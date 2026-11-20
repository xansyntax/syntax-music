package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewRequesterElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/relocation/BringIntoViewRequesterNode;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class BringIntoViewRequesterElement extends ModifierNodeElement {
    public final BringIntoViewRequesterImpl requester;

    public BringIntoViewRequesterElement(BringIntoViewRequesterImpl bringIntoViewRequesterImpl) {
        this.requester = bringIntoViewRequesterImpl;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        BringIntoViewRequesterNode bringIntoViewRequesterNode = new BringIntoViewRequesterNode();
        bringIntoViewRequesterNode.requester = this.requester;
        return bringIntoViewRequesterNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BringIntoViewRequesterElement) {
            return Intrinsics.areEqual(this.requester, ((BringIntoViewRequesterElement) obj).requester);
        }
        return false;
    }

    public final int hashCode() {
        return this.requester.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        BringIntoViewRequesterNode bringIntoViewRequesterNode = (BringIntoViewRequesterNode) node;
        BringIntoViewRequesterImpl bringIntoViewRequesterImpl = bringIntoViewRequesterNode.requester;
        if (bringIntoViewRequesterImpl != null) {
            bringIntoViewRequesterImpl.nodes.remove(bringIntoViewRequesterNode);
        }
        BringIntoViewRequesterImpl bringIntoViewRequesterImpl2 = this.requester;
        if (bringIntoViewRequesterImpl2 != null) {
            bringIntoViewRequesterImpl2.nodes.add(bringIntoViewRequesterNode);
        }
        bringIntoViewRequesterNode.requester = bringIntoViewRequesterImpl2;
    }
}
