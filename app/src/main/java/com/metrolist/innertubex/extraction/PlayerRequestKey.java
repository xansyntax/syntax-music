package com.metrolist.innertubex.extraction;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.InnerTube;
import com.metrolist.innertubex.models.YouTubeClient;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlayerRequestKey {
    public final YouTubeClient client;
    public final String encryptedHostFlags;
    public final String poToken;
    public final InnerTube.SessionSnapshot requestSession;
    public final Integer signatureTimestamp;
    public final String videoId;

    public PlayerRequestKey(YouTubeClient youTubeClient, String str, Integer num, String str2, InnerTube.SessionSnapshot sessionSnapshot, String str3) {
        youTubeClient.getClass();
        str.getClass();
        sessionSnapshot.getClass();
        this.client = youTubeClient;
        this.videoId = str;
        this.signatureTimestamp = num;
        this.poToken = str2;
        this.requestSession = sessionSnapshot;
        this.encryptedHostFlags = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayerRequestKey)) {
            return false;
        }
        PlayerRequestKey playerRequestKey = (PlayerRequestKey) obj;
        return Intrinsics.areEqual(this.client, playerRequestKey.client) && Intrinsics.areEqual(this.videoId, playerRequestKey.videoId) && Intrinsics.areEqual(this.signatureTimestamp, playerRequestKey.signatureTimestamp) && Intrinsics.areEqual(this.poToken, playerRequestKey.poToken) && Intrinsics.areEqual(this.requestSession, playerRequestKey.requestSession) && Intrinsics.areEqual(this.encryptedHostFlags, playerRequestKey.encryptedHostFlags);
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(this.client.hashCode() * 31, 31, this.videoId);
        Integer num = this.signatureTimestamp;
        int iHashCode = (iM + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.poToken;
        int iHashCode2 = (this.requestSession.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31;
        String str2 = this.encryptedHostFlags;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m("PlayerRequestKey(client=", this.client.clientName, ")");
    }
}
