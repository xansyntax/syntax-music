package com.metrolist.innertubex.models.body

import kotlinx.serialization.Serializable
import com.metrolist.innertubex.models.*

@Serializable
data class GetQueueBody(
    val context: Context? = null,
    val playlistId: String? = null,
    val videoIds: List<String>? = null,
)
