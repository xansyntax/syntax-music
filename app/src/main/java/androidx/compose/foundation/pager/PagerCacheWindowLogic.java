package androidx.compose.foundation.pager;

import androidx.compose.foundation.ScrollKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.MultiLaneCacheWindow;
import androidx.compose.ui.draw.DrawResult;
import androidx.emoji2.text.EmojiProcessor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PagerCacheWindowLogic implements CacheWindowLogic {
    public final /* synthetic */ MultiLaneCacheWindow $$delegate_0;
    public final EmojiProcessor cacheWindowScope;
    public final LazyLayoutPrefetchState state;

    public PagerCacheWindowLogic(DrawResult drawResult, LazyLayoutPrefetchState lazyLayoutPrefetchState, PagerState$$ExternalSyntheticLambda2 pagerState$$ExternalSyntheticLambda2) {
        this.$$delegate_0 = new MultiLaneCacheWindow(drawResult, new ScrollKt$$ExternalSyntheticLambda0((byte) 20));
        this.state = lazyLayoutPrefetchState;
        this.cacheWindowScope = new EmojiProcessor((byte) 4, (Object) pagerState$$ExternalSyntheticLambda2);
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

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowLogic
    public final void resetStrategy() {
        this.$$delegate_0.resetStrategy();
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowLogic
    public final void setHasLookaheadOccurred() {
        this.$$delegate_0.hasLookaheadOccurred = true;
    }
}
