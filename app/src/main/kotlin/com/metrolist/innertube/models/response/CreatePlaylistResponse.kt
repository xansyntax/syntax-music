package com.metrolist.innertube.models.response

import kotlinx.serialization.Serializable
import com.metrolist.innertube.models.*

@Serializable
data class CreatePlaylistResponse(
    val playlistId: String? = null,
)
