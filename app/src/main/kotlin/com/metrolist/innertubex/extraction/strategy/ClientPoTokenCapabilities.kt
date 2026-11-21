package com.metrolist.innertubex.extraction.strategy

data class ClientPoTokenCapabilities(
    val player: PoTokenRule = PoTokenRule(),
    val gvs: PoTokenRule = PoTokenRule(),
    val subtitles: PoTokenRule = PoTokenRule(),
)
