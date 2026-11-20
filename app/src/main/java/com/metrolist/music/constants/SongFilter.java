package com.metrolist.music.constants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SongFilter {
    public static final /* synthetic */ SongFilter[] $VALUES;
    public static final SongFilter DOWNLOADED;
    public static final SongFilter LIBRARY;
    public static final SongFilter LIKED;
    public static final SongFilter UPLOADED;

    static {
        SongFilter songFilter = new SongFilter("LIBRARY", 0);
        LIBRARY = songFilter;
        SongFilter songFilter2 = new SongFilter("LIKED", 1);
        LIKED = songFilter2;
        SongFilter songFilter3 = new SongFilter("DOWNLOADED", 2);
        DOWNLOADED = songFilter3;
        SongFilter songFilter4 = new SongFilter("UPLOADED", 3);
        UPLOADED = songFilter4;
        $VALUES = new SongFilter[]{songFilter, songFilter2, songFilter3, songFilter4};
    }

    public static SongFilter valueOf(String str) {
        return (SongFilter) Enum.valueOf(SongFilter.class, str);
    }

    public static SongFilter[] values() {
        return (SongFilter[]) $VALUES.clone();
    }
}
