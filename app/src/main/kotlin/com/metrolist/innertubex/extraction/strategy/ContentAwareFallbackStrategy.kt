package com.metrolist.innertubex.extraction.strategy

import com.metrolist.innertubex.models.YouTubeClient

class ContentAwareFallbackStrategy : ClientFallbackStrategy {

    fun hardRejectionReasons(
        playbackClientManifest: PlaybackClientManifest,
        clientSelectionRequest: ClientSelectionRequest,
        checkContentSupport: Boolean,
    ): List<String> {
        val reasons = mutableListOf<String>()
        val authenticated = clientSelectionRequest.authenticated
        val lifecycle = playbackClientManifest.lifecycle
        val poTokens = playbackClientManifest.poTokens
        val id = playbackClientManifest.id
        val request = playbackClientManifest.request

        if (lifecycle == ClientLifecycle.BROKEN) {
            reasons.add("client marked broken")
        }
        if (playbackClientManifest.authentication == AuthenticationPolicy.REQUIRED && !authenticated) {
            reasons.add("login required")
        }
        val contentHints = clientSelectionRequest.hints
        val jsAvailable = clientSelectionRequest.javaScriptRuntimeAvailable
        if (contentHints.isUploaded == true && !authenticated) {
            reasons.add("uploads require login")
        }
        val support = playbackClientManifest.content.supportFor(contentHints)
        if (checkContentSupport && support == CapabilitySupport.UNSUPPORTED) {
            reasons.add("content type unsupported")
        }
        if (checkContentSupport && id == "VISIONOS_0_1" && support != CapabilitySupport.SUPPORTED) {
            reasons.add("legacy direct playback verified for normal audio only")
        }
        if (!jsAvailable && request.signatureCipher == JavaScriptRequirement.REQUIRED) {
            reasons.add("signature transform unavailable")
        }
        if (!jsAvailable && request.nTransform == JavaScriptRequirement.REQUIRED) {
            reasons.add("n-transform unavailable")
        }
        if (request.webView == WebViewRequirement.FULL_PLAYER && !clientSelectionRequest.webViewAvailable) {
            reasons.add("full WebView runtime unavailable")
        }
        val rules = listOf("player" to poTokens.player, "GVS" to poTokens.gvs)
        val missingTokenProviders = mutableListOf<String>()
        for ((name, rule) in rules) {
            if (rule.requirement == PoTokenRequirement.REQUIRED) {
                val hasProvider = rule.providers.any { clientSelectionRequest.availablePoTokenProviders.contains(it) }
                if (!hasProvider) {
                    missingTokenProviders.add(name)
                    break
                }
            }
        }
        if (missingTokenProviders.isNotEmpty()) {
            reasons.add(missingTokenProviders.joinToString("+") + " PO-token provider unavailable")
        }
        if (clientSelectionRequest.fastPathOnly) {
            if (request.signatureTimestamp) {
                reasons.add("watch config excluded from fast path")
            }
            val checkRules = listOf(poTokens.player, poTokens.gvs)
            if (checkRules.any { it.requirement == PoTokenRequirement.REQUIRED }) {
                reasons.add("token generation excluded from fast path")
            }
            if (request.signatureCipher == JavaScriptRequirement.REQUIRED) {
                reasons.add("signature transform excluded from fast path")
            }
            if (request.nTransform == JavaScriptRequirement.REQUIRED) {
                reasons.add("n-transform excluded from fast path")
            }
        }
        return reasons
    }

    fun isExcluded(
        playbackClientManifest: PlaybackClientManifest,
        excluded: Set<*>,
        availablePoTokenProviders: Set<PoTokenProviderKind>,
        premium: Boolean = false,
    ): Boolean {
        if (excluded.contains(playbackClientManifest.client.clientName) || excluded.contains(playbackClientManifest.id)) {
            return true
        }
        val nopoIds = PlaybackClientCatalog.profileIds(playbackClientManifest, false)
        val z2 = nopoIds.any { excluded.contains(it) }

        val poIds = PlaybackClientCatalog.profileIds(playbackClientManifest, true)
        val z3 = poIds.any { excluded.contains(it) }

        val rules = listOf(playbackClientManifest.poTokens.player, playbackClientManifest.poTokens.gvs)
        val hasSupportedTokenProvider = rules.any { rule ->
            rule.requirement != PoTokenRequirement.NONE && rule.providers.any { availablePoTokenProviders.contains(it) }
        }
        val requiresToken = rules.any { rule ->
            rule.requirement == PoTokenRequirement.REQUIRED && (!premium || !rule.premiumMayBypass)
        }

        if ((!z2 || !z3) && ((hasSupportedTokenProvider || !z2) && (!requiresToken || !z3))) {
            return false
        }
        return true
    }

