package com.materialkolor.dynamiccolor;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.materialkolor.palettes.TonalPalette;
import com.materialkolor.scheme.DynamicScheme;
import com.metrolist.innertube.YouTube$$ExternalSyntheticLambda0;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DynamicColor$Companion$Builder {
    public Function1 background;
    public Function1 chromaMultiplier;
    public Function1 contrastCurve;
    public boolean isBackground;
    public String name;
    public Function1 opacity;
    public Function1 palette;
    public Function1 secondBackground;
    public Function1 tone;
    public Function1 toneDeltaPair;

    public final DynamicColor build() {
        Function1 function1 = this.background;
        if (function1 == null && this.secondBackground != null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m("Color ", this.name, " has secondBackground defined, but background is not defined."));
            return null;
        }
        if (function1 == null && this.contrastCurve != null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m("Color ", this.name, " has contrastCurve defined, but background is not defined."));
            return null;
        }
        if (function1 != null && this.contrastCurve == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m("Color ", this.name, " has background defined, but contrastCurve is not defined."));
            return null;
        }
        Function1 youTube$$ExternalSyntheticLambda0 = this.tone;
        if (youTube$$ExternalSyntheticLambda0 == null) {
            youTube$$ExternalSyntheticLambda0 = function1 == null ? new YouTube$$ExternalSyntheticLambda0((byte) 13) : new CodecsKt$$ExternalSyntheticLambda0(function1, (byte) 12);
        }
        String str = this.name;
        str.getClass();
        Function1 function2 = this.palette;
        function2.getClass();
        return new DynamicColor(str, function2, youTube$$ExternalSyntheticLambda0, this.isBackground, this.chromaMultiplier, this.background, this.secondBackground, this.contrastCurve, this.toneDeltaPair, this.opacity);
    }

    public final DynamicColor$Companion$Builder extendSpecVersion(final DynamicColor dynamicColor) {
        String str = this.name;
        String str2 = dynamicColor.name;
        boolean zAreEqual = Intrinsics.areEqual(str, str2);
        ColorSpec$SpecVersion colorSpec$SpecVersion = ColorSpec$SpecVersion.SPEC_2025;
        if (!zAreEqual) {
            PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("Attempting to extend color ", this.name, " with color ", str2, " of different name for spec version "), colorSpec$SpecVersion, ".");
            return null;
        }
        boolean z = this.isBackground;
        boolean z2 = dynamicColor.isBackground;
        String str3 = this.name;
        if (z != z2) {
            String str4 = z ? "background" : "foreground";
            String str5 = z2 ? "background" : "foreground";
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("Attempting to extend color ", str3, " as a ", str4, " with color ");
            IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, str2, " as a ", str5, " for spec version ");
            PathKt$$ExternalSyntheticBUOutline0.m(sbM, colorSpec$SpecVersion, ".");
            return null;
        }
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        str3.getClass();
        dynamicColor$Companion$Builder.name = str3;
        dynamicColor$Companion$Builder.isBackground = this.isBackground;
        final byte b = 0;
        dynamicColor$Companion$Builder.palette = new Function1() { // from class: com.materialkolor.dynamiccolor.DynamicColor$Companion$Builder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                TonalPalette tonalPalette;
                byte b2 = b;
                DynamicColor$Companion$Builder dynamicColor$Companion$Builder2 = this;
                DynamicColor dynamicColor2 = dynamicColor;
                ColorSpec$SpecVersion colorSpec$SpecVersion2 = ColorSpec$SpecVersion.SPEC_2025;
                switch (b2) {
                    case 0:
                        Function1 function1 = dynamicColor2.palette;
                        DynamicScheme dynamicScheme = (DynamicScheme) obj;
                        dynamicScheme.getClass();
                        Function1 function2 = dynamicScheme.specVersion == colorSpec$SpecVersion2 ? function1 : dynamicColor$Companion$Builder2.palette;
                        return (function2 == null || (tonalPalette = (TonalPalette) function2.invoke(dynamicScheme)) == null) ? (TonalPalette) function1.invoke(dynamicScheme) : tonalPalette;
                    case 1:
                        Function1 function3 = dynamicColor2.tone;
                        DynamicScheme dynamicScheme2 = (DynamicScheme) obj;
                        dynamicScheme2.getClass();
                        Function1 function4 = dynamicScheme2.specVersion == colorSpec$SpecVersion2 ? function3 : dynamicColor$Companion$Builder2.tone;
                        return Double.valueOf(((Number) (function4 != null ? function4.invoke(dynamicScheme2) : function3.invoke(dynamicScheme2))).doubleValue());
                    case 2:
                        DynamicScheme dynamicScheme3 = (DynamicScheme) obj;
                        dynamicScheme3.getClass();
                        Function1 function5 = dynamicScheme3.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.chromaMultiplier : dynamicColor$Companion$Builder2.chromaMultiplier;
                        return function5 != null ? (Double) function5.invoke(dynamicScheme3) : Double.valueOf(1.0d);
                    case 3:
                        DynamicScheme dynamicScheme4 = (DynamicScheme) obj;
                        dynamicScheme4.getClass();
                        Function1 function6 = dynamicScheme4.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.background : dynamicColor$Companion$Builder2.background;
                        if (function6 != null) {
                            return (DynamicColor) function6.invoke(dynamicScheme4);
                        }
                        return null;
                    case 4:
                        DynamicScheme dynamicScheme5 = (DynamicScheme) obj;
                        dynamicScheme5.getClass();
                        Function1 function7 = dynamicScheme5.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.secondBackground : dynamicColor$Companion$Builder2.secondBackground;
                        if (function7 != null) {
                            return (DynamicColor) function7.invoke(dynamicScheme5);
                        }
                        return null;
                    case 5:
                        DynamicScheme dynamicScheme6 = (DynamicScheme) obj;
                        dynamicScheme6.getClass();
                        Function1 function8 = dynamicScheme6.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.contrastCurve : dynamicColor$Companion$Builder2.contrastCurve;
                        if (function8 != null) {
                            return (ContrastCurve) function8.invoke(dynamicScheme6);
                        }
                        return null;
                    case 6:
                        DynamicScheme dynamicScheme7 = (DynamicScheme) obj;
                        dynamicScheme7.getClass();
                        Function1 function9 = dynamicScheme7.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.toneDeltaPair : dynamicColor$Companion$Builder2.toneDeltaPair;
                        if (function9 != null) {
                            return (ToneDeltaPair) function9.invoke(dynamicScheme7);
                        }
                        return null;
                    default:
                        DynamicScheme dynamicScheme8 = (DynamicScheme) obj;
                        dynamicScheme8.getClass();
                        Function1 function10 = dynamicScheme8.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.opacity : dynamicColor$Companion$Builder2.opacity;
                        if (function10 != null) {
                            return (Double) function10.invoke(dynamicScheme8);
                        }
                        return null;
                }
            }
        };
        final byte b2 = 1;
        dynamicColor$Companion$Builder.tone = new Function1() { // from class: com.materialkolor.dynamiccolor.DynamicColor$Companion$Builder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                TonalPalette tonalPalette;
                byte b3 = b2;
                DynamicColor$Companion$Builder dynamicColor$Companion$Builder2 = this;
                DynamicColor dynamicColor2 = dynamicColor;
                ColorSpec$SpecVersion colorSpec$SpecVersion2 = ColorSpec$SpecVersion.SPEC_2025;
                switch (b3) {
                    case 0:
                        Function1 function1 = dynamicColor2.palette;
                        DynamicScheme dynamicScheme = (DynamicScheme) obj;
                        dynamicScheme.getClass();
                        Function1 function2 = dynamicScheme.specVersion == colorSpec$SpecVersion2 ? function1 : dynamicColor$Companion$Builder2.palette;
                        return (function2 == null || (tonalPalette = (TonalPalette) function2.invoke(dynamicScheme)) == null) ? (TonalPalette) function1.invoke(dynamicScheme) : tonalPalette;
                    case 1:
                        Function1 function3 = dynamicColor2.tone;
                        DynamicScheme dynamicScheme2 = (DynamicScheme) obj;
                        dynamicScheme2.getClass();
                        Function1 function4 = dynamicScheme2.specVersion == colorSpec$SpecVersion2 ? function3 : dynamicColor$Companion$Builder2.tone;
                        return Double.valueOf(((Number) (function4 != null ? function4.invoke(dynamicScheme2) : function3.invoke(dynamicScheme2))).doubleValue());
                    case 2:
                        DynamicScheme dynamicScheme3 = (DynamicScheme) obj;
                        dynamicScheme3.getClass();
                        Function1 function5 = dynamicScheme3.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.chromaMultiplier : dynamicColor$Companion$Builder2.chromaMultiplier;
                        return function5 != null ? (Double) function5.invoke(dynamicScheme3) : Double.valueOf(1.0d);
                    case 3:
                        DynamicScheme dynamicScheme4 = (DynamicScheme) obj;
                        dynamicScheme4.getClass();
                        Function1 function6 = dynamicScheme4.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.background : dynamicColor$Companion$Builder2.background;
                        if (function6 != null) {
                            return (DynamicColor) function6.invoke(dynamicScheme4);
                        }
                        return null;
                    case 4:
                        DynamicScheme dynamicScheme5 = (DynamicScheme) obj;
                        dynamicScheme5.getClass();
                        Function1 function7 = dynamicScheme5.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.secondBackground : dynamicColor$Companion$Builder2.secondBackground;
                        if (function7 != null) {
                            return (DynamicColor) function7.invoke(dynamicScheme5);
                        }
                        return null;
                    case 5:
                        DynamicScheme dynamicScheme6 = (DynamicScheme) obj;
                        dynamicScheme6.getClass();
                        Function1 function8 = dynamicScheme6.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.contrastCurve : dynamicColor$Companion$Builder2.contrastCurve;
                        if (function8 != null) {
                            return (ContrastCurve) function8.invoke(dynamicScheme6);
                        }
                        return null;
                    case 6:
                        DynamicScheme dynamicScheme7 = (DynamicScheme) obj;
                        dynamicScheme7.getClass();
                        Function1 function9 = dynamicScheme7.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.toneDeltaPair : dynamicColor$Companion$Builder2.toneDeltaPair;
                        if (function9 != null) {
                            return (ToneDeltaPair) function9.invoke(dynamicScheme7);
                        }
                        return null;
                    default:
                        DynamicScheme dynamicScheme8 = (DynamicScheme) obj;
                        dynamicScheme8.getClass();
                        Function1 function10 = dynamicScheme8.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.opacity : dynamicColor$Companion$Builder2.opacity;
                        if (function10 != null) {
                            return (Double) function10.invoke(dynamicScheme8);
                        }
                        return null;
                }
            }
        };
        final byte b3 = 2;
        dynamicColor$Companion$Builder.chromaMultiplier = new Function1() { // from class: com.materialkolor.dynamiccolor.DynamicColor$Companion$Builder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                TonalPalette tonalPalette;
                byte b4 = b3;
                DynamicColor$Companion$Builder dynamicColor$Companion$Builder2 = this;
                DynamicColor dynamicColor2 = dynamicColor;
                ColorSpec$SpecVersion colorSpec$SpecVersion2 = ColorSpec$SpecVersion.SPEC_2025;
                switch (b4) {
                    case 0:
                        Function1 function1 = dynamicColor2.palette;
                        DynamicScheme dynamicScheme = (DynamicScheme) obj;
                        dynamicScheme.getClass();
                        Function1 function2 = dynamicScheme.specVersion == colorSpec$SpecVersion2 ? function1 : dynamicColor$Companion$Builder2.palette;
                        return (function2 == null || (tonalPalette = (TonalPalette) function2.invoke(dynamicScheme)) == null) ? (TonalPalette) function1.invoke(dynamicScheme) : tonalPalette;
                    case 1:
                        Function1 function3 = dynamicColor2.tone;
                        DynamicScheme dynamicScheme2 = (DynamicScheme) obj;
                        dynamicScheme2.getClass();
                        Function1 function4 = dynamicScheme2.specVersion == colorSpec$SpecVersion2 ? function3 : dynamicColor$Companion$Builder2.tone;
                        return Double.valueOf(((Number) (function4 != null ? function4.invoke(dynamicScheme2) : function3.invoke(dynamicScheme2))).doubleValue());
                    case 2:
                        DynamicScheme dynamicScheme3 = (DynamicScheme) obj;
                        dynamicScheme3.getClass();
                        Function1 function5 = dynamicScheme3.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.chromaMultiplier : dynamicColor$Companion$Builder2.chromaMultiplier;
                        return function5 != null ? (Double) function5.invoke(dynamicScheme3) : Double.valueOf(1.0d);
                    case 3:
                        DynamicScheme dynamicScheme4 = (DynamicScheme) obj;
                        dynamicScheme4.getClass();
                        Function1 function6 = dynamicScheme4.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.background : dynamicColor$Companion$Builder2.background;
                        if (function6 != null) {
                            return (DynamicColor) function6.invoke(dynamicScheme4);
                        }
                        return null;
                    case 4:
                        DynamicScheme dynamicScheme5 = (DynamicScheme) obj;
                        dynamicScheme5.getClass();
                        Function1 function7 = dynamicScheme5.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.secondBackground : dynamicColor$Companion$Builder2.secondBackground;
                        if (function7 != null) {
                            return (DynamicColor) function7.invoke(dynamicScheme5);
                        }
                        return null;
                    case 5:
                        DynamicScheme dynamicScheme6 = (DynamicScheme) obj;
                        dynamicScheme6.getClass();
                        Function1 function8 = dynamicScheme6.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.contrastCurve : dynamicColor$Companion$Builder2.contrastCurve;
                        if (function8 != null) {
                            return (ContrastCurve) function8.invoke(dynamicScheme6);
                        }
                        return null;
                    case 6:
                        DynamicScheme dynamicScheme7 = (DynamicScheme) obj;
                        dynamicScheme7.getClass();
                        Function1 function9 = dynamicScheme7.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.toneDeltaPair : dynamicColor$Companion$Builder2.toneDeltaPair;
                        if (function9 != null) {
                            return (ToneDeltaPair) function9.invoke(dynamicScheme7);
                        }
                        return null;
                    default:
                        DynamicScheme dynamicScheme8 = (DynamicScheme) obj;
                        dynamicScheme8.getClass();
                        Function1 function10 = dynamicScheme8.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.opacity : dynamicColor$Companion$Builder2.opacity;
                        if (function10 != null) {
                            return (Double) function10.invoke(dynamicScheme8);
                        }
                        return null;
                }
            }
        };
        final byte b4 = 3;
        dynamicColor$Companion$Builder.background = new Function1() { // from class: com.materialkolor.dynamiccolor.DynamicColor$Companion$Builder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                TonalPalette tonalPalette;
                byte b5 = b4;
                DynamicColor$Companion$Builder dynamicColor$Companion$Builder2 = this;
                DynamicColor dynamicColor2 = dynamicColor;
                ColorSpec$SpecVersion colorSpec$SpecVersion2 = ColorSpec$SpecVersion.SPEC_2025;
                switch (b5) {
                    case 0:
                        Function1 function1 = dynamicColor2.palette;
                        DynamicScheme dynamicScheme = (DynamicScheme) obj;
                        dynamicScheme.getClass();
                        Function1 function2 = dynamicScheme.specVersion == colorSpec$SpecVersion2 ? function1 : dynamicColor$Companion$Builder2.palette;
                        return (function2 == null || (tonalPalette = (TonalPalette) function2.invoke(dynamicScheme)) == null) ? (TonalPalette) function1.invoke(dynamicScheme) : tonalPalette;
                    case 1:
                        Function1 function3 = dynamicColor2.tone;
                        DynamicScheme dynamicScheme2 = (DynamicScheme) obj;
                        dynamicScheme2.getClass();
                        Function1 function4 = dynamicScheme2.specVersion == colorSpec$SpecVersion2 ? function3 : dynamicColor$Companion$Builder2.tone;
                        return Double.valueOf(((Number) (function4 != null ? function4.invoke(dynamicScheme2) : function3.invoke(dynamicScheme2))).doubleValue());
                    case 2:
                        DynamicScheme dynamicScheme3 = (DynamicScheme) obj;
                        dynamicScheme3.getClass();
                        Function1 function5 = dynamicScheme3.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.chromaMultiplier : dynamicColor$Companion$Builder2.chromaMultiplier;
                        return function5 != null ? (Double) function5.invoke(dynamicScheme3) : Double.valueOf(1.0d);
                    case 3:
                        DynamicScheme dynamicScheme4 = (DynamicScheme) obj;
                        dynamicScheme4.getClass();
                        Function1 function6 = dynamicScheme4.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.background : dynamicColor$Companion$Builder2.background;
                        if (function6 != null) {
                            return (DynamicColor) function6.invoke(dynamicScheme4);
                        }
                        return null;
                    case 4:
                        DynamicScheme dynamicScheme5 = (DynamicScheme) obj;
                        dynamicScheme5.getClass();
                        Function1 function7 = dynamicScheme5.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.secondBackground : dynamicColor$Companion$Builder2.secondBackground;
                        if (function7 != null) {
                            return (DynamicColor) function7.invoke(dynamicScheme5);
                        }
                        return null;
                    case 5:
                        DynamicScheme dynamicScheme6 = (DynamicScheme) obj;
                        dynamicScheme6.getClass();
                        Function1 function8 = dynamicScheme6.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.contrastCurve : dynamicColor$Companion$Builder2.contrastCurve;
                        if (function8 != null) {
                            return (ContrastCurve) function8.invoke(dynamicScheme6);
                        }
                        return null;
                    case 6:
                        DynamicScheme dynamicScheme7 = (DynamicScheme) obj;
                        dynamicScheme7.getClass();
                        Function1 function9 = dynamicScheme7.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.toneDeltaPair : dynamicColor$Companion$Builder2.toneDeltaPair;
                        if (function9 != null) {
                            return (ToneDeltaPair) function9.invoke(dynamicScheme7);
                        }
                        return null;
                    default:
                        DynamicScheme dynamicScheme8 = (DynamicScheme) obj;
                        dynamicScheme8.getClass();
                        Function1 function10 = dynamicScheme8.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.opacity : dynamicColor$Companion$Builder2.opacity;
                        if (function10 != null) {
                            return (Double) function10.invoke(dynamicScheme8);
                        }
                        return null;
                }
            }
        };
        final byte b5 = 4;
        dynamicColor$Companion$Builder.secondBackground = new Function1() { // from class: com.materialkolor.dynamiccolor.DynamicColor$Companion$Builder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                TonalPalette tonalPalette;
                byte b6 = b5;
                DynamicColor$Companion$Builder dynamicColor$Companion$Builder2 = this;
                DynamicColor dynamicColor2 = dynamicColor;
                ColorSpec$SpecVersion colorSpec$SpecVersion2 = ColorSpec$SpecVersion.SPEC_2025;
                switch (b6) {
                    case 0:
                        Function1 function1 = dynamicColor2.palette;
                        DynamicScheme dynamicScheme = (DynamicScheme) obj;
                        dynamicScheme.getClass();
                        Function1 function2 = dynamicScheme.specVersion == colorSpec$SpecVersion2 ? function1 : dynamicColor$Companion$Builder2.palette;
                        return (function2 == null || (tonalPalette = (TonalPalette) function2.invoke(dynamicScheme)) == null) ? (TonalPalette) function1.invoke(dynamicScheme) : tonalPalette;
                    case 1:
                        Function1 function3 = dynamicColor2.tone;
                        DynamicScheme dynamicScheme2 = (DynamicScheme) obj;
                        dynamicScheme2.getClass();
                        Function1 function4 = dynamicScheme2.specVersion == colorSpec$SpecVersion2 ? function3 : dynamicColor$Companion$Builder2.tone;
                        return Double.valueOf(((Number) (function4 != null ? function4.invoke(dynamicScheme2) : function3.invoke(dynamicScheme2))).doubleValue());
                    case 2:
                        DynamicScheme dynamicScheme3 = (DynamicScheme) obj;
                        dynamicScheme3.getClass();
                        Function1 function5 = dynamicScheme3.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.chromaMultiplier : dynamicColor$Companion$Builder2.chromaMultiplier;
                        return function5 != null ? (Double) function5.invoke(dynamicScheme3) : Double.valueOf(1.0d);
                    case 3:
                        DynamicScheme dynamicScheme4 = (DynamicScheme) obj;
                        dynamicScheme4.getClass();
                        Function1 function6 = dynamicScheme4.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.background : dynamicColor$Companion$Builder2.background;
                        if (function6 != null) {
                            return (DynamicColor) function6.invoke(dynamicScheme4);
                        }
                        return null;
                    case 4:
                        DynamicScheme dynamicScheme5 = (DynamicScheme) obj;
                        dynamicScheme5.getClass();
                        Function1 function7 = dynamicScheme5.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.secondBackground : dynamicColor$Companion$Builder2.secondBackground;
                        if (function7 != null) {
                            return (DynamicColor) function7.invoke(dynamicScheme5);
                        }
                        return null;
                    case 5:
                        DynamicScheme dynamicScheme6 = (DynamicScheme) obj;
                        dynamicScheme6.getClass();
                        Function1 function8 = dynamicScheme6.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.contrastCurve : dynamicColor$Companion$Builder2.contrastCurve;
                        if (function8 != null) {
                            return (ContrastCurve) function8.invoke(dynamicScheme6);
                        }
                        return null;
                    case 6:
                        DynamicScheme dynamicScheme7 = (DynamicScheme) obj;
                        dynamicScheme7.getClass();
                        Function1 function9 = dynamicScheme7.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.toneDeltaPair : dynamicColor$Companion$Builder2.toneDeltaPair;
                        if (function9 != null) {
                            return (ToneDeltaPair) function9.invoke(dynamicScheme7);
                        }
                        return null;
                    default:
                        DynamicScheme dynamicScheme8 = (DynamicScheme) obj;
                        dynamicScheme8.getClass();
                        Function1 function10 = dynamicScheme8.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.opacity : dynamicColor$Companion$Builder2.opacity;
                        if (function10 != null) {
                            return (Double) function10.invoke(dynamicScheme8);
                        }
                        return null;
                }
            }
        };
        final byte b6 = 5;
        dynamicColor$Companion$Builder.contrastCurve = new Function1() { // from class: com.materialkolor.dynamiccolor.DynamicColor$Companion$Builder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                TonalPalette tonalPalette;
                byte b7 = b6;
                DynamicColor$Companion$Builder dynamicColor$Companion$Builder2 = this;
                DynamicColor dynamicColor2 = dynamicColor;
                ColorSpec$SpecVersion colorSpec$SpecVersion2 = ColorSpec$SpecVersion.SPEC_2025;
                switch (b7) {
                    case 0:
                        Function1 function1 = dynamicColor2.palette;
                        DynamicScheme dynamicScheme = (DynamicScheme) obj;
                        dynamicScheme.getClass();
                        Function1 function2 = dynamicScheme.specVersion == colorSpec$SpecVersion2 ? function1 : dynamicColor$Companion$Builder2.palette;
                        return (function2 == null || (tonalPalette = (TonalPalette) function2.invoke(dynamicScheme)) == null) ? (TonalPalette) function1.invoke(dynamicScheme) : tonalPalette;
                    case 1:
                        Function1 function3 = dynamicColor2.tone;
                        DynamicScheme dynamicScheme2 = (DynamicScheme) obj;
                        dynamicScheme2.getClass();
                        Function1 function4 = dynamicScheme2.specVersion == colorSpec$SpecVersion2 ? function3 : dynamicColor$Companion$Builder2.tone;
                        return Double.valueOf(((Number) (function4 != null ? function4.invoke(dynamicScheme2) : function3.invoke(dynamicScheme2))).doubleValue());
                    case 2:
                        DynamicScheme dynamicScheme3 = (DynamicScheme) obj;
                        dynamicScheme3.getClass();
                        Function1 function5 = dynamicScheme3.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.chromaMultiplier : dynamicColor$Companion$Builder2.chromaMultiplier;
                        return function5 != null ? (Double) function5.invoke(dynamicScheme3) : Double.valueOf(1.0d);
                    case 3:
                        DynamicScheme dynamicScheme4 = (DynamicScheme) obj;
                        dynamicScheme4.getClass();
                        Function1 function6 = dynamicScheme4.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.background : dynamicColor$Companion$Builder2.background;
                        if (function6 != null) {
                            return (DynamicColor) function6.invoke(dynamicScheme4);
                        }
                        return null;
                    case 4:
                        DynamicScheme dynamicScheme5 = (DynamicScheme) obj;
                        dynamicScheme5.getClass();
                        Function1 function7 = dynamicScheme5.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.secondBackground : dynamicColor$Companion$Builder2.secondBackground;
                        if (function7 != null) {
                            return (DynamicColor) function7.invoke(dynamicScheme5);
                        }
                        return null;
                    case 5:
                        DynamicScheme dynamicScheme6 = (DynamicScheme) obj;
                        dynamicScheme6.getClass();
                        Function1 function8 = dynamicScheme6.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.contrastCurve : dynamicColor$Companion$Builder2.contrastCurve;
                        if (function8 != null) {
                            return (ContrastCurve) function8.invoke(dynamicScheme6);
                        }
                        return null;
                    case 6:
                        DynamicScheme dynamicScheme7 = (DynamicScheme) obj;
                        dynamicScheme7.getClass();
                        Function1 function9 = dynamicScheme7.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.toneDeltaPair : dynamicColor$Companion$Builder2.toneDeltaPair;
                        if (function9 != null) {
                            return (ToneDeltaPair) function9.invoke(dynamicScheme7);
                        }
                        return null;
                    default:
                        DynamicScheme dynamicScheme8 = (DynamicScheme) obj;
                        dynamicScheme8.getClass();
                        Function1 function10 = dynamicScheme8.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.opacity : dynamicColor$Companion$Builder2.opacity;
                        if (function10 != null) {
                            return (Double) function10.invoke(dynamicScheme8);
                        }
                        return null;
                }
            }
        };
        final byte b7 = 6;
        dynamicColor$Companion$Builder.toneDeltaPair = new Function1() { // from class: com.materialkolor.dynamiccolor.DynamicColor$Companion$Builder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                TonalPalette tonalPalette;
                byte b8 = b7;
                DynamicColor$Companion$Builder dynamicColor$Companion$Builder2 = this;
                DynamicColor dynamicColor2 = dynamicColor;
                ColorSpec$SpecVersion colorSpec$SpecVersion2 = ColorSpec$SpecVersion.SPEC_2025;
                switch (b8) {
                    case 0:
                        Function1 function1 = dynamicColor2.palette;
                        DynamicScheme dynamicScheme = (DynamicScheme) obj;
                        dynamicScheme.getClass();
                        Function1 function2 = dynamicScheme.specVersion == colorSpec$SpecVersion2 ? function1 : dynamicColor$Companion$Builder2.palette;
                        return (function2 == null || (tonalPalette = (TonalPalette) function2.invoke(dynamicScheme)) == null) ? (TonalPalette) function1.invoke(dynamicScheme) : tonalPalette;
                    case 1:
                        Function1 function3 = dynamicColor2.tone;
                        DynamicScheme dynamicScheme2 = (DynamicScheme) obj;
                        dynamicScheme2.getClass();
                        Function1 function4 = dynamicScheme2.specVersion == colorSpec$SpecVersion2 ? function3 : dynamicColor$Companion$Builder2.tone;
                        return Double.valueOf(((Number) (function4 != null ? function4.invoke(dynamicScheme2) : function3.invoke(dynamicScheme2))).doubleValue());
                    case 2:
                        DynamicScheme dynamicScheme3 = (DynamicScheme) obj;
                        dynamicScheme3.getClass();
                        Function1 function5 = dynamicScheme3.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.chromaMultiplier : dynamicColor$Companion$Builder2.chromaMultiplier;
                        return function5 != null ? (Double) function5.invoke(dynamicScheme3) : Double.valueOf(1.0d);
                    case 3:
                        DynamicScheme dynamicScheme4 = (DynamicScheme) obj;
                        dynamicScheme4.getClass();
                        Function1 function6 = dynamicScheme4.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.background : dynamicColor$Companion$Builder2.background;
                        if (function6 != null) {
                            return (DynamicColor) function6.invoke(dynamicScheme4);
                        }
                        return null;
                    case 4:
                        DynamicScheme dynamicScheme5 = (DynamicScheme) obj;
                        dynamicScheme5.getClass();
                        Function1 function7 = dynamicScheme5.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.secondBackground : dynamicColor$Companion$Builder2.secondBackground;
                        if (function7 != null) {
                            return (DynamicColor) function7.invoke(dynamicScheme5);
                        }
                        return null;
                    case 5:
                        DynamicScheme dynamicScheme6 = (DynamicScheme) obj;
                        dynamicScheme6.getClass();
                        Function1 function8 = dynamicScheme6.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.contrastCurve : dynamicColor$Companion$Builder2.contrastCurve;
                        if (function8 != null) {
                            return (ContrastCurve) function8.invoke(dynamicScheme6);
                        }
                        return null;
                    case 6:
                        DynamicScheme dynamicScheme7 = (DynamicScheme) obj;
                        dynamicScheme7.getClass();
                        Function1 function9 = dynamicScheme7.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.toneDeltaPair : dynamicColor$Companion$Builder2.toneDeltaPair;
                        if (function9 != null) {
                            return (ToneDeltaPair) function9.invoke(dynamicScheme7);
                        }
                        return null;
                    default:
                        DynamicScheme dynamicScheme8 = (DynamicScheme) obj;
                        dynamicScheme8.getClass();
                        Function1 function10 = dynamicScheme8.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.opacity : dynamicColor$Companion$Builder2.opacity;
                        if (function10 != null) {
                            return (Double) function10.invoke(dynamicScheme8);
                        }
                        return null;
                }
            }
        };
        final byte b8 = 7;
        dynamicColor$Companion$Builder.opacity = new Function1() { // from class: com.materialkolor.dynamiccolor.DynamicColor$Companion$Builder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                TonalPalette tonalPalette;
                byte b9 = b8;
                DynamicColor$Companion$Builder dynamicColor$Companion$Builder2 = this;
                DynamicColor dynamicColor2 = dynamicColor;
                ColorSpec$SpecVersion colorSpec$SpecVersion2 = ColorSpec$SpecVersion.SPEC_2025;
                switch (b9) {
                    case 0:
                        Function1 function1 = dynamicColor2.palette;
                        DynamicScheme dynamicScheme = (DynamicScheme) obj;
                        dynamicScheme.getClass();
                        Function1 function2 = dynamicScheme.specVersion == colorSpec$SpecVersion2 ? function1 : dynamicColor$Companion$Builder2.palette;
                        return (function2 == null || (tonalPalette = (TonalPalette) function2.invoke(dynamicScheme)) == null) ? (TonalPalette) function1.invoke(dynamicScheme) : tonalPalette;
                    case 1:
                        Function1 function3 = dynamicColor2.tone;
                        DynamicScheme dynamicScheme2 = (DynamicScheme) obj;
                        dynamicScheme2.getClass();
                        Function1 function4 = dynamicScheme2.specVersion == colorSpec$SpecVersion2 ? function3 : dynamicColor$Companion$Builder2.tone;
                        return Double.valueOf(((Number) (function4 != null ? function4.invoke(dynamicScheme2) : function3.invoke(dynamicScheme2))).doubleValue());
                    case 2:
                        DynamicScheme dynamicScheme3 = (DynamicScheme) obj;
                        dynamicScheme3.getClass();
                        Function1 function5 = dynamicScheme3.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.chromaMultiplier : dynamicColor$Companion$Builder2.chromaMultiplier;
                        return function5 != null ? (Double) function5.invoke(dynamicScheme3) : Double.valueOf(1.0d);
                    case 3:
                        DynamicScheme dynamicScheme4 = (DynamicScheme) obj;
                        dynamicScheme4.getClass();
                        Function1 function6 = dynamicScheme4.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.background : dynamicColor$Companion$Builder2.background;
                        if (function6 != null) {
                            return (DynamicColor) function6.invoke(dynamicScheme4);
                        }
                        return null;
                    case 4:
                        DynamicScheme dynamicScheme5 = (DynamicScheme) obj;
                        dynamicScheme5.getClass();
                        Function1 function7 = dynamicScheme5.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.secondBackground : dynamicColor$Companion$Builder2.secondBackground;
                        if (function7 != null) {
                            return (DynamicColor) function7.invoke(dynamicScheme5);
                        }
                        return null;
                    case 5:
                        DynamicScheme dynamicScheme6 = (DynamicScheme) obj;
                        dynamicScheme6.getClass();
                        Function1 function8 = dynamicScheme6.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.contrastCurve : dynamicColor$Companion$Builder2.contrastCurve;
                        if (function8 != null) {
                            return (ContrastCurve) function8.invoke(dynamicScheme6);
                        }
                        return null;
                    case 6:
                        DynamicScheme dynamicScheme7 = (DynamicScheme) obj;
                        dynamicScheme7.getClass();
                        Function1 function9 = dynamicScheme7.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.toneDeltaPair : dynamicColor$Companion$Builder2.toneDeltaPair;
                        if (function9 != null) {
                            return (ToneDeltaPair) function9.invoke(dynamicScheme7);
                        }
                        return null;
                    default:
                        DynamicScheme dynamicScheme8 = (DynamicScheme) obj;
                        dynamicScheme8.getClass();
                        Function1 function10 = dynamicScheme8.specVersion == colorSpec$SpecVersion2 ? dynamicColor2.opacity : dynamicColor$Companion$Builder2.opacity;
                        if (function10 != null) {
                            return (Double) function10.invoke(dynamicScheme8);
                        }
                        return null;
                }
            }
        };
        return dynamicColor$Companion$Builder;
    }
}
