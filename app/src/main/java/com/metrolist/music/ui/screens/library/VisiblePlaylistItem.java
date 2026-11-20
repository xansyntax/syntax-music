package com.metrolist.music.ui.screens.library;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.metrolist.music.db.entities.Playlist;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VisiblePlaylistItem {
    public final boolean autoPlaylist;
    public final String key;
    public final Playlist playlist;
    public final String route;

    public VisiblePlaylistItem(String str, Playlist playlist, boolean z, String str2) {
        str.getClass();
        this.key = str;
        this.playlist = playlist;
        this.autoPlaylist = z;
        this.route = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisiblePlaylistItem)) {
            return false;
        }
        VisiblePlaylistItem visiblePlaylistItem = (VisiblePlaylistItem) obj;
        return Intrinsics.areEqual(this.key, visiblePlaylistItem.key) && Intrinsics.areEqual(this.playlist, visiblePlaylistItem.playlist) && this.autoPlaylist == visiblePlaylistItem.autoPlaylist && Intrinsics.areEqual(this.route, visiblePlaylistItem.route);
    }

    public final int hashCode() {
        int iM = IntIntPair$$ExternalSyntheticOutline0.m((this.playlist.hashCode() + (this.key.hashCode() * 31)) * 31, this.autoPlaylist, 31);
        String str = this.route;
        return iM + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "VisiblePlaylistItem(key=" + this.key + ", playlist=" + this.playlist + ", autoPlaylist=" + this.autoPlaylist + ", route=" + this.route + ")";
    }
}
