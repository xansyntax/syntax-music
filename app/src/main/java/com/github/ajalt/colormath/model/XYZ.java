package com.github.ajalt.colormath.model;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import coil3.util.FileSystemsKt;
import com.github.ajalt.colormath.Color;
import com.github.ajalt.colormath.WhitePoint;
import com.github.ajalt.colormath.internal.ConstantsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class XYZ implements Color {
    public final float alpha;
    public final XYZColorSpaceImpl space;
    public final float x;
    public final float y;
    public final float z;

    static {
        XYZColorSpaceImpl xYZColorSpaceImpl = XYZColorSpaces.XYZ65;
        XYZColorSpaceImpl xYZColorSpaceImpl2 = XYZColorSpaces.XYZ65;
    }

    public XYZ(float f, float f2, float f3, float f4, XYZColorSpaceImpl xYZColorSpaceImpl) {
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.alpha = f4;
        this.space = xYZColorSpaceImpl;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XYZ)) {
            return false;
        }
        XYZ xyz = (XYZ) obj;
        return Float.compare(this.x, xyz.x) == 0 && Float.compare(this.y, xyz.y) == 0 && Float.compare(this.z, xyz.z) == 0 && Float.compare(this.alpha, xyz.alpha) == 0 && this.space.equals(xyz.space);
    }

    public final int hashCode() {
        return this.space.whitePoint.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.alpha, IntIntPair$$ExternalSyntheticOutline0.m(this.z, IntIntPair$$ExternalSyntheticOutline0.m(this.y, Float.hashCode(this.x) * 31, 31), 31), 31);
    }

    @Override // com.github.ajalt.colormath.Color
    public final HSL toHSL() {
        return toRGB(RGBColorSpaces.SRGB).toHSL();
    }

    public final RGB toRGB(RGBColorSpace rGBColorSpace) {
        char c;
        char c2;
        XYZ xyz;
        char c3;
        rGBColorSpace.getClass();
        XYZColorSpaceImpl xYZColorSpaceImplXYZColorSpace = FileSystemsKt.XYZColorSpace(rGBColorSpace.getWhitePoint());
        xYZColorSpaceImplXYZColorSpace.getClass();
        float[] fArr = ConstantsKt.CAT02_XYZ_TO_LMS;
        float[] fArr2 = ConstantsKt.CAT02_LMS_TO_XYZ;
        WhitePoint whitePoint = xYZColorSpaceImplXYZColorSpace.whitePoint;
        WhitePoint whitePoint2 = this.space.whitePoint;
        if (Intrinsics.areEqual(whitePoint, whitePoint2)) {
            xyz = this;
            c3 = 0;
            c = '\b';
            c2 = 7;
        } else {
            xyY xyy = whitePoint2.chromaticity;
            fArr2.getClass();
            xyY xyy2 = whitePoint.chromaticity;
            float f = xyy.x;
            c = '\b';
            float f2 = xyy.Y;
            c2 = 7;
            float[] fArrM1874dotCue6Qto = MathKt.m1874dotCue6Qto((f * f2) / xyy.y, f2, xyy.getAbsoluteZ(), fArr);
            float f3 = xyy2.x;
            float f4 = xyy2.Y;
            float[] fArrM1874dotCue6Qto2 = MathKt.m1874dotCue6Qto((f3 * f4) / xyy2.y, f4, xyy2.getAbsoluteZ(), fArr);
            float[] fArrM1875dotDiagonalCue6Qto = MathKt.m1875dotDiagonalCue6Qto(fArrM1874dotCue6Qto2[0] / fArrM1874dotCue6Qto[0], fArrM1874dotCue6Qto2[1] / fArrM1874dotCue6Qto[1], fArrM1874dotCue6Qto2[2] / fArrM1874dotCue6Qto[2], fArr2);
            float[] fArr3 = {MathKt.dot_sRJ3GRI$f(0, 0, fArrM1875dotDiagonalCue6Qto, fArr), MathKt.dot_sRJ3GRI$f(1, 0, fArrM1875dotDiagonalCue6Qto, fArr), MathKt.dot_sRJ3GRI$f(2, 0, fArrM1875dotDiagonalCue6Qto, fArr), MathKt.dot_sRJ3GRI$f(0, 1, fArrM1875dotDiagonalCue6Qto, fArr), MathKt.dot_sRJ3GRI$f(1, 1, fArrM1875dotDiagonalCue6Qto, fArr), MathKt.dot_sRJ3GRI$f(2, 1, fArrM1875dotDiagonalCue6Qto, fArr), MathKt.dot_sRJ3GRI$f(0, 2, fArrM1875dotDiagonalCue6Qto, fArr), MathKt.dot_sRJ3GRI$f(1, 2, fArrM1875dotDiagonalCue6Qto, fArr), MathKt.dot_sRJ3GRI$f(2, 2, fArrM1875dotDiagonalCue6Qto, fArr)};
            float f5 = fArr3[0];
            float f6 = this.x;
            float f7 = fArr3[1];
            float f8 = this.y;
            float f9 = (f7 * f8) + (f5 * f6);
            float f10 = fArr3[2];
            float f11 = this.z;
            c3 = 0;
            xyz = new XYZ((f10 * f11) + f9, (fArr3[5] * f11) + (fArr3[4] * f8) + (fArr3[3] * f6), (fArr3[8] * f11) + (fArr3[7] * f8) + (fArr3[6] * f6), this.alpha, xYZColorSpaceImplXYZColorSpace);
        }
        RGBColorSpace.TransferFunctions transferFunctions = rGBColorSpace.getTransferFunctions();
        float[] matrixFromXyz = rGBColorSpace.getMatrixFromXyz();
        matrixFromXyz.getClass();
        float f12 = matrixFromXyz[c3];
        float f13 = xyz.x;
        float f14 = matrixFromXyz[1];
        float f15 = xyz.y;
        float f16 = (f14 * f15) + (f12 * f13);
        float f17 = matrixFromXyz[2];
        float f18 = xyz.z;
        return rGBColorSpace.invoke(transferFunctions.oetf((f17 * f18) + f16), transferFunctions.oetf((matrixFromXyz[5] * f18) + (matrixFromXyz[4] * f15) + (matrixFromXyz[3] * f13)), transferFunctions.oetf((matrixFromXyz[c] * f18) + (matrixFromXyz[c2] * f15) + (matrixFromXyz[6] * f13)), this.alpha);
    }

    @Override // com.github.ajalt.colormath.Color
    public final RGB toSRGB() {
        return toRGB(RGBColorSpaces.SRGB);
    }

    public final String toString() {
        return "XYZ(x=" + this.x + ", y=" + this.y + ", z=" + this.z + ", alpha=" + this.alpha + ", space=" + this.space + ')';
    }

    @Override // com.github.ajalt.colormath.Color
    public final XYZ toXYZ() {
        return this;
    }
}
