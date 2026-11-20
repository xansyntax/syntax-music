package com.metrolist.music.constants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AlbumFilter {
    public static final /* synthetic */ AlbumFilter[] $VALUES;
    public static final AlbumFilter LIBRARY;
    public static final AlbumFilter LIKED;
    public static final AlbumFilter UPLOADED;

    static {
        AlbumFilter albumFilter = new AlbumFilter("LIBRARY", 0);
        LIBRARY = albumFilter;
        AlbumFilter albumFilter2 = new AlbumFilter("LIKED", 1);
        LIKED = albumFilter2;
        AlbumFilter albumFilter3 = new AlbumFilter("UPLOADED", 2);
        UPLOADED = albumFilter3;
        $VALUES = new AlbumFilter[]{albumFilter, albumFilter2, albumFilter3};
    }

    public static AlbumFilter valueOf(String str) {
        return (AlbumFilter) Enum.valueOf(AlbumFilter.class, str);
    }

    public static AlbumFilter[] values() {
        return (AlbumFilter[]) $VALUES.clone();
    }
}
