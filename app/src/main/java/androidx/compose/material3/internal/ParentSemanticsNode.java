package androidx.compose.material3.internal;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ParentSemanticsNode extends Modifier.Node implements TraversableNode, SemanticsModifierNode {
    public UtilsKt$$ExternalSyntheticLambda0 properties;
    public boolean semanticsConsumed;

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) throws Throwable {
        if (this.semanticsConsumed) {
            return;
        }
        this.properties.invoke(semanticsPropertyReceiver);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final boolean getShouldMergeDescendantSemantics() {
        return true;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public final Object getTraverseKey() {
        return ParentSemanticsNodeKey.INSTANCE;
    }
}
