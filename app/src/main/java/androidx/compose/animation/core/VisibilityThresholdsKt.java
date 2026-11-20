package androidx.compose.animation.core;

import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class VisibilityThresholdsKt {
    public static final Map VisibilityThresholdMap;

    static {
        Float fValueOf = Float.valueOf(1.0f);
        Pair pair = new Pair(ArcSplineKt.IntToVector, fValueOf);
        Pair pair2 = new Pair(ArcSplineKt.IntSizeToVector, fValueOf);
        Pair pair3 = new Pair(ArcSplineKt.IntOffsetToVector, fValueOf);
        Pair pair4 = new Pair(ArcSplineKt.FloatToVector, Float.valueOf(0.01f));
        Pair pair5 = new Pair(ArcSplineKt.RectToVector, fValueOf);
        Pair pair6 = new Pair(ArcSplineKt.SizeToVector, fValueOf);
        Pair pair7 = new Pair(ArcSplineKt.OffsetToVector, fValueOf);
        TwoWayConverterImpl twoWayConverterImpl = ArcSplineKt.DpToVector;
        Float fValueOf2 = Float.valueOf(0.4f);
        VisibilityThresholdMap = MapsKt__MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, new Pair(twoWayConverterImpl, fValueOf2), new Pair(ArcSplineKt.DpOffsetToVector, fValueOf2));
    }
}
