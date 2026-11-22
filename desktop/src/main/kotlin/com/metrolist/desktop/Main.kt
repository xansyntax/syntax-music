package com.metrolist.desktop

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import coil3.compose.AsyncImage
import com.metrolist.desktop.models.*
import com.metrolist.desktop.playback.DesktopPlaybackEngine
import com.metrolist.desktop.ui.components.*
import com.metrolist.desktop.ui.player.FullGlassPlayerOverlay
import com.metrolist.desktop.ui.player.GlassBottomPlayer
import com.metrolist.desktop.ui.screens.*
import com.metrolist.desktop.ui.theme.*
import com.metrolist.innertube.YouTube
import com.metrolist.innertube.models.*
import com.metrolist.innertube.pages.ExplorePage
import com.metrolist.innertube.pages.HomePage
import com.metrolist.innertube.pages.LibraryPage
import com.metrolist.innertube.pages.MoodAndGenres
import kotlinx.coroutines.launch

fun main() {
    System.setProperty("skiko.renderApi", "OPENGL")
    System.setProperty("skiko.fps", "165")
    System.setProperty("skiko.vsync.enabled", "true")

    application {
        val engine = remember { DesktopPlaybackEngine() }
        DisposableEffect(Unit) { onDispose { engine.release() } }

        Window(
            onCloseRequest = ::exitApplication,
            title = "Syntax Music",
            icon = painterResource("icon.png"),
            state = rememberWindowState(width = 1360.dp, height = 860.dp),
            onPreviewKeyEvent = { event ->
                if (event.type == KeyEventType.KeyDown) {
                    when {
                        event.isCtrlPressed && event.key == Key.Spacebar -> {
                            engine.togglePlayPause()
                            true
                        }
                        event.key == Key.MediaPlayPause || event.key == Key.MediaPlay || event.key == Key.MediaPause -> {
                            engine.togglePlayPause()
                            true
                        }
                        event.key == Key.MediaNext -> {
                            engine.playNext()
                            true
                        }
                        event.key == Key.MediaPrevious -> {
                            engine.playPrevious()
                            true
                        }
                        event.key == Key.MediaStop -> {
                            engine.togglePlayPause()
                            true
                        }
                        event.isCtrlPressed && event.key == Key.DirectionRight -> {
                            engine.seekBy(5000L)
                            true
                        }
                        event.isCtrlPressed && event.key == Key.DirectionLeft -> {
                            engine.seekBy(-5000L)
                            true
                        }
                        event.isCtrlPressed && event.key == Key.DirectionUp -> {
                            engine.setVolume(engine.state.value.volume + 5)
                            true
                        }
                        event.isCtrlPressed && event.key == Key.DirectionDown -> {
                            engine.setVolume(engine.state.value.volume - 5)
                            true
                        }
                        else -> false
                    }
                } else false
            },
        ) {
            val uiState by engine.state.collectAsState()
            val animPrimary by animateColorAsState(Color(uiState.palette.primaryArgb), tween(750))
            val animContainer by animateColorAsState(Color(uiState.palette.containerArgb), tween(750))
            val animSecondary by animateColorAsState(Color(uiState.palette.secondaryArgb), tween(750))
            val animTertiary by animateColorAsState(Color(uiState.palette.tertiaryArgb), tween(750))

            val adaptiveScheme = GlassDark.copy(
                primary = animPrimary,
                primaryContainer = animContainer,
                secondary = animSecondary,
                tertiary = animTertiary,
            )

            MaterialTheme(colorScheme = adaptiveScheme, typography = GlassTypography) {
                SyntaxGlassDesktopApp(engine)
            }
        }
    }
}

