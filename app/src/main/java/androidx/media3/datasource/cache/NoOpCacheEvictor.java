package androidx.media3.datasource.cache;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NoOpCacheEvictor implements CacheEvictor {
    @Override // androidx.media3.datasource.cache.CacheEvictor
    public final boolean requiresCacheSpanTouches() {
        return false;
    }

    @Override // androidx.media3.datasource.cache.CacheEvictor
    public final void onSpanRemoved(SimpleCacheSpan simpleCacheSpan) {
    }

    @Override // androidx.media3.datasource.cache.CacheEvictor
    public final void onSpanAdded(SimpleCache simpleCache, SimpleCacheSpan simpleCacheSpan) {
    }

    @Override // androidx.media3.datasource.cache.CacheEvictor
    public final void onStartFile(SimpleCache simpleCache, long j) {
    }

    @Override // androidx.media3.datasource.cache.CacheEvictor
    public final void onSpanTouched(SimpleCache simpleCache, SimpleCacheSpan simpleCacheSpan, SimpleCacheSpan simpleCacheSpan2) {
    }
}
