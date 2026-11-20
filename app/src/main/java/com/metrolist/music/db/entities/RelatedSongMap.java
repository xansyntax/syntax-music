package com.metrolist.music.db.entities;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RelatedSongMap {
    public final String relatedSongId;
    public final String songId;

    public RelatedSongMap(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.songId = str;
        this.relatedSongId = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RelatedSongMap)) {
            return false;
        }
        RelatedSongMap relatedSongMap = (RelatedSongMap) obj;
        return Intrinsics.areEqual(this.songId, relatedSongMap.songId) && Intrinsics.areEqual(this.relatedSongId, relatedSongMap.relatedSongId);
    }

    public final int hashCode() {
        return this.relatedSongId.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(Long.hashCode(0L) * 31, 31, this.songId);
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("RelatedSongMap(id=0, songId=", this.songId, ", relatedSongId=", this.relatedSongId, ")");
    }
}
