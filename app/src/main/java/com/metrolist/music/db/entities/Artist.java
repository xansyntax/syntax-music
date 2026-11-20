package com.metrolist.music.db.entities;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Artist extends LocalItem {
    public final ArtistEntity artist;
    public final int songCount;
    public final Integer timeListened;

    public Artist(ArtistEntity artistEntity, int i, Integer num) {
        this.artist = artistEntity;
        this.songCount = i;
        this.timeListened = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Artist)) {
            return false;
        }
        Artist artist = (Artist) obj;
        return this.artist.equals(artist.artist) && this.songCount == artist.songCount && Intrinsics.areEqual(this.timeListened, artist.timeListened);
    }

    @Override // com.metrolist.music.db.entities.LocalItem
    public final String getId() {
        return this.artist.id;
    }

    @Override // com.metrolist.music.db.entities.LocalItem
    public final String getThumbnailUrl() {
        return this.artist.thumbnailUrl;
    }

    @Override // com.metrolist.music.db.entities.LocalItem
    public final String getTitle() {
        return this.artist.name;
    }

    public final int hashCode() {
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(this.songCount, this.artist.hashCode() * 31, 31);
        Integer num = this.timeListened;
        return iM + (num == null ? 0 : num.hashCode());
    }

    public final String toString() {
        return "Artist(artist=" + this.artist + ", songCount=" + this.songCount + ", timeListened=" + this.timeListened + ")";
    }
}
