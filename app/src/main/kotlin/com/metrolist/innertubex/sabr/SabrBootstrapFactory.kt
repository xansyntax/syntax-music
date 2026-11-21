package com.metrolist.innertubex.sabr

import com.metrolist.innertubex.models.response.PlayerResponse
import io.ktor.http.URLProtocol
import io.ktor.http.Url
import java.util.Locale
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@OptIn(ExperimentalEncodingApi::class)
fun decodeBase64Url(maxBytes: Int, encoded: String, fieldName: String): ByteArray {
    if (encoded.length > ((maxBytes + 2) / 3) * 4) {
        error("Player response $fieldName exceeded the size limit")
    }
    var normalized = encoded.replace('-', '+').replace('_', '/')
    val remainder = normalized.length % 4
    if (remainder != 0) {
        normalized = normalized + "=".repeat(4 - remainder)
    }
    val decoded = runCatching {
        Base64.Default.decode(normalized)
    }.getOrElse {
        error("Player response has an invalid $fieldName")
    }
    if (decoded.size > maxBytes) {
        error("Player response $fieldName exceeded the size limit")
    }
    return decoded
}

fun requireAllowedSabrUrl(urlString: String) {
    val url = runCatching { Url(urlString) }.getOrElse {
        error("Invalid SABR streaming URL")
    }
    val host = url.host.lowercase(Locale.ROOT)
    if (url.protocol != URLProtocol.HTTPS ||
        url.port != 443 ||
        (!host.equals("googlevideo.com") && !host.endsWith(".googlevideo.com")) ||
        url.encodedPath != "/videoplayback" ||
        url.user != null ||
        url.password != null
    ) {
        error("SABR streaming URL is not an HTTPS googlevideo endpoint")
    }
}

fun sabrRequestOrigin(clientName: String): String? {
    return when (clientName) {
        "WEB_REMIX" -> "https://music.youtube.com"
        "WEB" -> "https://www.youtube.com"
        "MWEB" -> "https://m.youtube.com"
        else -> null
    }
}

fun toSabrFormatId(format: PlayerResponse.StreamingData.Format): SabrFormatId {
    val itag = format.itag
    val lastModified = format.lastModified?.toLongOrNull() ?: 0L
    return SabrFormatId(itag, lastModified, format.xtags)
}

fun toSabrBootstrap(
    playerResponse: PlayerResponse,
    clientName: Int,
    clientVersion: String,
    audioFormat: PlayerResponse.StreamingData.Format,
    poToken: String? = null,
    requestUserAgent: String? = null,
    requestOrigin: String? = null,
    serverAbrStreamingUrlOverride: String? = null,
    selectedVideoFormat: PlayerResponse.StreamingData.Format? = null,
): SabrBootstrap? {
    if (clientName <= 0) {
        error("SABR client ID must be positive")
    }
    val streamingData = playerResponse.streamingData
        ?: error("Player response has no streamingData")

    val serverAbrUrl = serverAbrStreamingUrlOverride ?: streamingData.serverAbrStreamingUrl
        ?: error("Player response has no serverAbrStreamingUrl")

    requireAllowedSabrUrl(serverAbrUrl)

    val ustreamerConfig = playerResponse.playerConfig?.mediaCommonConfig?.mediaUstreamerRequestConfig?.videoPlaybackUstreamerConfig
        ?: error("Player response has no videoPlaybackUstreamerConfig")

    val discardVideo = streamingData.adaptiveFormats.asSequence()
        .filter { !it.isAudio() && it.height != null }
        .minWithOrNull(compareBy({ it.height }, { it.bitrate }))
        ?: error("Player response has no SABR video format to discard")

    val durationMs = audioFormat.approxDurationMs?.toLongOrNull()
        ?: playerResponse.videoDetails?.lengthSeconds?.toLongOrNull()?.times(1000L)
        ?: error("Player response has no duration")

    if (durationMs <= 0L) {
        error("Player response has an invalid duration")
    }

    val audioSabrFormatId = toSabrFormatId(audioFormat)
    val discardVideoFormatId = toSabrFormatId(discardVideo)
    val selectedVideoFormatId = selectedVideoFormat?.let { toSabrFormatId(it) }

    if (audioSabrFormatId.lastModified <= 0L) {
        error("SABR audio format has no last-modified identity")
    }
    if (discardVideoFormatId.lastModified <= 0L) {
        error("SABR video format has no last-modified identity")
    }
    if (selectedVideoFormatId != null && selectedVideoFormatId.lastModified <= 0L) {
        error("Selected SABR video format has no last-modified identity")
    }

    val videoId = playerResponse.videoDetails?.videoId
        ?: error("Player response has no video ID")

    val ustreamerConfigBytes = decodeBase64Url(65536, ustreamerConfig, "videoPlaybackUstreamerConfig")
    val discardVideoHeight = discardVideo.height ?: 144

    val poTokenBytes = poToken?.takeIf { it.isNotBlank() }?.let {
        decodeBase64Url(16384, it, "poToken")
    }

    val audioMimeType = audioFormat.mimeType?.substringBefore(';')?.trim().orEmpty()
    val videoMimeType = selectedVideoFormat?.mimeType?.substringBefore(';')?.trim()

    return SabrBootstrap(
        videoId = videoId,
        serverAbrStreamingUrl = serverAbrUrl,
        videoPlaybackUstreamerConfig = ustreamerConfigBytes,
        clientName = clientName,
        clientVersion = clientVersion,
        audioFormat = audioSabrFormatId,
        discardVideoFormat = discardVideoFormatId,
        discardVideoHeight = discardVideoHeight,
        selectedVideoFormat = selectedVideoFormatId,
        selectedVideoWidth = selectedVideoFormat?.width,
        selectedVideoHeight = selectedVideoFormat?.height,
        selectedVideoContentLengthBytes = selectedVideoFormat?.contentLength,
        selectedVideoMimeType = videoMimeType,
        selectedVideoBitrate = selectedVideoFormat?.bitrate,
        durationMs = durationMs,
        contentLengthBytes = audioFormat.contentLength,
        mimeType = audioMimeType,
        audioTrackId = audioFormat.audioTrack?.id,
        isDrc = audioFormat.isDrc,
        poToken = poTokenBytes,
        requestUserAgent = requestUserAgent,
        requestOrigin = requestOrigin,
    )
}
