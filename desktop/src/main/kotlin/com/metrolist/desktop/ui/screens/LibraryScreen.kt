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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil3.compose.AsyncImage
import com.metrolist.desktop.models.DesktopTrack
import com.metrolist.desktop.models.LocalPlaylist
import com.metrolist.desktop.playback.DesktopPlaybackEngine
import com.metrolist.desktop.ui.components.GlassMediaCard
import com.metrolist.desktop.ui.components.glassSurface
import com.metrolist.desktop.ui.theme.GlassCardShape
import com.metrolist.innertube.models.YTItem
import com.metrolist.innertube.pages.LibraryPage

enum class LibrarySubTab(val title: String) {
    PLAYLISTS("Playlists"),
    FAVORITES("Liked Songs"),
    DOWNLOADS("Downloaded"),
    HISTORY("History"),
    ACCOUNT("Account Sync"),
}

@Composable
fun LibraryScreen(
    engine: DesktopPlaybackEngine,
    libraryPage: LibraryPage?,
    isLoadingAccount: Boolean,
    onSaveCookie: (String) -> Unit,
    onItemClick: (YTItem, List<YTItem>) -> Unit,
    onOpenAddToPlaylist: (DesktopTrack) -> Unit,
) {
    val cs = MaterialTheme.colorScheme
    val state by engine.state.collectAsState()
    var activeTab by remember { mutableStateOf(LibrarySubTab.PLAYLISTS) }

    var showCreateDialog by remember { mutableStateOf(false) }
    var createName by remember { mutableStateOf("") }
    var createDesc by remember { mutableStateOf("") }

    var selectedLocalPlaylist by remember { mutableStateOf<LocalPlaylist?>(null) }
    var showRenameDialog by remember { mutableStateOf(false) }
    var renameName by remember { mutableStateOf("") }

    // Keep selected local playlist synced with state updates
    val activePlaylist = state.localPlaylists.firstOrNull { it.id == selectedLocalPlaylist?.id }

    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 26.dp, vertical = 22.dp)) {
        // Header & Tab Selector
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text("Library", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Text("Playlists, Liked Songs & Offline Music", fontSize = 12.sp, color = cs.primary, fontWeight = FontWeight.Medium)
            }

            // Subtab Pills
            Row(
                modifier = Modifier.glassSurface(CircleShape).padding(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                LibrarySubTab.entries.forEach { tab ->
                    val active = activeTab == tab && activePlaylist == null
                    val bg by animateColorAsState(if (active) cs.primary else Color.Transparent, tween(150))
                    val fg by animateColorAsState(if (active) cs.onPrimary else cs.onSurfaceVariant, tween(150))
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(bg)
                            .clickable {
                                activeTab = tab
                                selectedLocalPlaylist = null
                            }
                            .padding(horizontal = 14.dp, vertical = 7.dp),
                    ) {
                        Text(tab.title, color = fg, fontSize = 13.sp, fontWeight = if (active) FontWeight.Bold else FontWeight.Medium)
                    }
                }
            }
        }

        Spacer(Modifier.height(18.dp))

        // If local playlist detail is open
        if (activePlaylist != null) {
            Column(modifier = Modifier.fillMaxSize()) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.clickable { selectedLocalPlaylist = null },
                    ) {
                        IconButton(onClick = { selectedLocalPlaylist = null }, modifier = Modifier.glassSurface(CircleShape).size(36.dp)) {
                            Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back", tint = Color.White, modifier = Modifier.size(20.dp))
                        }
                        Text("Semua Playlist", color = cs.onSurfaceVariant, fontSize = 14.sp)
                    }

                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedButton(
                            onClick = {
                                renameName = activePlaylist.name
                                showRenameDialog = true
                            },
                            shape = CircleShape,
                        ) {
                            Icon(Icons.Rounded.Edit, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(Modifier.width(6.dp))
                            Text("Rename")
                        }
                        Button(
                            onClick = {
                                engine.deletePlaylist(activePlaylist.id)
                                selectedLocalPlaylist = null
                            },
                            shape = CircleShape,
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEF4444), contentColor = Color.White),
                        ) {
                            Icon(Icons.Rounded.Delete, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(Modifier.width(6.dp))
                            Text("Hapus")
                        }
                    }
                }

                Spacer(Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth().glassSurface(GlassCardShape, elevated = true).padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .clip(RoundedCornerShape(18.dp))
                            .background(cs.primaryContainer.copy(0.6f)),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(Icons.AutoMirrored.Rounded.QueueMusic, contentDescription = null, tint = cs.onPrimaryContainer, modifier = Modifier.size(54.dp))
                    }
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.weight(1f)) {
                        Text("PLAYLIST LOKAL", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = cs.primary)
                        Text(activePlaylist.name, fontSize = 26.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        Text("${activePlaylist.tracks.size} lagu", fontSize = 13.sp, color = cs.onSurfaceVariant)
                        if (activePlaylist.tracks.isNotEmpty()) {
                            Row(horizontalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(top = 4.dp)) {
                                Button(
                                    onClick = { engine.playTrack(activePlaylist.tracks.first(), activePlaylist.tracks) },
                                    shape = CircleShape,
                                    colors = ButtonDefaults.buttonColors(containerColor = cs.primary, contentColor = cs.onPrimary),
                                ) {
                                    Icon(Icons.Rounded.PlayArrow, contentDescription = null, modifier = Modifier.size(18.dp))
                                    Spacer(Modifier.width(6.dp))
                                    Text("Play All", fontWeight = FontWeight.Bold)
                                }
                                OutlinedButton(
                                    onClick = {
                                        val sh = activePlaylist.tracks.shuffled()
                                        engine.playTrack(sh.first(), sh)
                                    },
                                    shape = CircleShape,
                                ) {
                                    Icon(Icons.Rounded.Shuffle, contentDescription = null, modifier = Modifier.size(16.dp))
                                    Spacer(Modifier.width(6.dp))
                                    Text("Shuffle")
                                }
                            }
                        }
                    }
                }

                Spacer(Modifier.height(18.dp))

                if (activePlaylist.tracks.isEmpty()) {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("Playlist ini masih kosong. Tambahkan lagu dari pencarian atau beranda!", color = cs.onSurfaceVariant)
                    }
                } else {
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(6.dp), contentPadding = PaddingValues(bottom = 28.dp)) {
                        itemsIndexed(activePlaylist.tracks) { idx, track ->
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
                                    .clickable { engine.playTrack(track, activePlaylist.tracks) }
                                    .padding(horizontal = 14.dp, vertical = 9.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(14.dp),
                            ) {
                                Text("${idx + 1}", color = cs.onSurfaceVariant, fontSize = 13.sp, fontWeight = FontWeight.Bold, modifier = Modifier.width(26.dp))
                                AsyncImage(model = track.thumbnail, contentDescription = track.title, contentScale = ContentScale.Crop, modifier = Modifier.size(42.dp).clip(RoundedCornerShape(8.dp)))
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
                                IconButton(onClick = { engine.removeTrackFromPlaylist(activePlaylist.id, track.id) }, modifier = Modifier.size(32.dp)) {
                                    Icon(Icons.Rounded.DeleteOutline, contentDescription = "Hapus dari playlist", tint = cs.onSurfaceVariant, modifier = Modifier.size(18.dp))
                                }
                            }
                        }
                    }
                }
            }
        } else {
            when (activeTab) {
                LibrarySubTab.PLAYLISTS -> {
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text("Playlist Lokal (${state.localPlaylists.size})", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            Button(
                                onClick = {
                                    createName = ""
                                    createDesc = ""
                                    showCreateDialog = true
                                },
                                shape = CircleShape,
                                colors = ButtonDefaults.buttonColors(containerColor = cs.primary, contentColor = cs.onPrimary),
                            ) {
                                Icon(Icons.Rounded.Add, contentDescription = null, modifier = Modifier.size(18.dp))
                                Spacer(Modifier.width(6.dp))
                                Text("Buat Playlist", fontWeight = FontWeight.Bold)
                            }
                        }

                        if (state.localPlaylists.isEmpty()) {
                            Box(Modifier.fillMaxWidth().height(220.dp), contentAlignment = Alignment.Center) {
                                Text("Belum ada playlist lokal. Klik 'Buat Playlist' di atas!", color = cs.onSurfaceVariant)
                            }
                        } else {
                            LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                                items(state.localPlaylists) { pl ->
                                    val interaction = remember { MutableInteractionSource() }
                                    val isHov by interaction.collectIsHoveredAsState()
                                    val cardScale by androidx.compose.animation.core.animateFloatAsState(if (isHov) 1.03f else 1.0f)

                                    Column(
                                        modifier = Modifier
                                            .width(180.dp)
                                            .scale(cardScale)
                                            .glassSurface(GlassCardShape, elevated = isHov)
                                            .hoverable(interaction)
                                            .clickable { selectedLocalPlaylist = pl }
                                            .padding(14.dp),
                                        verticalArrangement = Arrangement.spacedBy(10.dp),
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .aspectRatio(1f)
                                                .clip(RoundedCornerShape(16.dp))
                                                .background(cs.primaryContainer.copy(0.45f)),
                                            contentAlignment = Alignment.Center,
                                        ) {
                                            Icon(Icons.AutoMirrored.Rounded.QueueMusic, contentDescription = null, tint = cs.onPrimaryContainer, modifier = Modifier.size(48.dp))
                                        }
                                        Column {
                                            Text(pl.name, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                                            Text("${pl.tracks.size} lagu", color = cs.onSurfaceVariant, fontSize = 12.sp)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                LibrarySubTab.FAVORITES -> {
                    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text("Liked Songs (${state.favorites.size})", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            if (state.favorites.isNotEmpty()) {
                                Button(
                                    onClick = { engine.playTrack(state.favorites.first(), state.favorites) },
                                    shape = CircleShape,
                                    colors = ButtonDefaults.buttonColors(containerColor = cs.primary, contentColor = cs.onPrimary),
                                ) {
                                    Icon(Icons.Rounded.PlayArrow, contentDescription = null, modifier = Modifier.size(18.dp))
                                    Spacer(Modifier.width(6.dp))
                                    Text("Play All", fontWeight = FontWeight.Bold)
                                }
                            }
                        }

                        if (state.favorites.isEmpty()) {
                            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                Text("Belum ada lagu yang disukai.", color = cs.onSurfaceVariant)
                            }
                        } else {
                            LazyColumn(verticalArrangement = Arrangement.spacedBy(6.dp), contentPadding = PaddingValues(bottom = 28.dp)) {
                                itemsIndexed(state.favorites) { idx, track ->
                                    TrackRowItem(
                                        index = idx + 1,
                                        track = track,
                                        isCurrent = state.currentTrack?.id == track.id,
                                        isFavorite = true,
                                        isDownloaded = state.isDownloaded(track.id),
                                        onPlay = { engine.playTrack(track, state.favorites) },
                                        onToggleLike = { engine.toggleFavorite(track) },
                                        onAddToPlaylist = { onOpenAddToPlaylist(track) },
                                        onDownload = { engine.downloadTrack(track) },
                                    )
                                }
                            }
                        }
                    }
                }

                LibrarySubTab.DOWNLOADS -> {
                    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Column {
                                Text("Downloaded (${state.downloads.size})", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                Text("Putar offline secara instan tanpa buffering", fontSize = 12.sp, color = cs.primary)
                            }
                            if (state.downloads.isNotEmpty()) {
                                Button(
                                    onClick = { engine.playTrack(state.downloads.first(), state.downloads) },
                                    shape = CircleShape,
                                    colors = ButtonDefaults.buttonColors(containerColor = cs.primary, contentColor = cs.onPrimary),
                                ) {
                                    Icon(Icons.Rounded.PlayArrow, contentDescription = null, modifier = Modifier.size(18.dp))
                                    Spacer(Modifier.width(6.dp))
                                    Text("Play All", fontWeight = FontWeight.Bold)
                                }
                            }
                        }

                        if (state.downloads.isEmpty()) {
                            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                Text("Belum ada lagu yang didownload.", color = cs.onSurfaceVariant)
                            }
                        } else {
                            LazyColumn(verticalArrangement = Arrangement.spacedBy(6.dp), contentPadding = PaddingValues(bottom = 28.dp)) {
                                itemsIndexed(state.downloads) { idx, track ->
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
                                            .clickable { engine.playTrack(track, state.downloads) }
                                            .padding(horizontal = 14.dp, vertical = 9.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(14.dp),
                                    ) {
                                        Text("${idx + 1}", color = cs.onSurfaceVariant, fontSize = 13.sp, fontWeight = FontWeight.Bold, modifier = Modifier.width(26.dp))
                                        AsyncImage(model = track.thumbnail, contentDescription = track.title, contentScale = ContentScale.Crop, modifier = Modifier.size(42.dp).clip(RoundedCornerShape(8.dp)))
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(track.title, color = if (isCur) cs.primary else Color.White, fontWeight = FontWeight.Medium, fontSize = 14.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                                            Text(track.artist, color = cs.onSurfaceVariant, fontSize = 12.sp, maxLines = 1)
                                        }
                                        Icon(Icons.Rounded.OfflinePin, contentDescription = "Offline ready", tint = cs.primary, modifier = Modifier.size(20.dp))
                                        IconButton(onClick = { engine.deleteDownload(track.id) }, modifier = Modifier.size(32.dp)) {
                                            Icon(Icons.Rounded.DeleteOutline, contentDescription = "Hapus download", tint = cs.onSurfaceVariant, modifier = Modifier.size(18.dp))
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                LibrarySubTab.HISTORY -> {
                    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                        Text("Recently Played (${state.history.size})", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        if (state.history.isEmpty()) {
                            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                Text("Belum ada riwayat pemutaran.", color = cs.onSurfaceVariant)
                            }
                        } else {
                            LazyColumn(verticalArrangement = Arrangement.spacedBy(6.dp), contentPadding = PaddingValues(bottom = 28.dp)) {
                                itemsIndexed(state.history) { idx, track ->
                                    TrackRowItem(
                                        index = idx + 1,
                                        track = track,
                                        isCurrent = state.currentTrack?.id == track.id,
                                        isFavorite = state.isFavorite(track.id),
                                        isDownloaded = state.isDownloaded(track.id),
                                        onPlay = { engine.playTrack(track, state.history) },
                                        onToggleLike = { engine.toggleFavorite(track) },
                                        onAddToPlaylist = { onOpenAddToPlaylist(track) },
                                        onDownload = { engine.downloadTrack(track) },
                                    )
                                }
                            }
                        }
                    }
                }

                LibrarySubTab.ACCOUNT -> {
                    var cookieInput by remember { mutableStateOf(engine.getSavedCookie()) }
                    var savedToast by remember { mutableStateOf(false) }

                    Column(verticalArrangement = Arrangement.spacedBy(18.dp)) {
                        Column(
                            modifier = Modifier.fillMaxWidth().glassSurface(GlassCardShape).padding(20.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                        ) {
                            Text("YouTube Music Account (Cookie Sync)", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            Text("Masukkan cookie browser YouTube Music Anda untuk sinkronisasi playlist & like otomatis.", fontSize = 12.sp, color = cs.onSurfaceVariant)
                            OutlinedTextField(
                                value = cookieInput,
                                onValueChange = {
                                    cookieInput = it
                                    savedToast = false
                                },
                                placeholder = { Text("VISITOR_INFO1_LIVE=...; SAPISID=...;") },
                                modifier = Modifier.fillMaxWidth().height(92.dp),
                                shape = RoundedCornerShape(14.dp),
                            )
                            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Button(
                                    onClick = {
                                        onSaveCookie(cookieInput)
                                        savedToast = true
                                    },
                                    shape = CircleShape,
                                    colors = ButtonDefaults.buttonColors(containerColor = cs.primary, contentColor = cs.onPrimary),
                                ) {
                                    Text("Simpan & Sinkronkan", fontWeight = FontWeight.Bold)
                                }
                                OutlinedButton(
                                    onClick = {
                                        cookieInput = ""
                                        onSaveCookie("")
                                        savedToast = true
                                    },
                                    shape = CircleShape,
                                ) {
                                    Text("Logout / Clear")
                                }
                            }
                            if (savedToast) {
                                Text("Cookie berhasil disimpan!", color = cs.primary, fontSize = 13.sp)
                            }
                        }

                        if (isLoadingAccount) {
                            Box(Modifier.fillMaxWidth().padding(24.dp), contentAlignment = Alignment.Center) {
                                CircularProgressIndicator(color = cs.primary)
                            }
                        } else if (libraryPage != null && libraryPage.items.isNotEmpty()) {
                            Text("Playlist YouTube Music", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                                items(libraryPage.items) { item ->
                                    GlassMediaCard(item = item, onClick = { onItemClick(item, libraryPage.items) })
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // Create Playlist Modal Dialog
    if (showCreateDialog) {
        Dialog(onDismissRequest = { showCreateDialog = false }) {
            Column(
                modifier = Modifier
                    .width(400.dp)
                    .glassSurface(GlassCardShape, elevated = true)
                    .background(cs.surfaceVariant)
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp),
            ) {
                Text("Buat Playlist Baru", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
                OutlinedTextField(
                    value = createName,
                    onValueChange = { createName = it },
                    label = { Text("Nama Playlist") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                )
                OutlinedTextField(
                    value = createDesc,
                    onValueChange = { createDesc = it },
                    label = { Text("Deskripsi (Opsional)") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                )
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    TextButton(onClick = { showCreateDialog = false }) { Text("Batal") }
                    Spacer(Modifier.width(8.dp))
                    Button(
                        onClick = {
                            if (createName.isNotBlank()) {
                                val pl = engine.createPlaylist(createName, createDesc)
                                showCreateDialog = false
                                selectedLocalPlaylist = pl
                            }
                        },
                        enabled = createName.isNotBlank(),
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(containerColor = cs.primary, contentColor = cs.onPrimary),
                    ) {
                        Text("Simpan")
                    }
                }
            }
        }
    }

    // Rename Playlist Dialog
    if (showRenameDialog && activePlaylist != null) {
        Dialog(onDismissRequest = { showRenameDialog = false }) {
            Column(
                modifier = Modifier
                    .width(400.dp)
                    .glassSurface(GlassCardShape, elevated = true)
                    .background(cs.surfaceVariant)
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp),
            ) {
                Text("Rename Playlist", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
                OutlinedTextField(
                    value = renameName,
                    onValueChange = { renameName = it },
                    label = { Text("Nama Baru") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                )
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    TextButton(onClick = { showRenameDialog = false }) { Text("Batal") }
                    Spacer(Modifier.width(8.dp))
                    Button(
                        onClick = {
                            if (renameName.isNotBlank()) {
                                engine.renamePlaylist(activePlaylist.id, renameName)
                                showRenameDialog = false
                            }
                        },
                        enabled = renameName.isNotBlank(),
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(containerColor = cs.primary, contentColor = cs.onPrimary),
                    ) {
                        Text("Rename")
                    }
                }
            }
        }
    }
}

@Composable
private fun TrackRowItem(
    index: Int,
    track: DesktopTrack,
    isCurrent: Boolean,
    isFavorite: Boolean,
    isDownloaded: Boolean,
    onPlay: () -> Unit,
    onToggleLike: () -> Unit,
    onAddToPlaylist: () -> Unit,
    onDownload: () -> Unit,
) {
    val cs = MaterialTheme.colorScheme
    val interaction = remember { MutableInteractionSource() }
    val hovered by interaction.collectIsHoveredAsState()
    val bg by animateColorAsState(
        if (isCurrent) cs.primaryContainer.copy(0.40f) else if (hovered) Color.White.copy(0.11f) else Color.White.copy(0.04f),
        tween(120),
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(bg)
            .border(0.5.dp, if (isCurrent) cs.primary.copy(0.5f) else Color.White.copy(0.08f), RoundedCornerShape(14.dp))
            .hoverable(interaction)
            .clickable(onClick = onPlay)
            .padding(horizontal = 14.dp, vertical = 9.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(14.dp),
    ) {
        Text("$index", color = cs.onSurfaceVariant, fontSize = 13.sp, fontWeight = FontWeight.Bold, modifier = Modifier.width(26.dp))
        AsyncImage(model = track.thumbnail, contentDescription = track.title, contentScale = ContentScale.Crop, modifier = Modifier.size(42.dp).clip(RoundedCornerShape(8.dp)))
        Column(modifier = Modifier.weight(1f)) {
            Text(track.title, color = if (isCurrent) cs.primary else Color.White, fontWeight = FontWeight.Medium, fontSize = 14.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
            Text(track.artist, color = cs.onSurfaceVariant, fontSize = 12.sp, maxLines = 1)
        }
        IconButton(onClick = onToggleLike, modifier = Modifier.size(32.dp)) {
            Icon(
                if (isFavorite) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                contentDescription = "Like",
                tint = if (isFavorite) cs.primary else cs.onSurfaceVariant,
                modifier = Modifier.size(18.dp),
            )
        }
        IconButton(onClick = onAddToPlaylist, modifier = Modifier.size(32.dp)) {
            Icon(Icons.AutoMirrored.Rounded.PlaylistAdd, contentDescription = "Add to playlist", tint = cs.onSurfaceVariant, modifier = Modifier.size(18.dp))
        }
        IconButton(onClick = onDownload, modifier = Modifier.size(32.dp)) {
            Icon(
                if (isDownloaded) Icons.Rounded.DownloadDone else Icons.Rounded.Download,
                contentDescription = "Download",
                tint = if (isDownloaded) cs.primary else cs.onSurfaceVariant,
                modifier = Modifier.size(18.dp),
            )
        }
    }
}
