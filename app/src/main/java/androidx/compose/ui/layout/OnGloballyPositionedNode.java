package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OnGloballyPositionedNode extends Modifier.Node implements GlobalPositionAwareModifierNode {
    public Function1 callback;

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public final void onGloballyPositioned(NodeCoordinator nodeCoordinator) {
        this.callback.invoke(nodeCoordinator);
    }
}
