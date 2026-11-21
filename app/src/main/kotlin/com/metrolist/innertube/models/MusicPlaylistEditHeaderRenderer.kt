package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class MusicPlaylistEditHeaderRenderer(
    val editTitle: Runs? = null,
)
