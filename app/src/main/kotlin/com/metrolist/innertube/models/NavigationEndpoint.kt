package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class NavigationEndpoint(
    val browseEndpoint: BrowseEndpoint? = null,
    val confirmDialogEndpoint: ConfirmDialogEndpoint? = null,
    val deletePrivatelyOwnedEntityCommand: DeletePrivatelyOwnedEntityCommand? = null,
    val feedbackEndpoint: FeedbackEndpoint? = null,
    val queueAddEndpoint: QueueAddEndpoint? = null,
    val searchEndpoint: SearchEndpoint? = null,
    val shareEntityEndpoint: ShareEntityEndpoint? = null,
    val urlEndpoint: UrlEndpoint? = null,
    val watchEndpoint: WatchEndpoint? = null,
    val watchPlaylistEndpoint: WatchEndpoint? = null,
) {

    @Serializable
    data class ConfirmDialogEndpoint(
        val content: ConfirmDialogContent? = null,
    ) {

        @Serializable
        data class ConfirmButton(
            val buttonRenderer: ConfirmButtonRenderer? = null,
        )

        @Serializable
        data class ConfirmButtonRenderer(
            val command: ConfirmCommand? = null,
        )

        @Serializable
        data class ConfirmCommand(
            val musicDeletePrivatelyOwnedEntityCommand: DeletePrivatelyOwnedEntityCommand? = null,
        )

        @Serializable
        data class ConfirmDialogContent(
            val confirmDialogRenderer: ConfirmDialogRenderer? = null,
        )

        @Serializable
        data class ConfirmDialogRenderer(
            val confirmButton: ConfirmButton? = null,
        )
    }

    @Serializable
    data class DeletePrivatelyOwnedEntityCommand(
        val entityId: String? = null,
    )
}

fun NavigationEndpoint.getMusicVideoType(): String? =
    watchEndpoint?.watchEndpointMusicSupportedConfigs?.watchEndpointMusicConfig?.musicVideoType
        ?: watchPlaylistEndpoint?.watchEndpointMusicSupportedConfigs?.watchEndpointMusicConfig?.musicVideoType
