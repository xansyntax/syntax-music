package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/SizeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/SizeNode;", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SizeElement extends ModifierNodeElement {
    public final boolean enforceIncoming;
    public final float maxHeight;
    public final float maxWidth;
    public final float minHeight;
    public final float minWidth;

    public /* synthetic */ SizeElement(float f, float f2, float f3, float f4, int i) {
        this((i & 1) != 0 ? Float.NaN : f, (i & 2) != 0 ? Float.NaN : f2, (i & 4) != 0 ? Float.NaN : f3, (i & 8) != 0 ? Float.NaN : f4, true);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        SizeNode sizeNode = new SizeNode();
        sizeNode.minWidth = this.minWidth;
        sizeNode.minHeight = this.minHeight;
        sizeNode.maxWidth = this.maxWidth;
        sizeNode.maxHeight = this.maxHeight;
        sizeNode.enforceIncoming = this.enforceIncoming;
        return sizeNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeElement)) {
            return false;
        }
        SizeElement sizeElement = (SizeElement) obj;
        return Dp.m796equalsimpl0(this.minWidth, sizeElement.minWidth) && Dp.m796equalsimpl0(this.minHeight, sizeElement.minHeight) && Dp.m796equalsimpl0(this.maxWidth, sizeElement.maxWidth) && Dp.m796equalsimpl0(this.maxHeight, sizeElement.maxHeight) && this.enforceIncoming == sizeElement.enforceIncoming;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.enforceIncoming) + IntIntPair$$ExternalSyntheticOutline0.m(this.maxHeight, IntIntPair$$ExternalSyntheticOutline0.m(this.maxWidth, IntIntPair$$ExternalSyntheticOutline0.m(this.minHeight, Float.hashCode(this.minWidth) * 31, 31), 31), 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        SizeNode sizeNode = (SizeNode) node;
        sizeNode.minWidth = this.minWidth;
        sizeNode.minHeight = this.minHeight;
        sizeNode.maxWidth = this.maxWidth;
        sizeNode.maxHeight = this.maxHeight;
        sizeNode.enforceIncoming = this.enforceIncoming;
    }

    public SizeElement(float f, float f2, float f3, float f4, boolean z) {
        this.minWidth = f;
        this.minHeight = f2;
        this.maxWidth = f3;
        this.maxHeight = f4;
        this.enforceIncoming = z;
    }
}
