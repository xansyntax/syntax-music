package com.metrolist.innertube.models

sealed class YTItem {
    abstract val id: String
    abstract val title: String
    abstract val thumbnail: String
    open val explicit: Boolean = false
}
