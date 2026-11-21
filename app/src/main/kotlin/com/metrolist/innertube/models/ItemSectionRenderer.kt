package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class ItemSectionRenderer(
    val contents: List<Content>? = null,
    val header: Header? = null,
) {

    @Serializable
    data class Content(
        val gridRenderer: GridRenderer? = null,
        val musicPlaylistShelfRenderer: MusicPlaylistShelfRenderer? = null,
        val musicResponsiveListItemRenderer: MusicResponsiveListItemRenderer? = null,
        val musicShelfRenderer: MusicShelfRenderer? = null,
    )

    @Serializable
    data class Header(
        val itemSectionTabbedHeaderRenderer: ItemSectionTabbedHeaderRenderer? = null,
    ) {

        @Serializable
        data class ItemSectionTabbedHeaderRenderer(
            val title: Runs? = null,
        )
    }
}
