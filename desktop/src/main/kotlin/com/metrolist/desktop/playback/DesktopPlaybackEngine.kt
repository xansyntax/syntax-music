package com.metrolist.desktop.playback

import kotlinx.serialization.json.jsonArray

import com.metrolist.desktop.models.DesktopTrack
import com.metrolist.desktop.models.DynamicPalette
import com.metrolist.desktop.models.LocalPlaylist
import com.metrolist.desktop.models.LyricLine
import com.metrolist.desktop.models.PlaybackProgress
import com.metrolist.desktop.models.PlayerUiState
import com.metrolist.desktop.models.RepeatMode
import com.metrolist.desktop.models.toDesktopTrack
import com.metrolist.innertube.YouTube
import com.metrolist.innertube.models.SongItem
import com.metrolist.innertubex.InnerTubeLogEvent
import com.metrolist.innertubex.InnerTubeLogger
import com.metrolist.innertubex.cipher.PlayerConfigRepository
import com.metrolist.innertubex.cipher.RemotePlayerConfigStore
import com.metrolist.innertubex.cipher.YouTubeCipherService
import com.metrolist.innertubex.extraction.AudioQuality
import com.metrolist.innertubex.extraction.ContentHints
import com.metrolist.innertubex.extraction.InnerTubeExtractor
import com.metrolist.innertubex.extraction.PoTokenResult
import com.metrolist.innertubex.extraction.TokenProvider
import com.metrolist.innertubex.extraction.TokenProviderCapabilities
import com.metrolist.innertubex.extraction.YtConfigParser
import com.metrolist.innertubex.extraction.YtConfigParserImpl
import com.metrolist.innertubex.extraction.generateClientPlaybackNonce
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import uk.co.caprica.vlcj.factory.MediaPlayerFactory
import uk.co.caprica.vlcj.player.base.MediaPlayer
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter
import java.awt.Color as AwtColor
import java.io.File
import java.net.HttpURLConnection
import java.net.URL
import java.util.UUID
import javax.imageio.ImageIO

@Serializable
private data class CachedConfigMeta(
    val cachedAtMs: Long = 0L,
    val cachedSourceUrl: String = "",
    val cachedEtag: String = "",
)

class DesktopPlaybackEngine {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val _state = MutableStateFlow(PlayerUiState())
    val state: StateFlow<PlayerUiState> = _state.asStateFlow()

    // Isolated progress flow so 250ms ticks NEVER recompose sidebar/home/cards
    private val _progress = MutableStateFlow(PlaybackProgress())
    val progress: StateFlow<PlaybackProgress> = _progress.asStateFlow()

    private val configDir = File(System.getProperty("user.home"), ".config/syntax-music").apply { mkdirs() }
    private val downloadsDir = File(configDir, "downloads").apply { mkdirs() }
    private val cookieFile = File(configDir, "cookie.txt")
    private val favoritesFile = File(configDir, "favorites.json")
    private val historyFile = File(configDir, "history.json")
    private val downloadsMetaFile = File(configDir, "downloads.json")
    private val playlistsFile = File(configDir, "playlists.json")
    private val searchHistoryFile = File(configDir, "search_history.json")
    private val playerConfigJsonFile = File(configDir, "player_config.json")
    private val playerConfigMetaFile = File(configDir, "player_config_meta.json")

    private val jsonFormat = Json { ignoreUnknownKeys = true; prettyPrint = false }
    private val lyricsClient = HttpClient(OkHttp)

    private var factory: MediaPlayerFactory? = null
    private var mediaPlayer: MediaPlayer? = null
    private var progressJob: Job? = null
    private var playJob: Job? = null
    private var lyricsJob: Job? = null
    private var radioJob: Job? = null
    private var paletteJob: Job? = null
    private var sleepTimerJob: Job? = null

    private val bundleMutex = Mutex()
    private var cachedExtractor: InnerTubeExtractor? = null
    private var cachedGeneration: Long = -1L

    private val logger = InnerTubeLogger { event: InnerTubeLogEvent ->
        if (event.level.name == "ERROR" || event.level.name == "WARN") {
            println("[InnerTubeX/${event.level}] ${event.tag}: ${event.message}")
        }
    }

