package androidx.compose.ui.input.pointer;

import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.platform.AndroidComposeView$pointerIconService$1;
import androidx.compose.ui.platform.Api24Impl;
import androidx.compose.ui.platform.CompositionLocalsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PointerHoverIconModifierNode extends HoverIconModifierNode {
    @Override // androidx.compose.ui.input.pointer.HoverIconModifierNode
    public final void displayIcon(PointerIcon pointerIcon) {
        PointerIconService pointerIconService = (PointerIconService) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalPointerIconService);
        if (pointerIconService != null) {
            AndroidComposeView$pointerIconService$1 androidComposeView$pointerIconService$1 = (AndroidComposeView$pointerIconService$1) pointerIconService;
            if (pointerIcon == null) {
                PointerIcon.Companion.getClass();
                pointerIcon = PointerIconKt.pointerIconDefault;
            }
            Api24Impl.setPointerIcon(androidComposeView$pointerIconService$1.this$0, pointerIcon);
        }
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public final Object getTraverseKey() {
        return "androidx.compose.ui.input.pointer.PointerHoverIcon";
    }
}
