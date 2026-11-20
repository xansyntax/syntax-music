package com.materialkolor.dynamiccolor;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.materialkolor.scheme.DynamicScheme;
import com.materialkolor.scheme.Variant;
import kotlin.jvm.functions.Function1;
import kotlin.text.RegexKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ColorSpec2021$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ColorSpec2021$$ExternalSyntheticLambda1(ColorSpec2021 colorSpec2021) {
        this.$r8$classId = (byte) 2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        double d;
        double d2;
        double d3;
        double d4;
        byte b = this.$r8$classId;
        double d5 = 30.0d;
        double d6 = 100.0d;
        double d7 = 40.0d;
        Variant variant = Variant.MONOCHROME;
        double d8 = 6.0d;
        ColorSpec2025 colorSpec2025 = MaterialDynamicColors.colorSpec;
        switch (b) {
            case 0:
                ((DynamicScheme) obj).getClass();
                return Double.valueOf(0.0d);
            case 1:
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                dynamicScheme.getClass();
                return dynamicScheme.tertiaryPalette;
            case 2:
                DynamicScheme dynamicScheme2 = (DynamicScheme) obj;
                dynamicScheme2.getClass();
                boolean z = dynamicScheme2.isDark;
                if (dynamicScheme2.variant == variant) {
                    d5 = z ? 60.0d : 49.0d;
                } else if (ColorSpec2021.isFidelity(dynamicScheme2)) {
                    d5 = RegexKt.fixIfDisliked(dynamicScheme2.tertiaryPalette.getHct(dynamicScheme2.sourceColorHct.tone)).tone;
                } else if (!z) {
                    d5 = 90.0d;
                }
                return Double.valueOf(d5);
            case 3:
                ((DynamicScheme) obj).getClass();
                return new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d);
            case 4:
                ((DynamicScheme) obj).getClass();
                return new ContrastCurve(3.0d, 4.5d, 7.0d, 7.0d);
            case 5:
                DynamicScheme dynamicScheme3 = (DynamicScheme) obj;
                dynamicScheme3.getClass();
                return dynamicScheme3.neutralVariantPalette;
            case 6:
                DynamicScheme dynamicScheme4 = (DynamicScheme) obj;
                dynamicScheme4.getClass();
                return Double.valueOf(dynamicScheme4.isDark ? 30.0d : 80.0d);
            case 7:
                ((DynamicScheme) obj).getClass();
                return new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d);
            case 8:
                DynamicScheme dynamicScheme5 = (DynamicScheme) obj;
                dynamicScheme5.getClass();
                return dynamicScheme5.neutralPalette;
            case 9:
                DynamicScheme dynamicScheme6 = (DynamicScheme) obj;
                dynamicScheme6.getClass();
                if (dynamicScheme6.isDark) {
                    double d9 = dynamicScheme6.contrastLevel;
                    d6 = 4.0d;
                    if (d9 > -1.0d) {
                        if (d9 < 0.0d) {
                            double d10 = (d9 - (-1.0d)) / 1.0d;
                            d = (1.0d - d10) * 4.0d;
                            d2 = d10 * 4.0d;
                        } else if (d9 < 0.5d) {
                            double d11 = (d9 - 0.0d) / 0.5d;
                            d = (1.0d - d11) * 4.0d;
                            d2 = d11 * 2.0d;
                        } else if (d9 < 1.0d) {
                            double d12 = (d9 - 0.5d) / 0.5d;
                            d = (1.0d - d12) * 2.0d;
                            d2 = d12 * 0.0d;
                        } else {
                            d6 = 0.0d;
                        }
                        d6 = d2 + d;
                    }
                }
                return Double.valueOf(d6);
            case 10:
                DynamicScheme dynamicScheme7 = (DynamicScheme) obj;
                dynamicScheme7.getClass();
                return dynamicScheme7.neutralPalette;
            case 11:
                DynamicScheme dynamicScheme8 = (DynamicScheme) obj;
                dynamicScheme8.getClass();
                if (!dynamicScheme8.isDark) {
                    double d13 = dynamicScheme8.contrastLevel;
                    if (d13 <= -1.0d) {
                        d8 = 87.0d;
                    } else {
                        if (d13 < 0.0d) {
                            double d14 = (d13 - (-1.0d)) / 1.0d;
                            d3 = (1.0d - d14) * 87.0d;
                            d4 = d14 * 87.0d;
                        } else if (d13 < 0.5d) {
                            double d15 = (d13 - 0.0d) / 0.5d;
                            d3 = (1.0d - d15) * 87.0d;
                            d4 = d15 * 80.0d;
                        } else if (d13 < 1.0d) {
                            double d16 = (d13 - 0.5d) / 0.5d;
                            d3 = (1.0d - d16) * 80.0d;
                            d4 = d16 * 75.0d;
                        } else {
                            d8 = 75.0d;
                        }
                        d8 = d4 + d3;
                    }
                }
                return Double.valueOf(d8);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                DynamicScheme dynamicScheme9 = (DynamicScheme) obj;
                dynamicScheme9.getClass();
                return dynamicScheme9.errorPalette;
            case 13:
                DynamicScheme dynamicScheme10 = (DynamicScheme) obj;
                dynamicScheme10.getClass();
                return Double.valueOf(dynamicScheme10.isDark ? 80.0d : 40.0d);
            case 14:
                ((DynamicScheme) obj).getClass();
                return new ContrastCurve(3.0d, 4.5d, 7.0d, 7.0d);
            case 15:
                DynamicScheme dynamicScheme11 = (DynamicScheme) obj;
                dynamicScheme11.getClass();
                return dynamicScheme11.secondaryPalette;
            case 16:
                DynamicScheme dynamicScheme12 = (DynamicScheme) obj;
                dynamicScheme12.getClass();
                return dynamicScheme12.neutralPalette;
            case 17:
                ((DynamicScheme) obj).getClass();
                return Double.valueOf(10.0d);
            case 18:
                ((DynamicScheme) obj).getClass();
                return colorSpec2025.secondaryFixedDim();
            case 19:
                ((DynamicScheme) obj).getClass();
                return colorSpec2025.secondaryFixed();
            case 20:
                ((DynamicScheme) obj).getClass();
                return new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d);
            case 21:
                DynamicScheme dynamicScheme13 = (DynamicScheme) obj;
                dynamicScheme13.getClass();
                return dynamicScheme13.errorPalette;
            case 22:
                DynamicScheme dynamicScheme14 = (DynamicScheme) obj;
                dynamicScheme14.getClass();
                return Double.valueOf(dynamicScheme14.isDark ? 20.0d : 100.0d);
            case 23:
                ((DynamicScheme) obj).getClass();
                return colorSpec2025.error();
            case 24:
                ((DynamicScheme) obj).getClass();
                return new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d);
            case 25:
                DynamicScheme dynamicScheme15 = (DynamicScheme) obj;
                dynamicScheme15.getClass();
                return dynamicScheme15.tertiaryPalette;
            case 26:
                DynamicScheme dynamicScheme16 = (DynamicScheme) obj;
                dynamicScheme16.getClass();
                Variant variant2 = dynamicScheme16.variant;
                boolean z2 = dynamicScheme16.isDark;
                if (variant2 == variant) {
                    d7 = z2 ? 90.0d : 25.0d;
                } else if (z2) {
                    d7 = 80.0d;
                }
                return Double.valueOf(d7);
            case 27:
                DynamicScheme dynamicScheme17 = (DynamicScheme) obj;
                dynamicScheme17.getClass();
                return Double.valueOf(dynamicScheme17.isDark ? 6.0d : 98.0d);
            case 28:
                ((DynamicScheme) obj).getClass();
                return new ContrastCurve(3.0d, 4.5d, 7.0d, 7.0d);
            default:
                DynamicScheme dynamicScheme18 = (DynamicScheme) obj;
                dynamicScheme18.getClass();
                return dynamicScheme18.errorPalette;
        }
    }

    public /* synthetic */ ColorSpec2021$$ExternalSyntheticLambda1(byte b) {
        this.$r8$classId = b;
    }
}