    private val configRepository = object : PlayerConfigRepository {
        private val defaultUrl =
            "https://raw.githubusercontent.com/ZemerTeam/zemer-cipher/master/library/src/main/assets/player_configs.json"

        override val enabled: Boolean = true
        override val sourceUrl: String = defaultUrl
        override val defaultSourceUrl: String = defaultUrl

        private fun readMeta(): CachedConfigMeta =
            try {
                if (playerConfigMetaFile.exists()) jsonFormat.decodeFromString(playerConfigMetaFile.readText())
                else CachedConfigMeta()
            } catch (_: Exception) { CachedConfigMeta() }

        private fun writeMeta(meta: CachedConfigMeta) {
            try { playerConfigMetaFile.writeText(jsonFormat.encodeToString(meta)) } catch (_: Exception) {}
        }

        override var cachedJson: String
            get() = if (playerConfigJsonFile.exists()) playerConfigJsonFile.readText() else ""
            set(value) { playerConfigJsonFile.writeText(value) }

        override var cachedAtMs: Long
            get() = readMeta().cachedAtMs
            set(value) { writeMeta(readMeta().copy(cachedAtMs = value)) }

        override var cachedSourceUrl: String
            get() = readMeta().cachedSourceUrl
            set(value) { writeMeta(readMeta().copy(cachedSourceUrl = value)) }

        override var cachedEtag: String
            get() = readMeta().cachedEtag
            set(value) { writeMeta(readMeta().copy(cachedEtag = value)) }
    }

    private val noopTokenProvider = object : TokenProvider {
        override val capabilities = TokenProviderCapabilities(providers = emptySet(), usesWebView = false)
        override suspend fun getPoToken(videoId: String, visitorData: String, cookie: String?): PoTokenResult? = null
    }

    init {
        loadSavedCookie()
        loadLocalCollections()
        initVlc()
        startProgressTracker()
    }

    private fun downloadFileFor(id: String): File = File(downloadsDir, "$id.audio")

    private fun loadLocalCollections() {
        val favs = try {
            if (favoritesFile.exists()) jsonFormat.decodeFromString<List<DesktopTrack>>(favoritesFile.readText())
            else emptyList()
        } catch (_: Exception) { emptyList() }

        val hist = try {
            if (historyFile.exists()) jsonFormat.decodeFromString<List<DesktopTrack>>(historyFile.readText())
            else emptyList()
        } catch (_: Exception) { emptyList() }

        val dls = try {
            if (downloadsMetaFile.exists()) {
                jsonFormat.decodeFromString<List<DesktopTrack>>(downloadsMetaFile.readText())
                    .filter { downloadFileFor(it.id).exists() }
            } else emptyList()
        } catch (_: Exception) { emptyList() }

        val pls = try {
            if (playlistsFile.exists()) jsonFormat.decodeFromString<List<LocalPlaylist>>(playlistsFile.readText())
            else emptyList()
        } catch (_: Exception) { emptyList() }

        val sHist = try {
            if (searchHistoryFile.exists()) jsonFormat.decodeFromString<List<String>>(searchHistoryFile.readText())
            else emptyList()
        } catch (_: Exception) { emptyList() }

        _state.value = _state.value.copy(
            favorites = favs,
            history = hist,
            downloads = dls,
            localPlaylists = pls,
            searchHistory = sHist,
        )
    }

    private fun saveFavorites(list: List<DesktopTrack>) {
        try { favoritesFile.writeText(jsonFormat.encodeToString(list)) } catch (_: Exception) {}
    }

    private fun saveHistory(list: List<DesktopTrack>) {
        try { historyFile.writeText(jsonFormat.encodeToString(list)) } catch (_: Exception) {}
    }

    private fun saveDownloadsMeta(list: List<DesktopTrack>) {
        try { downloadsMetaFile.writeText(jsonFormat.encodeToString(list)) } catch (_: Exception) {}
    }

    private fun savePlaylists(list: List<LocalPlaylist>) {
        try { playlistsFile.writeText(jsonFormat.encodeToString(list)) } catch (_: Exception) {}
    }

    private fun saveSearchHistory(list: List<String>) {
        try { searchHistoryFile.writeText(jsonFormat.encodeToString(list)) } catch (_: Exception) {}
    }

