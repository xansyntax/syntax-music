package com.metrolist.innertubex.extraction

import com.metrolist.innertubex.extraction.strategy.ClientFailureKind
import java.util.Locale

data class PlayabilityFailure(
    val status: String?,
    val reason: String?,
    val category: ClientFailureKind,
) {
    constructor(status: String?, reason: String?) : this(
        status = status,
        reason = reason,
        category = determineCategory(status),
    )

    companion object {
        private fun determineCategory(status: String?): ClientFailureKind {
            val upper = (status ?: "").uppercase(Locale.ROOT)
            return if (upper in setOf("AGE_CHECK_REQUIRED", "AGE_VERIFICATION_REQUIRED", "CONTENT_CHECK_REQUIRED") ||
                upper in setOf("UNPLAYABLE", "VIDEO_UNAVAILABLE", "LIVE_STREAM_OFFLINE") ||
                upper != "LOGIN_REQUIRED"
            ) {
                ClientFailureKind.PLAYABILITY
            } else {
                ClientFailureKind.TOKEN
            }
        }
    }
}
