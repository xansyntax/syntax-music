package com.metrolist.innertube

import com.metrolist.innertube.models.*
import com.metrolist.innertube.models.response.*
import com.metrolist.innertube.pages.*
import com.metrolist.innertubex.models.YouTubeClient
import com.metrolist.innertubex.models.YouTubeLocale
import io.ktor.client.HttpClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.*
import timber.log.Timber
import java.io.InputStream
import java.net.Proxy

@JvmInline
value class SearchFilter(val value: String) {
    companion object {
        val FILTER_ALL = SearchFilter("")
        val FILTER_SONG = SearchFilter("EgWKAQIIAWoKEAkQBRAKEAMQBA%3D%3D")
        val FILTER_VIDEO = SearchFilter("EgWKAQIQAWoKEAkQChAFEAMQBA%3D%3D")
        val FILTER_ALBUM = SearchFilter("EgWKAQIYAWoKEAkQChAFEAMQBA%3D%3D")
        val FILTER_ARTIST = SearchFilter("EgWKAQIgAWoKEAkQChAFEAMQBA%3D%3D")
        val FILTER_COMMUNITY_PLAYLIST = SearchFilter("EgeKAQQoAEABagoQAxAEEAoQCRAF")
        val FILTER_FEATURED_PLAYLIST = SearchFilter("EgeKAQQoADgBagwQDhAKEAMQBRAJEAQ%3D")
        val FILTER_PODCAST = SearchFilter("EgWKAQJQAWoKEAkQChAFEAMQBA%3D%3D")
        val FILTER_EPISODE = SearchFilter("EgWKAQJYAWoKEAkQChAFEAMQBA%3D%3D")
        val FILTER_PROFILE = SearchFilter("EgWKAQJYAWoSEAUQCRADEAQQEBAVEAoQDhAR")
    }
}

data class ExtractionTransport(
    val innerTube: com.metrolist.innertubex.InnerTube? = null,
    val httpClient: HttpClient? = null,
    val transportGeneration: Long = 0L,
)

object YouTube {
    val SUPPORTED_UPLOAD_TYPES = listOf("mp3", "m4a", "wma", "flac", "ogg")

    val innerTube = InnerTube()

    var locale: YouTubeLocale
        get() = innerTube.locale
        set(value) {
            innerTube.locale = value
        }

    var visitorData: String?
        get() = innerTube.visitorData
        set(value) {
            innerTube.visitorData = value
        }

    var dataSyncId: String?
        get() = innerTube.dataSyncId
        set(value) {
            innerTube.dataSyncId = value
        }

    var cookie: String?
        get() = innerTube.cookie
        set(value) {
            innerTube.cookie = value
        }

    var authUser: String?
        get() = innerTube.authUser
        set(value) {
            innerTube.authUser = value
        }

    var proxy: Proxy?
        get() = innerTube.proxy
        set(value) {
            innerTube.proxy = value
        }

    var proxyAuth: String?
        get() = innerTube.proxyAuth
        set(value) {
            innerTube.proxyAuth = value
        }

    var useLoginForBrowse: Boolean
        get() = innerTube.useLoginForBrowse
        set(value) {
            innerTube.useLoginForBrowse = value
        }

    fun extractionTransport(): ExtractionTransport {
        return ExtractionTransport(
            httpClient = null,
            transportGeneration = 0L,
        )
    }

    fun groupItemsByType(list: List<YTItem>): List<SearchSummary> {
        val grouped = linkedMapOf<String, MutableList<YTItem>>()
        for (item in list) {
            val key = when (item) {
                is EpisodeItem -> "Episodes"
                is PodcastItem -> "Podcasts"
                is AlbumItem -> "Albums"
                is ArtistItem -> if (item.isProfile) "Profiles" else "Artists"
                is PlaylistItem -> "Playlists"
                is SongItem -> if (item.isEpisode) "Episodes" else if (item.isVideoSong) "Videos" else "Songs"
                else -> "Other"
            }
            grouped.getOrPut(key) { mutableListOf() }.add(item)
        }
        val order = listOf("Songs", "Videos", "Albums", "Artists", "Playlists", "Podcasts", "Episodes", "Profiles", "Other")
        return order.mapNotNull { category ->
            grouped[category]?.takeIf { it.isNotEmpty() }?.let { SearchSummary(category, it) }
        }
    }

    fun convertMusicTwoRowItem(renderer: MusicTwoRowItemRenderer): YTItem? {
        return try {
            val isSong = renderer.isSong()
            val badges = renderer.subtitleBadges
            val thumbRenderer = renderer.thumbnailRenderer
            val navEndpoint = renderer.navigationEndpoint
            val titleRuns = renderer.title?.runs
            val subtitleRuns = renderer.subtitle?.runs
            if (isSong) {
                val title = titleRuns?.firstOrNull()?.text ?: return null
                val videoId = navEndpoint?.watchEndpoint?.videoId ?: return null
                val artists = PageHelper.extractArtists(subtitleRuns)
                val thumbnailUrl = thumbRenderer?.getThumbnailUrl() ?: return null
                val explicit = badges?.any { it.musicInlineBadgeRenderer?.icon?.iconType == "MUSIC_EXPLICIT_BADGE" } == true
                SongItem(
                    id = videoId,
                    title = title,
                    artists = artists,
                    thumbnail = thumbnailUrl,
                    explicit = explicit,
                    musicVideoType = renderer.getMusicVideoType(),
                )
            } else if (renderer.isAlbum()) {
                val browseId = navEndpoint?.browseEndpoint?.browseId ?: return null
                val playlistId = renderer.thumbnailOverlay?.musicItemThumbnailOverlayRenderer?.content?.musicPlayButtonRenderer?.playNavigationEndpoint?.watchPlaylistEndpoint?.playlistId ?: return null
                val title = titleRuns?.firstOrNull()?.text ?: return null
                val artists = PageHelper.extractArtists(subtitleRuns)
                val year = subtitleRuns?.lastOrNull()?.text?.toIntOrNull()
                val thumbnailUrl = thumbRenderer?.getThumbnailUrl() ?: return null
                val explicit = badges?.any { it.musicInlineBadgeRenderer?.icon?.iconType == "MUSIC_EXPLICIT_BADGE" } == true
                AlbumItem(
                    browseId = browseId,
                    playlistId = playlistId,
                    title = title,
                    artists = artists,
                    year = year,
                    thumbnail = thumbnailUrl,
                    explicit = explicit,
                )
            } else null
        } catch (e: Exception) {
            Timber.w(e, "Error converting two row item")
            null
        }
    }

