package androidx.media3.datasource.cache;

import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSpec;
import coil3.util.UtilsKt;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CacheDataSink {
    public ReusableBufferedOutputStream bufferedOutputStream;
    public final SimpleCache cache;
    public DataSpec dataSpec;
    public long dataSpecBytesWritten;
    public long dataSpecFragmentSize;
    public File file;
    public final long fragmentSize;
    public OutputStream outputStream;
    public long outputStreamBytesWritten;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CacheDataSinkException extends Cache$CacheException {
    }

    public CacheDataSink(SimpleCache simpleCache) {
        simpleCache.getClass();
        this.cache = simpleCache;
        this.fragmentSize = 5242880L;
    }

    public final void closeCurrentOutputStream() {
        OutputStream outputStream = this.outputStream;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            Util.closeQuietly(this.outputStream);
            this.outputStream = null;
            File file = this.file;
            this.file = null;
            SimpleCache simpleCache = this.cache;
            long j = this.outputStreamBytesWritten;
            synchronized (simpleCache) {
                if (file.exists()) {
                    if (j == 0) {
                        file.delete();
                        return;
                    }
                    SimpleCacheSpan simpleCacheSpanCreateCacheEntry = SimpleCacheSpan.createCacheEntry(file, j, -9223372036854775807L, simpleCache.contentIndex);
                    simpleCacheSpanCreateCacheEntry.getClass();
                    CachedContent cachedContent = simpleCache.contentIndex.get(simpleCacheSpanCreateCacheEntry.key);
                    cachedContent.getClass();
                    UtilsKt.checkState(cachedContent.isFullyLocked(simpleCacheSpanCreateCacheEntry.position, simpleCacheSpanCreateCacheEntry.length));
                    long contentLength = ContentMetadata.getContentLength(cachedContent.metadata);
                    if (contentLength != -1) {
                        UtilsKt.checkState(simpleCacheSpanCreateCacheEntry.position + simpleCacheSpanCreateCacheEntry.length <= contentLength);
                    }
                    if (simpleCache.fileIndex == null) {
                        simpleCache.addSpan(simpleCacheSpanCreateCacheEntry);
                        simpleCache.contentIndex.store();
                        simpleCache.notifyAll();
                        return;
                    }
                    try {
                        simpleCache.fileIndex.set(simpleCacheSpanCreateCacheEntry.length, simpleCacheSpanCreateCacheEntry.lastTouchTimestamp, file.getName());
                        simpleCache.addSpan(simpleCacheSpanCreateCacheEntry);
                        try {
                            simpleCache.contentIndex.store();
                            simpleCache.notifyAll();
                            return;
                        } catch (IOException e) {
                            throw new Cache$CacheException(e);
                        }
                    } catch (IOException e2) {
                        throw new Cache$CacheException(e2);
                    }
                    throw th;
                }
            }
        } catch (Throwable th) {
            Util.closeQuietly(this.outputStream);
            this.outputStream = null;
            File file2 = this.file;
            this.file = null;
            file2.delete();
            throw th;
        }
    }

    public final void openNextOutputStream(DataSpec dataSpec) {
        File cacheFile;
        long j = dataSpec.length;
        long jMin = j != -1 ? Math.min(j - this.dataSpecBytesWritten, this.dataSpecFragmentSize) : -1L;
        SimpleCache simpleCache = this.cache;
        String str = dataSpec.key;
        String str2 = Util.DEVICE_DEBUG_INFO;
        long j2 = dataSpec.position + this.dataSpecBytesWritten;
        synchronized (simpleCache) {
            try {
                simpleCache.checkInitialization();
                CachedContent cachedContent = simpleCache.contentIndex.get(str);
                cachedContent.getClass();
                UtilsKt.checkState(cachedContent.isFullyLocked(j2, jMin));
                if (!simpleCache.cacheDir.exists()) {
                    SimpleCache.createCacheDirectories(simpleCache.cacheDir);
                    simpleCache.removeStaleSpans();
                }
                simpleCache.evictor.onStartFile(simpleCache, jMin);
                File file = new File(simpleCache.cacheDir, Integer.toString(simpleCache.random.nextInt(10)));
                if (!file.exists()) {
                    SimpleCache.createCacheDirectories(file);
                }
                cacheFile = SimpleCacheSpan.getCacheFile(file, cachedContent.id, j2, System.currentTimeMillis());
            } catch (Throwable th) {
                throw th;
            }
        }
        this.file = cacheFile;
        FileOutputStream fileOutputStream = new FileOutputStream(this.file);
        ReusableBufferedOutputStream reusableBufferedOutputStream = this.bufferedOutputStream;
        if (reusableBufferedOutputStream == null) {
            this.bufferedOutputStream = new ReusableBufferedOutputStream(fileOutputStream, 20480);
        } else {
            reusableBufferedOutputStream.reset(fileOutputStream);
        }
        this.outputStream = this.bufferedOutputStream;
        this.outputStreamBytesWritten = 0L;
    }
}
