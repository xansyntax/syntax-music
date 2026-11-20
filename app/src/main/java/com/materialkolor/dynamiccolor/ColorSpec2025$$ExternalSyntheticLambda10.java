package com.materialkolor.dynamiccolor;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.materialkolor.palettes.TonalPalette;
import com.materialkolor.scheme.DynamicScheme;
import com.materialkolor.scheme.Variant;
import kotlin.jvm.functions.Function1;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ColorSpec2025$$ExternalSyntheticLambda10 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ColorSpec2025$$ExternalSyntheticLambda10(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i;
        double dTMaxC$default;
        byte b = this.$r8$classId;
        Variant variant = Variant.EXPRESSIVE;
        Variant variant2 = Variant.TONAL_SPOT;
        DynamicScheme.Platform platform = DynamicScheme.Platform.WATCH;
        ColorSpec2025 colorSpec2025 = MaterialDynamicColors.colorSpec;
        DynamicScheme.Platform platform2 = DynamicScheme.Platform.PHONE;
        DynamicScheme dynamicScheme = (DynamicScheme) obj;
        switch (b) {
            case 0:
                dynamicScheme.getClass();
                return dynamicScheme.tertiaryPalette;
            case 1:
                dynamicScheme.getClass();
                return dynamicScheme.tertiaryPalette;
            case 2:
                dynamicScheme.getClass();
                return dynamicScheme.platform == platform2 ? colorSpec2025.tertiary() : colorSpec2025.tertiaryDim();
            case 3:
                dynamicScheme.getClass();
                return dynamicScheme.platform == platform2 ? Path.Companion.getContrastCurve(6.0d) : Path.Companion.getContrastCurve(7.0d);
            case 4:
                dynamicScheme.getClass();
                return dynamicScheme.primaryPalette;
            case 5:
                dynamicScheme.getClass();
                return colorSpec2025.primaryContainer();
            case 6:
                dynamicScheme.getClass();
                return dynamicScheme.platform == platform2 ? Path.Companion.getContrastCurve(6.0d) : Path.Companion.getContrastCurve(7.0d);
            case 7:
                dynamicScheme.getClass();
                return dynamicScheme.primaryPalette;
            case 8:
                dynamicScheme.getClass();
                return colorSpec2025.primaryFixedDim();
            case 9:
                dynamicScheme.getClass();
                return Path.Companion.getContrastCurve(4.5d);
            case 10:
                dynamicScheme.getClass();
                return dynamicScheme.neutralPalette;
            case 11:
                dynamicScheme.getClass();
                double d = 1.0d;
                if (dynamicScheme.platform != platform2) {
                    return Double.valueOf(1.0d);
                }
                Variant variant3 = dynamicScheme.variant;
                if (variant3 == Variant.NEUTRAL) {
                    d = 2.2d;
                } else if (variant3 == variant2) {
                    d = 1.7d;
                } else if (variant3 == variant) {
                    if (dynamicScheme.neutralPalette.keyColor.isYellow()) {
                        d = dynamicScheme.isDark ? 3.0d : 2.3d;
                    } else {
                        d = 1.6d;
                    }
                }
                return Double.valueOf(d);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                dynamicScheme.getClass();
                if (dynamicScheme.platform == platform2) {
                    return dynamicScheme.isDark ? colorSpec2025.surfaceBright() : colorSpec2025.surfaceDim();
                }
                return colorSpec2025.surfaceContainerHigh();
            case 13:
                dynamicScheme.getClass();
                if (dynamicScheme.platform == platform2) {
                    return dynamicScheme.isDark ? Path.Companion.getContrastCurve(6.0d) : Path.Companion.getContrastCurve(4.5d);
                }
                return Path.Companion.getContrastCurve(7.0d);
            case 14:
                dynamicScheme.getClass();
                return dynamicScheme.tertiaryPalette;
            case 15:
                dynamicScheme.getClass();
                return dynamicScheme.primaryPalette;
            case 16:
                dynamicScheme.getClass();
                return dynamicScheme.platform == platform2 ? colorSpec2025.primary() : colorSpec2025.primaryDim();
            case 17:
                dynamicScheme.getClass();
                return dynamicScheme.platform == platform2 ? Path.Companion.getContrastCurve(6.0d) : Path.Companion.getContrastCurve(7.0d);
            case 18:
                dynamicScheme.getClass();
                return colorSpec2025.tertiaryFixedDim();
            case 19:
                dynamicScheme.getClass();
                return Double.valueOf(dynamicScheme.platform == platform ? 100.0d : colorSpec2025.onSurface().getTone(dynamicScheme));
            case 20:
                dynamicScheme.getClass();
                return dynamicScheme.tertiaryPalette;
            case 21:
                dynamicScheme.getClass();
                TonalPalette tonalPalette = dynamicScheme.tertiaryPalette;
                boolean z = dynamicScheme.isDark;
                DynamicScheme.Platform platform3 = dynamicScheme.platform;
                Variant variant4 = dynamicScheme.variant;
                if (platform3 == platform) {
                    dTMaxC$default = variant4 == variant2 ? Path.Companion.tMaxC$default(tonalPalette, 0.0d, 90.0d) : Path.Companion.tMaxC(tonalPalette);
                } else if (variant4 == variant || variant4 == Variant.VIBRANT) {
                    if (tonalPalette.keyColor.isCyan()) {
                        i = 88;
                    } else {
                        i = z ? 98 : 100;
                    }
                    dTMaxC$default = Path.Companion.tMaxC$default(tonalPalette, 0.0d, i);
                } else {
                    dTMaxC$default = z ? Path.Companion.tMaxC$default(tonalPalette, 0.0d, 98.0d) : Path.Companion.tMaxC(tonalPalette);
                }
                return Double.valueOf(dTMaxC$default);
            case 22:
                dynamicScheme.getClass();
                return dynamicScheme.platform == platform2 ? Path.Companion.getContrastCurve(4.5d) : Path.Companion.getContrastCurve(7.0d);
            case 23:
                dynamicScheme.getClass();
                return dynamicScheme.secondaryPalette;
            case 24:
                dynamicScheme.getClass();
                return dynamicScheme.primaryPalette;
            case 25:
                dynamicScheme.getClass();
                return Path.Companion.getContrastCurve(7.0d);
            case 26:
                dynamicScheme.getClass();
                return dynamicScheme.secondaryPalette;
            case 27:
                dynamicScheme.getClass();
                if (dynamicScheme.platform != platform2 || dynamicScheme.contrastLevel <= 0.0d) {
                    return null;
                }
                return Path.Companion.getContrastCurve(1.5d);
            case 28:
                dynamicScheme.getClass();
                return dynamicScheme.errorPalette;
            default:
                dynamicScheme.getClass();
                return dynamicScheme.platform == platform2 ? colorSpec2025.error() : colorSpec2025.errorDim();
        }
    }
}
