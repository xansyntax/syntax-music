package com.metrolist.innertubex.sabr

data class SabrFormatId(
    val itag: Int,
    val lastModified: Long,
    val xtags: String? = null,
)
