package com.metrolist.shazamkit.models

import kotlinx.serialization.Serializable

@Serializable
data class ShazamRequestJson(
    val geolocation: Geolocation,
    val signature: Signature,
    val timestamp: Long,
    val timezone: String,
) {
    @Serializable
    data class Geolocation(
        val altitude: Double = 300.0,
        val latitude: Double = 45.0,
        val longitude: Double = 2.0,
    )

    @Serializable
    data class Signature(
        val samplems: Long,
        val timestamp: Long,
        val uri: String,
    )
}
