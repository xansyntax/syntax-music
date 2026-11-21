package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class AvatarStackViewModel(
    val avatars: List<Avatar>? = null,
    val rendererContext: RendererContext? = null,
    val text: AvatarText? = null,
) {

    @Serializable
    data class Avatar(
        val avatarViewModel: AvatarViewModel? = null,
    )

    @Serializable
    data class AvatarImage(
        val sources: List<ImageSource>? = null,
    )

    @Serializable
    data class AvatarText(
        val content: String? = null,
    )

    @Serializable
    data class AvatarViewModel(
        val image: AvatarImage? = null,
    )

    @Serializable
    data class BrowseEndpoint(
        val browseId: String? = null,
    )

    @Serializable
    data class CommandContext(
        val onTap: OnTap? = null,
    )

    @Serializable
    data class ImageSource(
        val url: String? = null,
    )

    @Serializable
    data class InnerTubeBrowseCommand(
        val browseEndpoint: BrowseEndpoint? = null,
    )

    @Serializable
    data class OnTap(
        val innertubeCommand: InnerTubeBrowseCommand? = null,
    )

    @Serializable
    data class RendererContext(
        val commandContext: CommandContext? = null,
    )
}
