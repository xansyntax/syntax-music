package com.metrolist.innertubex.cipher

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

object RemotePlayerConfigParser {
    val SIG_RE = Regex("^[A-Za-z0-9\${'$'}_]{1,8}\\(\\d+,\\d+,INPUT\\)$")
    val NCLASS_RE = Regex("^[A-Za-z0-9\${'$'}_]{1,8}$")
    val HASH_RE = Regex("""^[a-f0-9]{8}$""")
    val PLAYER_HASH_PATTERNS = listOf(
        Regex("""/player/([a-f0-9]{8})/"""),
        Regex("""player_ias\.vflset/[^/]+/([a-f0-9]{8})/"""),
        Regex("""/s/player/([a-f0-9]{8})/"""),
    )

    data class HardcodedPlayerConfig(
        val sigJsExpression: String,
        val nJsExpression: String,
        val signatureTimestamp: Int,
    )

    sealed class ParseResult {
        data class Success(
            val configs: Map<String, HardcodedPlayerConfig>,
            val failedHashes: List<String>,
        ) : ParseResult()

        data class Failure(val reason: String) : ParseResult()
    }

    fun extractPlayerHash(playerUrl: String): String? {
        for (pattern in PLAYER_HASH_PATTERNS) {
            val match = pattern.find(playerUrl)
            if (match != null) {
                return match.groupValues[1]
            }
        }
        return null
    }

    fun parse(jsonString: String): ParseResult {
        return try {
            val json = Json.parseToJsonElement(jsonString) as? JsonObject
                ?: return ParseResult.Failure("root is not a JSON object")
            val schemaVersionPrim = json["schemaVersion"] as? JsonPrimitive
                ?: return ParseResult.Failure("schemaVersion missing or not an int")
            val schemaVersion = schemaVersionPrim.content.toIntOrNull()
                ?: return ParseResult.Failure("schemaVersion missing or not an int")
            if (schemaVersion <= 0) {
                return ParseResult.Failure("schemaVersion must be positive")
            }
            if (schemaVersion > 1) {
                return ParseResult.Failure("unsupported schemaVersion $schemaVersion (supported: 1)")
            }
            val playersObj = json["players"] as? JsonObject
                ?: return ParseResult.Failure("players missing or not an object")

            val configs = LinkedHashMap<String, HardcodedPlayerConfig>()
            val failed = ArrayList<String>()

            for ((hash, elem) in playersObj) {
                val playerEntry = elem as? JsonObject
                if (playerEntry == null || !HASH_RE.matches(hash)) {
                    failed.add(hash)
                    continue
                }
                val sig = (playerEntry["sig"] as? JsonPrimitive)?.content
                if (sig == null || !SIG_RE.matches(sig)) {
                    failed.add(hash)
                    continue
                }
                val nClass = (playerEntry["nClass"] as? JsonPrimitive)?.content
                if (nClass == null || !NCLASS_RE.matches(nClass)) {
                    failed.add(hash)
                    continue
                }
                val sts = (playerEntry["sts"] as? JsonPrimitive)?.content?.toIntOrNull()
                if (sts == null || sts <= 0) {
                    failed.add(hash)
                    continue
                }
                val aliasesElem = playerEntry["aliases"]
                val aliases = ArrayList<String>()
                if (aliasesElem is JsonArray) {
                    for (aliasElem in aliasesElem) {
                        val a = (aliasElem as? JsonPrimitive)?.content
                        if (a != null && HASH_RE.matches(a)) {
                            aliases.add(a)
                        }
                    }
                }
                val nExpr = "(function(n){try{var u=new g.$nClass('https://x.googlevideo.com/videoplayback?n='+n,true);var t=u.get('n');return(t&&t!==n)?t:n;}catch(e){return n;}})(INPUT)"
                val config = HardcodedPlayerConfig(sig, nExpr, sts)

                val allKeys = aliases + hash
                val duplicate = allKeys.firstOrNull { configs.containsKey(it) }
                    ?: allKeys.groupingBy { it }.eachCount().filter { it.value > 1 }.keys.firstOrNull()

                if (duplicate != null) {
                    return ParseResult.Failure("duplicate hash/alias '$duplicate' (entry $hash)")
                }
                configs[hash] = config
                for (alias in aliases) {
                    configs[alias] = config
                }
            }
            ParseResult.Success(configs, failed)
        } catch (_: Exception) {
            ParseResult.Failure("malformed JSON")
        }
    }

    fun parseLegacySignatureTimestamp(jsonString: String, playerHash: String): Int? {
        val json = runCatching { Json.parseToJsonElement(jsonString) as? JsonObject }.getOrNull() ?: return null
        val hash = (json["playerHash"] as? JsonPrimitive)?.content
        if (hash == null || hash == playerHash) {
            val playerObj = json["player"] as? JsonObject
            positiveInt(json, "signatureTimestamp")?.let { return it }
            positiveInt(json, "sts")?.let { return it }
            if (playerObj != null) {
                positiveInt(playerObj, "signatureTimestamp")?.let { return it }
                positiveInt(playerObj, "sts")?.let { return it }
            }
        }
        return null
    }

    private fun positiveInt(jsonObject: JsonObject, key: String): Int? {
        val prim = jsonObject[key] as? JsonPrimitive ?: return null
        val v = prim.content.toIntOrNull() ?: return null
        return if (v > 0) v else null
    }
}

val LOCALIZED_IAS_PLAYER_URL = Regex("""^https://www\.youtube\.com/s/player/([A-Za-z0-9_-]+)/player_ias\.vflset/[A-Za-z]{2,3}(?:_[A-Za-z]{2,4})?/base\.js$""")

fun canonicalPlayerUrl(playerUrl: String): String {
    val match = LOCALIZED_IAS_PLAYER_URL.matchEntire(playerUrl) ?: return playerUrl
    val hash = match.groupValues[1]
    return "https://www.youtube.com/s/player/$hash/player_ias.vflset/en_GB/base.js"
}
