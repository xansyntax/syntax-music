package com.metrolist.innertubex.models.body

import kotlinx.serialization.Serializable
import com.metrolist.innertubex.models.*

@Serializable
data class CreatePlaylistBody(
    val context: Context? = null,
    val privacyStatus: String? = null,
    val title: String? = null,
    val videoIds: List<String>? = null,
)
