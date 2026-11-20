package androidx.compose.foundation.text.selection;

import androidx.compose.ui.semantics.SemanticsPropertyKey;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SelectionHandlesKt {
    public static final SemanticsPropertyKey SelectionHandleInfoKey = new SemanticsPropertyKey("SelectionHandleInfo");

    /* JADX INFO: renamed from: getAdjustedCoordinates-k-4lQ0M, reason: not valid java name */
    public static final long m229getAdjustedCoordinatesk4lQ0M(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        return (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) - 1.0f)) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
    }
}
