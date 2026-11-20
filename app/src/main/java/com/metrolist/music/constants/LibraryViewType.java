package com.metrolist.music.constants;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LibraryViewType {
    public static final /* synthetic */ LibraryViewType[] $VALUES;
    public static final LibraryViewType GRID;
    public static final LibraryViewType LIST;

    static {
        LibraryViewType libraryViewType = new LibraryViewType("LIST", 0);
        LIST = libraryViewType;
        LibraryViewType libraryViewType2 = new LibraryViewType("GRID", 1);
        GRID = libraryViewType2;
        $VALUES = new LibraryViewType[]{libraryViewType, libraryViewType2};
    }

    public static LibraryViewType valueOf(String str) {
        return (LibraryViewType) Enum.valueOf(LibraryViewType.class, str);
    }

    public static LibraryViewType[] values() {
        return (LibraryViewType[]) $VALUES.clone();
    }

    public final LibraryViewType toggle() {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return GRID;
        }
        if (iOrdinal == 1) {
            return LIST;
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1();
        return null;
    }
}
