package com.metrolist.innertube.pages

import com.metrolist.innertube.models.BrowseEndpoint
import com.metrolist.innertube.models.SectionListRenderer

data class MoodAndGenres(
    val title: String,
    val items: List<Item>,
) {
    data class Item(
        val title: String,
        val stripeColor: Long,
        val endpoint: BrowseEndpoint,
    )

    companion object {
        fun fromSectionListRendererContent(content: SectionListRenderer.Content): MoodAndGenres? {
            val grid = content.gridRenderer ?: return null
            val title = grid.header?.gridHeaderRenderer?.title?.runs?.firstOrNull()?.text ?: return null
            val items = grid.items.orEmpty().mapNotNull { gridItem ->
                val btn = gridItem.musicNavigationButtonRenderer ?: return@mapNotNull null
                val itemTitle = btn.buttonText?.runs?.firstOrNull()?.text ?: return@mapNotNull null
                val stripeColor = btn.solid?.leftStripeColor ?: return@mapNotNull null
                val endpoint = btn.clickCommand?.browseEndpoint ?: return@mapNotNull null
                Item(title = itemTitle, stripeColor = stripeColor, endpoint = endpoint)
            }
            return MoodAndGenres(title = title, items = items)
        }
    }
}
