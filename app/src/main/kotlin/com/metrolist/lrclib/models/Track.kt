package com.metrolist.lrclib.models

import kotlinx.serialization.Serializable

@Serializable
data class Track(
    val id: Int,
    val trackName: String,
    val artistName: String,
    val albumName: String? = null,
    val duration: Double,
    val instrumental: Boolean,
    val plainLyrics: String? = null,
    val syncedLyrics: String? = null,
)
