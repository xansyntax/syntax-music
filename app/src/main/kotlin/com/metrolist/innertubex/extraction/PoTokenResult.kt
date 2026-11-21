package com.metrolist.innertubex.extraction

data class PoTokenResult(
    val playerRequestToken: String,
    val streamingDataToken: String,
    val visitorData: String,
) {
    override fun toString(): String {
        val pToken = if (playerRequestToken.isBlank()) "missing" else "present"
        val sToken = if (streamingDataToken.isBlank()) "missing" else "present"
        val vData = if (visitorData.isBlank()) "missing" else "present"
        return "PoTokenResult(playerRequestToken=$pToken, streamingDataToken=$sToken, visitorData=$vData)"
    }
}
