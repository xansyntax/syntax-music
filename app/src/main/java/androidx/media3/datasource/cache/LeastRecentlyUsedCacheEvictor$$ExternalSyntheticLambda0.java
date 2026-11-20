package androidx.media3.datasource.cache;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LeastRecentlyUsedCacheEvictor$$ExternalSyntheticLambda0 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        SimpleCacheSpan simpleCacheSpan = (SimpleCacheSpan) obj;
        SimpleCacheSpan simpleCacheSpan2 = (SimpleCacheSpan) obj2;
        long j = simpleCacheSpan.lastTouchTimestamp;
        long j2 = simpleCacheSpan2.lastTouchTimestamp;
        if (j - j2 == 0) {
            return simpleCacheSpan.compareTo(simpleCacheSpan2);
        }
        return j < j2 ? -1 : 1;
    }
}
