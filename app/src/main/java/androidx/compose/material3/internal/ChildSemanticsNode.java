package androidx.compose.material3.internal;

import androidx.compose.foundation.selection.ToggleableNode$$ExternalSyntheticLambda0;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ChildSemanticsNode extends Modifier.Node implements SemanticsModifierNode {
    public TextKt$$ExternalSyntheticLambda0 properties;

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        HitTestResultKt.traverseAncestors(this, ParentSemanticsNodeKey.INSTANCE, new ToggleableNode$$ExternalSyntheticLambda0(semanticsPropertyReceiver, (byte) 2));
        this.properties.getClass();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        HitTestResultKt.traverseAncestors(this, ParentSemanticsNodeKey.INSTANCE, new TextKt$$ExternalSyntheticLambda0((byte) 22));
    }
}
