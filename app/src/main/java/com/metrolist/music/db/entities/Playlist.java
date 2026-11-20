package com.metrolist.music.db.entities;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Playlist extends LocalItem {
    public final PlaylistEntity playlist;
    public final int songCount;
    public final List songThumbnails;

    public Playlist(PlaylistEntity playlistEntity, int i, List list) {
        this.playlist = playlistEntity;
        this.songCount = i;
        this.songThumbnails = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Playlist)) {
            return false;
        }
        Playlist playlist = (Playlist) obj;
        return this.playlist.equals(playlist.playlist) && this.songCount == playlist.songCount && this.songThumbnails.equals(playlist.songThumbnails);
    }

    @Override // com.metrolist.music.db.entities.LocalItem
    public final String getId() {
        return this.playlist.id;
    }

    public final List getThumbnails() {
        String str = this.playlist.thumbnailUrl;
        return str != null ? CollectionsKt__IterablesKt.listOf(str) : CollectionsKt.filterNotNull(this.songThumbnails);
    }

    @Override // com.metrolist.music.db.entities.LocalItem
    public final String getTitle() {
        return this.playlist.name;
    }

    public final int hashCode() {
        return this.songThumbnails.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.songCount, this.playlist.hashCode() * 31, 31);
    }

    public final String toString() {
        return "Playlist(playlist=" + this.playlist + ", songCount=" + this.songCount + ", songThumbnails=" + this.songThumbnails + ")";
    }
}
