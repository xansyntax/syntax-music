package com.metrolist.innertube.pages

import com.metrolist.innertube.models.YTItem

data class SearchResult(
    val items: List<YTItem>,
    val continuation: String?,
)