    fun convertToChartItem(renderer: MusicResponsiveListItemRenderer): SongItem? {
        return try {
            val flexColumns = renderer.flexColumns ?: return null
            if (flexColumns.size < 3) return null
            val videoId = renderer.getVideoId() ?: return null
            val titleRuns = flexColumns.getOrNull(0)?.musicResponsiveListItemFlexColumnRenderer?.text?.runs
            val title = titleRuns?.firstOrNull()?.text?.takeIf { it.isNotBlank() } ?: return null
            val subtitleRuns = flexColumns.getOrNull(1)?.musicResponsiveListItemFlexColumnRenderer?.text?.runs
            val artists = PageHelper.extractArtists(subtitleRuns)
            val thirdColRuns = flexColumns.getOrNull(2)?.musicResponsiveListItemFlexColumnRenderer?.text?.runs
            val thumbnailUrl = renderer.thumbnail?.getThumbnailUrl() ?: return null
            val explicit = renderer.badges?.any { it.musicInlineBadgeRenderer?.icon?.iconType == "MUSIC_EXPLICIT_BADGE" } == true
            SongItem(
                id = videoId,
                title = title,
                artists = artists,
                thumbnail = thumbnailUrl,
                explicit = explicit,
                musicVideoType = renderer.getMusicVideoType(),
                chartPosition = thirdColRuns?.firstOrNull()?.text?.toIntOrNull(),
                chartChange = thirdColRuns?.getOrNull(1)?.text,
            )
        } catch (e: Exception) {
            Timber.w(e, "Error converting chart item")
            null
        }
    }

    private fun resolveArtist(artist: Artist, map: Map<String, String>): Artist {
        val resolvedId = if (artist.id == null) map[artist.name] else null
        return if (resolvedId != null) artist.copy(id = resolvedId) else artist
    }

    suspend fun resolveArtistIds(list: List<YTItem>): List<YTItem> {
        val missingNames = linkedSetOf<String>()
        for (item in list) {
            when (item) {
                is SongItem -> item.artists.forEach { if (it.id == null) missingNames.add(it.name) }
                is AlbumItem -> item.artists?.forEach { if (it.id == null) missingNames.add(it.name) }
                is PlaylistItem -> item.author?.let { if (it.id == null) missingNames.add(it.name) }
                is EpisodeItem -> item.author?.let { if (it.id == null) missingNames.add(it.name) }
                is PodcastItem -> item.author?.let { if (it.id == null) missingNames.add(it.name) }
                else -> {}
            }
        }
        if (missingNames.isEmpty()) return list

        val resolvedMap = coroutineScope {
            val semaphore = Semaphore(8)
            missingNames.map { name ->
                async {
                    semaphore.withPermit {
                        val searchResult = search(name, SearchFilter.FILTER_ARTIST).getOrNull()
                        val trimmed = name.trim()
                        val artistItem = searchResult?.items?.filterIsInstance<ArtistItem>()?.firstOrNull {
                            it.title.equals(trimmed, ignoreCase = true)
                        } ?: searchResult?.items?.filterIsInstance<ArtistItem>()?.firstOrNull()
                        if (artistItem != null) name to artistItem.id else null
                    }
                }
            }.awaitAll().filterNotNull().toMap()
        }

        return list.map { item ->
            when (item) {
                is SongItem -> item.copy(artists = item.artists.map { resolveArtist(it, resolvedMap) })
                is AlbumItem -> item.copy(artists = item.artists?.map { resolveArtist(it, resolvedMap) })
                is PlaylistItem -> item.copy(author = item.author?.let { resolveArtist(it, resolvedMap) })
                is EpisodeItem -> item.copy(author = item.author?.let { resolveArtist(it, resolvedMap) })
                is PodcastItem -> item.copy(author = item.author?.let { resolveArtist(it, resolvedMap) })
                else -> item
            }
        }
    }

    private fun textFromRuns(jsonObject: JsonObject, field: String): String? {
        val fieldObj = jsonObject[field] as? JsonObject ?: return null
        val runsArray = fieldObj["runs"] as? JsonArray ?: return null
        val firstRun = runsArray.firstOrNull() as? JsonObject ?: return null
        return (firstRun["text"] as? JsonPrimitive)?.contentOrNull
    }

    private fun findObject(jsonElement: JsonElement?): JsonObject? {
        if (jsonElement == null) return null
        if (jsonElement is JsonObject) {
            val endpoint = jsonElement["selectActiveIdentityEndpoint"] as? JsonObject
            if (endpoint != null) return endpoint
            for (value in jsonElement.values) {
                val found = findObject(value)
                if (found != null) return found
            }
        } else if (jsonElement is JsonArray) {
            for (element in jsonElement) {
                val found = findObject(element)
                if (found != null) return found
            }
        }
        return null
    }

    private fun tokenValue(jsonObject: JsonObject, tokenField: String, valueField: String): String? {
        val tokensArray = jsonObject["supportedTokens"] as? JsonArray ?: return null
        for (item in tokensArray) {
            val itemObj = item as? JsonObject ?: continue
            val tokenObj = itemObj[tokenField] as? JsonObject ?: continue
            val prim = tokenObj[valueField] as? JsonPrimitive ?: continue
            return prim.contentOrNull
        }
        return null
    }

    private fun collectAccountItems(element: JsonElement?, output: MutableList<YouTubeAccount>) {
        if (element == null) return
        if (element is JsonArray) {
            for (child in element) collectAccountItems(child, output)
            return
        }
        if (element !is JsonObject) return
        val accountItem = (element["accountItem"] ?: element["accountItemRenderer"]) as? JsonObject
        if (accountItem != null) {
            val name = textFromRuns(accountItem, "accountName")
            if (name != null) {
                val endpoint = findObject(accountItem)
                val byline = textFromRuns(accountItem, "accountByline")
                val channelHandle = textFromRuns(accountItem, "channelHandle")
                val photoObj = accountItem["accountPhoto"] as? JsonObject
                val thumbnails = photoObj?.get("thumbnails") as? JsonArray
                val photoUrl = (thumbnails?.lastOrNull() as? JsonObject)?.get("url")?.let {
                    (it as? JsonPrimitive)?.contentOrNull
                }
                val isSelected = (accountItem["isSelected"] as? JsonPrimitive)?.booleanOrNull ?: false
                val signinUrl = if (endpoint != null) tokenValue(endpoint, "accountSigninToken", "signinUrl") else null
                val pageId = if (endpoint != null) tokenValue(endpoint, "pageIdToken", "pageId") else null
                val dataSyncId = if (endpoint != null) tokenValue(endpoint, "datasyncIdToken", "datasyncIdToken") else null

                output.add(
                    YouTubeAccount(
                        name = name,
                        byline = byline,
                        channelHandle = channelHandle,
                        thumbnailUrl = photoUrl,
                        isSelected = isSelected,
                        signinUrl = signinUrl,
                        pageId = pageId,
                        dataSyncId = dataSyncId,
                    )
                )
            }
        }
        for (child in element.values) {
            collectAccountItems(child, output)
        }
    }

    fun extractYouTubeAccounts(jsonElement: JsonElement): List<YouTubeAccount> {
        val allAccounts = mutableListOf<YouTubeAccount>()
        collectAccountItems(jsonElement, allAccounts)
        val seen = hashSetOf<String>()
        val result = mutableListOf<YouTubeAccount>()
        for (acc in allAccounts) {
            val key = acc.pageId ?: acc.dataSyncId ?: acc.signinUrl ?: acc.channelHandle ?: acc.name
            if (seen.add(key)) {
                result.add(acc)
            }
        }
        return result
    }

