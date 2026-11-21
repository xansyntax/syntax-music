package com.metrolist.innertubex.extraction

data class PlayerResponseBatch(
    val playableResponses: List<ClientResult>,
    val failures: List<PlayabilityFailure>,
    val requestFailures: List<Throwable>,
    val attempts: List<StreamAttemptDiagnostic>,
)
