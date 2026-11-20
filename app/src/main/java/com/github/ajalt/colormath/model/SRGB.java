package com.github.ajalt.colormath.model;

import com.github.ajalt.colormath.WhitePoint;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SRGB implements RGBColorSpace {
    public static final SRGB INSTANCE = new SRGB();
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

    public final String toString() {
        return "sRGB";
    }
}
