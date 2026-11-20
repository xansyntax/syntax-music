package com.materialkolor.dynamiccolor;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.materialkolor.palettes.TonalPalette;
import com.materialkolor.scheme.DynamicScheme;
import com.materialkolor.scheme.Variant;
import kotlin.jvm.functions.Function1;
import kotlin.uuid.UuidKt;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ColorSpec2025$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ColorSpec2025 f$0;

    public /* synthetic */ ColorSpec2025$$ExternalSyntheticLambda2(ColorSpec2025 colorSpec2025, byte b) {
        this.$r8$classId = b;
        this.f$0 = colorSpec2025;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        DynamicColor dynamicColorSurfaceContainerHigh;
        double tone;
        byte b = this.$r8$classId;
        DynamicScheme.Platform platform = DynamicScheme.Platform.PHONE;
        ColorSpec2025 colorSpec2025 = this.f$0;
        DynamicScheme dynamicScheme = (DynamicScheme) obj;
        switch (b) {
            case 0:
                dynamicScheme.getClass();
                if (dynamicScheme.platform == platform) {
                    return dynamicScheme.isDark ? colorSpec2025.surfaceBright() : colorSpec2025.surfaceDim();
                }
                return null;
            case 1:
                dynamicScheme.getClass();
                return Double.valueOf(colorSpec2025.tertiaryFixed().getTone(dynamicScheme));
            case 2:
                dynamicScheme.getClass();
                return new ToneDeltaPair(colorSpec2025.tertiaryFixedDim(), colorSpec2025.tertiaryFixed(), 5.0d, TonePolarity.DARKER, false, ToneDeltaPair.DeltaConstraint.EXACT, 16);
            case 3:
                dynamicScheme.getClass();
                if (dynamicScheme.platform == platform) {
                    return dynamicScheme.isDark ? colorSpec2025.surfaceBright() : colorSpec2025.surfaceDim();
                }
                return colorSpec2025.surfaceContainerHigh();
            case 4:
                dynamicScheme.getClass();
                if (dynamicScheme.platform == platform) {
                    return new ToneDeltaPair(colorSpec2025.tertiaryContainer(), colorSpec2025.tertiary(), 5.0d, TonePolarity.RELATIVE_LIGHTER, false, ToneDeltaPair.DeltaConstraint.FARTHER, 16);
                }
                return null;
            case 5:
                dynamicScheme.getClass();
                return Double.valueOf(colorSpec2025.secondaryFixed().getTone(dynamicScheme));
            case 6:
                dynamicScheme.getClass();
                return new ToneDeltaPair(colorSpec2025.secondaryFixedDim(), colorSpec2025.secondaryFixed(), 5.0d, TonePolarity.DARKER, false, ToneDeltaPair.DeltaConstraint.EXACT, 16);
            case 7:
                dynamicScheme.getClass();
                return Double.valueOf(colorSpec2025.primaryFixed().getTone(dynamicScheme));
            case 8:
                dynamicScheme.getClass();
                return new ToneDeltaPair(colorSpec2025.primaryFixedDim(), colorSpec2025.primaryFixed(), 5.0d, TonePolarity.DARKER, false, ToneDeltaPair.DeltaConstraint.EXACT, 16);
            case 9:
                dynamicScheme.getClass();
                return Double.valueOf(colorSpec2025.secondaryContainer().getTone(new DynamicScheme(dynamicScheme.sourceColorHct, dynamicScheme.variant, false, 0.0d, dynamicScheme.primaryPalette, dynamicScheme.secondaryPalette, dynamicScheme.tertiaryPalette, dynamicScheme.neutralPalette, dynamicScheme.neutralVariantPalette, dynamicScheme.platform, dynamicScheme.specVersion, dynamicScheme.errorPalette)));
            case 10:
                dynamicScheme.getClass();
                if (dynamicScheme.platform == platform) {
                    return dynamicScheme.isDark ? colorSpec2025.surfaceBright() : colorSpec2025.surfaceDim();
                }
                return null;
            case 11:
                dynamicScheme.getClass();
                return colorSpec2025.surfaceContainerHigh();
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                dynamicScheme.getClass();
                return new ToneDeltaPair(colorSpec2025.secondaryDim(), colorSpec2025.secondary(), 5.0d, TonePolarity.DARKER, false, ToneDeltaPair.DeltaConstraint.FARTHER, 16);
            case 13:
                dynamicScheme.getClass();
                return colorSpec2025.surfaceContainerHigh();
            case 14:
                dynamicScheme.getClass();
                return new ToneDeltaPair(colorSpec2025.tertiaryDim(), colorSpec2025.tertiary(), 5.0d, TonePolarity.DARKER, false, ToneDeltaPair.DeltaConstraint.FARTHER, 16);
            case 15:
                dynamicScheme.getClass();
                return colorSpec2025.surfaceContainerHigh();
            case 16:
                dynamicScheme.getClass();
                return new ToneDeltaPair(colorSpec2025.primaryDim(), colorSpec2025.primary(), 5.0d, TonePolarity.DARKER, false, ToneDeltaPair.DeltaConstraint.FARTHER, 16);
            case 17:
                dynamicScheme.getClass();
                return colorSpec2025.surfaceContainerHigh();
            case 18:
                dynamicScheme.getClass();
                return new ToneDeltaPair(colorSpec2025.errorDim(), colorSpec2025.error(), 5.0d, TonePolarity.DARKER, false, ToneDeltaPair.DeltaConstraint.FARTHER, 16);
            case 19:
                dynamicScheme.getClass();
                if (dynamicScheme.platform == platform) {
                    return dynamicScheme.isDark ? colorSpec2025.surfaceBright() : colorSpec2025.surfaceDim();
                }
                return colorSpec2025.surfaceContainerHigh();
            case 20:
                dynamicScheme.getClass();
                if (dynamicScheme.platform == platform) {
                    return new ToneDeltaPair(colorSpec2025.primaryContainer(), colorSpec2025.primary(), 5.0d, TonePolarity.RELATIVE_LIGHTER, false, ToneDeltaPair.DeltaConstraint.FARTHER, 16);
                }
                return null;
            case 21:
                dynamicScheme.getClass();
                if (dynamicScheme.platform == platform) {
                    return dynamicScheme.isDark ? colorSpec2025.surfaceBright() : colorSpec2025.surfaceDim();
                }
                return colorSpec2025.surfaceContainerHigh();
            case 22:
                dynamicScheme.getClass();
                if (dynamicScheme.platform == platform) {
                    return new ToneDeltaPair(colorSpec2025.errorContainer(), colorSpec2025.error(), 5.0d, TonePolarity.RELATIVE_LIGHTER, false, ToneDeltaPair.DeltaConstraint.FARTHER, 16);
                }
                return null;
            case 23:
                dynamicScheme.getClass();
                return Double.valueOf(colorSpec2025.primaryContainer().getTone(new DynamicScheme(dynamicScheme.sourceColorHct, dynamicScheme.variant, false, 0.0d, dynamicScheme.primaryPalette, dynamicScheme.secondaryPalette, dynamicScheme.tertiaryPalette, dynamicScheme.neutralPalette, dynamicScheme.neutralVariantPalette, dynamicScheme.platform, dynamicScheme.specVersion, dynamicScheme.errorPalette)));
            case 24:
                dynamicScheme.getClass();
                if (dynamicScheme.platform == platform) {
                    return dynamicScheme.isDark ? colorSpec2025.surfaceBright() : colorSpec2025.surfaceDim();
                }
                return null;
            case 25:
                dynamicScheme.getClass();
                if (dynamicScheme.variant == Variant.VIBRANT) {
                    TonalPalette tonalPalette = dynamicScheme.neutralPalette;
                    tone = UuidKt.coerceIn(Path.Companion.findBestToneForChroma(tonalPalette.hue, 1.1d * tonalPalette.chroma, 100.0d, true), 0.0d, 100.0d);
                } else {
                    if (dynamicScheme.platform == platform) {
                        dynamicColorSurfaceContainerHigh = dynamicScheme.isDark ? colorSpec2025.surfaceBright() : colorSpec2025.surfaceDim();
                    } else {
                        dynamicColorSurfaceContainerHigh = colorSpec2025.surfaceContainerHigh();
                    }
                    tone = dynamicColorSurfaceContainerHigh.getTone(dynamicScheme);
                }
                return Double.valueOf(tone);
            case 26:
                dynamicScheme.getClass();
                if (dynamicScheme.platform == platform) {
                    return dynamicScheme.isDark ? colorSpec2025.surfaceBright() : colorSpec2025.surfaceDim();
                }
                return colorSpec2025.surfaceContainerHigh();
            case 27:
                dynamicScheme.getClass();
                if (dynamicScheme.platform == DynamicScheme.Platform.WATCH) {
                    return new ToneDeltaPair(colorSpec2025.errorContainer(), colorSpec2025.errorDim(), 10.0d, TonePolarity.DARKER, false, ToneDeltaPair.DeltaConstraint.FARTHER, 16);
                }
                return null;
            case 28:
                dynamicScheme.getClass();
                return Double.valueOf(colorSpec2025.tertiaryContainer().getTone(new DynamicScheme(dynamicScheme.sourceColorHct, dynamicScheme.variant, false, 0.0d, dynamicScheme.primaryPalette, dynamicScheme.secondaryPalette, dynamicScheme.tertiaryPalette, dynamicScheme.neutralPalette, dynamicScheme.neutralVariantPalette, dynamicScheme.platform, dynamicScheme.specVersion, dynamicScheme.errorPalette)));
            default:
                dynamicScheme.getClass();
                if (dynamicScheme.platform == platform) {
                    return dynamicScheme.isDark ? colorSpec2025.surfaceBright() : colorSpec2025.surfaceDim();
                }
                return null;
        }
    }
}
