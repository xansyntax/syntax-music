package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class WatchEndpoint(
    val videoId: String? = null,
    val playlistId: String? = null,
    val params: String? = null,
    val index: Int? = null,
    val playlistSetVideoId: String? = null,
    val watchEndpointMusicSupportedConfigs: WatchEndpointMusicSupportedConfigs? = null,
) : Endpoint() {

    @Serializable
    data class WatchEndpointMusicSupportedConfigs(
        val watchEndpointMusicConfig: WatchEndpointMusicConfig? = null,
    ) {
        @Serializable
        data class WatchEndpointMusicConfig(
            val musicVideoType: String? = null,
        )
    }
}
