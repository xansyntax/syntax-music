package com.metrolist.innertubex.models.body

import kotlinx.serialization.Serializable
import com.metrolist.innertubex.models.*

@Serializable
data class NextBody(
    val contentCheckOk: Boolean = false,
    val context: Context? = null,
    val continuation: String? = null,
    val index: Int? = null,
    val params: String? = null,
    val playlistId: String? = null,
    val playlistSetVideoId: String? = null,
    val racyCheckOk: Boolean = false,
    val videoId: String? = null,
)
