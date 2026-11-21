package com.metrolist.paxsenix.models

import kotlinx.serialization.Serializable

@Serializable
data class AppleMusicSongsResult(
    val data: List<AppleMusicSongData> = emptyList(),
)
