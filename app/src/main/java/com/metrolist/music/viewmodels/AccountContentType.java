package com.metrolist.music.viewmodels;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AccountContentType {
    public static final /* synthetic */ AccountContentType[] $VALUES;
    public static final AccountContentType ALBUMS;
    public static final AccountContentType ARTISTS;
    public static final AccountContentType PLAYLISTS;
    public static final AccountContentType PODCASTS;

    static {
        AccountContentType accountContentType = new AccountContentType("PLAYLISTS", 0);
        PLAYLISTS = accountContentType;
        AccountContentType accountContentType2 = new AccountContentType("ALBUMS", 1);
        ALBUMS = accountContentType2;
        AccountContentType accountContentType3 = new AccountContentType("ARTISTS", 2);
        ARTISTS = accountContentType3;
        AccountContentType accountContentType4 = new AccountContentType("PODCASTS", 3);
        PODCASTS = accountContentType4;
        $VALUES = new AccountContentType[]{accountContentType, accountContentType2, accountContentType3, accountContentType4};
    }

    public static AccountContentType valueOf(String str) {
        return (AccountContentType) Enum.valueOf(AccountContentType.class, str);
    }

    public static AccountContentType[] values() {
        return (AccountContentType[]) $VALUES.clone();
    }
}
