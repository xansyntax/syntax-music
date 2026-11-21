package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class MusicResponsiveListItemRenderer(
    val badges: List<Badges>? = null,
    val fixedColumns: List<FlexColumn>? = null,
    val flexColumns: List<FlexColumn>? = null,
    val menu: Menu? = null,
    val navigationEndpoint: NavigationEndpoint? = null,
    val overlay: Overlay? = null,
    val playlistItemData: PlaylistItemData? = null,
    val thumbnail: ThumbnailRenderer? = null,
) {

    @Serializable
    data class FlexColumn(
        val musicResponsiveListItemFlexColumnRenderer: MusicResponsiveListItemFlexColumnRenderer? = null,
    ) {

        @Serializable
        data class MusicResponsiveListItemFlexColumnRenderer(
            val text: Runs? = null,
        )
    }

    @Serializable
    data class Overlay(
        val musicItemThumbnailOverlayRenderer: MusicItemThumbnailOverlayRenderer? = null,
    ) {

        @Serializable
        data class MusicItemThumbnailOverlayRenderer(
            val content: Content? = null,
        ) {

            @Serializable
            data class Content(
                val musicPlayButtonRenderer: MusicPlayButtonRenderer? = null,
            ) {

                @Serializable
                data class MusicPlayButtonRenderer(
                    val playNavigationEndpoint: NavigationEndpoint? = null,
                )
            }
        }
    }

    @Serializable
    data class PlaylistItemData(
        val playlistSetVideoId: String? = null,
        val videoId: String? = null,
    )
}

fun MusicResponsiveListItemRenderer.getPlaylistSetVideoId(): String? =
    playlistItemData?.playlistSetVideoId
        ?: overlay?.musicItemThumbnailOverlayRenderer?.content?.musicPlayButtonRenderer?.playNavigationEndpoint?.watchEndpoint?.playlistSetVideoId

fun MusicResponsiveListItemRenderer.getVideoId(): String? =
    playlistItemData?.videoId
        ?: flexColumns?.firstOrNull()?.musicResponsiveListItemFlexColumnRenderer?.text?.runs?.firstOrNull()?.navigationEndpoint?.watchEndpoint?.videoId
        ?: overlay?.musicItemThumbnailOverlayRenderer?.content?.musicPlayButtonRenderer?.playNavigationEndpoint?.watchEndpoint?.videoId
        ?: navigationEndpoint?.watchEndpoint?.videoId

fun MusicResponsiveListItemRenderer.isSong(): Boolean =
    navigationEndpoint?.watchEndpoint != null

fun MusicResponsiveListItemRenderer.isAlbum(): Boolean {
    val pageType = navigationEndpoint?.browseEndpoint?.browseEndpointContextSupportedConfigs?.browseEndpointContextMusicConfig?.pageType
    return pageType == "MUSIC_PAGE_TYPE_ALBUM" || pageType == "MUSIC_PAGE_TYPE_AUDIOBOOK"
}

fun MusicResponsiveListItemRenderer.isArtist(): Boolean =
    navigationEndpoint?.browseEndpoint?.browseEndpointContextSupportedConfigs?.browseEndpointContextMusicConfig?.pageType == "MUSIC_PAGE_TYPE_ARTIST"

fun MusicResponsiveListItemRenderer.isPodcast(): Boolean =
    navigationEndpoint?.browseEndpoint?.browseEndpointContextSupportedConfigs?.browseEndpointContextMusicConfig?.pageType == "MUSIC_PAGE_TYPE_PODCAST_SHOW_DETAIL_PAGE"

fun MusicResponsiveListItemRenderer.isEpisode(): Boolean {
    if (navigationEndpoint?.browseEndpoint?.browseEndpointContextSupportedConfigs?.browseEndpointContextMusicConfig?.pageType == "MUSIC_PAGE_TYPE_NON_MUSIC_AUDIO_TRACK_PAGE") {
        return true
    }
    val col1 = flexColumns?.getOrNull(1)
    if (col1?.musicResponsiveListItemFlexColumnRenderer?.text?.runs?.firstOrNull()?.text == "Episode") {
        return true
    }
    val hasPodcastDetail = col1?.musicResponsiveListItemFlexColumnRenderer?.text?.runs?.any {
        it.navigationEndpoint?.browseEndpoint?.browseEndpointContextSupportedConfigs?.browseEndpointContextMusicConfig?.pageType == "MUSIC_PAGE_TYPE_PODCAST_SHOW_DETAIL_PAGE"
    } == true
    return hasPodcastDetail && getVideoId() != null
}

fun MusicResponsiveListItemRenderer.getMusicVideoType(): String? =
    navigationEndpoint?.getMusicVideoType()
        ?: overlay?.musicItemThumbnailOverlayRenderer?.content?.musicPlayButtonRenderer?.playNavigationEndpoint?.getMusicVideoType()
