package com.metrolist.music.db.entities;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Album extends LocalItem {
    public final AlbumEntity album;
    public final List artists;
    public final Integer songCountListened;
    public final Long timeListened;

    public Album(AlbumEntity albumEntity, List list, Integer num, Long l) {
        list.getClass();
        this.album = albumEntity;
        this.artists = list;
        this.songCountListened = num;
        this.timeListened = l;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Album)) {
            return false;
        }
        Album album = (Album) obj;
        return this.album.equals(album.album) && Intrinsics.areEqual(this.artists, album.artists) && Intrinsics.areEqual(this.songCountListened, album.songCountListened) && Intrinsics.areEqual(this.timeListened, album.timeListened);
    }

    @Override // com.metrolist.music.db.entities.LocalItem
    public final String getId() {
        return this.album.id;
    }

    @Override // com.metrolist.music.db.entities.LocalItem
    public final String getThumbnailUrl() {
        return this.album.thumbnailUrl;
    }

    @Override // com.metrolist.music.db.entities.LocalItem
    public final String getTitle() {
        return this.album.title;
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(this.album.hashCode() * 31, 31, this.artists);
        Integer num = this.songCountListened;
        int iHashCode = (iM + (num == null ? 0 : num.hashCode())) * 31;
        Long l = this.timeListened;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public final String toString() {
        return "Album(album=" + this.album + ", artists=" + this.artists + ", songCountListened=" + this.songCountListened + ", timeListened=" + this.timeListened + ")";
    }
}
