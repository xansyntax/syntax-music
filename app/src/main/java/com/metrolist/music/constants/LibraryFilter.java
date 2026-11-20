package com.metrolist.music.constants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LibraryFilter {
    public static final /* synthetic */ LibraryFilter[] $VALUES;
    public static final LibraryFilter ALBUMS;
    public static final LibraryFilter ARTISTS;
    public static final LibraryFilter LIBRARY;
    public static final LibraryFilter PLAYLISTS;
    public static final LibraryFilter PODCASTS;
    public static final LibraryFilter SONGS;

    static {
        LibraryFilter libraryFilter = new LibraryFilter("SONGS", 0);
        SONGS = libraryFilter;
        LibraryFilter libraryFilter2 = new LibraryFilter("ARTISTS", 1);
        ARTISTS = libraryFilter2;
        LibraryFilter libraryFilter3 = new LibraryFilter("ALBUMS", 2);
        ALBUMS = libraryFilter3;
        LibraryFilter libraryFilter4 = new LibraryFilter("PLAYLISTS", 3);
        PLAYLISTS = libraryFilter4;
        LibraryFilter libraryFilter5 = new LibraryFilter("PODCASTS", 4);
        PODCASTS = libraryFilter5;
        LibraryFilter libraryFilter6 = new LibraryFilter("LIBRARY", 5);
        LIBRARY = libraryFilter6;
        $VALUES = new LibraryFilter[]{libraryFilter, libraryFilter2, libraryFilter3, libraryFilter4, libraryFilter5, libraryFilter6};
    }

    public static LibraryFilter valueOf(String str) {
        return (LibraryFilter) Enum.valueOf(LibraryFilter.class, str);
    }

    public static LibraryFilter[] values() {
        return (LibraryFilter[]) $VALUES.clone();
    }
}
