package com.metrolist.innertube.models.response

import kotlinx.serialization.Serializable
import com.metrolist.innertube.models.*

@Serializable
data class EditPlaylistResponse(
    val newHeader: BrowseResponse.Header? = null,
)