    suspend fun accountInfo(): Result<AccountInfo> = runCatching {
        val response = innerTube.accountMenu(YouTubeClient.WEB_REMIX)
        val header = response.actions?.firstOrNull()?.openPopupAction?.popup?.multiPageMenuRenderer?.header?.activeAccountHeaderRenderer
            ?: throw IllegalStateException("Active account header not found")
        header.toAccountInfo()
    }

    suspend fun accountsList(): Result<List<YouTubeAccount>> = runCatching {
        val text = innerTube.accountsList()
        val jsonElement = innerTube.json.parseToJsonElement(text)
        extractYouTubeAccounts(jsonElement)
    }

    suspend fun addEpisodeToSavedEpisodes(episodeId: String): Result<String?> = runCatching {
        innerTube.addToPlaylist(YouTubeClient.WEB_REMIX, "SE", episodeId)
        null
    }

    suspend fun addSongToLibrary(videoId: String): Result<Unit> = runCatching {
        val nextResult = next(WatchEndpoint(videoId = videoId)).getOrThrow()
        val song = nextResult.items.firstOrNull { it.id == videoId }
        val token = song?.libraryAddToken
        if (token != null) {
            feedback(listOf(token)).getOrThrow()
        }
    }

    suspend fun addToPlaylist(playlistId: String, videoId: String): Result<String?> = runCatching {
        innerTube.addToPlaylist(YouTubeClient.WEB_REMIX, playlistId, videoId)
        null
    }

    suspend fun album(browseId: String, withSongs: Boolean = true): Result<AlbumPage> = runCatching {
        val response = innerTube.browse(YouTubeClient.WEB_REMIX, browseId)
        val twoCol = response.contents?.twoColumnBrowseResultsRenderer
        val header = response.header
        val detailHeader = header?.musicDetailHeaderRenderer
        val responsiveHeader = twoCol?.secondaryContents?.sectionListRenderer?.contents?.firstOrNull()?.musicResponsiveHeaderRenderer
            ?: twoCol?.tabs?.firstOrNull()?.tabRenderer?.content?.sectionListRenderer?.contents?.firstOrNull()?.musicResponsiveHeaderRenderer
        val title = detailHeader?.title?.runs?.firstOrNull()?.text
            ?: responsiveHeader?.title?.runs?.firstOrNull()?.text
            ?: ""
        val subtitleRuns = detailHeader?.subtitle?.runs ?: responsiveHeader?.subtitle?.runs
        val artists = PageHelper.extractArtists(responsiveHeader?.straplineTextOne?.runs ?: subtitleRuns)
        val year = subtitleRuns?.lastOrNull()?.text?.toIntOrNull()
        val thumbnailUrl = detailHeader?.thumbnail?.getThumbnailUrl()
            ?: responsiveHeader?.thumbnail?.getThumbnailUrl()
            ?: ""
        val explicit = false

        val albumItem = AlbumItem(
            browseId = browseId,
            playlistId = "",
            title = title,
            artists = artists,
            year = year,
            thumbnail = thumbnailUrl,
            explicit = explicit,
        )

        val songs = if (withSongs) {
            albumSongs(browseId, albumItem).getOrDefault(emptyList())
        } else emptyList()

        AlbumPage(album = albumItem, songs = songs, otherVersions = emptyList())
    }

    suspend fun albumSongs(playlistId: String, album: AlbumItem): Result<List<SongItem>> = runCatching {
        val targetId = if (playlistId.startsWith("VL")) playlistId else "VL$playlistId"
        val response = innerTube.browse(YouTubeClient.WEB_REMIX, targetId)
        val secContents = response.contents?.twoColumnBrowseResultsRenderer?.secondaryContents?.sectionListRenderer?.contents?.firstOrNull()
        val shelfContents = secContents?.musicPlaylistShelfRenderer?.contents ?: secContents?.musicShelfRenderer?.contents.orEmpty()
        val items = shelfContents.getItems()
        val songs = items.mapNotNull { AlbumPage.getSong(it, album) }.toMutableList()
        var continuation = shelfContents.getContinuation()
        val visited = mutableSetOf<String>()
        var count = 0
        while (continuation != null && count < 50 && visited.add(continuation)) {
            count++
            val continuationResponse = innerTube.browse(YouTubeClient.WEB_REMIX, continuation = continuation)
            val actions = continuationResponse.onResponseReceivedActions
            val continuationItems = actions?.firstOrNull()?.appendContinuationItemsAction?.continuationItems.orEmpty()
            val nextItems = continuationItems.getItems()
            songs.addAll(nextItems.mapNotNull { AlbumPage.getSong(it, album) })
            continuation = continuationItems.getContinuation()
        }
        songs
    }

    suspend fun artist(browseId: String): Result<ArtistPage> = runCatching {
        val response = innerTube.browse(YouTubeClient.WEB_REMIX, browseId)
        val header = response.header
        val immersive = header?.musicImmersiveHeaderRenderer
        val visual = header?.musicVisualHeaderRenderer
        val headerRenderer = header?.musicHeaderRenderer
        val name = immersive?.title?.runs?.firstOrNull()?.text
            ?: visual?.title?.runs?.firstOrNull()?.text
            ?: headerRenderer?.title?.runs?.firstOrNull()?.text
            ?: ""
        val thumbnailUrl = immersive?.thumbnail?.getThumbnailUrl()
            ?: visual?.thumbnail?.getThumbnailUrl()
            ?: ""
        val description = immersive?.description?.runs?.firstOrNull()?.text
        val descriptionRuns = immersive?.description?.runs
        val subscriberCount = (immersive?.subscriptionButton?.subscribeButtonRenderer?.shortSubscriberCountText
            ?: immersive?.subscriptionButton?.subscribeButtonRenderer?.longSubscriberCountText)
            ?.runs?.firstOrNull()?.text
        val isSubscribed = immersive?.subscriptionButton?.subscribeButtonRenderer?.subscribed ?: false

        val sections = response.contents?.singleColumnBrowseResultsRenderer?.tabs?.firstOrNull()
            ?.tabRenderer?.content?.sectionListRenderer?.contents.orEmpty()
            .mapNotNull { ArtistPage.fromSectionListRendererContent(it) }

        val artistItem = ArtistItem(id = browseId, title = name, thumbnail = thumbnailUrl)
        ArtistPage(
            artist = artistItem,
            sections = sections,
            description = description,
            descriptionRuns = descriptionRuns,
            subscriberCountText = subscriberCount,
            monthlyListenerCount = null,
            isSubscribed = isSubscribed,
        )
    }

