package com.materialkolor.dynamiccolor;

import androidx.room.RoomDatabase$$ExternalSyntheticLambda2;
import coil3.network.NetworkFetcher;
import com.materialkolor.hct.Hct;
import com.materialkolor.hct.HctSolver;
import com.materialkolor.palettes.TonalPalette;
import com.materialkolor.scheme.DynamicScheme;
import com.materialkolor.scheme.Variant;
import com.materialkolor.utils.MathUtils;
import com.metrolist.innertube.YouTube$$ExternalSyntheticLambda0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ColorSpec2025 extends ColorSpec2021 {
    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final DynamicColor background() {
        DynamicColor$Companion$Builder builder = surface().toBuilder();
        builder.name = "background";
        return super.background().toBuilder().extendSpecVersion(builder.build()).build();
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final DynamicColor error() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "error";
        dynamicColor$Companion$Builder.palette = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 5);
        dynamicColor$Companion$Builder.tone = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 6);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 21);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 7);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 22);
        return super.error().toBuilder().extendSpecVersion(dynamicColor$Companion$Builder.build()).build();
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final DynamicColor errorContainer() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "error_container";
        dynamicColor$Companion$Builder.palette = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 28);
        byte b = 0;
        dynamicColor$Companion$Builder.tone = new ColorSpec2025$$ExternalSyntheticLambda1(b);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new ColorSpec2025$$ExternalSyntheticLambda2(this, b);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 27);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 26);
        return super.errorContainer().toBuilder().extendSpecVersion(dynamicColor$Companion$Builder.build()).build();
    }

    public final DynamicColor errorDim() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "error_dim";
        dynamicColor$Companion$Builder.palette = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 26);
        dynamicColor$Companion$Builder.tone = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 27);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 17);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 29);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 18);
        return dynamicColor$Companion$Builder.build();
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final TonalPalette getErrorPalette(Variant variant, Hct hct, boolean z, DynamicScheme.Platform platform, double d) {
        double[] dArr = {0.0d, 3.0d, 13.0d, 23.0d, 33.0d, 43.0d, 153.0d, 273.0d, 360.0d};
        double[] dArr2 = {12.0d, 22.0d, 32.0d, 12.0d, 22.0d, 32.0d, 22.0d, 12.0d};
        int iMin = Math.min(8, 8);
        double d2 = hct.hue;
        for (int i = 0; i < iMin; i++) {
            if (d2 >= dArr[i] && d2 < dArr[i + 1]) {
                double d3 = dArr2[i] % 360.0d;
                if (d3 < 0.0d) {
                    d3 += 360.0d;
                }
                d2 = d3;
                break;
            }
        }
        int iOrdinal = variant.ordinal();
        DynamicScheme.Platform platform2 = DynamicScheme.Platform.PHONE;
        if (iOrdinal == 1) {
            return TonalPalette.Companion.fromHueAndChroma(d2, platform == platform2 ? 50.0d : 40.0d);
        }
        if (iOrdinal == 2) {
            return TonalPalette.Companion.fromHueAndChroma(d2, platform == platform2 ? 60.0d : 48.0d);
        }
        if (iOrdinal == 3) {
            return TonalPalette.Companion.fromHueAndChroma(d2, platform == platform2 ? 80.0d : 60.0d);
        }
        if (iOrdinal == 4) {
            return TonalPalette.Companion.fromHueAndChroma(d2, platform == platform2 ? 64.0d : 48.0d);
        }
        super.getErrorPalette(variant, hct, z, platform, d);
        return null;
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final Hct getHct(DynamicColor dynamicColor, DynamicScheme dynamicScheme) {
        Double d;
        TonalPalette tonalPalette = (TonalPalette) dynamicColor.palette.invoke(dynamicScheme);
        double tone = getTone(dynamicColor, dynamicScheme);
        Function1 function1 = dynamicColor.chromaMultiplier;
        double dDoubleValue = (function1 == null || (d = (Double) function1.invoke(dynamicScheme)) == null) ? 1.0d : d.doubleValue();
        if (dDoubleValue == 1.0d) {
            return tonalPalette.getHct(tone);
        }
        double d2 = tonalPalette.chroma;
        double d3 = tonalPalette.hue;
        double d4 = d2 * dDoubleValue;
        return (tone != 99.0d || d3 < 105.0d || d3 >= 125.0d) ? new Hct(HctSolver.solveToInt(d3, d4, tone)) : TonalPalette.Companion.fromHueAndChroma(d3, d4).getHct(tone);
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final TonalPalette getNeutralPalette(Variant variant, Hct hct, boolean z, DynamicScheme.Platform platform, double d) {
        double d2 = hct.hue;
        int iOrdinal = variant.ordinal();
        DynamicScheme.Platform platform2 = DynamicScheme.Platform.PHONE;
        if (iOrdinal == 1) {
            return TonalPalette.Companion.fromHueAndChroma(d2, platform == platform2 ? 1.4d : 6.0d);
        }
        if (iOrdinal == 2) {
            return TonalPalette.Companion.fromHueAndChroma(d2, platform == platform2 ? 5.0d : 10.0d);
        }
        if (iOrdinal != 3) {
            return iOrdinal != 4 ? super.getNeutralPalette(variant, hct, z, platform, d) : TonalPalette.Companion.fromHueAndChroma(Path.Companion.getExpressiveNeutralHue(hct), Path.Companion.getExpressiveNeutralChroma(hct, z, platform));
        }
        return TonalPalette.Companion.fromHueAndChroma(Path.Companion.getVibrantNeutralHue(hct), Path.Companion.getVibrantNeutralChroma(hct, platform));
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final TonalPalette getNeutralVariantPalette(Variant variant, Hct hct, boolean z, DynamicScheme.Platform platform, double d) {
        double d2 = hct.hue;
        int iOrdinal = variant.ordinal();
        DynamicScheme.Platform platform2 = DynamicScheme.Platform.PHONE;
        if (iOrdinal == 1) {
            return TonalPalette.Companion.fromHueAndChroma(d2, (platform == platform2 ? 1.4d : 6.0d) * 2.2d);
        }
        if (iOrdinal == 2) {
            return TonalPalette.Companion.fromHueAndChroma(d2, (platform == platform2 ? 5.0d : 10.0d) * 1.7d);
        }
        if (iOrdinal == 3) {
            return TonalPalette.Companion.fromHueAndChroma(Path.Companion.getVibrantNeutralHue(hct), Path.Companion.getVibrantNeutralChroma(hct, platform) * 1.29d);
        }
        if (iOrdinal != 4) {
            return super.getNeutralVariantPalette(variant, hct, z, platform, d);
        }
        double expressiveNeutralHue = Path.Companion.getExpressiveNeutralHue(hct);
        return TonalPalette.Companion.fromHueAndChroma(expressiveNeutralHue, Path.Companion.getExpressiveNeutralChroma(hct, z, platform) * ((expressiveNeutralHue < 105.0d || expressiveNeutralHue >= 125.0d) ? 2.3d : 1.6d));
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final TonalPalette getPrimaryPalette(Variant variant, Hct hct, boolean z, DynamicScheme.Platform platform, double d) {
        double d2;
        double d3 = hct.hue;
        int iOrdinal = variant.ordinal();
        DynamicScheme.Platform platform2 = DynamicScheme.Platform.PHONE;
        if (iOrdinal == 1) {
            double d4 = 12.0d;
            if (platform == platform2) {
                if (d3 < 250.0d || d3 >= 270.0d) {
                    d4 = 8.0d;
                }
            } else if (d3 >= 250.0d && d3 < 270.0d) {
                d4 = 16.0d;
            }
            return TonalPalette.Companion.fromHueAndChroma(d3, d4);
        }
        if (iOrdinal == 2) {
            return TonalPalette.Companion.fromHueAndChroma(d3, (platform == platform2 && z) ? 26.0d : 32.0d);
        }
        if (iOrdinal == 3) {
            return TonalPalette.Companion.fromHueAndChroma(d3, platform == platform2 ? 74.0d : 56.0d);
        }
        if (iOrdinal != 4) {
            return super.getPrimaryPalette(variant, hct, z, platform, d);
        }
        if (platform == platform2) {
            d2 = z ? 36.0d : 48.0d;
        } else {
            d2 = 40.0d;
        }
        return TonalPalette.Companion.fromHueAndChroma(d3, d2);
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final TonalPalette getSecondaryPalette(Variant variant, Hct hct, boolean z, DynamicScheme.Platform platform, double d) {
        double d2 = hct.hue;
        int iOrdinal = variant.ordinal();
        DynamicScheme.Platform platform2 = DynamicScheme.Platform.PHONE;
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return TonalPalette.Companion.fromHueAndChroma(d2, 16.0d);
            }
            if (iOrdinal == 3) {
                return TonalPalette.Companion.fromHueAndChroma(UuidKt.getRotatedHue(hct, new double[]{0.0d, 38.0d, 105.0d, 140.0d, 333.0d, 360.0d}, new double[]{-14.0d, 10.0d, -14.0d, 10.0d, -14.0d}), platform == platform2 ? 56.0d : 36.0d);
            }
            if (iOrdinal != 4) {
                return super.getSecondaryPalette(variant, hct, z, platform, d);
            }
            return TonalPalette.Companion.fromHueAndChroma(UuidKt.getRotatedHue(hct, new double[]{0.0d, 105.0d, 140.0d, 204.0d, 253.0d, 278.0d, 300.0d, 333.0d, 360.0d}, new double[]{-160.0d, 155.0d, -100.0d, 96.0d, -96.0d, -156.0d, -165.0d, -160.0d}), (platform == platform2 && z) ? 16.0d : 24.0d);
        }
        double d3 = 6.0d;
        if (platform == platform2) {
            if (d2 < 250.0d || d2 >= 270.0d) {
                d3 = 4.0d;
            }
        } else if (d2 >= 250.0d && d2 < 270.0d) {
            d3 = 10.0d;
        }
        return TonalPalette.Companion.fromHueAndChroma(d2, d3);
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final TonalPalette getTertiaryPalette(Variant variant, Hct hct, boolean z, DynamicScheme.Platform platform, double d) {
        int iOrdinal = variant.ordinal();
        DynamicScheme.Platform platform2 = DynamicScheme.Platform.PHONE;
        if (iOrdinal == 1) {
            return TonalPalette.Companion.fromHueAndChroma(UuidKt.getRotatedHue(hct, new double[]{0.0d, 38.0d, 105.0d, 161.0d, 204.0d, 278.0d, 333.0d, 360.0d}, new double[]{-32.0d, 26.0d, 10.0d, -39.0d, 24.0d, -15.0d, -32.0d}), platform == platform2 ? 20.0d : 36.0d);
        }
        if (iOrdinal == 2) {
            return TonalPalette.Companion.fromHueAndChroma(UuidKt.getRotatedHue(hct, new double[]{0.0d, 20.0d, 71.0d, 161.0d, 333.0d, 360.0d}, new double[]{-40.0d, 48.0d, -32.0d, 40.0d, -32.0d}), platform == platform2 ? 28.0d : 32.0d);
        }
        if (iOrdinal != 3) {
            return iOrdinal != 4 ? super.getTertiaryPalette(variant, hct, z, platform, d) : TonalPalette.Companion.fromHueAndChroma(UuidKt.getRotatedHue(hct, new double[]{0.0d, 105.0d, 140.0d, 204.0d, 253.0d, 278.0d, 300.0d, 333.0d, 360.0d}, new double[]{-165.0d, 160.0d, -105.0d, 101.0d, -101.0d, -160.0d, -170.0d, -165.0d}), 48.0d);
        }
        return TonalPalette.Companion.fromHueAndChroma(UuidKt.getRotatedHue(hct, new double[]{0.0d, 38.0d, 71.0d, 105.0d, 140.0d, 161.0d, 253.0d, 333.0d, 360.0d}, new double[]{-72.0d, 35.0d, 24.0d, -24.0d, 62.0d, 50.0d, 62.0d, -72.0d}), 56.0d);
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final double getTone(DynamicColor dynamicColor, DynamicScheme dynamicScheme) {
        DynamicColor dynamicColor2;
        ContrastCurve contrastCurve;
        DynamicColor dynamicColor3;
        double dCoerceIn;
        dynamicScheme.getClass();
        boolean z = dynamicScheme.isDark;
        double d = dynamicScheme.contrastLevel;
        boolean z2 = dynamicColor.isBackground;
        Function1 function1 = dynamicColor.background;
        Function1 function2 = dynamicColor.contrastCurve;
        String str = dynamicColor.name;
        Function1 function3 = dynamicColor.toneDeltaPair;
        Double dValueOf = null;
        ToneDeltaPair toneDeltaPair = function3 != null ? (ToneDeltaPair) function3.invoke(dynamicScheme) : null;
        if (toneDeltaPair == null) {
            double dDoubleValue = ((Number) dynamicColor.tone.invoke(dynamicScheme)).doubleValue();
            Double dValueOf2 = (function1 == null || (dynamicColor3 = (DynamicColor) function1.invoke(dynamicScheme)) == null) ? null : Double.valueOf(dynamicColor3.getTone(dynamicScheme));
            if (function2 != null && (contrastCurve = (ContrastCurve) function2.invoke(dynamicScheme)) != null) {
                dValueOf = Double.valueOf(contrastCurve.get(d));
            }
            if (dValueOf2 == null || dValueOf == null) {
                return dDoubleValue;
            }
            if (HexFormatKt.ratioOfTones(dValueOf2.doubleValue(), dDoubleValue) < dValueOf.doubleValue() || d < 0.0d) {
                dDoubleValue = ColorSpecs.foregroundTone(dValueOf2.doubleValue(), dValueOf.doubleValue());
            }
            double dCoerceIn2 = dDoubleValue;
            if (z2 && !StringsKt__StringsJVMKt.endsWith(str, "_fixed_dim", false)) {
                dCoerceIn2 = dCoerceIn2 >= 57.0d ? UuidKt.coerceIn(dCoerceIn2, 65.0d, 100.0d) : UuidKt.coerceIn(dCoerceIn2, 0.0d, 49.0d);
            }
            double d2 = dCoerceIn2;
            Function1 function4 = dynamicColor.secondBackground;
            if (function4 != null && (dynamicColor2 = (DynamicColor) function4.invoke(dynamicScheme)) != null) {
                double tone = dynamicColor2.getTone(dynamicScheme);
                double dMax = Math.max(dValueOf2.doubleValue(), tone);
                double dMin = Math.min(dValueOf2.doubleValue(), tone);
                if (HexFormatKt.ratioOfTones(dMax, d2) < dValueOf.doubleValue() || HexFormatKt.ratioOfTones(dMin, d2) < dValueOf.doubleValue()) {
                    double dLighter = HexFormatKt.lighter(dMax, dValueOf.doubleValue());
                    double dDarker = HexFormatKt.darker(dMin, dValueOf.doubleValue());
                    ArrayList arrayList = new ArrayList();
                    if (dLighter != -1.0d) {
                        arrayList.add(Double.valueOf(dLighter));
                    }
                    if (dDarker != -1.0d) {
                        arrayList.add(Double.valueOf(dDarker));
                    }
                    if (Math.rint(dValueOf2.doubleValue()) < 60.0d || Math.rint(tone) < 60.0d) {
                        if (dLighter < 0.0d) {
                            return 100.0d;
                        }
                        return dLighter;
                    }
                    if (arrayList.size() == 1) {
                        return ((Number) CollectionsKt.first((List) arrayList)).doubleValue();
                    }
                    if (dDarker < 0.0d) {
                        return 0.0d;
                    }
                    return dDarker;
                }
            }
            return d2;
        }
        double d3 = toneDeltaPair.delta;
        DynamicColor dynamicColor4 = toneDeltaPair.roleA;
        DynamicColor dynamicColor5 = toneDeltaPair.roleB;
        TonePolarity tonePolarity = toneDeltaPair.polarity;
        ToneDeltaPair.DeltaConstraint deltaConstraint = toneDeltaPair.deltaConstraint;
        if (tonePolarity == TonePolarity.DARKER || ((tonePolarity == TonePolarity.RELATIVE_LIGHTER && z) || (tonePolarity == TonePolarity.RELATIVE_DARKER && !z))) {
            d3 = -d3;
        }
        boolean zAreEqual = Intrinsics.areEqual(str, dynamicColor4.name);
        DynamicColor dynamicColor6 = zAreEqual ? dynamicColor4 : dynamicColor5;
        if (zAreEqual) {
            dynamicColor4 = dynamicColor5;
        }
        double dDoubleValue2 = ((Number) dynamicColor6.tone.invoke(dynamicScheme)).doubleValue();
        double tone2 = dynamicColor4.getTone(dynamicScheme);
        double d4 = d3 * ((double) (zAreEqual ? 1 : -1));
        int iOrdinal = deltaConstraint.ordinal();
        if (iOrdinal == 0) {
            dCoerceIn = UuidKt.coerceIn(tone2 + d4, 0.0d, 100.0d);
        } else if (iOrdinal == 1) {
            dCoerceIn = d4 > 0.0d ? UuidKt.coerceIn(UuidKt.coerceIn(dDoubleValue2, tone2, tone2 + d4), 0.0d, 100.0d) : UuidKt.coerceIn(UuidKt.coerceIn(dDoubleValue2, tone2 + d4, tone2), 0.0d, 100.0d);
        } else {
            if (iOrdinal != 2) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return 0.0d;
            }
            dCoerceIn = d4 > 0.0d ? UuidKt.coerceIn(dDoubleValue2, tone2 + d4, 100.0d) : UuidKt.coerceIn(dDoubleValue2, 0.0d, tone2 + d4);
        }
        if (function1 != null && function2 != null) {
            DynamicColor dynamicColor7 = (DynamicColor) function1.invoke(dynamicScheme);
            ContrastCurve contrastCurve2 = (ContrastCurve) function2.invoke(dynamicScheme);
            if (dynamicColor7 != null && contrastCurve2 != null) {
                double tone3 = dynamicColor7.getTone(dynamicScheme);
                double d5 = contrastCurve2.get(d);
                double dYFromLstar = MathUtils.yFromLstar(tone3);
                double d6 = dCoerceIn;
                double dYFromLstar2 = MathUtils.yFromLstar(d6);
                double dMax2 = Math.max(dYFromLstar, dYFromLstar2);
                if (dMax2 != dYFromLstar2) {
                    dYFromLstar = dYFromLstar2;
                }
                dCoerceIn = ((dMax2 + 5.0d) / (dYFromLstar + 5.0d) < d5 || d < 0.0d) ? ColorSpecs.foregroundTone(tone3, d5) : d6;
            }
        }
        double d7 = dCoerceIn;
        if (!z2 || StringsKt__StringsJVMKt.endsWith(str, "_fixed_dim", false)) {
            return d7;
        }
        return d7 >= 57.0d ? UuidKt.coerceIn(d7, 65.0d, 100.0d) : UuidKt.coerceIn(d7, 0.0d, 49.0d);
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final DynamicColor inverseSurface() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "inverse_surface";
        dynamicColor$Companion$Builder.palette = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 21);
        dynamicColor$Companion$Builder.tone = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 22);
        dynamicColor$Companion$Builder.isBackground = true;
        return super.inverseSurface().toBuilder().extendSpecVersion(dynamicColor$Companion$Builder.build()).build();
    }

    public final DynamicColor onSurface() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "on_surface";
        dynamicColor$Companion$Builder.palette = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 14);
        byte b = 25;
        dynamicColor$Companion$Builder.tone = new ColorSpec2025$$ExternalSyntheticLambda2(this, b);
        dynamicColor$Companion$Builder.chromaMultiplier = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 15);
        byte b2 = 26;
        dynamicColor$Companion$Builder.background = new ColorSpec2025$$ExternalSyntheticLambda2(this, b2);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 16);
        DynamicColor dynamicColorBuild = dynamicColor$Companion$Builder.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder2 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder2.name = "on_surface";
        dynamicColor$Companion$Builder2.palette = new ColorSpec2021$$ExternalSyntheticLambda7(b2);
        dynamicColor$Companion$Builder2.tone = new RoomDatabase$$ExternalSyntheticLambda2(b);
        dynamicColor$Companion$Builder2.background = new NetworkFetcher.AnonymousClass2(1, this, ColorSpec2021.class, "highestSurface", "highestSurface(Lcom/materialkolor/scheme/DynamicScheme;)Lcom/materialkolor/dynamiccolor/DynamicColor;", 0, (byte) 10);
        dynamicColor$Companion$Builder2.contrastCurve = new RoomDatabase$$ExternalSyntheticLambda2(b2);
        return dynamicColor$Companion$Builder2.build().toBuilder().extendSpecVersion(dynamicColorBuild).build();
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final DynamicColor primary() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "primary";
        dynamicColor$Companion$Builder.palette = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 28);
        dynamicColor$Companion$Builder.tone = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 1);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 19);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 2);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 20);
        return super.primary().toBuilder().extendSpecVersion(dynamicColor$Companion$Builder.build()).build();
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final DynamicColor primaryContainer() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "primary_container";
        dynamicColor$Companion$Builder.palette = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 2);
        dynamicColor$Companion$Builder.tone = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 3);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new ColorSpec2025$$ExternalSyntheticLambda7(this, (byte) 1);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2025$$ExternalSyntheticLambda7(this, (byte) 2);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 4);
        return super.primaryContainer().toBuilder().extendSpecVersion(dynamicColor$Companion$Builder.build()).build();
    }

    public final DynamicColor primaryDim() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "primary_dim";
        dynamicColor$Companion$Builder.palette = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 23);
        dynamicColor$Companion$Builder.tone = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 24);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 15);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 25);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 16);
        return dynamicColor$Companion$Builder.build();
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final DynamicColor primaryFixed() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "primary_fixed";
        dynamicColor$Companion$Builder.palette = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 12);
        dynamicColor$Companion$Builder.tone = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 23);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 24);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 13);
        return super.primaryFixed().toBuilder().extendSpecVersion(dynamicColor$Companion$Builder.build()).build();
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final DynamicColor primaryFixedDim() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "primary_fixed_dim";
        dynamicColor$Companion$Builder.palette = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 24);
        dynamicColor$Companion$Builder.tone = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 7);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 8);
        return super.primaryFixedDim().toBuilder().extendSpecVersion(dynamicColor$Companion$Builder.build()).build();
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final DynamicColor secondary() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "secondary";
        dynamicColor$Companion$Builder.palette = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 0);
        dynamicColor$Companion$Builder.tone = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 14);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new ColorSpec2025$$ExternalSyntheticLambda7(this, (byte) 0);
        dynamicColor$Companion$Builder.contrastCurve = new YouTube$$ExternalSyntheticLambda0((byte) 5);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2025$$ExternalSyntheticLambda7(this, (byte) 7);
        return super.secondary().toBuilder().extendSpecVersion(dynamicColor$Companion$Builder.build()).build();
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final DynamicColor secondaryContainer() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "secondary_container";
        dynamicColor$Companion$Builder.palette = new YouTube$$ExternalSyntheticLambda0((byte) 3);
        dynamicColor$Companion$Builder.tone = new YouTube$$ExternalSyntheticLambda0((byte) 4);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new ColorSpec2025$$ExternalSyntheticLambda7(this, (byte) 3);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2025$$ExternalSyntheticLambda7(this, (byte) 4);
        dynamicColor$Companion$Builder.contrastCurve = new YouTube$$ExternalSyntheticLambda0((byte) 6);
        return super.secondaryContainer().toBuilder().extendSpecVersion(dynamicColor$Companion$Builder.build()).build();
    }

    public final DynamicColor secondaryDim() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "secondary_dim";
        dynamicColor$Companion$Builder.palette = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 16);
        dynamicColor$Companion$Builder.tone = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 17);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 11);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 18);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 12);
        return dynamicColor$Companion$Builder.build();
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final DynamicColor secondaryFixed() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "secondary_fixed";
        dynamicColor$Companion$Builder.palette = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 26);
        dynamicColor$Companion$Builder.tone = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 9);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 10);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 27);
        return super.secondaryFixed().toBuilder().extendSpecVersion(dynamicColor$Companion$Builder.build()).build();
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final DynamicColor secondaryFixedDim() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "secondary_fixed_dim";
        dynamicColor$Companion$Builder.palette = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 23);
        dynamicColor$Companion$Builder.tone = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 5);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 6);
        return super.secondaryFixedDim().toBuilder().extendSpecVersion(dynamicColor$Companion$Builder.build()).build();
    }

    public final DynamicColor surface() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "surface";
        dynamicColor$Companion$Builder.palette = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 3);
        dynamicColor$Companion$Builder.tone = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 4);
        dynamicColor$Companion$Builder.isBackground = true;
        DynamicColor dynamicColorBuild = dynamicColor$Companion$Builder.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder2 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder2.name = "surface";
        dynamicColor$Companion$Builder2.palette = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 20);
        dynamicColor$Companion$Builder2.tone = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 21);
        dynamicColor$Companion$Builder2.isBackground = true;
        return dynamicColor$Companion$Builder2.build().toBuilder().extendSpecVersion(dynamicColorBuild).build();
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final DynamicColor surfaceBright() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "surface_bright";
        dynamicColor$Companion$Builder.palette = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 6);
        dynamicColor$Companion$Builder.tone = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 7);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.chromaMultiplier = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 8);
        return super.surfaceBright().toBuilder().extendSpecVersion(dynamicColor$Companion$Builder.build()).build();
    }

    public final DynamicColor surfaceContainerHigh() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "surface_container_high";
        dynamicColor$Companion$Builder.palette = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 23);
        dynamicColor$Companion$Builder.tone = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 24);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.chromaMultiplier = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 25);
        DynamicColor dynamicColorBuild = dynamicColor$Companion$Builder.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder2 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder2.name = "surface_container_high";
        dynamicColor$Companion$Builder2.palette = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 11);
        dynamicColor$Companion$Builder2.tone = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 12);
        dynamicColor$Companion$Builder2.isBackground = true;
        return dynamicColor$Companion$Builder2.build().toBuilder().extendSpecVersion(dynamicColorBuild).build();
    }

    public final DynamicColor surfaceContainerHighest() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "surface_container_highest";
        dynamicColor$Companion$Builder.palette = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 11);
        dynamicColor$Companion$Builder.tone = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 12);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.chromaMultiplier = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 13);
        DynamicColor dynamicColorBuild = dynamicColor$Companion$Builder.build();
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder2 = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder2.name = "surface_container_highest";
        dynamicColor$Companion$Builder2.palette = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 21);
        dynamicColor$Companion$Builder2.tone = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 22);
        dynamicColor$Companion$Builder2.isBackground = true;
        return dynamicColor$Companion$Builder2.build().toBuilder().extendSpecVersion(dynamicColorBuild).build();
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final DynamicColor surfaceDim() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "surface_dim";
        dynamicColor$Companion$Builder.palette = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 5);
        dynamicColor$Companion$Builder.tone = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 6);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.chromaMultiplier = new ColorSpec2025$$ExternalSyntheticLambda5((byte) 7);
        return super.surfaceDim().toBuilder().extendSpecVersion(dynamicColor$Companion$Builder.build()).build();
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final DynamicColor tertiary() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "tertiary";
        dynamicColor$Companion$Builder.palette = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 20);
        dynamicColor$Companion$Builder.tone = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 21);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 3);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 22);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 4);
        return super.tertiary().toBuilder().extendSpecVersion(dynamicColor$Companion$Builder.build()).build();
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final DynamicColor tertiaryContainer() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "tertiary_container";
        dynamicColor$Companion$Builder.palette = new YouTube$$ExternalSyntheticLambda0((byte) 11);
        dynamicColor$Companion$Builder.tone = new YouTube$$ExternalSyntheticLambda0((byte) 12);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new ColorSpec2025$$ExternalSyntheticLambda7(this, (byte) 5);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2025$$ExternalSyntheticLambda7(this, (byte) 6);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 29);
        return super.tertiaryContainer().toBuilder().extendSpecVersion(dynamicColor$Companion$Builder.build()).build();
    }

    public final DynamicColor tertiaryDim() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "tertiary_dim";
        dynamicColor$Companion$Builder.palette = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 19);
        dynamicColor$Companion$Builder.tone = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 20);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 13);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda13((byte) 22);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 14);
        return dynamicColor$Companion$Builder.build();
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final DynamicColor tertiaryFixed() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "tertiary_fixed";
        dynamicColor$Companion$Builder.palette = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 25);
        dynamicColor$Companion$Builder.tone = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 28);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 29);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2025$$ExternalSyntheticLambda1((byte) 27);
        return super.tertiaryFixed().toBuilder().extendSpecVersion(dynamicColor$Companion$Builder.build()).build();
    }

    @Override // com.materialkolor.dynamiccolor.ColorSpec2021
    public final DynamicColor tertiaryFixedDim() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "tertiary_fixed_dim";
        dynamicColor$Companion$Builder.palette = new ColorSpec2025$$ExternalSyntheticLambda10((byte) 14);
        dynamicColor$Companion$Builder.tone = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 1);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2025$$ExternalSyntheticLambda2(this, (byte) 2);
        return super.tertiaryFixedDim().toBuilder().extendSpecVersion(dynamicColor$Companion$Builder.build()).build();
    }
}
