package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class MusicResponsiveHeaderRenderer(
    val buttons: List<Button>? = null,
    val description: DescriptionWrapper? = null,
    val facepile: FacepileWrapper? = null,
    val secondSubtitle: Runs? = null,
    val straplineTextOne: Runs? = null,
    val subtitle: Runs? = null,
    val thumbnail: ThumbnailRenderer? = null,
    val title: Runs? = null,
) {

    @Serializable
    data class Button(
        val menuRenderer: Menu.MenuRenderer? = null,
        val musicPlayButtonRenderer: MusicPlayButtonRenderer? = null,
        val toggleButtonRenderer: ToggleButtonRenderer? = null,
    ) {

        @Serializable
        data class MusicPlayButtonRenderer(
            val playNavigationEndpoint: NavigationEndpoint? = null,
        )

        @Serializable
        data class ToggleButtonRenderer(
            val defaultIcon: Icon? = null,
            val defaultServiceEndpoint: DefaultServiceEndpoint? = null,
            val toggledServiceEndpoint: ToggledServiceEndpoint? = null,
        )
    }
}