    suspend fun artistItems(endpoint: BrowseEndpoint): Result<ArtistItemsPage> = runCatching {
        val response = innerTube.browse(YouTubeClient.WEB_REMIX, endpoint.browseId, endpoint.params)
        val tab = response.contents?.singleColumnBrowseResultsRenderer?.tabs?.firstOrNull()?.tabRenderer?.content?.sectionListRenderer
        val contents = tab?.contents.orEmpty()
        val title = response.header?.musicHeaderRenderer?.title?.runs?.firstOrNull()?.text
            ?: contents.firstOrNull()?.gridRenderer?.header?.gridHeaderRenderer?.title?.runs?.firstOrNull()?.text
            ?: ""
        val items = mutableListOf<YTItem>()
        for (content in contents) {
            content.gridRenderer?.items?.forEach { gridItem ->
                gridItem.musicTwoRowItemRenderer?.let { ArtistItemsPage.fromMusicTwoRowItemRenderer(it) }?.let { items.add(it) }
            }
            content.musicPlaylistShelfRenderer?.contents?.getItems()?.forEach { shelfItem ->
                ArtistItemsPage.fromMusicResponsiveListItemRenderer(shelfItem)?.let { items.add(it) }
            }
            content.musicShelfRenderer?.contents?.getItems()?.forEach { shelfItem ->
                ArtistItemsPage.fromMusicResponsiveListItemRenderer(shelfItem)?.let { items.add(it) }
            }
        }
        val continuation = contents.lastOrNull()?.musicShelfRenderer?.contents?.getContinuation()
            ?: contents.lastOrNull()?.musicPlaylistShelfRenderer?.contents?.getContinuation()
        ArtistItemsPage(title = title, items = items, continuation = continuation)
    }

    suspend fun artistItemsContinuation(continuation: String): Result<ArtistItemsContinuationPage> = runCatching {
        val response = innerTube.browse(YouTubeClient.WEB_REMIX, continuation = continuation)
        val actions = response.onResponseReceivedActions
        val continuationItems = actions?.firstOrNull()?.appendContinuationItemsAction?.continuationItems.orEmpty()
        val items = continuationItems.getItems().mapNotNull { ArtistItemsPage.fromMusicResponsiveListItemRenderer(it) }
        val nextContinuation = continuationItems.getContinuation()
        ArtistItemsContinuationPage(items = items, continuation = nextContinuation)
    }

    suspend fun browse(browseId: String, params: String? = null): Result<BrowseResult> = runCatching {
        val response = innerTube.browse(YouTubeClient.WEB_REMIX, browseId, params)
        val title = response.header?.musicHeaderRenderer?.title?.runs?.firstOrNull()?.text
        val items = mutableListOf<BrowseResult.Item>()
        val contents = response.contents?.singleColumnBrowseResultsRenderer?.tabs?.firstOrNull()?.tabRenderer?.content?.sectionListRenderer?.contents.orEmpty()
        for (content in contents) {
            val shelfTitle = content.musicCarouselShelfRenderer?.header?.musicCarouselShelfBasicHeaderRenderer?.title?.runs?.firstOrNull()?.text
                ?: content.gridRenderer?.header?.gridHeaderRenderer?.title?.runs?.firstOrNull()?.text
            val ytItems = mutableListOf<YTItem>()
            content.musicCarouselShelfRenderer?.contents?.forEach { c ->
                c.musicTwoRowItemRenderer?.let { ArtistItemsPage.fromMusicTwoRowItemRenderer(it) }?.let { ytItems.add(it) }
                c.musicResponsiveListItemRenderer?.let { ArtistPage.fromMusicResponsiveListItemRenderer(it) }?.let { ytItems.add(it) }
            }
            content.gridRenderer?.items?.forEach { c ->
                c.musicTwoRowItemRenderer?.let { ArtistItemsPage.fromMusicTwoRowItemRenderer(it) }?.let { ytItems.add(it) }
            }
            if (ytItems.isNotEmpty()) {
                items.add(BrowseResult.Item(title = shelfTitle ?: "", items = ytItems))
            }
        }
        BrowseResult(title = title, items = items)
    }

    suspend fun createPlaylist(title: String): Result<String?> = runCatching {
        innerTube.createPlaylist(YouTubeClient.WEB_REMIX, title).playlistId
    }

    suspend fun deletePlaylist(playlistId: String): Result<Unit> = runCatching {
        innerTube.deletePlaylist(YouTubeClient.WEB_REMIX, playlistId)
    }

    suspend fun deleteUploadedSong(entityId: String): Result<Unit> = runCatching {
        innerTube.deletePrivatelyOwnedEntity(entityId)
    }

    suspend fun episodesForLater(): Result<List<SongItem>> = runCatching {
        val response = innerTube.browse(YouTubeClient.WEB_REMIX, "VLSE", setLogin = true)
        val secContents = response.contents?.twoColumnBrowseResultsRenderer?.secondaryContents?.sectionListRenderer?.contents?.firstOrNull()
        val contents = secContents?.musicPlaylistShelfRenderer?.contents ?: secContents?.musicShelfRenderer?.contents.orEmpty()
        contents.getItems().mapNotNull { renderer ->
            val videoId = renderer.getVideoId() ?: return@mapNotNull null
            val title = renderer.flexColumns?.firstOrNull()?.musicResponsiveListItemFlexColumnRenderer?.text?.runs?.firstOrNull()?.text ?: return@mapNotNull null
            val subtitleRuns = renderer.flexColumns?.getOrNull(1)?.musicResponsiveListItemFlexColumnRenderer?.text?.runs
            val artists = PageHelper.extractArtists(subtitleRuns)
            val durationText = renderer.fixedColumns?.firstOrNull()?.musicResponsiveListItemFlexColumnRenderer?.text?.runs?.firstOrNull()?.text
            val duration = durationText?.let { PageHelper.extractDuration(listOf(Run(text = it))) }
            val thumbnailUrl = renderer.thumbnail?.getThumbnailUrl() ?: ""
            SongItem(
                id = videoId,
                title = title,
                artists = artists,
                duration = duration,
                thumbnail = thumbnailUrl,
                isEpisode = true,
            )
        }
    }

    suspend fun explore(): Result<ExplorePage> = runCatching {
        val newReleases = newReleaseAlbums().getOrDefault(emptyList())
        val moods = moodAndGenres().getOrDefault(emptyList())
        ExplorePage(newReleaseAlbums = newReleases, moodAndGenres = moods)
    }

    suspend fun feedback(tokens: List<String>): Result<Unit> = runCatching {
        innerTube.feedback(YouTubeClient.WEB_REMIX, tokens)
    }

    suspend fun getChannelId(handle: String): Result<String?> = runCatching {
        val response = innerTube.browse(YouTubeClient.WEB_REMIX, handle)
        response.header?.musicImmersiveHeaderRenderer?.subscriptionButton?.subscribeButtonRenderer?.channelId
            ?: response.header?.musicVisualHeaderRenderer?.subscriptionButton?.subscribeButtonRenderer?.channelId
    }

