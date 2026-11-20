package androidx.compose.foundation.layout;

import androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda4;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FillNode extends Modifier.Node implements LayoutModifierNode, ParentDataModifierNode {
    public Direction direction;
    public float fraction;

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int iM786getMinWidthimpl;
        int iM784getMaxWidthimpl;
        int iM783getMaxHeightimpl;
        int i;
        if (!Constraints.m780getHasBoundedWidthimpl(j) || this.direction == Direction.Vertical) {
            iM786getMinWidthimpl = Constraints.m786getMinWidthimpl(j);
            iM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(j);
        } else {
            int iRound = Math.round(Constraints.m784getMaxWidthimpl(j) * this.fraction);
            int iM786getMinWidthimpl2 = Constraints.m786getMinWidthimpl(j);
            iM786getMinWidthimpl = Constraints.m784getMaxWidthimpl(j);
            if (iRound < iM786getMinWidthimpl2) {
                iRound = iM786getMinWidthimpl2;
            }
            if (iRound <= iM786getMinWidthimpl) {
                iM786getMinWidthimpl = iRound;
            }
            iM784getMaxWidthimpl = iM786getMinWidthimpl;
        }
        if (!Constraints.m779getHasBoundedHeightimpl(j) || this.direction == Direction.Horizontal) {
            int iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(j);
            int iM783getMaxHeightimpl2 = Constraints.m783getMaxHeightimpl(j);
            iM783getMaxHeightimpl = iM785getMinHeightimpl;
            i = iM783getMaxHeightimpl2;
        } else {
            int iRound2 = Math.round(Constraints.m783getMaxHeightimpl(j) * this.fraction);
            int iM785getMinHeightimpl2 = Constraints.m785getMinHeightimpl(j);
            iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(j);
            if (iRound2 < iM785getMinHeightimpl2) {
                iRound2 = iM785getMinHeightimpl2;
            }
            if (iRound2 <= iM783getMaxHeightimpl) {
                iM783getMaxHeightimpl = iRound2;
            }
            i = iM783getMaxHeightimpl;
        }
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(ConstraintsKt.Constraints(iM786getMinWidthimpl, iM784getMaxWidthimpl, iM783getMaxHeightimpl, i));
        return measureScope.layout(placeableMo598measureBRTryo0.width, placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 6));
    }

    @Override // androidx.compose.ui.node.ParentDataModifierNode
    public final Object modifyParentData(Density density, Object obj) {
        FillParentData fillParentData = obj instanceof FillParentData ? (FillParentData) obj : null;
        if (fillParentData == null) {
            return obj == null ? new FillParentData() : obj;
        }
        return fillParentData;
    }
}
