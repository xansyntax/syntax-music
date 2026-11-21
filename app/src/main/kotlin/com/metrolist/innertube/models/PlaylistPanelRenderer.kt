package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class PlaylistPanelRenderer(
    val contents: List<Content>? = null,
    val continuations: List<Continuation>? = null,
    val isInfinite: Boolean? = null,
    val numItemsToShow: Int? = null,
    val playlistId: String? = null,
    val shortBylineText: Runs? = null,
    val title: String? = null,
    val titleText: Runs? = null,
) {

    @Serializable
    data class Content(
        val automixPreviewVideoRenderer: AutomixPreviewVideoRenderer? = null,
        val playlistPanelVideoRenderer: PlaylistPanelVideoRenderer? = null,
    )
}
