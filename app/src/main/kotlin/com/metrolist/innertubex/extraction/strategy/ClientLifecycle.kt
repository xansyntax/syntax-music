package com.metrolist.innertubex.extraction.strategy

enum class ClientLifecycle {
    STABLE,
    CANARY,
    EXPERIMENTAL,
    UNRELEASED,
    DEPRECATED,
    BROKEN
}
