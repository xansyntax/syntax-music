package com.metrolist.lastfm.models

import kotlinx.serialization.Serializable

@Serializable
data class LastFmError(
    val error: Int,
    val message: String,
)
