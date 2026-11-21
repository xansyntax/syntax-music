package com.metrolist.paxsenix.models

import kotlinx.serialization.Serializable

@Serializable
data class LyricsMetadata(
    val songwriters: List<String> = emptyList(),
)
