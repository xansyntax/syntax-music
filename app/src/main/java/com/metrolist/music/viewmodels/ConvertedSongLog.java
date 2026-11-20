package com.metrolist.music.viewmodels;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ConvertedSongLog {
    public final String artists;
    public final String title;

    public ConvertedSongLog(String str, String str2) {
        str.getClass();
        this.title = str;
        this.artists = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConvertedSongLog)) {
            return false;
        }
        ConvertedSongLog convertedSongLog = (ConvertedSongLog) obj;
        return Intrinsics.areEqual(this.title, convertedSongLog.title) && this.artists.equals(convertedSongLog.artists);
    }

    public final int hashCode() {
        return this.artists.hashCode() + (this.title.hashCode() * 31);
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("ConvertedSongLog(title=", this.title, ", artists=", this.artists, ")");
    }
}
