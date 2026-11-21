package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class MusicMultiRowListItemRenderer(
    val displayStyle: String? = null,
    val menu: Menu? = null,
    val onTap: NavigationEndpoint? = null,
    val playbackProgress: PlaybackProgress? = null,
    val secondSubtitle: Runs? = null,
    val secondarySubtitle: Runs? = null,
    val subtitle: Runs? = null,
    val thumbnail: ThumbnailRenderer? = null,
    val title: Runs? = null,
) {

    @Serializable
    data class PlaybackProgress(
        val value: Float? = null,
    )
}
