package com.metrolist.innertubex.models.body

import kotlinx.serialization.Serializable
import com.metrolist.innertubex.models.*

@Serializable
data class BrowseBody(
    val browseId: String? = null,
    val context: Context? = null,
    val continuation: String? = null,
    val params: String? = null,
)
