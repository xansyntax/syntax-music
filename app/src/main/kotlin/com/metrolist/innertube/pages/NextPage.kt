package com.metrolist.innertube.pages

import com.metrolist.innertube.models.Album
import com.metrolist.innertube.models.PlaylistPanelVideoRenderer
import com.metrolist.innertube.models.Run
import com.metrolist.innertube.models.SongItem
import com.metrolist.innertube.models.getMusicVideoType

object NextPage {
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

    fun fromPlaylistPanelVideoRenderer(renderer: PlaylistPanelVideoRenderer): SongItem? {
        val nav = renderer.navigationEndpoint
        val videoId = renderer.videoId ?: nav?.watchEndpoint?.videoId ?: return null
        val title = renderer.title?.runs?.firstOrNull()?.text ?: return null
        val bylineRuns = renderer.longBylineText?.runs ?: return null
        val sections = splitRunsBySeparator(bylineRuns)
        val artists = PageHelper.extractArtists(bylineRuns)
        val albumRun = sections.getOrNull(1)?.firstOrNull()?.takeIf { it.navigationEndpoint?.browseEndpoint != null }
        val album = albumRun?.let { run ->
            val browseId = run.navigationEndpoint?.browseEndpoint?.browseId ?: return@let null
            Album(id = browseId, name = run.text.orEmpty())
        }
        val durationText = renderer.lengthText?.runs?.firstOrNull()?.text ?: return null
        val duration = PageHelper.extractDuration(listOf(Run(text = durationText))) ?: return null
        val thumbnailUrl = renderer.thumbnail?.thumbnails?.lastOrNull()?.url ?: return null
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
            endpoint = nav?.watchEndpoint,
            musicVideoType = nav?.getMusicVideoType(),
            libraryAddToken = tokens.addToken,
            libraryRemoveToken = tokens.removeToken,
        )
    }
}
