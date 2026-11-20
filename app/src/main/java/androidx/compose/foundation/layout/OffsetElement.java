package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.unit.Dp;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/OffsetElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/OffsetNode;", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class OffsetElement extends ModifierNodeElement {
    public final float x;
    public final float y;

    public OffsetElement(float f, float f2, OffsetKt$$ExternalSyntheticLambda0 offsetKt$$ExternalSyntheticLambda0) {
        this.x = f;
        this.y = f2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        OffsetNode offsetNode = new OffsetNode();
        offsetNode.x = this.x;
        offsetNode.y = this.y;
        offsetNode.rtlAware = true;
        return offsetNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        OffsetElement offsetElement = obj instanceof OffsetElement ? (OffsetElement) obj : null;
        return offsetElement != null && Dp.m796equalsimpl0(this.x, offsetElement.x) && Dp.m796equalsimpl0(this.y, offsetElement.y);
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + IntIntPair$$ExternalSyntheticOutline0.m(this.y, Float.hashCode(this.x) * 31, 31);
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("OffsetModifierElement(x=", Dp.m797toStringimpl(this.x), ", y=", Dp.m797toStringimpl(this.y), ", rtlAware=true)");
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        OffsetNode offsetNode = (OffsetNode) node;
        float f = offsetNode.x;
        float f2 = this.x;
        boolean zM796equalsimpl0 = Dp.m796equalsimpl0(f, f2);
        float f3 = this.y;
        if (!zM796equalsimpl0 || !Dp.m796equalsimpl0(offsetNode.y, f3) || !offsetNode.rtlAware) {
            HitTestResultKt.requireLayoutNode(offsetNode).requestRelayout$ui(false);
        }
        offsetNode.x = f2;
        offsetNode.y = f3;
        offsetNode.rtlAware = true;
    }
}
