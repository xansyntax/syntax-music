package com.metrolist.innertubex.extraction.strategy

import com.metrolist.innertubex.models.YouTubeClient

data class SelectedClient(
    val client: YouTubeClient,
    val manifest: PlaybackClientManifest?,
    val score: Int,
    val reasons: List<String>,
)
