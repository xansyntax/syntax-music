package com.metrolist.innertube.pages

import com.metrolist.innertube.models.AlbumItem
import com.metrolist.innertube.models.MusicTwoRowItemRenderer
import com.metrolist.innertube.models.getThumbnailUrl

object NewReleaseAlbumPage {
    fun fromMusicTwoRowItemRenderer(renderer: MusicTwoRowItemRenderer): AlbumItem? {
        val browseId = renderer.navigationEndpoint?.browseEndpoint?.browseId ?: return null
        val playlistId = renderer.thumbnailOverlay
            ?.musicItemThumbnailOverlayRenderer
            ?.content
            ?.musicPlayButtonRenderer
            ?.playNavigationEndpoint
            ?.watchPlaylistEndpoint
            ?.playlistId ?: return null
        val title = renderer.title?.runs?.firstOrNull()?.text ?: return null
        val thumbnailUrl = renderer.thumbnailRenderer?.getThumbnailUrl() ?: return null
        val artists = PageHelper.extractArtists(renderer.subtitle?.runs)
        val year = renderer.subtitle?.runs?.lastOrNull()?.text?.toIntOrNull()
        val explicit = renderer.subtitleBadges?.any {
            it.musicInlineBadgeRenderer?.icon?.iconType == "MUSIC_EXPLICIT_BADGE"
        } == true

        return AlbumItem(
            id = browseId,
            browseId = browseId,
            playlistId = playlistId,
            title = title,
            artists = artists,
            year = year,
            thumbnail = thumbnailUrl,
            explicit = explicit,
        )
    }
}
