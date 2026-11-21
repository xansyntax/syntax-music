package com.metrolist.paxsenix.models

import kotlinx.serialization.Serializable

@Serializable
data class AppleMusicSearchResponse(
    val results: AppleMusicResults,
    val resources: AppleMusicResources? = null,
)
