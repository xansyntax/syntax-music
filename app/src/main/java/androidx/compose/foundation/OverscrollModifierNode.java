package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OverscrollModifierNode extends DelegatingNode {
    public DelegatableNode overscrollNode;

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        DelegatableNode delegatableNode = this.overscrollNode;
        if (delegatableNode == null || ((Modifier.Node) delegatableNode).node.isAttached) {
            delegatableNode = null;
        } else {
            delegate(delegatableNode);
        }
        this.overscrollNode = delegatableNode;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        DelegatableNode delegatableNode = this.overscrollNode;
        if (delegatableNode != null) {
            undelegate(delegatableNode);
        }
    }
}
