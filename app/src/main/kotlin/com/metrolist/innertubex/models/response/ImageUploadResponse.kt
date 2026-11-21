package com.metrolist.innertubex.models.response

import kotlinx.serialization.Serializable
import com.metrolist.innertubex.models.*

@Serializable
data class ImageUploadResponse(
    val encryptedBlobId: String? = null,
)
