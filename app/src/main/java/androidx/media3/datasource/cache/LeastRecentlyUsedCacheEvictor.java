package androidx.media3.datasource.cache;

import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LeastRecentlyUsedCacheEvictor implements CacheEvictor {
    public long currentSize;
    public final TreeSet leastRecentlyUsed = new TreeSet(new LeastRecentlyUsedCacheEvictor$$ExternalSyntheticLambda0());
    public final long maxBytes;

    public LeastRecentlyUsedCacheEvictor(long j) {
        this.maxBytes = j;
    }

    public final void evictCache(SimpleCache simpleCache, long j) {
        while (this.currentSize + j > this.maxBytes && !this.leastRecentlyUsed.isEmpty()) {
            SimpleCacheSpan simpleCacheSpan = (SimpleCacheSpan) this.leastRecentlyUsed.first();
            synchronized (simpleCache) {
                simpleCache.removeSpanInternal(simpleCacheSpan);
            }
        }
    }

    @Override // androidx.media3.datasource.cache.CacheEvictor
    public final void onSpanAdded(SimpleCache simpleCache, SimpleCacheSpan simpleCacheSpan) {
        this.leastRecentlyUsed.add(simpleCacheSpan);
        this.currentSize += simpleCacheSpan.length;
        evictCache(simpleCache, 0L);
    }

    @Override // androidx.media3.datasource.cache.CacheEvictor
    public final void onSpanRemoved(SimpleCacheSpan simpleCacheSpan) {
        this.leastRecentlyUsed.remove(simpleCacheSpan);
        this.currentSize -= simpleCacheSpan.length;
    }

    @Override // androidx.media3.datasource.cache.CacheEvictor
    public final void onSpanTouched(SimpleCache simpleCache, SimpleCacheSpan simpleCacheSpan, SimpleCacheSpan simpleCacheSpan2) {
        onSpanRemoved(simpleCacheSpan);
        onSpanAdded(simpleCache, simpleCacheSpan2);
    }

    @Override // androidx.media3.datasource.cache.CacheEvictor
    public final void onStartFile(SimpleCache simpleCache, long j) {
        if (j != -1) {
            evictCache(simpleCache, j);
        }
    }

    @Override // androidx.media3.datasource.cache.CacheEvictor
    public final boolean requiresCacheSpanTouches() {
        return true;
    }
}
