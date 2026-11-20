package androidx.compose.foundation.lazy;

import androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda4;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ParentSizeNode extends Modifier.Node implements LayoutModifierNode {
    public float fraction;
    public State heightState;
    public State widthState;

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        State state = this.widthState;
        int iRound = (state == null || ((Number) state.getValue()).intValue() == Integer.MAX_VALUE) ? Integer.MAX_VALUE : Math.round(((Number) state.getValue()).floatValue() * this.fraction);
        State state2 = this.heightState;
        int iRound2 = (state2 == null || ((Number) state2.getValue()).intValue() == Integer.MAX_VALUE) ? Integer.MAX_VALUE : Math.round(((Number) state2.getValue()).floatValue() * this.fraction);
        int iM786getMinWidthimpl = iRound != Integer.MAX_VALUE ? iRound : Constraints.m786getMinWidthimpl(j);
        int iM785getMinHeightimpl = iRound2 != Integer.MAX_VALUE ? iRound2 : Constraints.m785getMinHeightimpl(j);
        if (iRound == Integer.MAX_VALUE) {
            iRound = Constraints.m784getMaxWidthimpl(j);
        }
        if (iRound2 == Integer.MAX_VALUE) {
            iRound2 = Constraints.m783getMaxHeightimpl(j);
        }
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(ConstraintsKt.Constraints(iM786getMinWidthimpl, iRound, iM785getMinHeightimpl, iRound2));
        return measureScope.layout(placeableMo598measureBRTryo0.width, placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 10));
    }
}
