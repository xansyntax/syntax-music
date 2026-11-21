package com.metrolist.innertubex.extraction

import com.metrolist.innertubex.extraction.strategy.PoTokenProviderKind

data class TokenProviderCapabilities(
    val providers: Set<PoTokenProviderKind> = emptySet(),
    val usesWebView: Boolean = false,
)
