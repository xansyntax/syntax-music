package com.metrolist.music.ui.screens;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OptionStats {
    public static final /* synthetic */ OptionStats[] $VALUES;
    public static final OptionStats CONTINUOUS;
    public static final OptionStats MONTHS;
    public static final OptionStats WEEKS;
    public static final OptionStats YEARS;

    static {
        OptionStats optionStats = new OptionStats("WEEKS", 0);
        WEEKS = optionStats;
        OptionStats optionStats2 = new OptionStats("MONTHS", 1);
        MONTHS = optionStats2;
        OptionStats optionStats3 = new OptionStats("YEARS", 2);
        YEARS = optionStats3;
        OptionStats optionStats4 = new OptionStats("CONTINUOUS", 3);
        CONTINUOUS = optionStats4;
        $VALUES = new OptionStats[]{optionStats, optionStats2, optionStats3, optionStats4};
    }

    public static OptionStats valueOf(String str) {
        return (OptionStats) Enum.valueOf(OptionStats.class, str);
    }

    public static OptionStats[] values() {
        return (OptionStats[]) $VALUES.clone();
    }
}
