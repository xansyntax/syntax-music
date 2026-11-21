package com.metrolist.innertube.pages

import com.metrolist.innertube.models.Album
import com.metrolist.innertube.models.AlbumItem
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
import com.metrolist.innertube.models.isEpisode

data class RelatedPage(
    val songs: List<SongItem>,
    val albums: List<AlbumItem>,
    val artists: List<ArtistItem>,
    val playlists: List<PlaylistItem>,
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
            val videoId = renderer.getVideoId() ?: return null
            val title = columns.firstOrNull()
                ?.musicResponsiveListItemFlexColumnRenderer
                ?.text
                ?.runs
                ?.firstOrNull()
                ?.text ?: return null
            val bylineRuns = columns.getOrNull(1)?.musicResponsiveListItemFlexColumnRenderer?.text?.runs
            val artists = PageHelper.extractArtists(bylineRuns?.let { splitRunsBySeparator(it).firstOrNull() })
            val albumRun = columns.getOrNull(2)?.musicResponsiveListItemFlexColumnRenderer?.text?.runs?.firstOrNull()
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

            return SongItem(
                id = videoId,
                title = title,
                artists = artists,
                album = album,
                duration = duration,
                thumbnail = thumbnailUrl,
                explicit = explicit,
                musicVideoType = renderer.getMusicVideoType(),
                libraryAddToken = tokens.addToken,
                libraryRemoveToken = tokens.removeToken,
                isEpisode = renderer.isEpisode(),
            )
        }

        fun fromMusicTwoRowItemRenderer(renderer: MusicTwoRowItemRenderer): YTItem? =
            ArtistItemsPage.fromMusicTwoRowItemRenderer(renderer)
    }
}
