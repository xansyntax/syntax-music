package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class SubscriptionButton(
    val subscribeButtonRenderer: SubscribeButtonRenderer? = null,
) {

    @Serializable
    data class SubscribeButtonRenderer(
        val channelId: String? = null,
        val longSubscriberCountText: Runs? = null,
        val shortSubscriberCountText: Runs? = null,
        val subscribed: Boolean = false,
    )
}
