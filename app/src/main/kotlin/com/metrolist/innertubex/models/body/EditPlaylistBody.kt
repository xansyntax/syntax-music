package com.metrolist.innertubex.models.body

import com.metrolist.innertubex.models.Context
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EditPlaylistBody(
    val context: Context,
    val playlistId: String,
    val actions: List<Action>,
) {
    @Serializable
    sealed class Action {
        @Serializable
        @SerialName("ACTION_ADD_VIDEO")
        data class AddVideoAction(
            val action: String = "ACTION_ADD_VIDEO",
            val addedVideoId: String,
        ) : Action()

        @Serializable
        @SerialName("ACTION_REMOVE_VIDEO")
        data class RemoveVideoAction(
            val action: String = "ACTION_REMOVE_VIDEO",
            val removedVideoId: String? = null,
            val setVideoId: String? = null,
        ) : Action()

        @Serializable
        @SerialName("ACTION_MOVE_VIDEO_BEFORE")
        data class MoveVideoAction(
            val action: String = "ACTION_MOVE_VIDEO_BEFORE",
            val movedSetVideoIdPredecessor: String? = null,
            val setVideoId: String,
        ) : Action()

        @Serializable
        @SerialName("ACTION_SET_PLAYLIST_NAME")
        data class SetPlaylistNameAction(
            val action: String = "ACTION_SET_PLAYLIST_NAME",
            val playlistName: String,
        ) : Action()

        @Serializable
        @SerialName("ACTION_SET_CUSTOM_THUMBNAIL")
        data class SetCustomThumbnailAction(
            val action: String = "ACTION_SET_CUSTOM_THUMBNAIL",
            val addedCustomThumbnail: AddedCustomThumbnail,
        ) : Action() {
            @Serializable
            data class AddedCustomThumbnail(
                val imageKey: ImageKey,
                val imageType: String = "PLAYLIST_IMAGE_TYPE_CUSTOM_THUMBNAIL",
            ) {
                @Serializable
                data class ImageKey(
                    val name: String,
                    val type: String = "PLAYLIST_IMAGE_KEY_TYPE_CUSTOM_THUMBNAIL",
                )
            }
        }

        @Serializable
        @SerialName("ACTION_REMOVE_CUSTOM_THUMBNAIL")
        data class RemoveCustomThumbnailAction(
            val action: String = "ACTION_REMOVE_CUSTOM_THUMBNAIL",
        ) : Action()
    }
}
