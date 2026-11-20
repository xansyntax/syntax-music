package com.metrolist.music.ui.screens.settings;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LyricsPosition {
    public static final /* synthetic */ LyricsPosition[] $VALUES;
    public static final LyricsPosition CENTER;

    /* JADX INFO: Fake field, exist only in values array */
    LyricsPosition EF0;

    static {
        LyricsPosition lyricsPosition = new LyricsPosition("LEFT", 0);
        LyricsPosition lyricsPosition2 = new LyricsPosition("CENTER", 1);
        CENTER = lyricsPosition2;
        $VALUES = new LyricsPosition[]{lyricsPosition, lyricsPosition2, new LyricsPosition("RIGHT", 2)};
    }

    public static LyricsPosition valueOf(String str) {
        return (LyricsPosition) Enum.valueOf(LyricsPosition.class, str);
    }

    public static LyricsPosition[] values() {
        return (LyricsPosition[]) $VALUES.clone();
    }
}
