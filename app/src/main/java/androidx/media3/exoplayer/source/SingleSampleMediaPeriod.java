package androidx.media3.exoplayer.source;

import android.os.Looper;
import android.os.SystemClock;
import androidx.compose.animation.core.FloatTweenSpec;
import androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda10;
import androidx.compose.ui.platform.WeakCache;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.HttpDataSource$CleartextNotPermittedException;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.upstream.Loader.LoadTask;
import androidx.media3.exoplayer.util.ReleasableExecutor$1;
import androidx.media3.extractor.text.CueDecoder;
import coil3.size.SizeKt;
import coil3.util.UtilsKt;
import io.ktor.client.utils.CIOKt;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.time.InstantParseResult;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SingleSampleMediaPeriod implements MediaPeriod, Loader.Callback {
    public final DataSource.Factory dataSourceFactory;
    public final DataSpec dataSpec;
    public final StatusLine eventDispatcher;
    public final Format format;
    public final Loader loader;
    public boolean loadingFinished;
    public byte[] sampleData;
    public int sampleSize;
    public final ArrayList sampleStreams = new ArrayList();
    public final TrackGroupArray tracks;
    public final DefaultBandwidthMeter transferListener;

    public SingleSampleMediaPeriod(DataSpec dataSpec, DataSource.Factory factory, DefaultBandwidthMeter defaultBandwidthMeter, Format format, CueDecoder cueDecoder, StatusLine statusLine, ReleasableExecutor$1 releasableExecutor$1) {
        this.dataSpec = dataSpec;
        this.dataSourceFactory = factory;
        this.transferListener = defaultBandwidthMeter;
        this.format = format;
        this.eventDispatcher = statusLine;
        this.tracks = new TrackGroupArray(new TrackGroup("", format));
        this.loader = releasableExecutor$1 != null ? new Loader(releasableExecutor$1) : new Loader("SingleSampleMediaPeriod");
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean continueLoading(LoadingInfo loadingInfo) {
        if (!this.loadingFinished) {
            Loader loader = this.loader;
            if (!loader.isLoading() && loader.fatalError == null) {
                DataSource dataSourceCreateDataSource = this.dataSourceFactory.createDataSource();
                DefaultBandwidthMeter defaultBandwidthMeter = this.transferListener;
                if (defaultBandwidthMeter != null) {
                    dataSourceCreateDataSource.addTransferListener(defaultBandwidthMeter);
                }
                SourceLoadable sourceLoadable = new SourceLoadable(this.dataSpec, dataSourceCreateDataSource);
                Looper looperMyLooper = Looper.myLooper();
                looperMyLooper.getClass();
                loader.fatalError = null;
                Loader.LoadTask loadTask = loader.new LoadTask(looperMyLooper, sourceLoadable, this, 3, SystemClock.elapsedRealtime());
                UtilsKt.checkState(loader.currentTask == null);
                loader.currentTask = loadTask;
                loadTask.execute();
                return true;
            }
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long getBufferedPositionUs() {
        return this.loadingFinished ? Long.MIN_VALUE : 0L;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long getNextLoadPositionUs() {
        return (this.loadingFinished || this.loader.isLoading()) ? Long.MIN_VALUE : 0L;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final TrackGroupArray getTrackGroups() {
        return this.tracks;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean isLoading() {
        return this.loader.isLoading();
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final void onLoadCanceled(Loader.Loadable loadable, long j, long j2, boolean z) {
        SourceLoadable sourceLoadable = (SourceLoadable) loadable;
        StatsDataSource statsDataSource = sourceLoadable.dataSource;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable.dataSpec, statsDataSource.lastOpenedUri, statsDataSource.lastResponseHeaders, j, statsDataSource.bytesRead);
        FloatTweenSpec floatTweenSpec = new FloatTweenSpec(-1, null, Util.usToMs(0L), Util.usToMs(-9223372036854775807L));
        StatusLine statusLine = this.eventDispatcher;
        statusLine.dispatchEvent(new MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda2(statusLine, loadEventInfo, floatTweenSpec, (byte) 1));
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final void onLoadCompleted(Loader.Loadable loadable, long j, long j2) {
        SourceLoadable sourceLoadable = (SourceLoadable) loadable;
        StatsDataSource statsDataSource = sourceLoadable.dataSource;
        this.sampleSize = (int) statsDataSource.bytesRead;
        byte[] bArr = sourceLoadable.sampleData;
        bArr.getClass();
        this.sampleData = bArr;
        this.loadingFinished = true;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable.dataSpec, statsDataSource.lastOpenedUri, statsDataSource.lastResponseHeaders, j, this.sampleSize);
        FloatTweenSpec floatTweenSpec = new FloatTweenSpec(-1, this.format, Util.usToMs(0L), Util.usToMs(-9223372036854775807L));
        StatusLine statusLine = this.eventDispatcher;
        statusLine.dispatchEvent(new MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda2(statusLine, loadEventInfo, floatTweenSpec, (byte) 0));
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final InstantParseResult.Success onLoadError(Loader.Loadable loadable, long j, long j2, IOException iOException, int i) {
        long jMin;
        IOException iOException2;
        InstantParseResult.Success success;
        SourceLoadable sourceLoadable = (SourceLoadable) loadable;
        StatsDataSource statsDataSource = sourceLoadable.dataSource;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable.dataSpec, statsDataSource.lastOpenedUri, statsDataSource.lastResponseHeaders, j, statsDataSource.bytesRead);
        String str = Util.DEVICE_DEBUG_INFO;
        Throwable cause = iOException;
        while (true) {
            if (cause == null) {
                jMin = Math.min((i - 1) * CIOKt.DEFAULT_HTTP_POOL_SIZE, 5000);
                break;
            }
            if ((cause instanceof ParserException) || (cause instanceof FileNotFoundException) || (cause instanceof HttpDataSource$CleartextNotPermittedException) || (cause instanceof Loader.UnexpectedLoaderException) || ((cause instanceof DataSourceException) && ((DataSourceException) cause).reason == 2008)) {
                jMin = -9223372036854775807L;
                break;
            }
            cause = cause.getCause();
        }
        if (jMin == -9223372036854775807L || i >= 3) {
            iOException2 = iOException;
            Log.w("SingleSampleMediaPeriod", "Loading failed, treating as end-of-stream.", iOException2);
            this.loadingFinished = true;
            success = Loader.DONT_RETRY;
        } else {
            iOException2 = iOException;
            success = jMin != -9223372036854775807L ? new InstantParseResult.Success(0, jMin) : Loader.DONT_RETRY_FATAL;
        }
        int i2 = success.nanosecondsOfSecond;
        boolean z = i2 == 0 || i2 == 1;
        FloatTweenSpec floatTweenSpec = new FloatTweenSpec(-1, this.format, Util.usToMs(0L), Util.usToMs(-9223372036854775807L));
        StatusLine statusLine = this.eventDispatcher;
        statusLine.dispatchEvent(new MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda3(statusLine, loadEventInfo, floatTweenSpec, iOException2, !z));
        return success;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final void onLoadStarted(Loader.Loadable loadable, long j, long j2, int i) {
        SourceLoadable sourceLoadable = (SourceLoadable) loadable;
        DataSpec dataSpec = sourceLoadable.dataSpec;
        StatsDataSource statsDataSource = sourceLoadable.dataSource;
        LoadEventInfo loadEventInfo = i == 0 ? new LoadEventInfo(dataSpec, j) : new LoadEventInfo(dataSpec, statsDataSource.lastOpenedUri, statsDataSource.lastResponseHeaders, j, statsDataSource.bytesRead);
        FloatTweenSpec floatTweenSpec = new FloatTweenSpec(-1, this.format, Util.usToMs(0L), Util.usToMs(-9223372036854775807L));
        StatusLine statusLine = this.eventDispatcher;
        statusLine.dispatchEvent(new MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda1(statusLine, loadEventInfo, floatTweenSpec, i));
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void prepare(MediaPeriod.Callback callback, long j) {
        callback.onPrepared(this);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long readDiscontinuity() {
        return -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long seekToUs(long j) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.sampleStreams;
            if (i >= arrayList.size()) {
                return j;
            }
            SampleStreamImpl sampleStreamImpl = (SampleStreamImpl) arrayList.get(i);
            if (sampleStreamImpl.streamState == 2) {
                sampleStreamImpl.streamState = (byte) 1;
            }
            i++;
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        for (int i = 0; i < exoTrackSelectionArr.length; i++) {
            SampleStream sampleStream = sampleStreamArr[i];
            ArrayList arrayList = this.sampleStreams;
            if (sampleStream != null && (exoTrackSelectionArr[i] == null || !zArr[i])) {
                arrayList.remove(sampleStream);
                sampleStreamArr[i] = null;
            }
            if (sampleStreamArr[i] == null && exoTrackSelectionArr[i] != null) {
                SampleStreamImpl sampleStreamImpl = new SampleStreamImpl();
                arrayList.add(sampleStreamImpl);
                sampleStreamArr[i] = sampleStreamImpl;
                zArr2[i] = true;
            }
        }
        return j;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SampleStreamImpl implements SampleStream {
        public boolean notifiedDownstreamFormat;
        public byte streamState;

        public SampleStreamImpl() {
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final boolean isReady() {
            return SingleSampleMediaPeriod.this.loadingFinished;
        }

        public final void maybeNotifyDownstreamFormat() {
            SingleSampleMediaPeriod singleSampleMediaPeriod = SingleSampleMediaPeriod.this;
            Format format = singleSampleMediaPeriod.format;
            if (this.notifiedDownstreamFormat) {
                return;
            }
            StatusLine statusLine = singleSampleMediaPeriod.eventDispatcher;
            statusLine.dispatchEvent(new TextLinkScope$$ExternalSyntheticLambda10(statusLine, new FloatTweenSpec(MimeTypes.getTrackType(format.sampleMimeType), format, Util.usToMs(0L), -9223372036854775807L), (byte) 7));
            this.notifiedDownstreamFormat = true;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final int readData(WeakCache weakCache, DecoderInputBuffer decoderInputBuffer, int i) {
            maybeNotifyDownstreamFormat();
            SingleSampleMediaPeriod singleSampleMediaPeriod = SingleSampleMediaPeriod.this;
            boolean z = singleSampleMediaPeriod.loadingFinished;
            if (z && singleSampleMediaPeriod.sampleData == null) {
                this.streamState = (byte) 2;
            }
            byte b = this.streamState;
            if (b == 2) {
                decoderInputBuffer.addFlag(4);
                return -4;
            }
            if ((i & 2) != 0 || b == 0) {
                weakCache.referenceQueue = singleSampleMediaPeriod.format;
                this.streamState = (byte) 1;
                return -5;
            }
            if (!z) {
                return -3;
            }
            singleSampleMediaPeriod.sampleData.getClass();
            decoderInputBuffer.addFlag(1);
            decoderInputBuffer.timeUs = 0L;
            if ((i & 4) == 0) {
                decoderInputBuffer.ensureSpaceForWrite(singleSampleMediaPeriod.sampleSize);
                decoderInputBuffer.data.put(singleSampleMediaPeriod.sampleData, 0, singleSampleMediaPeriod.sampleSize);
            }
            if ((i & 1) == 0) {
                this.streamState = (byte) 2;
            }
            return -4;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final int skipData(long j) {
            maybeNotifyDownstreamFormat();
            if (j <= 0 || this.streamState == 2) {
                return 0;
            }
            this.streamState = (byte) 2;
            return 1;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final void maybeThrowError() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SourceLoadable implements Loader.Loadable {
        public final StatsDataSource dataSource;
        public final DataSpec dataSpec;
        public byte[] sampleData;

        public SourceLoadable(DataSpec dataSpec, DataSource dataSource) {
            LoadEventInfo.idSource.getAndIncrement();
            this.dataSpec = dataSpec;
            this.dataSource = new StatsDataSource(dataSource);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
        public final void load() {
            StatsDataSource statsDataSource = this.dataSource;
            statsDataSource.bytesRead = 0L;
            try {
                statsDataSource.open(this.dataSpec);
                int i = 0;
                while (i != -1) {
                    int i2 = (int) statsDataSource.bytesRead;
                    byte[] bArrCopyOf = this.sampleData;
                    if (bArrCopyOf == null) {
                        bArrCopyOf = new byte[1024];
                        this.sampleData = bArrCopyOf;
                    } else if (i2 == bArrCopyOf.length) {
                        bArrCopyOf = Arrays.copyOf(bArrCopyOf, bArrCopyOf.length * 2);
                        this.sampleData = bArrCopyOf;
                    }
                    i = statsDataSource.read(bArrCopyOf, i2, bArrCopyOf.length - i2);
                }
            } finally {
                SizeKt.closeQuietly(statsDataSource);
            }
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
        public final void cancelLoad() {
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void maybeThrowPrepareError() {
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void discardBuffer(long j) {
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final void reevaluateBuffer(long j) {
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        return j;
    }
}
