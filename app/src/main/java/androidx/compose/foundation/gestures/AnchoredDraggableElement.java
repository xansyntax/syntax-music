package androidx.compose.foundation.gestures;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002¨\u0006\u0004"}, d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableElement;", "T", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/gestures/AnchoredDraggableNode;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnchoredDraggableElement<T> extends ModifierNodeElement {
    public final boolean enabled;
    public final FlingBehavior flingBehavior;
    public final Orientation orientation;
    public final NodeChain state;

    public AnchoredDraggableElement(NodeChain nodeChain, Orientation orientation, boolean z, FlingBehavior flingBehavior) {
        this.state = nodeChain;
        this.orientation = orientation;
        this.enabled = z;
        this.flingBehavior = flingBehavior;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        AnchoredDraggableNode anchoredDraggableNode = new AnchoredDraggableNode(ScrollableKt.AlwaysDrag, this.enabled, null, this.orientation);
        anchoredDraggableNode.state = this.state;
        anchoredDraggableNode.flingBehavior = this.flingBehavior;
        return anchoredDraggableNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AnchoredDraggableElement) {
            AnchoredDraggableElement anchoredDraggableElement = (AnchoredDraggableElement) obj;
            if (this.state == anchoredDraggableElement.state && this.orientation == anchoredDraggableElement.orientation && this.enabled == anchoredDraggableElement.enabled && Intrinsics.areEqual(this.flingBehavior, anchoredDraggableElement.flingBehavior)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iM = IntIntPair$$ExternalSyntheticOutline0.m((this.orientation.hashCode() + (this.state.hashCode() * 31)) * 31, this.enabled, 28629151);
        FlingBehavior flingBehavior = this.flingBehavior;
        return iM + (flingBehavior != null ? flingBehavior.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        boolean z;
        boolean z2;
        AnchoredDraggableNode anchoredDraggableNode = (AnchoredDraggableNode) node;
        FlingBehavior flingBehavior = this.flingBehavior;
        anchoredDraggableNode.flingBehavior = flingBehavior;
        NodeChain nodeChain = anchoredDraggableNode.state;
        NodeChain nodeChain2 = this.state;
        if (Intrinsics.areEqual(nodeChain, nodeChain2)) {
            z = false;
        } else {
            anchoredDraggableNode.state = nodeChain2;
            anchoredDraggableNode.updateFlingBehavior(flingBehavior);
            z = true;
        }
        Orientation orientation = anchoredDraggableNode.orientation;
        Orientation orientation2 = this.orientation;
        if (orientation != orientation2) {
            anchoredDraggableNode.orientation = orientation2;
            z2 = true;
        } else {
            z2 = z;
        }
        anchoredDraggableNode.update(anchoredDraggableNode.canDrag, this.enabled, null, orientation2, z2);
    }
}
