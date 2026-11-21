package com.metrolist.paxsenix.models

import kotlinx.serialization.Serializable

@Serializable
data class LyricText(
    val text: String,
    val timestamp: Long,
    val endtime: Long,
    val duration: Long,
    val part: Boolean = false,
)
