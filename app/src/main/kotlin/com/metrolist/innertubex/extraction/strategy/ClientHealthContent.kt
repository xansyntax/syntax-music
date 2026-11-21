package com.metrolist.innertubex.extraction.strategy

import kotlinx.serialization.Serializable

@Serializable
enum class ClientHealthContent {
    NORMAL,
    EXPLICIT,
    KIDS,
    AGE_RESTRICTED,
    LIVE,
    UPLOAD
}
