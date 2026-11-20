package com.github.ajalt.colormath.model;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import coil3.util.FileSystemsKt;
import com.github.ajalt.colormath.Color;
import com.github.ajalt.colormath.WhitePoint;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LAB implements Color {
    public final float a;
    public final float alpha;
    public final float b;
    public final float l;
    public final LABColorSpaceImpl space;

    static {
        LABColorSpaceImpl lABColorSpaceImpl = LABColorSpaces.LAB50;
        LABColorSpaceImpl lABColorSpaceImpl2 = LABColorSpaces.LAB50;
    }

    public LAB(float f, float f2, float f3, float f4, LABColorSpaceImpl lABColorSpaceImpl) {
        this.l = f;
        this.a = f2;
        this.b = f3;
        this.alpha = f4;
        this.space = lABColorSpaceImpl;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LAB)) {
            return false;
        }
        LAB lab = (LAB) obj;
        return Float.compare(this.l, lab.l) == 0 && Float.compare(this.a, lab.a) == 0 && Float.compare(this.b, lab.b) == 0 && Float.compare(this.alpha, lab.alpha) == 0 && this.space.equals(lab.space);
    }

    public final int hashCode() {
        return this.space.whitePoint.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.alpha, IntIntPair$$ExternalSyntheticOutline0.m(this.b, IntIntPair$$ExternalSyntheticOutline0.m(this.a, Float.hashCode(this.l) * 31, 31), 31), 31);
    }

    @Override // com.github.ajalt.colormath.Color
    public final HSL toHSL() {
        return toSRGB().toHSL();
    }

    @Override // com.github.ajalt.colormath.Color
    public final RGB toSRGB() {
        return this.l == CropImageView.DEFAULT_ASPECT_RATIO ? RGB.Companion.invoke(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, this.alpha) : toXYZ().toRGB(RGBColorSpaces.SRGB);
    }

    public final String toString() {
        return "LAB(l=" + this.l + ", a=" + this.a + ", b=" + this.b + ", alpha=" + this.alpha + ", space=" + this.space + ')';
    }

    @Override // com.github.ajalt.colormath.Color
    public final XYZ toXYZ() {
        Double dValueOf = Double.valueOf(0.0d);
        WhitePoint whitePoint = this.space.whitePoint;
        XYZColorSpaceImpl xYZColorSpaceImplXYZColorSpace = FileSystemsKt.XYZColorSpace(whitePoint);
        float f = this.l;
        if (f == CropImageView.DEFAULT_ASPECT_RATIO) {
            return xYZColorSpaceImplXYZColorSpace.invoke(dValueOf, dValueOf, dValueOf, Float.valueOf(1.0f));
        }
        double d = ((double) (16.0f + f)) / 116.0d;
        double d2 = d - (((double) this.b) / 200.0d);
        double d3 = (((double) this.a) / 500.0d) + d;
        double d4 = f;
        double dPow = d4 > 8.0d ? Math.pow(d, 3.0d) : d4 / 903.2962962962963d;
        double dPow2 = Math.pow(d2, 3.0d);
        if (dPow2 <= 0.008856451679035631d) {
            dPow2 = ((d2 * 116.0d) - 16.0d) / 903.2962962962963d;
        }
        double dPow3 = Math.pow(d3, 3.0d);
        if (dPow3 <= 0.008856451679035631d) {
            dPow3 = ((116.0d * d3) - 16.0d) / 903.2962962962963d;
        }
        xyY xyy = whitePoint.chromaticity;
        float f2 = xyy.Y;
        return xYZColorSpaceImplXYZColorSpace.invoke(Double.valueOf(dPow3 * ((double) ((xyy.x * f2) / xyy.y))), Double.valueOf(dPow * ((double) f2)), Double.valueOf(dPow2 * ((double) xyy.getAbsoluteZ())), Float.valueOf(this.alpha));
    }
}
