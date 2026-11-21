package com.metrolist.innertubex.extraction.strategy

import com.metrolist.innertubex.extraction.ContentHints
import kotlinx.serialization.Serializable

@Serializable
data class ClientHealthScope(
    val content: ClientHealthContent,
    val authenticated: Boolean,
    val wantVideo: Boolean = false,
) {
    companion object {
        fun from(hints: ContentHints, authenticated: Boolean): ClientHealthScope {
            val content = when {
                hints.isUploaded == true -> ClientHealthContent.UPLOAD
                hints.isAgeRestricted == true -> ClientHealthContent.AGE_RESTRICTED
                hints.isKidsContent == true -> ClientHealthContent.KIDS
                hints.isExplicit == true -> ClientHealthContent.EXPLICIT
                else -> ClientHealthContent.NORMAL
            }
            return ClientHealthScope(content, authenticated, wantVideo = false)
        }
    }
}
