package com.materialkolor.ktx;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.graphics.Color;
import com.materialkolor.PaletteStyle;
import com.materialkolor.dynamiccolor.ColorSpec$SpecVersion;
import com.materialkolor.dynamiccolor.ColorSpec2021;
import com.materialkolor.dynamiccolor.ColorSpec2025;
import com.materialkolor.dynamiccolor.ColorSpecs;
import com.materialkolor.hct.Hct;
import com.materialkolor.palettes.TonalPalette;
import com.materialkolor.scheme.DynamicScheme;
import com.materialkolor.scheme.SchemeContent;
import com.materialkolor.scheme.Variant;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a?\u0010\u0005\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0093\u0001\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007b\u0002\b\u001c¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u008d\u0001\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u001e\u0010\u001f\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006 "}, d2 = {"sourceColor", "Landroidx/compose/ui/graphics/Color;", "Lcom/materialkolor/scheme/DynamicScheme;", "getSourceColor", "(Lcom/materialkolor/scheme/DynamicScheme;)J", "toDynamicScheme", "isDark", "", "style", "Lcom/materialkolor/PaletteStyle;", "contrastLevel", "", "specVersion", "Lcom/materialkolor/dynamiccolor/ColorSpec$SpecVersion;", "platform", "Lcom/materialkolor/scheme/DynamicScheme$Platform;", "toDynamicScheme-KTwxG1Y", "(JZLcom/materialkolor/PaletteStyle;DLcom/materialkolor/dynamiccolor/ColorSpec$SpecVersion;Lcom/materialkolor/scheme/DynamicScheme$Platform;)Lcom/materialkolor/scheme/DynamicScheme;", "rememberDynamicScheme", "seedColor", "primary", "secondary", "tertiary", "neutral", "neutralVariant", "error", "rememberDynamicScheme-k1ZVges", "(JZLandroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Lcom/materialkolor/PaletteStyle;DLcom/materialkolor/dynamiccolor/ColorSpec$SpecVersion;Lcom/materialkolor/scheme/DynamicScheme$Platform;Landroidx/compose/runtime/Composer;III)Lcom/materialkolor/scheme/DynamicScheme;", "Landroidx/compose/runtime/Composable;", "DynamicScheme", "DynamicScheme-dtSySfE", "(JZLandroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Lcom/materialkolor/PaletteStyle;DLcom/materialkolor/dynamiccolor/ColorSpec$SpecVersion;Lcom/materialkolor/scheme/DynamicScheme$Platform;)Lcom/materialkolor/scheme/DynamicScheme;", "MaterialKolor:material-kolor"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class DynamicSchemeKt {
    /* JADX INFO: renamed from: DynamicScheme-dtSySfE, reason: not valid java name */
    public static final DynamicScheme m961DynamicSchemedtSySfE(long j, boolean z, Color color, Color color2, Color color3, Color color4, Color color5, Color color6, PaletteStyle paletteStyle, double d, ColorSpec$SpecVersion colorSpec$SpecVersion, DynamicScheme.Platform platform) {
        Variant variant;
        TonalPalette tonalPaletteM953toTonalPalette8_81llA;
        TonalPalette tonalPaletteM953toTonalPalette8_81llA2;
        TonalPalette tonalPaletteM953toTonalPalette8_81llA3;
        TonalPalette tonalPaletteM953toTonalPalette8_81llA4;
        TonalPalette tonalPaletteM953toTonalPalette8_81llA5;
        TonalPalette tonalPaletteM953toTonalPalette8_81llA6;
        paletteStyle.getClass();
        colorSpec$SpecVersion.getClass();
        platform.getClass();
        DynamicScheme dynamicSchemeM964toDynamicSchemeKTwxG1Y = m964toDynamicSchemeKTwxG1Y(j, z, paletteStyle, d, colorSpec$SpecVersion, platform);
        Hct hctM973toHct8_81llA = HctKt.m973toHct8_81llA(j);
        switch (paletteStyle.ordinal()) {
            case 0:
                variant = Variant.TONAL_SPOT;
                break;
            case 1:
                variant = Variant.NEUTRAL;
                break;
            case 2:
                variant = Variant.VIBRANT;
                break;
            case 3:
                variant = Variant.EXPRESSIVE;
                break;
            case 4:
                variant = Variant.RAINBOW;
                break;
            case 5:
                variant = Variant.FRUIT_SALAD;
                break;
            case 6:
                variant = Variant.MONOCHROME;
                break;
            case 7:
                variant = Variant.FIDELITY;
                break;
            case 8:
                variant = Variant.CONTENT;
                break;
            default:
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
        }
        if (color == null || (tonalPaletteM953toTonalPalette8_81llA = ColorKt.m953toTonalPalette8_81llA(color.value)) == null) {
            tonalPaletteM953toTonalPalette8_81llA = dynamicSchemeM964toDynamicSchemeKTwxG1Y.primaryPalette;
        }
        if (color2 == null || (tonalPaletteM953toTonalPalette8_81llA2 = ColorKt.m953toTonalPalette8_81llA(color2.value)) == null) {
            tonalPaletteM953toTonalPalette8_81llA2 = dynamicSchemeM964toDynamicSchemeKTwxG1Y.secondaryPalette;
        }
        if (color3 == null || (tonalPaletteM953toTonalPalette8_81llA3 = ColorKt.m953toTonalPalette8_81llA(color3.value)) == null) {
            tonalPaletteM953toTonalPalette8_81llA3 = dynamicSchemeM964toDynamicSchemeKTwxG1Y.tertiaryPalette;
        }
        TonalPalette tonalPalette = tonalPaletteM953toTonalPalette8_81llA3;
        if (color4 == null || (tonalPaletteM953toTonalPalette8_81llA4 = ColorKt.m953toTonalPalette8_81llA(color4.value)) == null) {
            tonalPaletteM953toTonalPalette8_81llA4 = dynamicSchemeM964toDynamicSchemeKTwxG1Y.neutralPalette;
        }
        TonalPalette tonalPalette2 = tonalPaletteM953toTonalPalette8_81llA4;
        if (color5 == null || (tonalPaletteM953toTonalPalette8_81llA5 = ColorKt.m953toTonalPalette8_81llA(color5.value)) == null) {
            tonalPaletteM953toTonalPalette8_81llA5 = dynamicSchemeM964toDynamicSchemeKTwxG1Y.neutralVariantPalette;
        }
        TonalPalette tonalPalette3 = tonalPaletteM953toTonalPalette8_81llA5;
        if (color6 == null || (tonalPaletteM953toTonalPalette8_81llA6 = ColorKt.m953toTonalPalette8_81llA(color6.value)) == null) {
            tonalPaletteM953toTonalPalette8_81llA6 = dynamicSchemeM964toDynamicSchemeKTwxG1Y.errorPalette;
        }
        return new DynamicScheme(hctM973toHct8_81llA, variant, z, d, tonalPaletteM953toTonalPalette8_81llA, tonalPaletteM953toTonalPalette8_81llA2, tonalPalette, tonalPalette2, tonalPalette3, platform, colorSpec$SpecVersion, tonalPaletteM953toTonalPalette8_81llA6);
    }

    /* JADX INFO: renamed from: DynamicScheme-dtSySfE$default, reason: not valid java name */
    public static DynamicScheme m962DynamicSchemedtSySfE$default(long j, boolean z, Color color, Color color2, Color color3, Color color4, Color color5, Color color6, PaletteStyle paletteStyle, double d, ColorSpec$SpecVersion colorSpec$SpecVersion, DynamicScheme.Platform platform, int i, Object obj) {
        ColorSpec$SpecVersion colorSpec$SpecVersion2;
        DynamicScheme.Platform platform2;
        Color color7 = (i & 4) != 0 ? null : color;
        Color color8 = (i & 8) != 0 ? null : color2;
        Color color9 = (i & 16) != 0 ? null : color3;
        Color color10 = (i & 32) != 0 ? null : color4;
        Color color11 = (i & 64) != 0 ? null : color5;
        Color color12 = (i & 128) != 0 ? null : color6;
        PaletteStyle paletteStyle2 = (i & 256) != 0 ? PaletteStyle.TonalSpot : paletteStyle;
        double d2 = (i & 512) != 0 ? 0.0d : d;
        if ((i & 1024) != 0) {
            ColorSpec$SpecVersion.Companion.getClass();
            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
        } else {
            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
        }
        if ((i & 2048) != 0) {
            DynamicScheme.Platform.Companion.getClass();
            platform2 = DynamicScheme.Platform.Default;
        } else {
            platform2 = platform;
        }
        return m961DynamicSchemedtSySfE(j, z, color7, color8, color9, color10, color11, color12, paletteStyle2, d2, colorSpec$SpecVersion2, platform2);
    }

    public static final long getSourceColor(DynamicScheme dynamicScheme) {
        dynamicScheme.getClass();
        return ((long) dynamicScheme.sourceColorArgb) << 32;
    }

    /* JADX WARN: Code duplicated, block: B:112:0x015a  */
    /* JADX WARN: Code duplicated, block: B:114:0x0168  */
    /* JADX WARN: Code duplicated, block: B:116:0x016e  */
    /* JADX WARN: Code duplicated, block: B:117:0x0170  */
    /* JADX WARN: Code duplicated, block: B:128:0x0197  */
    /* JADX WARN: Code duplicated, block: B:130:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:132:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:133:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:136:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:138:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:140:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:141:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:146:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:50:0x007e A[PHI: r14
      0x007e: PHI (r14v4 long) = (r14v2 long), (r14v5 long) binds: [B:49:0x007c, B:45:0x0074] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:60:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a2  */
    /* JADX INFO: renamed from: rememberDynamicScheme-k1ZVges, reason: not valid java name */
    public static final DynamicScheme m963rememberDynamicSchemek1ZVges(long j, boolean z, Color color, Color color2, Color color3, Color color4, Color color5, Color color6, PaletteStyle paletteStyle, double d, ColorSpec$SpecVersion colorSpec$SpecVersion, DynamicScheme.Platform platform, Composer composer, int i, int i2, int i3) {
        ColorSpec$SpecVersion colorSpec$SpecVersion2;
        DynamicScheme.Platform platform2;
        long j2;
        boolean z2;
        DynamicScheme.Platform platform3;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        GapComposer gapComposer;
        Object objRememberedValue;
        Color color7 = (i3 & 4) != 0 ? null : color;
        Color color8 = (i3 & 8) != 0 ? null : color2;
        Color color9 = (i3 & 16) != 0 ? null : color3;
        Color color10 = (i3 & 32) != 0 ? null : color4;
        Color color11 = (i3 & 64) != 0 ? null : color5;
        Color color12 = (i3 & 128) == 0 ? color6 : null;
        PaletteStyle paletteStyle2 = (i3 & 256) != 0 ? PaletteStyle.TonalSpot : paletteStyle;
        double d2 = (i3 & 512) != 0 ? 0.0d : d;
        if ((i3 & 1024) != 0) {
            ColorSpec$SpecVersion.Companion.getClass();
            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
        } else {
            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
        }
        if ((i3 & 2048) != 0) {
            DynamicScheme.Platform.Companion.getClass();
            platform2 = DynamicScheme.Platform.Default;
        } else {
            platform2 = platform;
        }
        if (((i & 14) ^ 6) > 4) {
            j2 = j;
            if (((GapComposer) composer).changed(j2)) {
                z2 = true;
            }
            platform3 = platform2;
            if (((i & 112) ^ 48) <= 32 && ((GapComposer) composer).changed(z)) {
                z3 = true;
            } else if ((i & 48) == 32) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean z8 = z3 | z2 | ((((i & 896) ^ 384) <= 256 && ((GapComposer) composer).changed(color7)) || (i & 384) == 256) | ((((i & 7168) ^ 3072) <= 2048 && ((GapComposer) composer).changed(color8)) || (i & 3072) == 2048) | ((((57344 & i) ^ 24576) <= 16384 && ((GapComposer) composer).changed(color9)) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) <= 131072 && ((GapComposer) composer).changed(color10)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) <= 1048576 && ((GapComposer) composer).changed(color11)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) <= 8388608 && ((GapComposer) composer).changed(color12)) || (i & 12582912) == 8388608);
            if (((234881024 & i) ^ 100663296) > 67108864) {
                if (!((GapComposer) composer).changed(paletteStyle2.ordinal())) {
                    z4 = true;
                } else if ((i & 100663296) == 67108864) {
                    z4 = true;
                } else {
                    z4 = false;
                }
            } else if ((i & 100663296) == 67108864) {
                z4 = true;
            } else {
                z4 = false;
            }
            boolean z9 = ((((1879048192 & i) ^ 805306368) <= 536870912 && ((GapComposer) composer).changed(d2)) || (i & 805306368) == 536870912) | z8 | z4;
            if (((i2 & 14) ^ 6) > 4) {
                if (!((GapComposer) composer).changed(colorSpec$SpecVersion2.ordinal())) {
                    z5 = true;
                } else if ((i2 & 6) == 4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
            } else if ((i2 & 6) == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
            boolean z10 = z9 | z5;
            if (((i2 & 112) ^ 48) > 32) {
                if (!((GapComposer) composer).changed(platform3.ordinal())) {
                    z6 = true;
                } else if ((i2 & 48) == 32) {
                    z6 = true;
                } else {
                    z6 = false;
                }
            } else if ((i2 & 48) == 32) {
                z6 = true;
            } else {
                z6 = false;
            }
            z7 = z10 | z6;
            gapComposer = (GapComposer) composer;
            objRememberedValue = gapComposer.rememberedValue();
            if (z7 || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = m961DynamicSchemedtSySfE(j2, z, color7, color8, color9, color10, color11, color12, paletteStyle2, d2, colorSpec$SpecVersion2, platform3);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            return (DynamicScheme) objRememberedValue;
        }
        j2 = j;
        if ((i & 6) == 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        platform3 = platform2;
        if (((i & 112) ^ 48) <= 32) {
        }
        if ((i & 48) == 32) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean z11 = z3 | z2 | ((((i & 896) ^ 384) <= 256 && ((GapComposer) composer).changed(color7)) || (i & 384) == 256) | ((((i & 7168) ^ 3072) <= 2048 && ((GapComposer) composer).changed(color8)) || (i & 3072) == 2048) | ((((57344 & i) ^ 24576) <= 16384 && ((GapComposer) composer).changed(color9)) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) <= 131072 && ((GapComposer) composer).changed(color10)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) <= 1048576 && ((GapComposer) composer).changed(color11)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) <= 8388608 && ((GapComposer) composer).changed(color12)) || (i & 12582912) == 8388608);
        if (((234881024 & i) ^ 100663296) > 67108864) {
            if (!((GapComposer) composer).changed(paletteStyle2.ordinal())) {
                z4 = true;
            } else if ((i & 100663296) == 67108864) {
                z4 = true;
            } else {
                z4 = false;
            }
        } else if ((i & 100663296) == 67108864) {
            z4 = true;
        } else {
            z4 = false;
        }
        boolean z12 = ((((1879048192 & i) ^ 805306368) <= 536870912 && ((GapComposer) composer).changed(d2)) || (i & 805306368) == 536870912) | z11 | z4;
        if (((i2 & 14) ^ 6) > 4) {
            if (!((GapComposer) composer).changed(colorSpec$SpecVersion2.ordinal())) {
                z5 = true;
            } else if ((i2 & 6) == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
        } else if ((i2 & 6) == 4) {
            z5 = true;
        } else {
            z5 = false;
        }
        boolean z13 = z12 | z5;
        if (((i2 & 112) ^ 48) > 32) {
            if (!((GapComposer) composer).changed(platform3.ordinal())) {
                z6 = true;
            } else if ((i2 & 48) == 32) {
                z6 = true;
            } else {
                z6 = false;
            }
        } else if ((i2 & 48) == 32) {
            z6 = true;
        } else {
            z6 = false;
        }
        z7 = z13 | z6;
        gapComposer = (GapComposer) composer;
        objRememberedValue = gapComposer.rememberedValue();
        if (z7) {
            objRememberedValue = m961DynamicSchemedtSySfE(j2, z, color7, color8, color9, color10, color11, color12, paletteStyle2, d2, colorSpec$SpecVersion2, platform3);
            gapComposer.updateRememberedValue(objRememberedValue);
        } else {
            objRememberedValue = m961DynamicSchemedtSySfE(j2, z, color7, color8, color9, color10, color11, color12, paletteStyle2, d2, colorSpec$SpecVersion2, platform3);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (DynamicScheme) objRememberedValue;
    }

    /* JADX INFO: renamed from: toDynamicScheme-KTwxG1Y, reason: not valid java name */
    public static final DynamicScheme m964toDynamicSchemeKTwxG1Y(long j, boolean z, PaletteStyle paletteStyle, double d, ColorSpec$SpecVersion colorSpec$SpecVersion, DynamicScheme.Platform platform) {
        paletteStyle.getClass();
        colorSpec$SpecVersion.getClass();
        platform.getClass();
        Hct hctM973toHct8_81llA = HctKt.m973toHct8_81llA(j);
        int iOrdinal = paletteStyle.ordinal();
        ColorSpec$SpecVersion colorSpec$SpecVersion2 = ColorSpec$SpecVersion.SPEC_2025;
        ColorSpec2025 colorSpec2025 = ColorSpecs.SPEC_2025;
        ColorSpec2021 colorSpec2021 = ColorSpecs.SPEC_2021;
        switch (iOrdinal) {
            case 0:
                hctM973toHct8_81llA.getClass();
                ColorSpec2021 colorSpec2022 = colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021;
                Variant variant = Variant.TONAL_SPOT;
                return new SchemeContent(hctM973toHct8_81llA, variant, z, d, platform, colorSpec$SpecVersion, colorSpec2022.getPrimaryPalette(variant, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getSecondaryPalette(variant, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getTertiaryPalette(variant, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getNeutralPalette(variant, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getNeutralVariantPalette(variant, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getErrorPalette(variant, hctM973toHct8_81llA, z, platform, d));
            case 1:
                hctM973toHct8_81llA.getClass();
                ColorSpec2021 colorSpec2023 = colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021;
                Variant variant2 = Variant.NEUTRAL;
                return new SchemeContent(hctM973toHct8_81llA, variant2, z, d, platform, colorSpec$SpecVersion, colorSpec2023.getPrimaryPalette(variant2, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getSecondaryPalette(variant2, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getTertiaryPalette(variant2, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getNeutralPalette(variant2, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getNeutralVariantPalette(variant2, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getErrorPalette(variant2, hctM973toHct8_81llA, z, platform, d));
            case 2:
                hctM973toHct8_81llA.getClass();
                ColorSpec2021 colorSpec2024 = colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021;
                Variant variant3 = Variant.VIBRANT;
                return new SchemeContent(hctM973toHct8_81llA, variant3, z, d, platform, colorSpec$SpecVersion, colorSpec2024.getPrimaryPalette(variant3, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getSecondaryPalette(variant3, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getTertiaryPalette(variant3, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getNeutralPalette(variant3, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getNeutralVariantPalette(variant3, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getErrorPalette(variant3, hctM973toHct8_81llA, z, platform, d));
            case 3:
                hctM973toHct8_81llA.getClass();
                ColorSpec2021 colorSpec2026 = colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021;
                Variant variant4 = Variant.EXPRESSIVE;
                return new SchemeContent(hctM973toHct8_81llA, variant4, z, d, platform, colorSpec$SpecVersion, colorSpec2026.getPrimaryPalette(variant4, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getSecondaryPalette(variant4, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getTertiaryPalette(variant4, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getNeutralPalette(variant4, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getNeutralVariantPalette(variant4, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getErrorPalette(variant4, hctM973toHct8_81llA, z, platform, d));
            case 4:
                hctM973toHct8_81llA.getClass();
                ColorSpec2021 colorSpec2027 = colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021;
                Variant variant5 = Variant.RAINBOW;
                return new SchemeContent(hctM973toHct8_81llA, variant5, z, d, platform, colorSpec$SpecVersion, colorSpec2027.getPrimaryPalette(variant5, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getSecondaryPalette(variant5, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getTertiaryPalette(variant5, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getNeutralPalette(variant5, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getNeutralVariantPalette(variant5, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getErrorPalette(variant5, hctM973toHct8_81llA, z, platform, d));
            case 5:
                hctM973toHct8_81llA.getClass();
                ColorSpec2021 colorSpec2028 = colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021;
                Variant variant6 = Variant.FRUIT_SALAD;
                return new SchemeContent(hctM973toHct8_81llA, variant6, z, d, platform, colorSpec$SpecVersion, colorSpec2028.getPrimaryPalette(variant6, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getSecondaryPalette(variant6, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getTertiaryPalette(variant6, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getNeutralPalette(variant6, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getNeutralVariantPalette(variant6, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getErrorPalette(variant6, hctM973toHct8_81llA, z, platform, d));
            case 6:
                hctM973toHct8_81llA.getClass();
                ColorSpec2021 colorSpec2029 = colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021;
                Variant variant7 = Variant.MONOCHROME;
                return new SchemeContent(hctM973toHct8_81llA, variant7, z, d, platform, colorSpec$SpecVersion, colorSpec2029.getPrimaryPalette(variant7, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getSecondaryPalette(variant7, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getTertiaryPalette(variant7, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getNeutralPalette(variant7, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getNeutralVariantPalette(variant7, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getErrorPalette(variant7, hctM973toHct8_81llA, z, platform, d));
            case 7:
                hctM973toHct8_81llA.getClass();
                ColorSpec2021 colorSpec20210 = colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021;
                Variant variant8 = Variant.FIDELITY;
                return new SchemeContent(hctM973toHct8_81llA, variant8, z, d, platform, colorSpec$SpecVersion, colorSpec20210.getPrimaryPalette(variant8, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getSecondaryPalette(variant8, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getTertiaryPalette(variant8, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getNeutralPalette(variant8, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getNeutralVariantPalette(variant8, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getErrorPalette(variant8, hctM973toHct8_81llA, z, platform, d));
            case 8:
                hctM973toHct8_81llA.getClass();
                ColorSpec2021 colorSpec20211 = colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021;
                Variant variant9 = Variant.CONTENT;
                return new SchemeContent(hctM973toHct8_81llA, variant9, z, d, platform, colorSpec$SpecVersion, colorSpec20211.getPrimaryPalette(variant9, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getSecondaryPalette(variant9, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getTertiaryPalette(variant9, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getNeutralPalette(variant9, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getNeutralVariantPalette(variant9, hctM973toHct8_81llA, z, platform, d), (colorSpec$SpecVersion == colorSpec$SpecVersion2 ? colorSpec2025 : colorSpec2021).getErrorPalette(variant9, hctM973toHct8_81llA, z, platform, d));
            default:
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
        }
    }

    /* JADX INFO: renamed from: toDynamicScheme-KTwxG1Y$default, reason: not valid java name */
    public static DynamicScheme m965toDynamicSchemeKTwxG1Y$default(long j, boolean z, PaletteStyle paletteStyle, double d, ColorSpec$SpecVersion colorSpec$SpecVersion, DynamicScheme.Platform platform, int i, Object obj) {
        ColorSpec$SpecVersion colorSpec$SpecVersion2;
        DynamicScheme.Platform platform2;
        if ((i & 4) != 0) {
            d = 0.0d;
        }
        double d2 = d;
        if ((i & 8) != 0) {
            ColorSpec$SpecVersion.Companion.getClass();
            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
        } else {
            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
        }
        if ((i & 16) != 0) {
            DynamicScheme.Platform.Companion.getClass();
            platform2 = DynamicScheme.Platform.Default;
        } else {
            platform2 = platform;
        }
        return m964toDynamicSchemeKTwxG1Y(j, z, paletteStyle, d2, colorSpec$SpecVersion2, platform2);
    }
}