    private fun initVlc() {
        try {
            val isWindows = System.getProperty("os.name").lowercase().contains("win")
            if (isWindows) {
                System.getProperty("compose.application.resources.dir")?.let { resDir ->
                    val dir = File(resDir)
                    if (dir.exists()) {
                        com.sun.jna.NativeLibrary.addSearchPath("libvlc", dir.absolutePath)
                        com.sun.jna.NativeLibrary.addSearchPath("libvlccore", dir.absolutePath)
                        System.setProperty("VLC_PLUGIN_PATH", File(dir, "plugins").absolutePath)
                    }
                }
            }
            val vlcArgs = if (isWindows) {
                arrayOf("--no-video", "--quiet")
            } else {
                arrayOf("--no-video", "--quiet", "--control=dbus", "--extraintf=dbus")
            }
            val f = MediaPlayerFactory(*vlcArgs)
            val mp = f.mediaPlayers().newMediaPlayer()
            mp.audio().setVolume(_state.value.volume)
            mp.events().addMediaPlayerEventListener(object : MediaPlayerEventAdapter() {
                override fun playing(mediaPlayer: MediaPlayer) {
                    mediaPlayer.controls().setRate(_state.value.playbackSpeed)
                    _state.value = _state.value.copy(isPlaying = true, isLoading = false, errorMessage = null)
                }

                override fun paused(mediaPlayer: MediaPlayer) {
                    _state.value = _state.value.copy(isPlaying = false)
                }

                override fun stopped(mediaPlayer: MediaPlayer) {
                    _state.value = _state.value.copy(isPlaying = false)
                }

                override fun finished(mediaPlayer: MediaPlayer) {
                    scope.launch { handleTrackFinished() }
                }

                override fun error(mediaPlayer: MediaPlayer) {
                    _state.value = _state.value.copy(isPlaying = false, isLoading = false, errorMessage = "VLC playback error")
                }
            })
            factory = f
            mediaPlayer = mp
        } catch (t: Throwable) {
            _state.value = _state.value.copy(errorMessage = "libvlc tidak ditemukan: ${t.message}")
        }
    }

    private fun startProgressTracker() {
        progressJob = scope.launch {
            while (isActive) {
                val mp = mediaPlayer
                if (mp != null && _state.value.isPlaying) {
                    val time = mp.status().time().coerceAtLeast(0L)
                    val len = mp.status().length().coerceAtLeast(0L)
                    _progress.value = PlaybackProgress(time, len)
                }
                delay(250L)
            }
        }
    }

    private fun YtConfigParser.withEmbeddedFallback(): YtConfigParser =
        object : YtConfigParser by this {
            override suspend fun fetchConfig(videoId: String, useLoginCookies: Boolean) =
                try {
                    this@withEmbeddedFallback.fetchConfig(videoId, useLoginCookies)
                } catch (_: IllegalStateException) {
                    this@withEmbeddedFallback.fetchEmbeddedConfig(videoId, useLoginCookies = false)
                }
        }

    private suspend fun extractor(): InnerTubeExtractor {
        val transport = YouTube.extractionTransport()
        cachedExtractor?.takeIf { cachedGeneration == transport.generation }?.let { return it }
        return bundleMutex.withLock {
            val latest = YouTube.extractionTransport()
            cachedExtractor?.takeIf { cachedGeneration == latest.generation }?.let { return@withLock it }
            val store = RemotePlayerConfigStore(latest.httpClient, configRepository, logger)
            val cipher = YouTubeCipherService(latest.httpClient, store, logger)
            val ext = InnerTubeExtractor(
                configParser = YtConfigParserImpl(latest.httpClient, latest.innerTube, store, logger).withEmbeddedFallback(),
                cipherService = cipher,
                innerTube = latest.innerTube,
                tokenProvider = noopTokenProvider,
                logger = logger,
            )
            cachedExtractor = ext
            cachedGeneration = latest.generation
            ext
        }
    }

    fun playSong(song: SongItem, queue: List<SongItem> = listOf(song)) {
        playTrack(song.toDesktopTrack(), queue.map { it.toDesktopTrack() })
    }

