package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/ConsumedInsetsModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/ConsumedInsetsModifierNode;", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class ConsumedInsetsModifierElement extends ModifierNodeElement {
    public final Function1 block;

    public ConsumedInsetsModifierElement(Function1 function1) {
        this.block = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        ConsumedInsetsModifierNode consumedInsetsModifierNode = new ConsumedInsetsModifierNode();
        consumedInsetsModifierNode.block = this.block;
        return consumedInsetsModifierNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ConsumedInsetsModifierElement) && ((ConsumedInsetsModifierElement) obj).block == this.block;
    }

    public final int hashCode() {
        return this.block.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ConsumedInsetsModifierNode consumedInsetsModifierNode = (ConsumedInsetsModifierNode) node;
        Function1 function1 = consumedInsetsModifierNode.block;
        Function1 function2 = this.block;
        if (function2 != function1) {
            consumedInsetsModifierNode.block = function2;
            consumedInsetsModifierNode.insetsInvalidated();
        }
    }
}
