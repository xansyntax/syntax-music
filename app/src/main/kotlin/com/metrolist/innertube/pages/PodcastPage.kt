package com.metrolist.innertube.pages

import com.metrolist.innertube.models.Album
import com.metrolist.innertube.models.Artist
import com.metrolist.innertube.models.EpisodeItem
import com.metrolist.innertube.models.MusicMultiRowListItemRenderer
import com.metrolist.innertube.models.PodcastItem
import com.metrolist.innertube.models.Run
import com.metrolist.innertube.models.getThumbnailUrl
import com.metrolist.innertube.models.isPodcastEndpoint

data class PodcastPage(
    val podcast: PodcastItem,
    val episodes: List<EpisodeItem>,
    val continuation: String?,
    val isChannelSubscribed: Boolean = false,
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

        fun extractPodcastArtists(
            renderer: MusicMultiRowListItemRenderer,
            extraRuns: List<Run>?,
        ): List<Artist> {
            val secondary = renderer.secondarySubtitle?.runs.orEmpty()
            val second = renderer.secondSubtitle?.runs.orEmpty()
            val combined = extraRuns.orEmpty() + secondary + second

            val artists = PageHelper.extractArtists(combined).toMutableList()
            if (artists.isEmpty()) {
                for (run in combined) {
                    val text = run.text?.trim().orEmpty()
                    if (text.isNotBlank() && run.navigationEndpoint?.browseEndpoint?.isPodcastEndpoint() == true) {
                        artists.add(Artist(id = null, name = text))
                    }
                }
            }
            if (artists.isNotEmpty()) return artists

            val menuItems = renderer.menu?.menuRenderer?.items.orEmpty()
            val hasPodcastNav = menuItems.any {
                it.menuNavigationItemRenderer?.navigationEndpoint?.browseEndpoint?.isPodcastEndpoint() == true
            }
            if (hasPodcastNav) {
                for (runsContainer in listOf(renderer.secondSubtitle, renderer.secondarySubtitle)) {
                    val single = runsContainer?.runs?.singleOrNull()
                    if (single != null && single.navigationEndpoint == null && !single.text.isNullOrBlank()) {
                        return listOf(Artist(id = null, name = single.text.trim()))
                    }
                }
            }
            return emptyList()
        }

        fun extractPodcastByline(runs: List<Run>?): List<Artist> {
            if (runs.isNullOrEmpty()) return emptyList()
            val artists = PageHelper.extractArtists(runs)
            if (artists.isNotEmpty()) return artists

            runs.firstOrNull {
                !it.text.isNullOrBlank() && it.navigationEndpoint?.browseEndpoint?.isPodcastEndpoint() == true
            }?.let { return listOf(Artist(id = null, name = it.text!!.trim())) }

            val firstRun = splitRunsBySeparator(runs).firstOrNull()?.firstOrNull()
            if (firstRun != null && firstRun.navigationEndpoint == null && !firstRun.text.isNullOrBlank()) {
                return listOf(Artist(id = null, name = firstRun.text.trim()))
            }
            return emptyList()
        }

        fun fromMusicMultiRowListItemRenderer(
            renderer: MusicMultiRowListItemRenderer,
            podcast: PodcastItem? = null,
        ): EpisodeItem? {
            val watchEndpoint = renderer.onTap?.watchEndpoint ?: return null
            val videoId = watchEndpoint.videoId ?: return null
            val title = renderer.title?.runs?.firstOrNull()?.text ?: return null
            val thumbnailUrl = renderer.thumbnail?.getThumbnailUrl() ?: return null

            val subtitleSections = renderer.subtitle?.runs?.let(::splitRunsBySeparator)
            val publishDateText = subtitleSections?.firstOrNull()?.firstOrNull()?.text
            val durationText = subtitleSections?.lastOrNull()?.firstOrNull()?.text
            val duration = durationText?.let { PageHelper.extractDuration(listOf(Run(text = it))) }
            val tokens = PageHelper.extractLibraryTokensFromMenuItems(renderer.menu?.menuRenderer?.items)

            return EpisodeItem(
                id = videoId,
                title = title,
                author = podcast?.author,
                podcast = podcast?.let { Album(id = it.id, name = it.title) },
                duration = duration,
                publishDateText = publishDateText,
                thumbnail = thumbnailUrl,
                explicit = false,
                endpoint = watchEndpoint,
                libraryAddToken = tokens.addToken,
                libraryRemoveToken = tokens.removeToken,
            )
        }
    }
}
