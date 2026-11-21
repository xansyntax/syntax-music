package com.metrolist.innertubex.extraction.strategy

interface ClientHealthMonitor {
    companion object {
        val NONE: ClientHealthMonitor = object : ClientHealthMonitor {}
    }
}
