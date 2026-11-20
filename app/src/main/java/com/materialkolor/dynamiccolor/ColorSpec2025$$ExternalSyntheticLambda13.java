package com.materialkolor.dynamiccolor;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.materialkolor.palettes.TonalPalette;
import com.materialkolor.scheme.DynamicScheme;
import com.materialkolor.scheme.Variant;
import kotlin.jvm.functions.Function1;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ColorSpec2025$$ExternalSyntheticLambda13 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ColorSpec2025$$ExternalSyntheticLambda13(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        double d;
        double d2;
        byte b = this.$r8$classId;
        Variant variant = Variant.EXPRESSIVE;
        double dTMaxC$default = 85.0d;
        Variant variant2 = Variant.VIBRANT;
        ColorSpec2025 colorSpec2025 = MaterialDynamicColors.colorSpec;
        Variant variant3 = Variant.TONAL_SPOT;
        Variant variant4 = Variant.NEUTRAL;
        DynamicScheme.Platform platform = DynamicScheme.Platform.PHONE;
        switch (b) {
            case 0:
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                dynamicScheme.getClass();
                return dynamicScheme.secondaryPalette;
            case 1:
                DynamicScheme dynamicScheme2 = (DynamicScheme) obj;
                dynamicScheme2.getClass();
                return dynamicScheme2.platform == platform ? Path.Companion.getContrastCurve(6.0d) : Path.Companion.getContrastCurve(7.0d);
            case 2:
                DynamicScheme dynamicScheme3 = (DynamicScheme) obj;
                dynamicScheme3.getClass();
                return dynamicScheme3.neutralPalette;
            case 3:
                DynamicScheme dynamicScheme4 = (DynamicScheme) obj;
                dynamicScheme4.getClass();
                if (dynamicScheme4.platform != platform) {
                    return Double.valueOf(1.0d);
                }
                Variant variant5 = dynamicScheme4.variant;
                if (variant5 == variant4) {
                    d = 2.2d;
                } else if (variant5 == variant3) {
                    d = 1.7d;
                } else if (variant5 != variant) {
                    d = variant5 == variant2 ? 1.29d : 1.0d;
                } else if (dynamicScheme4.neutralPalette.keyColor.isYellow()) {
                    d = dynamicScheme4.isDark ? 3.0d : 2.3d;
                } else {
                    d = 1.6d;
                }
                return Double.valueOf(d);
            case 4:
                DynamicScheme dynamicScheme5 = (DynamicScheme) obj;
                dynamicScheme5.getClass();
                if (dynamicScheme5.platform == platform) {
                    return dynamicScheme5.isDark ? colorSpec2025.surfaceBright() : colorSpec2025.surfaceDim();
                }
                return colorSpec2025.surfaceContainerHigh();
            case 5:
                DynamicScheme dynamicScheme6 = (DynamicScheme) obj;
                dynamicScheme6.getClass();
                return dynamicScheme6.platform == platform ? Path.Companion.getContrastCurve(1.5d) : Path.Companion.getContrastCurve(3.0d);
            case 6:
                DynamicScheme dynamicScheme7 = (DynamicScheme) obj;
                dynamicScheme7.getClass();
                return dynamicScheme7.neutralPalette;
            case 7:
                DynamicScheme dynamicScheme8 = (DynamicScheme) obj;
                dynamicScheme8.getClass();
                if (dynamicScheme8.isDark) {
                    d2 = 18.0d;
                } else if (dynamicScheme8.neutralPalette.keyColor.isYellow()) {
                    d2 = 99.0d;
                } else {
                    d2 = dynamicScheme8.variant == variant2 ? 97.0d : 98.0d;
                }
                return Double.valueOf(d2);
            case 8:
                DynamicScheme dynamicScheme9 = (DynamicScheme) obj;
                dynamicScheme9.getClass();
                if (dynamicScheme9.isDark) {
                    Variant variant6 = dynamicScheme9.variant;
                    if (variant6 == variant4) {
                        return Double.valueOf(2.5d);
                    }
                    if (variant6 == variant3) {
                        return Double.valueOf(1.7d);
                    }
                    if (variant6 == variant) {
                        return dynamicScheme9.neutralPalette.keyColor.isYellow() ? Double.valueOf(2.7d) : Double.valueOf(1.75d);
                    }
                    if (variant6 == variant2) {
                        return Double.valueOf(1.36d);
                    }
                }
                return Double.valueOf(1.0d);
            case 9:
                DynamicScheme dynamicScheme10 = (DynamicScheme) obj;
                dynamicScheme10.getClass();
                return dynamicScheme10.tertiaryPalette;
            case 10:
                ((DynamicScheme) obj).getClass();
                return colorSpec2025.tertiaryFixedDim();
            case 11:
                ((DynamicScheme) obj).getClass();
                return Path.Companion.getContrastCurve(4.5d);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                DynamicScheme dynamicScheme11 = (DynamicScheme) obj;
                dynamicScheme11.getClass();
                return dynamicScheme11.secondaryPalette;
            case 13:
                DynamicScheme dynamicScheme12 = (DynamicScheme) obj;
                dynamicScheme12.getClass();
                return dynamicScheme12.platform == platform ? colorSpec2025.secondary() : colorSpec2025.secondaryDim();
            case 14:
                ((DynamicScheme) obj).getClass();
                return colorSpec2025.secondaryFixedDim();
            case 15:
                ((DynamicScheme) obj).getClass();
                return Path.Companion.getContrastCurve(7.0d);
            case 16:
                DynamicScheme dynamicScheme13 = (DynamicScheme) obj;
                dynamicScheme13.getClass();
                return dynamicScheme13.secondaryPalette;
            case 17:
                DynamicScheme dynamicScheme14 = (DynamicScheme) obj;
                dynamicScheme14.getClass();
                return Double.valueOf(dynamicScheme14.variant != variant4 ? Path.Companion.tMaxC$default(dynamicScheme14.secondaryPalette, 0.0d, 90.0d) : 85.0d);
            case 18:
                ((DynamicScheme) obj).getClass();
                return Path.Companion.getContrastCurve(4.5d);
            case 19:
                DynamicScheme dynamicScheme15 = (DynamicScheme) obj;
                dynamicScheme15.getClass();
                return dynamicScheme15.tertiaryPalette;
            case 20:
                DynamicScheme dynamicScheme16 = (DynamicScheme) obj;
                dynamicScheme16.getClass();
                Variant variant7 = dynamicScheme16.variant;
                TonalPalette tonalPalette = dynamicScheme16.tertiaryPalette;
                return Double.valueOf(variant7 == variant3 ? Path.Companion.tMaxC$default(tonalPalette, 0.0d, 90.0d) : Path.Companion.tMaxC(tonalPalette));
            case 21:
                DynamicScheme dynamicScheme17 = (DynamicScheme) obj;
                dynamicScheme17.getClass();
                return dynamicScheme17.platform == platform ? Path.Companion.getContrastCurve(6.0d) : Path.Companion.getContrastCurve(7.0d);
            case 22:
                ((DynamicScheme) obj).getClass();
                return Path.Companion.getContrastCurve(4.5d);
            case 23:
                DynamicScheme dynamicScheme18 = (DynamicScheme) obj;
                dynamicScheme18.getClass();
                return dynamicScheme18.primaryPalette;
            case 24:
                DynamicScheme dynamicScheme19 = (DynamicScheme) obj;
                dynamicScheme19.getClass();
                Variant variant8 = dynamicScheme19.variant;
                if (variant8 != variant4) {
                    TonalPalette tonalPalette2 = dynamicScheme19.primaryPalette;
                    dTMaxC$default = variant8 == variant3 ? Path.Companion.tMaxC$default(tonalPalette2, 0.0d, 90.0d) : Path.Companion.tMaxC(tonalPalette2);
                }
                return Double.valueOf(dTMaxC$default);
            case 25:
                ((DynamicScheme) obj).getClass();
                return Path.Companion.getContrastCurve(4.5d);
            case 26:
                DynamicScheme dynamicScheme20 = (DynamicScheme) obj;
                dynamicScheme20.getClass();
                return dynamicScheme20.errorPalette;
            case 27:
                DynamicScheme dynamicScheme21 = (DynamicScheme) obj;
                dynamicScheme21.getClass();
                return Double.valueOf(Path.Companion.tMinC(dynamicScheme21.errorPalette, 0.0d, 100.0d));
            case 28:
                DynamicScheme dynamicScheme22 = (DynamicScheme) obj;
                dynamicScheme22.getClass();
                return dynamicScheme22.primaryPalette;
            default:
                ((DynamicScheme) obj).getClass();
                return Path.Companion.getContrastCurve(4.5d);
        }
    }
}
