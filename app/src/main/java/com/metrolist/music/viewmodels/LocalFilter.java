package com.metrolist.music.viewmodels;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LocalFilter {
    public static final /* synthetic */ LocalFilter[] $VALUES;
    public static final LocalFilter ALBUM;
    public static final LocalFilter ALL;
    public static final LocalFilter ARTIST;
    public static final LocalFilter PLAYLIST;
    public static final LocalFilter SONG;

    static {
        LocalFilter localFilter = new LocalFilter("ALL", 0);
        ALL = localFilter;
        LocalFilter localFilter2 = new LocalFilter("SONG", 1);
        SONG = localFilter2;
        LocalFilter localFilter3 = new LocalFilter("ALBUM", 2);
        ALBUM = localFilter3;
        LocalFilter localFilter4 = new LocalFilter("ARTIST", 3);
        ARTIST = localFilter4;
        LocalFilter localFilter5 = new LocalFilter("PLAYLIST", 4);
        PLAYLIST = localFilter5;
        $VALUES = new LocalFilter[]{localFilter, localFilter2, localFilter3, localFilter4, localFilter5};
    }

    public static LocalFilter valueOf(String str) {
        return (LocalFilter) Enum.valueOf(LocalFilter.class, str);
    }

    public static LocalFilter[] values() {
        return (LocalFilter[]) $VALUES.clone();
    }
}
