package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/OnSizeChangedModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/layout/OnSizeChangedNode;", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class OnSizeChangedModifier extends ModifierNodeElement {
    public final Function1 onSizeChanged;

    public OnSizeChangedModifier(Function1 function1) {
        this.onSizeChanged = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        OnSizeChangedNode onSizeChangedNode = new OnSizeChangedNode();
        onSizeChangedNode.onSizeChanged = this.onSizeChanged;
        onSizeChangedNode.previousSize = -9223372034707292160L;
        return onSizeChangedNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OnSizeChangedModifier) {
            return this.onSizeChanged == ((OnSizeChangedModifier) obj).onSizeChanged;
        }
        return false;
    }

    public final int hashCode() {
        return this.onSizeChanged.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        OnSizeChangedNode onSizeChangedNode = (OnSizeChangedNode) node;
        onSizeChangedNode.onSizeChanged = this.onSizeChanged;
        onSizeChangedNode.previousSize = -9223372034707292160L;
    }
}
