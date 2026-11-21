package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class MusicCardShelfRenderer(
    val buttons: List<Button>? = null,
    val contents: List<Content>? = null,
    val header: Header? = null,
    val onTap: NavigationEndpoint? = null,
    val subtitle: Runs? = null,
    val subtitleBadges: List<Badges>? = null,
    val thumbnail: ThumbnailRenderer? = null,
    val title: Runs? = null,
) {

    @Serializable
    data class Content(
        val musicResponsiveListItemRenderer: MusicResponsiveListItemRenderer? = null,
    )

    @Serializable
    data class Header(
        val musicCardShelfHeaderBasicRenderer: MusicCardShelfHeaderBasicRenderer? = null,
    ) {

        @Serializable
        data class MusicCardShelfHeaderBasicRenderer(
            val title: Runs? = null,
        )
    }
}
