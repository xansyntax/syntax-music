package com.metrolist.innertube.models.response

import kotlinx.serialization.Serializable
import com.metrolist.innertube.models.*

@Serializable
data class FeedbackResponse(
    val feedbackResponses: List<Status>? = null,
) {

    @Serializable
    data class Status(
        val isProcessed: Boolean = false,
    )
}
