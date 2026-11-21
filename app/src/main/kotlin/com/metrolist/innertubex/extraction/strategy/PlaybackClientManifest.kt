package com.metrolist.innertubex.extraction.strategy

import com.metrolist.innertubex.models.YouTubeClient

data class PlaybackClientManifest(
    val id: String,
    val displayName: String,
    val client: YouTubeClient,
    val lifecycle: ClientLifecycle,
    val selectionMode: ClientSelectionMode,
    val authentication: AuthenticationPolicy,
    val transports: Set<PlaybackTransport>,
    val poTokens: ClientPoTokenCapabilities,
    val request: ClientRequestCapabilities,
    val content: ClientContentCapabilities,
    val benchmarkContent: ClientContentCapabilities,
    val priority: Byte,
    val evidence: Set<String>,
    val notes: String,
) {
    constructor(
        id: String,
        displayName: String,
        client: YouTubeClient,
        lifecycle: ClientLifecycle,
        selectionMode: ClientSelectionMode,
        authentication: AuthenticationPolicy,
        transports: Set<PlaybackTransport>,
        poTokens: ClientPoTokenCapabilities,
        request: ClientRequestCapabilities,
        content: ClientContentCapabilities,
        benchmarkContent: ClientContentCapabilities,
        priority: Int,
        evidence: Set<String>,
        notes: String,
    ) : this(
        id, displayName, client, lifecycle, selectionMode, authentication,
        transports, poTokens, request, content, benchmarkContent, priority.toByte(), evidence, notes
    )

    init {
        require(id.matches(Regex("[A-Z0-9_]+"))) { "Client manifest ID must be stable and uppercase: $id" }
        require(transports.isNotEmpty() || selectionMode == ClientSelectionMode.API_ONLY) {
            "Playback client $id must declare at least one transport"
        }
        require(transports.contains(PlaybackTransport.SABR) == client.useSabr) {
            "Client $id disagrees with its SABR request profile"
        }
        require((authentication != AuthenticationPolicy.UNSUPPORTED) == client.loginSupported) {
            "Client $id disagrees with its login request profile"
        }
        require((authentication == AuthenticationPolicy.REQUIRED) == client.loginRequired) {
            "Client $id disagrees with its required-login request profile"
        }
        require(request.signatureTimestamp == client.useSignatureTimestamp) {
            "Client $id disagrees with its signature timestamp request profile"
        }
        require(request.embedded == client.isEmbedded) {
            "Client $id disagrees with its embedded request profile"
        }
        require(!request.encryptedHostFlags || request.embedded) {
            "Client $id requests encrypted host flags without an embedded player context"
        }
    }
}
