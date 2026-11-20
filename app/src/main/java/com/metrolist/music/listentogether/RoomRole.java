package com.metrolist.music.listentogether;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RoomRole {
    public static final /* synthetic */ RoomRole[] $VALUES;
    public static final RoomRole GUEST;
    public static final RoomRole HOST;
    public static final RoomRole NONE;

    static {
        RoomRole roomRole = new RoomRole("HOST", 0);
        HOST = roomRole;
        RoomRole roomRole2 = new RoomRole("GUEST", 1);
        GUEST = roomRole2;
        RoomRole roomRole3 = new RoomRole("NONE", 2);
        NONE = roomRole3;
        $VALUES = new RoomRole[]{roomRole, roomRole2, roomRole3};
    }

    public static RoomRole valueOf(String str) {
        return (RoomRole) Enum.valueOf(RoomRole.class, str);
    }

    public static RoomRole[] values() {
        return (RoomRole[]) $VALUES.clone();
    }
}
