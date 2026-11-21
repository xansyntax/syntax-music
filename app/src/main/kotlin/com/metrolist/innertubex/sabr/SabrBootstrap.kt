package com.metrolist.innertubex.sabr

import java.util.Arrays

data class SabrBootstrap(
    val videoId: String,
    val serverAbrStreamingUrl: String,
    val videoPlaybackUstreamerConfig: ByteArray,
    val clientName: Int,
    val clientVersion: String,
    val audioFormat: SabrFormatId,
    val discardVideoFormat: SabrFormatId,
    val discardVideoHeight: Int,
    val selectedVideoFormat: SabrFormatId? = null,
    val selectedVideoWidth: Int? = null,
    val selectedVideoHeight: Int? = null,
    val selectedVideoContentLengthBytes: Long? = null,
    val selectedVideoMimeType: String? = null,
    val selectedVideoBitrate: Int? = null,
    val durationMs: Long,
    val contentLengthBytes: Long? = null,
    val mimeType: String,
    val audioTrackId: String? = null,
    val isDrc: Boolean = false,
    val poToken: ByteArray? = null,
    val requestUserAgent: String? = null,
    val requestOrigin: String? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SabrBootstrap) return false

        if (videoId != other.videoId) return false
        if (serverAbrStreamingUrl != other.serverAbrStreamingUrl) return false
        if (!Arrays.equals(videoPlaybackUstreamerConfig, other.videoPlaybackUstreamerConfig)) return false
        if (clientName != other.clientName) return false
        if (clientVersion != other.clientVersion) return false
        if (audioFormat != other.audioFormat) return false
        if (discardVideoFormat != other.discardVideoFormat) return false
        if (discardVideoHeight != other.discardVideoHeight) return false
        if (selectedVideoFormat != other.selectedVideoFormat) return false
        if (selectedVideoWidth != other.selectedVideoWidth) return false
        if (selectedVideoHeight != other.selectedVideoHeight) return false
        if (selectedVideoContentLengthBytes != other.selectedVideoContentLengthBytes) return false
        if (selectedVideoMimeType != other.selectedVideoMimeType) return false
        if (selectedVideoBitrate != other.selectedVideoBitrate) return false
        if (durationMs != other.durationMs) return false
        if (contentLengthBytes != other.contentLengthBytes) return false
        if (mimeType != other.mimeType) return false
        if (audioTrackId != other.audioTrackId) return false
        if (isDrc != other.isDrc) return false
        if (!Arrays.equals(poToken, other.poToken)) return false
        if (requestUserAgent != other.requestUserAgent) return false
        if (requestOrigin != other.requestOrigin) return false

        return true
    }

    override fun hashCode(): Int {
        var result = videoId.hashCode()
        result = 31 * result + serverAbrStreamingUrl.hashCode()
        result = 31 * result + Arrays.hashCode(videoPlaybackUstreamerConfig)
        result = 31 * result + clientName
        result = 31 * result + clientVersion.hashCode()
        result = 31 * result + audioFormat.hashCode()
        result = 31 * result + discardVideoFormat.hashCode()
        result = 31 * result + discardVideoHeight
        result = 31 * result + (selectedVideoFormat?.hashCode() ?: 0)
        result = 31 * result + (selectedVideoWidth?.hashCode() ?: 0)
        result = 31 * result + (selectedVideoHeight?.hashCode() ?: 0)
        result = 31 * result + (selectedVideoContentLengthBytes?.hashCode() ?: 0)
        result = 31 * result + (selectedVideoMimeType?.hashCode() ?: 0)
        result = 31 * result + (selectedVideoBitrate?.hashCode() ?: 0)
        result = 31 * result + durationMs.hashCode()
        result = 31 * result + (contentLengthBytes?.hashCode() ?: 0)
        result = 31 * result + mimeType.hashCode()
        result = 31 * result + (audioTrackId?.hashCode() ?: 0)
        result = 31 * result + isDrc.hashCode()
        result = 31 * result + (poToken?.let { Arrays.hashCode(it) } ?: 0)
        result = 31 * result + (requestUserAgent?.hashCode() ?: 0)
        result = 31 * result + (requestOrigin?.hashCode() ?: 0)
        return result
    }
}
