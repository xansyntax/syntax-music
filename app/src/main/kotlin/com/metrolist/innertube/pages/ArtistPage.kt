package com.metrolist.innertube.pages

import com.metrolist.innertube.models.Album
import com.metrolist.innertube.models.ArtistItem
import com.metrolist.innertube.models.BrowseEndpoint
import com.metrolist.innertube.models.MusicResponsiveListItemRenderer
import com.metrolist.innertube.models.Run
import com.metrolist.innertube.models.SectionListRenderer
import com.metrolist.innertube.models.SongItem
import com.metrolist.innertube.models.getMusicVideoType
import com.metrolist.innertube.models.getThumbnailUrl
import com.metrolist.innertube.models.getVideoId
import com.metrolist.innertube.models.isEpisode

data class ArtistPage(
    val artist: ArtistItem,
    val sections: List<ArtistSection>,
    val description: String?,
    val descriptionRuns: List<Run>?,
    val subscriberCountText: String?,
    val monthlyListenerCount: String?,
    val isSubscribed: Boolean,
) {
    companion object {
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

        fun fromSectionListRendererContent(content: SectionListRenderer.Content): ArtistSection? {
            content.musicShelfRenderer?.let { shelf ->
                val title = shelf.title?.runs?.firstOrNull()?.text ?: return null
                val items = shelf.contents.orEmpty().mapNotNull { shelfItem ->
                    shelfItem.musicResponsiveListItemRenderer?.let(::fromMusicResponsiveListItemRenderer)
                }
                if (items.isEmpty()) return null
                val moreEndpoint = shelf.bottomEndpoint?.browseEndpoint
                    ?: shelf.moreContentButton?.buttonRenderer?.navigationEndpoint?.browseEndpoint
                return ArtistSection(title = title, items = items, moreEndpoint = moreEndpoint)
            }
            content.musicCarouselShelfRenderer?.let { carousel ->
                val header = carousel.header?.musicCarouselShelfBasicHeaderRenderer ?: return null
                val title = header.title?.runs?.firstOrNull()?.text ?: return null
                val items = carousel.contents.orEmpty().mapNotNull { item ->
                    item.musicTwoRowItemRenderer?.let { ArtistItemsPage.fromMusicTwoRowItemRenderer(it) }
                        ?: item.musicResponsiveListItemRenderer?.let(::fromMusicResponsiveListItemRenderer)
                }
                if (items.isEmpty()) return null
                val moreEndpoint = header.moreContentButton?.buttonRenderer?.navigationEndpoint?.browseEndpoint
                return ArtistSection(title = title, items = items, moreEndpoint = moreEndpoint)
            }
            return null
        }
    }
}
