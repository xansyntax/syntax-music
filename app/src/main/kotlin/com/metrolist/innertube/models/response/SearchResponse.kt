package com.metrolist.innertube.models.response

import kotlinx.serialization.Serializable
import com.metrolist.innertube.models.*

@Serializable
data class SearchResponse(
    val contents: Contents? = null,
    val continuationContents: ContinuationContents? = null,
) {

    @Serializable
    data class Contents(
        val tabbedSearchResultsRenderer: Tabs? = null,
    )

    @Serializable
    data class ContinuationContents(
        val musicShelfContinuation: MusicShelfContinuation? = null,
    ) {

        @Serializable
        data class MusicShelfContinuation(
            val contents: List<Content>? = null,
            val continuations: List<Continuation>? = null,
        ) {

            @Serializable
            data class Content(
                val musicResponsiveListItemRenderer: MusicResponsiveListItemRenderer? = null,
            )
        }
    }
}
