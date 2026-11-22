package com.metrolist.desktop.ui.player

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode as AnimRepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import kotlin.math.abs
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Fullscreen
import androidx.compose.material.icons.rounded.FullscreenExit
import androidx.compose.material.icons.rounded.Translate
import androidx.compose.material.icons.automirrored.rounded.QueueMusic
import androidx.compose.material.icons.automirrored.rounded.*
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.metrolist.desktop.models.DesktopTrack
import com.metrolist.desktop.models.RepeatMode
import com.metrolist.desktop.playback.DesktopPlaybackEngine
import com.metrolist.desktop.ui.components.EqualizerBars
import com.metrolist.desktop.ui.components.GlassRimBrush
import com.metrolist.desktop.ui.components.SleekProgressBar
import com.metrolist.desktop.ui.components.ambientGlow
import com.metrolist.desktop.ui.components.glassSurface
import com.metrolist.desktop.ui.theme.GlassOverlayShape

@Composable
fun GlassBottomPlayer(
    engine: DesktopPlaybackEngine,
    onOpenFullPlayer: (Int) -> Unit,
    onOpenAddToPlaylist: (DesktopTrack) -> Unit,
) {
    val state by engine.state.collectAsState()
    val cs = MaterialTheme.colorScheme
    val track = state.currentTrack

    Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 14.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(84.dp)
                .glassSurface(GlassOverlayShape, elevated = true)
                .padding(horizontal = 20.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            // Left: Track Info + Like + Playlist
            Row(
                modifier = Modifier
                    .weight(0.32f)
                    .clip(RoundedCornerShape(14.dp))
                    .clickable(enabled = track != null) { onOpenFullPlayer(0) }
                    .padding(4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                if (track != null) {
                    AsyncImage(
                        model = highResThumbnail(track.thumbnail),
                        contentDescription = track.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(54.dp).clip(RoundedCornerShape(14.dp)).border(0.5.dp, GlassRimBrush, RoundedCornerShape(14.dp)),
                    )
                    Column(modifier = Modifier.weight(1f)) {
                        Text(track.title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                        Text(track.artist, color = cs.onSurfaceVariant, fontSize = 12.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                    }
                    IconButton(onClick = { engine.toggleFavorite(track) }, modifier = Modifier.size(34.dp)) {
                        Icon(
                            if (state.isCurrentLiked) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                            contentDescription = "Like",
                            tint = if (state.isCurrentLiked) cs.primary else cs.onSurfaceVariant,
                            modifier = Modifier.size(20.dp),
                        )
                    }
                    IconButton(onClick = { onOpenAddToPlaylist(track) }, modifier = Modifier.size(34.dp)) {
                        Icon(Icons.AutoMirrored.Rounded.PlaylistAdd, contentDescription = "Add to Playlist", tint = cs.onSurfaceVariant, modifier = Modifier.size(20.dp))
                    }
                } else {
                    Text("Pilih lagu untuk mulai memutar", color = cs.onSurfaceVariant, fontSize = 13.sp)
                }
            }

            // Center: Playback Controls + Sleek Progress
            Column(
                modifier = Modifier.weight(0.40f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                    IconButton(onClick = { engine.toggleShuffle() }, modifier = Modifier.size(32.dp)) {
                        Icon(Icons.Rounded.Shuffle, contentDescription = "Shuffle", tint = if (state.isShuffled) cs.primary else cs.onSurfaceVariant, modifier = Modifier.size(18.dp))
                    }
                    IconButton(onClick = { engine.playPrevious() }, modifier = Modifier.size(32.dp)) {
                        Icon(Icons.Rounded.SkipPrevious, contentDescription = "Prev", tint = Color.White, modifier = Modifier.size(24.dp))
                    }
                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .clip(CircleShape)
                            .background(cs.primary)
                            .clickable(enabled = track != null) { engine.togglePlayPause() },
                        contentAlignment = Alignment.Center,
                    ) {
                        if (state.isLoading) {
                            CircularProgressIndicator(modifier = Modifier.size(18.dp), strokeWidth = 2.dp, color = cs.onPrimary)
                        } else {
                            Icon(if (state.isPlaying) Icons.Rounded.Pause else Icons.Rounded.PlayArrow, contentDescription = "Play/Pause", tint = cs.onPrimary, modifier = Modifier.size(22.dp))
                        }
                    }
                    IconButton(onClick = { engine.playNext() }, modifier = Modifier.size(32.dp)) {
                        Icon(Icons.Rounded.SkipNext, contentDescription = "Next", tint = Color.White, modifier = Modifier.size(24.dp))
                    }
                    IconButton(onClick = { engine.cycleRepeatMode() }, modifier = Modifier.size(32.dp)) {
                        Icon(
                            if (state.repeatMode == RepeatMode.ONE) Icons.Rounded.RepeatOne else Icons.Rounded.Repeat,
                            contentDescription = "Repeat",
                            tint = if (state.repeatMode != RepeatMode.OFF) cs.primary else cs.onSurfaceVariant,
                            modifier = Modifier.size(18.dp),
                        )
                    }
                }

                val prog by engine.progress.collectAsState()
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(formatMs(prog.positionMs), fontSize = 11.sp, color = cs.onSurfaceVariant)
                    val frac = if (prog.durationMs > 0L) (prog.positionMs.toFloat() / prog.durationMs.toFloat()) else 0f
                    SleekProgressBar(fraction = frac, onSeekFraction = { f -> engine.seekTo((f * prog.durationMs).toLong()) }, modifier = Modifier.weight(1f))
                    Text(formatMs(prog.durationMs), fontSize = 11.sp, color = cs.onSurfaceVariant)
                }
            }

            // Right: Download + Lyrics + Volume + Fullscreen
            Row(modifier = Modifier.weight(0.28f), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End) {
                if (track != null) {
                    val isDl = state.isDownloaded(track.id)
                    val isDling = state.isDownloading(track.id)
                    IconButton(onClick = { engine.downloadTrack(track) }, modifier = Modifier.size(34.dp)) {
                        if (isDling) {
                            CircularProgressIndicator(modifier = Modifier.size(16.dp), strokeWidth = 2.dp, color = cs.primary)
                        } else {
                            Icon(
                                if (isDl) Icons.Rounded.DownloadDone else Icons.Rounded.Download,
                                contentDescription = "Download",
                                tint = if (isDl) cs.primary else cs.onSurfaceVariant,
                                modifier = Modifier.size(20.dp),
                            )
                        }
                    }
                }
                IconButton(onClick = { if (track != null) onOpenFullPlayer(1) }, modifier = Modifier.size(34.dp)) {
                    Icon(Icons.Rounded.Lyrics, contentDescription = "Lyrics", tint = cs.primary, modifier = Modifier.size(20.dp))
                }
                IconButton(onClick = { if (track != null) onOpenFullPlayer(0) }, modifier = Modifier.size(34.dp)) {
                    Icon(Icons.AutoMirrored.Rounded.QueueMusic, contentDescription = "Queue", tint = cs.onSurfaceVariant, modifier = Modifier.size(20.dp))
                }
                Spacer(Modifier.width(4.dp))
                IconButton(onClick = { engine.setVolume(if (state.volume > 0) 0 else 80) }, modifier = Modifier.size(30.dp)) {
                    Icon(if (state.volume == 0) Icons.AutoMirrored.Rounded.VolumeOff else Icons.AutoMirrored.Rounded.VolumeUp, contentDescription = "Volume", tint = cs.onSurfaceVariant, modifier = Modifier.size(19.dp))
                }
                Spacer(Modifier.width(6.dp))
                SleekProgressBar(fraction = state.volume / 100f, onSeekFraction = { f -> engine.setVolume((f * 100).toInt()) }, modifier = Modifier.width(92.dp))
                Spacer(Modifier.width(6.dp))
                IconButton(onClick = { if (track != null) onOpenFullPlayer(0) }, modifier = Modifier.size(34.dp)) {
                    Icon(Icons.Rounded.OpenInFull, contentDescription = "Fullscreen", tint = Color.White, modifier = Modifier.size(18.dp))
                }
            }
        }
    }
}

