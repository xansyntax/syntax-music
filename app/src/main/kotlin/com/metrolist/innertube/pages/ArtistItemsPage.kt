package com.metrolist.innertube.pages

import com.metrolist.innertube.models.Album
import com.metrolist.innertube.models.AlbumItem
import com.metrolist.innertube.models.Artist
import com.metrolist.innertube.models.ArtistItem
import com.metrolist.innertube.models.MusicResponsiveListItemRenderer
import com.metrolist.innertube.models.MusicTwoRowItemRenderer
import com.metrolist.innertube.models.PlaylistItem
import com.metrolist.innertube.models.PodcastItem
import com.metrolist.innertube.models.Run
import com.metrolist.innertube.models.SongItem
import com.metrolist.innertube.models.YTItem
import com.metrolist.innertube.models.getMusicVideoType
import com.metrolist.innertube.models.getThumbnailUrl
import com.metrolist.innertube.models.getVideoId
import com.metrolist.innertube.models.isAlbum
import com.metrolist.innertube.models.isArtist
import com.metrolist.innertube.models.isEpisode
import com.metrolist.innertube.models.isPlaylist
import com.metrolist.innertube.models.isPodcast
import com.metrolist.innertube.models.isSong

data class ArtistItemsPage(
    val title: String,
    val items: List<YTItem>,
    val continuation: String?,
) {
    companion object {
        private fun splitRunsBySeparator(runs: List<Run>): List<List<Run>> {
            val result = mutableListOf<List<Run>>()
            var current = mutableListOf<Run>()
            for (run in runs) {
                if (run.text == " • ") {
                    result.add(current)
                    current = mutableListOf()
                } else {
                    current.add(run)
                }
            }
            result.add(current)
            return result
        }

        fun fromMusicResponsiveListItemRenderer(renderer: MusicResponsiveListItemRenderer): SongItem? {
            val columns = renderer.flexColumns.orEmpty()
            val title = columns.firstOrNull()
                ?.musicResponsiveListItemFlexColumnRenderer
                ?.text
                ?.runs
                ?.firstOrNull()
                ?.text ?: return null
            val videoId = renderer.getVideoId() ?: return null
            val artistRuns = columns.getOrNull(1)?.musicResponsiveListItemFlexColumnRenderer?.text?.runs
            val artists = PageHelper.extractArtists(artistRuns)
            val albumRun = columns.lastOrNull()?.musicResponsiveListItemFlexColumnRenderer?.text?.runs?.firstOrNull()
            val album = albumRun?.navigationEndpoint?.browseEndpoint?.browseId?.let { browseId ->
                Album(id = browseId, name = albumRun.text.orEmpty())
            }
            val durationText = renderer.fixedColumns?.firstOrNull()
                ?.musicResponsiveListItemFlexColumnRenderer
                ?.text
                ?.runs
                ?.firstOrNull()
                ?.text
            val duration = durationText?.let { PageHelper.extractDuration(listOf(Run(text = it))) }
            val thumbnailUrl = renderer.thumbnail?.getThumbnailUrl() ?: return null
            val explicit = renderer.badges?.any {
                it.musicInlineBadgeRenderer?.icon?.iconType == "MUSIC_EXPLICIT_BADGE"
            } == true
            val tokens = PageHelper.extractLibraryTokensFromMenuItems(renderer.menu?.menuRenderer?.items)
            val endpoint = renderer.overlay?.musicItemThumbnailOverlayRenderer?.content?.musicPlayButtonRenderer?.playNavigationEndpoint?.watchEndpoint

            return SongItem(
                id = videoId,
                title = title,
                artists = artists,
                album = album,
                duration = duration,
                thumbnail = thumbnailUrl,
                explicit = explicit,
                endpoint = endpoint,
                musicVideoType = renderer.getMusicVideoType(),
                libraryAddToken = tokens.addToken,
                libraryRemoveToken = tokens.removeToken,
                isEpisode = renderer.isEpisode(),
            )
        }

        fun fromMusicTwoRowItemRenderer(renderer: MusicTwoRowItemRenderer): YTItem? {
            val title = renderer.title?.runs?.firstOrNull()?.text ?: return null
            val subtitleRuns = renderer.subtitle?.runs
            val thumbnailUrl = renderer.thumbnailRenderer?.getThumbnailUrl() ?: return null
            val explicit = renderer.subtitleBadges?.any {
                it.musicInlineBadgeRenderer?.icon?.iconType == "MUSIC_EXPLICIT_BADGE"
            } == true
            val menuItems = renderer.menu?.menuRenderer?.items.orEmpty()

            if (renderer.isSong()) {
                val videoId = renderer.navigationEndpoint?.watchEndpoint?.videoId ?: return null
                val artists = PageHelper.extractArtists(subtitleRuns)
                val tokens = PageHelper.extractLibraryTokensFromMenuItems(menuItems)
                return SongItem(
                    id = videoId,
                    title = title,
                    artists = artists,
                    thumbnail = thumbnailUrl,
                    explicit = explicit,
                    endpoint = renderer.navigationEndpoint?.watchEndpoint,
                    musicVideoType = renderer.navigationEndpoint?.getMusicVideoType(),
                    libraryAddToken = tokens.addToken,
                    libraryRemoveToken = tokens.removeToken,
                )
            }

            val browseId = renderer.navigationEndpoint?.browseEndpoint?.browseId ?: return null
            return when {
                renderer.isAlbum() -> {
                    val playlistId = menuItems.firstOrNull {
                        it.menuNavigationItemRenderer?.icon?.iconType in setOf("MUSIC_SHUFFLE", "MIX")
                    }?.menuNavigationItemRenderer?.navigationEndpoint?.watchPlaylistEndpoint?.playlistId ?: return null
                    val artists = PageHelper.extractArtists(subtitleRuns)
                    val year = subtitleRuns?.lastOrNull()?.text?.toIntOrNull()
                    AlbumItem(
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
                renderer.isPlaylist() -> {
                    val authorSection = subtitleRuns?.let { splitRunsBySeparator(it).getOrNull(1) }
                    val author = PageHelper.extractArtists(authorSection).firstOrNull()
                    val songCountText = subtitleRuns?.joinToString("") { it.text.orEmpty() }
                    val playEndpoint = menuItems.firstOrNull { it.menuNavigationItemRenderer?.icon?.iconType == "PLAY_ARROW" }
                        ?.menuNavigationItemRenderer?.navigationEndpoint?.watchPlaylistEndpoint
                    val shuffleEndpoint = menuItems.firstOrNull { it.menuNavigationItemRenderer?.icon?.iconType == "MUSIC_SHUFFLE" }
                        ?.menuNavigationItemRenderer?.navigationEndpoint?.watchPlaylistEndpoint
                    val radioEndpoint = menuItems.firstOrNull { it.menuNavigationItemRenderer?.icon?.iconType == "MIX" }
                        ?.menuNavigationItemRenderer?.navigationEndpoint?.watchPlaylistEndpoint
                    PlaylistItem(
                        id = browseId,
                        title = title,
                        author = author,
                        songCountText = songCountText,
                        thumbnail = thumbnailUrl,
                        playEndpoint = playEndpoint,
                        shuffleEndpoint = shuffleEndpoint,
                        radioEndpoint = radioEndpoint,
                        isPodcast = explicit,
                    )
                }
                renderer.isArtist() -> {
                    val shuffleEndpoint = menuItems.firstOrNull { it.menuNavigationItemRenderer?.icon?.iconType == "MUSIC_SHUFFLE" }
                        ?.menuNavigationItemRenderer?.navigationEndpoint?.watchPlaylistEndpoint
                    val radioEndpoint = menuItems.firstOrNull { it.menuNavigationItemRenderer?.icon?.iconType == "MIX" }
                        ?.menuNavigationItemRenderer?.navigationEndpoint?.watchPlaylistEndpoint
                    ArtistItem(
                        id = browseId,
                        title = title,
                        thumbnail = thumbnailUrl,
                        shuffleEndpoint = shuffleEndpoint,
                        radioEndpoint = radioEndpoint,
                    )
                }
                renderer.isPodcast() -> {
                    val byline = PodcastPage.extractPodcastByline(subtitleRuns).firstOrNull()
                    val channelId = menuItems.firstOrNull { it.menuNavigationItemRenderer?.icon?.iconType == "ARTIST" }
                        ?.menuNavigationItemRenderer?.navigationEndpoint?.browseEndpoint?.browseId
                    val resolvedAuthor = when {
                        byline == null && channelId != null -> Artist(
                            id = channelId,
                            name = subtitleRuns?.let { splitRunsBySeparator(it).firstOrNull()?.firstOrNull()?.text?.trim() }.orEmpty(),
                        )
                        byline != null && byline.id == null && channelId != null -> byline.copy(id = channelId)
                        else -> byline
                    }
                    val episodeCount = subtitleRuns?.let { splitRunsBySeparator(it).getOrNull(1)?.firstOrNull()?.text?.trim() }
                        ?: subtitleRuns?.let { splitRunsBySeparator(it).firstOrNull()?.firstOrNull()?.text }
                    val playEndpoint = renderer.thumbnailOverlay?.musicItemThumbnailOverlayRenderer?.content?.musicPlayButtonRenderer?.playNavigationEndpoint?.watchPlaylistEndpoint
                    val tokens = PageHelper.extractLibraryTokensFromMenuItems(menuItems)
                    PodcastItem(
                        id = browseId,
                        title = title,
                        author = resolvedAuthor,
                        episodeCountText = episodeCount,
                        thumbnail = thumbnailUrl,
                        playEndpoint = playEndpoint,
                        libraryAddToken = tokens.addToken,
                        libraryRemoveToken = tokens.removeToken,
                        channelId = channelId,
                    )
                }
                else -> null
            }
        }
    }
}
