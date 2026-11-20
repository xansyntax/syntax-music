package androidx.compose.material3.internal;

import androidx.compose.material3.TextKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/material3/internal/ChildSemanticsNodeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/internal/ChildSemanticsNode;", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChildSemanticsNodeElement extends ModifierNodeElement {
    public final TextKt$$ExternalSyntheticLambda0 properties;

    public ChildSemanticsNodeElement(TextKt$$ExternalSyntheticLambda0 textKt$$ExternalSyntheticLambda0) {
        this.properties = textKt$$ExternalSyntheticLambda0;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        ChildSemanticsNode childSemanticsNode = new ChildSemanticsNode();
        childSemanticsNode.properties = this.properties;
        return childSemanticsNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChildSemanticsNodeElement) {
            return this.properties == ((ChildSemanticsNodeElement) obj).properties;
        }
        return false;
    }

    public final int hashCode() {
        return this.properties.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ChildSemanticsNode childSemanticsNode = (ChildSemanticsNode) node;
        childSemanticsNode.properties = this.properties;
        HitTestResultKt.invalidateSemantics(childSemanticsNode);
    }
}