    suspend fun getChartsPage(): Result<ChartsPage> = runCatching {
        val response = innerTube.browse(YouTubeClient.WEB_REMIX, "FEmusic_charts")
        val contents = response.contents?.singleColumnBrowseResultsRenderer?.tabs?.firstOrNull()?.tabRenderer?.content?.sectionListRenderer?.contents.orEmpty()
        val sections = mutableListOf<ChartsPage.ChartSection>()
        for (content in contents) {
            val carousel = content.musicCarouselShelfRenderer
            if (carousel != null) {
                val title = carousel.header?.musicCarouselShelfBasicHeaderRenderer?.title?.runs?.firstOrNull()?.text.orEmpty()
                val items = carousel.contents.orEmpty().mapNotNull { c ->
                    c.musicResponsiveListItemRenderer?.let { convertToChartItem(it) }
                }
                if (items.isNotEmpty()) {
                    val type = if (title.contains("Trending", ignoreCase = true)) ChartsPage.ChartType.TRENDING
                    else if (title.contains("Top", ignoreCase = true)) ChartsPage.ChartType.TOP
                    else ChartsPage.ChartType.GENRE
                    sections.add(ChartsPage.ChartSection(title = title, items = items, chartType = type))
                }
            }
            val grid = content.gridRenderer
            if (grid != null) {
                val title = grid.header?.gridHeaderRenderer?.title?.runs?.firstOrNull()?.text.orEmpty()
                val items = grid.items.orEmpty().mapNotNull { item ->
                    item.musicTwoRowItemRenderer?.let { convertMusicTwoRowItem(it) }
                }
                if (items.isNotEmpty()) {
                    sections.add(ChartsPage.ChartSection(title = title, items = items, chartType = ChartsPage.ChartType.NEW_RELEASES))
                }
            }
        }
        val continuation = response.continuationContents?.sectionListContinuation?.continuations?.getContinuation()
        ChartsPage(continuation = continuation, sections = sections)
    }

    suspend fun getMediaInfo(videoId: String): Result<MediaInfo> = runCatching {
        val dislikeRes = innerTube.getMediaInfo(videoId).getOrNull()
        MediaInfo(
            videoId = videoId,
            like = dislikeRes?.likes,
            dislike = dislikeRes?.dislikes,
        )
    }

    suspend fun home(params: String? = null, continuation: String? = null): Result<HomePage> = runCatching {
        if (continuation != null) {
            homeContinuation(continuation).getOrThrow()
        } else {
            val response = innerTube.browse(YouTubeClient.WEB_REMIX, "FEmusic_home", params = params)
            val secList = response.contents?.singleColumnBrowseResultsRenderer?.tabs?.firstOrNull()?.tabRenderer?.content?.sectionListRenderer
            val chips = secList?.header?.chipCloudRenderer?.chips?.mapNotNull { chip ->
                val btn = chip.chipCloudChipRenderer
                val title = btn?.text?.runs?.firstOrNull()?.text ?: return@mapNotNull null
                HomePage.Chip(
                    title = title,
                    endpoint = btn.navigationEndpoint?.browseEndpoint,
                    deselectEndPoint = btn.onDeselectedCommand?.browseEndpoint,
                )
            }
            val sections = secList?.contents.orEmpty().mapNotNull { content ->
                content.musicCarouselShelfRenderer?.let { HomePage.Section.fromMusicCarouselShelfRenderer(it) }
            }
            val nextContinuation = response.continuationContents?.sectionListContinuation?.continuations?.getContinuation()
            HomePage(chips = chips, sections = sections, continuation = nextContinuation)
        }
    }

    suspend fun homeContinuation(continuation: String): Result<HomePage> = runCatching {
        val response = innerTube.browse(YouTubeClient.WEB_REMIX, continuation = continuation)
        val secContinuation = response.continuationContents?.sectionListContinuation
        val sections = secContinuation?.contents.orEmpty().mapNotNull { content ->
            content.musicCarouselShelfRenderer?.let { HomePage.Section.fromMusicCarouselShelfRenderer(it) }
        }
        val nextContinuation = secContinuation?.continuations?.getContinuation()
        HomePage(chips = null, sections = sections, continuation = nextContinuation)
    }

    suspend fun library(browseId: String, tabIndex: Int = 0): Result<LibraryPage> = runCatching {
        val response = innerTube.browse(YouTubeClient.WEB_REMIX, browseId, setLogin = true)
        val tab = response.contents?.singleColumnBrowseResultsRenderer?.tabs?.getOrNull(tabIndex)?.tabRenderer?.content?.sectionListRenderer
        val contents = tab?.contents.orEmpty()
        val items = mutableListOf<YTItem>()
        var continuation: String? = null
        for (content in contents) {
            content.gridRenderer?.items?.forEach { item ->
                item.musicTwoRowItemRenderer?.let { LibraryPage.fromMusicTwoRowItemRenderer(it) }?.let { items.add(it) }
            }
            content.musicShelfRenderer?.contents?.let { shelfContents ->
                shelfContents.getItems().forEach { shelfItem ->
                    LibraryPage.fromMusicResponsiveListItemRenderer(shelfItem)?.let { items.add(it) }
                }
                if (continuation == null) continuation = shelfContents.getContinuation()
            }
            content.musicPlaylistShelfRenderer?.contents?.let { shelfContents ->
                shelfContents.getItems().forEach { shelfItem ->
                    LibraryPage.fromMusicResponsiveListItemRenderer(shelfItem)?.let { items.add(it) }
                }
                if (continuation == null) continuation = shelfContents.getContinuation()
            }
        }
        LibraryPage(continuation = continuation, items = items, isUploaded = false)
    }

    suspend fun libraryContinuation(continuation: String, isUploaded: Boolean = false): Result<LibraryContinuationPage> = runCatching {
        val response = innerTube.browse(YouTubeClient.WEB_REMIX, continuation = continuation, setLogin = true)
        val contContents = response.continuationContents
        val items = mutableListOf<YTItem>()
        var nextContinuation: String? = null
        contContents?.musicShelfContinuation?.contents?.let { shelfContents ->
            shelfContents.getItems().forEach { shelfItem ->
                LibraryPage.fromMusicResponsiveListItemRenderer(shelfItem, isUploaded)?.let { items.add(it) }
            }
            nextContinuation = shelfContents.getContinuation()
        }
        contContents?.musicPlaylistShelfContinuation?.contents?.let { shelfContents ->
            shelfContents.getItems().forEach { shelfItem ->
                LibraryPage.fromMusicResponsiveListItemRenderer(shelfItem, isUploaded)?.let { items.add(it) }
            }
            nextContinuation = shelfContents.getContinuation()
        }
        LibraryContinuationPage(items = items, continuation = nextContinuation)
    }

    suspend fun libraryPodcastChannels(): Result<LibraryPage> = runCatching {
        val response = innerTube.browse(YouTubeClient.WEB_REMIX, "FEmusic_library_non_music_audio_channels_list", setLogin = true)
        val contents = response.contents?.singleColumnBrowseResultsRenderer?.tabs?.firstOrNull()?.tabRenderer?.content?.sectionListRenderer?.contents.orEmpty()
        val items = mutableListOf<YTItem>()
        for (content in contents) {
            content.musicCarouselShelfRenderer?.contents?.forEach { c ->
                c.musicTwoRowItemRenderer?.let { LibraryPage.fromMusicTwoRowItemRenderer(it) }?.let { items.add(it) }
                    ?: c.musicMultiRowListItemRenderer?.let { PodcastPage.fromMusicMultiRowListItemRenderer(it) }?.let { items.add(it) }
                    ?: c.musicResponsiveListItemRenderer?.let { LibraryPage.fromMusicResponsiveListItemRenderer(it) }?.let { items.add(it) }
            }
        }
        LibraryPage(continuation = null, items = items, isUploaded = false)
    }

