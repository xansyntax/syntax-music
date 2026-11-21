package com.metrolist.innertube.models

data class ArtistItem(
    override val id: String,
    override val title: String,
    override val thumbnail: String,
    val channelId: String? = null,
    val playEndpoint: WatchEndpoint? = null,
    val shuffleEndpoint: WatchEndpoint? = null,
    val radioEndpoint: WatchEndpoint? = null,
    val isProfile: Boolean = false,
) : YTItem()
