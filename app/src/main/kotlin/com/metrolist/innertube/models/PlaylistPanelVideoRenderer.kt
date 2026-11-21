package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class PlaylistPanelVideoRenderer(
    val badges: List<Badges>? = null,
    val lengthText: Runs? = null,
    val longBylineText: Runs? = null,
    val menu: Menu? = null,
    val navigationEndpoint: NavigationEndpoint? = null,
    val playlistSetVideoId: String? = null,
    val selected: Boolean = false,
    val shortBylineText: Runs? = null,
    val thumbnail: Thumbnails? = null,
    val title: Runs? = null,
    val unplayableText: Runs? = null,
    val videoId: String? = null,
)
