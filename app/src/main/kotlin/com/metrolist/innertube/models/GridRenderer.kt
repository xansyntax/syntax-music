package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class GridRenderer(
    val continuations: List<Continuation>? = null,
    val header: Header? = null,
    val items: List<Item>? = null,
) {

    @Serializable
    data class Header(
        val gridHeaderRenderer: GridHeaderRenderer? = null,
    ) {

        @Serializable
        data class GridHeaderRenderer(
            val title: Runs? = null,
        )
    }

    @Serializable
    data class Item(
        val musicNavigationButtonRenderer: MusicNavigationButtonRenderer? = null,
        val musicTwoRowItemRenderer: MusicTwoRowItemRenderer? = null,
    )
}
