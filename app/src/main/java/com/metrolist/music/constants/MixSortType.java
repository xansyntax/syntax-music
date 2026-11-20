package com.metrolist.music.constants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MixSortType {
    public static final /* synthetic */ MixSortType[] $VALUES;
    public static final MixSortType CREATE_DATE;

    static {
        MixSortType mixSortType = new MixSortType("CREATE_DATE", 0);
        CREATE_DATE = mixSortType;
        $VALUES = new MixSortType[]{mixSortType, new MixSortType("NAME", 1), new MixSortType("LAST_UPDATED", 2)};
    }

    public static MixSortType valueOf(String str) {
        return (MixSortType) Enum.valueOf(MixSortType.class, str);
    }

    public static MixSortType[] values() {
        return (MixSortType[]) $VALUES.clone();
    }
}
