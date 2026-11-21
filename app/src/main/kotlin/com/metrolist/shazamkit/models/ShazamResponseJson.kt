package com.metrolist.shazamkit.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ShazamResponseJson(
    val matches: List<Match> = emptyList(),
    val location: Location? = null,
    val timestamp: Long? = null,
    val timezone: String? = null,
    val track: Track? = null,
    val tagid: String? = null,
) {
    @Serializable
    data class Match(
        val id: String? = null,
        val offset: Double? = null,
        val timeskew: Double? = null,
        val frequencyskew: Double? = null,
    )

    @Serializable
    data class Location(
        val accuracy: Double? = null,
        val altitude: Double? = null,
        val latitude: Double? = null,
        val longitude: Double? = null,
    )

    @Serializable
    data class Track(
        val layout: String? = null,
        val type: String? = null,
        val key: String? = null,
        val title: String? = null,
        val subtitle: String? = null,
        val images: Images? = null,
        val share: Share? = null,
        val hub: Hub? = null,
        val sections: List<Section>? = null,
        val url: String? = null,
        val artists: List<Artist>? = null,
        val isrc: String? = null,
        val genres: Genres? = null,
        val albumadamid: String? = null,
        val relatedtracksurl: String? = null,
    ) {
        @Serializable
        data class Images(
            val background: String? = null,
            val coverart: String? = null,
            val coverarthq: String? = null,
            val joecolor: String? = null,
        )

        @Serializable
        data class Share(
            val subject: String? = null,
            val text: String? = null,
            val href: String? = null,
            val image: String? = null,
            val twitter: String? = null,
            val html: String? = null,
            val avatar: String? = null,
            val snapchat: String? = null,
        )

        @Serializable
        data class Hub(
            val type: String? = null,
            val image: String? = null,
            val actions: List<Action>? = null,
            val options: List<Option>? = null,
            val providers: List<Provider>? = null,
            val explicit: Boolean? = null,
            val displayname: String? = null,
        ) {
            @Serializable
            data class Action(
                val name: String? = null,
                val type: String? = null,
                val id: String? = null,
                val uri: String? = null,
            )

            @Serializable
            data class Option(
                val caption: String? = null,
                val actions: List<OptionAction>? = null,
                val beacondata: Beacondata? = null,
                val image: String? = null,
                val type: String? = null,
                val listcaption: String? = null,
                val overflowimage: String? = null,
                val colouroverflowimage: Boolean? = null,
                val providername: String? = null,
            ) {
                @Serializable
                data class OptionAction(
                    val name: String? = null,
                    val type: String? = null,
                    val uri: String? = null,
                )

                @Serializable
                data class Beacondata(
                    val type: String? = null,
                    val providername: String? = null,
                )
            }

            @Serializable
            data class Provider(
                val caption: String? = null,
                val images: ProviderImages? = null,
                val actions: List<ProviderAction>? = null,
                val type: String? = null,
            ) {
                @Serializable
                data class ProviderImages(
                    val overflow: String? = null,
                    @SerialName("default") val defaultImage: String? = null,
                )

                @Serializable
                data class ProviderAction(
                    val name: String? = null,
                    val type: String? = null,
                    val uri: String? = null,
                )
            }
        }

        @Serializable
        data class Section(
            val type: String? = null,
            val metapages: List<Metapage>? = null,
            val tabname: String? = null,
            val metadata: List<Metadata>? = null,
            val text: List<String>? = null,
            val url: String? = null,
        ) {
            @Serializable
            data class Metapage(
                val image: String? = null,
                val caption: String? = null,
            )

            @Serializable
            data class Metadata(
                val title: String? = null,
                val text: String? = null,
            )
        }

        @Serializable
        data class Artist(
            val id: String? = null,
            val adamid: String? = null,
        )

        @Serializable
        data class Genres(
            val primary: String? = null,
        )
    }
}
