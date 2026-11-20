package com.metrolist.music.db.entities;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SongAlbumMap {
    public final String albumId;
    public final int index;
    public final String songId;

    public SongAlbumMap(String str, String str2, int i) {
        str.getClass();
        str2.getClass();
        this.songId = str;
        this.albumId = str2;
        this.index = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SongAlbumMap)) {
            return false;
        }
        SongAlbumMap songAlbumMap = (SongAlbumMap) obj;
        return Intrinsics.areEqual(this.songId, songAlbumMap.songId) && Intrinsics.areEqual(this.albumId, songAlbumMap.albumId) && this.index == songAlbumMap.index;
    }

    public final int hashCode() {
        return Integer.hashCode(this.index) + Fragment$5$$ExternalSyntheticOutline0.m(this.songId.hashCode() * 31, 31, this.albumId);
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("SongAlbumMap(songId=", this.songId, ", albumId=", this.albumId, ", index="), this.index, ")");
    }
}
