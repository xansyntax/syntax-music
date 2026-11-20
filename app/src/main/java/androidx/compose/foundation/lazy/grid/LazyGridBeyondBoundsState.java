package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import androidx.sqlite.SQLite;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyGridBeyondBoundsState implements LazyLayoutBeyondBoundsState {
    public final LazyGridState state;

    public LazyGridBeyondBoundsState(LazyGridState lazyGridState) {
        this.state = lazyGridState;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState
    public final int getFirstPlacedIndex() {
        return this.state.getFirstVisibleItemIndex();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState
    public final boolean getHasVisibleItems() {
        return !this.state.getLayoutInfo().visibleItemsInfo.isEmpty();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState
    public final int getItemCount() {
        return this.state.getLayoutInfo().totalItemsCount;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState
    public final int getLastPlacedIndex() {
        return ((LazyGridMeasuredItem) CollectionsKt.last(this.state.getLayoutInfo().visibleItemsInfo)).index;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState
    public final int itemsPerViewport() {
        int i;
        LazyGridState lazyGridState = this.state;
        if (lazyGridState.getLayoutInfo().visibleItemsInfo.isEmpty()) {
            return 0;
        }
        LazyGridMeasureResult layoutInfo = lazyGridState.getLayoutInfo();
        int iM168getViewportSizeYbymL2g = (int) (layoutInfo.orientation == Orientation.Vertical ? layoutInfo.m168getViewportSizeYbymL2g() & 4294967295L : layoutInfo.m168getViewportSizeYbymL2g() >> 32);
        int iVisibleLinesAverageMainAxisSize = SQLite.visibleLinesAverageMainAxisSize(lazyGridState.getLayoutInfo());
        if (iVisibleLinesAverageMainAxisSize != 0 && (i = iM168getViewportSizeYbymL2g / iVisibleLinesAverageMainAxisSize) >= 1) {
            return i;
        }
        return 1;
    }
}
