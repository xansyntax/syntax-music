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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.metrolist.desktop.models.ArtistDetail
import com.metrolist.desktop.models.CollectionDetail
import com.metrolist.desktop.models.DesktopTrack
import com.metrolist.desktop.playback.DesktopPlaybackEngine
import com.metrolist.desktop.ui.components.GlassRimBrush
import com.metrolist.desktop.ui.components.glassSurface
import com.metrolist.desktop.ui.theme.GlassCardShape

@Composable
fun ArtistScreen(
    detail: ArtistDetail,
    onBack: () -> Unit,
    onPlayTrack: (DesktopTrack, List<DesktopTrack>) -> Unit,
    onOpenCollection: (CollectionDetail) -> Unit,
    onOpenArtistById: (String) -> Unit,
    engine: DesktopPlaybackEngine,
    onOpenAddToPlaylist: (DesktopTrack) -> Unit,
) {
    val cs = MaterialTheme.colorScheme
    val state by engine.state.collectAsState()
    var bioExpanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 26.dp, vertical = 22.dp)) {
        // Back Button
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.clickable(onClick = onBack).padding(bottom = 14.dp),
        ) {
            IconButton(onClick = onBack, modifier = Modifier.glassSurface(CircleShape, elevated = false).size(36.dp)) {
                Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back", tint = Color.White, modifier = Modifier.size(20.dp))
            }
            Text("Kembali", color = cs.onSurfaceVariant, fontSize = 14.sp, fontWeight = FontWeight.Medium)
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(28.dp),
            contentPadding = PaddingValues(bottom = 32.dp),
        ) {
            // Artist Header Banner
            item(key = "artist_header") {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .glassSurface(GlassCardShape, elevated = true)
                        .padding(24.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(26.dp),
                ) {
                    AsyncImage(
                        model = detail.thumbnail,
                        contentDescription = detail.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(150.dp)
                            .clip(CircleShape)
                            .border(2.dp, GlassRimBrush, CircleShape),
                    )
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.weight(1f)) {
                        Text(detail.name, fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        val subText = listOfNotNull(detail.monthlyListeners, detail.subscriberCount).joinToString(" • ")
                        if (subText.isNotBlank()) {
                            Text(subText, fontSize = 14.sp, color = cs.onSurfaceVariant)
                        }

                        if (!detail.description.isNullOrBlank()) {
                            Text(
                                detail.description,
                                fontSize = 13.sp,
                                color = cs.onSurfaceVariant.copy(0.9f),
                                maxLines = if (bioExpanded) 12 else 2,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.clickable { bioExpanded = !bioExpanded },
                            )
                        }

                        Row(horizontalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.padding(top = 4.dp)) {
                            if (detail.topSongs.isNotEmpty()) {
                                Button(
                                    onClick = { onPlayTrack(detail.topSongs.first(), detail.topSongs) },
                                    shape = CircleShape,
                                    colors = ButtonDefaults.buttonColors(containerColor = cs.primary, contentColor = cs.onPrimary),
                                ) {
                                    Icon(Icons.Rounded.PlayArrow, contentDescription = null, modifier = Modifier.size(20.dp))
                                    Spacer(Modifier.width(6.dp))
                                    Text("Play (${detail.topSongs.size})", fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }
                }
            }

            // Top Songs Section
            if (detail.topSongs.isNotEmpty()) {
                item(key = "top_songs") {
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Text("Top Songs", fontSize = 21.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            detail.topSongs.take(8).forEachIndexed { idx, track ->
                                val isCur = state.currentTrack?.id == track.id
                                val interaction = remember { MutableInteractionSource() }
                                val hovered by interaction.collectIsHoveredAsState()
                                val bg by animateColorAsState(
                                    if (isCur) cs.primaryContainer.copy(0.40f) else if (hovered) Color.White.copy(0.11f) else Color.White.copy(0.04f),
                                    tween(120),
                                )

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(14.dp))
                                        .background(bg)
                                        .border(0.5.dp, if (isCur) cs.primary.copy(0.5f) else Color.White.copy(0.08f), RoundedCornerShape(14.dp))
                                        .hoverable(interaction)
                                        .clickable { onPlayTrack(track, detail.topSongs) }
                                        .padding(horizontal = 14.dp, vertical = 10.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(14.dp),
                                ) {
                                    Text("${idx + 1}", color = cs.onSurfaceVariant, fontSize = 13.sp, fontWeight = FontWeight.Bold, modifier = Modifier.width(26.dp))
                                    AsyncImage(
                                        model = track.thumbnail,
                                        contentDescription = track.title,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.size(42.dp).clip(RoundedCornerShape(8.dp)),
                                    )
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(track.title, color = if (isCur) cs.primary else Color.White, fontWeight = FontWeight.Medium, fontSize = 14.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
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
                                    track.durationSec?.let { dur ->
                                        Text(formatSec(dur), color = cs.onSurfaceVariant, fontSize = 12.sp)
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // Albums Section
            if (detail.albums.isNotEmpty()) {
                item(key = "albums") {
                    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                        Text("Albums", fontSize = 21.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                            items(detail.albums) { alb ->
                                Column(
                                    modifier = Modifier
                                        .width(170.dp)
                                        .glassSurface(GlassCardShape)
                                        .clickable { onOpenCollection(alb) }
                                        .padding(12.dp),
                                    verticalArrangement = Arrangement.spacedBy(8.dp),
                                ) {
                                    AsyncImage(
                                        model = alb.thumbnail,
                                        contentDescription = alb.title,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.fillMaxWidth().aspectRatio(1f).clip(RoundedCornerShape(14.dp)),
                                    )
                                    Text(alb.title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 13.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                                    if (alb.yearOrCount.isNotBlank()) {
                                        Text(alb.yearOrCount, color = cs.onSurfaceVariant, fontSize = 11.sp)
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // Singles & EPs Section
            if (detail.singles.isNotEmpty()) {
                item(key = "singles") {
                    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                        Text("Singles & EPs", fontSize = 21.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                            items(detail.singles) { single ->
                                Column(
                                    modifier = Modifier
                                        .width(170.dp)
                                        .glassSurface(GlassCardShape)
                                        .clickable { onOpenCollection(single) }
                                        .padding(12.dp),
                                    verticalArrangement = Arrangement.spacedBy(8.dp),
                                ) {
                                    AsyncImage(
                                        model = single.thumbnail,
                                        contentDescription = single.title,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.fillMaxWidth().aspectRatio(1f).clip(RoundedCornerShape(14.dp)),
                                    )
                                    Text(single.title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 13.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                                    if (single.yearOrCount.isNotBlank()) {
                                        Text(single.yearOrCount, color = cs.onSurfaceVariant, fontSize = 11.sp)
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // Related Artists / Fans Might Also Like
            if (detail.relatedArtists.isNotEmpty()) {
                item(key = "related") {
                    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                        Text("Fans Also Like", fontSize = 21.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        LazyRow(horizontalArrangement = Arrangement.spacedBy(18.dp)) {
                            items(detail.relatedArtists) { relArtist ->
                                Column(
                                    modifier = Modifier
                                        .width(140.dp)
                                        .clickable { onOpenArtistById(relArtist.id) },
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(8.dp),
                                ) {
                                    AsyncImage(
                                        model = relArtist.thumbnail,
                                        contentDescription = relArtist.title,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.size(110.dp).clip(CircleShape).border(1.dp, GlassRimBrush, CircleShape),
                                    )
                                    Text(relArtist.title, color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 13.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                                    Text("Artist", color = cs.onSurfaceVariant, fontSize = 11.sp)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CollectionScreen(
    detail: CollectionDetail,
    onBack: () -> Unit,
    onPlayTrack: (DesktopTrack, List<DesktopTrack>) -> Unit,
    onOpenArtist: (String) -> Unit,
    engine: DesktopPlaybackEngine,
    onOpenAddToPlaylist: (DesktopTrack) -> Unit,
) {
    val cs = MaterialTheme.colorScheme
    val state by engine.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 26.dp, vertical = 22.dp)) {
        // Back Button
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.clickable(onClick = onBack).padding(bottom = 14.dp),
        ) {
            IconButton(onClick = onBack, modifier = Modifier.glassSurface(CircleShape, elevated = false).size(36.dp)) {
                Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back", tint = Color.White, modifier = Modifier.size(20.dp))
            }
            Text("Kembali", color = cs.onSurfaceVariant, fontSize = 14.sp, fontWeight = FontWeight.Medium)
        }

        // Header Card
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.fillMaxWidth().glassSurface(GlassCardShape, elevated = true).padding(20.dp),
        ) {
            AsyncImage(
                model = detail.thumbnail,
                contentDescription = detail.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .border(1.dp, GlassRimBrush, RoundedCornerShape(20.dp)),
            )
            Column(verticalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.weight(1f)) {
                Text(if (detail.isAlbum) "ALBUM" else "PLAYLIST", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = cs.primary)
                Text(detail.title, fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color.White, maxLines = 2)
                if (detail.subtitle.isNotBlank()) {
                    Text(
                        detail.subtitle,
                        fontSize = 14.sp,
                        color = cs.onSurfaceVariant,
                        modifier = Modifier.clickable {
                            val firstTrackArtistId = detail.tracks.firstOrNull()?.artistId
                            if (firstTrackArtistId != null) onOpenArtist(firstTrackArtistId)
                        },
                    )
                }
                if (detail.yearOrCount.isNotBlank()) {
                    Text(detail.yearOrCount, fontSize = 12.sp, color = cs.onSurfaceVariant.copy(0.7f))
                }
                if (detail.tracks.isNotEmpty()) {
                    Row(horizontalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.padding(top = 4.dp)) {
                        Button(
                            onClick = { onPlayTrack(detail.tracks.first(), detail.tracks) },
                            shape = CircleShape,
                            colors = ButtonDefaults.buttonColors(containerColor = cs.primary, contentColor = cs.onPrimary),
                        ) {
                            Icon(Icons.Rounded.PlayArrow, contentDescription = null, modifier = Modifier.size(20.dp))
                            Spacer(Modifier.width(6.dp))
                            Text("Play All (${detail.tracks.size})", fontWeight = FontWeight.Bold)
                        }
                        OutlinedButton(
                            onClick = {
                                val shuffled = detail.tracks.shuffled()
                                onPlayTrack(shuffled.first(), shuffled)
                            },
                            shape = CircleShape,
                        ) {
                            Icon(Icons.Rounded.Shuffle, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(Modifier.width(6.dp))
                            Text("Shuffle")
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(18.dp))

        // Tracks List
        LazyColumn(verticalArrangement = Arrangement.spacedBy(6.dp), contentPadding = PaddingValues(bottom = 28.dp)) {
            itemsIndexed(detail.tracks) { idx, track ->
                val isCur = state.currentTrack?.id == track.id
                val interaction = remember { MutableInteractionSource() }
                val hovered by interaction.collectIsHoveredAsState()
                val bg by animateColorAsState(
                    if (isCur) cs.primaryContainer.copy(0.40f) else if (hovered) Color.White.copy(0.11f) else Color.White.copy(0.04f),
                    tween(120),
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .background(bg)
                        .border(0.5.dp, if (isCur) cs.primary.copy(0.5f) else Color.White.copy(0.08f), RoundedCornerShape(14.dp))
                        .hoverable(interaction)
                        .clickable { onPlayTrack(track, detail.tracks) }
                        .padding(horizontal = 14.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(14.dp),
                ) {
                    Text("${idx + 1}", color = cs.onSurfaceVariant, fontSize = 13.sp, fontWeight = FontWeight.Bold, modifier = Modifier.width(26.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(track.title, color = if (isCur) cs.primary else Color.White, fontWeight = FontWeight.Medium, fontSize = 14.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
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
                    track.durationSec?.let { dur ->
                        Text(formatSec(dur), color = cs.onSurfaceVariant, fontSize = 12.sp)
                    }
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
