package com.materialkolor.dynamiccolor;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.materialkolor.hct.Hct;
import com.materialkolor.hct.HctSolver;
import com.materialkolor.palettes.TonalPalette;
import com.materialkolor.scheme.DynamicScheme;
import com.materialkolor.scheme.Variant;
import kotlin.jvm.functions.Function1;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ColorSpec2021$$ExternalSyntheticLambda7 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ColorSpec2021$$ExternalSyntheticLambda7(ColorSpec2021 colorSpec2021) {
        this.$r8$classId = (byte) 24;
    }

    /* JADX WARN: Code duplicated, block: B:127:0x0257  */
    /* JADX WARN: Code duplicated, block: B:52:0x0100  */
    /* JADX WARN: Code duplicated, block: B:99:0x01c9  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        double d;
        double d2;
        double d3;
        double d4;
        byte b = this.$r8$classId;
        double dForegroundTone = 10.0d;
        ColorSpec2025 colorSpec2025 = MaterialDynamicColors.colorSpec;
        double d5 = 30.0d;
        double d6 = 90.0d;
        Variant variant = Variant.MONOCHROME;
        switch (b) {
            case 0:
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                dynamicScheme.getClass();
                return Double.valueOf(dynamicScheme.isDark ? 80.0d : 40.0d);
            case 1:
                ((DynamicScheme) obj).getClass();
                return new ContrastCurve(1.5d, 3.0d, 4.5d, 7.0d);
            case 2:
                DynamicScheme dynamicScheme2 = (DynamicScheme) obj;
                dynamicScheme2.getClass();
                return dynamicScheme2.primaryPalette;
            case 3:
                DynamicScheme dynamicScheme3 = (DynamicScheme) obj;
                dynamicScheme3.getClass();
                return Double.valueOf(dynamicScheme3.variant != variant ? 80.0d : 30.0d);
            case 4:
                ((DynamicScheme) obj).getClass();
                return new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d);
            case 5:
                DynamicScheme dynamicScheme4 = (DynamicScheme) obj;
                dynamicScheme4.getClass();
                return dynamicScheme4.secondaryPalette;
            case 6:
                DynamicScheme dynamicScheme5 = (DynamicScheme) obj;
                dynamicScheme5.getClass();
                return Double.valueOf(dynamicScheme5.variant == variant ? 70.0d : 80.0d);
            case 7:
                ((DynamicScheme) obj).getClass();
                return new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d);
            case 8:
                DynamicScheme dynamicScheme6 = (DynamicScheme) obj;
                dynamicScheme6.getClass();
                return dynamicScheme6.secondaryPalette;
            case 9:
                DynamicScheme dynamicScheme7 = (DynamicScheme) obj;
                dynamicScheme7.getClass();
                boolean z = dynamicScheme7.isDark;
                if (dynamicScheme7.variant == variant) {
                    if (z) {
                        dForegroundTone = 90.0d;
                    }
                } else if (ColorSpec2021.isFidelity(dynamicScheme7)) {
                    dForegroundTone = ColorSpecs.foregroundTone(((Number) colorSpec2025.secondaryContainer().tone.invoke(dynamicScheme7)).doubleValue(), 4.5d);
                } else if (z) {
                    dForegroundTone = 90.0d;
                } else {
                    dForegroundTone = 30.0d;
                }
                return Double.valueOf(dForegroundTone);
            case 10:
                ((DynamicScheme) obj).getClass();
                return colorSpec2025.secondaryContainer();
            case 11:
                ((DynamicScheme) obj).getClass();
                return new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                DynamicScheme dynamicScheme8 = (DynamicScheme) obj;
                dynamicScheme8.getClass();
                return dynamicScheme8.primaryPalette;
            case 13:
                DynamicScheme dynamicScheme9 = (DynamicScheme) obj;
                dynamicScheme9.getClass();
                return Double.valueOf(dynamicScheme9.isDark ? 40.0d : 80.0d);
            case 14:
                ((DynamicScheme) obj).getClass();
                return colorSpec2025.inverseSurface();
            case 15:
                ((DynamicScheme) obj).getClass();
                return new ContrastCurve(3.0d, 4.5d, 7.0d, 7.0d);
            case 16:
                DynamicScheme dynamicScheme10 = (DynamicScheme) obj;
                dynamicScheme10.getClass();
                return dynamicScheme10.secondaryPalette;
            case 17:
                DynamicScheme dynamicScheme11 = (DynamicScheme) obj;
                dynamicScheme11.getClass();
                return dynamicScheme11.neutralPalette;
            case 18:
                DynamicScheme dynamicScheme12 = (DynamicScheme) obj;
                dynamicScheme12.getClass();
                Variant variant2 = dynamicScheme12.variant;
                boolean z2 = dynamicScheme12.isDark;
                if (variant2 == variant) {
                    if (!z2) {
                        dForegroundTone = 100.0d;
                    }
                } else if (z2) {
                    dForegroundTone = 20.0d;
                } else {
                    dForegroundTone = 100.0d;
                }
                return Double.valueOf(dForegroundTone);
            case 19:
                ((DynamicScheme) obj).getClass();
                return colorSpec2025.secondary();
            case 20:
                ((DynamicScheme) obj).getClass();
                return new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d);
            case 21:
                DynamicScheme dynamicScheme13 = (DynamicScheme) obj;
                dynamicScheme13.getClass();
                return dynamicScheme13.neutralPalette;
            case 22:
                DynamicScheme dynamicScheme14 = (DynamicScheme) obj;
                dynamicScheme14.getClass();
                double d7 = dynamicScheme14.contrastLevel;
                if (!dynamicScheme14.isDark) {
                    if (d7 > -1.0d) {
                        if (d7 < 0.0d) {
                            double d8 = (d7 - (-1.0d)) / 1.0d;
                            d6 = (d8 * 90.0d) + ((1.0d - d8) * 90.0d);
                        } else {
                            if (d7 < 0.5d) {
                                double d9 = (d7 - 0.0d) / 0.5d;
                                d = (1.0d - d9) * 90.0d;
                                d2 = d9 * 84.0d;
                            } else if (d7 < 1.0d) {
                                double d10 = (d7 - 0.5d) / 0.5d;
                                d = (1.0d - d10) * 84.0d;
                                d2 = d10 * 80.0d;
                            } else {
                                d6 = 80.0d;
                            }
                            d6 = d2 + d;
                        }
                    }
                    d5 = d6;
                } else if (d7 <= -1.0d) {
                    d5 = 22.0d;
                } else {
                    if (d7 < 0.0d) {
                        double d11 = (d7 - (-1.0d)) / 1.0d;
                        d3 = (1.0d - d11) * 22.0d;
                        d4 = d11 * 22.0d;
                    } else if (d7 < 0.5d) {
                        double d12 = (d7 - 0.0d) / 0.5d;
                        d3 = (1.0d - d12) * 22.0d;
                        d4 = d12 * 26.0d;
                    } else if (d7 < 1.0d) {
                        double d13 = (d7 - 0.5d) / 0.5d;
                        d5 = (d13 * 30.0d) + ((1.0d - d13) * 26.0d);
                    }
                    d5 = d4 + d3;
                }
                return Double.valueOf(d5);
            case 23:
                DynamicScheme dynamicScheme15 = (DynamicScheme) obj;
                dynamicScheme15.getClass();
                return dynamicScheme15.secondaryPalette;
            case 24:
                DynamicScheme dynamicScheme16 = (DynamicScheme) obj;
                dynamicScheme16.getClass();
                boolean z3 = dynamicScheme16.isDark;
                double d14 = z3 ? 30.0d : 90.0d;
                if (dynamicScheme16.variant == variant) {
                    if (!z3) {
                        d5 = 85.0d;
                    }
                } else if (ColorSpec2021.isFidelity(dynamicScheme16)) {
                    TonalPalette tonalPalette = dynamicScheme16.secondaryPalette;
                    double d15 = tonalPalette.hue;
                    double d16 = tonalPalette.chroma;
                    Hct hct = new Hct(HctSolver.solveToInt(d15, d16, d14));
                    double dMax = hct.chroma;
                    if (dMax < d16) {
                        d5 = d14;
                        while (true) {
                            double d17 = hct.chroma;
                            if (d17 < d16) {
                                double d18 = d5 + (!z3 ? -1.0d : 1.0d);
                                Hct hct2 = new Hct(HctSolver.solveToInt(d15, d16, d18));
                                double d19 = hct2.chroma;
                                if (dMax <= d19) {
                                    double d20 = d19 - d16;
                                    if (Math.abs(d20) >= 0.4d) {
                                        if (Math.abs(d20) < Math.abs(d17 - d16)) {
                                            hct = hct2;
                                        }
                                        dMax = Math.max(dMax, d19);
                                        d5 = d18;
                                    }
                                }
                                d5 = d18;
                            }
                        }
                    } else {
                        d5 = d14;
                    }
                } else {
                    d5 = d14;
                }
                return Double.valueOf(d5);
            case 25:
                ((DynamicScheme) obj).getClass();
                return new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d);
            case 26:
                DynamicScheme dynamicScheme17 = (DynamicScheme) obj;
                dynamicScheme17.getClass();
                return dynamicScheme17.neutralPalette;
            case 27:
                DynamicScheme dynamicScheme18 = (DynamicScheme) obj;
                dynamicScheme18.getClass();
                return Double.valueOf(dynamicScheme18.isDark ? 90.0d : 20.0d);
            case 28:
                DynamicScheme dynamicScheme19 = (DynamicScheme) obj;
                dynamicScheme19.getClass();
                return dynamicScheme19.errorPalette;
            default:
                DynamicScheme dynamicScheme20 = (DynamicScheme) obj;
                dynamicScheme20.getClass();
                if (dynamicScheme20.platform != DynamicScheme.Platform.PHONE || dynamicScheme20.contrastLevel <= 0.0d) {
                    return null;
                }
                return Path.Companion.getContrastCurve(1.5d);
        }
    }

    public /* synthetic */ ColorSpec2021$$ExternalSyntheticLambda7(byte b) {
        this.$r8$classId = b;
    }
}
