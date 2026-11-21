package com.metrolist.lastfm

import com.metrolist.lastfm.models.Authentication
import com.metrolist.lastfm.models.LastFmError
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.Parameters
import io.ktor.http.contentType
import io.ktor.http.userAgent
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import java.security.MessageDigest

object LastFM {
    var sessionKey: String? = null
    var API_KEY: String = ""
    var SECRET: String = ""

    private val json = Json {
        isLenient = true
        ignoreUnknownKeys = true
    }

    private val client by lazy {
        HttpClient(OkHttp) {
            install(ContentNegotiation) { json(json) }
            defaultRequest { url("https://ws.audioscrobbler.com/2.0/") }
        }
    }

    class LastFmException(val code: Int, override val message: String?) : Exception(message)

    private suspend inline fun <reified T> HttpResponse.bodyOrThrow(): T {
        if (status == HttpStatusCode.OK) {
            return body()
        } else {
            val err = body<LastFmError>()
            throw LastFmException(err.error, err.message)
        }
    }

    private fun HttpRequestBuilder.lastfmParams(
        method: String,
        apiKey: String = API_KEY,
        secret: String = SECRET,
        sk: String? = sessionKey,
        extra: Map<String, String> = emptyMap(),
    ) {
        contentType(ContentType.Application.FormUrlEncoded)
        userAgent("Metrolist (https://github.com/MetrolistGroup/Metrolist)")
        val params = buildMap {
            put("method", method)
            put("api_key", apiKey)
            if (sk != null) put("sk", sk)
            putAll(extra)
        }.toSortedMap()

        val sigSource = params.entries.joinToString("") { "${it.key}${it.value}" } + secret
        val apiSig = MessageDigest.getInstance("MD5")
            .digest(sigSource.toByteArray())
            .joinToString("") { "%02x".format(it) }

        setBody(
            FormDataContent(
                Parameters.build {
                    params.forEach { (k, v) -> append(k, v) }
                    append("api_sig", apiSig)
                }
            )
        )
    }

    suspend fun getMobileSession(username: String, password: String): Result<Authentication> = runCatching {
        client.post {
            lastfmParams(
                method = "auth.getMobileSession",
                sk = null,
                extra = mapOf("username" to username, "password" to password),
            )
            parameter("format", "json")
        }.bodyOrThrow()
    }

    suspend fun updateNowPlaying(
        artist: String,
        track: String,
        album: String? = null,
        duration: Int? = null,
    ): Result<Unit> = runCatching {
        client.post {
            lastfmParams(
                method = "track.updateNowPlaying",
                extra = buildMap {
                    put("artist", artist)
                    put("track", track)
                    if (album != null) put("album", album)
                    if (duration != null) put("duration", duration.toString())
                },
            )
            parameter("format", "json")
        }.bodyOrThrow<Unit>()
    }

    suspend fun scrobble(
        artist: String,
        track: String,
        timestamp: Long,
        album: String? = null,
        duration: Int? = null,
    ): Result<Unit> = runCatching {
        client.post {
            lastfmParams(
                method = "track.scrobble",
                extra = buildMap {
                    put("artist[0]", artist)
                    put("track[0]", track)
                    put("timestamp[0]", timestamp.toString())
                    if (album != null) put("album[0]", album)
                    if (duration != null) put("duration[0]", duration.toString())
                },
            )
            parameter("format", "json")
        }.bodyOrThrow<Unit>()
    }

    suspend fun setLoveStatus(
        artist: String,
        track: String,
        love: Boolean,
    ): Result<Unit> = runCatching {
        client.post {
            lastfmParams(
                method = if (love) "track.love" else "track.unlove",
                extra = mapOf("artist" to artist, "track" to track),
            )
            parameter("format", "json")
        }.bodyOrThrow<Unit>()
    }
}
