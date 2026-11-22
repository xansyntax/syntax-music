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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
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
import com.metrolist.desktop.ui.components.GlassMediaCard
import com.metrolist.desktop.ui.components.glassSurface
import com.metrolist.desktop.ui.theme.GlassCardShape
import com.metrolist.innertube.YouTube
import com.metrolist.innertube.models.AlbumItem
import com.metrolist.innertube.models.SongItem
import com.metrolist.innertube.models.YTItem
import com.metrolist.innertube.pages.ChartsPage
import com.metrolist.innertube.pages.MoodAndGenres
import kotlinx.coroutines.launch

enum class ExploreSubTab(val title: String) {
    CHARTS("Charts"),
    NEW_RELEASES("New Releases"),
    MOODS_GENRES("Moods & Genres"),
}

@Composable
fun ExploreScreen(
    engine: DesktopPlaybackEngine,
    onItemClick: (YTItem, List<YTItem>) -> Unit,
    onOpenMoodOrGenre: (MoodAndGenres.Item) -> Unit,
    onOpenAddToPlaylist: (DesktopTrack) -> Unit,
) {
    val cs = MaterialTheme.colorScheme
    val scope = rememberCoroutineScope()
    val state by engine.state.collectAsState()

    var activeSubTab by remember { mutableStateOf(ExploreSubTab.CHARTS) }

    var chartsPage by remember { mutableStateOf<ChartsPage?>(null) }
    var chartsLoading by remember { mutableStateOf(false) }

    var newReleases by remember { mutableStateOf<List<AlbumItem>>(emptyList()) }
    var newReleasesLoading by remember { mutableStateOf(false) }

    var moodAndGenresList by remember { mutableStateOf<List<MoodAndGenres>>(emptyList()) }
    var moodsLoading by remember { mutableStateOf(false) }

    LaunchedEffect(activeSubTab) {
        when (activeSubTab) {
            ExploreSubTab.CHARTS -> {
                if (chartsPage == null) {
                    chartsLoading = true
                    YouTube.getChartsPage().onSuccess { chartsPage = it }
                    chartsLoading = false
                }
            }
            ExploreSubTab.NEW_RELEASES -> {
                if (newReleases.isEmpty()) {
                    newReleasesLoading = true
                    YouTube.newReleaseAlbums().onSuccess { newReleases = it }
                    newReleasesLoading = false
                }
            }
            ExploreSubTab.MOODS_GENRES -> {
                if (moodAndGenresList.isEmpty()) {
                    moodsLoading = true
                    YouTube.moodAndGenres().onSuccess { moodAndGenresList = it }
                    moodsLoading = false
                }
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 26.dp, vertical = 22.dp)) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text("Explore", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Text("Charts, New Releases & Genres", fontSize = 12.sp, color = cs.primary, fontWeight = FontWeight.Medium)
            }

            // Subtab Pills
            Row(
                modifier = Modifier.glassSurface(CircleShape).padding(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                ExploreSubTab.entries.forEach { tab ->
                    val active = activeSubTab == tab
                    val bg by animateColorAsState(if (active) cs.primary else Color.Transparent, tween(150))
                    val fg by animateColorAsState(if (active) cs.onPrimary else cs.onSurfaceVariant, tween(150))
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(bg)
                            .clickable { activeSubTab = tab }
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                    ) {
                        Text(tab.title, color = fg, fontSize = 13.sp, fontWeight = if (active) FontWeight.Bold else FontWeight.Medium)
                    }
                }
            }
        }

        Spacer(Modifier.height(20.dp))

        when (activeSubTab) {
            ExploreSubTab.CHARTS -> {
                if (chartsLoading) {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(color = cs.primary)
                    }
                } else if (chartsPage != null) {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(26.dp),
                        contentPadding = PaddingValues(bottom = 28.dp),
                    ) {
                        items(chartsPage!!.sections) { section ->
                            Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                                Text(section.title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)

                                val songs = section.items.filterIsInstance<SongItem>()
                                if (songs.isNotEmpty()) {
                                    val tracks = songs.map { it.toDesktopTrack() }
                                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                        songs.forEachIndexed { idx, song ->
                                            val track = song.toDesktopTrack()
                                            val isCur = state.currentTrack?.id == track.id
                                            val interaction = remember { MutableInteractionSource() }
                                            val isHov by interaction.collectIsHoveredAsState()
                                            val rowBg by animateColorAsState(
                                                if (isCur) cs.primaryContainer.copy(0.40f) else if (isHov) Color.White.copy(0.10f) else Color.White.copy(0.04f),
                                                tween(120),
                                            )
                                            val rankColor = when (idx) {
                                                0 -> Color(0xFFFFD700) // Gold
                                                1 -> Color(0xFFC0C0C0) // Silver
                                                2 -> Color(0xFFCD7F32) // Bronze
                                                else -> cs.onSurfaceVariant
                                            }

                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .clip(RoundedCornerShape(14.dp))
                                                    .background(rowBg)
                                                    .border(0.5.dp, if (isCur) cs.primary.copy(0.5f) else Color.White.copy(0.08f), RoundedCornerShape(14.dp))
                                                    .hoverable(interaction)
                                                    .clickable { engine.playTrack(track, tracks) }
                                                    .padding(horizontal = 14.dp, vertical = 9.dp),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.spacedBy(14.dp),
                                            ) {
                                                Text(
                                                    "#${idx + 1}",
                                                    color = rankColor,
                                                    fontSize = 14.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.width(36.dp),
                                                )
                                                AsyncImage(
                                                    model = track.thumbnail,
                                                    contentDescription = track.title,
                                                    contentScale = ContentScale.Crop,
                                                    modifier = Modifier.size(44.dp).clip(RoundedCornerShape(10.dp)),
                                                )
                                                Column(modifier = Modifier.weight(1f)) {
                                                    Text(track.title, color = if (isCur) cs.primary else Color.White, fontWeight = FontWeight.SemiBold, fontSize = 14.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                                                    Text(track.artist, color = cs.onSurfaceVariant, fontSize = 12.sp, maxLines = 1)
                                                }
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
                                            }
                                        }
                                    }
                                } else {
                                    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                                        items(section.items) { item ->
                                            GlassMediaCard(item = item, onClick = { onItemClick(item, section.items) })
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            ExploreSubTab.NEW_RELEASES -> {
                if (newReleasesLoading) {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(color = cs.primary)
                    }
                } else {
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(minSize = 178.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalArrangement = Arrangement.spacedBy(18.dp),
                        contentPadding = PaddingValues(bottom = 28.dp),
                    ) {
                        items(newReleases) { album ->
                            GlassMediaCard(item = album, onClick = { onItemClick(album, newReleases) })
                        }
                    }
                }
            }

            ExploreSubTab.MOODS_GENRES -> {
                if (moodsLoading) {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(color = cs.primary)
                    }
                } else {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(26.dp),
                        contentPadding = PaddingValues(bottom = 28.dp),
                    ) {
                        items(moodAndGenresList) { section ->
                            Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                                Text(section.title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                LazyVerticalGrid(
                                    columns = GridCells.Adaptive(minSize = 180.dp),
                                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                                    verticalArrangement = Arrangement.spacedBy(12.dp),
                                    modifier = Modifier.heightIn(max = 320.dp),
                                ) {
                                    items(section.items) { item ->
                                        val stripeColor = Color(item.stripeColor)
                                        val interaction = remember { MutableInteractionSource() }
                                        val isHov by interaction.collectIsHoveredAsState()
                                        val cardScale by androidx.compose.animation.core.animateFloatAsState(if (isHov) 1.03f else 1.0f)

                                        Box(
                                            modifier = Modifier
                                                .height(64.dp)
                                                .scale(cardScale)
                                                .clip(RoundedCornerShape(16.dp))
                                                .background(
                                                    Brush.horizontalGradient(
                                                        listOf(stripeColor.copy(alpha = 0.65f), Color.White.copy(alpha = 0.08f))
                                                    )
                                                )
                                                .border(1.dp, stripeColor.copy(alpha = 0.5f), RoundedCornerShape(16.dp))
                                                .hoverable(interaction)
                                                .clickable { onOpenMoodOrGenre(item) }
                                                .padding(horizontal = 16.dp),
                                            contentAlignment = Alignment.CenterStart,
                                        ) {
                                            Text(
                                                item.title,
                                                color = Color.White,
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 14.sp,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis,
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
}
