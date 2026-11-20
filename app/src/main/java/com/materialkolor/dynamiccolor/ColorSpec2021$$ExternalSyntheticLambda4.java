package com.materialkolor.dynamiccolor;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.materialkolor.scheme.DynamicScheme;
import com.materialkolor.scheme.Variant;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ColorSpec2021$$ExternalSyntheticLambda4 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ColorSpec2021$$ExternalSyntheticLambda4(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        double d11;
        byte b = this.$r8$classId;
        double dForegroundTone = 100.0d;
        double d12 = 92.0d;
        Variant variant = Variant.MONOCHROME;
        double d13 = 20.0d;
        ColorSpec2025 colorSpec2025 = MaterialDynamicColors.colorSpec;
        double d14 = 90.0d;
        switch (b) {
            case 0:
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                dynamicScheme.getClass();
                return dynamicScheme.neutralVariantPalette;
            case 1:
                DynamicScheme dynamicScheme2 = (DynamicScheme) obj;
                dynamicScheme2.getClass();
                return Double.valueOf(dynamicScheme2.isDark ? 30.0d : 90.0d);
            case 2:
                ((DynamicScheme) obj).getClass();
                return new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d);
            case 3:
                DynamicScheme dynamicScheme3 = (DynamicScheme) obj;
                dynamicScheme3.getClass();
                return dynamicScheme3.neutralPalette;
            case 4:
                DynamicScheme dynamicScheme4 = (DynamicScheme) obj;
                dynamicScheme4.getClass();
                return Double.valueOf(dynamicScheme4.isDark ? 90.0d : 10.0d);
            case 5:
                ((DynamicScheme) obj).getClass();
                return colorSpec2025.background();
            case 6:
                ((DynamicScheme) obj).getClass();
                return new ContrastCurve(3.0d, 3.0d, 4.5d, 7.0d);
            case 7:
                DynamicScheme dynamicScheme5 = (DynamicScheme) obj;
                dynamicScheme5.getClass();
                return dynamicScheme5.primaryPalette;
            case 8:
                DynamicScheme dynamicScheme6 = (DynamicScheme) obj;
                dynamicScheme6.getClass();
                if (ColorSpec2021.isFidelity(dynamicScheme6)) {
                    dForegroundTone = ColorSpecs.foregroundTone(((Number) colorSpec2025.primaryContainer().tone.invoke(dynamicScheme6)).doubleValue(), 4.5d);
                } else {
                    Variant variant2 = dynamicScheme6.variant;
                    boolean z = dynamicScheme6.isDark;
                    if (variant2 != variant) {
                        dForegroundTone = z ? 90.0d : 30.0d;
                    } else if (z) {
                        dForegroundTone = 0.0d;
                    }
                }
                return Double.valueOf(dForegroundTone);
            case 9:
                ((DynamicScheme) obj).getClass();
                return colorSpec2025.primaryContainer();
            case 10:
                ((DynamicScheme) obj).getClass();
                return new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d);
            case 11:
                DynamicScheme dynamicScheme7 = (DynamicScheme) obj;
                dynamicScheme7.getClass();
                return dynamicScheme7.neutralPalette;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                DynamicScheme dynamicScheme8 = (DynamicScheme) obj;
                dynamicScheme8.getClass();
                double d15 = dynamicScheme8.contrastLevel;
                if (dynamicScheme8.isDark) {
                    d = 17.0d;
                    if (d15 > -1.0d) {
                        if (d15 < 0.0d) {
                            d5 = (d15 - (-1.0d)) / 1.0d;
                            d6 = (1.0d - d5) * 17.0d;
                        } else if (d15 < 0.5d) {
                            double d16 = (d15 - 0.0d) / 0.5d;
                            d6 = (1.0d - d16) * 17.0d;
                            d7 = d16 * 21.0d;
                            d = d7 + d6;
                        } else {
                            d = 25.0d;
                            if (d15 < 1.0d) {
                                d5 = (d15 - 0.5d) / 0.5d;
                                d6 = (1.0d - d5) * 21.0d;
                            }
                        }
                        d7 = d5 * d;
                        d = d7 + d6;
                    }
                } else {
                    if (d15 > -1.0d) {
                        if (d15 < 0.0d) {
                            d2 = (d15 - (-1.0d)) / 1.0d;
                            d3 = (1.0d - d2) * 92.0d;
                        } else if (d15 < 0.5d) {
                            double d17 = (d15 - 0.0d) / 0.5d;
                            d3 = (1.0d - d17) * 92.0d;
                            d4 = d17 * 88.0d;
                            d12 = d4 + d3;
                        } else {
                            d12 = 85.0d;
                            if (d15 < 1.0d) {
                                d2 = (d15 - 0.5d) / 0.5d;
                                d3 = (1.0d - d2) * 88.0d;
                            }
                        }
                        d4 = d2 * d12;
                        d12 = d4 + d3;
                    }
                    d = d12;
                }
                return Double.valueOf(d);
            case 13:
                DynamicScheme dynamicScheme9 = (DynamicScheme) obj;
                dynamicScheme9.getClass();
                return dynamicScheme9.neutralPalette;
            case 14:
                DynamicScheme dynamicScheme10 = (DynamicScheme) obj;
                dynamicScheme10.getClass();
                return Double.valueOf(dynamicScheme10.isDark ? 20.0d : 95.0d);
            case 15:
                ((DynamicScheme) obj).getClass();
                return colorSpec2025.inverseSurface();
            case 16:
                ((DynamicScheme) obj).getClass();
                return new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d);
            case 17:
                DynamicScheme dynamicScheme11 = (DynamicScheme) obj;
                dynamicScheme11.getClass();
                return Double.valueOf(dynamicScheme11.isDark ? 30.0d : 90.0d);
            case 18:
                DynamicScheme dynamicScheme12 = (DynamicScheme) obj;
                dynamicScheme12.getClass();
                return dynamicScheme12.secondaryPalette;
            case 19:
                DynamicScheme dynamicScheme13 = (DynamicScheme) obj;
                dynamicScheme13.getClass();
                return Double.valueOf(dynamicScheme13.variant == variant ? 80.0d : 90.0d);
            case 20:
                ((DynamicScheme) obj).getClass();
                return new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d);
            case 21:
                DynamicScheme dynamicScheme14 = (DynamicScheme) obj;
                dynamicScheme14.getClass();
                return dynamicScheme14.primaryPalette;
            case 22:
                DynamicScheme dynamicScheme15 = (DynamicScheme) obj;
                dynamicScheme15.getClass();
                Variant variant3 = dynamicScheme15.variant;
                boolean z2 = dynamicScheme15.isDark;
                if (variant3 == variant) {
                    dForegroundTone = z2 ? 10.0d : 90.0d;
                } else if (z2) {
                    dForegroundTone = 20.0d;
                }
                return Double.valueOf(dForegroundTone);
            case 23:
                ((DynamicScheme) obj).getClass();
                return colorSpec2025.primary();
            case 24:
                ((DynamicScheme) obj).getClass();
                return new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d);
            case 25:
                DynamicScheme dynamicScheme16 = (DynamicScheme) obj;
                dynamicScheme16.getClass();
                return dynamicScheme16.neutralPalette;
            case 26:
                DynamicScheme dynamicScheme17 = (DynamicScheme) obj;
                dynamicScheme17.getClass();
                double d18 = dynamicScheme17.contrastLevel;
                if (!dynamicScheme17.isDark) {
                    if (d18 <= -1.0d) {
                        d14 = 94.0d;
                    } else {
                        if (d18 < 0.0d) {
                            double d19 = (d18 - (-1.0d)) / 1.0d;
                            d8 = (1.0d - d19) * 94.0d;
                            d9 = d19 * 94.0d;
                        } else if (d18 < 0.5d) {
                            double d20 = (d18 - 0.0d) / 0.5d;
                            d8 = (1.0d - d20) * 94.0d;
                            d9 = d20 * 92.0d;
                        } else if (d18 < 1.0d) {
                            double d21 = (d18 - 0.5d) / 0.5d;
                            d8 = (1.0d - d21) * 92.0d;
                            d9 = d21 * 90.0d;
                        }
                        d14 = d9 + d8;
                    }
                    d13 = d14;
                } else if (d18 <= -1.0d) {
                    d13 = 12.0d;
                } else {
                    if (d18 < 0.0d) {
                        double d22 = (d18 - (-1.0d)) / 1.0d;
                        d10 = (1.0d - d22) * 12.0d;
                        d11 = d22 * 12.0d;
                    } else if (d18 < 0.5d) {
                        double d23 = (d18 - 0.0d) / 0.5d;
                        d10 = (1.0d - d23) * 12.0d;
                        d11 = d23 * 16.0d;
                    } else if (d18 < 1.0d) {
                        double d24 = (d18 - 0.5d) / 0.5d;
                        d10 = (1.0d - d24) * 16.0d;
                        d11 = d24 * 20.0d;
                    }
                    d13 = d11 + d10;
                }
                return Double.valueOf(d13);
            case 27:
                DynamicScheme dynamicScheme18 = (DynamicScheme) obj;
                dynamicScheme18.getClass();
                return dynamicScheme18.primaryPalette;
            case 28:
                DynamicScheme dynamicScheme19 = (DynamicScheme) obj;
                dynamicScheme19.getClass();
                return dynamicScheme19.neutralVariantPalette;
            default:
                DynamicScheme dynamicScheme20 = (DynamicScheme) obj;
                dynamicScheme20.getClass();
                return Double.valueOf(dynamicScheme20.isDark ? 60.0d : 50.0d);
        }
    }
}
