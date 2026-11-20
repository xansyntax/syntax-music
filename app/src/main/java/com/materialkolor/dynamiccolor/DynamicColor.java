package com.materialkolor.dynamiccolor;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.materialkolor.scheme.DynamicScheme;
import java.util.HashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DynamicColor {
    public final Function1 background;
    public final Function1 chromaMultiplier;
    public final Function1 contrastCurve;
    public final HashMap hctCache;
    public final boolean isBackground;
    public final String name;
    public final Function1 opacity;
    public final Function1 palette;
    public final Function1 secondBackground;
    public final Function1 tone;
    public final Function1 toneDeltaPair;

    public DynamicColor(String str, Function1 function1, Function1 function2, boolean z, Function1 function3, Function1 function4, Function1 function5, Function1 function6, Function1 function7, Function1 function8) {
        str.getClass();
        function1.getClass();
        this.name = str;
        this.palette = function1;
        this.tone = function2;
        this.isBackground = z;
        this.chromaMultiplier = function3;
        this.background = function4;
        this.secondBackground = function5;
        this.contrastCurve = function6;
        this.toneDeltaPair = function7;
        this.opacity = function8;
        this.hctCache = new HashMap();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DynamicColor)) {
            return false;
        }
        DynamicColor dynamicColor = (DynamicColor) obj;
        return Intrinsics.areEqual(this.name, dynamicColor.name) && Intrinsics.areEqual(this.palette, dynamicColor.palette) && this.tone.equals(dynamicColor.tone) && this.isBackground == dynamicColor.isBackground && Intrinsics.areEqual(this.chromaMultiplier, dynamicColor.chromaMultiplier) && Intrinsics.areEqual(this.background, dynamicColor.background) && Intrinsics.areEqual(this.secondBackground, dynamicColor.secondBackground) && Intrinsics.areEqual(this.contrastCurve, dynamicColor.contrastCurve) && Intrinsics.areEqual(this.toneDeltaPair, dynamicColor.toneDeltaPair) && Intrinsics.areEqual(this.opacity, dynamicColor.opacity);
    }

    public final double getTone(DynamicScheme dynamicScheme) {
        dynamicScheme.getClass();
        return (dynamicScheme.specVersion == ColorSpec$SpecVersion.SPEC_2025 ? ColorSpecs.SPEC_2025 : ColorSpecs.SPEC_2021).getTone(this, dynamicScheme);
    }

    public final int hashCode() {
        int iM = IntIntPair$$ExternalSyntheticOutline0.m((this.tone.hashCode() + ((this.palette.hashCode() + (this.name.hashCode() * 31)) * 31)) * 31, this.isBackground, 31);
        Function1 function1 = this.chromaMultiplier;
        int iHashCode = (iM + (function1 == null ? 0 : function1.hashCode())) * 31;
        Function1 function2 = this.background;
        int iHashCode2 = (iHashCode + (function2 == null ? 0 : function2.hashCode())) * 31;
        Function1 function3 = this.secondBackground;
        int iHashCode3 = (iHashCode2 + (function3 == null ? 0 : function3.hashCode())) * 31;
        Function1 function4 = this.contrastCurve;
        int iHashCode4 = (iHashCode3 + (function4 == null ? 0 : function4.hashCode())) * 31;
        Function1 function5 = this.toneDeltaPair;
        int iHashCode5 = (iHashCode4 + (function5 == null ? 0 : function5.hashCode())) * 31;
        Function1 function6 = this.opacity;
        return iHashCode5 + (function6 != null ? function6.hashCode() : 0);
    }

    public final DynamicColor$Companion$Builder toBuilder() {
        DynamicColor$Companion$Builder dynamicColor$Companion$Builder = new DynamicColor$Companion$Builder();
        String str = this.name;
        str.getClass();
        dynamicColor$Companion$Builder.name = str;
        Function1 function1 = this.palette;
        function1.getClass();
        dynamicColor$Companion$Builder.palette = function1;
        dynamicColor$Companion$Builder.tone = this.tone;
        dynamicColor$Companion$Builder.isBackground = this.isBackground;
        dynamicColor$Companion$Builder.chromaMultiplier = this.chromaMultiplier;
        dynamicColor$Companion$Builder.background = this.background;
        dynamicColor$Companion$Builder.secondBackground = this.secondBackground;
        dynamicColor$Companion$Builder.contrastCurve = this.contrastCurve;
        dynamicColor$Companion$Builder.toneDeltaPair = this.toneDeltaPair;
        dynamicColor$Companion$Builder.opacity = this.opacity;
        return dynamicColor$Companion$Builder;
    }

    public final String toString() {
        return "DynamicColor(name=" + this.name + ", palette=" + this.palette + ", tone=" + this.tone + ", isBackground=" + this.isBackground + ", chromaMultiplier=" + this.chromaMultiplier + ", background=" + this.background + ", secondBackground=" + this.secondBackground + ", contrastCurve=" + this.contrastCurve + ", toneDeltaPair=" + this.toneDeltaPair + ", opacity=" + this.opacity + ")";
    }
}
