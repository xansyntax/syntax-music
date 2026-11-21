package com.metrolist.innertubex

fun interface InnerTubeLogger {
    fun log(event: InnerTubeLogEvent)

    companion object {
        val NONE = InnerTubeLogger { }
    }
}

fun InnerTubeLogger.d(
    tag: String,
    message: String,
    details: Map<String, String> = emptyMap(),
    mediaId: String? = null,
) {
    log(InnerTubeLogEvent(InnerTubeLogLevel.DEBUG, tag, message, mediaId, details))
}

fun InnerTubeLogger.i(
    tag: String,
    message: String,
    details: Map<String, String> = emptyMap(),
    mediaId: String? = null,
) {
    log(InnerTubeLogEvent(InnerTubeLogLevel.INFO, tag, message, mediaId, details))
}

fun InnerTubeLogger.w(
    tag: String,
    message: String,
    details: Map<String, String> = emptyMap(),
    mediaId: String? = null,
) {
    log(InnerTubeLogEvent(InnerTubeLogLevel.WARN, tag, message, mediaId, details))
}

fun InnerTubeLogger.e(
    tag: String,
    message: String,
    details: Map<String, String> = emptyMap(),
    mediaId: String? = null,
) {
    log(InnerTubeLogEvent(InnerTubeLogLevel.ERROR, tag, message, mediaId, details))
}
