package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.ScrollKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow;
import androidx.compose.foundation.lazy.layout.MultiLaneCacheWindow;
import androidx.compose.ui.platform.WeakCache;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyGridCacheWindowPrefetchStrategy implements CacheWindowLogic {
    public final /* synthetic */ MultiLaneCacheWindow $$delegate_0;
    public final WeakCache cacheWindowScope = new WeakCache((byte) 3, false);

    public LazyGridCacheWindowPrefetchStrategy(LazyLayoutCacheWindow lazyLayoutCacheWindow) {
        this.$$delegate_0 = new MultiLaneCacheWindow(lazyLayoutCacheWindow, new ScrollKt$$ExternalSyntheticLambda0((byte) 20));
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowLogic
    public final int[] getPerLaneCacheWindowEndItemIndex() {
        return this.$$delegate_0.perLaneCacheWindowEndItemIndex;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowLogic
    public final int[] getPerLaneCacheWindowStartIndex() {
        return this.$$delegate_0.perLaneCacheWindowStartIndex;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowLogic
    public final boolean hasValidBounds() {
        return this.$$delegate_0.hasValidBounds();
    }

    public final void onScroll(LazyGridState$prefetchScope$2$1 lazyGridState$prefetchScope$2$1, float f, LazyGridMeasureResult lazyGridMeasureResult) {
        WeakCache weakCache = this.cacheWindowScope;
        weakCache.values = lazyGridMeasureResult;
        weakCache.referenceQueue = lazyGridState$prefetchScope$2$1;
        this.$$delegate_0.onScroll(weakCache, f);
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowLogic
    public final void resetStrategy() {
        this.$$delegate_0.resetStrategy();
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowLogic
    public final void setHasLookaheadOccurred() {
        this.$$delegate_0.hasLookaheadOccurred = true;
    }
}
