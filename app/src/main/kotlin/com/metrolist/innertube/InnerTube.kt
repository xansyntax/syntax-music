package com.metrolist.innertube

import com.metrolist.innertube.models.ReturnYouTubeDislikeResponse
import com.metrolist.innertube.models.response.AccountMenuResponse
import com.metrolist.innertube.models.response.BrowseResponse
import com.metrolist.innertube.models.response.CreatePlaylistResponse
import com.metrolist.innertube.models.response.EditPlaylistResponse
import com.metrolist.innertube.models.response.FeedbackResponse
import com.metrolist.innertube.models.response.GetQueueResponse
import com.metrolist.innertube.models.response.GetSearchSuggestionsResponse
import com.metrolist.innertube.models.response.GetTranscriptResponse
import com.metrolist.innertube.models.response.NextResponse
import com.metrolist.innertube.models.response.SearchResponse
import com.metrolist.innertubex.InnerTubeHttpException
import com.metrolist.innertubex.models.YouTubeClient
import com.metrolist.innertubex.models.YouTubeLocale
import com.metrolist.innertubex.models.body.AccountMenuBody
import com.metrolist.innertubex.models.body.AccountsListBody
import com.metrolist.innertubex.models.body.BrowseBody
import com.metrolist.innertubex.models.body.CreatePlaylistBody
import com.metrolist.innertubex.models.body.DeletePrivatelyOwnedEntityBody
import com.metrolist.innertubex.models.body.EditPlaylistBody
import com.metrolist.innertubex.models.body.FeedbackBody
import com.metrolist.innertubex.models.body.GetQueueBody
import com.metrolist.innertubex.models.body.GetSearchSuggestionsBody
import com.metrolist.innertubex.models.body.GetTranscriptBody
import com.metrolist.innertubex.models.body.LikeBody
import com.metrolist.innertubex.models.body.NextBody
import com.metrolist.innertubex.models.body.PlaylistDeleteBody
import com.metrolist.innertubex.models.body.SearchBody
import com.metrolist.innertubex.models.body.SubscribeBody
import com.metrolist.innertubex.models.response.ImageUploadResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.compression.ContentEncoding
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.net.Proxy
import java.security.MessageDigest
import java.util.Locale

class InnerTube {
    var locale: YouTubeLocale = YouTubeLocale(
        gl = Locale.getDefault().country.ifEmpty { "US" },
        hl = Locale.getDefault().toLanguageTag().ifEmpty { "en" },
    )
    var visitorData: String? = null
    var dataSyncId: String? = null
    var cookie: String? = null
        set(value) {
            field = value
            cookieMap = parseCookieString(value)
        }
    var authUser: String? = null
    var proxy: Proxy? = null
        set(value) {
            field = value
            recreateTransport()
        }
    var proxyAuth: String? = null
        set(value) {
            field = value
            recreateTransport()
        }
    var useLoginForBrowse: Boolean = false

    private var cookieMap: Map<String, String> = emptyMap()

