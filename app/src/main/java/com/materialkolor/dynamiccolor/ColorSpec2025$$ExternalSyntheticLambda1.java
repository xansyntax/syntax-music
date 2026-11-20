package com.materialkolor.dynamiccolor;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.materialkolor.palettes.TonalPalette;
import com.materialkolor.scheme.DynamicScheme;
import com.materialkolor.scheme.Variant;
import kotlin.jvm.functions.Function1;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ColorSpec2025$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ColorSpec2025$$ExternalSyntheticLambda1(byte b) {
        this.$r8$classId = b;
    }

    /* JADX WARN: Code duplicated, block: B:131:0x0254  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        double dTMinC;
        byte b = this.$r8$classId;
        double dTMaxC = 90.0d;
        double d = 98.0d;
        Variant variant = Variant.EXPRESSIVE;
        Variant variant2 = Variant.TONAL_SPOT;
        Variant variant3 = Variant.NEUTRAL;
        ColorSpec2025 colorSpec2025 = MaterialDynamicColors.colorSpec;
        DynamicScheme.Platform platform = DynamicScheme.Platform.PHONE;
        switch (b) {
            case 0:
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                dynamicScheme.getClass();
                double dTMinC2 = 30.0d;
                if (dynamicScheme.platform != DynamicScheme.Platform.WATCH) {
                    boolean z = dynamicScheme.isDark;
                    TonalPalette tonalPalette = dynamicScheme.errorPalette;
                    dTMinC2 = z ? Path.Companion.tMinC(tonalPalette, 30.0d, 93.0d) : Path.Companion.tMaxC$default(tonalPalette, 0.0d, 90.0d);
                }
                return Double.valueOf(dTMinC2);
            case 1:
                DynamicScheme dynamicScheme2 = (DynamicScheme) obj;
                dynamicScheme2.getClass();
                TonalPalette tonalPalette2 = dynamicScheme2.primaryPalette;
                boolean z2 = dynamicScheme2.isDark;
                DynamicScheme.Platform platform2 = dynamicScheme2.platform;
                Variant variant4 = dynamicScheme2.variant;
                if (variant4 == variant3) {
                    if (platform2 == platform) {
                        if (z2) {
                            dTMaxC = 80.0d;
                        } else {
                            dTMaxC = 40.0d;
                        }
                    }
                } else if (variant4 != variant2) {
                    int i = 98;
                    if (variant4 == variant) {
                        if (platform2 == platform) {
                            if (tonalPalette2.keyColor.isYellow()) {
                                i = 25;
                            } else if (tonalPalette2.keyColor.isCyan()) {
                                i = 88;
                            }
                            dTMaxC = Path.Companion.tMaxC$default(tonalPalette2, 0.0d, i);
                        } else {
                            dTMaxC = Path.Companion.tMaxC(tonalPalette2);
                        }
                    } else if (platform2 == platform) {
                        dTMaxC = Path.Companion.tMaxC$default(tonalPalette2, 0.0d, tonalPalette2.keyColor.isCyan() ? 88 : 98);
                    } else {
                        dTMaxC = Path.Companion.tMaxC(tonalPalette2);
                    }
                } else if (platform2 != platform) {
                    dTMaxC = Path.Companion.tMaxC$default(tonalPalette2, 0.0d, 90.0d);
                } else if (z2) {
                    dTMaxC = 80.0d;
                } else {
                    dTMaxC = Path.Companion.tMaxC(tonalPalette2);
                }
                return Double.valueOf(dTMaxC);
            case 2:
                DynamicScheme dynamicScheme3 = (DynamicScheme) obj;
                dynamicScheme3.getClass();
                return dynamicScheme3.platform == platform ? Path.Companion.getContrastCurve(4.5d) : Path.Companion.getContrastCurve(7.0d);
            case 3:
                DynamicScheme dynamicScheme4 = (DynamicScheme) obj;
                dynamicScheme4.getClass();
                return dynamicScheme4.neutralPalette;
            case 4:
                DynamicScheme dynamicScheme5 = (DynamicScheme) obj;
                dynamicScheme5.getClass();
                if (dynamicScheme5.platform != platform) {
                    d = 0.0d;
                } else if (dynamicScheme5.isDark) {
                    d = 4.0d;
                } else if (dynamicScheme5.neutralPalette.keyColor.isYellow()) {
                    d = 99.0d;
                } else if (dynamicScheme5.variant == Variant.VIBRANT) {
                    d = 97.0d;
                }
                return Double.valueOf(d);
            case 5:
                DynamicScheme dynamicScheme6 = (DynamicScheme) obj;
                dynamicScheme6.getClass();
                return dynamicScheme6.errorPalette;
            case 6:
                DynamicScheme dynamicScheme7 = (DynamicScheme) obj;
                dynamicScheme7.getClass();
                TonalPalette tonalPalette3 = dynamicScheme7.errorPalette;
                if (dynamicScheme7.platform == platform) {
                    dTMinC = dynamicScheme7.isDark ? Path.Companion.tMinC(tonalPalette3, 0.0d, 98.0d) : Path.Companion.tMaxC(tonalPalette3);
                } else {
                    dTMinC = Path.Companion.tMinC(tonalPalette3, 0.0d, 100.0d);
                }
                return Double.valueOf(dTMinC);
            case 7:
                DynamicScheme dynamicScheme8 = (DynamicScheme) obj;
                dynamicScheme8.getClass();
                return dynamicScheme8.platform == platform ? Path.Companion.getContrastCurve(4.5d) : Path.Companion.getContrastCurve(7.0d);
            case 8:
                DynamicScheme dynamicScheme9 = (DynamicScheme) obj;
                dynamicScheme9.getClass();
                return dynamicScheme9.primaryPalette;
            case 9:
                DynamicScheme dynamicScheme10 = (DynamicScheme) obj;
                dynamicScheme10.getClass();
                return Double.valueOf(Path.Companion.tMaxC(dynamicScheme10.primaryPalette));
            case 10:
                ((DynamicScheme) obj).getClass();
                return colorSpec2025.inverseSurface();
            case 11:
                DynamicScheme dynamicScheme11 = (DynamicScheme) obj;
                dynamicScheme11.getClass();
                return dynamicScheme11.platform == platform ? Path.Companion.getContrastCurve(6.0d) : Path.Companion.getContrastCurve(7.0d);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                DynamicScheme dynamicScheme12 = (DynamicScheme) obj;
                dynamicScheme12.getClass();
                return dynamicScheme12.primaryPalette;
            case 13:
                DynamicScheme dynamicScheme13 = (DynamicScheme) obj;
                dynamicScheme13.getClass();
                if (dynamicScheme13.platform != platform || dynamicScheme13.contrastLevel <= 0.0d) {
                    return null;
                }
                return Path.Companion.getContrastCurve(1.5d);
            case 14:
                DynamicScheme dynamicScheme14 = (DynamicScheme) obj;
                dynamicScheme14.getClass();
                return dynamicScheme14.neutralPalette;
            case 15:
                DynamicScheme dynamicScheme15 = (DynamicScheme) obj;
                dynamicScheme15.getClass();
                double d2 = 1.0d;
                if (dynamicScheme15.platform != platform) {
                    return Double.valueOf(1.0d);
                }
                Variant variant5 = dynamicScheme15.variant;
                if (variant5 == variant3) {
                    d2 = 2.2d;
                } else if (variant5 == variant2) {
                    d2 = 1.7d;
                } else if (variant5 == variant) {
                    if (dynamicScheme15.neutralPalette.keyColor.isYellow()) {
                        d2 = dynamicScheme15.isDark ? 3.0d : 2.3d;
                    } else {
                        d2 = 1.6d;
                    }
                }
                return Double.valueOf(d2);
            case 16:
                DynamicScheme dynamicScheme16 = (DynamicScheme) obj;
                dynamicScheme16.getClass();
                return (dynamicScheme16.isDark && dynamicScheme16.platform == platform) ? Path.Companion.getContrastCurve(11.0d) : Path.Companion.getContrastCurve(9.0d);
            case 17:
                DynamicScheme dynamicScheme17 = (DynamicScheme) obj;
                dynamicScheme17.getClass();
                return dynamicScheme17.neutralPalette;
            case 18:
                DynamicScheme dynamicScheme18 = (DynamicScheme) obj;
                dynamicScheme18.getClass();
                return Double.valueOf(dynamicScheme18.isDark ? 0.0d : 100.0d);
            case 19:
                DynamicScheme dynamicScheme19 = (DynamicScheme) obj;
                dynamicScheme19.getClass();
                return dynamicScheme19.neutralPalette;
            case 20:
                ((DynamicScheme) obj).getClass();
                return colorSpec2025.inverseSurface();
            case 21:
                ((DynamicScheme) obj).getClass();
                return Path.Companion.getContrastCurve(7.0d);
            case 22:
                DynamicScheme dynamicScheme20 = (DynamicScheme) obj;
                dynamicScheme20.getClass();
                return dynamicScheme20.secondaryPalette;
            case 23:
                ((DynamicScheme) obj).getClass();
                return colorSpec2025.secondaryContainer();
            case 24:
                DynamicScheme dynamicScheme21 = (DynamicScheme) obj;
                dynamicScheme21.getClass();
                return dynamicScheme21.platform == platform ? Path.Companion.getContrastCurve(6.0d) : Path.Companion.getContrastCurve(7.0d);
            case 25:
                DynamicScheme dynamicScheme22 = (DynamicScheme) obj;
                dynamicScheme22.getClass();
                return dynamicScheme22.tertiaryPalette;
            case 26:
                DynamicScheme dynamicScheme23 = (DynamicScheme) obj;
                dynamicScheme23.getClass();
                if (dynamicScheme23.platform != platform || dynamicScheme23.contrastLevel <= 0.0d) {
                    return null;
                }
                return Path.Companion.getContrastCurve(1.5d);
            case 27:
                DynamicScheme dynamicScheme24 = (DynamicScheme) obj;
                dynamicScheme24.getClass();
                if (dynamicScheme24.platform != platform || dynamicScheme24.contrastLevel <= 0.0d) {
                    return null;
                }
                return Path.Companion.getContrastCurve(1.5d);
            case 28:
                DynamicScheme dynamicScheme25 = (DynamicScheme) obj;
                dynamicScheme25.getClass();
                return dynamicScheme25.tertiaryPalette;
            default:
                ((DynamicScheme) obj).getClass();
                return colorSpec2025.tertiaryContainer();
        }
    }
}