@Composable
fun SyntaxGlassDesktopApp(engine: DesktopPlaybackEngine) {
    var selectedTab by remember { mutableStateOf(DesktopTab.HOME) }
    var showFullPlayer by remember { mutableStateOf(false) }
    var fullPlayerInitialTab by remember { mutableStateOf(0) }
    val scope = rememberCoroutineScope()

    var homePage by remember { mutableStateOf<HomePage?>(null) }
    var homeLoading by remember { mutableStateOf(true) }
    var homeError by remember { mutableStateOf<String?>(null) }
    var selectedHomeChipKey by remember { mutableStateOf<String?>(null) }

    var libraryPage by remember { mutableStateOf<LibraryPage?>(null) }
    var libraryLoading by remember { mutableStateOf(false) }

    var activeCollection by remember { mutableStateOf<CollectionDetail?>(null) }
    var activeArtist by remember { mutableStateOf<ArtistDetail?>(null) }
    var detailLoading by remember { mutableStateOf(false) }

    var searchQuery by remember { mutableStateOf("") }
    var searchFilter by remember { mutableStateOf(SearchFilterTab.SONGS) }
    var searchResults by remember { mutableStateOf<List<YTItem>>(emptyList()) }
    var searchContinuation by remember { mutableStateOf<String?>(null) }
    var searchLoading by remember { mutableStateOf(false) }
    var searchLoadingMore by remember { mutableStateOf(false) }

    var trackForPlaylist by remember { mutableStateOf<DesktopTrack?>(null) }

    fun loadHome(chipContinuation: String? = selectedHomeChipKey) {
        scope.launch {
            homeLoading = true
            YouTube.home(continuation = chipContinuation)
                .onSuccess {
                    homePage = it
                    homeError = null
                }
                .onFailure {
                    homeError = it.message ?: "Gagal memuat beranda YouTube Music"
                }
            homeLoading = false
        }
    }

    fun loadLibrary() {
        scope.launch {
            libraryLoading = true
            YouTube.library("FEmusic_liked_playlists").onSuccess { libraryPage = it }
            libraryLoading = false
        }
    }

    fun runSearch(q: String = searchQuery, filter: SearchFilterTab = searchFilter) {
        if (q.isBlank()) return
        scope.launch {
            searchLoading = true
            searchContinuation = null
            YouTube.search(q, filter.filter).onSuccess {
                searchResults = it.items
                searchContinuation = it.continuation
            }
            searchLoading = false
        }
    }

    fun loadMoreSearch() {
        val token = searchContinuation ?: return
        if (searchLoadingMore || searchLoading) return
        scope.launch {
            searchLoadingMore = true
            YouTube.searchContinuation(token).onSuccess { res ->
                val existingIds = searchResults.mapTo(HashSet()) { it.id }
                searchResults = searchResults + res.items.filter { it.id !in existingIds }
                searchContinuation = res.continuation
            }
            searchLoadingMore = false
        }
    }

    fun openArtistById(browseId: String) {
        scope.launch {
            detailLoading = true
            YouTube.artist(browseId).onSuccess { page ->
                val topTracks = page.sections.firstOrNull { it.title.contains("Song", ignoreCase = true) }
                    ?.items?.filterIsInstance<SongItem>()?.map { it.toDesktopTrack() } ?: emptyList()

                val albumsList = page.sections.firstOrNull { it.title.contains("Album", ignoreCase = true) }
                    ?.items?.filterIsInstance<AlbumItem>()?.map {
                        CollectionDetail(
                            id = it.browseId,
                            title = it.title,
                            subtitle = it.artists?.joinToString(", ") { a -> a.name }.orEmpty(),
                            thumbnail = it.thumbnail,
                            tracks = emptyList(),
                            isAlbum = true,
                            yearOrCount = it.year?.toString().orEmpty(),
                        )
                    } ?: emptyList()

                val singlesList = page.sections.firstOrNull {
                    it.title.contains("Single", ignoreCase = true) || it.title.contains("EP", ignoreCase = true)
                }?.items?.filterIsInstance<AlbumItem>()?.map {
                    CollectionDetail(
                        id = it.browseId,
                        title = it.title,
                        subtitle = it.artists?.joinToString(", ") { a -> a.name }.orEmpty(),
                        thumbnail = it.thumbnail,
                        tracks = emptyList(),
                        isAlbum = true,
                        yearOrCount = it.year?.toString().orEmpty(),
                    )
                } ?: emptyList()

                val relatedList = page.sections.firstOrNull {
                    it.title.contains("Fans", ignoreCase = true) || it.title.contains("Similar", ignoreCase = true)
                }?.items?.filterIsInstance<ArtistItem>()?.map {
                    DesktopTrack(
                        id = it.id,
                        title = it.title,
                        artist = "Artist",
                        thumbnail = it.thumbnail.orEmpty(),
                    )
                } ?: emptyList()

                activeArtist = ArtistDetail(
                    id = page.artist.id,
                    name = page.artist.title,
                    thumbnail = page.artist.thumbnail,
                    subscriberCount = page.subscriberCountText,
                    monthlyListeners = page.monthlyListenerCount,
                    description = page.description,
                    topSongs = topTracks,
                    albums = albumsList,
                    singles = singlesList,
                    relatedArtists = relatedList,
                )
                activeCollection = null
            }
            detailLoading = false
        }
    }

    fun openItem(item: YTItem, contextItems: List<YTItem>) {
        when (item) {
            is SongItem -> {
                val songs = contextItems.filterIsInstance<SongItem>()
                val queue = if (songs.size > 1) songs.map { it.toDesktopTrack() } else listOf(item.toDesktopTrack())
                engine.playTrack(item.toDesktopTrack(), queue)
            }
            is AlbumItem -> {
                scope.launch {
                    detailLoading = true
                    YouTube.album(item.browseId).onSuccess { page ->
                        activeCollection = CollectionDetail(
                            id = item.browseId,
                            title = item.title,
                            subtitle = item.artists?.joinToString(", ") { it.name }.orEmpty(),
                            thumbnail = item.thumbnail,
                            tracks = page.songs.map { it.toDesktopTrack() },
                            isAlbum = true,
                            yearOrCount = page.album.year?.toString().orEmpty(),
                        )
                        activeArtist = null
                    }
                    detailLoading = false
                }
            }
            is PlaylistItem -> {
                scope.launch {
                    detailLoading = true
                    YouTube.playlist(item.id).onSuccess { page ->
                        activeCollection = CollectionDetail(
                            id = item.id,
                            title = item.title,
                            subtitle = item.author?.name.orEmpty(),
                            thumbnail = item.thumbnail,
                            tracks = page.songs.map { it.toDesktopTrack() },
                            isAlbum = false,
                            yearOrCount = "${page.playlist.songCountText ?: page.songs.size.toString()} tracks",
                        )
                        activeArtist = null
                    }
                    detailLoading = false
                }
            }
            is ArtistItem -> {
                openArtistById(item.id)
            }
            else -> Unit
        }
    }

    fun openCollectionDirect(detail: CollectionDetail) {
        scope.launch {
            detailLoading = true
            YouTube.album(detail.id).onSuccess { page ->
                activeCollection = detail.copy(
                    tracks = page.songs.map { it.toDesktopTrack() },
                    yearOrCount = page.album.year?.toString().orEmpty(),
                )
                activeArtist = null
            }
            detailLoading = false
        }
    }

    LaunchedEffect(Unit) { loadHome() }

    val cs = MaterialTheme.colorScheme
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(cs.background)
            .ambientGlow(cs.primary, cs.secondary, cs.tertiary),
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                // Floating Liquid Glass Sidebar
                GlassSidebar(
                    engine = engine,
                    selectedTab = selectedTab,
                    hasDetail = activeCollection != null || activeArtist != null,
                    onSelectTab = { tab ->
                        selectedTab = tab
                        activeCollection = null
                        activeArtist = null
                        if (tab == DesktopTab.EXPLORE) {
                            // Explore auto loads
                        }
                        if (tab == DesktopTab.LIBRARY) {
                            loadLibrary()
                        }
                    },
                )

                // Main Content View
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .glassSurface(GlassOverlayShape, elevated = false),
                ) {
                    val navKey = when {
                        detailLoading -> "loading"
                        activeArtist != null -> "artist:${activeArtist?.id}"
                        activeCollection != null -> "collection:${activeCollection?.id}"
                        else -> selectedTab.name
                    }

                    AnimatedContent(
                        targetState = navKey,
                        transitionSpec = {
                            (fadeIn(tween(200)) + slideInVertically(tween(200)) { it / 32 }) togetherWith fadeOut(tween(140))
                        },
                        label = "DesktopNav",
                    ) { key ->
                        when {
                            key == "loading" -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                CircularProgressIndicator(color = cs.primary)
                            }
                            activeArtist != null -> ArtistScreen(
                                detail = activeArtist!!,
                                onBack = { activeArtist = null },
                                onPlayTrack = { t, list -> engine.playTrack(t, list) },
                                onOpenCollection = { openCollectionDirect(it) },
                                onOpenArtistById = { openArtistById(it) },
                                engine = engine,
                                onOpenAddToPlaylist = { trackForPlaylist = it },
                            )
                            activeCollection != null -> CollectionScreen(
                                detail = activeCollection!!,
                                onBack = { activeCollection = null },
                                onPlayTrack = { t, list -> engine.playTrack(t, list) },
                                onOpenArtist = { openArtistById(it) },
                                engine = engine,
                                onOpenAddToPlaylist = { trackForPlaylist = it },
                            )
                            selectedTab == DesktopTab.HOME -> HomeScreen(
                                homePage = homePage,
                                isLoading = homeLoading,
                                error = homeError,
                                selectedChipKey = selectedHomeChipKey,
                                onSelectChip = { key ->
                                    selectedHomeChipKey = key
                                    loadHome(key)
                                },
                                onRefresh = { loadHome(selectedHomeChipKey) },
                                onItemClick = { item, list -> openItem(item, list) },
                                engine = engine,
                                onOpenAddToPlaylist = { trackForPlaylist = it },
                            )
                            selectedTab == DesktopTab.EXPLORE -> ExploreScreen(
                                engine = engine,
                                onItemClick = { item, list -> openItem(item, list) },
                                onOpenMoodOrGenre = { moodItem ->
                                    searchQuery = moodItem.title
                                    searchFilter = SearchFilterTab.SONGS
                                    selectedTab = DesktopTab.SEARCH
                                    runSearch(moodItem.title, SearchFilterTab.SONGS)
                                },
                                onOpenAddToPlaylist = { trackForPlaylist = it },
                            )
                            selectedTab == DesktopTab.SEARCH -> SearchScreen(
                                query = searchQuery,
                                selectedFilter = searchFilter,
                                onQueryChange = { searchQuery = it },
                                onFilterChange = {
                                    searchFilter = it
                                    runSearch(searchQuery, it)
                                },
                                onSearch = { q ->
                                    runSearch(q, searchFilter)
                                },
                                results = searchResults,
                                isLoading = searchLoading,
                                isLoadingMore = searchLoadingMore,
                                hasMore = searchContinuation != null,
                                onLoadMore = { loadMoreSearch() },
                                onItemClick = { item, list -> openItem(item, list) },
                                engine = engine,
                                onOpenAddToPlaylist = { trackForPlaylist = it },
                            )
                            selectedTab == DesktopTab.LIBRARY -> LibraryScreen(
                                engine = engine,
                                libraryPage = libraryPage,
                                isLoadingAccount = libraryLoading,
                                onSaveCookie = { cookie ->
                                    engine.saveCookie(cookie)
                                    loadHome()
                                    loadLibrary()
                                },
                                onItemClick = { item, list -> openItem(item, list) },
                                onOpenAddToPlaylist = { trackForPlaylist = it },
                            )
                            selectedTab == DesktopTab.SETTINGS -> SettingsScreen(engine = engine)
                        }
                    }
                }
            }

            // Floating Bottom Player Capsule
            GlassBottomPlayer(
                engine = engine,
                onOpenFullPlayer = { tab ->
                    fullPlayerInitialTab = tab
                    showFullPlayer = true
                },
                onOpenAddToPlaylist = { trackForPlaylist = it },
            )
        }

        // Fullscreen Now Playing Overlay
        AnimatedVisibility(
            visible = showFullPlayer,
            enter = slideInVertically(tween(300, easing = FastOutSlowInEasing)) { it } + fadeIn(tween(220)),
            exit = slideOutVertically(tween(240, easing = FastOutSlowInEasing)) { it } + fadeOut(tween(180)),
        ) {
            FullGlassPlayerOverlay(
                engine = engine,
                initialTab = fullPlayerInitialTab,
                onClose = { showFullPlayer = false },
                onOpenAddToPlaylist = { trackForPlaylist = it },
            )
        }

        // Add To Playlist Modal Dialog
        trackForPlaylist?.let { track ->
            val uiState by engine.state.collectAsState()
            AddToPlaylistDialog(
                track = track,
                playlists = uiState.localPlaylists,
                onDismiss = { trackForPlaylist = null },
                onAddToPlaylist = { plId ->
                    engine.addTrackToPlaylist(plId, track)
                    trackForPlaylist = null
                },
                onCreatePlaylistAndAdd = { name ->
                    val pl = engine.createPlaylist(name)
                    engine.addTrackToPlaylist(pl.id, track)
                    trackForPlaylist = null
                },
            )
        }
    }
}

