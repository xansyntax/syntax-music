package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class DefaultServiceEndpoint(
    var feedbackEndpoint: FeedbackEndpoint? = null,
    var subscribeEndpoint: SubscribeEndpoint? = null,
) : Endpoint() {

    @Serializable
    data class SubscribeEndpoint(
        val channelIds: List<String>? = null,
        val params: String? = null,
    ) : Endpoint()
}
