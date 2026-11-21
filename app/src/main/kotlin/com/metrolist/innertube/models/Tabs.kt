package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class Tabs(
    val tabs: List<Tab>? = null,
) {

    @Serializable
    data class Tab(
        val tabRenderer: TabRenderer? = null,
    ) {

        @Serializable
        data class TabRenderer(
            val content: Content? = null,
            val endpoint: NavigationEndpoint? = null,
            val title: String? = null,
        ) {

            @Serializable
            data class Content(
                val musicQueueRenderer: MusicQueueRenderer? = null,
                val sectionListRenderer: SectionListRenderer? = null,
            )
        }
    }
}
