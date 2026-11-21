package com.metrolist.innertube.pages

import com.metrolist.innertube.models.AlbumItem
import com.metrolist.innertube.models.ArtistItem
import com.metrolist.innertube.models.MusicCardShelfRenderer
import com.metrolist.innertube.models.PlaylistItem
import com.metrolist.innertube.models.PodcastItem
import com.metrolist.innertube.models.SongItem
import com.metrolist.innertube.models.YTItem
import com.metrolist.innertube.models.getMusicVideoType
import com.metrolist.innertube.models.getThumbnailUrl

data class SearchSummaryPage(
    val summaries: List<SearchSummary>,
) {
    companion object {
        fun fromMusicCardShelfRenderer(renderer: MusicCardShelfRenderer): YTItem? {
            val title = renderer.title?.runs?.firstOrNull()?.text ?: return null
            val subtitleRuns = renderer.subtitle?.runs
            val thumbnailUrl = renderer.thumbnail?.getThumbnailUrl() ?: return null
            val explicit = renderer.subtitleBadges?.any {
                it.musicInlineBadgeRenderer?.icon?.iconType == "MUSIC_EXPLICIT_BADGE"
            } == true
            val buttons = renderer.buttons.orEmpty()
            val nav = renderer.onTap

            nav?.watchEndpoint?.let { watch ->
                val videoId = watch.videoId ?: return null
                val artists = PageHelper.extractArtists(subtitleRuns)
                val duration = subtitleRuns?.let { PageHelper.extractDuration(it) }
                return SongItem(
                    id = videoId,
                    title = title,
                    artists = artists,
                    duration = duration,
                    thumbnail = thumbnailUrl,
                    explicit = explicit,
                    endpoint = watch,
                    musicVideoType = nav.getMusicVideoType(),
                )
            }

            val browse = nav?.browseEndpoint ?: return null
            val browseId = browse.browseId ?: return null
            val pageType = browse.browseEndpointContextSupportedConfigs?.browseEndpointContextMusicConfig?.pageType
            return when (pageType) {
                "MUSIC_PAGE_TYPE_ALBUM", "MUSIC_PAGE_TYPE_AUDIOBOOK" -> {
                    val firstButtonCmd = buttons.firstOrNull()?.buttonRenderer?.command
                    val playlistId = firstButtonCmd?.watchEndpoint?.playlistId
                        ?: firstButtonCmd?.watchPlaylistEndpoint?.playlistId
                        ?: browseId.removePrefix("MPREb_").let { "OLAK5uy_$it" }
                    AlbumItem(
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
                    val playButton = buttons.firstOrNull { it.buttonRenderer?.icon?.iconType == "PLAY_ARROW" }
                    val shuffleButton = buttons.firstOrNull { it.buttonRenderer?.icon?.iconType == "MUSIC_SHUFFLE" }
                    PlaylistItem(
                        id = browseId.removePrefix("VL"),
                        title = title,
                        author = PageHelper.extractArtists(subtitleRuns).firstOrNull(),
                        thumbnail = thumbnailUrl,
                        playEndpoint = playButton?.buttonRenderer?.navigationEndpoint?.watchPlaylistEndpoint,
                        shuffleEndpoint = shuffleButton?.buttonRenderer?.navigationEndpoint?.watchPlaylistEndpoint,
                    )
                }
                "MUSIC_PAGE_TYPE_ARTIST" -> ArtistItem(
                    id = browseId,
                    title = title,
                    thumbnail = thumbnailUrl,
                )
                "MUSIC_PAGE_TYPE_PODCAST_SHOW_DETAIL_PAGE" -> {
                    val playButton = buttons.firstOrNull { it.buttonRenderer?.icon?.iconType == "PLAY_ARROW" }
                    val shuffleButton = buttons.firstOrNull { it.buttonRenderer?.icon?.iconType == "MUSIC_SHUFFLE" }
                    PodcastItem(
                        id = browseId,
                        title = title,
                        author = PageHelper.extractArtists(subtitleRuns).firstOrNull(),
                        thumbnail = thumbnailUrl,
                        playEndpoint = playButton?.buttonRenderer?.navigationEndpoint?.watchPlaylistEndpoint,
                        shuffleEndpoint = shuffleButton?.buttonRenderer?.navigationEndpoint?.watchPlaylistEndpoint,
                    )
                }
                else -> null
            }
        }
    }
}
