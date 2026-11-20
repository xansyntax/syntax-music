package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/WrapContentElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/WrapContentNode;", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WrapContentElement extends ModifierNodeElement {
    public final Object align;
    public final Function2 alignmentCallback;
    public final Direction direction;

    public WrapContentElement(Direction direction, Function2 function2, Object obj) {
        this.direction = direction;
        this.alignmentCallback = function2;
        this.align = obj;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        WrapContentNode wrapContentNode = new WrapContentNode();
        wrapContentNode.direction = this.direction;
        wrapContentNode.alignmentCallback = this.alignmentCallback;
        return wrapContentNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WrapContentElement.class != obj.getClass()) {
            return false;
        }
        WrapContentElement wrapContentElement = (WrapContentElement) obj;
        return this.direction == wrapContentElement.direction && Intrinsics.areEqual(this.align, wrapContentElement.align);
    }

    public final int hashCode() {
        return this.align.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.direction.hashCode() * 31, false, 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        WrapContentNode wrapContentNode = (WrapContentNode) node;
        wrapContentNode.direction = this.direction;
        wrapContentNode.alignmentCallback = this.alignmentCallback;
    }
}
