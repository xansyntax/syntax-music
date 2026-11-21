package com.metrolist.innertube.pages

import com.metrolist.innertube.models.Artist
import com.metrolist.innertube.models.Menu
import com.metrolist.innertube.models.MusicResponsiveListItemRenderer
import com.metrolist.innertube.models.Run

object PageHelper {
    data class LibraryFeedbackTokens(
        val addToken: String?,
        val removeToken: String?,
    )

    private val LIBRARY_ADD_ICONS = setOf("LIBRARY_ADD", "BOOKMARK_BORDER")
    private val LIBRARY_SAVED_ICONS = setOf("LIBRARY_SAVED", "BOOKMARK", "LIBRARY_REMOVE")
    private val ALL_LIBRARY_ICONS = LIBRARY_ADD_ICONS + LIBRARY_SAVED_ICONS
    private val DURATION_REGEX = Regex("""\d{1,2}[:.,]\d{2}(?:[:.,]\d{2})?""")

    fun extractRuns(columns: List<MusicResponsiveListItemRenderer.FlexColumn>, typeFilter: String): List<Run> {
        val result = mutableListOf<Run>()
        for (column in columns) {
            val runs = column.musicResponsiveListItemFlexColumnRenderer?.text?.runs ?: continue
            for (run in runs) {
                val nav = run.navigationEndpoint
                val type = nav?.watchEndpoint?.watchEndpointMusicSupportedConfigs?.watchEndpointMusicConfig?.musicVideoType
                    ?: nav?.browseEndpoint?.browseEndpointContextSupportedConfigs?.browseEndpointContextMusicConfig?.pageType
                if (type != null && type.contains(typeFilter)) {
                    result.add(run)
                }
            }
        }
        return result
    }

    fun extractArtists(runs: List<Run>?): List<Artist> {
        if (runs.isNullOrEmpty()) return emptyList()
        val result = mutableListOf<Artist>()
        for (run in runs) {
            val browse = run.navigationEndpoint?.browseEndpoint ?: continue
            val browseId = browse.browseId ?: continue
            val pageType = browse.browseEndpointContextSupportedConfigs?.browseEndpointContextMusicConfig?.pageType
            val name = run.text.orEmpty().trim()
            if (name.isNotBlank() && (
                    pageType == "MUSIC_PAGE_TYPE_ARTIST" ||
                    pageType == "MUSIC_PAGE_TYPE_LIBRARY_ARTIST" ||
                    pageType == "MUSIC_PAGE_TYPE_USER_CHANNEL" ||
                    (pageType == null && browseId.startsWith("UC"))
                )
            ) {
                result.add(Artist(id = browseId, name = name))
            }
        }
        return result
    }

    fun extractDuration(runs: List<Run>): Int? {
        for (run in runs) {
            val text = run.text.orEmpty().trim()
            if (DURATION_REGEX.matches(text)) {
                val parts = text.split(":", ".", ",").mapNotNull { it.toIntOrNull() }
                return when (parts.size) {
                    2 -> parts[0] * 60 + parts[1]
                    3 -> parts[0] * 3600 + parts[1] * 60 + parts[2]
                    else -> null
                }
            }
        }
        return null
    }

    fun isLibraryIcon(iconType: String?): Boolean =
        iconType != null &&
            iconType != "KEEP" &&
            iconType != "KEEP_OFF" &&
            (iconType in ALL_LIBRARY_ICONS || iconType.startsWith("LIBRARY_"))

    fun extractLibraryTokensFromMenuItems(items: List<Menu.MenuRenderer.Item>?): LibraryFeedbackTokens {
        if (items.isNullOrEmpty()) return LibraryFeedbackTokens(null, null)
        var addToken: String? = null
        var removeToken: String? = null
        for (item in items) {
            val toggle = item.toggleMenuServiceItemRenderer ?: continue
            val iconType = toggle.defaultIcon?.iconType ?: continue
            if (iconType == "KEEP" || iconType == "KEEP_OFF" || !isLibraryIcon(iconType)) continue
            val defaultToken = toggle.defaultServiceEndpoint?.feedbackEndpoint?.feedbackToken
            val toggledToken = toggle.toggledServiceEndpoint?.feedbackEndpoint?.feedbackToken
            if (iconType in LIBRARY_ADD_ICONS) {
                if (addToken == null) addToken = defaultToken
                if (removeToken == null) removeToken = toggledToken
            } else if (iconType in LIBRARY_SAVED_ICONS) {
                if (removeToken == null) removeToken = defaultToken
                if (addToken == null) addToken = toggledToken
            }
        }
        return LibraryFeedbackTokens(addToken, removeToken)
    }
}
