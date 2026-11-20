package androidx.compose.ui.node;

import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface PointerInputModifierNode extends DelegatableNode {
    /* JADX INFO: renamed from: getTouchBoundsExpansion-RZrCHBk */
    default long mo212getTouchBoundsExpansionRZrCHBk() {
        return HitTestResultKt.pack$ui(0, 0, 0, 0);
    }

    void onCancelPointerInput();

    default void onDensityChange() {
        onCancelPointerInput();
    }

    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    void mo27onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j);

    default void onViewConfigurationChange() {
        onCancelPointerInput();
    }

    default boolean sharePointerInputWithSiblings() {
        return false;
    }

    default void interceptOutOfBoundsChildEvents() {
    }
}
