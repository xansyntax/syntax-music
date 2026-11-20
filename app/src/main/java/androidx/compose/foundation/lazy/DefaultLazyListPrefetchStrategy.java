package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultLazyListPrefetchStrategy {
    public LazyLayoutPrefetchState.PrefetchHandle currentPrefetchHandle;
    public int indexToPrefetch;
    public float previousPassDelta;
    public int previousPassItemCount;
    public boolean wasScrollingForward;

    public static int calculateIndexToPrefetch(LazyListMeasureResult lazyListMeasureResult, boolean z) {
        return z ? ((LazyListMeasuredItem) CollectionsKt.last(lazyListMeasureResult.visibleItemsInfo)).index + 1 : ((LazyListMeasuredItem) CollectionsKt.first(lazyListMeasureResult.visibleItemsInfo)).index - 1;
    }
}
