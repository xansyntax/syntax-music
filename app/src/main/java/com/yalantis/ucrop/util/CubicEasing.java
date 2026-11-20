package com.yalantis.ucrop.util;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CubicEasing {
    public static float easeIn(float f, float f2, float f3, float f4) {
        float f5 = f / f4;
        return (f3 * f5 * f5 * f5) + f2;
    }

    public static float easeInOut(float f, float f2, float f3, float f4) {
        float f5 = f / (f4 / 2.0f);
        float f6 = f3 / 2.0f;
        if (f5 < 1.0f) {
            return (f6 * f5 * f5 * f5) + f2;
        }
        float f7 = f5 - 2.0f;
        return (((f7 * f7 * f7) + 2.0f) * f6) + f2;
    }

    public static float easeOut(float f, float f2, float f3, float f4) {
        float f5 = (f / f4) - 1.0f;
        return (((f5 * f5 * f5) + 1.0f) * f3) + f2;
    }
}
