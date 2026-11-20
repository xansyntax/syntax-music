package com.metrolist.music.constants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaylistSongSortType {
    public static final /* synthetic */ PlaylistSongSortType[] $VALUES;
    public static final PlaylistSongSortType CUSTOM;

    static {
        PlaylistSongSortType playlistSongSortType = new PlaylistSongSortType("CUSTOM", 0);
        CUSTOM = playlistSongSortType;
        $VALUES = new PlaylistSongSortType[]{playlistSongSortType, new PlaylistSongSortType("CREATE_DATE", 1), new PlaylistSongSortType("NAME", 2), new PlaylistSongSortType("ARTIST", 3), new PlaylistSongSortType("PLAY_TIME", 4)};
    }

    public static PlaylistSongSortType valueOf(String str) {
        return (PlaylistSongSortType) Enum.valueOf(PlaylistSongSortType.class, str);
    }

    public static PlaylistSongSortType[] values() {
        return (PlaylistSongSortType[]) $VALUES.clone();
    }
}
