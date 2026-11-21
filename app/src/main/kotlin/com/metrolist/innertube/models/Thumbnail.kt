package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class Thumbnail(
    val height: Int? = null,
    val url: String? = null,
    val width: Int? = null,
)
