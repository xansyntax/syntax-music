package androidx.compose.foundation.layout;

import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PaddingNode extends Modifier.Node implements LayoutModifierNode {
    public float bottom;
    public float end;
    public boolean rtlAware;
    public float start;
    public float top;

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int iMo75roundToPx0680j_4 = measureScope.mo75roundToPx0680j_4(this.end) + measureScope.mo75roundToPx0680j_4(this.start);
        int iMo75roundToPx0680j_5 = measureScope.mo75roundToPx0680j_4(this.bottom) + measureScope.mo75roundToPx0680j_4(this.top);
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(ConstraintsKt.m793offsetNN6EwU(-iMo75roundToPx0680j_4, -iMo75roundToPx0680j_5, j));
        return measureScope.layout(ConstraintsKt.m792constrainWidthK40F9xA(placeableMo598measureBRTryo0.width + iMo75roundToPx0680j_4, j), ConstraintsKt.m791constrainHeightK40F9xA(placeableMo598measureBRTryo0.height + iMo75roundToPx0680j_5, j), EmptyMap.INSTANCE, new BackHandlerKt$$ExternalSyntheticLambda2(this, placeableMo598measureBRTryo0, (byte) 20));
    }
}
