package androidx.compose.ui.scrollcapture;

import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.unit.IntRect;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollCaptureCandidate {
    public final NodeCoordinator coordinates;
    public final int depth;
    public final SemanticsNode node;
    public final IntRect viewportBoundsInWindow;

    public ScrollCaptureCandidate(SemanticsNode semanticsNode, int i, IntRect intRect, NodeCoordinator nodeCoordinator) {
        this.node = semanticsNode;
        this.depth = i;
        this.viewportBoundsInWindow = intRect;
        this.coordinates = nodeCoordinator;
    }

    public final String toString() {
        return "ScrollCaptureCandidate(node=" + this.node + ", depth=" + this.depth + ", viewportBoundsInWindow=" + this.viewportBoundsInWindow + ", coordinates=" + this.coordinates + ")";
    }
}
