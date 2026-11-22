package com.metrolist.desktop.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode as AnimRepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil3.compose.AsyncImage
import com.metrolist.desktop.models.DesktopTrack
import com.metrolist.desktop.models.LocalPlaylist
import com.metrolist.desktop.ui.theme.GlassCardShape
import com.metrolist.innertube.models.*

val GlassRimBrush = Brush.linearGradient(
    colors = listOf(
        Color.White.copy(alpha = 0.48f),
        Color.White.copy(alpha = 0.05f),
        Color.White.copy(alpha = 0.05f),
        Color.White.copy(alpha = 0.22f),
    ),
    start = Offset.Zero,
    end = Offset.Infinite,
)

val GlassSheenBrush = Brush.verticalGradient(
    0.0f to Color.White.copy(alpha = 0.10f),
    0.5f to Color.Transparent,
)

fun glassFill(elevated: Boolean = false): Color =
    Color.White.copy(alpha = if (elevated) 0.13f else 0.08f)

fun Modifier.glassSurface(
    shape: Shape = GlassCardShape,
    elevated: Boolean = false,
): Modifier = this
    .clip(shape)
    .background(glassFill(elevated))
    .background(GlassSheenBrush)
    .border(1.dp, GlassRimBrush, shape)

fun Modifier.ambientGlow(
    primary: Color,
    secondary: Color,
    tertiary: Color,
): Modifier = drawWithCache {
    val brushA = Brush.radialGradient(
        colors = listOf(primary.copy(alpha = 0.38f), Color.Transparent),
        center = Offset(size.width * 0.20f, size.height * 0.15f),
        radius = size.maxDimension * 0.75f,
    )
    val brushB = Brush.radialGradient(
        colors = listOf(secondary.copy(alpha = 0.22f), Color.Transparent),
        center = Offset(size.width * 0.85f, size.height * 0.45f),
        radius = size.maxDimension * 0.65f,
    )
    val brushC = Brush.radialGradient(
        colors = listOf(tertiary.copy(alpha = 0.24f), Color.Transparent),
        center = Offset(size.width * 0.50f, size.height * 0.90f),
        radius = size.maxDimension * 0.70f,
    )
    onDrawBehind {
        drawRect(brushA)
        drawRect(brushB)
        drawRect(brushC)
    }
}

@Composable
fun EqualizerBars(color: Color, modifier: Modifier = Modifier) {
    val transition = rememberInfiniteTransition(label = "eq")
    val b1 by transition.animateFloat(0.20f, 1.0f, infiniteRepeatable(tween(420, easing = FastOutSlowInEasing), AnimRepeatMode.Reverse), label = "b1")
    val b2 by transition.animateFloat(0.95f, 0.25f, infiniteRepeatable(tween(340, easing = FastOutSlowInEasing), AnimRepeatMode.Reverse), label = "b2")
    val b3 by transition.animateFloat(0.35f, 0.90f, infiniteRepeatable(tween(510, easing = FastOutSlowInEasing), AnimRepeatMode.Reverse), label = "b3")

    Row(horizontalArrangement = Arrangement.spacedBy(2.5.dp), verticalAlignment = Alignment.Bottom, modifier = modifier.height(14.dp)) {
        listOf(b1, b2, b3).forEach { frac ->
            Box(modifier = Modifier.width(3.dp).fillMaxHeight(frac).clip(RoundedCornerShape(2.dp)).background(color))
        }
    }
}

