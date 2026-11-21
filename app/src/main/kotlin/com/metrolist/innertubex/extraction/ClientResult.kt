package com.metrolist.innertubex.extraction

import com.metrolist.innertubex.models.response.PlayerResponse

data class ClientResult(
    val clientName: String,
    val profileId: String,
    val userAgent: String,
    val response: PlayerResponse,
    val usedPoToken: Boolean = false,
    val streamingDataPoToken: String? = null,
    val clientId: Int,
    val clientVersion: String,
    val useSabr: Boolean = false,
    val bearerAuthenticated: Boolean = false,
) {
    override fun toString(): String {
        return "ClientResult(clientName=$clientName, profileId=$profileId, usedPoToken=$usedPoToken, streamingDataPoToken=${if (streamingDataPoToken != null) "present" else "missing"}, clientId=$clientId, clientVersion=${if (clientVersion.isNotEmpty()) "present" else "missing"}, useSabr=$useSabr, bearerAuthenticated=$bearerAuthenticated)"
    }
}
