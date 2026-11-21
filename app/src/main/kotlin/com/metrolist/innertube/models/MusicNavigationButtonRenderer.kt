package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class MusicNavigationButtonRenderer(
    val buttonText: Runs? = null,
    val clickCommand: NavigationEndpoint? = null,
    val iconStyle: IconStyle? = null,
    val solid: Solid? = null,
) {

    @Serializable
    data class IconStyle(
        val icon: Icon? = null,
    )

    @Serializable
    data class Solid(
        val leftStripeColor: Long = 0L,
    )
}
