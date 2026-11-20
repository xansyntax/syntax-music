package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/OverscrollModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/OverscrollModifierNode;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class OverscrollModifierElement extends ModifierNodeElement {
    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        OverscrollModifierNode overscrollModifierNode = new OverscrollModifierNode();
        overscrollModifierNode.overscrollNode = null;
        return overscrollModifierNode;
    }

    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof OverscrollModifierElement);
    }

    public final int hashCode() {
        return 0;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        OverscrollModifierNode overscrollModifierNode = (OverscrollModifierNode) node;
        DelegatableNode delegatableNode = overscrollModifierNode.overscrollNode;
        if (delegatableNode != null) {
            overscrollModifierNode.undelegate(delegatableNode);
        }
        overscrollModifierNode.overscrollNode = null;
        overscrollModifierNode.overscrollNode = null;
    }
}
