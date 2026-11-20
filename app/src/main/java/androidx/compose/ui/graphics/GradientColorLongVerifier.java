package androidx.compose.ui.graphics;

import androidx.core.graphics.TypefaceCompat$$ExternalSyntheticApiModelOutline1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GradientColorLongVerifier {
    public static final GradientColorLongVerifier INSTANCE = new GradientColorLongVerifier();

    /* JADX INFO: renamed from: createLinearGradientColorLong-VjE6UOU, reason: not valid java name */
    public final android.graphics.LinearGradient m504createLinearGradientColorLongVjE6UOU(long j, long j2, long[] jArr, float[] fArr, int i) {
        return TypefaceCompat$$ExternalSyntheticApiModelOutline1.m(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)), Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)), jArr, fArr, ColorKt.m497toAndroidTileMode0vamqd0(i));
    }

    /* JADX INFO: renamed from: createRadialGradientColorLong-8uybcMk, reason: not valid java name */
    public final android.graphics.RadialGradient m505createRadialGradientColorLong8uybcMk(long j, float f, long[] jArr, float[] fArr, int i) {
        return TypefaceCompat$$ExternalSyntheticApiModelOutline1.m(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)), f, jArr, fArr, ColorKt.m497toAndroidTileMode0vamqd0(i));
    }

    /* JADX INFO: renamed from: createSweepGradientColorLong-9KIMszo, reason: not valid java name */
    public final android.graphics.SweepGradient m506createSweepGradientColorLong9KIMszo(long j, long[] jArr, float[] fArr) {
        return TypefaceCompat$$ExternalSyntheticApiModelOutline1.m(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)), jArr, fArr);
    }
}
