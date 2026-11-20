package androidx.compose.foundation.gestures;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/DraggableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/gestures/DraggableNode;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DraggableElement extends ModifierNodeElement {
    public static final BorderKt$$ExternalSyntheticLambda1 CanDrag = new BorderKt$$ExternalSyntheticLambda1((byte) 28);
    public final boolean enabled;
    public final MutableInteractionSourceImpl interactionSource;
    public final Function3 onDragStarted;
    public final Function3 onDragStopped;
    public final Orientation orientation;
    public final boolean reverseDirection;
    public final boolean startDragImmediately;
    public final DraggableState state;

    public DraggableElement(DraggableState draggableState, Orientation orientation, boolean z, MutableInteractionSourceImpl mutableInteractionSourceImpl, boolean z2, DraggableKt$NoOpOnDragStarted$1 draggableKt$NoOpOnDragStarted$1, Function3 function3, boolean z3) {
        this.state = draggableState;
        this.orientation = orientation;
        this.enabled = z;
        this.interactionSource = mutableInteractionSourceImpl;
        this.startDragImmediately = z2;
        this.onDragStarted = draggableKt$NoOpOnDragStarted$1;
        this.onDragStopped = function3;
        this.reverseDirection = z3;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        DraggableNode draggableNode = new DraggableNode(CanDrag, this.enabled, this.interactionSource, this.orientation);
        draggableNode.state = this.state;
        draggableNode.startDragImmediately = this.startDragImmediately;
        draggableNode.onDragStarted = this.onDragStarted;
        draggableNode.onDragStopped = this.onDragStopped;
        draggableNode.reverseDirection = this.reverseDirection;
        return draggableNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DraggableElement.class != obj.getClass()) {
            return false;
        }
        DraggableElement draggableElement = (DraggableElement) obj;
        return Intrinsics.areEqual(this.state, draggableElement.state) && this.orientation == draggableElement.orientation && this.enabled == draggableElement.enabled && Intrinsics.areEqual(this.interactionSource, draggableElement.interactionSource) && this.startDragImmediately == draggableElement.startDragImmediately && Intrinsics.areEqual(this.onDragStarted, draggableElement.onDragStarted) && Intrinsics.areEqual(this.onDragStopped, draggableElement.onDragStopped) && this.reverseDirection == draggableElement.reverseDirection;
    }

    public final int hashCode() {
        int iM = IntIntPair$$ExternalSyntheticOutline0.m((this.orientation.hashCode() + (this.state.hashCode() * 31)) * 31, this.enabled, 31);
        MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
        return Boolean.hashCode(this.reverseDirection) + ((this.onDragStopped.hashCode() + ((this.onDragStarted.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m((iM + (mutableInteractionSourceImpl != null ? mutableInteractionSourceImpl.hashCode() : 0)) * 31, this.startDragImmediately, 31)) * 31)) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        boolean z;
        boolean z2;
        DraggableNode draggableNode = (DraggableNode) node;
        DraggableState draggableState = draggableNode.state;
        DraggableState draggableState2 = this.state;
        if (Intrinsics.areEqual(draggableState, draggableState2)) {
            z = false;
        } else {
            draggableNode.state = draggableState2;
            z = true;
        }
        boolean z3 = draggableNode.reverseDirection;
        boolean z4 = this.reverseDirection;
        if (z3 != z4) {
            draggableNode.reverseDirection = z4;
            z2 = true;
        } else {
            z2 = z;
        }
        draggableNode.onDragStarted = this.onDragStarted;
        draggableNode.onDragStopped = this.onDragStopped;
        draggableNode.startDragImmediately = this.startDragImmediately;
        draggableNode.update(CanDrag, this.enabled, this.interactionSource, this.orientation, z2);
    }
}
