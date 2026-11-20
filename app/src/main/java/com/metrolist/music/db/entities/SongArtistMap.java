package com.metrolist.music.db.entities;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SongArtistMap {
    public final String artistId;
    public final int position;
    public final String songId;

    public SongArtistMap(String str, String str2, int i) {
        str.getClass();
        str2.getClass();
        this.songId = str;
        this.artistId = str2;
        this.position = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SongArtistMap)) {
            return false;
        }
        SongArtistMap songArtistMap = (SongArtistMap) obj;
        return Intrinsics.areEqual(this.songId, songArtistMap.songId) && Intrinsics.areEqual(this.artistId, songArtistMap.artistId) && this.position == songArtistMap.position;
    }

    public final int hashCode() {
        return Integer.hashCode(this.position) + Fragment$5$$ExternalSyntheticOutline0.m(this.songId.hashCode() * 31, 31, this.artistId);
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("SongArtistMap(songId=", this.songId, ", artistId=", this.artistId, ", position="), this.position, ")");
    }
}
