package com.metrolist.innertubex.models.body

import kotlinx.serialization.Serializable
import com.metrolist.innertubex.models.*

@Serializable
data class GetTranscriptBody(
    val context: Context? = null,
    val params: String? = null,
)
