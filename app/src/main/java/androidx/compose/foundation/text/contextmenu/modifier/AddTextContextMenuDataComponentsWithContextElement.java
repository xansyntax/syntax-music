package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/modifier/AddTextContextMenuDataComponentsWithContextElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/contextmenu/modifier/AddTextContextMenuDataComponentsWithContextNode;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AddTextContextMenuDataComponentsWithContextElement extends ModifierNodeElement {
    public final ButtonKt$$ExternalSyntheticLambda1 builder;

    public AddTextContextMenuDataComponentsWithContextElement(ButtonKt$$ExternalSyntheticLambda1 buttonKt$$ExternalSyntheticLambda1) {
        this.builder = buttonKt$$ExternalSyntheticLambda1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new AddTextContextMenuDataComponentsWithContextNode(this.builder);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AddTextContextMenuDataComponentsWithContextElement) {
            return this.builder == ((AddTextContextMenuDataComponentsWithContextElement) obj).builder;
        }
        return false;
    }

    public final int hashCode() {
        return this.builder.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ((AddTextContextMenuDataComponentsWithContextNode) node).builder = this.builder;
    }
}
