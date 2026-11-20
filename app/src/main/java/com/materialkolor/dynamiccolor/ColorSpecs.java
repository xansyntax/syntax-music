package com.materialkolor.dynamiccolor;

import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ColorSpecs {
    public static final ColorSpec2021 SPEC_2021 = new ColorSpec2021();
    public static final ColorSpec2025 SPEC_2025 = new ColorSpec2025();

    /* JADX WARN: Code duplicated, block: B:26:0x0054 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x0055 A[RETURN] */
    public static double foregroundTone(double d, double d2) {
        double dLighter = HexFormatKt.lighter(d, d2);
        if (dLighter < 0.0d) {
            dLighter = 100.0d;
        }
        double dMax = Math.max(0.0d, HexFormatKt.darker(d, d2));
        double dRatioOfTones = HexFormatKt.ratioOfTones(dLighter, d);
        double dRatioOfTones2 = HexFormatKt.ratioOfTones(dMax, d);
        if (Math.rint(d) >= 60.0d) {
            if (dRatioOfTones2 >= d2 || dRatioOfTones2 >= dRatioOfTones) {
                return dMax;
            }
            return dLighter;
        }
        boolean z = Math.abs(dRatioOfTones - dRatioOfTones2) < 0.1d && dRatioOfTones < d2 && dRatioOfTones2 < d2;
        if (dRatioOfTones >= d2 || dRatioOfTones >= dRatioOfTones2 || z) {
            return dLighter;
        }
        return dMax;
    }
}
