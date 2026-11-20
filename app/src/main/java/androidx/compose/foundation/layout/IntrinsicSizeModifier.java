package androidx.compose.foundation.layout;

import androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda4;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class IntrinsicSizeModifier extends Modifier.Node implements LayoutModifierNode {
    public final /* synthetic */ byte $r8$classId;

    /* JADX INFO: renamed from: calculateContentConstraints-l58MMJ0 */
    public abstract long mo126calculateContentConstraintsl58MMJ0(Measurable measurable, long j);

    public abstract boolean getEnforceIncoming();

    public int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return measurable.maxIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return measurable.maxIntrinsicWidth(i);
    }

    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        long jMo126calculateContentConstraintsl58MMJ0 = mo126calculateContentConstraintsl58MMJ0(measurable, j);
        if (getEnforceIncoming()) {
            jMo126calculateContentConstraintsl58MMJ0 = ConstraintsKt.m790constrainN9IONVI(j, jMo126calculateContentConstraintsl58MMJ0);
        }
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(jMo126calculateContentConstraintsl58MMJ0);
        return measureScope.layout(placeableMo598measureBRTryo0.width, placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 7));
    }

    public int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return measurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return measurable.minIntrinsicWidth(i);
    }
}
