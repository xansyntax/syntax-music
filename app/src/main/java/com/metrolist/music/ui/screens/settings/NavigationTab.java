package com.metrolist.music.ui.screens.settings;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavigationTab {
    public static final /* synthetic */ NavigationTab[] $VALUES;
    public static final NavigationTab HOME;
    public static final NavigationTab LIBRARY;
    public static final NavigationTab SEARCH;

    static {
        NavigationTab navigationTab = new NavigationTab("HOME", 0);
        HOME = navigationTab;
        NavigationTab navigationTab2 = new NavigationTab("SEARCH", 1);
        SEARCH = navigationTab2;
        NavigationTab navigationTab3 = new NavigationTab("LIBRARY", 2);
        LIBRARY = navigationTab3;
        $VALUES = new NavigationTab[]{navigationTab, navigationTab2, navigationTab3};
    }

    public static NavigationTab valueOf(String str) {
        return (NavigationTab) Enum.valueOf(NavigationTab.class, str);
    }

    public static NavigationTab[] values() {
        return (NavigationTab[]) $VALUES.clone();
    }
}
