package com.metrolist.innertubex.cipher

import com.metrolist.innertubex.InnerTubeLogger
import com.metrolist.innertubex.d
import com.metrolist.innertubex.w
import com.metrolist.music.utils.InnerTubeXPlayer
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.request.headers
import io.ktor.http.HttpHeaders
import io.ktor.http.Url
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import java.io.IOException
import kotlin.coroutines.cancellation.CancellationException

class RemotePlayerConfigStore(
    val httpClient: HttpClient,
    val repository: InnerTubeXPlayer.AndroidPlayerConfigRepository,
    val logger: InnerTubeLogger? = null,
    val nowMs: () -> Long = { System.currentTimeMillis() },
) {
    data class CachedLegacyTimestamp(
        val value: Int?,
        val fetchedAtMs: Long,
    )

    data class RefreshResult(
        val changed: Boolean,
        val requestAttempted: Boolean,
    )

    @Volatile
    var configEpoch: Long = 0L

    @Volatile
    var configSourceUrl: String? = null

    @Volatile
    var configs: Map<String, RemotePlayerConfigParser.HardcodedPlayerConfig> = emptyMap()

    @Volatile
    var lastRefreshAttemptAtMs: Long = 0L

    @Volatile
    var lastRefreshAttemptSourceUrl: String? = null

    @Volatile
    var lastStreamRejectionRefreshAtMs: Long = 0L

    @Volatile
    var lastStreamRejectionRefreshSourceUrl: String? = null

    @Volatile
    var lastUnknownHashRefreshAtMs: Long = 0L

    @Volatile
    var lastUnknownHashRefreshSourceUrl: String? = null

    val legacyTimestampCache = LinkedHashMap<String, CachedLegacyTimestamp>()
    val mutex = Mutex()
    val refreshMutex = Mutex()

    fun applyConfigs(sourceUrl: String, newConfigs: Map<String, RemotePlayerConfigParser.HardcodedPlayerConfig>): Boolean {
        val changed = configSourceUrl != sourceUrl || configs != newConfigs
        configs = newConfigs
        configSourceUrl = sourceUrl
        if (changed) {
            configEpoch++
        }
        return changed
    }

    fun configuredUrl(): String? {
        val defaultUrl = "https://raw.githubusercontent.com/ZemerTeam/zemer-cipher/master/library/src/main/assets/player_configs.json"
        val custom = repository.preferences.getString("remote_config_source_url", null)?.trim()
        val template = if (!custom.isNullOrBlank()) {
            if (custom == "https://github.com/MetrolistGroup/faraday/releases/download/{playerTag}/{playerHash}.json") {
                defaultUrl
            } else if (custom.substringBefore('?').endsWith("/player_configs.json")) {
                custom
            } else {
                null
            }
        } else {
            defaultUrl
        }
        if (template != null && validatedSourceUrlOrNull(template) != null) {
            return template
        }
        return null
    }

    fun ensureLoadedFromCache(sourceUrl: String) {
        if (configSourceUrl != sourceUrl || configs.isEmpty()) {
            val cachedSource = repository.preferences.getString("source_url", "").orEmpty()
            if (cachedSource == sourceUrl) {
                val cachedJson = repository.preferences.getString("json", "").orEmpty()
                if (cachedJson.isNotBlank()) {
                    when (val parseResult = RemotePlayerConfigParser.parse(cachedJson)) {
                        is RemotePlayerConfigParser.ParseResult.Success -> {
                            applyConfigs(sourceUrl, parseResult.configs)
                        }
                        is RemotePlayerConfigParser.ParseResult.Failure -> {
                            logger?.w("RemotePlayerConfigStore", "Cached remote player configs rejected: ${parseResult.reason}")
                        }
                    }
                }
            }
        }
    }

    suspend fun forceRefresh(expectedPlayerHash: String?): Boolean {
        val sourceUrl = configuredUrl() ?: return false
        val isKnown = isKnownHash(expectedPlayerHash.orEmpty(), sourceUrl)
        if (isKnown) {
            return false
        }
        val reservedAt = reserveUnknownHashRefresh(sourceUrl) ?: return false
        try {
            val result = refresh(sourceUrl, force = true, requireFresh = expectedPlayerHash != null)
            if (!result.requestAttempted) {
                releaseUnknownHashRefresh(reservedAt, sourceUrl)
            }
            return result.changed
        } catch (e: CancellationException) {
            withContext(NonCancellable) {
                releaseUnknownHashRefresh(reservedAt, sourceUrl)
            }
            throw e
        }
    }

    suspend fun getConfig(playerUrl: String): RemotePlayerConfigParser.HardcodedPlayerConfig? {
        val hash = RemotePlayerConfigParser.extractPlayerHash(playerUrl) ?: return null
        val sourceUrl = configuredUrl() ?: return null
        refreshIfStale()
        val map = if (configSourceUrl == sourceUrl) configs else null
        return map?.get(hash)
    }

    suspend fun getLegacySignatureTimestamp(playerUrl: String): Int? {
        val hash = RemotePlayerConfigParser.extractPlayerHash(playerUrl) ?: return null
        var template = repository.preferences.getString(
            "remote_config_source_url",
            "https://cdn.jsdelivr.net/gh/MetrolistGroup/faraday@{playerTag}/registry/players/{playerHash}.json"
        )?.trim().orEmpty()

        if (template.isBlank() ||
            template == "https://github.com/MetrolistGroup/faraday/releases/download/{playerTag}/{playerHash}.json" ||
            template.substringBefore('?').endsWith("/player_configs.json")
        ) {
            return null
        }
        val resolvedUrl = template
            .replace("{playerHash}", hash)
            .replace("{playerTag}", "player-$hash")
        if (validatedSourceUrlOrNull(resolvedUrl) == null) {
            return null
        }

        val now = nowMs()
        mutex.withLock {
            val cached = legacyTimestampCache[resolvedUrl]
            if (cached != null) {
                if (now - cached.fetchedAtMs < 86400000L) {
                    return cached.value
                }
            }
        }

        val parsedUrl = Url(resolvedUrl)
        var fetchedTimestamp: Int? = null
        try {
            val response = getTextWithoutRedirects(
                httpClient = httpClient,
                url = parsedUrl,
                maxBytes = 4194304,
                configure = {
                    headers.append("Accept", "application/json")
                }
            )
            val body = response.body
            if (body != null) {
                fetchedTimestamp = RemotePlayerConfigParser.parseLegacySignatureTimestamp(body, hash)
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            val exName = e::class.simpleName ?: "Exception"
            logger?.d("RemotePlayerConfigStore", "Legacy player config timestamp unavailable hash=$hash type=$exName")
        }

        mutex.withLock {
            legacyTimestampCache[resolvedUrl] = CachedLegacyTimestamp(fetchedTimestamp, now)
            while (legacyTimestampCache.size > 16) {
                val firstKey = legacyTimestampCache.keys.firstOrNull() ?: break
                legacyTimestampCache.remove(firstKey)
            }
        }
        return fetchedTimestamp
    }

    suspend fun getSignatureTimestamp(playerUrl: String): Int? {
        val config = getConfig(playerUrl)
        if (config != null) {
            return config.signatureTimestamp
        }
        return getLegacySignatureTimestamp(playerUrl)
    }

    fun hasFreshCache(now: Long, sourceUrl: String): Boolean {
        val json = repository.preferences.getString("json", "").orEmpty()
        if (json.isBlank()) {
            return false
        }
        val cachedSource = repository.preferences.getString("source_url", "").orEmpty()
        return cachedSource == sourceUrl && (now - repository.preferences.getLong("cached_at_ms", 0L) < 21600000L)
    }

    fun hasRecentRefreshAttempt(now: Long, sourceUrl: String): Boolean {
        if (lastRefreshAttemptSourceUrl != sourceUrl) {
            return false
        }
        val diff = now - lastRefreshAttemptAtMs
        return diff in 0 until 60000L
    }

    suspend fun isKnownHash(playerHash: String, sourceUrl: String): Boolean = mutex.withLock {
        ensureLoadedFromCache(sourceUrl)
        val map = if (configSourceUrl == sourceUrl) configs else null
        map != null && map.containsKey(playerHash)
    }

    suspend fun refresh(sourceUrl: String, force: Boolean, requireFresh: Boolean): RefreshResult = refreshMutex.withLock {
        val now = nowMs()
        mutex.withLock {
            if (!force && hasFreshCache(now, sourceUrl)) {
                ensureLoadedFromCache(sourceUrl)
                return@withLock RefreshResult(changed = false, requestAttempted = false)
            }
            if (hasRecentRefreshAttempt(now, sourceUrl)) {
                ensureLoadedFromCache(sourceUrl)
                return@withLock RefreshResult(changed = false, requestAttempted = false)
            }
            lastRefreshAttemptAtMs = now
            lastRefreshAttemptSourceUrl = sourceUrl
            null
        }?.let { return it }

        val cachedEtag = repository.preferences.getString("etag", "").orEmpty()
        val cachedSource = repository.preferences.getString("source_url", "").orEmpty()
        val effectiveEtag = if (!requireFresh && cachedSource == sourceUrl && cachedEtag.isNotBlank()) cachedEtag else null

        val parsedUrl = Url(sourceUrl)
        var response: RestrictedTextResponse? = null
        try {
            response = getTextWithoutRedirects(
                httpClient = httpClient,
                url = parsedUrl,
                maxBytes = 4194304,
                configure = {
                    if (effectiveEtag != null) {
                        headers.append(HttpHeaders.IfNoneMatch, effectiveEtag)
                    }
                    headers.append("Accept", "application/json")
                }
            )
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            val exName = e::class.simpleName ?: "Exception"
            logger?.w("RemotePlayerConfigStore", "Remote player configs fetch failed ($exName)")
        }

        mutex.withLock {
            if (configuredUrl() != sourceUrl) {
                return@withLock RefreshResult(changed = false, requestAttempted = true)
            }
            if (response == null) {
                ensureLoadedFromCache(sourceUrl)
                return@withLock RefreshResult(changed = false, requestAttempted = true)
            }
            val status = response.status.value
            val etag = response.headers[HttpHeaders.ETag]
            if (status == 304) {
                repository.preferences.edit().putLong("cached_at_ms", nowMs()).apply()
                ensureLoadedFromCache(sourceUrl)
                return@withLock RefreshResult(changed = false, requestAttempted = true)
            }
            if (status !in 200..299) {
                logger?.w("RemotePlayerConfigStore", "Remote player configs HTTP $status")
                ensureLoadedFromCache(sourceUrl)
                return@withLock RefreshResult(changed = false, requestAttempted = true)
            }
            val body = response.body
            if (body == null) {
                return@withLock RefreshResult(changed = false, requestAttempted = true)
            }
            when (val parseResult = RemotePlayerConfigParser.parse(body)) {
                is RemotePlayerConfigParser.ParseResult.Success -> {
                    val changed = applyConfigs(sourceUrl, parseResult.configs)
                    repository.preferences.edit()
                        .putString("json", body)
                        .putLong("cached_at_ms", nowMs())
                        .putString("source_url", sourceUrl)
                        .apply()
                    if (etag != null) {
                        repository.preferences.edit().putString("etag", etag).apply()
                    }
                    logger?.d("RemotePlayerConfigStore", "Remote player configs applied (${parseResult.configs.size} entries) changed=$changed epoch=$configEpoch")
                    RefreshResult(changed = changed, requestAttempted = true)
                }
                is RemotePlayerConfigParser.ParseResult.Failure -> {
                    logger?.w("RemotePlayerConfigStore", "Remote player configs rejected: ${parseResult.reason}")
                    ensureLoadedFromCache(sourceUrl)
                    RefreshResult(changed = false, requestAttempted = true)
                }
            }
        }
    }

    suspend fun refreshAfterStreamRejection(): Boolean {
        val sourceUrl = configuredUrl() ?: return false
        val reservedAt = reserveStreamRejectionRefresh(sourceUrl) ?: return false
        try {
            val result = refresh(sourceUrl, force = true, requireFresh = true)
            if (!result.requestAttempted) {
                releaseStreamRejectionRefresh(reservedAt, sourceUrl)
            }
            return result.changed
        } catch (e: CancellationException) {
            withContext(NonCancellable) {
                releaseStreamRejectionRefresh(reservedAt, sourceUrl)
            }
            throw e
        }
    }

    suspend fun refreshIfStale(): Boolean {
        val sourceUrl = configuredUrl() ?: return false
        return refresh(sourceUrl, force = false, requireFresh = false).changed
    }

    suspend fun releaseStreamRejectionRefresh(reservedAt: Long, sourceUrl: String) = mutex.withLock {
        if (lastStreamRejectionRefreshSourceUrl == sourceUrl && lastStreamRejectionRefreshAtMs == reservedAt) {
            lastStreamRejectionRefreshSourceUrl = null
            lastStreamRejectionRefreshAtMs = 0L
        }
    }

    suspend fun releaseUnknownHashRefresh(reservedAt: Long, sourceUrl: String) = mutex.withLock {
        if (lastUnknownHashRefreshSourceUrl == sourceUrl && lastUnknownHashRefreshAtMs == reservedAt) {
            lastUnknownHashRefreshSourceUrl = null
            lastUnknownHashRefreshAtMs = 0L
        }
    }

    suspend fun reserveStreamRejectionRefresh(sourceUrl: String): Long? = mutex.withLock {
        val now = nowMs()
        val lastUrl = lastStreamRejectionRefreshSourceUrl
        val lastAt = lastStreamRejectionRefreshAtMs
        val isRecent = lastUrl == sourceUrl && (now >= lastAt && now - lastAt < 300000L)
        if (isRecent) {
            null
        } else {
            lastStreamRejectionRefreshSourceUrl = sourceUrl
            lastStreamRejectionRefreshAtMs = now
            now
        }
    }

    suspend fun reserveUnknownHashRefresh(sourceUrl: String): Long? = mutex.withLock {
        val now = nowMs()
        val lastUrl = lastUnknownHashRefreshSourceUrl
        val lastAt = lastUnknownHashRefreshAtMs
        val isRecent = lastUrl == sourceUrl && (now >= lastAt && now - lastAt < 300000L)
        if (isRecent) {
            null
        } else {
            lastUnknownHashRefreshSourceUrl = sourceUrl
            lastUnknownHashRefreshAtMs = now
            now
        }
    }

    companion object {
        fun validatedSourceUrlOrNull(urlStr: String): Url? {
            val url = runCatching { Url(urlStr) }.getOrNull() ?: return null
            if (url.protocol.name != "https") return null
            val host = url.host
            val path = url.encodedPath
            val valid = when (host) {
                "github.com" -> path.startsWith("/MetrolistGroup/faraday/releases/download/")
                "raw.githubusercontent.com" -> path.startsWith("/MetrolistGroup/faraday/")
                "cdn.jsdelivr.net" -> path.startsWith("/gh/MetrolistGroup/faraday@")
                else -> false
            }
            return if (valid) url else null
        }
    }
}
