package com.metrolist.music.constants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MyTopFilter {
    public static final /* synthetic */ MyTopFilter[] $VALUES;
    public static final MyTopFilter ALL_TIME;

    static {
        MyTopFilter myTopFilter = new MyTopFilter("ALL_TIME", 0);
        ALL_TIME = myTopFilter;
        $VALUES = new MyTopFilter[]{myTopFilter, new MyTopFilter("DAY", 1), new MyTopFilter("WEEK", 2), new MyTopFilter("MONTH", 3), new MyTopFilter("YEAR", 4)};
    }

    public static MyTopFilter valueOf(String str) {
        return (MyTopFilter) Enum.valueOf(MyTopFilter.class, str);
    }

    public static MyTopFilter[] values() {
        return (MyTopFilter[]) $VALUES.clone();
    }
}
