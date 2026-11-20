package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.unit.Constraints;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FlowLayoutOverflowState {
    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof FlowLayoutOverflowState);
    }

    public final int hashCode() {
        return Integer.hashCode(0) + IntIntPair$$ExternalSyntheticOutline0.m(0, FlowLayoutOverflow$OverflowType.Clip.hashCode() * 31, 31);
    }

    /* JADX INFO: renamed from: setOverflowMeasurables--hBUhpc$foundation_layout, reason: not valid java name */
    public final void m120setOverflowMeasurableshBUhpc$foundation_layout(Measurable measurable, Measurable measurable2, long j) {
        long jM130constructorimpl = OffsetKt.m130constructorimpl(j, LayoutOrientation.Horizontal);
        if (measurable != null) {
            int iMinIntrinsicWidth = measurable.minIntrinsicWidth(Constraints.m783getMaxHeightimpl(jM130constructorimpl));
            new IntIntPair(IntIntPair.m1constructorimpl(iMinIntrinsicWidth, measurable.minIntrinsicHeight(iMinIntrinsicWidth)));
        }
        if (measurable2 != null) {
            int iMinIntrinsicWidth2 = measurable2.minIntrinsicWidth(Constraints.m783getMaxHeightimpl(jM130constructorimpl));
            new IntIntPair(IntIntPair.m1constructorimpl(iMinIntrinsicWidth2, measurable2.minIntrinsicHeight(iMinIntrinsicWidth2)));
        }
    }

    public final String toString() {
        return "FlowLayoutOverflowState(type=" + FlowLayoutOverflow$OverflowType.Clip + ", minLinesToShowCollapse=0, minCrossAxisSizeToShowCollapse=0)";
    }
}
