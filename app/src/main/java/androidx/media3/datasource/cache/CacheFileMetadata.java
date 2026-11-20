package androidx.media3.datasource.cache;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CacheFileMetadata {
    public final long lastTouchTimestamp;
    public final long length;

    public CacheFileMetadata(long j, long j2) {
        this.length = j;
        this.lastTouchTimestamp = j2;
    }
}
