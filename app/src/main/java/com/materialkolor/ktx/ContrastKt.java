package com.materialkolor.ktx;

import com.materialkolor.hct.Hct;
import com.materialkolor.utils.MathUtils;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0007\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0004\u001a#\u0010\r\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/graphics/Color;", "other", "", "contrastRatio--OWjLjI", "(JJ)D", "contrastRatio", "tonalContrastRatio--OWjLjI", "tonalContrastRatio", "Lcom/materialkolor/ktx/ContrastThreshold;", "threshold", "", "hasEnoughContrast-jxsXWHM", "(JJLcom/materialkolor/ktx/ContrastThreshold;)Z", "hasEnoughContrast", "MaterialKolor:material-kolor"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class ContrastKt {
    /* JADX INFO: renamed from: contrastRatio--OWjLjI, reason: not valid java name */
    public static final double m954contrastRatioOWjLjI(long j, long j2) {
        double[] dArrXyzFromArgb = MathUtils.xyzFromArgb(androidx.compose.ui.graphics.ColorKt.m498toArgb8_81llA(j));
        double[] dArrXyzFromArgb2 = MathUtils.xyzFromArgb(androidx.compose.ui.graphics.ColorKt.m498toArgb8_81llA(j2));
        double d = dArrXyzFromArgb[1];
        double d2 = dArrXyzFromArgb2[1];
        double dMax = Math.max(d, d2);
        if (dMax != d2) {
            d = d2;
        }
        return (dMax + 5.0d) / (d + 5.0d);
    }

    /* JADX INFO: renamed from: hasEnoughContrast-jxsXWHM, reason: not valid java name */
    public static final boolean m955hasEnoughContrastjxsXWHM(long j, long j2, ContrastThreshold contrastThreshold) {
        contrastThreshold.getClass();
        return Double.compare(m954contrastRatioOWjLjI(j, j2), contrastThreshold.threshold) >= 0;
    }

    /* JADX INFO: renamed from: hasEnoughContrast-jxsXWHM$default, reason: not valid java name */
    public static /* synthetic */ boolean m956hasEnoughContrastjxsXWHM$default(long j, long j2, ContrastThreshold contrastThreshold, int i, Object obj) {
        if ((i & 2) != 0) {
            contrastThreshold = ContrastThreshold.WCAG_AA_NORMAL_TEXT;
        }
        return m955hasEnoughContrastjxsXWHM(j, j2, contrastThreshold);
    }

    /* JADX INFO: renamed from: tonalContrastRatio--OWjLjI, reason: not valid java name */
    public static final double m957tonalContrastRatioOWjLjI(long j, long j2) {
        Hct hctM973toHct8_81llA = HctKt.m973toHct8_81llA(j);
        Hct hctM973toHct8_81llA2 = HctKt.m973toHct8_81llA(j2);
        double d = hctM973toHct8_81llA.tone;
        double d2 = hctM973toHct8_81llA2.tone;
        double dYFromLstar = MathUtils.yFromLstar(d);
        double dYFromLstar2 = MathUtils.yFromLstar(d2);
        double dMax = Math.max(dYFromLstar, dYFromLstar2);
        if (dMax != dYFromLstar2) {
            dYFromLstar = dYFromLstar2;
        }
        return (dMax + 5.0d) / (dYFromLstar + 5.0d);
    }
}
