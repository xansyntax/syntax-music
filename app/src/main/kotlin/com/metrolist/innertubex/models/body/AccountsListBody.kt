package com.metrolist.innertubex.models.body

import kotlinx.serialization.Serializable
import com.metrolist.innertubex.models.*

@Serializable
data class AccountsListBody(
    val callCircumstance: String? = null,
    val context: Context? = null,
    val requestType: String? = null,
)
