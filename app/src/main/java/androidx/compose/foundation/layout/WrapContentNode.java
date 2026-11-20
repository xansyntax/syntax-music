package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import com.metrolist.music.db.DatabaseDao_Impl$$ExternalSyntheticLambda130;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function2;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class WrapContentNode extends Modifier.Node implements LayoutModifierNode {
    public Function2 alignmentCallback;
    public Direction direction;

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(ConstraintsKt.Constraints(this.direction != Direction.Vertical ? 0 : Constraints.m786getMinWidthimpl(j), Constraints.m784getMaxWidthimpl(j), this.direction == Direction.Horizontal ? Constraints.m785getMinHeightimpl(j) : 0, Constraints.m783getMaxHeightimpl(j)));
        int iCoerceIn = UuidKt.coerceIn(placeableMo598measureBRTryo0.width, Constraints.m786getMinWidthimpl(j), Constraints.m784getMaxWidthimpl(j));
        int iCoerceIn2 = UuidKt.coerceIn(placeableMo598measureBRTryo0.height, Constraints.m785getMinHeightimpl(j), Constraints.m783getMaxHeightimpl(j));
        return measureScope.layout(iCoerceIn, iCoerceIn2, EmptyMap.INSTANCE, new DatabaseDao_Impl$$ExternalSyntheticLambda130(this, iCoerceIn, placeableMo598measureBRTryo0, iCoerceIn2, measureScope));
    }
}
