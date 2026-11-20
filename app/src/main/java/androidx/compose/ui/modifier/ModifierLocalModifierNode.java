package androidx.compose.ui.modifier;

import androidx.compose.ui.node.DelegatableNode;
import androidx.sqlite.SQLite;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface ModifierLocalModifierNode extends DelegatableNode {
    default SQLite getProvidedValues() {
        return EmptyMap.INSTANCE;
    }
}
