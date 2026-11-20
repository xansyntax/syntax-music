package com.github.ajalt.colormath.model;

import com.google.common.math.IntMath;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BT709TransferFunctions implements RGBColorSpace.TransferFunctions {
    public static final BT709TransferFunctions INSTANCE = new BT709TransferFunctions();
    public static final double eotfC = (IntMath.spow(0.018d, 0.45d) * 1.099d) - 0.099d;

    @Override // com.github.ajalt.colormath.model.RGBColorSpace.TransferFunctions
    public final float eotf(float f) {
        double d = f;
        return (d < eotfC ? Float.valueOf(f / 4.5f) : Double.valueOf(IntMath.spow((d + 0.099d) / 1.099d, 2.2222222222222223d))).floatValue();
    }

    @Override // com.github.ajalt.colormath.model.RGBColorSpace.TransferFunctions
    public final float oetf(float f) {
        double d = f;
        return (float) (d < 0.018d ? d * 4.5d : (IntMath.spow(d, 0.45d) * 1.099d) - 0.099d);
    }
}
