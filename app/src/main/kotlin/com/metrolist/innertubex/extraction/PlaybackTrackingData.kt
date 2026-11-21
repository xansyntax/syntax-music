package com.metrolist.innertubex.extraction

data class PlaybackTrackingData(
    val clientPlaybackNonce: String,
    val playbackUrl: String?,
    val watchtimeUrl: String?,
    val scheduledFlushWalltimeSeconds: List<Int>?,
    val defaultFlushIntervalSeconds: Int?,
    val resolvedAtEpochMs: Long,
) {
    override fun toString(): String {
        val nonce = if (clientPlaybackNonce.isNotEmpty()) "present" else "missing"
        val pbUrl = if (!playbackUrl.isNullOrEmpty()) "present" else "missing"
        val wtUrl = if (!watchtimeUrl.isNullOrEmpty()) "present" else "missing"
        val count = scheduledFlushWalltimeSeconds?.size ?: 0
        return "PlaybackTrackingData(clientPlaybackNonce=$nonce, playbackUrl=$pbUrl, watchtimeUrl=$wtUrl, scheduledFlushWalltimeSeconds=$count, defaultFlushIntervalSeconds=$defaultFlushIntervalSeconds, resolvedAtEpochMs=$resolvedAtEpochMs)"
    }
}
