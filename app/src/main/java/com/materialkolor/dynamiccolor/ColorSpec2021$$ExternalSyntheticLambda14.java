package com.materialkolor.dynamiccolor;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.materialkolor.scheme.DynamicScheme;
import com.materialkolor.scheme.Variant;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ColorSpec2021$$ExternalSyntheticLambda14 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ColorSpec2021$$ExternalSyntheticLambda14(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        double d;
        double d2;
        double d3;
        double d4;
        byte b = this.$r8$classId;
        double dForegroundTone = 0.0d;
        double d5 = 90.0d;
        Variant variant = Variant.MONOCHROME;
        ColorSpec2025 colorSpec2025 = MaterialDynamicColors.colorSpec;
        DynamicScheme dynamicScheme = (DynamicScheme) obj;
        switch (b) {
            case 0:
                dynamicScheme.getClass();
                return dynamicScheme.secondaryPalette;
            case 1:
                dynamicScheme.getClass();
                return new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d);
            case 2:
                dynamicScheme.getClass();
                return dynamicScheme.tertiaryPalette;
            case 3:
                dynamicScheme.getClass();
                boolean z = dynamicScheme.isDark;
                if (dynamicScheme.variant == variant) {
                    if (!z) {
                        dForegroundTone = 100.0d;
                    }
                } else if (ColorSpec2021.isFidelity(dynamicScheme)) {
                    dForegroundTone = ColorSpecs.foregroundTone(((Number) colorSpec2025.tertiaryContainer().tone.invoke(dynamicScheme)).doubleValue(), 4.5d);
                } else {
                    dForegroundTone = z ? 90.0d : 30.0d;
                }
                return Double.valueOf(dForegroundTone);
            case 4:
                dynamicScheme.getClass();
                return colorSpec2025.tertiaryContainer();
            case 5:
                dynamicScheme.getClass();
                return new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d);
            case 6:
                dynamicScheme.getClass();
                return dynamicScheme.errorPalette;
            case 7:
                dynamicScheme.getClass();
                Variant variant2 = dynamicScheme.variant;
                boolean z2 = dynamicScheme.isDark;
                if (variant2 == variant) {
                    if (!z2) {
                        d5 = 10.0d;
                    }
                } else if (!z2) {
                    d5 = 30.0d;
                }
                return Double.valueOf(d5);
            case 8:
                dynamicScheme.getClass();
                return colorSpec2025.errorContainer();
            case 9:
                dynamicScheme.getClass();
                return new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d);
            case 10:
                dynamicScheme.getClass();
                return dynamicScheme.neutralPalette;
            case 11:
                dynamicScheme.getClass();
                if (dynamicScheme.isDark) {
                    double d6 = dynamicScheme.contrastLevel;
                    d = 24.0d;
                    if (d6 > -1.0d) {
                        if (d6 < 0.0d) {
                            d2 = (d6 - (-1.0d)) / 1.0d;
                            d3 = (1.0d - d2) * 24.0d;
                        } else if (d6 < 0.5d) {
                            double d7 = (d6 - 0.0d) / 0.5d;
                            d3 = (1.0d - d7) * 24.0d;
                            d4 = d7 * 29.0d;
                            d = d4 + d3;
                        } else {
                            d = 34.0d;
                            if (d6 < 1.0d) {
                                d2 = (d6 - 0.5d) / 0.5d;
                                d3 = (1.0d - d2) * 29.0d;
                            }
                        }
                        d4 = d2 * d;
                        d = d4 + d3;
                    }
                } else {
                    d = 98.0d;
                }
                return Double.valueOf(d);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                dynamicScheme.getClass();
                return dynamicScheme.tertiaryPalette;
            case 13:
                dynamicScheme.getClass();
                return Double.valueOf(dynamicScheme.variant == variant ? 100.0d : 10.0d);
            case 14:
                dynamicScheme.getClass();
                return colorSpec2025.tertiaryFixedDim();
            case 15:
                dynamicScheme.getClass();
                return colorSpec2025.tertiaryFixed();
            case 16:
                dynamicScheme.getClass();
                return new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d);
            case 17:
                dynamicScheme.getClass();
                return dynamicScheme.tertiaryPalette;
            case 18:
                dynamicScheme.getClass();
                Variant variant3 = dynamicScheme.variant;
                boolean z3 = dynamicScheme.isDark;
                if (variant3 != variant) {
                    d5 = z3 ? 20.0d : 100.0d;
                } else if (z3) {
                    d5 = 10.0d;
                }
                return Double.valueOf(d5);
            case 19:
                dynamicScheme.getClass();
                return colorSpec2025.tertiary();
            case 20:
                dynamicScheme.getClass();
                return new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d);
            case 21:
                dynamicScheme.getClass();
                return dynamicScheme.neutralVariantPalette;
            case 22:
                dynamicScheme.getClass();
                return Double.valueOf(dynamicScheme.isDark ? 80.0d : 30.0d);
            case 23:
                dynamicScheme.getClass();
                return new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d);
            case 24:
                dynamicScheme.getClass();
                return dynamicScheme.primaryPalette;
            case 25:
                dynamicScheme.getClass();
                return Double.valueOf(dynamicScheme.isDark ? 80.0d : 40.0d);
            case 26:
                dynamicScheme.getClass();
                return Double.valueOf(dynamicScheme.variant == variant ? 100.0d : 10.0d);
            case 27:
                dynamicScheme.getClass();
                return colorSpec2025.primaryFixedDim();
            case 28:
                dynamicScheme.getClass();
                return colorSpec2025.primaryFixed();
            default:
                dynamicScheme.getClass();
                return new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d);
        }
    }
}
