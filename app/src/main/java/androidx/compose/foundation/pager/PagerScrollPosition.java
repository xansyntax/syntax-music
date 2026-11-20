package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PagerScrollPosition {
    public final ParcelableSnapshotMutableIntState currentPage$delegate;
    public final ParcelableSnapshotMutableFloatState currentPageOffsetFraction$delegate;
    public boolean hadFirstNotEmptyLayout;
    public Object lastKnownCurrentPageKey;
    public final LazyLayoutNearestRangeState nearestRangeState;
    public final PagerState state;

    public PagerScrollPosition(int i, float f, PagerState pagerState) {
        this.state = pagerState;
        this.currentPage$delegate = new ParcelableSnapshotMutableIntState(i);
        this.currentPageOffsetFraction$delegate = new ParcelableSnapshotMutableFloatState(f);
        this.nearestRangeState = new LazyLayoutNearestRangeState(i, 30, 100);
    }
}
