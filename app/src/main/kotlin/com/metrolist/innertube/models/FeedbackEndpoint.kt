package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class FeedbackEndpoint(
    val feedbackToken: String? = null,
) : Endpoint()
