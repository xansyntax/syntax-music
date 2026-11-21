package com.metrolist.innertube.models

data class PodcastItem(
    override val id: String,
    override val title: String,
    val author: Artist? = null,
    val episodeCountText: String? = null,
    override val thumbnail: String,
    val playEndpoint: WatchEndpoint? = null,
    val shuffleEndpoint: WatchEndpoint? = null,
    val libraryAddToken: String? = null,
    val libraryRemoveToken: String? = null,
    val channelId: String? = null,
) : YTItem() {
    fun asPlaylistItem() = PlaylistItem(
        id = id,
        title = title,
        author = author,
        songCountText = episodeCountText,
        thumbnail = thumbnail,
        playEndpoint = playEndpoint,
        shuffleEndpoint = shuffleEndpoint,
        isEditable = false,
        isPodcast = true,
    )
}
