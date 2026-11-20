package com.metrolist.music.constants;

import kotlin.enums.EnumEntriesList;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlayerBackgroundStyle {
    public static final /* synthetic */ EnumEntriesList $ENTRIES;
    public static final /* synthetic */ PlayerBackgroundStyle[] $VALUES;
    public static final PlayerBackgroundStyle BLUR;
    public static final PlayerBackgroundStyle DEFAULT;

    static {
        PlayerBackgroundStyle playerBackgroundStyle = new PlayerBackgroundStyle("DEFAULT", 0);
        DEFAULT = playerBackgroundStyle;
        PlayerBackgroundStyle playerBackgroundStyle2 = new PlayerBackgroundStyle("GRADIENT", 1);
        PlayerBackgroundStyle playerBackgroundStyle3 = new PlayerBackgroundStyle("BLUR", 2);
        BLUR = playerBackgroundStyle3;
        PlayerBackgroundStyle[] playerBackgroundStyleArr = {playerBackgroundStyle, playerBackgroundStyle2, playerBackgroundStyle3};
        $VALUES = playerBackgroundStyleArr;
        $ENTRIES = new EnumEntriesList(playerBackgroundStyleArr);
    }

    public static PlayerBackgroundStyle valueOf(String str) {
        return (PlayerBackgroundStyle) Enum.valueOf(PlayerBackgroundStyle.class, str);
    }

    public static PlayerBackgroundStyle[] values() {
        return (PlayerBackgroundStyle[]) $VALUES.clone();
    }
}
