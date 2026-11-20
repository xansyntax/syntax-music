package com.metrolist.music.constants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LyricsAnimationStyle {
    public static final /* synthetic */ LyricsAnimationStyle[] $VALUES;
    public static final LyricsAnimationStyle APPLE;
    public static final LyricsAnimationStyle FADE;
    public static final LyricsAnimationStyle GLOW;
    public static final LyricsAnimationStyle KARAOKE;
    public static final LyricsAnimationStyle NONE;
    public static final LyricsAnimationStyle SLIDE;

    static {
        LyricsAnimationStyle lyricsAnimationStyle = new LyricsAnimationStyle("NONE", 0);
        NONE = lyricsAnimationStyle;
        LyricsAnimationStyle lyricsAnimationStyle2 = new LyricsAnimationStyle("FADE", 1);
        FADE = lyricsAnimationStyle2;
        LyricsAnimationStyle lyricsAnimationStyle3 = new LyricsAnimationStyle("GLOW", 2);
        GLOW = lyricsAnimationStyle3;
        LyricsAnimationStyle lyricsAnimationStyle4 = new LyricsAnimationStyle("SLIDE", 3);
        SLIDE = lyricsAnimationStyle4;
        LyricsAnimationStyle lyricsAnimationStyle5 = new LyricsAnimationStyle("KARAOKE", 4);
        KARAOKE = lyricsAnimationStyle5;
        LyricsAnimationStyle lyricsAnimationStyle6 = new LyricsAnimationStyle("APPLE", 5);
        APPLE = lyricsAnimationStyle6;
        $VALUES = new LyricsAnimationStyle[]{lyricsAnimationStyle, lyricsAnimationStyle2, lyricsAnimationStyle3, lyricsAnimationStyle4, lyricsAnimationStyle5, lyricsAnimationStyle6};
    }

    public static LyricsAnimationStyle valueOf(String str) {
        return (LyricsAnimationStyle) Enum.valueOf(LyricsAnimationStyle.class, str);
    }

    public static LyricsAnimationStyle[] values() {
        return (LyricsAnimationStyle[]) $VALUES.clone();
    }
}
