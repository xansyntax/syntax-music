package com.metrolist.innertubex.cipher

import com.metrolist.innertubex.InnerTubeLogger
import com.metrolist.innertubex.d
import com.metrolist.music.utils.InnerTubeXPlayer
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.request.headers
import io.ktor.http.Url
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlin.coroutines.cancellation.CancellationException

class GitHubPlayerConfigClient(
    val httpClient: HttpClient,
    val ejs: EjsChallengeSolver,
    val repository: InnerTubeXPlayer.AndroidPlayerConfigRepository,
    val validateSourceUrl: (String) -> Url? = { RemotePlayerConfigStore.validatedSourceUrlOrNull(it) },
    val logger: InnerTubeLogger? = null,
) {
    data class CachedConfig(
        val url: String,
        val config: PlayerConfig,
        val fetchedAtMs: Long,
    )

    @Serializable
    data class NTransformConfig(
        val type: String,
        val preprocessedPlayerEncoding: String? = null,
        val preprocessedPlayer: String,
    )

    @Serializable
    data class PlayerConfig(
        val schemaVersion: Int = 0,
        val playerHash: String,
        val nTransform: NTransformConfig? = null,
    )

    data class SolveResult(
        val sigByChallenge: Map<String, String>,
        val nByChallenge: Map<String, String>,
    )

    val cacheMutex = Mutex()
    val cachedConfigs = LinkedHashMap<String, CachedConfig>()
    val missingConfigs = LinkedHashMap<String, Long>()
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    suspend fun fetchConfig(url: String): PlayerConfig? {
        return try {
            val parsedUrl = validateSourceUrl(url) ?: return null
            val response = getTextWithoutRedirects(
                httpClient = httpClient,
                url = parsedUrl,
                maxBytes = 4194304,
                configure = {
                    headers.append("Accept", "application/json")
                }
            )
            val body = response.body ?: return null
            json.decodeFromString(PlayerConfig.serializer(), body)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            val exName = e::class.simpleName ?: "Exception"
            logger?.d("GitHubPlayerConfigClient", "GitHub config fetch failed ($exName)")
            null
        }
    }

    suspend fun loadConfig(playerHash: String, url: String): PlayerConfig? {
        val now = System.currentTimeMillis()
        cacheMutex.withLock {
            val cached = cachedConfigs.remove(url)
            if (cached != null) {
                if (now - cached.fetchedAtMs < 86400000L && nTransformFor(cached.config, playerHash) != null) {
                    cachedConfigs[url] = cached
                    return cached.config
                }
            }
            val missingAt = missingConfigs[url]
            if (missingAt != null) {
                val diff = now - missingAt
                if (diff in 0 until 900000L) {
                    return null
                }
            }
        }

        val config = fetchConfig(url)
        val validConfig = if (config != null && nTransformFor(config, playerHash) != null) config else null

        cacheMutex.withLock {
            if (validConfig != null) {
                cachedConfigs[url] = CachedConfig(url, validConfig, System.currentTimeMillis())
                while (cachedConfigs.size > 1) {
                    val firstKey = cachedConfigs.keys.firstOrNull() ?: break
                    cachedConfigs.remove(firstKey)
                }
                return validConfig
            } else {
                missingConfigs[url] = System.currentTimeMillis()
                while (missingConfigs.size > 8) {
                    val firstKey = missingConfigs.keys.firstOrNull() ?: break
                    missingConfigs.remove(firstKey)
                }
                return null
            }
        }
    }

    suspend fun loadPreprocessedPlayer(playerHash: String, sourceUrl: String): String? {
        val candidates = ArrayList<String>()
        candidates.add(sourceUrl)
        val match = JSDELIVR_URL_REGEX.find(sourceUrl)
        if (match != null) {
            val owner = match.groupValues[1]
            val repo = match.groupValues[2]
            val version = match.groupValues[3]
            val path = match.groupValues[4]
            val raw = "https://raw.githubusercontent.com/$owner/$repo/$version/$path"
            if (!candidates.contains(raw)) {
                candidates.add(raw)
            }
        }

        for (candidateUrl in candidates) {
            val config = loadConfig(playerHash, candidateUrl)
            if (config != null) {
                val nTransform = nTransformFor(config, playerHash)
                if (nTransform != null) {
                    return nTransform.preprocessedPlayer
                }
            }
        }
        return null
    }

    suspend fun solve(
        playerUrl: String,
        sigChallenges: List<String>,
        nChallenges: List<String>,
    ): SolveResult {
        val emptyResult = SolveResult(emptyMap(), emptyMap())
        if (sigChallenges.isEmpty() && nChallenges.isEmpty()) {
            return emptyResult
        }
        val match = PLAYER_HASH_REGEX.find(playerUrl)
        val playerHash = match?.groupValues?.getOrNull(1) ?: return emptyResult

        var sourceTemplate = repository.preferences.getString(
            "remote_config_source_url",
            "https://cdn.jsdelivr.net/gh/MetrolistGroup/faraday@{playerTag}/registry/players/{playerHash}.json"
        )?.trim().orEmpty()

        if (sourceTemplate.substringBefore('?').endsWith("/player_configs.json") ||
            sourceTemplate == "https://github.com/MetrolistGroup/faraday/releases/download/{playerTag}/{playerHash}.json"
        ) {
            sourceTemplate = "https://cdn.jsdelivr.net/gh/MetrolistGroup/faraday@{playerTag}/registry/players/{playerHash}.json"
        }
        if (sourceTemplate.isBlank()) {
            return emptyResult
        }
        val resolvedUrl = sourceTemplate
            .replace("{playerHash}", playerHash)
            .replace("{playerTag}", "player-$playerHash")
        if (resolvedUrl.isBlank()) {
            return emptyResult
        }

        val preprocessedPlayer = loadPreprocessedPlayer(playerHash, resolvedUrl) ?: return emptyResult

        val requests = ArrayList<Pair<String, List<String>>>()
        if (sigChallenges.isNotEmpty()) {
            requests.add("sig" to sigChallenges)
        }
        if (nChallenges.isNotEmpty()) {
            requests.add("n" to nChallenges)
        }

        return try {
            val solveResult = ejs.solve(playerUrl, { null }, requests, true)
            val sigSolved = solveResult.sigByChallenge.filterValues { it.isNotBlank() }
            val nSolved = solveResult.nByChallenge.filterValues { it.isNotBlank() }
            logger?.d("GitHubPlayerConfigClient", "GitHub preprocessed-player response sigRequested=${sigChallenges.size} sigSolved=${sigSolved.size} nRequested=${nChallenges.size} nSolved=${nSolved.size} hash=$playerHash")
            SolveResult(sigSolved, nSolved)
        } catch (e: Exception) {
            val exName = e::class.simpleName ?: "Exception"
            logger?.d("GitHubPlayerConfigClient", "GitHub preprocessed-player failed ($exName)")
            emptyResult
        }
    }

    companion object {
        val JSDELIVR_URL_REGEX = Regex("""^https://cdn\.jsdelivr\.net/gh/([^/]+)/([^@/]+)@([^/]+)/(.+)$""")
        val PLAYER_HASH_REGEX = Regex("""/s/player/([^/]+)/""")

        fun nTransformFor(playerConfig: PlayerConfig, playerHash: String): NTransformConfig? {
            if (playerConfig.playerHash != playerHash) {
                return null
            }
            val nTransform = playerConfig.nTransform ?: return null
            if (nTransform.type != "yt-dlp-ejs-preprocessed-player" || nTransform.preprocessedPlayer.isBlank()) {
                return null
            }
            return nTransform
        }
    }
}
