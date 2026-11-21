package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class SectionListRenderer(
    val contents: List<Content>? = null,
    val continuations: List<Continuation>? = null,
    val header: Header? = null,
) {

    @Serializable
    data class Header(
        val chipCloudRenderer: ChipCloudRenderer? = null,
    ) {

        @Serializable
        data class ChipCloudRenderer(
            val chips: List<Chip>? = null,
        ) {

            @Serializable
            data class Chip(
                val chipCloudChipRenderer: ChipCloudChipRenderer? = null,
            ) {

                @Serializable
                data class ChipCloudChipRenderer(
                    val isSelected: Boolean = false,
                    val navigationEndpoint: NavigationEndpoint? = null,
                    val onDeselectedCommand: NavigationEndpoint? = null,
                    val text: Runs? = null,
                    val uniqueId: String? = null,
                )
            }
        }
    }

    @Serializable
    data class Content(
        val gridRenderer: GridRenderer? = null,
        val itemSectionRenderer: ItemSectionRenderer? = null,
        val musicCardShelfRenderer: MusicCardShelfRenderer? = null,
        val musicCarouselShelfRenderer: MusicCarouselShelfRenderer? = null,
        val musicDescriptionShelfRenderer: MusicDescriptionShelfRenderer? = null,
        val musicEditablePlaylistDetailHeaderRenderer: MusicEditablePlaylistDetailHeaderRenderer? = null,
        val musicPlaylistShelfRenderer: MusicPlaylistShelfRenderer? = null,
        val musicResponsiveHeaderRenderer: MusicResponsiveHeaderRenderer? = null,
        val musicShelfRenderer: MusicShelfRenderer? = null,
    )
}
