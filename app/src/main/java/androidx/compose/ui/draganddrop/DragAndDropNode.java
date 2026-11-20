package androidx.compose.ui.draganddrop;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.TraversableNode;
import coil3.size.ViewSizeResolver$size$3$1;
import coil3.util.LifecyclesKt;
import coil3.util.UtilsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DragAndDropNode extends Modifier.Node implements TraversableNode, LayoutAwareModifierNode {
    public DragAndDropNode lastChildDragAndDropModifierNode;
    public long size;
    public DragAndDropNode thisDragAndDropTarget;

    @Override // androidx.compose.ui.node.TraversableNode
    public final Object getTraverseKey() {
        return DragAndDropNode$Companion$DragAndDropTraversableKey.INSTANCE;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        this.thisDragAndDropTarget = null;
        this.lastChildDragAndDropModifierNode = null;
    }

    public final boolean onDrop() {
        DragAndDropNode dragAndDropNode = this.lastChildDragAndDropModifierNode;
        if (dragAndDropNode != null) {
            return dragAndDropNode.onDrop();
        }
        DragAndDropNode dragAndDropNode2 = this.thisDragAndDropTarget;
        if (dragAndDropNode2 != null) {
            return dragAndDropNode2.onDrop();
        }
        return false;
    }

    public final void onEntered() {
        DragAndDropNode dragAndDropNode = this.thisDragAndDropTarget;
        if (dragAndDropNode != null) {
            dragAndDropNode.onEntered();
            return;
        }
        DragAndDropNode dragAndDropNode2 = this.lastChildDragAndDropModifierNode;
        if (dragAndDropNode2 != null) {
            dragAndDropNode2.onEntered();
        }
    }

    public final void onExited() {
        DragAndDropNode dragAndDropNode = this.thisDragAndDropTarget;
        if (dragAndDropNode != null) {
            dragAndDropNode.onExited();
        }
        DragAndDropNode dragAndDropNode2 = this.lastChildDragAndDropModifierNode;
        if (dragAndDropNode2 != null) {
            dragAndDropNode2.onExited();
        }
        this.lastChildDragAndDropModifierNode = null;
    }

    public final void onMoved(DrawResult drawResult) {
        TraversableNode traversableNode;
        DragAndDropNode dragAndDropNode;
        DragAndDropNode dragAndDropNode2 = this.lastChildDragAndDropModifierNode;
        if (dragAndDropNode2 == null || !LifecyclesKt.m885containsUv8p0NA(dragAndDropNode2, UtilsKt.getPositionInRoot(drawResult))) {
            if (this.node.isAttached) {
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                HitTestResultKt.traverseDescendants(this, new ViewSizeResolver$size$3$1(ref$ObjectRef, this, drawResult, (byte) 2));
                traversableNode = (TraversableNode) ref$ObjectRef.element;
            } else {
                traversableNode = null;
            }
            dragAndDropNode = (DragAndDropNode) traversableNode;
        } else {
            dragAndDropNode = dragAndDropNode2;
        }
        if (dragAndDropNode != null && dragAndDropNode2 == null) {
            dragAndDropNode.onEntered();
            dragAndDropNode.onMoved(drawResult);
            DragAndDropNode dragAndDropNode3 = this.thisDragAndDropTarget;
            if (dragAndDropNode3 != null) {
                dragAndDropNode3.onExited();
            }
        } else if (dragAndDropNode == null && dragAndDropNode2 != null) {
            DragAndDropNode dragAndDropNode4 = this.thisDragAndDropTarget;
            if (dragAndDropNode4 != null) {
                dragAndDropNode4.onEntered();
                dragAndDropNode4.onMoved(drawResult);
            }
            dragAndDropNode2.onExited();
        } else if (!Intrinsics.areEqual(dragAndDropNode, dragAndDropNode2)) {
            if (dragAndDropNode != null) {
                dragAndDropNode.onEntered();
                dragAndDropNode.onMoved(drawResult);
            }
            if (dragAndDropNode2 != null) {
                dragAndDropNode2.onExited();
            }
        } else if (dragAndDropNode != null) {
            dragAndDropNode.onMoved(drawResult);
        } else {
            DragAndDropNode dragAndDropNode5 = this.thisDragAndDropTarget;
            if (dragAndDropNode5 != null) {
                dragAndDropNode5.onMoved(drawResult);
            }
        }
        this.lastChildDragAndDropModifierNode = dragAndDropNode;
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode, androidx.compose.ui.node.MeasuredSizeAwareModifierNode
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    public final void mo61onRemeasuredozmzZPI(long j) {
        this.size = j;
    }

    public final void onStarted() {
        DragAndDropNode dragAndDropNode = this.thisDragAndDropTarget;
        if (dragAndDropNode != null) {
            dragAndDropNode.onStarted();
            return;
        }
        DragAndDropNode dragAndDropNode2 = this.lastChildDragAndDropModifierNode;
        if (dragAndDropNode2 != null) {
            dragAndDropNode2.onStarted();
        }
    }
}
