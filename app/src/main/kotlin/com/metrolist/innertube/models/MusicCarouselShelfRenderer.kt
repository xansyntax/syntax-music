package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class MusicCarouselShelfRenderer(
    val contents: List<Content>? = null,
    val header: Header? = null,
    val itemSize: String? = null,
    val numItemsPerColumn: Int? = null,
) {

    @Serializable
    data class Content(
        val musicMultiRowListItemRenderer: MusicMultiRowListItemRenderer? = null,
        val musicNavigationButtonRenderer: MusicNavigationButtonRenderer? = null,
        val musicResponsiveListItemRenderer: MusicResponsiveListItemRenderer? = null,
        val musicTwoRowItemRenderer: MusicTwoRowItemRenderer? = null,
    )

    @Serializable
    data class Header(
        val musicCarouselShelfBasicHeaderRenderer: MusicCarouselShelfBasicHeaderRenderer? = null,
    ) {

        @Serializable
        data class MusicCarouselShelfBasicHeaderRenderer(
            val moreContentButton: Button? = null,
            val strapline: Runs? = null,
            val thumbnail: ThumbnailRenderer? = null,
            val title: Runs? = null,
        )
    }
}
