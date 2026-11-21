package com.metrolist.innertubex.extraction.strategy

import com.metrolist.innertubex.models.PoTokenBinding

data class PoTokenRule(
    val requirement: PoTokenRequirement = PoTokenRequirement.NONE,
    val binding: PoTokenBinding? = null,
    val providers: Set<PoTokenProviderKind> = emptySet(),
    val premiumMayBypass: Boolean = false,
) {
    init {
        if (requirement != PoTokenRequirement.NONE && binding == null) {
            error("A PO token rule must declare its content binding")
        }
        if (requirement != PoTokenRequirement.NONE && providers.isEmpty()) {
            error("A PO token rule must declare at least one compatible provider")
        }
    }
}
