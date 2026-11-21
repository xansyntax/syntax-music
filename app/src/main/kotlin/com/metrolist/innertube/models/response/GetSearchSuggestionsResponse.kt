package com.metrolist.innertube.models.response

import kotlinx.serialization.Serializable
import com.metrolist.innertube.models.*

@Serializable
data class GetSearchSuggestionsResponse(
    val contents: List<Content>? = null,
) {

    @Serializable
    data class Content(
        val searchSuggestionsSectionRenderer: SearchSuggestionsSectionRenderer? = null,
    )
}
