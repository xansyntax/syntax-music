package com.metrolist.innertubex.models.body

import kotlinx.serialization.Serializable
import com.metrolist.innertubex.models.*

@Serializable
data class SearchBody(
    val context: Context? = null,
    val params: String? = null,
    val query: String? = null,
)
