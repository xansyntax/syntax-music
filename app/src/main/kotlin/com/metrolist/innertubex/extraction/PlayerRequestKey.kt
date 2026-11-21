package com.metrolist.innertubex.extraction

import com.metrolist.innertubex.InnerTube
import com.metrolist.innertubex.models.YouTubeClient

data class PlayerRequestKey(
    val client: YouTubeClient,
    val videoId: String,
    val signatureTimestamp: Int?,
    val poToken: String?,
    val requestSession: InnerTube.SessionSnapshot,
    val encryptedHostFlags: String?,
) {
    override fun toString(): String {
        return "PlayerRequestKey(client=${client.clientName})"
    }
}
