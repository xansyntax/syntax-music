package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/UnionInsetsConsumingModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/UnionInsetsConsumingModifierNode;", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class UnionInsetsConsumingModifierElement extends ModifierNodeElement {
    public final WindowInsets insets;

    public UnionInsetsConsumingModifierElement(WindowInsets windowInsets) {
        this.insets = windowInsets;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        UnionInsetsConsumingModifierNode unionInsetsConsumingModifierNode = new UnionInsetsConsumingModifierNode();
        unionInsetsConsumingModifierNode.insets = this.insets;
        return unionInsetsConsumingModifierNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UnionInsetsConsumingModifierElement) {
            return Intrinsics.areEqual(((UnionInsetsConsumingModifierElement) obj).insets, this.insets);
        }
        return false;
    }

    public final int hashCode() {
        return this.insets.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        UnionInsetsConsumingModifierNode unionInsetsConsumingModifierNode = (UnionInsetsConsumingModifierNode) node;
        WindowInsets windowInsets = unionInsetsConsumingModifierNode.insets;
        WindowInsets windowInsets2 = this.insets;
        if (Intrinsics.areEqual(windowInsets2, windowInsets)) {
            return;
        }
        unionInsetsConsumingModifierNode.insets = windowInsets2;
        unionInsetsConsumingModifierNode.insetsInvalidated();
    }
}
