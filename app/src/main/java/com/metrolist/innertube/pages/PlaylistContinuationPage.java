package com.metrolist.innertube.pages;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaylistContinuationPage {
    public final String continuation;
    public final ArrayList songs;

    public PlaylistContinuationPage(String str, ArrayList arrayList) {
        this.songs = arrayList;
        this.continuation = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaylistContinuationPage)) {
            return false;
        }
        PlaylistContinuationPage playlistContinuationPage = (PlaylistContinuationPage) obj;
        return this.songs.equals(playlistContinuationPage.songs) && Intrinsics.areEqual(this.continuation, playlistContinuationPage.continuation);
    }

    public final int hashCode() {
        int iHashCode = this.songs.hashCode() * 31;
        String str = this.continuation;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "PlaylistContinuationPage(songs=" + this.songs + ", continuation=" + this.continuation + ")";
    }
}
