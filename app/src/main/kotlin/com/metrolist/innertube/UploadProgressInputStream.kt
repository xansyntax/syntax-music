package com.metrolist.innertube

import java.io.FilterInputStream
import java.io.InputStream

class UploadProgressInputStream(
    inputStream: InputStream,
    private val contentLength: Long,
    private val onProgress: (Float) -> Unit,
) : FilterInputStream(inputStream) {
    private var bytesRead = 0L

    override fun read(): Int {
        val byte = super.read()
        if (byte >= 0) reportBytesRead(1)
        return byte
    }

    override fun read(b: ByteArray, off: Int, len: Int): Int {
        val count = super.read(b, off, len)
        if (count > 0) reportBytesRead(count)
        return count
    }

    private fun reportBytesRead(count: Int) {
        bytesRead += count
        val progress = (bytesRead.toFloat() / contentLength.coerceAtLeast(1L)).coerceAtMost(1f)
        onProgress(progress)
    }
}
