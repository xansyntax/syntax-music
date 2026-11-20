package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.InlineClassHelperKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IntrinsicWidthNode extends IntrinsicSizeModifier {
    public boolean enforceIncoming;
    public IntrinsicSize width;

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier
    /* JADX INFO: renamed from: calculateContentConstraints-l58MMJ0 */
    public final long mo126calculateContentConstraintsl58MMJ0(Measurable measurable, long j) {
        int iMinIntrinsicWidth = this.width == IntrinsicSize.Min ? measurable.minIntrinsicWidth(Constraints.m783getMaxHeightimpl(j)) : measurable.maxIntrinsicWidth(Constraints.m783getMaxHeightimpl(j));
        if (iMinIntrinsicWidth < 0) {
            iMinIntrinsicWidth = 0;
        }
        if (iMinIntrinsicWidth < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("width must be >= 0");
        }
        return ConstraintsKt.createConstraints(iMinIntrinsicWidth, iMinIntrinsicWidth, 0, Integer.MAX_VALUE);
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier
    public final boolean getEnforceIncoming() {
        return this.enforceIncoming;
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier, androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return this.width == IntrinsicSize.Min ? measurable.minIntrinsicWidth(i) : measurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier, androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return this.width == IntrinsicSize.Min ? measurable.minIntrinsicWidth(i) : measurable.maxIntrinsicWidth(i);
    }
}