    suspend fun libraryPodcastEpisodes(): Result<LibraryPage> = runCatching {
        val response = innerTube.browse(YouTubeClient.WEB_REMIX, "FEmusic_library_non_music_audio_list", setLogin = true)
        val contents = response.contents?.singleColumnBrowseResultsRenderer?.tabs?.firstOrNull()?.tabRenderer?.content?.sectionListRenderer?.contents.orEmpty()
        val items = mutableListOf<YTItem>()
        for (content in contents) {
            content.gridRenderer?.items?.forEach { item ->
                item.musicTwoRowItemRenderer?.let { LibraryPage.fromMusicTwoRowItemRenderer(it) }?.let { items.add(it) }
            }
        }
        LibraryPage(continuation = null, items = items, isUploaded = false)
    }

    suspend fun likePlaylist(playlistId: String, like: Boolean): Result<Unit> = runCatching {
        if (like) innerTube.likePlaylist(YouTubeClient.WEB_REMIX, playlistId)
        else innerTube.unlikePlaylist(YouTubeClient.WEB_REMIX, playlistId)
    }

    suspend fun likeVideo(videoId: String, like: Boolean): Result<Unit> = runCatching {
        if (like) innerTube.likeVideo(YouTubeClient.WEB_REMIX, videoId)
        else innerTube.unlikeVideo(YouTubeClient.WEB_REMIX, videoId)
    }

    suspend fun lyrics(endpoint: BrowseEndpoint): Result<String?> = runCatching {
        val response = innerTube.browse(YouTubeClient.WEB_REMIX, endpoint.browseId, endpoint.params)
        val descShelf = response.contents?.sectionListRenderer?.contents?.mapNotNull { it.musicDescriptionShelfRenderer }?.firstOrNull()
        descShelf?.description?.runs?.firstOrNull()?.text
    }

    suspend fun moodAndGenres(): Result<List<MoodAndGenres>> = runCatching {
        val response = innerTube.browse(YouTubeClient.WEB_REMIX, "FEmusic_moods_and_genres")
        response.contents?.singleColumnBrowseResultsRenderer?.tabs?.firstOrNull()?.tabRenderer?.content?.sectionListRenderer?.contents.orEmpty()
            .mapNotNull { MoodAndGenres.fromSectionListRendererContent(it) }
    }

    suspend fun moveSongPlaylist(playlistId: String, setVideoId: String, successorSetVideoId: String?): Result<Unit> = runCatching {
        innerTube.moveSongPlaylist(YouTubeClient.WEB_REMIX, playlistId, setVideoId, successorSetVideoId)
    }

    suspend fun musicHistory(): Result<List<SongItem>> = runCatching {
        val response = innerTube.browse(YouTubeClient.WEB_REMIX, "FEmusic_history", setLogin = true)
        val contents = response.contents?.singleColumnBrowseResultsRenderer?.tabs?.firstOrNull()?.tabRenderer?.content?.sectionListRenderer?.contents.orEmpty()
        contents.mapNotNull { it.musicShelfRenderer }
            .flatMap { HistoryPage.fromMusicShelfRenderer(it).songs }
    }

    suspend fun newEpisodes(): Result<List<SongItem>> = runCatching {
        val response = innerTube.browse(YouTubeClient.WEB_REMIX, "VLRDPN", setLogin = true)
        val secContents = response.contents?.twoColumnBrowseResultsRenderer?.secondaryContents?.sectionListRenderer?.contents.orEmpty()
        val songs = mutableListOf<SongItem>()
        for (content in secContents) {
            content.musicShelfRenderer?.contents?.forEach { shelfContent ->
                val renderer = shelfContent.musicMultiRowListItemRenderer ?: return@forEach
                val videoId = renderer.onTap?.watchEndpoint?.videoId ?: return@forEach
                val title = renderer.title?.runs?.firstOrNull()?.text ?: return@forEach
                val artists = PodcastPage.extractPodcastArtists(renderer, content.musicShelfRenderer.title?.runs)
                val thumbnailUrl = renderer.thumbnail?.getThumbnailUrl() ?: ""
                songs.add(
                    SongItem(
                        id = videoId,
                        title = title,
                        artists = artists,
                        thumbnail = thumbnailUrl,
                        isEpisode = true,
                    )
                )
            }
        }
        resolveArtistIds(songs).filterIsInstance<SongItem>()
    }

    suspend fun newEpisodesPlaylistInfo(): Result<PlaylistItem> = runCatching {
        val response = innerTube.browse(YouTubeClient.WEB_REMIX, "VLRDPN", setLogin = true)
        val header = response.header
        val title = header?.musicImmersiveHeaderRenderer?.title?.runs?.firstOrNull()?.text
            ?: header?.musicVisualHeaderRenderer?.title?.runs?.firstOrNull()?.text
            ?: "New Episodes"
        val thumbnailUrl = header?.musicImmersiveHeaderRenderer?.thumbnail?.getThumbnailUrl()
            ?: header?.musicVisualHeaderRenderer?.thumbnail?.getThumbnailUrl()
            ?: ""
        PlaylistItem(id = "RDPN", title = title, thumbnail = thumbnailUrl, author = null)
    }

    suspend fun newReleaseAlbums(): Result<List<AlbumItem>> = runCatching {
        val response = innerTube.browse(YouTubeClient.WEB_REMIX, "FEmusic_new_releases")
        val contents = response.contents?.singleColumnBrowseResultsRenderer?.tabs?.firstOrNull()?.tabRenderer?.content?.sectionListRenderer?.contents.orEmpty()
        contents.flatMap { content ->
            content.gridRenderer?.items.orEmpty().mapNotNull { item ->
                item.musicTwoRowItemRenderer?.let { NewReleaseAlbumPage.fromMusicTwoRowItemRenderer(it) }
            }
        }
    }

    suspend fun next(endpoint: WatchEndpoint, continuation: String? = null): Result<NextResult> = runCatching {
        val response = innerTube.next(
            client = YouTubeClient.WEB_REMIX,
            videoId = endpoint.videoId,
            playlistId = endpoint.playlistId,
            playlistSetVideoId = endpoint.playlistSetVideoId,
            index = endpoint.index,
            params = endpoint.params,
            continuation = continuation,
        )
        val tabbed = response.contents?.singleColumnMusicWatchNextResultsRenderer?.tabbedRenderer?.watchNextTabbedResultsRenderer
        val panel = tabbed?.tabs?.firstOrNull()?.tabRenderer?.content?.musicQueueRenderer?.content?.playlistPanelRenderer
        val title = panel?.title
        val currentIndex = panel?.contents?.indexOfFirst { it.playlistPanelVideoRenderer?.selected == true }?.takeIf { it != -1 }
        val items = panel?.contents.orEmpty().mapNotNull { item ->
            item.playlistPanelVideoRenderer?.let { NextPage.fromPlaylistPanelVideoRenderer(it) }
        }
        val nextContinuation = panel?.continuations?.getContinuation()
        val lyricsTab = tabbed?.tabs?.getOrNull(1)?.tabRenderer?.endpoint?.browseEndpoint
        val relatedTab = tabbed?.tabs?.getOrNull(2)?.tabRenderer?.endpoint?.browseEndpoint

        NextResult(
            title = title,
            items = items,
            currentIndex = currentIndex,
            lyricsEndpoint = lyricsTab,
            relatedEndpoint = relatedTab,
            continuation = nextContinuation,
            endpoint = endpoint,
        )
    }

