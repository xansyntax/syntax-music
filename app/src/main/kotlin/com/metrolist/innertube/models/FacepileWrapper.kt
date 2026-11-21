package com.metrolist.innertube.models

import kotlinx.serialization.Serializable

@Serializable
data class FacepileWrapper(
    val avatarStackViewModel: AvatarStackViewModel? = null,
)
