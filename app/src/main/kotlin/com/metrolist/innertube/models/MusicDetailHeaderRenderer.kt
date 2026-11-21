package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class MusicDetailHeaderRenderer(
    val description: Runs? = null,
    val menu: Menu? = null,
    val secondSubtitle: Runs? = null,
    val subtitle: Runs? = null,
    val thumbnail: ThumbnailRenderer? = null,
    val title: Runs? = null,
)
