package com.metrolist.innertube.models.response

import kotlinx.serialization.Serializable
import com.metrolist.innertube.models.*

@Serializable
data class BrowseResponse(
    val background: ThumbnailRenderer? = null,
    val contents: Contents? = null,
    val continuationContents: ContinuationContents? = null,
    val header: Header? = null,
    val microformat: Microformat? = null,
    val onResponseReceivedActions: List<ResponseAction>? = null,
    val responseContext: ResponseContext? = null,
) {

    @Serializable
    data class Contents(
        val sectionListRenderer: SectionListRenderer? = null,
        val singleColumnBrowseResultsRenderer: Tabs? = null,
        val twoColumnBrowseResultsRenderer: TwoColumnBrowseResultsRenderer? = null,
    )

    @Serializable
    data class ContinuationContents(
        val gridContinuation: GridContinuation? = null,
        val musicPlaylistShelfContinuation: MusicPlaylistShelfContinuation? = null,
        val musicShelfContinuation: MusicShelfRenderer? = null,
        val sectionListContinuation: SectionListContinuation? = null,
    ) {

        @Serializable
        data class GridContinuation(
            val continuations: List<Continuation>? = null,
            val items: List<GridRenderer.Item>? = null,
        )

        @Serializable
        data class MusicPlaylistShelfContinuation(
            val contents: List<MusicShelfRenderer.Content>? = null,
            val continuations: List<Continuation>? = null,
        )

        @Serializable
        data class SectionListContinuation(
            val contents: List<SectionListRenderer.Content>? = null,
            val continuations: List<Continuation>? = null,
        )
    }

    @Serializable
    data class Header(
        val musicDetailHeaderRenderer: MusicDetailHeaderRenderer? = null,
        val musicEditablePlaylistDetailHeaderRenderer: MusicEditablePlaylistDetailHeaderRenderer? = null,
        val musicHeaderRenderer: MusicHeaderRenderer? = null,
        val musicImmersiveHeaderRenderer: MusicImmersiveHeaderRenderer? = null,
        val musicVisualHeaderRenderer: MusicVisualHeaderRenderer? = null,
    ) {

        @Serializable
        data class Buttons(
            val menuRenderer: Menu.MenuRenderer? = null,
        )

        @Serializable
        data class MusicHeaderRenderer(
            val buttons: List<Buttons>? = null,
            val secondSubtitle: Runs? = null,
            val straplineTextOne: Runs? = null,
            val straplineThumbnail: MusicThumbnailRenderer? = null,
            val subtitle: Runs? = null,
            val thumbnail: MusicThumbnailRenderer? = null,
            val title: Runs? = null,
        )

        @Serializable
        data class MusicImmersiveHeaderRenderer(
            val description: Runs? = null,
            val menu: Menu? = null,
            val monthlyListenerCount: Runs? = null,
            val playButton: Button? = null,
            val startRadioButton: Button? = null,
            val subscriptionButton: SubscriptionButton? = null,
            val subscriptionButton2: SubscriptionButton2? = null,
            val thumbnail: ThumbnailRenderer? = null,
            val title: Runs? = null,
        ) {

            @Serializable
            data class SubscriptionButton2(
                val subscribeButtonRenderer: SubscribeButtonRenderer? = null,
            ) {

                @Serializable
                data class SubscribeButtonRenderer(
                    val subscriberCountWithSubscribeText: Runs? = null,
                )
            }
        }

        @Serializable
        data class MusicThumbnail(
            val url: String? = null,
        )

        @Serializable
        data class MusicThumbnailRenderer(
            val musicThumbnailRenderer: MusicThumbnailRenderer? = null,
            val thumbnails: List<MusicThumbnail>? = null,
        )

        @Serializable
        data class MusicVisualHeaderRenderer(
            val foregroundThumbnail: ThumbnailRenderer? = null,
            val subscriptionButton: SubscriptionButton? = null,
            val thumbnail: ThumbnailRenderer? = null,
            val title: Runs? = null,
        )
    }

    @Serializable
    data class Microformat(
        val microformatDataRenderer: MicroformatDataRenderer? = null,
    ) {

        @Serializable
        data class MicroformatDataRenderer(
            val urlCanonical: String? = null,
        )
    }

    @Serializable
    data class ResponseAction(
        val appendContinuationItemsAction: ContinuationItems? = null,
    ) {

        @Serializable
        data class ContinuationItems(
            val continuationItems: List<MusicShelfRenderer.Content>? = null,
        )
    }

    @Serializable
    data class SecondaryContents(
        val sectionListRenderer: SectionListRenderer? = null,
    )

    @Serializable
    data class TwoColumnBrowseResultsRenderer(
        val secondaryContents: SecondaryContents? = null,
        val tabs: List<Tabs.Tab>? = null,
    )
}
