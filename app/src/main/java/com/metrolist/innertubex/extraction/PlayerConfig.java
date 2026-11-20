package com.metrolist.innertubex.extraction;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlayerConfig {
    public final String clientVersion;
    public final String encryptedHostFlags;
    public final String playerUrl;
    public final Integer signatureTimestamp;
    public final String visitorData;

    public PlayerConfig(String str, Integer num, String str2, String str3, String str4) {
        str.getClass();
        this.playerUrl = str;
        this.signatureTimestamp = num;
        this.visitorData = str2;
        this.clientVersion = str3;
        this.encryptedHostFlags = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayerConfig)) {
            return false;
        }
        PlayerConfig playerConfig = (PlayerConfig) obj;
        return Intrinsics.areEqual(this.playerUrl, playerConfig.playerUrl) && Intrinsics.areEqual(this.signatureTimestamp, playerConfig.signatureTimestamp) && Intrinsics.areEqual(this.visitorData, playerConfig.visitorData) && Intrinsics.areEqual(this.clientVersion, playerConfig.clientVersion) && Intrinsics.areEqual(this.encryptedHostFlags, playerConfig.encryptedHostFlags);
    }

    public final int hashCode() {
        int iHashCode = this.playerUrl.hashCode() * 31;
        Integer num = this.signatureTimestamp;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.visitorData;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.clientVersion;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.encryptedHostFlags;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        String strPresence = CollectionsKt__IterablesKt.presence(this.playerUrl);
        boolean z = this.signatureTimestamp != null;
        String strPresence2 = CollectionsKt__IterablesKt.presence(this.visitorData);
        String strPresence3 = CollectionsKt__IterablesKt.presence(this.clientVersion);
        String strPresence4 = CollectionsKt__IterablesKt.presence(this.encryptedHostFlags);
        StringBuilder sb = new StringBuilder("PlayerConfig(playerUrl=");
        sb.append(strPresence);
        sb.append(", signatureTimestamp=");
        sb.append(z);
        sb.append(", visitorData=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, strPresence2, ", clientVersion=", strPresence3, ", encryptedHostFlags=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, strPresence4, ")");
    }
}
