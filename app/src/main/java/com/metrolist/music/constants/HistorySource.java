package com.metrolist.music.constants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HistorySource {
    public static final /* synthetic */ HistorySource[] $VALUES;
    public static final HistorySource LOCAL;
    public static final HistorySource REMOTE;

    static {
        HistorySource historySource = new HistorySource("LOCAL", 0);
        LOCAL = historySource;
        HistorySource historySource2 = new HistorySource("REMOTE", 1);
        REMOTE = historySource2;
        $VALUES = new HistorySource[]{historySource, historySource2};
    }

    public static HistorySource valueOf(String str) {
        return (HistorySource) Enum.valueOf(HistorySource.class, str);
    }

    public static HistorySource[] values() {
        return (HistorySource[]) $VALUES.clone();
    }
}
