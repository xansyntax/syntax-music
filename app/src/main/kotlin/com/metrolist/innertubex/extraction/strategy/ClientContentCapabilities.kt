package com.metrolist.innertubex.extraction.strategy

import com.metrolist.innertubex.extraction.ContentHints

data class ClientContentCapabilities(
    val normal: CapabilitySupport = CapabilitySupport.SUPPORTED,
    val explicit: CapabilitySupport = CapabilitySupport.UNKNOWN,
    val kids: CapabilitySupport = CapabilitySupport.UNKNOWN,
    val ageRestricted: CapabilitySupport = CapabilitySupport.UNKNOWN,
    val live: CapabilitySupport = CapabilitySupport.UNKNOWN,
    val uploads: CapabilitySupport = CapabilitySupport.UNKNOWN,
) {
    fun supportFor(hints: ContentHints): CapabilitySupport {
        if (hints.isUploaded == true) {
            return uploads
        }
        if (hints.isAgeRestricted == true) {
            return ageRestricted
        }
        if (hints.isKidsContent == true) {
            return kids
        }
        return if (hints.isExplicit == true) explicit else normal
    }
}
