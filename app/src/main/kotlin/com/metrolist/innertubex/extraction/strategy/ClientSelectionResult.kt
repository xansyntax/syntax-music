package com.metrolist.innertubex.extraction.strategy

data class ClientSelectionResult(
    val candidates: List<SelectedClient>,
    val rejected: List<RejectedClient>,
)
