package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class Run(
    val navigationEndpoint: NavigationEndpoint? = null,
    val text: String? = null,
)
