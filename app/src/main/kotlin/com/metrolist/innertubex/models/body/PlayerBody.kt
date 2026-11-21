package com.metrolist.innertubex.models.body

import kotlinx.serialization.Serializable
import com.metrolist.innertubex.models.*

@Serializable
data class PlayerBody(
    val context: Context? = null,
    val videoId: String? = null,
    val playlistId: String? = null,
    val playbackContext: PlaybackContext? = null,
    val thirdParty: ThirdParty? = null,
    val serviceIntegrityDimensions: ServiceIntegrityDimensions? = null,
    val contentCheckOk: Boolean = false,
    val racyCheckOk: Boolean = false,
    val videoCheckOk: Boolean? = null,
) {
    constructor(
        context: Context,
        videoId: String,
        playbackContext: PlaybackContext? = null,
        thirdParty: ThirdParty? = null,
        serviceIntegrityDimensions: ServiceIntegrityDimensions? = null,
        videoCheckOk: Boolean? = null,
    ) : this(
        context = context,
        videoId = videoId,
        playlistId = null,
        playbackContext = playbackContext,
        thirdParty = thirdParty,
        serviceIntegrityDimensions = serviceIntegrityDimensions,
        contentCheckOk = true,
        racyCheckOk = true,
        videoCheckOk = videoCheckOk,
    )


    @Serializable
    data class PlaybackContext(
        val contentPlaybackContext: ContentPlaybackContext? = null,
    ) {

        @Serializable
        data class ContentPlaybackContext(
            val encryptedHostFlags: String? = null,
            val html5Preference: String? = null,
            val signatureTimestamp: Int? = null,
        )
    }

    @Serializable
    data class ServiceIntegrityDimensions(
        val poToken: String? = null,
    )

    @Serializable
    data class ThirdParty(
        val embedUrl: String? = null,
    )
}
