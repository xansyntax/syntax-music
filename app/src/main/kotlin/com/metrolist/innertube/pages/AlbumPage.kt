package com.metrolist.innertube.pages

import com.metrolist.innertube.models.Album
import com.metrolist.innertube.models.AlbumItem
import com.metrolist.innertube.models.Artist
import com.metrolist.innertube.models.MusicResponsiveListItemRenderer
import com.metrolist.innertube.models.Run
import com.metrolist.innertube.models.SongItem
import com.metrolist.innertube.models.getMusicVideoType
import com.metrolist.innertube.models.getThumbnailUrl

data class AlbumPage(
    val album: AlbumItem,
    val songs: List<SongItem>,
    val otherVersions: List<AlbumItem>,
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

        fun getSong(renderer: MusicResponsiveListItemRenderer, album: AlbumItem? = null): SongItem? {
            val columns = renderer.flexColumns.orEmpty()
            val tokens = PageHelper.extractLibraryTokensFromMenuItems(renderer.menu?.menuRenderer?.items)
            val artistRuns = columns.getOrNull(1)?.musicResponsiveListItemFlexColumnRenderer?.text?.runs
            var artists = PageHelper.extractArtists(artistRuns)
            if (artists.isEmpty()) {
                val isPrivateOrOlak = album?.playlistId?.startsWith("OLAK") == true ||
                    album?.browseId?.startsWith("FEmusic_library_privately_owned_release_detail") == true
                if (isPrivateOrOlak && artistRuns != null) {
                    val firstSection = splitRunsBySeparator(artistRuns).firstOrNull().orEmpty()
                    artists = firstSection.filterIndexed { index, _ -> index % 2 == 0 }
                        .mapNotNull { run ->
                            val name = run.text?.trim().orEmpty()
                            if (name.isNotEmpty() && run.navigationEndpoint == null) Artist(id = null, name = name) else null
                        }
                }
            }
            if (artists.isEmpty()) {
                artists = album?.artists.orEmpty()
            }

            val videoId = renderer.playlistItemData?.videoId
                ?: renderer.navigationEndpoint?.watchEndpoint?.videoId
                ?: renderer.overlay?.musicItemThumbnailOverlayRenderer?.content?.musicPlayButtonRenderer?.playNavigationEndpoint?.watchEndpoint?.videoId
                ?: columns.firstOrNull()?.musicResponsiveListItemFlexColumnRenderer?.text?.runs?.firstOrNull()?.navigationEndpoint?.watchEndpoint?.videoId
                ?: return null

            val title = PageHelper.extractRuns(columns, "MUSIC_VIDEO").firstOrNull()?.text ?: return null
            val resolvedAlbum = if (album != null) {
                Album(id = album.browseId, name = album.title)
            } else {
                val albumRun = columns.getOrNull(2)?.musicResponsiveListItemFlexColumnRenderer?.text?.runs?.firstOrNull()
                    ?: return null
                val browseId = albumRun.navigationEndpoint?.browseEndpoint?.browseId ?: return null
                Album(id = browseId, name = albumRun.text.orEmpty())
            }

            val durationText = renderer.fixedColumns?.firstOrNull()
                ?.musicResponsiveListItemFlexColumnRenderer
                ?.text
                ?.runs
                ?.firstOrNull()
                ?.text ?: return null
            val duration = PageHelper.extractDuration(listOf(Run(text = durationText))) ?: return null
            val thumbnailUrl = renderer.thumbnail?.getThumbnailUrl() ?: album?.thumbnail ?: return null
            val explicit = renderer.badges?.any {
                it.musicInlineBadgeRenderer?.icon?.iconType == "MUSIC_EXPLICIT_BADGE"
            } == true

            return SongItem(
                id = videoId,
                title = title,
                artists = artists,
                album = resolvedAlbum,
                duration = duration,
                thumbnail = thumbnailUrl,
                explicit = explicit,
                musicVideoType = renderer.getMusicVideoType(),
                libraryAddToken = tokens.addToken,
                libraryRemoveToken = tokens.removeToken,
            )
        }
    }
}
