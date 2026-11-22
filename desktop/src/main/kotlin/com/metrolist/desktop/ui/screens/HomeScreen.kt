package com.metrolist.desktop.ui.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.metrolist.desktop.models.DesktopTrack
import com.metrolist.desktop.models.toDesktopTrack
import com.metrolist.desktop.playback.DesktopPlaybackEngine
import com.metrolist.desktop.ui.components.ChipsRow
import com.metrolist.desktop.ui.components.GlassMediaCard
import com.metrolist.desktop.ui.components.glassSurface
import com.metrolist.desktop.ui.theme.GlassCardShape
import com.metrolist.innertube.models.SongItem
import com.metrolist.innertube.models.YTItem
import com.metrolist.innertube.pages.HomePage

@Composable
fun HomeScreen(
    homePage: HomePage?,
    isLoading: Boolean,
    error: String?,
    selectedChipKey: String?,
    onSelectChip: (String?) -> Unit,
    onRefresh: () -> Unit,
    onItemClick: (YTItem, List<YTItem>) -> Unit,
    engine: DesktopPlaybackEngine,
    onOpenAddToPlaylist: (DesktopTrack) -> Unit,
) {
    val cs = MaterialTheme.colorScheme
    val state by engine.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 26.dp, vertical = 22.dp)) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text("Home", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Text("by Xan Syntax", fontSize = 12.sp, color = cs.primary, fontWeight = FontWeight.Medium)
            }
            IconButton(onClick = onRefresh, modifier = Modifier.glassSurface(CircleShape, elevated = false)) {
                Icon(Icons.Rounded.Refresh, contentDescription = "Refresh", tint = Color.White)
            }
        }

        Spacer(Modifier.height(14.dp))

        // Mood & Genre Chips
        if (homePage?.chips != null && homePage.chips.isNotEmpty()) {
            val chipPairs = remember(homePage.chips) {
                homePage.chips.map { (it.endpoint?.params ?: it.title) to it.title }
            }
            ChipsRow(
                chips = chipPairs,
                selectedKey = selectedChipKey,
                onSelectKey = onSelectChip,
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(Modifier.height(12.dp))
        }

        when {
            isLoading -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = cs.primary)
            }
            error != null -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text(error, color = Color(0xFFF87171), fontSize = 14.sp)
                    Button(
                        onClick = onRefresh,
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(containerColor = cs.primary, contentColor = cs.onPrimary),
                    ) { Text("Coba Lagi") }
                }
            }
            homePage != null -> {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(28.dp),
                    contentPadding = PaddingValues(bottom = 28.dp),
                ) {
                    // Check for Quick Picks section
                    val quickPicksSection = homePage.sections.firstOrNull {
                        it.title.contains("Quick picks", ignoreCase = true) || it.title.contains("Pilihan cepat", ignoreCase = true)
                    }
                    val otherSections = if (quickPicksSection != null) homePage.sections.filterNot { it == quickPicksSection } else homePage.sections

                    // Render Quick Picks Prominently
                    if (quickPicksSection != null && quickPicksSection.items.isNotEmpty()) {
                        item(key = "quick_picks") {
                            Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Text(quickPicksSection.title, fontSize = 21.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                    val quickSongs = quickPicksSection.items.filterIsInstance<SongItem>()
                                    if (quickSongs.isNotEmpty()) {
                                        TextButton(onClick = {
                                            val queue = quickSongs.map { it.toDesktopTrack() }
                                            engine.playTrack(queue.first(), queue)
                                        }) {
                                            Icon(Icons.Rounded.PlayArrow, contentDescription = null, modifier = Modifier.size(18.dp), tint = cs.primary)
                                            Spacer(Modifier.width(4.dp))
                                            Text("Play All", color = cs.primary, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                                        }
                                    }
                                }

                                // Quick picks 4-row grid / card list
                                val chunkedSongs = quickPicksSection.items.filterIsInstance<SongItem>().chunked(4)
                                LazyRow(horizontalArrangement = Arrangement.spacedBy(18.dp)) {
                                    items(chunkedSongs) { columnSongs ->
                                        Column(
                                            modifier = Modifier.width(340.dp),
                                            verticalArrangement = Arrangement.spacedBy(8.dp),
                                        ) {
                                            columnSongs.forEach { song ->
                                                val track = song.toDesktopTrack()
                                                val isCur = state.currentTrack?.id == track.id
                                                val interaction = remember { MutableInteractionSource() }
                                                val isHov by interaction.collectIsHoveredAsState()
                                                val bg by animateColorAsState(
                                                    if (isCur) cs.primaryContainer.copy(0.40f) else if (isHov) Color.White.copy(0.10f) else Color.White.copy(0.04f),
                                                    tween(120),
                                                )

                                                Row(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .clip(RoundedCornerShape(14.dp))
                                                        .background(bg)
                                                        .border(0.5.dp, if (isCur) cs.primary.copy(0.5f) else Color.White.copy(0.08f), RoundedCornerShape(14.dp))
                                                        .hoverable(interaction)
                                                        .clickable {
                                                            val allSongs = quickPicksSection.items.filterIsInstance<SongItem>().map { it.toDesktopTrack() }
                                                            engine.playTrack(track, allSongs)
                                                        }
                                                        .padding(horizontal = 10.dp, vertical = 8.dp),
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                                                ) {
                                                    AsyncImage(
                                                        model = track.thumbnail,
                                                        contentDescription = track.title,
                                                        contentScale = ContentScale.Crop,
                                                        modifier = Modifier.size(46.dp).clip(RoundedCornerShape(10.dp)),
                                                    )
                                                    Column(modifier = Modifier.weight(1f)) {
                                                        Text(track.title, color = if (isCur) cs.primary else Color.White, fontWeight = FontWeight.SemiBold, fontSize = 13.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                                                        Text(track.artist, color = cs.onSurfaceVariant, fontSize = 12.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                                                    }
                                                    IconButton(onClick = { engine.toggleFavorite(track) }, modifier = Modifier.size(30.dp)) {
                                                        Icon(
                                                            if (state.isFavorite(track.id)) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                                                            contentDescription = "Like",
                                                            tint = if (state.isFavorite(track.id)) cs.primary else cs.onSurfaceVariant,
                                                            modifier = Modifier.size(16.dp),
                                                        )
                                                    }
                                                    IconButton(onClick = { onOpenAddToPlaylist(track) }, modifier = Modifier.size(30.dp)) {
                                                        Icon(Icons.AutoMirrored.Rounded.PlaylistAdd, contentDescription = "Add to playlist", tint = cs.onSurfaceVariant, modifier = Modifier.size(18.dp))
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    // Render other sections
                    items(otherSections) { section ->
                        if (section.items.isNotEmpty()) {
                            Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                                Text(section.title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                                    items(section.items) { item ->
                                        GlassMediaCard(
                                            item = item,
                                            onClick = { onItemClick(item, section.items) },
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
