package com.metrolist.paxsenix.models

import kotlinx.serialization.Serializable

@Serializable
data class AppleMusicSongAttributes(
    val name: String,
    val artistName: String,
    val albumName: String? = null,
    val artwork: AppleMusicArtwork? = null,
    val url: String? = null,
    val durationInMillis: Long? = null,
)
