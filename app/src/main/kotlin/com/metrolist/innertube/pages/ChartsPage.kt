package com.metrolist.innertube.pages

import com.metrolist.innertube.models.YTItem

data class ChartsPage(
    val continuation: String?,
    val sections: List<ChartSection>,
) {
    enum class ChartType {
        TRENDING,
        TOP,
        NEW_RELEASES,
        GENRE,
    }

    data class ChartSection(
        val title: String,
        val items: List<YTItem>,
        val chartType: ChartType,
    )
}