    fun selectClients(
        clientSelectionRequest: ClientSelectionRequest,
        allowFastPath: Boolean = false,
        allowProbing: Boolean = false,
    ): ClientSelectionResult {
        val availableProviders = clientSelectionRequest.availablePoTokenProviders
        val excluded = clientSelectionRequest.excludedClients
        val rejectedClients = mutableListOf<RejectedClient>()
        val hints = clientSelectionRequest.hints
        val overrideId = hints.playbackClientOverrideId

        if (overrideId != null) {
            val option = PlaybackClientCatalog.find(overrideId)
            if (option != null) {
                val manifest = option.manifest
                val hardReasons = hardRejectionReasons(manifest, clientSelectionRequest, false)
                if (isExcluded(manifest, excluded, availableProviders, false)) {
                    val reasons = if (hardReasons.isEmpty()) listOf("manual override recently failed") else hardReasons
                    rejectedClients.add(RejectedClient(manifest, reasons))
                } else {
                    val reasons = hardReasons.map { "ignored: $it" } + "manual override"
                    return ClientSelectionResult(
                        candidates = listOf(SelectedClient(option.client, manifest, Int.MAX_VALUE, reasons)),
                        rejected = emptyList(),
                    )
                }
            }
        }

        val candidates = mutableListOf<SelectedClient>()
        val visionOs01Option = PlaybackClientCatalog.find("VISIONOS_0_1")
        val visionOs01Manifest = if (visionOs01Option != null && allowProbing && visionOs01Option.manifest.selectionMode == ClientSelectionMode.PROBE_ONLY) {
            visionOs01Option.manifest
        } else {
            null
        }
        val pool = listOfNotNull(visionOs01Manifest) + PlaybackClientCatalog.automaticManifests

        for (manifest in pool) {
            if (!isExcluded(manifest, excluded, availableProviders, false)) {
                val hardReasons = hardRejectionReasons(manifest, clientSelectionRequest, true)
                if (hardReasons.isEmpty()) {
                    var score = manifest.priority.toInt()
                    val reasons = mutableListOf("base=${manifest.priority}")

                    fun adjust(delta: Int, reason: String) {
                        score += delta
                        reasons.add("$reason=${if (delta >= 0) "+" else ""}$delta")
                    }

                    val auth = manifest.authentication
                    val id = manifest.id
                    val reqCaps = manifest.request
                    val transports = manifest.transports
                    val authenticated = clientSelectionRequest.authenticated

                    if (id == "VISIONOS_SABR") {
                        adjust(80, "sabr-audio-playback")
                    }
                    if ((hints.isExplicit == true || hints.isKidsContent == true || hints.isAgeRestricted == true || hints.isUploaded == true) && auth == AuthenticationPolicy.OPTIONAL) {
                        adjust(if (authenticated) 18 else -18, if (authenticated) "authenticated" else "signed-out")
                    }
                    if (auth == AuthenticationPolicy.REQUIRED) {
                        adjust(8, "auth-specialist")
                    }

                    when (clientSelectionRequest.transportPreference) {
                        PlaybackTransportPreference.AUTO -> {
                            if (transports.contains(PlaybackTransport.DIRECT)) {
                                adjust(10, "direct-fast-path")
                            }
                        }
                        PlaybackTransportPreference.DIRECT -> {
                            adjust(if (transports.contains(PlaybackTransport.DIRECT)) 30 else -30, "direct-preference")
                        }
                        PlaybackTransportPreference.SABR -> {
                            adjust(if (transports.contains(PlaybackTransport.SABR)) 30 else -30, "sabr-preference")
                        }
                        PlaybackTransportPreference.HLS -> {
                            adjust(if (transports.contains(PlaybackTransport.HLS)) 30 else -30, "hls-preference")
                        }
                    }

                    when (manifest.lifecycle) {
                        ClientLifecycle.STABLE -> {}
                        ClientLifecycle.CANARY -> adjust(-15, "canary")
                        ClientLifecycle.EXPERIMENTAL -> adjust(-10, "experimental")
                        ClientLifecycle.UNRELEASED -> adjust(-5, "unreleased")
                        ClientLifecycle.DEPRECATED -> adjust(-20, "deprecated")
                        ClientLifecycle.BROKEN -> adjust(-100, "broken")
                    }

                    val poRules = listOf(manifest.poTokens.player, manifest.poTokens.gvs)
                    val requiredTokenCount = poRules.count { it.requirement == PoTokenRequirement.REQUIRED }
                    val optionalTokenCount = poRules.count { it.requirement == PoTokenRequirement.OPTIONAL }
                    if (requiredTokenCount > 0) {
                        adjust(requiredTokenCount * -12, "required-token")
                    }
                    if (optionalTokenCount > 0) {
                        adjust(optionalTokenCount * -4, "optional-token")
                    }

                    if (reqCaps.nTransform == JavaScriptRequirement.RESPONSE_DEPENDENT) {
                        adjust(-4, "possible-n-transform")
                    }
                    if (reqCaps.signatureCipher == JavaScriptRequirement.RESPONSE_DEPENDENT) {
                        adjust(-3, "possible-cipher")
                    }

                    when (reqCaps.webView) {
                        WebViewRequirement.NONE -> {}
                        WebViewRequirement.OPTIONAL_TOKEN_MINTING -> adjust(-2, "optional-web-runtime")
                        WebViewRequirement.REQUIRED_TOKEN_MINTING -> adjust(-8, "token-web-runtime")
                        WebViewRequirement.FULL_PLAYER -> adjust(-25, "full-webview")
                    }

                    candidates.add(SelectedClient(manifest.client, manifest, score, reasons))
                } else {
                    rejectedClients.add(RejectedClient(manifest, hardReasons))
                }
            }
        }

        val sortedCandidates = candidates.sortedWith(
            compareBy<SelectedClient> { client ->
                when (clientSelectionRequest.transportPreference) {
                    PlaybackTransportPreference.AUTO -> {
                        if (client.client.useSabr) 2
                        else if (hints.isKidsContent == true) {
                            if (client.client == YouTubeClient.WEB_KIDS) 0 else 1
                        } else 1
                    }
                    PlaybackTransportPreference.SABR -> {
                        if (!client.client.useSabr) 1 else 0
                    }
                    else -> 0
                }
            }.thenByDescending {
                it.score
            }.thenBy {
                it.manifest?.id
            }
        )

        val seenRejectedIds = HashSet<String>()
        val distinctRejected = rejectedClients.filter { seenRejectedIds.add(it.manifest.id) }
        val sortedRejected = distinctRejected.sortedBy { it.manifest.id }

        return ClientSelectionResult(sortedCandidates, sortedRejected)
    }
}
