package com.metrolist.innertube.models

data class YouTubeAccount(
    val name: String,
    val channelHandle: String? = null,
    val byline: String? = null,
    val thumbnailUrl: String? = null,
    val pageId: String? = null,
    val dataSyncId: String? = null,
    val signinUrl: String? = null,
    val isSelected: Boolean = false,
)
