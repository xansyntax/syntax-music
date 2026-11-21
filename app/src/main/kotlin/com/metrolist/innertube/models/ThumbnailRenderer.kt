package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class ThumbnailRenderer(
    val croppedSquareThumbnailRenderer: MusicThumbnailRenderer? = null,
    val musicAnimatedThumbnailRenderer: MusicAnimatedThumbnailRenderer? = null,
    val musicThumbnailRenderer: MusicThumbnailRenderer? = null,
) {

    @Serializable
    data class MusicAnimatedThumbnailRenderer(
        val animatedThumbnail: Thumbnails? = null,
        val backupRenderer: MusicThumbnailRenderer? = null,
    )

    @Serializable
    data class MusicThumbnailRenderer(
        val thumbnail: Thumbnails? = null,
        val thumbnailCrop: String? = null,
        val thumbnailScale: String? = null,
    )
}

fun ThumbnailRenderer.getThumbnailUrl(): String? =
    musicThumbnailRenderer?.thumbnail?.thumbnails?.lastOrNull()?.url
        ?: croppedSquareThumbnailRenderer?.thumbnail?.thumbnails?.lastOrNull()?.url
        ?: musicAnimatedThumbnailRenderer?.animatedThumbnail?.thumbnails?.lastOrNull()?.url
        ?: musicAnimatedThumbnailRenderer?.backupRenderer?.thumbnail?.thumbnails?.lastOrNull()?.url
