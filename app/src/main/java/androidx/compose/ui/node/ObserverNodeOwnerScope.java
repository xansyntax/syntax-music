package androidx.compose.ui.node;

import androidx.compose.ui.ComposedModifierKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ObserverNodeOwnerScope implements OwnerScope {
    public static final ComposedModifierKt$$ExternalSyntheticLambda0 OnObserveReadsChanged = new ComposedModifierKt$$ExternalSyntheticLambda0(15);
    public final ObserverModifierNode observerNode;

    public ObserverNodeOwnerScope(ObserverModifierNode observerModifierNode) {
        this.observerNode = observerModifierNode;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final boolean isValidOwnerScope() {
        return ((Modifier.Node) this.observerNode).node.isAttached;
    }
}