    fun playTrack(track: DesktopTrack, queue: List<DesktopTrack> = listOf(track)) {
        val baseQueue = if (queue.isEmpty()) listOf(track) else queue
        val idx = baseQueue.indexOfFirst { it.id == track.id }.let { if (it >= 0) it else 0 }

        val updatedHistory = (listOf(track) + _state.value.history.filterNot { it.id == track.id }).take(50)
        saveHistory(updatedHistory)

        _progress.value = PlaybackProgress(0L, (track.durationSec ?: 0) * 1000L)
        _state.value = _state.value.copy(
            currentTrack = track,
            queue = baseQueue,
            currentIndex = idx,
            history = updatedHistory,
            isLoading = true,
            syncedLyrics = emptyList(),
            plainLyrics = null,
            lyricsLoading = true,
            errorMessage = null,
        )

        extractAdaptivePalette(track.thumbnail)
        fetchLyrics(track)
        if (baseQueue.size <= 1) fetchAutoRadioQueue(track)

        playJob?.cancel()
        playJob = scope.launch {
            try {
                val localFile = downloadFileFor(track.id)
                if (localFile.exists() && localFile.length() > 1024L) {
                    withContext(Dispatchers.Main) {
                        mediaPlayer?.media()?.play(localFile.absolutePath)
                    }
                    return@launch
                }

                val hints = ContentHints().withStreamCapabilities(allowHls = false, allowSabr = false, allowBoundedRange = false)
                val stream = extractor().extract(
                    videoId = track.id,
                    hints = hints,
                    excludedClients = emptySet(),
                    audioQuality = _state.value.audioQuality,
                    clientPlaybackNonce = generateClientPlaybackNonce(),
                ) ?: throw IllegalStateException("Stream audio tidak tersedia")

                val options = arrayOf(":http-referrer=https://music.youtube.com/")
                withContext(Dispatchers.Main) {
                    mediaPlayer?.media()?.play(stream.audioUrl, *options)
                }
            } catch (e: Exception) {
                _state.value = _state.value.copy(isLoading = false, isPlaying = false, errorMessage = e.message ?: "Gagal memutar lagu")
            }
        }
    }

    fun downloadTrack(track: DesktopTrack) {
        if (_state.value.isDownloaded(track.id) || _state.value.isDownloading(track.id)) return
        _state.value = _state.value.copy(downloadingIds = _state.value.downloadingIds + track.id)

        scope.launch {
            val tmp = File(downloadsDir, "${track.id}.part")
            try {
                val hints = ContentHints().withStreamCapabilities(allowHls = false, allowSabr = false, allowBoundedRange = false)
                val stream = extractor().extract(
                    videoId = track.id,
                    hints = hints,
                    excludedClients = emptySet(),
                    audioQuality = _state.value.audioQuality,
                    clientPlaybackNonce = generateClientPlaybackNonce(),
                ) ?: throw IllegalStateException("Stream tidak tersedia")

                val target = downloadFileFor(track.id)
                if (tmp.exists()) tmp.delete()

                val chunkSize = 512L * 1024L
                var offset = 0L
                var totalBytes = -1L

                tmp.outputStream().buffered().use { output ->
                    while (true) {
                        val endByte = if (totalBytes > 0L) minOf(offset + chunkSize - 1L, totalBytes - 1L) else (offset + chunkSize - 1L)
                        val conn = (java.net.URI.create(stream.audioUrl).toURL().openConnection() as HttpURLConnection).apply {
                            connectTimeout = 15_000
                            readTimeout = 20_000
                            setRequestProperty("Range", "bytes=$offset-$endByte")
                            setRequestProperty("Referer", "https://music.youtube.com/")
                            setRequestProperty("Origin", "https://music.youtube.com")
                            val ua = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36"
                            setRequestProperty("User-Agent", ua)
                        }

                        val code = conn.responseCode
                        if (code != HttpURLConnection.HTTP_PARTIAL && code != HttpURLConnection.HTTP_OK) {
                            conn.disconnect()
                            throw IllegalStateException("HTTP $code")
                        }

                        if (totalBytes < 0L) {
                            val contentRange = conn.getHeaderField("Content-Range")
                            totalBytes = contentRange?.substringAfterLast("/")?.toLongOrNull()
                                ?: conn.contentLengthLong.takeIf { it > 0L }
                                ?: -1L
                        }

                        var readInChunk = 0L
                        conn.inputStream.use { input ->
                            val buf = ByteArray(16 * 1024)
                            while (true) {
                                val n = input.read(buf)
                                if (n <= 0) break
                                output.write(buf, 0, n)
                                readInChunk += n
                            }
                        }
                        conn.disconnect()

                        if (readInChunk <= 0L) break
                        offset += readInChunk
                        if (code == HttpURLConnection.HTTP_OK || (totalBytes > 0L && offset >= totalBytes)) break
                    }
                    output.flush()
                }

                if (tmp.exists() && tmp.length() > 4096L) {
                    if (target.exists()) target.delete()
                    tmp.renameTo(target)
                    val updated = (listOf(track) + _state.value.downloads.filterNot { it.id == track.id })
                    saveDownloadsMeta(updated)
                    _state.value = _state.value.copy(downloads = updated)
                } else {
                    tmp.delete()
                    throw IllegalStateException("File tidak lengkap")
                }
            } catch (e: Exception) {
                tmp.delete()
                _state.value = _state.value.copy(errorMessage = "Gagal: ${e.message}")
            } finally {
                _state.value = _state.value.copy(downloadingIds = _state.value.downloadingIds - track.id)
            }
        }
    }

