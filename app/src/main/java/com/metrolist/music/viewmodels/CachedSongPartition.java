package com.metrolist.music.viewmodels;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CachedSongPartition {
    public final ArrayList stale;
    public final ArrayList stillCached;

    public CachedSongPartition(ArrayList arrayList, ArrayList arrayList2) {
        this.stillCached = arrayList;
        this.stale = arrayList2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CachedSongPartition)) {
            return false;
        }
        CachedSongPartition cachedSongPartition = (CachedSongPartition) obj;
        return this.stillCached.equals(cachedSongPartition.stillCached) && this.stale.equals(cachedSongPartition.stale);
    }

    public final int hashCode() {
        return this.stale.hashCode() + (this.stillCached.hashCode() * 31);
    }

    public final String toString() {
        return "CachedSongPartition(stillCached=" + this.stillCached + ", stale=" + this.stale + ")";
    }
}
