package com.metrolist.innertubex.models.response

import kotlinx.serialization.Serializable
import com.metrolist.innertubex.models.*

@Serializable
data class PlayerResponse(
    val playabilityStatus: PlayabilityStatus? = null,
    val playbackTracking: PlaybackTracking? = null,
    val playerConfig: PlayerConfig? = null,
    val streamingData: StreamingData? = null,
    val videoDetails: VideoDetails? = null,
) {

    @Serializable
    data class PlayabilityStatus(
        val reason: String? = null,
        val status: String? = null,
    )

    @Serializable
    data class PlaybackTracking(
        val atrUrl: VideostatsUrl? = null,
        val videostatsDefaultFlushIntervalSeconds: Int? = null,
        val videostatsPlaybackUrl: VideostatsUrl? = null,
        val videostatsScheduledFlushWalltimeSeconds: List<Int>? = null,
        val videostatsWatchtimeUrl: VideostatsUrl? = null,
    ) {

        @Serializable
        data class VideostatsUrl(
            val baseUrl: String? = null,
        )
    }

    @Serializable
    data class PlayerConfig(
        val audioConfig: AudioConfig? = null,
        val mediaCommonConfig: MediaCommonConfig? = null,
    ) {

        @Serializable
        data class AudioConfig(
            val loudnessDb: Double? = null,
            val perceptualLoudnessDb: Double? = null,
        )

        @Serializable
        data class MediaCommonConfig(
            val mediaUstreamerRequestConfig: MediaUstreamerRequestConfig? = null,
        ) {

            @Serializable
            data class MediaUstreamerRequestConfig(
                val videoPlaybackUstreamerConfig: String? = null,
            )
        }
    }

    @Serializable
    data class VideoDetails(
        val author: String? = null,
        val channelId: String? = null,
        val isLiveContent: Boolean? = null,
        val lengthSeconds: String? = null,
        val musicVideoType: String? = null,
        val thumbnail: Thumbnails? = null,
        val title: String? = null,
        val videoId: String? = null,
        val viewCount: String? = null,
    )

    @Serializable
    data class StreamingData(
        val adaptiveFormats: List<Format> = emptyList(),
        val dashManifestUrl: String? = null,
        val expiresInSeconds: Int? = null,
        val formats: List<Format>? = null,
        val hlsManifestUrl: String? = null,
        val serverAbrStreamingUrl: String? = null,
    ) {

        @Serializable
        data class Format(
            val approxDurationMs: String? = null,
            val audioChannels: Int? = null,
            val audioQuality: String? = null,
            val audioSampleRate: Int? = null,
            val audioTrack: AudioTrack? = null,
            val bitrate: Int = 0,
            val cipher: String? = null,
            val contentLength: Long? = null,
            val height: Int? = null,
            val isDrc: Boolean = false,
            val itag: Int = 0,
            val lastModified: String? = null,
            val loudnessDb: Double? = null,
            val mimeType: String? = null,
            val quality: String? = null,
            val signatureCipher: String? = null,
            val url: String? = null,
            val width: Int? = null,
            val xtags: String? = null,
        ) {
            fun isAudio(): Boolean = width == null

            @Serializable
            data class AudioTrack(
                val audioIsDefault: Boolean? = null,
                val displayName: String? = null,
                val id: String? = null,
            )
        }
    }
}
