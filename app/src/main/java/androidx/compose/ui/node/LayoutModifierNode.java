package androidx.compose.ui.node;

import androidx.compose.ui.layout.DefaultIntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicsMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.ConstraintsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface LayoutModifierNode extends DelegatableNode {
    default int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return mo14measure3p2s80s(new IntrinsicsMeasureScope(lookaheadCapablePlaceable, lookaheadCapablePlaceable.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, NodeMeasuringIntrinsics$IntrinsicMinMax.Max, NodeMeasuringIntrinsics$IntrinsicWidthHeight.Height, (byte) 2), ConstraintsKt.Constraints$default(0, i, 0, 0, 13)).getHeight();
    }

    default int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return mo14measure3p2s80s(new IntrinsicsMeasureScope(lookaheadCapablePlaceable, lookaheadCapablePlaceable.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, NodeMeasuringIntrinsics$IntrinsicMinMax.Max, NodeMeasuringIntrinsics$IntrinsicWidthHeight.Width, (byte) 2), ConstraintsKt.Constraints$default(0, 0, 0, i, 7)).getWidth();
    }

    /* JADX INFO: renamed from: measure-3p2s80s */
    MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j);

    default int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return mo14measure3p2s80s(new IntrinsicsMeasureScope(lookaheadCapablePlaceable, lookaheadCapablePlaceable.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, NodeMeasuringIntrinsics$IntrinsicMinMax.Min, NodeMeasuringIntrinsics$IntrinsicWidthHeight.Height, (byte) 2), ConstraintsKt.Constraints$default(0, i, 0, 0, 13)).getHeight();
    }

    default int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return mo14measure3p2s80s(new IntrinsicsMeasureScope(lookaheadCapablePlaceable, lookaheadCapablePlaceable.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, NodeMeasuringIntrinsics$IntrinsicMinMax.Min, NodeMeasuringIntrinsics$IntrinsicWidthHeight.Width, (byte) 2), ConstraintsKt.Constraints$default(0, 0, 0, i, 7)).getWidth();
    }
}
