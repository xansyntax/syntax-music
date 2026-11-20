package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import coil3.util.FileSystemsKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PagerBeyondBoundsState implements LazyLayoutBeyondBoundsState {
    public final byte beyondViewportPageCount;
    public final PagerState state;

    /* JADX WARN: Multi-variable type inference failed */
    public PagerBeyondBoundsState(PagerState pagerState, int i) {
        this.state = pagerState;
        this.beyondViewportPageCount = i;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState
    public final int getFirstPlacedIndex() {
        return Math.max(0, this.state.firstVisiblePage - this.beyondViewportPageCount);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState
    public final boolean getHasVisibleItems() {
        return !this.state.getLayoutInfo().visiblePagesInfo.isEmpty();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState
    public final int getItemCount() {
        return this.state.getPageCount();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState
    public final int getLastPlacedIndex() {
        PagerState pagerState = this.state;
        return Math.min(pagerState.getPageCount() - 1, ((MeasuredPage) CollectionsKt.last(pagerState.getLayoutInfo().visiblePagesInfo)).index + this.beyondViewportPageCount);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState
    public final int itemsPerViewport() {
        int i;
        PagerState pagerState = this.state;
        if (pagerState.getLayoutInfo().visiblePagesInfo.size() == 0) {
            return 0;
        }
        int mainAxisViewportSize = FileSystemsKt.getMainAxisViewportSize(pagerState.getLayoutInfo());
        int i2 = pagerState.getLayoutInfo().pageSize + pagerState.getLayoutInfo().pageSpacing;
        if (i2 != 0 && (i = mainAxisViewportSize / i2) >= 1) {
            return i;
        }
        return 1;
    }
}
