package com.metrolist.innertubex

import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsChannel
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.readAvailable
import java.io.ByteArrayOutputStream
import java.nio.charset.Charset

suspend fun HttpResponse.bodyAsTextLimited(
    maxBytes: Int,
    stopWhen: (suspend (String) -> Boolean)? = null,
    charset: Charset = Charsets.UTF_8,
): String {
    val channel: ByteReadChannel = bodyAsChannel()
    val buffer = ByteArrayOutputStream()
    val chunk = ByteArray(8192)
    var totalRead = 0

    while (!channel.isClosedForRead && totalRead < maxBytes) {
        val toRead = minOf(chunk.size, maxBytes - totalRead)
        val read = channel.readAvailable(chunk, 0, toRead)
        if (read <= 0) break
        buffer.write(chunk, 0, read)
        totalRead += read
        if (stopWhen != null) {
            val currentText = buffer.toString(charset.name())
            if (stopWhen(currentText)) {
                return currentText
            }
        }
    }
    return buffer.toString(charset.name())
}
