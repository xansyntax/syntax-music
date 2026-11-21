package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class MusicDescriptionShelfRenderer(
    val description: Runs? = null,
    val footer: Runs? = null,
    val header: Runs? = null,
    val subheader: Runs? = null,
)