    private fun extractAdaptivePalette(thumbnailUrl: String) {
        paletteJob?.cancel()
        paletteJob = scope.launch {
            try {
                val img = ImageIO.read(java.net.URI.create(thumbnailUrl).toURL()) ?: return@launch
                val stepX = (img.width / 24).coerceAtLeast(1)
                val stepY = (img.height / 24).coerceAtLeast(1)
                var bestScore = -1f
                var bestHue = 0.94f
                var bestSat = 0.45f
                val hsb = FloatArray(3)

                for (y in 0 until img.height step stepY) {
                    for (x in 0 until img.width step stepX) {
                        val rgb = img.getRGB(x, y)
                        val r = (rgb shr 16) and 0xFF
                        val g = (rgb shr 8) and 0xFF
                        val b = rgb and 0xFF
                        AwtColor.RGBtoHSB(r, g, b, hsb)
                        val sat = hsb[1]
                        val bri = hsb[2]
                        if (bri in 0.18f..0.95f) {
                            val score = sat * 1.6f + bri * 0.4f
                            if (score > bestScore) {
                                bestScore = score
                                bestHue = hsb[0]
                                bestSat = sat.coerceIn(0.32f, 0.78f)
                            }
                        }
                    }
                }

                val primaryRgb = AwtColor.HSBtoRGB(bestHue, bestSat * 0.85f, 0.96f)
                val containerRgb = AwtColor.HSBtoRGB(bestHue, bestSat, 0.44f)
                val secondaryRgb = AwtColor.HSBtoRGB((bestHue + 0.08f) % 1f, bestSat * 0.7f, 0.88f)
                val tertiaryRgb = AwtColor.HSBtoRGB((bestHue + 0.88f) % 1f, bestSat * 0.65f, 0.85f)

                _state.value = _state.value.copy(
                    palette = DynamicPalette(
                        primaryArgb = (0xFF000000L or (primaryRgb.toLong() and 0xFFFFFFL)),
                        containerArgb = (0xFF000000L or (containerRgb.toLong() and 0xFFFFFFL)),
                        secondaryArgb = (0xFF000000L or (secondaryRgb.toLong() and 0xFFFFFFL)),
                        tertiaryArgb = (0xFF000000L or (tertiaryRgb.toLong() and 0xFFFFFFL)),
                    )
                )
            } catch (_: Exception) {}
        }
    }

    private fun fetchAutoRadioQueue(seed: DesktopTrack) {
        radioJob?.cancel()
        radioJob = scope.launch {
            try {
                val q = "${seed.artist} ${seed.title}".trim()
                YouTube.search(q, YouTube.SearchFilter.FILTER_SONG).onSuccess { res ->
                    val related = res.items.filterIsInstance<SongItem>().map { it.toDesktopTrack() }.filterNot { it.id == seed.id }.take(15)
                    if (related.isNotEmpty() && _state.value.currentTrack?.id == seed.id) {
                        _state.value = _state.value.copy(queue = (_state.value.queue + related).distinctBy { it.id })
                    }
                }
            } catch (_: Exception) {}
        }
    }

    fun toggleLyricTranslation() {
        _state.value = _state.value.copy(showLyricTranslation = !_state.value.showLyricTranslation)
    }

    private fun hasNonLatinScript(text: String): Boolean =
        text.any { ch ->
            val block = Character.UnicodeBlock.of(ch)
            block != null &&
                block != Character.UnicodeBlock.BASIC_LATIN &&
                block != Character.UnicodeBlock.LATIN_1_SUPPLEMENT &&
                block != Character.UnicodeBlock.LATIN_EXTENDED_A &&
                block != Character.UnicodeBlock.LATIN_EXTENDED_B &&
                block != Character.UnicodeBlock.GENERAL_PUNCTUATION
        }

