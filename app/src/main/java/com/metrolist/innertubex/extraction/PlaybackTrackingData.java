package com.metrolist.innertubex.extraction;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaybackTrackingData {
    public final String clientPlaybackNonce;
    public final Integer defaultFlushIntervalSeconds;
    public final String playbackUrl;
    public final long resolvedAtEpochMs;
    public final List scheduledFlushWalltimeSeconds;
    public final String watchtimeUrl;

    public PlaybackTrackingData(String str, String str2, String str3, List list, Integer num, long j) {
        str.getClass();
        this.clientPlaybackNonce = str;
        this.playbackUrl = str2;
        this.watchtimeUrl = str3;
        this.scheduledFlushWalltimeSeconds = list;
        this.defaultFlushIntervalSeconds = num;
        this.resolvedAtEpochMs = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaybackTrackingData)) {
            return false;
        }
        PlaybackTrackingData playbackTrackingData = (PlaybackTrackingData) obj;
        return Intrinsics.areEqual(this.clientPlaybackNonce, playbackTrackingData.clientPlaybackNonce) && Intrinsics.areEqual(this.playbackUrl, playbackTrackingData.playbackUrl) && Intrinsics.areEqual(this.watchtimeUrl, playbackTrackingData.watchtimeUrl) && Intrinsics.areEqual(this.scheduledFlushWalltimeSeconds, playbackTrackingData.scheduledFlushWalltimeSeconds) && Intrinsics.areEqual(this.defaultFlushIntervalSeconds, playbackTrackingData.defaultFlushIntervalSeconds) && this.resolvedAtEpochMs == playbackTrackingData.resolvedAtEpochMs;
    }

    public final int hashCode() {
        int iHashCode = this.clientPlaybackNonce.hashCode() * 31;
        String str = this.playbackUrl;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.watchtimeUrl;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List list = this.scheduledFlushWalltimeSeconds;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num = this.defaultFlushIntervalSeconds;
        return Long.hashCode(this.resolvedAtEpochMs) + ((iHashCode4 + (num != null ? num.hashCode() : 0)) * 31);
    }

    public final String toString() {
        String strPresence = CollectionsKt__IterablesKt.presence(this.clientPlaybackNonce);
        String strPresence2 = CollectionsKt__IterablesKt.presence(this.playbackUrl);
        String strPresence3 = CollectionsKt__IterablesKt.presence(this.watchtimeUrl);
        List list = this.scheduledFlushWalltimeSeconds;
        int size = list != null ? list.size() : 0;
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("PlaybackTrackingData(clientPlaybackNonce=", strPresence, ", playbackUrl=", strPresence2, ", watchtimeUrl=");
        sbM.append(strPresence3);
        sbM.append(", scheduledFlushWalltimeSeconds=");
        sbM.append(size);
        sbM.append(", defaultFlushIntervalSeconds=");
        sbM.append(this.defaultFlushIntervalSeconds);
        sbM.append(", resolvedAtEpochMs=");
        sbM.append(this.resolvedAtEpochMs);
        sbM.append(")");
        return sbM.toString();
    }
}