@Composable
fun SleekProgressBar(
    fraction: Float,
    onSeekFraction: (Float) -> Unit,
    modifier: Modifier = Modifier,
) {
    val cs = MaterialTheme.colorScheme
    val interaction = remember { MutableInteractionSource() }
    val hovered by interaction.collectIsHoveredAsState()
    var widthPx by remember { mutableStateOf(1f) }

    val trackHeight by animateDpAsState(if (hovered) 6.dp else 4.dp, tween(120))
    val activeColor by animateColorAsState(if (hovered) cs.primary else Color.White, tween(120))
    val thumbScale by animateFloatAsState(if (hovered) 1f else 0f, tween(120))

    Box(
        modifier = modifier
            .height(20.dp)
            .hoverable(interaction)
            .onSizeChanged { widthPx = it.width.coerceAtLeast(1).toFloat() }
            .pointerInput(Unit) { detectTapGestures { offset -> onSeekFraction((offset.x / widthPx).coerceIn(0f, 1f)) } }
            .pointerInput(Unit) { detectHorizontalDragGestures { change, _ -> change.consume(); onSeekFraction((change.position.x / widthPx).coerceIn(0f, 1f)) } },
        contentAlignment = Alignment.CenterStart,
    ) {
        Box(modifier = Modifier.fillMaxWidth().height(trackHeight).clip(CircleShape).background(Color.White.copy(alpha = 0.20f)))
        Box(modifier = Modifier.fillMaxWidth(fraction.coerceIn(0f, 1f)).height(trackHeight).clip(CircleShape).background(activeColor))
        if (thumbScale > 0.05f) {
            Box(modifier = Modifier.fillMaxWidth(fraction.coerceIn(0f, 1f))) {
                Box(modifier = Modifier.align(Alignment.CenterEnd).offset(x = 6.dp).size(12.dp).scale(thumbScale).clip(CircleShape).background(Color.White))
            }
        }
    }
}

@Composable
fun GlassMediaCard(
    item: YTItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    onPlayClick: (() -> Unit)? = null,
) {
    val cs = MaterialTheme.colorScheme
    val interaction = remember { MutableInteractionSource() }
    val hovered by interaction.collectIsHoveredAsState()

    val playBtnAlpha by animateFloatAsState(if (hovered) 1f else 0f, tween(180))
    val playBtnOffsetY by animateDpAsState(if (hovered) 0.dp else 10.dp, spring(dampingRatio = 0.72f, stiffness = 380f))
    val cardScale by animateFloatAsState(if (hovered) 1.03f else 1.0f, tween(160))

    val subtitle = when (item) {
        is SongItem -> item.artists.joinToString(", ") { it.name }
        is AlbumItem -> item.artists?.joinToString(", ") { it.name } ?: "Album"
        is PlaylistItem -> item.author?.name ?: "Playlist"
        is ArtistItem -> "Artist"
        else -> ""
    }
    val artShape = if (item is ArtistItem) CircleShape else RoundedCornerShape(16.dp)

    Column(
        modifier = modifier
            .width(178.dp)
            .scale(cardScale)
            .glassSurface(GlassCardShape, elevated = hovered)
            .hoverable(interaction)
            .clickable(onClick = onClick)
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Box(modifier = Modifier.fillMaxWidth().aspectRatio(1f)) {
            AsyncImage(
                model = item.thumbnail,
                contentDescription = item.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize().clip(artShape),
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
                    .offset(y = playBtnOffsetY)
                    .alpha(playBtnAlpha)
                    .size(44.dp)
                    .shadow(10.dp, CircleShape)
                    .clip(CircleShape)
                    .background(cs.primary)
                    .clickable { onPlayClick?.invoke() ?: onClick() },
                contentAlignment = Alignment.Center,
            ) {
                Icon(Icons.Rounded.PlayArrow, contentDescription = "Play", tint = cs.onPrimary, modifier = Modifier.size(26.dp))
            }
        }
        Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
            Text(item.title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
            Text(subtitle, color = cs.onSurfaceVariant, fontSize = 12.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
        }
    }
}

@Composable
fun ChipsRow(
    chips: List<Pair<String, String>>, // key to label
    selectedKey: String?,
    onSelectKey: (String?) -> Unit,
    modifier: Modifier = Modifier,
) {
    val cs = MaterialTheme.colorScheme
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 6.dp),
    ) {
        item {
            val active = selectedKey == null
            val bg by animateColorAsState(if (active) cs.primary else Color.White.copy(0.08f), tween(140))
            val fg by animateColorAsState(if (active) cs.onPrimary else Color.White, tween(140))
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(bg)
                    .border(1.dp, if (active) cs.primary else Color.White.copy(0.16f), CircleShape)
                    .clickable { onSelectKey(null) }
                    .padding(horizontal = 16.dp, vertical = 7.dp),
            ) {
                Text("All", color = fg, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
            }
        }
        items(chips) { (key, label) ->
            val active = selectedKey == key
            val bg by animateColorAsState(if (active) cs.primary else Color.White.copy(0.08f), tween(140))
            val fg by animateColorAsState(if (active) cs.onPrimary else Color.White, tween(140))
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(bg)
                    .border(1.dp, if (active) cs.primary else Color.White.copy(0.16f), CircleShape)
                    .clickable { onSelectKey(if (active) null else key) }
                    .padding(horizontal = 16.dp, vertical = 7.dp),
            ) {
                Text(label, color = fg, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
            }
        }
    }
}

