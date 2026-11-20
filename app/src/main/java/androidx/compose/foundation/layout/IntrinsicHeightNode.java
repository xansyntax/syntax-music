package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.InlineClassHelperKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IntrinsicHeightNode extends IntrinsicSizeModifier {
    public boolean enforceIncoming;
    public IntrinsicSize height;

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier
    /* JADX INFO: renamed from: calculateContentConstraints-l58MMJ0, reason: not valid java name */
    public final long mo126calculateContentConstraintsl58MMJ0(Measurable measurable, long j) {
        int iMinIntrinsicHeight = this.height == IntrinsicSize.Min ? measurable.minIntrinsicHeight(Constraints.m784getMaxWidthimpl(j)) : measurable.maxIntrinsicHeight(Constraints.m784getMaxWidthimpl(j));
        if (iMinIntrinsicHeight < 0) {
            iMinIntrinsicHeight = 0;
        }
        if (iMinIntrinsicHeight < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("height must be >= 0");
        }
        return ConstraintsKt.createConstraints(0, Integer.MAX_VALUE, iMinIntrinsicHeight, iMinIntrinsicHeight);
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier
    public final boolean getEnforceIncoming() {
        return this.enforceIncoming;
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier, androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return this.height == IntrinsicSize.Min ? measurable.minIntrinsicHeight(i) : measurable.maxIntrinsicHeight(i);
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier, androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return this.height == IntrinsicSize.Min ? measurable.minIntrinsicHeight(i) : measurable.maxIntrinsicHeight(i);
    }
}
