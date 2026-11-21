package com.metrolist.innertubex.extraction

import com.metrolist.innertubex.sabr.SabrBootstrap
import kotlin.time.Instant

@OptIn(kotlin.time.ExperimentalTime::class)
data class ExtractedStream(
    val videoId: String,
    val audioUrl: String,
    val headers: Map<String, String>,
    val loudnessDb: Double?,
    val expiresAt: Instant?,
    val contentLengthBytes: Long?,
    val itag: Int,
    val mimeType: String?,
    val codecs: String?,
    val bitrate: Int?,
    val sampleRate: Int?,
    val clientName: String,
    val profileId: String,
    val requireBoundedRange: Boolean,
    val rangeChunkSizeBytes: Long,
    val useRangeChunks: Boolean = false,
    val playbackTracking: PlaybackTrackingData?,
    val streamDiagnostics: StreamDiagnostics,
    val videoUrl: String? = null,
    val videoWidth: Int? = null,
    val videoHeight: Int? = null,
    val videoMimeType: String? = null,
    val videoCodecs: String? = null,
    val videoBitrate: Int? = null,
    val videoItag: Int? = null,
    val videoContentLengthBytes: Long? = null,
    val sabrBootstrap: SabrBootstrap? = null,
    val sabrVideoBootstrap: SabrBootstrap? = null,
    val availableVideoHeights: List<Int> = emptyList(),
) {
    var mediaMetadata: ExtractedMediaMetadata? = null
    var perceptualLoudnessDb: Double? = null

    override fun toString(): String {
        val vid = if (videoId.isNotEmpty()) "present" else "missing"
        val aud = if (audioUrl.isNotEmpty()) "present" else "missing"
        val vidUrl = if (!videoUrl.isNullOrEmpty()) "present" else "missing"
        val hasMeta = mediaMetadata != null
        val hasSabr = sabrBootstrap != null
        val hasSabrVid = sabrVideoBootstrap != null
        return "ExtractedStream(videoId=$vid, audioUrl=$aud, headerCount=${headers.size}, contentLengthBytes=$contentLengthBytes, itag=$itag, mimeType=$mimeType, clientName=$clientName, profileId=$profileId, mediaMetadata=$hasMeta, videoUrl=$vidUrl, videoItag=$videoItag, sabr=$hasSabr, sabrVideo=$hasSabrVid)"
    }
}
