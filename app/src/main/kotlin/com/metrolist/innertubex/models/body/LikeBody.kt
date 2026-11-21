package com.metrolist.innertubex.models.body

import kotlinx.serialization.Serializable
import com.metrolist.innertubex.models.*

@Serializable
data class LikeBody(
    val context: Context? = null,
    val target: Target? = null,
) {

    @Serializable
    data class Target(
        val playlistId: String? = null,
        val videoId: String? = null,
    )
}
