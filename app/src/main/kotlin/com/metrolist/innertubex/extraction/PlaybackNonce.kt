package com.metrolist.innertubex.extraction

import io.ktor.http.Url
import java.util.regex.Pattern
import kotlin.random.Random

private val CPN_REGEX = Pattern.compile("([?&])cpn=[^&#]*")
private const val NONCE_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_"

fun appendClientPlaybackNonce(url: String, nonce: String): String {
    if (nonce.length != 16) {
        return url
    }
    for (i in 0 until nonce.length) {
        if (!NONCE_CHARS.contains(nonce[i])) {
            return url
        }
    }
    val parsedUrl = runCatching { Url(url) }.getOrNull()
    val isValidGoogleVideo = parsedUrl != null &&
            parsedUrl.protocol.name == "https" &&
            parsedUrl.port == 443 &&
            (parsedUrl.host == "googlevideo.com" || parsedUrl.host.endsWith(".googlevideo.com")) &&
            parsedUrl.encodedPath == "/videoplayback" &&
            parsedUrl.user == null &&
            parsedUrl.password == null

    if (!isValidGoogleVideo || parsedUrl.parameters.contains("cpn")) {
        return url
    }

    val param = "cpn=$nonce"
    val hashIndex = url.indexOf('#')
    val base = if (hashIndex < 0) url else url.substring(0, hashIndex)
    val fragment = if (hashIndex < 0) "" else url.substring(hashIndex)
    val separator = if ('?' in base) "&" else "?"
    return "$base$separator$param$fragment"
}

fun generateClientPlaybackNonce(): String {
    val sb = StringBuilder(16)
    for (i in 0 until 16) {
        sb.append(NONCE_CHARS[Random.nextInt(64)])
    }
    return sb.toString()
}
