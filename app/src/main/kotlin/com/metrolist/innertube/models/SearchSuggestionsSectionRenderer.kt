package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class SearchSuggestionsSectionRenderer(
    val contents: List<Content>? = null,
) {

    @Serializable
    data class Content(
        val musicResponsiveListItemRenderer: MusicResponsiveListItemRenderer? = null,
        val searchSuggestionRenderer: SearchSuggestionRenderer? = null,
    ) {

        @Serializable
        data class SearchSuggestionRenderer(
            val navigationEndpoint: NavigationEndpoint? = null,
            val suggestion: Runs? = null,
        )
    }
}
