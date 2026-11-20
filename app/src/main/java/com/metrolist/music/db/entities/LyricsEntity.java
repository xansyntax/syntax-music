package com.metrolist.music.db.entities;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LyricsEntity {
    public final String id;
    public final String lyrics;
    public final String provider;
    public final String translatedLyrics;
    public final String translationLanguage;
    public final String translationMode;

    public LyricsEntity(String str, String str2, String str3, String str4, String str5, String str6) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        str6.getClass();
        this.id = str;
        this.lyrics = str2;
        this.provider = str3;
        this.translatedLyrics = str4;
        this.translationLanguage = str5;
        this.translationMode = str6;
    }

    public static LyricsEntity copy$default(LyricsEntity lyricsEntity, String str, String str2, String str3) {
        String str4 = lyricsEntity.id;
        String str5 = lyricsEntity.lyrics;
        String str6 = lyricsEntity.provider;
        str4.getClass();
        str5.getClass();
        str6.getClass();
        str2.getClass();
        str3.getClass();
        return new LyricsEntity(str4, str5, str6, str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LyricsEntity)) {
            return false;
        }
        LyricsEntity lyricsEntity = (LyricsEntity) obj;
        return Intrinsics.areEqual(this.id, lyricsEntity.id) && Intrinsics.areEqual(this.lyrics, lyricsEntity.lyrics) && Intrinsics.areEqual(this.provider, lyricsEntity.provider) && Intrinsics.areEqual(this.translatedLyrics, lyricsEntity.translatedLyrics) && Intrinsics.areEqual(this.translationLanguage, lyricsEntity.translationLanguage) && Intrinsics.areEqual(this.translationMode, lyricsEntity.translationMode);
    }

    public final int hashCode() {
        return this.translationMode.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.lyrics), 31, this.provider), 31, this.translatedLyrics), 31, this.translationLanguage);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("LyricsEntity(id=", this.id, ", lyrics=", this.lyrics, ", provider=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.provider, ", translatedLyrics=", this.translatedLyrics, ", translationLanguage=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sbM, this.translationLanguage, ", translationMode=", this.translationMode, ")");
    }

    public /* synthetic */ LyricsEntity(String str, String str2, String str3) {
        this(str, str2, str3, "", "", "");
    }
}
