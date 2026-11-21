package com.metrolist.innertube.pages

import com.metrolist.innertube.models.Album
import com.metrolist.innertube.models.MusicShelfRenderer
import com.metrolist.innertube.models.Run
import com.metrolist.innertube.models.SongItem
import com.metrolist.innertube.models.getItems
import com.metrolist.innertube.models.getMusicVideoType
import com.metrolist.innertube.models.getThumbnailUrl
import com.metrolist.innertube.models.getVideoId
import com.metrolist.innertube.models.isEpisode

data class HistoryPage(
    val sections: List<HistorySection>?,
) {
    data class HistorySection(
        val title: String,
        val songs: List<SongItem>,
    )

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

        fun fromMusicShelfRenderer(renderer: MusicShelfRenderer): HistorySection {
            val title = renderer.title?.runs?.firstOrNull()?.text.orEmpty()
            val songs = renderer.contents.orEmpty().getItems().mapNotNull { item ->
                val videoId = item.getVideoId() ?: return@mapNotNull null
                val columns = item.flexColumns.orEmpty()
                val songTitle = columns.firstOrNull()
                    ?.musicResponsiveListItemFlexColumnRenderer
                    ?.text
                    ?.runs
                    ?.firstOrNull()
                    ?.text ?: return@mapNotNull null
                val bylineRuns = columns.getOrNull(1)
                    ?.musicResponsiveListItemFlexColumnRenderer
                    ?.text
                    ?.runs
                val splitByline = bylineRuns?.let(::splitRunsBySeparator)
                val artists = PageHelper.extractArtists(splitByline?.firstOrNull())
                val albumRun = columns.getOrNull(3)
                    ?.musicResponsiveListItemFlexColumnRenderer
                    ?.text
                    ?.runs
                    ?.firstOrNull()
                val album = albumRun?.navigationEndpoint?.browseEndpoint?.browseId?.let { browseId ->
                    Album(id = browseId, name = albumRun.text.orEmpty())
                }
                val durationText = item.fixedColumns?.firstOrNull()
                    ?.musicResponsiveListItemFlexColumnRenderer
                    ?.text
                    ?.runs
                    ?.firstOrNull()
                    ?.text
                val duration = durationText?.let { PageHelper.extractDuration(listOf(Run(text = it))) }
                val thumbnailUrl = item.thumbnail?.getThumbnailUrl() ?: return@mapNotNull null
                val explicit = item.badges?.any {
                    it.musicInlineBadgeRenderer?.icon?.iconType == "MUSIC_EXPLICIT_BADGE"
                } == true
                val tokens = PageHelper.extractLibraryTokensFromMenuItems(item.menu?.menuRenderer?.items)
                val historyRemoveToken = item.menu?.menuRenderer?.items?.firstOrNull {
                    it.menuServiceItemRenderer?.icon?.iconType == "REMOVE_FROM_HISTORY"
                }?.menuServiceItemRenderer?.serviceEndpoint?.feedbackEndpoint?.feedbackToken
                val endpoint = item.overlay?.musicItemThumbnailOverlayRenderer?.content?.musicPlayButtonRenderer?.playNavigationEndpoint?.watchEndpoint

                SongItem(
                    id = videoId,
                    title = songTitle,
                    artists = artists,
                    album = album,
                    duration = duration,
                    thumbnail = thumbnailUrl,
                    explicit = explicit,
                    endpoint = endpoint,
                    musicVideoType = item.getMusicVideoType(),
                    libraryAddToken = tokens.addToken,
                    libraryRemoveToken = tokens.removeToken,
                    historyRemoveToken = historyRemoveToken,
                    isEpisode = item.isEpisode(),
                )
            }
            return HistorySection(title = title, songs = songs)
        }
    }
}
