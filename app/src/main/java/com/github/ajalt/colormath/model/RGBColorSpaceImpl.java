package com.github.ajalt.colormath.model;

import com.github.ajalt.colormath.WhitePoint;
import com.github.ajalt.colormath.internal.ColorSpaceUtilsKt;
import java.util.Arrays;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RGBColorSpaceImpl implements RGBColorSpace {
    public final xyY b;
    public final Function2 convertImpl;
    public final xyY g;
    public final float[] matrixFromXyz;
    public final float[] matrixToXyz;
    public final String name;
    public final xyY r;
    public final RGBColorSpace.TransferFunctions transferFunctions;
    public final WhitePoint whitePoint;

    public RGBColorSpaceImpl(String str, WhitePoint whitePoint, RGBColorSpace.TransferFunctions transferFunctions, xyY xyy, xyY xyy2, xyY xyy3, Function2 function2) {
        whitePoint.getClass();
        xyy.getClass();
        xyy2.getClass();
        xyy3.getClass();
        this.name = str;
        this.whitePoint = whitePoint;
        this.transferFunctions = transferFunctions;
        this.r = xyy;
        this.g = xyy2;
        this.b = xyy3;
        this.convertImpl = function2;
        ColorSpaceUtilsKt.zeroOneComponentInfo("RGB");
        xyY xyy4 = RGBColorSpacesKt.SRGB_R;
        float f = xyy.x;
        float f2 = xyy2.x;
        float f3 = xyy3.x;
        float f4 = xyy.y;
        float f5 = xyy2.y;
        float f6 = xyy3.y;
        float[] fArr = {f, f2, f3, f4, f5, f6, (1.0f - f) - f4, (1.0f - f2) - f5, (1.0f - f3) - f6};
        xyY xyy5 = whitePoint.chromaticity;
        float[] fArrM1878inverseM2Qqt3Q$default = MathKt.m1878inverseM2Qqt3Q$default(fArr);
        float f7 = xyy5.x;
        float f8 = xyy5.Y;
        float f9 = (f7 * f8) / xyy5.y;
        float absoluteZ = xyy5.getAbsoluteZ();
        float[] fArrM1875dotDiagonalCue6Qto = MathKt.m1875dotDiagonalCue6Qto((fArrM1878inverseM2Qqt3Q$default[2] * absoluteZ) + (fArrM1878inverseM2Qqt3Q$default[1] * f8) + (fArrM1878inverseM2Qqt3Q$default[0] * f9), (fArrM1878inverseM2Qqt3Q$default[5] * absoluteZ) + (fArrM1878inverseM2Qqt3Q$default[4] * f8) + (fArrM1878inverseM2Qqt3Q$default[3] * f9), (fArrM1878inverseM2Qqt3Q$default[8] * absoluteZ) + (fArrM1878inverseM2Qqt3Q$default[7] * f8) + (fArrM1878inverseM2Qqt3Q$default[6] * f9), fArr);
        this.matrixToXyz = fArrM1875dotDiagonalCue6Qto;
        this.matrixFromXyz = MathKt.m1878inverseM2Qqt3Q$default(fArrM1875dotDiagonalCue6Qto);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RGBColorSpace)) {
            return false;
        }
        RGBColorSpace rGBColorSpace = (RGBColorSpace) obj;
        if (!this.name.equals(rGBColorSpace.getName()) || !Intrinsics.areEqual(this.whitePoint, rGBColorSpace.getWhitePoint()) || !this.transferFunctions.equals(rGBColorSpace.getTransferFunctions())) {
            return false;
        }
        if (!(obj instanceof RGBColorSpaceImpl)) {
            return Arrays.equals(this.matrixToXyz, rGBColorSpace.getMatrixToXyz()) && Arrays.equals(this.matrixFromXyz, rGBColorSpace.getMatrixFromXyz());
        }
        RGBColorSpaceImpl rGBColorSpaceImpl = (RGBColorSpaceImpl) obj;
        return Intrinsics.areEqual(this.r, rGBColorSpaceImpl.r) && Intrinsics.areEqual(this.g, rGBColorSpaceImpl.g) && Intrinsics.areEqual(this.b, rGBColorSpaceImpl.b);
    }

    @Override // com.github.ajalt.colormath.model.RGBColorSpace
    public final float[] getMatrixFromXyz() {
        return this.matrixFromXyz;
    }

    @Override // com.github.ajalt.colormath.model.RGBColorSpace
    public final float[] getMatrixToXyz() {
        return this.matrixToXyz;
    }

    @Override // com.github.ajalt.colormath.ColorSpace
    public final String getName() {
        return this.name;
    }

    @Override // com.github.ajalt.colormath.model.RGBColorSpace
    public final RGBColorSpace.TransferFunctions getTransferFunctions() {
        return this.transferFunctions;
    }

    @Override // com.github.ajalt.colormath.WhitePointColorSpace
    public final WhitePoint getWhitePoint() {
        return this.whitePoint;
    }

    public final int hashCode() {
        return this.b.hashCode() + ((this.g.hashCode() + ((this.r.hashCode() + ((this.transferFunctions.hashCode() + ((this.whitePoint.hashCode() + (this.name.hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
    }

    @Override // com.github.ajalt.colormath.model.RGBColorSpace
    public final RGB invoke(float f, float f2, float f3, float f4) {
        return new RGB(f, f2, f3, f4, this);
    }

    public final String toString() {
        return this.name;
    }
}
