package com.metrolist.shazamkit

import com.metrolist.shazamkit.models.RecognitionResult
import com.metrolist.shazamkit.models.ShazamRequestJson
import com.metrolist.shazamkit.models.ShazamResponseJson
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.serialization.json.Json
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap
import kotlin.random.Random

object Shazam {
    private const val MIN_REQUEST_INTERVAL_MS = 1500L
    private const val CACHE_TTL_MS = 5 * 60 * 1000L

    private var lastRequestTime = 0L
    private val requestMutex = Mutex()
    private val resultCache = ConcurrentHashMap<String, CachedResult>()

    private data class CachedResult(
        val timestamp: Long,
        val result: RecognitionResult,
    )

    private val userAgents = listOf(
        "Dalvik/2.1.0 (Linux; U; Android 5.0.2; VS980 4G Build/LRX22G)",
        "Dalvik/1.6.0 (Linux; U; Android 4.4.2; SM-T210 Build/KOT49H)",
        "Dalvik/2.1.0 (Linux; U; Android 5.1.1; SM-P905V Build/LMY47X)",
        "Dalvik/2.1.0 (Linux; U; Android 6.0.1; SM-G920F Build/MMB29K)",
        "Dalvik/2.1.0 (Linux; U; Android 5.0; SM-G900F Build/LRX21T)",
    )

    private val timezones = listOf(
        "Europe/Paris",
        "Europe/London",
        "America/New_York",
        "America/Los_Angeles",
        "Asia/Tokyo",
        "Asia/Dubai",
    )

    private val client by lazy {
        HttpClient(OkHttp) {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                    }
                )
            }
        }
    }

    private suspend fun enforceRateLimit() {
        requestMutex.withLock {
            val elapsed = System.currentTimeMillis() - lastRequestTime
            if (elapsed < MIN_REQUEST_INTERVAL_MS) {
                delay(MIN_REQUEST_INTERVAL_MS - elapsed)
            }
            lastRequestTime = System.currentTimeMillis()
        }
    }

    suspend fun recognize(
        signatureUri: String,
        sampleDurationMs: Long,
    ): Result<RecognitionResult> = runCatching {
        val cacheKey = signatureUri.hashCode().toString()
        resultCache[cacheKey]?.let { cached ->
            if (System.currentTimeMillis() - cached.timestamp < CACHE_TTL_MS) {
                return@runCatching cached.result
            }
        }

        var lastError: Throwable? = null
        repeat(3) { attempt ->
            try {
                enforceRateLimit()
                val res = performRecognition(signatureUri, sampleDurationMs)
                resultCache[cacheKey] = CachedResult(System.currentTimeMillis(), res)
                return@runCatching res
            } catch (e: Exception) {
                lastError = e
                if (attempt < 2) delay(1000L * (attempt + 1))
            }
        }
        throw lastError ?: IllegalStateException("Recognition failed after 3 attempts")
    }

    private suspend fun performRecognition(
        signatureUri: String,
        sampleDurationMs: Long,
    ): RecognitionResult {
        val now = System.currentTimeMillis()
        val deviceId = UUID.randomUUID().toString().uppercase()
        val sessionId = UUID.randomUUID().toString()
        val url = "https://amp.shazam.com/discovery/v5/en/US/android/-/tag/$deviceId/$sessionId"

        val body = ShazamRequestJson(
            geolocation = ShazamRequestJson.Geolocation(
                altitude = Random.nextDouble(100.0, 500.0),
                latitude = Random.nextDouble(-60.0, 60.0),
                longitude = Random.nextDouble(-180.0, 180.0),
            ),
            signature = ShazamRequestJson.Signature(
                samplems = sampleDurationMs,
                timestamp = now,
                uri = signatureUri,
            ),
            timestamp = now,
            timezone = timezones.random(),
        )

        val response = client.post(url) {
            parameter("sync", "true")
            parameter("webv3", "true")
            parameter("sampling", "true")
            parameter("connected", "")
            parameter("shazamapiversion", "v3")
            parameter("sharehub", "true")
            parameter("video", "v3")
            header(HttpHeaders.UserAgent, userAgents.random())
            header(HttpHeaders.ContentLanguage, "en_US")
            contentType(ContentType.Application.Json)
            setBody(body)
        }

        if (!response.status.isSuccess()) {
            throw IllegalStateException("Shazam HTTP ${response.status.value}")
        }

        val parsed = response.body<ShazamResponseJson>()
        val track = parsed.track ?: throw NoSuchElementException("No track matched")
        val metadata = track.sections?.flatMap { it.metadata.orEmpty() }.orEmpty()
        val lyrics = track.sections?.firstOrNull { it.type.equals("LYRICS", ignoreCase = true) }?.text
        val appleMusicUrl = track.hub?.options?.firstOrNull { it.providername.equals("applemusic", true) }
            ?.actions?.firstOrNull()?.uri
        val spotifyUrl = track.hub?.providers?.firstOrNull { it.type.equals("SPOTIFY", true) }
            ?.actions?.firstOrNull()?.uri

        return RecognitionResult(
            trackId = track.key ?: UUID.randomUUID().toString(),
            title = track.title.orEmpty(),
            artist = track.subtitle.orEmpty(),
            album = metadata.firstOrNull { it.title.equals("Album", true) }?.text,
            coverArtUrl = track.images?.coverart,
            coverArtHqUrl = track.images?.coverarthq ?: track.images?.coverart,
            genre = track.genres?.primary,
            releaseDate = metadata.firstOrNull { it.title.equals("Released", true) }?.text,
            label = metadata.firstOrNull { it.title.equals("Label", true) }?.text,
            lyrics = lyrics,
            shazamUrl = track.url,
            appleMusicUrl = appleMusicUrl,
            spotifyUrl = spotifyUrl,
            isrc = track.isrc,
            youtubeVideoId = null,
        )
    }
}
