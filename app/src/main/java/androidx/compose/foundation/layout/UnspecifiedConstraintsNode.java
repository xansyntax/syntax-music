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
public final class UnspecifiedConstraintsNode extends Modifier.Node implements LayoutModifierNode {
    public float minHeight;
    public float minWidth;

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        int iMaxIntrinsicHeight = measurable.maxIntrinsicHeight(i);
        int iMo75roundToPx0680j_4 = !Float.isNaN(this.minHeight) ? lookaheadCapablePlaceable.mo75roundToPx0680j_4(this.minHeight) : 0;
        return iMaxIntrinsicHeight < iMo75roundToPx0680j_4 ? iMo75roundToPx0680j_4 : iMaxIntrinsicHeight;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        int iMaxIntrinsicWidth = measurable.maxIntrinsicWidth(i);
        int iMo75roundToPx0680j_4 = !Float.isNaN(this.minWidth) ? lookaheadCapablePlaceable.mo75roundToPx0680j_4(this.minWidth) : 0;
        return iMaxIntrinsicWidth < iMo75roundToPx0680j_4 ? iMo75roundToPx0680j_4 : iMaxIntrinsicWidth;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int iM786getMinWidthimpl;
        int iM785getMinHeightimpl;
        if (Float.isNaN(this.minWidth) || Constraints.m786getMinWidthimpl(j) != 0) {
            iM786getMinWidthimpl = Constraints.m786getMinWidthimpl(j);
        } else {
            int iMo75roundToPx0680j_4 = measureScope.mo75roundToPx0680j_4(this.minWidth);
            iM786getMinWidthimpl = Constraints.m784getMaxWidthimpl(j);
            if (iMo75roundToPx0680j_4 < 0) {
                iMo75roundToPx0680j_4 = 0;
            }
            if (iMo75roundToPx0680j_4 <= iM786getMinWidthimpl) {
                iM786getMinWidthimpl = iMo75roundToPx0680j_4;
            }
        }
        int iM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(j);
        if (Float.isNaN(this.minHeight) || Constraints.m785getMinHeightimpl(j) != 0) {
            iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(j);
        } else {
            int iMo75roundToPx0680j_5 = measureScope.mo75roundToPx0680j_4(this.minHeight);
            iM785getMinHeightimpl = Constraints.m783getMaxHeightimpl(j);
            int i = iMo75roundToPx0680j_5 >= 0 ? iMo75roundToPx0680j_5 : 0;
            if (i <= iM785getMinHeightimpl) {
                iM785getMinHeightimpl = i;
            }
        }
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(ConstraintsKt.Constraints(iM786getMinWidthimpl, iM784getMaxWidthimpl, iM785getMinHeightimpl, Constraints.m783getMaxHeightimpl(j)));
        return measureScope.layout(placeableMo598measureBRTryo0.width, placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 9));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        int iMinIntrinsicHeight = measurable.minIntrinsicHeight(i);
        int iMo75roundToPx0680j_4 = !Float.isNaN(this.minHeight) ? lookaheadCapablePlaceable.mo75roundToPx0680j_4(this.minHeight) : 0;
        return iMinIntrinsicHeight < iMo75roundToPx0680j_4 ? iMo75roundToPx0680j_4 : iMinIntrinsicHeight;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        int iMinIntrinsicWidth = measurable.minIntrinsicWidth(i);
        int iMo75roundToPx0680j_4 = !Float.isNaN(this.minWidth) ? lookaheadCapablePlaceable.mo75roundToPx0680j_4(this.minWidth) : 0;
        return iMinIntrinsicWidth < iMo75roundToPx0680j_4 ? iMo75roundToPx0680j_4 : iMinIntrinsicWidth;
    }
}
