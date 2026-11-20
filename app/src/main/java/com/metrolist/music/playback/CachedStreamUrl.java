package com.metrolist.music.playback;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CachedStreamUrl {
    public final String clientName;
    public final long rangeChunkSizeBytes;
    public final Map requestHeaders;
    public final boolean requireBoundedRange;
    public final String url;
    public final boolean useRangeChunks;

    public CachedStreamUrl(String str, Map map, String str2, boolean z, long j, boolean z2) {
        str.getClass();
        map.getClass();
        str2.getClass();
        this.url = str;
        this.requestHeaders = map;
        this.clientName = str2;
        this.requireBoundedRange = z;
        this.rangeChunkSizeBytes = j;
        this.useRangeChunks = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CachedStreamUrl)) {
            return false;
        }
        CachedStreamUrl cachedStreamUrl = (CachedStreamUrl) obj;
        return Intrinsics.areEqual(this.url, cachedStreamUrl.url) && Intrinsics.areEqual(this.requestHeaders, cachedStreamUrl.requestHeaders) && Intrinsics.areEqual(this.clientName, cachedStreamUrl.clientName) && this.requireBoundedRange == cachedStreamUrl.requireBoundedRange && this.rangeChunkSizeBytes == cachedStreamUrl.rangeChunkSizeBytes && this.useRangeChunks == cachedStreamUrl.useRangeChunks;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.useRangeChunks) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m((this.requestHeaders.hashCode() + (this.url.hashCode() * 31)) * 31, 31, this.clientName), this.requireBoundedRange, 31), 31, this.rangeChunkSizeBytes);
    }

    public final String toString() {
        return "CachedStreamUrl(url=" + this.url + ", requestHeaders=" + this.requestHeaders + ", clientName=" + this.clientName + ", requireBoundedRange=" + this.requireBoundedRange + ", rangeChunkSizeBytes=" + this.rangeChunkSizeBytes + ", useRangeChunks=" + this.useRangeChunks + ")";
    }
}
