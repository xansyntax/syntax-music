package com.metrolist.innertubex.extraction

import com.metrolist.innertubex.InnerTube
import com.metrolist.innertubex.InnerTubeLogger
import com.metrolist.innertubex.d
import com.metrolist.innertubex.e
import com.metrolist.innertubex.i
import com.metrolist.innertubex.w
import com.metrolist.innertubex.cipher.YouTubeCipherService
import com.metrolist.innertubex.cipher.canonicalPlayerUrl
import com.metrolist.innertubex.extraction.strategy.ClientHealthMonitor
import com.metrolist.innertubex.extraction.strategy.ClientSelectionMode
import com.metrolist.innertubex.extraction.strategy.ContentAwareFallbackStrategy
import com.metrolist.innertubex.extraction.strategy.PlaybackClientCatalog
import com.metrolist.innertubex.models.YouTubeLocale
import com.metrolist.innertubex.models.response.PlayerResponse
import com.metrolist.innertubex.sabr.SabrBootstrap
import com.metrolist.innertubex.sabr.requireAllowedSabrUrl
import com.metrolist.innertubex.sabr.sabrRequestOrigin
import com.metrolist.innertubex.sabr.toSabrBootstrap
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.http.Url
import io.ktor.http.encodedPath
import java.io.IOException
import java.util.Locale
import java.util.concurrent.CancellationException
import kotlin.time.Duration.Companion.seconds
import kotlin.time.Instant
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withTimeoutOrNull

