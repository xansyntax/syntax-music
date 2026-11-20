package com.materialkolor.blend;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.materialkolor.hct.Cam16;
import com.materialkolor.hct.HctSolver;
import com.materialkolor.hct.ViewingConditions;
import com.materialkolor.utils.MathUtils;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Blend {
    public static final Blend INSTANCE = new Blend();

    public static int cam16Ucs(double d, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        Cam16 cam16FromInt = HctSolver.fromInt(i);
        Cam16 cam16FromInt2 = HctSolver.fromInt(i2);
        double d2 = 1.0d - d;
        double d3 = (cam16FromInt2.jstar * d) + (cam16FromInt.jstar * d2);
        double d4 = (cam16FromInt2.astar * d) + (cam16FromInt.astar * d2);
        double d5 = (cam16FromInt2.bstar * d) + (d2 * cam16FromInt.bstar);
        ViewingConditions viewingConditions = ViewingConditions.DEFAULT;
        viewingConditions.getClass();
        double d6 = viewingConditions.aw;
        double d7 = viewingConditions.c;
        double dExpm1 = Math.expm1(Math.hypot(d4, d5) * 0.0228d) / 0.0228d;
        double d8 = viewingConditions.flRoot;
        double d9 = dExpm1 / d8;
        double dAtan2 = Math.atan2(d5, d4) * 57.29577951308232d;
        if (dAtan2 < 0.0d) {
            dAtan2 += 360.0d;
        }
        double d10 = d3 / (1.0d - ((d3 - 100.0d) * 0.007d));
        double d11 = d10 / 100.0d;
        Math.sqrt(d11);
        Math.sqrt(((d9 / Math.sqrt(d11)) * d7) / (d6 + 4.0d));
        double d12 = dAtan2 * 0.017453292519943295d;
        Math.log1p(d8 * d9 * 0.0228d);
        Math.cos(d12);
        Math.sin(d12);
        double d13 = viewingConditions.fl;
        double dPow = Math.pow(((d9 == 0.0d || d10 == 0.0d) ? 0.0d : d9 / Math.sqrt(d11)) / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.n), 0.73d), 1.1111111111111112d);
        double dCos = (Math.cos(d12 + 2.0d) + 3.8d) * 0.25d;
        double dPow2 = Math.pow(d11, (1.0d / d7) / viewingConditions.z) * d6;
        double d14 = dCos * 3846.153846153846d * viewingConditions.nc * viewingConditions.ncb;
        double d15 = dPow2 / viewingConditions.nbb;
        double dSin = Math.sin(d12);
        double dCos2 = Math.cos(d12);
        double d16 = (((0.305d + d15) * 23.0d) * dPow) / (((dPow * 108.0d) * dSin) + (((11.0d * dPow) * dCos2) + (d14 * 23.0d)));
        double d17 = dCos2 * d16;
        double d18 = d16 * dSin;
        double d19 = d15 * 460.0d;
        double d20 = ((288.0d * d18) + ((451.0d * d17) + d19)) / 1403.0d;
        double dM = IntIntPair$$ExternalSyntheticOutline0.m(d18, 261.0d, d19 - (891.0d * d17), 1403.0d);
        double dM2 = IntIntPair$$ExternalSyntheticOutline0.m(d18, 6300.0d, d19 - (d17 * 220.0d), 1403.0d);
        double dMax = Math.max(0.0d, (Math.abs(d20) * 27.13d) / (400.0d - Math.abs(d20)));
        if (d20 < 0.0d) {
            i3 = 1;
            i4 = -1;
        } else if (d20 == 0.0d) {
            i4 = 0;
            i3 = 1;
        } else {
            i3 = 1;
            i4 = 1;
        }
        double d21 = 100.0d / d13;
        double dPow3 = Math.pow(dMax, 2.380952380952381d) * ((double) i4) * d21;
        double dMax2 = Math.max(0.0d, (Math.abs(dM) * 27.13d) / (400.0d - Math.abs(dM)));
        if (dM < 0.0d) {
            i5 = -1;
        } else {
            i5 = dM == 0.0d ? 0 : i3;
        }
        double dPow4 = Math.pow(dMax2, 2.380952380952381d) * ((double) i5) * d21;
        double dMax3 = Math.max(0.0d, (Math.abs(dM2) * 27.13d) / (400.0d - Math.abs(dM2)));
        if (dM2 < 0.0d) {
            i6 = -1;
        } else {
            i6 = dM2 == 0.0d ? 0 : i3;
        }
        double dPow5 = Math.pow(dMax3, 2.380952380952381d) * d21 * ((double) i6);
        double[] dArr = viewingConditions.rgbD;
        double d22 = dPow3 / dArr[0];
        double d23 = dPow4 / dArr[i3];
        double d24 = dPow5 / dArr[2];
        double[][] dArr2 = Cam16.CAM16RGB_TO_XYZ;
        double[] dArr3 = dArr2[0];
        double d25 = (dArr3[2] * d24) + (dArr3[i3] * d23) + (dArr3[0] * d22);
        double[] dArr4 = dArr2[i3];
        double d26 = (dArr4[2] * d24) + (dArr4[i3] * d23) + (dArr4[0] * d22);
        double[] dArr5 = dArr2[2];
        return MathUtils.argbFromXyz(d25, d26, (d24 * dArr5[2]) + (d23 * dArr5[i3]) + (d22 * dArr5[0]));
    }
}