@Composable
private fun GlassSidebar(
    engine: DesktopPlaybackEngine,
    selectedTab: DesktopTab,
    hasDetail: Boolean,
    onSelectTab: (DesktopTab) -> Unit,
) {
    val state by engine.state.collectAsState()
    val cs = MaterialTheme.colorScheme

    Column(
        modifier = Modifier
            .width(252.dp)
            .fillMaxHeight()
            .glassSurface(GlassOverlayShape, elevated = false)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        // App Logo & Title
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 10.dp),
        ) {
            Image(
                painter = painterResource("icon.png"),
                contentDescription = "Syntax Music Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(42.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(1.dp, GlassRimBrush, RoundedCornerShape(12.dp)),
            )
            Column {
                Text("Syntax Music", fontSize = 17.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Text("by Xan Syntax", fontSize = 11.sp, color = cs.primary, fontWeight = FontWeight.SemiBold)
            }
        }

        Spacer(Modifier.height(6.dp))

        // Navigation Tabs
        DesktopTab.entries.forEach { tab ->
            val active = selectedTab == tab && !hasDetail
            val interaction = remember { MutableInteractionSource() }
            val hovered by interaction.collectIsHoveredAsState()
            val textColor by animateColorAsState(if (active) cs.onPrimaryContainer else if (hovered) Color.White else cs.onSurfaceVariant, tween(150))
            val bgColor by animateColorAsState(
                if (active) cs.primaryContainer.copy(alpha = 0.72f) else if (hovered) Color.White.copy(alpha = 0.08f) else Color.Transparent,
                tween(150),
            )
            val icon = when (tab) {
                DesktopTab.HOME -> Icons.Rounded.Home
                DesktopTab.EXPLORE -> Icons.Rounded.Explore
                DesktopTab.SEARCH -> Icons.Rounded.Search
                DesktopTab.LIBRARY -> Icons.Rounded.LibraryMusic
                DesktopTab.SETTINGS -> Icons.Rounded.Settings
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(bgColor)
                    .border(1.dp, if (active) cs.primary.copy(alpha = 0.45f) else Color.Transparent, RoundedCornerShape(16.dp))
                    .hoverable(interaction)
                    .clickable { onSelectTab(tab) }
                    .padding(horizontal = 14.dp, vertical = 11.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Icon(icon, contentDescription = tab.title, tint = if (active) cs.primary else textColor, modifier = Modifier.size(20.dp))
                Text(tab.title, color = textColor, fontSize = 14.sp, fontWeight = if (active) FontWeight.Bold else FontWeight.Medium)
            }
        }

        Spacer(Modifier.height(12.dp))
        HorizontalDivider(color = Color.White.copy(alpha = 0.08f))
        Spacer(Modifier.height(6.dp))

        // Up Next mini queue header
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text("UP NEXT", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = cs.onSurfaceVariant)
            if (state.queue.isNotEmpty()) {
                Text("${state.queue.size}", fontSize = 11.sp, color = cs.primary, fontWeight = FontWeight.Bold)
            }
        }

        // Mini Queue List
        if (state.queue.isEmpty()) {
            Box(Modifier.weight(1f).fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text("Antrean kosong", color = cs.onSurfaceVariant.copy(0.6f), fontSize = 12.sp)
            }
        } else {
            LazyColumn(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                items(state.queue) { item ->
                    val isCurrent = item.id == state.currentTrack?.id
                    val interaction = remember { MutableInteractionSource() }
                    val hovered by interaction.collectIsHoveredAsState()
                    val rowBg by animateColorAsState(
                        if (isCurrent) Color.White.copy(0.14f) else if (hovered) Color.White.copy(0.07f) else Color.Transparent,
                        tween(120),
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(rowBg)
                            .hoverable(interaction)
                            .clickable { engine.playTrack(item, state.queue) }
                            .padding(horizontal = 8.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                    ) {
                        AsyncImage(
                            model = item.thumbnail,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(34.dp).clip(RoundedCornerShape(8.dp)),
                        )
                        Column(modifier = Modifier.weight(1f)) {
                            Text(item.title, maxLines = 1, overflow = TextOverflow.Ellipsis, fontSize = 12.sp, fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Normal, color = if (isCurrent) cs.primary else Color.White)
                            Text(item.artist, maxLines = 1, overflow = TextOverflow.Ellipsis, fontSize = 11.sp, color = cs.onSurfaceVariant)
                        }
                        if (isCurrent && state.isPlaying) {
                            EqualizerBars(cs.primary)
                        }
                    }
                }
            }
        }
    }
}
