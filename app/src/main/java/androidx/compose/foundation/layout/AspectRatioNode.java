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
import androidx.compose.ui.unit.InlineClassHelperKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AspectRatioNode extends Modifier.Node implements LayoutModifierNode {
    public float aspectRatio;

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return i != Integer.MAX_VALUE ? Math.round(i / this.aspectRatio) : measurable.maxIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return i != Integer.MAX_VALUE ? Math.round(i * this.aspectRatio) : measurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        long jM114tryMaxWidthJN0ABg = m114tryMaxWidthJN0ABg(j, true);
        if (IntSize.m810equalsimpl0(jM114tryMaxWidthJN0ABg, 0L)) {
            jM114tryMaxWidthJN0ABg = m113tryMaxHeightJN0ABg(j, true);
            if (IntSize.m810equalsimpl0(jM114tryMaxWidthJN0ABg, 0L)) {
                jM114tryMaxWidthJN0ABg = m116tryMinWidthJN0ABg(j, true);
                if (IntSize.m810equalsimpl0(jM114tryMaxWidthJN0ABg, 0L)) {
                    jM114tryMaxWidthJN0ABg = m115tryMinHeightJN0ABg(j, true);
                    if (IntSize.m810equalsimpl0(jM114tryMaxWidthJN0ABg, 0L)) {
                        jM114tryMaxWidthJN0ABg = m114tryMaxWidthJN0ABg(j, false);
                        if (IntSize.m810equalsimpl0(jM114tryMaxWidthJN0ABg, 0L)) {
                            jM114tryMaxWidthJN0ABg = m113tryMaxHeightJN0ABg(j, false);
                            if (IntSize.m810equalsimpl0(jM114tryMaxWidthJN0ABg, 0L)) {
                                jM114tryMaxWidthJN0ABg = m116tryMinWidthJN0ABg(j, false);
                                if (IntSize.m810equalsimpl0(jM114tryMaxWidthJN0ABg, 0L)) {
                                    jM114tryMaxWidthJN0ABg = m115tryMinHeightJN0ABg(j, false);
                                    if (IntSize.m810equalsimpl0(jM114tryMaxWidthJN0ABg, 0L)) {
                                        jM114tryMaxWidthJN0ABg = 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (!IntSize.m810equalsimpl0(jM114tryMaxWidthJN0ABg, 0L)) {
            int i = (int) (jM114tryMaxWidthJN0ABg >> 32);
            int i2 = (int) (4294967295L & jM114tryMaxWidthJN0ABg);
            if (!((i >= 0) & (i2 >= 0))) {
                InlineClassHelperKt.throwIllegalArgumentException("width and height must be >= 0");
            }
            j = ConstraintsKt.createConstraints(i, i, i2, i2);
        }
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(j);
        return measureScope.layout(placeableMo598measureBRTryo0.width, placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 5));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return i != Integer.MAX_VALUE ? Math.round(i / this.aspectRatio) : measurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return i != Integer.MAX_VALUE ? Math.round(i * this.aspectRatio) : measurable.minIntrinsicWidth(i);
    }

    /* JADX INFO: renamed from: tryMaxHeight-JN-0ABg, reason: not valid java name */
    public final long m113tryMaxHeightJN0ABg(long j, boolean z) {
        int iRound;
        int iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(j);
        if (iM783getMaxHeightimpl == Integer.MAX_VALUE || (iRound = Math.round(iM783getMaxHeightimpl * this.aspectRatio)) <= 0) {
            return 0L;
        }
        if (!z || OffsetKt.m132isSatisfiedByNN6EwU(iRound, iM783getMaxHeightimpl, j)) {
            return (((long) iRound) << 32) | (((long) iM783getMaxHeightimpl) & 4294967295L);
        }
        return 0L;
    }

    /* JADX INFO: renamed from: tryMaxWidth-JN-0ABg, reason: not valid java name */
    public final long m114tryMaxWidthJN0ABg(long j, boolean z) {
        int iRound;
        int iM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(j);
        if (iM784getMaxWidthimpl == Integer.MAX_VALUE || (iRound = Math.round(iM784getMaxWidthimpl / this.aspectRatio)) <= 0) {
            return 0L;
        }
        if (!z || OffsetKt.m132isSatisfiedByNN6EwU(iM784getMaxWidthimpl, iRound, j)) {
            return (((long) iM784getMaxWidthimpl) << 32) | (((long) iRound) & 4294967295L);
        }
        return 0L;
    }

    /* JADX INFO: renamed from: tryMinHeight-JN-0ABg, reason: not valid java name */
    public final long m115tryMinHeightJN0ABg(long j, boolean z) {
        int iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(j);
        int iRound = Math.round(iM785getMinHeightimpl * this.aspectRatio);
        if (iRound <= 0) {
            return 0L;
        }
        if (!z || OffsetKt.m132isSatisfiedByNN6EwU(iRound, iM785getMinHeightimpl, j)) {
            return (((long) iRound) << 32) | (((long) iM785getMinHeightimpl) & 4294967295L);
        }
        return 0L;
    }

    /* JADX INFO: renamed from: tryMinWidth-JN-0ABg, reason: not valid java name */
    public final long m116tryMinWidthJN0ABg(long j, boolean z) {
        int iM786getMinWidthimpl = Constraints.m786getMinWidthimpl(j);
        int iRound = Math.round(iM786getMinWidthimpl / this.aspectRatio);
        if (iRound <= 0) {
            return 0L;
        }
        if (!z || OffsetKt.m132isSatisfiedByNN6EwU(iM786getMinWidthimpl, iRound, j)) {
            return (((long) iM786getMinWidthimpl) << 32) | (((long) iRound) & 4294967295L);
        }
        return 0L;
    }
}
