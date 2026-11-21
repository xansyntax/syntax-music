package com.metrolist.innertubex.extraction.strategy

import kotlinx.serialization.Serializable

@Serializable
enum class ClientFailureKind {
    PLAYER_REQUEST,
    PLAYABILITY,
    TOKEN,
    MEDIA_FORBIDDEN,
    MEDIA_FAILURE
}
