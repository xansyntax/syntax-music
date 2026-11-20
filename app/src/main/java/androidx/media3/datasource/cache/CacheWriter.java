package androidx.media3.datasource.cache;

import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.media3.datasource.DataSpec;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CacheWriter {
    public long bytesCached;
    public final SimpleCache cache;
    public final String cacheKey;
    public final CacheDataSource dataSource;
    public final DataSpec dataSpec;
    public long endPosition;
    public volatile boolean isCanceled;
    public long nextPosition;
    public final OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 progressListener;
    public final byte[] temporaryBuffer = new byte[131072];

    public CacheWriter(CacheDataSource cacheDataSource, DataSpec dataSpec, OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0) {
        this.dataSource = cacheDataSource;
        this.cache = cacheDataSource.cache;
        this.dataSpec = dataSpec;
        this.progressListener = onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
        String str = dataSpec.key;
        this.cacheKey = str == null ? dataSpec.uri.toString() : str;
        this.nextPosition = dataSpec.position;
    }
}
