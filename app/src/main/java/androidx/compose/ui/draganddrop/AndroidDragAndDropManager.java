package androidx.compose.ui.draganddrop;

import android.view.DragEvent;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.channels.BufferedChannel$bindCancellationFun$2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidDragAndDropManager implements View.OnDragListener, DragAndDropManager {
    public final ArraySet interestedTargets;
    public final AndroidDragAndDropManager$modifier$1 modifier;
    public final DragAndDropNode rootDragAndDropNode;

    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.compose.ui.draganddrop.AndroidDragAndDropManager$modifier$1] */
    public AndroidDragAndDropManager(BufferedChannel$bindCancellationFun$2 bufferedChannel$bindCancellationFun$2) {
        DragAndDropNode dragAndDropNode = new DragAndDropNode();
        dragAndDropNode.size = 0L;
        this.rootDragAndDropNode = dragAndDropNode;
        this.interestedTargets = new ArraySet(0);
        this.modifier = new ModifierNodeElement() { // from class: androidx.compose.ui.draganddrop.AndroidDragAndDropManager$modifier$1
            @Override // androidx.compose.ui.node.ModifierNodeElement
            public final Modifier.Node create() {
                return this.this$0.rootDragAndDropNode;
            }

            public final boolean equals(Object obj) {
                return obj == this;
            }

            public final int hashCode() {
                return this.this$0.rootDragAndDropNode.hashCode();
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public final void update(Modifier.Node node) {
            }
        };
    }

    @Override // android.view.View.OnDragListener
    public final boolean onDrag(View view, DragEvent dragEvent) {
        DrawResult drawResult = new DrawResult((byte) 22, dragEvent);
        int action = dragEvent.getAction();
        TraversableNode$Companion$TraverseDescendantsAction traversableNode$Companion$TraverseDescendantsAction = TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
        ArraySet arraySet = this.interestedTargets;
        DragAndDropNode dragAndDropNode = this.rootDragAndDropNode;
        switch (action) {
            case 1:
                Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                DragAndDropNode$$ExternalSyntheticLambda1 dragAndDropNode$$ExternalSyntheticLambda1 = new DragAndDropNode$$ExternalSyntheticLambda1(drawResult, dragAndDropNode, ref$BooleanRef);
                if (dragAndDropNode$$ExternalSyntheticLambda1.invoke(dragAndDropNode) == traversableNode$Companion$TraverseDescendantsAction) {
                    HitTestResultKt.traverseDescendants(dragAndDropNode, dragAndDropNode$$ExternalSyntheticLambda1);
                }
                boolean z = ref$BooleanRef.element;
                ArrayMap.KeyIterator keyIterator = new ArrayMap.KeyIterator(arraySet);
                while (keyIterator.hasNext()) {
                    ((DragAndDropNode) keyIterator.next()).onStarted();
                }
                return z;
            case 2:
                dragAndDropNode.onMoved(drawResult);
                return false;
            case 3:
                return dragAndDropNode.onDrop();
            case 4:
                TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2 = new TextKt$$ExternalSyntheticLambda2((byte) 18, drawResult);
                if (textKt$$ExternalSyntheticLambda2.invoke(dragAndDropNode) == traversableNode$Companion$TraverseDescendantsAction) {
                    HitTestResultKt.traverseDescendants(dragAndDropNode, textKt$$ExternalSyntheticLambda2);
                }
                arraySet.clear();
                return false;
            case 5:
                dragAndDropNode.onEntered();
                return false;
            case 6:
                dragAndDropNode.onExited();
                return false;
            default:
                return false;
        }
    }
}
