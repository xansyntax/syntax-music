package androidx.compose.material3.internal;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002¨\u0006\u0004"}, d2 = {"Landroidx/compose/material3/internal/DraggableAnchorsElement;", "T", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/internal/DraggableAnchorsNode;", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class DraggableAnchorsElement<T> extends ModifierNodeElement {
    public final Function2 anchors;
    public final Orientation orientation;
    public final NodeChain state;

    public DraggableAnchorsElement(NodeChain nodeChain, Function2 function2, Orientation orientation) {
        this.state = nodeChain;
        this.anchors = function2;
        this.orientation = orientation;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        DraggableAnchorsNode draggableAnchorsNode = new DraggableAnchorsNode();
        draggableAnchorsNode.state = this.state;
        draggableAnchorsNode.anchors = this.anchors;
        draggableAnchorsNode.orientation = this.orientation;
        return draggableAnchorsNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DraggableAnchorsElement) {
            DraggableAnchorsElement draggableAnchorsElement = (DraggableAnchorsElement) obj;
            if (this.state == draggableAnchorsElement.state && this.anchors == draggableAnchorsElement.anchors && this.orientation == draggableAnchorsElement.orientation) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.orientation.hashCode() + ((this.anchors.hashCode() + (this.state.hashCode() * 31)) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        DraggableAnchorsNode draggableAnchorsNode = (DraggableAnchorsNode) node;
        NodeChain nodeChain = draggableAnchorsNode.state;
        NodeChain nodeChain2 = this.state;
        boolean zAreEqual = Intrinsics.areEqual(nodeChain, nodeChain2);
        draggableAnchorsNode.state = nodeChain2;
        draggableAnchorsNode.anchors = this.anchors;
        draggableAnchorsNode.orientation = this.orientation;
        if (zAreEqual) {
            return;
        }
        draggableAnchorsNode.didInitializeAnchors = false;
        HitTestResultKt.invalidateMeasurement(draggableAnchorsNode);
    }
}