@Composable
fun AddToPlaylistDialog(
    track: DesktopTrack,
    playlists: List<LocalPlaylist>,
    onDismiss: () -> Unit,
    onAddToPlaylist: (playlistId: String) -> Unit,
    onCreatePlaylistAndAdd: (name: String) -> Unit,
) {
    val cs = MaterialTheme.colorScheme
    var newPlaylistName by remember { mutableStateOf("") }
    var isCreatingNew by remember { mutableStateOf(false) }

    Dialog(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .width(420.dp)
                .glassSurface(GlassCardShape, elevated = true)
                .background(cs.surfaceVariant)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text("Tambah ke Playlist", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
                IconButton(onClick = onDismiss, modifier = Modifier.size(32.dp)) {
                    Icon(Icons.Rounded.Close, contentDescription = "Close", tint = cs.onSurfaceVariant)
                }
            }

            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                AsyncImage(model = track.thumbnail, contentDescription = null, modifier = Modifier.size(44.dp).clip(RoundedCornerShape(8.dp)), contentScale = ContentScale.Crop)
                Column(modifier = Modifier.weight(1f)) {
                    Text(track.title, fontWeight = FontWeight.Bold, color = Color.White, fontSize = 13.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                    Text(track.artist, color = cs.onSurfaceVariant, fontSize = 12.sp, maxLines = 1)
                }
            }

            HorizontalDivider(color = Color.White.copy(0.08f))

            if (!isCreatingNew) {
                Button(
                    onClick = { isCreatingNew = true },
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = cs.primaryContainer, contentColor = cs.onPrimaryContainer),
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Icon(Icons.Rounded.Add, contentDescription = null, modifier = Modifier.size(18.dp))
                    Spacer(Modifier.width(6.dp))
                    Text("Buat Playlist Baru", fontWeight = FontWeight.Bold)
                }

                if (playlists.isEmpty()) {
                    Text("Belum ada playlist lokal.", color = cs.onSurfaceVariant, fontSize = 13.sp, modifier = Modifier.padding(vertical = 12.dp))
                } else {
                    LazyColumn(modifier = Modifier.heightIn(max = 240.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        items(playlists) { pl ->
                            val containsSong = pl.tracks.any { it.id == track.id }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color.White.copy(0.05f))
                                    .clickable {
                                        onAddToPlaylist(pl.id)
                                        onDismiss()
                                    }
                                    .padding(horizontal = 12.dp, vertical = 10.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(pl.name, color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                                    Text("${pl.tracks.size} lagu", color = cs.onSurfaceVariant, fontSize = 11.sp)
                                }
                                if (containsSong) {
                                    Icon(Icons.Rounded.Check, contentDescription = "Sudah ditambahkan", tint = cs.primary, modifier = Modifier.size(18.dp))
                                }
                            }
                        }
                    }
                }
            } else {
                OutlinedTextField(
                    value = newPlaylistName,
                    onValueChange = { newPlaylistName = it },
                    label = { Text("Nama Playlist Baru") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                )
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    TextButton(onClick = { isCreatingNew = false }) { Text("Batal") }
                    Spacer(Modifier.width(8.dp))
                    Button(
                        onClick = {
                            if (newPlaylistName.isNotBlank()) {
                                onCreatePlaylistAndAdd(newPlaylistName.trim())
                                onDismiss()
                            }
                        },
                        enabled = newPlaylistName.isNotBlank(),
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(containerColor = cs.primary, contentColor = cs.onPrimary),
                    ) {
                        Text("Simpan & Tambah")
                    }
                }
            }
        }
    }
}
