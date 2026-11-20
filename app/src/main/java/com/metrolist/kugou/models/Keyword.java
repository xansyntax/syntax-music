package com.metrolist.kugou.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Keyword {
    public final String album;
    public final String artist;
    public final String title;

    public Keyword(String str, String str2, String str3) {
        this.title = str;
        this.artist = str2;
        this.album = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Keyword)) {
            return false;
        }
        Keyword keyword = (Keyword) obj;
        return this.title.equals(keyword.title) && this.artist.equals(keyword.artist) && Intrinsics.areEqual(this.album, keyword.album);
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(this.title.hashCode() * 31, 31, this.artist);
        String str = this.album;
        return iM + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("Keyword(title=", this.title, ", artist=", this.artist, ", album="), this.album, ")");
    }
}
