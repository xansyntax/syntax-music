package com.metrolist.innertubex.extraction

import com.metrolist.innertubex.InnerTube
import com.metrolist.innertubex.InnerTubeLogger
import com.metrolist.innertubex.bodyAsTextLimited
import com.metrolist.innertubex.d
import com.metrolist.innertubex.extraction.strategy.ClientFallbackStrategy
import com.metrolist.innertubex.extraction.strategy.ClientHealthMonitor
import com.metrolist.innertubex.extraction.strategy.ClientHealthScope
import com.metrolist.innertubex.extraction.strategy.ClientPoTokenCapabilities
import com.metrolist.innertubex.extraction.strategy.ClientSelectionRequest
import com.metrolist.innertubex.extraction.strategy.ClientSelectionResult
import com.metrolist.innertubex.extraction.strategy.ContentAwareFallbackStrategy
import com.metrolist.innertubex.extraction.strategy.PlaybackClientCatalog
import com.metrolist.innertubex.extraction.strategy.PlaybackClientManifest
import com.metrolist.innertubex.extraction.strategy.PlaybackTransportPreference
import com.metrolist.innertubex.extraction.strategy.PoTokenProviderKind
import com.metrolist.innertubex.extraction.strategy.PoTokenRequirement
import com.metrolist.innertubex.extraction.strategy.PoTokenRule
import com.metrolist.innertubex.extraction.strategy.SelectedClient
import com.metrolist.innertubex.models.PoTokenBinding
import com.metrolist.innertubex.models.YouTubeClient
import com.metrolist.innertubex.models.response.PlayerResponse
import com.metrolist.innertubex.w
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonObject
import java.io.IOException
import java.util.Locale
import java.util.concurrent.CancellationException
import java.util.concurrent.atomic.AtomicInteger

