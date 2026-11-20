package com.metrolist.music.lyrics;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LyricsWithProvider {
    public final String lyrics;
    public final String provider;

    public LyricsWithProvider(String str, String str2) {
        str2.getClass();
        this.lyrics = str;
        this.provider = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LyricsWithProvider)) {
            return false;
        }
        LyricsWithProvider lyricsWithProvider = (LyricsWithProvider) obj;
        return this.lyrics.equals(lyricsWithProvider.lyrics) && Intrinsics.areEqual(this.provider, lyricsWithProvider.provider);
    }

    public final int hashCode() {
        return this.provider.hashCode() + (this.lyrics.hashCode() * 31);
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("LyricsWithProvider(lyrics=", this.lyrics, ", provider=", this.provider, ")");
    }
}
