package com.metrolist.music.lyrics;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LyricsResult {
    public final String lyrics;
    public final String providerName;

    public LyricsResult(String str, String str2) {
        str.getClass();
        this.providerName = str;
        this.lyrics = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LyricsResult)) {
            return false;
        }
        LyricsResult lyricsResult = (LyricsResult) obj;
        return Intrinsics.areEqual(this.providerName, lyricsResult.providerName) && this.lyrics.equals(lyricsResult.lyrics);
    }

    public final int hashCode() {
        return this.lyrics.hashCode() + (this.providerName.hashCode() * 31);
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("LyricsResult(providerName=", this.providerName, ", lyrics=", this.lyrics, ")");
    }
}
