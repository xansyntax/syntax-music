package com.metrolist.innertube.pages

import com.metrolist.innertube.models.YTItem

data class SearchSummary(
    val title: String,
    val items: List<YTItem>,
)
