package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class ReturnYouTubeDislikeResponse(
    val dateCreated: String? = null,
    val deleted: Boolean? = null,
    val dislikes: Int? = null,
    val id: String? = null,
    val likes: Int? = null,
    val rating: Double? = null,
    val viewCount: Int? = null,
)
