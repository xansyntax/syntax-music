package androidx.media3.exoplayer.offline;

import android.net.Uri;
import android.os.SystemClock;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.datasource.cache.CacheWriter;
import androidx.media3.datasource.cache.ContentMetadata;
import androidx.media3.datasource.cache.SimpleCache;
import coil3.size.SizeKt;
import coil3.util.UtilsKt;
import com.metrolist.music.playback.DownloadUtil$$ExternalSyntheticLambda2;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ProgressiveDownloader {
    public final CacheWriter cacheWriter;
    public final CacheDataSource dataSource;
    public final DataSpec dataSpec;
    public volatile AnonymousClass1 downloadRunnable;
    public final DownloadUtil$$ExternalSyntheticLambda2 executor;
    public volatile boolean isCanceled;
    public DownloadManager.Task progressListener;

    public ProgressiveDownloader(MediaItem mediaItem, CacheDataSource.Factory factory, DownloadUtil$$ExternalSyntheticLambda2 downloadUtil$$ExternalSyntheticLambda2, long j, long j2) {
        this.executor = downloadUtil$$ExternalSyntheticLambda2;
        MediaItem.LocalConfiguration localConfiguration = mediaItem.localConfiguration;
        localConfiguration.getClass();
        Map map = Collections.EMPTY_MAP;
        Uri uri = localConfiguration.uri;
        String str = localConfiguration.customCacheKey;
        UtilsKt.checkNotNull(uri, "The uri must be set.");
        DataSpec dataSpec = new DataSpec(uri, 0L, 1, null, map, j, j2, str, 4);
        this.dataSpec = dataSpec;
        DataSource.Factory factory2 = factory.upstreamDataSourceFactory;
        CacheDataSource cacheDataSourceCreateDataSourceInternal = factory.createDataSourceInternal(factory2 != null ? factory2.createDataSource() : null, factory.flags | 1);
        this.dataSource = cacheDataSourceCreateDataSourceInternal;
        this.cacheWriter = new CacheWriter(cacheDataSourceCreateDataSourceInternal, dataSpec, new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 17, this));
    }

    public final void download(DownloadManager.Task task) {
        this.progressListener = task;
        try {
            if (!this.isCanceled) {
                this.downloadRunnable = new AnonymousClass1();
                this.executor.execute(this.downloadRunnable);
                try {
                    this.downloadRunnable.get();
                } catch (ExecutionException e) {
                    Throwable cause = e.getCause();
                    cause.getClass();
                    if (cause instanceof IOException) {
                        throw ((IOException) cause);
                    }
                    String str = Util.DEVICE_DEBUG_INFO;
                    throw cause;
                }
            }
            AnonymousClass1 anonymousClass1 = this.downloadRunnable;
            anonymousClass1.getClass();
            anonymousClass1.finished.blockUninterruptible();
        } catch (Throwable th) {
            AnonymousClass1 anonymousClass2 = this.downloadRunnable;
            anonymousClass2.getClass();
            anonymousClass2.finished.blockUninterruptible();
            throw th;
        }
    }

    /* JADX INFO: renamed from: androidx.media3.exoplayer.offline.ProgressiveDownloader$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements RunnableFuture {
        public boolean canceled;
        public Exception exception;
        public Thread workThread;
        public final ConditionVariable started = new ConditionVariable(0);
        public final ConditionVariable finished = new ConditionVariable(0);
        public final Object cancelLock = new Object();

        public AnonymousClass1() {
        }

        @Override // java.util.concurrent.Future
        public final boolean cancel(boolean z) {
            boolean z2;
            synchronized (this.cancelLock) {
                try {
                    if (!this.canceled) {
                        ConditionVariable conditionVariable = this.finished;
                        synchronized (conditionVariable) {
                            z2 = conditionVariable.isOpen;
                        }
                        if (!z2) {
                            this.canceled = true;
                            ProgressiveDownloader.this.cacheWriter.isCanceled = true;
                            Thread thread = this.workThread;
                            if (thread == null) {
                                this.started.open();
                                this.finished.open();
                            } else if (z) {
                                thread.interrupt();
                            }
                            return true;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void doWork() throws Exception {
            long j;
            long j2;
            long j3;
            long j4;
            long jOpen;
            long j5;
            CacheWriter cacheWriter = ProgressiveDownloader.this.cacheWriter;
            if (cacheWriter.isCanceled) {
                throw new InterruptedIOException();
            }
            SimpleCache simpleCache = cacheWriter.cache;
            String str = cacheWriter.cacheKey;
            DataSpec dataSpec = cacheWriter.dataSpec;
            long j6 = dataSpec.position;
            long j7 = dataSpec.length;
            synchronized (simpleCache) {
                j = -1;
                long j8 = j7 == -1 ? Long.MAX_VALUE : j7 + j6;
                j2 = 0;
                long j9 = j8 < 0 ? Long.MAX_VALUE : j8;
                long j10 = 0;
                while (j6 < j9) {
                    long j11 = j10;
                    long cachedLength = simpleCache.getCachedLength(j6, j9 - j6, str);
                    if (cachedLength > 0) {
                        j11 += cachedLength;
                    } else {
                        cachedLength = -cachedLength;
                    }
                    j6 += cachedLength;
                    j10 = j11;
                }
                j3 = j10;
            }
            cacheWriter.bytesCached = j3;
            DataSpec dataSpec2 = cacheWriter.dataSpec;
            long j12 = dataSpec2.length;
            if (j12 != -1) {
                j4 = dataSpec2.position + j12;
                cacheWriter.endPosition = j4;
            } else {
                long contentLength = ContentMetadata.getContentLength(cacheWriter.cache.getContentMetadata(cacheWriter.cacheKey));
                j4 = contentLength == -1 ? -1L : contentLength;
                cacheWriter.endPosition = j4;
            }
            cacheWriter.progressListener.onProgress(j4 == -1 ? -1L : j4 - cacheWriter.dataSpec.position, cacheWriter.bytesCached);
            while (true) {
                long j13 = cacheWriter.endPosition;
                if (j13 != j && cacheWriter.nextPosition >= j13) {
                    return;
                }
                if (cacheWriter.isCanceled) {
                    throw new InterruptedIOException();
                }
                long j14 = cacheWriter.endPosition;
                long cachedLength2 = cacheWriter.cache.getCachedLength(cacheWriter.nextPosition, j14 == j ? Long.MAX_VALUE : j14 - cacheWriter.nextPosition, cacheWriter.cacheKey);
                if (cachedLength2 > j2) {
                    cacheWriter.nextPosition += cachedLength2;
                    j5 = j;
                } else {
                    long j15 = -cachedLength2;
                    if (j15 == Long.MAX_VALUE) {
                        j15 = j;
                    }
                    long j16 = cacheWriter.nextPosition;
                    DataSpec dataSpec3 = cacheWriter.dataSpec;
                    CacheDataSource cacheDataSource = cacheWriter.dataSource;
                    boolean z = true;
                    int i = 0;
                    boolean z2 = j16 + j15 == cacheWriter.endPosition || j15 == j;
                    if (j15 != j) {
                        DataSpec.Builder builderBuildUpon = dataSpec3.buildUpon();
                        builderBuildUpon.position = j16;
                        builderBuildUpon.length = j15;
                        try {
                            jOpen = cacheDataSource.open(builderBuildUpon.build());
                        } catch (Exception unused) {
                            SizeKt.closeQuietly(cacheDataSource);
                            jOpen = j;
                            z = false;
                        }
                    } else {
                        jOpen = j;
                        z = false;
                    }
                    if (!z) {
                        if (cacheWriter.isCanceled) {
                            throw new InterruptedIOException();
                        }
                        DataSpec.Builder builderBuildUpon2 = dataSpec3.buildUpon();
                        builderBuildUpon2.position = j16;
                        builderBuildUpon2.length = j;
                        try {
                            jOpen = cacheDataSource.open(builderBuildUpon2.build());
                        } catch (Exception e) {
                            SizeKt.closeQuietly(cacheDataSource);
                            throw e;
                        }
                    }
                    if (z2 && jOpen != j) {
                        long j17 = jOpen + j16;
                        try {
                            if (cacheWriter.endPosition != j17) {
                                cacheWriter.endPosition = j17;
                                cacheWriter.progressListener.onProgress(j17 == j ? j : j17 - cacheWriter.dataSpec.position, cacheWriter.bytesCached);
                            }
                        } catch (Exception e2) {
                            SizeKt.closeQuietly(cacheDataSource);
                            throw e2;
                        }
                    }
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 != -1) {
                        if (cacheWriter.isCanceled) {
                            throw new InterruptedIOException();
                        }
                        byte[] bArr = cacheWriter.temporaryBuffer;
                        i2 = cacheDataSource.read(bArr, i, bArr.length);
                        if (i2 != -1) {
                            long j18 = j;
                            long j19 = cacheWriter.bytesCached + ((long) i2);
                            cacheWriter.bytesCached = j19;
                            OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 = cacheWriter.progressListener;
                            long j20 = cacheWriter.endPosition;
                            onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0.onProgress(j20 == j18 ? j18 : j20 - cacheWriter.dataSpec.position, j19);
                            i3 += i2;
                            j = j18;
                            i = 0;
                        }
                    }
                    j5 = j;
                    if (z2) {
                        long j21 = ((long) i3) + j16;
                        if (cacheWriter.endPosition != j21) {
                            cacheWriter.endPosition = j21;
                            cacheWriter.progressListener.onProgress(j21 == j5 ? j5 : j21 - cacheWriter.dataSpec.position, cacheWriter.bytesCached);
                        }
                    }
                    cacheDataSource.close();
                    cacheWriter.nextPosition = j16 + ((long) i3);
                }
                j = j5;
                j2 = 0;
            }
        }

        @Override // java.util.concurrent.Future
        public final Object get(long j, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
            boolean z;
            long jConvert = TimeUnit.MILLISECONDS.convert(j, timeUnit);
            ConditionVariable conditionVariable = this.finished;
            synchronized (conditionVariable) {
                try {
                    if (jConvert <= 0) {
                        z = conditionVariable.isOpen;
                    } else {
                        conditionVariable.clock.getClass();
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        long j2 = jConvert + jElapsedRealtime;
                        if (j2 < jElapsedRealtime) {
                            conditionVariable.block();
                        } else {
                            while (!conditionVariable.isOpen && jElapsedRealtime < j2) {
                                conditionVariable.clock.getClass();
                                conditionVariable.wait(j2 - jElapsedRealtime);
                                conditionVariable.clock.getClass();
                                jElapsedRealtime = SystemClock.elapsedRealtime();
                            }
                        }
                        z = conditionVariable.isOpen;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!z) {
                throw new TimeoutException();
            }
            if (this.canceled) {
                throw new CancellationException();
            }
            Exception exc = this.exception;
            if (exc == null) {
                return null;
            }
            throw new ExecutionException(exc);
        }

        @Override // java.util.concurrent.Future
        public final boolean isCancelled() {
            return this.canceled;
        }

        @Override // java.util.concurrent.Future
        public final boolean isDone() {
            boolean z;
            ConditionVariable conditionVariable = this.finished;
            synchronized (conditionVariable) {
                z = conditionVariable.isOpen;
            }
            return z;
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            synchronized (this.cancelLock) {
                try {
                    if (this.canceled) {
                        return;
                    }
                    this.workThread = Thread.currentThread();
                    this.started.open();
                    try {
                        try {
                            doWork();
                            synchronized (this.cancelLock) {
                                this.finished.open();
                                this.workThread = null;
                                Thread.interrupted();
                            }
                        } catch (Exception e) {
                            this.exception = e;
                            synchronized (this.cancelLock) {
                                this.finished.open();
                                this.workThread = null;
                                Thread.interrupted();
                            }
                        }
                    } catch (Throwable th) {
                        synchronized (this.cancelLock) {
                            this.finished.open();
                            this.workThread = null;
                            Thread.interrupted();
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // java.util.concurrent.Future
        public final Object get() throws ExecutionException {
            this.finished.block();
            if (!this.canceled) {
                Exception exc = this.exception;
                if (exc == null) {
                    return null;
                }
                throw new ExecutionException(exc);
            }
            throw new CancellationException();
        }
    }
}
