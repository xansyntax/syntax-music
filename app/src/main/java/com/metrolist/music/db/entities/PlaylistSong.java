package com.metrolist.music.db.entities;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaylistSong {
    public final PlaylistSongMap map;
    public final Song song;

    public PlaylistSong(PlaylistSongMap playlistSongMap, Song song) {
        this.map = playlistSongMap;
        this.song = song;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaylistSong)) {
            return false;
        }
        PlaylistSong playlistSong = (PlaylistSong) obj;
        return this.map.equals(playlistSong.map) && this.song.equals(playlistSong.song);
    }

    public final int hashCode() {
        return this.song.hashCode() + (this.map.hashCode() * 31);
    }

    public final String toString() {
        return "PlaylistSong(map=" + this.map + ", song=" + this.song + ")";
    }
}
