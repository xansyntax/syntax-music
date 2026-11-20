package com.metrolist.music.constants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GridItemSize {
    public static final /* synthetic */ GridItemSize[] $VALUES;
    public static final GridItemSize BIG;
    public static final GridItemSize SMALL;

    static {
        GridItemSize gridItemSize = new GridItemSize("BIG", 0);
        BIG = gridItemSize;
        GridItemSize gridItemSize2 = new GridItemSize("SMALL", 1);
        SMALL = gridItemSize2;
        $VALUES = new GridItemSize[]{gridItemSize, gridItemSize2};
    }

    public static GridItemSize valueOf(String str) {
        return (GridItemSize) Enum.valueOf(GridItemSize.class, str);
    }

    public static GridItemSize[] values() {
        return (GridItemSize[]) $VALUES.clone();
    }
}
