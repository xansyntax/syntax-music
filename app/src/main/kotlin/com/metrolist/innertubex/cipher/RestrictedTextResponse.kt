package com.metrolist.innertubex.cipher

import io.ktor.http.Headers
import io.ktor.http.HttpStatusCode

data class RestrictedTextResponse(
    val status: HttpStatusCode,
    val headers: Headers,
    val body: String?,
)
