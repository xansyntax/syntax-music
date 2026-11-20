package com.github.ajalt.colormath.internal;

import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ConstantsKt {
    public static final float[] CAT02_LMS_TO_XYZ;
    public static final float[] CAT02_XYZ_TO_LMS;

    static {
        float[] fArr = {0.7328f, 0.4296f, -0.1624f, -0.7036f, 1.6975f, 0.0061f, 0.003f, 0.0136f, 0.9834f};
        CAT02_XYZ_TO_LMS = fArr;
        CAT02_LMS_TO_XYZ = MathKt.m1878inverseM2Qqt3Q$default(fArr);
    }
}
