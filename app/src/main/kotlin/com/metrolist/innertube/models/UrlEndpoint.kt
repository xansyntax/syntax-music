package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class UrlEndpoint(
    val target: String? = null,
    val url: String? = null,
)
