package com.metrolist.paxsenix

import android.content.Context
import com.metrolist.paxsenix.models.AppleMusicSearchResponse
import com.metrolist.paxsenix.models.LyricsResponse
import com.metrolist.paxsenix.models.SearchResult
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.serialization.json.Json
import java.net.URLEncoder
import java.util.Locale
import kotlin.math.abs

object Paxsenix {
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    @Volatile
    private var client: HttpClient? = null

    @Volatile
    private var appleTokenManager: AppleTokenManager? = null

    private var appVersion: String = "Unknown"

    private class AppleTokenManager(private val httpClient: HttpClient) {
        private val mutex = Mutex()
        @Volatile
        private var cachedToken: String? = null

        suspend fun getToken(): String = mutex.withLock {
            cachedToken?.let { return it }
            val homeHtml = httpClient.get("https://music.apple.com/us/browse") {
                header(HttpHeaders.UserAgent, "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:95.0) Gecko/20100101 Firefox/95.0")
            }.bodyAsText()
            val jsPath = Regex("/assets/index[^\"']+\\.js").find(homeHtml)?.value
                ?: throw IllegalStateException("Apple Music bundle not found")
            val jsText = httpClient.get("https://music.apple.com$jsPath") {
                header(HttpHeaders.UserAgent, "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:95.0) Gecko/20100101 Firefox/95.0")
            }.bodyAsText()
            val token = Regex("eyJhbGciOiJFUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IldlYlBsYXlLaWQifQ\\.[A-Za-z0-9_-]+\\.[A-Za-z0-9_-]+").find(jsText)?.value
                ?: throw IllegalStateException("Apple Music bearer token not found")
            cachedToken = token
            token
        }

        fun invalidate() {
            cachedToken = null
        }
    }

    fun init(context: Context) {
        if (client != null) return
        synchronized(this) {
            if (client != null) return
            appVersion = runCatching {
                context.packageManager.getPackageInfo(context.getPackageName(), 0).versionName ?: "Unknown"
            }.getOrDefault("Unknown")
            client = HttpClient(OkHttp) {
                install(ContentNegotiation) { json(json) }
                defaultRequest {
                    url("https://lyrics.paxsenix.org")
                    header(HttpHeaders.UserAgent, "Metrolist/$appVersion")
                }
                expectSuccess = true
            }
        }
    }

    private fun requireClient(): HttpClient =
        client ?: throw IllegalStateException("Paxsenix not initialized. Call Paxsenix.init(context) first.")

    private fun getTokenManager(): AppleTokenManager {
        appleTokenManager?.let { return it }
        return synchronized(this) {
            appleTokenManager ?: AppleTokenManager(requireClient()).also { appleTokenManager = it }
        }
    }

    suspend fun search(query: String): List<SearchResult> = runCatching {
        val manager = getTokenManager()
        val firstTry = runCatching { searchWithToken(manager.getToken(), query) }
        firstTry.getOrElse {
            manager.invalidate()
            searchWithToken(manager.getToken(), query)
        }
    }.getOrDefault(emptyList())

    private suspend fun searchWithToken(token: String, query: String): List<SearchResult> {
        val encoded = URLEncoder.encode(query, "UTF-8")
        val url = "https://amp-api.music.apple.com/v1/catalog/us/search?term=$encoded&types=songs&limit=25&l=en-US&platform=web&format[resources]=map&include[songs]=artists&extend=artistUrl"
        val raw = requireClient().get(url) {
            header(HttpHeaders.Authorization, "Bearer $token")
            header(HttpHeaders.Origin, "https://music.apple.com")
            header(HttpHeaders.Referrer, "https://music.apple.com/")
            header(HttpHeaders.UserAgent, "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:95.0) Gecko/20100101 Firefox/95.0")
            header(HttpHeaders.Accept, "application/json")
            header(HttpHeaders.AcceptLanguage, "en-US,en;q=0.5")
            header("x-apple-renewal", "true")
        }.bodyAsText()

        val parsed = json.decodeFromString<AppleMusicSearchResponse>(raw)
        val songIds = parsed.results.songs?.data.orEmpty().map { it.id }
        val songMap = parsed.resources?.songs.orEmpty()
        return songIds.mapNotNull { id ->
            val attr = songMap[id]?.attributes ?: return@mapNotNull null
            SearchResult(
                id = id,
                songName = attr.name,
                trackName = attr.name,
                artistName = attr.artistName,
                albumName = attr.albumName,
                duration = attr.durationInMillis?.div(1000)?.toInt(),
                artwork = attr.artwork?.url,
            )
        }
    }

    suspend fun fetchLyricsForTrack(trackId: String): Result<String> = runCatching {
        val response = requireClient().get("/apple-music/lyrics") {
            parameter("id", trackId)
        }.body<LyricsResponse>()

        response.elrcMultiPerson?.takeIf { it.isNotBlank() }
            ?: response.elrc?.takeIf { it.isNotBlank() }
            ?: response.plain?.takeIf { it.isNotBlank() }
            ?: buildString {
                for (line in response.content) {
                    val mins = (line.timestamp / 1000) / 60
                    val secs = (line.timestamp / 1000) % 60
                    val centis = (line.timestamp % 1000) / 10
                    val text = line.text.joinToString(" ") { it.text }.trim()
                    if (text.isNotBlank()) {
                        append(String.format(Locale.US, "[%02d:%02d.%02d]%s\n", mins, secs, centis, text))
                    }
                }
            }.trim().takeIf { it.isNotBlank() }
            ?: throw IllegalStateException("Lyrics unavailable")
    }

    suspend fun getLyrics(
        title: String,
        artist: String,
        duration: Int,
        album: String? = null,
    ): Result<String> = runCatching {
        val candidates = search("$artist $title")
        val best = candidates.minByOrNull { item ->
            if (duration > 0 && item.duration != null) abs(item.duration - duration) else 0
        } ?: throw IllegalStateException("No matching track on Apple Music")
        fetchLyricsForTrack(best.id).getOrThrow()
    }

    suspend fun getAllLyrics(
        title: String,
        artist: String,
        duration: Int,
        callback: (String) -> Unit,
    ) {
        runCatching {
            search("$artist $title")
                .filter { duration <= 0 || it.duration == null || abs(it.duration - duration) <= 10 }
                .take(5)
                .forEach { candidate ->
                    fetchLyricsForTrack(candidate.id).getOrNull()?.let(callback)
                }
        }
    }
}
