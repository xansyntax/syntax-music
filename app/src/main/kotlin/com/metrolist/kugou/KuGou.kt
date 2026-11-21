package com.metrolist.kugou

import android.util.Base64
import com.metrolist.kugou.models.DownloadLyricsResponse
import com.metrolist.kugou.models.Keyword
import com.metrolist.kugou.models.SearchLyricsResponse
import com.metrolist.kugou.models.SearchSongResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.ContentType
import io.ktor.http.encodeURLParameter
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlin.math.abs

object KuGou {
    private val ACCEPTED_REGEX = Regex("""\[(\d\d):(\d\d)\.(\d{2,3})\].*""")
    private val BANNED_REGEX = Regex(".+].+[:：].+")

    private val client by lazy {
        HttpClient(OkHttp) {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                    },
                    contentType = ContentType.Any,
                )
            }
            expectSuccess = true
        }
    }

    suspend fun getLyrics(
        title: String,
        artist: String,
        duration: Int,
        album: String? = null,
    ): Result<String> = runCatching {
        val keyword = generateKeyword(title, artist, album)
        val candidate = getLyricsCandidate(keyword, duration)
            ?: throw IllegalStateException("Lyrics unavailable")
        val downloaded = downloadLyrics(candidate.id, candidate.accesskey)
        String(Base64.decode(downloaded.content, Base64.DEFAULT)).normalize()
    }

    suspend fun getAllPossibleLyricsOptions(
        title: String,
        artist: String,
        duration: Int,
        album: String? = null,
        callback: (String) -> Unit,
    ) {
        runCatching {
            val keyword = generateKeyword(title, artist, album)
            searchSongs(keyword).data.info.forEach { song ->
                if (duration == -1 || abs(song.duration - duration) <= 8) {
                    searchLyricsByHash(song.hash).candidates.firstOrNull()?.let { candidate ->
                        val downloaded = downloadLyrics(candidate.id, candidate.accesskey)
                        callback(String(Base64.decode(downloaded.content, Base64.DEFAULT)).normalize())
                    }
                }
            }
            searchLyricsByKeyword(keyword, duration).candidates.forEach { candidate ->
                val downloaded = downloadLyrics(candidate.id, candidate.accesskey)
                callback(String(Base64.decode(downloaded.content, Base64.DEFAULT)).normalize())
            }
        }
    }

    suspend fun getLyricsCandidate(keyword: Keyword, duration: Int): SearchLyricsResponse.Candidate? {
        searchSongs(keyword).data.info.forEach { song ->
            if (duration == -1 || abs(song.duration - duration) <= 8) {
                val candidate = searchLyricsByHash(song.hash).candidates.firstOrNull()
                if (candidate != null) return candidate
            }
        }
        return searchLyricsByKeyword(keyword, duration).candidates.firstOrNull()
    }

    suspend fun searchSongs(keyword: Keyword): SearchSongResponse =
        client.get("https://mobileservice.kugou.com/api/v3/search/song") {
            parameter("version", 9108)
            parameter("plat", 0)
            parameter("pagesize", 8)
            parameter("showtype", 0)
            url.encodedParameters.append("keyword", "${keyword.artist} - ${keyword.title}".encodeURLParameter(spaceToPlus = false))
        }.body()

    suspend fun searchLyricsByKeyword(keyword: Keyword, duration: Int): SearchLyricsResponse =
        client.get("https://lyrics.kugou.com/search") {
            parameter("ver", 1)
            parameter("man", "yes")
            parameter("client", "pc")
            if (duration != -1) parameter("duration", duration * 1000)
            url.encodedParameters.append("keyword", "${keyword.artist} - ${keyword.title}".encodeURLParameter(spaceToPlus = false))
        }.body()

    suspend fun searchLyricsByHash(hash: String): SearchLyricsResponse =
        client.get("https://lyrics.kugou.com/search") {
            parameter("ver", 1)
            parameter("man", "yes")
            parameter("client", "pc")
            parameter("hash", hash)
        }.body()

    suspend fun downloadLyrics(id: Long, accessKey: String): DownloadLyricsResponse =
        client.get("https://lyrics.kugou.com/download") {
            parameter("fmt", "lrc")
            parameter("charset", "utf8")
            parameter("client", "pc")
            parameter("ver", 1)
            parameter("id", id)
            parameter("accesskey", accessKey)
        }.body()

    fun generateKeyword(title: String, artist: String, album: String? = null): Keyword {
        fun cleanTitle(raw: String): String = raw
            .replace(Regex("""\(.*\)"""), "")
            .replace(Regex("（.*）"), "")
            .replace(Regex("「.*」"), "")
            .replace(Regex("『.*』"), "")
            .replace(Regex("<.*>"), "")
            .replace(Regex("《.*》"), "")
            .replace(Regex("〈.*〉"), "")
            .replace(Regex("＜.*＞"), "")
            .trim()

        fun cleanArtist(raw: String): String = raw
            .replace(Regex("""\(.*\)"""), "")
            .replace(Regex("（.*）"), "")
            .split(",", "&", "/", "、")
            .firstOrNull()
            ?.trim()
            ?: raw.trim()

        return Keyword(
            title = cleanTitle(title),
            artist = cleanArtist(artist),
            album = album?.let(::cleanTitle),
        )
    }

    fun String.normalize(): String =
        lines()
            .filter { it.matches(ACCEPTED_REGEX) && !it.matches(BANNED_REGEX) }
            .joinToString("\n")
}
