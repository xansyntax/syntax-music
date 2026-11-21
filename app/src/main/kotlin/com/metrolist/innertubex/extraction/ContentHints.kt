package com.metrolist.innertubex.extraction

data class ContentHints(
    val isExplicit: Boolean? = null,
    val isKidsContent: Boolean? = null,
    val isAgeRestricted: Boolean? = null,
    val isUploaded: Boolean? = null,
    val playbackClientOverrideId: String? = null,
) {
    var allowHls: Boolean = true
    var allowSabr: Boolean = true
    var allowBoundedRange: Boolean = true

    override fun toString(): String {
        return "{explicit=$isExplicit, kids=$isKidsContent, ageRestricted=$isAgeRestricted, live=null, uploaded=$isUploaded, local=null, endpointParamsPresent=false, wantVideo=false, clientOverride=$playbackClientOverrideId, sabrFirst=false, maxVideoHeight=null, premium=false, allowHls=$allowHls, allowSabr=$allowSabr, allowBoundedRange=$allowBoundedRange}"
    }
}
