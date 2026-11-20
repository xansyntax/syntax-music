package androidx.compose.foundation.text.handwriting;

import androidx.compose.material3.ScrimKt$Scrim$dismissModifier$1$1;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusRequesterModifierNode;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StylusHandwritingNode extends DelegatingNode implements PointerInputModifierNode, FocusEventModifierNode, FocusRequesterModifierNode {
    public boolean focused;
    public Function0 onHandwritingSlopExceeded;
    public final SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNode;

    public StylusHandwritingNode(Function0 function0) {
        this.onHandwritingSlopExceeded = function0;
        SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImplSuspendingPointerInputModifierNode = SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new ScrimKt$Scrim$dismissModifier$1$1((byte) 5, this));
        delegate(suspendingPointerInputModifierNodeImplSuspendingPointerInputModifierNode);
        this.suspendingPointerInputModifierNode = suspendingPointerInputModifierNodeImplSuspendingPointerInputModifierNode;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: getTouchBoundsExpansion-RZrCHBk, reason: not valid java name */
    public final long mo212getTouchBoundsExpansionRZrCHBk() {
        Density density = HitTestResultKt.requireLayoutNode(this).density;
        StylusHandwritingKt.HandwritingBoundsExpansion.getClass();
        return HitTestResultKt.pack$ui(density.mo75roundToPx0680j_4(10.0f), density.mo75roundToPx0680j_4(40.0f), density.mo75roundToPx0680j_4(10.0f), density.mo75roundToPx0680j_4(40.0f));
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onCancelPointerInput() {
        this.suspendingPointerInputModifierNode.onCancelPointerInput();
    }

    @Override // androidx.compose.ui.focus.FocusEventModifierNode
    public final void onFocusEvent(FocusStateImpl focusStateImpl) {
        this.focused = focusStateImpl.isFocused();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public final void mo27onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        this.suspendingPointerInputModifierNode.mo27onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
    }
}
