package androidx.compose.foundation;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/ScrollingLayoutElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/ScrollNode;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScrollingLayoutElement extends ModifierNodeElement {
    public final boolean isVertical;
    public final ScrollState scrollState;

    public ScrollingLayoutElement(ScrollState scrollState, boolean z) {
        this.scrollState = scrollState;
        this.isVertical = z;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        ScrollNode scrollNode = new ScrollNode();
        scrollNode.state = this.scrollState;
        scrollNode.isVertical = this.isVertical;
        return scrollNode;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ScrollingLayoutElement)) {
            return false;
        }
        ScrollingLayoutElement scrollingLayoutElement = (ScrollingLayoutElement) obj;
        return Intrinsics.areEqual(this.scrollState, scrollingLayoutElement.scrollState) && this.isVertical == scrollingLayoutElement.isVertical;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.isVertical) + IntIntPair$$ExternalSyntheticOutline0.m(this.scrollState.hashCode() * 31, false, 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ScrollNode scrollNode = (ScrollNode) node;
        scrollNode.state = this.scrollState;
        scrollNode.isVertical = this.isVertical;
    }
}
