package androidx.compose.ui.node;

import androidx.compose.ui.layout.LayoutCoordinates;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface LayoutAwareModifierNode extends MeasuredSizeAwareModifierNode, DelegatableNode {
    default void onPlaced(LayoutCoordinates layoutCoordinates) {
    }

    @Override // androidx.compose.ui.node.MeasuredSizeAwareModifierNode
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    default void mo61onRemeasuredozmzZPI(long j) {
    }
}
