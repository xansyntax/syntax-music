package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class MusicShelfRenderer(
    val bottomEndpoint: NavigationEndpoint? = null,
    val contents: List<Content>? = null,
    val continuations: List<Continuation>? = null,
    val moreContentButton: Button? = null,
    val title: Runs? = null,
) {

    @Serializable
    data class Content(
        val continuationItemRenderer: ContinuationItemRenderer? = null,
        val musicMultiRowListItemRenderer: MusicMultiRowListItemRenderer? = null,
        val musicResponsiveListItemRenderer: MusicResponsiveListItemRenderer? = null,
    )
}

fun List<MusicShelfRenderer.Content>.getContinuation(): String? =
    firstOrNull { it.continuationItemRenderer != null }
        ?.continuationItemRenderer
        ?.continuationEndpoint
        ?.continuationCommand
        ?.token

fun List<MusicShelfRenderer.Content>.getItems(): List<MusicResponsiveListItemRenderer> =
    mapNotNull { it.musicResponsiveListItemRenderer }
