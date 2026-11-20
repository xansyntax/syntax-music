package androidx.media3.datasource.cache;

import android.net.Uri;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.FileDataSource;
import androidx.media3.datasource.PlaceholderDataSource;
import androidx.media3.datasource.TeeDataSource;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import coil3.util.UtilsKt;
import java.io.InterruptedIOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CacheDataSource implements DataSource {
    public Uri actualUri;
    public final boolean blockOnCache;
    public long bytesRemaining;
    public final SimpleCache cache;
    public final DataSource cacheReadDataSource;
    public final TeeDataSource cacheWriteDataSource;
    public long checkCachePosition;
    public DataSource currentDataSource;
    public long currentDataSourceBytesRead;
    public DataSpec currentDataSpec;
    public SimpleCacheSpan currentHoleSpan;
    public boolean currentRequestIgnoresCache;
    public final boolean ignoreCacheForUnsetLengthRequests;
    public final boolean ignoreCacheOnError;
    public long readPosition;
    public DataSpec requestDataSpec;
    public boolean seenCacheError;
    public final DataSource upstreamDataSource;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Factory implements DataSource.Factory {
        public SimpleCache cache;
        public boolean cacheIsReadOnly;
        public final FileDataSource.Factory cacheReadDataSourceFactory = new FileDataSource.Factory();
        public byte flags;
        public DataSource.Factory upstreamDataSourceFactory;

        @Override // androidx.media3.datasource.DataSource.Factory
        public final DataSource createDataSource() {
            DataSource.Factory factory = this.upstreamDataSourceFactory;
            return createDataSourceInternal(factory != null ? factory.createDataSource() : null, this.flags);
        }

        public final CacheDataSource createDataSourceInternal(DataSource dataSource, int i) {
            SimpleCache simpleCache = this.cache;
            simpleCache.getClass();
            return new CacheDataSource(simpleCache, dataSource, this.cacheReadDataSourceFactory.createDataSource(), (this.cacheIsReadOnly || dataSource == null) ? null : new CacheDataSink(simpleCache), i);
        }
    }

    public CacheDataSource(SimpleCache simpleCache, DataSource dataSource, DataSource dataSource2, CacheDataSink cacheDataSink, int i) {
        this.cache = simpleCache;
        this.cacheReadDataSource = dataSource2;
        this.blockOnCache = (i & 1) != 0;
        this.ignoreCacheOnError = (i & 2) != 0;
        this.ignoreCacheForUnsetLengthRequests = (i & 4) != 0;
        if (dataSource != null) {
            this.upstreamDataSource = dataSource;
            this.cacheWriteDataSource = cacheDataSink != null ? new TeeDataSource(dataSource, cacheDataSink) : null;
        } else {
            this.upstreamDataSource = PlaceholderDataSource.INSTANCE;
            this.cacheWriteDataSource = null;
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final void addTransferListener(DefaultBandwidthMeter defaultBandwidthMeter) {
        defaultBandwidthMeter.getClass();
        this.cacheReadDataSource.addTransferListener(defaultBandwidthMeter);
        this.upstreamDataSource.addTransferListener(defaultBandwidthMeter);
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() {
        this.requestDataSpec = null;
        this.actualUri = null;
        this.readPosition = 0L;
        try {
            closeCurrentSource();
        } catch (Throwable th) {
            if (this.currentDataSource == this.cacheReadDataSource || (th instanceof Cache$CacheException)) {
                this.seenCacheError = true;
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void closeCurrentSource() {
        SimpleCache simpleCache = this.cache;
        DataSource dataSource = this.currentDataSource;
        if (dataSource == null) {
            return;
        }
        try {
            dataSource.close();
        } finally {
            this.currentDataSpec = null;
            this.currentDataSource = null;
            SimpleCacheSpan simpleCacheSpan = this.currentHoleSpan;
            if (simpleCacheSpan != null) {
                simpleCache.releaseHoleSpan(simpleCacheSpan);
                this.currentHoleSpan = null;
            }
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final Map getResponseHeaders() {
        return !(this.currentDataSource == this.cacheReadDataSource) ? this.upstreamDataSource.getResponseHeaders() : Collections.EMPTY_MAP;
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri getUri() {
        return this.actualUri;
    }

    @Override // androidx.media3.datasource.DataSource
    public final long open(DataSpec dataSpec) {
        long j;
        SimpleCache simpleCache = this.cache;
        try {
            String string = dataSpec.key;
            if (string == null) {
                string = dataSpec.uri.toString();
            }
            long j2 = dataSpec.position;
            long j3 = dataSpec.length;
            DataSpec.Builder builderBuildUpon = dataSpec.buildUpon();
            builderBuildUpon.key = string;
            DataSpec dataSpecBuild = builderBuildUpon.build();
            this.requestDataSpec = dataSpecBuild;
            Uri uri = dataSpecBuild.uri;
            byte[] bArr = (byte[]) simpleCache.getContentMetadata(string).metadata.get("exo_redir");
            Uri uri2 = null;
            String str = bArr != null ? new String(bArr, StandardCharsets.UTF_8) : null;
            if (str != null) {
                uri2 = Uri.parse(str);
            }
            if (uri2 != null) {
                uri = uri2;
            }
            this.actualUri = uri;
            this.readPosition = j2;
            long contentLength = -1;
            boolean z = (this.ignoreCacheOnError && this.seenCacheError) || (this.ignoreCacheForUnsetLengthRequests && j3 == -1);
            this.currentRequestIgnoresCache = z;
            if (z) {
                this.bytesRemaining = -1L;
                j = -1;
            } else {
                j = -1;
                contentLength = ContentMetadata.getContentLength(simpleCache.getContentMetadata(string));
                this.bytesRemaining = contentLength;
                if (contentLength != -1) {
                    contentLength -= j2;
                    this.bytesRemaining = contentLength;
                    if (contentLength < 0) {
                        throw new DataSourceException(2008);
                    }
                }
            }
            if (j3 != j) {
                contentLength = contentLength == j ? j3 : Math.min(contentLength, j3);
                this.bytesRemaining = contentLength;
            }
            if (contentLength > 0 || contentLength == j) {
                openNextSource(dataSpecBuild, false);
            }
            return j3 != j ? j3 : this.bytesRemaining;
        } catch (Throwable th) {
            if (this.currentDataSource == this.cacheReadDataSource || (th instanceof Cache$CacheException)) {
                this.seenCacheError = true;
            }
            throw th;
        }
    }

    public final void openNextSource(DataSpec dataSpec, boolean z) throws InterruptedIOException {
        SimpleCacheSpan simpleCacheSpanStartReadWriteNonBlocking;
        DataSpec dataSpecBuild;
        DataSource dataSource;
        String str = dataSpec.key;
        String str2 = Util.DEVICE_DEBUG_INFO;
        if (this.currentRequestIgnoresCache) {
            simpleCacheSpanStartReadWriteNonBlocking = null;
        } else {
            boolean z2 = this.blockOnCache;
            SimpleCache simpleCache = this.cache;
            long j = this.readPosition;
            if (z2) {
                try {
                    long j2 = this.bytesRemaining;
                    synchronized (simpleCache) {
                        simpleCache.checkInitialization();
                        while (true) {
                            simpleCacheSpanStartReadWriteNonBlocking = simpleCache.startReadWriteNonBlocking(j, j2, str);
                            if (simpleCacheSpanStartReadWriteNonBlocking != null) {
                                break;
                            } else {
                                simpleCache.wait();
                            }
                        }
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException();
                }
            } else {
                simpleCacheSpanStartReadWriteNonBlocking = simpleCache.startReadWriteNonBlocking(j, this.bytesRemaining, str);
            }
        }
        if (simpleCacheSpanStartReadWriteNonBlocking == null) {
            dataSource = this.upstreamDataSource;
            DataSpec.Builder builderBuildUpon = dataSpec.buildUpon();
            builderBuildUpon.position = this.readPosition;
            builderBuildUpon.length = this.bytesRemaining;
            dataSpecBuild = builderBuildUpon.build();
        } else if (simpleCacheSpanStartReadWriteNonBlocking.isCached) {
            Uri uriFromFile = Uri.fromFile(simpleCacheSpanStartReadWriteNonBlocking.file);
            long j3 = simpleCacheSpanStartReadWriteNonBlocking.position;
            long j4 = this.readPosition - j3;
            long jMin = simpleCacheSpanStartReadWriteNonBlocking.length - j4;
            long j5 = this.bytesRemaining;
            if (j5 != -1) {
                jMin = Math.min(jMin, j5);
            }
            DataSpec.Builder builderBuildUpon2 = dataSpec.buildUpon();
            builderBuildUpon2.uri = uriFromFile;
            builderBuildUpon2.uriPositionOffset = j3;
            builderBuildUpon2.position = j4;
            builderBuildUpon2.length = jMin;
            dataSpecBuild = builderBuildUpon2.build();
            dataSource = this.cacheReadDataSource;
        } else {
            long jMin2 = simpleCacheSpanStartReadWriteNonBlocking.length;
            long j6 = this.bytesRemaining;
            if (jMin2 == -1) {
                jMin2 = j6;
            } else if (j6 != -1) {
                jMin2 = Math.min(jMin2, j6);
            }
            DataSpec.Builder builderBuildUpon3 = dataSpec.buildUpon();
            builderBuildUpon3.position = this.readPosition;
            builderBuildUpon3.length = jMin2;
            dataSpecBuild = builderBuildUpon3.build();
            dataSource = this.cacheWriteDataSource;
            if (dataSource == null) {
                dataSource = this.upstreamDataSource;
                this.cache.releaseHoleSpan(simpleCacheSpanStartReadWriteNonBlocking);
                simpleCacheSpanStartReadWriteNonBlocking = null;
            }
        }
        this.checkCachePosition = (this.currentRequestIgnoresCache || dataSource != this.upstreamDataSource) ? Long.MAX_VALUE : this.readPosition + 102400;
        if (z) {
            UtilsKt.checkState(this.currentDataSource == this.upstreamDataSource);
            if (dataSource == this.upstreamDataSource) {
                return;
            }
            try {
                closeCurrentSource();
            } catch (Throwable th) {
                if (!simpleCacheSpanStartReadWriteNonBlocking.isCached) {
                    this.cache.releaseHoleSpan(simpleCacheSpanStartReadWriteNonBlocking);
                }
                throw th;
            }
        }
        if (simpleCacheSpanStartReadWriteNonBlocking != null && !simpleCacheSpanStartReadWriteNonBlocking.isCached) {
            this.currentHoleSpan = simpleCacheSpanStartReadWriteNonBlocking;
        }
        this.currentDataSource = dataSource;
        this.currentDataSpec = dataSpecBuild;
        this.currentDataSourceBytesRead = 0L;
        long jOpen = dataSource.open(dataSpecBuild);
        CacheFileMetadataIndex cacheFileMetadataIndex = new CacheFileMetadataIndex();
        if (dataSpecBuild.length == -1 && jOpen != -1) {
            this.bytesRemaining = jOpen;
            cacheFileMetadataIndex.checkAndSet(Long.valueOf(this.readPosition + jOpen), "exo_len");
        }
        if (!(this.currentDataSource == this.cacheReadDataSource)) {
            Uri uri = dataSource.getUri();
            this.actualUri = uri;
            Uri uri2 = dataSpec.uri.equals(uri) ? null : this.actualUri;
            if (uri2 == null) {
                ((ArrayList) cacheFileMetadataIndex.tableName).add("exo_redir");
                ((HashMap) cacheFileMetadataIndex.databaseProvider).remove("exo_redir");
            } else {
                cacheFileMetadataIndex.checkAndSet(uri2.toString(), "exo_redir");
            }
        }
        if (this.currentDataSource == this.cacheWriteDataSource) {
            this.cache.applyContentMetadataMutations(str, cacheFileMetadataIndex);
        }
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i, int i2) {
        int i3;
        long j;
        DataSource dataSource = this.cacheReadDataSource;
        if (i2 == 0) {
            return 0;
        }
        if (this.bytesRemaining == 0) {
            return -1;
        }
        DataSpec dataSpec = this.requestDataSpec;
        dataSpec.getClass();
        DataSpec dataSpec2 = this.currentDataSpec;
        dataSpec2.getClass();
        try {
            if (this.readPosition >= this.checkCachePosition) {
                openNextSource(dataSpec, true);
            }
            DataSource dataSource2 = this.currentDataSource;
            dataSource2.getClass();
            int i4 = dataSource2.read(bArr, i, i2);
            DataSource dataSource3 = this.currentDataSource;
            if (i4 != -1) {
                long j2 = i4;
                this.readPosition += j2;
                this.currentDataSourceBytesRead += j2;
                long j3 = this.bytesRemaining;
                if (j3 == -1) {
                    return i4;
                }
                this.bytesRemaining = j3 - j2;
                return i4;
            }
            if (!(dataSource3 == dataSource)) {
                j = -1;
                long j4 = dataSpec2.length;
                if (j4 != -1) {
                    i3 = i4;
                    if (this.currentDataSourceBytesRead < j4) {
                    }
                } else {
                    i3 = i4;
                }
                String str = dataSpec.key;
                String str2 = Util.DEVICE_DEBUG_INFO;
                this.bytesRemaining = 0L;
                if (!(dataSource3 == this.cacheWriteDataSource)) {
                    return i3;
                }
                CacheFileMetadataIndex cacheFileMetadataIndex = new CacheFileMetadataIndex();
                cacheFileMetadataIndex.checkAndSet(Long.valueOf(this.readPosition), "exo_len");
                this.cache.applyContentMetadataMutations(str, cacheFileMetadataIndex);
                return i3;
            }
            i3 = i4;
            j = -1;
            long j5 = this.bytesRemaining;
            if (j5 <= 0 && j5 != j) {
                return i3;
            }
            closeCurrentSource();
            openNextSource(dataSpec, false);
            return read(bArr, i, i2);
        } catch (Throwable th) {
            if (this.currentDataSource == dataSource || (th instanceof Cache$CacheException)) {
                this.seenCacheError = true;
            }
            throw th;
        }
    }
}
