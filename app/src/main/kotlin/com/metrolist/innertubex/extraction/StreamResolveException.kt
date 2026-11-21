package com.metrolist.innertubex.extraction

class StreamResolveException(
    val reason: Reason,
    message: String,
    cause: Throwable? = null,
    val diagnostics: StreamDiagnostics,
) : IllegalStateException(message, cause) {
    enum class Reason {
        NO_PLAYABLE_STREAM,
        EXPLICIT_UNSUPPORTED,
        UNAVAILABLE,
        AGE_RESTRICTED,
        NO_MUSIC_VIDEO,
        NETWORK,
        UNKNOWN
    }
}
