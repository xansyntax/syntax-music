package androidx.media3.datasource.cache;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface CacheEvictor {
    void onSpanAdded(SimpleCache simpleCache, SimpleCacheSpan simpleCacheSpan);

    void onSpanRemoved(SimpleCacheSpan simpleCacheSpan);

    void onSpanTouched(SimpleCache simpleCache, SimpleCacheSpan simpleCacheSpan, SimpleCacheSpan simpleCacheSpan2);

    void onStartFile(SimpleCache simpleCache, long j);

    boolean requiresCacheSpanTouches();
}
