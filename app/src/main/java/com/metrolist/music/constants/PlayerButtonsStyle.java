package com.metrolist.music.constants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlayerButtonsStyle {
    public static final /* synthetic */ PlayerButtonsStyle[] $VALUES;
    public static final PlayerButtonsStyle DEFAULT;

    static {
        PlayerButtonsStyle playerButtonsStyle = new PlayerButtonsStyle("DEFAULT", 0);
        DEFAULT = playerButtonsStyle;
        $VALUES = new PlayerButtonsStyle[]{playerButtonsStyle, new PlayerButtonsStyle("PRIMARY", 1), new PlayerButtonsStyle("TERTIARY", 2)};
    }

    public static PlayerButtonsStyle valueOf(String str) {
        return (PlayerButtonsStyle) Enum.valueOf(PlayerButtonsStyle.class, str);
    }

    public static PlayerButtonsStyle[] values() {
        return (PlayerButtonsStyle[]) $VALUES.clone();
    }
}
