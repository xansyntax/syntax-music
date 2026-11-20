package com.metrolist.music.constants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ArtistSongSortType {
    public static final /* synthetic */ ArtistSongSortType[] $VALUES;
    public static final ArtistSongSortType CREATE_DATE;

    static {
        ArtistSongSortType artistSongSortType = new ArtistSongSortType("CREATE_DATE", 0);
        CREATE_DATE = artistSongSortType;
        $VALUES = new ArtistSongSortType[]{artistSongSortType, new ArtistSongSortType("NAME", 1), new ArtistSongSortType("PLAY_TIME", 2)};
    }

    public static ArtistSongSortType valueOf(String str) {
        return (ArtistSongSortType) Enum.valueOf(ArtistSongSortType.class, str);
    }

    public static ArtistSongSortType[] values() {
        return (ArtistSongSortType[]) $VALUES.clone();
    }
}
