package com.metrolist.innertubex

import io.ktor.http.HttpStatusCode

class InnerTubeHttpException(
    operation: String,
    statusCode: HttpStatusCode,
) : IllegalStateException("$operation failed with HTTP ${statusCode.value}")