@Composable
fun FullGlassPlayerOverlay(
    engine: DesktopPlaybackEngine,
    initialTab: Int,
    onClose: () -> Unit,
    onOpenAddToPlaylist: (DesktopTrack) -> Unit,
) {
    val state by engine.state.collectAsState()
    val cs = MaterialTheme.colorScheme
    val track = state.currentTrack ?: return
    var rightTab by remember(initialTab) { mutableStateOf(initialTab) }
    var immersiveLyrics by remember { mutableStateOf(false) }
    val infiniteTransition = rememberInfiniteTransition(label = "gloomy")
    val orbShift1 by infiniteTransition.animateFloat(initialValue = 0f, targetValue = 1f, animationSpec = infiniteRepeatable(tween(9000, easing = FastOutSlowInEasing), AnimRepeatMode.Reverse), label = "orb1")
    val orbShift2 by infiniteTransition.animateFloat(initialValue = 0f, targetValue = 1f, animationSpec = infiniteRepeatable(tween(12000, easing = FastOutSlowInEasing), AnimRepeatMode.Reverse), label = "orb2")
    val orbPulse by infiniteTransition.animateFloat(initialValue = 0.85f, targetValue = 1.25f, animationSpec = infiniteRepeatable(tween(4500, easing = FastOutSlowInEasing), AnimRepeatMode.Reverse), label = "pulse")
    val lyricsListState = rememberLazyListState()
    var lyricsViewportHeightPx by remember { mutableStateOf(0) }

    val prog by engine.progress.collectAsState()
    val activeLyricIndex = remember(state.syncedLyrics, prog.positionMs) {
        state.syncedLyrics.indexOfLast { it.timeMs <= prog.positionMs + 250L }
    }

    LaunchedEffect(activeLyricIndex, rightTab) {
        if (rightTab == 1 && activeLyricIndex >= 0) {
            if (immersiveLyrics && lyricsViewportHeightPx > 0) {
                lyricsListState.animateScrollToItem(index = activeLyricIndex, scrollOffset = (lyricsViewportHeightPx * 0.40f).toInt())
            } else {
                lyricsListState.animateScrollToItem((activeLyricIndex - 2).coerceAtLeast(0))
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(cs.background)
            .ambientGlow(cs.primary, cs.secondary, cs.tertiary),
    ) {
        if (immersiveLyrics) {
            androidx.compose.foundation.Canvas(modifier = Modifier.fillMaxSize()) {
                val w = size.width
                val h = size.height
                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(cs.primary.copy(alpha = 0.28f), Color.Transparent),
                        center = Offset(w * (0.25f + 0.35f * orbShift1), h * (0.30f + 0.25f * orbShift2)),
                        radius = w * 0.55f * orbPulse,
                    ),
                    radius = w * 0.55f * orbPulse,
                    center = Offset(w * (0.25f + 0.35f * orbShift1), h * (0.30f + 0.25f * orbShift2)),
                )
                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(cs.tertiary.copy(alpha = 0.24f), Color.Transparent),
                        center = Offset(w * (0.78f - 0.35f * orbShift2), h * (0.72f - 0.30f * orbShift1)),
                        radius = w * 0.50f * orbPulse,
                    ),
                    radius = w * 0.50f * orbPulse,
                    center = Offset(w * (0.78f - 0.35f * orbShift2), h * (0.72f - 0.30f * orbShift1)),
                )
                drawRect(
                    brush = Brush.radialGradient(
                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.72f)),
                        center = Offset(w * 0.5f, h * 0.5f),
                        radius = w * 0.75f,
                    ),
                )
            }
        }
        Column(modifier = Modifier.fillMaxSize().padding(32.dp)) {
            // Top Navigation Bar
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onClose, modifier = Modifier.glassSurface(CircleShape, elevated = true)) {
                    Icon(Icons.Rounded.KeyboardArrowDown, contentDescription = "Close", tint = Color.White, modifier = Modifier.size(28.dp))
                }
                Text("NOW PLAYING", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = cs.onSurfaceVariant)
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    IconButton(onClick = { onOpenAddToPlaylist(track) }, modifier = Modifier.glassSurface(CircleShape, elevated = true)) {
                        Icon(Icons.AutoMirrored.Rounded.PlaylistAdd, contentDescription = "Add to playlist", tint = Color.White)
                    }
                    IconButton(onClick = { engine.toggleFavorite(track) }, modifier = Modifier.glassSurface(CircleShape, elevated = true)) {
                        Icon(if (state.isCurrentLiked) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder, contentDescription = "Like", tint = if (state.isCurrentLiked) cs.primary else Color.White)
                    }
                }
            }

            // Main Content: Left Vinyl Art + Right Side Panel
            Row(
                modifier = Modifier.weight(1f).fillMaxWidth().padding(top = 18.dp),
                horizontalArrangement = Arrangement.spacedBy(48.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                // Left Column: Artwork & Player Controls
                if (!immersiveLyrics) Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                ) {
                    val albumArtScale by animateFloatAsState(if (state.isPlaying) 1.0f else 0.94f, tween(300))
                    AsyncImage(
                        model = highResThumbnail(track.thumbnail),
                        contentDescription = track.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(360.dp)
                            .scale(albumArtScale)
                            .shadow(28.dp, RoundedCornerShape(28.dp))
                            .clip(RoundedCornerShape(28.dp))
                            .border(1.dp, GlassRimBrush, RoundedCornerShape(28.dp)),
                    )
                    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(track.title, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White, maxLines = 1, overflow = TextOverflow.Ellipsis)
                        Text(track.artist, fontSize = 15.sp, color = cs.onSurfaceVariant, maxLines = 1)
                    }
                    Column(modifier = Modifier.fillMaxWidth(0.86f)) {
                        val frac = if (prog.durationMs > 0L) (prog.positionMs.toFloat() / prog.durationMs.toFloat()) else 0f
                        SleekProgressBar(fraction = frac, onSeekFraction = { f -> engine.seekTo((f * prog.durationMs).toLong()) }, modifier = Modifier.fillMaxWidth())
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text(formatMs(prog.positionMs), fontSize = 12.sp, color = cs.onSurfaceVariant)
                            Text(formatMs(prog.durationMs), fontSize = 12.sp, color = cs.onSurfaceVariant)
                        }
                    }
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                        IconButton(onClick = { engine.toggleShuffle() }) {
                            Icon(Icons.Rounded.Shuffle, contentDescription = "Shuffle", tint = if (state.isShuffled) cs.primary else cs.onSurfaceVariant)
                        }
                        IconButton(onClick = { engine.playPrevious() }) {
                            Icon(Icons.Rounded.SkipPrevious, contentDescription = "Prev", tint = Color.White, modifier = Modifier.size(34.dp))
                        }
                        Box(
                            modifier = Modifier.size(64.dp).clip(CircleShape).background(cs.primary).clickable { engine.togglePlayPause() },
                            contentAlignment = Alignment.Center,
                        ) {
                            Icon(if (state.isPlaying) Icons.Rounded.Pause else Icons.Rounded.PlayArrow, contentDescription = "Play/Pause", tint = cs.onPrimary, modifier = Modifier.size(32.dp))
                        }
                        IconButton(onClick = { engine.playNext() }) {
                            Icon(Icons.Rounded.SkipNext, contentDescription = "Next", tint = Color.White, modifier = Modifier.size(34.dp))
                        }
                        IconButton(onClick = { engine.cycleRepeatMode() }) {
                            Icon(
                                if (state.repeatMode == RepeatMode.ONE) Icons.Rounded.RepeatOne else Icons.Rounded.Repeat,
                                contentDescription = "Repeat",
                                tint = if (state.repeatMode != RepeatMode.OFF) cs.primary else cs.onSurfaceVariant,
                            )
                        }
                    }
                }

                // Right Column: Queue (Up Next) or Lyrics
                Column(
                    modifier = if (immersiveLyrics) Modifier.fillMaxSize().padding(horizontal = 12.dp, vertical = 0.dp) else Modifier.weight(0.92f).fillMaxHeight(0.90f).glassSurface(GlassOverlayShape, elevated = false).padding(22.dp),
                ) {
                    if (!immersiveLyrics) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            listOf("Up Next (${state.queue.size})", "Lyrics").forEachIndexed { idx, title ->
                                val active = rightTab == idx
                                Box(
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .background(if (active) cs.primary else Color.White.copy(0.08f))
                                        .clickable { rightTab = idx }
                                        .padding(horizontal = 18.dp, vertical = 8.dp)
                                ) {
                                    Text(title, color = if (active) cs.onPrimary else Color.White, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }

                        if (rightTab == 0 && state.queue.size > 1) {
                            TextButton(onClick = { engine.clearQueue() }) {
                                Text("Clear Queue", color = cs.onSurfaceVariant, fontSize = 12.sp)
                            }
                        } else if (rightTab == 1) {
                            Row(horizontalArrangement = Arrangement.spacedBy(22.dp), verticalAlignment = Alignment.CenterVertically) {
                                IconButton(
                                    onClick = { engine.toggleLyricTranslation() },
                                    modifier = Modifier.size(34.dp).glassSurface(CircleShape),
                                ) {
                                    Icon(
                                        Icons.Rounded.Translate,
                                        contentDescription = "Latin & Terjemahan",
                                        tint = if (state.showLyricTranslation) cs.primary else Color.White.copy(0.75f),
                                        modifier = Modifier.size(17.dp),
                                    )
                                }
                                IconButton(
                                    onClick = { immersiveLyrics = true },
                                    modifier = Modifier.size(34.dp).glassSurface(CircleShape),
                                ) {
                                    Icon(
                                        Icons.Rounded.Fullscreen,
                                        contentDescription = "Immersive Lyrics",
                                        tint = Color.White,
                                        modifier = Modifier.size(18.dp),
                                    )
                                }
                            }
                        }
                    }

                    Spacer(Modifier.height(18.dp))
                    }

                    if (rightTab == 0) {
                        LazyColumn(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            itemsIndexed(state.queue) { idx, item ->
                                val isCurrent = item.id == track.id
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(14.dp))
                                        .background(if (isCurrent) Color.White.copy(0.14f) else Color.Transparent)
                                        .clickable { engine.playTrack(item, state.queue) }
                                        .padding(8.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                                ) {
                                    AsyncImage(model = item.thumbnail, contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.size(42.dp).clip(RoundedCornerShape(10.dp)))
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(item.title, color = if (isCurrent) cs.primary else Color.White, fontSize = 13.sp, fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Normal, maxLines = 1, overflow = TextOverflow.Ellipsis)
                                        Text(item.artist, color = cs.onSurfaceVariant, fontSize = 11.sp, maxLines = 1)
                                    }
                                    if (isCurrent && state.isPlaying) {
                                        EqualizerBars(cs.primary)
                                    }
                                    if (idx > 0) {
                                        IconButton(onClick = { engine.moveQueueItem(idx, idx - 1) }, modifier = Modifier.size(28.dp)) {
                                            Icon(Icons.Rounded.ArrowUpward, contentDescription = "Move up", tint = cs.onSurfaceVariant, modifier = Modifier.size(16.dp))
                                        }
                                    }
                                    if (idx < state.queue.lastIndex) {
                                        IconButton(onClick = { engine.moveQueueItem(idx, idx + 1) }, modifier = Modifier.size(28.dp)) {
                                            Icon(Icons.Rounded.ArrowDownward, contentDescription = "Move down", tint = cs.onSurfaceVariant, modifier = Modifier.size(16.dp))
                                        }
                                    }
                                    IconButton(onClick = { engine.removeFromQueue(idx) }, modifier = Modifier.size(28.dp)) {
                                        Icon(Icons.Rounded.Close, contentDescription = "Remove", tint = cs.onSurfaceVariant, modifier = Modifier.size(16.dp))
                                    }
                                }
                            }
                        }
                    } else {
                        when {
                            state.lyricsLoading -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                CircularProgressIndicator(color = cs.primary)
                            }
                            state.syncedLyrics.isNotEmpty() -> Column(modifier = Modifier.fillMaxSize()) {

                                if (immersiveLyrics) {
                                    BoxWithConstraints(
                                        modifier = Modifier.weight(1f).fillMaxWidth(),
                                        contentAlignment = Alignment.Center,
                                    ) {
                                        val density = LocalDensity.current
                                        val stepPx = with(density) { 128.dp.toPx() }
                                        val liftPx = with(density) { 12.dp.toPx() }
                                        val hasStarted = activeLyricIndex >= 0
                                        val centerIdx = if (hasStarted) activeLyricIndex else 0
                                        val visibleRange = ((centerIdx - 4).coerceAtLeast(0))..((centerIdx + 4).coerceAtMost(state.syncedLyrics.lastIndex))
                                        for (idx in visibleRange) {
                                            androidx.compose.runtime.key(idx) {
                                                val line = state.syncedLyrics[idx]
                                                val rel = idx - centerIdx
                                                val active = hasStarted && (rel == 0)
                                                val dist = if (hasStarted) abs(rel) else (idx + 1)
                                                val animatedRel by animateFloatAsState(
                                                    targetValue = rel.toFloat(),
                                                    animationSpec = tween(durationMillis = 550, easing = FastOutSlowInEasing),
                                                    label = "lyricSlide",
                                                )
                                                val targetAlpha = when (dist) {
                                                    0 -> 1f
                                                    1 -> 0.45f
                                                    2 -> 0.24f
                                                    3 -> 0.12f
                                                    else -> 0f
                                                }
                                                val animatedAlpha by animateFloatAsState(
                                                    targetValue = targetAlpha,
                                                    animationSpec = tween(durationMillis = 450, easing = FastOutSlowInEasing),
                                                    label = "lyricAlpha",
                                                )
                                                val animatedScale by animateFloatAsState(
                                                    targetValue = if (active) 1.0f else (0.76f - dist * 0.04f).coerceAtLeast(0.62f),
                                                    animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing),
                                                    label = "lyricScale",
                                                )
                                                val blurDp = if (active) 0.dp else (dist.coerceAtMost(3) * 1.8f).dp
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .graphicsLayer {
                                                            translationY = (animatedRel * stepPx) - liftPx
                                                            scaleX = animatedScale
                                                            scaleY = animatedScale
                                                            alpha = animatedAlpha
                                                        }
                                                        .then(if (blurDp > 0.dp) Modifier.blur(blurDp) else Modifier)
                                                        .clip(RoundedCornerShape(16.dp))
                                                        .clickable { engine.seekTo(line.timeMs) }
                                                        .padding(horizontal = 24.dp, vertical = 6.dp),
                                                    horizontalAlignment = Alignment.CenterHorizontally,
                                                    verticalArrangement = Arrangement.spacedBy(4.dp),
                                                ) {
                                                    Text(
                                                        text = line.text,
                                                        color = Color.White,
                                                        fontSize = 46.sp,
                                                        fontWeight = FontWeight.Bold,
                                                        lineHeight = 56.sp,
                                                        textAlign = TextAlign.Center,
                                                        modifier = Modifier.fillMaxWidth(),
                                                    )
                                                    if (state.showLyricTranslation && !line.romanized.isNullOrBlank()) {
                                                        Text(
                                                            text = line.romanized,
                                                            color = cs.primary,
                                                            fontSize = 21.sp,
                                                            fontWeight = FontWeight.Medium,
                                                            lineHeight = 26.sp,
                                                            textAlign = TextAlign.Center,
                                                            modifier = Modifier.fillMaxWidth(),
                                                        )
                                                    }
                                                    if (state.showLyricTranslation && !line.translated.isNullOrBlank()) {
                                                        Text(
                                                            text = line.translated,
                                                            color = Color.White.copy(0.80f),
                                                            fontSize = 19.sp,
                                                            fontWeight = FontWeight.Normal,
                                                            lineHeight = 24.sp,
                                                            textAlign = TextAlign.Center,
                                                            modifier = Modifier.fillMaxWidth(),
                                                        )
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    LazyColumn(
                                        state = lyricsListState,
                                        verticalArrangement = Arrangement.spacedBy(16.dp),
                                        contentPadding = PaddingValues(vertical = 20.dp),
                                    ) {
                                        itemsIndexed(state.syncedLyrics) { idx, line ->
                                            val active = idx == activeLyricIndex
                                            val lyricColor by animateColorAsState(if (active) Color.White else Color.White.copy(0.36f), tween(200))
                                            val lyricScale by animateFloatAsState(if (active) 1.03f else 1.0f, tween(200))
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .scale(lyricScale)
                                                    .clip(RoundedCornerShape(12.dp))
                                                    .clickable { engine.seekTo(line.timeMs) }
                                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                                                horizontalAlignment = Alignment.CenterHorizontally,
                                                verticalArrangement = Arrangement.spacedBy(3.dp),
                                            ) {
                                                Text(
                                                    text = line.text,
                                                    color = lyricColor,
                                                    fontSize = if (active) 21.sp else 17.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    lineHeight = 28.sp,
                                                    textAlign = TextAlign.Center,
                                                    modifier = Modifier.fillMaxWidth(),
                                                )
                                                if (state.showLyricTranslation && !line.romanized.isNullOrBlank()) {
                                                    Text(
                                                        text = line.romanized,
                                                        color = if (active) cs.primary else cs.primary.copy(0.55f),
                                                        fontSize = if (active) 14.sp else 13.sp,
                                                        fontWeight = FontWeight.Medium,
                                                        lineHeight = 20.sp,
                                                        textAlign = TextAlign.Center,
                                                        modifier = Modifier.fillMaxWidth(),
                                                    )
                                                }
                                                if (state.showLyricTranslation && !line.translated.isNullOrBlank()) {
                                                    Text(
                                                        text = line.translated,
                                                        color = if (active) Color.White.copy(0.78f) else Color.White.copy(0.32f),
                                                        fontSize = if (active) 13.sp else 12.sp,
                                                        fontWeight = FontWeight.Normal,
                                                        lineHeight = 18.sp,
                                                        textAlign = TextAlign.Center,
                                                        modifier = Modifier.fillMaxWidth(),
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else -> Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
                                Text(state.plainLyrics ?: "Lirik tidak tersedia.", color = Color.White.copy(0.9f), fontSize = 16.sp, lineHeight = 26.sp)
                            }
                        }
                    }
                }
            }

            if (immersiveLyrics) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp).glassSurface(CircleShape, elevated = true).padding(horizontal = 24.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(18.dp),
                ) {
                    AsyncImage(model = highResThumbnail(track.thumbnail), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.size(42.dp).clip(CircleShape))
                    Column(modifier = Modifier.width(200.dp)) {
                        Text(track.title, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.White, maxLines = 1, overflow = TextOverflow.Ellipsis)
                        Text(track.artist, fontSize = 12.sp, color = cs.onSurfaceVariant, maxLines = 1, overflow = TextOverflow.Ellipsis)
                    }
                    val frac = if (prog.durationMs > 0L) (prog.positionMs.toFloat() / prog.durationMs.toFloat()) else 0f
                    Text(formatMs(prog.positionMs), fontSize = 11.sp, color = cs.onSurfaceVariant)
                    SleekProgressBar(fraction = frac, onSeekFraction = { f -> engine.seekTo((f * prog.durationMs).toLong()) }, modifier = Modifier.weight(1f))
                    Text(formatMs(prog.durationMs), fontSize = 11.sp, color = cs.onSurfaceVariant)
                    IconButton(onClick = { engine.playPrevious() }, modifier = Modifier.size(34.dp)) { Icon(Icons.Rounded.SkipPrevious, null, tint = Color.White) }
                    Box(modifier = Modifier.size(40.dp).clip(CircleShape).background(cs.primary).clickable { engine.togglePlayPause() }, contentAlignment = Alignment.Center) {
                        Icon(if (state.isPlaying) Icons.Rounded.Pause else Icons.Rounded.PlayArrow, null, tint = cs.onPrimary, modifier = Modifier.size(22.dp))
                    }
                    IconButton(onClick = { engine.playNext() }, modifier = Modifier.size(34.dp)) { Icon(Icons.Rounded.SkipNext, null, tint = Color.White) }
                    IconButton(onClick = { engine.toggleLyricTranslation() }, modifier = Modifier.size(34.dp)) { Icon(Icons.Rounded.Translate, contentDescription = "Latin & Terjemahan", tint = if (state.showLyricTranslation) cs.primary else Color.White.copy(0.65f), modifier = Modifier.size(18.dp)) }
                    IconButton(onClick = { immersiveLyrics = false }, modifier = Modifier.size(34.dp)) { Icon(Icons.Rounded.FullscreenExit, contentDescription = "Exit Fullscreen", tint = cs.primary, modifier = Modifier.size(20.dp)) }
                }
            }
        }
    }
}

private fun formatMs(ms: Long): String {
    val totalSec = (ms / 1000L).coerceAtLeast(0L)
    val min = totalSec / 60L
    val sec = totalSec % 60L
    return "%d:%02d".format(min, sec)
}

private fun highResThumbnail(url: String): String {
    if (url.isBlank()) return url
    return when {
        url.contains("googleusercontent.com") && url.contains("=w") -> url.substringBefore("=w") + "=w1200-h1200-l90-rj"
        url.contains("i.ytimg.com/vi/") -> url.replace("hqdefault.jpg", "maxresdefault.jpg").replace("mqdefault.jpg", "maxresdefault.jpg")
        else -> url
    }
}
