package com.metrolist.music.constants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ArtistFilter {
    public static final /* synthetic */ ArtistFilter[] $VALUES;
    public static final ArtistFilter LIBRARY;
    public static final ArtistFilter LIKED;

    static {
        ArtistFilter artistFilter = new ArtistFilter("LIBRARY", 0);
        LIBRARY = artistFilter;
        ArtistFilter artistFilter2 = new ArtistFilter("LIKED", 1);
        LIKED = artistFilter2;
        $VALUES = new ArtistFilter[]{artistFilter, artistFilter2};
    }

    public static ArtistFilter valueOf(String str) {
        return (ArtistFilter) Enum.valueOf(ArtistFilter.class, str);
    }

    public static ArtistFilter[] values() {
        return (ArtistFilter[]) $VALUES.clone();
    }
}
