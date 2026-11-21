package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class MusicTwoRowItemRenderer(
    val title: Runs? = null,
    val subtitle: Runs? = null,
    val subtitleBadges: List<Badges>? = null,
    val menu: Menu? = null,
    val thumbnailRenderer: ThumbnailRenderer? = null,
    val navigationEndpoint: NavigationEndpoint? = null,
    val thumbnailOverlay: MusicResponsiveListItemRenderer.Overlay? = null,
)

fun MusicTwoRowItemRenderer.isSong(): Boolean =
    navigationEndpoint?.watchEndpoint != null

fun MusicTwoRowItemRenderer.isAlbum(): Boolean {
    val pageType = navigationEndpoint?.browseEndpoint?.browseEndpointContextSupportedConfigs?.browseEndpointContextMusicConfig?.pageType
    return pageType == "MUSIC_PAGE_TYPE_ALBUM" || pageType == "MUSIC_PAGE_TYPE_AUDIOBOOK"
}

fun MusicTwoRowItemRenderer.isPlaylist(): Boolean =
    navigationEndpoint?.browseEndpoint?.browseEndpointContextSupportedConfigs?.browseEndpointContextMusicConfig?.pageType == "MUSIC_PAGE_TYPE_PLAYLIST"

fun MusicTwoRowItemRenderer.isArtist(): Boolean =
    navigationEndpoint?.browseEndpoint?.browseEndpointContextSupportedConfigs?.browseEndpointContextMusicConfig?.pageType == "MUSIC_PAGE_TYPE_ARTIST"

fun MusicTwoRowItemRenderer.isPodcast(): Boolean =
    navigationEndpoint?.browseEndpoint?.isPodcastEndpoint() == true

fun MusicTwoRowItemRenderer.isEpisode(): Boolean =
    navigationEndpoint?.browseEndpoint?.browseEndpointContextSupportedConfigs?.browseEndpointContextMusicConfig?.pageType == "MUSIC_PAGE_TYPE_NON_MUSIC_AUDIO_TRACK_PAGE"

fun MusicTwoRowItemRenderer.getMusicVideoType(): String? =
    thumbnailOverlay?.musicItemThumbnailOverlayRenderer?.content?.musicPlayButtonRenderer?.playNavigationEndpoint?.getMusicVideoType()
        ?: navigationEndpoint?.getMusicVideoType()
