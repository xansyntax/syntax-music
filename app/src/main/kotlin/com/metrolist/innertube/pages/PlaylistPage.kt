package com.metrolist.innertube.pages

import com.metrolist.innertube.models.Album
import com.metrolist.innertube.models.Artist
import com.metrolist.innertube.models.MusicResponsiveListItemRenderer
import com.metrolist.innertube.models.PlaylistItem
import com.metrolist.innertube.models.Run
import com.metrolist.innertube.models.SongItem
import com.metrolist.innertube.models.getMusicVideoType
import com.metrolist.innertube.models.getPlaylistSetVideoId
import com.metrolist.innertube.models.getThumbnailUrl
import com.metrolist.innertube.models.getVideoId
import com.metrolist.innertube.models.isEpisode

data class PlaylistPage(
    val playlist: PlaylistItem,
    val songs: List<SongItem>,
    val songsContinuation: String?,
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
            val artistRuns = columns.getOrNull(1)
                ?.musicResponsiveListItemFlexColumnRenderer
                ?.text
                ?.runs
            val artists = PageHelper.extractArtists(artistRuns)
            val albumRun = columns.getOrNull(2)
                ?.musicResponsiveListItemFlexColumnRenderer
                ?.text
                ?.runs
                ?.firstOrNull()
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
            val setVideoId = renderer.getPlaylistSetVideoId() ?: return null

            return SongItem(
                id = videoId,
                title = title,
                artists = artists,
                album = album,
                duration = duration,
                thumbnail = thumbnailUrl,
                setVideoId = setVideoId,
                explicit = explicit,
                endpoint = endpoint,
                musicVideoType = renderer.getMusicVideoType(),
                libraryAddToken = tokens.addToken,
                libraryRemoveToken = tokens.removeToken,
                isEpisode = renderer.isEpisode(),
            )
        }

        fun ownerFromDetailSubtitle(runs: List<Run>?): Artist? {
            val section = runs?.let { splitRunsBySeparator(it).getOrNull(1) } ?: return null
            PageHelper.extractArtists(section).firstOrNull()?.let { return it }
            val fallbackRun = splitRunsBySeparator(section).firstOrNull()?.firstOrNull()
            if (fallbackRun != null && fallbackRun.navigationEndpoint == null && !fallbackRun.text.isNullOrBlank()) {
                return Artist(id = null, name = fallbackRun.text.trim())
            }
            return null
        }
    }
}
