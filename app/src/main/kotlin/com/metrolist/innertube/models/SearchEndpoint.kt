package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class SearchEndpoint(
    val params: String? = null,
    val query: String? = null,
) : Endpoint()
