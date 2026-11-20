package androidx.compose.foundation.lazy;

import androidx.collection.internal.Lock;
import androidx.compose.foundation.layout.OffsetKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.jvm.functions.Function1;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListState$prefetchScope$1 {
    public final /* synthetic */ LazyListState this$0;

    public /* synthetic */ LazyListState$prefetchScope$1(LazyListState lazyListState) {
        this.this$0 = lazyListState;
    }

    public static LazyLayoutPrefetchState.PrefetchHandle schedulePrefetch$default(LazyListState$prefetchScope$1 lazyListState$prefetchScope$1, int i) {
        LazyListState lazyListState = lazyListState$prefetchScope$1.this$0;
        Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            LazyListMeasureResult lazyListMeasureResult = (LazyListMeasureResult) lazyListState.layoutInfoState.getValue();
            return lazyListState.prefetchState.m177schedulePrecompositionAndPremeasure_EkL_Y$foundation(i, lazyListMeasureResult.childConstraints, lazyListState.executeRequestsInHighPriorityMode, new OffsetKt$$ExternalSyntheticLambda0(i, lazyListMeasureResult));
        } finally {
            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        }
    }

    public ConnectionPool getLayoutInfo() {
        return new ConnectionPool(this.this$0.getLayoutInfo());
    }
}
