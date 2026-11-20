package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerHoverIconModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/input/pointer/PointerHoverIconModifierNode;", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class PointerHoverIconModifierElement extends ModifierNodeElement {
    public final AndroidPointerIconType icon;

    public PointerHoverIconModifierElement(AndroidPointerIconType androidPointerIconType) {
        this.icon = androidPointerIconType;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new PointerHoverIconModifierNode(this.icon, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PointerHoverIconModifierElement) && this.icon.equals(((PointerHoverIconModifierElement) obj).icon);
    }

    public final int hashCode() {
        return Boolean.hashCode(false) + (this.icon.hashCode() * 31);
    }

    public final String toString() {
        return "PointerHoverIconModifierElement(icon=" + this.icon + ", overrideDescendants=false)";
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        PointerHoverIconModifierNode pointerHoverIconModifierNode = (PointerHoverIconModifierNode) node;
        AndroidPointerIconType androidPointerIconType = pointerHoverIconModifierNode.icon;
        AndroidPointerIconType androidPointerIconType2 = this.icon;
        if (Intrinsics.areEqual(androidPointerIconType, androidPointerIconType2)) {
            return;
        }
        pointerHoverIconModifierNode.icon = androidPointerIconType2;
        if (pointerHoverIconModifierNode.cursorInBoundsOfNode) {
            pointerHoverIconModifierNode.displayIconIfDescendantsDoNotHavePriority();
        }
    }
}
