package com.metrolist.innertube.models.response

import kotlinx.serialization.Serializable
import com.metrolist.innertube.models.*

@Serializable
data class GetQueueResponse(
    val queueDatas: List<QueueData>? = null,
) {

    @Serializable
    data class QueueData(
        val content: PlaylistPanelRenderer.Content? = null,
    )
}
