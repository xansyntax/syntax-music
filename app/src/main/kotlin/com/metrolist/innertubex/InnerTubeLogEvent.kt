package com.metrolist.innertubex

data class InnerTubeLogEvent(
    val level: InnerTubeLogLevel,
    val tag: String,
    val message: String,
    val mediaId: String? = null,
    val details: Map<String, String> = emptyMap(),
)