    private suspend fun enrichLyricsWithRomanizationAndTranslation(
        trackId: String,
        lines: List<LyricLine>,
    ) {
        if (lines.isEmpty()) return
        try {
            val joined = lines.joinToString(" | ") { it.text }
            val needsRoman = hasNonLatinScript(joined)
            val resp = lyricsClient.get("https://translate.googleapis.com/translate_a/single") {
                parameter("client", "gtx")
                parameter("sl", "auto")
                parameter("tl", "id")
                parameter("dt", "t")
                if (needsRoman) parameter("dt", "rm")
                parameter("q", joined)
            }
            val root = jsonFormat.parseToJsonElement(resp.bodyAsText()).jsonArray
            val detectedLang = root.getOrNull(2)?.jsonPrimitive?.content ?: ""
            val sentences = root.getOrNull(0)?.jsonArray ?: return

            val translatedSb = StringBuilder()
            val romanSb = StringBuilder()
            for (item in sentences) {
                val arr = item.jsonArray
                arr.getOrNull(0)?.jsonPrimitive?.content?.let { translatedSb.append(it) }
                arr.getOrNull(3)?.jsonPrimitive?.content?.let { romanSb.append(it) }
            }

            val transLines = translatedSb.toString().split("|").map { it.trim() }
            val romanLines = romanSb.toString().split("|").map { it.trim() }
            val isIndonesian = detectedLang.equals("id", ignoreCase = true)

            val enriched = lines.mapIndexed { idx, line ->
                val rom = if (needsRoman) {
                    romanLines.getOrNull(idx)?.trim()?.takeIf { it.isNotBlank() && !it.equals(line.text.trim(), ignoreCase = true) }
                } else null
                val tr = if (!isIndonesian) {
                    transLines.getOrNull(idx)?.trim()?.takeIf { it.isNotBlank() && !it.equals(line.text.trim(), ignoreCase = true) }
                } else null
                line.copy(romanized = rom, translated = tr)
            }

            if (_state.value.currentTrack?.id == trackId) {
                _state.value = _state.value.copy(syncedLyrics = enriched)
            }
        } catch (_: Exception) {
            // Fallback tetap tampilkan lirik asli jika offline / gagal translate
        }
    }

    private fun fetchLyrics(track: DesktopTrack) {
        lyricsJob?.cancel()
        lyricsJob = scope.launch {
            try {
                val artist = track.artist.split(",").firstOrNull()?.trim().orEmpty()
                val resp = lyricsClient.get("https://lrclib.net/api/get") {
                    parameter("track_name", track.title)
                    if (artist.isNotBlank()) parameter("artist_name", artist)
                }
                val obj = jsonFormat.parseToJsonElement(resp.bodyAsText()).jsonObject
                val syncedRaw = obj["syncedLyrics"]?.jsonPrimitive?.content
                val plainRaw = obj["plainLyrics"]?.jsonPrimitive?.content
                val parsedSynced = parseLrc(syncedRaw)
                _state.value = _state.value.copy(
                    syncedLyrics = parsedSynced,
                    plainLyrics = plainRaw?.takeIf { it.isNotBlank() } ?: if (parsedSynced.isEmpty()) "Lirik tidak ditemukan untuk lagu ini." else null,
                    lyricsLoading = false,
                )
                if (parsedSynced.isNotEmpty()) {
                    enrichLyricsWithRomanizationAndTranslation(track.id, parsedSynced)
                }
            } catch (_: Exception) {
                _state.value = _state.value.copy(syncedLyrics = emptyList(), plainLyrics = "Lirik tidak ditemukan untuk lagu ini.", lyricsLoading = false)
            }
        }
    }

    private fun parseLrc(raw: String?): List<LyricLine> {
        if (raw.isNullOrBlank()) return emptyList()
        val regex = Regex("""\[(\d+):(\d+)(?:\.(\d+))?]\s*(.*)""")
        return raw.lines().mapNotNull { line ->
            val m = regex.matchEntire(line.trim()) ?: return@mapNotNull null
            val min = m.groupValues[1].toLongOrNull() ?: 0L
            val sec = m.groupValues[2].toLongOrNull() ?: 0L
            val fracStr = m.groupValues[3]
            val ms = when (fracStr.length) {
                1 -> (fracStr.toLongOrNull() ?: 0L) * 100L
                2 -> (fracStr.toLongOrNull() ?: 0L) * 10L
                3 -> fracStr.toLongOrNull() ?: 0L
                else -> 0L
            }
            val text = m.groupValues[4].trim()
            if (text.isBlank()) null else LyricLine(min * 60_000L + sec * 1_000L + ms, text)
        }.sortedBy { it.timeMs }
    }

