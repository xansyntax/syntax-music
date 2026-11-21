package com.metrolist.innertubex.models.body

import kotlinx.serialization.Serializable
import com.metrolist.innertubex.models.*

@Serializable
data class SubscribeBody(
    val channelIds: List<String>? = null,
    val context: Context? = null,
    val params: String? = null,
)
