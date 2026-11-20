package com.materialkolor.dynamiccolor;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.materialkolor.palettes.TonalPalette;
import com.materialkolor.scheme.DynamicScheme;
import com.materialkolor.scheme.Variant;
import kotlin.jvm.functions.Function1;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ColorSpec2025$$ExternalSyntheticLambda5 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ColorSpec2025$$ExternalSyntheticLambda5(byte b) {
        this.$r8$classId = b;
    }

    /* JADX WARN: Code duplicated, block: B:210:0x039d  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        double d;
        double d2;
        byte b = this.$r8$classId;
        DynamicScheme.Platform platform = DynamicScheme.Platform.WATCH;
        double d3 = 4.0d;
        double d4 = 94.0d;
        ColorSpec2025 colorSpec2025 = MaterialDynamicColors.colorSpec;
        double d5 = 98.0d;
        double dTMaxC$default = 90.0d;
        Variant variant = Variant.EXPRESSIVE;
        Variant variant2 = Variant.TONAL_SPOT;
        Variant variant3 = Variant.NEUTRAL;
        DynamicScheme.Platform platform2 = DynamicScheme.Platform.PHONE;
        Variant variant4 = Variant.VIBRANT;
        switch (b) {
            case 0:
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                dynamicScheme.getClass();
                return dynamicScheme.secondaryPalette;
            case 1:
                DynamicScheme dynamicScheme2 = (DynamicScheme) obj;
                dynamicScheme2.getClass();
                return dynamicScheme2.platform == platform2 ? Path.Companion.getContrastCurve(6.0d) : Path.Companion.getContrastCurve(7.0d);
            case 2:
                DynamicScheme dynamicScheme3 = (DynamicScheme) obj;
                dynamicScheme3.getClass();
                return dynamicScheme3.primaryPalette;
            case 3:
                DynamicScheme dynamicScheme4 = (DynamicScheme) obj;
                dynamicScheme4.getClass();
                boolean z = dynamicScheme4.isDark;
                if (dynamicScheme4.platform != platform) {
                    Variant variant5 = dynamicScheme4.variant;
                    if (variant5 != variant3) {
                        TonalPalette tonalPalette = dynamicScheme4.primaryPalette;
                        if (variant5 == variant2) {
                            dTMaxC$default = z ? Path.Companion.tMinC(tonalPalette, 35.0d, 93.0d) : Path.Companion.tMaxC$default(tonalPalette, 0.0d, 90.0d);
                        } else {
                            if (variant5 == variant) {
                                if (z) {
                                    dTMaxC$default = Path.Companion.tMaxC$default(tonalPalette, 30.0d, 93.0d);
                                } else {
                                    dTMaxC$default = Path.Companion.tMaxC$default(tonalPalette, 78.0d, tonalPalette.keyColor.isCyan() ? 88 : 90);
                                }
                            } else if (z) {
                                dTMaxC$default = Path.Companion.tMinC(tonalPalette, 66.0d, 93.0d);
                            } else {
                                dTMaxC$default = Path.Companion.tMaxC$default(tonalPalette, 66.0d, tonalPalette.keyColor.isCyan() ? 88 : 93);
                            }
                        }
                    } else if (z) {
                        dTMaxC$default = 30.0d;
                    }
                } else {
                    dTMaxC$default = 30.0d;
                }
                return Double.valueOf(dTMaxC$default);
            case 4:
                DynamicScheme dynamicScheme5 = (DynamicScheme) obj;
                dynamicScheme5.getClass();
                if (dynamicScheme5.platform != platform2 || dynamicScheme5.contrastLevel <= 0.0d) {
                    return null;
                }
                return Path.Companion.getContrastCurve(1.5d);
            case 5:
                DynamicScheme dynamicScheme6 = (DynamicScheme) obj;
                dynamicScheme6.getClass();
                return dynamicScheme6.neutralPalette;
            case 6:
                DynamicScheme dynamicScheme7 = (DynamicScheme) obj;
                dynamicScheme7.getClass();
                if (!dynamicScheme7.isDark) {
                    if (dynamicScheme7.neutralPalette.keyColor.isYellow()) {
                        d3 = 90.0d;
                    } else {
                        d3 = dynamicScheme7.variant == variant4 ? 85.0d : 87.0d;
                    }
                }
                return Double.valueOf(d3);
            case 7:
                DynamicScheme dynamicScheme8 = (DynamicScheme) obj;
                dynamicScheme8.getClass();
                if (!dynamicScheme8.isDark) {
                    Variant variant6 = dynamicScheme8.variant;
                    if (variant6 == variant3) {
                        return Double.valueOf(2.5d);
                    }
                    if (variant6 == variant2) {
                        return Double.valueOf(1.7d);
                    }
                    if (variant6 == variant) {
                        return dynamicScheme8.neutralPalette.keyColor.isYellow() ? Double.valueOf(2.7d) : Double.valueOf(1.75d);
                    }
                    if (variant6 == variant4) {
                        return Double.valueOf(1.36d);
                    }
                }
                return Double.valueOf(1.0d);
            case 8:
                DynamicScheme dynamicScheme9 = (DynamicScheme) obj;
                dynamicScheme9.getClass();
                return dynamicScheme9.neutralPalette;
            case 9:
                DynamicScheme dynamicScheme10 = (DynamicScheme) obj;
                dynamicScheme10.getClass();
                if (dynamicScheme10.platform != platform2) {
                    d = 20.0d;
                } else if (dynamicScheme10.isDark) {
                    d = 9.0d;
                } else if (dynamicScheme10.neutralPalette.keyColor.isYellow()) {
                    d = 96.0d;
                } else {
                    d = dynamicScheme10.variant == variant4 ? 92.0d : 94.0d;
                }
                return Double.valueOf(d);
            case 10:
                DynamicScheme dynamicScheme11 = (DynamicScheme) obj;
                Double dValueOf = Double.valueOf(1.6d);
                dynamicScheme11.getClass();
                if (dynamicScheme11.platform == platform2) {
                    Variant variant7 = dynamicScheme11.variant;
                    if (variant7 == variant3) {
                        return dValueOf;
                    }
                    if (variant7 == variant2) {
                        return Double.valueOf(1.4d);
                    }
                    if (variant7 == variant) {
                        return dynamicScheme11.neutralPalette.keyColor.isYellow() ? dValueOf : Double.valueOf(1.3d);
                    }
                    if (variant7 == variant4) {
                        return Double.valueOf(1.15d);
                    }
                }
                return Double.valueOf(1.0d);
            case 11:
                DynamicScheme dynamicScheme12 = (DynamicScheme) obj;
                dynamicScheme12.getClass();
                return dynamicScheme12.neutralPalette;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                DynamicScheme dynamicScheme13 = (DynamicScheme) obj;
                dynamicScheme13.getClass();
                if (dynamicScheme13.isDark) {
                    d2 = 15.0d;
                } else if (dynamicScheme13.neutralPalette.keyColor.isYellow()) {
                    d2 = 92.0d;
                } else {
                    d2 = dynamicScheme13.variant == variant4 ? 88.0d : 90.0d;
                }
                return Double.valueOf(d2);
            case 13:
                DynamicScheme dynamicScheme14 = (DynamicScheme) obj;
                dynamicScheme14.getClass();
                Variant variant8 = dynamicScheme14.variant;
                if (variant8 == variant3) {
                    return Double.valueOf(2.2d);
                }
                if (variant8 == variant2) {
                    return Double.valueOf(1.7d);
                }
                if (variant8 == variant) {
                    return dynamicScheme14.neutralPalette.keyColor.isYellow() ? Double.valueOf(2.3d) : Double.valueOf(1.6d);
                }
                return variant8 == variant4 ? Double.valueOf(1.29d) : Double.valueOf(1.0d);
            case 14:
                DynamicScheme dynamicScheme15 = (DynamicScheme) obj;
                dynamicScheme15.getClass();
                TonalPalette tonalPalette2 = dynamicScheme15.secondaryPalette;
                boolean z2 = dynamicScheme15.isDark;
                DynamicScheme.Platform platform3 = dynamicScheme15.platform;
                Variant variant9 = dynamicScheme15.variant;
                if (platform3 == platform) {
                    if (variant9 != variant3) {
                        dTMaxC$default = Path.Companion.tMaxC$default(tonalPalette2, 0.0d, 90.0d);
                    }
                } else if (variant9 == variant3) {
                    dTMaxC$default = z2 ? Path.Companion.tMinC(tonalPalette2, 0.0d, 98.0d) : Path.Companion.tMaxC(tonalPalette2);
                } else if (variant9 == variant4) {
                    dTMaxC$default = Path.Companion.tMaxC$default(tonalPalette2, 0.0d, z2 ? 90 : 98);
                } else {
                    dTMaxC$default = z2 ? 80.0d : Path.Companion.tMaxC(tonalPalette2);
                }
                return Double.valueOf(dTMaxC$default);
            case 15:
                DynamicScheme dynamicScheme16 = (DynamicScheme) obj;
                dynamicScheme16.getClass();
                return dynamicScheme16.primaryPalette;
            case 16:
                ((DynamicScheme) obj).getClass();
                return colorSpec2025.primaryFixedDim();
            case 17:
                ((DynamicScheme) obj).getClass();
                return Path.Companion.getContrastCurve(7.0d);
            case 18:
                DynamicScheme dynamicScheme17 = (DynamicScheme) obj;
                dynamicScheme17.getClass();
                return dynamicScheme17.neutralPalette;
            case 19:
                DynamicScheme dynamicScheme18 = (DynamicScheme) obj;
                dynamicScheme18.getClass();
                if (dynamicScheme18.platform != platform2) {
                    d5 = 15.0d;
                } else if (dynamicScheme18.isDark) {
                    d5 = 6.0d;
                } else if (!dynamicScheme18.neutralPalette.keyColor.isYellow()) {
                    d5 = dynamicScheme18.variant == variant4 ? 95.0d : 96.0d;
                }
                return Double.valueOf(d5);
            case 20:
                DynamicScheme dynamicScheme19 = (DynamicScheme) obj;
                Double dValueOf2 = Double.valueOf(1.3d);
                dynamicScheme19.getClass();
                if (dynamicScheme19.platform == platform2) {
                    Variant variant10 = dynamicScheme19.variant;
                    if (variant10 == variant3) {
                        return dValueOf2;
                    }
                    if (variant10 == variant2) {
                        return Double.valueOf(1.25d);
                    }
                    if (variant10 == variant) {
                        return dynamicScheme19.neutralPalette.keyColor.isYellow() ? dValueOf2 : Double.valueOf(1.15d);
                    }
                    if (variant10 == variant4) {
                        return Double.valueOf(1.08d);
                    }
                }
                return Double.valueOf(1.0d);
            case 21:
                DynamicScheme dynamicScheme20 = (DynamicScheme) obj;
                dynamicScheme20.getClass();
                return dynamicScheme20.neutralPalette;
            case 22:
                DynamicScheme dynamicScheme21 = (DynamicScheme) obj;
                dynamicScheme21.getClass();
                return Double.valueOf(dynamicScheme21.isDark ? 98.0d : 4.0d);
            case 23:
                DynamicScheme dynamicScheme22 = (DynamicScheme) obj;
                dynamicScheme22.getClass();
                return dynamicScheme22.neutralPalette;
            case 24:
                DynamicScheme dynamicScheme23 = (DynamicScheme) obj;
                dynamicScheme23.getClass();
                if (dynamicScheme23.platform != platform2) {
                    d4 = 25.0d;
                } else if (dynamicScheme23.isDark) {
                    d4 = 12.0d;
                } else if (!dynamicScheme23.neutralPalette.keyColor.isYellow()) {
                    d4 = dynamicScheme23.variant == variant4 ? 90.0d : 92.0d;
                }
                return Double.valueOf(d4);
            case 25:
                DynamicScheme dynamicScheme24 = (DynamicScheme) obj;
                dynamicScheme24.getClass();
                if (dynamicScheme24.platform == platform2) {
                    Variant variant11 = dynamicScheme24.variant;
                    if (variant11 == variant3) {
                        return Double.valueOf(1.9d);
                    }
                    if (variant11 == variant2) {
                        return Double.valueOf(1.5d);
                    }
                    if (variant11 == variant) {
                        return dynamicScheme24.neutralPalette.keyColor.isYellow() ? Double.valueOf(1.95d) : Double.valueOf(1.45d);
                    }
                    if (variant11 == variant4) {
                        return Double.valueOf(1.22d);
                    }
                }
                return Double.valueOf(1.0d);
            case 26:
                DynamicScheme dynamicScheme25 = (DynamicScheme) obj;
                dynamicScheme25.getClass();
                return dynamicScheme25.secondaryPalette;
            case 27:
                ((DynamicScheme) obj).getClass();
                return colorSpec2025.secondaryFixedDim();
            case 28:
                ((DynamicScheme) obj).getClass();
                return Path.Companion.getContrastCurve(4.5d);
            default:
                DynamicScheme dynamicScheme26 = (DynamicScheme) obj;
                dynamicScheme26.getClass();
                return dynamicScheme26.errorPalette;
        }
    }
}
