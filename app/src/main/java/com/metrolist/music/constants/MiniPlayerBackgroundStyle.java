package com.metrolist.music.constants;

import kotlin.enums.EnumEntriesList;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MiniPlayerBackgroundStyle {
    public static final /* synthetic */ EnumEntriesList $ENTRIES;
    public static final /* synthetic */ MiniPlayerBackgroundStyle[] $VALUES;
    public static final MiniPlayerBackgroundStyle BLUR;
    public static final MiniPlayerBackgroundStyle DEFAULT;

    static {
        MiniPlayerBackgroundStyle miniPlayerBackgroundStyle = new MiniPlayerBackgroundStyle("DEFAULT", 0);
        DEFAULT = miniPlayerBackgroundStyle;
        MiniPlayerBackgroundStyle miniPlayerBackgroundStyle2 = new MiniPlayerBackgroundStyle("TRANSPARENT", 1);
        MiniPlayerBackgroundStyle miniPlayerBackgroundStyle3 = new MiniPlayerBackgroundStyle("BLUR", 2);
        BLUR = miniPlayerBackgroundStyle3;
        MiniPlayerBackgroundStyle[] miniPlayerBackgroundStyleArr = {miniPlayerBackgroundStyle, miniPlayerBackgroundStyle2, miniPlayerBackgroundStyle3, new MiniPlayerBackgroundStyle("GRADIENT", 3), new MiniPlayerBackgroundStyle("PURE_BLACK", 4)};
        $VALUES = miniPlayerBackgroundStyleArr;
        $ENTRIES = new EnumEntriesList(miniPlayerBackgroundStyleArr);
    }

    public static MiniPlayerBackgroundStyle valueOf(String str) {
        return (MiniPlayerBackgroundStyle) Enum.valueOf(MiniPlayerBackgroundStyle.class, str);
    }

    public static MiniPlayerBackgroundStyle[] values() {
        return (MiniPlayerBackgroundStyle[]) $VALUES.clone();
    }
}
