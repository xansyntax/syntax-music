package com.metrolist.desktop.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.*
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.metrolist.desktop.models.DesktopTrack
import com.metrolist.desktop.models.SearchFilterTab
import com.metrolist.desktop.models.toDesktopTrack
import com.metrolist.desktop.playback.DesktopPlaybackEngine
import com.metrolist.desktop.ui.components.glassSurface
import com.metrolist.desktop.ui.theme.GlassCardShape
import com.metrolist.innertube.YouTube
import com.metrolist.innertube.models.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SearchScreen(
    query: String,
    selectedFilter: SearchFilterTab,
    onQueryChange: (String) -> Unit,
    onFilterChange: (SearchFilterTab) -> Unit,
    onSearch: (String) -> Unit,
    results: List<YTItem>,
    isLoading: Boolean,
    isLoadingMore: Boolean = false,
    hasMore: Boolean = false,
    onLoadMore: () -> Unit = {},
    onItemClick: (YTItem, List<YTItem>) -> Unit,
    engine: DesktopPlaybackEngine,
    onOpenAddToPlaylist: (DesktopTrack) -> Unit,
) {
    val cs = MaterialTheme.colorScheme
    val scope = rememberCoroutineScope()
    val state by engine.state.collectAsState()

    var suggestions by remember { mutableStateOf<List<String>>(emptyList()) }
    var debounceJob by remember { mutableStateOf<Job?>(null) }
    var isSearchFocused by remember { mutableStateOf(false) }

    fun updateQueryWithSuggestions(newQuery: String) {
        onQueryChange(newQuery)
        debounceJob?.cancel()
        if (newQuery.isNotBlank()) {
            debounceJob = scope.launch {
                delay(200L)
                YouTube.searchSuggestions(newQuery).onSuccess { res ->
                    suggestions = res.queries
                }
            }
        } else {
            suggestions = emptyList()
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 26.dp, vertical = 22.dp)) {
        // Title
        Text("Search", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Spacer(Modifier.height(14.dp))

        // Search Bar with Suggestion Dropdown
        Box(modifier = Modifier.fillMaxWidth(0.85f)) {
            OutlinedTextField(
                value = query,
                onValueChange = { updateQueryWithSuggestions(it) },
                singleLine = true,
                placeholder = { Text("Cari lagu, artis, album, atau playlist... (Tekan Enter)", color = cs.onSurfaceVariant) },
                leadingIcon = { Icon(Icons.Rounded.Search, contentDescription = null, tint = cs.primary) },
                trailingIcon = {
                    if (query.isNotEmpty()) {
                        IconButton(onClick = {
                            onQueryChange("")
                            suggestions = emptyList()
                        }) {
                            Icon(Icons.Rounded.Close, contentDescription = "Clear", tint = cs.onSurfaceVariant)
                        }
                    }
                },
                shape = CircleShape,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White.copy(0.09f),
                    unfocusedContainerColor = Color.White.copy(0.06f),
                    focusedBorderColor = cs.primary,
                    unfocusedBorderColor = Color.White.copy(0.18f),
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged { isSearchFocused = it.isFocused }
                    .onPreviewKeyEvent { event ->
                        if (event.type == KeyEventType.KeyDown && event.key == Key.Enter) {
                            if (query.isNotBlank()) {
                                engine.addSearchHistory(query)
                                suggestions = emptyList()
                                onSearch(query)
                            }
                            true
                        } else false
                    },
            )
        }

        // Suggestions Dropdown
        AnimatedVisibility(
            visible = suggestions.isNotEmpty(),
            enter = fadeIn(tween(140)),
            exit = fadeOut(tween(100)),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(top = 4.dp)
                    .glassSurface(GlassCardShape, elevated = true)
                    .background(cs.surfaceVariant)
                    .padding(vertical = 8.dp),
            ) {
                suggestions.take(6).forEach { sug ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onQueryChange(sug)
                                engine.addSearchHistory(sug)
                                suggestions = emptyList()
                                onSearch(sug)
                            }
                            .padding(horizontal = 16.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        Icon(Icons.Rounded.Search, contentDescription = null, tint = cs.onSurfaceVariant, modifier = Modifier.size(16.dp))
                        Text(sug, color = Color.White, fontSize = 14.sp)
                    }
                }
            }
        }

        Spacer(Modifier.height(14.dp))

        // Filter Tabs
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            SearchFilterTab.entries.forEach { tab ->
                val active = selectedFilter == tab
                val bg by animateColorAsState(if (active) cs.primary else Color.White.copy(0.08f), tween(140))
                val fg by animateColorAsState(if (active) cs.onPrimary else Color.White, tween(140))
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(bg)
                        .border(1.dp, if (active) cs.primary else Color.White.copy(0.16f), CircleShape)
                        .clickable { onFilterChange(tab) }
                        .padding(horizontal = 16.dp, vertical = 7.dp)
                ) {
                    Text(tab.label, color = fg, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                }
            }
        }

        Spacer(Modifier.height(18.dp))

        // Content: Search Results or Recent Searches
        when {
            isLoading -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = cs.primary)
                }
            }
            results.isNotEmpty() -> {
                val songs = results.filterIsInstance<SongItem>()
                val contextTracks = songs.map { it.toDesktopTrack() }

                val listState = rememberLazyListState()
                val shouldLoadMore by remember(hasMore, isLoadingMore, results.size) {
                    derivedStateOf {
                        val lastVisible = listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0
                        hasMore && !isLoadingMore && results.isNotEmpty() && lastVisible >= results.lastIndex - 3
                    }
                }
                LaunchedEffect(shouldLoadMore) {
                    if (shouldLoadMore) onLoadMore()
                }

                LazyColumn(
                    state = listState,
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    contentPadding = PaddingValues(bottom = 28.dp),
                ) {
                    items(results) { item ->
                        val interaction = remember { MutableInteractionSource() }
                        val hovered by interaction.collectIsHoveredAsState()
                        val isCur = item is SongItem && item.id == state.currentTrack?.id
                        val bg by animateColorAsState(
                            if (isCur) cs.primaryContainer.copy(0.40f) else if (hovered) Color.White.copy(0.12f) else Color.White.copy(0.05f),
                            tween(120),
                        )
                        val subtitle = when (item) {
                            is SongItem -> item.artists.joinToString(", ") { it.name }
                            is AlbumItem -> item.artists?.joinToString(", ") { it.name } ?: "Album"
                            is PlaylistItem -> item.author?.name ?: "Playlist"
                            is ArtistItem -> "Artist"
                            else -> ""
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .background(bg)
                                .border(0.5.dp, if (isCur) cs.primary.copy(0.5f) else Color.White.copy(0.10f), RoundedCornerShape(16.dp))
                            .hoverable(interaction)
                            .clickable {
                                if (item is SongItem) {
                                    val track = item.toDesktopTrack()
                                    engine.playTrack(track, contextTracks)
                                } else {
                                    onItemClick(item, results)
                                }
                            }
                            .padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(14.dp),
                        ) {
                            AsyncImage(
                                model = item.thumbnail,
                                contentDescription = item.title,
                                contentScale = ContentScale.Crop,
                                modifier = (if (selectedFilter == SearchFilterTab.VIDEOS && item is SongItem) Modifier.width(86.dp).height(48.dp) else Modifier.size(50.dp)).clip(if (item is ArtistItem) CircleShape else RoundedCornerShape(12.dp)),
                            )
                            Column(modifier = Modifier.weight(1f)) {
                                Text(item.title, color = if (isCur) cs.primary else Color.White, fontWeight = FontWeight.SemiBold, fontSize = 14.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                                Text(subtitle, color = cs.onSurfaceVariant, fontSize = 12.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                            }
                            if (item is SongItem) {
                                val track = item.toDesktopTrack()
                                IconButton(onClick = { engine.toggleFavorite(track) }, modifier = Modifier.size(32.dp)) {
                                    Icon(
                                        if (state.isFavorite(track.id)) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                                        contentDescription = "Like",
                                        tint = if (state.isFavorite(track.id)) cs.primary else cs.onSurfaceVariant,
                                        modifier = Modifier.size(18.dp),
                                    )
                                }
                                IconButton(onClick = { onOpenAddToPlaylist(track) }, modifier = Modifier.size(32.dp)) {
                                    Icon(Icons.AutoMirrored.Rounded.PlaylistAdd, contentDescription = "Add to playlist", tint = cs.onSurfaceVariant, modifier = Modifier.size(18.dp))
                                }
                                IconButton(onClick = { engine.downloadTrack(track) }, modifier = Modifier.size(32.dp)) {
                                    val isDl = state.isDownloaded(track.id)
                                    Icon(
                                        if (isDl) Icons.Rounded.DownloadDone else Icons.Rounded.Download,
                                        contentDescription = "Download",
                                        tint = if (isDl) cs.primary else cs.onSurfaceVariant,
                                        modifier = Modifier.size(18.dp),
                                    )
                                }
                                item.duration?.let { dur ->
                                    Text(
                                        formatSec(dur),
                                        color = cs.onSurfaceVariant,
                                        fontSize = 12.sp,
                                        modifier = Modifier.padding(end = 4.dp),
                                    )
                                }
                            }
                        }
                    }
                    if (isLoadingMore) {
                        item {
                            Box(Modifier.fillMaxWidth().padding(vertical = 16.dp), contentAlignment = Alignment.Center) {
                                CircularProgressIndicator(color = cs.primary, modifier = Modifier.size(26.dp), strokeWidth = 2.5.dp)
                            }
                        }
                    }
                }
            }
            state.searchHistory.isNotEmpty() -> {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text("Riwayat Pencarian", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        TextButton(onClick = { engine.clearSearchHistory() }) {
                            Text("Hapus Semua", color = cs.primary, fontSize = 12.sp)
                        }
                    }

                    LazyColumn(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        items(state.searchHistory) { hist ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(0.85f)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color.White.copy(0.05f))
                                    .clickable {
                                        onQueryChange(hist)
                                        onSearch(hist)
                                    }
                                    .padding(horizontal = 14.dp, vertical = 9.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                    Icon(Icons.Rounded.History, contentDescription = null, tint = cs.onSurfaceVariant, modifier = Modifier.size(18.dp))
                                    Text(hist, color = Color.White, fontSize = 14.sp)
                                }
                                IconButton(onClick = { engine.removeSearchHistory(hist) }, modifier = Modifier.size(28.dp)) {
                                    Icon(Icons.Rounded.Close, contentDescription = "Hapus", tint = cs.onSurfaceVariant, modifier = Modifier.size(16.dp))
                                }
                            }
                        }
                    }
                }
            }
            else -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Ketik sesuatu dan tekan Enter untuk mencari", color = cs.onSurfaceVariant.copy(0.6f), fontSize = 14.sp)
                }
            }
        }
    }
}

private fun formatSec(sec: Int): String {
    val m = sec / 60
    val s = sec % 60
    return "%d:%02d".format(m, s)
}
