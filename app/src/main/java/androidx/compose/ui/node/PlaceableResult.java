package androidx.compose.ui.node;

import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.VerticalRuler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaceableResult implements OwnerScope {
    public final LookaheadCapablePlaceable placeable;
    public MeasureResult result;
    public final VerticalRuler ruler;

    public PlaceableResult(MeasureResult measureResult, LookaheadCapablePlaceable lookaheadCapablePlaceable, VerticalRuler verticalRuler) {
        this.result = measureResult;
        this.placeable = lookaheadCapablePlaceable;
        this.ruler = verticalRuler;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final boolean isValidOwnerScope() {
        return this.placeable.getCoordinates().isAttached$1();
    }
}
