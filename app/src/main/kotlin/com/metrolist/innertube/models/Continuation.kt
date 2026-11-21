package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class Continuation(
    val nextContinuationData: NextContinuationData? = null,
) {

    @Serializable
    data class NextContinuationData(
        val continuation: String? = null,
    )
}

fun List<Continuation>.getContinuation(): String? =
    firstOrNull()?.nextContinuationData?.continuation
