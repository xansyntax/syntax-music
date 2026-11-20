package com.github.ajalt.colormath.model;

import kotlin.math.Constants;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ACEScctTransferFunctions implements RGBColorSpace.TransferFunctions {
    public static final ACEScctTransferFunctions INSTANCE = new ACEScctTransferFunctions();
    public static final double eotfC2 = ((Math.log(65504.0d) / Constants.LN2) + 9.72d) / 17.52d;

    @Override // com.github.ajalt.colormath.model.RGBColorSpace.TransferFunctions
    public final float eotf(float f) {
        double dPow;
        double d = f;
        if (d <= 0.155251141552511d) {
            dPow = (d - 0.0729055341958355d) / 10.5402377416545d;
        } else {
            dPow = d < eotfC2 ? Math.pow(2.0d, (d * 17.52d) - 9.72d) : 65504.0d;
        }
        return (float) dPow;
    }

    @Override // com.github.ajalt.colormath.model.RGBColorSpace.TransferFunctions
    public final float oetf(float f) {
        double d = f;
        return (float) (d < 0.0078125d ? (d * 10.5402377416545d) + 0.0729055341958355d : (((double) ((float) (Math.log(d) / Constants.LN2))) + 9.72d) / 17.52d);
    }
}
