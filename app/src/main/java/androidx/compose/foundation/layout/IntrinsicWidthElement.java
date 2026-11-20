package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/IntrinsicWidthElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/IntrinsicWidthNode;", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class IntrinsicWidthElement extends ModifierNodeElement {
    public final IntrinsicSize width;

    public IntrinsicWidthElement(IntrinsicSize intrinsicSize) {
        this.width = intrinsicSize;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        IntrinsicWidthNode intrinsicWidthNode = new IntrinsicWidthNode((byte) 0);
        intrinsicWidthNode.width = this.width;
        intrinsicWidthNode.enforceIncoming = true;
        return intrinsicWidthNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        IntrinsicWidthElement intrinsicWidthElement = obj instanceof IntrinsicWidthElement ? (IntrinsicWidthElement) obj : null;
        return intrinsicWidthElement != null && this.width == intrinsicWidthElement.width;
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + (this.width.hashCode() * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        IntrinsicWidthNode intrinsicWidthNode = (IntrinsicWidthNode) node;
        intrinsicWidthNode.width = this.width;
        intrinsicWidthNode.enforceIncoming = true;
    }
}
