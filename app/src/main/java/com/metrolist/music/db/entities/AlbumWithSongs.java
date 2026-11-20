package com.metrolist.music.db.entities;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AlbumWithSongs {
    public final AlbumEntity album;
    public final List artists;
    public final List songs;

    public AlbumWithSongs(AlbumEntity albumEntity, List list, List list2) {
        this.album = albumEntity;
        this.artists = list;
        this.songs = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlbumWithSongs)) {
            return false;
        }
        AlbumWithSongs albumWithSongs = (AlbumWithSongs) obj;
        return this.album.equals(albumWithSongs.album) && this.artists.equals(albumWithSongs.artists) && this.songs.equals(albumWithSongs.songs);
    }

    public final int hashCode() {
        return this.songs.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(this.album.hashCode() * 31, 31, this.artists);
    }

    public final String toString() {
        return "AlbumWithSongs(album=" + this.album + ", artists=" + this.artists + ", songs=" + this.songs + ")";
    }
}
