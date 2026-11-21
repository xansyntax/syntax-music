package com.metrolist.innertubex.extraction

import com.metrolist.innertubex.models.response.PlayerResponse
import com.metrolist.innertubex.sabr.ProtoReader
import java.util.Locale
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

val highAudioFormatComparator: Comparator<PlayerResponse.StreamingData.Format> =
    compareBy<PlayerResponse.StreamingData.Format> {
        it.bitrate
    }.thenBy {
        when (it.audioChannels) {
            2 -> 2
            null -> 1
            else -> 0
        }
    }.thenBy {
        (it.audioSampleRate ?: 0).coerceIn(0, 48000)
    }.thenBy {
        when {
            it.mimeType?.contains("audio/webm") == true -> 2
            it.mimeType?.contains("audio/mp4") == true -> 1
            else -> 0
        }
    }

val videoFormatComparator: Comparator<PlayerResponse.StreamingData.Format> =
    compareBy<PlayerResponse.StreamingData.Format> {
        it.height ?: 0
    }.thenBy {
        val lower = it.mimeType?.lowercase(Locale.ROOT).orEmpty()
        when {
            "av01" in lower -> 1
            "avc1" in lower || "vp09" in lower || "vp9" in lower || "video/mp4" in lower || "video/webm" in lower -> 2
            else -> 0
        }
    }.thenBy {
        if (it.bitrate > 0) -it.bitrate else Int.MIN_VALUE
    }

fun audioFormatScore(format: PlayerResponse.StreamingData.Format): Long {
    val mimeScore = when {
        format.mimeType?.contains("audio/webm") == true -> 100
        format.mimeType?.contains("audio/mp4") == true -> 50
        else -> 0
    }
    val channelsScore = when (format.audioChannels) {
        2 -> 50000
        1 -> 0
        else -> 25000
    }
    val sampleRateScore = (format.audioSampleRate ?: 0).coerceIn(0, 48000) / 10
    return (mimeScore.toLong() * 1000000L) + channelsScore.toLong() + format.bitrate.toLong() + sampleRateScore.toLong()
}

@OptIn(ExperimentalEncodingApi::class)
fun selectBestAudioFormat(
    formats: List<PlayerResponse.StreamingData.Format>,
    audioQuality: AudioQuality,
    requireUrl: Boolean = true,
): PlayerResponse.StreamingData.Format? {
    var available = if (requireUrl) {
        formats.filter { !it.url.isNullOrBlank() }
    } else {
        formats
    }
    if (available.isEmpty()) return null

    if (available.any { it.audioTrack != null }) {
        val originalTracks = available.filter { format ->
            val xtags = format.xtags
            if (xtags != null && xtags.length <= 1024) {
                runCatching {
                    val decoded = Base64.UrlSafe.withPadding(Base64.PaddingOption.ABSENT_OPTIONAL).decode(xtags)
                    val reader = ProtoReader(decoded)
                    var acontValue: String? = null
                    while (reader.hasRemaining) {
                        val tag = reader.tag()
                        if (tag.field == 1 && tag.wireType == 2) {
                            val subReader = ProtoReader(reader.bytes())
                            var key: String? = null
                            var value: String? = null
                            while (subReader.hasRemaining) {
                                val subTag = subReader.tag()
                                if (subTag.field == 1 && subTag.wireType == 2) {
                                    key = subReader.bytes().decodeToString()
                                } else if (subTag.field == 2 && subTag.wireType == 2) {
                                    value = subReader.bytes().decodeToString()
                                } else {
                                    subReader.skip(subTag)
                                }
                            }
                            if (key == "acont") {
                                acontValue = value
                                break
                            }
                        } else {
                            reader.skip(tag)
                        }
                    }
                    acontValue
                }.getOrNull() == "original"
            } else {
                false
            }
        }

        val filtered = if (originalTracks.isNotEmpty()) {
            originalTracks
        } else {
            available.filter { it.audioTrack?.audioIsDefault == true }
        }

        if (filtered.isNotEmpty()) {
            available = filtered
        }
    }

    if (available.isEmpty()) return null

    return when (audioQuality) {
        AudioQuality.AUTO -> {
            val webm = available.filter { it.mimeType?.contains("audio/webm") == true }
            webm.maxByOrNull { audioFormatScore(it) } ?: available.maxByOrNull { audioFormatScore(it) }
        }
        AudioQuality.LOW -> {
            val mp4 = available.filter { it.mimeType?.contains("audio/mp4") == true }
            mp4.minByOrNull { it.bitrate } ?: available.minByOrNull { it.bitrate }
        }
        AudioQuality.HIGH -> {
            available.maxWithOrNull(highAudioFormatComparator)
        }
        AudioQuality.MP4 -> {
            val mp4 = available.filter { it.mimeType?.contains("audio/mp4") == true }
            mp4.maxByOrNull { audioFormatScore(it) } ?: available.maxByOrNull { audioFormatScore(it) }
        }
    }
}

fun selectBestVideoFormat(
    maxHeight: Int,
    formats: List<PlayerResponse.StreamingData.Format>,
    requireUrl: Boolean = true,
): PlayerResponse.StreamingData.Format? {
    val available = if (requireUrl) {
        formats.filter { !it.url.isNullOrBlank() }
    } else {
        formats
    }
    val videoFormats = available.filter { it.width != null && (it.height ?: 0) > 0 }
    if (videoFormats.isEmpty()) return null

    val bounded = videoFormats.filter { it.height!! <= maxHeight }
    val bestBounded = bounded.maxWithOrNull(videoFormatComparator)
    if (bestBounded != null) return bestBounded

    val byHeight = videoFormats.groupBy { it.height!! }
    val minHeightEntry = byHeight.minByOrNull { it.key }
    return minHeightEntry?.value?.maxWithOrNull(videoFormatComparator)
}
