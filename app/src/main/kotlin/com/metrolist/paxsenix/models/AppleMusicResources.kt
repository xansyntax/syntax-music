package com.metrolist.paxsenix.models

import kotlinx.serialization.Serializable

@Serializable
data class AppleMusicResources(
    val songs: Map<String, AppleMusicSongDetail>? = null,
)
