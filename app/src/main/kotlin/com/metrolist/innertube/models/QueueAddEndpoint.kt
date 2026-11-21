package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class QueueAddEndpoint(
    val queueInsertPosition: String? = null,
    val queueTarget: QueueTarget? = null,
) : Endpoint() {

    @Serializable
    data class QueueTarget(
        val playlistId: String? = null,
        val videoId: String? = null,
    )
}
