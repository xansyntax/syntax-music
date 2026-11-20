package com.metrolist.music.constants;

import kotlin.enums.EnumEntriesList;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaylistSortType {
    public static final /* synthetic */ EnumEntriesList $ENTRIES;
    public static final /* synthetic */ PlaylistSortType[] $VALUES;
    public static final PlaylistSortType CREATE_DATE;
    public static final PlaylistSortType NAME;

    static {
        PlaylistSortType playlistSortType = new PlaylistSortType("CREATE_DATE", 0);
        CREATE_DATE = playlistSortType;
        PlaylistSortType playlistSortType2 = new PlaylistSortType("NAME", 1);
        NAME = playlistSortType2;
        PlaylistSortType[] playlistSortTypeArr = {playlistSortType, playlistSortType2, new PlaylistSortType("SONG_COUNT", 2), new PlaylistSortType("LAST_UPDATED", 3)};
        $VALUES = playlistSortTypeArr;
        $ENTRIES = new EnumEntriesList(playlistSortTypeArr);
    }

    public static PlaylistSortType valueOf(String str) {
        return (PlaylistSortType) Enum.valueOf(PlaylistSortType.class, str);
    }

    public static PlaylistSortType[] values() {
        return (PlaylistSortType[]) $VALUES.clone();
    }
}
