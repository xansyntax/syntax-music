package androidx.compose.ui.node;

import androidx.compose.ui.semantics.SemanticsPropertyReceiver;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface SemanticsModifierNode extends DelegatableNode {
    void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver);

    default boolean getShouldClearDescendantSemantics() {
        return false;
    }

    default boolean getShouldMergeDescendantSemantics() {
        return false;
    }

    default boolean isImportantForBounds() {
        return true;
    }
}