class PlayerClientDirector(
    val innerTube: InnerTube,
    val fallbackStrategy: ClientFallbackStrategy = ContentAwareFallbackStrategy(),
    val tokenProvider: TokenProvider = UnavailableTokenProvider,
    val healthMonitor: ClientHealthMonitor = ClientHealthMonitor.NONE,
    val logger: InnerTubeLogger = InnerTubeLogger.NONE,
) {
    val maxPlayerRequests: Int = DEFAULT_MAX_PLAYER_REQUESTS
    val json: Json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }
    val usesAutomaticCatalog: Boolean = fallbackStrategy is ContentAwareFallbackStrategy

    class ClientAttempt(
        val response: PlayerResponse,
        val usedPoToken: Boolean,
        val streamingDataPoToken: String?,
    )

    class ClientAttemptResult(
        val attempt: ClientAttempt?,
        val failure: PlayabilityFailure?,
        val requestFailure: Throwable? = null,
        val tokenUnavailable: Boolean = false,
        val tokenFetchUnavailable: Boolean = false,
        val observedResponse: PlayerResponse? = null,
    )

    class TokenPlan(
        val playerBinding: PoTokenBinding?,
        val gvsBinding: PoTokenBinding?,
        val playerRequired: Boolean,
        val gvsRequired: Boolean,
    ) {
        val canMint: Boolean
            get() = playerBinding != null || gvsBinding != null
    }

    class PlayerRequestContext(val budget: Int = DEFAULT_MAX_PLAYER_REQUESTS) {
        init {
            require(budget > 0) { "Player request budget must be positive" }
        }
        val cache = LinkedHashMap<PlayerRequestKey, PlayerResponse>()
        val recorded = LinkedHashSet<PlayerRequestKey>()
        val remainingBudget = AtomicInteger(budget)
        fun getRemaining(): Int = remainingBudget.get()
    }

    companion object {
        val DEFAULT_MAX_PLAYER_REQUESTS: Int = PlaybackClientCatalog.automaticManifests.size * 2
        val N_PARAMETER_REGEX: Regex = Regex("[?&]n=[^&]+")
        val UNSAFE_PROFILE_CHARACTERS: Regex = Regex("[^A-Za-z0-9_.-]")
        val DYNAMIC_WEB_VERSION_CLIENT_NAMES: Set<String> = setOf("WEB", "WEB_EMBEDDED_PLAYER")
        val TRANSPORT_PROBE_CLIENT_NAMES: Set<String> = setOf("IOS_MUSIC", "ANDROID_KIDS", "ANDROID_PRODUCER", "MEDIA_CONNECT_FRONTEND")
        val KNOWN_DRM_KEYS: Set<String> = setOf(
            "contentprotection", "contentprotectionids", "drmfamilies", "drmfamily",
            "drmparameters", "drmparams", "drmtracktype", "fairplay", "licenseinfo",
            "licenseinfos", "licenseurl", "playready", "widevine"
        )

        fun hasDrmValue(jsonElement: JsonElement): Boolean {
            return when (jsonElement) {
                is JsonObject -> jsonElement.isNotEmpty()
                is JsonArray -> jsonElement.any { child ->
                    when (child) {
                        is JsonObject, is JsonArray -> true
                        is JsonPrimitive -> {
                            val content = child.content
                            content.isNotBlank() && content != "false" && content != "0"
                        }
                    }
                }
                is JsonPrimitive -> {
                    val content = jsonElement.content
                    content.isNotBlank() && content != "false" && content != "0"
                }
            }
        }

        fun hasUsableSabrAudio(playerResponse: PlayerResponse): Boolean {
            val streamingData = playerResponse.streamingData ?: return false
            val sabrUrl = streamingData.serverAbrStreamingUrl ?: return false
            if (sabrUrl.isBlank()) return false

            val ustreamerConfig = playerResponse.playerConfig?.mediaCommonConfig?.mediaUstreamerRequestConfig?.videoPlaybackUstreamerConfig
            if (ustreamerConfig.isNullOrBlank()) return false

            val adaptiveFormats = streamingData.adaptiveFormats ?: return false
            return adaptiveFormats.any { it.isAudio() && it.itag > 0 }
        }

        fun isPlayable(playerResponse: PlayerResponse, client: YouTubeClient): Boolean {
            val status = playerResponse.playabilityStatus?.status
            if (status == "OK" || client.skipPlayerResponseValidation) {
                if (client.useSabr) {
                    return hasUsableSabrAudio(playerResponse)
                }
                val streamingData = playerResponse.streamingData
                if (streamingData != null) {
                    val allFormats = (streamingData.adaptiveFormats.orEmpty()) + (streamingData.formats.orEmpty())
                    if (allFormats.isEmpty()) {
                        val hls = streamingData.hlsManifestUrl
                        return !hls.isNullOrBlank()
                    }
                    val hasAudio = allFormats.any { format ->
                        format.isAudio() && (!format.url.isNullOrBlank() || !format.signatureCipher.isNullOrBlank() || !format.cipher.isNullOrBlank())
                    }
                    if (hasAudio) return true
                    val hls = streamingData.hlsManifestUrl
                    return !hls.isNullOrBlank()
                }
            }
            return false
        }

        fun isSatisfiedByPremium(rule: PoTokenRule, authenticated: Boolean): Boolean {
            if (rule.requirement == PoTokenRequirement.REQUIRED) {
                return authenticated && rule.premiumMayBypass
            }
            return true
        }

        fun knownDrmValue(jsonObject: JsonObject, key: String): JsonElement? {
            for ((entryKey, entryValue) in jsonObject) {
                if (entryKey.lowercase(Locale.ROOT) == key) {
                    return entryValue
                }
            }
            return null
        }

        fun legacyProfileId(client: YouTubeClient, hasPo: Boolean): String {
            val sb = StringBuilder()
            sb.append(client.clientName)
            sb.append('_')
            sb.append(client.friendlyName ?: client.clientVersion)
            if (client.isEmbedded) {
                sb.append("_embedded")
            }
            val sanitized = UNSAFE_PROFILE_CHARACTERS.replace(sb.toString(), "_")
            val suffix = if (hasPo) "po" else "nopo"
            return "${sanitized}_$suffix"
        }

        fun profileId(selectedClient: SelectedClient, hasPo: Boolean): String {
            val manifest = selectedClient.manifest
            return if (manifest != null) {
                val suffix = if (hasPo) "po" else "nopo"
                "${manifest.id}__$suffix"
            } else {
                legacyProfileId(selectedClient.client, hasPo)
            }
        }

        fun profileIds(selectedClient: SelectedClient, hasPo: Boolean): Set<String> {
            val manifest = selectedClient.manifest
            return if (manifest == null) {
                setOf(legacyProfileId(selectedClient.client, hasPo))
            } else {
                PlaybackClientCatalog.profileIds(manifest, hasPo)
            }
        }

        fun responseTransportOutcome(playerResponse: PlayerResponse): String {
            val streamingData = playerResponse.streamingData
            val adaptive = streamingData?.adaptiveFormats.orEmpty()
            val progressive = streamingData?.formats.orEmpty()

            val adaptiveDirect = if (adaptive.any { !it.url.isNullOrBlank() }) "present" else "absent"
            val adaptiveCipher = if (adaptive.any { !it.signatureCipher.isNullOrBlank() || !it.cipher.isNullOrBlank() }) "present" else "absent"
            val progressiveDirect = if (progressive.any { !it.url.isNullOrBlank() }) "present" else "absent"
            val progressiveCipher = if (progressive.any { !it.signatureCipher.isNullOrBlank() || !it.cipher.isNullOrBlank() }) "present" else "absent"
            val hls = if (!streamingData?.hlsManifestUrl.isNullOrBlank()) "present" else "absent"
            val dash = if (!streamingData?.dashManifestUrl.isNullOrBlank()) "present" else "absent"
            val sabr = if (!streamingData?.serverAbrStreamingUrl.isNullOrBlank()) "present" else "absent"

            return "response_shape:adaptive_direct=$adaptiveDirect,adaptive_cipher=$adaptiveCipher,progressive_direct=$progressiveDirect,progressive_cipher=$progressiveCipher,hls=$hls,dash=$dash,sabr=$sabr"
        }
    }

    fun tokenPlan(selectedClient: SelectedClient, authenticated: Boolean): TokenPlan {
        val manifest = selectedClient.manifest
        if (manifest != null) {
            val poCaps = manifest.poTokens
            val playerRule = poCaps.player
            val gvsRule = poCaps.gvs
            return TokenPlan(
                playerBinding = tokenPlanCompatibleBinding(playerRule),
                gvsBinding = tokenPlanCompatibleBinding(gvsRule),
                playerRequired = !isSatisfiedByPremium(playerRule, authenticated),
                gvsRequired = !isSatisfiedByPremium(gvsRule, authenticated)
            )
        }
        val client = selectedClient.client
        val useWebPoTokens = client.useWebPoTokens
        val playerBinding = if (useWebPoTokens) client.poTokenBinding else null
        val gvsBinding = if (useWebPoTokens) PoTokenBinding.VIDEO_ID else null
        return TokenPlan(
            playerBinding = playerBinding,
            gvsBinding = gvsBinding,
            playerRequired = client.requirePoToken,
            gvsRequired = useWebPoTokens
        )
    }

    private fun tokenPlanCompatibleBinding(rule: PoTokenRule): PoTokenBinding? {
        val binding = rule.binding ?: return null
        if (rule.requirement == PoTokenRequirement.NONE) return null
        if (rule.providers.isEmpty()) return null
        val available = tokenProvider.getCapabilities().providers
        return if (rule.providers.any { available.contains(it) }) binding else null
    }

    suspend fun requestPlayer(
        client: YouTubeClient,
        videoId: String,
        signatureTimestamp: Int?,
        poToken: String?,
        sessionSnapshot: InnerTube.SessionSnapshot,
        encryptedHostFlags: String?,
        requestContext: PlayerRequestContext,
    ): PlayerResponse {
        val playerRequestKey = PlayerRequestKey(
            client = client,
            videoId = videoId,
            signatureTimestamp = if (client.useSignatureTimestamp) signatureTimestamp else null,
            poToken = poToken,
            requestSession = sessionSnapshot,
            encryptedHostFlags = if (client.isEmbedded) encryptedHostFlags else null
        )
        val cached = requestContext.cache[playerRequestKey]
        if (cached != null) {
            logger.d("PlayerClientDirector", "player response reused", mapOf("client" to client.clientName))
            return cached
        }

        while (true) {
            val remaining = requestContext.remainingBudget.get()
            if (remaining <= 0) {
                error("Player request budget exhausted")
            }
            if (requestContext.remainingBudget.compareAndSet(remaining, remaining - 1)) {
                try {
                    val response = withTimeout(8000L) {
                        requestPlayerWithoutTimeout(
                            client,
                            videoId,
                            signatureTimestamp,
                            poToken,
                            sessionSnapshot,
                            encryptedHostFlags
                        )
                    }
                    requestContext.cache[playerRequestKey] = response
                    return response
                } catch (e: TimeoutCancellationException) {
                    throw IOException("Player request for ${client.clientName} exceeded 8000ms", e)
                }
            }
        }
    }

    suspend fun requestPlayerWithoutTimeout(
        client: YouTubeClient,
        videoId: String,
        signatureTimestamp: Int?,
        poToken: String?,
        sessionSnapshot: InnerTube.SessionSnapshot,
        encryptedHostFlags: String?,
    ): PlayerResponse {
        val startTime = System.currentTimeMillis()
        val response = innerTube.player(
            client = client,
            videoId = videoId,
            signatureTimestamp = signatureTimestamp,
            poToken = poToken,
            requestSession = sessionSnapshot,
            encryptedHostFlags = encryptedHostFlags
        )
        val rawText = response.bodyAsTextLimited(maxBytes = 4194304)
        val isBearer = client.loginRequired || client.loginSupported
        val jsonObject = try {
            json.parseToJsonElement(rawText).jsonObject
        } catch (t: Throwable) {
            null
        }

        if (isBearer && jsonObject != null) {
            val streamingDataJson = jsonObject["streamingData"] as? JsonObject
            if (streamingDataJson != null) {
                val hasDrm = KNOWN_DRM_KEYS.any { key ->
                    val drmElem = knownDrmValue(streamingDataJson, key)
                    drmElem != null && hasDrmValue(drmElem)
                } || listOf("formats", "adaptiveFormats").any { formatsKey ->
                    (streamingDataJson[formatsKey] as? JsonArray)?.any { formatElem ->
                        (formatElem as? JsonObject)?.let { formatObj ->
                            KNOWN_DRM_KEYS.any { key ->
                                val drmElem = knownDrmValue(formatObj, key)
                                drmElem != null && hasDrmValue(drmElem)
                            }
                        } == true
                    } == true
                }
                if (hasDrm) {
                    logger.w("PlayerClientDirector", "bearer player response rejected", mapOf("client" to client.clientName, "reason" to "drm"))
                }
            }
        }

        val playerResponse = try {
            json.decodeFromString(PlayerResponse.serializer(), rawText)
        } catch (t: Throwable) {
            null
        }

        if (playerResponse == null) {
            val elapsed = System.currentTimeMillis() - startTime
            val map = mapOf(
                "client" to client.clientName,
                "httpStatus" to response.status.value.toString(),
                "elapsedMs" to elapsed.toString()
            )
            if (jsonObject == null) {
                logger.w("PlayerClientDirector", "invalid player response", map)
            } else if (jsonObject.containsKey("playabilityStatus")) {
                logger.w("PlayerClientDirector", "player response decode failed", map)
            } else {
                logger.d("PlayerClientDirector", "player response missing status", map)
            }
            error("Failed to decode player response for ${client.clientName}")
        }

        val returnedVideoId = playerResponse.videoDetails?.videoId
        if (!returnedVideoId.isNullOrBlank() && returnedVideoId != videoId) {
            logger.w("PlayerClientDirector", "player response rejected", mapOf("client" to client.clientName, "reason" to "video_identity"))
            error("Player response videoId mismatch: expected $videoId, got $returnedVideoId")
        }

        val elapsed = System.currentTimeMillis() - startTime
        val streamingData = playerResponse.streamingData
        val formatCount = (streamingData?.formats?.size ?: 0) + (streamingData?.adaptiveFormats?.size ?: 0)

        val probeMap = if (TRANSPORT_PROBE_CLIENT_NAMES.contains(client.clientName)) {
            val adaptive = streamingData?.adaptiveFormats.orEmpty()
            val progressive = streamingData?.formats.orEmpty()
            mapOf(
                "adaptiveFormatCount" to adaptive.size.toString(),
                "adaptiveDirectCount" to adaptive.count { !it.url.isNullOrBlank() }.toString(),
                "adaptiveCipherCount" to adaptive.count { !it.signatureCipher.isNullOrBlank() || !it.cipher.isNullOrBlank() }.toString(),
                "progressiveFormatCount" to progressive.size.toString(),
                "progressiveDirectCount" to progressive.count { !it.url.isNullOrBlank() }.toString(),
                "progressiveCipherCount" to progressive.count { !it.signatureCipher.isNullOrBlank() || !it.cipher.isNullOrBlank() }.toString(),
                "hlsPresent" to (!streamingData?.hlsManifestUrl.isNullOrBlank()).toString(),
                "dashPresent" to (!streamingData?.dashManifestUrl.isNullOrBlank()).toString(),
                "sabrPresent" to (!streamingData?.serverAbrStreamingUrl.isNullOrBlank()).toString(),
                "sabrConfigPresent" to (!playerResponse.playerConfig?.mediaCommonConfig?.mediaUstreamerRequestConfig?.videoPlaybackUstreamerConfig.isNullOrBlank()).toString()
            )
        } else emptyMap()

        logger.d(
            "PlayerClientDirector",
            "player response decoded",
            mapOf(
                "client" to client.clientName,
                "streamingPresent" to (streamingData != null).toString(),
                "formatCount" to formatCount.toString(),
                "elapsedMs" to elapsed.toString()
            ) + probeMap
        )

        return playerResponse
    }

    suspend fun tryTokenizedPlayer(
        selectedClient: SelectedClient,
        tokenPlan: TokenPlan,
        videoId: String,
        playerConfig: PlayerConfig,
        sessionSnapshot: InnerTube.SessionSnapshot,
        playabilityFailure: PlayabilityFailure?,
        playerResponse: PlayerResponse?,
        requestContext: PlayerRequestContext,
        fastPathOnly: Boolean,
        deferred: Deferred<PoTokenResult?>?,
    ): ClientAttemptResult {
        if (fastPathOnly) {
            return ClientAttemptResult(
                attempt = null,
                failure = playabilityFailure,
                requestFailure = null,
                tokenUnavailable = true
            )
        }

        val client = selectedClient.client
        val startTime = System.currentTimeMillis()
        var currentSession = sessionSnapshot
        var visitorData = currentSession.visitorData

        if (visitorData.isNullOrBlank()) {
            logger.d("PlayerClientDirector", "visitor data requested", mapOf("client" to client.clientName))
            val freshVisitorData = withTimeoutOrNull(5000L) {
                innerTube.fetchFreshVisitorData(currentSession, force = false)
            }
            if (!freshVisitorData.isNullOrBlank()) {
                currentSession = innerTube.sessionSnapshotWithVisitorData(currentSession, freshVisitorData) ?: currentSession
                visitorData = freshVisitorData
            }
        }

        val resolvedVisitorData = visitorData ?: ""
        val poTokenResult = withTimeoutOrNull(18000L) {
            val prewarmed = if (deferred != null && selectedClient.manifest?.request?.cookies != false) {
                val candidateToken = deferred.await()
                if (candidateToken?.visitorData == resolvedVisitorData) candidateToken else null
            } else null
            prewarmed ?: tokenProvider.getPoToken(videoId, resolvedVisitorData)
        }

        val elapsed = System.currentTimeMillis() - startTime
        logger.d(
            "PlayerClientDirector",
            "token fetch completed",
            mapOf(
                "client" to client.clientName,
                "tokenPresent" to (poTokenResult != null).toString(),
                "elapsedMs" to elapsed.toString()
            )
        )

        val playerPoToken = when (tokenPlan.playerBinding) {
            PoTokenBinding.VISITOR_DATA -> poTokenResult?.streamingDataToken
            PoTokenBinding.VIDEO_ID -> poTokenResult?.playerRequestToken
            null -> null
        }
        val gvsPoToken = when (tokenPlan.gvsBinding) {
            PoTokenBinding.VISITOR_DATA -> poTokenResult?.streamingDataToken
            PoTokenBinding.VIDEO_ID -> poTokenResult?.playerRequestToken
            null -> null
        }

        val isMissingRequired = (tokenPlan.playerRequired && playerPoToken.isNullOrBlank()) ||
                (tokenPlan.gvsRequired && gvsPoToken.isNullOrBlank())

        if (poTokenResult == null) {
            return ClientAttemptResult(
                attempt = null,
                failure = playabilityFailure,
                requestFailure = null,
                tokenUnavailable = true
            )
        }

        if (poTokenResult.visitorData != resolvedVisitorData || isMissingRequired) {
            logger.w("PlayerClientDirector", "token binding rejected", mapOf("client" to client.clientName))
            return ClientAttemptResult(
                attempt = null,
                failure = playabilityFailure,
                requestFailure = null,
                tokenUnavailable = true
            )
        }

        if (playerResponse != null && playerPoToken.isNullOrBlank()) {
            return ClientAttemptResult(
                attempt = ClientAttempt(playerResponse, usedPoToken = true, streamingDataPoToken = gvsPoToken),
                failure = null,
                requestFailure = null,
                tokenUnavailable = false
            )
        }

        val tokenizedResponse = requestPlayer(
            client = client,
            videoId = videoId,
            signatureTimestamp = playerConfig.signatureTimestamp,
            poToken = playerPoToken,
            sessionSnapshot = currentSession,
            encryptedHostFlags = playerConfig.encryptedHostFlags,
            requestContext = requestContext
        )

        return if (isPlayable(tokenizedResponse, client)) {
            val usedPo = !playerPoToken.isNullOrBlank() || !gvsPoToken.isNullOrBlank()
            ClientAttemptResult(
                attempt = ClientAttempt(tokenizedResponse, usedPoToken = usedPo, streamingDataPoToken = gvsPoToken),
                failure = null,
                requestFailure = null,
                tokenUnavailable = false
            )
        } else {
            logger.d("PlayerClientDirector", "tokenized response unavailable", mapOf("client" to client.clientName))
            ClientAttemptResult(
                attempt = null,
                failure = PlayabilityFailure(tokenizedResponse.playabilityStatus?.status, tokenizedResponse.playabilityStatus?.reason),
                requestFailure = null,
                tokenUnavailable = false
            )
        }
    }

    suspend fun tryPlayer(
        selectedClient: SelectedClient,
        videoId: String,
        playerConfig: PlayerConfig,
        contentHints: ContentHints,
        isBearer: Boolean,
        authenticated: Boolean,
        forceTokenized: Boolean,
        sessionSnapshot: InnerTube.SessionSnapshot,
        requestContext: PlayerRequestContext,
        fastPathOnly: Boolean,
        deferred: Deferred<PoTokenResult?>?,
    ): ClientAttemptResult {
        return try {
            val client = selectedClient.client
            val tokenPlan = tokenPlan(selectedClient, authenticated)
            val isPlayerRequired = tokenPlan.playerRequired

            if (fastPathOnly && (isPlayerRequired || tokenPlan.gvsRequired) && !isBearer) {
                return ClientAttemptResult(
                    attempt = null,
                    failure = null,
                    requestFailure = null,
                    tokenUnavailable = true
                )
            }

            if ((forceTokenized || isPlayerRequired) && tokenPlan.canMint) {
                logger.d("PlayerClientDirector", "tokenized request selected", mapOf("client" to client.clientName))
                tryTokenizedPlayer(
                    selectedClient,
                    tokenPlan,
                    videoId,
                    playerConfig,
                    sessionSnapshot,
                    null,
                    null,
                    requestContext,
                    fastPathOnly,
                    deferred
                )
            } else {
                val playerResponse = requestPlayer(
                    client = client,
                    videoId = videoId,
                    signatureTimestamp = playerConfig.signatureTimestamp,
                    poToken = null,
                    sessionSnapshot = sessionSnapshot,
                    encryptedHostFlags = playerConfig.encryptedHostFlags,
                    requestContext = requestContext
                )

                val playable = isPlayable(playerResponse, client)
                val status = playerResponse.playabilityStatus
                val failure = PlayabilityFailure(status?.status, status?.reason)

                if (playable) {
                    if (!tokenPlan.playerRequired && !tokenPlan.gvsRequired) {
                        if (tokenPlan.canMint) {
                            logger.d("PlayerClientDirector", "untokenized response accepted", mapOf("client" to client.clientName))
                        }
                        return ClientAttemptResult(
                            attempt = ClientAttempt(playerResponse, usedPoToken = false, streamingDataPoToken = null),
                            failure = null,
                            requestFailure = null,
                            tokenUnavailable = false
                        )
                    }
                }

                if (!tokenPlan.canMint) {
                    ClientAttemptResult(
                        attempt = if (playable) ClientAttempt(playerResponse, false, null) else null,
                        failure = if (playable) null else failure,
                        requestFailure = null,
                        tokenUnavailable = false,
                        observedResponse = playerResponse
                    )
                } else {
                    if (!playable && contentHints.isUploaded == true) {
                        logger.d("PlayerClientDirector", "token fetch retried", mapOf("client" to client.clientName, "restrictedContent" to "true"))
                    }
                    tryTokenizedPlayer(
                        selectedClient,
                        tokenPlan,
                        videoId,
                        playerConfig,
                        sessionSnapshot,
                        if (playable) null else failure,
                        if (playable) playerResponse else null,
                        requestContext,
                        fastPathOnly,
                        deferred
                    )
                }
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            val exType = e::class.simpleName ?: "unknown"
            val profilePresent = selectedClient.manifest?.id != null
            logger.w(
                "PlayerClientDirector",
                "player request failed",
                mapOf(
                    "client" to selectedClient.client.clientName,
                    "profilePresent" to profilePresent.toString(),
                    "exceptionType" to exType
                )
            )
            ClientAttemptResult(
                attempt = null,
                failure = null,
                requestFailure = e,
                tokenUnavailable = false
            )
        }
    }

    suspend fun fetchPlayerResponses(
        videoId: String,
        playerConfig: PlayerConfig,
        hints: ContentHints,
        excludedClients: Set<String> = emptySet(),
        fastPathOnly: Boolean = false,
        preferDirectTransport: Boolean = false,
        forceTokenized: Boolean = false,
        requestContext: PlayerRequestContext? = null,
        prewarmedToken: Deferred<PoTokenResult?>? = null,
    ): PlayerResponseBatch {
        val startTime = System.currentTimeMillis()
        val sessionSnapshot = innerTube.sessionSnapshot()
        val visitorData = if (!playerConfig.visitorData.isNullOrBlank() && !playerConfig.encryptedHostFlags.isNullOrBlank()) {
            null
        } else {
            sessionSnapshot.visitorData?.takeIf { it.isNotBlank() } ?: playerConfig.visitorData?.takeIf { it.isNotBlank() }
        }

        var currentSession = sessionSnapshot.copy(visitorData = visitorData)
        val isAuthenticated = !currentSession.sapisid.isNullOrBlank()
        val healthScope = ClientHealthScope.from(hints, isAuthenticated)

        val selectionRequest = ClientSelectionRequest(
            hints = hints,
            authenticated = isAuthenticated,
            availablePoTokenProviders = tokenProvider.getCapabilities().providers,
            javaScriptRuntimeAvailable = playerConfig.playerUrl.isNotBlank(),
            webViewAvailable = tokenProvider.getCapabilities().usesWebView,
            fastPathOnly = fastPathOnly,
            transportPreference = if (preferDirectTransport) PlaybackTransportPreference.DIRECT else PlaybackTransportPreference.AUTO,
            excludedClients = excludedClients
        )

        val selectionResult = (fallbackStrategy as? ContentAwareFallbackStrategy)
            ?.selectClients(selectionRequest, forceTokenized, visitorData != null)
            ?: ClientSelectionResult(emptyList(), emptyList())

        val attempts = ArrayList<StreamAttemptDiagnostic>()
        for (rejected in selectionResult.rejected) {
            val manifest = rejected.manifest
            attempts.add(
                StreamAttemptDiagnostic(
                    clientName = manifest.client.clientName,
                    profileId = manifest.id,
                    userAgent = manifest.client.userAgent,
                    outcome = "selection:" + rejected.reasons.joinToString("+")
                )
            )
        }

        val candidates = ArrayList<SelectedClient>()
        for (candidate in selectionResult.candidates) {
            val clientName = candidate.client.clientName
            if (excludedClients.contains(clientName)) continue

            val noPoProfiles = profileIds(candidate, hasPo = false)
            val poProfiles = profileIds(candidate, hasPo = true)
            val hasExcludedNoPo = noPoProfiles.any { excludedClients.contains(it) }
            val hasExcludedPo = poProfiles.any { excludedClients.contains(it) }

            if (hasExcludedNoPo && hasExcludedPo) continue
            if (!tokenPlan(candidate, isAuthenticated).canMint && hasExcludedNoPo) continue

            val plan = tokenPlan(candidate, isAuthenticated)
            if (hasExcludedPo && (plan.playerRequired || plan.gvsRequired)) continue

            candidates.add(candidate)
        }

        logger.d(
            "PlayerClientDirector",
            "player client selection",
            mapOf(
                "candidateCount" to candidates.size.toString(),
                "rejectedCount" to selectionResult.rejected.size.toString(),
                "wantVideo" to "false"
            )
        )

        logger.d(
            "PlayerClientDirector",
            "player response batch started",
            mapOf(
                "candidateCount" to candidates.size.toString(),
                "excludedCount" to excludedClients.size.toString(),
                "directAudioOnly" to preferDirectTransport.toString(),
                "wantVideo" to "false"
            )
        )

        val playableResponses = ArrayList<ClientResult>()
        val failures = ArrayList<PlayabilityFailure>()
        val requestFailures = ArrayList<Throwable>()
        val effectiveContext = requestContext ?: PlayerRequestContext(
            budget = if (hints.playbackClientOverrideId != null) 1 else maxPlayerRequests
        )

        val maxResults = if (hints.playbackClientOverrideId != null) 1 else 2
        var attemptsCount = 0

        for (candidate in candidates) {
            if (playableResponses.size >= maxResults || effectiveContext.getRemaining() <= 0) {
                break
            }

            // Sync session visitor data if generation changed
            val latestSession = innerTube.sessionSnapshot()
            if (latestSession.generation != currentSession.generation && !latestSession.visitorData.isNullOrBlank()) {
                currentSession = innerTube.sessionSnapshotWithVisitorData(currentSession, latestSession.visitorData) ?: currentSession
            }

            // Web client dynamic version check
            val clientVersion = playerConfig.clientVersion
            val effectiveCandidate = if (!clientVersion.isNullOrBlank() &&
                DYNAMIC_WEB_VERSION_CLIENT_NAMES.contains(candidate.client.clientName) &&
                candidate.client.clientVersion != clientVersion
            ) {
                val updatedClient = candidate.client.copy(clientVersion = clientVersion)
                SelectedClient(updatedClient, candidate.manifest, candidate.score, candidate.reasons)
            } else {
                candidate
            }

            // VISIONOS check
            if (usesAutomaticCatalog && effectiveCandidate.manifest?.id == "VISIONOS_0_1") {
                if (visitorData.isNullOrBlank() && hints.playbackClientOverrideId == null) {
                    continue
                }
            }

            val isBearer = effectiveCandidate.manifest?.request?.cookies == false
            val attemptResult = tryPlayer(
                selectedClient = effectiveCandidate,
                videoId = videoId,
                playerConfig = playerConfig,
                contentHints = hints,
                isBearer = isBearer,
                authenticated = isAuthenticated,
                forceTokenized = forceTokenized,
                sessionSnapshot = currentSession,
                requestContext = effectiveContext,
                fastPathOnly = fastPathOnly,
                deferred = prewarmedToken
            )

            attemptsCount++
            val client = effectiveCandidate.client
            val manifest = effectiveCandidate.manifest
            val effectiveProfileId = manifest?.id ?: legacyProfileId(client, attemptResult.attempt?.usedPoToken == true)

            if (attemptResult.attempt != null) {
                val attempt = attemptResult.attempt
                val clientResult = ClientResult(
                    clientName = client.clientName,
                    profileId = effectiveProfileId,
                    userAgent = client.userAgent,
                    response = attempt.response,
                    usedPoToken = attempt.usedPoToken,
                    streamingDataPoToken = attempt.streamingDataPoToken,
                    clientId = client.clientId.toIntOrNull() ?: 0,
                    clientVersion = client.clientVersion,
                    useSabr = client.useSabr,
                    bearerAuthenticated = isBearer
                )
                playableResponses.add(clientResult)
                attempts.add(
                    StreamAttemptDiagnostic(
                        clientName = client.clientName,
                        profileId = effectiveProfileId,
                        userAgent = client.userAgent,
                        outcome = "playable"
                    )
                )
                if (playableResponses.size >= maxResults) {
                    break
                }
            } else {
                if (attemptResult.failure != null) {
                    failures.add(attemptResult.failure)
                    attempts.add(
                        StreamAttemptDiagnostic(
                            clientName = client.clientName,
                            profileId = effectiveProfileId,
                            userAgent = client.userAgent,
                            outcome = "playability_failed:${attemptResult.failure.status}"
                        )
                    )
                }
                if (attemptResult.requestFailure != null) {
                    requestFailures.add(attemptResult.requestFailure)
                    val exType = attemptResult.requestFailure::class.simpleName ?: "unknown"
                    attempts.add(
                        StreamAttemptDiagnostic(
                            clientName = client.clientName,
                            profileId = effectiveProfileId,
                            userAgent = client.userAgent,
                            outcome = "request_failed:$exType"
                        )
                    )
                }
                if (attemptResult.tokenUnavailable) {
                    attempts.add(
                        StreamAttemptDiagnostic(
                            clientName = client.clientName,
                            profileId = effectiveProfileId,
                            userAgent = client.userAgent,
                            outcome = "token_unavailable"
                        )
                    )
                }
            }
        }

        val totalElapsed = System.currentTimeMillis() - startTime
        logger.d(
            "PlayerClientDirector",
            "player response batch completed",
            mapOf(
                "resultCount" to playableResponses.size.toString(),
                "elapsedMs" to totalElapsed.toString()
            )
        )

        return PlayerResponseBatch(
            playableResponses = playableResponses,
            failures = failures,
            requestFailures = requestFailures,
            attempts = attempts
        )
    }
}
