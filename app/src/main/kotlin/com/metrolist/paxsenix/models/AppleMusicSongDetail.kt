package com.metrolist.paxsenix.models

import kotlinx.serialization.Serializable

@Serializable
data class AppleMusicSongDetail(
    val attributes: AppleMusicSongAttributes,
)
