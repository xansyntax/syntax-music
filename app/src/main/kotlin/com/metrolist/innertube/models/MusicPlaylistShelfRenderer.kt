package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class MusicPlaylistShelfRenderer(
    val collapsedItemCount: Int? = null,
    val contents: List<MusicShelfRenderer.Content>? = null,
    val continuations: List<Continuation>? = null,
    val playlistId: String? = null,
)
