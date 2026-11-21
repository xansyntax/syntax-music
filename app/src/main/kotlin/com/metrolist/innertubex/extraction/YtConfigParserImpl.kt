package com.metrolist.innertubex.extraction

import com.metrolist.innertubex.InnerTube
import com.metrolist.innertubex.InnerTubeLogger
import com.metrolist.innertubex.cipher.RemotePlayerConfigStore
import com.metrolist.innertubex.cipher.getTextWithoutRedirects
import com.metrolist.innertubex.d
import com.metrolist.innertubex.w
import io.ktor.client.HttpClient
import io.ktor.client.plugins.timeout
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.http.URLBuilder
import io.ktor.http.Url
import io.ktor.http.isSuccess
import io.ktor.http.takeFrom
import java.util.concurrent.CancellationException

class YtConfigParserImpl(
    private val httpClient: HttpClient,
    val innerTube: InnerTube,
    val remotePlayerConfigStore: RemotePlayerConfigStore? = null,
    val logger: InnerTubeLogger = InnerTubeLogger.NONE,
) {
    companion object {
        val REDIRECT_STATUS_CODES: Set<Int> = setOf(301, 302, 303, 307, 308)
        val SAFE_VIDEO_ID: Regex = Regex("[A-Za-z0-9_-]{1,64}")
        val EMBED_PATH: Regex = Regex("/embed/[A-Za-z0-9_-]{1,64}")
        val PLAYER_PATH: Regex = Regex("/s/player/[A-Za-z0-9_-]+/.+\\.js")
        val KEYED_PLAYER_URL_PATTERNS: List<Regex> = listOf(
            Regex("\"PLAYER_JS_URL\":\"([^\"]+)\""),
            Regex("\"jsUrl\":\"([^\"]+)\"")
        )
        val LOOSE_PLAYER_URL_PATTERN: Regex = Regex("(?<![A-Za-z0-9:/])(/s/player/[^\"'\\\\]+/[^\"'\\\\]*\\.js[^\"'\\\\]*)")
        val PLAYER_ID_REGEX: Regex = Regex("/s/player/([a-zA-Z0-9_-]+)/")
        val STS_PATTERNS: List<Regex> = listOf(
            Regex("(?:signatureTimestamp|sts)\"?\\s*:\\s*([0-9]{5})"),
            Regex("\"STS\":\\s*([0-9]{5})")
        )
        val CLIENT_VERSION_REGEX: Regex = Regex("\"INNERTUBE_CLIENT_VERSION\"\\s*:\\s*\"([^\"]+)\"")
        val ENCRYPTED_HOST_FLAGS_REGEX: Regex = Regex("\"encryptedHostFlags\"\\s*:\\s*\"([^\"]+)\"")
        val VISITOR_DATA_REGEX: Regex = Regex("\"visitorData\"\\s*:\\s*\"([^\"]+)\"")

        fun approvedYouTubeHost(host: String): Boolean {
            return host == "youtube.com" ||
                    host.endsWith(".youtube.com") ||
                    host == "youtube-nocookie.com" ||
                    host.endsWith(".youtube-nocookie.com")
        }

        fun extractPlayerId(playerUrl: String): String? {
            val normalized = playerUrl.replace("\\/", "/")
            val match = PLAYER_ID_REGEX.find(normalized) ?: return null
            return match.groupValues.getOrNull(1)
        }

        fun extractSignatureTimestamp(htmlOrJs: String): Int? {
            return STS_PATTERNS.asSequence().mapNotNull { pattern ->
                pattern.find(htmlOrJs)?.groupValues?.getOrNull(1)?.toIntOrNull()
            }.firstOrNull()
        }

        fun validatePlayerUrl(url: String): String? {
            val parsedUrl = try {
                Url(url)
            } catch (t: Throwable) {
                null
            } ?: return null

            return if (parsedUrl.protocol.name == "https" &&
                parsedUrl.port == 443 &&
                approvedYouTubeHost(parsedUrl.host) &&
                parsedUrl.user == null &&
                parsedUrl.password == null &&
                PLAYER_PATH.matches(parsedUrl.encodedPath)
            ) {
                parsedUrl.toString()
            } else null
        }
    }

    fun extractPlayerUrl(html: String): String? {
        val keyedCandidates = KEYED_PLAYER_URL_PATTERNS.asSequence().mapNotNull { regex ->
            regex.find(html)?.groupValues?.getOrNull(1)
                ?.replace("\\/", "/")
                ?.replace("\\u0026", "&")
        }
        val looseCandidates = sequence {
            val unescaped = html.replace("\\/", "/").replace("\\u0026", "&")
            LOOSE_PLAYER_URL_PATTERN.find(unescaped)?.groupValues?.getOrNull(1)?.let { yield(it) }
        }
        return (keyedCandidates + looseCandidates)
            .mapNotNull { candidate ->
                var resolved = candidate
                if (!resolved.startsWith("http")) {
                    if (!resolved.startsWith("/")) {
                        resolved = "/$resolved"
                    }
                    resolved = "https://www.youtube.com$resolved"
                }
                validatePlayerUrl(resolved)
            }
            .firstOrNull()
    }

    suspend fun fetchConfigPage(
        authenticated: Boolean,
        urlString: String,
        contextDesc: String,
        referer: String?,
    ): PlayerConfig? {
        val cookieHeader = if (authenticated) {
            val rawCookie = innerTube.session.get().cookie
            if (rawCookie != null) {
                val filtered = rawCookie.split(';')
                    .map { it.trim() }
                    .filter { it.isNotEmpty() && !it.startsWith("PREF=", ignoreCase = true) }
                    .joinToString("; ")
                filtered.ifEmpty { null }
            } else null
        } else null

        var cachedPlayerUrl: String? = null
        var cachedSts: Int? = null

        val isConfigComplete: suspend (String) -> Boolean = { chunk ->
            val playerUrl = extractPlayerUrl(chunk)
            if (playerUrl == null) {
                false
            } else {
                val visitorData = VISITOR_DATA_REGEX.find(chunk)?.groupValues?.getOrNull(1)
                if (visitorData == null) {
                    false
                } else {
                    val clientVersion = CLIENT_VERSION_REGEX.find(chunk)?.groupValues?.getOrNull(1)
                    if (clientVersion == null) {
                        false
                    } else if (contextDesc == "embed" && ENCRYPTED_HOST_FLAGS_REGEX.find(chunk)?.groupValues?.getOrNull(1) == null) {
                        false
                    } else if (extractSignatureTimestamp(chunk) != null) {
                        true
                    } else {
                        if (cachedPlayerUrl != playerUrl) {
                            cachedPlayerUrl = playerUrl
                            cachedSts = remotePlayerConfigStore?.getSignatureTimestamp(playerUrl)
                        }
                        cachedSts != null
                    }
                }
            }
        }

        val text = try {
            getText(
                url = Url(urlString),
                maxBytes = 4194304,
                stopWhen = isConfigComplete
            ) {
                header(HttpHeaders.UserAgent, "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0")
                header(HttpHeaders.Accept, "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                if (referer != null) {
                    header(HttpHeaders.Referrer, referer)
                }
                if (cookieHeader != null) {
                    header(HttpHeaders.Cookie, cookieHeader)
                }
                header(HttpHeaders.AcceptLanguage, innerTube.session.get().locale.acceptLanguageHeader())
                timeout {
                    requestTimeoutMillis = 10000L
                    connectTimeoutMillis = 10000L
                    socketTimeoutMillis = 10000L
                }
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            if (cookieHeader != null) {
                val exType = e::class.simpleName ?: "Exception"
                logger.w("YtConfigParser", "authenticated config page unavailable; retrying without cookies", mapOf("exceptionType" to exType))
                getText(
                    url = Url(urlString),
                    maxBytes = 4194304,
                    stopWhen = isConfigComplete
                ) {
                    header(HttpHeaders.UserAgent, "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0")
                    header(HttpHeaders.Accept, "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                    if (referer != null) {
                        header(HttpHeaders.Referrer, referer)
                    }
                    header(HttpHeaders.AcceptLanguage, innerTube.session.get().locale.acceptLanguageHeader())
                    timeout {
                        requestTimeoutMillis = 10000L
                        connectTimeoutMillis = 10000L
                        socketTimeoutMillis = 10000L
                    }
                }
            } else {
                throw e
            }
        }

        val playerUrl = extractPlayerUrl(text) ?: fetchIframePlayerUrl() ?: error("Unable to parse YouTube player JavaScript URL")
        val sts = extractSignatureTimestamp(text)
            ?: remotePlayerConfigStore?.getSignatureTimestamp(playerUrl)
            ?: fetchPlayerSignatureTimestamp(playerUrl)

        val visitorData = VISITOR_DATA_REGEX.find(text)?.groupValues?.getOrNull(1)
        val encryptedHostFlags = if (contextDesc == "embed") {
            ENCRYPTED_HOST_FLAGS_REGEX.find(text)?.groupValues?.getOrNull(1)
        } else null

        logger.d(
            "YtConfigParser",
            "fetchConfig parsed page=$contextDesc htmlSize=${text.length} hasSts=${sts != null} hasVisitorData=${visitorData != null} hasEncryptedHostFlags=${encryptedHostFlags != null}"
        )

        val clientVersion = CLIENT_VERSION_REGEX.find(text)?.groupValues?.getOrNull(1)

        return PlayerConfig(
            playerUrl = playerUrl,
            signatureTimestamp = sts,
            visitorData = visitorData,
            clientVersion = clientVersion,
            encryptedHostFlags = encryptedHostFlags
        )
    }

    suspend fun fetchConfig(videoId: String, authenticated: Boolean): PlayerConfig? {
        return try {
            require(SAFE_VIDEO_ID.matches(videoId)) { "Invalid video ID" }
            fetchConfigPage(
                authenticated = authenticated,
                urlString = "https://www.youtube.com/watch?v=$videoId&bpctr=9999999999&has_verified=1",
                contextDesc = "watch",
                referer = null
            )
        } catch (e: IllegalStateException) {
            fetchEmbeddedConfig(videoId)
        }
    }

    suspend fun fetchEmbeddedConfig(videoId: String): PlayerConfig? {
        require(SAFE_VIDEO_ID.matches(videoId)) { "Invalid video ID" }
        return fetchConfigPage(
            authenticated = false,
            urlString = "https://www.youtube.com/embed/$videoId?html5=1",
            contextDesc = "embed",
            referer = "https://www.reddit.com/"
        )
    }

    suspend fun fetchIframePlayerUrl(): String? {
        val text = try {
            getText(
                url = Url("https://www.youtube.com/iframe_api"),
                maxBytes = 1048576,
                configure = {
                    header(HttpHeaders.UserAgent, "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0")
                    timeout {
                        requestTimeoutMillis = 5000L
                        connectTimeoutMillis = 5000L
                        socketTimeoutMillis = 5000L
                    }
                }
            )
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            val exType = e::class.simpleName ?: "Exception"
            logger.d("YtConfigParser", "iframe player URL unavailable type=$exType")
            return null
        }
        val playerId = extractPlayerId(text) ?: return null
        return validatePlayerUrl("https://www.youtube.com/s/player/$playerId/player_ias.vflset/en_GB/base.js")
    }

    suspend fun fetchPlayerSignatureTimestamp(playerUrl: String): Int? {
        val text = try {
            getText(
                url = Url(playerUrl),
                maxBytes = 8388608,
                configure = {
                    header(HttpHeaders.UserAgent, "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0")
                    timeout {
                        requestTimeoutMillis = 5000L
                        connectTimeoutMillis = 5000L
                        socketTimeoutMillis = 5000L
                    }
                }
            )
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            val exType = e::class.simpleName ?: "Exception"
            logger.d("YtConfigParser", "player JS timestamp unavailable type=$exType")
            return null
        }
        return extractSignatureTimestamp(text)
    }

    suspend fun getText(
        url: Url,
        maxBytes: Int,
        stopWhen: (suspend (String) -> Boolean)? = null,
        configure: (HttpRequestBuilder.() -> Unit)? = null,
    ): String {
        var currentUrl = url
        for (redirectCount in 0 until 4) {
            val response = getTextWithoutRedirects(
                httpClient = httpClient,
                url = currentUrl,
                maxBytes = maxBytes,
                stopWhen = stopWhen,
                configure = configure
            )
            if (response.status.isSuccess()) {
                return checkNotNull(response.body) { "Required value was null." }
            }
            val location = response.headers[HttpHeaders.Location]
            val redirectUrl = if (location != null && REDIRECT_STATUS_CODES.contains(response.status.value) && redirectCount < 3) {
                try {
                    val nextUrl = URLBuilder(currentUrl).takeFrom(location).build()
                    if (nextUrl.protocol.name == "https" &&
                        nextUrl.port == 443 &&
                        approvedYouTubeHost(nextUrl.host) &&
                        nextUrl.user == null &&
                        nextUrl.password == null &&
                        (nextUrl.encodedPath == "/watch" ||
                                nextUrl.encodedPath == "/iframe_api" ||
                                EMBED_PATH.matches(nextUrl.encodedPath) ||
                                PLAYER_PATH.matches(nextUrl.encodedPath))
                    ) {
                        nextUrl
                    } else null
                } catch (t: Throwable) {
                    null
                }
            } else null

            if (redirectUrl != null) {
                currentUrl = redirectUrl
            } else {
                error("HTTP ${response.status.value}")
            }
        }
        error("Too many redirects")
    }
}
