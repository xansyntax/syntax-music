package com.materialkolor.dynamiccolor;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.materialkolor.scheme.DynamicScheme;
import com.materialkolor.scheme.Variant;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ColorSpec2021$$ExternalSyntheticLambda10 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ColorSpec2021$$ExternalSyntheticLambda10(ColorSpec2021 colorSpec2021) {
        this.$r8$classId = (byte) 14;
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
        byte b = this.$r8$classId;
        double d8 = 25.0d;
        double d9 = 0.0d;
        ColorSpec2025 colorSpec2025 = MaterialDynamicColors.colorSpec;
        Variant variant = Variant.MONOCHROME;
        DynamicScheme dynamicScheme = (DynamicScheme) obj;
        switch (b) {
            case 0:
                dynamicScheme.getClass();
                return dynamicScheme.primaryPalette;
            case 1:
                dynamicScheme.getClass();
                return dynamicScheme.secondaryPalette;
            case 2:
                dynamicScheme.getClass();
                return Double.valueOf(dynamicScheme.variant != variant ? 30.0d : 25.0d);
            case 3:
                dynamicScheme.getClass();
                return colorSpec2025.secondaryFixedDim();
            case 4:
                dynamicScheme.getClass();
                return colorSpec2025.secondaryFixed();
            case 5:
                dynamicScheme.getClass();
                return new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d);
            case 6:
                dynamicScheme.getClass();
                return dynamicScheme.primaryPalette;
            case 7:
                dynamicScheme.getClass();
                return Double.valueOf(dynamicScheme.variant == variant ? 90.0d : 30.0d);
            case 8:
                dynamicScheme.getClass();
                return colorSpec2025.primaryFixedDim();
            case 9:
                dynamicScheme.getClass();
                return colorSpec2025.primaryFixed();
            case 10:
                dynamicScheme.getClass();
                return new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d);
            case 11:
                dynamicScheme.getClass();
                return dynamicScheme.tertiaryPalette;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                dynamicScheme.getClass();
                return Double.valueOf(dynamicScheme.variant != variant ? 90.0d : 40.0d);
            case 13:
                dynamicScheme.getClass();
                return new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d);
            case 14:
                dynamicScheme.getClass();
                if (ColorSpec2021.isFidelity(dynamicScheme)) {
                    d8 = dynamicScheme.sourceColorHct.tone;
                } else {
                    Variant variant2 = dynamicScheme.variant;
                    boolean z = dynamicScheme.isDark;
                    if (variant2 != variant) {
                        d8 = z ? 30.0d : 90.0d;
                    } else if (z) {
                        d8 = 85.0d;
                    }
                }
                return Double.valueOf(d8);
            case 15:
                dynamicScheme.getClass();
                return dynamicScheme.primaryPalette;
            case 16:
                dynamicScheme.getClass();
                Variant variant3 = dynamicScheme.variant;
                boolean z2 = dynamicScheme.isDark;
                if (variant3 != variant) {
                    d9 = z2 ? 80.0d : 40.0d;
                } else if (z2) {
                    d9 = 100.0d;
                }
                return Double.valueOf(d9);
            case 17:
                dynamicScheme.getClass();
                return new ContrastCurve(3.0d, 4.5d, 7.0d, 7.0d);
            case 18:
                dynamicScheme.getClass();
                return dynamicScheme.neutralPalette;
            case 19:
                dynamicScheme.getClass();
                double d10 = dynamicScheme.contrastLevel;
                if (dynamicScheme.isDark) {
                    d = 10.0d;
                    if (d10 > -1.0d) {
                        if (d10 < 0.0d) {
                            d5 = (d10 - (-1.0d)) / 1.0d;
                            d6 = (1.0d - d5) * 10.0d;
                        } else if (d10 < 0.5d) {
                            double d11 = (d10 - 0.0d) / 0.5d;
                            d6 = (1.0d - d11) * 10.0d;
                            d7 = d11 * 11.0d;
                            d = d7 + d6;
                        } else {
                            d = 12.0d;
                            if (d10 < 1.0d) {
                                d5 = (d10 - 0.5d) / 0.5d;
                                d6 = (1.0d - d5) * 11.0d;
                            }
                        }
                        d7 = d5 * d;
                        d = d7 + d6;
                    }
                } else {
                    d = 96.0d;
                    if (d10 > -1.0d) {
                        if (d10 < 0.0d) {
                            d4 = (d10 - (-1.0d)) / 1.0d;
                        } else if (d10 < 0.5d) {
                            d4 = (d10 - 0.0d) / 0.5d;
                        } else if (d10 < 1.0d) {
                            double d12 = (d10 - 0.5d) / 0.5d;
                            d2 = (1.0d - d12) * 96.0d;
                            d3 = d12 * 95.0d;
                            d = d3 + d2;
                        } else {
                            d = 95.0d;
                        }
                        d2 = (1.0d - d4) * 96.0d;
                        d3 = d4 * 96.0d;
                        d = d3 + d2;
                    }
                }
                return Double.valueOf(d);
            case 20:
                dynamicScheme.getClass();
                return dynamicScheme.neutralPalette;
            case 21:
                dynamicScheme.getClass();
                return Double.valueOf(dynamicScheme.isDark ? 6.0d : 98.0d);
            case 22:
                dynamicScheme.getClass();
                return dynamicScheme.primaryPalette;
            case 23:
                dynamicScheme.getClass();
                return Double.valueOf(dynamicScheme.variant != variant ? 90.0d : 40.0d);
            case 24:
                dynamicScheme.getClass();
                return new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d);
            case 25:
                dynamicScheme.getClass();
                return new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d);
            case 26:
                dynamicScheme.getClass();
                return dynamicScheme.tertiaryPalette;
            case 27:
                dynamicScheme.getClass();
                return Double.valueOf(dynamicScheme.variant == variant ? 90.0d : 30.0d);
            case 28:
                dynamicScheme.getClass();
                return colorSpec2025.tertiaryFixedDim();
            default:
                dynamicScheme.getClass();
                return colorSpec2025.tertiaryFixed();
        }
    }

    public /* synthetic */ ColorSpec2021$$ExternalSyntheticLambda10(byte b) {
        this.$r8$classId = b;
    }
}
