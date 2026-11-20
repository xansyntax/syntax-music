package androidx.compose.foundation.layout;

import androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda4;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SizeNode extends Modifier.Node implements LayoutModifierNode {
    public boolean enforceIncoming;
    public float maxHeight;
    public float maxWidth;
    public float minHeight;
    public float minWidth;

    /* JADX WARN: Code duplicated, block: B:23:0x0041  */
    /* JADX INFO: renamed from: getTargetConstraints-OenEA2s, reason: not valid java name */
    public final long m158getTargetConstraintsOenEA2s(MeasureScope measureScope) {
        int iMo75roundToPx0680j_4;
        int iMo75roundToPx0680j_5;
        int iMo75roundToPx0680j_6;
        int i = 0;
        if (Float.isNaN(this.maxWidth)) {
            iMo75roundToPx0680j_4 = Integer.MAX_VALUE;
        } else {
            iMo75roundToPx0680j_4 = measureScope.mo75roundToPx0680j_4(this.maxWidth);
            if (iMo75roundToPx0680j_4 < 0) {
                iMo75roundToPx0680j_4 = 0;
            }
        }
        if (Float.isNaN(this.maxHeight)) {
            iMo75roundToPx0680j_5 = Integer.MAX_VALUE;
        } else {
            iMo75roundToPx0680j_5 = measureScope.mo75roundToPx0680j_4(this.maxHeight);
            if (iMo75roundToPx0680j_5 < 0) {
                iMo75roundToPx0680j_5 = 0;
            }
        }
        if (Float.isNaN(this.minWidth)) {
            iMo75roundToPx0680j_6 = 0;
        } else {
            iMo75roundToPx0680j_6 = measureScope.mo75roundToPx0680j_4(this.minWidth);
            if (iMo75roundToPx0680j_6 < 0) {
                iMo75roundToPx0680j_6 = 0;
            }
            if (iMo75roundToPx0680j_6 > iMo75roundToPx0680j_4) {
                iMo75roundToPx0680j_6 = iMo75roundToPx0680j_4;
            }
            if (iMo75roundToPx0680j_6 == Integer.MAX_VALUE) {
                iMo75roundToPx0680j_6 = 0;
            }
        }
        if (!Float.isNaN(this.minHeight)) {
            int iMo75roundToPx0680j_7 = measureScope.mo75roundToPx0680j_4(this.minHeight);
            if (iMo75roundToPx0680j_7 < 0) {
                iMo75roundToPx0680j_7 = 0;
            }
            if (iMo75roundToPx0680j_7 > iMo75roundToPx0680j_5) {
                iMo75roundToPx0680j_7 = iMo75roundToPx0680j_5;
            }
            if (iMo75roundToPx0680j_7 != Integer.MAX_VALUE) {
                i = iMo75roundToPx0680j_7;
            }
        }
        return ConstraintsKt.Constraints(iMo75roundToPx0680j_6, iMo75roundToPx0680j_4, i, iMo75roundToPx0680j_5);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        long jM158getTargetConstraintsOenEA2s = m158getTargetConstraintsOenEA2s(lookaheadCapablePlaceable);
        if (Constraints.m781getHasFixedHeightimpl(jM158getTargetConstraintsOenEA2s)) {
            return Constraints.m783getMaxHeightimpl(jM158getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m792constrainWidthK40F9xA(i, jM158getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m791constrainHeightK40F9xA(measurable.maxIntrinsicHeight(i), jM158getTargetConstraintsOenEA2s);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        long jM158getTargetConstraintsOenEA2s = m158getTargetConstraintsOenEA2s(lookaheadCapablePlaceable);
        if (Constraints.m782getHasFixedWidthimpl(jM158getTargetConstraintsOenEA2s)) {
            return Constraints.m784getMaxWidthimpl(jM158getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m791constrainHeightK40F9xA(i, jM158getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m792constrainWidthK40F9xA(measurable.maxIntrinsicWidth(i), jM158getTargetConstraintsOenEA2s);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int iM786getMinWidthimpl;
        int iM784getMaxWidthimpl;
        int iM785getMinHeightimpl;
        int iM783getMaxHeightimpl;
        long jConstraints;
        long jM158getTargetConstraintsOenEA2s = m158getTargetConstraintsOenEA2s(measureScope);
        if (this.enforceIncoming) {
            jConstraints = ConstraintsKt.m790constrainN9IONVI(j, jM158getTargetConstraintsOenEA2s);
        } else {
            if (Float.isNaN(this.minWidth)) {
                iM786getMinWidthimpl = Constraints.m786getMinWidthimpl(j);
                int iM784getMaxWidthimpl2 = Constraints.m784getMaxWidthimpl(jM158getTargetConstraintsOenEA2s);
                if (iM786getMinWidthimpl > iM784getMaxWidthimpl2) {
                    iM786getMinWidthimpl = iM784getMaxWidthimpl2;
                }
            } else {
                iM786getMinWidthimpl = Constraints.m786getMinWidthimpl(jM158getTargetConstraintsOenEA2s);
            }
            if (Float.isNaN(this.maxWidth)) {
                iM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(j);
                int iM786getMinWidthimpl2 = Constraints.m786getMinWidthimpl(jM158getTargetConstraintsOenEA2s);
                if (iM784getMaxWidthimpl < iM786getMinWidthimpl2) {
                    iM784getMaxWidthimpl = iM786getMinWidthimpl2;
                }
            } else {
                iM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(jM158getTargetConstraintsOenEA2s);
            }
            if (Float.isNaN(this.minHeight)) {
                iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(j);
                int iM783getMaxHeightimpl2 = Constraints.m783getMaxHeightimpl(jM158getTargetConstraintsOenEA2s);
                if (iM785getMinHeightimpl > iM783getMaxHeightimpl2) {
                    iM785getMinHeightimpl = iM783getMaxHeightimpl2;
                }
            } else {
                iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(jM158getTargetConstraintsOenEA2s);
            }
            if (Float.isNaN(this.maxHeight)) {
                iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(j);
                int iM785getMinHeightimpl2 = Constraints.m785getMinHeightimpl(jM158getTargetConstraintsOenEA2s);
                if (iM783getMaxHeightimpl < iM785getMinHeightimpl2) {
                    iM783getMaxHeightimpl = iM785getMinHeightimpl2;
                }
            } else {
                iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(jM158getTargetConstraintsOenEA2s);
            }
            jConstraints = ConstraintsKt.Constraints(iM786getMinWidthimpl, iM784getMaxWidthimpl, iM785getMinHeightimpl, iM783getMaxHeightimpl);
        }
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(jConstraints);
        return measureScope.layout(placeableMo598measureBRTryo0.width, placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 8));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        long jM158getTargetConstraintsOenEA2s = m158getTargetConstraintsOenEA2s(lookaheadCapablePlaceable);
        if (Constraints.m781getHasFixedHeightimpl(jM158getTargetConstraintsOenEA2s)) {
            return Constraints.m783getMaxHeightimpl(jM158getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m792constrainWidthK40F9xA(i, jM158getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m791constrainHeightK40F9xA(measurable.minIntrinsicHeight(i), jM158getTargetConstraintsOenEA2s);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        long jM158getTargetConstraintsOenEA2s = m158getTargetConstraintsOenEA2s(lookaheadCapablePlaceable);
        if (Constraints.m782getHasFixedWidthimpl(jM158getTargetConstraintsOenEA2s)) {
            return Constraints.m784getMaxWidthimpl(jM158getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m791constrainHeightK40F9xA(i, jM158getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m792constrainWidthK40F9xA(measurable.minIntrinsicWidth(i), jM158getTargetConstraintsOenEA2s);
    }
}
