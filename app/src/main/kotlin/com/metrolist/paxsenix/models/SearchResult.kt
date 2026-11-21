package com.metrolist.paxsenix.models

import kotlinx.serialization.Serializable

@Serializable
data class SearchResult(
    val id: String,
    val songName: String? = null,
    val trackName: String? = null,
    val artistName: String? = null,
    val albumName: String? = null,
    val duration: Int? = null,
    val artwork: String? = null,
)
