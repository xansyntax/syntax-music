package com.metrolist.innertube.models

data class SongItem(
    override val id: String,
    override val title: String,
    val artists: List<Artist>,
    val album: Album? = null,
    val duration: Int? = null,
    override val thumbnail: String,
    val chartPosition: Int? = null,
    val chartChange: String? = null,
    val setVideoId: String? = null,
    override val explicit: Boolean = false,
    val endpoint: WatchEndpoint? = null,
    val musicVideoType: String? = null,
    val libraryAddToken: String? = null,
    val libraryRemoveToken: String? = null,
    val historyRemoveToken: String? = null,
    val isEpisode: Boolean = false,
    val uploadEntityId: String? = null,
) : YTItem() {
    val isVideoSong: Boolean
        get() = musicVideoType != null && musicVideoType != "MUSIC_VIDEO_TYPE_ATV"
}
