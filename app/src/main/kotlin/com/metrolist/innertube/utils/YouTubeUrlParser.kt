package com.metrolist.innertube.utils

object YouTubeUrlParser {
    sealed class ParsedUrl {
        data class Video(val id: String) : ParsedUrl()
        data class Playlist(val id: String) : ParsedUrl()
        data class Album(val id: String) : ParsedUrl()
        data class Artist(val id: String) : ParsedUrl()
    }

    private val VIDEO_URL_PATTERNS = listOf(
        Regex("""(?:https?://)?(?:www\.)?(?:music\.)?youtube\.com/watch\?.*v=([a-zA-Z0-9_-]{11})"""),
        Regex("""(?:https?://)?(?:www\.)?(?:music\.)?youtube\.com/watch\?v=([a-zA-Z0-9_-]{11})"""),
        Regex("""(?:https?://)?youtu\.be/([a-zA-Z0-9_-]{11})"""),
        Regex("""(?:https?://)?(?:www\.)?youtube\.com/shorts/([a-zA-Z0-9_-]{11})"""),
    )
    private val PLAYLIST_URL_PATTERN = Regex("""(?:https?://)?(?:www\.)?(?:music\.)?youtube\.com/playlist\?.*list=([a-zA-Z0-9_-]+)""")
    private val ARTIST_URL_PATTERNS = listOf(
        Regex("""(?:https?://)?(?:www\.)?music\.youtube\.com/channel/([a-zA-Z0-9_-]+)"""),
        Regex("""(?:https?://)?(?:www\.)?music\.youtube\.com/browse/(MPRE[a-zA-Z0-9_-]+)"""),
    )

    fun parse(url: String): ParsedUrl? {
        val trimmed = url.trim()
        for (p in VIDEO_URL_PATTERNS) {
            p.find(trimmed)?.groupValues?.getOrNull(1)?.let { return ParsedUrl.Video(it) }
        }
        PLAYLIST_URL_PATTERN.find(trimmed)?.groupValues?.getOrNull(1)?.let {
            return if (it.startsWith("OLAK5uy_")) ParsedUrl.Album(it) else ParsedUrl.Playlist(it)
        }
        for (p in ARTIST_URL_PATTERNS) {
            p.find(trimmed)?.groupValues?.getOrNull(1)?.let {
                return if (it.startsWith("MPRE")) ParsedUrl.Album(it) else ParsedUrl.Artist(it)
            }
        }
        return null
    }
}
