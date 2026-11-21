package com.metrolist.innertubex.extraction

data class PlayerConfig(
    val playerUrl: String,
    val signatureTimestamp: Int?,
    val visitorData: String?,
    val clientVersion: String?,
    val encryptedHostFlags: String?,
) {
    override fun toString(): String {
        val pUrl = if (playerUrl.isNotEmpty()) "present" else "missing"
        val hasSig = signatureTimestamp != null
        val vData = if (!visitorData.isNullOrEmpty()) "present" else "missing"
        val cVer = if (!clientVersion.isNullOrEmpty()) "present" else "missing"
        val flags = if (!encryptedHostFlags.isNullOrEmpty()) "present" else "missing"
        return "PlayerConfig(playerUrl=$pUrl, signatureTimestamp=$hasSig, visitorData=$vData, clientVersion=$cVer, encryptedHostFlags=$flags)"
    }
}
