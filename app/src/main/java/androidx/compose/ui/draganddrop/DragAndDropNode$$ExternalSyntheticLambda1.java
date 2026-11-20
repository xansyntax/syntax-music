package androidx.compose.ui.draganddrop;

import androidx.compose.ui.input.pointer.HoverIconModifierNode;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DragAndDropNode$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Ref$BooleanRef f$2;

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        TraversableNode$Companion$TraverseDescendantsAction traversableNode$Companion$TraverseDescendantsAction = TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
        Ref$BooleanRef ref$BooleanRef = this.f$2;
        switch (b) {
            case 0:
                DragAndDropNode dragAndDropNode = (DragAndDropNode) obj;
                if (!dragAndDropNode.isAttached) {
                    return TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
                }
                if (dragAndDropNode.thisDragAndDropTarget != null) {
                    InlineClassHelperKt.throwIllegalStateException("DragAndDropTarget self reference must be null at the start of a drag and drop session");
                }
                dragAndDropNode.thisDragAndDropTarget = null;
                ref$BooleanRef.element = ref$BooleanRef.element;
                return traversableNode$Companion$TraverseDescendantsAction;
            default:
                if (!((HoverIconModifierNode) obj).cursorInBoundsOfNode) {
                    return traversableNode$Companion$TraverseDescendantsAction;
                }
                ref$BooleanRef.element = false;
                return TraversableNode$Companion$TraverseDescendantsAction.CancelTraversal;
        }
    }

    public /* synthetic */ DragAndDropNode$$ExternalSyntheticLambda1(Ref$BooleanRef ref$BooleanRef) {
        this.f$2 = ref$BooleanRef;
    }
}
