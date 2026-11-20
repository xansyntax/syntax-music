package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import coil3.util.FileSystemsKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListBeyondBoundsState implements LazyLayoutBeyondBoundsState {
    public final LazyListState state;

    public LazyListBeyondBoundsState(LazyListState lazyListState) {
        this.state = lazyListState;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState
    public final int getFirstPlacedIndex() {
        return Math.max(0, this.state.getFirstVisibleItemIndex());
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
        return Math.min(getItemCount() - 1, ((LazyListMeasuredItem) CollectionsKt.last(this.state.getLayoutInfo().visibleItemsInfo)).index);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState
    public final int itemsPerViewport() {
        int i;
        LazyListState lazyListState = this.state;
        if (lazyListState.getLayoutInfo().visibleItemsInfo.isEmpty()) {
            return 0;
        }
        LazyListMeasureResult layoutInfo = lazyListState.getLayoutInfo();
        int iM162getViewportSizeYbymL2g = (int) (layoutInfo.orientation == Orientation.Vertical ? layoutInfo.m162getViewportSizeYbymL2g() & 4294967295L : layoutInfo.m162getViewportSizeYbymL2g() >> 32);
        int iVisibleItemsAverageSize = FileSystemsKt.visibleItemsAverageSize(lazyListState.getLayoutInfo());
        if (iVisibleItemsAverageSize != 0 && (i = iM162getViewportSizeYbymL2g / iVisibleItemsAverageSize) >= 1) {
            return i;
        }
        return 1;
    }
}
