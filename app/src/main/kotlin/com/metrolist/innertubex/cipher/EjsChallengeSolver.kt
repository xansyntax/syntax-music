package com.metrolist.innertubex.cipher

import com.metrolist.innertubex.InnerTubeLogger
import com.metrolist.innertubex.d
import com.metrolist.innertubex.w
import io.ktor.http.Url
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import java.security.MessageDigest
import kotlin.coroutines.cancellation.CancellationException

class EjsChallengeSolver(
    val engine: QuickJsEngine,
    val logger: InnerTubeLogger? = null,
) {
    data class ChallengeKey(
        val playerUrl: String,
        val kind: String,
        val challenge: String,
    )

    data class SolveResult(
        val sigByChallenge: Map<String, String>,
        val nByChallenge: Map<String, String>,
        val preprocessedPlayer: String?,
    )

    var bootstrapped: Boolean = false
        private set
    var bundleHash: String? = null
        private set

    val operationMutex = Mutex()
    private val idleScope = CoroutineScope(Dispatchers.Default)
    var idleJob: Job? = null

    val solvedChallenges = LinkedHashMap<ChallengeKey, String>()
    val preprocessedByPlayerUrl = LinkedHashMap<String, String>()
    val compiledPlayers = LinkedHashSet<String>()

    var readPreprocessedPlayer: suspend (String) -> String? = { null }
    var writePreprocessedPlayer: suspend (String, String?) -> Unit = { _, _ -> }

    suspend fun ensureBootstrapped() {
        if (bootstrapped) return
        val startTime = System.currentTimeMillis()
        engine.initialize()

        engine.execute(
            """
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
        )

        val solverLib = readYtEjsSolverScript("yt.solver.lib.min.js")
        val solverCore = readYtEjsSolverScript("yt.solver.core.min.js")
        bundleHash = sha1(solverLib + solverCore)

        engine.execute(solverLib)
        engine.execute("Object.assign(globalThis, lib);")
        engine.execute(solverCore)
        engine.execute(
            """
            globalThis.__itxPlayers = new Map();
            globalThis.__itxCompile = function(key, code) {
              var fns = {"n":null,"sig":null};
              Function("_result", code)(fns);
              __itxPlayers.delete(key);
              __itxPlayers.set(key, fns);
              while (__itxPlayers.size > 2) __itxPlayers.delete(__itxPlayers.keys().next().value);
              return fns;
            };
            globalThis.__itxRun = function(fns, requests) {
              return {"type":"result","responses":requests.map(function(req) {
                if (req.type !== "n" && req.type !== "sig")
                  return {"type":"error","error":"Unknown request type: " + req.type};
                var fn = fns[req.type];
                if (!fn) return {"type":"error","error":"Failed to extract " + req.type + " function"};
                try {
                  return {"type":"result","data":Object.fromEntries(req.challenges.map(function(c) { return [c, fn(c)]; }))};
                } catch (e) {
                  return {"type":"error","error":String(e)};
                }
              })};
            };
            """.trimIndent()
        )

        bootstrapped = true
        logger?.d("EjsChallengeSolver", "EJS bootstrap done elapsed=${System.currentTimeMillis() - startTime}ms")
    }

    suspend fun releaseRuntime() {
        bootstrapped = false
        compiledPlayers.clear()
        preprocessedByPlayerUrl.clear()
        engine.dispose()
    }

    suspend fun dispose() {
        operationMutex.withLock {
            idleJob?.cancel()
            idleJob = null
            solvedChallenges.clear()
            releaseRuntime()
        }
    }

    suspend fun <T> withActivity(block: suspend () -> T): T = operationMutex.withLock {
        idleJob?.cancel()
        idleJob = null
        try {
            block()
        } finally {
            idleJob = idleScope.launch {
                delay(20_000L)
                operationMutex.withLock {
                    ensureActive()
                    releaseRuntime()
                    idleJob = null
                }
            }
        }
    }

    fun putPreprocessedPlayerLocked(playerUrl: String, preprocessedPlayer: String) {
        preprocessedByPlayerUrl.remove(playerUrl)
        preprocessedByPlayerUrl[playerUrl] = preprocessedPlayer
        while (preprocessedByPlayerUrl.size > 1) {
            val key = preprocessedByPlayerUrl.keys.firstOrNull() ?: return
            preprocessedByPlayerUrl.remove(key)
        }
    }

    suspend fun safeWritePreprocessedPlayer(key: String, value: String?) {
        try {
            writePreprocessedPlayer(key, value)
        } catch (e: CancellationException) {
            throw e
        } catch (_: Exception) {
        }
    }

    suspend fun loadPreprocessedPlayer(playerUrl: String, cacheKey: String?): String? {
        try {
            val cached = preprocessedByPlayerUrl.remove(playerUrl)
            if (cached != null) {
                preprocessedByPlayerUrl[playerUrl] = cached
                return cached
            }
            if (cacheKey != null) {
                val diskValue = readPreprocessedPlayer(cacheKey)
                if (diskValue != null) {
                    if (diskValue.isNotBlank() && diskValue.length <= 8388608) {
                        putPreprocessedPlayerLocked(playerUrl, diskValue)
                        return diskValue
                    }
                    safeWritePreprocessedPlayer(cacheKey, null)
                }
            }
            return null
        } catch (e: CancellationException) {
            throw e
        } catch (_: Exception) {
            return null
        }
    }

    suspend fun solve(
        playerUrl: String,
        loadFullPlayerJs: suspend () -> String?,
        requests: List<Pair<String, List<String>>>,
        preferPreprocessed: Boolean,
    ): SolveResult {
        if (requests.isEmpty() || requests.all { it.second.isEmpty() }) {
            return SolveResult(emptyMap(), emptyMap(), null)
        }
        val totalCount = requests.sumOf { it.second.size }
        if (totalCount > 256) {
            return SolveResult(emptyMap(), emptyMap(), null)
        }
        val totalLength = requests.sumOf { req -> req.second.sumOf { it.length.toLong() } }
        if (totalLength > 8388608L) {
            return SolveResult(emptyMap(), emptyMap(), null)
        }
        for (req in requests) {
            for (c in req.second) {
                if (c.length > 65536) {
                    return SolveResult(emptyMap(), emptyMap(), null)
                }
            }
        }

        return withActivity {
            val cachedSig = LinkedHashMap<String, String>()
            val cachedN = LinkedHashMap<String, String>()
            for ((kind, challenges) in requests) {
                for (challenge in challenges) {
                    val key = ChallengeKey(playerUrl, kind, challenge)
                    val solved = solvedChallenges.remove(key)
                    if (solved != null) {
                        solvedChallenges[key] = solved
                        if (kind == "sig") {
                            cachedSig[challenge] = solved
                        } else if (kind == "n") {
                            cachedN[challenge] = solved
                        }
                    }
                }
            }
            val cachedResult = SolveResult(cachedSig, cachedN, null)
            if (preferPreprocessed && solvesAll(cachedResult, requests)) {
                return@withActivity cachedResult
            }

            val solveResult = solveUncached(playerUrl, loadFullPlayerJs, requests, preferPreprocessed)
            for ((kind, map) in listOf("sig" to solveResult.sigByChallenge, "n" to solveResult.nByChallenge)) {
                for ((challenge, solved) in map) {
                    if (solved.length + challenge.length + playerUrl.length <= 4096) {
                        val key = ChallengeKey(playerUrl, kind, challenge)
                        solvedChallenges.remove(key)
                        solvedChallenges[key] = solved
                        while (solvedChallenges.size > 256) {
                            val firstKey = solvedChallenges.keys.first()
                            solvedChallenges.remove(firstKey)
                        }
                    }
                }
            }
            solveResult
        }
    }

    suspend fun solveOnce(
        playerUrl: String,
        code: String?,
        requests: List<Pair<String, List<String>>>,
        isPreprocessed: Boolean,
    ): SolveResult {
        val emptyResult = SolveResult(emptyMap(), emptyMap(), null)
        val reqElements = ArrayList<JsonObject>()
        for ((kind, challenges) in requests) {
            if (challenges.isNotEmpty()) {
                val map = LinkedHashMap<String, JsonElement>()
                map["type"] = JsonPrimitive(kind)
                map["challenges"] = JsonArray(challenges.map { JsonPrimitive(it) })
                reqElements.add(JsonObject(map))
            }
        }
        val encodedRequests = payloadJson.encodeToString(JsonArray.serializer(), JsonArray(reqElements))
        val quotedPlayerUrl = playerUrl.jsStringLiteral()
        val quotedCode = code?.jsStringLiteral() ?: ""
        if (encodedRequests.length + quotedCode.length > 10485760) {
            return emptyResult
        }

        val snippet = if (code == null) {
            """
            var fns = __itxPlayers.get($quotedPlayerUrl);
            var r = fns ? __itxRun(fns, $encodedRequests) : null;
            """.trimIndent()
        } else if (isPreprocessed) {
            """
            var r = __itxRun(__itxCompile($quotedPlayerUrl, $quotedCode), $encodedRequests);
            """.trimIndent()
        } else {
            """
            __itxPlayers.clear();
            var r = jsc({"type":"player","player":$quotedCode,"output_preprocessed":true,"requests":$encodedRequests});
            """.trimIndent()
        }

        val wrapper = """
            (function() {
              $snippet
              if (!r) return JSON.stringify({"type":"error","error":"jsc returned null"});
              if (r.type === "error")
                return JSON.stringify({"type":"error","error":String(r.error != null ? r.error : "")});
              if (r.type !== "result")
                return JSON.stringify({"type":"error","error":"unexpected jsc type: "+String(r.type)});
              var out = {"type":"result","responses":[]};
              if (typeof r.preprocessed_player === "string" && r.preprocessed_player.length > 0) {
                if (r.preprocessed_player.length > 8388608)
                  return JSON.stringify({"type":"error","error":"preprocessed player too large"});
                out.preprocessed_player = r.preprocessed_player;
              }
              var resps = r.responses;
              if (!resps) return JSON.stringify(out);
              for (var i = 0; i < resps.length; i++) {
                var resp = resps[i];
                if (!resp) {
                  out.responses.push({"type":"error","error":"null response"});
                  continue;
                }
                if (resp.type === "error") {
                  out.responses.push({
                    "type":"error",
                    "error":String(resp.error != null ? resp.error : "")
                  });
                } else if (resp.type === "result") {
                  var d = resp.data;
                  var plain = {};
                  if (d && typeof d === "object") {
                    var keys = Object.keys(d);
                    for (var j = 0; j < keys.length; j++) {
                      var k = keys[j];
                      var v = d[k];
                      var text = v == null ? "" : String(v);
                      if (text.length > 262144) {
                        plain = null;
                        break;
                      }
                      plain[k] = text;
                    }
                  }
                  if (plain == null)
                    out.responses.push({"type":"error","error":"solver output too large"});
                  else
                    out.responses.push({"type":"result","data":plain});
                } else {
                  out.responses.push({"type":"error","error":"unknown response type"});
                }
              }
              return JSON.stringify(out);
            })()
        """.trimIndent()

        val start = System.currentTimeMillis()
        if (code != null) {
            if (isPreprocessed) {
                compiledPlayers.remove(playerUrl)
                compiledPlayers.add(playerUrl)
                while (compiledPlayers.size > 2) {
                    compiledPlayers.remove(compiledPlayers.first())
                }
            } else {
                compiledPlayers.clear()
            }
        }

        val evalScript = """
            (function() {
              const value = ($wrapper);
              if (value == null) return "";
              const text = String(value);
              return text.length <= 10485760 ? text : "";
            })()
        """.trimIndent()

        val evaluatedText = engine.withRuntime { js ->
            val result = js.evaluate<String?>(evalScript) ?: ""
            if (!isPreprocessed) {
                js.gc()
            }
            result
        }

        if (evaluatedText.length > 10485760) {
            return emptyResult
        }
        val trimmed = evaluatedText.trim()
        val requestCount = requests.sumOf { it.second.size }
        val elapsed = System.currentTimeMillis() - start
        val playerHash = RemotePlayerConfigParser.extractPlayerHash(playerUrl) ?: "unknown"
        logger?.d("EjsChallengeSolver", "EJS evaluate done preprocessed=$isPreprocessed requests=$requestCount elapsed=${elapsed}ms player=$playerHash")

        return try {
            val rootObj = Json.parseToJsonElement(trimmed).jsonObject
            val rootType = rootObj["type"]?.jsonPrimitive?.content
            if (rootType != "result") {
                logger?.w("EjsChallengeSolver", "EJS returned a top-level error")
                return emptyResult
            }
            val preprocessedPlayer = rootObj["preprocessed_player"]?.jsonPrimitive?.contentOrNull?.takeIf {
                it.isNotBlank() && it.length <= 8388608
            }
            if (preprocessedPlayer != null) {
                putPreprocessedPlayerLocked(playerUrl, preprocessedPlayer)
            }
            val responses = rootObj["responses"]?.jsonArray ?: JsonArray(emptyList())
            val activeRequests = requests.filter { it.second.isNotEmpty() }
            if (responses.size != activeRequests.size) {
                logger?.w("EjsChallengeSolver", "EJS responses size mismatch expected=${activeRequests.size} got=${responses.size}")
            }
            val sigMap = LinkedHashMap<String, String>()
            val nMap = LinkedHashMap<String, String>()
            for ((index, req) in activeRequests.withIndex()) {
                val kind = req.first
                if (index < responses.size) {
                    val respObj = responses[index].jsonObject
                    if (respObj["type"]?.jsonPrimitive?.content == "result") {
                        val dataObj = respObj["data"]?.jsonObject
                        if (dataObj != null) {
                            val dataMap = LinkedHashMap<String, String>()
                            for ((k, v) in dataObj) {
                                val content = v.jsonPrimitive.content
                                if (content.isNotBlank() && content.length <= 262144) {
                                    dataMap[k] = content
                                }
                            }
                            if (kind == "sig") {
                                sigMap.putAll(dataMap)
                            } else if (kind == "n") {
                                nMap.putAll(dataMap)
                            }
                        }
                    } else {
                        logger?.w("EjsChallengeSolver", "EJS request kind=$kind failed")
                    }
                }
            }
            SolveResult(sigMap, nMap, preprocessedPlayer)
        } catch (e: Exception) {
            val exName = e::class.simpleName ?: "Exception"
            logger?.w("EjsChallengeSolver", "EJS output was not valid JSON ($exName)")
            emptyResult
        }
    }

    suspend fun solveUncached(
        playerUrl: String,
        loadFullPlayerJs: suspend () -> String?,
        requests: List<Pair<String, List<String>>>,
        preferPreprocessed: Boolean,
    ): SolveResult {
        ensureBootstrapped()
        if (!preferPreprocessed && compiledPlayers.contains(playerUrl)) {
            val cachedAttempt = solveOnce(playerUrl, null, requests, false)
            if (solvesAll(cachedAttempt, requests)) {
                return cachedAttempt
            }
        }

        val cacheKey = bundleHash?.let { preprocessedPlayerCacheKey(playerUrl, it) }
        var result = SolveResult(emptyMap(), emptyMap(), null)

        if (preferPreprocessed) {
            val preprocessed = loadPreprocessedPlayer(playerUrl, cacheKey)
            if (preprocessed != null) {
                try {
                    val attempt = solveOnce(playerUrl, preprocessed, requests, true)
                    if (solvesAll(attempt, requests)) {
                        return attempt
                    }
                    result = attempt
                } catch (e: CancellationException) {
                    throw e
                } catch (_: Exception) {
                }
                preprocessedByPlayerUrl.remove(playerUrl)
                compiledPlayers.remove(playerUrl)
                if (cacheKey != null) {
                    safeWritePreprocessedPlayer(cacheKey, null)
                }
            }
        }

        val fullPlayerJs = loadFullPlayerJs()
        if (fullPlayerJs != null && fullPlayerJs.isNotBlank() && fullPlayerJs.length <= 8388608) {
            val fullAttempt = solveOnce(playerUrl, fullPlayerJs, requests, false)
            val extractedPreprocessed = fullAttempt.preprocessedPlayer
            if (cacheKey != null && extractedPreprocessed != null && extractedPreprocessed.isNotBlank() && extractedPreprocessed.length <= 8388608) {
                safeWritePreprocessedPlayer(cacheKey, extractedPreprocessed)
            }
            return fullAttempt
        }
        return result
    }

    companion object {
        private val payloadJson = Json {
            encodeDefaults = false
        }
    }
}

val PREPROCESSED_CACHE_KEY_REGEX = Regex("[a-f0-9]{40}")

fun preprocessedPlayerCacheKey(playerScriptUrl: String, bundleHash: String): String? {
    if (!PREPROCESSED_CACHE_KEY_REGEX.matches(bundleHash)) {
        return null
    }
    val url = runCatching { validatedPlayerScriptUrl(playerScriptUrl) }.getOrNull() ?: return null
    return sha1("$playerScriptUrl:$bundleHash")
}

fun solvesAll(result: EjsChallengeSolver.SolveResult, requests: List<Pair<String, List<String>>>): Boolean {
    for ((kind, challenges) in requests) {
        val map = when (kind) {
            "sig" -> result.sigByChallenge
            "n" -> result.nByChallenge
            else -> return false
        }
        for (c in challenges) {
            if (!map.containsKey(c)) {
                return false
            }
        }
    }
    return true
}

internal fun validatedPlayerScriptUrl(urlStr: String): Url {
    val url = Url(urlStr)
    val host = url.host
    val validHost = host == "youtube.com" || host.endsWith(".youtube.com") || host == "youtube-nocookie.com" || host.endsWith(".youtube-nocookie.com")
    require(url.protocol.name == "https" && validHost && url.encodedPath.startsWith("/s/player/") && url.encodedPath.endsWith(".js")) {
        "Player script URL must use an approved YouTube HTTPS endpoint"
    }
    return url
}

internal fun sha1(str: String): String {
    val md = MessageDigest.getInstance("SHA-1")
    val digest = md.digest(str.toByteArray(Charsets.UTF_8))
    return digest.joinToString("") { "%02x".format(it) }
}

private fun readYtEjsSolverScript(name: String): String {
    val path = "yt_ejs/$name"
    val classLoader = Thread.currentThread().contextClassLoader
    val stream = classLoader?.getResourceAsStream(path)
        ?: EjsChallengeSolver::class.java.getResourceAsStream("/$path")
        ?: EjsChallengeSolver::class.java.getResourceAsStream(path)
        ?: error("Missing classpath resource: $path")
    return stream.bufferedReader(Charsets.UTF_8).use { it.readText() }
}
