package com.metrolist.innertube.pages

import com.metrolist.innertube.models.BrowseEndpoint
import com.metrolist.innertube.models.MusicCarouselShelfRenderer
import com.metrolist.innertube.models.YTItem
import com.metrolist.innertube.models.getThumbnailUrl

data class HomePage(
    val chips: List<Chip>? = null,
    val sections: List<Section>,
    val continuation: String? = null,
) {
    data class Chip(
        val title: String,
        val endpoint: BrowseEndpoint?,
        val deselectEndPoint: BrowseEndpoint?,
    )

    data class Section(
        val title: String,
        val label: String?,
        val thumbnail: String?,
        val endpoint: BrowseEndpoint?,
        val items: List<YTItem>,
    ) {
        companion object {
            fun fromMusicCarouselShelfRenderer(renderer: MusicCarouselShelfRenderer): Section? {
                val header = renderer.header?.musicCarouselShelfBasicHeaderRenderer ?: return null
                val title = header.title?.runs?.firstOrNull()?.text ?: return null
                val label = header.strapline?.runs?.firstOrNull()?.text
                val thumbnail = header.thumbnail?.getThumbnailUrl()
                val endpoint = header.moreContentButton?.buttonRenderer?.navigationEndpoint?.browseEndpoint
                val items = renderer.contents.orEmpty().mapNotNull { item ->
                    item.musicTwoRowItemRenderer?.let { ArtistItemsPage.fromMusicTwoRowItemRenderer(it) }
                        ?: item.musicResponsiveListItemRenderer?.let { ArtistPage.fromMusicResponsiveListItemRenderer(it) }
                }
                if (items.isEmpty()) return null
                return Section(
                    title = title,
                    label = label,
                    thumbnail = thumbnail,
                    endpoint = endpoint,
                    items = items,
                )
            }
        }
    }
}
