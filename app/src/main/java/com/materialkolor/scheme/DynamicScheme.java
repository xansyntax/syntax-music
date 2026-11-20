package com.materialkolor.scheme;

import com.materialkolor.dynamiccolor.ColorSpec$SpecVersion;
import com.materialkolor.hct.Hct;
import com.materialkolor.palettes.TonalPalette;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class DynamicScheme {
    public final double contrastLevel;
    public final TonalPalette errorPalette;
    public final boolean isDark;
    public final TonalPalette neutralPalette;
    public final TonalPalette neutralVariantPalette;
    public final Platform platform;
    public final TonalPalette primaryPalette;
    public final TonalPalette secondaryPalette;
    public final int sourceColorArgb;
    public final Hct sourceColorHct;
    public final ColorSpec$SpecVersion specVersion;
    public final TonalPalette tertiaryPalette;
    public final Variant variant;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Platform {
        public static final /* synthetic */ Platform[] $VALUES;
        public static final Path.Companion Companion;
        public static final Platform Default;
        public static final Platform PHONE;
        public static final Platform WATCH;

        static {
            Platform platform = new Platform("PHONE", 0);
            PHONE = platform;
            Platform platform2 = new Platform("WATCH", 1);
            WATCH = platform2;
            $VALUES = new Platform[]{platform, platform2};
            Companion = new Path.Companion((byte) 3);
            Default = platform;
        }

        public static Platform valueOf(String str) {
            return (Platform) Enum.valueOf(Platform.class, str);
        }

        public static Platform[] values() {
            return (Platform[]) $VALUES.clone();
        }
    }

    public DynamicScheme(Hct hct, Variant variant, boolean z, double d, TonalPalette tonalPalette, TonalPalette tonalPalette2, TonalPalette tonalPalette3, TonalPalette tonalPalette4, TonalPalette tonalPalette5, Platform platform, ColorSpec$SpecVersion colorSpec$SpecVersion, TonalPalette tonalPalette6) {
        hct.getClass();
        variant.getClass();
        tonalPalette.getClass();
        tonalPalette2.getClass();
        tonalPalette3.getClass();
        tonalPalette4.getClass();
        tonalPalette5.getClass();
        platform.getClass();
        colorSpec$SpecVersion.getClass();
        tonalPalette6.getClass();
        this.sourceColorHct = hct;
        this.variant = variant;
        this.isDark = z;
        this.contrastLevel = d;
        this.primaryPalette = tonalPalette;
        this.secondaryPalette = tonalPalette2;
        this.tertiaryPalette = tonalPalette3;
        this.neutralPalette = tonalPalette4;
        this.neutralVariantPalette = tonalPalette5;
        this.platform = platform;
        this.errorPalette = tonalPalette6;
        switch (variant.ordinal()) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                colorSpec$SpecVersion = ColorSpec$SpecVersion.SPEC_2021;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            default:
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                throw null;
        }
        this.specVersion = colorSpec$SpecVersion;
        this.sourceColorArgb = hct.argb;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DynamicScheme(Hct hct, Variant variant, boolean z, double d, Platform platform, ColorSpec$SpecVersion colorSpec$SpecVersion, TonalPalette tonalPalette, TonalPalette tonalPalette2, TonalPalette tonalPalette3, TonalPalette tonalPalette4, TonalPalette tonalPalette5, TonalPalette tonalPalette6) {
        this(hct, variant, z, d, tonalPalette, tonalPalette2, tonalPalette3, tonalPalette4, tonalPalette5, platform, colorSpec$SpecVersion, tonalPalette6 == null ? TonalPalette.Companion.fromHueAndChroma(25.0d, 84.0d) : tonalPalette6);
        tonalPalette.getClass();
        tonalPalette2.getClass();
        tonalPalette3.getClass();
        tonalPalette4.getClass();
        tonalPalette5.getClass();
    }
}