    fun toggleFavorite(track: DesktopTrack? = _state.value.currentTrack) {
        val target = track ?: return
        val current = _state.value.favorites
        val updated = if (current.any { it.id == target.id }) current.filterNot { it.id == target.id } else listOf(target) + current
        saveFavorites(updated)
        _state.value = _state.value.copy(favorites = updated)
    }

    fun setPlaybackSpeed(speed: Float) {
        mediaPlayer?.controls()?.setRate(speed)
        _state.value = _state.value.copy(playbackSpeed = speed)
    }

    fun setAudioQuality(quality: AudioQuality) { _state.value = _state.value.copy(audioQuality = quality) }

    fun setSleepTimer(minutes: Int) {
        sleepTimerJob?.cancel()
        if (minutes <= 0) {
            _state.value = _state.value.copy(sleepTimerRemainingSec = null)
            return
        }
        sleepTimerJob = scope.launch {
            var remaining = minutes * 60
            while (remaining > 0 && isActive) {
                _state.value = _state.value.copy(sleepTimerRemainingSec = remaining)
                delay(1000L)
                remaining--
            }
            if (isActive) {
                _state.value = _state.value.copy(sleepTimerRemainingSec = null)
                mediaPlayer?.controls()?.pause()
            }
        }
    }

    private fun handleTrackFinished() {
        val st = _state.value
        val track = st.currentTrack ?: return
        when (st.repeatMode) {
            RepeatMode.ONE -> playTrack(track, st.queue)
            RepeatMode.ALL -> playNext(forceWrap = true)
            RepeatMode.OFF -> if (st.currentIndex + 1 < st.queue.size || st.isShuffled) playNext(forceWrap = false)
        }
    }

    fun clearQueue() {
        val cur = _state.value.currentTrack
        _state.value = if (cur != null) {
            _state.value.copy(queue = listOf(cur), currentIndex = 0)
        } else {
            _state.value.copy(queue = emptyList(), currentIndex = -1)
        }
    }

    fun moveQueueItem(fromIndex: Int, toIndex: Int) {
        val q = _state.value.queue.toMutableList()
        if (fromIndex !in q.indices || toIndex !in q.indices || fromIndex == toIndex) return
        val moved = q.removeAt(fromIndex)
        q.add(toIndex, moved)
        val curId = _state.value.currentTrack?.id
        val newCurIdx = if (curId != null) q.indexOfFirst { it.id == curId } else -1
        _state.value = _state.value.copy(queue = q, currentIndex = newCurIdx)
    }

    fun removeFromQueue(index: Int) {
        val q = _state.value.queue.toMutableList()
        if (index !in q.indices) return
        val removed = q.removeAt(index)
        if (q.isEmpty()) {
            mediaPlayer?.controls()?.stop()
            _state.value = _state.value.copy(currentTrack = null, queue = emptyList(), currentIndex = -1, isPlaying = false)
            return
        }
        val curId = _state.value.currentTrack?.id
        if (removed.id == curId) {
            val nextIdx = index.coerceAtMost(q.lastIndex)
            playTrack(q[nextIdx], q)
        } else {
            val newCurIdx = if (curId != null) q.indexOfFirst { it.id == curId } else -1
            _state.value = _state.value.copy(queue = q, currentIndex = newCurIdx)
        }
    }

    fun toggleShuffle() { _state.value = _state.value.copy(isShuffled = !_state.value.isShuffled) }

    fun cycleRepeatMode() {
        val next = when (_state.value.repeatMode) {
            RepeatMode.OFF -> RepeatMode.ALL
            RepeatMode.ALL -> RepeatMode.ONE
            RepeatMode.ONE -> RepeatMode.OFF
        }
        _state.value = _state.value.copy(repeatMode = next)
    }

    fun togglePlayPause() {
        val mp = mediaPlayer ?: return
        if (_state.value.isPlaying) mp.controls().pause() else mp.controls().play()
    }

    fun seekTo(positionMs: Long) {
        val dur = _progress.value.durationMs.coerceAtLeast(0L)
        val clamped = positionMs.coerceIn(0L, dur)
        mediaPlayer?.controls()?.setTime(clamped)
        _progress.value = _progress.value.copy(positionMs = clamped)
    }

    fun seekBy(deltaMs: Long) = seekTo(_progress.value.positionMs + deltaMs)

    fun setVolume(volume: Int) {
        val clamped = volume.coerceIn(0, 100)
        mediaPlayer?.audio()?.setVolume(clamped)
        _state.value = _state.value.copy(volume = clamped)
    }

