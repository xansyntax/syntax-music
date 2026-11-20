package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BringIntoViewRequesterNode extends Modifier.Node {
    public BringIntoViewRequesterImpl requester;

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        BringIntoViewRequesterImpl bringIntoViewRequesterImpl = this.requester;
        if (bringIntoViewRequesterImpl != null) {
            bringIntoViewRequesterImpl.nodes.remove(this);
        }
        if (bringIntoViewRequesterImpl != null) {
            bringIntoViewRequesterImpl.nodes.add(this);
        }
        this.requester = bringIntoViewRequesterImpl;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        BringIntoViewRequesterImpl bringIntoViewRequesterImpl = this.requester;
        if (bringIntoViewRequesterImpl != null) {
            bringIntoViewRequesterImpl.nodes.remove(this);
        }
    }
}
