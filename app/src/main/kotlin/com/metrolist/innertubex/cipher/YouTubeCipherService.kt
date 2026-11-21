package com.metrolist.innertubex.cipher

import com.metrolist.innertubex.InnerTubeLogger
import com.metrolist.innertubex.d
import com.metrolist.innertubex.models.response.PlayerResponse
import com.metrolist.innertubex.w
import io.ktor.client.HttpClient
import io.ktor.http.Url
import io.ktor.http.decodeURLQueryComponent
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.delay
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import java.io.IOException

class YouTubeCipherService(
    val httpClient: HttpClient,
    val remotePlayerConfigStore: RemotePlayerConfigStore,
    val logger: InnerTubeLogger? = null,
) {
    data class CachedSolver(
        val playerUrl: String,
        val engine: QuickJsEngine,
        val nSolver: suspend (String) -> String?,
        val sigSolver: suspend (String) -> String?,
    )

    data class CachedZemerSolver(
        val config: RemotePlayerConfigParser.HardcodedPlayerConfig,
        val configEpoch: Long,
        val solver: ZemerCipherSolver,
    )

    data class PlayerCodeResult(
        val code: String,
        val source: String,
    )

    class PlayerScriptHttpException(
        val statusCode: Int,
        val retryable: Boolean,
    ) : IllegalStateException("Player script request failed with HTTP $statusCode")

    data class RemoteSolveResult(
        val sigByChallenge: Map<String, String>,
        val nByChallenge: Map<String, String>,
    )

    internal data class SigTask(
        val index: Int,
        val params: LinkedHashMap<String, String>,
        val useSignatureCipherField: Boolean,
    )

    internal data class NTask(
        val index: Int,
        val url: String,
        val nValue: String,
    )

    val ejs: EjsChallengeSolver = EjsChallengeSolver(QuickJsEngine(), logger)
    val githubPreprocessedPlayer: GitHubPlayerConfigClient = GitHubPlayerConfigClient(
        httpClient = httpClient,
        ejs = ejs,
        repository = remotePlayerConfigStore.repository,
        validateSourceUrl = { RemotePlayerConfigStore.validatedSourceUrlOrNull(it) },
        logger = logger,
    )

    val cache = LinkedHashMap<String, CachedSolver>()
    val zemerCache = LinkedHashMap<String, CachedZemerSolver>()
    val playerCodeCache = LinkedHashMap<String, String>()
    val playerCodeDownloads = LinkedHashMap<String, CompletableDeferred<String>>()
    val cacheMutex = Mutex()
    val operationMutex = Mutex()

    suspend fun createSolver(playerUrl: String, playerCode: String): CachedSolver {
        val splitJoinIndex0 = PlayerScriptParser.extractSplitJoinByIndex(0, playerCode)
        val firstSplitJoin = splitJoinIndex0.first
        val functionMatches = PlayerScriptParser.functionPattern.findAll(playerCode)
            .mapNotNull { match ->
                val name = match.groupValues.getOrNull(1) ?: return@mapNotNull null
                PlayerScriptParser.FunctionMatch(name)
            }
            .toList()

        var nFunctionPair: Pair<String?, String?> = Pair(null, null)
        for (i in 1 until functionMatches.size) {
            val fnMatch = functionMatches[i]
            val fnBody = PlayerScriptParser.extractFunctionByName(playerCode, fnMatch.name)
            if (fnBody != null && fnBody != firstSplitJoin) {
                nFunctionPair = Pair(fnBody, fnMatch.name)
                break
            }
        }

        if (nFunctionPair.first == null) {
            if (functionMatches.isNotEmpty() && firstSplitJoin == null) {
                val splitJoinIndex1 = PlayerScriptParser.extractSplitJoinByIndex(1, playerCode)
                if (splitJoinIndex1.first != null) {
                    nFunctionPair = splitJoinIndex1
                } else {
                    val reverseRegex = Regex("(?s)function\\s+([a-zA-Z_\$][a-zA-Z0-9_\$]*)\\s*\\(\\s*a\\s*\\)\\s*\\{[^{}]*a\\s*[=.][^{}]*reverse[^{}]*\\}")
                    for (match in reverseRegex.findAll(playerCode)) {
                        val name = match.groupValues.getOrNull(1) ?: continue
                        val body = PlayerScriptParser.extractFunctionByName(playerCode, name)
                        if (body != null && (body.contains("reverse") || body.contains("splice") || body.contains("slice"))) {
                            nFunctionPair = Pair(body, name)
                            break
                        }
                    }
                }
            } else {
                val reverseRegex = Regex("(?s)function\\s+([a-zA-Z_\$][a-zA-Z0-9_\$]*)\\s*\\(\\s*a\\s*\\)\\s*\\{[^{}]*a\\s*[=.][^{}]*reverse[^{}]*\\}")
                for (match in reverseRegex.findAll(playerCode)) {
                    val name = match.groupValues.getOrNull(1) ?: continue
                    val body = PlayerScriptParser.extractFunctionByName(playerCode, name)
                    if (body != null && body != firstSplitJoin && (body.contains("reverse") || body.contains("splice") || body.contains("slice"))) {
                        nFunctionPair = Pair(body, name)
                        break
                    }
                }
            }
        }

        val helperObjects = LinkedHashMap<String, String>()
        val helperRegexes = listOf(
            Regex("(?s)var\\s+([a-zA-Z_\$][a-zA-Z0-9_\$]*)\\s*=\\s*\\{\\s*[^}]*reverse[^}]*\\}"),
            Regex("(?s)var\\s+([a-zA-Z_\$][a-zA-Z0-9_\$]*)\\s*=\\s*\\{\\s*[^}]*slice[^}]*\\}"),
            Regex("(?s)var\\s+([a-zA-Z_\$][a-zA-Z0-9_\$]*)\\s*=\\s*\\{\\s*[^}]*splice[^}]*\\}"),
        )
        for (regex in helperRegexes) {
            for (match in regex.findAll(playerCode)) {
                val start = match.range.first
                val end = PlayerScriptParser.findFunctionEnd(start, playerCode)
                if (end > start) {
                    val name = match.groupValues.getOrNull(1) ?: continue
                    helperObjects[name] = playerCode.substring(start, end)
                }
            }
        }

        val parseResult = PlayerScriptParser.ParseResult(
            sigFunctionCode = firstSplitJoin,
            sigInvoker = splitJoinIndex0.second,
            nFunctionCode = nFunctionPair.first,
            nInvoker = nFunctionPair.second,
            helperFunctions = helperObjects,
        )

        val scriptBuilder = StringBuilder()
        for ((_, helperCode) in parseResult.helperFunctions) {
            scriptBuilder.append(helperCode).append('\n')
        }
        val nCode = parseResult.nFunctionCode
        if (nCode != null) {
            scriptBuilder.append(nCode).append('\n')
            val nInvoker = parseResult.nInvoker
            if (!nInvoker.isNullOrBlank()) {
                scriptBuilder.append(
                    """
                    function _solveN(input) {
                        try { return $nInvoker(input); } catch(e) { return null; }
                    }
                    """.trimIndent()
                ).append('\n')
            }
        }
        val sigCode = parseResult.sigFunctionCode
        if (sigCode != null) {
            scriptBuilder.append(sigCode).append('\n')
            val sigInvoker = parseResult.sigInvoker
            if (!sigInvoker.isNullOrBlank()) {
                scriptBuilder.append(
                    """
                    function _solveSig(input) {
                        try { return $sigInvoker(input); } catch(e) { return null; }
                    }
                    """.trimIndent()
                ).append('\n')
            }
        }
        val solverScript = scriptBuilder.toString()

        val engine = QuickJsEngine()
        try {
            engine.initialize()
            val polyfillScript = """
                if (typeof globalThis.XMLHttpRequest === "undefined") {
                    globalThis.XMLHttpRequest = { prototype: {} };
                }
                if (typeof URL === "undefined") {
                    globalThis.location = {
                        hash: "",
                        host: "www.youtube.com",
                        hostname: "www.youtube.com",
                        href: "https://www.youtube.com/watch?v=yt-dlp-wins",
                        origin: "https://www.youtube.com",
                        password: "",
                        pathname: "/watch",
                        port: "",
                        protocol: "https:",
                        search: "?v=yt-dlp-wins",
                        username: "",
                    };
                } else {
                    globalThis.location = new URL("https://www.youtube.com/watch?v=yt-dlp-wins");
                }
                if (typeof globalThis.document === "undefined") {
                    globalThis.document = Object.create(null);
                }
                if (typeof globalThis.navigator === "undefined") {
                    globalThis.navigator = Object.create(null);
                }
                if (typeof globalThis.self === "undefined") {
                    globalThis.self = globalThis;
                }
                if (typeof globalThis.window === "undefined") {
                    globalThis.window = globalThis;
                }
                if (typeof globalThis.Intl === "undefined") {
                    const NumberFormat = function(locale, options) {
                        this.options = options || {};
                    };
                    NumberFormat.supportedLocalesOf = function(locales) {
                        return Array.isArray(locales) ? locales : [locales];
                    };
                    NumberFormat.prototype.format = function(value) {
                        let formatted = String(value);
                        const minimumDigits = this.options.minimumIntegerDigits || 0;
                        while (formatted.length < minimumDigits) formatted = "0" + formatted;
                        return formatted;
                    };
                    const DateTimeFormat = function() {};
                    DateTimeFormat.prototype.resolvedOptions = function() {
                        return { timeZone: "UTC" };
                    };
                    DateTimeFormat.prototype.format = function(value) {
                        return String(value);
                    };
                    globalThis.Intl = { NumberFormat, DateTimeFormat };
                }
            """.trimIndent()
            engine.execute(polyfillScript)
            if (solverScript.isNotBlank()) {
                engine.execute(solverScript)
            }

            val hasNFunction = parseResult.nFunctionCode != null
            val hasSigFunction = parseResult.sigFunctionCode != null

            val nSolver: suspend (String) -> String? = { input ->
                if (hasNFunction) {
                    try {
                        engine.callFunction("_solveN", input)
                    } catch (e: CancellationException) {
                        throw e
                    } catch (_: Exception) {
                        null
                    }
                } else {
                    null
                }
            }

            val sigSolver: suspend (String) -> String? = { input ->
                if (hasSigFunction) {
                    try {
                        engine.callFunction("_solveSig", input)
                    } catch (e: CancellationException) {
                        throw e
                    } catch (_: Exception) {
                        null
                    }
                } else {
                    null
                }
            }

            return CachedSolver(playerUrl, engine, nSolver, sigSolver)
        } catch (t: Throwable) {
            engine.dispose()
            throw t
        }
    }

    suspend fun getOrCreateSolver(playerUrl: String, playerCode: String): CachedSolver {
        val evictedSolvers = mutableListOf<CachedSolver>()
        val solver: CachedSolver
        cacheMutex.withLock {
            val existing = cache.remove(playerUrl)
            if (existing != null) {
                cache[playerUrl] = existing
                solver = existing
            } else {
                solver = createSolver(playerUrl, playerCode)
                cache[playerUrl] = solver
                while (cache.size > 4) {
                    val oldestKey = cache.keys.firstOrNull() ?: break
                    val removed = cache.remove(oldestKey)
                    if (removed != null) {
                        evictedSolvers.add(removed)
                    }
                }
            }
        }
        for (evicted in evictedSolvers) {
            evicted.engine.dispose()
        }
        return solver
    }

    suspend fun getOrCreateZemerSolver(
        playerUrl: String,
        playerCode: String,
        config: RemotePlayerConfigParser.HardcodedPlayerConfig,
        configEpoch: Long,
    ): ZemerCipherSolver {
        val evictedSolvers = mutableListOf<CachedZemerSolver>()
        var previousReplacedSolver: CachedZemerSolver? = null
        val resultSolver: ZemerCipherSolver

        cacheMutex.withLock {
            val cached = cacheMutexLet {
                val existing = zemerCache[playerUrl]
                if (existing != null && existing.config == config && existing.configEpoch == configEpoch) {
                    zemerCache.remove(playerUrl)
                    zemerCache[playerUrl] = existing
                    existing
                } else {
                    null
                }
            }

            if (cached != null) {
                resultSolver = cached.solver
            } else {
                val newSolver = ZemerCipherSolver.create(playerCode, config)
                previousReplacedSolver = zemerCache.remove(playerUrl)
                zemerCache[playerUrl] = CachedZemerSolver(config, configEpoch, newSolver)
                while (zemerCache.size > 4) {
                    val oldestKey = zemerCache.keys.firstOrNull() ?: break
                    val removed = zemerCache.remove(oldestKey)
                    if (removed != null) {
                        evictedSolvers.add(removed)
                    }
                }
                resultSolver = newSolver
            }
        }

        previousReplacedSolver?.solver?.engine?.dispose()
        for (evicted in evictedSolvers) {
            evicted.solver.engine.dispose()
        }
        return resultSolver
    }

    private inline fun <T> cacheMutexLet(block: () -> T): T = block()

    suspend fun downloadPlayerScript(playerUrl: String): String {
        val parsedUrl = validatedPlayerScriptUrl(playerUrl)
        var lastException: Throwable? = null
        val retryableStatusCodes = setOf(408, 425, 429, 500, 502, 503, 504)

        for (attempt in 0 until 3) {
            try {
                val response = getTextWithoutRedirects(
                    httpClient = httpClient,
                    url = parsedUrl,
                    maxBytes = 8388608,
                )
                val body = response.body
                if (body != null) {
                    return body
                }
                val statusCode = response.status.value
                val isRetryable = retryableStatusCodes.contains(statusCode)
                val httpEx = PlayerScriptHttpException(statusCode, isRetryable)
                lastException = httpEx
                if (!isRetryable || attempt == 2) {
                    throw httpEx
                }
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                lastException = e
                if (e is PlayerScriptHttpException && !e.retryable) {
                    throw e
                }
                if (attempt == 2) {
                    throw e
                }
            }
            delay(250L shl attempt)
        }
        throw (lastException ?: IllegalStateException("Player script request failed"))
    }

    suspend fun getOrDownloadPlayerCode(playerUrl: String): PlayerCodeResult {
        var preloadedCode: String? = null
        var inFlightDeferred: CompletableDeferred<String>? = null
        var isLeader = false

        cacheMutex.withLock {
            val cached = playerCodeCache.remove(playerUrl)
            if (cached != null) {
                playerCodeCache[playerUrl] = cached
                preloadedCode = cached
            } else {
                val inFlight = playerCodeDownloads[playerUrl]
                if (inFlight != null) {
                    inFlightDeferred = inFlight
                } else {
                    val deferred = CompletableDeferred<String>()
                    playerCodeDownloads[playerUrl] = deferred
                    inFlightDeferred = deferred
                    isLeader = true
                }
            }
        }

        if (preloadedCode != null) {
            return PlayerCodeResult(preloadedCode!!, "preloaded")
        }

        val deferred = inFlightDeferred
        if (deferred == null) {
            val downloaded = downloadPlayerScript(playerUrl)
            return PlayerCodeResult(downloaded, "downloaded")
        }

        if (!isLeader) {
            val code = deferred.await()
            return PlayerCodeResult(code, "in-flight")
        }

        try {
            val downloadedCode = downloadPlayerScript(playerUrl)
            cacheMutex.withLock {
                playerCodeCache[playerUrl] = downloadedCode
                while (playerCodeCache.size > 4) {
                    val oldestKey = playerCodeCache.keys.firstOrNull() ?: break
                    playerCodeCache.remove(oldestKey)
                }
                if (playerCodeDownloads[playerUrl] === deferred) {
                    playerCodeDownloads.remove(playerUrl)
                }
            }
            deferred.complete(downloadedCode)
            return PlayerCodeResult(downloadedCode, "downloaded")
        } catch (e: Exception) {
            cacheMutex.withLock {
                if (playerCodeDownloads[playerUrl] === deferred) {
                    playerCodeDownloads.remove(playerUrl)
                }
            }
            deferred.completeExceptionally(e)
            throw e
        }
    }

    suspend fun preloadCanonicalPlayerCode(playerUrl: String) {
        operationMutex.withLock {
            val startMs = System.currentTimeMillis()
            try {
                val hardcodedConfig = remotePlayerConfigStore.getConfig(playerUrl)
                if (hardcodedConfig != null) {
                    getOrDownloadPlayerCode(playerUrl)
                } else {
                    ejs.solve(
                        playerUrl = playerUrl,
                        loadFullPlayerJs = { getOrDownloadPlayerCode(playerUrl).code },
                        requests = listOf("sig" to listOf("prewarm")),
                        preferPreprocessed = true,
                    )
                }
                val elapsed = System.currentTimeMillis() - startMs
                logger?.d("YouTubeCipherService", "player JS preload done elapsed=${elapsed}ms player=${logId(playerUrl)}")
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                val elapsed = System.currentTimeMillis() - startMs
                val typeName = e::class.simpleName ?: "Exception"
                logger?.d("YouTubeCipherService", "player JS preload failed elapsed=${elapsed}ms player=${logId(playerUrl)} type=$typeName")
            }
        }
    }

    suspend fun prewarmEjs() {
        operationMutex.withLock {
            ejs.withActivity { }
        }
    }

    suspend fun refreshAfterStreamRejection(): Boolean {
        return remotePlayerConfigStore.refreshAfterStreamRejection()
    }

    suspend fun solveWithGitHubConfig(
        playerUrl: String,
        sigChallenges: List<String>,
        nChallenges: List<String>,
    ): RemoteSolveResult {
        val result = githubPreprocessedPlayer.solve(playerUrl, sigChallenges, nChallenges)
        return RemoteSolveResult(result.sigByChallenge, result.nByChallenge)
    }

    suspend fun solveWithZemerConfig(
        playerUrl: String,
        sigChallenges: List<String>,
        nChallenges: List<String>,
    ): RemoteSolveResult {
        if (sigChallenges.isEmpty() && nChallenges.isEmpty()) {
            return RemoteSolveResult(emptyMap(), emptyMap())
        }

        var config = remotePlayerConfigStore.getConfig(playerUrl)
        if (config == null) {
            val hash = RemotePlayerConfigParser.extractPlayerHash(playerUrl)
            remotePlayerConfigStore.forceRefresh(hash)
            config = remotePlayerConfigStore.getConfig(playerUrl)
        }

        if (config == null) {
            return RemoteSolveResult(emptyMap(), emptyMap())
        }

        val playerHash = RemotePlayerConfigParser.extractPlayerHash(playerUrl)
            ?: return RemoteSolveResult(emptyMap(), emptyMap())
        val iasPlayerUrl = "https://www.youtube.com/s/player/$playerHash/player_ias.vflset/en_GB/base.js"

        return try {
            val playerCodeResult = getOrDownloadPlayerCode(iasPlayerUrl)
            val zemerSolver = getOrCreateZemerSolver(
                playerUrl = iasPlayerUrl,
                playerCode = playerCodeResult.code,
                config = config,
                configEpoch = remotePlayerConfigStore.configEpoch,
            )

            val sigResults = LinkedHashMap<String, String>()
            for (sig in sigChallenges.distinct()) {
                val solved = zemerSolver.solveSignature(sig)
                if (solved != null) {
                    sigResults[sig] = solved
                }
            }

            val nResults = LinkedHashMap<String, String>()
            for (n in nChallenges.distinct()) {
                val solved = zemerSolver.solveN(n)
                if (solved != null) {
                    nResults[n] = solved
                }
            }

            RemoteSolveResult(sigResults, nResults)
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            val typeName = e::class.simpleName ?: "Exception"
            logger?.d("YouTubeCipherService", "Faraday zemer config failed player=${logId(playerUrl)} type=$typeName")
            RemoteSolveResult(emptyMap(), emptyMap())
        }
    }

    suspend fun processFormatWithSolver(
        cachedSolver: CachedSolver,
        format: PlayerResponse.StreamingData.Format,
    ): PlayerResponse.StreamingData.Format {
        var currentFormat = format
        val sigCipher = currentFormat.signatureCipher
        if (!sigCipher.isNullOrBlank()) {
            val params = parseCipherParams(sigCipher)
            val url = params["url"]
            val s = params["s"]
            if (url != null && s != null) {
                val solvedSig = cachedSolver.sigSolver(s)
                if (solvedSig != null) {
                    val sp = params["sp"] ?: "signature"
                    val updatedUrl = appendQueryParameter(url, sp, solvedSig)
                    if (updatedUrl != null) {
                        currentFormat = currentFormat.copy(url = updatedUrl)
                    }
                }
            }
        } else {
            val cipher = currentFormat.cipher
            if (!cipher.isNullOrBlank()) {
                val params = parseCipherParams(cipher)
                val url = params["url"]
                val s = params["s"]
                if (url != null && s != null) {
                    val solvedSig = cachedSolver.sigSolver(s)
                    if (solvedSig != null) {
                        val sp = params["sp"] ?: "signature"
                        val updatedUrl = appendQueryParameter(url, sp, solvedSig)
                        if (updatedUrl != null) {
                            currentFormat = currentFormat.copy(url = updatedUrl)
                        }
                    }
                }
            }
        }

        val url = currentFormat.url
        if (!url.isNullOrBlank() && extractNParameter(url) != null) {
            val updatedUrl = processNParameterWithSolver(cachedSolver, url)
            if (updatedUrl != null) {
                currentFormat = currentFormat.copy(url = updatedUrl)
            }
        }

        return currentFormat
    }

    suspend fun processNParameterWithSolver(
        cachedSolver: CachedSolver,
        url: String,
    ): String? {
        val matchResult = findNParameter(url) ?: return null
        val nValue = matchResult.groupValues.getOrNull(1) ?: return null
        val solvedN = cachedSolver.nSolver(nValue) ?: return null
        return replaceQueryParameter(url, matchResult, solvedN)
    }

    suspend fun processFormats(
        playerUrl: String,
        formats: List<PlayerResponse.StreamingData.Format>,
    ): List<PlayerResponse.StreamingData.Format> {
        val canonicalUrl = canonicalPlayerUrl(playerUrl)
        val directNValues = formats.map { format ->
            val u = format.url
            if (u != null) extractNParameter(u) else null
        }

        var cipherCount = 0
        for (f in formats) {
            val sc = f.signatureCipher
            val c = f.cipher
            if ((sc != null && sc.isNotBlank()) || (c != null && c.isNotBlank())) {
                cipherCount++
            }
        }

        val nCount = directNValues.count { it != null }

        if (cipherCount == 0 && nCount == 0) {
            return formats
        }

        return withContext(Dispatchers.Default) {
            processCanonicalFormats(formats, cipherCount, nCount, canonicalUrl, directNValues)
        }
    }

    private suspend fun processCanonicalFormats(
        formats: List<PlayerResponse.StreamingData.Format>,
        cipherFormats: Int,
        nFormats: Int,
        playerUrl: String,
        directNValues: List<String?>,
    ): List<PlayerResponse.StreamingData.Format> {
        return operationMutex.withLock {
            val startMs = System.currentTimeMillis()
            var cachedSolver: CachedSolver? = null
            cacheMutex.withLock {
                val existing = cache.remove(playerUrl)
                if (existing != null) {
                    cache[playerUrl] = existing
                    cachedSolver = existing
                }
            }

            logger?.d(
                "YouTubeCipherService",
                "processFormats start formats=${formats.size} cipher=$cipherFormats n=$nFormats cached=${cachedSolver != null} player=${logId(playerUrl)}"
            )

            val currentFormats = formats.toMutableList()
            var playerCodeResult: PlayerCodeResult? = null
            var playerCodeError: Throwable? = null

            suspend fun getPlayerCode(): String? {
                val cached = playerCodeResult
                if (cached != null) return cached.code
                if (playerCodeError != null) return null
                return try {
                    val fetchStart = System.currentTimeMillis()
                    val res = getOrDownloadPlayerCode(playerUrl)
                    playerCodeResult = res
                    val elapsed = System.currentTimeMillis() - fetchStart
                    logger?.d(
                        "YouTubeCipherService",
                        "player JS ready source=${res.source} size=${res.code.length} elapsed=${elapsed}ms player=${logId(playerUrl)}"
                    )
                    res.code
                } catch (e: CancellationException) {
                    throw e
                } catch (e: Exception) {
                    playerCodeError = e
                    val typeName = e::class.simpleName ?: "Exception"
                    logger?.w(
                        "YouTubeCipherService",
                        "player JS unavailable, challenges unsolvable player=${logId(playerUrl)} type=$typeName"
                    )
                    null
                }
            }

            val sigTasks = mutableListOf<SigTask>()
            for ((index, format) in formats.withIndex()) {
                val sigCipher = format.signatureCipher
                if (!sigCipher.isNullOrBlank()) {
                    val params = parseCipherParams(sigCipher)
                    val u = params["url"]
                    if (u != null && isApprovedMediaUrl(u)) {
                        val sp = params["sp"]
                        if (sp == null || QUERY_PARAMETER_NAME_REGEX.matches(sp)) {
                            sigTasks.add(SigTask(index, params, useSignatureCipherField = true))
                        }
                    }
                } else {
                    val cipher = format.cipher
                    if (!cipher.isNullOrBlank()) {
                        val params = parseCipherParams(cipher)
                        val u = params["url"]
                        if (params.containsKey("s") && u != null && isApprovedMediaUrl(u)) {
                            val sp = params["sp"]
                            if (sp == null || QUERY_PARAMETER_NAME_REGEX.matches(sp)) {
                                sigTasks.add(SigTask(index, params, useSignatureCipherField = false))
                            }
                        }
                    }
                }
            }

            val sigChallenges = sigTasks.mapNotNull { it.params["s"] }.distinct()
            val sigUrlNValues = sigTasks.mapNotNull {
                val u = it.params["url"]
                if (u != null) extractNParameter(u) else null
            }.distinct()

            val allNChallenges = (directNValues.filterNotNull().distinct() + sigUrlNValues).distinct()
            val initialNChallengesSet = allNChallenges.toSet()

            var remoteSolveResult: RemoteSolveResult = if (sigChallenges.isEmpty() && allNChallenges.isEmpty()) {
                RemoteSolveResult(emptyMap(), emptyMap())
            } else {
                val zemerStart = System.currentTimeMillis()
                val zemerRes = solveWithZemerConfig(playerUrl, sigChallenges, allNChallenges)
                if (zemerRes.sigByChallenge.isNotEmpty() || zemerRes.nByChallenge.isNotEmpty()) {
                    val elapsed = System.currentTimeMillis() - zemerStart
                    logger?.d(
                        "YouTubeCipherService",
                        "Faraday zemer config solved sig=${zemerRes.sigByChallenge.size}/${sigChallenges.size} n=${zemerRes.nByChallenge.size}/${allNChallenges.size} elapsed=${elapsed}ms player=${logId(playerUrl)}"
                    )
                }
                zemerRes
            }

            val missingSigForGithub = sigChallenges.filter { it !in remoteSolveResult.sigByChallenge }
            val missingNForGithub = allNChallenges.filter { it !in remoteSolveResult.nByChallenge }

            if (missingSigForGithub.isNotEmpty() || missingNForGithub.isNotEmpty()) {
                val githubRes = solveWithGitHubConfig(playerUrl, missingSigForGithub, missingNForGithub)
                remoteSolveResult = RemoteSolveResult(
                    sigByChallenge = remoteSolveResult.sigByChallenge + githubRes.sigByChallenge,
                    nByChallenge = remoteSolveResult.nByChallenge + githubRes.nByChallenge,
                )
            }

            val sigByChallenge = remoteSolveResult.sigByChallenge.toMutableMap()
            val nByChallenge = remoteSolveResult.nByChallenge.toMutableMap()

            if (sigTasks.isNotEmpty()) {
                val missingSigForEjs = sigChallenges.filter { it !in sigByChallenge }
                if (missingSigForEjs.isNotEmpty()) {
                    val ejsStart = System.currentTimeMillis()
                    val missingNForEjs = allNChallenges.filter { it !in nByChallenge }
                    val ejsChallenges = mutableListOf<Pair<String, List<String>>>()
                    ejsChallenges.add("sig" to missingSigForEjs)
                    if (missingNForEjs.isNotEmpty()) {
                        ejsChallenges.add("n" to missingNForEjs)
                    }

                    val ejsResult = ejs.solve(
                        playerUrl = playerUrl,
                        loadFullPlayerJs = { getPlayerCode() },
                        requests = ejsChallenges,
                        preferPreprocessed = false,
                    )
                    sigByChallenge.putAll(ejsResult.sigByChallenge)
                    nByChallenge.putAll(ejsResult.nByChallenge)
                    val elapsed = System.currentTimeMillis() - ejsStart
                    logger?.d(
                        "YouTubeCipherService",
                        "signature EJS done tasks=${sigTasks.size} unique=${sigChallenges.size} missing=${missingSigForEjs.size} solved=${ejsResult.sigByChallenge.size} nRemote=${nByChallenge.size} elapsed=${elapsed}ms player=${logId(playerUrl)}"
                    )
                } else {
                    logger?.d(
                        "YouTubeCipherService",
                        "signature remote player config reused tasks=${sigTasks.size} unique=${sigChallenges.size} solved=${sigByChallenge.size} player=${logId(playerUrl)}"
                    )
                }

                for (sigTask in sigTasks) {
                    val s = sigTask.params["s"] ?: continue
                    val solved = sigByChallenge[s] ?: continue
                    val u = sigTask.params["url"] ?: continue
                    val sp = sigTask.params["sp"] ?: "signature"
                    val newUrl = appendQueryParameter(u, sp, solved) ?: continue
                    val targetFormat = currentFormats[sigTask.index]
                    currentFormats[sigTask.index] = targetFormat.copy(url = newUrl)
                }

                val unsolvedSigTasks = sigTasks.filter { task ->
                    val s = task.params["s"]
                    s == null || sigByChallenge[s] == null
                }

                if (unsolvedSigTasks.isNotEmpty()) {
                    val fallbackStart = System.currentTimeMillis()
                    val code = getPlayerCode()
                    var localSolver: CachedSolver? = null
                    if (code != null) {
                        localSolver = getOrCreateSolver(playerUrl, code)
                    }
                    if (localSolver != null) {
                        for (sigTask in unsolvedSigTasks) {
                            val f = currentFormats[sigTask.index]
                            currentFormats[sigTask.index] = processFormatWithSolver(localSolver, f)
                        }
                    }
                    val elapsed = System.currentTimeMillis() - fallbackStart
                    logger?.d(
                        "YouTubeCipherService",
                        "signature fallback done solved=${unsolvedSigTasks.size} elapsed=${elapsed}ms player=${logId(playerUrl)}"
                    )
                }
            }

            val nTasks = mutableListOf<NTask>()
            for ((index, format) in currentFormats.withIndex()) {
                val u = format.url ?: continue
                val n = extractNParameter(u) ?: continue
                nTasks.add(NTask(index, u, n))
            }

            if (nTasks.isNotEmpty()) {
                val distinctNValues = nTasks.map { it.nValue }.distinct()
                val missingNForRemote = distinctNValues.filter { it !in nByChallenge && it !in initialNChallengesSet }
                if (missingNForRemote.isNotEmpty()) {
                    val zemerRes = solveWithZemerConfig(playerUrl, emptyList(), missingNForRemote)
                    nByChallenge.putAll(zemerRes.nByChallenge)

                    val remainingMissingN = missingNForRemote.filter { it !in nByChallenge }
                    if (remainingMissingN.isNotEmpty()) {
                        val githubRes = solveWithGitHubConfig(playerUrl, emptyList(), remainingMissingN)
                        nByChallenge.putAll(githubRes.nByChallenge)
                    }
                }

                val missingNForEjs = distinctNValues.filter { it !in nByChallenge }
                if (missingNForEjs.isNotEmpty()) {
                    val ejsStart = System.currentTimeMillis()
                    val ejsChallenges = listOf("n" to missingNForEjs)
                    val ejsResult = ejs.solve(
                        playerUrl = playerUrl,
                        loadFullPlayerJs = { getPlayerCode() },
                        requests = ejsChallenges,
                        preferPreprocessed = false,
                    )
                    nByChallenge.putAll(ejsResult.nByChallenge)
                    val elapsed = System.currentTimeMillis() - ejsStart
                    logger?.d(
                        "YouTubeCipherService",
                        "n fallback done failed=${missingNForEjs.size - ejsResult.nByChallenge.size} elapsed=${elapsed}ms player=${logId(playerUrl)}"
                    )
                } else {
                    logger?.d(
                        "YouTubeCipherService",
                        "n prior cipher pass reused tasks=${nTasks.size} unique=${distinctNValues.size} solved=${distinctNValues.size} player=${logId(playerUrl)}"
                    )
                }

                for (nTask in nTasks) {
                    val solved = nByChallenge[nTask.nValue] ?: continue
                    val matchResult = findNParameter(nTask.url) ?: continue
                    val replaced = replaceQueryParameter(nTask.url, matchResult, solved) ?: continue
                    val targetFormat = currentFormats[nTask.index]
                    currentFormats[nTask.index] = targetFormat.copy(url = replaced)
                }

                val unsolvedNTasks = nTasks.filter { task ->
                    nByChallenge[task.nValue] == null
                }

                if (unsolvedNTasks.isNotEmpty()) {
                    val code = getPlayerCode()
                    var localSolver: CachedSolver? = null
                    if (code != null) {
                        localSolver = getOrCreateSolver(playerUrl, code)
                    }
                    if (localSolver != null) {
                        for (nTask in unsolvedNTasks) {
                            val f = currentFormats[nTask.index]
                            currentFormats[nTask.index] = processFormatWithSolver(localSolver, f)
                        }
                    }
                }

                for (nTask in nTasks) {
                    val currentFormat = currentFormats[nTask.index]
                    val u = currentFormat.url
                    val currentN = if (u != null) extractNParameter(u) else null
                    if (currentN == null || currentN == nTask.nValue) {
                        currentFormats[nTask.index] = currentFormat.copy(url = null)
                        logger?.w(
                            "YouTubeCipherService",
                            "rejecting format with unresolved n itag=${currentFormat.itag} player=${logId(playerUrl)}"
                        )
                    }
                }
            }

            for ((i, origFormat) in formats.withIndex()) {
                val processed = currentFormats[i]
                if (processed.width == null) {
                    val origHadCipher = (!origFormat.signatureCipher.isNullOrBlank()) || (!origFormat.cipher.isNullOrBlank())
                    if (origHadCipher && processed.url.isNullOrBlank()) {
                        logger?.w(
                            "YouTubeCipherService",
                            "audio format cipher deobfuscation produced no url itag=${origFormat.itag} player=${logId(playerUrl)}"
                        )
                    } else if (!origHadCipher && origFormat.url.isNullOrBlank()) {
                        logger?.w(
                            "YouTubeCipherService",
                            "audio format has no url and no cipher fields (DRM/SABR-only?) itag=${origFormat.itag} mime=${origFormat.mimeType}"
                        )
                    }
                }
            }

            val usableAudio = currentFormats.count { it.width == null && !it.url.isNullOrBlank() }
            val totalElapsed = System.currentTimeMillis() - startMs
            logger?.d(
                "YouTubeCipherService",
                "processFormats done formats=${formats.size} usableAudio=$usableAudio elapsed=${totalElapsed}ms player=${logId(playerUrl)}"
            )

            currentFormats
        }
    }

    suspend fun dispose() {
        operationMutex.withLock {
            val solversToDispose = mutableListOf<CachedSolver>()
            val zemerSolversToDispose = mutableListOf<CachedZemerSolver>()

            cacheMutex.withLock {
                solversToDispose.addAll(cache.values)
                zemerSolversToDispose.addAll(zemerCache.values)
                cache.clear()
                zemerCache.clear()
                playerCodeCache.clear()
                playerCodeDownloads.clear()
            }

            for (solver in solversToDispose) {
                solver.engine.dispose()
            }
            for (zemerSolver in zemerSolversToDispose) {
                zemerSolver.solver.engine.dispose()
            }
            withContext(NonCancellable) {
                ejs.dispose()
            }
        }
    }

    companion object {
        val N_PARAMETER_REGEX = Regex("[&?]n=([^&#]+)")
        val QUERY_PARAMETER_NAME_REGEX = Regex("[A-Za-z][A-Za-z0-9._~-]*")

        fun isApprovedMediaUrl(urlStr: String): Boolean {
            if (urlStr.isEmpty() || urlStr.length >= 16385) {
                return false
            }
            val url = runCatching { Url(urlStr) }.getOrNull() ?: return false
            val host = url.host
            val isApprovedHost = host == "googlevideo.com" || host.endsWith(".googlevideo.com") || host == "youtube.com" || host.endsWith(".youtube.com")
            return url.protocol.name == "https" &&
                url.port == 443 &&
                isApprovedHost &&
                url.encodedPath == "/videoplayback" &&
                url.user == null &&
                url.password == null
        }

        fun findNParameter(url: String): MatchResult? {
            if (isApprovedMediaUrl(url)) {
                val hashIndex = url.indexOf('#')
                val boundary = if (hashIndex >= 0) hashIndex else url.length
                val match = N_PARAMETER_REGEX.find(url)
                if (match != null && match.range.first < boundary) {
                    return match
                }
            }
            return null
        }

        fun extractNParameter(url: String): String? {
            val match = findNParameter(url) ?: return null
            return match.groupValues.getOrNull(1)
        }

        fun logId(playerUrl: String): String {
            return RemotePlayerConfigParser.extractPlayerHash(playerUrl) ?: "unknown"
        }

        fun encodeQueryComponent(str: String): String {
            val sb = StringBuilder(str.length)
            for (b in str.toByteArray(Charsets.UTF_8)) {
                val i = b.toInt() and 0xFF
                if ((i in 48..57) || (i in 65..90) || (i in 97..122) || i == 45 || i == 46 || i == 95 || i == 126) {
                    sb.append(i.toChar())
                } else {
                    sb.append('%')
                    sb.append("0123456789ABCDEF"[i ushr 4])
                    sb.append("0123456789ABCDEF"[i and 15])
                }
            }
            return sb.toString()
        }

        fun appendQueryParameter(url: String, key: String, value: String): String? {
            if (!isApprovedMediaUrl(url) || !QUERY_PARAMETER_NAME_REGEX.matches(key) || value.isBlank() || value.length > 262144) {
                return null
            }
            val hashIndex = url.indexOf('#')
            val boundary = if (hashIndex >= 0) hashIndex else url.length
            val queryIndex = url.indexOf('?')
            val separator = if (queryIndex < 0 || queryIndex >= boundary) {
                "?"
            } else {
                if (boundary > 0 && "?&".contains(url[boundary - 1])) "" else "&"
            }
            val sb = StringBuilder(url.length + key.length + value.length + 2)
            sb.append(url, 0, boundary)
            sb.append(separator)
            sb.append(key)
            sb.append('=')
            sb.append(encodeQueryComponent(value))
            sb.append(url, boundary, url.length)
            return sb.toString()
        }

        fun replaceQueryParameter(url: String, matchResult: MatchResult, value: String): String? {
            val hashIndex = url.indexOf('#')
            val boundary = if (hashIndex >= 0) hashIndex else url.length
            if (isApprovedMediaUrl(url)) {
                if (matchResult.range.first < boundary && value.isNotBlank() && value.length <= 262144) {
                    val group1 = matchResult.groupValues.getOrNull(1) ?: return null
                    val startIndex = (matchResult.range.last + 1) - group1.length
                    val endIndex = matchResult.range.last + 1
                    return url.replaceRange(startIndex, endIndex, encodeQueryComponent(value))
                }
            }
            return null
        }

        fun parseCipherParams(cipherString: String): LinkedHashMap<String, String> {
            val map = LinkedHashMap<String, String>()
            val pairs = cipherString.split('&')
            for (pair in pairs) {
                val parts = pair.split('=', limit = 2)
                if (parts.size == 2) {
                    map[parts[0]] = parts[1].decodeURLQueryComponent(plusIsSpace = true)
                }
            }
            return map
        }

        fun validatedPlayerScriptUrl(str: String): Url {
            val url = Url(str)
            val isApprovedHost = url.host == "youtube.com" || url.host.endsWith(".youtube.com") || url.host == "youtube-nocookie.com" || url.host.endsWith(".youtube-nocookie.com")
            if (url.protocol.name == "https" && isApprovedHost && url.encodedPath.startsWith("/s/player/") && url.encodedPath.endsWith(".js")) {
                return url
            }
            error("Player script URL must use an approved YouTube HTTPS endpoint")
        }
    }
}
