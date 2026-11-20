package com.materialkolor.dynamiccolor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TonePolarity {
    public static final /* synthetic */ TonePolarity[] $VALUES;
    public static final TonePolarity DARKER;
    public static final TonePolarity LIGHTER;
    public static final TonePolarity NEARER;
    public static final TonePolarity RELATIVE_DARKER;
    public static final TonePolarity RELATIVE_LIGHTER;

    static {
        TonePolarity tonePolarity = new TonePolarity("DARKER", 0);
        DARKER = tonePolarity;
        TonePolarity tonePolarity2 = new TonePolarity("LIGHTER", 1);
        LIGHTER = tonePolarity2;
        TonePolarity tonePolarity3 = new TonePolarity("RELATIVE_DARKER", 2);
        RELATIVE_DARKER = tonePolarity3;
        TonePolarity tonePolarity4 = new TonePolarity("RELATIVE_LIGHTER", 3);
        RELATIVE_LIGHTER = tonePolarity4;
        TonePolarity tonePolarity5 = new TonePolarity("NEARER", 4);
        NEARER = tonePolarity5;
        $VALUES = new TonePolarity[]{tonePolarity, tonePolarity2, tonePolarity3, tonePolarity4, tonePolarity5, new TonePolarity("FARTHER", 5)};
    }

    public static TonePolarity valueOf(String str) {
        return (TonePolarity) Enum.valueOf(TonePolarity.class, str);
    }

    public static TonePolarity[] values() {
        return (TonePolarity[]) $VALUES.clone();
    }
}
