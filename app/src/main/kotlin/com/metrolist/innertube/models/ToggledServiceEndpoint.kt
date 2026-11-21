package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class ToggledServiceEndpoint(
    var feedbackEndpoint: FeedbackEndpoint? = null,
) : Endpoint()
