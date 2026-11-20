package com.github.ajalt.colormath.model;

import com.github.ajalt.colormath.WhitePoint;
import com.github.ajalt.colormath.WhitePointColorSpace;
import com.github.ajalt.colormath.internal.ColorSpaceUtilsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class XYZColorSpaceImpl implements WhitePointColorSpace {
    public final WhitePoint whitePoint;

    public XYZColorSpaceImpl(WhitePoint whitePoint) {
        whitePoint.getClass();
        this.whitePoint = whitePoint;
        ColorSpaceUtilsKt.zeroOneComponentInfo("XYZ");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof XYZColorSpaceImpl) {
            return Intrinsics.areEqual(this.whitePoint, ((XYZColorSpaceImpl) obj).whitePoint);
        }
        return false;
    }

    @Override // com.github.ajalt.colormath.WhitePointColorSpace
    public final WhitePoint getWhitePoint() {
        throw null;
    }

    public final int hashCode() {
        return this.whitePoint.hashCode();
    }

    public final XYZ invoke(Number number, Number number2, Number number3, Number number4) {
        return new XYZ(number.floatValue(), number2.floatValue(), number3.floatValue(), number4.floatValue(), this);
    }

    public final String toString() {
        return "XYZColorSpace(" + this.whitePoint + ')';
    }
}
