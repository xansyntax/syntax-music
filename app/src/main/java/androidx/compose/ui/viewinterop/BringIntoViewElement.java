package androidx.compose.ui.viewinterop;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/viewinterop/BringIntoViewElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/viewinterop/BringIntoViewNode;", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class BringIntoViewElement extends ModifierNodeElement {
    public final AndroidViewHolder$$ExternalSyntheticLambda4 onRequesterReady;

    public BringIntoViewElement(AndroidViewHolder$$ExternalSyntheticLambda4 androidViewHolder$$ExternalSyntheticLambda4) {
        this.onRequesterReady = androidViewHolder$$ExternalSyntheticLambda4;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new BringIntoViewNode(this.onRequesterReady);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BringIntoViewElement) {
            return this.onRequesterReady == ((BringIntoViewElement) obj).onRequesterReady;
        }
        return false;
    }

    public final int hashCode() {
        return this.onRequesterReady.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        BringIntoViewNode bringIntoViewNode = (BringIntoViewNode) node;
        AndroidViewHolder$$ExternalSyntheticLambda4 androidViewHolder$$ExternalSyntheticLambda4 = this.onRequesterReady;
        bringIntoViewNode.onRequesterReady = androidViewHolder$$ExternalSyntheticLambda4;
        if (bringIntoViewNode.isAttached) {
            androidViewHolder$$ExternalSyntheticLambda4.invoke(bringIntoViewNode.requester);
        }
    }
}
