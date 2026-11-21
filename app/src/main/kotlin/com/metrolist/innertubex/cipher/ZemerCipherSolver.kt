package com.metrolist.innertubex.cipher

import kotlin.coroutines.cancellation.CancellationException

class ZemerCipherSolver(val engine: QuickJsEngine) {
    suspend fun call(name: String, arg: String): String? {
        return try {
            engine.callFunction(name, arg)
        } catch (e: CancellationException) {
            throw e
        } catch (_: Exception) {
            null
        }
    }

    suspend fun solveN(n: String): String? {
        val result = call("_nTransformFunc", n)
        if (result == null || result.isBlank() || result == n) {
            return null
        }
        return result
    }

    suspend fun solveSignature(sig: String): String? {
        val result = call("_cipherSigFunc", sig)
        if (result == null || result.isBlank()) {
            return null
        }
        return result
    }

    companion object {
        val VALID_N_RESULT = Regex("^[A-Za-z0-9_-]+$")

        fun buildModifiedPlayerScript(
            playerScript: String,
            config: RemotePlayerConfigParser.HardcodedPlayerConfig,
        ): String {
            val sigCode = config.sigJsExpression.replace("INPUT", "sig")
            val nCode = config.nJsExpression.replace("INPUT", "n")
            val injection = "; window._cipherSigFunc=function(sig){try{return $sigCode;}catch(e){return null;}};window._nTransformFunc=function(n){try{return $nCode;}catch(e){return n;}}; "
            return if (playerScript.contains("})(_yt_player);")) {
                playerScript.replace("})(_yt_player);", "$injection })(_yt_player);")
            } else {
                "$playerScript\n$injection"
            }
        }

        suspend fun create(
            playerScript: String,
            config: RemotePlayerConfigParser.HardcodedPlayerConfig,
        ): ZemerCipherSolver {
            val engine = QuickJsEngine()
            try {
                engine.initialize()
                engine.execute(
                    """
                    if (typeof globalThis.XMLHttpRequest === "undefined") {
                        globalThis.XMLHttpRequest = { prototype: {} };
                    }
                    if (typeof URL === "undefined") {
                        globalThis.location = {
                            hash: "",
                            host: "www.youtube.com",
                            hostname: "www.youtube.com",
                            href: "https://www.youtube.com/watch?v=yt-dlp-wins",
                            origin: "https://www.youtube.com",
                            password: "",
                            pathname: "/watch",
                            port: "",
                            protocol: "https:",
                            search: "?v=yt-dlp-wins",
                            username: "",
                        };
                    } else {
                        globalThis.location = new URL("https://www.youtube.com/watch?v=yt-dlp-wins");
                    }
                    if (typeof globalThis.document === "undefined") {
                        globalThis.document = Object.create(null);
                    }
                    if (typeof globalThis.navigator === "undefined") {
                        globalThis.navigator = Object.create(null);
                    }
                    if (typeof globalThis.self === "undefined") {
                        globalThis.self = globalThis;
                    }
                    if (typeof globalThis.window === "undefined") {
                        globalThis.window = globalThis;
                    }
                    if (typeof globalThis.Intl === "undefined") {
                        const NumberFormat = function(locale, options) {
                            this.options = options || {};
                        };
                        NumberFormat.supportedLocalesOf = function(locales) {
                            return Array.isArray(locales) ? locales : [locales];
                        };
                        NumberFormat.prototype.format = function(value) {
                            let formatted = String(value);
                            const minimumDigits = this.options.minimumIntegerDigits || 0;
                            while (formatted.length < minimumDigits) formatted = "0" + formatted;
                            return formatted;
                        };
                        const DateTimeFormat = function() {};
                        DateTimeFormat.prototype.resolvedOptions = function() {
                            return { timeZone: "UTC" };
                        };
                        DateTimeFormat.prototype.format = function(value) {
                            return String(value);
                        };
                        globalThis.Intl = { NumberFormat, DateTimeFormat };
                    }
                    """.trimIndent()
                )
                engine.execute("globalThis._yt_player = globalThis._yt_player || {};")
                val modifiedScript = buildModifiedPlayerScript(playerScript, config)
                engine.execute(modifiedScript)

                val probe = engine.callFunction("_nTransformFunc", "KdrqFlzJXl9EcCwlmEy")
                if (probe == null || probe == "KdrqFlzJXl9EcCwlmEy" || probe.length < 5 || !VALID_N_RESULT.matches(probe)) {
                    error("Faraday n-transform probe failed")
                }
                return ZemerCipherSolver(engine)
            } catch (e: CancellationException) {
                engine.dispose()
                throw e
            } catch (e: Exception) {
                engine.dispose()
                throw e
            }
        }
    }
}
