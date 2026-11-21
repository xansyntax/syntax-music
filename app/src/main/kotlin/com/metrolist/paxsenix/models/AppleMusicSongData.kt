package com.metrolist.paxsenix.models

import kotlinx.serialization.Serializable

@Serializable
data class AppleMusicSongData(
    val id: String,
    val type: String,
)
