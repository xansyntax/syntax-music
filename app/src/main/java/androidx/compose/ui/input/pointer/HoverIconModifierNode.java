package androidx.compose.ui.input.pointer;

import androidx.compose.ui.ComposedModifierKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draganddrop.DragAndDropNode$$ExternalSyntheticLambda1;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DpTouchBoundsExpansion;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.platform.AndroidComposeView$pointerIconService$1;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.navigation.NavGraphNavigator$$ExternalSyntheticLambda0;
import java.util.List;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class HoverIconModifierNode extends Modifier.Node implements TraversableNode, PointerInputModifierNode, CompositionLocalConsumerModifierNode {
    public boolean cursorInBoundsOfNode;
    public DpTouchBoundsExpansion dpTouchBoundsExpansion;
    public AndroidPointerIconType icon;

    public HoverIconModifierNode(AndroidPointerIconType androidPointerIconType, DpTouchBoundsExpansion dpTouchBoundsExpansion) {
        this.dpTouchBoundsExpansion = dpTouchBoundsExpansion;
        this.icon = androidPointerIconType;
    }

    public final void displayIcon() {
        AndroidPointerIconType androidPointerIconType;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        HitTestResultKt.traverseAncestors(this, new ComposedModifierKt$$ExternalSyntheticLambda0((byte) 7, ref$ObjectRef));
        HoverIconModifierNode hoverIconModifierNode = (HoverIconModifierNode) ref$ObjectRef.element;
        if (hoverIconModifierNode == null || (androidPointerIconType = hoverIconModifierNode.icon) == null) {
            androidPointerIconType = this.icon;
        }
        displayIcon(androidPointerIconType);
    }

    public final void displayIconIfDescendantsDoNotHavePriority() {
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = true;
        HitTestResultKt.traverseDescendants(this, new DragAndDropNode$$ExternalSyntheticLambda1(ref$BooleanRef));
        if (ref$BooleanRef.element) {
            displayIcon();
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: getTouchBoundsExpansion-RZrCHBk */
    public final long mo212getTouchBoundsExpansionRZrCHBk() {
        if (this.dpTouchBoundsExpansion == null) {
            return HitTestResultKt.pack$ui(0, 0, 0, 0);
        }
        Density density = HitTestResultKt.requireLayoutNode(this).density;
        return HitTestResultKt.pack$ui(density.mo75roundToPx0680j_4(10.0f), density.mo75roundToPx0680j_4(40.0f), density.mo75roundToPx0680j_4(10.0f), density.mo75roundToPx0680j_4(40.0f));
    }

    /* JADX INFO: renamed from: isRelevantPointerType-uerMTgs, reason: not valid java name */
    public boolean mo585isRelevantPointerTypeuerMTgs(int i) {
        return (i == 3 || i == 4) ? false : true;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onCancelPointerInput() {
        onExit();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        onExit();
    }

    public final void onExit() {
        if (this.cursorInBoundsOfNode) {
            this.cursorInBoundsOfNode = false;
            if (this.isAttached) {
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                HitTestResultKt.traverseAncestors(this, new NavGraphNavigator$$ExternalSyntheticLambda0(ref$ObjectRef, (byte) 4));
                HoverIconModifierNode hoverIconModifierNode = (HoverIconModifierNode) ref$ObjectRef.element;
                if (hoverIconModifierNode != null) {
                    hoverIconModifierNode.displayIcon();
                } else {
                    displayIcon(null);
                }
            }
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public final void mo27onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        if (pointerEventPass == PointerEventPass.Main) {
            List list = pointerEvent.changes;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (mo585isRelevantPointerTypeuerMTgs(((PointerInputChange) list.get(i)).type)) {
                    int i2 = pointerEvent.type;
                    if (i2 == 4) {
                        this.cursorInBoundsOfNode = true;
                        displayIconIfDescendantsDoNotHavePriority();
                        return;
                    } else {
                        if (i2 == 5) {
                            onExit();
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    public void displayIcon(PointerIcon pointerIcon) {
        PointerIconService pointerIconService = (PointerIconService) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalPointerIconService);
        if (pointerIconService != null) {
            ((AndroidComposeView$pointerIconService$1) pointerIconService).currentStylusHoverIcon = pointerIcon;
        }
    }
}