    fun playNext(forceWrap: Boolean = true) {
        val q = _state.value.queue
        if (q.isEmpty()) return
        val nextIdx = if (_state.value.isShuffled && q.size > 1) {
            (q.indices - _state.value.currentIndex).random()
        } else {
            val cand = _state.value.currentIndex + 1
            if (cand < q.size) cand else if (forceWrap) 0 else return
        }
        playTrack(q[nextIdx], q)
    }

    fun playPrevious() {
        val q = _state.value.queue
        if (q.isEmpty()) return
        if (_progress.value.positionMs > 4000L) { seekTo(0L); return }
        val prevIdx = if (_state.value.currentIndex - 1 < 0) q.lastIndex else _state.value.currentIndex - 1
        playTrack(q[prevIdx], q)
    }



    fun deleteDownload(trackId: String) {
        try { downloadFileFor(trackId).delete() } catch (_: Exception) {}
        val updated = _state.value.downloads.filterNot { it.id == trackId }
        saveDownloadsMeta(updated)
        _state.value = _state.value.copy(downloads = updated)
    }

    fun createPlaylist(name: String, description: String = ""): LocalPlaylist {
        val cleanName = name.trim().ifBlank { "My Playlist" }
        val created = LocalPlaylist(name = cleanName, description = description.trim())
        val updated = listOf(created) + _state.value.localPlaylists
        savePlaylists(updated)
        _state.value = _state.value.copy(localPlaylists = updated)
        return created
    }

    fun renamePlaylist(playlistId: String, newName: String) {
        val cleanName = newName.trim()
        if (cleanName.isBlank()) return
        val updated = _state.value.localPlaylists.map { pl ->
            if (pl.id == playlistId) pl.copy(name = cleanName) else pl
        }
        savePlaylists(updated)
        _state.value = _state.value.copy(localPlaylists = updated)
    }

    fun deletePlaylist(playlistId: String) {
        val updated = _state.value.localPlaylists.filterNot { it.id == playlistId }
        savePlaylists(updated)
        _state.value = _state.value.copy(localPlaylists = updated)
    }

    fun addTrackToPlaylist(playlistId: String, track: DesktopTrack) {
        val updated = _state.value.localPlaylists.map { pl ->
            if (pl.id == playlistId) {
                val nextTracks = (pl.tracks.filterNot { it.id == track.id } + track)
                pl.copy(tracks = nextTracks)
            } else pl
        }
        savePlaylists(updated)
        _state.value = _state.value.copy(localPlaylists = updated)
    }

    fun removeTrackFromPlaylist(playlistId: String, trackId: String) {
        val updated = _state.value.localPlaylists.map { pl ->
            if (pl.id == playlistId) pl.copy(tracks = pl.tracks.filterNot { it.id == trackId }) else pl
        }
        savePlaylists(updated)
        _state.value = _state.value.copy(localPlaylists = updated)
    }

    fun addSearchHistory(query: String) {
        val clean = query.trim()
        if (clean.isBlank()) return
        val updated = (listOf(clean) + _state.value.searchHistory.filterNot { it.equals(clean, ignoreCase = true) }).take(20)
        saveSearchHistory(updated)
        _state.value = _state.value.copy(searchHistory = updated)
    }

    fun removeSearchHistory(query: String) {
        val updated = _state.value.searchHistory.filterNot { it == query }
        saveSearchHistory(updated)
        _state.value = _state.value.copy(searchHistory = updated)
    }

    fun clearSearchHistory() {
        saveSearchHistory(emptyList<String>())
        _state.value = _state.value.copy(searchHistory = emptyList())
    }

    fun saveCookie(cookie: String) {
        val trimmed = cookie.trim()
        YouTube.cookie = trimmed.ifBlank { null }
        if (trimmed.isBlank()) cookieFile.delete() else cookieFile.writeText(trimmed)
    }

    fun getSavedCookie(): String = if (cookieFile.exists()) cookieFile.readText() else ""

    private fun loadSavedCookie() {
        if (cookieFile.exists()) {
            val saved = cookieFile.readText().trim()
            if (saved.isNotBlank()) YouTube.cookie = saved
        }
    }

    fun release() {
        progressJob?.cancel()
        playJob?.cancel()
        lyricsJob?.cancel()
        radioJob?.cancel()
        paletteJob?.cancel()
        sleepTimerJob?.cancel()
        lyricsClient.close()
        mediaPlayer?.release()
        factory?.release()
    }
}
