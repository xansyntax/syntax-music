package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class BrowseEndpoint(
    val browseId: String? = null,
    val params: String? = null,
    val browseEndpointContextSupportedConfigs: BrowseEndpointContextSupportedConfigs? = null,
) : Endpoint() {

    @Serializable
    data class BrowseEndpointContextSupportedConfigs(
        val browseEndpointContextMusicConfig: BrowseEndpointContextMusicConfig? = null,
    ) {
        @Serializable
        data class BrowseEndpointContextMusicConfig(
            val pageType: String? = null,
        )
    }
}

fun BrowseEndpoint.isPodcastEndpoint(): Boolean {
    val pageType = browseEndpointContextSupportedConfigs
        ?.browseEndpointContextMusicConfig
        ?.pageType
    return pageType == "MUSIC_PAGE_TYPE_PODCAST_SHOW_DETAIL_PAGE" ||
        pageType == "MUSIC_PAGE_TYPE_NON_MUSIC_AUDIO_TRACK_PAGE" ||
        browseId?.startsWith("MPSP") == true
}
