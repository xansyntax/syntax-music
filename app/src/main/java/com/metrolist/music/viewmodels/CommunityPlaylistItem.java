package com.metrolist.music.viewmodels;

import com.metrolist.innertube.models.PlaylistItem;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CommunityPlaylistItem {
    public final PlaylistItem playlist;
    public final List songs;

    public CommunityPlaylistItem(PlaylistItem playlistItem, List list) {
        this.playlist = playlistItem;
        this.songs = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommunityPlaylistItem)) {
            return false;
        }
        CommunityPlaylistItem communityPlaylistItem = (CommunityPlaylistItem) obj;
        return this.playlist.equals(communityPlaylistItem.playlist) && this.songs.equals(communityPlaylistItem.songs);
    }

    public final int hashCode() {
        return this.songs.hashCode() + (this.playlist.hashCode() * 31);
    }

    public final String toString() {
        return "CommunityPlaylistItem(playlist=" + this.playlist + ", songs=" + this.songs + ")";
    }
}
