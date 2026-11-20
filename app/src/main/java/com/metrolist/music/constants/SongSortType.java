package com.metrolist.music.constants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SongSortType {
    public static final /* synthetic */ SongSortType[] $VALUES;
    public static final SongSortType CREATE_DATE;

    static {
        SongSortType songSortType = new SongSortType("CREATE_DATE", 0);
        CREATE_DATE = songSortType;
        $VALUES = new SongSortType[]{songSortType, new SongSortType("NAME", 1), new SongSortType("ARTIST", 2), new SongSortType("PLAY_TIME", 3)};
    }

    public static SongSortType valueOf(String str) {
        return (SongSortType) Enum.valueOf(SongSortType.class, str);
    }

    public static SongSortType[] values() {
        return (SongSortType[]) $VALUES.clone();
    }
}
