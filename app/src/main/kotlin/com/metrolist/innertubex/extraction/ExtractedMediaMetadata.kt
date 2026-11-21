package com.metrolist.innertubex.extraction

import com.metrolist.innertubex.models.Thumbnail

data class ExtractedMediaMetadata(
    val title: String?,
    val author: String?,
    val channelId: String?,
    val durationSeconds: Long?,
    val musicVideoType: String?,
    val viewCount: String?,
    val thumbnails: List<Thumbnail>,
    val isLive: Boolean,
) {
    override fun toString(): String {
        return "ExtractedMediaMetadata(title=${if (title != null) "present" else "missing"}, author=${if (author != null) "present" else "missing"}, channelId=${if (channelId != null) "present" else "missing"}, durationSeconds=$durationSeconds, musicVideoType=$musicVideoType, viewCount=${if (viewCount != null) "present" else "missing"}, thumbnailCount=${thumbnails.size}, isLive=$isLive)"
    }
}
