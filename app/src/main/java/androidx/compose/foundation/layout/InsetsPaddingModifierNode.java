package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class InsetsPaddingModifierNode extends InsetsConsumingModifierNode implements LayoutModifierNode {
    public WindowInsets insets;

    public InsetsPaddingModifierNode(WindowInsets windowInsets) {
        this.insets = windowInsets;
    }

    @Override // androidx.compose.foundation.layout.InsetsConsumingModifierNode
    public final WindowInsets calculateInsets(WindowInsets windowInsets) {
        return new UnionInsets(windowInsets, this.insets);
    }

    @Override // androidx.compose.foundation.layout.InsetsConsumingModifierNode
    public final void insetsInvalidated() {
        super.insetsInvalidated();
        HitTestResultKt.invalidateMeasurement(this);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int left = this.consumedInsets.getLeft(measureScope, measureScope.getLayoutDirection()) - this.ancestorConsumedInsets.getLeft(measureScope, measureScope.getLayoutDirection());
        int top = this.consumedInsets.getTop(measureScope) - this.ancestorConsumedInsets.getTop(measureScope);
        int right = (this.consumedInsets.getRight(measureScope, measureScope.getLayoutDirection()) - this.ancestorConsumedInsets.getRight(measureScope, measureScope.getLayoutDirection())) + left;
        int bottom = (this.consumedInsets.getBottom(measureScope) - this.ancestorConsumedInsets.getBottom(measureScope)) + top;
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(ConstraintsKt.m793offsetNN6EwU(-right, -bottom, j));
        return measureScope.layout(ConstraintsKt.m792constrainWidthK40F9xA(placeableMo598measureBRTryo0.width + right, j), ConstraintsKt.m791constrainHeightK40F9xA(placeableMo598measureBRTryo0.height + bottom, j), EmptyMap.INSTANCE, new PaddingValuesModifier$$ExternalSyntheticLambda0(placeableMo598measureBRTryo0, left, top, (byte) 1));
    }
}
