package com.metrolist.innertubex.extraction

object UnavailableTokenProvider : TokenProvider {
    override suspend fun getPoToken(videoId: String, visitorData: String?): PoTokenResult? = null
}
