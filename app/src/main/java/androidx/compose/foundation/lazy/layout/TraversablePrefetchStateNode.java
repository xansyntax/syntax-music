package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.TraversableNode;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TraversablePrefetchStateNode extends Modifier.Node implements TraversableNode {
    public LazyLayoutPrefetchState prefetchState;

    @Override // androidx.compose.ui.node.TraversableNode
    public final Object getTraverseKey() {
        return "androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode";
    }
}
