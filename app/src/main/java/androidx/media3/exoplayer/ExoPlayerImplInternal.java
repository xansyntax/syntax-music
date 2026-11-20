package androidx.media3.exoplayer;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Trace;
import android.text.TextUtils;
import android.util.Pair;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda10;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Format;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Timeline;
import androidx.media3.common.audio.AudioFocusManager;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.StuckPlayerException;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.SystemHandlerWrapper;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector$$ExternalSyntheticLambda0;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.source.BaseMediaSource;
import androidx.media3.exoplayer.source.ForwardingTimeline;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.source.ShuffleOrder$DefaultShuffleOrder;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.exoplayer.video.VideoFrameMetadataListener;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableList;
import com.yalantis.ucrop.util.ImageHeaderParser;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.client.utils.CIOKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.serialization.json.internal.JsonPath;
import okio.Path$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ExoPlayerImplInternal implements Handler.Callback, MediaPeriod.Callback, VideoFrameMetadataListener {
    public static final long BUFFERING_MAXIMUM_INTERVAL_MS = Util.usToMs(10000);
    public final DefaultAnalyticsCollector analyticsCollector;
    public final SystemHandlerWrapper applicationLooperHandler;
    public final AudioFocusManager audioFocusManager;
    public final boolean avoidLoadingWhileEnded;
    public final long backBufferDurationUs;
    public final DefaultBandwidthMeter bandwidthMeter;
    public boolean deliverPendingMessageAtStartPositionRequired;
    public int droppedSeeksWhileScrubbing;
    public final TrackSelectorResult emptyTrackSelectorResult;
    public int enabledRendererCount;
    public boolean foregroundMode;
    public final SystemHandlerWrapper handler;
    public final boolean hasSecondaryRenderers;
    public boolean isPrewarmingDisabledUntilNextTransition;
    public boolean isRebuffering;
    public long lastRebufferRealtimeMs;
    public final DefaultLivePlaybackSpeedControl livePlaybackSpeedControl;
    public final DefaultLoadControl loadControl;
    public final DefaultMediaClock mediaClock;
    public final MediaSourceList mediaSourceList;
    public int nextPendingMessageIndexHint;
    public boolean offloadSchedulingEnabled;
    public boolean pauseAtEndOfWindow;
    public SeekPosition pendingInitialSeekPosition;
    public final ArrayList pendingMessages;
    public boolean pendingPauseAtEndOfPeriod;
    public ExoPlaybackException pendingRecoverableRendererError;
    public final Timeline.Period period;
    public PlaybackInfo playbackInfo;
    public PlaybackInfoUpdate playbackInfoUpdate;
    public final ExoPlayerImpl$$ExternalSyntheticLambda20 playbackInfoUpdateListener;
    public final Looper playbackLooper;
    public final JsonPath playbackLooperProvider;
    public long playbackMaybeBecameStuckAtMs;
    public final PlayerId playerId;
    public ExoPlayer$PreloadConfiguration preloadConfiguration;
    public long prewarmingMediaPeriodDiscontinuity;
    public final MediaPeriodQueue queue;
    public SeekPosition queuedSeekWhileScrubbing;
    public boolean releasedOnApplicationThread;
    public final BaseRenderer[] rendererCapabilities;
    public long rendererPositionElapsedRealtimeUs;
    public long rendererPositionUs;
    public final boolean[] rendererReportedReady;
    public final RendererHolder[] renderers;
    public int repeatMode;
    public boolean requestForRendererSleep;
    public boolean scrubbingModeEnabled;
    public ScrubbingModeParameters scrubbingModeParameters;
    public boolean seekIsPendingWhileScrubbing;
    public SeekParameters seekParameters;
    public boolean shouldContinueLoading;
    public boolean shuffleModeEnabled;
    public final DefaultTrackSelector trackSelector;
    public float volume;
    public final Timeline.Window window;

    /* JADX INFO: renamed from: androidx.media3.exoplayer.ExoPlayerImplInternal$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 {
        public AnonymousClass1() {
        }

        public final void onWakeup() {
            ExoPlayerImplInternal exoPlayerImplInternal = ExoPlayerImplInternal.this;
            if (exoPlayerImplInternal.scrubbingModeEnabled) {
                exoPlayerImplInternal.scrubbingModeParameters.getClass();
            } else if (!exoPlayerImplInternal.offloadSchedulingEnabled) {
                return;
            }
            exoPlayerImplInternal.handler.sendEmptyMessage(2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MediaSourceListUpdateMessage {
        public final ArrayList mediaSourceHolders;
        public final long positionUs;
        public final ShuffleOrder$DefaultShuffleOrder shuffleOrder;
        public final int windowIndex;

        public MediaSourceListUpdateMessage(ArrayList arrayList, ShuffleOrder$DefaultShuffleOrder shuffleOrder$DefaultShuffleOrder, int i, long j) {
            this.mediaSourceHolders = arrayList;
            this.shuffleOrder = shuffleOrder$DefaultShuffleOrder;
            this.windowIndex = i;
            this.positionUs = j;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MoveMediaItemsMessage {
        public final int fromIndex;
        public final int newFromIndex;
        public final ShuffleOrder$DefaultShuffleOrder shuffleOrder;
        public final int toIndex;

        public MoveMediaItemsMessage(int i, int i2, int i3, ShuffleOrder$DefaultShuffleOrder shuffleOrder$DefaultShuffleOrder) {
            this.fromIndex = i;
            this.toIndex = i2;
            this.newFromIndex = i3;
            this.shuffleOrder = shuffleOrder$DefaultShuffleOrder;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PendingMessageInfo implements Comparable {
        public final PlayerMessage message;
        public int resolvedPeriodIndex;
        public long resolvedPeriodTimeUs;
        public Object resolvedPeriodUid;

        public PendingMessageInfo(PlayerMessage playerMessage) {
            this.message = playerMessage;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            PendingMessageInfo pendingMessageInfo = (PendingMessageInfo) obj;
            Object obj2 = this.resolvedPeriodUid;
            if ((obj2 == null) != (pendingMessageInfo.resolvedPeriodUid == null)) {
                return obj2 != null ? -1 : 1;
            }
            if (obj2 == null) {
                return 0;
            }
            int i = this.resolvedPeriodIndex - pendingMessageInfo.resolvedPeriodIndex;
            return i != 0 ? i : Long.compare(this.resolvedPeriodTimeUs, pendingMessageInfo.resolvedPeriodTimeUs);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PlaybackInfoUpdate {
        public int discontinuityReason;
        public boolean hasPendingChange;
        public int operationAcks;
        public PlaybackInfo playbackInfo;
        public boolean positionDiscontinuity;

        public PlaybackInfoUpdate(PlaybackInfo playbackInfo) {
            this.playbackInfo = playbackInfo;
        }

        public final void incrementPendingOperationAcks(int i) {
            this.hasPendingChange |= i > 0;
            this.operationAcks += i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PositionUpdateForPlaylistChange {
        public final int discontinuityReason;
        public final boolean endPlayback;
        public final boolean forceBufferingState;
        public final MediaSource$MediaPeriodId periodId;
        public final boolean periodPositionChanged;
        public final long periodPositionUs;
        public final boolean reportDiscontinuity;
        public final long requestedContentPositionUs;
        public final boolean setTargetLiveOffset;

        public PositionUpdateForPlaylistChange(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, long j, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i) {
            this.periodId = mediaSource$MediaPeriodId;
            this.periodPositionUs = j;
            this.requestedContentPositionUs = j2;
            this.forceBufferingState = z;
            this.endPlayback = z2;
            this.setTargetLiveOffset = z3;
            this.periodPositionChanged = z4;
            this.reportDiscontinuity = z5;
            this.discontinuityReason = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SeekPosition {
        public final Timeline timeline;
        public final int windowIndex;
        public final long windowPositionUs;

        public SeekPosition(Timeline timeline, int i, long j) {
            this.timeline = timeline;
            this.windowIndex = i;
            this.windowPositionUs = j;
        }
    }

    public ExoPlayerImplInternal(Context context, BaseRenderer[] baseRendererArr, BaseRenderer[] baseRendererArr2, DefaultTrackSelector defaultTrackSelector, TrackSelectorResult trackSelectorResult, DefaultLoadControl defaultLoadControl, DefaultBandwidthMeter defaultBandwidthMeter, int i, boolean z, DefaultAnalyticsCollector defaultAnalyticsCollector, SeekParameters seekParameters, DefaultLivePlaybackSpeedControl defaultLivePlaybackSpeedControl, Looper looper, ExoPlayerImpl$$ExternalSyntheticLambda20 exoPlayerImpl$$ExternalSyntheticLambda20, PlayerId playerId, final VideoFrameMetadataListener videoFrameMetadataListener) {
        Looper looper2;
        ExoPlayer$PreloadConfiguration exoPlayer$PreloadConfiguration = ExoPlayer$PreloadConfiguration.DEFAULT;
        this.prewarmingMediaPeriodDiscontinuity = -9223372036854775807L;
        this.playbackInfoUpdateListener = exoPlayerImpl$$ExternalSyntheticLambda20;
        this.trackSelector = defaultTrackSelector;
        this.emptyTrackSelectorResult = trackSelectorResult;
        this.loadControl = defaultLoadControl;
        this.bandwidthMeter = defaultBandwidthMeter;
        this.repeatMode = i;
        this.shuffleModeEnabled = z;
        this.seekParameters = seekParameters;
        this.livePlaybackSpeedControl = defaultLivePlaybackSpeedControl;
        boolean z2 = false;
        this.pauseAtEndOfWindow = false;
        this.playerId = playerId;
        this.preloadConfiguration = exoPlayer$PreloadConfiguration;
        this.analyticsCollector = defaultAnalyticsCollector;
        this.volume = 1.0f;
        this.scrubbingModeParameters = ScrubbingModeParameters.DEFAULT;
        this.avoidLoadingWhileEnded = true;
        this.playbackMaybeBecameStuckAtMs = -9223372036854775807L;
        this.lastRebufferRealtimeMs = -9223372036854775807L;
        this.backBufferDurationUs = defaultLoadControl.backBufferDurationUs;
        Timeline.AnonymousClass1 anonymousClass1 = Timeline.EMPTY;
        PlaybackInfo playbackInfoCreateDummy = PlaybackInfo.createDummy(trackSelectorResult);
        this.playbackInfo = playbackInfoCreateDummy;
        this.playbackInfoUpdate = new PlaybackInfoUpdate(playbackInfoCreateDummy);
        this.rendererCapabilities = new BaseRenderer[baseRendererArr.length];
        this.rendererReportedReady = new boolean[baseRendererArr.length];
        defaultTrackSelector.getClass();
        this.renderers = new RendererHolder[baseRendererArr.length];
        boolean z3 = false;
        for (int i2 = 0; i2 < baseRendererArr.length; i2++) {
            BaseRenderer baseRenderer = baseRendererArr[i2];
            SystemClock systemClock = SystemClock.DEFAULT;
            baseRenderer.index = i2;
            baseRenderer.playerId = playerId;
            baseRenderer.clock = systemClock;
            this.rendererCapabilities[i2] = baseRenderer;
            BaseRenderer baseRenderer2 = this.rendererCapabilities[i2];
            synchronized (baseRenderer2.lock) {
                baseRenderer2.rendererCapabilitiesListener = defaultTrackSelector;
            }
            BaseRenderer baseRenderer3 = baseRendererArr2[i2];
            if (baseRenderer3 != null) {
                baseRenderer3.index = i2;
                baseRenderer3.playerId = playerId;
                baseRenderer3.clock = systemClock;
                z3 = true;
            }
            this.renderers[i2] = new RendererHolder(baseRendererArr[i2], baseRenderer3, i2);
        }
        this.hasSecondaryRenderers = z3;
        this.mediaClock = new DefaultMediaClock(this);
        this.pendingMessages = new ArrayList();
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        UtilsKt.checkState(defaultTrackSelector.listener == null);
        defaultTrackSelector.listener = this;
        defaultTrackSelector.bandwidthMeter = defaultBandwidthMeter;
        this.deliverPendingMessageAtStartPositionRequired = true;
        SystemHandlerWrapper systemHandlerWrapper = new SystemHandlerWrapper(new Handler(looper, null));
        this.applicationLooperHandler = systemHandlerWrapper;
        this.queue = new MediaPeriodQueue(defaultAnalyticsCollector, systemHandlerWrapper, new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 10, (Object) this));
        this.mediaSourceList = new MediaSourceList(this, defaultAnalyticsCollector, systemHandlerWrapper, playerId);
        JsonPath jsonPath = new JsonPath();
        this.playbackLooperProvider = jsonPath;
        synchronized (jsonPath.configuration) {
            try {
                looper2 = (Looper) jsonPath.currentObjectPath;
                if (looper2 == null) {
                    if (jsonPath.currentDepth == 0 && ((HandlerThread) jsonPath.indicies) == null) {
                        z2 = true;
                    }
                    UtilsKt.checkState(z2);
                    HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
                    jsonPath.indicies = handlerThread;
                    handlerThread.start();
                    looper2 = ((HandlerThread) jsonPath.indicies).getLooper();
                    jsonPath.currentObjectPath = looper2;
                }
                jsonPath.currentDepth++;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.playbackLooper = looper2;
        SystemHandlerWrapper systemHandlerWrapper2 = new SystemHandlerWrapper(new Handler(looper2, this));
        this.handler = systemHandlerWrapper2;
        this.audioFocusManager = new AudioFocusManager(context, looper2, this);
        systemHandlerWrapper2.obtainMessage(35, new VideoFrameMetadataListener() { // from class: androidx.media3.exoplayer.ExoPlayerImplInternal$$ExternalSyntheticLambda3
            @Override // androidx.media3.exoplayer.video.VideoFrameMetadataListener
            public final void onVideoFrameAboutToBeRendered(long j, long j2, Format format, MediaFormat mediaFormat) {
                videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j, j2, format, mediaFormat);
                this.f$0.onVideoFrameAboutToBeRendered(j, j2, format, mediaFormat);
            }
        }).sendToTarget();
        systemHandlerWrapper2.obtainMessage(39, new ExoPlayerImplInternal$$ExternalSyntheticLambda4(this)).sendToTarget();
    }

    public static void deliverMessage(PlayerMessage playerMessage) {
        boolean z;
        synchronized (playerMessage) {
            z = playerMessage.isCanceled;
        }
        if (z) {
            return;
        }
        try {
            playerMessage.target.handleMessage(playerMessage.type, playerMessage.payload);
        } finally {
            playerMessage.markAsProcessed(true);
        }
    }

    public static boolean isLoadingPossible(MediaPeriodHolder mediaPeriodHolder) {
        if (mediaPeriodHolder != null) {
            try {
                MediaPeriod mediaPeriod = mediaPeriodHolder.mediaPeriod;
                if (mediaPeriodHolder.prepared) {
                    for (SampleStream sampleStream : mediaPeriodHolder.sampleStreams) {
                        if (sampleStream != null) {
                            sampleStream.maybeThrowError();
                        }
                    }
                } else {
                    mediaPeriod.maybeThrowPrepareError();
                }
                if ((!mediaPeriodHolder.prepared ? 0L : mediaPeriod.getNextLoadPositionUs()) != Long.MIN_VALUE) {
                    return true;
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    public static void resolvePendingMessageEndOfStreamPosition(Timeline timeline, PendingMessageInfo pendingMessageInfo, Timeline.Window window, Timeline.Period period) {
        int i = timeline.getWindow(timeline.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period).windowIndex, window, 0L).lastPeriodIndex;
        Object obj = timeline.getPeriod(i, period, true).uid;
        long j = period.durationUs;
        long j2 = j != -9223372036854775807L ? j - 1 : Long.MAX_VALUE;
        pendingMessageInfo.resolvedPeriodIndex = i;
        pendingMessageInfo.resolvedPeriodTimeUs = j2;
        pendingMessageInfo.resolvedPeriodUid = obj;
    }

    public static boolean resolvePendingMessagePosition(PendingMessageInfo pendingMessageInfo, Timeline timeline, Timeline timeline2, int i, boolean z, Timeline.Window window, Timeline.Period period) {
        Object obj = pendingMessageInfo.resolvedPeriodUid;
        PlayerMessage playerMessage = pendingMessageInfo.message;
        if (obj == null) {
            long j = playerMessage.positionMs;
            Pair pairResolveSeekPositionUs = resolveSeekPositionUs(timeline, new SeekPosition(playerMessage.timeline, playerMessage.mediaItemIndex, j == Long.MIN_VALUE ? -9223372036854775807L : Util.msToUs(j)), false, i, z, window, period);
            if (pairResolveSeekPositionUs == null) {
                return false;
            }
            int indexOfPeriod = timeline.getIndexOfPeriod(pairResolveSeekPositionUs.first);
            long jLongValue = ((Long) pairResolveSeekPositionUs.second).longValue();
            Object obj2 = pairResolveSeekPositionUs.first;
            pendingMessageInfo.resolvedPeriodIndex = indexOfPeriod;
            pendingMessageInfo.resolvedPeriodTimeUs = jLongValue;
            pendingMessageInfo.resolvedPeriodUid = obj2;
            if (playerMessage.positionMs == Long.MIN_VALUE) {
                resolvePendingMessageEndOfStreamPosition(timeline, pendingMessageInfo, window, period);
                return true;
            }
        } else {
            int indexOfPeriod2 = timeline.getIndexOfPeriod(obj);
            if (indexOfPeriod2 == -1) {
                return false;
            }
            if (playerMessage.positionMs == Long.MIN_VALUE) {
                resolvePendingMessageEndOfStreamPosition(timeline, pendingMessageInfo, window, period);
                return true;
            }
            pendingMessageInfo.resolvedPeriodIndex = indexOfPeriod2;
            timeline2.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period);
            if (period.isPlaceholder && timeline2.getWindow(period.windowIndex, window, 0L).firstPeriodIndex == timeline2.getIndexOfPeriod(pendingMessageInfo.resolvedPeriodUid)) {
                Pair periodPositionUs = timeline.getPeriodPositionUs(window, period, timeline.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period).windowIndex, pendingMessageInfo.resolvedPeriodTimeUs + period.positionInWindowUs);
                int indexOfPeriod3 = timeline.getIndexOfPeriod(periodPositionUs.first);
                long jLongValue2 = ((Long) periodPositionUs.second).longValue();
                Object obj3 = periodPositionUs.first;
                pendingMessageInfo.resolvedPeriodIndex = indexOfPeriod3;
                pendingMessageInfo.resolvedPeriodTimeUs = jLongValue2;
                pendingMessageInfo.resolvedPeriodUid = obj3;
            }
        }
        return true;
    }

    public static Pair resolveSeekPositionUs(Timeline timeline, SeekPosition seekPosition, boolean z, int i, boolean z2, Timeline.Window window, Timeline.Period period) {
        int iResolveSubsequentPeriod;
        Timeline timeline2 = seekPosition.timeline;
        if (timeline.isEmpty()) {
            return null;
        }
        Timeline timeline3 = timeline2.isEmpty() ? timeline : timeline2;
        try {
            Pair periodPositionUs = timeline3.getPeriodPositionUs(window, period, seekPosition.windowIndex, seekPosition.windowPositionUs);
            if (!timeline.equals(timeline3)) {
                if (timeline.getIndexOfPeriod(periodPositionUs.first) == -1) {
                    if (!z || (iResolveSubsequentPeriod = resolveSubsequentPeriod(window, period, i, z2, periodPositionUs.first, timeline3, timeline)) == -1) {
                        return null;
                    }
                    return timeline.getPeriodPositionUs(window, period, iResolveSubsequentPeriod, -9223372036854775807L);
                }
                if (timeline3.getPeriodByUid(periodPositionUs.first, period).isPlaceholder && timeline3.getWindow(period.windowIndex, window, 0L).firstPeriodIndex == timeline3.getIndexOfPeriod(periodPositionUs.first)) {
                    return timeline.getPeriodPositionUs(window, period, timeline.getPeriodByUid(periodPositionUs.first, period).windowIndex, seekPosition.windowPositionUs);
                }
            }
            return periodPositionUs;
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    public static int resolveSubsequentPeriod(Timeline.Window window, Timeline.Period period, int i, boolean z, Object obj, Timeline timeline, Timeline timeline2) {
        Timeline timeline3 = timeline;
        Object obj2 = timeline3.getWindow(timeline3.getPeriodByUid(obj, period).windowIndex, window, 0L).uid;
        for (int i2 = 0; i2 < timeline2.getWindowCount(); i2++) {
            if (timeline2.getWindow(i2, window, 0L).uid.equals(obj2)) {
                return i2;
            }
        }
        int indexOfPeriod = timeline3.getIndexOfPeriod(obj);
        int periodCount = timeline3.getPeriodCount();
        int indexOfPeriod2 = -1;
        int i3 = 0;
        while (i3 < periodCount && indexOfPeriod2 == -1) {
            Timeline timeline4 = timeline3;
            int nextPeriodIndex = timeline4.getNextPeriodIndex(indexOfPeriod, period, window, i, z);
            if (nextPeriodIndex == -1) {
                break;
            }
            indexOfPeriod2 = timeline2.getIndexOfPeriod(timeline4.getUidOfPeriod(nextPeriodIndex));
            i3++;
            timeline3 = timeline4;
            indexOfPeriod = nextPeriodIndex;
        }
        if (indexOfPeriod2 == -1) {
            return -1;
        }
        return timeline2.getPeriod(indexOfPeriod2, period, false).windowIndex;
    }

    public final void addMediaItemsInternal(MediaSourceListUpdateMessage mediaSourceListUpdateMessage, int i) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        MediaSourceList mediaSourceList = this.mediaSourceList;
        if (i == -1) {
            i = mediaSourceList.mediaSourceHolders.size();
        }
        handleMediaSourceListInfoRefreshed(mediaSourceList.addMediaSources(i, mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), false);
    }

    public final void applyScrubbingModeParameters() {
        for (RendererHolder rendererHolder : this.renderers) {
            ScrubbingModeParameters scrubbingModeParameters = this.scrubbingModeEnabled ? this.scrubbingModeParameters : null;
            rendererHolder.primaryRenderer.handleMessage(18, scrubbingModeParameters);
            BaseRenderer baseRenderer = rendererHolder.secondaryRenderer;
            if (baseRenderer != null) {
                baseRenderer.handleMessage(18, scrubbingModeParameters);
            }
        }
    }

    public final boolean areRenderersPrewarming() {
        if (!this.hasSecondaryRenderers) {
            return false;
        }
        for (RendererHolder rendererHolder : this.renderers) {
            if (rendererHolder.isPrewarming()) {
                return true;
            }
        }
        return false;
    }

    public final void disableAndResetPrewarmingRenderers() {
        BaseRenderer baseRenderer;
        if (this.hasSecondaryRenderers && areRenderersPrewarming()) {
            for (RendererHolder rendererHolder : this.renderers) {
                int enabledRendererCount = rendererHolder.getEnabledRendererCount();
                DefaultMediaClock defaultMediaClock = this.mediaClock;
                if (rendererHolder.isPrewarming()) {
                    int i = rendererHolder.prewarmingState;
                    boolean z = i == 4 || i == 2;
                    int i2 = i != 4 ? 0 : 1;
                    if (z) {
                        try {
                            baseRenderer = rendererHolder.primaryRenderer;
                        } catch (RuntimeException e) {
                            Log.e("RendererHolder", "Disable prewarming failed.", e);
                        }
                    } else {
                        baseRenderer = rendererHolder.secondaryRenderer;
                        baseRenderer.getClass();
                    }
                    rendererHolder.disableRenderer(baseRenderer, defaultMediaClock);
                    try {
                        rendererHolder.maybeResetRenderer(z);
                    } catch (RuntimeException e2) {
                        Log.e("RendererHolder", "Reset prewarming failed.", e2);
                    }
                    rendererHolder.prewarmingState = i2;
                }
                this.enabledRendererCount -= enabledRendererCount - rendererHolder.getEnabledRendererCount();
            }
            this.prewarmingMediaPeriodDiscontinuity = -9223372036854775807L;
        }
    }

    public final void disableRenderer(int i) {
        RendererHolder[] rendererHolderArr = this.renderers;
        int enabledRendererCount = rendererHolderArr[i].getEnabledRendererCount();
        RendererHolder rendererHolder = rendererHolderArr[i];
        BaseRenderer baseRenderer = rendererHolder.primaryRenderer;
        DefaultMediaClock defaultMediaClock = this.mediaClock;
        rendererHolder.disableRenderer(baseRenderer, defaultMediaClock);
        BaseRenderer baseRenderer2 = rendererHolder.secondaryRenderer;
        if (baseRenderer2 != null) {
            boolean z = (baseRenderer2.state == 0 || rendererHolder.prewarmingState == 3) ? false : true;
            rendererHolder.disableRenderer(baseRenderer2, defaultMediaClock);
            rendererHolder.maybeResetRenderer(false);
            if (z) {
                BaseRenderer baseRenderer3 = rendererHolder.primaryRenderer;
                baseRenderer2.getClass();
                baseRenderer2.handleMessage(17, baseRenderer3);
            }
        }
        rendererHolder.prewarmingState = 0;
        maybeTriggerOnRendererReadyChanged(i, false);
        this.enabledRendererCount -= enabledRendererCount;
    }

    /* JADX WARN: Code duplicated, block: B:116:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:156:0x0242  */
    /* JADX WARN: Code duplicated, block: B:158:0x024f  */
    /* JADX WARN: Code duplicated, block: B:192:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:195:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:197:0x02de  */
    /* JADX WARN: Code duplicated, block: B:201:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:215:0x032c  */
    /* JADX WARN: Code duplicated, block: B:218:0x0339  */
    /* JADX WARN: Code duplicated, block: B:221:0x0342  */
    /* JADX WARN: Code duplicated, block: B:224:0x0347  */
    /* JADX WARN: Code duplicated, block: B:228:0x034e  */
    /* JADX WARN: Code duplicated, block: B:231:0x0355  */
    /* JADX WARN: Code duplicated, block: B:234:0x0360  */
    /* JADX WARN: Code duplicated, block: B:253:0x02e4 A[EDGE_INSN: B:253:0x02e4->B:199:0x02e4 BREAK  A[LOOP:1: B:193:0x02d1->B:198:0x02e1], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:255:0x02e1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:93:0x0146  */
    public final void doSomeWork() {
        boolean z;
        boolean z2;
        long j;
        boolean z3;
        boolean z4;
        boolean zIsTimelineReady;
        int i;
        boolean z5;
        PlaybackInfo playbackInfoCopyWithSleepingForOffload;
        int i2;
        int i3;
        RendererHolder[] rendererHolderArr;
        PlaybackInfo playbackInfo;
        long jUptimeMillis = android.os.SystemClock.uptimeMillis();
        this.handler.removeMessages(2);
        if (!this.avoidLoadingWhileEnded) {
            updatePeriods();
        }
        int i4 = this.playbackInfo.playbackState;
        if (i4 == 1 || i4 == 4) {
            return;
        }
        if (this.avoidLoadingWhileEnded) {
            updatePeriods();
        }
        MediaPeriodHolder mediaPeriodHolder = this.queue.playing;
        if (mediaPeriodHolder == null) {
            scheduleNextWork(jUptimeMillis);
            return;
        }
        Trace.beginSection("doSomeWork");
        updatePlaybackPositions();
        if (mediaPeriodHolder.prepared) {
            this.rendererPositionElapsedRealtimeUs = Util.msToUs(android.os.SystemClock.elapsedRealtime());
            mediaPeriodHolder.mediaPeriod.discardBuffer(this.playbackInfo.positionUs - this.backBufferDurationUs);
            z = true;
            z2 = true;
            int i5 = 0;
            while (true) {
                RendererHolder[] rendererHolderArr2 = this.renderers;
                if (i5 >= rendererHolderArr2.length) {
                    break;
                }
                RendererHolder rendererHolder = rendererHolderArr2[i5];
                if (rendererHolder.getEnabledRendererCount() == 0) {
                    maybeTriggerOnRendererReadyChanged(i5, false);
                } else {
                    long j2 = this.rendererPositionUs;
                    long j3 = this.rendererPositionElapsedRealtimeUs;
                    BaseRenderer baseRenderer = rendererHolder.secondaryRenderer;
                    BaseRenderer baseRenderer2 = rendererHolder.primaryRenderer;
                    if (RendererHolder.isRendererEnabled(baseRenderer2)) {
                        baseRenderer2.render(j2, j3);
                    }
                    if (baseRenderer != null && baseRenderer.state != 0) {
                        baseRenderer.render(j2, j3);
                    }
                    if (z) {
                        BaseRenderer baseRenderer3 = rendererHolder.secondaryRenderer;
                        BaseRenderer baseRenderer4 = rendererHolder.primaryRenderer;
                        boolean zIsEnded = RendererHolder.isRendererEnabled(baseRenderer4) ? baseRenderer4.isEnded() : true;
                        if (baseRenderer3 != null && baseRenderer3.state != 0) {
                            zIsEnded &= baseRenderer3.isEnded();
                        }
                        if (zIsEnded) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                    BaseRenderer rendererReadingFromPeriod = rendererHolder.getRendererReadingFromPeriod(mediaPeriodHolder);
                    boolean z6 = rendererReadingFromPeriod == null || rendererReadingFromPeriod.hasReadStreamToEnd() || rendererReadingFromPeriod.isReady() || rendererReadingFromPeriod.isEnded();
                    maybeTriggerOnRendererReadyChanged(i5, z6);
                    z2 = z2 && z6;
                    if (!z6) {
                        maybeThrowRendererStreamError(i5);
                    }
                }
                i5++;
            }
        } else {
            mediaPeriodHolder.mediaPeriod.maybeThrowPrepareError();
            z = true;
            z2 = true;
        }
        long j4 = mediaPeriodHolder.info.durationUs;
        boolean z7 = z && mediaPeriodHolder.prepared && (j4 == -9223372036854775807L || j4 <= this.playbackInfo.positionUs);
        if (z7 && this.pendingPauseAtEndOfPeriod) {
            this.pendingPauseAtEndOfPeriod = false;
            int i6 = this.playbackInfo.playbackSuppressionReason;
            this.playbackInfoUpdate.incrementPendingOperationAcks(0);
            updatePlayWhenReadyWithAudioFocus(this.audioFocusManager.updateAudioFocus(this.playbackInfo.playbackState, false), i6, 5, false);
        }
        if (!z7 || !mediaPeriodHolder.info.isFinal) {
            PlaybackInfo playbackInfo2 = this.playbackInfo;
            if (playbackInfo2.playbackState == 2) {
                MediaPeriodQueue mediaPeriodQueue = this.queue;
                if (this.enabledRendererCount != 0) {
                    if (!z2) {
                        zIsTimelineReady = false;
                    } else if (playbackInfo2.isLoading) {
                        MediaPeriodHolder mediaPeriodHolder2 = mediaPeriodQueue.playing;
                        long j5 = shouldUseLivePlaybackSpeedControl(playbackInfo2.timeline, mediaPeriodHolder2.info.id) ? this.livePlaybackSpeedControl.currentTargetLiveOffsetUs : -9223372036854775807L;
                        MediaPeriodHolder mediaPeriodHolder3 = mediaPeriodQueue.loading;
                        boolean z8 = mediaPeriodHolder3.isFullyBuffered() && mediaPeriodHolder3.info.isFinal;
                        boolean z9 = mediaPeriodHolder3.info.id.isAd() && !mediaPeriodHolder3.prepared;
                        if (z8 || z9) {
                            j = -9223372036854775807L;
                        } else {
                            long totalBufferedDurationUs = getTotalBufferedDurationUs(mediaPeriodHolder3.getBufferedPositionUs());
                            DefaultLoadControl defaultLoadControl = this.loadControl;
                            PlayerId playerId = this.playerId;
                            j = -9223372036854775807L;
                            Timeline timeline = this.playbackInfo.timeline;
                            MediaSource$MediaPeriodId mediaSource$MediaPeriodId = mediaPeriodHolder2.info.id;
                            float f = this.mediaClock.getPlaybackParameters().speed;
                            boolean z10 = this.playbackInfo.playWhenReady;
                            boolean z11 = this.isRebuffering;
                            defaultLoadControl.getClass();
                            long j6 = j5;
                            MediaItem.LocalConfiguration localConfiguration = timeline.getWindow(timeline.getPeriodByUid(mediaSource$MediaPeriodId.periodUid, defaultLoadControl.period).windowIndex, defaultLoadControl.window, 0L).mediaItem.localConfiguration;
                            if (localConfiguration == null) {
                                z4 = false;
                            } else {
                                String scheme = localConfiguration.uri.getScheme();
                                if (TextUtils.isEmpty(scheme) || DefaultLoadControl.LOCAL_PLAYBACK_SCHEMES.contains(scheme)) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                            }
                            if (f != 1.0f) {
                                totalBufferedDurationUs = Math.round(totalBufferedDurationUs / ((double) f));
                            }
                            long jMin = z11 ? z4 ? defaultLoadControl.bufferForPlaybackAfterRebufferForLocalPlaybackUs : defaultLoadControl.bufferForPlaybackAfterRebufferUs : z4 ? defaultLoadControl.bufferForPlaybackForLocalPlaybackUs : defaultLoadControl.bufferForPlaybackUs;
                            if (j6 != -9223372036854775807L) {
                                jMin = Math.min(j6 / 2, jMin);
                            }
                            if (jMin > 0 && totalBufferedDurationUs < jMin) {
                                if (!(z4 ? defaultLoadControl.prioritizeTimeOverSizeThresholdsForLocalPlayback : false)) {
                                    DefaultLoadControl.PlayerLoadingState playerLoadingState = (DefaultLoadControl.PlayerLoadingState) defaultLoadControl.loadingStates.get(playerId);
                                    playerLoadingState.getClass();
                                    synchronized (playerLoadingState) {
                                        i = playerLoadingState.allocatedCounts;
                                    }
                                    int i7 = i * 65536;
                                    DefaultLoadControl.PlayerLoadingState playerLoadingState2 = (DefaultLoadControl.PlayerLoadingState) defaultLoadControl.loadingStates.get(playerId);
                                    playerLoadingState2.getClass();
                                    if (i7 >= playerLoadingState2.targetBufferBytes) {
                                    }
                                }
                                zIsTimelineReady = false;
                            }
                        }
                        zIsTimelineReady = true;
                    } else {
                        j = -9223372036854775807L;
                        zIsTimelineReady = true;
                    }
                    if (zIsTimelineReady) {
                        setState(3);
                        this.pendingRecoverableRendererError = null;
                        if (shouldPlayWhenReady()) {
                            updateRebufferingState(false, false);
                            DefaultMediaClock defaultMediaClock = this.mediaClock;
                            z3 = true;
                            defaultMediaClock.standaloneClockIsStarted = true;
                            ((StandaloneMediaClock) defaultMediaClock.standaloneClock).start();
                            startRenderers();
                        }
                    }
                    if (this.playbackInfo.playbackState == 2) {
                        i3 = 0;
                        while (true) {
                            rendererHolderArr = this.renderers;
                            if (i3 < rendererHolderArr.length) {
                                break;
                            }
                            if (rendererHolderArr[i3].getRendererReadingFromPeriod(mediaPeriodHolder) != null) {
                                maybeThrowRendererStreamError(i3);
                            }
                            i3++;
                        }
                        playbackInfo = this.playbackInfo;
                        if (!playbackInfo.isLoading || playbackInfo.totalBufferedDurationUs >= 500000 || !isLoadingPossible(this.queue.loading) || !shouldPlayWhenReady()) {
                            this.playbackMaybeBecameStuckAtMs = -9223372036854775807L;
                        } else if (this.playbackMaybeBecameStuckAtMs == -9223372036854775807L) {
                            this.playbackMaybeBecameStuckAtMs = android.os.SystemClock.elapsedRealtime();
                        } else if (android.os.SystemClock.elapsedRealtime() - this.playbackMaybeBecameStuckAtMs >= 4000) {
                            throw new StuckPlayerException(0, 4000);
                        }
                    } else {
                        this.playbackMaybeBecameStuckAtMs = -9223372036854775807L;
                    }
                    if (shouldPlayWhenReady() || this.playbackInfo.playbackState != 3) {
                        z5 = false;
                    } else {
                        z5 = z3;
                    }
                    if (this.offloadSchedulingEnabled || !this.requestForRendererSleep || !z5) {
                        z3 = false;
                    }
                    playbackInfoCopyWithSleepingForOffload = this.playbackInfo;
                    if (playbackInfoCopyWithSleepingForOffload.sleepingForOffload != z3) {
                        playbackInfoCopyWithSleepingForOffload = playbackInfoCopyWithSleepingForOffload.copyWithSleepingForOffload(z3);
                        this.playbackInfo = playbackInfoCopyWithSleepingForOffload;
                    }
                    this.requestForRendererSleep = false;
                    if (!z3 && (i2 = playbackInfoCopyWithSleepingForOffload.playbackState) != 4 && (z5 || i2 == 2 || (i2 == 3 && this.enabledRendererCount != 0))) {
                        scheduleNextWork(jUptimeMillis);
                    }
                    Trace.endSection();
                }
                zIsTimelineReady = isTimelineReady();
                j = -9223372036854775807L;
                if (zIsTimelineReady) {
                    setState(3);
                    this.pendingRecoverableRendererError = null;
                    if (shouldPlayWhenReady()) {
                        updateRebufferingState(false, false);
                        DefaultMediaClock defaultMediaClock2 = this.mediaClock;
                        z3 = true;
                        defaultMediaClock2.standaloneClockIsStarted = true;
                        ((StandaloneMediaClock) defaultMediaClock2.standaloneClock).start();
                        startRenderers();
                    }
                }
                if (this.playbackInfo.playbackState == 2) {
                    i3 = 0;
                    while (true) {
                        rendererHolderArr = this.renderers;
                        if (i3 < rendererHolderArr.length) {
                            break;
                            break;
                        } else {
                            if (rendererHolderArr[i3].getRendererReadingFromPeriod(mediaPeriodHolder) != null) {
                                maybeThrowRendererStreamError(i3);
                            }
                            i3++;
                        }
                    }
                    playbackInfo = this.playbackInfo;
                    if (!playbackInfo.isLoading) {
                        this.playbackMaybeBecameStuckAtMs = -9223372036854775807L;
                    } else {
                        this.playbackMaybeBecameStuckAtMs = -9223372036854775807L;
                    }
                } else {
                    this.playbackMaybeBecameStuckAtMs = -9223372036854775807L;
                }
                if (shouldPlayWhenReady()) {
                    z5 = false;
                } else {
                    z5 = false;
                }
                if (this.offloadSchedulingEnabled) {
                    z3 = false;
                } else {
                    z3 = false;
                }
                playbackInfoCopyWithSleepingForOffload = this.playbackInfo;
                if (playbackInfoCopyWithSleepingForOffload.sleepingForOffload != z3) {
                    playbackInfoCopyWithSleepingForOffload = playbackInfoCopyWithSleepingForOffload.copyWithSleepingForOffload(z3);
                    this.playbackInfo = playbackInfoCopyWithSleepingForOffload;
                }
                this.requestForRendererSleep = false;
                if (!z3) {
                    scheduleNextWork(jUptimeMillis);
                }
                Trace.endSection();
            }
            j = -9223372036854775807L;
            z3 = true;
            if (this.playbackInfo.playbackState == 3 && (this.enabledRendererCount != 0 ? !z2 : !isTimelineReady())) {
                updateRebufferingState(shouldPlayWhenReady(), false);
                setState(2);
                if (this.isRebuffering) {
                    for (MediaPeriodHolder mediaPeriodHolder4 = this.queue.playing; mediaPeriodHolder4 != null; mediaPeriodHolder4 = mediaPeriodHolder4.next) {
                        for (ExoTrackSelection exoTrackSelection : mediaPeriodHolder4.trackSelectorResult.selections) {
                            if (exoTrackSelection != null) {
                                exoTrackSelection.onRebuffer();
                            }
                        }
                    }
                    DefaultLivePlaybackSpeedControl defaultLivePlaybackSpeedControl = this.livePlaybackSpeedControl;
                    long j7 = defaultLivePlaybackSpeedControl.currentTargetLiveOffsetUs;
                    if (j7 != j) {
                        long j8 = j7 + defaultLivePlaybackSpeedControl.targetLiveOffsetRebufferDeltaUs;
                        defaultLivePlaybackSpeedControl.currentTargetLiveOffsetUs = j8;
                        long j9 = defaultLivePlaybackSpeedControl.maxTargetLiveOffsetUs;
                        if (j9 != j && j8 > j9) {
                            defaultLivePlaybackSpeedControl.currentTargetLiveOffsetUs = j9;
                        }
                        defaultLivePlaybackSpeedControl.lastPlaybackSpeedUpdateMs = j;
                    }
                }
                stopRenderers();
            }
            if (this.playbackInfo.playbackState == 2) {
                i3 = 0;
                while (true) {
                    rendererHolderArr = this.renderers;
                    if (i3 < rendererHolderArr.length) {
                        break;
                        break;
                    } else {
                        if (rendererHolderArr[i3].getRendererReadingFromPeriod(mediaPeriodHolder) != null) {
                            maybeThrowRendererStreamError(i3);
                        }
                        i3++;
                    }
                }
                playbackInfo = this.playbackInfo;
                if (!playbackInfo.isLoading) {
                    this.playbackMaybeBecameStuckAtMs = -9223372036854775807L;
                } else {
                    this.playbackMaybeBecameStuckAtMs = -9223372036854775807L;
                }
            } else {
                this.playbackMaybeBecameStuckAtMs = -9223372036854775807L;
            }
            if (shouldPlayWhenReady()) {
                z5 = false;
            } else {
                z5 = false;
            }
            if (this.offloadSchedulingEnabled) {
                z3 = false;
            } else {
                z3 = false;
            }
            playbackInfoCopyWithSleepingForOffload = this.playbackInfo;
            if (playbackInfoCopyWithSleepingForOffload.sleepingForOffload != z3) {
                playbackInfoCopyWithSleepingForOffload = playbackInfoCopyWithSleepingForOffload.copyWithSleepingForOffload(z3);
                this.playbackInfo = playbackInfoCopyWithSleepingForOffload;
            }
            this.requestForRendererSleep = false;
            if (!z3) {
                scheduleNextWork(jUptimeMillis);
            }
            Trace.endSection();
        }
        setState(4);
        stopRenderers();
        z3 = true;
        if (this.playbackInfo.playbackState == 2) {
            i3 = 0;
            while (true) {
                rendererHolderArr = this.renderers;
                if (i3 < rendererHolderArr.length) {
                    break;
                    break;
                } else {
                    if (rendererHolderArr[i3].getRendererReadingFromPeriod(mediaPeriodHolder) != null) {
                        maybeThrowRendererStreamError(i3);
                    }
                    i3++;
                }
            }
            playbackInfo = this.playbackInfo;
            if (!playbackInfo.isLoading) {
                this.playbackMaybeBecameStuckAtMs = -9223372036854775807L;
            } else {
                this.playbackMaybeBecameStuckAtMs = -9223372036854775807L;
            }
        } else {
            this.playbackMaybeBecameStuckAtMs = -9223372036854775807L;
        }
        if (shouldPlayWhenReady()) {
            z5 = false;
        } else {
            z5 = false;
        }
        if (this.offloadSchedulingEnabled) {
            z3 = false;
        } else {
            z3 = false;
        }
        playbackInfoCopyWithSleepingForOffload = this.playbackInfo;
        if (playbackInfoCopyWithSleepingForOffload.sleepingForOffload != z3) {
            playbackInfoCopyWithSleepingForOffload = playbackInfoCopyWithSleepingForOffload.copyWithSleepingForOffload(z3);
            this.playbackInfo = playbackInfoCopyWithSleepingForOffload;
        }
        this.requestForRendererSleep = false;
        if (!z3) {
            scheduleNextWork(jUptimeMillis);
        }
        Trace.endSection();
    }

    public final void enableRenderer(MediaPeriodHolder mediaPeriodHolder, int i, boolean z, long j) {
        RendererHolder rendererHolder = this.renderers[i];
        boolean zIsRendererEnabled = rendererHolder.isRendererEnabled();
        BaseRenderer baseRenderer = rendererHolder.primaryRenderer;
        if (zIsRendererEnabled) {
            return;
        }
        boolean z2 = mediaPeriodHolder == this.queue.playing;
        TrackSelectorResult trackSelectorResult = mediaPeriodHolder.trackSelectorResult;
        RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i];
        ExoTrackSelection exoTrackSelection = trackSelectorResult.selections[i];
        boolean z3 = shouldPlayWhenReady() && this.playbackInfo.playbackState == 3;
        boolean z4 = !z && z3;
        this.enabledRendererCount++;
        SampleStream sampleStream = mediaPeriodHolder.sampleStreams[i];
        long j2 = mediaPeriodHolder.rendererPositionOffsetUs;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = mediaPeriodHolder.info.id;
        BaseRenderer baseRenderer2 = rendererHolder.secondaryRenderer;
        int length = exoTrackSelection != null ? exoTrackSelection.length() : 0;
        Format[] formatArr = new Format[length];
        for (int i2 = 0; i2 < length; i2++) {
            exoTrackSelection.getClass();
            formatArr[i2] = exoTrackSelection.getFormat(i2);
        }
        int i3 = rendererHolder.prewarmingState;
        DefaultMediaClock defaultMediaClock = this.mediaClock;
        if (i3 == 0 || i3 == 2 || i3 == 4) {
            rendererHolder.primaryRequiresReset = true;
            UtilsKt.checkState(baseRenderer.state == 0);
            baseRenderer.configuration = rendererConfiguration;
            baseRenderer.mediaPeriodId = mediaSource$MediaPeriodId;
            baseRenderer.state = (byte) 1;
            baseRenderer.onEnabled(z4, z2);
            baseRenderer.replaceStream(formatArr, sampleStream, j, j2, mediaSource$MediaPeriodId);
            baseRenderer.resetPosition(j, z4, true);
            defaultMediaClock.onRendererEnabled(baseRenderer);
        } else {
            rendererHolder.secondaryRequiresReset = true;
            baseRenderer2.getClass();
            UtilsKt.checkState(baseRenderer2.state == 0);
            baseRenderer2.configuration = rendererConfiguration;
            baseRenderer2.mediaPeriodId = mediaSource$MediaPeriodId;
            baseRenderer2.state = (byte) 1;
            baseRenderer2.onEnabled(z4, z2);
            baseRenderer2.replaceStream(formatArr, sampleStream, j, j2, mediaSource$MediaPeriodId);
            baseRenderer2.resetPosition(j, z4, true);
            defaultMediaClock.onRendererEnabled(baseRenderer2);
        }
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        BaseRenderer rendererReadingFromPeriod = rendererHolder.getRendererReadingFromPeriod(mediaPeriodHolder);
        rendererReadingFromPeriod.getClass();
        rendererReadingFromPeriod.handleMessage(11, anonymousClass1);
        if (z3 && z2) {
            rendererHolder.start();
        }
    }

    public final void enableRenderers(boolean[] zArr, long j) {
        RendererHolder[] rendererHolderArr;
        ExoPlayerImplInternal exoPlayerImplInternal;
        long j2;
        MediaPeriodHolder mediaPeriodHolder = this.queue.reading;
        TrackSelectorResult trackSelectorResult = mediaPeriodHolder.trackSelectorResult;
        int i = 0;
        while (true) {
            rendererHolderArr = this.renderers;
            if (i >= rendererHolderArr.length) {
                break;
            }
            if (!trackSelectorResult.isRendererEnabled(i)) {
                rendererHolderArr[i].reset();
            }
            i++;
        }
        int i2 = 0;
        while (i2 < rendererHolderArr.length) {
            if (trackSelectorResult.isRendererEnabled(i2) && rendererHolderArr[i2].getRendererReadingFromPeriod(mediaPeriodHolder) == null) {
                exoPlayerImplInternal = this;
                j2 = j;
                exoPlayerImplInternal.enableRenderer(mediaPeriodHolder, i2, zArr[i2], j2);
            } else {
                exoPlayerImplInternal = this;
                j2 = j;
            }
            i2++;
            this = exoPlayerImplInternal;
            j = j2;
        }
    }

    public final long getLiveOffsetUs(Timeline timeline, Object obj, long j) {
        Timeline.Period period = this.period;
        int i = timeline.getPeriodByUid(obj, period).windowIndex;
        Timeline.Window window = this.window;
        timeline.getWindow(i, window);
        if (window.windowStartTimeMs == -9223372036854775807L || !window.isLive() || !window.isDynamic) {
            return -9223372036854775807L;
        }
        long j2 = window.elapsedRealtimeEpochOffsetMs;
        return Util.msToUs((j2 == -9223372036854775807L ? System.currentTimeMillis() : j2 + android.os.SystemClock.elapsedRealtime()) - window.windowStartTimeMs) - (j + period.positionInWindowUs);
    }

    public final long getMaxRendererReadPositionUs(MediaPeriodHolder mediaPeriodHolder) {
        if (mediaPeriodHolder == null) {
            return 0L;
        }
        long jMax = mediaPeriodHolder.rendererPositionOffsetUs;
        if (!mediaPeriodHolder.prepared) {
            return jMax;
        }
        int i = 0;
        while (true) {
            RendererHolder[] rendererHolderArr = this.renderers;
            if (i >= rendererHolderArr.length) {
                return jMax;
            }
            if (rendererHolderArr[i].getRendererReadingFromPeriod(mediaPeriodHolder) != null) {
                BaseRenderer rendererReadingFromPeriod = rendererHolderArr[i].getRendererReadingFromPeriod(mediaPeriodHolder);
                Objects.requireNonNull(rendererReadingFromPeriod);
                long j = rendererReadingFromPeriod.readingPositionUs;
                if (j == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                jMax = Math.max(j, jMax);
            }
            i++;
        }
    }

    public final Pair getPlaceholderFirstMediaPeriodPositionUs(Timeline timeline) {
        if (timeline.isEmpty()) {
            return Pair.create(PlaybackInfo.PLACEHOLDER_MEDIA_PERIOD_ID, 0L);
        }
        Pair periodPositionUs = timeline.getPeriodPositionUs(this.window, this.period, timeline.getFirstWindowIndex(this.shuffleModeEnabled), -9223372036854775807L);
        MediaSource$MediaPeriodId mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange = this.queue.resolveMediaPeriodIdForAdsAfterPeriodPositionChange(timeline, periodPositionUs.first, 0L);
        long jLongValue = ((Long) periodPositionUs.second).longValue();
        if (mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd()) {
            Object obj = mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.periodUid;
            Timeline.Period period = this.period;
            timeline.getPeriodByUid(obj, period);
            jLongValue = mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adIndexInAdGroup == period.getFirstAdIndexToPlay(mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adGroupIndex) ? period.adPlaybackState.adResumePositionUs : 0L;
        }
        return Pair.create(mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange, Long.valueOf(jLongValue));
    }

    public final long getTotalBufferedDurationUs(long j) {
        MediaPeriodHolder mediaPeriodHolder = this.queue.loading;
        if (mediaPeriodHolder == null) {
            return 0L;
        }
        return Math.max(0L, j - (this.rendererPositionUs - mediaPeriodHolder.rendererPositionOffsetUs));
    }

    public final void handleAudioFocusPlayerCommandInternal(int i) {
        PlaybackInfo playbackInfo = this.playbackInfo;
        updatePlayWhenReadyWithAudioFocus(i, playbackInfo.playbackSuppressionReason, playbackInfo.playWhenReadyChangeReason, playbackInfo.playWhenReady);
    }

    public final void handleAudioFocusVolumeMultiplierChange() {
        setVolumeInternal(this.volume);
    }

    public final void handleContinueLoadingRequested(MediaPeriod mediaPeriod) {
        MediaPeriodQueue mediaPeriodQueue = this.queue;
        MediaPeriodHolder mediaPeriodHolder = mediaPeriodQueue.loading;
        if (mediaPeriodHolder != null && mediaPeriodHolder.mediaPeriod == mediaPeriod) {
            mediaPeriodQueue.reevaluateBuffer(this.rendererPositionUs);
            maybeContinueLoading();
            return;
        }
        MediaPeriodHolder mediaPeriodHolder2 = mediaPeriodQueue.preloading;
        if (mediaPeriodHolder2 == null || mediaPeriodHolder2.mediaPeriod != mediaPeriod) {
            return;
        }
        maybeContinuePreloading();
    }

    public final void handleIoException(IOException iOException, int i) {
        ExoPlaybackException exoPlaybackException = new ExoPlaybackException(0, iOException, i);
        MediaPeriodHolder mediaPeriodHolder = this.queue.playing;
        if (mediaPeriodHolder != null) {
            exoPlaybackException = exoPlaybackException.copyWithMediaPeriodId(mediaPeriodHolder.info.id);
        }
        Log.e("ExoPlayerImplInternal", "Playback error", exoPlaybackException);
        stopInternal(false, false);
        this.playbackInfo = this.playbackInfo.copyWithPlaybackError(exoPlaybackException);
    }

    public final void handleLoadingMediaPeriodChanged(boolean z) {
        MediaPeriodHolder mediaPeriodHolder = this.queue.loading;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = mediaPeriodHolder == null ? this.playbackInfo.periodId : mediaPeriodHolder.info.id;
        boolean zEquals = this.playbackInfo.loadingMediaPeriodId.equals(mediaSource$MediaPeriodId);
        if (!zEquals) {
            this.playbackInfo = this.playbackInfo.copyWithLoadingMediaPeriodId(mediaSource$MediaPeriodId);
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        playbackInfo.bufferedPositionUs = mediaPeriodHolder == null ? playbackInfo.positionUs : mediaPeriodHolder.getBufferedPositionUs();
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        playbackInfo2.totalBufferedDurationUs = getTotalBufferedDurationUs(playbackInfo2.bufferedPositionUs);
        if ((!zEquals || z) && mediaPeriodHolder != null && mediaPeriodHolder.prepared) {
            updateLoadControlTrackSelection(mediaPeriodHolder.info.id, mediaPeriodHolder.trackSelectorResult);
        }
    }

    /* JADX WARN: Code duplicated, block: B:111:0x0232  */
    /* JADX WARN: Code duplicated, block: B:140:0x029c  */
    /* JADX WARN: Code duplicated, block: B:155:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:158:0x02df  */
    /* JADX WARN: Code duplicated, block: B:159:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:169:0x030f  */
    /* JADX WARN: Code duplicated, block: B:177:0x032e  */
    /* JADX WARN: Code duplicated, block: B:257:0x0427  */
    /* JADX WARN: Code duplicated, block: B:258:0x0429  */
    /* JADX WARN: Code duplicated, block: B:263:0x0442  */
    /* JADX WARN: Code duplicated, block: B:265:0x0448  */
    /* JADX WARN: Code duplicated, block: B:266:0x044a  */
    /* JADX WARN: Code duplicated, block: B:270:0x0470  */
    /* JADX WARN: Code duplicated, block: B:275:0x0487  */
    /* JADX WARN: Code duplicated, block: B:276:0x0489  */
    /* JADX WARN: Code duplicated, block: B:279:0x0496  */
    /* JADX WARN: Code duplicated, block: B:281:0x04a0  */
    /* JADX WARN: Code duplicated, block: B:283:0x04a6  */
    /* JADX WARN: Code duplicated, block: B:284:0x04a8  */
    /* JADX WARN: Code duplicated, block: B:288:0x04ce  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25, types: [androidx.media3.common.Timeline] */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r2v10, types: [androidx.media3.common.Timeline] */
    /* JADX WARN: Type inference failed for: r2v15, types: [androidx.media3.exoplayer.PlaybackInfo] */
    /* JADX WARN: Type inference failed for: r2v31, types: [androidx.media3.exoplayer.MediaPeriodQueue] */
    /* JADX WARN: Type inference failed for: r45v0, types: [androidx.media3.exoplayer.ExoPlayerImplInternal] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v18, types: [androidx.media3.common.Timeline] */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void handleMediaSourceListInfoRefreshed(Timeline timeline, boolean z) throws Throwable {
        long j;
        Timeline.Window window;
        Object obj;
        int firstWindowIndex;
        long jConstrainValue;
        boolean z2;
        boolean z3;
        boolean z4;
        Timeline timeline2;
        Timeline.Period period;
        boolean z5;
        Timeline timeline3;
        Timeline.Period period2;
        Timeline timeline4;
        long jLongValue;
        boolean z6;
        int i;
        int i2;
        long jMin;
        long j2;
        boolean z7;
        int i3;
        int i4;
        boolean z8;
        PositionUpdateForPlaylistChange positionUpdateForPlaylistChange;
        int i5;
        long jLongValue2;
        boolean z9;
        int firstWindowIndex2;
        boolean z10;
        Timeline.Period period3;
        Timeline timeline5;
        ?? r11;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId;
        long j3;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId2;
        boolean z11;
        long j4;
        boolean z12;
        ?? r8;
        MediaPeriodHolder mediaPeriodHolder;
        long j5;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId3;
        boolean z13;
        long j6;
        PlaybackInfo playbackInfo = this.playbackInfo;
        SeekPosition seekPosition = this.pendingInitialSeekPosition;
        MediaPeriodQueue mediaPeriodQueue = this.queue;
        int i6 = this.repeatMode;
        boolean z14 = this.shuffleModeEnabled;
        Timeline.Window window2 = this.window;
        Timeline.Period period4 = this.period;
        if (timeline.isEmpty()) {
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId4 = PlaybackInfo.PLACEHOLDER_MEDIA_PERIOD_ID;
            boolean z15 = (mediaSource$MediaPeriodId4.equals(playbackInfo.periodId) && playbackInfo.positionUs == 0) ? false : true;
            PositionUpdateForPlaylistChange positionUpdateForPlaylistChange2 = new PositionUpdateForPlaylistChange(mediaSource$MediaPeriodId4, 0L, -9223372036854775807L, false, true, false, z15, z15 && z && !playbackInfo.timeline.isEmpty() && !playbackInfo.timeline.getPeriodByUid(playbackInfo.periodId.periodUid, period4).isPlaceholder, 4);
            timeline5 = timeline;
            positionUpdateForPlaylistChange = positionUpdateForPlaylistChange2;
            period3 = period4;
        } else {
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId5 = playbackInfo.periodId;
            Object obj2 = mediaSource$MediaPeriodId5.periodUid;
            Timeline timeline6 = playbackInfo.timeline;
            boolean z16 = timeline6.isEmpty() || timeline6.getPeriodByUid(mediaSource$MediaPeriodId5.periodUid, period4).isPlaceholder;
            long j7 = (playbackInfo.periodId.isAd() || z16) ? playbackInfo.requestedContentPositionUs : playbackInfo.positionUs;
            if (seekPosition != null) {
                boolean z17 = true;
                j = 1;
                Timeline timeline7 = timeline;
                Pair pairResolveSeekPositionUs = resolveSeekPositionUs(timeline7, seekPosition, true, i6, z14, window2, period4);
                if (pairResolveSeekPositionUs == null) {
                    firstWindowIndex2 = timeline7.getFirstWindowIndex(z14);
                    obj = obj2;
                    jLongValue2 = j7;
                    z9 = false;
                    z10 = false;
                } else {
                    long j8 = seekPosition.windowPositionUs;
                    obj = pairResolveSeekPositionUs.first;
                    if (j8 == -9223372036854775807L) {
                        firstWindowIndex2 = timeline7.getPeriodByUid(obj, period4).windowIndex;
                        obj = obj2;
                        jLongValue2 = j7;
                        z9 = false;
                    } else {
                        jLongValue2 = ((Long) pairResolveSeekPositionUs.second).longValue();
                        z9 = true;
                        firstWindowIndex2 = -1;
                    }
                    z10 = playbackInfo.playbackState == 4;
                    z17 = false;
                }
                j7 = jLongValue2;
                z4 = z9;
                z3 = z17;
                z2 = z10;
                firstWindowIndex = firstWindowIndex2;
                window = window2;
                timeline4 = timeline7;
                period2 = period4;
            } else {
                j = 1;
                Timeline timeline8 = timeline;
                if (playbackInfo.timeline.isEmpty()) {
                    firstWindowIndex = timeline8.getFirstWindowIndex(z14);
                    window = window2;
                    obj = obj2;
                } else if (timeline8.getIndexOfPeriod(obj2) == -1) {
                    int iResolveSubsequentPeriod = resolveSubsequentPeriod(window2, period4, i6, z14, obj, playbackInfo.timeline, timeline8);
                    window = window2;
                    if (iResolveSubsequentPeriod == -1) {
                        obj = obj2;
                        timeline2 = timeline8;
                        period = period4;
                        iResolveSubsequentPeriod = timeline2.getFirstWindowIndex(z14);
                        z5 = true;
                    } else {
                        obj = obj2;
                        timeline2 = timeline8;
                        period = period4;
                        z5 = false;
                    }
                    firstWindowIndex = iResolveSubsequentPeriod;
                    z3 = z5;
                    j7 = j7;
                    z2 = false;
                    timeline3 = timeline2;
                    z4 = false;
                    timeline4 = timeline3;
                    period2 = period;
                } else {
                    window = window2;
                    if (j7 == -9223372036854775807L) {
                        obj = obj2;
                        firstWindowIndex = timeline8.getPeriodByUid(obj, period4).windowIndex;
                    } else if (z16) {
                        playbackInfo.timeline.getPeriodByUid(mediaSource$MediaPeriodId5.periodUid, period4);
                        if (playbackInfo.timeline.getWindow(period4.windowIndex, window, 0L).firstPeriodIndex == playbackInfo.timeline.getIndexOfPeriod(mediaSource$MediaPeriodId5.periodUid)) {
                            Pair periodPositionUs = timeline8.getPeriodPositionUs(window, period4, timeline8.getPeriodByUid(obj, period4).windowIndex, j7 + period4.positionInWindowUs);
                            obj = periodPositionUs.first;
                            jConstrainValue = ((Long) periodPositionUs.second).longValue();
                        } else {
                            jConstrainValue = timeline8.getPeriodByUid(obj, period4).durationUs != -9223372036854775807L ? Util.constrainValue(j7, 0L, period4.durationUs - 1) : j7;
                        }
                        j7 = jConstrainValue;
                        firstWindowIndex = -1;
                        z2 = false;
                        z3 = false;
                        z4 = true;
                        timeline4 = timeline8;
                        period2 = period4;
                    } else {
                        firstWindowIndex = -1;
                        z2 = false;
                        z3 = false;
                        timeline3 = timeline8;
                        period = period4;
                        z4 = false;
                        timeline4 = timeline3;
                        period2 = period;
                    }
                }
                z2 = false;
                z3 = false;
                timeline3 = timeline8;
                period = period4;
                z4 = false;
                timeline4 = timeline3;
                period2 = period;
            }
            if (firstWindowIndex != -1) {
                Pair periodPositionUs2 = timeline4.getPeriodPositionUs(window, period2, firstWindowIndex, -9223372036854775807L);
                obj = periodPositionUs2.first;
                jLongValue = ((Long) periodPositionUs2.second).longValue();
                j7 = -9223372036854775807L;
            } else {
                jLongValue = j7;
            }
            MediaSource$MediaPeriodId mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange = mediaPeriodQueue.resolveMediaPeriodIdForAdsAfterPeriodPositionChange(timeline4, obj, jLongValue);
            int i7 = mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.nextAdGroupIndex;
            boolean z18 = i7 == -1 || ((i5 = mediaSource$MediaPeriodId5.nextAdGroupIndex) != -1 && i7 >= i5);
            boolean zEquals = mediaSource$MediaPeriodId5.periodUid.equals(obj);
            boolean z19 = zEquals && !mediaSource$MediaPeriodId5.isAd() && !mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd() && z18;
            Timeline.Period periodByUid = timeline4.getPeriodByUid(obj, period2);
            if (z16 || j7 != j7) {
                z6 = false;
            } else {
                Object obj3 = mediaSource$MediaPeriodId5.periodUid;
                int i8 = mediaSource$MediaPeriodId5.adIndexInAdGroup;
                int i9 = mediaSource$MediaPeriodId5.adGroupIndex;
                if (obj3.equals(mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.periodUid) && (!(mediaSource$MediaPeriodId5.isAd() && periodByUid.isServerSideInsertedAdGroup(i9)) ? mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd() && periodByUid.isServerSideInsertedAdGroup(mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adGroupIndex) : !(periodByUid.getAdState(i9, i8) == 4 || periodByUid.getAdState(i9, i8) == 2))) {
                    z6 = true;
                } else {
                    z6 = false;
                }
            }
            if (z19 || z6) {
                mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange = mediaSource$MediaPeriodId5;
            }
            if (!mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd()) {
                if (zEquals && mediaSource$MediaPeriodId5.isAd()) {
                    AdPlaybackState.AdGroup adGroup = timeline4.getPeriodByUid(obj, period2).adPlaybackState.getAdGroup(mediaSource$MediaPeriodId5.adGroupIndex);
                    long j9 = adGroup.contentResumeOffsetUs;
                    long j10 = playbackInfo.requestedContentPositionUs;
                    if (j10 != -9223372036854775807L) {
                        long j11 = adGroup.timeUs;
                        if (j11 == Long.MIN_VALUE || j11 + j9 > j10) {
                            i = adGroup.count;
                            i2 = mediaSource$MediaPeriodId5.adIndexInAdGroup;
                            if (i <= i2 && adGroup.states[i2] == 2) {
                                long j12 = timeline4.getPeriodByUid(obj, period2).durationUs;
                                jMin = j12 != -9223372036854775807L ? Math.min(j12 - j, jLongValue + j9) : jLongValue + j9;
                                j2 = jMin;
                            }
                        }
                    } else {
                        i = adGroup.count;
                        i2 = mediaSource$MediaPeriodId5.adIndexInAdGroup;
                        if (i <= i2) {
                        }
                    }
                }
                if (mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.equals(playbackInfo.periodId) || jMin != playbackInfo.positionUs) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (timeline4.getIndexOfPeriod(playbackInfo.periodId.periodUid) == -1) {
                    i3 = 4;
                } else {
                    i3 = 3;
                }
                if (mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.periodUid.equals(playbackInfo.periodId.periodUid) || mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adGroupIndex == -1) {
                    i4 = i3;
                } else {
                    AdPlaybackState.AdGroup adGroup2 = timeline4.getPeriodByUid(mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.periodUid, period2).adPlaybackState.getAdGroup(mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adGroupIndex);
                    int i10 = mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adIndexInAdGroup;
                    int[] iArr = adGroup2.states;
                    if (i10 >= iArr.length || iArr[i10] != 2) {
                        i4 = 0;
                    } else {
                        i4 = i3;
                    }
                }
                if (z7 || !z || playbackInfo.timeline.isEmpty() || playbackInfo.timeline.getPeriodByUid(playbackInfo.periodId.periodUid, period2).isPlaceholder) {
                    z8 = false;
                } else {
                    z8 = true;
                }
                positionUpdateForPlaylistChange = new PositionUpdateForPlaylistChange(mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange, jMin, j2, z2, z3, z4, z7, z8, i4);
                timeline5 = timeline4;
                period3 = period2;
            } else if (mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.equals(mediaSource$MediaPeriodId5)) {
                jLongValue = playbackInfo.positionUs;
            } else {
                timeline4.getPeriodByUid(mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.periodUid, period2);
                jLongValue = mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adIndexInAdGroup == period2.getFirstAdIndexToPlay(mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adGroupIndex) ? period2.adPlaybackState.adResumePositionUs : 0L;
            }
            jMin = jLongValue;
            j2 = j7;
            if (mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.equals(playbackInfo.periodId)) {
                z7 = true;
            } else {
                z7 = true;
            }
            if (timeline4.getIndexOfPeriod(playbackInfo.periodId.periodUid) == -1) {
                i3 = 4;
            } else {
                i3 = 3;
            }
            if (mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.periodUid.equals(playbackInfo.periodId.periodUid)) {
                i4 = i3;
            } else {
                i4 = i3;
            }
            if (z7) {
                z8 = false;
            } else {
                z8 = false;
            }
            positionUpdateForPlaylistChange = new PositionUpdateForPlaylistChange(mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange, jMin, j2, z2, z3, z4, z7, z8, i4);
            timeline5 = timeline4;
            period3 = period2;
        }
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId6 = positionUpdateForPlaylistChange.periodId;
        long jSeekToPeriodPosition = positionUpdateForPlaylistChange.periodPositionUs;
        try {
            if (positionUpdateForPlaylistChange.endPlayback) {
                z12 = true;
                if (this.playbackInfo.playbackState != 1) {
                    setState(4);
                }
                resetInternal(false, false, false, true);
            } else {
                z12 = true;
            }
            RendererHolder[] rendererHolderArr = this.renderers;
            int length = rendererHolderArr.length;
            int i11 = 0;
            ?? r9 = period3;
            while (i11 < length) {
                RendererHolder rendererHolder = rendererHolderArr[i11];
                BaseRenderer baseRenderer = rendererHolder.primaryRenderer;
                boolean zEquals2 = baseRenderer.timeline.equals(timeline5);
                if (!zEquals2) {
                    baseRenderer.timeline = timeline5;
                    baseRenderer.onTimelineChanged();
                }
                BaseRenderer baseRenderer2 = rendererHolder.secondaryRenderer;
                if (baseRenderer2 != null && !baseRenderer2.timeline.equals(timeline5)) {
                    baseRenderer2.timeline = timeline5;
                    baseRenderer2.onTimelineChanged();
                }
                i11++;
                r9 = zEquals2;
            }
            try {
                if (positionUpdateForPlaylistChange.periodPositionChanged) {
                    r9 = timeline5;
                    if (r9.isEmpty()) {
                        mediaSource$MediaPeriodId = mediaSource$MediaPeriodId6;
                    } else {
                        for (MediaPeriodHolder mediaPeriodHolder2 = this.queue.playing; mediaPeriodHolder2 != null; mediaPeriodHolder2 = mediaPeriodHolder2.next) {
                            if (mediaPeriodHolder2.info.id.equals(mediaSource$MediaPeriodId6)) {
                                mediaPeriodHolder2.info = this.queue.getUpdatedMediaPeriodInfo(r9, mediaPeriodHolder2.info);
                                mediaPeriodHolder2.updateClipping();
                            }
                        }
                        boolean z20 = positionUpdateForPlaylistChange.forceBufferingState;
                        try {
                            MediaPeriodQueue mediaPeriodQueue2 = this.queue;
                            mediaSource$MediaPeriodId = mediaSource$MediaPeriodId6;
                            try {
                                jSeekToPeriodPosition = seekToPeriodPosition(mediaSource$MediaPeriodId, jSeekToPeriodPosition, mediaPeriodQueue2.playing != mediaPeriodQueue2.reading ? z12 : false, z20);
                            } catch (Throwable th) {
                                th = th;
                                jSeekToPeriodPosition = jSeekToPeriodPosition;
                                r8 = r9;
                                r11 = r8;
                                PlaybackInfo playbackInfo2 = this.playbackInfo;
                                Timeline timeline9 = playbackInfo2.timeline;
                                MediaSource$MediaPeriodId mediaSource$MediaPeriodId7 = playbackInfo2.periodId;
                                if (positionUpdateForPlaylistChange.setTargetLiveOffset) {
                                    j3 = jSeekToPeriodPosition;
                                } else {
                                    j3 = -9223372036854775807L;
                                }
                                mediaSource$MediaPeriodId2 = mediaSource$MediaPeriodId;
                                updatePlaybackSpeedSettingsForNewPeriod(r11, mediaSource$MediaPeriodId2, timeline9, mediaSource$MediaPeriodId7, j3, false);
                                if (positionUpdateForPlaylistChange.periodPositionChanged) {
                                    long j13 = positionUpdateForPlaylistChange.requestedContentPositionUs;
                                    z11 = positionUpdateForPlaylistChange.reportDiscontinuity;
                                    if (z11) {
                                        j4 = jSeekToPeriodPosition;
                                    } else {
                                        j4 = this.playbackInfo.discontinuityStartPositionUs;
                                    }
                                    this.playbackInfo = handlePositionDiscontinuity(mediaSource$MediaPeriodId2, jSeekToPeriodPosition, j13, j4, z11, positionUpdateForPlaylistChange.discontinuityReason);
                                } else {
                                    long j14 = positionUpdateForPlaylistChange.requestedContentPositionUs;
                                    z11 = positionUpdateForPlaylistChange.reportDiscontinuity;
                                    if (z11) {
                                        j4 = jSeekToPeriodPosition;
                                    } else {
                                        j4 = this.playbackInfo.discontinuityStartPositionUs;
                                    }
                                    this.playbackInfo = handlePositionDiscontinuity(mediaSource$MediaPeriodId2, jSeekToPeriodPosition, j14, j4, z11, positionUpdateForPlaylistChange.discontinuityReason);
                                }
                                resetPendingPauseAtEndOfPeriod();
                                resolvePendingMessagePositions(r11, this.playbackInfo.timeline);
                                this.playbackInfo = this.playbackInfo.copyWithTimeline(r11);
                                if (!r11.isEmpty()) {
                                    this.pendingInitialSeekPosition = null;
                                }
                                handleLoadingMediaPeriodChanged(false);
                                this.handler.sendEmptyMessage(2);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            mediaSource$MediaPeriodId = mediaSource$MediaPeriodId6;
                            r8 = r9;
                            r11 = r8;
                            PlaybackInfo playbackInfo3 = this.playbackInfo;
                            Timeline timeline10 = playbackInfo3.timeline;
                            MediaSource$MediaPeriodId mediaSource$MediaPeriodId8 = playbackInfo3.periodId;
                            if (positionUpdateForPlaylistChange.setTargetLiveOffset) {
                                j3 = jSeekToPeriodPosition;
                            } else {
                                j3 = -9223372036854775807L;
                            }
                            mediaSource$MediaPeriodId2 = mediaSource$MediaPeriodId;
                            updatePlaybackSpeedSettingsForNewPeriod(r11, mediaSource$MediaPeriodId2, timeline10, mediaSource$MediaPeriodId8, j3, false);
                            if (positionUpdateForPlaylistChange.periodPositionChanged) {
                                long j15 = positionUpdateForPlaylistChange.requestedContentPositionUs;
                                z11 = positionUpdateForPlaylistChange.reportDiscontinuity;
                                if (z11) {
                                    j4 = jSeekToPeriodPosition;
                                } else {
                                    j4 = this.playbackInfo.discontinuityStartPositionUs;
                                }
                                this.playbackInfo = handlePositionDiscontinuity(mediaSource$MediaPeriodId2, jSeekToPeriodPosition, j15, j4, z11, positionUpdateForPlaylistChange.discontinuityReason);
                            } else {
                                long j16 = positionUpdateForPlaylistChange.requestedContentPositionUs;
                                z11 = positionUpdateForPlaylistChange.reportDiscontinuity;
                                if (z11) {
                                    j4 = jSeekToPeriodPosition;
                                } else {
                                    j4 = this.playbackInfo.discontinuityStartPositionUs;
                                }
                                this.playbackInfo = handlePositionDiscontinuity(mediaSource$MediaPeriodId2, jSeekToPeriodPosition, j16, j4, z11, positionUpdateForPlaylistChange.discontinuityReason);
                            }
                            resetPendingPauseAtEndOfPeriod();
                            resolvePendingMessagePositions(r11, this.playbackInfo.timeline);
                            this.playbackInfo = this.playbackInfo.copyWithTimeline(r11);
                            if (!r11.isEmpty()) {
                                this.pendingInitialSeekPosition = null;
                            }
                            handleLoadingMediaPeriodChanged(false);
                            this.handler.sendEmptyMessage(2);
                            throw th;
                        }
                    }
                    PlaybackInfo playbackInfo4 = this.playbackInfo;
                    Timeline timeline11 = playbackInfo4.timeline;
                    MediaSource$MediaPeriodId mediaSource$MediaPeriodId9 = playbackInfo4.periodId;
                    if (positionUpdateForPlaylistChange.setTargetLiveOffset) {
                        j5 = jSeekToPeriodPosition;
                    } else {
                        j5 = -9223372036854775807L;
                    }
                    mediaSource$MediaPeriodId3 = mediaSource$MediaPeriodId;
                    updatePlaybackSpeedSettingsForNewPeriod(timeline, mediaSource$MediaPeriodId3, timeline11, mediaSource$MediaPeriodId9, j5, false);
                    if (positionUpdateForPlaylistChange.periodPositionChanged) {
                        long j17 = positionUpdateForPlaylistChange.requestedContentPositionUs;
                        z13 = positionUpdateForPlaylistChange.reportDiscontinuity;
                        if (z13) {
                            j6 = jSeekToPeriodPosition;
                        } else {
                            j6 = this.playbackInfo.discontinuityStartPositionUs;
                        }
                        this.playbackInfo = handlePositionDiscontinuity(mediaSource$MediaPeriodId3, jSeekToPeriodPosition, j17, j6, z13, positionUpdateForPlaylistChange.discontinuityReason);
                    } else {
                        long j18 = positionUpdateForPlaylistChange.requestedContentPositionUs;
                        z13 = positionUpdateForPlaylistChange.reportDiscontinuity;
                        if (z13) {
                            j6 = jSeekToPeriodPosition;
                        } else {
                            j6 = this.playbackInfo.discontinuityStartPositionUs;
                        }
                        this.playbackInfo = handlePositionDiscontinuity(mediaSource$MediaPeriodId3, jSeekToPeriodPosition, j18, j6, z13, positionUpdateForPlaylistChange.discontinuityReason);
                    }
                    resetPendingPauseAtEndOfPeriod();
                    resolvePendingMessagePositions(timeline, this.playbackInfo.timeline);
                    this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline);
                    if (!timeline.isEmpty()) {
                        this.pendingInitialSeekPosition = null;
                    }
                    handleLoadingMediaPeriodChanged(false);
                    this.handler.sendEmptyMessage(2);
                    return;
                }
                try {
                    MediaPeriodHolder mediaPeriodHolder3 = this.queue.reading;
                    try {
                        try {
                            int iUpdateQueuedPeriods = this.queue.updateQueuedPeriods(timeline, this.rendererPositionUs, mediaPeriodHolder3 == null ? 0L : getMaxRendererReadPositionUs(mediaPeriodHolder3), (!areRenderersPrewarming() || (mediaPeriodHolder = this.queue.prewarming) == null) ? 0L : getMaxRendererReadPositionUs(mediaPeriodHolder));
                            if ((iUpdateQueuedPeriods & 1) != 0) {
                                seekToCurrentPosition(false);
                            } else if ((iUpdateQueuedPeriods & 2) != 0) {
                                disableAndResetPrewarmingRenderers();
                            }
                            mediaSource$MediaPeriodId = mediaSource$MediaPeriodId6;
                            PlaybackInfo playbackInfo5 = this.playbackInfo;
                            Timeline timeline12 = playbackInfo5.timeline;
                            MediaSource$MediaPeriodId mediaSource$MediaPeriodId10 = playbackInfo5.periodId;
                            if (positionUpdateForPlaylistChange.setTargetLiveOffset) {
                                j5 = jSeekToPeriodPosition;
                            } else {
                                j5 = -9223372036854775807L;
                            }
                            mediaSource$MediaPeriodId3 = mediaSource$MediaPeriodId;
                            updatePlaybackSpeedSettingsForNewPeriod(timeline, mediaSource$MediaPeriodId3, timeline12, mediaSource$MediaPeriodId10, j5, false);
                            if (positionUpdateForPlaylistChange.periodPositionChanged || positionUpdateForPlaylistChange.requestedContentPositionUs != this.playbackInfo.requestedContentPositionUs) {
                                long j19 = positionUpdateForPlaylistChange.requestedContentPositionUs;
                                z13 = positionUpdateForPlaylistChange.reportDiscontinuity;
                                if (z13) {
                                    j6 = jSeekToPeriodPosition;
                                } else {
                                    j6 = this.playbackInfo.discontinuityStartPositionUs;
                                }
                                this.playbackInfo = handlePositionDiscontinuity(mediaSource$MediaPeriodId3, jSeekToPeriodPosition, j19, j6, z13, positionUpdateForPlaylistChange.discontinuityReason);
                            }
                            resetPendingPauseAtEndOfPeriod();
                            resolvePendingMessagePositions(timeline, this.playbackInfo.timeline);
                            this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline);
                            if (!timeline.isEmpty()) {
                                this.pendingInitialSeekPosition = null;
                            }
                            handleLoadingMediaPeriodChanged(false);
                            this.handler.sendEmptyMessage(2);
                            return;
                        } catch (Throwable th3) {
                            th = th3;
                            r9 = timeline;
                            mediaSource$MediaPeriodId = mediaSource$MediaPeriodId6;
                            r8 = r9;
                            r11 = r8;
                            PlaybackInfo playbackInfo6 = this.playbackInfo;
                            Timeline timeline13 = playbackInfo6.timeline;
                            MediaSource$MediaPeriodId mediaSource$MediaPeriodId11 = playbackInfo6.periodId;
                            if (positionUpdateForPlaylistChange.setTargetLiveOffset) {
                                j3 = jSeekToPeriodPosition;
                            } else {
                                j3 = -9223372036854775807L;
                            }
                            mediaSource$MediaPeriodId2 = mediaSource$MediaPeriodId;
                            updatePlaybackSpeedSettingsForNewPeriod(r11, mediaSource$MediaPeriodId2, timeline13, mediaSource$MediaPeriodId11, j3, false);
                            if (positionUpdateForPlaylistChange.periodPositionChanged) {
                                long j110 = positionUpdateForPlaylistChange.requestedContentPositionUs;
                                z11 = positionUpdateForPlaylistChange.reportDiscontinuity;
                                if (z11) {
                                    j4 = jSeekToPeriodPosition;
                                } else {
                                    j4 = this.playbackInfo.discontinuityStartPositionUs;
                                }
                                this.playbackInfo = handlePositionDiscontinuity(mediaSource$MediaPeriodId2, jSeekToPeriodPosition, j110, j4, z11, positionUpdateForPlaylistChange.discontinuityReason);
                            } else {
                                long j111 = positionUpdateForPlaylistChange.requestedContentPositionUs;
                                z11 = positionUpdateForPlaylistChange.reportDiscontinuity;
                                if (z11) {
                                    j4 = jSeekToPeriodPosition;
                                } else {
                                    j4 = this.playbackInfo.discontinuityStartPositionUs;
                                }
                                this.playbackInfo = handlePositionDiscontinuity(mediaSource$MediaPeriodId2, jSeekToPeriodPosition, j111, j4, z11, positionUpdateForPlaylistChange.discontinuityReason);
                            }
                            resetPendingPauseAtEndOfPeriod();
                            resolvePendingMessagePositions(r11, this.playbackInfo.timeline);
                            this.playbackInfo = this.playbackInfo.copyWithTimeline(r11);
                            if (!r11.isEmpty()) {
                                this.pendingInitialSeekPosition = null;
                            }
                            handleLoadingMediaPeriodChanged(false);
                            this.handler.sendEmptyMessage(2);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        r9 = timeline;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    r9 = timeline5;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
            r11 = timeline5;
            mediaSource$MediaPeriodId = mediaSource$MediaPeriodId6;
        }
        PlaybackInfo playbackInfo7 = this.playbackInfo;
        Timeline timeline14 = playbackInfo7.timeline;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId12 = playbackInfo7.periodId;
        if (positionUpdateForPlaylistChange.setTargetLiveOffset) {
            j3 = jSeekToPeriodPosition;
        } else {
            j3 = -9223372036854775807L;
        }
        mediaSource$MediaPeriodId2 = mediaSource$MediaPeriodId;
        updatePlaybackSpeedSettingsForNewPeriod(r11, mediaSource$MediaPeriodId2, timeline14, mediaSource$MediaPeriodId12, j3, false);
        if (positionUpdateForPlaylistChange.periodPositionChanged || positionUpdateForPlaylistChange.requestedContentPositionUs != this.playbackInfo.requestedContentPositionUs) {
            long j112 = positionUpdateForPlaylistChange.requestedContentPositionUs;
            z11 = positionUpdateForPlaylistChange.reportDiscontinuity;
            if (z11) {
                j4 = jSeekToPeriodPosition;
            } else {
                j4 = this.playbackInfo.discontinuityStartPositionUs;
            }
            this.playbackInfo = handlePositionDiscontinuity(mediaSource$MediaPeriodId2, jSeekToPeriodPosition, j112, j4, z11, positionUpdateForPlaylistChange.discontinuityReason);
        }
        resetPendingPauseAtEndOfPeriod();
        resolvePendingMessagePositions(r11, this.playbackInfo.timeline);
        this.playbackInfo = this.playbackInfo.copyWithTimeline(r11);
        if (!r11.isEmpty()) {
            this.pendingInitialSeekPosition = null;
        }
        handleLoadingMediaPeriodChanged(false);
        this.handler.sendEmptyMessage(2);
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) throws Throwable {
        int i;
        MediaPeriodHolder mediaPeriodHolder;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId;
        MediaPeriodHolder mediaPeriodHolder2;
        int i2;
        int i3 = CIOKt.DEFAULT_HTTP_POOL_SIZE;
        try {
            switch (message.what) {
                case 1:
                    boolean z = message.arg1 != 0;
                    int i4 = message.arg2;
                    this.playbackInfoUpdate.incrementPendingOperationAcks(1);
                    updatePlayWhenReadyWithAudioFocus(this.audioFocusManager.updateAudioFocus(this.playbackInfo.playbackState, z), i4 >> 4, i4 & 15, z);
                    break;
                case 2:
                    doSomeWork();
                    break;
                case 3:
                    seekToInternal((SeekPosition) message.obj);
                    break;
                case 4:
                    setPlaybackParametersInternal((PlaybackParameters) message.obj);
                    break;
                case 5:
                    this.seekParameters = (SeekParameters) message.obj;
                    break;
                case 6:
                    stopInternal(false, true);
                    break;
                case 7:
                    releaseInternal((ConditionVariable) message.obj);
                    return true;
                case 8:
                    handlePeriodPrepared((MediaPeriod) message.obj);
                    break;
                case 9:
                    handleContinueLoadingRequested((MediaPeriod) message.obj);
                    break;
                case 10:
                    reselectTracksInternal();
                    break;
                case 11:
                    setRepeatModeInternal(message.arg1);
                    break;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    setShuffleModeEnabledInternal(message.arg1 != 0);
                    break;
                case 13:
                    setForegroundModeInternal(message.arg1 != 0, (ConditionVariable) message.obj);
                    break;
                case 14:
                    sendMessageInternal((PlayerMessage) message.obj);
                    break;
                case 15:
                    sendMessageToTargetThread((PlayerMessage) message.obj);
                    break;
                case 16:
                    PlaybackParameters playbackParameters = (PlaybackParameters) message.obj;
                    handlePlaybackParameters(playbackParameters, playbackParameters.speed, true, false);
                    break;
                case 17:
                    setMediaItemsInternal((MediaSourceListUpdateMessage) message.obj);
                    break;
                case 18:
                    addMediaItemsInternal((MediaSourceListUpdateMessage) message.obj, message.arg1);
                    break;
                case 19:
                    moveMediaItemsInternal((MoveMediaItemsMessage) message.obj);
                    break;
                case 20:
                    removeMediaItemsInternal(message.arg1, message.arg2, (ShuffleOrder$DefaultShuffleOrder) message.obj);
                    break;
                case 21:
                    setShuffleOrderInternal((ShuffleOrder$DefaultShuffleOrder) message.obj);
                    break;
                case 22:
                    mediaSourceListUpdateRequestedInternal();
                    break;
                case 23:
                    setPauseAtEndOfWindowInternal(message.arg1 != 0);
                    break;
                case 24:
                default:
                    return false;
                case 25:
                    reselectTracksInternal();
                    seekToCurrentPosition(true);
                    break;
                case 26:
                    reselectTracksInternal();
                    seekToCurrentPosition(true);
                    break;
                case 27:
                    updateMediaSourcesWithMediaItemsInternal(message.arg1, message.arg2, (List) message.obj);
                    break;
                case 28:
                    setPreloadConfigurationInternal((ExoPlayer$PreloadConfiguration) message.obj);
                    break;
                case 29:
                    prepareInternal();
                    break;
                case 30:
                    Pair pair = (Pair) message.obj;
                    setVideoOutputInternal(pair.first, (ConditionVariable) pair.second);
                    break;
                case 31:
                    setAudioAttributesInternal((AudioAttributes) message.obj, message.arg1 != 0);
                    break;
                case 32:
                    setVolumeInternal(((Float) message.obj).floatValue());
                    break;
                case 33:
                    handleAudioFocusPlayerCommandInternal(message.arg1);
                    break;
                case 34:
                    handleAudioFocusVolumeMultiplierChange();
                    break;
                case 35:
                    setVideoFrameMetadataListenerInternal((VideoFrameMetadataListener) message.obj);
                    break;
                case 36:
                    setScrubbingModeEnabledInternal(((Boolean) message.obj).booleanValue());
                    break;
                case 37:
                    this.seekIsPendingWhileScrubbing = false;
                    SeekPosition seekPosition = this.queuedSeekWhileScrubbing;
                    if (seekPosition != null) {
                        seekToInternal(seekPosition);
                        this.queuedSeekWhileScrubbing = null;
                    }
                    break;
                case 38:
                    setScrubbingModeParametersInternal((ScrubbingModeParameters) message.obj);
                    break;
                case 39:
                    setImageMetadataListenerInternal((ExoPlayerImplInternal$$ExternalSyntheticLambda4) message.obj);
                    break;
            }
        } catch (ParserException e) {
            boolean z2 = e.contentIsMalformed;
            boolean z3 = e.dataType;
            if (z3 == 1) {
                i2 = z2 ? 3001 : 3003;
            } else {
                if (z3 == 4) {
                    i2 = z2 ? 3002 : 3004;
                }
                handleIoException(e, i3);
            }
            i3 = i2;
            handleIoException(e, i3);
        } catch (DataSourceException e2) {
            handleIoException(e2, e2.reason);
        } catch (ExoPlaybackException e3) {
            e = e3;
            byte b = e.type;
            MediaPeriodQueue mediaPeriodQueue = this.queue;
            if (b == 1 && (mediaPeriodHolder2 = mediaPeriodQueue.reading) != null && e.mediaPeriodId == null) {
                e = e.copyWithMediaPeriodId(mediaPeriodHolder2.info.id);
            }
            byte b2 = e.type;
            SystemHandlerWrapper systemHandlerWrapper = this.handler;
            if (b2 == 1 && (mediaSource$MediaPeriodId = e.mediaPeriodId) != null && isRendererPrewarmingMediaPeriod(e.rendererIndex, mediaSource$MediaPeriodId)) {
                this.isPrewarmingDisabledUntilNextTransition = true;
                disableAndResetPrewarmingRenderers();
                MediaPeriodHolder mediaPeriodHolder3 = mediaPeriodQueue.prewarming;
                MediaPeriodHolder mediaPeriodHolder4 = mediaPeriodQueue.playing;
                if (mediaPeriodHolder4 != mediaPeriodHolder3) {
                    while (mediaPeriodHolder4 != null) {
                        MediaPeriodHolder mediaPeriodHolder5 = mediaPeriodHolder4.next;
                        if (mediaPeriodHolder5 == mediaPeriodHolder3) {
                            break;
                        }
                        mediaPeriodHolder4 = mediaPeriodHolder5;
                    }
                }
                mediaPeriodQueue.removeAfter(mediaPeriodHolder4);
                if (this.playbackInfo.playbackState != 4) {
                    maybeContinueLoading();
                    systemHandlerWrapper.sendEmptyMessage(2);
                }
            } else {
                ExoPlaybackException exoPlaybackException = this.pendingRecoverableRendererError;
                if (exoPlaybackException != null) {
                    exoPlaybackException.addSuppressed(e);
                    e = this.pendingRecoverableRendererError;
                }
                if (e.type == 1 && mediaPeriodQueue.playing != mediaPeriodQueue.reading) {
                    while (true) {
                        mediaPeriodHolder = mediaPeriodQueue.playing;
                        if (mediaPeriodHolder == mediaPeriodQueue.reading) {
                            break;
                        }
                        mediaPeriodQueue.advancePlayingPeriod();
                    }
                    UtilsKt.checkNotNull(mediaPeriodHolder);
                    maybeNotifyPlaybackInfoChanged();
                    MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.info;
                    MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = mediaPeriodInfo.id;
                    long j = mediaPeriodInfo.startPositionUs;
                    this.playbackInfo = handlePositionDiscontinuity(mediaSource$MediaPeriodId2, j, mediaPeriodInfo.requestedContentPositionUs, j, true, 0);
                }
                if (e.isRecoverable && (this.pendingRecoverableRendererError == null || (i = e.errorCode) == 5004 || i == 5003)) {
                    Log.w("ExoPlayerImplInternal", "Recoverable renderer error", e);
                    if (this.pendingRecoverableRendererError == null) {
                        this.pendingRecoverableRendererError = e;
                    }
                    SystemHandlerWrapper.SystemMessage systemMessageObtainMessage = systemHandlerWrapper.obtainMessage(25, e);
                    Handler handler = systemHandlerWrapper.handler;
                    Message message2 = systemMessageObtainMessage.message;
                    message2.getClass();
                    handler.sendMessageAtFrontOfQueue(message2);
                    systemMessageObtainMessage.recycle();
                } else {
                    Log.e("ExoPlayerImplInternal", "Playback error", e);
                    stopInternal(true, false);
                    this.playbackInfo = this.playbackInfo.copyWithPlaybackError(e);
                }
            }
        } catch (DrmSession.DrmSessionException e4) {
            handleIoException(e4, e4.errorCode);
        } catch (IOException e5) {
            handleIoException(e5, 2000);
        } catch (RuntimeException e6) {
            if ((e6 instanceof IllegalStateException) || (e6 instanceof IllegalArgumentException)) {
                i3 = 1004;
            }
            ExoPlaybackException exoPlaybackException2 = new ExoPlaybackException(2, e6, i3);
            Log.e("ExoPlayerImplInternal", "Playback error", exoPlaybackException2);
            stopInternal(true, false);
            this.playbackInfo = this.playbackInfo.copyWithPlaybackError(exoPlaybackException2);
        }
        maybeNotifyPlaybackInfoChanged();
        return true;
    }

    public final void handlePeriodPrepared(MediaPeriod mediaPeriod) {
        MediaPeriodHolder mediaPeriodHolder;
        ExoPlayerImplInternal exoPlayerImplInternal;
        MediaPeriodQueue mediaPeriodQueue = this.queue;
        MediaPeriodHolder mediaPeriodHolder2 = mediaPeriodQueue.loading;
        DefaultMediaClock defaultMediaClock = this.mediaClock;
        if (mediaPeriodHolder2 != null && mediaPeriodHolder2.mediaPeriod == mediaPeriod) {
            mediaPeriodHolder2.getClass();
            if (!mediaPeriodHolder2.prepared) {
                float f = defaultMediaClock.getPlaybackParameters().speed;
                PlaybackInfo playbackInfo = this.playbackInfo;
                mediaPeriodHolder2.handlePrepared(f, playbackInfo.timeline, playbackInfo.playWhenReady);
            }
            updateLoadControlTrackSelection(mediaPeriodHolder2.info.id, mediaPeriodHolder2.trackSelectorResult);
            if (mediaPeriodHolder2 == mediaPeriodQueue.playing) {
                resetRendererPosition(mediaPeriodHolder2.info.startPositionUs, true);
                enableRenderers(new boolean[this.renderers.length], mediaPeriodQueue.reading.getStartPositionRendererTime());
                mediaPeriodHolder2.allRenderersInCorrectState = true;
                PlaybackInfo playbackInfo2 = this.playbackInfo;
                MediaSource$MediaPeriodId mediaSource$MediaPeriodId = playbackInfo2.periodId;
                long j = mediaPeriodHolder2.info.startPositionUs;
                exoPlayerImplInternal = this;
                exoPlayerImplInternal.playbackInfo = handlePositionDiscontinuity(mediaSource$MediaPeriodId, j, playbackInfo2.requestedContentPositionUs, j, false, 5);
            } else {
                exoPlayerImplInternal = this;
            }
            exoPlayerImplInternal.maybeContinueLoading();
            return;
        }
        int i = 0;
        while (true) {
            if (i >= mediaPeriodQueue.preloadPriorityList.size()) {
                mediaPeriodHolder = null;
                break;
            }
            mediaPeriodHolder = (MediaPeriodHolder) mediaPeriodQueue.preloadPriorityList.get(i);
            if (mediaPeriodHolder.mediaPeriod == mediaPeriod) {
                break;
            } else {
                i++;
            }
        }
        if (mediaPeriodHolder != null) {
            UtilsKt.checkState(!mediaPeriodHolder.prepared);
            float f2 = defaultMediaClock.getPlaybackParameters().speed;
            PlaybackInfo playbackInfo3 = this.playbackInfo;
            mediaPeriodHolder.handlePrepared(f2, playbackInfo3.timeline, playbackInfo3.playWhenReady);
            MediaPeriodHolder mediaPeriodHolder3 = mediaPeriodQueue.preloading;
            if (mediaPeriodHolder3 == null || mediaPeriodHolder3.mediaPeriod != mediaPeriod) {
                return;
            }
            maybeContinuePreloading();
        }
    }

    public final void handlePlaybackParameters(PlaybackParameters playbackParameters, float f, boolean z, boolean z2) {
        int i;
        if (z) {
            if (z2) {
                this.playbackInfoUpdate.incrementPendingOperationAcks(1);
            }
            this.playbackInfo = this.playbackInfo.copyWithPlaybackParameters(playbackParameters);
        }
        float f2 = playbackParameters.speed;
        MediaPeriodHolder mediaPeriodHolder = this.queue.playing;
        while (true) {
            i = 0;
            if (mediaPeriodHolder == null) {
                break;
            }
            ExoTrackSelection[] exoTrackSelectionArr = mediaPeriodHolder.trackSelectorResult.selections;
            int length = exoTrackSelectionArr.length;
            while (i < length) {
                ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i];
                if (exoTrackSelection != null) {
                    exoTrackSelection.onPlaybackSpeed(f2);
                }
                i++;
            }
            mediaPeriodHolder = mediaPeriodHolder.next;
        }
        RendererHolder[] rendererHolderArr = this.renderers;
        int length2 = rendererHolderArr.length;
        while (i < length2) {
            RendererHolder rendererHolder = rendererHolderArr[i];
            float f3 = playbackParameters.speed;
            rendererHolder.primaryRenderer.setPlaybackSpeed(f, f3);
            BaseRenderer baseRenderer = rendererHolder.secondaryRenderer;
            if (baseRenderer != null) {
                baseRenderer.setPlaybackSpeed(f, f3);
            }
            i++;
        }
    }

    public final PlaybackInfo handlePositionDiscontinuity(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, long j, long j2, long j3, boolean z, int i) {
        RegularImmutableList regularImmutableListBuild;
        boolean z2;
        this.deliverPendingMessageAtStartPositionRequired = (!this.deliverPendingMessageAtStartPositionRequired && j == this.playbackInfo.positionUs && mediaSource$MediaPeriodId.equals(this.playbackInfo.periodId)) ? false : true;
        resetPendingPauseAtEndOfPeriod();
        PlaybackInfo playbackInfo = this.playbackInfo;
        TrackGroupArray trackGroupArray = playbackInfo.trackGroups;
        TrackSelectorResult trackSelectorResult = playbackInfo.trackSelectorResult;
        List list = playbackInfo.staticMetadata;
        if (this.mediaSourceList.isPrepared) {
            MediaPeriodHolder mediaPeriodHolder = this.queue.playing;
            trackGroupArray = mediaPeriodHolder == null ? TrackGroupArray.EMPTY : mediaPeriodHolder.trackGroups;
            trackSelectorResult = mediaPeriodHolder == null ? this.emptyTrackSelectorResult : mediaPeriodHolder.trackSelectorResult;
            ExoTrackSelection[] exoTrackSelectionArr = trackSelectorResult.selections;
            ImmutableList.Builder builder = new ImmutableList.Builder(4);
            boolean z3 = false;
            for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
                if (exoTrackSelection != null) {
                    Metadata metadata = exoTrackSelection.getFormat(0).metadata;
                    if (metadata == null) {
                        builder.add((Object) new Metadata(new Metadata.Entry[0]));
                    } else {
                        builder.add((Object) metadata);
                        z3 = true;
                    }
                }
            }
            if (z3) {
                regularImmutableListBuild = builder.build();
            } else {
                ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
                regularImmutableListBuild = RegularImmutableList.EMPTY;
            }
            list = regularImmutableListBuild;
            if (mediaPeriodHolder != null) {
                MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.info;
                if (mediaPeriodInfo.requestedContentPositionUs != j2) {
                    mediaPeriodHolder.info = mediaPeriodInfo.copyWithRequestedContentPositionUs(j2);
                }
            }
            RendererHolder[] rendererHolderArr = this.renderers;
            MediaPeriodQueue mediaPeriodQueue = this.queue;
            MediaPeriodHolder mediaPeriodHolder2 = mediaPeriodQueue.playing;
            if (mediaPeriodHolder2 == mediaPeriodQueue.reading && mediaPeriodHolder2 != null) {
                TrackSelectorResult trackSelectorResult2 = mediaPeriodHolder2.trackSelectorResult;
                int i2 = 0;
                boolean z4 = false;
                while (true) {
                    if (i2 >= rendererHolderArr.length) {
                        z2 = true;
                        break;
                    }
                    if (trackSelectorResult2.isRendererEnabled(i2)) {
                        if (rendererHolderArr[i2].primaryRenderer.trackType != 1) {
                            z2 = false;
                            break;
                        }
                        if (trackSelectorResult2.rendererConfigurations[i2].offloadModePreferred != 0) {
                            z4 = true;
                        }
                    }
                    i2++;
                }
                boolean z5 = z4 && z2;
                if (z5 != this.offloadSchedulingEnabled) {
                    this.offloadSchedulingEnabled = z5;
                    if (!z5 && this.playbackInfo.sleepingForOffload) {
                        this.handler.sendEmptyMessage(2);
                    }
                }
            }
        } else if (!mediaSource$MediaPeriodId.equals(playbackInfo.periodId)) {
            trackGroupArray = TrackGroupArray.EMPTY;
            trackSelectorResult = this.emptyTrackSelectorResult;
            ImmutableList.Itr itr2 = ImmutableList.EMPTY_ITR;
            list = RegularImmutableList.EMPTY;
        }
        TrackSelectorResult trackSelectorResult3 = trackSelectorResult;
        List list2 = list;
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        if (z) {
            PlaybackInfoUpdate playbackInfoUpdate = this.playbackInfoUpdate;
            if (!playbackInfoUpdate.positionDiscontinuity || playbackInfoUpdate.discontinuityReason == 5) {
                playbackInfoUpdate.hasPendingChange = true;
                playbackInfoUpdate.positionDiscontinuity = true;
                playbackInfoUpdate.discontinuityReason = i;
            } else {
                UtilsKt.checkArgument(i == 5);
            }
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        return playbackInfo2.copyWithNewPosition(mediaSource$MediaPeriodId, j, j2, j3, getTotalBufferedDurationUs(playbackInfo2.bufferedPositionUs), trackGroupArray2, trackSelectorResult3, list2);
    }

    public final boolean isRendererPrewarmingMediaPeriod(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        MediaPeriodQueue mediaPeriodQueue = this.queue;
        MediaPeriodHolder mediaPeriodHolder = mediaPeriodQueue.prewarming;
        if (mediaPeriodHolder != null && mediaPeriodHolder.info.id.equals(mediaSource$MediaPeriodId)) {
            RendererHolder rendererHolder = this.renderers[i];
            MediaPeriodHolder mediaPeriodHolder2 = mediaPeriodQueue.prewarming;
            int i2 = rendererHolder.prewarmingState;
            boolean z = (i2 == 2 || i2 == 4) && rendererHolder.getRendererReadingFromPeriod(mediaPeriodHolder2) == rendererHolder.primaryRenderer;
            boolean z2 = rendererHolder.prewarmingState == 3 && rendererHolder.getRendererReadingFromPeriod(mediaPeriodHolder2) == rendererHolder.secondaryRenderer;
            if (z || z2) {
                return true;
            }
        }
        return false;
    }

    public final boolean isTimelineReady() {
        MediaPeriodHolder mediaPeriodHolder = this.queue.playing;
        long j = mediaPeriodHolder.info.durationUs;
        if (mediaPeriodHolder.prepared) {
            return j == -9223372036854775807L || this.playbackInfo.positionUs < j || !shouldPlayWhenReady();
        }
        return false;
    }

    public final void maybeContinueLoading() {
        boolean zShouldContinueLoading;
        if (isLoadingPossible(this.queue.loading)) {
            MediaPeriodHolder mediaPeriodHolder = this.queue.loading;
            long totalBufferedDurationUs = getTotalBufferedDurationUs(!mediaPeriodHolder.prepared ? 0L : mediaPeriodHolder.mediaPeriod.getNextLoadPositionUs());
            MediaPeriodHolder mediaPeriodHolder2 = this.queue.playing;
            long j = shouldUseLivePlaybackSpeedControl(this.playbackInfo.timeline, mediaPeriodHolder.info.id) ? this.livePlaybackSpeedControl.currentTargetLiveOffsetUs : -9223372036854775807L;
            PlayerId playerId = this.playerId;
            Timeline timeline = this.playbackInfo.timeline;
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId = mediaPeriodHolder.info.id;
            float f = this.mediaClock.getPlaybackParameters().speed;
            boolean z = this.playbackInfo.playWhenReady;
            LoadControl$Parameters loadControl$Parameters = new LoadControl$Parameters(playerId, timeline, mediaSource$MediaPeriodId, totalBufferedDurationUs, f, this.isRebuffering, j);
            zShouldContinueLoading = this.loadControl.shouldContinueLoading(loadControl$Parameters);
            MediaPeriodHolder mediaPeriodHolder3 = this.queue.playing;
            if (!zShouldContinueLoading && mediaPeriodHolder3.prepared && totalBufferedDurationUs < 500000 && this.backBufferDurationUs > 0) {
                mediaPeriodHolder3.mediaPeriod.discardBuffer(this.playbackInfo.positionUs);
                zShouldContinueLoading = this.loadControl.shouldContinueLoading(loadControl$Parameters);
            }
        } else {
            zShouldContinueLoading = false;
        }
        this.shouldContinueLoading = zShouldContinueLoading;
        if (zShouldContinueLoading) {
            MediaPeriodHolder mediaPeriodHolder4 = this.queue.loading;
            mediaPeriodHolder4.getClass();
            LoadingInfo.Builder builder = new LoadingInfo.Builder();
            builder.playbackPositionUs = this.rendererPositionUs - mediaPeriodHolder4.rendererPositionOffsetUs;
            float f2 = this.mediaClock.getPlaybackParameters().speed;
            UtilsKt.checkArgument(f2 > CropImageView.DEFAULT_ASPECT_RATIO || f2 == -3.4028235E38f);
            builder.playbackSpeed = f2;
            long j2 = this.lastRebufferRealtimeMs;
            UtilsKt.checkArgument(j2 >= 0 || j2 == -9223372036854775807L);
            builder.lastRebufferRealtimeMs = j2;
            LoadingInfo loadingInfo = new LoadingInfo(builder);
            UtilsKt.checkState(mediaPeriodHolder4.next == null);
            mediaPeriodHolder4.mediaPeriod.continueLoading(loadingInfo);
        }
        updateIsLoading();
    }

    public final void maybeContinuePreloading() {
        MediaPeriodQueue mediaPeriodQueue = this.queue;
        mediaPeriodQueue.maybeUpdatePreloadMediaPeriodHolder();
        MediaPeriodHolder mediaPeriodHolder = mediaPeriodQueue.preloading;
        if (mediaPeriodHolder != null) {
            MediaPeriod mediaPeriod = mediaPeriodHolder.mediaPeriod;
            if ((!mediaPeriodHolder.prepareCalled || mediaPeriodHolder.prepared) && !mediaPeriod.isLoading()) {
                Timeline timeline = this.playbackInfo.timeline;
                if (mediaPeriodHolder.prepared) {
                    mediaPeriod.getBufferedPositionUs();
                }
                Iterator it = this.loadControl.loadingStates.values().iterator();
                while (it.hasNext()) {
                    if (((DefaultLoadControl.PlayerLoadingState) it.next()).isLoading) {
                        return;
                    }
                }
                if (!mediaPeriodHolder.prepareCalled) {
                    long j = mediaPeriodHolder.info.startPositionUs;
                    mediaPeriodHolder.prepareCalled = true;
                    mediaPeriod.prepare(this, j);
                    return;
                }
                LoadingInfo.Builder builder = new LoadingInfo.Builder();
                builder.playbackPositionUs = this.rendererPositionUs - mediaPeriodHolder.rendererPositionOffsetUs;
                float f = this.mediaClock.getPlaybackParameters().speed;
                UtilsKt.checkArgument(f > CropImageView.DEFAULT_ASPECT_RATIO || f == -3.4028235E38f);
                builder.playbackSpeed = f;
                long j2 = this.lastRebufferRealtimeMs;
                UtilsKt.checkArgument(j2 >= 0 || j2 == -9223372036854775807L);
                builder.lastRebufferRealtimeMs = j2;
                LoadingInfo loadingInfo = new LoadingInfo(builder);
                UtilsKt.checkState(mediaPeriodHolder.next == null);
                mediaPeriod.continueLoading(loadingInfo);
            }
        }
    }

    public final void maybeNotifyPlaybackInfoChanged() {
        PlaybackInfoUpdate playbackInfoUpdate = this.playbackInfoUpdate;
        PlaybackInfo playbackInfo = this.playbackInfo;
        boolean z = playbackInfoUpdate.hasPendingChange | (playbackInfoUpdate.playbackInfo != playbackInfo);
        playbackInfoUpdate.hasPendingChange = z;
        playbackInfoUpdate.playbackInfo = playbackInfo;
        if (z) {
            ExoPlayerImpl exoPlayerImpl = this.playbackInfoUpdateListener.f$0;
            exoPlayerImpl.playbackInfoUpdateHandler.post(new ComponentActivity$$ExternalSyntheticLambda10(exoPlayerImpl, playbackInfoUpdate, (byte) 13));
            this.playbackInfoUpdate = new PlaybackInfoUpdate(this.playbackInfo);
        }
    }

    public final void maybeThrowRendererStreamError(int i) {
        RendererHolder rendererHolder = this.renderers[i];
        try {
            MediaPeriodHolder mediaPeriodHolder = this.queue.playing;
            mediaPeriodHolder.getClass();
            BaseRenderer rendererReadingFromPeriod = rendererHolder.getRendererReadingFromPeriod(mediaPeriodHolder);
            rendererReadingFromPeriod.getClass();
            SampleStream sampleStream = rendererReadingFromPeriod.stream;
            sampleStream.getClass();
            sampleStream.maybeThrowError();
        } catch (IOException | RuntimeException e) {
            byte b = rendererHolder.primaryRenderer.trackType;
            if (b != 3 && b != 5) {
                throw e;
            }
            TrackSelectorResult trackSelectorResult = this.queue.playing.trackSelectorResult;
            Log.e("ExoPlayerImplInternal", "Disabling track due to error: ".concat(Format.toLogString(trackSelectorResult.selections[i].getSelectedFormat())), e);
            TrackSelectorResult trackSelectorResult2 = new TrackSelectorResult((RendererConfiguration[]) trackSelectorResult.rendererConfigurations.clone(), (ExoTrackSelection[]) trackSelectorResult.selections.clone(), trackSelectorResult.tracks, trackSelectorResult.info);
            trackSelectorResult2.rendererConfigurations[i] = null;
            trackSelectorResult2.selections[i] = null;
            disableRenderer(i);
            MediaPeriodHolder mediaPeriodHolder2 = this.queue.playing;
            mediaPeriodHolder2.applyTrackSelection(trackSelectorResult2, this.playbackInfo.positionUs, false, new boolean[mediaPeriodHolder2.rendererCapabilities.length]);
        }
    }

    public final void maybeTriggerOnRendererReadyChanged(final int i, final boolean z) {
        boolean[] zArr = this.rendererReportedReady;
        if (zArr[i] != z) {
            zArr[i] = z;
            this.applicationLooperHandler.post(new Runnable() { // from class: androidx.media3.exoplayer.ExoPlayerImplInternal$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ExoPlayerImplInternal exoPlayerImplInternal = this.f$0;
                    DefaultAnalyticsCollector defaultAnalyticsCollector = exoPlayerImplInternal.analyticsCollector;
                    RendererHolder[] rendererHolderArr = exoPlayerImplInternal.renderers;
                    int i2 = i;
                    byte b = rendererHolderArr[i2].primaryRenderer.trackType;
                    AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = defaultAnalyticsCollector.generateReadingMediaPeriodEventTime();
                    defaultAnalyticsCollector.sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, 1033, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0(eventTimeGenerateReadingMediaPeriodEventTime, i2, b, z));
                }
            });
        }
    }

    public final void mediaSourceListUpdateRequestedInternal() throws Throwable {
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.createTimeline(), true);
    }

    public final void moveMediaItemsInternal(MoveMediaItemsMessage moveMediaItemsMessage) throws Throwable {
        Timeline timelineCreateTimeline;
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        int i = moveMediaItemsMessage.fromIndex;
        int i2 = moveMediaItemsMessage.toIndex;
        int i3 = moveMediaItemsMessage.newFromIndex;
        ShuffleOrder$DefaultShuffleOrder shuffleOrder$DefaultShuffleOrder = moveMediaItemsMessage.shuffleOrder;
        MediaSourceList mediaSourceList = this.mediaSourceList;
        ArrayList arrayList = mediaSourceList.mediaSourceHolders;
        UtilsKt.checkArgument(i >= 0 && i <= i2 && i2 <= arrayList.size() && i3 >= 0);
        mediaSourceList.shuffleOrder = shuffleOrder$DefaultShuffleOrder;
        if (i == i2 || i == i3) {
            timelineCreateTimeline = mediaSourceList.createTimeline();
        } else {
            int iMin = Math.min(i, i3);
            int iMax = Math.max(((i2 - i) + i3) - 1, i2 - 1);
            int windowCount = ((MediaSourceList.MediaSourceHolder) arrayList.get(iMin)).firstWindowIndexInChild;
            Util.moveItems(arrayList, i, i2, i3);
            while (iMin <= iMax) {
                MediaSourceList.MediaSourceHolder mediaSourceHolder = (MediaSourceList.MediaSourceHolder) arrayList.get(iMin);
                mediaSourceHolder.firstWindowIndexInChild = windowCount;
                windowCount += mediaSourceHolder.mediaSource.timeline.timeline.getWindowCount();
                iMin++;
            }
            timelineCreateTimeline = mediaSourceList.createTimeline();
        }
        handleMediaSourceListInfoRefreshed(timelineCreateTimeline, false);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
    public final void onContinueLoadingRequested(SequenceableLoader sequenceableLoader) {
        this.handler.obtainMessage(9, (MediaPeriod) sequenceableLoader).sendToTarget();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
    public final void onPrepared(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(8, mediaPeriod).sendToTarget();
    }

    @Override // androidx.media3.exoplayer.video.VideoFrameMetadataListener
    public final void onVideoFrameAboutToBeRendered(long j, long j2, Format format, MediaFormat mediaFormat) {
        if (this.seekIsPendingWhileScrubbing) {
            this.handler.obtainMessage(37).sendToTarget();
        }
    }

    public final void prepareInternal() {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        resetInternal(false, false, false, true);
        DefaultLoadControl defaultLoadControl = this.loadControl;
        ConcurrentHashMap concurrentHashMap = defaultLoadControl.loadingStates;
        long id = Thread.currentThread().getId();
        long j = defaultLoadControl.threadId;
        UtilsKt.checkState("Players that share the same LoadControl must share the same playback thread. See ExoPlayer.Builder.setPlaybackLooper(Looper).", j == -1 || j == id);
        defaultLoadControl.threadId = id;
        PlayerId playerId = this.playerId;
        DefaultLoadControl.PlayerLoadingState playerLoadingState = (DefaultLoadControl.PlayerLoadingState) concurrentHashMap.get(playerId);
        if (playerLoadingState == null) {
            DefaultLoadControl.PlayerLoadingState playerLoadingState2 = new DefaultLoadControl.PlayerLoadingState();
            playerLoadingState2.referenceCount = 1;
            concurrentHashMap.put(playerId, playerLoadingState2);
        } else {
            playerLoadingState.referenceCount++;
        }
        DefaultLoadControl.PlayerLoadingState playerLoadingState3 = (DefaultLoadControl.PlayerLoadingState) concurrentHashMap.get(playerId);
        playerLoadingState3.getClass();
        Integer num = (Integer) defaultLoadControl.playerTargetBufferBytesOverwrites.get(playerId.name);
        int iIntValue = (num == null || num.intValue() == -1) ? -1 : num.intValue();
        if (iIntValue == -1) {
            iIntValue = 13107200;
        }
        playerLoadingState3.targetBufferBytes = iIntValue;
        playerLoadingState3.isLoading = false;
        setState(this.playbackInfo.timeline.isEmpty() ? 4 : 2);
        PlaybackInfo playbackInfo = this.playbackInfo;
        boolean z = playbackInfo.playWhenReady;
        updatePlayWhenReadyWithAudioFocus(this.audioFocusManager.updateAudioFocus(playbackInfo.playbackState, z), playbackInfo.playbackSuppressionReason, playbackInfo.playWhenReadyChangeReason, z);
        DefaultBandwidthMeter defaultBandwidthMeter = this.bandwidthMeter;
        defaultBandwidthMeter.getClass();
        MediaSourceList mediaSourceList = this.mediaSourceList;
        ArrayList arrayList = mediaSourceList.mediaSourceHolders;
        UtilsKt.checkState(!mediaSourceList.isPrepared);
        mediaSourceList.mediaTransferListener = defaultBandwidthMeter;
        for (int i = 0; i < arrayList.size(); i++) {
            MediaSourceList.MediaSourceHolder mediaSourceHolder = (MediaSourceList.MediaSourceHolder) arrayList.get(i);
            mediaSourceList.prepareChildSource(mediaSourceHolder);
            mediaSourceList.enabledMediaSourceHolders.add(mediaSourceHolder);
        }
        mediaSourceList.isPrepared = true;
        this.handler.sendEmptyMessage(2);
    }

    public final void releaseInternal(ConditionVariable conditionVariable) {
        JsonPath jsonPath = this.playbackLooperProvider;
        SystemHandlerWrapper systemHandlerWrapper = this.handler;
        try {
            resetInternal(true, false, true, false);
            releaseRenderers();
            DefaultLoadControl defaultLoadControl = this.loadControl;
            PlayerId playerId = this.playerId;
            ConcurrentHashMap concurrentHashMap = defaultLoadControl.loadingStates;
            DefaultLoadControl.PlayerLoadingState playerLoadingState = (DefaultLoadControl.PlayerLoadingState) concurrentHashMap.get(playerId);
            if (playerLoadingState != null) {
                int i = playerLoadingState.referenceCount - 1;
                playerLoadingState.referenceCount = i;
                if (i == 0) {
                    concurrentHashMap.remove(playerId);
                    defaultLoadControl.updateAllocator();
                }
            }
            if (defaultLoadControl.loadingStates.isEmpty()) {
                defaultLoadControl.threadId = -1L;
            }
            AudioFocusManager audioFocusManager = this.audioFocusManager;
            audioFocusManager.playerControl = null;
            audioFocusManager.abandonAudioFocusIfHeld();
            audioFocusManager.setAudioFocusState(0);
            this.trackSelector.release();
            setState(1);
        } finally {
            systemHandlerWrapper.handler.removeCallbacksAndMessages(null);
            jsonPath.releaseLooper();
            conditionVariable.open();
        }
    }

    public final void releaseRenderers() {
        for (int i = 0; i < this.renderers.length; i++) {
            BaseRenderer baseRenderer = this.rendererCapabilities[i];
            synchronized (baseRenderer.lock) {
                baseRenderer.rendererCapabilitiesListener = null;
            }
            RendererHolder rendererHolder = this.renderers[i];
            BaseRenderer baseRenderer2 = rendererHolder.primaryRenderer;
            UtilsKt.checkState(baseRenderer2.state == 0);
            baseRenderer2.onRelease();
            rendererHolder.primaryRequiresReset = false;
            BaseRenderer baseRenderer3 = rendererHolder.secondaryRenderer;
            if (baseRenderer3 != null) {
                UtilsKt.checkState(baseRenderer3.state == 0);
                baseRenderer3.onRelease();
                rendererHolder.secondaryRequiresReset = false;
            }
        }
    }

    public final void removeMediaItemsInternal(int i, int i2, ShuffleOrder$DefaultShuffleOrder shuffleOrder$DefaultShuffleOrder) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        MediaSourceList mediaSourceList = this.mediaSourceList;
        mediaSourceList.getClass();
        UtilsKt.checkArgument(i >= 0 && i <= i2 && i2 <= mediaSourceList.mediaSourceHolders.size());
        mediaSourceList.shuffleOrder = shuffleOrder$DefaultShuffleOrder;
        mediaSourceList.removeMediaSourcesInternal(i, i2);
        handleMediaSourceListInfoRefreshed(mediaSourceList.createTimeline(), false);
    }

    /* JADX WARN: Code duplicated, block: B:71:0x015a  */
    /* JADX WARN: Code duplicated, block: B:78:0x0178 A[ORIG_RETURN, RETURN] */
    public final void reselectTracksInternal() {
        int i;
        int i2;
        float f = this.mediaClock.getPlaybackParameters().speed;
        MediaPeriodQueue mediaPeriodQueue = this.queue;
        MediaPeriodHolder mediaPeriodHolder = mediaPeriodQueue.playing;
        MediaPeriodHolder mediaPeriodHolder2 = mediaPeriodQueue.reading;
        TrackSelectorResult trackSelectorResult = null;
        MediaPeriodHolder mediaPeriodHolder3 = mediaPeriodHolder;
        boolean z = true;
        while (mediaPeriodHolder3 != null && mediaPeriodHolder3.prepared) {
            PlaybackInfo playbackInfo = this.playbackInfo;
            TrackSelectorResult trackSelectorResultSelectTracks = mediaPeriodHolder3.selectTracks(f, playbackInfo.timeline, playbackInfo.playWhenReady);
            TrackSelectorResult trackSelectorResult2 = mediaPeriodHolder3 == this.queue.playing ? trackSelectorResultSelectTracks : trackSelectorResult;
            TrackSelectorResult trackSelectorResult3 = mediaPeriodHolder3.trackSelectorResult;
            ExoTrackSelection[] exoTrackSelectionArr = trackSelectorResultSelectTracks.selections;
            boolean z2 = false;
            if (trackSelectorResult3.selections.length == exoTrackSelectionArr.length) {
                int i3 = 0;
                while (true) {
                    if (i3 >= exoTrackSelectionArr.length) {
                        MediaPeriodHolder mediaPeriodHolder4 = mediaPeriodHolder3;
                        if (mediaPeriodHolder4 == mediaPeriodHolder2) {
                            z = false;
                        }
                        mediaPeriodHolder3 = mediaPeriodHolder4.next;
                        trackSelectorResult = trackSelectorResult2;
                    } else if (trackSelectorResultSelectTracks.isEquivalent(trackSelectorResult3, i3)) {
                        i3++;
                        mediaPeriodHolder3 = mediaPeriodHolder3;
                    }
                }
            }
            MediaPeriodQueue mediaPeriodQueue2 = this.queue;
            if (!z) {
                i = 4;
                mediaPeriodQueue2.removeAfter(mediaPeriodHolder3);
                if (mediaPeriodHolder3.prepared) {
                    long jMax = Math.max(mediaPeriodHolder3.info.startPositionUs, this.rendererPositionUs - mediaPeriodHolder3.rendererPositionOffsetUs);
                    if (this.hasSecondaryRenderers && areRenderersPrewarming() && this.queue.prewarming == mediaPeriodHolder3) {
                        disableAndResetPrewarmingRenderers();
                    }
                    i2 = 4;
                    mediaPeriodHolder3.applyTrackSelection(trackSelectorResultSelectTracks, jMax, false, new boolean[mediaPeriodHolder3.rendererCapabilities.length]);
                }
                handleLoadingMediaPeriodChanged(true);
                if (this.playbackInfo.playbackState != i2) {
                    maybeContinueLoading();
                    updatePlaybackPositions();
                    this.handler.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            MediaPeriodHolder mediaPeriodHolder5 = mediaPeriodQueue2.playing;
            boolean z3 = (mediaPeriodQueue2.removeAfter(mediaPeriodHolder5) & 1) != 0;
            boolean[] zArr = new boolean[this.renderers.length];
            trackSelectorResult2.getClass();
            long jApplyTrackSelection = mediaPeriodHolder5.applyTrackSelection(trackSelectorResult2, this.playbackInfo.positionUs, z3, zArr);
            PlaybackInfo playbackInfo2 = this.playbackInfo;
            if (playbackInfo2.playbackState != 4 && jApplyTrackSelection != playbackInfo2.positionUs) {
                z2 = true;
            }
            PlaybackInfo playbackInfo3 = this.playbackInfo;
            i = 4;
            this.playbackInfo = handlePositionDiscontinuity(playbackInfo3.periodId, jApplyTrackSelection, playbackInfo3.requestedContentPositionUs, playbackInfo3.discontinuityStartPositionUs, z2, 5);
            if (z2) {
                resetRendererPosition(jApplyTrackSelection, true);
            }
            disableAndResetPrewarmingRenderers();
            boolean[] zArr2 = new boolean[this.renderers.length];
            int i4 = 0;
            while (true) {
                RendererHolder[] rendererHolderArr = this.renderers;
                if (i4 >= rendererHolderArr.length) {
                    break;
                }
                int enabledRendererCount = rendererHolderArr[i4].getEnabledRendererCount();
                zArr2[i4] = this.renderers[i4].isRendererEnabled();
                RendererHolder rendererHolder = this.renderers[i4];
                SampleStream sampleStream = mediaPeriodHolder5.sampleStreams[i4];
                DefaultMediaClock defaultMediaClock = this.mediaClock;
                long j = this.rendererPositionUs;
                boolean z4 = zArr[i4];
                BaseRenderer baseRenderer = rendererHolder.primaryRenderer;
                if (RendererHolder.isRendererEnabled(baseRenderer)) {
                    if (sampleStream != baseRenderer.stream) {
                        rendererHolder.disableRenderer(baseRenderer, defaultMediaClock);
                    } else if (z4) {
                        baseRenderer.resetPosition(j, false, true);
                    }
                }
                BaseRenderer baseRenderer2 = rendererHolder.secondaryRenderer;
                if (baseRenderer2 != null && RendererHolder.isRendererEnabled(baseRenderer2)) {
                    if (sampleStream != baseRenderer2.stream) {
                        rendererHolder.disableRenderer(baseRenderer2, defaultMediaClock);
                    } else if (z4) {
                        baseRenderer2.resetPosition(j, false, true);
                    }
                }
                if (enabledRendererCount - this.renderers[i4].getEnabledRendererCount() > 0) {
                    maybeTriggerOnRendererReadyChanged(i4, false);
                }
                this.enabledRendererCount -= enabledRendererCount - this.renderers[i4].getEnabledRendererCount();
                i4++;
            }
            enableRenderers(zArr2, this.rendererPositionUs);
            mediaPeriodHolder5.allRenderersInCorrectState = true;
            i2 = i;
            handleLoadingMediaPeriodChanged(true);
            if (this.playbackInfo.playbackState != i2) {
                maybeContinueLoading();
                updatePlaybackPositions();
                this.handler.sendEmptyMessage(2);
                return;
            }
            return;
        }
    }

    /* JADX WARN: Code duplicated, block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x009f  */
    /* JADX WARN: Code duplicated, block: B:61:0x0137  */
    /* JADX WARN: Code duplicated, block: B:62:0x0139  */
    /* JADX WARN: Code duplicated, block: B:64:0x013e  */
    /* JADX WARN: Code duplicated, block: B:66:0x0143  */
    /* JADX WARN: Code duplicated, block: B:68:0x0148  */
    /* JADX WARN: Code duplicated, block: B:70:0x014d  */
    /* JADX WARN: Code duplicated, block: B:72:0x0152  */
    /* JADX WARN: Code duplicated, block: B:74:0x0159  */
    /* JADX WARN: Code duplicated, block: B:77:0x0180  */
    /* JADX WARN: Code duplicated, block: B:79:0x018a  */
    /* JADX WARN: Code duplicated, block: B:82:0x0198 A[LOOP:3: B:80:0x0190->B:82:0x0198, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:87:0x01bf  */
    public final void resetInternal(boolean z, boolean z2, boolean z3, boolean z4) {
        long j;
        long j2;
        long j3;
        boolean z5;
        Timeline playlistTimeline;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId;
        PlaybackInfo playbackInfo;
        ExoPlaybackException exoPlaybackException;
        TrackGroupArray trackGroupArray;
        TrackSelectorResult trackSelectorResult;
        List list;
        MediaPeriodQueue mediaPeriodQueue;
        int i;
        this.handler.removeMessages(2);
        this.seekIsPendingWhileScrubbing = false;
        if (this.queuedSeekWhileScrubbing != null) {
            this.playbackInfoUpdate.incrementPendingOperationAcks(1);
            this.queuedSeekWhileScrubbing = null;
        }
        this.pendingRecoverableRendererError = null;
        updateRebufferingState(false, true);
        DefaultMediaClock defaultMediaClock = this.mediaClock;
        defaultMediaClock.standaloneClockIsStarted = false;
        StandaloneMediaClock standaloneMediaClock = (StandaloneMediaClock) defaultMediaClock.standaloneClock;
        if (standaloneMediaClock.started) {
            standaloneMediaClock.resetPosition(standaloneMediaClock.getPositionUs());
            standaloneMediaClock.started = false;
        }
        this.rendererPositionUs = 1000000000000L;
        for (int i2 = 0; i2 < this.renderers.length; i2++) {
            try {
                disableRenderer(i2);
            } catch (ExoPlaybackException e) {
                e = e;
                Log.e("ExoPlayerImplInternal", "Disable failed.", e);
            } catch (RuntimeException e2) {
                e = e2;
                Log.e("ExoPlayerImplInternal", "Disable failed.", e);
            }
        }
        this.prewarmingMediaPeriodDiscontinuity = -9223372036854775807L;
        if (z) {
            for (RendererHolder rendererHolder : this.renderers) {
                try {
                    rendererHolder.reset();
                } catch (RuntimeException e3) {
                    Log.e("ExoPlayerImplInternal", "Reset failed.", e3);
                }
            }
        }
        this.enabledRendererCount = 0;
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = playbackInfo2.periodId;
        long j4 = playbackInfo2.positionUs;
        if (this.playbackInfo.periodId.isAd()) {
            j = this.playbackInfo.requestedContentPositionUs;
        } else {
            PlaybackInfo playbackInfo3 = this.playbackInfo;
            Timeline.Period period = this.period;
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId3 = playbackInfo3.periodId;
            Timeline timeline = playbackInfo3.timeline;
            if (timeline.isEmpty() || timeline.getPeriodByUid(mediaSource$MediaPeriodId3.periodUid, period).isPlaceholder) {
                j = this.playbackInfo.requestedContentPositionUs;
            } else {
                j = this.playbackInfo.positionUs;
            }
        }
        if (z2) {
            this.pendingInitialSeekPosition = null;
            Pair placeholderFirstMediaPeriodPositionUs = getPlaceholderFirstMediaPeriodPositionUs(this.playbackInfo.timeline);
            mediaSource$MediaPeriodId2 = (MediaSource$MediaPeriodId) placeholderFirstMediaPeriodPositionUs.first;
            long jLongValue = ((Long) placeholderFirstMediaPeriodPositionUs.second).longValue();
            z5 = mediaSource$MediaPeriodId2.equals(this.playbackInfo.periodId) ? false : true;
            j2 = jLongValue;
            j3 = -9223372036854775807L;
        } else {
            j2 = j4;
            j3 = j;
            z5 = false;
        }
        this.queue.clear();
        this.shouldContinueLoading = false;
        Timeline timeline2 = this.playbackInfo.timeline;
        if (z3 && (timeline2 instanceof PlaylistTimeline)) {
            PlaylistTimeline playlistTimeline2 = (PlaylistTimeline) timeline2;
            ShuffleOrder$DefaultShuffleOrder shuffleOrder$DefaultShuffleOrder = this.mediaSourceList.shuffleOrder;
            Timeline[] timelineArr = playlistTimeline2.timelines;
            Timeline[] timelineArr2 = new Timeline[timelineArr.length];
            for (int i3 = 0; i3 < timelineArr.length; i3++) {
                final Timeline timeline3 = timelineArr[i3];
                timelineArr2[i3] = new ForwardingTimeline(timeline3) { // from class: androidx.media3.exoplayer.PlaylistTimeline.1
                    public final Timeline.Window window = new Timeline.Window();

                    public AnonymousClass1(final Timeline timeline4) {
                        super(timeline4);
                        this.window = new Timeline.Window();
                    }

                    @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
                    public final Timeline.Period getPeriod(int i4, Timeline.Period period2, boolean z6) {
                        Timeline timeline4 = this.timeline;
                        Timeline.Period period3 = timeline4.getPeriod(i4, period2, z6);
                        if (timeline4.getWindow(period3.windowIndex, this.window, 0L).isLive()) {
                            period3.set(period2.id, period2.uid, period2.windowIndex, period2.durationUs, period2.positionInWindowUs, AdPlaybackState.NONE, true);
                            return period3;
                        }
                        period3.isPlaceholder = true;
                        return period3;
                    }
                };
            }
            playlistTimeline = new PlaylistTimeline(timelineArr2, playlistTimeline2.uids, shuffleOrder$DefaultShuffleOrder);
            if (mediaSource$MediaPeriodId2.adGroupIndex != -1) {
                playlistTimeline.getPeriodByUid(mediaSource$MediaPeriodId2.periodUid, this.period);
                int i4 = this.period.windowIndex;
                Timeline.Window window = this.window;
                playlistTimeline.getWindow(i4, window, 0L);
                if (window.isLive()) {
                    mediaSource$MediaPeriodId = new MediaSource$MediaPeriodId(mediaSource$MediaPeriodId2.windowSequenceNumber, mediaSource$MediaPeriodId2.periodUid);
                }
            }
            playbackInfo = this.playbackInfo;
            int i5 = playbackInfo.playbackState;
            if (z4) {
                exoPlaybackException = null;
            } else {
                exoPlaybackException = playbackInfo.playbackError;
            }
            if (z5) {
                trackGroupArray = TrackGroupArray.EMPTY;
            } else {
                trackGroupArray = playbackInfo.trackGroups;
            }
            TrackGroupArray trackGroupArray2 = trackGroupArray;
            if (z5) {
                trackSelectorResult = this.emptyTrackSelectorResult;
            } else {
                trackSelectorResult = playbackInfo.trackSelectorResult;
            }
            TrackSelectorResult trackSelectorResult2 = trackSelectorResult;
            if (z5) {
                ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
                list = RegularImmutableList.EMPTY;
            } else {
                list = playbackInfo.staticMetadata;
            }
            this.playbackInfo = new PlaybackInfo(playlistTimeline, mediaSource$MediaPeriodId, j3, j2, i5, exoPlaybackException, false, trackGroupArray2, trackSelectorResult2, list, mediaSource$MediaPeriodId, playbackInfo.playWhenReady, playbackInfo.playWhenReadyChangeReason, playbackInfo.playbackSuppressionReason, playbackInfo.playbackParameters, j2, 0L, j2, 0L, false);
            if (z3) {
                mediaPeriodQueue = this.queue;
                if (!mediaPeriodQueue.preloadPriorityList.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (i = 0; i < mediaPeriodQueue.preloadPriorityList.size(); i++) {
                        ((MediaPeriodHolder) mediaPeriodQueue.preloadPriorityList.get(i)).release();
                    }
                    mediaPeriodQueue.preloadPriorityList = arrayList;
                    mediaPeriodQueue.preloading = null;
                    mediaPeriodQueue.maybeUpdatePreloadMediaPeriodHolder();
                }
                MediaSourceList mediaSourceList = this.mediaSourceList;
                HashMap map = mediaSourceList.childSources;
                for (MediaSourceList.MediaSourceAndListener mediaSourceAndListener : map.values()) {
                    try {
                        mediaSourceAndListener.mediaSource.releaseSource(mediaSourceAndListener.caller);
                    } catch (RuntimeException e4) {
                        Log.e("MediaSourceList", "Failed to release child source.", e4);
                    }
                    BaseMediaSource baseMediaSource = mediaSourceAndListener.mediaSource;
                    MediaSourceList.ForwardingEventListener forwardingEventListener = mediaSourceAndListener.eventListener;
                    baseMediaSource.removeEventListener(forwardingEventListener);
                    mediaSourceAndListener.mediaSource.removeDrmEventListener(forwardingEventListener);
                }
                map.clear();
                mediaSourceList.enabledMediaSourceHolders.clear();
                mediaSourceList.isPrepared = false;
            }
        }
        playlistTimeline = timeline2;
        mediaSource$MediaPeriodId = mediaSource$MediaPeriodId2;
        playbackInfo = this.playbackInfo;
        int i6 = playbackInfo.playbackState;
        if (z4) {
            exoPlaybackException = null;
        } else {
            exoPlaybackException = playbackInfo.playbackError;
        }
        if (z5) {
            trackGroupArray = TrackGroupArray.EMPTY;
        } else {
            trackGroupArray = playbackInfo.trackGroups;
        }
        TrackGroupArray trackGroupArray3 = trackGroupArray;
        if (z5) {
            trackSelectorResult = this.emptyTrackSelectorResult;
        } else {
            trackSelectorResult = playbackInfo.trackSelectorResult;
        }
        TrackSelectorResult trackSelectorResult3 = trackSelectorResult;
        if (z5) {
            ImmutableList.Itr itr2 = ImmutableList.EMPTY_ITR;
            list = RegularImmutableList.EMPTY;
        } else {
            list = playbackInfo.staticMetadata;
        }
        this.playbackInfo = new PlaybackInfo(playlistTimeline, mediaSource$MediaPeriodId, j3, j2, i6, exoPlaybackException, false, trackGroupArray3, trackSelectorResult3, list, mediaSource$MediaPeriodId, playbackInfo.playWhenReady, playbackInfo.playWhenReadyChangeReason, playbackInfo.playbackSuppressionReason, playbackInfo.playbackParameters, j2, 0L, j2, 0L, false);
        if (z3) {
            mediaPeriodQueue = this.queue;
            if (!mediaPeriodQueue.preloadPriorityList.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                while (i < mediaPeriodQueue.preloadPriorityList.size()) {
                    ((MediaPeriodHolder) mediaPeriodQueue.preloadPriorityList.get(i)).release();
                }
                mediaPeriodQueue.preloadPriorityList = arrayList2;
                mediaPeriodQueue.preloading = null;
                mediaPeriodQueue.maybeUpdatePreloadMediaPeriodHolder();
            }
            MediaSourceList mediaSourceList2 = this.mediaSourceList;
            HashMap map2 = mediaSourceList2.childSources;
            while (r4.hasNext()) {
                mediaSourceAndListener.mediaSource.releaseSource(mediaSourceAndListener.caller);
                BaseMediaSource baseMediaSource2 = mediaSourceAndListener.mediaSource;
                MediaSourceList.ForwardingEventListener forwardingEventListener2 = mediaSourceAndListener.eventListener;
                baseMediaSource2.removeEventListener(forwardingEventListener2);
                mediaSourceAndListener.mediaSource.removeDrmEventListener(forwardingEventListener2);
            }
            map2.clear();
            mediaSourceList2.enabledMediaSourceHolders.clear();
            mediaSourceList2.isPrepared = false;
        }
    }

    public final void resetPendingPauseAtEndOfPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.queue.playing;
        this.pendingPauseAtEndOfPeriod = mediaPeriodHolder != null && mediaPeriodHolder.info.isLastInTimelineWindow && this.pauseAtEndOfWindow;
    }

    public final void resetRendererPosition(long j, boolean z) {
        MediaPeriodHolder mediaPeriodHolder = this.queue.playing;
        long j2 = j + (mediaPeriodHolder == null ? 1000000000000L : mediaPeriodHolder.rendererPositionOffsetUs);
        this.rendererPositionUs = j2;
        ((StandaloneMediaClock) this.mediaClock.standaloneClock).resetPosition(j2);
        for (RendererHolder rendererHolder : this.renderers) {
            long j3 = this.rendererPositionUs;
            BaseRenderer rendererReadingFromPeriod = rendererHolder.getRendererReadingFromPeriod(mediaPeriodHolder);
            if (rendererReadingFromPeriod != null) {
                rendererReadingFromPeriod.resetPosition(j3, false, z);
            }
        }
        for (MediaPeriodHolder mediaPeriodHolder2 = r0.playing; mediaPeriodHolder2 != null; mediaPeriodHolder2 = mediaPeriodHolder2.next) {
            for (ExoTrackSelection exoTrackSelection : mediaPeriodHolder2.trackSelectorResult.selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onDiscontinuity();
                }
            }
        }
    }

    public final void resolvePendingMessagePositions(Timeline timeline, Timeline timeline2) {
        if (timeline.isEmpty() && timeline2.isEmpty()) {
            return;
        }
        ArrayList arrayList = this.pendingMessages;
        int size = arrayList.size() - 1;
        while (size >= 0) {
            Timeline timeline3 = timeline;
            Timeline timeline4 = timeline2;
            if (!resolvePendingMessagePosition((PendingMessageInfo) arrayList.get(size), timeline3, timeline4, this.repeatMode, this.shuffleModeEnabled, this.window, this.period)) {
                ((PendingMessageInfo) arrayList.get(size)).message.markAsProcessed(false);
                arrayList.remove(size);
            }
            size--;
            timeline = timeline3;
            timeline2 = timeline4;
        }
        Collections.sort(arrayList);
    }

    public final void scheduleNextWork(long j) {
        boolean z;
        if (this.scrubbingModeEnabled) {
            this.scrubbingModeParameters.getClass();
            z = true;
        } else {
            z = false;
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        long jMin = 1000;
        long j2 = BUFFERING_MAXIMUM_INTERVAL_MS;
        if (z) {
            jMin = playbackInfo.playbackState != 3 ? j2 : 1000L;
            for (RendererHolder rendererHolder : this.renderers) {
                long j3 = this.rendererPositionUs;
                long j4 = this.rendererPositionElapsedRealtimeUs;
                BaseRenderer baseRenderer = rendererHolder.secondaryRenderer;
                BaseRenderer baseRenderer2 = rendererHolder.primaryRenderer;
                long durationToProgressUs = RendererHolder.isRendererEnabled(baseRenderer2) ? baseRenderer2.getDurationToProgressUs(j3, j4) : Long.MAX_VALUE;
                if (baseRenderer != null && baseRenderer.state != 0) {
                    durationToProgressUs = Math.min(durationToProgressUs, baseRenderer.getDurationToProgressUs(j3, j4));
                }
                jMin = Math.min(jMin, Util.usToMs(durationToProgressUs));
            }
            if (this.playbackInfo.isPlaying()) {
                MediaPeriodHolder mediaPeriodHolder = this.queue.playing;
                MediaPeriodHolder mediaPeriodHolder2 = mediaPeriodHolder != null ? mediaPeriodHolder.next : null;
                if (mediaPeriodHolder2 != null) {
                    if ((Util.msToUs(jMin) * this.playbackInfo.playbackParameters.speed) + this.rendererPositionUs >= mediaPeriodHolder2.getStartPositionRendererTime()) {
                        jMin = Math.min(jMin, j2);
                    }
                }
            }
        } else if (playbackInfo.playbackState != 3 || shouldPlayWhenReady()) {
            jMin = j2;
        }
        this.handler.handler.sendEmptyMessageAtTime(2, j + jMin);
    }

    public final void seekToCurrentPosition(boolean z) {
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.queue.playing.info.id;
        long jSeekToPeriodPosition = seekToPeriodPosition(mediaSource$MediaPeriodId, this.playbackInfo.positionUs, true, false);
        if (jSeekToPeriodPosition != this.playbackInfo.positionUs) {
            PlaybackInfo playbackInfo = this.playbackInfo;
            this.playbackInfo = handlePositionDiscontinuity(mediaSource$MediaPeriodId, jSeekToPeriodPosition, playbackInfo.requestedContentPositionUs, playbackInfo.discontinuityStartPositionUs, z, 5);
        }
    }

    public final void seekToInternal(SeekPosition seekPosition) throws Throwable {
        long jLongValue;
        long jMax;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange;
        long j;
        long j2;
        boolean z;
        long j3;
        boolean z2;
        long j4;
        long adjustedSeekPositionUs;
        PlaybackInfo playbackInfo;
        int i;
        long j5;
        int i2;
        long j6;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId;
        long j7;
        ExoPlayerImplInternal exoPlayerImplInternal = this;
        if (exoPlayerImplInternal.seekIsPendingWhileScrubbing) {
            if (exoPlayerImplInternal.queuedSeekWhileScrubbing != null) {
                exoPlayerImplInternal.droppedSeeksWhileScrubbing++;
                exoPlayerImplInternal.playbackInfoUpdate.incrementPendingOperationAcks(1);
            }
            exoPlayerImplInternal.queuedSeekWhileScrubbing = seekPosition;
            return;
        }
        exoPlayerImplInternal.playbackInfoUpdate.incrementPendingOperationAcks(1);
        Pair pairResolveSeekPositionUs = resolveSeekPositionUs(exoPlayerImplInternal.playbackInfo.timeline, seekPosition, true, exoPlayerImplInternal.repeatMode, exoPlayerImplInternal.shuffleModeEnabled, exoPlayerImplInternal.window, exoPlayerImplInternal.period);
        if (pairResolveSeekPositionUs == null) {
            Pair placeholderFirstMediaPeriodPositionUs = exoPlayerImplInternal.getPlaceholderFirstMediaPeriodPositionUs(exoPlayerImplInternal.playbackInfo.timeline);
            mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange = (MediaSource$MediaPeriodId) placeholderFirstMediaPeriodPositionUs.first;
            jLongValue = ((Long) placeholderFirstMediaPeriodPositionUs.second).longValue();
            z = !exoPlayerImplInternal.playbackInfo.timeline.isEmpty();
            jMax = -9223372036854775807L;
            j = -9223372036854775807L;
            j2 = 0;
        } else {
            Object obj = pairResolveSeekPositionUs.first;
            jLongValue = ((Long) pairResolveSeekPositionUs.second).longValue();
            jMax = seekPosition.windowPositionUs == -9223372036854775807L ? -9223372036854775807L : jLongValue;
            mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange = exoPlayerImplInternal.queue.resolveMediaPeriodIdForAdsAfterPeriodPositionChange(exoPlayerImplInternal.playbackInfo.timeline, obj, jLongValue);
            if (mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd()) {
                exoPlayerImplInternal.playbackInfo.timeline.getPeriodByUid(mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.periodUid, exoPlayerImplInternal.period);
                jLongValue = exoPlayerImplInternal.period.getFirstAdIndexToPlay(mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adGroupIndex) == mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adIndexInAdGroup ? exoPlayerImplInternal.period.adPlaybackState.adResumePositionUs : 0L;
                AdPlaybackState.AdGroup adGroup = exoPlayerImplInternal.period.adPlaybackState.getAdGroup(mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adGroupIndex);
                j2 = 0;
                j = -9223372036854775807L;
                jMax = Math.max(jMax, adGroup.timeUs + adGroup.contentResumeOffsetUs);
            } else {
                j = -9223372036854775807L;
                j2 = 0;
                if (seekPosition.windowPositionUs != -9223372036854775807L) {
                    z = false;
                }
            }
            z = true;
        }
        try {
            try {
                if (!exoPlayerImplInternal.playbackInfo.timeline.isEmpty()) {
                    PlaybackInfo playbackInfo2 = exoPlayerImplInternal.playbackInfo;
                    if (pairResolveSeekPositionUs == null) {
                        if (playbackInfo2.playbackState != 1) {
                            exoPlayerImplInternal.setState(4);
                        }
                        exoPlayerImplInternal.resetInternal(false, true, false, true);
                    } else {
                        if (mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.equals(playbackInfo2.periodId)) {
                            try {
                                MediaPeriodHolder mediaPeriodHolder = exoPlayerImplInternal.queue.playing;
                                if (mediaPeriodHolder == null || !mediaPeriodHolder.prepared || jLongValue == j2) {
                                    adjustedSeekPositionUs = jLongValue;
                                } else {
                                    MediaPeriod mediaPeriod = mediaPeriodHolder.mediaPeriod;
                                    long j8 = exoPlayerImplInternal.window.durationUs;
                                    if (exoPlayerImplInternal.scrubbingModeEnabled && j8 != j) {
                                        exoPlayerImplInternal.scrubbingModeParameters.getClass();
                                    }
                                    adjustedSeekPositionUs = mediaPeriod.getAdjustedSeekPositionUs(jLongValue, exoPlayerImplInternal.seekParameters);
                                }
                                if (Util.usToMs(adjustedSeekPositionUs) == Util.usToMs(exoPlayerImplInternal.playbackInfo.positionUs) && ((i = (playbackInfo = exoPlayerImplInternal.playbackInfo).playbackState) == 2 || i == 3)) {
                                    j5 = playbackInfo.positionUs;
                                    i2 = 2;
                                    j6 = j5;
                                    z2 = z;
                                    mediaSource$MediaPeriodId = mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange;
                                    j7 = jMax;
                                }
                            } catch (Throwable th) {
                                th = th;
                                z2 = z;
                                j4 = jLongValue;
                                j3 = jMax;
                                exoPlayerImplInternal.playbackInfo = exoPlayerImplInternal.handlePositionDiscontinuity(mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange, j4, j3, j4, z2, 2);
                                throw th;
                            }
                        } else {
                            adjustedSeekPositionUs = jLongValue;
                        }
                        try {
                            boolean z3 = exoPlayerImplInternal.playbackInfo.playbackState == 4;
                            try {
                                MediaPeriodQueue mediaPeriodQueue = exoPlayerImplInternal.queue;
                                long jSeekToPeriodPosition = exoPlayerImplInternal.seekToPeriodPosition(mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange, adjustedSeekPositionUs, mediaPeriodQueue.playing != mediaPeriodQueue.reading, z3);
                                z2 = (jLongValue != jSeekToPeriodPosition) | z;
                                try {
                                    PlaybackInfo playbackInfo3 = exoPlayerImplInternal.playbackInfo;
                                    MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange;
                                    try {
                                        Timeline timeline = playbackInfo3.timeline;
                                        long j9 = jMax;
                                        try {
                                            exoPlayerImplInternal.updatePlaybackSpeedSettingsForNewPeriod(timeline, mediaSource$MediaPeriodId2, timeline, playbackInfo3.periodId, j9, true);
                                            mediaSource$MediaPeriodId = mediaSource$MediaPeriodId2;
                                            j7 = j9;
                                            j5 = jSeekToPeriodPosition;
                                            i2 = 2;
                                            j6 = j5;
                                            exoPlayerImplInternal = this;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange = mediaSource$MediaPeriodId2;
                                            j3 = j9;
                                            j4 = jSeekToPeriodPosition;
                                            exoPlayerImplInternal.playbackInfo = exoPlayerImplInternal.handlePositionDiscontinuity(mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange, j4, j3, j4, z2, 2);
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange = mediaSource$MediaPeriodId2;
                                        j3 = jMax;
                                        j4 = jSeekToPeriodPosition;
                                        exoPlayerImplInternal.playbackInfo = exoPlayerImplInternal.handlePositionDiscontinuity(mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange, j4, j3, j4, z2, 2);
                                        throw th;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                j3 = jMax;
                                z2 = z;
                                j4 = jLongValue;
                                exoPlayerImplInternal.playbackInfo = exoPlayerImplInternal.handlePositionDiscontinuity(mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange, j4, j3, j4, z2, 2);
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    }
                    exoPlayerImplInternal.playbackInfo = exoPlayerImplInternal.handlePositionDiscontinuity(mediaSource$MediaPeriodId, j5, j7, j6, z2, i2);
                }
                exoPlayerImplInternal.pendingInitialSeekPosition = seekPosition;
                z2 = z;
                mediaSource$MediaPeriodId = mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange;
                j5 = jLongValue;
                j7 = jMax;
                i2 = 2;
                j6 = j5;
                exoPlayerImplInternal = this;
                exoPlayerImplInternal.playbackInfo = exoPlayerImplInternal.handlePositionDiscontinuity(mediaSource$MediaPeriodId, j5, j7, j6, z2, i2);
            } catch (Throwable th7) {
                th = th7;
                z2 = z;
            }
        } catch (Throwable th8) {
            th = th8;
            z = z;
            mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange = mediaSource$MediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange;
        }
    }

    /* JADX WARN: Code duplicated, block: B:72:0x0113  */
    public final long seekToPeriodPosition(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, long j, boolean z, boolean z2) {
        MediaPeriodQueue mediaPeriodQueue;
        byte b;
        stopRenderers();
        boolean z3 = true;
        updateRebufferingState(false, true);
        if (z2 || this.playbackInfo.playbackState == 3) {
            setState(2);
        }
        MediaPeriodHolder mediaPeriodHolder = this.queue.playing;
        MediaPeriodHolder mediaPeriodHolder2 = mediaPeriodHolder;
        while (mediaPeriodHolder2 != null && !mediaSource$MediaPeriodId.equals(mediaPeriodHolder2.info.id)) {
            mediaPeriodHolder2 = mediaPeriodHolder2.next;
        }
        if (z || mediaPeriodHolder != mediaPeriodHolder2 || (mediaPeriodHolder2 != null && mediaPeriodHolder2.rendererPositionOffsetUs + j < 0)) {
            for (int i = 0; i < this.renderers.length; i++) {
                disableRenderer(i);
            }
            this.prewarmingMediaPeriodDiscontinuity = -9223372036854775807L;
            if (mediaPeriodHolder2 != null) {
                while (true) {
                    mediaPeriodQueue = this.queue;
                    if (mediaPeriodQueue.playing == mediaPeriodHolder2) {
                        break;
                    }
                    mediaPeriodQueue.advancePlayingPeriod();
                }
                mediaPeriodQueue.removeAfter(mediaPeriodHolder2);
                mediaPeriodHolder2.rendererPositionOffsetUs = 1000000000000L;
                enableRenderers(new boolean[this.renderers.length], this.queue.reading.getStartPositionRendererTime());
                mediaPeriodHolder2.allRenderersInCorrectState = true;
            }
        }
        disableAndResetPrewarmingRenderers();
        if (this.scrubbingModeEnabled) {
            for (RendererHolder rendererHolder : this.renderers) {
                if (rendererHolder.isRendererEnabled() && ((b = rendererHolder.primaryRenderer.trackType) == 2 || b == 4)) {
                    this.seekIsPendingWhileScrubbing = true;
                    break;
                }
            }
        }
        MediaPeriodQueue mediaPeriodQueue2 = this.queue;
        if (mediaPeriodHolder2 != null) {
            mediaPeriodQueue2.removeAfter(mediaPeriodHolder2);
            if (!mediaPeriodHolder2.prepared) {
                mediaPeriodHolder2.info = mediaPeriodHolder2.info.copyWithStartPositionUs(j, -9223372036854775807L);
            } else if (mediaPeriodHolder2.hasEnabledTracks) {
                if (this.scrubbingModeEnabled) {
                    this.scrubbingModeParameters.getClass();
                    if (this.playbackInfo.timeline.isEmpty() || !mediaPeriodHolder2.info.id.equals(this.playbackInfo.periodId)) {
                        j = mediaPeriodHolder2.mediaPeriod.seekToUs(j);
                        mediaPeriodHolder2.mediaPeriod.discardBuffer(j - this.backBufferDurationUs);
                    } else {
                        long j2 = mediaPeriodHolder2.rendererPositionOffsetUs + j;
                        boolean z4 = true;
                        for (RendererHolder rendererHolder2 : this.renderers) {
                            if (rendererHolder2.isRendererEnabled()) {
                                BaseRenderer rendererReadingFromPeriod = rendererHolder2.getRendererReadingFromPeriod(mediaPeriodHolder2);
                                z4 &= rendererReadingFromPeriod != null && rendererReadingFromPeriod.supportsResetPositionWithoutKeyFrameReset(j2);
                            }
                        }
                        if (z4) {
                            MediaPeriod mediaPeriod = mediaPeriodHolder2.mediaPeriod;
                            long j3 = this.playbackInfo.positionUs;
                            SeekParameters seekParameters = SeekParameters.PREVIOUS_SYNC;
                            if (mediaPeriod.getAdjustedSeekPositionUs(j3, seekParameters) == mediaPeriodHolder2.mediaPeriod.getAdjustedSeekPositionUs(j, seekParameters)) {
                                z3 = false;
                            } else {
                                j = mediaPeriodHolder2.mediaPeriod.seekToUs(j);
                                mediaPeriodHolder2.mediaPeriod.discardBuffer(j - this.backBufferDurationUs);
                            }
                        } else {
                            j = mediaPeriodHolder2.mediaPeriod.seekToUs(j);
                            mediaPeriodHolder2.mediaPeriod.discardBuffer(j - this.backBufferDurationUs);
                        }
                    }
                } else {
                    j = mediaPeriodHolder2.mediaPeriod.seekToUs(j);
                    mediaPeriodHolder2.mediaPeriod.discardBuffer(j - this.backBufferDurationUs);
                }
            }
            resetRendererPosition(j, z3);
            maybeContinueLoading();
        } else {
            mediaPeriodQueue2.clear();
            resetRendererPosition(j, true);
        }
        handleLoadingMediaPeriodChanged(false);
        this.handler.sendEmptyMessage(2);
        return j;
    }

    public final void sendMessageInternal(PlayerMessage playerMessage) {
        if (playerMessage.positionMs == -9223372036854775807L) {
            sendMessageToTarget(playerMessage);
            return;
        }
        boolean zIsEmpty = this.playbackInfo.timeline.isEmpty();
        ArrayList arrayList = this.pendingMessages;
        if (zIsEmpty) {
            arrayList.add(new PendingMessageInfo(playerMessage));
            return;
        }
        PendingMessageInfo pendingMessageInfo = new PendingMessageInfo(playerMessage);
        Timeline timeline = this.playbackInfo.timeline;
        if (!resolvePendingMessagePosition(pendingMessageInfo, timeline, timeline, this.repeatMode, this.shuffleModeEnabled, this.window, this.period)) {
            playerMessage.markAsProcessed(false);
        } else {
            arrayList.add(pendingMessageInfo);
            Collections.sort(arrayList);
        }
    }

    public final void sendMessageToTarget(PlayerMessage playerMessage) {
        Looper looper = playerMessage.looper;
        Looper looper2 = this.playbackLooper;
        SystemHandlerWrapper systemHandlerWrapper = this.handler;
        if (looper != looper2) {
            systemHandlerWrapper.obtainMessage(15, playerMessage).sendToTarget();
            return;
        }
        deliverMessage(playerMessage);
        int i = this.playbackInfo.playbackState;
        if (i == 3 || i == 2) {
            systemHandlerWrapper.sendEmptyMessage(2);
        }
    }

    public final void sendMessageToTargetThread(PlayerMessage playerMessage) {
        Looper looper = playerMessage.looper;
        if (looper.getThread().isAlive()) {
            new SystemHandlerWrapper(new Handler(looper, null)).post(new ActivityCompat$$ExternalSyntheticLambda0(this, playerMessage));
        } else {
            Log.w("TAG", "Trying to send message on a dead thread.");
            playerMessage.markAsProcessed(false);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:13:0x0024  */
    /* JADX WARN: Code duplicated, block: B:20:0x003b  */
    public final void setAudioAttributesInternal(AudioAttributes audioAttributes, boolean z) {
        int i;
        DefaultTrackSelector defaultTrackSelector = this.trackSelector;
        if (!defaultTrackSelector.audioAttributes.equals(audioAttributes)) {
            defaultTrackSelector.audioAttributes = audioAttributes;
            defaultTrackSelector.maybeInvalidateForAudioChannelCountConstraints();
        }
        if (!z) {
            audioAttributes = null;
        }
        AudioFocusManager audioFocusManager = this.audioFocusManager;
        if (!Objects.equals(audioFocusManager.audioAttributes, audioAttributes)) {
            audioFocusManager.audioAttributes = audioAttributes;
            if (audioAttributes != null) {
                int i2 = audioAttributes.usage;
                i = 3;
                switch (i2) {
                    case 0:
                        Log.w("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                        i = 1;
                        break;
                    case 1:
                    case 14:
                        i = 1;
                        break;
                    case 2:
                    case 4:
                        i = 2;
                        break;
                    case 3:
                        i = 0;
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                    case 13:
                        break;
                    case 11:
                        if (audioAttributes.contentType == 1) {
                            i = 2;
                        }
                        break;
                    case 15:
                    default:
                        Format$$ExternalSyntheticOutline0.m(i2, "Unidentified audio usage: ", "AudioFocusManager");
                        i = 0;
                        break;
                    case 16:
                        i = 4;
                        break;
                }
            } else {
                i = 0;
            }
            audioFocusManager.focusGainToRequest = i;
            UtilsKt.checkArgument("Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.", i == 1 || i == 0);
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        boolean z2 = playbackInfo.playWhenReady;
        updatePlayWhenReadyWithAudioFocus(audioFocusManager.updateAudioFocus(playbackInfo.playbackState, z2), playbackInfo.playbackSuppressionReason, playbackInfo.playWhenReadyChangeReason, z2);
    }

    public final void setForegroundModeInternal(boolean z, ConditionVariable conditionVariable) {
        if (this.foregroundMode != z) {
            this.foregroundMode = z;
            if (!z) {
                for (RendererHolder rendererHolder : this.renderers) {
                    rendererHolder.reset();
                }
            }
        }
        if (conditionVariable != null) {
            conditionVariable.open();
        }
    }

    public final void setImageMetadataListenerInternal(ExoPlayerImplInternal$$ExternalSyntheticLambda4 exoPlayerImplInternal$$ExternalSyntheticLambda4) {
        for (RendererHolder rendererHolder : this.renderers) {
            BaseRenderer baseRenderer = rendererHolder.primaryRenderer;
            if (baseRenderer.trackType == 4) {
                baseRenderer.handleMessage(23, exoPlayerImplInternal$$ExternalSyntheticLambda4);
                BaseRenderer baseRenderer2 = rendererHolder.secondaryRenderer;
                if (baseRenderer2 != null) {
                    baseRenderer2.handleMessage(23, exoPlayerImplInternal$$ExternalSyntheticLambda4);
                }
            }
        }
    }

    public final void setMediaItemsInternal(MediaSourceListUpdateMessage mediaSourceListUpdateMessage) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        int i = mediaSourceListUpdateMessage.windowIndex;
        ShuffleOrder$DefaultShuffleOrder shuffleOrder$DefaultShuffleOrder = mediaSourceListUpdateMessage.shuffleOrder;
        ArrayList arrayList = mediaSourceListUpdateMessage.mediaSourceHolders;
        if (i != -1) {
            this.pendingInitialSeekPosition = new SeekPosition(new PlaylistTimeline(arrayList, shuffleOrder$DefaultShuffleOrder), mediaSourceListUpdateMessage.windowIndex, mediaSourceListUpdateMessage.positionUs);
        }
        MediaSourceList mediaSourceList = this.mediaSourceList;
        ArrayList arrayList2 = mediaSourceList.mediaSourceHolders;
        mediaSourceList.removeMediaSourcesInternal(0, arrayList2.size());
        handleMediaSourceListInfoRefreshed(mediaSourceList.addMediaSources(arrayList2.size(), arrayList, shuffleOrder$DefaultShuffleOrder), false);
    }

    public final void setPauseAtEndOfWindowInternal(boolean z) {
        this.pauseAtEndOfWindow = z;
        resetPendingPauseAtEndOfPeriod();
        if (this.pendingPauseAtEndOfPeriod) {
            MediaPeriodQueue mediaPeriodQueue = this.queue;
            if (mediaPeriodQueue.reading != mediaPeriodQueue.playing) {
                seekToCurrentPosition(true);
                handleLoadingMediaPeriodChanged(false);
            }
        }
    }

    public final void setPlaybackParametersInternal(PlaybackParameters playbackParameters) {
        this.handler.removeMessages(16);
        DefaultMediaClock defaultMediaClock = this.mediaClock;
        defaultMediaClock.setPlaybackParameters(playbackParameters);
        PlaybackParameters playbackParameters2 = defaultMediaClock.getPlaybackParameters();
        handlePlaybackParameters(playbackParameters2, playbackParameters2.speed, true, true);
    }

    public final void setPreloadConfigurationInternal(ExoPlayer$PreloadConfiguration exoPlayer$PreloadConfiguration) {
        this.preloadConfiguration = exoPlayer$PreloadConfiguration;
        Timeline timeline = this.playbackInfo.timeline;
        MediaPeriodQueue mediaPeriodQueue = this.queue;
        mediaPeriodQueue.getClass();
        exoPlayer$PreloadConfiguration.getClass();
        if (mediaPeriodQueue.preloadPriorityList.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < mediaPeriodQueue.preloadPriorityList.size(); i++) {
            ((MediaPeriodHolder) mediaPeriodQueue.preloadPriorityList.get(i)).release();
        }
        mediaPeriodQueue.preloadPriorityList = arrayList;
        mediaPeriodQueue.preloading = null;
        mediaPeriodQueue.maybeUpdatePreloadMediaPeriodHolder();
    }

    public final void setRepeatModeInternal(int i) {
        this.repeatMode = i;
        Timeline timeline = this.playbackInfo.timeline;
        MediaPeriodQueue mediaPeriodQueue = this.queue;
        mediaPeriodQueue.repeatMode = i;
        int iUpdateForPlaybackModeChange = mediaPeriodQueue.updateForPlaybackModeChange(timeline);
        if ((iUpdateForPlaybackModeChange & 1) != 0) {
            seekToCurrentPosition(true);
        } else if ((iUpdateForPlaybackModeChange & 2) != 0) {
            disableAndResetPrewarmingRenderers();
        }
        handleLoadingMediaPeriodChanged(false);
    }

    public final void setScrubbingModeEnabledInternal(boolean z) throws Throwable {
        if (!z) {
            SeekPosition seekPosition = this.queuedSeekWhileScrubbing;
            SystemHandlerWrapper systemHandlerWrapper = this.handler;
            if (seekPosition != null && this.seekIsPendingWhileScrubbing && !systemHandlerWrapper.handler.hasMessages(37)) {
                this.droppedSeeksWhileScrubbing++;
            }
            int i = this.droppedSeeksWhileScrubbing;
            if (i > 0) {
                this.applicationLooperHandler.post(new ActivityCompat$$ExternalSyntheticLambda0(this, i));
            }
            this.droppedSeeksWhileScrubbing = 0;
            this.seekIsPendingWhileScrubbing = false;
            systemHandlerWrapper.removeMessages(37);
            SeekPosition seekPosition2 = this.queuedSeekWhileScrubbing;
            if (seekPosition2 != null) {
                seekToInternal(seekPosition2);
                this.queuedSeekWhileScrubbing = null;
                this.seekIsPendingWhileScrubbing = false;
            }
        }
        this.scrubbingModeEnabled = z;
        applyScrubbingModeParameters();
    }

    public final void setScrubbingModeParametersInternal(ScrubbingModeParameters scrubbingModeParameters) {
        this.scrubbingModeParameters = scrubbingModeParameters;
        applyScrubbingModeParameters();
    }

    public final void setShuffleModeEnabledInternal(boolean z) {
        this.shuffleModeEnabled = z;
        Timeline timeline = this.playbackInfo.timeline;
        MediaPeriodQueue mediaPeriodQueue = this.queue;
        mediaPeriodQueue.shuffleModeEnabled = z;
        int iUpdateForPlaybackModeChange = mediaPeriodQueue.updateForPlaybackModeChange(timeline);
        if ((iUpdateForPlaybackModeChange & 1) != 0) {
            seekToCurrentPosition(true);
        } else if ((iUpdateForPlaybackModeChange & 2) != 0) {
            disableAndResetPrewarmingRenderers();
        }
        handleLoadingMediaPeriodChanged(false);
    }

    public final void setShuffleOrderInternal(ShuffleOrder$DefaultShuffleOrder shuffleOrder$DefaultShuffleOrder) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        MediaSourceList mediaSourceList = this.mediaSourceList;
        int size = mediaSourceList.mediaSourceHolders.size();
        if (shuffleOrder$DefaultShuffleOrder.shuffled.length != size) {
            shuffleOrder$DefaultShuffleOrder = new ShuffleOrder$DefaultShuffleOrder(new Random(shuffleOrder$DefaultShuffleOrder.random.nextLong())).cloneAndInsert(0, size);
        }
        mediaSourceList.shuffleOrder = shuffleOrder$DefaultShuffleOrder;
        handleMediaSourceListInfoRefreshed(mediaSourceList.createTimeline(), false);
    }

    public final void setState(int i) {
        PlaybackInfo playbackInfoCopyWithSleepingForOffload = this.playbackInfo;
        if (playbackInfoCopyWithSleepingForOffload.playbackState != i) {
            if (i != 2) {
                this.playbackMaybeBecameStuckAtMs = -9223372036854775807L;
            }
            if (i != 3 && playbackInfoCopyWithSleepingForOffload.sleepingForOffload) {
                playbackInfoCopyWithSleepingForOffload = playbackInfoCopyWithSleepingForOffload.copyWithSleepingForOffload(false);
                this.playbackInfo = playbackInfoCopyWithSleepingForOffload;
            }
            this.playbackInfo = playbackInfoCopyWithSleepingForOffload.copyWithPlaybackState(i);
        }
    }

    public final void setVideoFrameMetadataListenerInternal(VideoFrameMetadataListener videoFrameMetadataListener) {
        for (RendererHolder rendererHolder : this.renderers) {
            BaseRenderer baseRenderer = rendererHolder.primaryRenderer;
            if (baseRenderer.trackType == 2) {
                baseRenderer.handleMessage(7, videoFrameMetadataListener);
                BaseRenderer baseRenderer2 = rendererHolder.secondaryRenderer;
                if (baseRenderer2 != null) {
                    baseRenderer2.handleMessage(7, videoFrameMetadataListener);
                }
            }
        }
    }

    public final void setVideoOutputInternal(Object obj, ConditionVariable conditionVariable) {
        for (RendererHolder rendererHolder : this.renderers) {
            BaseRenderer baseRenderer = rendererHolder.primaryRenderer;
            if (baseRenderer.trackType == 2) {
                int i = rendererHolder.prewarmingState;
                if (i == 4 || i == 1) {
                    BaseRenderer baseRenderer2 = rendererHolder.secondaryRenderer;
                    baseRenderer2.getClass();
                    baseRenderer2.handleMessage(1, obj);
                } else {
                    baseRenderer.handleMessage(1, obj);
                }
            }
        }
        int i2 = this.playbackInfo.playbackState;
        if (i2 == 3 || i2 == 2) {
            this.handler.sendEmptyMessage(2);
        }
        if (conditionVariable != null) {
            conditionVariable.open();
        }
    }

    public final void setVolumeInternal(float f) {
        this.volume = f;
        float f2 = f * this.audioFocusManager.volumeMultiplier;
        for (RendererHolder rendererHolder : this.renderers) {
            BaseRenderer baseRenderer = rendererHolder.primaryRenderer;
            if (baseRenderer.trackType == 1) {
                baseRenderer.handleMessage(2, Float.valueOf(f2));
                BaseRenderer baseRenderer2 = rendererHolder.secondaryRenderer;
                if (baseRenderer2 != null) {
                    baseRenderer2.handleMessage(2, Float.valueOf(f2));
                }
            }
        }
    }

    public final boolean shouldPlayWhenReady() {
        PlaybackInfo playbackInfo = this.playbackInfo;
        return playbackInfo.playWhenReady && playbackInfo.playbackSuppressionReason == 0;
    }

    public final boolean shouldUseLivePlaybackSpeedControl(Timeline timeline, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        if (mediaSource$MediaPeriodId.isAd() || timeline.isEmpty()) {
            return false;
        }
        int i = timeline.getPeriodByUid(mediaSource$MediaPeriodId.periodUid, this.period).windowIndex;
        Timeline.Window window = this.window;
        timeline.getWindow(i, window);
        return window.isLive() && window.isDynamic && window.windowStartTimeMs != -9223372036854775807L;
    }

    public final void startRenderers() {
        MediaPeriodHolder mediaPeriodHolder = this.queue.playing;
        if (mediaPeriodHolder == null) {
            return;
        }
        TrackSelectorResult trackSelectorResult = mediaPeriodHolder.trackSelectorResult;
        int i = 0;
        while (true) {
            RendererHolder[] rendererHolderArr = this.renderers;
            if (i >= rendererHolderArr.length) {
                return;
            }
            if (trackSelectorResult.isRendererEnabled(i)) {
                rendererHolderArr[i].start();
            }
            i++;
        }
    }

    public final void stopInternal(boolean z, boolean z2) {
        resetInternal(z || !this.foregroundMode, false, true, false);
        this.playbackInfoUpdate.incrementPendingOperationAcks(z2 ? 1 : 0);
        DefaultLoadControl defaultLoadControl = this.loadControl;
        ConcurrentHashMap concurrentHashMap = defaultLoadControl.loadingStates;
        PlayerId playerId = this.playerId;
        DefaultLoadControl.PlayerLoadingState playerLoadingState = (DefaultLoadControl.PlayerLoadingState) concurrentHashMap.get(playerId);
        if (playerLoadingState != null) {
            int i = playerLoadingState.referenceCount - 1;
            playerLoadingState.referenceCount = i;
            if (i == 0) {
                concurrentHashMap.remove(playerId);
                defaultLoadControl.updateAllocator();
            }
        }
        this.audioFocusManager.updateAudioFocus(1, this.playbackInfo.playWhenReady);
        setState(1);
    }

    public final void stopRenderers() {
        DefaultMediaClock defaultMediaClock = this.mediaClock;
        defaultMediaClock.standaloneClockIsStarted = false;
        StandaloneMediaClock standaloneMediaClock = (StandaloneMediaClock) defaultMediaClock.standaloneClock;
        if (standaloneMediaClock.started) {
            standaloneMediaClock.resetPosition(standaloneMediaClock.getPositionUs());
            standaloneMediaClock.started = false;
        }
        for (RendererHolder rendererHolder : this.renderers) {
            BaseRenderer baseRenderer = rendererHolder.secondaryRenderer;
            BaseRenderer baseRenderer2 = rendererHolder.primaryRenderer;
            if (RendererHolder.isRendererEnabled(baseRenderer2)) {
                RendererHolder.ensureStopped(baseRenderer2);
            }
            if (baseRenderer != null && baseRenderer.state != 0) {
                RendererHolder.ensureStopped(baseRenderer);
            }
        }
    }

    public final void updateIsLoading() {
        MediaPeriodHolder mediaPeriodHolder = this.queue.loading;
        boolean z = this.shouldContinueLoading || (mediaPeriodHolder != null && mediaPeriodHolder.mediaPeriod.isLoading());
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (z != playbackInfo.isLoading) {
            this.playbackInfo = playbackInfo.copyWithIsLoading(z);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x0071  */
    public final void updateLoadControlTrackSelection(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, TrackSelectorResult trackSelectorResult) {
        boolean z;
        MediaPeriodHolder mediaPeriodHolder = this.queue.loading;
        mediaPeriodHolder.getClass();
        getTotalBufferedDurationUs(mediaPeriodHolder.getBufferedPositionUs());
        shouldUseLivePlaybackSpeedControl(this.playbackInfo.timeline, mediaPeriodHolder.info.id);
        Timeline timeline = this.playbackInfo.timeline;
        float f = this.mediaClock.getPlaybackParameters().speed;
        boolean z2 = this.playbackInfo.playWhenReady;
        ExoTrackSelection[] exoTrackSelectionArr = trackSelectorResult.selections;
        DefaultLoadControl defaultLoadControl = this.loadControl;
        defaultLoadControl.getClass();
        ImmutableMap immutableMap = defaultLoadControl.playerTargetBufferBytesOverwrites;
        PlayerId playerId = this.playerId;
        Integer num = (Integer) immutableMap.get(playerId.name);
        int iIntValue = (num == null || num.intValue() == -1) ? -1 : num.intValue();
        DefaultLoadControl.PlayerLoadingState playerLoadingState = (DefaultLoadControl.PlayerLoadingState) defaultLoadControl.loadingStates.get(playerId);
        playerLoadingState.getClass();
        if (iIntValue == -1) {
            MediaItem.LocalConfiguration localConfiguration = timeline.getWindow(timeline.getPeriodByUid(mediaSource$MediaPeriodId.periodUid, defaultLoadControl.period).windowIndex, defaultLoadControl.window, 0L).mediaItem.localConfiguration;
            if (localConfiguration == null) {
                z = false;
            } else {
                String scheme = localConfiguration.uri.getScheme();
                if (TextUtils.isEmpty(scheme) || DefaultLoadControl.LOCAL_PLAYBACK_SCHEMES.contains(scheme)) {
                    z = true;
                } else {
                    z = false;
                }
            }
            int length = exoTrackSelectionArr.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = 13107200;
                if (i < length) {
                    ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i];
                    if (exoTrackSelection != null) {
                        switch (exoTrackSelection.getTrackGroup().type) {
                            case -2:
                                i3 = 0;
                                i2 += i3;
                                break;
                            case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                            case 1:
                                i2 += i3;
                                break;
                            case 0:
                                i3 = 144310272;
                                i2 += i3;
                                break;
                            case 2:
                                i3 = z ? 19660800 : 131072000;
                                i2 += i3;
                                break;
                            case 3:
                            case 5:
                            case 6:
                                i3 = 131072;
                                i2 += i3;
                                break;
                            case 4:
                                i3 = 26214400;
                                i2 += i3;
                                break;
                            default:
                                Path$$ExternalSyntheticBUOutline0.m();
                                break;
                        }
                        return;
                    }
                    i++;
                } else {
                    iIntValue = Util.constrainValue(i2, 13107200, 210239488);
                }
            }
        }
        playerLoadingState.targetBufferBytes = iIntValue;
        defaultLoadControl.updateAllocator();
    }

    public final void updateMediaSourcesWithMediaItemsInternal(int i, int i2, List list) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        MediaSourceList mediaSourceList = this.mediaSourceList;
        mediaSourceList.getClass();
        ArrayList arrayList = mediaSourceList.mediaSourceHolders;
        UtilsKt.checkArgument(i >= 0 && i <= i2 && i2 <= arrayList.size());
        UtilsKt.checkArgument(list.size() == i2 - i);
        for (int i3 = i; i3 < i2; i3++) {
            ((MediaSourceList.MediaSourceHolder) arrayList.get(i3)).mediaSource.updateMediaItem((MediaItem) list.get(i3 - i));
        }
        handleMediaSourceListInfoRefreshed(mediaSourceList.createTimeline(), false);
    }

    /* JADX WARN: Code duplicated, block: B:150:0x029f  */
    /* JADX WARN: Code duplicated, block: B:152:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:18:0x0045  */
    /* JADX WARN: Code duplicated, block: B:203:0x038a  */
    /* JADX WARN: Code duplicated, block: B:205:0x038e  */
    /* JADX WARN: Code duplicated, block: B:207:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:212:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:214:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:228:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:247:0x042a  */
    /* JADX WARN: Code duplicated, block: B:316:0x0522  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void updatePeriods() {
        MediaPeriodHolder mediaPeriodHolder;
        MediaPeriodHolder mediaPeriodHolder2;
        MediaPeriodHolder mediaPeriodHolder3;
        boolean z;
        boolean z2;
        TrackSelectorResult trackSelectorResult;
        MediaPeriodHolder mediaPeriodHolder4;
        MediaPeriodHolder mediaPeriodHolder5;
        MediaPeriodHolder mediaPeriodHolder6;
        TrackSelectorResult trackSelectorResult2;
        int length;
        int i;
        BaseRenderer baseRenderer;
        boolean zIsRendererEnabled;
        BaseRenderer baseRenderer2;
        byte b;
        int i2;
        int i3;
        MediaPeriodHolder mediaPeriodHolder7;
        MediaPeriodHolder mediaPeriodHolder8;
        boolean z3;
        int i4;
        if (this.playbackInfo.timeline.isEmpty() || !this.mediaSourceList.isPrepared) {
            return;
        }
        this.queue.reevaluateBuffer(this.rendererPositionUs);
        MediaPeriodQueue mediaPeriodQueue = this.queue;
        MediaPeriodHolder mediaPeriodHolder9 = mediaPeriodQueue.loading;
        long j = -9223372036854775807L;
        if (mediaPeriodHolder9 == null || (!mediaPeriodHolder9.info.isFinal && mediaPeriodHolder9.isFullyBuffered() && mediaPeriodQueue.loading.info.durationUs != -9223372036854775807L && mediaPeriodQueue.length < 100)) {
            MediaPeriodQueue mediaPeriodQueue2 = this.queue;
            long j2 = this.rendererPositionUs;
            PlaybackInfo playbackInfo = this.playbackInfo;
            MediaPeriodHolder mediaPeriodHolder10 = mediaPeriodQueue2.loading;
            MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder10 == null ? mediaPeriodQueue2.getMediaPeriodInfo(playbackInfo.timeline, playbackInfo.periodId, playbackInfo.requestedContentPositionUs, playbackInfo.positionUs, -9223372036854775807L) : mediaPeriodQueue2.getFollowingMediaPeriodInfo(playbackInfo.timeline, mediaPeriodHolder10, j2);
            if (mediaPeriodInfo != null) {
                MediaPeriodQueue mediaPeriodQueue3 = this.queue;
                MediaPeriodHolder mediaPeriodHolder11 = mediaPeriodQueue3.loading;
                long j3 = mediaPeriodHolder11 == null ? 1000000000000L : (mediaPeriodHolder11.rendererPositionOffsetUs + mediaPeriodHolder11.info.durationUs) - mediaPeriodInfo.startPositionUs;
                int i5 = 0;
                while (true) {
                    if (i5 >= mediaPeriodQueue3.preloadPriorityList.size()) {
                        mediaPeriodHolder = null;
                        break;
                    }
                    MediaPeriodInfo mediaPeriodInfo2 = ((MediaPeriodHolder) mediaPeriodQueue3.preloadPriorityList.get(i5)).info;
                    long j4 = mediaPeriodInfo2.durationUs;
                    long j5 = mediaPeriodInfo.durationUs;
                    if ((j4 == -9223372036854775807L || j4 == j5) && mediaPeriodInfo2.startPositionUs == mediaPeriodInfo.startPositionUs && mediaPeriodInfo2.id.equals(mediaPeriodInfo.id)) {
                        mediaPeriodHolder = (MediaPeriodHolder) mediaPeriodQueue3.preloadPriorityList.remove(i5);
                        break;
                    }
                    i5++;
                }
                if (mediaPeriodHolder == null) {
                    ExoPlayerImplInternal exoPlayerImplInternal = (ExoPlayerImplInternal) mediaPeriodQueue3.mediaPeriodHolderFactory.f$0;
                    BaseRenderer[] baseRendererArr = exoPlayerImplInternal.rendererCapabilities;
                    DefaultTrackSelector defaultTrackSelector = exoPlayerImplInternal.trackSelector;
                    DefaultLoadControl defaultLoadControl = exoPlayerImplInternal.loadControl;
                    PlayerId playerId = exoPlayerImplInternal.playerId;
                    defaultLoadControl.getClass();
                    EmojiProcessor emojiProcessor = new EmojiProcessor(defaultLoadControl, playerId);
                    MediaSourceList mediaSourceList = exoPlayerImplInternal.mediaSourceList;
                    TrackSelectorResult trackSelectorResult3 = exoPlayerImplInternal.emptyTrackSelectorResult;
                    exoPlayerImplInternal.preloadConfiguration.getClass();
                    mediaPeriodHolder = new MediaPeriodHolder(baseRendererArr, j3, defaultTrackSelector, emojiProcessor, mediaSourceList, mediaPeriodInfo, trackSelectorResult3);
                } else {
                    mediaPeriodHolder.info = mediaPeriodInfo;
                    mediaPeriodHolder.rendererPositionOffsetUs = j3;
                }
                MediaPeriodHolder mediaPeriodHolder12 = mediaPeriodQueue3.loading;
                if (mediaPeriodHolder12 == null) {
                    mediaPeriodQueue3.playing = mediaPeriodHolder;
                    mediaPeriodQueue3.reading = mediaPeriodHolder;
                    mediaPeriodQueue3.prewarming = mediaPeriodHolder;
                } else if (mediaPeriodHolder != mediaPeriodHolder12.next) {
                    mediaPeriodHolder12.disableTrackSelectionsInResult();
                    mediaPeriodHolder12.next = mediaPeriodHolder;
                    mediaPeriodHolder12.enableTrackSelectionsInResult();
                }
                mediaPeriodQueue3.oldFrontPeriodUid = null;
                mediaPeriodQueue3.loading = mediaPeriodHolder;
                mediaPeriodQueue3.length++;
                mediaPeriodQueue3.notifyQueueUpdate();
                if (!mediaPeriodHolder.prepareCalled) {
                    long j6 = mediaPeriodInfo.startPositionUs;
                    mediaPeriodHolder.prepareCalled = true;
                    mediaPeriodHolder.mediaPeriod.prepare(this, j6);
                } else if (mediaPeriodHolder.prepared) {
                    this.handler.obtainMessage(8, mediaPeriodHolder.mediaPeriod).sendToTarget();
                }
                if (this.queue.playing == mediaPeriodHolder) {
                    resetRendererPosition(mediaPeriodInfo.startPositionUs, true);
                }
                handleLoadingMediaPeriodChanged(false);
            } else {
                j = -9223372036854775807L;
            }
        } else {
            j = -9223372036854775807L;
        }
        if (this.shouldContinueLoading) {
            this.shouldContinueLoading = isLoadingPossible(this.queue.loading);
            updateIsLoading();
        } else {
            maybeContinueLoading();
        }
        MediaPeriodQueue mediaPeriodQueue4 = this.queue;
        if (!this.pendingPauseAtEndOfPeriod && this.hasSecondaryRenderers && !this.isPrewarmingDisabledUntilNextTransition && !areRenderersPrewarming() && (mediaPeriodHolder7 = mediaPeriodQueue4.prewarming) != null && mediaPeriodHolder7 == mediaPeriodQueue4.reading && (mediaPeriodHolder8 = mediaPeriodHolder7.next) != null && (z3 = mediaPeriodHolder8.prepared)) {
            UtilsKt.checkState(z3);
            if (((long) ((mediaPeriodHolder8.getStartPositionRendererTime() - this.rendererPositionUs) / this.mediaClock.getPlaybackParameters().speed)) <= 10000000) {
                MediaPeriodHolder mediaPeriodHolder13 = mediaPeriodQueue4.prewarming;
                mediaPeriodHolder13.getClass();
                mediaPeriodQueue4.prewarming = mediaPeriodHolder13.next;
                mediaPeriodQueue4.notifyQueueUpdate();
                mediaPeriodQueue4.prewarming.getClass();
                RendererHolder[] rendererHolderArr = this.renderers;
                MediaPeriodHolder mediaPeriodHolder14 = mediaPeriodQueue4.prewarming;
                if (mediaPeriodHolder14 != null) {
                    TrackSelectorResult trackSelectorResult4 = mediaPeriodHolder14.trackSelectorResult;
                    for (int i6 = 0; i6 < rendererHolderArr.length; i6++) {
                        if (trackSelectorResult4.isRendererEnabled(i6)) {
                            RendererHolder rendererHolder = rendererHolderArr[i6];
                            if (rendererHolder.secondaryRenderer != null && !rendererHolder.isPrewarming()) {
                                RendererHolder rendererHolder2 = rendererHolderArr[i6];
                                UtilsKt.checkState(!rendererHolder2.isPrewarming());
                                if (RendererHolder.isRendererEnabled(rendererHolder2.primaryRenderer)) {
                                    i4 = 3;
                                } else {
                                    BaseRenderer baseRenderer3 = rendererHolder2.secondaryRenderer;
                                    i4 = (baseRenderer3 == null || baseRenderer3.state == 0) ? 2 : 4;
                                }
                                rendererHolder2.prewarmingState = i4;
                                enableRenderer(mediaPeriodHolder14, i6, false, mediaPeriodHolder14.getStartPositionRendererTime());
                            }
                        }
                    }
                    if (areRenderersPrewarming()) {
                        this.prewarmingMediaPeriodDiscontinuity = mediaPeriodHolder14.mediaPeriod.readDiscontinuity();
                        if (!mediaPeriodHolder14.isFullyBuffered()) {
                            mediaPeriodQueue4.removeAfter(mediaPeriodHolder14);
                            handleLoadingMediaPeriodChanged(false);
                            maybeContinueLoading();
                        }
                    }
                }
            }
        }
        boolean z4 = this.hasSecondaryRenderers;
        RendererHolder[] rendererHolderArr2 = this.renderers;
        MediaPeriodQueue mediaPeriodQueue5 = this.queue;
        MediaPeriodHolder mediaPeriodHolder15 = mediaPeriodQueue5.reading;
        if (mediaPeriodHolder15 != null) {
            if (mediaPeriodHolder15.next == null || this.pendingPauseAtEndOfPeriod) {
                if (mediaPeriodHolder15.info.isFinal || this.pendingPauseAtEndOfPeriod) {
                    for (RendererHolder rendererHolder3 : rendererHolderArr2) {
                        if (rendererHolder3.getRendererReadingFromPeriod(mediaPeriodHolder15) != null) {
                            BaseRenderer rendererReadingFromPeriod = rendererHolder3.getRendererReadingFromPeriod(mediaPeriodHolder15);
                            rendererReadingFromPeriod.getClass();
                            if (rendererReadingFromPeriod.hasReadStreamToEnd()) {
                                long j7 = mediaPeriodHolder15.info.durationUs;
                                long j8 = (j7 == -9223372036854775807L || j7 == Long.MIN_VALUE) ? -9223372036854775807L : j7 + mediaPeriodHolder15.rendererPositionOffsetUs;
                                BaseRenderer rendererReadingFromPeriod2 = rendererHolder3.getRendererReadingFromPeriod(mediaPeriodHolder15);
                                rendererReadingFromPeriod2.getClass();
                                RendererHolder.setCurrentStreamFinalInternal(rendererReadingFromPeriod2, j8);
                            }
                        }
                    }
                }
            } else if (mediaPeriodHolder15.prepared) {
                int i7 = 0;
                while (true) {
                    if (i7 >= rendererHolderArr2.length) {
                        if (!areRenderersPrewarming() || mediaPeriodQueue5.prewarming != mediaPeriodQueue5.reading) {
                            MediaPeriodHolder mediaPeriodHolder16 = mediaPeriodHolder15.next;
                            if (!mediaPeriodHolder16.prepared && this.rendererPositionUs < mediaPeriodHolder16.getStartPositionRendererTime()) {
                                break;
                            }
                            MediaPeriodHolder mediaPeriodHolder17 = mediaPeriodHolder15.next;
                            boolean z5 = mediaPeriodHolder17.prepared;
                            if (!z5) {
                                trackSelectorResult = mediaPeriodHolder15.trackSelectorResult;
                                mediaPeriodHolder4 = mediaPeriodQueue5.prewarming;
                                mediaPeriodHolder5 = mediaPeriodQueue5.reading;
                                if (mediaPeriodHolder4 == mediaPeriodHolder5) {
                                    mediaPeriodHolder5.getClass();
                                    mediaPeriodQueue5.prewarming = mediaPeriodHolder5.next;
                                }
                                MediaPeriodHolder mediaPeriodHolder18 = mediaPeriodQueue5.reading;
                                mediaPeriodHolder18.getClass();
                                mediaPeriodQueue5.reading = mediaPeriodHolder18.next;
                                mediaPeriodQueue5.notifyQueueUpdate();
                                mediaPeriodHolder6 = mediaPeriodQueue5.reading;
                                mediaPeriodHolder6.getClass();
                                trackSelectorResult2 = mediaPeriodHolder6.trackSelectorResult;
                                Timeline timeline = this.playbackInfo.timeline;
                                updatePlaybackSpeedSettingsForNewPeriod(timeline, mediaPeriodHolder6.info.id, timeline, mediaPeriodHolder15.info.id, -9223372036854775807L, false);
                                if (mediaPeriodHolder6.prepared) {
                                    length = rendererHolderArr2.length;
                                    for (i = 0; i < length; i++) {
                                        RendererHolder rendererHolder4 = rendererHolderArr2[i];
                                        long startPositionRendererTime = mediaPeriodHolder6.getStartPositionRendererTime();
                                        baseRenderer = rendererHolder4.primaryRenderer;
                                        int i8 = rendererHolder4.index;
                                        zIsRendererEnabled = trackSelectorResult.isRendererEnabled(i8);
                                        boolean zIsRendererEnabled2 = trackSelectorResult2.isRendererEnabled(i8);
                                        baseRenderer2 = rendererHolder4.secondaryRenderer;
                                        if (baseRenderer2 != null) {
                                            baseRenderer2 = baseRenderer;
                                        } else {
                                            baseRenderer2 = baseRenderer;
                                        }
                                        if (zIsRendererEnabled) {
                                            b = -2;
                                        } else {
                                            b = -2;
                                        }
                                    }
                                    break;
                                    break;
                                }
                                length = rendererHolderArr2.length;
                                while (i < length) {
                                    RendererHolder rendererHolder5 = rendererHolderArr2[i];
                                    long startPositionRendererTime2 = mediaPeriodHolder6.getStartPositionRendererTime();
                                    baseRenderer = rendererHolder5.primaryRenderer;
                                    int i9 = rendererHolder5.index;
                                    zIsRendererEnabled = trackSelectorResult.isRendererEnabled(i9);
                                    boolean zIsRendererEnabled3 = trackSelectorResult2.isRendererEnabled(i9);
                                    baseRenderer2 = rendererHolder5.secondaryRenderer;
                                    if (baseRenderer2 != null) {
                                        baseRenderer2 = baseRenderer;
                                    } else {
                                        baseRenderer2 = baseRenderer;
                                    }
                                    if (zIsRendererEnabled) {
                                        b = -2;
                                    } else {
                                        b = -2;
                                    }
                                }
                                break;
                                break;
                            }
                            UtilsKt.checkState(z5);
                            if (((long) ((mediaPeriodHolder17.getStartPositionRendererTime() - this.rendererPositionUs) / this.mediaClock.getPlaybackParameters().speed)) > 10000000) {
                                break;
                            }
                            trackSelectorResult = mediaPeriodHolder15.trackSelectorResult;
                            mediaPeriodHolder4 = mediaPeriodQueue5.prewarming;
                            mediaPeriodHolder5 = mediaPeriodQueue5.reading;
                            if (mediaPeriodHolder4 == mediaPeriodHolder5) {
                                mediaPeriodHolder5.getClass();
                                mediaPeriodQueue5.prewarming = mediaPeriodHolder5.next;
                            }
                            MediaPeriodHolder mediaPeriodHolder19 = mediaPeriodQueue5.reading;
                            mediaPeriodHolder19.getClass();
                            mediaPeriodQueue5.reading = mediaPeriodHolder19.next;
                            mediaPeriodQueue5.notifyQueueUpdate();
                            mediaPeriodHolder6 = mediaPeriodQueue5.reading;
                            mediaPeriodHolder6.getClass();
                            trackSelectorResult2 = mediaPeriodHolder6.trackSelectorResult;
                            Timeline timeline2 = this.playbackInfo.timeline;
                            updatePlaybackSpeedSettingsForNewPeriod(timeline2, mediaPeriodHolder6.info.id, timeline2, mediaPeriodHolder15.info.id, -9223372036854775807L, false);
                            if (mediaPeriodHolder6.prepared && ((z4 && this.prewarmingMediaPeriodDiscontinuity != j) || mediaPeriodHolder6.mediaPeriod.readDiscontinuity() != j)) {
                                this.prewarmingMediaPeriodDiscontinuity = j;
                                boolean z6 = z4 && !this.isPrewarmingDisabledUntilNextTransition;
                                if (z6) {
                                    for (int i10 = 0; i10 < rendererHolderArr2.length; i10++) {
                                        boolean zIsRendererEnabled4 = trackSelectorResult2.isRendererEnabled(i10);
                                        ExoTrackSelection[] exoTrackSelectionArr = trackSelectorResult2.selections;
                                        if (zIsRendererEnabled4 && rendererHolderArr2[i10].primaryRenderer.trackType != -2 && !MimeTypes.allSamplesAreSyncSamples(exoTrackSelectionArr[i10].getSelectedFormat().sampleMimeType, exoTrackSelectionArr[i10].getSelectedFormat().codecs) && !rendererHolderArr2[i10].isPrewarming()) {
                                            z6 = false;
                                            break;
                                        }
                                    }
                                }
                                if (!z6) {
                                    long startPositionRendererTime3 = mediaPeriodHolder6.getStartPositionRendererTime();
                                    for (RendererHolder rendererHolder6 : rendererHolderArr2) {
                                        BaseRenderer baseRenderer4 = rendererHolder6.secondaryRenderer;
                                        BaseRenderer baseRenderer5 = rendererHolder6.primaryRenderer;
                                        if (RendererHolder.isRendererEnabled(baseRenderer5) && (i3 = rendererHolder6.prewarmingState) != 4 && i3 != 2) {
                                            RendererHolder.setCurrentStreamFinalInternal(baseRenderer5, startPositionRendererTime3);
                                        }
                                        if (baseRenderer4 != null && baseRenderer4.state != 0 && rendererHolder6.prewarmingState != 3) {
                                            RendererHolder.setCurrentStreamFinalInternal(baseRenderer4, startPositionRendererTime3);
                                        }
                                    }
                                    if (!mediaPeriodHolder6.isFullyBuffered()) {
                                        mediaPeriodQueue5.removeAfter(mediaPeriodHolder6);
                                        handleLoadingMediaPeriodChanged(false);
                                        maybeContinueLoading();
                                        break;
                                    }
                                    break;
                                }
                                length = rendererHolderArr2.length;
                                while (i < length) {
                                    RendererHolder rendererHolder7 = rendererHolderArr2[i];
                                    long startPositionRendererTime4 = mediaPeriodHolder6.getStartPositionRendererTime();
                                    baseRenderer = rendererHolder7.primaryRenderer;
                                    int i11 = rendererHolder7.index;
                                    zIsRendererEnabled = trackSelectorResult.isRendererEnabled(i11);
                                    boolean zIsRendererEnabled5 = trackSelectorResult2.isRendererEnabled(i11);
                                    baseRenderer2 = rendererHolder7.secondaryRenderer;
                                    if (baseRenderer2 != null) {
                                        baseRenderer2 = baseRenderer;
                                    } else {
                                        baseRenderer2 = baseRenderer;
                                    }
                                    if (zIsRendererEnabled) {
                                        b = -2;
                                    } else {
                                        b = -2;
                                    }
                                }
                                break;
                                break;
                            }
                            length = rendererHolderArr2.length;
                            while (i < length) {
                                RendererHolder rendererHolder8 = rendererHolderArr2[i];
                                long startPositionRendererTime5 = mediaPeriodHolder6.getStartPositionRendererTime();
                                baseRenderer = rendererHolder8.primaryRenderer;
                                int i12 = rendererHolder8.index;
                                zIsRendererEnabled = trackSelectorResult.isRendererEnabled(i12);
                                boolean zIsRendererEnabled6 = trackSelectorResult2.isRendererEnabled(i12);
                                baseRenderer2 = rendererHolder8.secondaryRenderer;
                                if (baseRenderer2 != null || (i2 = rendererHolder8.prewarmingState) == 3 || (i2 == 0 && RendererHolder.isRendererEnabled(baseRenderer))) {
                                    baseRenderer2 = baseRenderer;
                                }
                                if (zIsRendererEnabled || baseRenderer2.streamIsFinal) {
                                    b = -2;
                                } else {
                                    byte b2 = baseRenderer.trackType;
                                    b = -2;
                                    boolean z7 = b2 == -2;
                                    RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i12];
                                    RendererConfiguration rendererConfiguration2 = trackSelectorResult2.rendererConfigurations[i12];
                                    if (!zIsRendererEnabled6 || !Objects.equals(rendererConfiguration2, rendererConfiguration) || z7 || rendererHolder8.isPrewarming()) {
                                        RendererHolder.setCurrentStreamFinalInternal(baseRenderer2, startPositionRendererTime5);
                                    }
                                }
                            }
                            break;
                        }
                        break;
                    }
                    RendererHolder rendererHolder9 = rendererHolderArr2[i7];
                    if (!rendererHolder9.hasFinishedReadingFromPeriodInternal(mediaPeriodHolder15, rendererHolder9.primaryRenderer) || !rendererHolder9.hasFinishedReadingFromPeriodInternal(mediaPeriodHolder15, rendererHolder9.secondaryRenderer)) {
                        break;
                    } else {
                        i7++;
                    }
                }
            }
        }
        MediaPeriodQueue mediaPeriodQueue6 = this.queue;
        MediaPeriodHolder mediaPeriodHolder20 = mediaPeriodQueue6.reading;
        if (mediaPeriodHolder20 != null && mediaPeriodQueue6.playing != mediaPeriodHolder20 && !mediaPeriodHolder20.allRenderersInCorrectState) {
            RendererHolder[] rendererHolderArr3 = this.renderers;
            TrackSelectorResult trackSelectorResult5 = mediaPeriodHolder20.trackSelectorResult;
            boolean z8 = true;
            for (int i13 = 0; i13 < rendererHolderArr3.length; i13++) {
                int enabledRendererCount = rendererHolderArr3[i13].getEnabledRendererCount();
                RendererHolder rendererHolder10 = rendererHolderArr3[i13];
                DefaultMediaClock defaultMediaClock = this.mediaClock;
                int iReplaceStreamsOrDisableRendererForTransitionInternal = rendererHolder10.replaceStreamsOrDisableRendererForTransitionInternal(rendererHolder10.primaryRenderer, mediaPeriodHolder20, trackSelectorResult5, defaultMediaClock);
                int iReplaceStreamsOrDisableRendererForTransitionInternal2 = rendererHolder10.replaceStreamsOrDisableRendererForTransitionInternal(rendererHolder10.secondaryRenderer, mediaPeriodHolder20, trackSelectorResult5, defaultMediaClock);
                if (iReplaceStreamsOrDisableRendererForTransitionInternal == 1) {
                    iReplaceStreamsOrDisableRendererForTransitionInternal = iReplaceStreamsOrDisableRendererForTransitionInternal2;
                }
                if ((iReplaceStreamsOrDisableRendererForTransitionInternal & 2) != 0 && (z2 = this.offloadSchedulingEnabled) && z2) {
                    this.offloadSchedulingEnabled = false;
                    if (this.playbackInfo.sleepingForOffload) {
                        this.handler.sendEmptyMessage(2);
                    }
                }
                this.enabledRendererCount -= enabledRendererCount - rendererHolderArr3[i13].getEnabledRendererCount();
                z8 &= (iReplaceStreamsOrDisableRendererForTransitionInternal & 1) != 0;
            }
            if (z8) {
                for (int i14 = 0; i14 < rendererHolderArr3.length; i14++) {
                    if (trackSelectorResult5.isRendererEnabled(i14) && rendererHolderArr3[i14].getRendererReadingFromPeriod(mediaPeriodHolder20) == null) {
                        enableRenderer(mediaPeriodHolder20, i14, false, mediaPeriodHolder20.getStartPositionRendererTime());
                    }
                }
            }
            if (z8) {
                mediaPeriodQueue6.reading.allRenderersInCorrectState = true;
            }
        }
        RendererHolder[] rendererHolderArr4 = this.renderers;
        MediaPeriodQueue mediaPeriodQueue7 = this.queue;
        boolean z9 = false;
        while (shouldPlayWhenReady() && !this.pendingPauseAtEndOfPeriod && (mediaPeriodHolder2 = mediaPeriodQueue7.playing) != null && (mediaPeriodHolder3 = mediaPeriodHolder2.next) != null && this.rendererPositionUs >= mediaPeriodHolder3.getStartPositionRendererTime() && mediaPeriodHolder3.allRenderersInCorrectState) {
            if (z9) {
                maybeNotifyPlaybackInfoChanged();
            }
            this.isPrewarmingDisabledUntilNextTransition = false;
            MediaPeriodHolder mediaPeriodHolderAdvancePlayingPeriod = mediaPeriodQueue7.advancePlayingPeriod();
            mediaPeriodHolderAdvancePlayingPeriod.getClass();
            if (this.playbackInfo.periodId.periodUid.equals(mediaPeriodHolderAdvancePlayingPeriod.info.id.periodUid)) {
                MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.playbackInfo.periodId;
                if (mediaSource$MediaPeriodId.adGroupIndex == -1) {
                    MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = mediaPeriodHolderAdvancePlayingPeriod.info.id;
                    if (mediaSource$MediaPeriodId2.adGroupIndex != -1 || mediaSource$MediaPeriodId.nextAdGroupIndex == mediaSource$MediaPeriodId2.nextAdGroupIndex) {
                        z = false;
                    } else {
                        z = true;
                    }
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            MediaPeriodInfo mediaPeriodInfo3 = mediaPeriodHolderAdvancePlayingPeriod.info;
            boolean z10 = z;
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId3 = mediaPeriodInfo3.id;
            long j9 = mediaPeriodInfo3.startPositionUs;
            this.playbackInfo = handlePositionDiscontinuity(mediaSource$MediaPeriodId3, j9, mediaPeriodInfo3.requestedContentPositionUs, j9, !z10, 0);
            resetPendingPauseAtEndOfPeriod();
            updatePlaybackPositions();
            if (areRenderersPrewarming() && mediaPeriodHolderAdvancePlayingPeriod == mediaPeriodQueue7.prewarming) {
                for (RendererHolder rendererHolder11 : rendererHolderArr4) {
                    int i15 = rendererHolder11.prewarmingState;
                    if (i15 == 3 || i15 == 4) {
                        boolean z11 = i15 == 4;
                        BaseRenderer baseRenderer6 = rendererHolder11.primaryRenderer;
                        BaseRenderer baseRenderer7 = rendererHolder11.secondaryRenderer;
                        if (z11) {
                            baseRenderer7.getClass();
                            baseRenderer7.handleMessage(17, baseRenderer6);
                        } else {
                            baseRenderer7.getClass();
                            baseRenderer6.handleMessage(17, baseRenderer7);
                        }
                        rendererHolder11.prewarmingState = rendererHolder11.prewarmingState == 4 ? 0 : 1;
                    } else if (i15 == 2) {
                        rendererHolder11.prewarmingState = 0;
                    }
                }
            }
            if (this.playbackInfo.playbackState == 3) {
                startRenderers();
            }
            TrackSelectorResult trackSelectorResult6 = mediaPeriodQueue7.playing.trackSelectorResult;
            for (int i16 = 0; i16 < rendererHolderArr4.length; i16++) {
                if (trackSelectorResult6.isRendererEnabled(i16)) {
                    RendererHolder rendererHolder12 = rendererHolderArr4[i16];
                    BaseRenderer baseRenderer8 = rendererHolder12.secondaryRenderer;
                    BaseRenderer baseRenderer9 = rendererHolder12.primaryRenderer;
                    if (RendererHolder.isRendererEnabled(baseRenderer9)) {
                        baseRenderer9.enableMayRenderStartOfStream();
                    } else if (baseRenderer8 != null && baseRenderer8.state != 0) {
                        baseRenderer8.enableMayRenderStartOfStream();
                    }
                }
            }
            z9 = true;
        }
        this.preloadConfiguration.getClass();
    }

    public final void updatePlayWhenReadyWithAudioFocus(int i, int i2, int i3, boolean z) {
        boolean z2 = z && i != -1;
        if (i == -1) {
            i3 = 2;
        } else if (i3 == 2) {
            i3 = 1;
        }
        boolean z3 = this.scrubbingModeEnabled;
        if (i == 0) {
            i2 = 1;
        } else if (i2 == 1) {
            i2 = z3 ? 4 : 0;
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (playbackInfo.playWhenReady == z2 && playbackInfo.playbackSuppressionReason == i2 && playbackInfo.playWhenReadyChangeReason == i3) {
            return;
        }
        this.playbackInfo = playbackInfo.copyWithPlayWhenReady(i3, z2, i2);
        updateRebufferingState(false, false);
        MediaPeriodQueue mediaPeriodQueue = this.queue;
        for (MediaPeriodHolder mediaPeriodHolder = mediaPeriodQueue.playing; mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.next) {
            for (ExoTrackSelection exoTrackSelection : mediaPeriodHolder.trackSelectorResult.selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onPlayWhenReadyChanged(z2);
                }
            }
        }
        if (!shouldPlayWhenReady()) {
            stopRenderers();
            updatePlaybackPositions();
            PlaybackInfo playbackInfo2 = this.playbackInfo;
            if (playbackInfo2.sleepingForOffload) {
                this.playbackInfo = playbackInfo2.copyWithSleepingForOffload(false);
            }
            mediaPeriodQueue.reevaluateBuffer(this.rendererPositionUs);
            return;
        }
        int i4 = this.playbackInfo.playbackState;
        SystemHandlerWrapper systemHandlerWrapper = this.handler;
        if (i4 != 3) {
            if (i4 == 2) {
                systemHandlerWrapper.sendEmptyMessage(2);
            }
        } else {
            DefaultMediaClock defaultMediaClock = this.mediaClock;
            defaultMediaClock.standaloneClockIsStarted = true;
            ((StandaloneMediaClock) defaultMediaClock.standaloneClock).start();
            startRenderers();
            systemHandlerWrapper.sendEmptyMessage(2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00ce  */
    public final void updatePlaybackPositions() {
        long j;
        PlaybackParameters playbackParameters;
        long j2;
        float f;
        long jConstrainValue;
        MediaPeriodHolder mediaPeriodHolder = this.queue.playing;
        if (mediaPeriodHolder == null) {
            return;
        }
        long j3 = -9223372036854775807L;
        long discontinuity = mediaPeriodHolder.prepared ? mediaPeriodHolder.mediaPeriod.readDiscontinuity() : -9223372036854775807L;
        if (discontinuity != -9223372036854775807L) {
            if (!mediaPeriodHolder.isFullyBuffered()) {
                this.queue.removeAfter(mediaPeriodHolder);
                handleLoadingMediaPeriodChanged(false);
                maybeContinueLoading();
            }
            resetRendererPosition(discontinuity, true);
            if (discontinuity != this.playbackInfo.positionUs) {
                PlaybackInfo playbackInfo = this.playbackInfo;
                this.playbackInfo = handlePositionDiscontinuity(playbackInfo.periodId, discontinuity, playbackInfo.requestedContentPositionUs, discontinuity, true, 5);
            }
            j = -9223372036854775807L;
        } else {
            DefaultMediaClock defaultMediaClock = this.mediaClock;
            boolean z = mediaPeriodHolder != this.queue.reading;
            StandaloneMediaClock standaloneMediaClock = (StandaloneMediaClock) defaultMediaClock.standaloneClock;
            BaseRenderer baseRenderer = (BaseRenderer) defaultMediaClock.rendererClockSource;
            if (baseRenderer == null || baseRenderer.isEnded() || ((z && ((BaseRenderer) defaultMediaClock.rendererClockSource).state != 2) || (!((BaseRenderer) defaultMediaClock.rendererClockSource).isReady() && (z || ((BaseRenderer) defaultMediaClock.rendererClockSource).hasReadStreamToEnd())))) {
                defaultMediaClock.isUsingStandaloneClock = true;
                if (defaultMediaClock.standaloneClockIsStarted) {
                    standaloneMediaClock.start();
                }
            } else {
                MediaClock mediaClock = (MediaClock) defaultMediaClock.rendererClock;
                mediaClock.getClass();
                long positionUs = mediaClock.getPositionUs();
                if (!defaultMediaClock.isUsingStandaloneClock) {
                    standaloneMediaClock.resetPosition(positionUs);
                    playbackParameters = mediaClock.getPlaybackParameters();
                    if (!playbackParameters.equals(standaloneMediaClock.playbackParameters)) {
                        standaloneMediaClock.setPlaybackParameters(playbackParameters);
                        ((ExoPlayerImplInternal) defaultMediaClock.listener).handler.obtainMessage(16, playbackParameters).sendToTarget();
                    }
                } else if (positionUs >= standaloneMediaClock.getPositionUs()) {
                    defaultMediaClock.isUsingStandaloneClock = false;
                    if (defaultMediaClock.standaloneClockIsStarted) {
                        standaloneMediaClock.start();
                    }
                    standaloneMediaClock.resetPosition(positionUs);
                    playbackParameters = mediaClock.getPlaybackParameters();
                    if (!playbackParameters.equals(standaloneMediaClock.playbackParameters)) {
                        standaloneMediaClock.setPlaybackParameters(playbackParameters);
                        ((ExoPlayerImplInternal) defaultMediaClock.listener).handler.obtainMessage(16, playbackParameters).sendToTarget();
                    }
                } else if (standaloneMediaClock.started) {
                    standaloneMediaClock.resetPosition(standaloneMediaClock.getPositionUs());
                    standaloneMediaClock.started = false;
                }
            }
            long positionUs2 = defaultMediaClock.getPositionUs();
            this.rendererPositionUs = positionUs2;
            long j4 = positionUs2 - mediaPeriodHolder.rendererPositionOffsetUs;
            long j5 = this.playbackInfo.positionUs;
            ArrayList arrayList = this.pendingMessages;
            if (arrayList.isEmpty() || this.playbackInfo.periodId.isAd()) {
                j = -9223372036854775807L;
            } else {
                if (this.deliverPendingMessageAtStartPositionRequired) {
                    j5--;
                    this.deliverPendingMessageAtStartPositionRequired = false;
                }
                PlaybackInfo playbackInfo2 = this.playbackInfo;
                int indexOfPeriod = playbackInfo2.timeline.getIndexOfPeriod(playbackInfo2.periodId.periodUid);
                int iMin = Math.min(this.nextPendingMessageIndexHint, arrayList.size());
                PendingMessageInfo pendingMessageInfo = iMin > 0 ? (PendingMessageInfo) arrayList.get(iMin - 1) : null;
                while (pendingMessageInfo != null) {
                    int i = pendingMessageInfo.resolvedPeriodIndex;
                    if (i <= indexOfPeriod && (i != indexOfPeriod || pendingMessageInfo.resolvedPeriodTimeUs <= j5)) {
                        break;
                    }
                    int i2 = iMin - 1;
                    pendingMessageInfo = i2 > 0 ? (PendingMessageInfo) arrayList.get(iMin - 2) : null;
                    iMin = i2;
                }
                PendingMessageInfo pendingMessageInfo2 = iMin < arrayList.size() ? (PendingMessageInfo) arrayList.get(iMin) : null;
                while (true) {
                    if (pendingMessageInfo2 != null && pendingMessageInfo2.resolvedPeriodUid != null) {
                        int i3 = pendingMessageInfo2.resolvedPeriodIndex;
                        if (i3 < indexOfPeriod) {
                            j = j3;
                        } else if (i3 == indexOfPeriod) {
                            j = j3;
                            if (pendingMessageInfo2.resolvedPeriodTimeUs > j5) {
                                break;
                            }
                        }
                        iMin++;
                        pendingMessageInfo2 = iMin < arrayList.size() ? (PendingMessageInfo) arrayList.get(iMin) : null;
                        j3 = j;
                    }
                    j = j3;
                    break;
                }
                while (pendingMessageInfo2 != null) {
                    PlayerMessage playerMessage = pendingMessageInfo2.message;
                    if (pendingMessageInfo2.resolvedPeriodUid == null || pendingMessageInfo2.resolvedPeriodIndex != indexOfPeriod) {
                        break;
                    }
                    long j6 = pendingMessageInfo2.resolvedPeriodTimeUs;
                    if (j6 <= j5 || j6 > j4) {
                        break;
                    }
                    try {
                        sendMessageToTarget(playerMessage);
                        arrayList.remove(iMin);
                        pendingMessageInfo2 = iMin < arrayList.size() ? (PendingMessageInfo) arrayList.get(iMin) : null;
                    } catch (Throwable th) {
                        playerMessage.getClass();
                        arrayList.remove(iMin);
                        throw th;
                    }
                }
                this.nextPendingMessageIndexHint = iMin;
            }
            if (this.mediaClock.hasSkippedSilenceSinceLastCall()) {
                boolean z2 = !this.playbackInfoUpdate.positionDiscontinuity;
                PlaybackInfo playbackInfo3 = this.playbackInfo;
                this.playbackInfo = handlePositionDiscontinuity(playbackInfo3.periodId, j4, playbackInfo3.requestedContentPositionUs, j4, z2, 6);
            } else {
                PlaybackInfo playbackInfo4 = this.playbackInfo;
                playbackInfo4.positionUs = j4;
                playbackInfo4.positionUpdateTimeMs = android.os.SystemClock.elapsedRealtime();
            }
        }
        this.playbackInfo.bufferedPositionUs = this.queue.loading.getBufferedPositionUs();
        PlaybackInfo playbackInfo5 = this.playbackInfo;
        playbackInfo5.totalBufferedDurationUs = getTotalBufferedDurationUs(playbackInfo5.bufferedPositionUs);
        PlaybackInfo playbackInfo6 = this.playbackInfo;
        if (playbackInfo6.playWhenReady && playbackInfo6.playbackState == 3 && shouldUseLivePlaybackSpeedControl(playbackInfo6.timeline, playbackInfo6.periodId)) {
            PlaybackInfo playbackInfo7 = this.playbackInfo;
            float fConstrainValue = 1.0f;
            if (playbackInfo7.playbackParameters.speed == 1.0f) {
                DefaultLivePlaybackSpeedControl defaultLivePlaybackSpeedControl = this.livePlaybackSpeedControl;
                long liveOffsetUs = getLiveOffsetUs(playbackInfo7.timeline, playbackInfo7.periodId.periodUid, playbackInfo7.positionUs);
                long j7 = this.playbackInfo.totalBufferedDurationUs;
                if (defaultLivePlaybackSpeedControl.mediaConfigurationTargetLiveOffsetUs != j) {
                    long j8 = liveOffsetUs - j7;
                    long j9 = defaultLivePlaybackSpeedControl.smoothedMinPossibleLiveOffsetUs;
                    if (j9 == j) {
                        defaultLivePlaybackSpeedControl.smoothedMinPossibleLiveOffsetUs = j8;
                        defaultLivePlaybackSpeedControl.smoothedMinPossibleLiveOffsetDeviationUs = 0L;
                    } else {
                        long jMax = Math.max(j8, (long) ((j8 * 9.999871E-4f) + (j9 * 0.999f)));
                        defaultLivePlaybackSpeedControl.smoothedMinPossibleLiveOffsetUs = jMax;
                        defaultLivePlaybackSpeedControl.smoothedMinPossibleLiveOffsetDeviationUs = (long) ((9.999871E-4f * Math.abs(j8 - jMax)) + (defaultLivePlaybackSpeedControl.smoothedMinPossibleLiveOffsetDeviationUs * 0.999f));
                    }
                    if (defaultLivePlaybackSpeedControl.lastPlaybackSpeedUpdateMs != j) {
                        j2 = 1000;
                        if (android.os.SystemClock.elapsedRealtime() - defaultLivePlaybackSpeedControl.lastPlaybackSpeedUpdateMs < 1000) {
                            fConstrainValue = defaultLivePlaybackSpeedControl.adjustedPlaybackSpeed;
                        }
                    } else {
                        j2 = 1000;
                    }
                    defaultLivePlaybackSpeedControl.lastPlaybackSpeedUpdateMs = android.os.SystemClock.elapsedRealtime();
                    long j10 = (defaultLivePlaybackSpeedControl.smoothedMinPossibleLiveOffsetDeviationUs * 3) + defaultLivePlaybackSpeedControl.smoothedMinPossibleLiveOffsetUs;
                    if (defaultLivePlaybackSpeedControl.currentTargetLiveOffsetUs > j10) {
                        float fMsToUs = Util.msToUs(j2);
                        f = 1.0E-7f;
                        long[] jArr = {j10, defaultLivePlaybackSpeedControl.idealTargetLiveOffsetUs, defaultLivePlaybackSpeedControl.currentTargetLiveOffsetUs - (((long) ((defaultLivePlaybackSpeedControl.adjustedPlaybackSpeed - 1.0f) * fMsToUs)) + ((long) ((defaultLivePlaybackSpeedControl.maxPlaybackSpeed - 1.0f) * fMsToUs)))};
                        jConstrainValue = jArr[0];
                        for (int i4 = 1; i4 < 3; i4++) {
                            long j11 = jArr[i4];
                            if (j11 > jConstrainValue) {
                                jConstrainValue = j11;
                            }
                        }
                        defaultLivePlaybackSpeedControl.currentTargetLiveOffsetUs = jConstrainValue;
                    } else {
                        f = 1.0E-7f;
                        jConstrainValue = Util.constrainValue(liveOffsetUs - ((long) (Math.max(CropImageView.DEFAULT_ASPECT_RATIO, defaultLivePlaybackSpeedControl.adjustedPlaybackSpeed - 1.0f) / 1.0E-7f)), defaultLivePlaybackSpeedControl.currentTargetLiveOffsetUs, j10);
                        defaultLivePlaybackSpeedControl.currentTargetLiveOffsetUs = jConstrainValue;
                        long j12 = defaultLivePlaybackSpeedControl.maxTargetLiveOffsetUs;
                        if (j12 != j && jConstrainValue > j12) {
                            defaultLivePlaybackSpeedControl.currentTargetLiveOffsetUs = j12;
                            jConstrainValue = j12;
                        }
                    }
                    long j13 = liveOffsetUs - jConstrainValue;
                    if (Math.abs(j13) < defaultLivePlaybackSpeedControl.maxLiveOffsetErrorUsForUnitSpeed) {
                        defaultLivePlaybackSpeedControl.adjustedPlaybackSpeed = 1.0f;
                    } else {
                        fConstrainValue = Util.constrainValue((f * j13) + 1.0f, defaultLivePlaybackSpeedControl.minPlaybackSpeed, defaultLivePlaybackSpeedControl.maxPlaybackSpeed);
                        defaultLivePlaybackSpeedControl.adjustedPlaybackSpeed = fConstrainValue;
                    }
                }
                if (this.mediaClock.getPlaybackParameters().speed != fConstrainValue) {
                    PlaybackParameters playbackParameters2 = new PlaybackParameters(fConstrainValue, this.playbackInfo.playbackParameters.pitch);
                    this.handler.removeMessages(16);
                    this.mediaClock.setPlaybackParameters(playbackParameters2);
                    handlePlaybackParameters(this.playbackInfo.playbackParameters, this.mediaClock.getPlaybackParameters().speed, false, false);
                }
            }
        }
    }

    public final void updatePlaybackSpeedSettingsForNewPeriod(Timeline timeline, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Timeline timeline2, MediaSource$MediaPeriodId mediaSource$MediaPeriodId2, long j, boolean z) {
        boolean zShouldUseLivePlaybackSpeedControl = shouldUseLivePlaybackSpeedControl(timeline, mediaSource$MediaPeriodId);
        Object obj = mediaSource$MediaPeriodId.periodUid;
        if (!zShouldUseLivePlaybackSpeedControl) {
            PlaybackParameters playbackParameters = mediaSource$MediaPeriodId.isAd() ? PlaybackParameters.DEFAULT : this.playbackInfo.playbackParameters;
            DefaultMediaClock defaultMediaClock = this.mediaClock;
            if (defaultMediaClock.getPlaybackParameters().equals(playbackParameters)) {
                return;
            }
            this.handler.removeMessages(16);
            defaultMediaClock.setPlaybackParameters(playbackParameters);
            handlePlaybackParameters(this.playbackInfo.playbackParameters, playbackParameters.speed, false, false);
            return;
        }
        Timeline.Period period = this.period;
        int i = timeline.getPeriodByUid(obj, period).windowIndex;
        Timeline.Window window = this.window;
        timeline.getWindow(i, window);
        MediaItem.LiveConfiguration liveConfiguration = window.liveConfiguration;
        String str = Util.DEVICE_DEBUG_INFO;
        long jMsToUs = Util.msToUs(liveConfiguration.targetOffsetMs);
        DefaultLivePlaybackSpeedControl defaultLivePlaybackSpeedControl = this.livePlaybackSpeedControl;
        defaultLivePlaybackSpeedControl.mediaConfigurationTargetLiveOffsetUs = jMsToUs;
        defaultLivePlaybackSpeedControl.minTargetLiveOffsetUs = Util.msToUs(liveConfiguration.minOffsetMs);
        defaultLivePlaybackSpeedControl.maxTargetLiveOffsetUs = Util.msToUs(liveConfiguration.maxOffsetMs);
        float f = liveConfiguration.minPlaybackSpeed;
        if (f == -3.4028235E38f) {
            f = 0.97f;
        }
        defaultLivePlaybackSpeedControl.minPlaybackSpeed = f;
        float f2 = liveConfiguration.maxPlaybackSpeed;
        if (f2 == -3.4028235E38f) {
            f2 = 1.03f;
        }
        defaultLivePlaybackSpeedControl.maxPlaybackSpeed = f2;
        if (f == 1.0f && f2 == 1.0f) {
            defaultLivePlaybackSpeedControl.mediaConfigurationTargetLiveOffsetUs = -9223372036854775807L;
        }
        defaultLivePlaybackSpeedControl.maybeResetTargetLiveOffsetUs();
        if (j != -9223372036854775807L) {
            defaultLivePlaybackSpeedControl.targetLiveOffsetOverrideUs = getLiveOffsetUs(timeline, obj, j);
            defaultLivePlaybackSpeedControl.maybeResetTargetLiveOffsetUs();
            return;
        }
        if (!Objects.equals(!timeline2.isEmpty() ? timeline2.getWindow(timeline2.getPeriodByUid(mediaSource$MediaPeriodId2.periodUid, period).windowIndex, window, 0L).uid : null, window.uid) || z) {
            defaultLivePlaybackSpeedControl.targetLiveOffsetOverrideUs = -9223372036854775807L;
            defaultLivePlaybackSpeedControl.maybeResetTargetLiveOffsetUs();
        }
    }

    public final void updateRebufferingState(boolean z, boolean z2) {
        this.isRebuffering = z;
        this.lastRebufferRealtimeMs = (!z || z2) ? -9223372036854775807L : android.os.SystemClock.elapsedRealtime();
    }
}
