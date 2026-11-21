package com.metrolist.paxsenix.models

import kotlinx.serialization.Serializable

@Serializable
data class AppleMusicResults(
    val songs: AppleMusicSongsResult? = null,
)