@OptIn(kotlin.time.ExperimentalTime::class)
class InnerTubeExtractor(
    val configParser: YtConfigParserImpl,
    val cipherService: YouTubeCipherService,
    val innerTube: InnerTube,
    tokenProvider: TokenProvider? = null,
    val logger: InnerTubeLogger = InnerTubeLogger.NONE,
) {
    val tokenProvider: TokenProvider = tokenProvider ?: UnavailableTokenProvider
    val clientDirector: PlayerClientDirector = PlayerClientDirector(
        innerTube = innerTube,
        fallbackStrategy = ContentAwareFallbackStrategy(),
        tokenProvider = this.tokenProvider,
        healthMonitor = ClientHealthMonitor.NONE,
        logger = logger,
    )
    val playerConfigCache: MutableMap<Boolean, CachedPlayerConfig> = LinkedHashMap()
    val playerConfigFetchMutex: Mutex = Mutex()

    data class CachedPlayerConfig(
        val config: PlayerConfig,
        val cachedAtMs: Long,
        val identity: ConfigIdentity,
        val usedLoginCookies: Boolean,
    )

    data class ConfigIdentity(
        val locale: YouTubeLocale,
        val cookie: String?,
    )

    class StreamResolutionContext(budget: Int = MAX_PLAYER_REQUESTS_PER_EXTRACTION) {
        val requestContext: PlayerClientDirector.PlayerRequestContext = PlayerClientDirector.PlayerRequestContext(budget)
        val failures: MutableList<PlayabilityFailure> = ArrayList()
        val requestFailures: MutableList<Throwable> = ArrayList()
        val attempts: MutableList<StreamAttemptDiagnostic> = ArrayList()
        var hasPlayableResponse: Boolean = false
        var usedAuthenticatedWatchPage: Boolean = false

        fun snapshot(): StreamDiagnostics = StreamDiagnostics(attempts.takeLast(32), usedAuthenticatedWatchPage)
    }

    companion object {
        val PO_TOKEN_PREFETCH_TIMEOUT = 18.seconds
        val EXPIRE_REGEX = Regex("[?&]expire=([0-9]+)")
        val N_PARAMETER_REGEX = Regex("(?:[?&]|%26)n(?:=|%3[dD])")
        val CODECS_REGEX = Regex("codecs=\"([^\"]+)\"")
        val MAX_PLAYER_REQUESTS_PER_EXTRACTION = (PlaybackClientCatalog.automaticManifests.size * 4) + 2

        fun extractCodecs(mimeType: String): String? {
            val match = CODECS_REGEX.find(mimeType) ?: return null
            return match.groupValues.getOrNull(1)
        }

        fun extractExpire(url: String): Long? {
            val match = EXPIRE_REGEX.find(url) ?: return null
            return match.groupValues.getOrNull(1)?.toLongOrNull()
        }

        fun hasReadyVideoUrl(format: PlayerResponse.StreamingData.Format): Boolean {
            val url = format.url ?: return false
            return !N_PARAMETER_REGEX.containsMatchIn(url) && isAllowedMediaUrl(url)
        }

        fun isAllowedHlsUrl(url: String): Boolean {
            val parsed = runCatching { Url(url) }.getOrNull() ?: return false
            if (parsed.protocol != URLProtocol.HTTPS || parsed.port != 443 || parsed.user != null || parsed.password != null) {
                return false
            }
            val host = parsed.host
            if (host == "googlevideo.com" || host.endsWith(".googlevideo.com") || host == "youtube.com" || host.endsWith(".youtube.com")) {
                val path = parsed.encodedPath
                return path.startsWith("/manifest/") || path.startsWith("/api/manifest/")
            }
            return false
        }

        fun isAllowedMediaUrl(url: String): Boolean {
            val parsed = runCatching { Url(url) }.getOrNull() ?: return false
            if (parsed.protocol != URLProtocol.HTTPS || parsed.port != 443 || parsed.user != null || parsed.password != null) {
                return false
            }
            val host = parsed.host
            return (host == "googlevideo.com" || host.endsWith(".googlevideo.com") || host == "youtube.com" || host.endsWith(".youtube.com")) &&
                parsed.encodedPath == "/videoplayback"
        }

        fun withPoToken(url: String, poToken: String?): String {
            if (poToken.isNullOrBlank()) return url
            if (url.contains("&pot=") || url.contains("?pot=")) return url
            val hashIndex = url.indexOf('#').takeIf { it >= 0 } ?: url.length
            val queryIndex = url.indexOf('?', 0)
            val separator = if (queryIndex < 0 || queryIndex >= hashIndex) "?" else "&"
            val encodedToken = buildString(poToken.length) {
                for (b in poToken.encodeToByteArray()) {
                    val i = b.toInt() and 0xFF
                    if ((i in 48..57) || (i in 65..90) || (i in 97..122) || i == 45 || i == 46 || i == 95 || i == 126) {
                        append(i.toChar())
                    } else {
                        append('%')
                        append("0123456789ABCDEF"[i ushr 4])
                        append("0123456789ABCDEF"[i and 0x0F])
                    }
                }
            }
            return buildString(url.length + poToken.length + 6) {
                append(url, 0, hashIndex)
                append(separator)
                append("pot=")
                append(encodedToken)
                append(url, hashIndex, url.length)
            }
        }

        fun toPlaybackTrackingData(tracking: PlayerResponse.PlaybackTracking?, clientPlaybackNonce: String?): PlaybackTrackingData? {
            return PlaybackTrackingData(
                clientPlaybackNonce = clientPlaybackNonce.orEmpty(),
                playbackUrl = tracking?.videostatsPlaybackUrl?.baseUrl,
                watchtimeUrl = tracking?.videostatsWatchtimeUrl?.baseUrl,
                scheduledFlushWalltimeSeconds = tracking?.videostatsScheduledFlushWalltimeSeconds,
                defaultFlushIntervalSeconds = tracking?.videostatsDefaultFlushIntervalSeconds,
                resolvedAtEpochMs = System.currentTimeMillis(),
            )
        }

        fun withResponseMetadata(stream: ExtractedStream, playerResponse: PlayerResponse) {
            stream.perceptualLoudnessDb = playerResponse.playerConfig?.audioConfig?.perceptualLoudnessDb
            val details = playerResponse.videoDetails
            if (details != null) {
                stream.mediaMetadata = ExtractedMediaMetadata(
                    title = details.title,
                    author = details.author,
                    channelId = details.channelId,
                    durationSeconds = details.lengthSeconds?.toLongOrNull(),
                    musicVideoType = details.musicVideoType,
                    viewCount = details.viewCount,
                    thumbnails = details.thumbnail?.thumbnails ?: emptyList(),
                    isLive = details.isLiveContent == true,
                )
            }
        }

        fun classifyPlayabilityFailures(failures: List<PlayabilityFailure>): StreamResolveException.Reason? {
            val ageStatuses = setOf("AGE_CHECK_REQUIRED", "AGE_VERIFICATION_REQUIRED", "CONTENT_CHECK_REQUIRED")
            val agePhrases = listOf("confirm your age", "age-restricted", "age restricted", "age verification")
            for (failure in failures) {
                val status = failure.status?.uppercase(Locale.ROOT).orEmpty()
                val reason = failure.reason?.lowercase(Locale.ROOT).orEmpty()
                if (status in ageStatuses || agePhrases.any { it in reason }) {
                    return StreamResolveException.Reason.AGE_RESTRICTED
                }
            }
            val unavailStatuses = setOf("UNPLAYABLE", "VIDEO_UNAVAILABLE", "LIVE_STREAM_OFFLINE")
            val unavailPhrases = listOf("video unavailable", "not available", "private video", "has been removed")
            for (failure in failures) {
                val status = failure.status?.uppercase(Locale.ROOT).orEmpty()
                val reason = failure.reason?.lowercase(Locale.ROOT).orEmpty()
                if (status in unavailStatuses || unavailPhrases.any { it in reason }) {
                    return StreamResolveException.Reason.UNAVAILABLE
                }
            }
            return null
        }

        fun throwExtractionFailure(hints: ContentHints, diagnostics: StreamResolutionContext): Nothing {
            if (!diagnostics.hasPlayableResponse) {
                val classified = classifyPlayabilityFailures(diagnostics.failures)
                if (classified != null) {
                    val message = if (classified == StreamResolveException.Reason.AGE_RESTRICTED) {
                        "This track is age-restricted."
                    } else {
                        "This track is unavailable."
                    }
                    throw StreamResolveException(classified, message, null, diagnostics.snapshot())
                }
                val lastFailure = diagnostics.requestFailures.lastOrNull()
                if (lastFailure != null) {
                    throw StreamResolveException(
                        StreamResolveException.Reason.NETWORK,
                        "Unable to fetch stream data from YouTube.",
                        lastFailure,
                        diagnostics.snapshot(),
                    )
                }
            }
            throw StreamResolveException(
                if (hints.isExplicit == true) StreamResolveException.Reason.EXPLICIT_UNSUPPORTED else StreamResolveException.Reason.NO_PLAYABLE_STREAM,
                "No playable stream found for this track.",
                null,
                diagnostics.snapshot(),
            )
        }

        fun requiresBoundedMediaRange(clientName: String): Boolean =
            clientName == "ANDROID_VR" || clientName == "IOS" || clientName == "TVHTML5_SIMPLY"

        fun usesChunkedMediaRanges(clientName: String): Boolean =
            clientName == "ANDROID_VR" || clientName == "TVHTML5_SIMPLY"

        fun mediaRangeChunkSize(clientName: String): Long =
            if (usesChunkedMediaRanges(clientName)) 524288L else 1048576L
    }

    fun buildHeaders(
        clientName: String,
        userAgent: String,
        url: String? = null,
        authenticated: Boolean = false,
    ): LinkedHashMap<String, String> {
        val headers = LinkedHashMap<String, String>()
        if (clientName != "ANDROID_VR" && clientName != "VISIONOS" && clientName != "TVHTML5_SIMPLY") {
            headers[HttpHeaders.UserAgent] = userAgent
            headers[HttpHeaders.Accept] = "*/*"
            headers[HttpHeaders.AcceptLanguage] = innerTube.sessionSnapshot().locale.acceptLanguageHeader()
            when (clientName) {
                "WEB_CREATOR" -> {
                    headers[HttpHeaders.Referrer] = "https://studio.youtube.com/"
                    headers[HttpHeaders.Origin] = "https://studio.youtube.com"
                }
                "WEB_REMIX" -> {
                    headers[HttpHeaders.Referrer] = "https://music.youtube.com/"
                    headers[HttpHeaders.Origin] = "https://music.youtube.com"
                }
                "WEB" -> {
                    headers[HttpHeaders.Referrer] = "https://www.youtube.com/"
                    headers[HttpHeaders.Origin] = "https://www.youtube.com"
                }
                "MWEB" -> {
                    headers[HttpHeaders.Referrer] = "https://m.youtube.com/"
                    headers[HttpHeaders.Origin] = "https://m.youtube.com"
                }
                "WEB_EMBEDDED_PLAYER" -> {
                    headers[HttpHeaders.Referrer] = "https://www.youtube.com/"
                    headers[HttpHeaders.Origin] = "https://www.youtube.com"
                }
            }
        }
        if (authenticated && url != null && isAllowedMediaUrl(url)) {
            val cookie = innerTube.sessionSnapshot().cookie
            if (!cookie.isNullOrBlank()) {
                headers[HttpHeaders.Cookie] = cookie
            }
        }
        return headers
    }

    fun configIdentity(authenticated: Boolean): ConfigIdentity {
        val snapshot = innerTube.sessionSnapshot()
        val cookie = if (authenticated) snapshot.cookie else null
        return ConfigIdentity(snapshot.locale, cookie)
    }

    fun getCachedPlayerConfigLocked(now: Long, authenticated: Boolean): CachedPlayerConfig? {
        val cached = playerConfigCache[authenticated] ?: return null
        if (cached.identity != configIdentity(authenticated)) {
            playerConfigCache.remove(authenticated)
            return null
        }
        if (now - cached.cachedAtMs <= 10_800_000L) {
            return cached
        }
        playerConfigCache.remove(authenticated)
        return null
    }

    suspend fun getCachedPlayerConfig(authenticated: Boolean, now: Long = System.currentTimeMillis()): CachedPlayerConfig? {
        playerConfigFetchMutex.withLock {
            return getCachedPlayerConfigLocked(now, authenticated)
        }
    }

    private suspend fun prewarmFetchConfig(authenticated: Boolean): PlayerConfig {
        playerConfigFetchMutex.withLock {
            val now = System.currentTimeMillis()
            val cached = getCachedPlayerConfigLocked(now, authenticated)
            if (cached != null) {
                return cached.config
            }
            val identity = configIdentity(authenticated)
            val config = checkNotNull(configParser.fetchConfig("dQw4w9WgXcQ", authenticated))
            if (configIdentity(authenticated) != identity) {
                throw CancellationException("InnerTube session changed")
            }
            playerConfigCache[authenticated] = CachedPlayerConfig(config, System.currentTimeMillis(), identity, authenticated)
            return config
        }
    }

    suspend fun prewarm() {
        val start = System.currentTimeMillis()
        val sessionSnapshot = innerTube.sessionSnapshot()
        val visitorData = if (tokenProvider.getCapabilities().providers.isNotEmpty()) {
            sessionSnapshot.visitorData ?: innerTube.fetchFreshVisitorData(sessionSnapshot, false)
        } else null

        try {
            coroutineScope {
                val configs = buildList {
                    val defaultDeferred = async { prewarmFetchConfig(false) }
                    add(defaultDeferred.await())
                    if (innerTube.hasSapCookieAuth()) {
                        try {
                            add(prewarmFetchConfig(true))
                        } catch (e: Exception) {
                            logger.w("InnerTubeExtractor", "authenticated player config prewarm failed", mapOf("exceptionType" to (e::class.simpleName ?: "unknown")))
                        }
                    }
                }
                val tokenWarmup = if (visitorData != null && tokenProvider.getCapabilities().providers.isNotEmpty()) {
                    async {
                        withTimeoutOrNull(PO_TOKEN_PREFETCH_TIMEOUT) {
                            try {
                                tokenProvider.getPoToken("dQw4w9WgXcQ", visitorData)
                            } catch (e: CancellationException) {
                                throw e
                            } catch (_: Exception) {
                                null
                            }
                        }
                    }
                } else null

                val lastConfigWithPlayerUrl = configs.reversed().firstOrNull { it.playerUrl.isNotBlank() }
                if (lastConfigWithPlayerUrl != null) {
                    cipherService.preloadCanonicalPlayerCode(canonicalPlayerUrl(lastConfigWithPlayerUrl.playerUrl))
                }
                tokenWarmup?.await()
            }
            logger.d("InnerTubeExtractor", "prewarm completed", mapOf("elapsedMs" to (System.currentTimeMillis() - start).toString()))
        } catch (e: Exception) {
            logger.w("InnerTubeExtractor", "player config prewarm failed", mapOf("exceptionType" to (e::class.simpleName ?: "unknown")))
            cipherService.prewarmEjs()
            logger.d("InnerTubeExtractor", "prewarm completed", mapOf("elapsedMs" to (System.currentTimeMillis() - start).toString()))
        }
    }

    suspend fun resolveBoundedContentLength(
        contentLength: Long?,
        url: String,
        headers: Map<String, String>,
        requireBoundedRange: Boolean,
    ): Long? {
        if (contentLength != null && contentLength > 0) {
            return contentLength
        }
        if (!requireBoundedRange) {
            return null
        }
        return withTimeoutOrNull(8.seconds) {
            innerTube.mediaContentLength(url, headers)
        }
    }

    suspend fun extractWithCachedConfig(
        videoId: String,
        hints: ContentHints,
        excludedClients: Set<String>,
        clientPlaybackNonce: String,
        authenticated: Boolean,
        totalStart: Long,
        audioQuality: AudioQuality,
        diagnostics: StreamResolutionContext,
        tokenWarmup: Deferred<PoTokenResult?>?,
    ): ExtractedStream? {
        val now = System.currentTimeMillis()
        val cached = getCachedPlayerConfig(authenticated, now)
        if (cached != null) {
            val stream = extractWithConfig(
                videoId = videoId,
                hints = hints,
                excludedClients = excludedClients,
                clientPlaybackNonce = clientPlaybackNonce,
                config = cached.config,
                totalStart = totalStart,
                allowConfigFallbacks = false,
                audioQuality = audioQuality,
                diagnostics = diagnostics,
                tokenWarmup = tokenWarmup,
            )
            if (stream != null) {
                return stream
            }
            logger.w("InnerTubeExtractor", "watch page cache unusable", mapOf("authenticated" to authenticated.toString()))
        }

        val fetchStart = System.currentTimeMillis()
        var fetched = false
        val config = playerConfigFetchMutex.withLock {
            if (cached != null && playerConfigCache[authenticated] === cached) {
                playerConfigCache.remove(authenticated)
            }
            if (diagnostics.requestContext.getRemaining() <= 0) {
                return null
            }
            val existing = getCachedPlayerConfigLocked(System.currentTimeMillis(), authenticated)
            if (existing != null) {
                existing
            } else {
                val identity = configIdentity(authenticated)
                val fetchedConfig = configParser.fetchConfig(videoId, authenticated) ?: return null
                if (configIdentity(authenticated) != identity) {
                    throw CancellationException("InnerTube session changed")
                }
                fetched = true
                val newCached = CachedPlayerConfig(fetchedConfig, System.currentTimeMillis(), identity, authenticated)
                playerConfigCache[authenticated] = newCached
                newCached
            }
        }

        if (config.usedLoginCookies) {
            diagnostics.usedAuthenticatedWatchPage = true
        }

        logger.d(
            "InnerTubeExtractor", "watch page config ready", mapOf(
                "fetched" to fetched.toString(),
                "authenticated" to config.usedLoginCookies.toString(),
                "elapsedMs" to (System.currentTimeMillis() - fetchStart).toString(),
            )
        )

        return extractWithConfig(
            videoId = videoId,
            hints = hints,
            excludedClients = excludedClients,
            clientPlaybackNonce = clientPlaybackNonce,
            config = config.config,
            totalStart = totalStart,
            allowConfigFallbacks = false,
            audioQuality = audioQuality,
            diagnostics = diagnostics,
            tokenWarmup = tokenWarmup,
        )
    }

    suspend fun extractWithEmbeddedConfig(
        videoId: String,
        hints: ContentHints,
        excludedClients: Set<String>,
        clientPlaybackNonce: String,
        totalStart: Long,
        audioQuality: AudioQuality,
        diagnostics: StreamResolutionContext,
    ): ExtractedStream? {
        val start = System.currentTimeMillis()
        return try {
            val config = configParser.fetchEmbeddedConfig(videoId) ?: return null
            if (config.encryptedHostFlags.isNullOrBlank()) {
                logger.w("InnerTubeExtractor", "embedded config missing encrypted host flags")
                return null
            }
            if (config.signatureTimestamp == null) {
                logger.w("InnerTubeExtractor", "embedded config missing signature timestamp")
                return null
            }
            logger.d("InnerTubeExtractor", "embedded config ready", mapOf("elapsedMs" to (System.currentTimeMillis() - start).toString()))
            val embeddedClientId = hints.playbackClientOverrideId?.let { id ->
                val manifest = PlaybackClientCatalog.findManifest(id)
                if (manifest?.request?.embedded == true) id else null
            } ?: "WEB_EMBEDDED_PLAYER"
            val hintsCopy = hints.copy(playbackClientOverrideId = embeddedClientId)
            extractWithConfig(
                videoId = videoId,
                hints = hintsCopy,
                excludedClients = excludedClients,
                clientPlaybackNonce = clientPlaybackNonce,
                config = config,
                totalStart = totalStart,
                allowConfigFallbacks = false,
                audioQuality = audioQuality,
                diagnostics = diagnostics,
                tokenWarmup = null,
            )
        } catch (e: Exception) {
            diagnostics.requestFailures.add(e)
            logger.w("InnerTubeExtractor", "embedded config unavailable", mapOf("exceptionType" to (e::class.simpleName ?: "unknown")))
            null
        }
    }

    suspend fun extractWithWebKidsFallback(
        videoId: String,
        hints: ContentHints,
        excludedClients: Set<String>,
        clientPlaybackNonce: String,
        totalStart: Long,
        audioQuality: AudioQuality,
        diagnostics: StreamResolutionContext,
    ): ExtractedStream? {
        val cached = getCachedPlayerConfig(false, System.currentTimeMillis()) ?: return null
        val config = cached.config
        logger.d("InnerTubeExtractor", "kids fallback attempted", mapOf("fallback" to "kids"))
        val hintsCopy = hints.copy(playbackClientOverrideId = "WEB_KIDS")
        return extractWithConfig(
            videoId = videoId,
            hints = hintsCopy,
            excludedClients = excludedClients,
            clientPlaybackNonce = clientPlaybackNonce,
            config = config,
            totalStart = totalStart,
            allowConfigFallbacks = false,
            audioQuality = audioQuality,
            diagnostics = diagnostics,
            tokenWarmup = null,
        )
    }

    private suspend fun extractWithWatchConfig(
        videoId: String,
        hints: ContentHints,
        excludedClients: Set<String>,
        clientPlaybackNonce: String,
        totalStart: Long,
        audioQuality: AudioQuality,
        diagnostics: StreamResolutionContext,
        tokenWarmup: Deferred<PoTokenResult?>?,
        authenticated: Boolean,
    ): ExtractedStream? {
        return try {
            extractWithCachedConfig(
                videoId = videoId,
                hints = hints,
                excludedClients = excludedClients,
                clientPlaybackNonce = clientPlaybackNonce,
                authenticated = authenticated,
                totalStart = totalStart,
                audioQuality = audioQuality,
                diagnostics = diagnostics,
                tokenWarmup = tokenWarmup,
            )
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            if (authenticated && !innerTube.hasSapCookieAuth()) {
                throw e
            }
            if (authenticated) {
                diagnostics.requestFailures.add(e)
                logger.w("InnerTubeExtractor", "authenticated watch config unavailable", mapOf("exceptionType" to (e::class.simpleName ?: "unknown")))
            }
            null
        }
    }

    suspend fun extractWithDiagnostics(
        videoId: String,
        hints: ContentHints,
        excludedClients: Set<String>,
        audioQuality: AudioQuality,
        clientPlaybackNonce: String,
        totalStart: Long,
        diagnostics: StreamResolutionContext,
        tokenWarmup: Deferred<PoTokenResult?>?,
    ): ExtractedStream {
        val overrideId = hints.playbackClientOverrideId
        logger.d("InnerTubeExtractor", "stream extraction started", mapOf("wantVideo" to "false"))

        val embeddedClientId = overrideId?.let { id ->
            val manifest = PlaybackClientCatalog.findManifest(id)
            if (manifest?.request?.embedded == true) id else null
        }
        if (embeddedClientId != null) {
            val stream = extractWithEmbeddedConfig(
                videoId = videoId,
                hints = hints,
                excludedClients = excludedClients,
                clientPlaybackNonce = clientPlaybackNonce,
                totalStart = totalStart,
                audioQuality = audioQuality,
                diagnostics = diagnostics,
            )
            if (stream != null) {
                return stream
            }
            throwExtractionFailure(hints, diagnostics)
        }

        val canProbeDirectly = overrideId == null && hints.isExplicit != true && hints.isAgeRestricted != true && hints.isUploaded != true
        val needsVisionOsProbe = canProbeDirectly && hints.isKidsContent != true && !innerTube.sessionSnapshot().visitorData.isNullOrBlank() && run {
            val strategy = clientDirector.fallbackStrategy as? ContentAwareFallbackStrategy
            val visionOsOption = PlaybackClientCatalog.find("VISIONOS_0_1")
            visionOsOption != null && visionOsOption.manifest.selectionMode == ClientSelectionMode.PROBE_ONLY &&
                strategy?.isExcluded(visionOsOption.manifest, excludedClients, emptySet(), false) == false
        }

        if (canProbeDirectly && !needsVisionOsProbe) {
            val directStream = extractWithConfig(
                videoId = videoId,
                hints = hints,
                excludedClients = excludedClients,
                clientPlaybackNonce = clientPlaybackNonce,
                config = PlayerConfig("", null, innerTube.sessionSnapshot().visitorData, null, null),
                totalStart = totalStart,
                allowConfigFallbacks = false,
                audioQuality = audioQuality,
                diagnostics = diagnostics,
                tokenWarmup = null,
            )
            if (directStream != null) {
                return directStream
            }
        }

        val preferAuth = (overrideId != null && innerTube.hasSapCookieAuth()) ||
            (innerTube.hasSapCookieAuth() && (hints.isExplicit == true || hints.isAgeRestricted == true || hints.isUploaded == true))

        var stream = try {
            extractWithWatchConfig(
                videoId = videoId,
                hints = hints,
                excludedClients = excludedClients,
                clientPlaybackNonce = clientPlaybackNonce,
                totalStart = totalStart,
                audioQuality = audioQuality,
                diagnostics = diagnostics,
                tokenWarmup = tokenWarmup,
                authenticated = preferAuth,
            )
        } catch (e: Exception) {
            if (!needsVisionOsProbe) throw e
            diagnostics.requestFailures.add(e)
            null
        }

        if (stream != null) {
            return stream
        }

        if (needsVisionOsProbe) {
            stream = extractWithConfig(
                videoId = videoId,
                hints = hints,
                excludedClients = excludedClients,
                clientPlaybackNonce = clientPlaybackNonce,
                config = PlayerConfig("", null, innerTube.sessionSnapshot().visitorData, null, null),
                totalStart = totalStart,
                allowConfigFallbacks = false,
                audioQuality = audioQuality,
                diagnostics = diagnostics,
                tokenWarmup = null,
            )
            if (stream != null) {
                return stream
            }
        }

        if (preferAuth) {
            logger.w("InnerTubeExtractor", "signed-out watch config fallback")
            stream = extractWithWatchConfig(
                videoId = videoId,
                hints = hints,
                excludedClients = excludedClients,
                clientPlaybackNonce = clientPlaybackNonce,
                totalStart = totalStart,
                audioQuality = audioQuality,
                diagnostics = diagnostics,
                tokenWarmup = tokenWarmup,
                authenticated = false,
            )
            if (stream != null) {
                return stream
            }
        } else if (innerTube.hasSapCookieAuth()) {
            logger.w("InnerTubeExtractor", "authenticated watch page retry", mapOf("authenticated" to "true"))
            stream = extractWithWatchConfig(
                videoId = videoId,
                hints = hints,
                excludedClients = excludedClients,
                clientPlaybackNonce = clientPlaybackNonce,
                totalStart = totalStart,
                audioQuality = audioQuality,
                diagnostics = diagnostics,
                tokenWarmup = tokenWarmup,
                authenticated = true,
            )
            if (stream != null) {
                return stream
            }
        }

        if (overrideId == null && hints.isUploaded != true) {
            stream = extractWithEmbeddedConfig(
                videoId = videoId,
                hints = hints,
                excludedClients = excludedClients,
                clientPlaybackNonce = clientPlaybackNonce,
                totalStart = totalStart,
                audioQuality = audioQuality,
                diagnostics = diagnostics,
            )
            if (stream != null) {
                return stream
            }
        }

        val playabilityReason = classifyPlayabilityFailures(diagnostics.failures)
        if (overrideId == null && hints.isKidsContent == null) {
            if (hints.isExplicit != true && hints.isAgeRestricted != true && hints.isUploaded != true && playabilityReason != StreamResolveException.Reason.AGE_RESTRICTED) {
                stream = extractWithWebKidsFallback(
                    videoId = videoId,
                    hints = hints,
                    excludedClients = excludedClients,
                    clientPlaybackNonce = clientPlaybackNonce,
                    totalStart = totalStart,
                    audioQuality = audioQuality,
                    diagnostics = diagnostics,
                )
                if (stream != null) {
                    return stream
                }
            }
        }

        throwExtractionFailure(hints, diagnostics)
    }

    suspend fun extract(
        videoId: String,
        hints: ContentHints = ContentHints(),
        excludedClients: Set<String> = emptySet(),
        audioQuality: AudioQuality = AudioQuality.AUTO,
        clientPlaybackNonce: String = generateClientPlaybackNonce(),
    ): ExtractedStream {
        val totalStart = System.currentTimeMillis()
        val diagnostics = StreamResolutionContext(
            if (hints.playbackClientOverrideId != null) 1 else MAX_PLAYER_REQUESTS_PER_EXTRACTION
        )
        return try {
            coroutineScope {
                val sessionSnapshot = innerTube.sessionSnapshot()
                val tokenWarmup = if (hints.isExplicit == true && hints.playbackClientOverrideId == null && !sessionSnapshot.visitorData.isNullOrBlank() && tokenProvider.getCapabilities().providers.isNotEmpty()) {
                    async {
                        withTimeoutOrNull(PO_TOKEN_PREFETCH_TIMEOUT) {
                            try {
                                tokenProvider.getPoToken(videoId, sessionSnapshot.visitorData)
                            } catch (e: CancellationException) {
                                throw e
                            } catch (_: Exception) {
                                null
                            }
                        }
                    }
                } else null

                try {
                    extractWithDiagnostics(
                        videoId = videoId,
                        hints = hints,
                        excludedClients = excludedClients,
                        audioQuality = audioQuality,
                        clientPlaybackNonce = clientPlaybackNonce,
                        totalStart = totalStart,
                        diagnostics = diagnostics,
                        tokenWarmup = tokenWarmup,
                    )
                } finally {
                    tokenWarmup?.cancel()
                }
            }
        } catch (e: StreamResolveException) {
            throw e
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            throw StreamResolveException(StreamResolveException.Reason.NETWORK, "Unable to fetch stream data from YouTube.", e, diagnostics.snapshot())
        }
    }

    suspend fun extractWithConfig(
        videoId: String,
        hints: ContentHints,
        excludedClients: Set<String>,
        clientPlaybackNonce: String,
        config: PlayerConfig,
        totalStart: Long,
        allowConfigFallbacks: Boolean = true,
        audioQuality: AudioQuality,
        diagnostics: StreamResolutionContext,
        tokenWarmup: Deferred<PoTokenResult?>? = null,
    ): ExtractedStream? {
        if (diagnostics.requestContext.getRemaining() <= 0) {
            return null
        }
        logger.d(
            "InnerTubeExtractor", "player extraction pass", mapOf(
                "signatureTimestamp" to (config.signatureTimestamp != null).toString(),
                "visitorDataPresent" to (!config.visitorData.isNullOrBlank()).toString(),
            )
        )
        val passStart = System.currentTimeMillis()
        val batch = clientDirector.fetchPlayerResponses(
            videoId = videoId,
            playerConfig = config,
            hints = hints,
            excludedClients = excludedClients,
            fastPathOnly = !allowConfigFallbacks,
            requestContext = diagnostics.requestContext,
            prewarmedToken = tokenWarmup,
        )

        diagnostics.failures.addAll(batch.failures)
        diagnostics.requestFailures.addAll(batch.requestFailures)
        diagnostics.attempts.addAll(batch.attempts)
        if (batch.playableResponses.isNotEmpty()) {
            diagnostics.hasPlayableResponse = true
        }

        logger.d(
            "InnerTubeExtractor", "player responses received", mapOf(
                "count" to batch.playableResponses.size.toString(),
                "elapsedMs" to (System.currentTimeMillis() - passStart).toString(),
            )
        )

        if (batch.playableResponses.isEmpty()) {
            logger.w("InnerTubeExtractor", "no playable clients")
            return null
        }

        for (clientResult in batch.playableResponses) {
            val playerResponse = clientResult.response
            val userAgent = clientResult.userAgent
            val clientName = clientResult.clientName
            val poToken = clientResult.streamingDataPoToken
            val bearerAuth = clientResult.bearerAuthenticated

            val clientRequiresBounded = requiresBoundedMediaRange(clientName)
            if (clientRequiresBounded && !hints.allowBoundedRange) {
                logger.d("InnerTubeExtractor", "bounded-range client skipped by request", mapOf("client" to clientName))
                continue
            }

            val streamingData = playerResponse.streamingData
            if (streamingData == null) {
                logger.w("InnerTubeExtractor", "response missing streaming data", mapOf("client" to clientName))
                continue
            }

            val trackingData = if (bearerAuth) null else toPlaybackTrackingData(playerResponse.playbackTracking, clientPlaybackNonce)
            val allFormats = (streamingData.adaptiveFormats.orEmpty() + streamingData.formats.orEmpty())

            val availableVideoHeights = allFormats.mapNotNull {
                val h = it.height
                val w = it.width
                if (h != null && w != null && h > 0) h else null
            }.distinct().sorted()

            val isLive = playerResponse.videoDetails?.isLiveContent == true

            // SABR handling
            if (clientResult.useSabr) {
                if (!hints.allowSabr) {
                    logger.d("InnerTubeExtractor", "SABR client skipped by request", mapOf("client" to clientName))
                    continue
                }
                val audioFormats = allFormats.filter { it.isAudio() }
                val bestAudio = selectBestAudioFormat(audioFormats, audioQuality, requireUrl = false)
                if (bestAudio == null) {
                    logger.d("InnerTubeExtractor", "SABR response missing audio format", mapOf("client" to clientName))
                    continue
                }

                val serverAbrUrl = streamingData.serverAbrStreamingUrl
                if (serverAbrUrl != null && N_PARAMETER_REGEX.containsMatchIn(serverAbrUrl) && !allowConfigFallbacks) {
                    logger.d("InnerTubeExtractor", "SABR transform deferred", mapOf("client" to clientName))
                    continue
                }

                var resolvedServerAbrUrl: String? = serverAbrUrl
                if (serverAbrUrl != null && N_PARAMETER_REGEX.containsMatchIn(serverAbrUrl)) {
                    val processed = cipherService.processFormats(
                        config.playerUrl,
                        listOf(bestAudio.copy(url = serverAbrUrl)),
                    )
                    resolvedServerAbrUrl = processed.firstOrNull()?.url
                }

                if (serverAbrUrl != null && N_PARAMETER_REGEX.containsMatchIn(serverAbrUrl) && resolvedServerAbrUrl == null) {
                    logger.w("InnerTubeExtractor", "SABR endpoint rejected", mapOf("client" to clientName))
                    continue
                }

                val validatedServerAbrUrl = resolvedServerAbrUrl?.let { rawUrl ->
                    runCatching {
                        val withNonce = appendClientPlaybackNonce(rawUrl, clientPlaybackNonce)
                        requireAllowedSabrUrl(withNonce)
                        withNonce
                    }.getOrNull()
                }

                if (resolvedServerAbrUrl != null && validatedServerAbrUrl == null) {
                    logger.w("InnerTubeExtractor", "SABR endpoint rejected", mapOf("client" to clientName))
                    continue
                }

                val origin = sabrRequestOrigin(clientResult.clientName)
                val sabrBootstrap = runCatching {
                    toSabrBootstrap(
                        playerResponse = playerResponse,
                        clientName = clientResult.clientId,
                        clientVersion = clientResult.clientVersion,
                        audioFormat = bestAudio,
                        poToken = clientResult.streamingDataPoToken,
                        requestUserAgent = clientResult.userAgent,
                        requestOrigin = origin,
                        serverAbrStreamingUrlOverride = validatedServerAbrUrl,
                        selectedVideoFormat = null,
                    )
                }.getOrNull()

                if (sabrBootstrap == null) {
                    logger.w(
                        "InnerTubeExtractor", "SABR bootstrap rejected", mapOf(
                            "client" to clientName,
                            "exceptionType" to "unknown",
                        )
                    )
                    continue
                }

                val expiresAt = streamingData.expiresInSeconds?.takeIf { it > 0 }?.let { seconds: Int ->
                    Instant.fromEpochMilliseconds(System.currentTimeMillis()).plus(seconds.seconds)
                }

                logger.i(
                    "InnerTubeExtractor", "SABR stream selected", mapOf(
                        "client" to clientName,
                        "profile" to clientResult.profileId,
                    )
                )

                val audioUrl = "sabr://$videoId"
                val stream = ExtractedStream(
                    videoId = videoId,
                    audioUrl = audioUrl,
                    headers = emptyMap<String, String>(),
                    loudnessDb = playerResponse.playerConfig?.audioConfig?.loudnessDb ?: bestAudio.loudnessDb,
                    expiresAt = expiresAt,
                    contentLengthBytes = bestAudio.contentLength,
                    itag = bestAudio.itag,
                    mimeType = bestAudio.mimeType?.substringBefore(';')?.trim(),
                    codecs = bestAudio.mimeType?.let { extractCodecs(it) },
                    bitrate = bestAudio.bitrate,
                    sampleRate = bestAudio.audioSampleRate,
                    clientName = clientResult.clientName,
                    profileId = clientResult.profileId,
                    requireBoundedRange = false,
                    rangeChunkSizeBytes = 1048576L,
                    useRangeChunks = false,
                    playbackTracking = trackingData,
                    streamDiagnostics = diagnostics.snapshot(),
                    sabrBootstrap = sabrBootstrap,
                    availableVideoHeights = availableVideoHeights,
                )
                withResponseMetadata(stream, playerResponse)
                return stream
            }

            // HLS stream handling
            val rawHlsUrl = streamingData.hlsManifestUrl
            val hlsUrl = rawHlsUrl?.let { withPoToken(it, poToken)?.let { u -> appendClientPlaybackNonce(u, clientPlaybackNonce) } }

            val hasVideoFormats = allFormats.any { it.width != null }
            val allowHls = hints.allowHls && hlsUrl != null && isAllowedHlsUrl(hlsUrl) &&
                (isLive || allFormats.isEmpty() || clientName == "TVHTML5_SIMPLY")

            if (allowHls) {
                logger.i(
                    "InnerTubeExtractor", "HLS stream selected", mapOf(
                        "client" to clientName,
                        "profile" to clientResult.profileId,
                    )
                )
                val isUploaded = hints.isUploaded == true
                val authHeaders = isUploaded && !bearerAuth
                val headers = buildHeaders(clientName, userAgent, hlsUrl, authHeaders)
                val stream = ExtractedStream(
                    videoId = videoId,
                    audioUrl = hlsUrl,
                    headers = headers,
                    loudnessDb = playerResponse.playerConfig?.audioConfig?.loudnessDb,
                    expiresAt = null,
                    contentLengthBytes = null,
                    itag = 96,
                    mimeType = "application/x-mpegURL",
                    codecs = null,
                    bitrate = null,
                    sampleRate = null,
                    clientName = clientName,
                    profileId = clientResult.profileId,
                    requireBoundedRange = false,
                    rangeChunkSizeBytes = mediaRangeChunkSize(clientName),
                    useRangeChunks = false,
                    playbackTracking = trackingData,
                    streamDiagnostics = diagnostics.snapshot(),
                    videoUrl = hlsUrl,
                    availableVideoHeights = availableVideoHeights,
                )
                withResponseMetadata(stream, playerResponse)
                return stream
            }

            // Progressive / Dash formats handling
            val availableItags = allFormats.asSequence().map { it.itag }.toSet()
            logger.d(
                "InnerTubeExtractor", "format inventory", mapOf(
                    "client" to clientName,
                    "formatCount" to allFormats.size.toString(),
                )
            )

            // Direct playable formats without deciphering
            val readyAudioFormats = allFormats.filter { format ->
                format.width == null && !format.url.isNullOrBlank() && availableItags.contains(format.itag)
            }
            val bestDirectAudio = selectBestAudioFormat(readyAudioFormats, audioQuality)

            val cipherAudioFormats = allFormats.filter { format ->
                format.isAudio() && (!format.url.isNullOrBlank() || !format.signatureCipher.isNullOrBlank() || !format.cipher.isNullOrBlank())
            }
            val bestCipherAudioCandidate = selectBestAudioFormat(cipherAudioFormats, audioQuality, requireUrl = false)

            val isDirectAudioOptimal = bestDirectAudio != null && bestDirectAudio.itag == bestCipherAudioCandidate?.itag
            val bestDirectVideo = selectBestVideoFormat(2160, allFormats)
            val usableDirectVideo = bestDirectVideo?.takeIf { hasReadyVideoUrl(it) }

            if (bestDirectAudio != null && isDirectAudioOptimal) {
                var audioUrl = bestDirectAudio.url.orEmpty()
                audioUrl = withPoToken(audioUrl, poToken)
                audioUrl = appendClientPlaybackNonce(audioUrl, clientPlaybackNonce)

                if (isAllowedMediaUrl(audioUrl)) {
                    var videoUrl: String? = usableDirectVideo?.url
                    if (videoUrl != null) {
                        videoUrl = withPoToken(videoUrl, poToken)
                        videoUrl = appendClientPlaybackNonce(videoUrl, clientPlaybackNonce)
                    }

                    if (!N_PARAMETER_REGEX.containsMatchIn(audioUrl) && (videoUrl == null || !N_PARAMETER_REGEX.containsMatchIn(videoUrl))) {
                        val expireSeconds = extractExpire(audioUrl)
                        val expiresAt = expireSeconds?.let { sec: Long -> Instant.fromEpochSeconds(sec, 0) }

                        val isUploaded = hints.isUploaded == true
                        val authHeaders = isUploaded && !bearerAuth
                        val headers = buildHeaders(clientName, userAgent, audioUrl, authHeaders)

                        val resolvedContentLength = resolveBoundedContentLength(
                            bestDirectAudio.contentLength,
                            audioUrl,
                            headers,
                            clientRequiresBounded,
                        )

                        if (!clientRequiresBounded || resolvedContentLength != null) {
                            val stream = ExtractedStream(
                                videoId = videoId,
                                audioUrl = audioUrl,
                                headers = headers,
                                loudnessDb = playerResponse.playerConfig?.audioConfig?.loudnessDb ?: bestDirectAudio.loudnessDb,
                                expiresAt = expiresAt,
                                contentLengthBytes = resolvedContentLength,
                                itag = bestDirectAudio.itag,
                                mimeType = bestDirectAudio.mimeType?.substringBefore(';')?.trim(),
                                codecs = bestDirectAudio.mimeType?.let { extractCodecs(it) },
                                bitrate = bestDirectAudio.bitrate,
                                sampleRate = bestDirectAudio.audioSampleRate,
                                clientName = clientName,
                                profileId = clientResult.profileId,
                                requireBoundedRange = clientRequiresBounded,
                                rangeChunkSizeBytes = mediaRangeChunkSize(clientName),
                                useRangeChunks = usesChunkedMediaRanges(clientName),
                                playbackTracking = trackingData,
                                streamDiagnostics = diagnostics.snapshot(),
                                videoUrl = videoUrl,
                                videoWidth = usableDirectVideo?.width,
                                videoHeight = usableDirectVideo?.height,
                                videoMimeType = usableDirectVideo?.mimeType?.substringBefore(';')?.trim(),
                                videoCodecs = usableDirectVideo?.mimeType?.let { extractCodecs(it) },
                                videoBitrate = usableDirectVideo?.bitrate,
                                videoItag = usableDirectVideo?.itag,
                                videoContentLengthBytes = usableDirectVideo?.contentLength,
                                availableVideoHeights = availableVideoHeights,
                            )
                            withResponseMetadata(stream, playerResponse)
                            return stream
                        } else {
                            logger.d("InnerTubeExtractor", "bounded media skipped", mapOf("client" to clientName))
                        }
                    }
                }
            }

            // Needs cipher processing
            val formatsToProcess = listOfNotNull<PlayerResponse.StreamingData.Format>(bestCipherAudioCandidate, bestDirectVideo)
            val cipherStart = System.currentTimeMillis()
            var processedFormats = cipherService.processFormats(config.playerUrl, formatsToProcess)

            logger.d(
                "InnerTubeExtractor", "cipher processing completed", mapOf(
                    "client" to clientName,
                    "requestedCount" to formatsToProcess.size.toString(),
                    "processedCount" to processedFormats.size.toString(),
                    "elapsedMs" to (System.currentTimeMillis() - cipherStart).toString(),
                )
            )

            val decipheredAudios = processedFormats.filter { it.isAudio() && !it.url.isNullOrBlank() }
            val bestAudioMatching = decipheredAudios.filter { availableItags.contains(it.itag) }.ifEmpty { decipheredAudios }
            var bestDecipheredAudio = selectBestAudioFormat(bestAudioMatching, audioQuality)

            // If audio wasn't found in processed subset, attempt processing all remaining audio formats
            if (bestDecipheredAudio == null && cipherAudioFormats.size != formatsToProcess.size) {
                processedFormats = cipherService.processFormats(config.playerUrl, cipherAudioFormats)
                val allDecipheredAudios = processedFormats.filter { it.isAudio() && !it.url.isNullOrBlank() }
                val allMatching = allDecipheredAudios.filter { availableItags.contains(it.itag) }.ifEmpty { allDecipheredAudios }
                bestDecipheredAudio = selectBestAudioFormat(allMatching, audioQuality)
            }

            if (bestDecipheredAudio == null) {
                logger.w("InnerTubeExtractor", "no playable audio formats after cipher processing", mapOf("client" to clientName))
                continue
            }

            var audioUrl = bestDecipheredAudio.url.orEmpty()
            audioUrl = withPoToken(audioUrl, poToken)
            audioUrl = appendClientPlaybackNonce(audioUrl, clientPlaybackNonce)

            if (!isAllowedMediaUrl(audioUrl)) {
                logger.w("InnerTubeExtractor", "disallowed media url after cipher processing", mapOf("client" to clientName))
                continue
            }

            val decipheredVideo = processedFormats.firstOrNull { it.width != null && hasReadyVideoUrl(it) }
            var videoUrl: String? = decipheredVideo?.url
            if (videoUrl != null) {
                videoUrl = withPoToken(videoUrl, poToken)
                videoUrl = appendClientPlaybackNonce(videoUrl, clientPlaybackNonce)
            }

            val expireSeconds = extractExpire(audioUrl)
            val expiresAt = expireSeconds?.let { sec: Long -> Instant.fromEpochSeconds(sec, 0) }

            val isUploaded = hints.isUploaded == true
            val authHeaders = isUploaded && !bearerAuth
            val headers = buildHeaders(clientName, userAgent, audioUrl, authHeaders)

            val resolvedContentLength = resolveBoundedContentLength(
                bestDecipheredAudio.contentLength,
                audioUrl,
                headers,
                clientRequiresBounded,
            )

            if (clientRequiresBounded && resolvedContentLength == null) {
                logger.d("InnerTubeExtractor", "bounded media skipped", mapOf("client" to clientName))
                continue
            }

            val stream = ExtractedStream(
                videoId = videoId,
                audioUrl = audioUrl,
                headers = headers,
                loudnessDb = playerResponse.playerConfig?.audioConfig?.loudnessDb ?: bestDecipheredAudio.loudnessDb,
                expiresAt = expiresAt,
                contentLengthBytes = resolvedContentLength,
                itag = bestDecipheredAudio.itag,
                mimeType = bestDecipheredAudio.mimeType?.substringBefore(';')?.trim(),
                codecs = bestDecipheredAudio.mimeType?.let { extractCodecs(it) },
                bitrate = bestDecipheredAudio.bitrate,
                sampleRate = bestDecipheredAudio.audioSampleRate,
                clientName = clientName,
                profileId = clientResult.profileId,
                requireBoundedRange = clientRequiresBounded,
                rangeChunkSizeBytes = mediaRangeChunkSize(clientName),
                useRangeChunks = usesChunkedMediaRanges(clientName),
                playbackTracking = trackingData,
                streamDiagnostics = diagnostics.snapshot(),
                videoUrl = videoUrl,
                videoWidth = decipheredVideo?.width,
                videoHeight = decipheredVideo?.height,
                videoMimeType = decipheredVideo?.mimeType?.substringBefore(';')?.trim(),
                videoCodecs = decipheredVideo?.mimeType?.let { extractCodecs(it) },
                videoBitrate = decipheredVideo?.bitrate,
                videoItag = decipheredVideo?.itag,
                videoContentLengthBytes = decipheredVideo?.contentLength,
                availableVideoHeights = availableVideoHeights,
            )
            withResponseMetadata(stream, playerResponse)
            return stream
        }

        return null
    }
}