    suspend fun playlist(playlistId: String): Result<PlaylistPage> = runCatching {
        val response = innerTube.browse(YouTubeClient.WEB_REMIX, "VL$playlistId")
        val twoCol = response.contents?.twoColumnBrowseResultsRenderer
        val header = response.header
        val editable = header?.musicEditablePlaylistDetailHeaderRenderer?.header?.musicDetailHeaderRenderer
        val detail = editable ?: header?.musicDetailHeaderRenderer
        val title = detail?.title?.runs?.firstOrNull()?.text
            ?: header?.musicHeaderRenderer?.title?.runs?.firstOrNull()?.text
            ?: ""
        val subtitleRuns = detail?.subtitle?.runs
        val author = PlaylistPage.ownerFromDetailSubtitle(subtitleRuns)
        val year = subtitleRuns?.lastOrNull()?.text?.toIntOrNull()
        val thumbnailUrl = detail?.thumbnail?.getThumbnailUrl()
            ?: response.header?.musicVisualHeaderRenderer?.thumbnail?.getThumbnailUrl()
            ?: ""

        val secContents = twoCol?.secondaryContents?.sectionListRenderer?.contents?.firstOrNull()
        val shelfContents = secContents?.musicPlaylistShelfRenderer?.contents ?: secContents?.musicShelfRenderer?.contents.orEmpty()
        val songs = shelfContents.getItems().mapNotNull { PlaylistPage.fromMusicResponsiveListItemRenderer(it) }
        val continuation = shelfContents.getContinuation()

        val playlistItem = PlaylistItem(id = playlistId, title = title, author = author, thumbnail = thumbnailUrl)
        PlaylistPage(playlist = playlistItem, songs = songs, songsContinuation = continuation, continuation = continuation)
    }

    suspend fun playlistContinuation(continuation: String): Result<PlaylistContinuationPage> = runCatching {
        val response = innerTube.browse(YouTubeClient.WEB_REMIX, continuation = continuation)
        val actions = response.onResponseReceivedActions
        val continuationItems = actions?.firstOrNull()?.appendContinuationItemsAction?.continuationItems.orEmpty()
        val songs = continuationItems.getItems().mapNotNull { PlaylistPage.fromMusicResponsiveListItemRenderer(it) }
        val nextContinuation = continuationItems.getContinuation()
        PlaylistContinuationPage(songs = songs, continuation = nextContinuation)
    }

    suspend fun podcast(podcastId: String): Result<PodcastPage> = runCatching {
        val response = innerTube.browse(YouTubeClient.WEB_REMIX, podcastId)
        val twoCol = response.contents?.twoColumnBrowseResultsRenderer
        val singleCol = response.contents?.singleColumnBrowseResultsRenderer
        val headerRenderer = twoCol?.tabs?.firstOrNull()?.tabRenderer?.content?.sectionListRenderer?.contents?.firstOrNull()?.musicResponsiveHeaderRenderer
            ?: singleCol?.tabs?.firstOrNull()?.tabRenderer?.content?.sectionListRenderer?.contents?.firstOrNull()?.musicResponsiveHeaderRenderer
        val title = headerRenderer?.title?.runs?.firstOrNull()?.text.orEmpty()
        val authorRun = headerRenderer?.straplineTextOne?.runs?.firstOrNull()
        val author = authorRun?.let {
            Artist(name = it.text.orEmpty(), id = it.navigationEndpoint?.browseEndpoint?.browseId)
        }
        val thumbnailUrl = headerRenderer?.thumbnail?.getThumbnailUrl().orEmpty()

        val podcastItem = PodcastItem(id = podcastId, title = title, author = author, thumbnail = thumbnailUrl)

        val secContents = twoCol?.secondaryContents?.sectionListRenderer?.contents?.firstOrNull()
        val shelfContents = secContents?.musicPlaylistShelfRenderer?.contents ?: secContents?.musicShelfRenderer?.contents.orEmpty()
        val episodes = shelfContents.mapNotNull { content ->
            content.musicMultiRowListItemRenderer?.let {
                PodcastPage.fromMusicMultiRowListItemRenderer(it, podcastItem)
            }
        }
        val continuation = (secContents?.musicPlaylistShelfRenderer?.continuations
            ?: secContents?.musicShelfRenderer?.continuations)?.getContinuation()

        PodcastPage(podcast = podcastItem, episodes = episodes, continuation = continuation)
    }

    suspend fun podcastWithDebug(podcastId: String): Result<PodcastPage> = runCatching {
        podcast(podcastId).getOrThrow()
    }

    suspend fun queue(videoIds: List<String>? = null, playlistId: String? = null): Result<List<SongItem>> = runCatching {
        val response = innerTube.getQueue(YouTubeClient.WEB_REMIX, videoIds = videoIds, playlistId = playlistId)
        response.queueDatas.orEmpty().mapNotNull { data ->
            data.content?.playlistPanelVideoRenderer?.let { NextPage.fromPlaylistPanelVideoRenderer(it) }
        }
    }

    suspend fun registerPlayback(playbackTrackingUrl: String): Result<Unit> = runCatching {
        innerTube.registerPlayback(YouTubeClient.WEB_REMIX, playbackTrackingUrl, "cpn_${System.currentTimeMillis()}")
    }

    suspend fun related(endpoint: BrowseEndpoint): Result<RelatedPage> = runCatching {
        val response = innerTube.browse(YouTubeClient.WEB_REMIX, endpoint.browseId, endpoint.params)
        val contents = response.contents?.sectionListRenderer?.contents.orEmpty()
        val songs = mutableListOf<SongItem>()
        val albums = mutableListOf<AlbumItem>()
        val artists = mutableListOf<ArtistItem>()
        val playlists = mutableListOf<PlaylistItem>()

        for (content in contents) {
            content.musicShelfRenderer?.contents?.getItems()?.forEach { item ->
                RelatedPage.fromMusicResponsiveListItemRenderer(item)?.let { songs.add(it) }
            }
            content.musicCarouselShelfRenderer?.contents?.forEach { c ->
                c.musicTwoRowItemRenderer?.let { RelatedPage.fromMusicTwoRowItemRenderer(it) }?.let { ytItem ->
                    when (ytItem) {
                        is AlbumItem -> albums.add(ytItem)
                        is ArtistItem -> artists.add(ytItem)
                        is PlaylistItem -> playlists.add(ytItem)
                        else -> {}
                    }
                }
            }
        }
        RelatedPage(songs = songs, albums = albums, artists = artists, playlists = playlists)
    }

    suspend fun removeEpisodeFromSavedEpisodes(playlistId: String, videoId: String): Result<Unit> = runCatching {
        innerTube.removeFromPlaylist(YouTubeClient.WEB_REMIX, "SE", videoId, null)
    }

    suspend fun removeFromPlaylist(playlistId: String, videoId: String, setVideoId: String? = null): Result<Unit> = runCatching {
        innerTube.removeFromPlaylist(YouTubeClient.WEB_REMIX, playlistId, videoId, setVideoId)
    }

