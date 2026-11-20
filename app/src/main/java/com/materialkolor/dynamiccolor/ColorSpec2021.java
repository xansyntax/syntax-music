package com.materialkolor.dynamiccolor;

import androidx.room.RoomDatabase$$ExternalSyntheticLambda2;
import coil3.network.NetworkFetcher;
import com.materialkolor.hct.Hct;
import com.materialkolor.palettes.TonalPalette;
import com.materialkolor.scheme.DynamicScheme;
import com.materialkolor.scheme.Variant;
import com.materialkolor.temperature.TemperatureCache;
import com.materialkolor.utils.MathUtils;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlin.text.RegexKt;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class ColorSpec2021 {
    public static boolean isFidelity(DynamicScheme dynamicScheme) {
        Variant variant = dynamicScheme.variant;
        return variant == Variant.FIDELITY || variant == Variant.CONTENT;
    }

    public DynamicColor background() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "background";
        dynamicColor$Companion$Builder.palette = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 16);
        dynamicColor$Companion$Builder.tone = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 27);
        dynamicColor$Companion$Builder.isBackground = true;
        return dynamicColor$Companion$Builder.build();
    }

    public DynamicColor error() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "error";
        dynamicColor$Companion$Builder.palette = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 12);
        dynamicColor$Companion$Builder.tone = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 13);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new NetworkFetcher.AnonymousClass2(1, this, ColorSpec2021.class, "highestSurface", "highestSurface(Lcom/materialkolor/scheme/DynamicScheme;)Lcom/materialkolor/dynamiccolor/DynamicColor;", 0, (byte) 8);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 14);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2021$$ExternalSyntheticLambda13(this, (byte) 7);
        return dynamicColor$Companion$Builder.build();
    }

    public DynamicColor errorContainer() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "error_container";
        dynamicColor$Companion$Builder.palette = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 29);
        dynamicColor$Companion$Builder.tone = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 1);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new NetworkFetcher.AnonymousClass2(1, this, ColorSpec2021.class, "highestSurface", "highestSurface(Lcom/materialkolor/scheme/DynamicScheme;)Lcom/materialkolor/dynamiccolor/DynamicColor;", 0, (byte) 9);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 2);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2021$$ExternalSyntheticLambda13(this, (byte) 9);
        return dynamicColor$Companion$Builder.build();
    }

    public TonalPalette getErrorPalette(Variant variant, Hct hct, boolean z, DynamicScheme.Platform platform, double d) {
        switch (variant.ordinal()) {
            default:
                PathKt$$ExternalSyntheticBUOutline0.m$1();
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
        }
    }

    public Hct getHct(DynamicColor dynamicColor, DynamicScheme dynamicScheme) {
        return ((TonalPalette) dynamicColor.palette.invoke(dynamicScheme)).getHct(getTone(dynamicColor, dynamicScheme));
    }

    public TonalPalette getNeutralPalette(Variant variant, Hct hct, boolean z, DynamicScheme.Platform platform, double d) {
        double d2 = hct.hue;
        switch (variant.ordinal()) {
            case 0:
                return TonalPalette.Companion.fromHueAndChroma(d2, 0.0d);
            case 1:
                return TonalPalette.Companion.fromHueAndChroma(d2, 2.0d);
            case 2:
                return TonalPalette.Companion.fromHueAndChroma(d2, 6.0d);
            case 3:
                return TonalPalette.Companion.fromHueAndChroma(d2, 10.0d);
            case 4:
                double d3 = (d2 + 15.0d) % 360.0d;
                if (d3 < 0.0d) {
                    d3 += 360.0d;
                }
                return TonalPalette.Companion.fromHueAndChroma(d3, 8.0d);
            case 5:
            case 6:
                return TonalPalette.Companion.fromHueAndChroma(d2, hct.chroma / 8.0d);
            case 7:
                return TonalPalette.Companion.fromHueAndChroma(d2, 0.0d);
            case 8:
                return TonalPalette.Companion.fromHueAndChroma(d2, 10.0d);
            default:
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
        }
    }

    public TonalPalette getNeutralVariantPalette(Variant variant, Hct hct, boolean z, DynamicScheme.Platform platform, double d) {
        double d2 = hct.chroma;
        double d3 = hct.hue;
        switch (variant.ordinal()) {
            case 0:
                return TonalPalette.Companion.fromHueAndChroma(d3, 0.0d);
            case 1:
                return TonalPalette.Companion.fromHueAndChroma(d3, 2.0d);
            case 2:
                return TonalPalette.Companion.fromHueAndChroma(d3, 8.0d);
            case 3:
                return TonalPalette.Companion.fromHueAndChroma(d3, 12.0d);
            case 4:
                double d4 = (d3 + 15.0d) % 360.0d;
                if (d4 < 0.0d) {
                    d4 += 360.0d;
                }
                return TonalPalette.Companion.fromHueAndChroma(d4, 12.0d);
            case 5:
                return TonalPalette.Companion.fromHueAndChroma(d3, (d2 / 8.0d) + 4.0d);
            case 6:
                return TonalPalette.Companion.fromHueAndChroma(d3, (d2 / 8.0d) + 4.0d);
            case 7:
                return TonalPalette.Companion.fromHueAndChroma(d3, 0.0d);
            case 8:
                return TonalPalette.Companion.fromHueAndChroma(d3, 16.0d);
            default:
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
        }
    }

    public TonalPalette getPrimaryPalette(Variant variant, Hct hct, boolean z, DynamicScheme.Platform platform, double d) {
        double d2 = hct.hue;
        switch (variant.ordinal()) {
            case 0:
                return TonalPalette.Companion.fromHueAndChroma(d2, 0.0d);
            case 1:
                return TonalPalette.Companion.fromHueAndChroma(d2, 12.0d);
            case 2:
                return TonalPalette.Companion.fromHueAndChroma(d2, 36.0d);
            case 3:
                return TonalPalette.Companion.fromHueAndChroma(d2, 200.0d);
            case 4:
                double d3 = (d2 + 240.0d) % 360.0d;
                if (d3 < 0.0d) {
                    d3 += 360.0d;
                }
                return TonalPalette.Companion.fromHueAndChroma(d3, 40.0d);
            case 5:
            case 6:
                return TonalPalette.Companion.fromHueAndChroma(d2, hct.chroma);
            case 7:
                return TonalPalette.Companion.fromHueAndChroma(d2, 48.0d);
            case 8:
                double d4 = (d2 - 50.0d) % 360.0d;
                if (d4 < 0.0d) {
                    d4 += 360.0d;
                }
                return TonalPalette.Companion.fromHueAndChroma(d4, 48.0d);
            default:
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
        }
    }

    public TonalPalette getSecondaryPalette(Variant variant, Hct hct, boolean z, DynamicScheme.Platform platform, double d) {
        double d2 = hct.hue;
        switch (variant.ordinal()) {
            case 0:
                return TonalPalette.Companion.fromHueAndChroma(d2, 0.0d);
            case 1:
                return TonalPalette.Companion.fromHueAndChroma(d2, 8.0d);
            case 2:
                return TonalPalette.Companion.fromHueAndChroma(d2, 16.0d);
            case 3:
                return TonalPalette.Companion.fromHueAndChroma(UuidKt.getRotatedHue(hct, new double[]{0.0d, 41.0d, 61.0d, 101.0d, 131.0d, 181.0d, 251.0d, 301.0d, 360.0d}, new double[]{18.0d, 15.0d, 10.0d, 12.0d, 15.0d, 18.0d, 15.0d, 12.0d, 12.0d}), 24.0d);
            case 4:
                return TonalPalette.Companion.fromHueAndChroma(UuidKt.getRotatedHue(hct, new double[]{0.0d, 21.0d, 51.0d, 121.0d, 151.0d, 191.0d, 271.0d, 321.0d, 360.0d}, new double[]{45.0d, 95.0d, 45.0d, 20.0d, 45.0d, 90.0d, 45.0d, 45.0d, 45.0d}), 24.0d);
            case 5:
            case 6:
                double d3 = hct.chroma;
                return TonalPalette.Companion.fromHueAndChroma(d2, Math.max(d3 - 32.0d, d3 * 0.5d));
            case 7:
                return TonalPalette.Companion.fromHueAndChroma(d2, 16.0d);
            case 8:
                double d4 = (d2 - 50.0d) % 360.0d;
                if (d4 < 0.0d) {
                    d4 += 360.0d;
                }
                return TonalPalette.Companion.fromHueAndChroma(d4, 36.0d);
            default:
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0237  */
    /* JADX WARN: Code duplicated, block: B:132:0x0103 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:136:0x0126 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:44:0x00f2 A[LOOP:5: B:43:0x00f0->B:44:0x00f2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:47:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:51:0x0112  */
    /* JADX WARN: Code duplicated, block: B:53:0x0115 A[LOOP:7: B:52:0x0113->B:53:0x0115, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:56:0x0121  */
    public TonalPalette getTertiaryPalette(Variant variant, Hct hct, boolean z, DynamicScheme.Platform platform, double d) {
        Hct hct2;
        double dAbs;
        ArrayList arrayList;
        int i;
        int i2;
        int i3;
        int i4;
        int size;
        int size2;
        double d2 = hct.hue;
        boolean z2 = false;
        double d3 = 0.0d;
        switch (variant.ordinal()) {
            case 0:
                return TonalPalette.Companion.fromHueAndChroma(d2, 0.0d);
            case 1:
                return TonalPalette.Companion.fromHueAndChroma(d2, 16.0d);
            case 2:
            case 7:
                double d4 = (d2 + 60.0d) % 360.0d;
                if (d4 < 0.0d) {
                    d4 += 360.0d;
                }
                return TonalPalette.Companion.fromHueAndChroma(d4, 24.0d);
            case 3:
                return TonalPalette.Companion.fromHueAndChroma(UuidKt.getRotatedHue(hct, new double[]{0.0d, 41.0d, 61.0d, 101.0d, 131.0d, 181.0d, 251.0d, 301.0d, 360.0d}, new double[]{35.0d, 30.0d, 20.0d, 25.0d, 30.0d, 35.0d, 30.0d, 25.0d, 25.0d}), 32.0d);
            case 4:
                return TonalPalette.Companion.fromHueAndChroma(UuidKt.getRotatedHue(hct, new double[]{0.0d, 21.0d, 51.0d, 121.0d, 151.0d, 191.0d, 271.0d, 321.0d, 360.0d}, new double[]{120.0d, 120.0d, 20.0d, 45.0d, 20.0d, 15.0d, 20.0d, 120.0d, 120.0d}), 32.0d);
            case 5:
                TemperatureCache temperatureCache = new TemperatureCache(hct);
                Hct hct3 = temperatureCache.precomputedComplement;
                if (hct3 == null) {
                    double d5 = temperatureCache.getColdest().hue;
                    Object obj = ((HashMap) temperatureCache.getTempsByHct()).get(temperatureCache.getColdest());
                    obj.getClass();
                    double dDoubleValue = ((Number) obj).doubleValue();
                    double d6 = temperatureCache.getWarmest().hue;
                    Object obj2 = ((HashMap) temperatureCache.getTempsByHct()).get(temperatureCache.getWarmest());
                    obj2.getClass();
                    double dDoubleValue2 = ((Number) obj2).doubleValue() - dDoubleValue;
                    if (d5 >= d6 ? d5 <= d2 || d2 <= d6 : d5 <= d2 && d2 <= d6) {
                        z2 = true;
                    }
                    double d7 = z2 ? d6 : d5;
                    if (!z2) {
                        d5 = d6;
                    }
                    Hct hct4 = (Hct) ((ArrayList) temperatureCache.getHctsByHue()).get((int) Math.rint(d2));
                    double relativeTemperature = 1.0d - temperatureCache.getRelativeTemperature(hct);
                    double d8 = 1000.0d;
                    double d9 = 0.0d;
                    while (d9 <= 360.0d) {
                        double d10 = ((1.0d * d9) + d7) % 360.0d;
                        if (d10 < d3) {
                            d10 += 360.0d;
                        }
                        if (d7 < d5) {
                            if (d7 > d10 || d10 > d5) {
                                d9 += 1.0d;
                            } else {
                                double d11 = d3;
                                hct2 = (Hct) ((ArrayList) temperatureCache.getHctsByHue()).get((int) Math.rint(d10));
                                Object obj3 = ((HashMap) temperatureCache.getTempsByHct()).get(hct2);
                                obj3.getClass();
                                dAbs = Math.abs(relativeTemperature - ((((Number) obj3).doubleValue() - dDoubleValue) / dDoubleValue2));
                                if (dAbs < d8) {
                                    hct4 = hct2;
                                    d8 = dAbs;
                                }
                                d9 += 1.0d;
                                d3 = d11;
                            }
                        } else if (d7 <= d10 || d10 <= d5) {
                            double d12 = d3;
                            hct2 = (Hct) ((ArrayList) temperatureCache.getHctsByHue()).get((int) Math.rint(d10));
                            Object obj4 = ((HashMap) temperatureCache.getTempsByHct()).get(hct2);
                            obj4.getClass();
                            dAbs = Math.abs(relativeTemperature - ((((Number) obj4).doubleValue() - dDoubleValue) / dDoubleValue2));
                            if (dAbs < d8) {
                                hct4 = hct2;
                                d8 = dAbs;
                            }
                            d9 += 1.0d;
                            d3 = d12;
                        } else {
                            d9 += 1.0d;
                        }
                    }
                    temperatureCache.precomputedComplement = hct4;
                    hct4.getClass();
                    hct3 = hct4;
                }
                Hct hctFixIfDisliked = RegexKt.fixIfDisliked(hct3);
                return new TonalPalette(hctFixIfDisliked.hue, hctFixIfDisliked.chroma, hctFixIfDisliked);
            case 6:
                TemperatureCache temperatureCache2 = new TemperatureCache(hct);
                int iRint = (int) Math.rint(d2);
                Hct hct5 = (Hct) ((ArrayList) temperatureCache2.getHctsByHue()).get(iRint);
                double relativeTemperature2 = temperatureCache2.getRelativeTemperature(hct5);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(hct5);
                int i5 = 0;
                double dAbs2 = 0.0d;
                while (i5 < 360) {
                    int i6 = (iRint + i5) % 360;
                    if (i6 < 0) {
                        i6 += 360;
                    }
                    double relativeTemperature3 = temperatureCache2.getRelativeTemperature((Hct) ((ArrayList) temperatureCache2.getHctsByHue()).get(i6));
                    dAbs2 += Math.abs(relativeTemperature3 - relativeTemperature2);
                    i5++;
                    relativeTemperature2 = relativeTemperature3;
                }
                double d13 = dAbs2 / 6.0d;
                double relativeTemperature4 = temperatureCache2.getRelativeTemperature(hct5);
                int i7 = 1;
                while (arrayList2.size() < 6) {
                    int i8 = (iRint + i7) % 360;
                    if (i8 < 0) {
                        i8 += 360;
                    }
                    Hct hct6 = (Hct) ((ArrayList) temperatureCache2.getHctsByHue()).get(i8);
                    double relativeTemperature5 = temperatureCache2.getRelativeTemperature(hct6);
                    double dAbs3 = d3 + Math.abs(relativeTemperature5 - relativeTemperature4);
                    boolean z3 = dAbs3 >= ((double) arrayList2.size()) * d13;
                    int i9 = 1;
                    while (z3 && arrayList2.size() < 6) {
                        arrayList2.add(hct6);
                        double d14 = dAbs3;
                        z3 = d14 >= ((double) (arrayList2.size() + i9)) * d13;
                        i9++;
                        dAbs3 = d14;
                    }
                    double d15 = dAbs3;
                    i7++;
                    if (i7 > 360) {
                        while (arrayList2.size() < 6) {
                            arrayList2.add(hct6);
                        }
                        arrayList = new ArrayList();
                        arrayList.add(hct);
                        int iFloor = (int) Math.floor(1.0d);
                        i = iFloor + 1;
                        for (i2 = 1; i2 < i; i2++) {
                            size2 = 0 - i2;
                            while (size2 < 0) {
                                size2 += arrayList2.size();
                            }
                            if (size2 >= arrayList2.size()) {
                                size2 %= arrayList2.size();
                            }
                            arrayList.add(0, arrayList2.get(size2));
                        }
                        i3 = 3 - iFloor;
                        for (i4 = 1; i4 < i3; i4++) {
                            size = i4;
                            while (size < 0) {
                                size += arrayList2.size();
                            }
                            if (size >= arrayList2.size()) {
                                size %= arrayList2.size();
                            }
                            arrayList.add(arrayList2.get(size));
                        }
                        Hct hctFixIfDisliked2 = RegexKt.fixIfDisliked((Hct) arrayList.get(2));
                        return new TonalPalette(hctFixIfDisliked2.hue, hctFixIfDisliked2.chroma, hctFixIfDisliked2);
                    }
                    d3 = d15;
                    relativeTemperature4 = relativeTemperature5;
                }
                arrayList = new ArrayList();
                arrayList.add(hct);
                int iFloor2 = (int) Math.floor(1.0d);
                i = iFloor2 + 1;
                while (i2 < i) {
                    size2 = 0 - i2;
                    while (size2 < 0) {
                        size2 += arrayList2.size();
                    }
                    if (size2 >= arrayList2.size()) {
                        size2 %= arrayList2.size();
                    }
                    arrayList.add(0, arrayList2.get(size2));
                }
                i3 = 3 - iFloor2;
                while (i4 < i3) {
                    size = i4;
                    while (size < 0) {
                        size += arrayList2.size();
                    }
                    if (size >= arrayList2.size()) {
                        size %= arrayList2.size();
                    }
                    arrayList.add(arrayList2.get(size));
                }
                Hct hctFixIfDisliked3 = RegexKt.fixIfDisliked((Hct) arrayList.get(2));
                return new TonalPalette(hctFixIfDisliked3.hue, hctFixIfDisliked3.chroma, hctFixIfDisliked3);
            case 8:
                return TonalPalette.Companion.fromHueAndChroma(d2, 36.0d);
            default:
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:60:0x010a  */
    public double getTone(DynamicColor dynamicColor, DynamicScheme dynamicScheme) {
        DynamicColor dynamicColor2;
        double d;
        double d2;
        double dCoerceIn;
        double d3;
        dynamicScheme.getClass();
        boolean z = dynamicScheme.isDark;
        Function1 function1 = dynamicColor.contrastCurve;
        Function1 function2 = dynamicColor.background;
        double d4 = dynamicScheme.contrastLevel;
        boolean z2 = d4 < 0.0d;
        Function1 function3 = dynamicColor.toneDeltaPair;
        Double dValueOf = null;
        ToneDeltaPair toneDeltaPair = function3 == null ? null : (ToneDeltaPair) function3.invoke(dynamicScheme);
        if (toneDeltaPair == null) {
            boolean z3 = z2;
            double dDoubleValue = ((Number) dynamicColor.tone.invoke(dynamicScheme)).doubleValue();
            if (function2 == null || function1 == null) {
                return dDoubleValue;
            }
            DynamicColor dynamicColor3 = (DynamicColor) function2.invoke(dynamicScheme);
            double tone = dynamicColor3 != null ? dynamicColor3.getTone(dynamicScheme) : 0.0d;
            ContrastCurve contrastCurve = (ContrastCurve) function1.invoke(dynamicScheme);
            double d5 = contrastCurve != null ? contrastCurve.get(d4) : 0.0d;
            if (HexFormatKt.ratioOfTones(tone, dDoubleValue) < d5) {
                dDoubleValue = ColorSpecs.foregroundTone(tone, d5);
            }
            if (z3) {
                dDoubleValue = ColorSpecs.foregroundTone(tone, d5);
            }
            if (dynamicColor.isBackground && 50.0d <= dDoubleValue && dDoubleValue < 60.0d) {
                dDoubleValue = HexFormatKt.ratioOfTones(49.0d, tone) >= d5 ? 49.0d : 60.0d;
            }
            Function1 function4 = dynamicColor.secondBackground;
            if (function4 != null && (dynamicColor2 = (DynamicColor) function4.invoke(dynamicScheme)) != null) {
                dValueOf = Double.valueOf(dynamicColor2.getTone(dynamicScheme));
            }
            if (dValueOf != null) {
                DynamicColor dynamicColor4 = (DynamicColor) function2.invoke(dynamicScheme);
                double tone2 = dynamicColor4 != null ? dynamicColor4.getTone(dynamicScheme) : 0.0d;
                double dMax = Math.max(tone2, dValueOf.doubleValue());
                double dMin = Math.min(tone2, dValueOf.doubleValue());
                if (HexFormatKt.ratioOfTones(dMax, dDoubleValue) < d5 || HexFormatKt.ratioOfTones(dMin, dDoubleValue) < d5) {
                    double dLighter = HexFormatKt.lighter(dMax, d5);
                    double dDarker = HexFormatKt.darker(dMin, d5);
                    ArrayList arrayList = new ArrayList();
                    if (dLighter != -1.0d) {
                        arrayList.add(Double.valueOf(dLighter));
                    }
                    if (dDarker != -1.0d) {
                        arrayList.add(Double.valueOf(dDarker));
                    }
                    if (Math.rint(tone2) < 60.0d || Math.rint(dValueOf.doubleValue()) < 60.0d) {
                        if (dLighter == -1.0d) {
                            return 100.0d;
                        }
                        return dLighter;
                    }
                    if (arrayList.size() == 1) {
                        return ((Number) CollectionsKt.first((List) arrayList)).doubleValue();
                    }
                    if (dDarker == -1.0d) {
                        return 0.0d;
                    }
                    return dDarker;
                }
            }
            return dDoubleValue;
        }
        DynamicColor dynamicColor5 = toneDeltaPair.roleA;
        DynamicColor dynamicColor6 = toneDeltaPair.roleB;
        double d6 = toneDeltaPair.delta;
        TonePolarity tonePolarity = toneDeltaPair.polarity;
        boolean z4 = toneDeltaPair.stayTogether;
        boolean z5 = tonePolarity == TonePolarity.NEARER || (tonePolarity == TonePolarity.LIGHTER && !z) || (tonePolarity == TonePolarity.DARKER && !z);
        DynamicColor dynamicColor7 = z5 ? dynamicColor5 : dynamicColor6;
        if (z5) {
            dynamicColor5 = dynamicColor6;
        }
        String str = dynamicColor.name;
        String str2 = dynamicColor7.name;
        Function1 function5 = dynamicColor7.contrastCurve;
        boolean zAreEqual = Intrinsics.areEqual(str, str2);
        double d7 = z ? 1 : -1;
        double dDoubleValue2 = ((Number) dynamicColor7.tone.invoke(dynamicScheme)).doubleValue();
        Function1 function6 = dynamicColor5.tone;
        Function1 function7 = dynamicColor5.contrastCurve;
        double dDoubleValue3 = ((Number) function6.invoke(dynamicScheme)).doubleValue();
        if (function2 == null || function5 == null || function7 == null) {
            d = d7;
            d2 = dDoubleValue2;
            dCoerceIn = d2;
        } else {
            DynamicColor dynamicColor8 = (DynamicColor) function2.invoke(dynamicScheme);
            ContrastCurve contrastCurve2 = (ContrastCurve) function5.invoke(dynamicScheme);
            ContrastCurve contrastCurve3 = (ContrastCurve) function7.invoke(dynamicScheme);
            if (dynamicColor8 == null || contrastCurve2 == null || contrastCurve3 == null) {
                d = d7;
                d2 = dDoubleValue2;
            } else {
                d = d7;
                double d8 = contrastCurve2.get(d4);
                double d9 = contrastCurve3.get(d4);
                double tone3 = dynamicColor8.getTone(dynamicScheme);
                double dYFromLstar = MathUtils.yFromLstar(tone3);
                boolean z6 = z2;
                double dYFromLstar2 = MathUtils.yFromLstar(dDoubleValue2);
                double dMax2 = Math.max(dYFromLstar, dYFromLstar2);
                if (dMax2 != dYFromLstar2) {
                    dYFromLstar = dYFromLstar2;
                }
                double dForegroundTone = (dMax2 + 5.0d) / (dYFromLstar + 5.0d) < d8 ? ColorSpecs.foregroundTone(tone3, d8) : dDoubleValue2;
                double dYFromLstar3 = MathUtils.yFromLstar(tone3);
                d2 = dForegroundTone;
                double dYFromLstar4 = MathUtils.yFromLstar(dDoubleValue3);
                double dMax3 = Math.max(dYFromLstar3, dYFromLstar4);
                if (dMax3 != dYFromLstar4) {
                    dYFromLstar3 = dYFromLstar4;
                }
                if ((dMax3 + 5.0d) / (dYFromLstar3 + 5.0d) < d9) {
                    dDoubleValue3 = ColorSpecs.foregroundTone(tone3, d9);
                }
                if (z6) {
                    dCoerceIn = ColorSpecs.foregroundTone(tone3, d8);
                    dDoubleValue3 = ColorSpecs.foregroundTone(tone3, d9);
                }
            }
            dCoerceIn = d2;
        }
        if ((dDoubleValue3 - dCoerceIn) * d < d6) {
            double d10 = d6 * d;
            dDoubleValue3 = UuidKt.coerceIn(dCoerceIn + d10, 0.0d, 100.0d);
            if ((dDoubleValue3 - dCoerceIn) * d < d6) {
                dCoerceIn = UuidKt.coerceIn(dDoubleValue3 - d10, 0.0d, 100.0d);
            }
        }
        double dMin2 = dDoubleValue3;
        if (50.0d > dCoerceIn || dCoerceIn >= 60.0d) {
            if (50.0d <= dMin2 && dMin2 < 60.0d) {
                if (!z4) {
                    dMin2 = d > 0.0d ? 60.0d : 49.0d;
                } else if (d > 0.0d) {
                    dMin2 = Math.max(dMin2, (d6 * d) + 60.0d);
                    d3 = 60.0d;
                } else {
                    dMin2 = Math.min(dMin2, (d6 * d) + 49.0d);
                    d3 = 49.0d;
                }
            }
            d3 = dCoerceIn;
        } else if (d > 0.0d) {
            dMin2 = Math.max(dMin2, (d6 * d) + 60.0d);
            d3 = 60.0d;
        } else {
            dMin2 = Math.min(dMin2, (d6 * d) + 49.0d);
            d3 = 49.0d;
        }
        return zAreEqual ? d3 : dMin2;
    }

    public final DynamicColor highestSurface(DynamicScheme dynamicScheme) {
        dynamicScheme.getClass();
        return dynamicScheme.isDark ? surfaceBright() : surfaceDim();
    }

    public DynamicColor inverseSurface() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "inverse_surface";
        dynamicColor$Companion$Builder.palette = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 17);
        dynamicColor$Companion$Builder.tone = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 27);
        dynamicColor$Companion$Builder.isBackground = true;
        return dynamicColor$Companion$Builder.build();
    }

    public DynamicColor primary() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "primary";
        dynamicColor$Companion$Builder.palette = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 15);
        dynamicColor$Companion$Builder.tone = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 16);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new NetworkFetcher.AnonymousClass2(1, this, ColorSpec2021.class, "highestSurface", "highestSurface(Lcom/materialkolor/scheme/DynamicScheme;)Lcom/materialkolor/dynamiccolor/DynamicColor;", 0, (byte) 14);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 17);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2021$$ExternalSyntheticLambda13(this, (byte) 3);
        return dynamicColor$Companion$Builder.build();
    }

    public DynamicColor primaryContainer() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "primary_container";
        byte b = 0;
        dynamicColor$Companion$Builder.palette = new ColorSpec2021$$ExternalSyntheticLambda10(b);
        dynamicColor$Companion$Builder.tone = new ColorSpec2021$$ExternalSyntheticLambda10(this);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new NetworkFetcher.AnonymousClass2(1, this, ColorSpec2021.class, "highestSurface", "highestSurface(Lcom/materialkolor/scheme/DynamicScheme;)Lcom/materialkolor/dynamiccolor/DynamicColor;", 0, (byte) 15);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 24);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2021$$ExternalSyntheticLambda13(this, b);
        return dynamicColor$Companion$Builder.build();
    }

    public DynamicColor primaryFixed() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "primary_fixed";
        dynamicColor$Companion$Builder.palette = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 22);
        dynamicColor$Companion$Builder.tone = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 23);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new NetworkFetcher.AnonymousClass2(1, this, ColorSpec2021.class, "highestSurface", "highestSurface(Lcom/materialkolor/scheme/DynamicScheme;)Lcom/materialkolor/dynamiccolor/DynamicColor;", 0, (byte) 16);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 25);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2021$$ExternalSyntheticLambda13(this, (byte) 4);
        return dynamicColor$Companion$Builder.build();
    }

    public DynamicColor primaryFixedDim() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "primary_fixed_dim";
        dynamicColor$Companion$Builder.palette = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 2);
        dynamicColor$Companion$Builder.tone = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 3);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new NetworkFetcher.AnonymousClass2(1, this, ColorSpec2021.class, "highestSurface", "highestSurface(Lcom/materialkolor/scheme/DynamicScheme;)Lcom/materialkolor/dynamiccolor/DynamicColor;", 0, (byte) 17);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 4);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2021$$ExternalSyntheticLambda13(this, (byte) 11);
        return dynamicColor$Companion$Builder.build();
    }

    public DynamicColor secondary() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "secondary";
        dynamicColor$Companion$Builder.palette = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 0);
        dynamicColor$Companion$Builder.tone = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 25);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new NetworkFetcher.AnonymousClass2(1, this, ColorSpec2021.class, "highestSurface", "highestSurface(Lcom/materialkolor/scheme/DynamicScheme;)Lcom/materialkolor/dynamiccolor/DynamicColor;", 0, (byte) 18);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 4);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2021$$ExternalSyntheticLambda13(this, (byte) 6);
        return dynamicColor$Companion$Builder.build();
    }

    public DynamicColor secondaryContainer() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "secondary_container";
        dynamicColor$Companion$Builder.palette = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 23);
        dynamicColor$Companion$Builder.tone = new ColorSpec2021$$ExternalSyntheticLambda7(this);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new NetworkFetcher.AnonymousClass2(1, this, ColorSpec2021.class, "highestSurface", "highestSurface(Lcom/materialkolor/scheme/DynamicScheme;)Lcom/materialkolor/dynamiccolor/DynamicColor;", 0, (byte) 19);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 25);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2021$$ExternalSyntheticLambda13(this, (byte) 13);
        return dynamicColor$Companion$Builder.build();
    }

    public DynamicColor secondaryFixed() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "secondary_fixed";
        dynamicColor$Companion$Builder.palette = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 18);
        dynamicColor$Companion$Builder.tone = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 19);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new NetworkFetcher.AnonymousClass2(1, this, ColorSpec2021.class, "highestSurface", "highestSurface(Lcom/materialkolor/scheme/DynamicScheme;)Lcom/materialkolor/dynamiccolor/DynamicColor;", 0, (byte) 20);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda4((byte) 20);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2021$$ExternalSyntheticLambda13(this, (byte) 10);
        return dynamicColor$Companion$Builder.build();
    }

    public DynamicColor secondaryFixedDim() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "secondary_fixed_dim";
        dynamicColor$Companion$Builder.palette = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 5);
        dynamicColor$Companion$Builder.tone = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 6);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new NetworkFetcher.AnonymousClass2(1, this, ColorSpec2021.class, "highestSurface", "highestSurface(Lcom/materialkolor/scheme/DynamicScheme;)Lcom/materialkolor/dynamiccolor/DynamicColor;", 0, (byte) 21);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda7((byte) 7);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2021$$ExternalSyntheticLambda13(this, (byte) 12);
        return dynamicColor$Companion$Builder.build();
    }

    public DynamicColor surfaceBright() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "surface_bright";
        dynamicColor$Companion$Builder.palette = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 10);
        dynamicColor$Companion$Builder.tone = new ColorSpec2021$$ExternalSyntheticLambda14((byte) 11);
        dynamicColor$Companion$Builder.isBackground = true;
        return dynamicColor$Companion$Builder.build();
    }

    public DynamicColor surfaceDim() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "surface_dim";
        dynamicColor$Companion$Builder.palette = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 10);
        dynamicColor$Companion$Builder.tone = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 11);
        dynamicColor$Companion$Builder.isBackground = true;
        return dynamicColor$Companion$Builder.build();
    }

    public DynamicColor tertiary() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "tertiary";
        dynamicColor$Companion$Builder.palette = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 25);
        dynamicColor$Companion$Builder.tone = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 26);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new NetworkFetcher.AnonymousClass2(1, this, ColorSpec2021.class, "highestSurface", "highestSurface(Lcom/materialkolor/scheme/DynamicScheme;)Lcom/materialkolor/dynamiccolor/DynamicColor;", 0, (byte) 22);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 28);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2021$$ExternalSyntheticLambda13(this, (byte) 8);
        return dynamicColor$Companion$Builder.build();
    }

    public DynamicColor tertiaryContainer() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "tertiary_container";
        dynamicColor$Companion$Builder.palette = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 1);
        dynamicColor$Companion$Builder.tone = new ColorSpec2021$$ExternalSyntheticLambda1(this);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new NetworkFetcher.AnonymousClass2(1, this, ColorSpec2021.class, "highestSurface", "highestSurface(Lcom/materialkolor/scheme/DynamicScheme;)Lcom/materialkolor/dynamiccolor/DynamicColor;", 0, (byte) 23);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda1((byte) 3);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2021$$ExternalSyntheticLambda13(this, (byte) 5);
        return dynamicColor$Companion$Builder.build();
    }

    public DynamicColor tertiaryFixed() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "tertiary_fixed";
        dynamicColor$Companion$Builder.palette = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 11);
        dynamicColor$Companion$Builder.tone = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 12);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new NetworkFetcher.AnonymousClass2(1, this, ColorSpec2021.class, "highestSurface", "highestSurface(Lcom/materialkolor/scheme/DynamicScheme;)Lcom/materialkolor/dynamiccolor/DynamicColor;", 0, (byte) 24);
        dynamicColor$Companion$Builder.contrastCurve = new ColorSpec2021$$ExternalSyntheticLambda10((byte) 13);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2021$$ExternalSyntheticLambda13(this, (byte) 2);
        return dynamicColor$Companion$Builder.build();
    }

    public DynamicColor tertiaryFixedDim() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        dynamicColor$Companion$Builder.name = "tertiary_fixed_dim";
        dynamicColor$Companion$Builder.palette = new RoomDatabase$$ExternalSyntheticLambda2((byte) 27);
        dynamicColor$Companion$Builder.tone = new RoomDatabase$$ExternalSyntheticLambda2((byte) 28);
        dynamicColor$Companion$Builder.isBackground = true;
        dynamicColor$Companion$Builder.background = new NetworkFetcher.AnonymousClass2(1, this, ColorSpec2021.class, "highestSurface", "highestSurface(Lcom/materialkolor/scheme/DynamicScheme;)Lcom/materialkolor/dynamiccolor/DynamicColor;", 0, (byte) 25);
        dynamicColor$Companion$Builder.contrastCurve = new RoomDatabase$$ExternalSyntheticLambda2((byte) 29);
        dynamicColor$Companion$Builder.toneDeltaPair = new ColorSpec2021$$ExternalSyntheticLambda13(this, (byte) 1);
        return dynamicColor$Companion$Builder.build();
    }
}
