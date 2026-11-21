package com.metrolist.innertubex.models

import kotlinx.serialization.Serializable

@Serializable
data class YouTubeLocale(
    val gl: String,
    val hl: String,
) {
    internal fun acceptLanguageHeader(): String {
        val normalizedHl = hl.replace('_', '-')
        val full = if (normalizedHl.contains('-')) {
            normalizedHl
        } else {
            if (gl.isEmpty()) normalizedHl else "$normalizedHl-$gl"
        }
        val primary = normalizedHl.substringBefore('-')
        return if (full == primary) {
            full
        } else {
            "$full,$primary;q=0.9"
        }
    }
}
