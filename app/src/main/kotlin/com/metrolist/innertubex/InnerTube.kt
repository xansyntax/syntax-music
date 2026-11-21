package com.metrolist.innertubex

import com.metrolist.innertubex.models.YouTubeClient
import com.metrolist.innertubex.models.YouTubeLocale
import com.metrolist.innertubex.models.body.EditPlaylistBody
import com.metrolist.innertubex.models.body.PlayerBody
import com.metrolist.innertubex.models.response.ImageUploadResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.url
import io.ktor.client.request.header
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsChannel
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.Url
import io.ktor.http.contentType
import io.ktor.http.encodedPath
import io.ktor.http.isSuccess
import io.ktor.http.takeFrom
import io.ktor.utils.io.cancel
import java.security.MessageDigest
import java.util.Locale
import java.util.concurrent.CancellationException
import java.util.concurrent.atomic.AtomicReference
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonPrimitive

class InnerTube(
    val httpClient: HttpClient,
    val logger: InnerTubeLogger = InnerTubeLogger.NONE,
    val retryDelay: suspend (Duration) -> Unit = { delay(it) },
) {
    data class SessionSnapshot(
        val locale: YouTubeLocale,
        val visitorData: String? = null,
        val dataSyncId: String? = null,
        val authUser: String = "0",
        val cookie: String? = null,
        val sapisid: String? = null,
        val useLoginForBrowse: Boolean = false,
        val regionOverrideActive: Boolean = false,
        val generation: Long = 0L,
    ) {
        override fun toString(): String {
            return "SessionSnapshot(locale=$locale, visitorData=${presence(visitorData)}, dataSyncId=${presence(dataSyncId)}, authUser=${presence(authUser)}, cookie=${presence(cookie)}, sapisid=${presence(sapisid)}, useLoginForBrowse=$useLoginForBrowse, regionOverrideActive=$regionOverrideActive, generation=$generation)"
        }

        companion object {
            fun presence(str: String?): String = if (str.isNullOrBlank()) "missing" else "present"
        }
    }

    data class SessionBoundRequest(
        val session: SessionSnapshot,
        val job: Job,
    )

    data class VisitorDataFlight(
        val sessionIdentity: SessionSnapshot,
        val result: CompletableDeferred<String?>,
    )

    val session: AtomicReference<SessionSnapshot>
    val mutableSessionFlow: MutableStateFlow<SessionSnapshot>
    val sessionFlow: StateFlow<SessionSnapshot>
    val visitorDataFetchMutex = Mutex()
    val visitorDataScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    val sessionBoundRequests = AtomicReference<List<SessionBoundRequest>>(emptyList())
    var visitorDataFlight: VisitorDataFlight? = null

    init {
        val defLocale = Locale.getDefault()
        val country = defLocale.country.uppercase(Locale.ROOT)
        val languageTag = defLocale.toLanguageTag()
        val initialSession = SessionSnapshot(
            locale = YouTubeLocale(gl = country, hl = languageTag),
            visitorData = null,
            dataSyncId = null,
            authUser = "0",
            cookie = null,
            sapisid = null,
            useLoginForBrowse = false,
            regionOverrideActive = false,
            generation = 0L,
        )
        session = AtomicReference(initialSession)
        mutableSessionFlow = MutableStateFlow(initialSession)
        sessionFlow = mutableSessionFlow.asStateFlow()
    }

    fun sessionSnapshot(): SessionSnapshot = session.get()

    fun sessionSnapshotWithVisitorData(sessionSnapshot: SessionSnapshot, visitorData: String?): SessionSnapshot? {
        val current = session.get()
        return if (sessionSnapshot.copy(visitorData = visitorData, generation = current.generation) == current) {
            current
        } else {
            null
        }
    }

    fun setLocale(locale: YouTubeLocale) {
        while (true) {
            val current = session.get()
            val next = current.copy(locale = locale)
            if (next == current || publishSession(current, next)) {
                return
            }
        }
    }

    fun hasSapCookieAuth(): Boolean {
        val current = session.get()
        return !current.cookie.isNullOrBlank() && !current.sapisid.isNullOrBlank()
    }

    fun publishSession(sessionSnapshot: SessionSnapshot, nextSessionSnapshot: SessionSnapshot): Boolean {
        val current = session.get()
        if (nextSessionSnapshot == sessionSnapshot) {
            return current == sessionSnapshot
        }
        if (current != sessionSnapshot) {
            return false
        }
        val nextGeneration = sessionSnapshot.generation + 1
        val updated = nextSessionSnapshot.copy(generation = nextGeneration)
        if (!session.compareAndSet(current, updated)) {
            return false
        }
        while (true) {
            val flowVal = mutableSessionFlow.value
            if (flowVal.generation >= nextGeneration) {
                break
            }
            if (mutableSessionFlow.compareAndSet(flowVal, updated)) {
                break
            }
        }
        var oldRequests: List<SessionBoundRequest>
        while (true) {
            val list = sessionBoundRequests.get()
            val kept = list.filter { it.session.generation >= nextGeneration }
            if (sessionBoundRequests.compareAndSet(list, kept)) {
                oldRequests = list.filter { it.session.generation < nextGeneration }
                break
            }
        }
        for (req in oldRequests) {
            req.job.cancel(CancellationException("InnerTube session changed"))
        }
        return true
    }

    suspend fun <T> withSessionBoundRequest(
        sessionSnapshot: SessionSnapshot,
        block: suspend () -> T,
    ): T {
        val job = kotlin.coroutines.coroutineContext[Job] ?: return block()
        val request = SessionBoundRequest(sessionSnapshot, job)
        val generation = sessionSnapshot.generation
        if (session.get().generation != generation) {
            throw CancellationException("InnerTube session changed")
        }
        while (true) {
            val current = sessionBoundRequests.get()
            if (sessionBoundRequests.compareAndSet(current, current + request)) {
                break
            }
        }
        if (session.get().generation != generation) {
            while (true) {
                val current = sessionBoundRequests.get()
                if (sessionBoundRequests.compareAndSet(current, current - request)) break
            }
            throw CancellationException("InnerTube session changed")
        }
        try {
            return block()
        } finally {
            while (true) {
                val current = sessionBoundRequests.get()
                if (sessionBoundRequests.compareAndSet(current, current - request)) break
            }
        }
    }

    suspend fun executeRequest(
        endpoint: String,
        isRetryable: Boolean = false,
        requireSuccess: Boolean = false,
        maxRetries: Int = 3,
        retryDelayMs: Long = 500L,
        backoffMultiplier: Double = 2.0,
        block: suspend () -> HttpResponse,
    ): HttpResponse {
        var attempt = 0
        var currentDelayMs = retryDelayMs
        while (true) {
            try {
                val response = block()
                val status = response.status.value
                val retryAfterMs = if (status == 429) {
                    val rawHeader = response.headers["Retry-After"]
                    val seconds = rawHeader?.toLongOrNull()
                    if (seconds != null) {
                        val ms = seconds * 1000L
                        if (ms in 1..5000) ms else null
                    } else null
                } else null

                val isTransient = if (status == 429) {
                    retryAfterMs != null
                } else {
                    TRANSIENT_STATUS_CODES.contains(status)
                }

                if (isRetryable && isTransient && attempt + 1 < maxRetries) {
                    response.bodyAsChannel().cancel(null)
                    attempt++
                    val delayMs = retryAfterMs ?: currentDelayMs
                    logger.w(TAG, "$endpoint returned HTTP $status on attempt $attempt/$maxRetries, retrying in ${delayMs}ms")
                    retryDelay(delayMs.milliseconds)
                    currentDelayMs = (currentDelayMs * backoffMultiplier).toLong()
                    continue
                }

                if (attempt > 0 && isTransient) {
                    logger.w(TAG, "$endpoint succeeded on retry ${attempt + 1}/$maxRetries")
                }

                if (requireSuccess && status !in 200..299) {
                    response.bodyAsChannel().cancel(null)
                    throw InnerTubeHttpException(endpoint, response.status)
                }

                return response
            } catch (e: CancellationException) {
                throw e
            } catch (e: InnerTubeHttpException) {
                throw e
            } catch (e: Exception) {
                attempt++
                val logType = e::class.simpleName ?: "Exception"
                if (isRetryable && attempt < maxRetries) {
                    logger.w(TAG, "$endpoint failed on attempt $attempt/$maxRetries ($logType), retrying in ${currentDelayMs}ms")
                    retryDelay(currentDelayMs.milliseconds)
                    currentDelayMs = (currentDelayMs * backoffMultiplier).toLong()
                    continue
                } else {
                    logger.w(TAG, "$endpoint failed after $attempt attempts ($logType)")
                    throw e
                }
            }
        }
    }

    suspend fun player(
        client: YouTubeClient,
        videoId: String,
        signatureTimestamp: Int? = null,
        poToken: String? = null,
        requestSession: SessionSnapshot = session.get(),
        encryptedHostFlags: String? = null,
        requestVisitorData: String? = null,
    ): HttpResponse = withSessionBoundRequest(requestSession) {
        val visitorDataForRequest = requestVisitorData ?: requestSession.visitorData
        val requestClient = if (client.userAgent.contains("{language}")) {
            client.copy(userAgent = client.userAgent.replace("{language}", requestSession.locale.hl.orEmpty()))
        } else {
            client
        }

        executeRequest("player:${client.clientName}", isRetryable = false, requireSuccess = false) {
            val startMs = System.currentTimeMillis()
            val hasCookie = !requestSession.cookie.isNullOrBlank()
            val hasSapisid = !requestSession.sapisid.isNullOrBlank()
            val hasDataSync = !requestSession.dataSyncId.isNullOrBlank()

            logger.d(
                TAG,
                "player request client=${client.clientName} version=${client.clientVersion} poToken=${poToken != null} sts=${signatureTimestamp != null} loginSupported=${client.loginSupported} loginRequired=${client.loginRequired} hasCookie=$hasCookie hasSapisid=$hasSapisid authEligible=${client.loginSupported} hasDataSync=$hasDataSync"
            )

            val response = httpClient.request("player") {
                method = HttpMethod.Post
                ytClient(
                    this,
                    requestClient,
                    requestSession,
                    setLogin = false,
                    visitorData = visitorDataForRequest,
                    usePrefCookie = true
                )
                val context = requestClient.toContext(
                    locale = requestSession.locale,
                    visitorData = visitorDataForRequest,
                    dataSyncId = if (client.loginSupported) requestSession.dataSyncId else null
                )
                val playbackContext = if (client.useSignatureTimestamp || client.isEmbedded) {
                    PlayerBody.PlaybackContext(
                        PlayerBody.PlaybackContext.ContentPlaybackContext(
                            html5Preference = if (!client.useMusicPlayerEndpoint) "HTML5_PREF_WANTS" else null,
                            signatureTimestamp = if (client.useSignatureTimestamp) signatureTimestamp else null,
                            encryptedHostFlags = if (client.isEmbedded) encryptedHostFlags else null
                        )
                    )
                } else null

                setBody(
                    PlayerBody(
                        context = context,
                        videoId = videoId,
                        playbackContext = playbackContext,
                        thirdParty = if (client.isEmbedded) PlayerBody.ThirdParty("https://www.youtube.com/embed/$videoId") else null,
                        serviceIntegrityDimensions = if (poToken != null) PlayerBody.ServiceIntegrityDimensions(poToken) else null,
                        videoCheckOk = if (!client.useMusicPlayerEndpoint) true else null
                    )
                )
                header(HttpHeaders.UserAgent, requestClient.userAgent)
            }
            val elapsed = System.currentTimeMillis() - startMs
            logger.d(TAG, "player response client=${client.clientName} elapsed=${elapsed}ms")
            response
        }
    }

    suspend fun executeMutation(
        name: String,
        sessionSnapshot: SessionSnapshot,
        block: suspend (SessionSnapshot) -> HttpResponse,
    ): HttpResponse = withSessionBoundRequest(sessionSnapshot) {
        executeRequest(name, isRetryable = false, requireSuccess = false) {
            block(sessionSnapshot)
        }
    }

    suspend fun fetchFreshVisitorData(sessionSnapshot: SessionSnapshot, force: Boolean = false): String? {
        val deferred: CompletableDeferred<String?>
        visitorDataFetchMutex.withLock {
            val current = session.get()
            if (force && sessionSnapshot == current) {
                val flightIdentity = sessionSnapshot.copy(visitorData = null, generation = 0L)
                val existingFlight = visitorDataFlight
                if (existingFlight != null && existingFlight.sessionIdentity == flightIdentity) {
                    deferred = existingFlight.result
                } else {
                    val newDeferred = CompletableDeferred<String?>()
                    visitorDataFlight = VisitorDataFlight(flightIdentity, newDeferred)
                    visitorDataScope.launch {
                        try {
                            val result = fetchFreshVisitorDataNetwork(sessionSnapshot)
                            newDeferred.complete(result)
                        } catch (t: Throwable) {
                            newDeferred.completeExceptionally(t)
                        }
                    }
                    deferred = newDeferred
                }
            } else {
                val visitorData = current.visitorData
                if (visitorData == null) {
                    val flightIdentity = sessionSnapshot.copy(visitorData = null, generation = 0L)
                    val existingFlight = visitorDataFlight
                    if (existingFlight != null && existingFlight.sessionIdentity == flightIdentity) {
                        deferred = existingFlight.result
                    } else {
                        val newDeferred = CompletableDeferred<String?>()
                        visitorDataFlight = VisitorDataFlight(flightIdentity, newDeferred)
                        visitorDataScope.launch {
                            try {
                                val result = fetchFreshVisitorDataNetwork(sessionSnapshot)
                                newDeferred.complete(result)
                            } catch (t: Throwable) {
                                newDeferred.completeExceptionally(t)
                            }
                        }
                        deferred = newDeferred
                    }
                } else {
                    val candidate = if (visitorData.isBlank() || sessionSnapshot.copy(visitorData = visitorData, generation = 0L) != current.copy(generation = 0L)) {
                        null
                    } else {
                        visitorData
                    }
                    if (candidate != null) {
                        deferred = CompletableDeferred()
                        deferred.complete(candidate)
                    } else {
                        val flightIdentity = sessionSnapshot.copy(visitorData = null, generation = 0L)
                        val existingFlight = visitorDataFlight
                        if (existingFlight != null && existingFlight.sessionIdentity == flightIdentity) {
                            deferred = existingFlight.result
                        } else {
                            val newDeferred = CompletableDeferred<String?>()
                            visitorDataFlight = VisitorDataFlight(flightIdentity, newDeferred)
                            visitorDataScope.launch {
                                try {
                                    val result = fetchFreshVisitorDataNetwork(sessionSnapshot)
                                    newDeferred.complete(result)
                                } catch (t: Throwable) {
                                    newDeferred.completeExceptionally(t)
                                }
                            }
                            deferred = newDeferred
                        }
                    }
                }
            }
        }
        return deferred.await()
    }

    suspend fun fetchFreshVisitorDataNetwork(sessionSnapshot: SessionSnapshot): String? {
        val startMs = System.currentTimeMillis()
        logger.d(TAG, "fetchFreshVisitorData start")
        var visitorData: String? = null
        var source = "service-worker"
        try {
            try {
                val swResponse = executeRequest("fetchFreshVisitorData", isRetryable = false, requireSuccess = false) {
                    httpClient.request("https://www.youtube.com/sw.js_data") {
                        method = HttpMethod.Get
                        header(HttpHeaders.UserAgent, YouTubeClient.USER_AGENT_WEB)
                        header(HttpHeaders.Accept, "application/json,text/plain,*/*")
                        header(HttpHeaders.AcceptLanguage, sessionSnapshot.locale.acceptLanguageHeader())
                    }
                }
                if (swResponse.status.value in 200..299) {
                    val swText = swResponse.bodyAsTextLimited(65536)
                    visitorData = parseServiceWorkerVisitorData(swText)
                } else {
                    swResponse.bodyAsChannel().cancel(null)
                }
            } catch (e: Exception) {
                logger.d(TAG, "service-worker visitor data unavailable (${e::class.simpleName ?: "Exception"})")
            }

            if (visitorData.isNullOrBlank()) {
                source = "homepage"
                visitorData = fetchHomepageVisitorData(sessionSnapshot)
            }

            if (!visitorData.isNullOrBlank()) {
                publishSession(sessionSnapshot, sessionSnapshot.copy(visitorData = visitorData))
            }

            val elapsed = System.currentTimeMillis() - startMs
            val hasVisitorData = !visitorData.isNullOrBlank()
            logger.d(TAG, "fetchFreshVisitorData success hasVisitorData=$hasVisitorData source=$source elapsed=${elapsed}ms")
            return visitorData
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            logger.w(TAG, "fetchFreshVisitorData failed (${e::class.simpleName ?: "Exception"})")
            return null
        }
    }

    suspend fun fetchHomepageVisitorData(sessionSnapshot: SessionSnapshot): String? {
        val response = executeRequest("fetchFreshVisitorData", isRetryable = false, requireSuccess = false) {
            httpClient.request("https://music.youtube.com") {
                method = HttpMethod.Get
                header(HttpHeaders.UserAgent, YouTubeClient.USER_AGENT_WEB)
                header(HttpHeaders.Accept, "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                header(HttpHeaders.AcceptLanguage, sessionSnapshot.locale.acceptLanguageHeader())
            }
        }
        val status = response.status.value
        return if (status in 200..299) {
            val text = response.bodyAsTextLimited(maxBytes = 4194304)
            VISITOR_DATA_REGEX.find(text)?.groupValues?.getOrNull(1)
        } else {
            response.bodyAsChannel().cancel(null)
            null
        }
    }

    suspend fun mediaContentLength(url: String, headers: Map<String, String>): Long? {
        return try {
            val validatedUrl = validatedMediaUrl(url) ?: return null
            val response = httpClient.request(validatedUrl) {
                method = HttpMethod.Head
                for ((key, value) in headers) {
                    if (MEDIA_REQUEST_HEADERS.contains(key.lowercase(Locale.ROOT))) {
                        header(key, value)
                    }
                }
            }
            val len = response.headers[HttpHeaders.ContentLength]?.toLongOrNull()
            if (len == null || len <= 0L) null else len
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            null
        }
    }

    suspend fun setPlaylistThumbnail(client: YouTubeClient, playlistId: String, imageBytes: ByteArray): Boolean {
        require(imageBytes.isNotEmpty()) { "Playlist thumbnail must not be empty" }
        val snapshot = sessionSnapshot()

        // 1. Start upload session
        val startResponse = executeMutation("setPlaylistThumbnail:start", snapshot) { s ->
            httpClient.request("https://music.youtube.com/playlist_image_upload/playlist_custom_thumbnail") {
                method = HttpMethod.Post
                ytClient(this, client, s, setLogin = true)
                header("X-Goog-Upload-Command", "start")
                header("X-Goog-Upload-Protocol", "resumable")
                header("X-Goog-Upload-Header-Content-Length", imageBytes.size.toString())
            }
        }
        val uploadId = startResponse.headers["X-Goog-Upload-Id"] ?: startResponse.headers["X-Guploader-Uploadid"]
        startResponse.bodyAsTextLimited(65536)
        if (!startResponse.status.isSuccess()) {
            error("Playlist thumbnail upload session start failed with HTTP ${startResponse.status.value}")
        }
        check(!uploadId.isNullOrBlank()) { "Missing playlist thumbnail upload ID" }

        // 2. Upload bytes
        val uploadResponse = executeMutation("setPlaylistThumbnail:upload", snapshot) { s ->
            httpClient.request("https://music.youtube.com/playlist_image_upload/playlist_custom_thumbnail") {
                method = HttpMethod.Post
                ytClient(this, client, s, setLogin = true)
                parameter("upload_id", uploadId)
                parameter("upload_protocol", "resumable")
                header("X-Goog-Upload-Command", "upload, finalize")
                header("X-Goog-Upload-Offset", "0")
                setBody(imageBytes)
            }
        }
        val uploadText = uploadResponse.bodyAsTextLimited(65536)
        if (!uploadResponse.status.isSuccess()) {
            error("Playlist thumbnail upload failed with HTTP ${uploadResponse.status.value}")
        }
        val imageUploadResponse = Json.decodeFromString<ImageUploadResponse>(uploadText)

        // 3. Apply thumbnail to playlist
        val applyResponse = executeMutation("setPlaylistThumbnail:apply", snapshot) { s ->
            httpClient.request("browse/edit_playlist") {
                method = HttpMethod.Post
                ytClient(this, client, s, setLogin = true)
                val cleanPlaylistId = playlistId.removePrefix("VL")
                setBody(
                    EditPlaylistBody(
                        context = client.toContext(s.locale, s.visitorData, s.dataSyncId),
                        playlistId = cleanPlaylistId,
                        actions = listOf(
                            EditPlaylistBody.Action.SetCustomThumbnailAction(
                                addedCustomThumbnail = EditPlaylistBody.Action.SetCustomThumbnailAction.AddedCustomThumbnail(
                                    imageKey = EditPlaylistBody.Action.SetCustomThumbnailAction.AddedCustomThumbnail.ImageKey(
                                        name = imageUploadResponse.encryptedBlobId ?: "",
                                    )
                                )
                            )
                        )
                    )
                )
            }
        }
        return applyResponse.status.isSuccess()
    }

    companion object {
        private const val TAG = "InnerTube"

        val TRANSIENT_STATUS_CODES: Set<Int> = setOf(408, 425, 429, 500, 502, 503, 504)
        val STATS_HOSTS: Set<String> = setOf("s.youtube.com", "www.youtube.com", "music.youtube.com")
        val STATS_PATHS: Set<String> = setOf("/api/stats/playback", "/api/stats/watchtime")
        val MEDIA_REQUEST_HEADERS: Set<String> = setOf(
            HttpHeaders.Accept.lowercase(Locale.ROOT),
            HttpHeaders.AcceptLanguage.lowercase(Locale.ROOT),
            HttpHeaders.Range.lowercase(Locale.ROOT),
            HttpHeaders.UserAgent.lowercase(Locale.ROOT),
        )
        val VISITOR_DATA_REGEX = Regex("\"(?:VISITOR_DATA|visitorData)\"\\s*:\\s*\"([^\"]+)\"")

        fun parseServiceWorkerVisitorData(str: String): String? {
            return try {
                val trimmed = str.substringAfter('\n').trimStart()
                val json = Json.parseToJsonElement(trimmed)
                val array = json.jsonArray[0].jsonArray[2].jsonArray[0].jsonArray[0].jsonArray[13]
                val content = array.jsonPrimitive.content
                if (content.isBlank()) null else content
            } catch (e: Throwable) {
                null
            }
        }

        fun sanitizeCookieString(str: String): String {
            val sb = StringBuilder()
            for (c in str) {
                if (c != '\r' && c != '\n' && c != '\t') {
                    sb.append(c)
                }
            }
            val cleaned = sb.toString()
            for (c in cleaned) {
                require(!c.isISOControl()) { "Cookie must not contain control characters" }
            }
            var result = cleaned.trim()
            if (result.startsWith("Cookie:", ignoreCase = true)) {
                result = result.substring(7)
            }
            return result.trim()
        }

        fun sanitizeVisitorData(str: String?): String? {
            if (str == null) return null
            val sb = StringBuilder()
            for (c in str) {
                if (!c.isWhitespace()) {
                    sb.append(c)
                }
            }
            val result = sb.toString()
            if (result.isNotEmpty()) {
                for (c in result) {
                    if (c !in '!'..'~') return null
                }
                return result
            }
            return null
        }

        fun injectPrefCookie(cookie: String?, hl: String, gl: String): String {
            if (cookie.isNullOrBlank()) {
                return "PREF=hl=$hl&gl=$gl"
            }
            val parts = cookie.split(";").map { it.trim() }.filter { it.isNotEmpty() }
            val prefItems = mutableListOf<String>()
            val otherCookies = mutableListOf<String>()
            for (part in parts) {
                if (part.startsWith("PREF=", ignoreCase = true)) {
                    val sub = part.substringAfter("=")
                    for (kv in sub.split("&")) {
                        if (!kv.startsWith("hl=", ignoreCase = false) && !kv.startsWith("gl=", ignoreCase = false)) {
                            prefItems.add(kv)
                        }
                    }
                } else {
                    otherCookies.add(part)
                }
            }
            prefItems.add(0, "hl=$hl")
            prefItems.add(1, "gl=$gl")
            val prefCookie = "PREF=" + prefItems.joinToString("&")
            return (listOf(prefCookie) + otherCookies).joinToString("; ")
        }

        fun resolveSapisidValue(str: String?): String? {
            if (str == null) return null
            val sanitized = sanitizeCookieString(str)
            val cookies = sanitized.split(";").map { it.trim() }.filter { it.isNotEmpty() }.associate { part ->
                val split = part.split("=", limit = 2)
                val rawName = split.getOrNull(0)?.trim().orEmpty()
                val name = rawName.removePrefix("cookie:").removePrefix("Cookie:").trim()
                val value = split.getOrNull(1)?.trim().orEmpty()
                name to value
            }
            return cookies["SAPISID"] ?: cookies["__Secure-3PAPISID"] ?: cookies["__Secure-1PAPISID"]
        }

        fun sanitizeAuthUser(str: String): String {
            val sb = StringBuilder()
            for (c in str) {
                if (c.isDigit()) {
                    sb.append(c)
                }
            }
            val result = sb.toString()
            return if (result.isBlank()) "0" else result
        }

        fun validatedMediaUrl(str: String): Url? {
            val url = Url(str)
            require(
                url.protocol.name == "https" &&
                url.port == 443 &&
                (url.host == "googlevideo.com" || url.host.endsWith(".googlevideo.com")) &&
                url.encodedPath == "/videoplayback" &&
                url.user == null &&
                url.password == null
            ) {
                "Media URL must use an approved Google Video HTTPS endpoint"
            }
            return url
        }

        fun ytClient(
            builder: HttpRequestBuilder,
            client: YouTubeClient,
            session: SessionSnapshot,
            setLogin: Boolean = false,
            visitorData: String? = null,
            usePrefCookie: Boolean = true,
        ) {
            val path = builder.url.encodedPath.removePrefix("/")
            val (apiBase, origin, defaultReferrer) = if (path == "player" && client.useMusicPlayerEndpoint) {
                Triple("https://music.youtube.com/youtubei/v1", "https://music.youtube.com", "https://music.youtube.com/")
            } else {
                when (client.clientName) {
                    "WEB_REMIX" -> Triple("https://music.youtube.com/youtubei/v1", "https://music.youtube.com", "https://music.youtube.com/")
                    "WEB_CREATOR" -> Triple("https://studio.youtube.com/youtubei/v1", "https://studio.youtube.com", "https://studio.youtube.com/")
                    "MWEB" -> Triple("https://m.youtube.com/youtubei/v1", "https://m.youtube.com", "https://m.youtube.com/")
                    else -> Triple("https://www.youtube.com/youtubei/v1", "https://www.youtube.com", "https://www.youtube.com/")
                }
            }
            val referrer = if (client.isEmbedded) "https://www.reddit.com/" else defaultReferrer
            builder.url.takeFrom("$apiBase/$path")
            builder.contentType(ContentType.Application.Json)
            builder.headers {
                append("X-Goog-Api-Format-Version", "1")
                append("X-YouTube-Client-Name", client.clientId)
                append("X-YouTube-Client-Version", client.clientVersion)
                append(HttpHeaders.Origin, origin)
                append("X-Origin", origin)
                append(HttpHeaders.Referrer, referrer)
                append(HttpHeaders.AcceptLanguage, session.locale.acceptLanguageHeader())
                if (visitorData != null) {
                    append("X-Goog-Visitor-Id", visitorData)
                }
                if (client.loginSupported && usePrefCookie) {
                    append(HttpHeaders.Cookie, injectPrefCookie(session.cookie, session.locale.hl, session.locale.gl))
                }
                if (setLogin && client.loginSupported && !session.cookie.isNullOrBlank()) {
                    append("X-Goog-AuthUser", session.authUser)
                    val sapisid = session.sapisid
                    if (!sapisid.isNullOrBlank()) {
                        val epochSeconds = System.currentTimeMillis() / 1000
                        val sha1 = sha1("$epochSeconds $sapisid $origin")
                        append("Authorization", "SAPISIDHASH ${epochSeconds}_$sha1")
                    }
                }
            }
        }

        private fun sha1(str: String): String {
            val digest = MessageDigest.getInstance("SHA-1").digest(str.toByteArray(Charsets.UTF_8))
            return digest.joinToString("") { "%02x".format(it) }
        }
    }
}
