package com.metrolist.innertubex.extraction.strategy

data class ClientRequestCapabilities(
    val signatureTimestamp: Boolean,
    val signatureCipher: JavaScriptRequirement = JavaScriptRequirement.NEVER,
    val nTransform: JavaScriptRequirement = JavaScriptRequirement.NEVER,
    val webView: WebViewRequirement = WebViewRequirement.NONE,
    val cookies: Boolean = false,
    val embedded: Boolean = false,
    val encryptedHostFlags: Boolean = false,
)
