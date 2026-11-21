package com.metrolist.innertube.pages

import com.metrolist.innertube.models.AlbumItem
import com.metrolist.innertube.models.ArtistItem
import com.metrolist.innertube.models.MusicResponsiveListItemRenderer
import com.metrolist.innertube.models.MusicTwoRowItemRenderer
import com.metrolist.innertube.models.PlaylistItem
import com.metrolist.innertube.models.Run
import com.metrolist.innertube.models.SongItem
import com.metrolist.innertube.models.YTItem
import com.metrolist.innertube.models.getMusicVideoType
import com.metrolist.innertube.models.getThumbnailUrl
import com.metrolist.innertube.models.getVideoId
import com.metrolist.innertube.models.isEpisode

data class LibraryPage(
    val items: List<YTItem>,
    val continuation: String?,
    val isUploaded: Boolean = false,
) {
    companion object {
        fun fromMusicResponsiveListItemRenderer(
            renderer: MusicResponsiveListItemRenderer,
            isUploaded: Boolean = false,
        ): YTItem? {
            val navBrowse = renderer.navigationEndpoint?.browseEndpoint
            val pageType = navBrowse?.browseEndpointContextSupportedConfigs?.browseEndpointContextMusicConfig?.pageType
            val columns = renderer.flexColumns.orEmpty()
            val title = columns.firstOrNull()
                ?.musicResponsiveListItemFlexColumnRenderer
                ?.text
                ?.runs
                ?.firstOrNull()
                ?.text ?: return null
            val thumbnailUrl = renderer.thumbnail?.getThumbnailUrl() ?: return null
            val explicit = renderer.badges?.any {
                it.musicInlineBadgeRenderer?.icon?.iconType == "MUSIC_EXPLICIT_BADGE"
            } == true
            val subtitleRuns = columns.getOrNull(1)?.musicResponsiveListItemFlexColumnRenderer?.text?.runs
            val menuItems = renderer.menu?.menuRenderer?.items.orEmpty()

            return when (pageType) {
                "MUSIC_PAGE_TYPE_ALBUM", "MUSIC_PAGE_TYPE_AUDIOBOOK" -> {
                    val browseId = navBrowse.browseId ?: return null
                    val playlistId = menuItems.firstOrNull {
                        it.menuNavigationItemRenderer?.icon?.iconType in setOf("MUSIC_SHUFFLE", "MIX")
                    }?.menuNavigationItemRenderer?.navigationEndpoint?.watchPlaylistEndpoint?.playlistId ?: browseId.removePrefix("MPRE")
                    AlbumItem(
                        id = browseId,
                        browseId = browseId,
                        playlistId = playlistId,
                        title = title,
                        artists = PageHelper.extractArtists(subtitleRuns),
                        year = subtitleRuns?.lastOrNull()?.text?.toIntOrNull(),
                        thumbnail = thumbnailUrl,
                        explicit = explicit,
                    )
                }
                "MUSIC_PAGE_TYPE_PLAYLIST" -> {
                    val browseId = navBrowse.browseId ?: return null
                    PlaylistItem(
                        id = browseId,
                        title = title,
                        author = PageHelper.extractArtists(subtitleRuns).firstOrNull(),
                        songCountText = subtitleRuns?.lastOrNull()?.text,
                        thumbnail = thumbnailUrl,
                        isEditable = true,
                    )
                }
                "MUSIC_PAGE_TYPE_ARTIST", "MUSIC_PAGE_TYPE_LIBRARY_ARTIST" -> {
                    val browseId = navBrowse.browseId ?: return null
                    ArtistItem(
                        id = browseId,
                        title = title,
                        thumbnail = thumbnailUrl,
                    )
                }
                else -> {
                    val videoId = renderer.getVideoId() ?: return null
                    val artists = PageHelper.extractArtists(subtitleRuns)
                    val durationText = renderer.fixedColumns?.firstOrNull()
                        ?.musicResponsiveListItemFlexColumnRenderer
                        ?.text
                        ?.runs
                        ?.firstOrNull()
                        ?.text
                    val duration = durationText?.let { PageHelper.extractDuration(listOf(Run(text = it))) }
                    val tokens = PageHelper.extractLibraryTokensFromMenuItems(menuItems)
                    val uploadEntityId = if (isUploaded) {
                        menuItems.firstOrNull {
                            it.menuServiceItemRenderer?.icon?.iconType == "DELETE"
                        }?.menuServiceItemRenderer?.serviceEndpoint?.deletePrivatelyOwnedEntityCommand?.entityId
                    } else null

                    SongItem(
                        id = videoId,
                        title = title,
                        artists = artists,
                        duration = duration,
                        thumbnail = thumbnailUrl,
                        explicit = explicit,
                        endpoint = renderer.navigationEndpoint?.watchEndpoint,
                        musicVideoType = renderer.getMusicVideoType(),
                        libraryAddToken = tokens.addToken,
                        libraryRemoveToken = tokens.removeToken,
                        isEpisode = renderer.isEpisode(),
                        uploadEntityId = uploadEntityId,
                    )
                }
            }
        }

        fun fromMusicTwoRowItemRenderer(renderer: MusicTwoRowItemRenderer): YTItem? =
            ArtistItemsPage.fromMusicTwoRowItemRenderer(renderer)
    }
}
