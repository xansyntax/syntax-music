package com.metrolist.innertubex.extraction

interface TokenProvider {
    fun getCapabilities(): TokenProviderCapabilities = TokenProviderCapabilities()
    suspend fun getPoToken(videoId: String, visitorData: String?): PoTokenResult?
}
