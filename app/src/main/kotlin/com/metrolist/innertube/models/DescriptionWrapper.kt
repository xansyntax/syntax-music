package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class DescriptionWrapper(
    val musicDescriptionShelfRenderer: MusicDescriptionShelfRenderer? = null,
)
