package com.metrolist.music.db.entities;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaylistSongMap {
    public final int id;
    public final String playlistId;
    public final int position;
    public final String setVideoId;
    public final String songId;

    public PlaylistSongMap(int i, String str, String str2, int i2, String str3) {
        str.getClass();
        str2.getClass();
        this.id = i;
        this.playlistId = str;
        this.songId = str2;
        this.position = i2;
        this.setVideoId = str3;
    }

    public static PlaylistSongMap copy$default(PlaylistSongMap playlistSongMap, int i, String str, int i2) {
        int i3 = (i2 & 1) != 0 ? playlistSongMap.id : 0;
        String str2 = playlistSongMap.playlistId;
        String str3 = playlistSongMap.songId;
        if ((i2 & 8) != 0) {
            i = playlistSongMap.position;
        }
        int i4 = i;
        if ((i2 & 16) != 0) {
            str = playlistSongMap.setVideoId;
        }
        playlistSongMap.getClass();
        str2.getClass();
        str3.getClass();
        return new PlaylistSongMap(i3, str2, str3, i4, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaylistSongMap)) {
            return false;
        }
        PlaylistSongMap playlistSongMap = (PlaylistSongMap) obj;
        return this.id == playlistSongMap.id && Intrinsics.areEqual(this.playlistId, playlistSongMap.playlistId) && Intrinsics.areEqual(this.songId, playlistSongMap.songId) && this.position == playlistSongMap.position && Intrinsics.areEqual(this.setVideoId, playlistSongMap.setVideoId);
    }

    public final int hashCode() {
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(this.position, Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Integer.hashCode(this.id) * 31, 31, this.playlistId), 31, this.songId), 31);
        String str = this.setVideoId;
        return iM + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PlaylistSongMap(id=");
        sb.append(this.id);
        sb.append(", playlistId=");
        sb.append(this.playlistId);
        sb.append(", songId=");
        sb.append(this.songId);
        sb.append(", position=");
        sb.append(this.position);
        sb.append(", setVideoId=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.setVideoId, ")");
    }

    public /* synthetic */ PlaylistSongMap(String str, String str2, int i, String str3, int i2) {
        this(0, str, str2, i, (i2 & 16) != 0 ? null : str3);
    }
}
