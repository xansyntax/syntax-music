package com.metrolist.innertube.pages

import com.metrolist.innertube.models.Album
import com.metrolist.innertube.models.AlbumItem
import com.metrolist.innertube.models.ArtistItem
import com.metrolist.innertube.models.MusicResponsiveListItemRenderer
import com.metrolist.innertube.models.PlaylistItem
import com.metrolist.innertube.models.PodcastItem
import com.metrolist.innertube.models.Run
import com.metrolist.innertube.models.SongItem
import com.metrolist.innertube.models.YTItem
import com.metrolist.innertube.models.getMusicVideoType
import com.metrolist.innertube.models.getThumbnailUrl
import com.metrolist.innertube.models.getVideoId
import com.metrolist.innertube.models.isEpisode
import com.metrolist.innertube.models.isPodcastEndpoint

object SearchPage {
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

    fun toYTItem(renderer: MusicResponsiveListItemRenderer, defaultArtists: List<com.metrolist.innertube.models.Artist>? = null): YTItem? {
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
        val subtitleSections = subtitleRuns?.let(::splitRunsBySeparator)
        val menuItems = renderer.menu?.menuRenderer?.items.orEmpty()

        val browseEndpoint = renderer.navigationEndpoint?.browseEndpoint
        val pageType = browseEndpoint?.browseEndpointContextSupportedConfigs?.browseEndpointContextMusicConfig?.pageType
        val watchEndpoint = renderer.navigationEndpoint?.watchEndpoint
            ?: renderer.overlay?.musicItemThumbnailOverlayRenderer?.content?.musicPlayButtonRenderer?.playNavigationEndpoint?.watchEndpoint

        if (watchEndpoint != null || renderer.getVideoId() != null) {
            val videoId = renderer.getVideoId() ?: return null
            val artists = PageHelper.extractArtists(subtitleSections?.firstOrNull() ?: subtitleRuns)
                .ifEmpty { defaultArtists.orEmpty() }
            val albumRun = subtitleRuns?.firstOrNull {
                it.navigationEndpoint?.browseEndpoint?.browseEndpointContextSupportedConfigs?.browseEndpointContextMusicConfig?.pageType == "MUSIC_PAGE_TYPE_ALBUM"
            }
            val album = albumRun?.navigationEndpoint?.browseEndpoint?.browseId?.let { browseId ->
                Album(id = browseId, name = albumRun.text.orEmpty())
            }
            val duration = subtitleRuns?.let { PageHelper.extractDuration(it) }
            val tokens = PageHelper.extractLibraryTokensFromMenuItems(menuItems)
            return SongItem(
                id = videoId,
                title = title,
                artists = artists,
                album = album,
                duration = duration,
                thumbnail = thumbnailUrl,
                explicit = explicit,
                endpoint = watchEndpoint,
                musicVideoType = renderer.getMusicVideoType(),
                libraryAddToken = tokens.addToken,
                libraryRemoveToken = tokens.removeToken,
                isEpisode = renderer.isEpisode(),
            )
        }

        val browseId = browseEndpoint?.browseId ?: return null
        return when {
            pageType == "MUSIC_PAGE_TYPE_ALBUM" || pageType == "MUSIC_PAGE_TYPE_AUDIOBOOK" -> {
                val playlistId = menuItems.firstOrNull {
                    it.menuNavigationItemRenderer?.icon?.iconType in setOf("MUSIC_SHUFFLE", "MIX")
                }?.menuNavigationItemRenderer?.navigationEndpoint?.watchPlaylistEndpoint?.playlistId ?: browseId.removePrefix("MPRE")
                val artists = PageHelper.extractArtists(subtitleRuns).ifEmpty { defaultArtists.orEmpty() }
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
            pageType == "MUSIC_PAGE_TYPE_PLAYLIST" -> {
                val author = PageHelper.extractArtists(subtitleRuns).firstOrNull()
                val songCountText = subtitleSections?.lastOrNull()?.firstOrNull()?.text
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
                )
            }
            pageType == "MUSIC_PAGE_TYPE_ARTIST" || pageType == "MUSIC_PAGE_TYPE_USER_CHANNEL" -> {
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
                    isProfile = pageType == "MUSIC_PAGE_TYPE_USER_CHANNEL",
                )
            }
            browseEndpoint.isPodcastEndpoint() -> {
                val author = PodcastPage.extractPodcastByline(subtitleRuns).firstOrNull()
                val tokens = PageHelper.extractLibraryTokensFromMenuItems(menuItems)
                PodcastItem(
                    id = browseId,
                    title = title,
                    author = author,
                    thumbnail = thumbnailUrl,
                    libraryAddToken = tokens.addToken,
                    libraryRemoveToken = tokens.removeToken,
                )
            }
            else -> null
        }
    }
}
