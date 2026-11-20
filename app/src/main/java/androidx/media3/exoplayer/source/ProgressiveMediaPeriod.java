package androidx.media3.exoplayer.source;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda10;
import androidx.compose.animation.core.FloatTweenSpec;
import androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda10;
import androidx.compose.ui.platform.WeakCache;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.HttpDataSource$CleartextNotPermittedException;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.image.ImageRenderer;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.upstream.Loader.LoadTask;
import androidx.media3.exoplayer.util.ReleasableExecutor$1;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ForwardingSeekMap;
import androidx.media3.extractor.IndexSeekMap;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.media3.extractor.mp3.Mp3Extractor;
import androidx.media3.extractor.text.CueDecoder;
import coil3.memory.RealStrongMemoryCache$cache$1;
import coil3.size.SizeKt;
import coil3.util.UtilsKt;
import io.ktor.client.utils.CIOKt;
import io.ktor.http.HttpHeaders;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.time.InstantParseResult;
import okhttp3.Dispatcher;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ProgressiveMediaPeriod implements MediaPeriod, ExtractorOutput, Loader.Callback {
    public static final Format ICY_FORMAT;
    public static final Map ICY_METADATA_HEADERS;
    public final EmojiProcessor allocator;
    public MediaPeriod.Callback callback;
    public ControlledTrackOutput[] controlledTrackOutputs;
    public final String customCacheKey;
    public final DataSource dataSource;
    public int dataType;
    public final DrmSessionEventListener.EventDispatcher drmEventDispatcher;
    public final DrmSessionManager drmSessionManager;
    public long durationUs;
    public int enabledTrackCount;
    public int extractedSamplesCountAtStartOfLoad;
    public final Handler handler;
    public boolean haveAudioVideoTracks;
    public IcyHeaders icyHeaders;
    public boolean isLengthKnown;
    public boolean isLive;
    public boolean isSingleSample;
    public long lastSeekPositionUs;
    public final ProgressiveMediaSource listener;
    public final ConditionVariable loadCondition;
    public final CueDecoder loadErrorHandlingPolicy;
    public final Loader loader;
    public boolean loadingFinished;
    public final ProgressiveMediaPeriod$$ExternalSyntheticLambda0 maybeFinishPrepareRunnable;
    public final StatusLine mediaSourceEventDispatcher;
    public boolean notifyDiscontinuity;
    public final ProgressiveMediaPeriod$$ExternalSyntheticLambda0 onContinueLoadingRequestedRunnable;
    public boolean pendingDeferredRetry;
    public boolean pendingInitialDiscontinuity;
    public long pendingResetPositionUs;
    public boolean prepared;
    public final EmojiProcessor progressiveMediaExtractor;
    public boolean released;
    public TrackId[] sampleQueueTrackIds;
    public SampleQueue[] sampleQueues;
    public boolean sampleQueuesBuilt;
    public SeekMap seekMap;
    public boolean seenFirstTrackSelection;
    public final long singleSampleDurationUs;
    public final Format singleTrackFormat;
    public Dispatcher trackState;
    public final Uri uri;
    public final long continueLoadingCheckIntervalBytes = 1048576;
    public final long endPositionUs = Long.MIN_VALUE;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ExtractingLoadable implements Loader.Loadable {
        public final StatsDataSource dataSource;
        public DataSpec dataSpec;
        public final ProgressiveMediaPeriod extractorOutput;
        public TrackOutput icyTrackOutput;
        public volatile boolean loadCanceled;
        public final ConditionVariable loadCondition;
        public final EmojiProcessor progressiveMediaExtractor;
        public long seekTimeUs;
        public boolean seenIcyMetadata;
        public final Uri uri;
        public final PositionHolder positionHolder = new PositionHolder();
        public boolean pendingExtractorSeek = true;

        public ExtractingLoadable(Uri uri, DataSource dataSource, EmojiProcessor emojiProcessor, ProgressiveMediaPeriod progressiveMediaPeriod, ConditionVariable conditionVariable) {
            this.uri = uri;
            this.dataSource = new StatsDataSource(dataSource);
            this.progressiveMediaExtractor = emojiProcessor;
            this.extractorOutput = progressiveMediaPeriod;
            this.loadCondition = conditionVariable;
            LoadEventInfo.idSource.getAndIncrement();
            this.dataSpec = buildDataSpec(0L, null);
        }

        public final DataSpec buildDataSpec(long j, String str) {
            Map mapBuildKeepingLast = ProgressiveMediaPeriod.ICY_METADATA_HEADERS;
            if (str != null && !str.startsWith("W/")) {
                StatusLine statusLine = new StatusLine(4);
                statusLine.putAll(mapBuildKeepingLast.entrySet());
                statusLine.put(HttpHeaders.IfRange, str);
                mapBuildKeepingLast = statusLine.buildKeepingLast();
            }
            Map map = Collections.EMPTY_MAP;
            String str2 = ProgressiveMediaPeriod.this.customCacheKey;
            Uri uri = this.uri;
            UtilsKt.checkNotNull(uri, "The uri must be set.");
            return new DataSpec(uri, 0L, 1, null, mapBuildKeepingLast, j, -1L, str2, 6);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
        public final void cancelLoad() {
            this.loadCanceled = true;
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
        public final void load() {
            DataSource icyDataSource;
            Extractor extractor;
            int i;
            int i2 = 0;
            String str = null;
            while (i2 == 0 && !this.loadCanceled) {
                try {
                    long j = this.positionHolder.position;
                    DataSpec dataSpecBuildDataSpec = buildDataSpec(j, str);
                    this.dataSpec = dataSpecBuildDataSpec;
                    long jOpen = this.dataSource.open(dataSpecBuildDataSpec);
                    if (this.loadCanceled) {
                        if (i2 != 1 && this.progressiveMediaExtractor.getCurrentInputPosition() != -1) {
                            this.positionHolder.position = this.progressiveMediaExtractor.getCurrentInputPosition();
                        }
                        SizeKt.closeQuietly(this.dataSource);
                        return;
                    }
                    List list = (List) this.dataSource.dataSource.getResponseHeaders().get(HttpHeaders.ETag);
                    str = (list == null || list.isEmpty()) ? null : (String) list.get(0);
                    if (jOpen != -1) {
                        jOpen += j;
                        ProgressiveMediaPeriod progressiveMediaPeriod = ProgressiveMediaPeriod.this;
                        progressiveMediaPeriod.handler.post(new ProgressiveMediaPeriod$$ExternalSyntheticLambda0(progressiveMediaPeriod, (byte) 0));
                    }
                    long j2 = jOpen;
                    ProgressiveMediaPeriod.this.icyHeaders = IcyHeaders.parse(this.dataSource.dataSource.getResponseHeaders());
                    StatsDataSource statsDataSource = this.dataSource;
                    IcyHeaders icyHeaders = ProgressiveMediaPeriod.this.icyHeaders;
                    if (icyHeaders == null || (i = icyHeaders.metadataInterval) == -1) {
                        icyDataSource = statsDataSource;
                    } else {
                        icyDataSource = new IcyDataSource(statsDataSource, i, this);
                        TrackOutput trackOutputPrepareTrackOutput = ProgressiveMediaPeriod.this.prepareTrackOutput(new TrackId(0, true));
                        this.icyTrackOutput = trackOutputPrepareTrackOutput;
                        trackOutputPrepareTrackOutput.format(ProgressiveMediaPeriod.ICY_FORMAT);
                    }
                    this.progressiveMediaExtractor.init(icyDataSource, this.uri, this.dataSource.dataSource.getResponseHeaders(), j, j2, this.extractorOutput);
                    if (ProgressiveMediaPeriod.this.icyHeaders != null && (extractor = (Extractor) this.progressiveMediaExtractor.mMetadataRepo) != null && (extractor instanceof Mp3Extractor)) {
                        ((Mp3Extractor) extractor).disableSeeking = true;
                    }
                    if (this.pendingExtractorSeek) {
                        EmojiProcessor emojiProcessor = this.progressiveMediaExtractor;
                        long j3 = this.seekTimeUs;
                        Extractor extractor2 = (Extractor) emojiProcessor.mMetadataRepo;
                        extractor2.getClass();
                        extractor2.seek(j, j3);
                        this.pendingExtractorSeek = false;
                    }
                    while (i2 == 0 && !this.loadCanceled) {
                        try {
                            this.loadCondition.block();
                            EmojiProcessor emojiProcessor2 = this.progressiveMediaExtractor;
                            PositionHolder positionHolder = this.positionHolder;
                            Extractor extractor3 = (Extractor) emojiProcessor2.mMetadataRepo;
                            extractor3.getClass();
                            DefaultExtractorInput defaultExtractorInput = (DefaultExtractorInput) emojiProcessor2.mGlyphChecker;
                            defaultExtractorInput.getClass();
                            i2 = extractor3.read(defaultExtractorInput, positionHolder);
                            long currentInputPosition = this.progressiveMediaExtractor.getCurrentInputPosition();
                            if (currentInputPosition > ProgressiveMediaPeriod.this.continueLoadingCheckIntervalBytes + j) {
                                ConditionVariable conditionVariable = this.loadCondition;
                                synchronized (conditionVariable) {
                                    conditionVariable.isOpen = false;
                                }
                                ProgressiveMediaPeriod progressiveMediaPeriod2 = ProgressiveMediaPeriod.this;
                                progressiveMediaPeriod2.handler.post(progressiveMediaPeriod2.onContinueLoadingRequestedRunnable);
                                j = currentInputPosition;
                            }
                        } catch (InterruptedException unused) {
                            throw new InterruptedIOException();
                        }
                    }
                    if (i2 == 1) {
                        i2 = 0;
                    } else if (this.progressiveMediaExtractor.getCurrentInputPosition() != -1) {
                        this.positionHolder.position = this.progressiveMediaExtractor.getCurrentInputPosition();
                    }
                    SizeKt.closeQuietly(this.dataSource);
                } catch (Throwable th) {
                    if (i2 != 1 && this.progressiveMediaExtractor.getCurrentInputPosition() != -1) {
                        this.positionHolder.position = this.progressiveMediaExtractor.getCurrentInputPosition();
                    }
                    SizeKt.closeQuietly(this.dataSource);
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SampleStreamImpl implements SampleStream {
        public final int track;

        public SampleStreamImpl(int i) {
            this.track = i;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final boolean isReady() {
            ProgressiveMediaPeriod progressiveMediaPeriod = ProgressiveMediaPeriod.this;
            return !progressiveMediaPeriod.suppressRead() && progressiveMediaPeriod.sampleQueues[this.track].isReady(progressiveMediaPeriod.loadingFinished);
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final void maybeThrowError() throws IOException {
            int i = this.track;
            ProgressiveMediaPeriod progressiveMediaPeriod = ProgressiveMediaPeriod.this;
            SampleQueue sampleQueue = progressiveMediaPeriod.sampleQueues[i];
            DrmSession drmSession = sampleQueue.currentDrmSession;
            if (drmSession != null && drmSession.getState() == 1) {
                DrmSession.DrmSessionException error = sampleQueue.currentDrmSession.getError();
                error.getClass();
                throw error;
            }
            Loader loader = progressiveMediaPeriod.loader;
            int minimumLoadableRetryCount = progressiveMediaPeriod.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(progressiveMediaPeriod.dataType);
            IOException iOException = loader.fatalError;
            if (iOException != null) {
                throw iOException;
            }
            Loader.LoadTask loadTask = loader.currentTask;
            if (loadTask != null) {
                if (minimumLoadableRetryCount == Integer.MIN_VALUE) {
                    minimumLoadableRetryCount = loadTask.defaultMinRetryCount;
                }
                IOException iOException2 = loadTask.currentError;
                if (iOException2 != null && loadTask.errorCount > minimumLoadableRetryCount) {
                    throw iOException2;
                }
            }
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final int readData(WeakCache weakCache, DecoderInputBuffer decoderInputBuffer, int i) {
            int i2;
            ProgressiveMediaPeriod progressiveMediaPeriod = ProgressiveMediaPeriod.this;
            int i3 = this.track;
            if (progressiveMediaPeriod.suppressRead()) {
                return -3;
            }
            progressiveMediaPeriod.maybeNotifyDownstreamFormat(i3);
            SampleQueue sampleQueue = progressiveMediaPeriod.sampleQueues[i3];
            boolean z = progressiveMediaPeriod.loadingFinished;
            sampleQueue.getClass();
            boolean z2 = (i & 2) != 0;
            ImageRenderer.TileInfo tileInfo = sampleQueue.extrasHolder;
            synchronized (sampleQueue) {
                decoderInputBuffer.waitingForKeys = false;
                int i4 = sampleQueue.absoluteFirstIndex;
                int i5 = sampleQueue.readPosition;
                int i6 = i4 + i5;
                int i7 = sampleQueue.readEndTimeAbsoluteIndex;
                boolean z3 = i7 != -1 && i6 >= i7;
                if (!(i5 != sampleQueue.length) || z3) {
                    if (!z && !sampleQueue.isLastSampleQueued && !z3) {
                        Format format = sampleQueue.upstreamFormat;
                        if (format == null || (!z2 && format == sampleQueue.downstreamFormat)) {
                            i2 = -3;
                        } else {
                            sampleQueue.onFormatResult(format, weakCache);
                            i2 = -5;
                        }
                    }
                    decoderInputBuffer.flags = 4;
                    decoderInputBuffer.timeUs = Long.MIN_VALUE;
                    i2 = -4;
                } else {
                    Format format2 = ((SampleQueue.SharedSampleMetadata) sampleQueue.sharedSampleMetadata.m1910get(i6)).format;
                    if (!z2 && format2 == sampleQueue.downstreamFormat) {
                        int relativeIndex = sampleQueue.getRelativeIndex(sampleQueue.readPosition);
                        if (sampleQueue.mayReadSample(relativeIndex)) {
                            decoderInputBuffer.flags = sampleQueue.flags[relativeIndex];
                            if (sampleQueue.readPosition == sampleQueue.length - 1 && (z || sampleQueue.isLastSampleQueued)) {
                                decoderInputBuffer.addFlag(536870912);
                            }
                            decoderInputBuffer.timeUs = sampleQueue.timesUs[relativeIndex];
                            tileInfo.tileIndex = sampleQueue.sizes[relativeIndex];
                            tileInfo.presentationTimeUs = sampleQueue.offsets[relativeIndex];
                            tileInfo.tileBitmap = sampleQueue.cryptoDatas[relativeIndex];
                            i2 = -4;
                        } else {
                            decoderInputBuffer.waitingForKeys = true;
                            i2 = -3;
                        }
                    }
                    sampleQueue.onFormatResult(format2, weakCache);
                    i2 = -5;
                }
            }
            if (i2 == -4 && !decoderInputBuffer.getFlag(4)) {
                boolean z4 = (i & 1) != 0;
                if ((i & 4) == 0) {
                    SampleDataQueue sampleDataQueue = sampleQueue.sampleDataQueue;
                    ImageRenderer.TileInfo tileInfo2 = sampleQueue.extrasHolder;
                    RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1 = sampleDataQueue.readAllocationNode;
                    if (z4) {
                        SampleDataQueue.readSampleData(realStrongMemoryCache$cache$1, decoderInputBuffer, tileInfo2, sampleDataQueue.scratch);
                    } else {
                        sampleDataQueue.readAllocationNode = SampleDataQueue.readSampleData(realStrongMemoryCache$cache$1, decoderInputBuffer, tileInfo2, sampleDataQueue.scratch);
                    }
                }
                if (!z4) {
                    sampleQueue.readPosition++;
                }
            }
            if (i2 == -3) {
                progressiveMediaPeriod.maybeStartDeferredRetry(i3);
            }
            return i2;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final int skipData(long j) {
            int iFindSampleBefore;
            ProgressiveMediaPeriod progressiveMediaPeriod = ProgressiveMediaPeriod.this;
            int i = this.track;
            boolean z = false;
            if (progressiveMediaPeriod.suppressRead()) {
                return 0;
            }
            progressiveMediaPeriod.maybeNotifyDownstreamFormat(i);
            SampleQueue sampleQueue = progressiveMediaPeriod.sampleQueues[i];
            boolean z2 = progressiveMediaPeriod.loadingFinished;
            synchronized (sampleQueue) {
                int relativeIndex = sampleQueue.getRelativeIndex(sampleQueue.readPosition);
                int i2 = sampleQueue.readPosition;
                int i3 = sampleQueue.length;
                if ((i2 != i3) && j >= sampleQueue.timesUs[relativeIndex]) {
                    if (j <= sampleQueue.largestQueuedTimestampUs || !z2) {
                        iFindSampleBefore = sampleQueue.findSampleBefore(relativeIndex, i3 - i2, j, true);
                        if (iFindSampleBefore == -1) {
                        }
                    } else {
                        iFindSampleBefore = i3 - i2;
                    }
                }
                iFindSampleBefore = 0;
            }
            synchronized (sampleQueue) {
                if (iFindSampleBefore >= 0) {
                    try {
                        if (sampleQueue.readPosition + iFindSampleBefore <= sampleQueue.length) {
                            z = true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                UtilsKt.checkArgument(z);
                sampleQueue.readPosition += iFindSampleBefore;
            }
            if (iFindSampleBefore == 0) {
                progressiveMediaPeriod.maybeStartDeferredRetry(i);
            }
            return iFindSampleBefore;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TrackId {
        public final int id;
        public final boolean isIcyTrack;

        public TrackId(int i, boolean z) {
            this.id = i;
            this.isIcyTrack = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || TrackId.class != obj.getClass()) {
                return false;
            }
            TrackId trackId = (TrackId) obj;
            return this.id == trackId.id && this.isIcyTrack == trackId.isIcyTrack;
        }

        public final int hashCode() {
            return (this.id * 31) + (this.isIcyTrack ? 1 : 0);
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        ICY_METADATA_HEADERS = Collections.unmodifiableMap(map);
        Format.Builder builder = new Format.Builder();
        builder.id = "icy";
        builder.sampleMimeType = MimeTypes.normalizeMimeType("application/x-icy");
        ICY_FORMAT = new Format(builder);
    }

    public ProgressiveMediaPeriod(Uri uri, DataSource dataSource, EmojiProcessor emojiProcessor, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, CueDecoder cueDecoder, StatusLine statusLine, ProgressiveMediaSource progressiveMediaSource, EmojiProcessor emojiProcessor2, String str, Format format, long j, ReleasableExecutor$1 releasableExecutor$1) {
        this.uri = uri;
        this.dataSource = dataSource;
        this.drmSessionManager = drmSessionManager;
        this.drmEventDispatcher = eventDispatcher;
        this.loadErrorHandlingPolicy = cueDecoder;
        this.mediaSourceEventDispatcher = statusLine;
        this.listener = progressiveMediaSource;
        this.allocator = emojiProcessor2;
        this.customCacheKey = str;
        this.singleTrackFormat = format;
        this.loader = releasableExecutor$1 != null ? new Loader(releasableExecutor$1) : new Loader("ProgressiveMediaPeriod");
        this.progressiveMediaExtractor = emojiProcessor;
        this.singleSampleDurationUs = j;
        this.loadCondition = new ConditionVariable(0);
        this.maybeFinishPrepareRunnable = new ProgressiveMediaPeriod$$ExternalSyntheticLambda0(this, (byte) 1);
        this.onContinueLoadingRequestedRunnable = new ProgressiveMediaPeriod$$ExternalSyntheticLambda0(this, (byte) 2);
        this.handler = Util.createHandlerForCurrentLooper(null);
        this.sampleQueueTrackIds = new TrackId[0];
        this.sampleQueues = new SampleQueue[0];
        this.controlledTrackOutputs = new ControlledTrackOutput[0];
        this.pendingResetPositionUs = -9223372036854775807L;
        this.dataType = 1;
    }

    public final void assertPrepared() {
        UtilsKt.checkState(this.prepared);
        this.trackState.getClass();
        this.seekMap.getClass();
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean continueLoading(LoadingInfo loadingInfo) {
        if (this.loadingFinished) {
            return false;
        }
        Loader loader = this.loader;
        if (loader.fatalError != null || this.pendingDeferredRetry) {
            return false;
        }
        if ((this.prepared || this.singleTrackFormat != null) && this.enabledTrackCount == 0) {
            return false;
        }
        boolean zOpen = this.loadCondition.open();
        if (loader.isLoading()) {
            return zOpen;
        }
        startLoading();
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void discardBuffer(long j) {
        long jDiscardSamples;
        long j2;
        int i;
        if (this.isSingleSample) {
            return;
        }
        assertPrepared();
        if (isPendingReset()) {
            return;
        }
        boolean[] zArr = (boolean[]) this.trackState.runningAsyncCalls;
        int length = this.sampleQueues.length;
        int i2 = 0;
        while (i2 < length) {
            SampleQueue sampleQueue = this.sampleQueues[i2];
            boolean z = zArr[i2];
            SampleDataQueue sampleDataQueue = sampleQueue.sampleDataQueue;
            synchronized (sampleQueue) {
                try {
                    int i3 = sampleQueue.length;
                    jDiscardSamples = -1;
                    if (i3 != 0) {
                        long[] jArr = sampleQueue.timesUs;
                        int i4 = sampleQueue.relativeFirstIndex;
                        if (j < jArr[i4]) {
                            j2 = j;
                        } else {
                            j2 = j;
                            int iFindSampleBefore = sampleQueue.findSampleBefore(i4, (!z || (i = sampleQueue.readPosition) == i3) ? i3 : i + 1, j2, false);
                            if (iFindSampleBefore != -1) {
                                jDiscardSamples = sampleQueue.discardSamples(iFindSampleBefore);
                            }
                        }
                    } else {
                        j2 = j;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            sampleDataQueue.discardDownstreamTo(jDiscardSamples);
            i2++;
            j = j2;
        }
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public final void endTracks() {
        this.sampleQueuesBuilt = true;
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    /* JADX WARN: Code duplicated, block: B:73:0x00ce A[RETURN] */
    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        assertPrepared();
        if (!this.seekMap.isSeekable()) {
            return 0L;
        }
        SeekMap.SeekPoints seekPoints = this.seekMap.getSeekPoints(j);
        long j2 = seekPoints.first.timeUs;
        long j3 = seekPoints.second.timeUs;
        long j4 = seekParameters.toleranceAfterUs;
        long j5 = seekParameters.toleranceBeforeUs;
        if (j5 == 0 && j4 == 0) {
            return j;
        }
        String str = Util.DEVICE_DEBUG_INFO;
        long j6 = j - j5;
        long j7 = Long.MAX_VALUE;
        long j8 = (((j5 ^ j) > 0L ? 1 : ((j5 ^ j) == 0L ? 0 : -1)) >= 0) | (((j ^ j6) > 0L ? 1 : ((j ^ j6) == 0L ? 0 : -1)) >= 0) ? j6 : ((j6 >>> 63) ^ 1) + Long.MAX_VALUE;
        if ((j8 == Long.MIN_VALUE && j6 != Long.MIN_VALUE) || (j8 == Long.MAX_VALUE && j6 != Long.MAX_VALUE)) {
            j8 = Long.MIN_VALUE;
        }
        long j9 = j + j4;
        long j10 = (((j4 ^ j) > 0L ? 1 : ((j4 ^ j) == 0L ? 0 : -1)) < 0) | (((j ^ j9) > 0L ? 1 : ((j ^ j9) == 0L ? 0 : -1)) >= 0) ? j9 : ((j9 >>> 63) ^ 1) + Long.MAX_VALUE;
        if ((j10 != Long.MIN_VALUE || j9 == Long.MIN_VALUE) && (j10 != Long.MAX_VALUE || j9 == Long.MAX_VALUE)) {
            j7 = j10;
        }
        boolean z = j8 <= j2 && j2 <= j7;
        boolean z2 = j8 <= j3 && j3 <= j7;
        if (z && z2) {
            if (Math.abs(j2 - j) <= Math.abs(j3 - j)) {
                return j2;
            }
            return j3;
        }
        if (!z) {
            if (z2) {
                return j3;
            }
            return j8;
        }
        return j2;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long getBufferedPositionUs() {
        long largestQueuedTimestampUs;
        boolean z;
        long j;
        assertPrepared();
        if (this.loadingFinished || this.enabledTrackCount == 0) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if (this.haveAudioVideoTracks) {
            int length = this.sampleQueues.length;
            largestQueuedTimestampUs = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                Dispatcher dispatcher = this.trackState;
                if (((boolean[]) dispatcher.readyAsyncCalls)[i] && ((boolean[]) dispatcher.runningAsyncCalls)[i]) {
                    SampleQueue sampleQueue = this.sampleQueues[i];
                    synchronized (sampleQueue) {
                        z = sampleQueue.isLastSampleQueued;
                    }
                    if (z) {
                        continue;
                    } else {
                        SampleQueue sampleQueue2 = this.sampleQueues[i];
                        synchronized (sampleQueue2) {
                            j = sampleQueue2.largestQueuedTimestampUs;
                        }
                        largestQueuedTimestampUs = Math.min(largestQueuedTimestampUs, j);
                    }
                }
            }
        } else {
            largestQueuedTimestampUs = Long.MAX_VALUE;
        }
        if (largestQueuedTimestampUs == Long.MAX_VALUE) {
            largestQueuedTimestampUs = getLargestQueuedTimestampUs(false);
        }
        return largestQueuedTimestampUs == Long.MIN_VALUE ? this.lastSeekPositionUs : largestQueuedTimestampUs;
    }

    public final int getExtractedSamplesCount() {
        int i = 0;
        for (SampleQueue sampleQueue : this.sampleQueues) {
            i += sampleQueue.absoluteFirstIndex + sampleQueue.length;
        }
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x001c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:8:0x0017  */
    public final long getLargestQueuedTimestampUs(boolean z) {
        SampleQueue sampleQueue;
        long jMax = Long.MIN_VALUE;
        for (int i = 0; i < this.sampleQueues.length; i++) {
            if (z) {
                sampleQueue = this.sampleQueues[i];
                synchronized (sampleQueue) {
                    jMax = Math.max(jMax, sampleQueue.largestQueuedTimestampUs);
                }
            } else {
                Dispatcher dispatcher = this.trackState;
                dispatcher.getClass();
                if (((boolean[]) dispatcher.runningAsyncCalls)[i]) {
                    sampleQueue = this.sampleQueues[i];
                    synchronized (sampleQueue) {
                    }
                    jMax = Math.max(jMax, sampleQueue.largestQueuedTimestampUs);
                } else {
                    continue;
                }
            }
        }
        return jMax;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long getNextLoadPositionUs() {
        return getBufferedPositionUs();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final TrackGroupArray getTrackGroups() {
        assertPrepared();
        return (TrackGroupArray) this.trackState.executorServiceOrNull;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean isLoading() {
        boolean z;
        if (this.loadingFinished || !this.loader.isLoading()) {
            return false;
        }
        ConditionVariable conditionVariable = this.loadCondition;
        synchronized (conditionVariable) {
            z = conditionVariable.isOpen;
        }
        return z;
    }

    public final boolean isPendingReset() {
        return this.pendingResetPositionUs != -9223372036854775807L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:126:? -> B:107:0x017f). Please report as a decompilation issue!!! */
    public final void maybeFinishPrepare() {
        Metadata metadataCopyWithAppendedEntries;
        char c;
        long j = this.singleSampleDurationUs;
        if (this.released || this.prepared || !this.sampleQueuesBuilt || this.seekMap == null) {
            return;
        }
        char c2 = 0;
        for (SampleQueue sampleQueue : this.sampleQueues) {
            if (sampleQueue.getUpstreamFormat() == null) {
                return;
            }
        }
        ConditionVariable conditionVariable = this.loadCondition;
        synchronized (conditionVariable) {
            conditionVariable.isOpen = false;
        }
        int length = this.sampleQueues.length;
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            char c3 = 1;
            if (i2 >= length) {
                break;
            }
            Format upstreamFormat = this.sampleQueues[i2].getUpstreamFormat();
            upstreamFormat.getClass();
            int trackType = MimeTypes.getTrackType(upstreamFormat.sampleMimeType);
            if (trackType == 1) {
                c = 3;
            } else if (trackType == 2) {
                c = 4;
            } else if (trackType != 3) {
                c = trackType != 4 ? (char) 0 : (char) 2;
            } else {
                c = 1;
            }
            if (i == 1) {
                c3 = 3;
            } else if (i == 2) {
                c3 = 4;
            } else if (i != 3) {
                c3 = i != 4 ? (char) 0 : (char) 2;
            }
            if (c > c3) {
                i3 = i2;
                i = trackType;
            }
            i2++;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        boolean[] zArr = new boolean[length];
        int i4 = 0;
        while (i4 < length) {
            Format upstreamFormat2 = this.sampleQueues[i4].getUpstreamFormat();
            upstreamFormat2.getClass();
            String str = upstreamFormat2.sampleMimeType;
            boolean zIsAudio = MimeTypes.isAudio(str);
            boolean z = (zIsAudio || MimeTypes.isVideo(str)) ? true : c2;
            zArr[i4] = z;
            char c4 = c2;
            this.haveAudioVideoTracks = (this.haveAudioVideoTracks ? 1 : 0) | (z ? 1 : 0);
            this.isSingleSample = (j != -9223372036854775807L && length == 1 && MimeTypes.isImage(str)) ? 1 : c4;
            IcyHeaders icyHeaders = this.icyHeaders;
            if (icyHeaders != null) {
                int i5 = icyHeaders.bitrate;
                if (zIsAudio || this.sampleQueueTrackIds[i4].isIcyTrack) {
                    Metadata metadata = upstreamFormat2.metadata;
                    if (metadata == null) {
                        Metadata.Entry[] entryArr = new Metadata.Entry[1];
                        entryArr[c4] = icyHeaders;
                        metadataCopyWithAppendedEntries = new Metadata(entryArr);
                    } else {
                        Metadata.Entry[] entryArr2 = new Metadata.Entry[1];
                        entryArr2[c4] = icyHeaders;
                        metadataCopyWithAppendedEntries = metadata.copyWithAppendedEntries(entryArr2);
                    }
                    Format.Builder builderBuildUpon = upstreamFormat2.buildUpon();
                    builderBuildUpon.metadata = metadataCopyWithAppendedEntries;
                    upstreamFormat2 = new Format(builderBuildUpon);
                }
                if (zIsAudio && upstreamFormat2.averageBitrate == -1 && upstreamFormat2.peakBitrate == -1 && i5 != -1) {
                    Format.Builder builderBuildUpon2 = upstreamFormat2.buildUpon();
                    builderBuildUpon2.averageBitrate = i5;
                    upstreamFormat2 = new Format(builderBuildUpon2);
                }
            }
            int cryptoType = this.drmSessionManager.getCryptoType(upstreamFormat2);
            Format.Builder builderBuildUpon3 = upstreamFormat2.buildUpon();
            builderBuildUpon3.cryptoType = cryptoType;
            Format format = new Format(builderBuildUpon3);
            if (i4 != i3) {
                Format.Builder builderBuildUpon4 = format.buildUpon();
                builderBuildUpon4.primaryTrackGroupId = Integer.toString(i3);
                format = new Format(builderBuildUpon4);
            }
            trackGroupArr[i4] = new TrackGroup(Integer.toString(i4), format);
            this.pendingInitialDiscontinuity = format.hasPrerollSamples | this.pendingInitialDiscontinuity;
            SampleQueue sampleQueue2 = this.sampleQueues[i4];
            long j2 = this.endPositionUs;
            synchronized (sampleQueue2) {
                try {
                    if (j2 != sampleQueue2.readEndTimeUs) {
                        if (j2 == Long.MIN_VALUE) {
                            sampleQueue2.readEndTimeAbsoluteIndex = -1;
                        } else {
                            int iFindSampleAfter = j2 <= sampleQueue2.largestQueuedTimestampUs ? sampleQueue2.findSampleAfter(sampleQueue2.relativeFirstIndex, sampleQueue2.length, j2, false) : -1;
                            try {
                                sampleQueue2.readEndTimeAbsoluteIndex = iFindSampleAfter == -1 ? -1 : sampleQueue2.absoluteFirstIndex + iFindSampleAfter;
                                sampleQueue2.readEndTimeUs = j2;
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    sampleQueue2 = sampleQueue2;
                    throw th;
                }
            }
            i4++;
            c2 = c4;
        }
        this.trackState = new Dispatcher(new TrackGroupArray(trackGroupArr), zArr);
        if (this.isSingleSample && this.durationUs == -9223372036854775807L) {
            this.durationUs = j;
            this.seekMap = new ForwardingSeekMap(this.seekMap) { // from class: androidx.media3.exoplayer.source.ProgressiveMediaPeriod.1
                @Override // androidx.media3.extractor.ForwardingSeekMap, androidx.media3.extractor.SeekMap
                public final long getDurationUs() {
                    return ProgressiveMediaPeriod.this.durationUs;
                }
            };
        }
        this.listener.onSourceInfoRefreshed(this.durationUs, this.seekMap, this.isLive);
        this.prepared = true;
        MediaPeriod.Callback callback = this.callback;
        callback.getClass();
        callback.onPrepared(this);
    }

    public final void maybeNotifyDownstreamFormat(int i) {
        assertPrepared();
        Dispatcher dispatcher = this.trackState;
        boolean[] zArr = (boolean[]) dispatcher.runningSyncCalls;
        if (zArr[i]) {
            return;
        }
        Format format = ((TrackGroupArray) dispatcher.executorServiceOrNull).get(i).formats[0];
        StatusLine statusLine = this.mediaSourceEventDispatcher;
        statusLine.dispatchEvent(new TextLinkScope$$ExternalSyntheticLambda10((Object) statusLine, (Object) new FloatTweenSpec(MimeTypes.getTrackType(format.sampleMimeType), format, Util.usToMs(this.lastSeekPositionUs), -9223372036854775807L), (byte) 7));
        zArr[i] = true;
    }

    public final void maybeStartDeferredRetry(int i) {
        assertPrepared();
        if (this.pendingDeferredRetry) {
            if ((!this.haveAudioVideoTracks || ((boolean[]) this.trackState.readyAsyncCalls)[i]) && !this.sampleQueues[i].isReady(false)) {
                this.pendingResetPositionUs = 0L;
                this.pendingDeferredRetry = false;
                this.notifyDiscontinuity = true;
                this.lastSeekPositionUs = 0L;
                this.extractedSamplesCountAtStartOfLoad = 0;
                for (SampleQueue sampleQueue : this.sampleQueues) {
                    sampleQueue.reset(false);
                }
                MediaPeriod.Callback callback = this.callback;
                callback.getClass();
                callback.onContinueLoadingRequested(this);
            }
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void maybeThrowPrepareError() throws IOException {
        int minimumLoadableRetryCount = this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(this.dataType);
        Loader loader = this.loader;
        IOException iOException = loader.fatalError;
        if (iOException != null) {
            throw iOException;
        }
        Loader.LoadTask loadTask = loader.currentTask;
        if (loadTask != null) {
            if (minimumLoadableRetryCount == Integer.MIN_VALUE) {
                minimumLoadableRetryCount = loadTask.defaultMinRetryCount;
            }
            IOException iOException2 = loadTask.currentError;
            if (iOException2 != null && loadTask.errorCount > minimumLoadableRetryCount) {
                throw iOException2;
            }
        }
        if (this.loadingFinished && !this.prepared) {
            throw ParserException.createForMalformedContainer(null, "Loading finished before preparation is complete.");
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final void onLoadCanceled(Loader.Loadable loadable, long j, long j2, boolean z) {
        ExtractingLoadable extractingLoadable = (ExtractingLoadable) loadable;
        StatsDataSource statsDataSource = extractingLoadable.dataSource;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.dataSpec, statsDataSource.lastOpenedUri, statsDataSource.lastResponseHeaders, j, statsDataSource.bytesRead);
        long j3 = extractingLoadable.seekTimeUs;
        long j4 = this.durationUs;
        StatusLine statusLine = this.mediaSourceEventDispatcher;
        statusLine.dispatchEvent(new MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda2(statusLine, loadEventInfo, new FloatTweenSpec(-1, null, Util.usToMs(j3), Util.usToMs(j4)), (byte) 1));
        if (z) {
            return;
        }
        for (SampleQueue sampleQueue : this.sampleQueues) {
            sampleQueue.reset(false);
        }
        if (this.enabledTrackCount > 0) {
            MediaPeriod.Callback callback = this.callback;
            callback.getClass();
            callback.onContinueLoadingRequested(this);
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final void onLoadCompleted(Loader.Loadable loadable, long j, long j2) {
        ExtractingLoadable extractingLoadable = (ExtractingLoadable) loadable;
        if (this.durationUs == -9223372036854775807L && this.seekMap != null) {
            long largestQueuedTimestampUs = getLargestQueuedTimestampUs(true);
            long j3 = largestQueuedTimestampUs == Long.MIN_VALUE ? 0L : largestQueuedTimestampUs + 10000;
            this.durationUs = j3;
            this.listener.onSourceInfoRefreshed(j3, this.seekMap, this.isLive);
        }
        StatsDataSource statsDataSource = extractingLoadable.dataSource;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.dataSpec, statsDataSource.lastOpenedUri, statsDataSource.lastResponseHeaders, j, statsDataSource.bytesRead);
        long j4 = extractingLoadable.seekTimeUs;
        long j5 = this.durationUs;
        StatusLine statusLine = this.mediaSourceEventDispatcher;
        statusLine.dispatchEvent(new MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda2(statusLine, loadEventInfo, new FloatTweenSpec(-1, null, Util.usToMs(j4), Util.usToMs(j5)), (byte) 0));
        this.loadingFinished = true;
        MediaPeriod.Callback callback = this.callback;
        callback.getClass();
        callback.onContinueLoadingRequested(this);
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final InstantParseResult.Success onLoadError(Loader.Loadable loadable, long j, long j2, IOException iOException, int i) {
        long jMin;
        InstantParseResult.Success success;
        SeekMap seekMap;
        ExtractingLoadable extractingLoadable = (ExtractingLoadable) loadable;
        StatsDataSource statsDataSource = extractingLoadable.dataSource;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.dataSpec, statsDataSource.lastOpenedUri, statsDataSource.lastResponseHeaders, j, statsDataSource.bytesRead);
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
        if (jMin == -9223372036854775807L) {
            success = Loader.DONT_RETRY_FATAL;
        } else {
            int extractedSamplesCount = getExtractedSamplesCount();
            int i2 = extractedSamplesCount > this.extractedSamplesCountAtStartOfLoad ? 1 : 0;
            if (this.isLengthKnown || !((seekMap = this.seekMap) == null || seekMap.getDurationUs() == -9223372036854775807L)) {
                this.extractedSamplesCountAtStartOfLoad = extractedSamplesCount;
            } else if (!this.prepared || suppressRead()) {
                this.notifyDiscontinuity = this.prepared;
                this.lastSeekPositionUs = 0L;
                this.extractedSamplesCountAtStartOfLoad = 0;
                for (SampleQueue sampleQueue : this.sampleQueues) {
                    sampleQueue.reset(false);
                }
                extractingLoadable.positionHolder.position = 0L;
                extractingLoadable.seekTimeUs = 0L;
                extractingLoadable.pendingExtractorSeek = true;
                extractingLoadable.seenIcyMetadata = false;
            } else {
                this.pendingDeferredRetry = true;
                success = Loader.DONT_RETRY;
            }
            success = new InstantParseResult.Success(i2, jMin);
        }
        int i3 = success.nanosecondsOfSecond;
        boolean z = !(i3 == 0 || i3 == 1);
        FloatTweenSpec floatTweenSpec = new FloatTweenSpec(-1, null, Util.usToMs(extractingLoadable.seekTimeUs), Util.usToMs(this.durationUs));
        StatusLine statusLine = this.mediaSourceEventDispatcher;
        statusLine.dispatchEvent(new MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda3(statusLine, loadEventInfo, floatTweenSpec, iOException, z));
        return success;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    public final void onLoadStarted(Loader.Loadable loadable, long j, long j2, int i) {
        ExtractingLoadable extractingLoadable = (ExtractingLoadable) loadable;
        StatsDataSource statsDataSource = extractingLoadable.dataSource;
        LoadEventInfo loadEventInfo = i == 0 ? new LoadEventInfo(extractingLoadable.dataSpec, j) : new LoadEventInfo(extractingLoadable.dataSpec, statsDataSource.lastOpenedUri, statsDataSource.lastResponseHeaders, j, statsDataSource.bytesRead);
        FloatTweenSpec floatTweenSpec = new FloatTweenSpec(-1, null, Util.usToMs(extractingLoadable.seekTimeUs), Util.usToMs(this.durationUs));
        StatusLine statusLine = this.mediaSourceEventDispatcher;
        statusLine.dispatchEvent(new MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda1(statusLine, loadEventInfo, floatTweenSpec, i));
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void prepare(MediaPeriod.Callback callback, long j) {
        this.callback = callback;
        Format format = this.singleTrackFormat;
        if (format == null) {
            this.loadCondition.open();
            startLoading();
        } else {
            track(0, 3).format(format);
            setSeekMap(new IndexSeekMap(-9223372036854775807L, new long[]{0}, new long[]{0}));
            endTracks();
            this.pendingResetPositionUs = j;
        }
    }

    public final TrackOutput prepareTrackOutput(TrackId trackId) {
        int length = this.sampleQueues.length;
        for (int i = 0; i < length; i++) {
            if (trackId.equals(this.sampleQueueTrackIds[i])) {
                return this.sampleQueues[i];
            }
        }
        if (this.sampleQueuesBuilt) {
            Log.w("ProgressiveMediaPeriod", "Extractor added new track (id=" + trackId.id + ") after finishing tracks.");
            return new DiscardingTrackOutput();
        }
        SampleQueue sampleQueue = new SampleQueue(this.allocator, this.drmSessionManager, this.drmEventDispatcher);
        ControlledTrackOutput controlledTrackOutput = new ControlledTrackOutput(sampleQueue);
        sampleQueue.upstreamFormatChangeListener = this;
        int i2 = length + 1;
        TrackId[] trackIdArr = (TrackId[]) Arrays.copyOf(this.sampleQueueTrackIds, i2);
        trackIdArr[length] = trackId;
        String str = Util.DEVICE_DEBUG_INFO;
        this.sampleQueueTrackIds = trackIdArr;
        SampleQueue[] sampleQueueArr = (SampleQueue[]) Arrays.copyOf(this.sampleQueues, i2);
        sampleQueueArr[length] = sampleQueue;
        this.sampleQueues = sampleQueueArr;
        ControlledTrackOutput[] controlledTrackOutputArr = (ControlledTrackOutput[]) Arrays.copyOf(this.controlledTrackOutputs, i2);
        controlledTrackOutputArr[length] = controlledTrackOutput;
        this.controlledTrackOutputs = controlledTrackOutputArr;
        return controlledTrackOutput;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long readDiscontinuity() {
        if (this.pendingInitialDiscontinuity) {
            this.pendingInitialDiscontinuity = false;
            return this.lastSeekPositionUs;
        }
        if (!this.notifyDiscontinuity) {
            return -9223372036854775807L;
        }
        if (!this.loadingFinished && getExtractedSamplesCount() <= this.extractedSamplesCountAtStartOfLoad) {
            return -9223372036854775807L;
        }
        this.notifyDiscontinuity = false;
        return this.lastSeekPositionUs;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final void reevaluateBuffer(long j) {
        boolean z;
        if (this.enabledTrackCount <= 0 || isPendingReset()) {
            return;
        }
        boolean z2 = false;
        if (this.endPositionUs != Long.MIN_VALUE) {
            assertPrepared();
            boolean z3 = true;
            int i = 0;
            while (true) {
                SampleQueue[] sampleQueueArr = this.sampleQueues;
                if (i >= sampleQueueArr.length) {
                    break;
                }
                Dispatcher dispatcher = this.trackState;
                if (((boolean[]) dispatcher.runningAsyncCalls)[i] && (((boolean[]) dispatcher.readyAsyncCalls)[i] || !this.haveAudioVideoTracks)) {
                    SampleQueue sampleQueue = sampleQueueArr[i];
                    synchronized (sampleQueue) {
                        z = sampleQueue.readEndTimeAbsoluteIndex != -1;
                    }
                    z3 &= z;
                }
                i++;
            }
            z2 = z3;
        }
        if (z2) {
            this.loadingFinished = true;
        }
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public final void seekMap(SeekMap seekMap) {
        this.handler.post(new ComponentActivity$$ExternalSyntheticLambda10(this, seekMap, (byte) 28));
    }

    /* JADX WARN: Code duplicated, block: B:68:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bf A[LOOP:1: B:69:0x00bd->B:70:0x00bf, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:73:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:75:0x00dd A[LOOP:2: B:74:0x00db->B:75:0x00dd, LOOP_END] */
    /* JADX WARN: Instruction removed from duplicated block: B:68:0x00b9, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:73:0x00d2, please report this as an issue */
    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long seekToUs(long j) {
        int i;
        int i2;
        boolean zSeekTo;
        assertPrepared();
        boolean[] zArr = (boolean[]) this.trackState.readyAsyncCalls;
        if (!this.seekMap.isSeekable()) {
            j = 0;
        }
        this.notifyDiscontinuity = false;
        boolean z = this.lastSeekPositionUs == j;
        this.lastSeekPositionUs = j;
        if (isPendingReset()) {
            this.pendingResetPositionUs = j;
            return j;
        }
        if (this.dataType == 7 || !(this.loadingFinished || this.loader.isLoading())) {
            this.pendingDeferredRetry = false;
            this.pendingResetPositionUs = j;
            this.loadingFinished = false;
            this.pendingInitialDiscontinuity = false;
            if (this.loader.isLoading()) {
                this.loader.fatalError = null;
                for (SampleQueue sampleQueue : this.sampleQueues) {
                    sampleQueue.reset(false);
                }
                break;
            }
            for (SampleQueue sampleQueue2 : this.sampleQueues) {
                sampleQueue2.discardToEnd();
            }
            Loader.LoadTask loadTask = this.loader.currentTask;
            loadTask.getClass();
            loadTask.cancel(false);
            return j;
        }
        int length = this.sampleQueues.length;
        for (int i3 = 0; i3 < length; i3++) {
            SampleQueue sampleQueue3 = this.sampleQueues[i3];
            if (this.controlledTrackOutputs[i3].outputMode.get() == ControlledTrackOutput.OutputMode.PASS_THROUGH) {
                int i4 = sampleQueue3.absoluteFirstIndex;
                if (sampleQueue3.readPosition + i4 != 0 || !z) {
                    if (this.isSingleSample) {
                        synchronized (sampleQueue3) {
                            synchronized (sampleQueue3) {
                                sampleQueue3.readPosition = 0;
                                SampleDataQueue sampleDataQueue = sampleQueue3.sampleDataQueue;
                                sampleDataQueue.readAllocationNode = sampleDataQueue.firstAllocationNode;
                            }
                        }
                        int i5 = sampleQueue3.absoluteFirstIndex;
                        if (i4 >= i5 && i4 <= sampleQueue3.length + i5) {
                            int i6 = sampleQueue3.readEndTimeAbsoluteIndex;
                            if (i6 == -1 || i4 < i6) {
                                sampleQueue3.startTimeUs = Long.MIN_VALUE;
                                sampleQueue3.readPosition = i4 - i5;
                                zSeekTo = true;
                            }
                        }
                        zSeekTo = false;
                    } else {
                        zSeekTo = sampleQueue3.seekTo(j, this.loadingFinished);
                    }
                    if (!zSeekTo && (zArr[i3] || !this.haveAudioVideoTracks)) {
                        this.pendingDeferredRetry = false;
                        this.pendingResetPositionUs = j;
                        this.loadingFinished = false;
                        this.pendingInitialDiscontinuity = false;
                        if (this.loader.isLoading()) {
                            this.loader.fatalError = null;
                            while (i < r0) {
                                sampleQueue.reset(false);
                            }
                            break;
                            break;
                        }
                        while (i2 < r2) {
                            sampleQueue2.discardToEnd();
                        }
                        Loader.LoadTask loadTask2 = this.loader.currentTask;
                        loadTask2.getClass();
                        loadTask2.cancel(false);
                        return j;
                    }
                }
            }
        }
        return j;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        ExoTrackSelection exoTrackSelection;
        assertPrepared();
        Dispatcher dispatcher = this.trackState;
        TrackGroupArray trackGroupArray = (TrackGroupArray) dispatcher.executorServiceOrNull;
        boolean[] zArr3 = (boolean[]) dispatcher.runningAsyncCalls;
        int i = this.enabledTrackCount;
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            SampleStream sampleStream = sampleStreamArr[i2];
            if (sampleStream != null && (exoTrackSelectionArr[i2] == null || !zArr[i2])) {
                int i3 = ((SampleStreamImpl) sampleStream).track;
                UtilsKt.checkState(zArr3[i3]);
                this.enabledTrackCount--;
                zArr3[i3] = false;
                sampleStreamArr[i2] = null;
            }
        }
        boolean z = !this.seenFirstTrackSelection ? j == 0 || this.isSingleSample : i != 0;
        for (int i4 = 0; i4 < exoTrackSelectionArr.length; i4++) {
            if (sampleStreamArr[i4] == null && (exoTrackSelection = exoTrackSelectionArr[i4]) != null) {
                UtilsKt.checkState(exoTrackSelection.length() == 1);
                UtilsKt.checkState(exoTrackSelection.getIndexInTrackGroup(0) == 0);
                int iIndexOf = trackGroupArray.trackGroups.indexOf(exoTrackSelection.getTrackGroup());
                if (iIndexOf < 0) {
                    iIndexOf = -1;
                }
                UtilsKt.checkState(!zArr3[iIndexOf]);
                this.enabledTrackCount++;
                zArr3[iIndexOf] = true;
                this.pendingInitialDiscontinuity = exoTrackSelection.getSelectedFormat().hasPrerollSamples | this.pendingInitialDiscontinuity;
                sampleStreamArr[i4] = new SampleStreamImpl(iIndexOf);
                zArr2[i4] = true;
                if (!z) {
                    SampleQueue sampleQueue = this.sampleQueues[iIndexOf];
                    z = (sampleQueue.absoluteFirstIndex + sampleQueue.readPosition == 0 || sampleQueue.seekTo(j, true)) ? false : true;
                }
            }
        }
        if (this.enabledTrackCount == 0) {
            this.pendingDeferredRetry = false;
            this.notifyDiscontinuity = false;
            this.pendingInitialDiscontinuity = false;
            Loader loader = this.loader;
            if (loader.isLoading()) {
                for (SampleQueue sampleQueue2 : this.sampleQueues) {
                    sampleQueue2.discardToEnd();
                }
                Loader.LoadTask loadTask = loader.currentTask;
                loadTask.getClass();
                loadTask.cancel(false);
            } else {
                this.loadingFinished = false;
                for (SampleQueue sampleQueue3 : this.sampleQueues) {
                    sampleQueue3.reset(false);
                }
            }
        } else if (z) {
            j = seekToUs(j);
            for (int i5 = 0; i5 < sampleStreamArr.length; i5++) {
                if (sampleStreamArr[i5] != null) {
                    zArr2[i5] = true;
                }
            }
        }
        this.seenFirstTrackSelection = true;
        return j;
    }

    public final void setSeekMap(SeekMap seekMap) {
        this.seekMap = this.icyHeaders == null ? seekMap : new SeekMap.Unseekable(-9223372036854775807L);
        this.durationUs = seekMap.getDurationUs();
        boolean z = !this.isLengthKnown && seekMap.getDurationUs() == -9223372036854775807L;
        this.isLive = z;
        this.dataType = z ? 7 : 1;
        if (this.prepared) {
            this.listener.onSourceInfoRefreshed(this.durationUs, seekMap, z);
        } else {
            maybeFinishPrepare();
        }
    }

    public final void startLoading() {
        ExtractingLoadable extractingLoadable = new ExtractingLoadable(this.uri, this.dataSource, this.progressiveMediaExtractor, this, this.loadCondition);
        if (this.prepared) {
            UtilsKt.checkState(isPendingReset());
            long j = this.endPositionUs;
            if (j == Long.MIN_VALUE) {
                j = this.durationUs;
            }
            if (j != -9223372036854775807L && this.pendingResetPositionUs > j) {
                this.loadingFinished = true;
                this.pendingResetPositionUs = -9223372036854775807L;
                return;
            }
            SeekMap seekMap = this.seekMap;
            seekMap.getClass();
            long j2 = seekMap.getSeekPoints(this.pendingResetPositionUs).first.position;
            long j3 = this.pendingResetPositionUs;
            extractingLoadable.positionHolder.position = j2;
            extractingLoadable.seekTimeUs = j3;
            extractingLoadable.pendingExtractorSeek = true;
            extractingLoadable.seenIcyMetadata = false;
            for (SampleQueue sampleQueue : this.sampleQueues) {
                sampleQueue.startTimeUs = this.pendingResetPositionUs;
            }
            this.pendingResetPositionUs = -9223372036854775807L;
        }
        this.extractedSamplesCountAtStartOfLoad = getExtractedSamplesCount();
        int minimumLoadableRetryCount = this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(this.dataType);
        Loader loader = this.loader;
        loader.getClass();
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper.getClass();
        loader.fatalError = null;
        Loader.LoadTask loadTask = loader.new LoadTask(looperMyLooper, extractingLoadable, this, minimumLoadableRetryCount, SystemClock.elapsedRealtime());
        UtilsKt.checkState(loader.currentTask == null);
        loader.currentTask = loadTask;
        loadTask.execute();
    }

    public final boolean suppressRead() {
        return this.notifyDiscontinuity || isPendingReset();
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public final TrackOutput track(int i, int i2) {
        return prepareTrackOutput(new TrackId(i, false));
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ControlledTrackOutput implements TrackOutput {
        public final DiscardingTrackOutput discardingTrackOutput = new DiscardingTrackOutput();
        public final AtomicReference outputMode = new AtomicReference(OutputMode.PASS_THROUGH);
        public final SampleQueue sampleQueue;
        public final SampleQueue trackOutput;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class OutputMode {
            public static final /* synthetic */ OutputMode[] $VALUES;
            public static final OutputMode DISCARDING;
            public static final OutputMode DISCARD_AFTER_NEXT_SAMPLE_METADATA;
            public static final OutputMode PASS_THROUGH;

            static {
                OutputMode outputMode = new OutputMode("PASS_THROUGH", 0);
                PASS_THROUGH = outputMode;
                OutputMode outputMode2 = new OutputMode("DISCARD_AFTER_NEXT_SAMPLE_METADATA", 1);
                DISCARD_AFTER_NEXT_SAMPLE_METADATA = outputMode2;
                OutputMode outputMode3 = new OutputMode("DISCARDING", 2);
                DISCARDING = outputMode3;
                $VALUES = new OutputMode[]{outputMode, outputMode2, outputMode3};
            }

            public static OutputMode valueOf(String str) {
                return (OutputMode) Enum.valueOf(OutputMode.class, str);
            }

            public static OutputMode[] values() {
                return (OutputMode[]) $VALUES.clone();
            }
        }

        public ControlledTrackOutput(SampleQueue sampleQueue) {
            this.trackOutput = sampleQueue;
            this.sampleQueue = sampleQueue;
        }

        @Override // androidx.media3.extractor.TrackOutput
        public final void format(Format format) {
            this.trackOutput.format(format);
        }

        public final TrackOutput getCurrentOutput() {
            return this.outputMode.get() == OutputMode.DISCARDING ? this.discardingTrackOutput : this.sampleQueue;
        }

        @Override // androidx.media3.extractor.TrackOutput
        public final int sampleData(DataReader dataReader, int i, boolean z) {
            return getCurrentOutput().sampleData(dataReader, i, z);
        }

        @Override // androidx.media3.extractor.TrackOutput
        public final int sampleData$1(DataReader dataReader, int i, boolean z) {
            return getCurrentOutput().sampleData$1(dataReader, i, z);
        }

        @Override // androidx.media3.extractor.TrackOutput
        public final void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
            getCurrentOutput().sampleMetadata(j, i, i2, i3, cryptoData);
            AtomicReference atomicReference = this.outputMode;
            if (atomicReference.get() == OutputMode.DISCARD_AFTER_NEXT_SAMPLE_METADATA) {
                this.sampleQueue.reset(false);
                atomicReference.set(OutputMode.DISCARDING);
            }
        }

        @Override // androidx.media3.extractor.TrackOutput
        public final void sampleData(int i, ParsableByteArray parsableByteArray) {
            getCurrentOutput().sampleData(i, parsableByteArray);
        }

        @Override // androidx.media3.extractor.TrackOutput
        public final void sampleData(ParsableByteArray parsableByteArray, int i, int i2) {
            getCurrentOutput().sampleData(parsableByteArray, i, i2);
        }

        @Override // androidx.media3.extractor.TrackOutput
        public final void durationUs(long j) {
        }
    }
}
