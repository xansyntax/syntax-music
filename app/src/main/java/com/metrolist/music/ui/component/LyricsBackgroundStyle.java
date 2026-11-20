package com.metrolist.music.ui.component;

import kotlin.enums.EnumEntriesList;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LyricsBackgroundStyle {
    public static final /* synthetic */ EnumEntriesList $ENTRIES;
    public static final /* synthetic */ LyricsBackgroundStyle[] $VALUES;
    public static final LyricsBackgroundStyle BLUR;
    public static final LyricsBackgroundStyle GRADIENT;
    public static final LyricsBackgroundStyle SOLID;

    static {
        LyricsBackgroundStyle lyricsBackgroundStyle = new LyricsBackgroundStyle("SOLID", 0);
        SOLID = lyricsBackgroundStyle;
        LyricsBackgroundStyle lyricsBackgroundStyle2 = new LyricsBackgroundStyle("BLUR", 1);
        BLUR = lyricsBackgroundStyle2;
        LyricsBackgroundStyle lyricsBackgroundStyle3 = new LyricsBackgroundStyle("GRADIENT", 2);
        GRADIENT = lyricsBackgroundStyle3;
        LyricsBackgroundStyle[] lyricsBackgroundStyleArr = {lyricsBackgroundStyle, lyricsBackgroundStyle2, lyricsBackgroundStyle3};
        $VALUES = lyricsBackgroundStyleArr;
        $ENTRIES = new EnumEntriesList(lyricsBackgroundStyleArr);
    }

    public static LyricsBackgroundStyle valueOf(String str) {
        return (LyricsBackgroundStyle) Enum.valueOf(LyricsBackgroundStyle.class, str);
    }

    public static LyricsBackgroundStyle[] values() {
        return (LyricsBackgroundStyle[]) $VALUES.clone();
    }
}
