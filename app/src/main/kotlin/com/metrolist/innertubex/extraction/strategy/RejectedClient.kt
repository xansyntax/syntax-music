package com.metrolist.innertubex.extraction.strategy

data class RejectedClient(
    val manifest: PlaybackClientManifest,
    val reasons: List<String>,
)
