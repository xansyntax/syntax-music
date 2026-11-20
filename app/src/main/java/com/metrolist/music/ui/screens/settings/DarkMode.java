package com.metrolist.music.ui.screens.settings;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DarkMode {
    public static final /* synthetic */ DarkMode[] $VALUES;
    public static final DarkMode AUTO;
    public static final DarkMode OFF;
    public static final DarkMode ON;

    static {
        DarkMode darkMode = new DarkMode("ON", 0);
        ON = darkMode;
        DarkMode darkMode2 = new DarkMode("OFF", 1);
        OFF = darkMode2;
        DarkMode darkMode3 = new DarkMode("AUTO", 2);
        AUTO = darkMode3;
        $VALUES = new DarkMode[]{darkMode, darkMode2, darkMode3};
    }

    public static DarkMode valueOf(String str) {
        return (DarkMode) Enum.valueOf(DarkMode.class, str);
    }

    public static DarkMode[] values() {
        return (DarkMode[]) $VALUES.clone();
    }
}
