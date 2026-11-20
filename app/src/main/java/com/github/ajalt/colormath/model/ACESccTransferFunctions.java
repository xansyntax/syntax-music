package com.github.ajalt.colormath.model;

import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.math.Constants;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ACESccTransferFunctions implements RGBColorSpace.TransferFunctions {
    public static final ACESccTransferFunctions INSTANCE = new ACESccTransferFunctions();
    public static final double eotfC2 = ((Math.log(65504.0d) / Constants.LN2) + 9.72d) / 17.52d;

    @Override // com.github.ajalt.colormath.model.RGBColorSpace.TransferFunctions
    public final float eotf(float f) {
        double dPow;
        double d = f;
        if (d <= -0.3013698630136986d) {
            dPow = (IntMath.spow(2.0d, (d * 17.52d) - 9.72d) - 1.52587890625E-5d) * 2.0d;
        } else {
            dPow = d < eotfC2 ? Math.pow(2.0d, (d * 17.52d) - 9.72d) : 65504.0d;
        }
        return (float) dPow;
    }

    @Override // com.github.ajalt.colormath.model.RGBColorSpace.TransferFunctions
    public final float oetf(float f) {
        double dLog;
        double d = f;
        if (d < 3.0517578125E-5d) {
            if (f < CropImageView.DEFAULT_ASPECT_RATIO) {
                f = 0.0f;
            }
            dLog = Math.log((((double) f) / 2.0d) + 1.52587890625E-5d) / Constants.LN2;
        } else {
            dLog = (float) (Math.log(d) / Constants.LN2);
        }
        return (float) ((dLog + 9.72d) / 17.52d);
    }
}
