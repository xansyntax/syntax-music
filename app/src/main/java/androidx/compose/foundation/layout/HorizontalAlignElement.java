package androidx.compose.foundation.layout;

import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/HorizontalAlignElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/HorizontalAlignNode;", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HorizontalAlignElement extends ModifierNodeElement {
    public final BiasAlignment.Horizontal horizontal;

    public HorizontalAlignElement(BiasAlignment.Horizontal horizontal) {
        this.horizontal = horizontal;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        HorizontalAlignNode horizontalAlignNode = new HorizontalAlignNode();
        horizontalAlignNode.horizontal = this.horizontal;
        return horizontalAlignNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        HorizontalAlignElement horizontalAlignElement = obj instanceof HorizontalAlignElement ? (HorizontalAlignElement) obj : null;
        if (horizontalAlignElement == null) {
            return false;
        }
        return this.horizontal.equals(horizontalAlignElement.horizontal);
    }

    public final int hashCode() {
        return Float.hashCode(this.horizontal.bias);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ((HorizontalAlignNode) node).horizontal = this.horizontal;
    }
}
