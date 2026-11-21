package com.metrolist.innertube.models

data class PlaylistItem(
    override val id: String,
    override val title: String,
    val author: Artist? = null,
    val authorAvatarUrl: String? = null,
    val songCountText: String? = null,
    override val thumbnail: String,
    val description: String? = null,
    val playEndpoint: WatchEndpoint? = null,
    val shuffleEndpoint: WatchEndpoint? = null,
    val radioEndpoint: WatchEndpoint? = null,
    val isEditable: Boolean = false,
    val isPodcast: Boolean = false,
) : YTItem()
