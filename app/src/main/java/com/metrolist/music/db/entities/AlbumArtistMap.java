package com.metrolist.music.db.entities;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AlbumArtistMap {
    public final String albumId;
    public final String artistId;
    public final int order;

    public AlbumArtistMap(String str, String str2, int i) {
        str.getClass();
        str2.getClass();
        this.albumId = str;
        this.artistId = str2;
        this.order = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlbumArtistMap)) {
            return false;
        }
        AlbumArtistMap albumArtistMap = (AlbumArtistMap) obj;
        return Intrinsics.areEqual(this.albumId, albumArtistMap.albumId) && Intrinsics.areEqual(this.artistId, albumArtistMap.artistId) && this.order == albumArtistMap.order;
    }

    public final int hashCode() {
        return Integer.hashCode(this.order) + Fragment$5$$ExternalSyntheticOutline0.m(this.albumId.hashCode() * 31, 31, this.artistId);
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("AlbumArtistMap(albumId=", this.albumId, ", artistId=", this.artistId, ", order="), this.order, ")");
    }
}
