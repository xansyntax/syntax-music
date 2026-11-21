package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class ResponseContext(
    val serviceTrackingParams: List<ServiceTrackingParam>? = null,
    val visitorData: String? = null,
) {

    @Serializable
    data class ServiceTrackingParam(
        val params: List<Param>? = null,
        val service: String? = null,
    ) {

        @Serializable
        data class Param(
            val key: String? = null,
            val value: String? = null,
        )
    }
}
