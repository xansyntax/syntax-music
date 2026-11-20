package com.metrolist.music.constants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class QuickPicks {
    public static final /* synthetic */ QuickPicks[] $VALUES;
    public static final QuickPicks QUICK_PICKS;

    static {
        QuickPicks quickPicks = new QuickPicks("QUICK_PICKS", 0);
        QUICK_PICKS = quickPicks;
        $VALUES = new QuickPicks[]{quickPicks, new QuickPicks("LAST_LISTEN", 1)};
    }

    public static QuickPicks valueOf(String str) {
        return (QuickPicks) Enum.valueOf(QuickPicks.class, str);
    }

    public static QuickPicks[] values() {
        return (QuickPicks[]) $VALUES.clone();
    }
}
