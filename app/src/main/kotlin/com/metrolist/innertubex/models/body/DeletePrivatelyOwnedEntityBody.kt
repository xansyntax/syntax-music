package com.metrolist.innertubex.models.body

import kotlinx.serialization.Serializable
import com.metrolist.innertubex.models.*

@Serializable
data class DeletePrivatelyOwnedEntityBody(
    val context: Context? = null,
    val entityId: String? = null,
)