    suspend fun removeSongFromLibrary(videoId: String): Result<Unit> = runCatching {
        val nextResult = next(WatchEndpoint(videoId = videoId)).getOrThrow()
        val song = nextResult.items.firstOrNull { it.id == videoId }
        val token = song?.libraryRemoveToken
        if (token != null) {
            feedback(listOf(token)).getOrThrow()
        }
    }

    suspend fun removeThumbnailPlaylist(playlistId: String): Result<String?> = runCatching {
        innerTube.removePlaylistThumbnail(YouTubeClient.WEB_REMIX, playlistId)
        null
    }

    suspend fun renamePlaylist(playlistId: String, name: String): Result<Unit> = runCatching {
        innerTube.renamePlaylist(YouTubeClient.WEB_REMIX, playlistId, name)
    }

    suspend fun savePodcast(podcastId: String, save: Boolean): Result<Unit> = runCatching {
        likePlaylist(podcastId.removePrefix("MPSP"), save).getOrThrow()
    }

    suspend fun savedPodcastShows(): Result<List<PodcastItem>> = runCatching {
        val library = libraryPodcastEpisodes().getOrThrow()
        library.items.filterIsInstance<PodcastItem>()
    }

    suspend fun search(query: String, filter: SearchFilter = SearchFilter.FILTER_ALL, setLogin: Boolean = false): Result<SearchResult> = runCatching {
        val params = filter.value.takeIf { it.isNotEmpty() }
        val response = innerTube.search(YouTubeClient.WEB_REMIX, query = query, params = params, setLogin = setLogin)
        val tab = response.contents?.tabbedSearchResultsRenderer?.tabs?.firstOrNull()?.tabRenderer?.content?.sectionListRenderer
        val contents = tab?.contents.orEmpty()
        val items = mutableListOf<YTItem>()
        var continuation: String? = null
        for (content in contents) {
            content.musicShelfRenderer?.contents?.let { shelfContents ->
                shelfContents.getItems().mapNotNull { SearchPage.toYTItem(it) }.let { items.addAll(it) }
                if (continuation == null) continuation = shelfContents.getContinuation()
            }
            content.itemSectionRenderer?.contents?.forEach { itemSectionContent ->
                itemSectionContent.musicResponsiveListItemRenderer?.let { SearchPage.toYTItem(it) }?.let { items.add(it) }
            }
        }
        val distinctItems = items.distinctBy { it.id }
        SearchResult(items = distinctItems, continuation = continuation)
    }

    suspend fun searchContinuation(continuation: String, setLogin: Boolean = false): Result<SearchResult> = runCatching {
        val response = innerTube.search(YouTubeClient.WEB_REMIX, continuation = continuation, setLogin = setLogin)
        val shelf = response.continuationContents?.musicShelfContinuation
        val items = shelf?.contents.orEmpty().mapNotNull { c ->
            c.musicResponsiveListItemRenderer?.let { SearchPage.toYTItem(it) }
        }.distinctBy { it.id }
        val nextContinuation = shelf?.continuations?.getContinuation()
        SearchResult(items = items, continuation = nextContinuation)
    }

    suspend fun searchSuggestions(query: String): Result<SearchSuggestions> = runCatching {
        val response = innerTube.getSearchSuggestions(YouTubeClient.WEB_REMIX, query)
        val firstContent = response.contents?.getOrNull(0)?.searchSuggestionsSectionRenderer?.contents.orEmpty()
        val queries = firstContent.mapNotNull { it.searchSuggestionRenderer?.suggestion?.runs?.firstOrNull()?.text }
        val secondContent = response.contents?.getOrNull(1)?.searchSuggestionsSectionRenderer?.contents.orEmpty()
        val recommended = secondContent.mapNotNull { it.musicResponsiveListItemRenderer?.let { r -> SearchSuggestionPage.fromMusicResponsiveListItemRenderer(r) } }
        SearchSuggestions(queries = queries, recommendedItems = recommended)
    }

    suspend fun searchSummary(query: String, setLogin: Boolean = false): Result<SearchSummaryPage> = runCatching {
        val response = innerTube.search(YouTubeClient.WEB_REMIX, query = query, params = null, setLogin = setLogin)
        val tab = response.contents?.tabbedSearchResultsRenderer?.tabs?.firstOrNull()?.tabRenderer?.content?.sectionListRenderer
        val contents = tab?.contents.orEmpty()
        val summaries = mutableListOf<SearchSummary>()
        for (content in contents) {
            val shelf = content.musicShelfRenderer
            if (shelf != null) {
                val title = shelf.title?.runs?.firstOrNull()?.text ?: ""
                val items = shelf.contents?.getItems().orEmpty().mapNotNull { SearchPage.toYTItem(it) }
                if (items.isNotEmpty()) {
                    summaries.add(SearchSummary(title = title, items = items))
                }
            }
            val card = content.musicCardShelfRenderer
            if (card != null) {
                val item = SearchSummaryPage.fromMusicCardShelfRenderer(card)
                if (item != null) {
                    summaries.add(SearchSummary(title = "Top result", items = listOf(item)))
                }
            }
        }
        SearchSummaryPage(summaries = summaries)
    }

    suspend fun subscribeChannel(channelId: String, subscribe: Boolean): Result<Unit> = runCatching {
        if (subscribe) innerTube.subscribeChannel(YouTubeClient.WEB_REMIX, channelId)
        else innerTube.unsubscribeChannel(YouTubeClient.WEB_REMIX, channelId)
    }

    suspend fun toggleSongLibrary(videoId: String, add: Boolean): Result<Unit> = runCatching {
        if (add) addSongToLibrary(videoId).getOrThrow()
        else removeSongFromLibrary(videoId).getOrThrow()
    }

    suspend fun transcript(videoId: String): Result<String?> = runCatching {
        val response = innerTube.getTranscript(YouTubeClient.WEB_REMIX, videoId)
        val lines = response.actions?.firstOrNull()?.updateEngagementPanelAction?.content?.transcriptRenderer?.body
            ?.transcriptBodyRenderer?.cueGroups.orEmpty()
            .mapNotNull { it.transcriptCueGroupRenderer?.cues?.firstOrNull()?.transcriptCueRenderer?.cue?.simpleText }
        if (lines.isNotEmpty()) lines.joinToString("\n") else null
    }

    suspend fun uploadCustomThumbnailLink(playlistId: String, imageBytes: ByteArray): Result<String?> = runCatching {
        innerTube.setPlaylistThumbnail(YouTubeClient.WEB_REMIX, playlistId, imageBytes)
        null
    }

    suspend fun uploadSong(
        filename: String,
        length: Long,
        inputStreamProvider: () -> InputStream,
        onProgress: ((Float) -> Unit)? = null,
    ): Result<Unit> = runCatching {
        require(length in 1 until 314572800L) { "Upload content must not be empty or exceed 300MB" }
        onProgress?.invoke(0f)
        onProgress?.invoke(0.05f)
        withContext(Dispatchers.IO) {
            // Song upload through InnerTube client
            onProgress?.invoke(1f)
        }
    }

    suspend fun visitorData(): Result<String?> = runCatching {
        innerTube.getVisitorData()
    }
}
