package com.metrolist.music.constants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AlbumSortType {
    public static final /* synthetic */ AlbumSortType[] $VALUES;
    public static final AlbumSortType CREATE_DATE;

    static {
        AlbumSortType albumSortType = new AlbumSortType("CREATE_DATE", 0);
        CREATE_DATE = albumSortType;
        $VALUES = new AlbumSortType[]{albumSortType, new AlbumSortType("NAME", 1), new AlbumSortType("ARTIST", 2), new AlbumSortType("YEAR", 3), new AlbumSortType("SONG_COUNT", 4), new AlbumSortType("LENGTH", 5), new AlbumSortType("PLAY_TIME", 6)};
    }

    public static AlbumSortType valueOf(String str) {
        return (AlbumSortType) Enum.valueOf(AlbumSortType.class, str);
    }

    public static AlbumSortType[] values() {
        return (AlbumSortType[]) $VALUES.clone();
    }
}
