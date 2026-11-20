package com.metrolist.innertubex.extraction;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.models.response.PlayerResponse;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ClientResult {
    public final boolean bearerAuthenticated;
    public final int clientId;
    public final String clientName;
    public final String clientVersion;
    public final String profileId;
    public final PlayerResponse response;
    public final String streamingDataPoToken;
    public final boolean useSabr;
    public final boolean usedPoToken;
    public final String userAgent;

    public ClientResult(String str, String str2, String str3, PlayerResponse playerResponse, boolean z, String str4, int i, String str5, boolean z2, int i2) {
        z = (i2 & 16) != 0 ? false : z;
        str4 = (i2 & 32) != 0 ? null : str4;
        z2 = (i2 & 256) != 0 ? false : z2;
        boolean z3 = (i2 & 512) == 0;
        str.getClass();
        str2.getClass();
        str3.getClass();
        playerResponse.getClass();
        str5.getClass();
        this.clientName = str;
        this.profileId = str2;
        this.userAgent = str3;
        this.response = playerResponse;
        this.usedPoToken = z;
        this.streamingDataPoToken = str4;
        this.clientId = i;
        this.clientVersion = str5;
        this.useSabr = z2;
        this.bearerAuthenticated = z3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClientResult)) {
            return false;
        }
        ClientResult clientResult = (ClientResult) obj;
        return Intrinsics.areEqual(this.clientName, clientResult.clientName) && Intrinsics.areEqual(this.profileId, clientResult.profileId) && Intrinsics.areEqual(this.userAgent, clientResult.userAgent) && Intrinsics.areEqual(this.response, clientResult.response) && this.usedPoToken == clientResult.usedPoToken && Intrinsics.areEqual(this.streamingDataPoToken, clientResult.streamingDataPoToken) && this.clientId == clientResult.clientId && this.clientVersion.equals(clientResult.clientVersion) && this.useSabr == clientResult.useSabr && this.bearerAuthenticated == clientResult.bearerAuthenticated;
    }

    public final int hashCode() {
        int iM = IntIntPair$$ExternalSyntheticOutline0.m((this.response.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.clientName.hashCode() * 31, 31, this.profileId), 31, this.userAgent)) * 31, this.usedPoToken, 31);
        String str = this.streamingDataPoToken;
        return Boolean.hashCode(this.bearerAuthenticated) + IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.clientId, (iM + (str == null ? 0 : str.hashCode())) * 31, 31), 31, this.clientVersion), this.useSabr, 31);
    }

    public final String toString() {
        String strPresence = CollectionsKt__IterablesKt.presence(this.streamingDataPoToken);
        String strPresence2 = CollectionsKt__IterablesKt.presence(this.clientVersion);
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("ClientResult(clientName=", this.clientName, ", profileId=", this.profileId, ", usedPoToken=");
        sbM.append(this.usedPoToken);
        sbM.append(", streamingDataPoToken=");
        sbM.append(strPresence);
        sbM.append(", clientId=");
        sbM.append(this.clientId);
        sbM.append(", clientVersion=");
        sbM.append(strPresence2);
        sbM.append(", useSabr=");
        sbM.append(this.useSabr);
        sbM.append(", bearerAuthenticated=");
        sbM.append(this.bearerAuthenticated);
        sbM.append(")");
        return sbM.toString();
    }
}
