package com.metrolist.innertube.pages

import com.metrolist.innertube.models.MusicResponsiveListItemRenderer
import com.metrolist.innertube.models.YTItem

object SearchSuggestionPage {
    fun fromMusicResponsiveListItemRenderer(renderer: MusicResponsiveListItemRenderer): YTItem? =
        SearchPage.toYTItem(renderer)
}
