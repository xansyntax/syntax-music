package com.metrolist.desktop.models

import com.metrolist.innertube.YouTube
import com.metrolist.innertube.models.SongItem
import com.metrolist.innertubex.extraction.AudioQuality
import kotlinx.serialization.Serializable
import java.util.UUID

enum class DesktopTab(val title: String) {
    HOME("Home"),
    EXPLORE("Explore"),
    SEARCH("Search"),
    LIBRARY("Library"),
    SETTINGS("Settings"),
}

enum class SearchFilterTab(val label: String, val filter: YouTube.SearchFilter) {
    SONGS("Songs", YouTube.SearchFilter.FILTER_SONG),
    VIDEOS("Videos", YouTube.SearchFilter.FILTER_VIDEO),
    ALBUMS("Albums", YouTube.SearchFilter.FILTER_ALBUM),
    PLAYLISTS("Playlists", YouTube.SearchFilter.FILTER_COMMUNITY_PLAYLIST),
    ARTISTS("Artists", YouTube.SearchFilter.FILTER_ARTIST),
}

enum class RepeatMode { OFF, ALL, ONE }

@Serializable
data class DesktopTrack(
    val id: String,
    val title: String,
    val artist: String,
    val thumbnail: String,
    val durationSec: Int? = null,
    val albumId: String? = null,
    val artistId: String? = null,
)

fun SongItem.toDesktopTrack(): DesktopTrack = DesktopTrack(
    id = id,
    title = title,
    artist = artists.joinToString(", ") { it.name },
    thumbnail = thumbnail,
    durationSec = duration,
    albumId = album?.id,
    artistId = artists.firstOrNull()?.id,
)

@Serializable
data class LocalPlaylist(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val description: String = "",
    val createdAtMs: Long = System.currentTimeMillis(),
    val tracks: List<DesktopTrack> = emptyList(),
)

data class LyricLine(
    val timeMs: Long,
    val text: String,
    val romanized: String? = null,
    val translated: String? = null,
)

data class PlaybackProgress(
    val positionMs: Long = 0L,
    val durationMs: Long = 0L,
)

data class DynamicPalette(
    val primaryArgb: Long = 0xFFFFB0CD,
    val containerArgb: Long = 0xFF72334E,
    val secondaryArgb: Long = 0xFFC4B5FD,
    val tertiaryArgb: Long = 0xFF8BE9FD,
)

data class CollectionDetail(
    val id: String,
    val title: String,
    val subtitle: String,
    val thumbnail: String?,
    val tracks: List<DesktopTrack>,
    val isAlbum: Boolean = false,
    val yearOrCount: String = "",
)

data class ArtistDetail(
    val id: String,
    val name: String,
    val thumbnail: String?,
    val subscriberCount: String? = null,
    val monthlyListeners: String? = null,
    val description: String? = null,
    val topSongs: List<DesktopTrack> = emptyList(),
    val albums: List<CollectionDetail> = emptyList(),
    val singles: List<CollectionDetail> = emptyList(),
    val relatedArtists: List<DesktopTrack> = emptyList(), // thumbnail = artist thumbnail, title = artist name, id = artist id
)

data class PlayerUiState(
    val currentTrack: DesktopTrack? = null,
    val queue: List<DesktopTrack> = emptyList(),
    val currentIndex: Int = -1,
    val isPlaying: Boolean = false,
    val isLoading: Boolean = false,
    val isShuffled: Boolean = false,
    val repeatMode: RepeatMode = RepeatMode.OFF,
    val volume: Int = 85,
    val playbackSpeed: Float = 1.0f,
    val audioQuality: AudioQuality = AudioQuality.HIGH,
    val sleepTimerRemainingSec: Int? = null,
    val syncedLyrics: List<LyricLine> = emptyList(),
    val plainLyrics: String? = null,
    val lyricsLoading: Boolean = false,
    val showLyricTranslation: Boolean = true,
    val favorites: List<DesktopTrack> = emptyList(),
    val history: List<DesktopTrack> = emptyList(),
    val downloads: List<DesktopTrack> = emptyList(),
    val downloadingIds: Set<String> = emptySet(),
    val localPlaylists: List<LocalPlaylist> = emptyList(),
    val searchHistory: List<String> = emptyList(),
    val palette: DynamicPalette = DynamicPalette(),
    val errorMessage: String? = null,
) {
    val isCurrentLiked: Boolean
        get() = currentTrack != null && favorites.any { it.id == currentTrack.id }

    fun isDownloaded(id: String): Boolean = downloads.any { it.id == id }
    fun isDownloading(id: String): Boolean = id in downloadingIds
    fun isFavorite(id: String): Boolean = favorites.any { it.id == id }
}
