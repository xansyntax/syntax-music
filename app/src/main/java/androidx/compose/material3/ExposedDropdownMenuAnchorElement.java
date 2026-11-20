package androidx.compose.material3;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda29;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuAnchorElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/ExposedDropdownMenuAnchorNode;", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExposedDropdownMenuAnchorElement extends ModifierNodeElement {
    public final MainActivity$$ExternalSyntheticLambda29 updateStateOnAttach;

    public ExposedDropdownMenuAnchorElement(MainActivity$$ExternalSyntheticLambda29 mainActivity$$ExternalSyntheticLambda29) {
        this.updateStateOnAttach = mainActivity$$ExternalSyntheticLambda29;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        ExposedDropdownMenuAnchorNode exposedDropdownMenuAnchorNode = new ExposedDropdownMenuAnchorNode();
        exposedDropdownMenuAnchorNode.updateStateOnAttach = this.updateStateOnAttach;
        return exposedDropdownMenuAnchorNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ExposedDropdownMenuAnchorElement) {
            return this.updateStateOnAttach == ((ExposedDropdownMenuAnchorElement) obj).updateStateOnAttach;
        }
        return false;
    }

    public final int hashCode() {
        return this.updateStateOnAttach.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ((ExposedDropdownMenuAnchorNode) node).updateStateOnAttach = this.updateStateOnAttach;
    }
}
