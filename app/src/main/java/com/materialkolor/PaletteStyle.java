package com.materialkolor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PaletteStyle {
    public static final /* synthetic */ PaletteStyle[] $VALUES;
    public static final PaletteStyle Expressive;
    public static final PaletteStyle TonalSpot;

    static {
        PaletteStyle paletteStyle = new PaletteStyle("TonalSpot", 0);
        TonalSpot = paletteStyle;
        PaletteStyle paletteStyle2 = new PaletteStyle("Neutral", 1);
        PaletteStyle paletteStyle3 = new PaletteStyle("Vibrant", 2);
        PaletteStyle paletteStyle4 = new PaletteStyle("Expressive", 3);
        Expressive = paletteStyle4;
        $VALUES = new PaletteStyle[]{paletteStyle, paletteStyle2, paletteStyle3, paletteStyle4, new PaletteStyle("Rainbow", 4), new PaletteStyle("FruitSalad", 5), new PaletteStyle("Monochrome", 6), new PaletteStyle("Fidelity", 7), new PaletteStyle("Content", 8)};
    }

    public static PaletteStyle valueOf(String str) {
        return (PaletteStyle) Enum.valueOf(PaletteStyle.class, str);
    }

    public static PaletteStyle[] values() {
        return (PaletteStyle[]) $VALUES.clone();
    }
}
