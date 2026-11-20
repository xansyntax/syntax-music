package androidx.compose.animation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/animation/ZIndexModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/ZIndexModifierNode;", "animation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class ZIndexModifierElement extends ModifierNodeElement {
    public final Object stateForContent;
    public final float zIndex;

    public ZIndexModifierElement(float f, Object obj) {
        this.zIndex = f;
        this.stateForContent = obj;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        ZIndexModifierNode zIndexModifierNode = new ZIndexModifierNode();
        zIndexModifierNode.zIndex = this.zIndex;
        zIndexModifierNode.stateForContent = this.stateForContent;
        return zIndexModifierNode;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ZIndexModifierElement)) {
            return false;
        }
        ZIndexModifierElement zIndexModifierElement = (ZIndexModifierElement) obj;
        return zIndexModifierElement.zIndex == this.zIndex && Intrinsics.areEqual(zIndexModifierElement.stateForContent, this.stateForContent);
    }

    public final int hashCode() {
        int iHashCode = Float.hashCode(this.zIndex) * 31;
        Object obj = this.stateForContent;
        return iHashCode + (obj != null ? obj.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ZIndexModifierNode zIndexModifierNode = (ZIndexModifierNode) node;
        zIndexModifierNode.zIndex = this.zIndex;
        zIndexModifierNode.stateForContent = this.stateForContent;
    }
}
