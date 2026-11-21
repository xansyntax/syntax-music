package com.metrolist.innertubex.extraction.strategy

import com.metrolist.innertubex.extraction.ContentHints

data class ClientSelectionRequest(
    val hints: ContentHints,
    val authenticated: Boolean,
    val availablePoTokenProviders: Set<PoTokenProviderKind>,
    val javaScriptRuntimeAvailable: Boolean,
    val webViewAvailable: Boolean,
    val fastPathOnly: Boolean,
    val transportPreference: PlaybackTransportPreference,
    val excludedClients: Set<String>,
) {
    override fun toString(): String {
        return "ClientSelectionRequest(hints=$hints, authenticated=$authenticated, premium=false, availablePoTokenProviders=$availablePoTokenProviders, javaScriptRuntimeAvailable=$javaScriptRuntimeAvailable, webViewAvailable=$webViewAvailable, fastPathOnly=$fastPathOnly, transportPreference=$transportPreference, excludedClients=$excludedClients)"
    }
}