    val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
        explicitNulls = false
    }

    @Volatile
    private var httpClient: HttpClient = buildHttpClient()

    private fun buildHttpClient(): HttpClient = HttpClient(OkHttp) {
        expectSuccess = false
        install(ContentNegotiation) { json(json) }
        install(ContentEncoding) {
            gzip()
            deflate()
        }
        engine {
            proxy?.let { this.proxy = it }
            config {
                proxyAuth?.let { auth ->
                    proxyAuthenticator { _, response ->
                        response.request.newBuilder()
                            .header("Proxy-Authorization", auth)
                            .build()
                    }
                }
            }
        }
        defaultRequest {
            url("https://music.youtube.com/youtubei/v1/")
        }
    }

    @Synchronized
    fun recreateTransport() {
        runCatching { httpClient.close() }
        httpClient = buildHttpClient()
    }

    private fun parseCookieString(raw: String?): Map<String, String> {
        if (raw.isNullOrBlank()) return emptyMap()
        return raw.split(";")
            .mapNotNull { part ->
                val idx = part.indexOf("=")
                if (idx <= 0) null
                else part.substring(0, idx).trim() to part.substring(idx + 1).trim()
            }
            .toMap()
    }

    private fun sha1(input: String): String =
        MessageDigest.getInstance("SHA-1")
            .digest(input.toByteArray(Charsets.UTF_8))
            .joinToString("") { "%02x".format(it) }

    private fun HttpRequestBuilder.ytClient(client: YouTubeClient, setLogin: Boolean = false) {
        contentType(ContentType.Application.Json)
        header(HttpHeaders.UserAgent, client.userAgent)
        header("X-Goog-Api-Format-Version", "1")
        header("X-YouTube-Client-Name", client.clientId)
        header("X-YouTube-Client-Version", client.clientVersion)
        header("X-Origin", YouTubeClient.ORIGIN_YOUTUBE_MUSIC)
        header(HttpHeaders.Referrer, YouTubeClient.REFERER_YOUTUBE_MUSIC)
        visitorData?.let { header("X-Goog-Visitor-Id", it) }

        if (setLogin && client.loginSupported && !cookie.isNullOrBlank()) {
            header(HttpHeaders.Cookie, cookie!!)
            authUser?.let { header("X-Goog-AuthUser", it) }
            dataSyncId?.let { header("X-Goog-PageId", it.substringBefore("||")) }
            val sapisid = cookieMap["SAPISID"] ?: cookieMap["__Secure-3PAPISID"]
            if (!sapisid.isNullOrBlank()) {
                val timestamp = System.currentTimeMillis() / 1000L
                val hash = sha1("$timestamp $sapisid ${YouTubeClient.ORIGIN_YOUTUBE_MUSIC}")
                header(HttpHeaders.Authorization, "SAPISIDHASH ${timestamp}_$hash")
            }
        }
    }

    suspend fun requireSuccess(response: HttpResponse, operation: String): HttpResponse {
        if (!response.status.isSuccess()) {
            throw InnerTubeHttpException(operation, response.status)
        }
        return response
    }

    suspend fun search(
        client: YouTubeClient,
        query: String? = null,
        params: String? = null,
        continuation: String? = null,
        setLogin: Boolean = useLoginForBrowse,
    ): SearchResponse = requireSuccess(
        httpClient.post("search") {
            ytClient(client, setLogin)
            parameter("prettyPrint", false)
            continuation?.let { parameter("continuation", it) }
            setBody(SearchBody(context = client.toContext(locale, visitorData, dataSyncId), query = query, params = params))
        },
        "search",
    ).body()

    suspend fun browse(
        client: YouTubeClient,
        browseId: String? = null,
        params: String? = null,
        continuation: String? = null,
        setLogin: Boolean = useLoginForBrowse,
    ): BrowseResponse = requireSuccess(
        httpClient.post("browse") {
            ytClient(client, setLogin)
            parameter("prettyPrint", false)
            continuation?.let { parameter("continuation", it) }
            setBody(BrowseBody(context = client.toContext(locale, visitorData, dataSyncId), browseId = browseId, params = params))
        },
        "browse",
    ).body()

    suspend fun next(
        client: YouTubeClient,
        videoId: String? = null,
        playlistId: String? = null,
        playlistSetVideoId: String? = null,
        index: Int? = null,
        params: String? = null,
        continuation: String? = null,
    ): NextResponse = requireSuccess(
        httpClient.post("next") {
            ytClient(client, setLogin = true)
            parameter("prettyPrint", false)
            setBody(
                NextBody(
                    context = client.toContext(locale, visitorData, dataSyncId),
                    videoId = videoId,
                    playlistId = playlistId,
                    playlistSetVideoId = playlistSetVideoId,
                    index = index,
                    params = params,
                    continuation = continuation,
                ),
            )
        },
        "next",
    ).body()

    suspend fun getSearchSuggestions(
        client: YouTubeClient,
        input: String,
    ): GetSearchSuggestionsResponse = requireSuccess(
        httpClient.post("music/get_search_suggestions") {
            ytClient(client, setLogin = true)
            parameter("prettyPrint", false)
            setBody(GetSearchSuggestionsBody(context = client.toContext(locale, visitorData, dataSyncId), input = input))
        },
        "getSearchSuggestions",
    ).body()

    suspend fun getQueue(
        client: YouTubeClient,
        videoIds: List<String>? = null,
        playlistId: String? = null,
    ): GetQueueResponse = requireSuccess(
        httpClient.post("music/get_queue") {
            ytClient(client, setLogin = true)
            parameter("prettyPrint", false)
            setBody(GetQueueBody(context = client.toContext(locale, visitorData, dataSyncId), videoIds = videoIds, playlistId = playlistId))
        },
        "getQueue",
    ).body()

    suspend fun getTranscript(
        client: YouTubeClient,
        params: String,
    ): GetTranscriptResponse = requireSuccess(
        httpClient.post("https://www.youtube.com/youtubei/v1/get_transcript") {
            ytClient(client, setLogin = false)
            parameter("prettyPrint", false)
            setBody(GetTranscriptBody(context = client.toContext(locale, visitorData, dataSyncId), params = params))
        },
        "getTranscript",
    ).body()

    suspend fun accountMenu(client: YouTubeClient): AccountMenuResponse = requireSuccess(
        httpClient.post("account/account_menu") {
            ytClient(client, setLogin = true)
            parameter("prettyPrint", false)
            setBody(AccountMenuBody(context = client.toContext(locale, visitorData, dataSyncId)))
        },
        "accountMenu",
    ).body()

    suspend fun accountsList(): String = requireSuccess(
        httpClient.post("account/accounts_list") {
            ytClient(YouTubeClient.WEB_REMIX, setLogin = true)
            parameter("prettyPrint", false)
            setBody(AccountsListBody(context = YouTubeClient.WEB_REMIX.toContext(locale, visitorData, dataSyncId)))
        },
        "accountsList",
    ).bodyAsText()

    suspend fun likeVideo(client: YouTubeClient, videoId: String) {
        requireSuccess(
            httpClient.post("like/like") {
                ytClient(client, setLogin = true)
                parameter("prettyPrint", false)
                setBody(LikeBody(context = client.toContext(locale, visitorData, dataSyncId), target = LikeBody.Target(videoId = videoId)))
            },
            "likeVideo",
        )
    }

    suspend fun unlikeVideo(client: YouTubeClient, videoId: String) {
        requireSuccess(
            httpClient.post("like/removelike") {
                ytClient(client, setLogin = true)
                parameter("prettyPrint", false)
                setBody(LikeBody(context = client.toContext(locale, visitorData, dataSyncId), target = LikeBody.Target(videoId = videoId)))
            },
            "unlikeVideo",
        )
    }

    suspend fun likePlaylist(client: YouTubeClient, playlistId: String) {
        requireSuccess(
            httpClient.post("like/like") {
                ytClient(client, setLogin = true)
                parameter("prettyPrint", false)
                setBody(LikeBody(context = client.toContext(locale, visitorData, dataSyncId), target = LikeBody.Target(playlistId = playlistId)))
            },
            "likePlaylist",
        )
    }

    suspend fun unlikePlaylist(client: YouTubeClient, playlistId: String) {
        requireSuccess(
            httpClient.post("like/removelike") {
                ytClient(client, setLogin = true)
                parameter("prettyPrint", false)
                setBody(LikeBody(context = client.toContext(locale, visitorData, dataSyncId), target = LikeBody.Target(playlistId = playlistId)))
            },
            "unlikePlaylist",
        )
    }

    suspend fun subscribeChannel(client: YouTubeClient, channelId: String, params: String? = null) {
        requireSuccess(
            httpClient.post("subscription/subscribe") {
                ytClient(client, setLogin = true)
                parameter("prettyPrint", false)
                setBody(SubscribeBody(context = client.toContext(locale, visitorData, dataSyncId), channelIds = listOf(channelId), params = params))
            },
            "subscribeChannel",
        )
    }

    suspend fun unsubscribeChannel(client: YouTubeClient, channelId: String, params: String? = null) {
        requireSuccess(
            httpClient.post("subscription/unsubscribe") {
                ytClient(client, setLogin = true)
                parameter("prettyPrint", false)
                setBody(SubscribeBody(context = client.toContext(locale, visitorData, dataSyncId), channelIds = listOf(channelId), params = params))
            },
            "unsubscribeChannel",
        )
    }

    suspend fun feedback(client: YouTubeClient, tokens: List<String>): FeedbackResponse = requireSuccess(
        httpClient.post("feedback") {
            ytClient(client, setLogin = true)
            parameter("prettyPrint", false)
            setBody(FeedbackBody(context = client.toContext(locale, visitorData, dataSyncId), feedbackTokens = tokens))
        },
        "feedback",
    ).body()

    suspend fun createPlaylist(client: YouTubeClient, title: String): CreatePlaylistResponse = requireSuccess(
        httpClient.post("playlist/create") {
            ytClient(client, setLogin = true)
            parameter("prettyPrint", false)
            setBody(CreatePlaylistBody(context = client.toContext(locale, visitorData, dataSyncId), title = title))
        },
        "createPlaylist",
    ).body()

    suspend fun renamePlaylist(client: YouTubeClient, playlistId: String, name: String): EditPlaylistResponse = requireSuccess(
        httpClient.post("browse/edit_playlist") {
            ytClient(client, setLogin = true)
            parameter("prettyPrint", false)
            setBody(
                EditPlaylistBody(
                    context = client.toContext(locale, visitorData, dataSyncId),
                    playlistId = playlistId,
                    actions = listOf(EditPlaylistBody.Action.SetPlaylistNameAction(playlistName = name)),
                ),
            )
        },
        "renamePlaylist",
    ).body()

    suspend fun deletePlaylist(client: YouTubeClient, playlistId: String) {
        requireSuccess(
            httpClient.post("playlist/delete") {
                ytClient(client, setLogin = true)
                parameter("prettyPrint", false)
                setBody(PlaylistDeleteBody(context = client.toContext(locale, visitorData, dataSyncId), playlistId = playlistId))
            },
            "deletePlaylist",
        )
    }

    suspend fun addToPlaylist(client: YouTubeClient, playlistId: String, videoId: String): EditPlaylistResponse = requireSuccess(
        httpClient.post("browse/edit_playlist") {
            ytClient(client, setLogin = true)
            parameter("prettyPrint", false)
            setBody(
                EditPlaylistBody(
                    context = client.toContext(locale, visitorData, dataSyncId),
                    playlistId = playlistId,
                    actions = listOf(EditPlaylistBody.Action.AddVideoAction(addedVideoId = videoId)),
                ),
            )
        },
        "addToPlaylist",
    ).body()

    suspend fun removeFromPlaylist(
        client: YouTubeClient,
        playlistId: String,
        videoId: String,
        setVideoId: String? = null,
    ): EditPlaylistResponse = requireSuccess(
        httpClient.post("browse/edit_playlist") {
            ytClient(client, setLogin = true)
            parameter("prettyPrint", false)
            setBody(
                EditPlaylistBody(
                    context = client.toContext(locale, visitorData, dataSyncId),
                    playlistId = playlistId,
                    actions = listOf(EditPlaylistBody.Action.RemoveVideoAction(removedVideoId = videoId, setVideoId = setVideoId)),
                ),
            )
        },
        "removeFromPlaylist",
    ).body()

    suspend fun moveSongPlaylist(
        client: YouTubeClient,
        playlistId: String,
        setVideoId: String,
        successorSetVideoId: String?,
    ): EditPlaylistResponse = requireSuccess(
        httpClient.post("browse/edit_playlist") {
            ytClient(client, setLogin = true)
            parameter("prettyPrint", false)
            setBody(
                EditPlaylistBody(
                    context = client.toContext(locale, visitorData, dataSyncId),
                    playlistId = playlistId,
                    actions = listOf(
                        EditPlaylistBody.Action.MoveVideoAction(
                            movedSetVideoIdPredecessor = successorSetVideoId,
                            setVideoId = setVideoId,
                        ),
                    ),
                ),
            )
        },
        "moveSongPlaylist",
    ).body()

    suspend fun removePlaylistThumbnail(client: YouTubeClient, playlistId: String): EditPlaylistResponse = requireSuccess(
        httpClient.post("browse/edit_playlist") {
            ytClient(client, setLogin = true)
            parameter("prettyPrint", false)
            setBody(
                EditPlaylistBody(
                    context = client.toContext(locale, visitorData, dataSyncId),
                    playlistId = playlistId,
                    actions = listOf(EditPlaylistBody.Action.RemoveCustomThumbnailAction()),
                ),
            )
        },
        "removePlaylistThumbnail",
    ).body()

    suspend fun setPlaylistThumbnail(client: YouTubeClient, playlistId: String, imageBytes: ByteArray): EditPlaylistResponse {
        val uploadResp = requireSuccess(
            httpClient.post("https://music.youtube.com/playlist_image_upload/playlist_custom_thumbnail") {
                ytClient(client, setLogin = true)
                header("X-Goog-Upload-Command", "start, upload, finalize")
                header("X-Goog-Upload-Protocol", "raw")
                contentType(ContentType.Image.JPEG)
                setBody(imageBytes)
            },
            "uploadPlaylistThumbnail",
        ).body<ImageUploadResponse>()

        val blobId = uploadResp.encryptedBlobId ?: throw IllegalStateException("Missing encryptedBlobId")
        return requireSuccess(
            httpClient.post("browse/edit_playlist") {
                ytClient(client, setLogin = true)
                parameter("prettyPrint", false)
                setBody(
                    EditPlaylistBody(
                        context = client.toContext(locale, visitorData, dataSyncId),
                        playlistId = playlistId,
                        actions = listOf(
                            EditPlaylistBody.Action.SetCustomThumbnailAction(
                                addedCustomThumbnail = EditPlaylistBody.Action.SetCustomThumbnailAction.AddedCustomThumbnail(
                                    imageKey = EditPlaylistBody.Action.SetCustomThumbnailAction.AddedCustomThumbnail.ImageKey(
                                        name = blobId,
                                    ),
                                ),
                            ),
                        ),
                    ),
                )
            },
            "setPlaylistThumbnail",
        ).body()
    }

    suspend fun deletePrivatelyOwnedEntity(entityId: String) {
        requireSuccess(
            httpClient.post("music/delete_privately_owned_entity") {
                ytClient(YouTubeClient.WEB_REMIX, setLogin = true)
                parameter("prettyPrint", false)
                setBody(
                    DeletePrivatelyOwnedEntityBody(
                        context = YouTubeClient.WEB_REMIX.toContext(locale, visitorData, dataSyncId),
                        entityId = entityId,
                    ),
                )
            },
            "deletePrivatelyOwnedEntity",
        )
    }

    suspend fun registerPlayback(client: YouTubeClient, url: String, cpn: String) {
        requireSuccess(
            httpClient.get(url) {
                ytClient(client, setLogin = true)
                parameter("ver", "2")
                parameter("c", client.clientName)
                parameter("cpn", cpn)
            },
            "registerPlayback",
        )
    }

    suspend fun getMediaInfo(videoId: String): Result<ReturnYouTubeDislikeResponse> = runCatching {
        requireSuccess(
            httpClient.get("https://returnyoutubedislikeapi.com/votes") {
                parameter("videoId", videoId)
            },
            "getMediaInfo",
        ).body()
    }

    suspend fun getVisitorData(): String {
        val html = httpClient.get("https://music.youtube.com") {
            header(HttpHeaders.UserAgent, YouTubeClient.USER_AGENT_WEB)
        }.bodyAsText()
        return Regex("\"VISITOR_DATA\":\"([^\"]+)\"").find(html)?.groupValues?.getOrNull(1)
            ?: throw IllegalStateException("Visitor data not found")
    }
}
