package com.metrolist.lastfm.models

import kotlinx.serialization.Serializable

@Serializable
data class Authentication(
    val session: Session,
) {
    @Serializable
    data class Session(
        val name: String,
        val key: String,
        val subscriber: Int,
    )
}
