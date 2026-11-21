package com.metrolist.innertubex.extraction.strategy

import com.metrolist.innertubex.models.YouTubeClient

data class PlaybackClientOption(
    val id: String,
    val displayName: String,
    val client: YouTubeClient,
    val manifest: PlaybackClientManifest,
)
