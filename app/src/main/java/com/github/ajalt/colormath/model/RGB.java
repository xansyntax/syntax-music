package com.github.ajalt.colormath.model;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import coil3.util.FileSystemsKt;
import com.github.ajalt.colormath.Color;
import com.github.ajalt.colormath.WhitePoint;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RGB implements Color {
    public static final Companion Companion = new Companion();
    public final float alpha;
    public final float b;
    public final float g;
    public final float r;
    public final RGBColorSpace space;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Companion implements RGBColorSpace {
        public final /* synthetic */ RGBColorSpaceImpl $$delegate_0 = RGBColorSpaces.SRGB;

        public final boolean equals(Object obj) {
            return Intrinsics.areEqual(RGBColorSpaces.SRGB, obj);
        }

        @Override // com.github.ajalt.colormath.model.RGBColorSpace
        public final float[] getMatrixFromXyz() {
            return this.$$delegate_0.matrixFromXyz;
        }

        @Override // com.github.ajalt.colormath.model.RGBColorSpace
        public final float[] getMatrixToXyz() {
            return this.$$delegate_0.matrixToXyz;
        }

        @Override // com.github.ajalt.colormath.ColorSpace
        public final String getName() {
            return this.$$delegate_0.name;
        }

        @Override // com.github.ajalt.colormath.model.RGBColorSpace
        public final RGBColorSpace.TransferFunctions getTransferFunctions() {
            return this.$$delegate_0.transferFunctions;
        }

        @Override // com.github.ajalt.colormath.WhitePointColorSpace
        public final WhitePoint getWhitePoint() {
            return this.$$delegate_0.whitePoint;
        }

        public final int hashCode() {
            return RGBColorSpaces.SRGB.hashCode();
        }

        @Override // com.github.ajalt.colormath.model.RGBColorSpace
        public final RGB invoke(float f, float f2, float f3, float f4) {
            RGBColorSpaceImpl rGBColorSpaceImpl = this.$$delegate_0;
            rGBColorSpaceImpl.getClass();
            return new RGB(f, f2, f3, f4, rGBColorSpaceImpl);
        }
    }

    public RGB(float f, float f2, float f3, float f4, RGBColorSpace rGBColorSpace) {
        rGBColorSpace.getClass();
        this.r = f;
        this.g = f2;
        this.b = f3;
        this.alpha = f4;
        this.space = rGBColorSpace;
    }

    public final RGB convertTo(RGBColorSpace rGBColorSpace) {
        rGBColorSpace.getClass();
        SRGB srgb = SRGB.INSTANCE;
        RGBColorSpace.TransferFunctions transferFunctions = srgb.$$delegate_0.transferFunctions;
        RGBColorSpace rGBColorSpace2 = this.space;
        if (Intrinsics.areEqual(rGBColorSpace2, rGBColorSpace)) {
            return this;
        }
        boolean zAreEqual = Intrinsics.areEqual(rGBColorSpace2, srgb);
        float f = this.alpha;
        float f2 = this.b;
        float f3 = this.g;
        float f4 = this.r;
        if (zAreEqual && rGBColorSpace.equals(RGBColorSpaces.LinearSRGB)) {
            return rGBColorSpace.invoke(transferFunctions.eotf(f4), transferFunctions.eotf(f3), transferFunctions.eotf(f2), f);
        }
        return (Intrinsics.areEqual(rGBColorSpace2, RGBColorSpaces.LinearSRGB) && rGBColorSpace.equals(srgb)) ? rGBColorSpace.invoke(transferFunctions.oetf(f4), transferFunctions.oetf(f3), transferFunctions.oetf(f2), f) : toXYZ().toRGB(rGBColorSpace);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RGB)) {
            return false;
        }
        RGB rgb = (RGB) obj;
        return Float.compare(this.r, rgb.r) == 0 && Float.compare(this.g, rgb.g) == 0 && Float.compare(this.b, rgb.b) == 0 && Float.compare(this.alpha, rgb.alpha) == 0 && Intrinsics.areEqual(this.space, rgb.space);
    }

    public final int hashCode() {
        return this.space.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.alpha, IntIntPair$$ExternalSyntheticOutline0.m(this.b, IntIntPair$$ExternalSyntheticOutline0.m(this.g, Float.hashCode(this.r) * 31, 31), 31), 31);
    }

    @Override // com.github.ajalt.colormath.Color
    public final HSL toHSL() {
        double d;
        RGB rgbConvertTo = convertTo(SRGB.INSTANCE);
        double d2 = rgbConvertTo.r;
        double d3 = rgbConvertTo.g;
        double d4 = rgbConvertTo.b;
        double dMin = Math.min(d2, Math.min(d3, d4));
        double dMax = Math.max(d2, Math.max(d3, d4));
        double d5 = dMax - dMin;
        double d6 = 0.0d;
        if (d5 < 1.0E-7d) {
            d = Double.NaN;
        } else if (d2 == dMax) {
            d = (d3 - d4) / d5;
        } else if (d3 == dMax) {
            d = ((d4 - d2) / d5) + 2.0d;
        } else {
            d = d4 == dMax ? ((d2 - d3) / d5) + 4.0d : 0.0d;
        }
        double d7 = (((d * 60.0d) % 360.0d) + 360.0d) % 360.0d;
        double d8 = dMin + dMax;
        double d9 = d8 / 2.0d;
        if (dMax != dMin) {
            d6 = d9 <= 0.5d ? d5 / d8 : d5 / ((2.0d - dMax) - dMin);
        }
        return new HSL((float) d7, (float) d6, (float) d9, this.alpha);
    }

    @Override // com.github.ajalt.colormath.Color
    public final RGB toSRGB() {
        return convertTo(RGBColorSpaces.SRGB);
    }

    public final String toString() {
        return "RGB(r=" + this.r + ", g=" + this.g + ", b=" + this.b + ", alpha=" + this.alpha + ", space=" + this.space + ')';
    }

    @Override // com.github.ajalt.colormath.Color
    public final XYZ toXYZ() {
        RGBColorSpace rGBColorSpace = this.space;
        RGBColorSpace.TransferFunctions transferFunctions = rGBColorSpace.getTransferFunctions();
        float[] matrixToXyz = rGBColorSpace.getMatrixToXyz();
        matrixToXyz.getClass();
        float fEotf = transferFunctions.eotf(this.r);
        float fEotf2 = transferFunctions.eotf(this.g);
        float fEotf3 = transferFunctions.eotf(this.b);
        float f = (matrixToXyz[2] * fEotf3) + (matrixToXyz[1] * fEotf2) + (matrixToXyz[0] * fEotf);
        float f2 = (matrixToXyz[5] * fEotf3) + (matrixToXyz[4] * fEotf2) + (matrixToXyz[3] * fEotf);
        float f3 = (matrixToXyz[8] * fEotf3) + (matrixToXyz[7] * fEotf2) + (matrixToXyz[6] * fEotf);
        XYZColorSpaceImpl xYZColorSpaceImplXYZColorSpace = FileSystemsKt.XYZColorSpace(rGBColorSpace.getWhitePoint());
        xYZColorSpaceImplXYZColorSpace.getClass();
        return new XYZ(f, f2, f3, this.alpha, xYZColorSpaceImplXYZColorSpace);
    }
}
