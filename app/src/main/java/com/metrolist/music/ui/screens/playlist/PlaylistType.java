package com.metrolist.music.ui.screens.playlist;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaylistType {
    public static final /* synthetic */ PlaylistType[] $VALUES;
    public static final PlaylistType DOWNLOAD;
    public static final PlaylistType LIKE;
    public static final PlaylistType OTHER;
    public static final PlaylistType UPLOADED;

    static {
        PlaylistType playlistType = new PlaylistType("LIKE", 0);
        LIKE = playlistType;
        PlaylistType playlistType2 = new PlaylistType("DOWNLOAD", 1);
        DOWNLOAD = playlistType2;
        PlaylistType playlistType3 = new PlaylistType("UPLOADED", 2);
        UPLOADED = playlistType3;
        PlaylistType playlistType4 = new PlaylistType("OTHER", 3);
        OTHER = playlistType4;
        $VALUES = new PlaylistType[]{playlistType, playlistType2, playlistType3, playlistType4};
    }

    public static PlaylistType valueOf(String str) {
        return (PlaylistType) Enum.valueOf(PlaylistType.class, str);
    }

    public static PlaylistType[] values() {
        return (PlaylistType[]) $VALUES.clone();
    }
}
