package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class Thumbnails(
    val thumbnails: List<Thumbnail>? = null,
)

fun Thumbnails.getThumbnailUrl(): String? =
    thumbnails?.lastOrNull()?.url
