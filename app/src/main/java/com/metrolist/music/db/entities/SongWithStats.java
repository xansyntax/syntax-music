package com.metrolist.music.db.entities;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SongWithStats {
    public final String artistName;
    public final List artists;
    public final String id;
    public final boolean isVideo;
    public final int songCountListened;
    public final String thumbnailUrl;
    public final Long timeListened;
    public final String title;

    public SongWithStats(String str, String str2, List list, String str3, String str4, int i, Long l, boolean z) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        this.id = str;
        this.title = str2;
        this.artists = list;
        this.thumbnailUrl = str3;
        this.artistName = str4;
        this.songCountListened = i;
        this.timeListened = l;
        this.isVideo = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SongWithStats)) {
            return false;
        }
        SongWithStats songWithStats = (SongWithStats) obj;
        return Intrinsics.areEqual(this.id, songWithStats.id) && Intrinsics.areEqual(this.title, songWithStats.title) && this.artists.equals(songWithStats.artists) && Intrinsics.areEqual(this.thumbnailUrl, songWithStats.thumbnailUrl) && Intrinsics.areEqual(this.artistName, songWithStats.artistName) && this.songCountListened == songWithStats.songCountListened && Intrinsics.areEqual(this.timeListened, songWithStats.timeListened) && this.isVideo == songWithStats.isVideo;
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.title), 31, this.artists), 31, this.thumbnailUrl);
        String str = this.artistName;
        int iM2 = IntIntPair$$ExternalSyntheticOutline0.m(this.songCountListened, (iM + (str == null ? 0 : str.hashCode())) * 31, 31);
        Long l = this.timeListened;
        return Boolean.hashCode(this.isVideo) + ((iM2 + (l != null ? l.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("SongWithStats(id=", this.id, ", title=", this.title, ", artists=");
        sbM.append(this.artists);
        sbM.append(", thumbnailUrl=");
        sbM.append(this.thumbnailUrl);
        sbM.append(", artistName=");
        sbM.append(this.artistName);
        sbM.append(", songCountListened=");
        sbM.append(this.songCountListened);
        sbM.append(", timeListened=");
        sbM.append(this.timeListened);
        sbM.append(", isVideo=");
        sbM.append(this.isVideo);
        sbM.append(")");
        return sbM.toString();
    }
}
