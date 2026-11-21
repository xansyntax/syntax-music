package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class Button(
    val buttonRenderer: ButtonRenderer? = null,
) {

    @Serializable
    data class ButtonRenderer(
        val command: NavigationEndpoint? = null,
        val icon: Icon? = null,
        val navigationEndpoint: NavigationEndpoint? = null,
        val text: Runs? = null,
    )
}
