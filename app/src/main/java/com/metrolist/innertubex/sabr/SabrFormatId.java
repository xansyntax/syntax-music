package com.metrolist.innertubex.sabr;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SabrFormatId {
    public final int itag;
    public final long lastModified;
    public final String xtags;

    public SabrFormatId(int i, long j, String str) {
        this.itag = i;
        this.lastModified = j;
        this.xtags = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SabrFormatId)) {
            return false;
        }
        SabrFormatId sabrFormatId = (SabrFormatId) obj;
        return this.itag == sabrFormatId.itag && this.lastModified == sabrFormatId.lastModified && Intrinsics.areEqual(this.xtags, sabrFormatId.xtags);
    }

    public final int hashCode() {
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(Integer.hashCode(this.itag) * 31, 31, this.lastModified);
        String str = this.xtags;
        return iM + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "SabrFormatId(itag=" + this.itag + ", lastModified=" + this.lastModified + ", xtags=" + this.xtags + ")";
    }
}
