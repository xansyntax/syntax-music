package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.TraversableNode;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GestureNode extends Modifier.Node implements TraversableNode {
    public static final TraverseKey TraverseKey = new TraverseKey();
    public final GestureConnection gestureConnection;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TraverseKey {
    }

    public GestureNode(GestureConnection gestureConnection) {
        this.gestureConnection = gestureConnection;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public final Object getTraverseKey() {
        return TraverseKey;
    }
}
