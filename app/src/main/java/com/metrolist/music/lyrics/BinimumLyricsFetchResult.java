package com.metrolist.music.lyrics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BinimumLyricsFetchResult {
    public final boolean isWordSync;
    public final String lrc;

    public BinimumLyricsFetchResult(String str, boolean z) {
        this.lrc = str;
        this.isWordSync = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BinimumLyricsFetchResult)) {
            return false;
        }
        BinimumLyricsFetchResult binimumLyricsFetchResult = (BinimumLyricsFetchResult) obj;
        return this.lrc.equals(binimumLyricsFetchResult.lrc) && this.isWordSync == binimumLyricsFetchResult.isWordSync;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.isWordSync) + (this.lrc.hashCode() * 31);
    }

    public final String toString() {
        return "BinimumLyricsFetchResult(lrc=" + this.lrc + ", isWordSync=" + this.isWordSync + ")";
    }
}
