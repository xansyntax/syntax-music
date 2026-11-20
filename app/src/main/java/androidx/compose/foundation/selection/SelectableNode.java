package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableNode;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SelectableNode extends ClickableNode {
    public boolean selected;

    @Override // androidx.compose.foundation.AbstractClickableNode
    public final void applyAdditionalSemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setSelected(semanticsPropertyReceiver, this.selected);
    }
}
