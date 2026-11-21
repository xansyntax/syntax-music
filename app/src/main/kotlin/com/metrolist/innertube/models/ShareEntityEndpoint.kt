package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class ShareEntityEndpoint(
    val serializedShareEntity: String? = null,
) : Endpoint()
