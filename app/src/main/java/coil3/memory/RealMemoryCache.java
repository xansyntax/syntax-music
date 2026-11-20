package coil3.memory;

import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RealMemoryCache {
    public final Object lock = new Object();
    public final RealStrongMemoryCache strongMemoryCache;
    public final PriorityQueue weakMemoryCache;

    public RealMemoryCache(RealStrongMemoryCache realStrongMemoryCache, PriorityQueue priorityQueue) {
        this.strongMemoryCache = realStrongMemoryCache;
        this.weakMemoryCache = priorityQueue;
    }

    public final void setMaxSize(long j) {
        synchronized (this.lock) {
            RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1 = (RealStrongMemoryCache$cache$1) this.strongMemoryCache.cache;
            realStrongMemoryCache$cache$1.maxSize = j;
            realStrongMemoryCache$cache$1.trimToSize(j);
        }
    }
}
