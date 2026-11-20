package com.materialkolor.dynamiccolor;

import okio.Path;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ColorSpec$SpecVersion {
    public static final /* synthetic */ ColorSpec$SpecVersion[] $VALUES;
    public static final Path.Companion Companion;
    public static final ColorSpec$SpecVersion Default;
    public static final ColorSpec$SpecVersion SPEC_2021;
    public static final ColorSpec$SpecVersion SPEC_2025;

    static {
        ColorSpec$SpecVersion colorSpec$SpecVersion = new ColorSpec$SpecVersion("SPEC_2021", 0);
        SPEC_2021 = colorSpec$SpecVersion;
        ColorSpec$SpecVersion colorSpec$SpecVersion2 = new ColorSpec$SpecVersion("SPEC_2025", 1);
        SPEC_2025 = colorSpec$SpecVersion2;
        $VALUES = new ColorSpec$SpecVersion[]{colorSpec$SpecVersion, colorSpec$SpecVersion2};
        Companion = new Path.Companion((byte) 1);
        Default = colorSpec$SpecVersion;
    }

    public static ColorSpec$SpecVersion valueOf(String str) {
        return (ColorSpec$SpecVersion) Enum.valueOf(ColorSpec$SpecVersion.class, str);
    }

    public static ColorSpec$SpecVersion[] values() {
        return (ColorSpec$SpecVersion[]) $VALUES.clone();
    }
}
