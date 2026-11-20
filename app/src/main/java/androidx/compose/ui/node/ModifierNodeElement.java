package androidx.compose.ui.node;

import androidx.compose.foundation.FocusGroupNode;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusTargetNode;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ModifierNodeElement implements Modifier.Element {
    public Modifier.Node create() {
        FocusGroupNode focusGroupNode = new FocusGroupNode();
        focusGroupNode.delegate(new FocusTargetNode(2, null, 10));
        return focusGroupNode;
    }

    public void update(Modifier.Node node) {
    }
}
