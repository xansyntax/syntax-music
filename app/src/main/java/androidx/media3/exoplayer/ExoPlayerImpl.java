package androidx.media3.exoplayer;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseBooleanArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda10;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Latch;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.RulerTrackingMap;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.provider.CallbackWrapper;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import androidx.datastore.core.AtomicInt;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Format;
import androidx.media3.common.Format$$ExternalSyntheticLambda1;
import androidx.media3.common.IllegalSeekPositionException;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Rating;
import androidx.media3.common.Timeline;
import androidx.media3.common.Timeline$$ExternalSyntheticLambda0;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.StuckPlayerDetector$1;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.SystemHandlerWrapper;
import androidx.media3.common.util.Util;
import androidx.media3.common.util.Util$$ExternalSyntheticLambda1;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector$$ExternalSyntheticLambda0;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.BaseMediaSource;
import androidx.media3.exoplayer.source.MaskingMediaSource;
import androidx.media3.exoplayer.source.MediaSource$Factory;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import androidx.media3.exoplayer.source.ShuffleOrder$DefaultShuffleOrder;
import androidx.media3.exoplayer.source.TimelineWithUpdatedMediaItem;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import androidx.media3.exoplayer.upstream.BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.exoplayer.video.VideoFrameMetadataListener;
import androidx.media3.session.MediaControllerHolder$$ExternalSyntheticLambda1;
import coil3.network.HttpException;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps$$ExternalSyntheticLambda1;
import com.google.common.collect.RegularImmutableList;
import com.yalantis.ucrop.UCropActivity$$ExternalSyntheticLambda1;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.IntConsumer;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.connection.Exchange;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ExoPlayerImpl implements Player {
    public final DefaultAnalyticsCollector analyticsCollector;
    public final Context applicationContext;
    public final Looper applicationLooper;
    public AudioAttributes audioAttributes;
    public final Latch audioBecomingNoisyManager;
    public final CallbackWrapper audioListenerManager;
    public final CopyOnWriteArraySet audioOffloadListeners;
    public final RulerTrackingMap audioSessionIdState;
    public Player.Commands availableCommands;
    public final DefaultBandwidthMeter bandwidthMeter;
    public final SystemClock clock;
    public final ComponentListener componentListener;
    public final ConditionVariable constructorFinished;
    public CueGroup currentCueGroup;
    public final short detachSurfaceTimeoutMs;
    public DeviceInfo deviceInfo;
    public final TrackSelectorResult emptyTrackSelectorResult;
    public final FrameMetadataListener frameMetadataListener;
    public boolean hasNotifiedFullWrongThreadWarning;
    public final ExoPlayerImplInternal internalPlayer;
    public final ListenerSet listeners;
    public int maskingWindowIndex;
    public long maskingWindowPositionMs;
    public final short maxSeekToPreviousPositionMs;
    public MediaMetadata mediaMetadata;
    public final MediaSource$Factory mediaSourceFactory;
    public final ArrayList mediaSourceHolderSnapshots;
    public Surface ownedSurface;
    public boolean pendingDiscontinuity;
    public int pendingDiscontinuityReason;
    public int pendingOperationAcks;
    public final Timeline.Period period;
    public final Player.Commands permanentAvailableCommands;
    public PlaybackInfo playbackInfo;
    public final SystemHandlerWrapper playbackInfoUpdateHandler;
    public final ExoPlayerImpl$$ExternalSyntheticLambda20 playbackInfoUpdateListener;
    public boolean playerReleased;
    public MediaMetadata playlistMetadata;
    public final int priority;
    public final BaseRenderer[] renderers;
    public int repeatMode;
    public final ScrubbingModeParameters scrubbingModeParameters;
    public final BaseRenderer[] secondaryRenderers;
    public final short seekBackIncrementMs;
    public final short seekForwardIncrementMs;
    public boolean shuffleModeEnabled;
    public ShuffleOrder$DefaultShuffleOrder shuffleOrder;
    public boolean skipSilenceEnabled;
    public MediaMetadata staticAndDynamicMediaMetadata;
    public final RulerTrackingMap streamVolumeManager;
    public final NodeChain stuckPlayerDetector;
    public SurfaceHolder surfaceHolder;
    public boolean surfaceHolderSurfaceIsVideoOutput;
    public Size surfaceSize;
    public TextureView textureView;
    public final boolean throwsWhenUsingWrongThread;
    public final DefaultTrackSelector trackSelector;
    public float unmuteVolume;
    public final boolean useLazyPreparation;
    public final CallbackWrapper videoListenerManager;
    public Object videoOutput;
    public final boolean videoScalingMode;
    public VideoSize videoSize;
    public final VirtualDeviceIdChangeListener virtualDeviceIdChangeListener;
    public float volume;
    public final Exchange wakeLockManager;
    public final Exchange wifiLockManager;
    public final Timeline.Window window;
    public final ExoPlayerImpl wrappingPlayer;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class FrameMetadataListener implements VideoFrameMetadataListener, PlayerMessage.Target {
        public FrameMetadataListener cameraMotionListener;
        public VideoFrameMetadataListener videoFrameMetadataListener;

        @Override // androidx.media3.exoplayer.PlayerMessage.Target
        public final void handleMessage(int i, Object obj) {
            if (i == 7) {
                this.videoFrameMetadataListener = (VideoFrameMetadataListener) obj;
                return;
            }
            if (i == 8) {
                this.cameraMotionListener = (FrameMetadataListener) obj;
            } else if (i == 10000 && obj != null) {
                PathKt$$ExternalSyntheticBUOutline0.m();
            }
        }

        public final void onCameraMotion() {
            FrameMetadataListener frameMetadataListener = this.cameraMotionListener;
            if (frameMetadataListener != null) {
                frameMetadataListener.onCameraMotion();
            }
        }

        public final void onCameraMotionReset() {
            FrameMetadataListener frameMetadataListener = this.cameraMotionListener;
            if (frameMetadataListener != null) {
                frameMetadataListener.onCameraMotionReset();
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoFrameMetadataListener
        public final void onVideoFrameAboutToBeRendered(long j, long j2, Format format, MediaFormat mediaFormat) {
            VideoFrameMetadataListener videoFrameMetadataListener = this.videoFrameMetadataListener;
            if (videoFrameMetadataListener != null) {
                videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j, j2, format, mediaFormat);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MediaSourceHolderSnapshot implements MediaSourceInfoHolder {
        public final MaskingMediaSource mediaSource;
        public Timeline timeline;
        public final Object uid;

        public MediaSourceHolderSnapshot(Object obj, MaskingMediaSource maskingMediaSource) {
            this.uid = obj;
            this.mediaSource = maskingMediaSource;
            this.timeline = maskingMediaSource.timeline;
        }

        @Override // androidx.media3.exoplayer.MediaSourceInfoHolder
        public final Timeline getTimeline() {
            return this.timeline;
        }

        @Override // androidx.media3.exoplayer.MediaSourceInfoHolder
        public final Object getUid() {
            return this.uid;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class VirtualDeviceIdChangeListener {
        public final WeakReference contextReference;
        public final ExoPlayerImpl$VirtualDeviceIdChangeListener$$ExternalSyntheticLambda0 listener;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.media3.exoplayer.ExoPlayerImpl$VirtualDeviceIdChangeListener$$ExternalSyntheticLambda0, java.util.function.IntConsumer] */
        public VirtualDeviceIdChangeListener(Context context) {
            this.contextReference = new WeakReference(context);
            ?? r0 = new IntConsumer() { // from class: androidx.media3.exoplayer.ExoPlayerImpl$VirtualDeviceIdChangeListener$$ExternalSyntheticLambda0
                @Override // java.util.function.IntConsumer
                public final void accept(int i) {
                    ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
                    if (exoPlayerImpl.playerReleased) {
                        return;
                    }
                    exoPlayerImpl.sendRendererMessage(1, 19, Integer.valueOf(i));
                }
            };
            this.listener = r0;
            context.registerDeviceIdChangeListener(new MediaControllerHolder$$ExternalSyntheticLambda1((byte) 2, ExoPlayerImpl.this.clock.createHandler(ExoPlayerImpl.this.applicationLooper, null)), r0);
        }

        public final void release() {
            Context context = (Context) this.contextReference.get();
            if (context == null) {
                return;
            }
            context.unregisterDeviceIdChangeListener(this.listener);
        }
    }

    static {
        MediaLibraryInfo.registerModule("media3.exoplayer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v14, types: [int, short] */
    public ExoPlayerImpl(ExoPlayer$Builder exoPlayer$Builder) {
        RulerTrackingMap rulerTrackingMap;
        int i;
        Context context = exoPlayer$Builder.context;
        Looper looper = exoPlayer$Builder.looper;
        this.window = new Timeline.Window();
        this.constructorFinished = new ConditionVariable(0);
        try {
            Log.i("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.10.1] [" + Util.DEVICE_DEBUG_INFO + "]");
            SystemClock systemClock = SystemClock.DEFAULT;
            this.applicationContext = context.getApplicationContext();
            this.analyticsCollector = new DefaultAnalyticsCollector(systemClock);
            this.priority = -1000;
            this.audioAttributes = exoPlayer$Builder.audioAttributes;
            byte b = 1;
            this.videoScalingMode = true;
            this.skipSilenceEnabled = false;
            this.detachSurfaceTimeoutMs = (short) 2000;
            ComponentListener componentListener = new ComponentListener();
            this.componentListener = componentListener;
            this.frameMetadataListener = new FrameMetadataListener();
            BaseRenderer[] baseRendererArrCreateRenderers = ((DefaultRenderersFactory) exoPlayer$Builder.renderersFactorySupplier.get()).createRenderers(new Handler(looper), componentListener, componentListener, componentListener, componentListener);
            this.renderers = baseRendererArrCreateRenderers;
            UtilsKt.checkState(baseRendererArrCreateRenderers.length > 0);
            this.secondaryRenderers = new BaseRenderer[baseRendererArrCreateRenderers.length];
            int i2 = 0;
            while (true) {
                BaseRenderer[] baseRendererArr = this.secondaryRenderers;
                if (i2 >= baseRendererArr.length) {
                    break;
                }
                byte b2 = this.renderers[i2].trackType;
                baseRendererArr[i2] = null;
                i2++;
            }
            DefaultTrackSelector defaultTrackSelector = (DefaultTrackSelector) exoPlayer$Builder.trackSelectorSupplier.get();
            this.trackSelector = defaultTrackSelector;
            this.mediaSourceFactory = (MediaSource$Factory) exoPlayer$Builder.mediaSourceFactorySupplier.get();
            DefaultBandwidthMeter defaultBandwidthMeter = (DefaultBandwidthMeter) exoPlayer$Builder.bandwidthMeterSupplier.get();
            this.bandwidthMeter = defaultBandwidthMeter;
            this.useLazyPreparation = true;
            SeekParameters seekParameters = exoPlayer$Builder.seekParameters;
            this.seekBackIncrementMs = (short) 5000;
            this.seekForwardIncrementMs = exoPlayer$Builder.seekForwardIncrementMs;
            this.maxSeekToPreviousPositionMs = (short) 3000;
            this.scrubbingModeParameters = exoPlayer$Builder.scrubbingModeParameters;
            this.applicationLooper = looper;
            this.clock = systemClock;
            this.wrappingPlayer = this;
            this.listeners = new ListenerSet(looper, new ExoPlayerImpl$$ExternalSyntheticLambda20(this, b));
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            this.audioOffloadListeners = copyOnWriteArraySet;
            this.mediaSourceHolderSnapshots = new ArrayList();
            this.shuffleOrder = new ShuffleOrder$DefaultShuffleOrder();
            BaseRenderer[] baseRendererArr2 = this.renderers;
            boolean z = true;
            TrackSelectorResult trackSelectorResult = new TrackSelectorResult(new RendererConfiguration[baseRendererArr2.length], new ExoTrackSelection[baseRendererArr2.length], Tracks.EMPTY, null);
            this.emptyTrackSelectorResult = trackSelectorResult;
            this.period = new Timeline.Period();
            FlagSet.Builder builder = new FlagSet.Builder((byte) 0);
            builder.addAll(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32);
            builder.add(29);
            if (exoPlayer$Builder.deviceVolumeControlEnabled) {
                builder.add(23);
            }
            if (exoPlayer$Builder.deviceVolumeControlEnabled) {
                builder.add(25);
            }
            if (exoPlayer$Builder.deviceVolumeControlEnabled) {
                builder.add(33);
            }
            if (exoPlayer$Builder.deviceVolumeControlEnabled) {
                builder.add(26);
            }
            if (exoPlayer$Builder.deviceVolumeControlEnabled) {
                builder.add(34);
            }
            FlagSet flagSetBuild = builder.build();
            this.permanentAvailableCommands = new Player.Commands(flagSetBuild);
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
            int i3 = 0;
            while (i3 < flagSetBuild.flags.size()) {
                int i4 = flagSetBuild.get(i3);
                UtilsKt.checkState(!false);
                sparseBooleanArray.append(i4, z);
                i3++;
                z = true;
            }
            UtilsKt.checkState(!false);
            sparseBooleanArray.append(4, true);
            UtilsKt.checkState(!false);
            sparseBooleanArray.append(10, true);
            UtilsKt.checkState(!false);
            this.availableCommands = new Player.Commands(new FlagSet(sparseBooleanArray));
            this.playbackInfoUpdateHandler = systemClock.createHandler(looper, null);
            byte b3 = 0;
            ExoPlayerImpl$$ExternalSyntheticLambda20 exoPlayerImpl$$ExternalSyntheticLambda20 = new ExoPlayerImpl$$ExternalSyntheticLambda20(this, b3);
            this.playbackInfoUpdateListener = exoPlayerImpl$$ExternalSyntheticLambda20;
            this.playbackInfo = PlaybackInfo.createDummy(trackSelectorResult);
            this.analyticsCollector.setPlayer(this, looper);
            PlayerId playerId = new PlayerId("");
            ExoPlayerImplInternal exoPlayerImplInternal = new ExoPlayerImplInternal(this.applicationContext, this.renderers, this.secondaryRenderers, defaultTrackSelector, trackSelectorResult, (DefaultLoadControl) exoPlayer$Builder.loadControlSupplier.get(), defaultBandwidthMeter, this.repeatMode, this.shuffleModeEnabled, this.analyticsCollector, seekParameters, exoPlayer$Builder.livePlaybackSpeedControl, looper, exoPlayerImpl$$ExternalSyntheticLambda20, playerId, this.frameMetadataListener);
            Looper looper2 = exoPlayerImplInternal.playbackLooper;
            SystemHandlerWrapper systemHandlerWrapper = exoPlayerImplInternal.handler;
            this.internalPlayer = exoPlayerImplInternal;
            this.volume = 1.0f;
            this.repeatMode = 0;
            MediaMetadata mediaMetadata = MediaMetadata.EMPTY;
            this.mediaMetadata = mediaMetadata;
            this.playlistMetadata = mediaMetadata;
            this.staticAndDynamicMediaMetadata = mediaMetadata;
            this.maskingWindowIndex = -1;
            this.currentCueGroup = CueGroup.EMPTY_TIME_ZERO;
            this.throwsWhenUsingWrongThread = true;
            addListener(this.analyticsCollector);
            Handler handler = new Handler(looper);
            DefaultAnalyticsCollector defaultAnalyticsCollector = this.analyticsCollector;
            defaultAnalyticsCollector.getClass();
            AtomicInt atomicInt = defaultBandwidthMeter.eventDispatcher;
            atomicInt.getClass();
            CopyOnWriteArrayList<BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener> copyOnWriteArrayList = (CopyOnWriteArrayList) atomicInt.delegate;
            for (BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener : copyOnWriteArrayList) {
                if (bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener.listener == defaultAnalyticsCollector) {
                    bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener.released = true;
                    copyOnWriteArrayList.remove(bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener);
                }
            }
            copyOnWriteArrayList.add(new BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener(handler, defaultAnalyticsCollector));
            copyOnWriteArraySet.add(this.componentListener);
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 31) {
                rulerTrackingMap = null;
                systemClock.createHandler(looper2, null).post(new Util$$ExternalSyntheticLambda1((Object) this.applicationContext, (Object) this, (Object) playerId, (byte) 4));
            } else {
                rulerTrackingMap = null;
            }
            RulerTrackingMap rulerTrackingMap2 = new RulerTrackingMap(0, looper2, looper, new ExoPlayerImpl$$ExternalSyntheticLambda20(this, (byte) 2));
            this.audioSessionIdState = rulerTrackingMap2;
            rulerTrackingMap2.runInBackground(new ActivityCompat$$ExternalSyntheticLambda0((byte) 15, (Object) this));
            Latch latch = new Latch(context, looper2, looper, this.componentListener);
            this.audioBecomingNoisyManager = latch;
            latch.setEnabled(exoPlayer$Builder.handleAudioBecomingNoisy);
            if (exoPlayer$Builder.deviceVolumeControlEnabled) {
                Context context2 = exoPlayer$Builder.context;
                ComponentListener componentListener2 = this.componentListener;
                AudioAttributes audioAttributes = this.audioAttributes;
                audioAttributes.getClass();
                try {
                    int volumeControlStream = audioAttributes.getPlatformAudioAttributes().getVolumeControlStream();
                    i = volumeControlStream == Integer.MIN_VALUE ? 3 : volumeControlStream;
                } catch (RuntimeException unused) {
                }
                RulerTrackingMap rulerTrackingMap3 = new RulerTrackingMap();
                rulerTrackingMap3.rulers = context2.getApplicationContext();
                rulerTrackingMap3.values = componentListener2;
                RulerTrackingMap rulerTrackingMap4 = new RulerTrackingMap(new StreamVolumeManager$StreamVolumeState(false, i, 0, 0, 0), looper2, looper, new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 11, (Object) rulerTrackingMap3));
                rulerTrackingMap3.accessFlags = rulerTrackingMap4;
                rulerTrackingMap4.runInBackground(new StreamVolumeManager$$ExternalSyntheticLambda1(rulerTrackingMap3, i, b3));
                this.streamVolumeManager = rulerTrackingMap3;
            } else {
                this.streamVolumeManager = rulerTrackingMap;
            }
            byte b4 = exoPlayer$Builder.wakeModeSet ? exoPlayer$Builder.wakeMode : (exoPlayer$Builder.stuckPlayingDetectionTimeoutMs == Integer.MAX_VALUE || exoPlayer$Builder.stuckPlayingNotEndingTimeoutMs == Integer.MAX_VALUE) ? (byte) 0 : (byte) 1;
            Exchange exchange = new Exchange(context, looper2, (byte) 1);
            this.wakeLockManager = exchange;
            boolean z2 = b4 != 0;
            if (exchange.isDuplex != z2) {
                exchange.isDuplex = z2;
                exchange.postUpdateWakeLock(z2, exchange.hasFailure);
            }
            Exchange exchange2 = new Exchange(context, looper2, (byte) 2);
            this.wifiLockManager = exchange2;
            boolean z3 = b4 == 2;
            if (exchange2.isDuplex != z3) {
                exchange2.isDuplex = z3;
                exchange2.postUpdateWifiLock(z3, exchange2.hasFailure);
            }
            this.deviceInfo = DeviceInfo.UNKNOWN;
            this.videoSize = VideoSize.UNKNOWN;
            this.surfaceSize = Size.UNKNOWN;
            this.virtualDeviceIdChangeListener = i5 >= 34 ? new VirtualDeviceIdChangeListener(context) : rulerTrackingMap;
            this.audioListenerManager = new CallbackWrapper((byte) 19);
            this.videoListenerManager = new CallbackWrapper((byte) 19);
            this.stuckPlayerDetector = new NodeChain(this, this.componentListener, this.clock, exoPlayer$Builder.stuckPlayingDetectionTimeoutMs, exoPlayer$Builder.stuckPlayingNotEndingTimeoutMs);
            systemHandlerWrapper.obtainMessage(38, this.scrubbingModeParameters).sendToTarget();
            AudioAttributes audioAttributes2 = this.audioAttributes;
            systemHandlerWrapper.getClass();
            SystemHandlerWrapper.SystemMessage systemMessageObtainSystemMessage = SystemHandlerWrapper.obtainSystemMessage();
            systemMessageObtainSystemMessage.message = systemHandlerWrapper.handler.obtainMessage(31, 0, 0, audioAttributes2);
            systemMessageObtainSystemMessage.sendToTarget();
            sendRendererMessage(1, 3, this.audioAttributes);
            sendRendererMessage(2, 4, Integer.valueOf(this.videoScalingMode ? 1 : 0));
            sendRendererMessage(2, 5, 0);
            sendRendererMessage(1, 9, Boolean.valueOf(this.skipSilenceEnabled));
            sendRendererMessage(6, 8, this.frameMetadataListener);
            sendRendererMessage(-1, 16, Integer.valueOf(this.priority));
        } finally {
            this.constructorFinished.open();
        }
    }

    public static long getRequestedContentPositionUs(PlaybackInfo playbackInfo) {
        Timeline.Window window = new Timeline.Window();
        Timeline.Period period = new Timeline.Period();
        playbackInfo.timeline.getPeriodByUid(playbackInfo.periodId.periodUid, period);
        long j = playbackInfo.requestedContentPositionUs;
        return j == -9223372036854775807L ? playbackInfo.timeline.getWindow(period.windowIndex, window, 0L).defaultPositionUs : period.positionInWindowUs + j;
    }

    public static PlaybackInfo maskPlaybackState(PlaybackInfo playbackInfo, int i) {
        PlaybackInfo playbackInfoCopyWithPlaybackState = playbackInfo.copyWithPlaybackState(i);
        return (i == 1 || i == 4) ? playbackInfoCopyWithPlaybackState.copyWithIsLoading(false) : playbackInfoCopyWithPlaybackState;
    }

    @Override // androidx.media3.common.Player
    public final void addListener(Player.Listener listener) {
        listener.getClass();
        this.listeners.add(listener);
    }

    @Override // androidx.media3.common.Player
    public final void addMediaItems(int i, List list) {
        verifyApplicationThread();
        ArrayList arrayListCreateMediaSources = createMediaSources(list);
        verifyApplicationThread();
        UtilsKt.checkArgument(i >= 0);
        int iMin = Math.min(i, this.mediaSourceHolderSnapshots.size());
        if (!this.playbackInfo.timeline.isEmpty()) {
            updatePlaybackInfo(addMediaSourcesInternal(this.playbackInfo, iMin, arrayListCreateMediaSources), 0, false, 5, -9223372036854775807L, -1, false);
            return;
        }
        boolean z = this.maskingWindowIndex == -1;
        verifyApplicationThread();
        setMediaSourcesInternal(arrayListCreateMediaSources, -1, -9223372036854775807L, z);
    }

    public final PlaybackInfo addMediaSourcesInternal(PlaybackInfo playbackInfo, int i, ArrayList arrayList) {
        Timeline timeline = playbackInfo.timeline;
        this.pendingOperationAcks++;
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            MediaSourceList.MediaSourceHolder mediaSourceHolder = new MediaSourceList.MediaSourceHolder((BaseMediaSource) arrayList.get(i2), this.useLazyPreparation);
            arrayList2.add(mediaSourceHolder);
            this.mediaSourceHolderSnapshots.add(i2 + i, new MediaSourceHolderSnapshot(mediaSourceHolder.uid, mediaSourceHolder.mediaSource));
        }
        this.shuffleOrder = this.shuffleOrder.cloneAndInsert(i, arrayList2.size());
        PlaylistTimeline playlistTimelineCreateMaskingTimeline = createMaskingTimeline();
        PlaybackInfo playbackInfoMaskTimelineAndPosition = maskTimelineAndPosition(playbackInfo, playlistTimelineCreateMaskingTimeline, getPeriodPositionUsAfterTimelineChanged(timeline, playlistTimelineCreateMaskingTimeline, getCurrentWindowIndexInternal(playbackInfo), getContentPositionInternal(playbackInfo)));
        ShuffleOrder$DefaultShuffleOrder shuffleOrder$DefaultShuffleOrder = this.shuffleOrder;
        SystemHandlerWrapper systemHandlerWrapper = this.internalPlayer.handler;
        ExoPlayerImplInternal.MediaSourceListUpdateMessage mediaSourceListUpdateMessage = new ExoPlayerImplInternal.MediaSourceListUpdateMessage(arrayList2, shuffleOrder$DefaultShuffleOrder, -1, -9223372036854775807L);
        systemHandlerWrapper.getClass();
        SystemHandlerWrapper.SystemMessage systemMessageObtainSystemMessage = SystemHandlerWrapper.obtainSystemMessage();
        systemMessageObtainSystemMessage.message = systemHandlerWrapper.handler.obtainMessage(18, i, 0, mediaSourceListUpdateMessage);
        systemMessageObtainSystemMessage.sendToTarget();
        return playbackInfoMaskTimelineAndPosition;
    }

    public final MediaMetadata buildUpdatedMediaMetadata() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return this.staticAndDynamicMediaMetadata;
        }
        MediaItem mediaItem = currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window, 0L).mediaItem;
        MediaMetadata.Builder builderBuildUpon = this.staticAndDynamicMediaMetadata.buildUpon();
        MediaMetadata mediaMetadata = mediaItem.mediaMetadata;
        if (mediaMetadata != null) {
            ImmutableList immutableList = mediaMetadata.supportedCommands;
            byte[] bArr = mediaMetadata.artworkData;
            CharSequence charSequence = mediaMetadata.title;
            if (charSequence != null) {
                builderBuildUpon.title = charSequence;
            }
            CharSequence charSequence2 = mediaMetadata.artist;
            if (charSequence2 != null) {
                builderBuildUpon.artist = charSequence2;
            }
            CharSequence charSequence3 = mediaMetadata.albumTitle;
            if (charSequence3 != null) {
                builderBuildUpon.albumTitle = charSequence3;
            }
            CharSequence charSequence4 = mediaMetadata.albumArtist;
            if (charSequence4 != null) {
                builderBuildUpon.albumArtist = charSequence4;
            }
            CharSequence charSequence5 = mediaMetadata.displayTitle;
            if (charSequence5 != null) {
                builderBuildUpon.displayTitle = charSequence5;
            }
            CharSequence charSequence6 = mediaMetadata.subtitle;
            if (charSequence6 != null) {
                builderBuildUpon.subtitle = charSequence6;
            }
            CharSequence charSequence7 = mediaMetadata.description;
            if (charSequence7 != null) {
                builderBuildUpon.description = charSequence7;
            }
            Long l = mediaMetadata.durationMs;
            if (l != null) {
                builderBuildUpon.setDurationMs(l);
            }
            Rating rating = mediaMetadata.userRating;
            if (rating != null) {
                builderBuildUpon.userRating = rating;
            }
            Rating rating2 = mediaMetadata.overallRating;
            if (rating2 != null) {
                builderBuildUpon.overallRating = rating2;
            }
            Uri uri = mediaMetadata.artworkUri;
            if (uri != null || bArr != null) {
                builderBuildUpon.artworkUri = uri;
                builderBuildUpon.setArtworkData(bArr, mediaMetadata.artworkDataType);
                builderBuildUpon.bundleableArtworkData = mediaMetadata.bundleableArtworkData;
            }
            Integer num = mediaMetadata.trackNumber;
            if (num != null) {
                builderBuildUpon.trackNumber = num;
            }
            Integer num2 = mediaMetadata.totalTrackCount;
            if (num2 != null) {
                builderBuildUpon.totalTrackCount = num2;
            }
            Integer num3 = mediaMetadata.folderType;
            if (num3 != null) {
                builderBuildUpon.folderType = num3;
            }
            Boolean bool = mediaMetadata.isBrowsable;
            if (bool != null) {
                builderBuildUpon.isBrowsable = bool;
            }
            Boolean bool2 = mediaMetadata.isPlayable;
            if (bool2 != null) {
                builderBuildUpon.isPlayable = bool2;
            }
            Integer num4 = mediaMetadata.year;
            if (num4 != null) {
                builderBuildUpon.recordingYear = num4;
            }
            Integer num5 = mediaMetadata.recordingYear;
            if (num5 != null) {
                builderBuildUpon.recordingYear = num5;
            }
            Integer num6 = mediaMetadata.recordingMonth;
            if (num6 != null) {
                builderBuildUpon.recordingMonth = num6;
            }
            Integer num7 = mediaMetadata.recordingDay;
            if (num7 != null) {
                builderBuildUpon.recordingDay = num7;
            }
            Integer num8 = mediaMetadata.releaseYear;
            if (num8 != null) {
                builderBuildUpon.releaseYear = num8;
            }
            Integer num9 = mediaMetadata.releaseMonth;
            if (num9 != null) {
                builderBuildUpon.releaseMonth = num9;
            }
            Integer num10 = mediaMetadata.releaseDay;
            if (num10 != null) {
                builderBuildUpon.releaseDay = num10;
            }
            CharSequence charSequence8 = mediaMetadata.writer;
            if (charSequence8 != null) {
                builderBuildUpon.writer = charSequence8;
            }
            CharSequence charSequence9 = mediaMetadata.composer;
            if (charSequence9 != null) {
                builderBuildUpon.composer = charSequence9;
            }
            CharSequence charSequence10 = mediaMetadata.conductor;
            if (charSequence10 != null) {
                builderBuildUpon.conductor = charSequence10;
            }
            Integer num11 = mediaMetadata.discNumber;
            if (num11 != null) {
                builderBuildUpon.discNumber = num11;
            }
            Integer num12 = mediaMetadata.totalDiscCount;
            if (num12 != null) {
                builderBuildUpon.totalDiscCount = num12;
            }
            CharSequence charSequence11 = mediaMetadata.genre;
            if (charSequence11 != null) {
                builderBuildUpon.genre = charSequence11;
            }
            CharSequence charSequence12 = mediaMetadata.compilation;
            if (charSequence12 != null) {
                builderBuildUpon.compilation = charSequence12;
            }
            CharSequence charSequence13 = mediaMetadata.station;
            if (charSequence13 != null) {
                builderBuildUpon.station = charSequence13;
            }
            Integer num13 = mediaMetadata.mediaType;
            if (num13 != null) {
                builderBuildUpon.mediaType = num13;
            }
            Bundle bundle = mediaMetadata.extras;
            if (bundle != null) {
                builderBuildUpon.extras = bundle;
            }
            if (!immutableList.isEmpty()) {
                builderBuildUpon.supportedCommands = ImmutableList.copyOf((Collection) immutableList);
            }
        }
        return new MediaMetadata(builderBuildUpon);
    }

    @Override // androidx.media3.common.Player
    public final boolean canAdvertiseSession() {
        return true;
    }

    @Override // androidx.media3.common.Player
    public final void clearMediaItems() {
        removeMediaItems(0, Integer.MAX_VALUE);
    }

    public final PlaylistTimeline createMaskingTimeline() {
        return new PlaylistTimeline(this.mediaSourceHolderSnapshots, this.shuffleOrder);
    }

    public final ArrayList createMediaSources(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(this.mediaSourceFactory.createMediaSource((MediaItem) list.get(i)));
        }
        return arrayList;
    }

    public final PlayerMessage createMessageInternal(PlayerMessage.Target target) {
        int currentWindowIndexInternal = getCurrentWindowIndexInternal(this.playbackInfo);
        Timeline timeline = this.playbackInfo.timeline;
        if (currentWindowIndexInternal == -1) {
            currentWindowIndexInternal = 0;
        }
        ExoPlayerImplInternal exoPlayerImplInternal = this.internalPlayer;
        return new PlayerMessage(exoPlayerImplInternal, target, timeline, currentWindowIndexInternal, exoPlayerImplInternal.playbackLooper);
    }

    @Override // androidx.media3.common.Player
    public final void decreaseDeviceVolume() {
        verifyApplicationThread();
        RulerTrackingMap rulerTrackingMap = this.streamVolumeManager;
        if (rulerTrackingMap != null) {
            ((RulerTrackingMap) rulerTrackingMap.accessFlags).updateStateAsync(new Format$$ExternalSyntheticLambda1((byte) 9), new StreamVolumeManager$$ExternalSyntheticLambda3(rulerTrackingMap, 1, (byte) 0));
        }
    }

    @Override // androidx.media3.common.Player
    public final Looper getApplicationLooper() {
        return this.applicationLooper;
    }

    @Override // androidx.media3.common.Player
    public final AudioAttributes getAudioAttributes() {
        verifyApplicationThread();
        return this.audioAttributes;
    }

    @Override // androidx.media3.common.Player
    public final Player.Commands getAvailableCommands() {
        verifyApplicationThread();
        return this.availableCommands;
    }

    @Override // androidx.media3.common.Player
    public final int getBufferedPercentage() {
        if (!isCommandAvailable(16)) {
            return 0;
        }
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return Util.constrainValue(Util.percentInt(bufferedPosition, duration), 0, 100);
    }

    @Override // androidx.media3.common.Player
    public final long getBufferedPosition() {
        verifyApplicationThread();
        if (!isPlayingAd()) {
            return getContentBufferedPosition();
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        return playbackInfo.loadingMediaPeriodId.equals(playbackInfo.periodId) ? Util.usToMs(this.playbackInfo.bufferedPositionUs) : getDuration();
    }

    @Override // androidx.media3.common.Player
    public final long getContentBufferedPosition() {
        verifyApplicationThread();
        if (this.playbackInfo.timeline.isEmpty()) {
            return this.maskingWindowPositionMs;
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (playbackInfo.loadingMediaPeriodId.windowSequenceNumber != playbackInfo.periodId.windowSequenceNumber) {
            return Util.usToMs(playbackInfo.timeline.getWindow(getCurrentMediaItemIndex(), this.window, 0L).durationUs);
        }
        long j = playbackInfo.bufferedPositionUs;
        if (this.playbackInfo.loadingMediaPeriodId.isAd()) {
            PlaybackInfo playbackInfo2 = this.playbackInfo;
            Timeline.Period periodByUid = playbackInfo2.timeline.getPeriodByUid(playbackInfo2.loadingMediaPeriodId.periodUid, this.period);
            long adGroupTimeUs = periodByUid.getAdGroupTimeUs(this.playbackInfo.loadingMediaPeriodId.adGroupIndex);
            j = adGroupTimeUs == Long.MIN_VALUE ? periodByUid.durationUs : adGroupTimeUs;
        }
        PlaybackInfo playbackInfo3 = this.playbackInfo;
        Timeline timeline = playbackInfo3.timeline;
        Object obj = playbackInfo3.loadingMediaPeriodId.periodUid;
        Timeline.Period period = this.period;
        timeline.getPeriodByUid(obj, period);
        return Util.usToMs(j + period.positionInWindowUs);
    }

    @Override // androidx.media3.common.Player
    public final long getContentDuration() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -9223372036854775807L;
        }
        return Util.usToMs(currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window, 0L).durationUs);
    }

    @Override // androidx.media3.common.Player
    public final long getContentPosition() {
        verifyApplicationThread();
        return getContentPositionInternal(this.playbackInfo);
    }

    public final long getContentPositionInternal(PlaybackInfo playbackInfo) {
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = playbackInfo.periodId;
        long j = playbackInfo.requestedContentPositionUs;
        Timeline timeline = playbackInfo.timeline;
        if (!mediaSource$MediaPeriodId.isAd()) {
            return Util.usToMs(getCurrentPositionUsInternal(playbackInfo));
        }
        Object obj = playbackInfo.periodId.periodUid;
        Timeline.Period period = this.period;
        timeline.getPeriodByUid(obj, period);
        if (j == -9223372036854775807L) {
            return Util.usToMs(timeline.getWindow(getCurrentWindowIndexInternal(playbackInfo), this.window, 0L).defaultPositionUs);
        }
        return Util.usToMs(j) + Util.usToMs(period.positionInWindowUs);
    }

    @Override // androidx.media3.common.Player
    public final int getCurrentAdGroupIndex() {
        verifyApplicationThread();
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adGroupIndex;
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    public final int getCurrentAdIndexInAdGroup() {
        verifyApplicationThread();
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adIndexInAdGroup;
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    public final CueGroup getCurrentCues() {
        verifyApplicationThread();
        return this.currentCueGroup;
    }

    @Override // androidx.media3.common.Player
    public final long getCurrentLiveOffset() {
        Timeline currentTimeline = getCurrentTimeline();
        if (!currentTimeline.isEmpty()) {
            int currentMediaItemIndex = getCurrentMediaItemIndex();
            Timeline.Window window = this.window;
            if (currentTimeline.getWindow(currentMediaItemIndex, window, 0L).windowStartTimeMs != -9223372036854775807L) {
                long j = window.elapsedRealtimeEpochOffsetMs;
                return ((j == -9223372036854775807L ? System.currentTimeMillis() : j + android.os.SystemClock.elapsedRealtime()) - window.windowStartTimeMs) - getContentPosition();
            }
        }
        return -9223372036854775807L;
    }

    @Override // androidx.media3.common.Player
    public final MediaItem getCurrentMediaItem() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return null;
        }
        return currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window, 0L).mediaItem;
    }

    @Override // androidx.media3.common.Player
    public final int getCurrentMediaItemIndex() {
        verifyApplicationThread();
        int currentWindowIndexInternal = getCurrentWindowIndexInternal(this.playbackInfo);
        if (currentWindowIndexInternal == -1) {
            return 0;
        }
        return currentWindowIndexInternal;
    }

    @Override // androidx.media3.common.Player
    public final int getCurrentPeriodIndex() {
        verifyApplicationThread();
        if (!this.playbackInfo.timeline.isEmpty()) {
            PlaybackInfo playbackInfo = this.playbackInfo;
            return playbackInfo.timeline.getIndexOfPeriod(playbackInfo.periodId.periodUid);
        }
        int i = this.maskingWindowIndex;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    @Override // androidx.media3.common.Player
    public final long getCurrentPosition() {
        verifyApplicationThread();
        return Util.usToMs(getCurrentPositionUsInternal(this.playbackInfo));
    }

    public final long getCurrentPositionUsInternal(PlaybackInfo playbackInfo) {
        if (playbackInfo.timeline.isEmpty()) {
            return Util.msToUs(this.maskingWindowPositionMs);
        }
        long estimatedPositionUs = playbackInfo.sleepingForOffload ? playbackInfo.getEstimatedPositionUs() : playbackInfo.positionUs;
        if (playbackInfo.periodId.isAd()) {
            return estimatedPositionUs;
        }
        Timeline timeline = playbackInfo.timeline;
        Object obj = playbackInfo.periodId.periodUid;
        Timeline.Period period = this.period;
        timeline.getPeriodByUid(obj, period);
        return estimatedPositionUs + period.positionInWindowUs;
    }

    @Override // androidx.media3.common.Player
    public final Timeline getCurrentTimeline() {
        verifyApplicationThread();
        return this.playbackInfo.timeline;
    }

    @Override // androidx.media3.common.Player
    public final Tracks getCurrentTracks() {
        verifyApplicationThread();
        return this.playbackInfo.trackSelectorResult.tracks;
    }

    public final int getCurrentWindowIndexInternal(PlaybackInfo playbackInfo) {
        return playbackInfo.timeline.isEmpty() ? this.maskingWindowIndex : playbackInfo.timeline.getPeriodByUid(playbackInfo.periodId.periodUid, this.period).windowIndex;
    }

    @Override // androidx.media3.common.Player
    public final DeviceInfo getDeviceInfo() {
        verifyApplicationThread();
        return this.deviceInfo;
    }

    @Override // androidx.media3.common.Player
    public final int getDeviceVolume() {
        verifyApplicationThread();
        RulerTrackingMap rulerTrackingMap = this.streamVolumeManager;
        if (rulerTrackingMap != null) {
            return ((StreamVolumeManager$StreamVolumeState) ((RulerTrackingMap) rulerTrackingMap.accessFlags).get()).volume;
        }
        return 0;
    }

    @Override // androidx.media3.common.Player
    public final long getDuration() {
        verifyApplicationThread();
        if (!isPlayingAd()) {
            return getContentDuration();
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = playbackInfo.periodId;
        Timeline timeline = playbackInfo.timeline;
        Object obj = mediaSource$MediaPeriodId.periodUid;
        Timeline.Period period = this.period;
        timeline.getPeriodByUid(obj, period);
        return Util.usToMs(period.getAdDurationUs(mediaSource$MediaPeriodId.adGroupIndex, mediaSource$MediaPeriodId.adIndexInAdGroup));
    }

    @Override // androidx.media3.common.Player
    public final long getMaxSeekToPreviousPosition() {
        verifyApplicationThread();
        return this.maxSeekToPreviousPositionMs;
    }

    @Override // androidx.media3.common.Player
    public final MediaItem getMediaItemAt(int i) {
        return getCurrentTimeline().getWindow(i, this.window, 0L).mediaItem;
    }

    @Override // androidx.media3.common.Player
    public final int getMediaItemCount() {
        return getCurrentTimeline().getWindowCount();
    }

    @Override // androidx.media3.common.Player
    public final MediaMetadata getMediaMetadata() {
        verifyApplicationThread();
        return this.mediaMetadata;
    }

    public final int getNextMediaItemIndex() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -1;
        }
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        verifyApplicationThread();
        int i = this.repeatMode;
        if (i == 1) {
            i = 0;
        }
        verifyApplicationThread();
        return currentTimeline.getNextWindowIndex(currentMediaItemIndex, this.shuffleModeEnabled, i);
    }

    public final Pair getPeriodPositionUsAfterTimelineChanged(Timeline timeline, PlaylistTimeline playlistTimeline, int i, long j) {
        if (timeline.isEmpty() || playlistTimeline.isEmpty()) {
            boolean z = !timeline.isEmpty() && playlistTimeline.isEmpty();
            return maskWindowPositionMsOrGetPeriodPositionUs(playlistTimeline, z ? -1 : i, z ? -9223372036854775807L : j);
        }
        Pair periodPositionUs = timeline.getPeriodPositionUs(this.window, this.period, i, Util.msToUs(j));
        Object obj = periodPositionUs.first;
        if (playlistTimeline.getIndexOfPeriod(obj) != -1) {
            return periodPositionUs;
        }
        int iResolveSubsequentPeriod = ExoPlayerImplInternal.resolveSubsequentPeriod(this.window, this.period, this.repeatMode, this.shuffleModeEnabled, obj, timeline, playlistTimeline);
        if (iResolveSubsequentPeriod == -1) {
            return maskWindowPositionMsOrGetPeriodPositionUs(playlistTimeline, -1, -9223372036854775807L);
        }
        Timeline.Window window = this.window;
        playlistTimeline.getWindow(iResolveSubsequentPeriod, window, 0L);
        return maskWindowPositionMsOrGetPeriodPositionUs(playlistTimeline, iResolveSubsequentPeriod, Util.usToMs(window.defaultPositionUs));
    }

    @Override // androidx.media3.common.Player
    public final boolean getPlayWhenReady() {
        verifyApplicationThread();
        return this.playbackInfo.playWhenReady;
    }

    @Override // androidx.media3.common.Player
    public final PlaybackParameters getPlaybackParameters() {
        verifyApplicationThread();
        return this.playbackInfo.playbackParameters;
    }

    @Override // androidx.media3.common.Player
    public final int getPlaybackState() {
        verifyApplicationThread();
        return this.playbackInfo.playbackState;
    }

    @Override // androidx.media3.common.Player
    public final int getPlaybackSuppressionReason() {
        verifyApplicationThread();
        return this.playbackInfo.playbackSuppressionReason;
    }

    @Override // androidx.media3.common.Player
    public final PlaybackException getPlayerError() {
        verifyApplicationThread();
        return this.playbackInfo.playbackError;
    }

    @Override // androidx.media3.common.Player
    public final MediaMetadata getPlaylistMetadata() {
        verifyApplicationThread();
        return this.playlistMetadata;
    }

    public final int getPreviousMediaItemIndex() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -1;
        }
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        verifyApplicationThread();
        int i = this.repeatMode;
        if (i == 1) {
            i = 0;
        }
        verifyApplicationThread();
        return currentTimeline.getPreviousWindowIndex(currentMediaItemIndex, this.shuffleModeEnabled, i);
    }

    @Override // androidx.media3.common.Player
    public final int getRepeatMode() {
        verifyApplicationThread();
        return this.repeatMode;
    }

    @Override // androidx.media3.common.Player
    public final long getSeekBackIncrement() {
        verifyApplicationThread();
        return this.seekBackIncrementMs;
    }

    @Override // androidx.media3.common.Player
    public final long getSeekForwardIncrement() {
        verifyApplicationThread();
        return this.seekForwardIncrementMs;
    }

    @Override // androidx.media3.common.Player
    public final boolean getShuffleModeEnabled() {
        verifyApplicationThread();
        return this.shuffleModeEnabled;
    }

    @Override // androidx.media3.common.Player
    public final long getTotalBufferedDuration() {
        verifyApplicationThread();
        return Util.usToMs(this.playbackInfo.totalBufferedDurationUs);
    }

    @Override // androidx.media3.common.Player
    public final TrackSelectionParameters getTrackSelectionParameters() {
        verifyApplicationThread();
        return this.trackSelector.getParameters();
    }

    @Override // androidx.media3.common.Player
    public final VideoSize getVideoSize() {
        verifyApplicationThread();
        return this.videoSize;
    }

    @Override // androidx.media3.common.Player
    public final float getVolume() {
        verifyApplicationThread();
        return this.volume;
    }

    public final boolean hasNextMediaItem() {
        return getNextMediaItemIndex() != -1;
    }

    public final boolean hasPreviousMediaItem() {
        return getPreviousMediaItemIndex() != -1;
    }

    @Override // androidx.media3.common.Player
    public final void increaseDeviceVolume() {
        verifyApplicationThread();
        RulerTrackingMap rulerTrackingMap = this.streamVolumeManager;
        if (rulerTrackingMap != null) {
            rulerTrackingMap.increaseVolume(1);
        }
    }

    @Override // androidx.media3.common.Player
    public final boolean isCommandAvailable(int i) {
        verifyApplicationThread();
        return this.availableCommands.contains(i);
    }

    @Override // androidx.media3.common.Player
    public final boolean isCurrentMediaItemDynamic() {
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window, 0L).isDynamic;
    }

    @Override // androidx.media3.common.Player
    public final boolean isCurrentMediaItemLive() {
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window, 0L).isLive();
    }

    @Override // androidx.media3.common.Player
    public final boolean isCurrentMediaItemSeekable() {
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window, 0L).isSeekable;
    }

    @Override // androidx.media3.common.Player
    public final boolean isDeviceMuted() {
        verifyApplicationThread();
        RulerTrackingMap rulerTrackingMap = this.streamVolumeManager;
        if (rulerTrackingMap != null) {
            return ((StreamVolumeManager$StreamVolumeState) ((RulerTrackingMap) rulerTrackingMap.accessFlags).get()).muted;
        }
        return false;
    }

    @Override // androidx.media3.common.Player
    public final boolean isLoading() {
        verifyApplicationThread();
        return this.playbackInfo.isLoading;
    }

    @Override // androidx.media3.common.Player
    public final boolean isPlaying() {
        return getPlaybackState() == 3 && getPlayWhenReady() && getPlaybackSuppressionReason() == 0;
    }

    @Override // androidx.media3.common.Player
    public final boolean isPlayingAd() {
        verifyApplicationThread();
        return this.playbackInfo.periodId.isAd();
    }

    public final PlaybackInfo maskTimelineAndPosition(PlaybackInfo playbackInfo, Timeline timeline, Pair pair) {
        List list;
        UtilsKt.checkArgument(timeline.isEmpty() || pair != null);
        Timeline timeline2 = playbackInfo.timeline;
        long contentPositionInternal = getContentPositionInternal(playbackInfo);
        PlaybackInfo playbackInfoCopyWithTimeline = playbackInfo.copyWithTimeline(timeline);
        if (timeline.isEmpty()) {
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId = PlaybackInfo.PLACEHOLDER_MEDIA_PERIOD_ID;
            long jMsToUs = Util.msToUs(this.maskingWindowPositionMs);
            TrackGroupArray trackGroupArray = TrackGroupArray.EMPTY;
            TrackSelectorResult trackSelectorResult = this.emptyTrackSelectorResult;
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            PlaybackInfo playbackInfoCopyWithLoadingMediaPeriodId = playbackInfoCopyWithTimeline.copyWithNewPosition(mediaSource$MediaPeriodId, jMsToUs, jMsToUs, jMsToUs, 0L, trackGroupArray, trackSelectorResult, RegularImmutableList.EMPTY).copyWithLoadingMediaPeriodId(mediaSource$MediaPeriodId);
            playbackInfoCopyWithLoadingMediaPeriodId.bufferedPositionUs = playbackInfoCopyWithLoadingMediaPeriodId.positionUs;
            return playbackInfoCopyWithLoadingMediaPeriodId;
        }
        Object obj = playbackInfoCopyWithTimeline.periodId.periodUid;
        String str = Util.DEVICE_DEBUG_INFO;
        boolean zEquals = obj.equals(pair.first);
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = !zEquals ? new MediaSource$MediaPeriodId(pair.first) : playbackInfoCopyWithTimeline.periodId;
        long jLongValue = ((Long) pair.second).longValue();
        long jMsToUs2 = Util.msToUs(contentPositionInternal);
        if (!timeline2.isEmpty()) {
            jMsToUs2 -= timeline2.getPeriodByUid(obj, this.period).positionInWindowUs;
            if (zEquals && jMsToUs2 - jLongValue == 1 && jMsToUs2 == timeline2.getPeriodByUid(obj, this.period).durationUs) {
                jMsToUs2--;
            }
        }
        if (!zEquals || jLongValue < jMsToUs2) {
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId3 = mediaSource$MediaPeriodId2;
            UtilsKt.checkState(!mediaSource$MediaPeriodId3.isAd());
            TrackGroupArray trackGroupArray2 = !zEquals ? TrackGroupArray.EMPTY : playbackInfoCopyWithTimeline.trackGroups;
            TrackSelectorResult trackSelectorResult2 = !zEquals ? this.emptyTrackSelectorResult : playbackInfoCopyWithTimeline.trackSelectorResult;
            if (zEquals) {
                list = playbackInfoCopyWithTimeline.staticMetadata;
            } else {
                ImmutableList.Itr itr2 = ImmutableList.EMPTY_ITR;
                list = RegularImmutableList.EMPTY;
            }
            PlaybackInfo playbackInfoCopyWithLoadingMediaPeriodId2 = playbackInfoCopyWithTimeline.copyWithNewPosition(mediaSource$MediaPeriodId3, jLongValue, jLongValue, jLongValue, 0L, trackGroupArray2, trackSelectorResult2, list).copyWithLoadingMediaPeriodId(mediaSource$MediaPeriodId3);
            playbackInfoCopyWithLoadingMediaPeriodId2.bufferedPositionUs = jLongValue;
            return playbackInfoCopyWithLoadingMediaPeriodId2;
        }
        if (jLongValue != jMsToUs2) {
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId4 = mediaSource$MediaPeriodId2;
            UtilsKt.checkState(!mediaSource$MediaPeriodId4.isAd());
            long jMax = Math.max(0L, playbackInfoCopyWithTimeline.totalBufferedDurationUs - (jLongValue - jMsToUs2));
            long j = playbackInfoCopyWithTimeline.bufferedPositionUs;
            if (playbackInfoCopyWithTimeline.loadingMediaPeriodId.equals(playbackInfoCopyWithTimeline.periodId)) {
                j = jLongValue + jMax;
            }
            PlaybackInfo playbackInfoCopyWithNewPosition = playbackInfoCopyWithTimeline.copyWithNewPosition(mediaSource$MediaPeriodId4, jLongValue, jLongValue, jLongValue, jMax, playbackInfoCopyWithTimeline.trackGroups, playbackInfoCopyWithTimeline.trackSelectorResult, playbackInfoCopyWithTimeline.staticMetadata);
            playbackInfoCopyWithNewPosition.bufferedPositionUs = j;
            return playbackInfoCopyWithNewPosition;
        }
        int indexOfPeriod = timeline.getIndexOfPeriod(playbackInfoCopyWithTimeline.loadingMediaPeriodId.periodUid);
        if (indexOfPeriod != -1 && timeline.getPeriod(indexOfPeriod, this.period, false).windowIndex == timeline.getPeriodByUid(mediaSource$MediaPeriodId2.periodUid, this.period).windowIndex) {
            return playbackInfoCopyWithTimeline;
        }
        timeline.getPeriodByUid(mediaSource$MediaPeriodId2.periodUid, this.period);
        boolean zIsAd = mediaSource$MediaPeriodId2.isAd();
        Timeline.Period period = this.period;
        long adDurationUs = zIsAd ? period.getAdDurationUs(mediaSource$MediaPeriodId2.adGroupIndex, mediaSource$MediaPeriodId2.adIndexInAdGroup) : period.durationUs;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId5 = mediaSource$MediaPeriodId2;
        PlaybackInfo playbackInfoCopyWithLoadingMediaPeriodId3 = playbackInfoCopyWithTimeline.copyWithNewPosition(mediaSource$MediaPeriodId5, playbackInfoCopyWithTimeline.positionUs, playbackInfoCopyWithTimeline.positionUs, playbackInfoCopyWithTimeline.discontinuityStartPositionUs, adDurationUs - playbackInfoCopyWithTimeline.positionUs, playbackInfoCopyWithTimeline.trackGroups, playbackInfoCopyWithTimeline.trackSelectorResult, playbackInfoCopyWithTimeline.staticMetadata).copyWithLoadingMediaPeriodId(mediaSource$MediaPeriodId5);
        playbackInfoCopyWithLoadingMediaPeriodId3.bufferedPositionUs = adDurationUs;
        return playbackInfoCopyWithLoadingMediaPeriodId3;
    }

    public final Pair maskWindowPositionMsOrGetPeriodPositionUs(Timeline timeline, int i, long j) {
        if (timeline.isEmpty()) {
            this.maskingWindowIndex = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.maskingWindowPositionMs = j;
            return null;
        }
        if (i == -1 || i >= timeline.getWindowCount()) {
            i = timeline.getFirstWindowIndex(this.shuffleModeEnabled);
            j = Util.usToMs(timeline.getWindow(i, this.window, 0L).defaultPositionUs);
        }
        return timeline.getPeriodPositionUs(this.window, this.period, i, Util.msToUs(j));
    }

    public final void maybeNotifySurfaceSizeChanged(int i, int i2) {
        Size size = this.surfaceSize;
        if (i == size.width && i2 == size.height) {
            return;
        }
        this.surfaceSize = new Size(i, i2);
        this.listeners.sendEvent(24, new ExoPlayerImpl$$ExternalSyntheticLambda24(i, i2, (byte) 0));
        sendRendererMessage(2, 14, new Size(i, i2));
    }

    @Override // androidx.media3.common.Player
    public final void moveMediaItem(int i, int i2) {
        if (i != i2) {
            moveMediaItems(i, i + 1, i2);
        }
    }

    @Override // androidx.media3.common.Player
    public final void moveMediaItems(int i, int i2, int i3) {
        verifyApplicationThread();
        UtilsKt.checkArgument(i >= 0 && i <= i2 && i3 >= 0);
        ArrayList arrayList = this.mediaSourceHolderSnapshots;
        int size = arrayList.size();
        int iMin = Math.min(i2, size);
        int iMin2 = Math.min(i3, size - (iMin - i));
        if (i >= size || i == iMin || i == iMin2) {
            return;
        }
        Timeline currentTimeline = getCurrentTimeline();
        this.pendingOperationAcks++;
        Util.moveItems(arrayList, i, iMin, iMin2);
        ShuffleOrder$DefaultShuffleOrder shuffleOrder$DefaultShuffleOrder = this.shuffleOrder;
        shuffleOrder$DefaultShuffleOrder.getClass();
        this.shuffleOrder = shuffleOrder$DefaultShuffleOrder;
        PlaylistTimeline playlistTimelineCreateMaskingTimeline = createMaskingTimeline();
        PlaybackInfo playbackInfo = this.playbackInfo;
        PlaybackInfo playbackInfoMaskTimelineAndPosition = maskTimelineAndPosition(playbackInfo, playlistTimelineCreateMaskingTimeline, getPeriodPositionUsAfterTimelineChanged(currentTimeline, playlistTimelineCreateMaskingTimeline, getCurrentWindowIndexInternal(playbackInfo), getContentPositionInternal(this.playbackInfo)));
        ShuffleOrder$DefaultShuffleOrder shuffleOrder$DefaultShuffleOrder2 = this.shuffleOrder;
        ExoPlayerImplInternal exoPlayerImplInternal = this.internalPlayer;
        exoPlayerImplInternal.getClass();
        exoPlayerImplInternal.handler.obtainMessage(19, new ExoPlayerImplInternal.MoveMediaItemsMessage(i, iMin, iMin2, shuffleOrder$DefaultShuffleOrder2)).sendToTarget();
        updatePlaybackInfo(playbackInfoMaskTimelineAndPosition, 0, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // androidx.media3.common.Player
    public final void mute() {
        verifyApplicationThread();
        if (this.volume != CropImageView.DEFAULT_ASPECT_RATIO) {
            setVolume(CropImageView.DEFAULT_ASPECT_RATIO);
        }
    }

    @Override // androidx.media3.common.Player
    public final void pause() {
        setPlayWhenReady(false);
    }

    @Override // androidx.media3.common.Player
    public final void play() {
        setPlayWhenReady(true);
    }

    @Override // androidx.media3.common.Player
    public final void prepare() {
        verifyApplicationThread();
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (playbackInfo.playbackState != 1) {
            return;
        }
        PlaybackInfo playbackInfoCopyWithPlaybackError = playbackInfo.copyWithPlaybackError(null);
        PlaybackInfo playbackInfoMaskPlaybackState = maskPlaybackState(playbackInfoCopyWithPlaybackError, playbackInfoCopyWithPlaybackError.timeline.isEmpty() ? 4 : 2);
        this.pendingOperationAcks++;
        this.internalPlayer.handler.obtainMessage(29).sendToTarget();
        updatePlaybackInfo(playbackInfoMaskPlaybackState, 1, false, 5, -9223372036854775807L, -1, false);
    }

    public final void release() {
        String str;
        boolean zBlockUninterruptible;
        StringBuilder sb = new StringBuilder("Release ");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" [AndroidXMedia3/1.10.1] [");
        sb.append(Util.DEVICE_DEBUG_INFO);
        sb.append("] [");
        HashSet hashSet = MediaLibraryInfo.registeredModules;
        synchronized (MediaLibraryInfo.class) {
            str = MediaLibraryInfo.registeredModulesString;
        }
        sb.append(str);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        verifyApplicationThread();
        this.audioBecomingNoisyManager.setEnabled(false);
        RulerTrackingMap rulerTrackingMap = this.streamVolumeManager;
        byte b = 1;
        if (rulerTrackingMap != null) {
            RulerTrackingMap rulerTrackingMap2 = (RulerTrackingMap) rulerTrackingMap.accessFlags;
            Maps$$ExternalSyntheticLambda1 maps$$ExternalSyntheticLambda1 = new Maps$$ExternalSyntheticLambda1(b, rulerTrackingMap);
            rulerTrackingMap2.getClass();
            UtilsKt.checkState(Looper.myLooper() == ((SystemHandlerWrapper) rulerTrackingMap2.values).handler.getLooper());
            rulerTrackingMap2.size++;
            rulerTrackingMap2.runInBackground(new ComponentActivity$$ExternalSyntheticLambda10(rulerTrackingMap2, maps$$ExternalSyntheticLambda1, (byte) 6));
            rulerTrackingMap2.updateStateInForeground((StreamVolumeManager$StreamVolumeState) rulerTrackingMap2.layoutNodes);
        }
        this.wakeLockManager.setStayAwake(false);
        this.wifiLockManager.setStayAwake(false);
        VirtualDeviceIdChangeListener virtualDeviceIdChangeListener = this.virtualDeviceIdChangeListener;
        if (virtualDeviceIdChangeListener != null && Build.VERSION.SDK_INT >= 34) {
            virtualDeviceIdChangeListener.release();
        }
        NodeChain nodeChain = this.stuckPlayerDetector;
        ((SystemHandlerWrapper) nodeChain.head).handler.removeCallbacksAndMessages(null);
        ((ExoPlayerImpl) nodeChain.layoutNode).removeListener((StuckPlayerDetector$1) nodeChain.sentinelHead);
        ExoPlayerImplInternal exoPlayerImplInternal = this.internalPlayer;
        if (exoPlayerImplInternal.releasedOnApplicationThread || !exoPlayerImplInternal.playbackLooper.getThread().isAlive()) {
            zBlockUninterruptible = true;
        } else {
            exoPlayerImplInternal.releasedOnApplicationThread = true;
            ConditionVariable conditionVariable = new ConditionVariable(0);
            exoPlayerImplInternal.handler.obtainMessage(7, conditionVariable).sendToTarget();
            zBlockUninterruptible = conditionVariable.blockUninterruptible(500L);
        }
        if (!zBlockUninterruptible) {
            this.listeners.sendEvent(10, new DifferentialMotionFlingController$$ExternalSyntheticLambda0((byte) 28));
        }
        this.listeners.release();
        this.playbackInfoUpdateHandler.handler.removeCallbacksAndMessages(null);
        DefaultBandwidthMeter defaultBandwidthMeter = this.bandwidthMeter;
        DefaultAnalyticsCollector defaultAnalyticsCollector = this.analyticsCollector;
        CopyOnWriteArrayList<BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener> copyOnWriteArrayList = (CopyOnWriteArrayList) defaultBandwidthMeter.eventDispatcher.delegate;
        for (BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener : copyOnWriteArrayList) {
            if (bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener.listener == defaultAnalyticsCollector) {
                bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener.released = true;
                copyOnWriteArrayList.remove(bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener);
            }
        }
        PlaybackInfo playbackInfoCopyWithEstimatedPosition = this.playbackInfo;
        if (playbackInfoCopyWithEstimatedPosition.sleepingForOffload) {
            playbackInfoCopyWithEstimatedPosition = playbackInfoCopyWithEstimatedPosition.copyWithEstimatedPosition();
            this.playbackInfo = playbackInfoCopyWithEstimatedPosition;
        }
        PlaybackInfo playbackInfoMaskPlaybackState = maskPlaybackState(playbackInfoCopyWithEstimatedPosition, 1);
        this.playbackInfo = playbackInfoMaskPlaybackState;
        PlaybackInfo playbackInfoCopyWithLoadingMediaPeriodId = playbackInfoMaskPlaybackState.copyWithLoadingMediaPeriodId(playbackInfoMaskPlaybackState.periodId);
        this.playbackInfo = playbackInfoCopyWithLoadingMediaPeriodId;
        playbackInfoCopyWithLoadingMediaPeriodId.bufferedPositionUs = playbackInfoCopyWithLoadingMediaPeriodId.positionUs;
        this.playbackInfo.totalBufferedDurationUs = 0L;
        DefaultAnalyticsCollector defaultAnalyticsCollector2 = this.analyticsCollector;
        SystemHandlerWrapper systemHandlerWrapper = defaultAnalyticsCollector2.handler;
        systemHandlerWrapper.getClass();
        systemHandlerWrapper.post(new ActivityCompat$$ExternalSyntheticLambda0((byte) 19, (Object) defaultAnalyticsCollector2));
        removeSurfaceCallbacks();
        Surface surface = this.ownedSurface;
        if (surface != null) {
            surface.release();
            this.ownedSurface = null;
        }
        this.currentCueGroup = CueGroup.EMPTY_TIME_ZERO;
        this.playerReleased = true;
    }

    @Override // androidx.media3.common.Player
    public final void removeListener(Player.Listener listener) {
        verifyApplicationThread();
        listener.getClass();
        this.listeners.remove(listener);
    }

    @Override // androidx.media3.common.Player
    public final void removeMediaItem(int i) {
        removeMediaItems(i, i + 1);
    }

    @Override // androidx.media3.common.Player
    public final void removeMediaItems(int i, int i2) {
        verifyApplicationThread();
        UtilsKt.checkArgument(i >= 0 && i2 >= i);
        int size = this.mediaSourceHolderSnapshots.size();
        int iMin = Math.min(i2, size);
        if (i >= size || i == iMin) {
            return;
        }
        PlaybackInfo playbackInfoRemoveMediaItemsInternal = removeMediaItemsInternal(this.playbackInfo, i, iMin);
        updatePlaybackInfo(playbackInfoRemoveMediaItemsInternal, 0, !playbackInfoRemoveMediaItemsInternal.periodId.periodUid.equals(this.playbackInfo.periodId.periodUid), 4, getCurrentPositionUsInternal(playbackInfoRemoveMediaItemsInternal), -1, false);
    }

    public final PlaybackInfo removeMediaItemsInternal(PlaybackInfo playbackInfo, int i, int i2) {
        int currentWindowIndexInternal = getCurrentWindowIndexInternal(playbackInfo);
        long contentPositionInternal = getContentPositionInternal(playbackInfo);
        Timeline timeline = playbackInfo.timeline;
        this.pendingOperationAcks++;
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            this.mediaSourceHolderSnapshots.remove(i3);
        }
        ShuffleOrder$DefaultShuffleOrder shuffleOrder$DefaultShuffleOrder = this.shuffleOrder;
        int i4 = i2 - i;
        int[] iArr = shuffleOrder$DefaultShuffleOrder.shuffled;
        int[] iArr2 = new int[iArr.length - i4];
        int i5 = 0;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            int i7 = iArr[i6];
            if (i7 < i || i7 >= i2) {
                int i8 = i6 - i5;
                if (i7 >= i) {
                    i7 -= i4;
                }
                iArr2[i8] = i7;
            } else {
                i5++;
            }
        }
        this.shuffleOrder = new ShuffleOrder$DefaultShuffleOrder(iArr2, new Random(shuffleOrder$DefaultShuffleOrder.random.nextLong()));
        PlaylistTimeline playlistTimelineCreateMaskingTimeline = createMaskingTimeline();
        PlaybackInfo playbackInfoMaskTimelineAndPosition = maskTimelineAndPosition(playbackInfo, playlistTimelineCreateMaskingTimeline, getPeriodPositionUsAfterTimelineChanged(timeline, playlistTimelineCreateMaskingTimeline, currentWindowIndexInternal, contentPositionInternal));
        int i9 = playbackInfoMaskTimelineAndPosition.playbackState;
        if (i9 != 1 && i9 != 4 && currentWindowIndexInternal >= i && currentWindowIndexInternal < i2) {
            if (ExoPlayerImplInternal.resolveSubsequentPeriod(this.window, this.period, this.repeatMode, this.shuffleModeEnabled, playbackInfo.periodId.periodUid, timeline, playlistTimelineCreateMaskingTimeline) == -1) {
                playbackInfoMaskTimelineAndPosition = maskPlaybackState(playbackInfoMaskTimelineAndPosition, 4);
            }
        }
        ShuffleOrder$DefaultShuffleOrder shuffleOrder$DefaultShuffleOrder2 = this.shuffleOrder;
        SystemHandlerWrapper systemHandlerWrapper = this.internalPlayer.handler;
        systemHandlerWrapper.getClass();
        SystemHandlerWrapper.SystemMessage systemMessageObtainSystemMessage = SystemHandlerWrapper.obtainSystemMessage();
        systemMessageObtainSystemMessage.message = systemHandlerWrapper.handler.obtainMessage(20, i, i2, shuffleOrder$DefaultShuffleOrder2);
        systemMessageObtainSystemMessage.sendToTarget();
        return playbackInfoMaskTimelineAndPosition;
    }

    public final void removeSurfaceCallbacks() {
        TextureView textureView = this.textureView;
        ComponentListener componentListener = this.componentListener;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != componentListener) {
                Log.w("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.textureView.setSurfaceTextureListener(null);
            }
            this.textureView = null;
        }
        SurfaceHolder surfaceHolder = this.surfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(componentListener);
            this.surfaceHolder = null;
        }
    }

    @Override // androidx.media3.common.Player
    public final void replaceMediaItem(int i, MediaItem mediaItem) {
        replaceMediaItems(i, i + 1, ImmutableList.of((Object) mediaItem));
    }

    @Override // androidx.media3.common.Player
    public final void replaceMediaItems(int i, int i2, List list) {
        verifyApplicationThread();
        UtilsKt.checkArgument(i >= 0 && i2 >= i);
        ArrayList arrayList = this.mediaSourceHolderSnapshots;
        int size = arrayList.size();
        if (i > size) {
            return;
        }
        int iMin = Math.min(i2, size);
        if (iMin - i == list.size()) {
            int i3 = i;
            while (true) {
                if (i3 >= iMin) {
                    this.pendingOperationAcks++;
                    SystemHandlerWrapper systemHandlerWrapper = this.internalPlayer.handler;
                    systemHandlerWrapper.getClass();
                    SystemHandlerWrapper.SystemMessage systemMessageObtainSystemMessage = SystemHandlerWrapper.obtainSystemMessage();
                    systemMessageObtainSystemMessage.message = systemHandlerWrapper.handler.obtainMessage(27, i, iMin, list);
                    systemMessageObtainSystemMessage.sendToTarget();
                    for (int i4 = i; i4 < iMin; i4++) {
                        MediaSourceHolderSnapshot mediaSourceHolderSnapshot = (MediaSourceHolderSnapshot) arrayList.get(i4);
                        Timeline timeline = mediaSourceHolderSnapshot.timeline;
                        MediaItem mediaItem = (MediaItem) list.get(i4 - i);
                        mediaSourceHolderSnapshot.timeline = timeline instanceof TimelineWithUpdatedMediaItem ? new TimelineWithUpdatedMediaItem(((TimelineWithUpdatedMediaItem) timeline).timeline, mediaItem) : new TimelineWithUpdatedMediaItem(timeline, mediaItem);
                    }
                    updatePlaybackInfo(this.playbackInfo.copyWithTimeline(createMaskingTimeline()), 0, false, 4, -9223372036854775807L, -1, false);
                    return;
                }
                if (!((MediaSourceHolderSnapshot) arrayList.get(i3)).mediaSource.mediaSource.canUpdateMediaItem((MediaItem) list.get(i3 - i))) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        ArrayList arrayListCreateMediaSources = createMediaSources(list);
        if (!this.playbackInfo.timeline.isEmpty()) {
            PlaybackInfo playbackInfoRemoveMediaItemsInternal = removeMediaItemsInternal(addMediaSourcesInternal(this.playbackInfo, iMin, arrayListCreateMediaSources), i, iMin);
            updatePlaybackInfo(playbackInfoRemoveMediaItemsInternal, 0, !playbackInfoRemoveMediaItemsInternal.periodId.periodUid.equals(this.playbackInfo.periodId.periodUid), 4, getCurrentPositionUsInternal(playbackInfoRemoveMediaItemsInternal), -1, false);
        } else {
            boolean z = this.maskingWindowIndex == -1;
            verifyApplicationThread();
            setMediaSourcesInternal(arrayListCreateMediaSources, -1, -9223372036854775807L, z);
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekBack() {
        verifyApplicationThread();
        long currentPosition = getCurrentPosition() + (-this.seekBackIncrementMs);
        long duration = getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        seekToCurrentItem(Math.max(currentPosition, 0L));
    }

    @Override // androidx.media3.common.Player
    public final void seekForward() {
        verifyApplicationThread();
        long currentPosition = getCurrentPosition() + ((long) this.seekForwardIncrementMs);
        long duration = getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        seekToCurrentItem(Math.max(currentPosition, 0L));
    }

    public final void seekTo(int i, long j, boolean z) {
        verifyApplicationThread();
        if (i == -1) {
            return;
        }
        UtilsKt.checkArgument(i >= 0);
        Timeline timeline = this.playbackInfo.timeline;
        if (timeline.isEmpty() || i < timeline.getWindowCount()) {
            DefaultAnalyticsCollector defaultAnalyticsCollector = this.analyticsCollector;
            if (!defaultAnalyticsCollector.isSeeking) {
                AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = defaultAnalyticsCollector.generateCurrentPlayerMediaPeriodEventTime();
                defaultAnalyticsCollector.isSeeking = true;
                defaultAnalyticsCollector.sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, -1, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 26));
            }
            this.pendingOperationAcks++;
            if (isPlayingAd()) {
                Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate = new ExoPlayerImplInternal.PlaybackInfoUpdate(this.playbackInfo);
                playbackInfoUpdate.incrementPendingOperationAcks(1);
                ExoPlayerImpl exoPlayerImpl = this.playbackInfoUpdateListener.f$0;
                exoPlayerImpl.playbackInfoUpdateHandler.post(new ComponentActivity$$ExternalSyntheticLambda10(exoPlayerImpl, playbackInfoUpdate, (byte) 13));
                return;
            }
            PlaybackInfo playbackInfoCopyWithPlaybackState = this.playbackInfo;
            int i2 = playbackInfoCopyWithPlaybackState.playbackState;
            if (i2 == 3 || (i2 == 4 && !timeline.isEmpty())) {
                playbackInfoCopyWithPlaybackState = this.playbackInfo.copyWithPlaybackState(2);
            }
            int currentMediaItemIndex = getCurrentMediaItemIndex();
            PlaybackInfo playbackInfoMaskTimelineAndPosition = maskTimelineAndPosition(playbackInfoCopyWithPlaybackState, timeline, maskWindowPositionMsOrGetPeriodPositionUs(timeline, i, j));
            this.internalPlayer.handler.obtainMessage(3, new ExoPlayerImplInternal.SeekPosition(timeline, i, Util.msToUs(j))).sendToTarget();
            updatePlaybackInfo(playbackInfoMaskTimelineAndPosition, 0, true, 1, getCurrentPositionUsInternal(playbackInfoMaskTimelineAndPosition), currentMediaItemIndex, z);
        }
    }

    public final void seekToCurrentItem(long j) {
        seekTo(getCurrentMediaItemIndex(), j, false);
    }

    @Override // androidx.media3.common.Player
    public final void seekToDefaultPosition() {
        seekTo(getCurrentMediaItemIndex(), -9223372036854775807L, false);
    }

    @Override // androidx.media3.common.Player
    public final void seekToNext() {
        if (getCurrentTimeline().isEmpty() || isPlayingAd()) {
            verifyApplicationThread();
            return;
        }
        if (!hasNextMediaItem()) {
            if (isCurrentMediaItemLive() && isCurrentMediaItemDynamic()) {
                seekTo(getCurrentMediaItemIndex(), -9223372036854775807L, false);
                return;
            } else {
                verifyApplicationThread();
                return;
            }
        }
        int nextMediaItemIndex = getNextMediaItemIndex();
        if (nextMediaItemIndex == -1) {
            verifyApplicationThread();
        } else if (nextMediaItemIndex == getCurrentMediaItemIndex()) {
            seekTo(getCurrentMediaItemIndex(), -9223372036854775807L, true);
        } else {
            seekTo(nextMediaItemIndex, -9223372036854775807L, false);
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekToNextMediaItem() {
        int nextMediaItemIndex = getNextMediaItemIndex();
        if (nextMediaItemIndex == -1) {
            verifyApplicationThread();
        } else if (nextMediaItemIndex == getCurrentMediaItemIndex()) {
            seekTo(getCurrentMediaItemIndex(), -9223372036854775807L, true);
        } else {
            seekTo(nextMediaItemIndex, -9223372036854775807L, false);
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekToPrevious() {
        if (getCurrentTimeline().isEmpty() || isPlayingAd()) {
            verifyApplicationThread();
            return;
        }
        boolean zHasPreviousMediaItem = hasPreviousMediaItem();
        if (isCurrentMediaItemLive() && !isCurrentMediaItemSeekable()) {
            if (zHasPreviousMediaItem) {
                seekToPreviousMediaItemInternal();
                return;
            } else {
                verifyApplicationThread();
                return;
            }
        }
        if (zHasPreviousMediaItem) {
            long currentPosition = getCurrentPosition();
            verifyApplicationThread();
            if (currentPosition <= this.maxSeekToPreviousPositionMs) {
                seekToPreviousMediaItemInternal();
                return;
            }
        }
        seekToCurrentItem(0L);
    }

    @Override // androidx.media3.common.Player
    public final void seekToPreviousMediaItem() {
        seekToPreviousMediaItemInternal();
    }

    public final void seekToPreviousMediaItemInternal() {
        int previousMediaItemIndex = getPreviousMediaItemIndex();
        if (previousMediaItemIndex == -1) {
            verifyApplicationThread();
        } else if (previousMediaItemIndex == getCurrentMediaItemIndex()) {
            seekTo(getCurrentMediaItemIndex(), -9223372036854775807L, true);
        } else {
            seekTo(previousMediaItemIndex, -9223372036854775807L, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void sendRendererMessage(int i, int i2, Object obj) {
        for (BaseRenderer baseRenderer : this.renderers) {
            if (i == -1 || baseRenderer.trackType == i) {
                PlayerMessage playerMessageCreateMessageInternal = createMessageInternal(baseRenderer);
                UtilsKt.checkState(!playerMessageCreateMessageInternal.isSent);
                playerMessageCreateMessageInternal.type = i2;
                UtilsKt.checkState(!playerMessageCreateMessageInternal.isSent);
                playerMessageCreateMessageInternal.payload = obj;
                playerMessageCreateMessageInternal.send();
            }
        }
        for (BaseRenderer baseRenderer2 : this.secondaryRenderers) {
            if (baseRenderer2 != null && (i == -1 || baseRenderer2.trackType == i)) {
                PlayerMessage playerMessageCreateMessageInternal2 = createMessageInternal(baseRenderer2);
                UtilsKt.checkState(!playerMessageCreateMessageInternal2.isSent);
                playerMessageCreateMessageInternal2.type = i2;
                UtilsKt.checkState(!playerMessageCreateMessageInternal2.isSent);
                playerMessageCreateMessageInternal2.payload = obj;
                playerMessageCreateMessageInternal2.send();
            }
        }
    }

    @Override // androidx.media3.common.Player
    public final void setAudioAttributes(AudioAttributes audioAttributes, boolean z) {
        int i;
        verifyApplicationThread();
        if (this.playerReleased) {
            return;
        }
        boolean zEquals = Objects.equals(this.audioAttributes, audioAttributes);
        byte b = 0;
        ListenerSet listenerSet = this.listeners;
        if (!zEquals) {
            this.audioAttributes = audioAttributes;
            sendRendererMessage(1, 3, audioAttributes);
            RulerTrackingMap rulerTrackingMap = this.streamVolumeManager;
            if (rulerTrackingMap != null) {
                try {
                    int volumeControlStream = audioAttributes.getPlatformAudioAttributes().getVolumeControlStream();
                    i = volumeControlStream == Integer.MIN_VALUE ? 3 : volumeControlStream;
                } catch (RuntimeException unused) {
                }
                RulerTrackingMap rulerTrackingMap2 = (RulerTrackingMap) rulerTrackingMap.accessFlags;
                StreamVolumeManager$$ExternalSyntheticLambda3 streamVolumeManager$$ExternalSyntheticLambda3 = new StreamVolumeManager$$ExternalSyntheticLambda3(rulerTrackingMap, i, (byte) 1);
                rulerTrackingMap2.getClass();
                UtilsKt.checkState(Looper.myLooper() == ((SystemHandlerWrapper) rulerTrackingMap2.values).handler.getLooper());
                rulerTrackingMap2.size++;
                rulerTrackingMap2.runInBackground(new ComponentActivity$$ExternalSyntheticLambda10(rulerTrackingMap2, streamVolumeManager$$ExternalSyntheticLambda3, (byte) 6));
                StreamVolumeManager$StreamVolumeState streamVolumeManager$StreamVolumeState = (StreamVolumeManager$StreamVolumeState) rulerTrackingMap2.layoutNodes;
                rulerTrackingMap2.updateStateInForeground(new StreamVolumeManager$StreamVolumeState(streamVolumeManager$StreamVolumeState.muted, i, streamVolumeManager$StreamVolumeState.volume, streamVolumeManager$StreamVolumeState.minVolume, streamVolumeManager$StreamVolumeState.maxVolume));
            }
            listenerSet.queueEvent(20, new ExoPlayerImpl$$ExternalSyntheticLambda27(audioAttributes, b));
        }
        AudioAttributes audioAttributes2 = this.audioAttributes;
        SystemHandlerWrapper systemHandlerWrapper = this.internalPlayer.handler;
        systemHandlerWrapper.getClass();
        SystemHandlerWrapper.SystemMessage systemMessageObtainSystemMessage = SystemHandlerWrapper.obtainSystemMessage();
        systemMessageObtainSystemMessage.message = systemHandlerWrapper.handler.obtainMessage(31, z ? 1 : 0, 0, audioAttributes2);
        systemMessageObtainSystemMessage.sendToTarget();
        listenerSet.flushEvents();
    }

    @Override // androidx.media3.common.Player
    public final void setDeviceMuted(boolean z) {
        verifyApplicationThread();
        RulerTrackingMap rulerTrackingMap = this.streamVolumeManager;
        if (rulerTrackingMap != null) {
            ((RulerTrackingMap) rulerTrackingMap.accessFlags).updateStateAsync(new StreamVolumeManager$$ExternalSyntheticLambda6(rulerTrackingMap, z), new StreamVolumeManager$$ExternalSyntheticLambda7(rulerTrackingMap, z, 1));
        }
    }

    @Override // androidx.media3.common.Player
    public final void setDeviceVolume(int i) {
        verifyApplicationThread();
        RulerTrackingMap rulerTrackingMap = this.streamVolumeManager;
        if (rulerTrackingMap != null) {
            ((RulerTrackingMap) rulerTrackingMap.accessFlags).updateStateAsync(new Timeline$$ExternalSyntheticLambda0((byte) 3, i), new StreamVolumeManager$$ExternalSyntheticLambda5(rulerTrackingMap, i, 1));
        }
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItem(MediaItem mediaItem, long j) {
        setMediaItems(ImmutableList.of((Object) mediaItem), 0, j);
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItem$1(MediaItem mediaItem) {
        setMediaItems(ImmutableList.of((Object) mediaItem));
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItems(List list) {
        verifyApplicationThread();
        ArrayList arrayListCreateMediaSources = createMediaSources(list);
        verifyApplicationThread();
        setMediaSourcesInternal(arrayListCreateMediaSources, -1, -9223372036854775807L, true);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x009d  */
    /* JADX WARN: Code duplicated, block: B:22:0x009f  */
    /* JADX WARN: Code duplicated, block: B:24:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:25:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:27:0x00ab A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:29:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e7  */
    public final void setMediaSourcesInternal(ArrayList arrayList, int i, long j, boolean z) {
        long j2;
        int i2;
        int i3;
        PlaybackInfo playbackInfoMaskPlaybackState;
        boolean z2;
        int firstWindowIndex = i;
        int currentWindowIndexInternal = getCurrentWindowIndexInternal(this.playbackInfo);
        long currentPosition = getCurrentPosition();
        this.pendingOperationAcks++;
        ArrayList arrayList2 = this.mediaSourceHolderSnapshots;
        arrayList2.clear();
        ArrayList arrayList3 = new ArrayList();
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            MediaSourceList.MediaSourceHolder mediaSourceHolder = new MediaSourceList.MediaSourceHolder((BaseMediaSource) arrayList.get(i4), this.useLazyPreparation);
            arrayList3.add(mediaSourceHolder);
            arrayList2.add(i4, new MediaSourceHolderSnapshot(mediaSourceHolder.uid, mediaSourceHolder.mediaSource));
        }
        ShuffleOrder$DefaultShuffleOrder shuffleOrder$DefaultShuffleOrder = this.shuffleOrder;
        int size = arrayList3.size();
        shuffleOrder$DefaultShuffleOrder.getClass();
        this.shuffleOrder = new ShuffleOrder$DefaultShuffleOrder(new Random(shuffleOrder$DefaultShuffleOrder.random.nextLong())).cloneAndInsert(0, size);
        PlaylistTimeline playlistTimelineCreateMaskingTimeline = createMaskingTimeline();
        int i5 = playlistTimelineCreateMaskingTimeline.windowCount;
        if (!playlistTimelineCreateMaskingTimeline.isEmpty() && firstWindowIndex >= i5) {
            throw new IllegalSeekPositionException();
        }
        if (!z) {
            if (firstWindowIndex == -1) {
                i2 = currentWindowIndexInternal;
                j2 = currentPosition;
            } else {
                j2 = j;
            }
            PlaybackInfo playbackInfoMaskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo, playlistTimelineCreateMaskingTimeline, maskWindowPositionMsOrGetPeriodPositionUs(playlistTimelineCreateMaskingTimeline, i2, j2));
            i3 = playbackInfoMaskTimelineAndPosition.playbackState;
            if (i3 == 1) {
                i3 = 1;
            } else if (!playlistTimelineCreateMaskingTimeline.isEmpty()) {
                i3 = 4;
            } else if (i2 != -1) {
                if (i2 >= i5) {
                    i3 = 4;
                } else {
                    i3 = 2;
                }
            }
            playbackInfoMaskPlaybackState = maskPlaybackState(playbackInfoMaskTimelineAndPosition, i3);
            this.internalPlayer.handler.obtainMessage(17, new ExoPlayerImplInternal.MediaSourceListUpdateMessage(arrayList3, this.shuffleOrder, i2, Util.msToUs(j2))).sendToTarget();
            if (!this.playbackInfo.periodId.periodUid.equals(playbackInfoMaskPlaybackState.periodId.periodUid) || this.playbackInfo.timeline.isEmpty()) {
                z2 = false;
            } else {
                z2 = true;
            }
            updatePlaybackInfo(playbackInfoMaskPlaybackState, 0, z2, 4, getCurrentPositionUsInternal(playbackInfoMaskPlaybackState), -1, false);
        }
        firstWindowIndex = playlistTimelineCreateMaskingTimeline.getFirstWindowIndex(this.shuffleModeEnabled);
        j2 = -9223372036854775807L;
        i2 = firstWindowIndex;
        PlaybackInfo playbackInfoMaskTimelineAndPosition2 = maskTimelineAndPosition(this.playbackInfo, playlistTimelineCreateMaskingTimeline, maskWindowPositionMsOrGetPeriodPositionUs(playlistTimelineCreateMaskingTimeline, i2, j2));
        i3 = playbackInfoMaskTimelineAndPosition2.playbackState;
        if (i3 == 1) {
            i3 = 1;
        } else if (!playlistTimelineCreateMaskingTimeline.isEmpty()) {
            i3 = 4;
        } else if (i2 != -1) {
            if (i2 >= i5) {
                i3 = 4;
            } else {
                i3 = 2;
            }
        }
        playbackInfoMaskPlaybackState = maskPlaybackState(playbackInfoMaskTimelineAndPosition2, i3);
        this.internalPlayer.handler.obtainMessage(17, new ExoPlayerImplInternal.MediaSourceListUpdateMessage(arrayList3, this.shuffleOrder, i2, Util.msToUs(j2))).sendToTarget();
        if (this.playbackInfo.periodId.periodUid.equals(playbackInfoMaskPlaybackState.periodId.periodUid)) {
            z2 = false;
        } else {
            z2 = false;
        }
        updatePlaybackInfo(playbackInfoMaskPlaybackState, 0, z2, 4, getCurrentPositionUsInternal(playbackInfoMaskPlaybackState), -1, false);
    }

    @Override // androidx.media3.common.Player
    public final void setPlayWhenReady(boolean z) {
        verifyApplicationThread();
        updatePlayWhenReady(1, z);
    }

    @Override // androidx.media3.common.Player
    public final void setPlaybackParameters(PlaybackParameters playbackParameters) {
        verifyApplicationThread();
        if (playbackParameters == null) {
            playbackParameters = PlaybackParameters.DEFAULT;
        }
        if (this.playbackInfo.playbackParameters.equals(playbackParameters)) {
            return;
        }
        PlaybackInfo playbackInfoCopyWithPlaybackParameters = this.playbackInfo.copyWithPlaybackParameters(playbackParameters);
        this.pendingOperationAcks++;
        this.internalPlayer.handler.obtainMessage(4, playbackParameters).sendToTarget();
        updatePlaybackInfo(playbackInfoCopyWithPlaybackParameters, 0, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // androidx.media3.common.Player
    public final void setPlaybackSpeed(float f) {
        setPlaybackParameters(new PlaybackParameters(f, getPlaybackParameters().pitch));
    }

    @Override // androidx.media3.common.Player
    public final void setPlaylistMetadata(MediaMetadata mediaMetadata) {
        verifyApplicationThread();
        mediaMetadata.getClass();
        if (mediaMetadata.equals(this.playlistMetadata)) {
            return;
        }
        this.playlistMetadata = mediaMetadata;
        this.listeners.sendEvent(15, new ExoPlayerImpl$$ExternalSyntheticLambda20(this, (byte) 3));
    }

    @Override // androidx.media3.common.Player
    public final void setRepeatMode(int i) {
        verifyApplicationThread();
        if (this.repeatMode != i) {
            this.repeatMode = i;
            SystemHandlerWrapper systemHandlerWrapper = this.internalPlayer.handler;
            systemHandlerWrapper.getClass();
            SystemHandlerWrapper.SystemMessage systemMessageObtainSystemMessage = SystemHandlerWrapper.obtainSystemMessage();
            systemMessageObtainSystemMessage.message = systemHandlerWrapper.handler.obtainMessage(11, i, 0);
            systemMessageObtainSystemMessage.sendToTarget();
            UCropActivity$$ExternalSyntheticLambda1 uCropActivity$$ExternalSyntheticLambda1 = new UCropActivity$$ExternalSyntheticLambda1((byte) 1, i);
            ListenerSet listenerSet = this.listeners;
            listenerSet.queueEvent(8, uCropActivity$$ExternalSyntheticLambda1);
            updateAvailableCommands();
            listenerSet.flushEvents();
        }
    }

    @Override // androidx.media3.common.Player
    public final void setShuffleModeEnabled(boolean z) {
        verifyApplicationThread();
        if (this.shuffleModeEnabled != z) {
            this.shuffleModeEnabled = z;
            SystemHandlerWrapper systemHandlerWrapper = this.internalPlayer.handler;
            systemHandlerWrapper.getClass();
            SystemHandlerWrapper.SystemMessage systemMessageObtainSystemMessage = SystemHandlerWrapper.obtainSystemMessage();
            systemMessageObtainSystemMessage.message = systemHandlerWrapper.handler.obtainMessage(12, z ? 1 : 0, 0);
            systemMessageObtainSystemMessage.sendToTarget();
            ExoPlayerImpl$$ExternalSyntheticLambda14 exoPlayerImpl$$ExternalSyntheticLambda14 = new ExoPlayerImpl$$ExternalSyntheticLambda14((byte) 1, z);
            ListenerSet listenerSet = this.listeners;
            listenerSet.queueEvent(9, exoPlayerImpl$$ExternalSyntheticLambda14);
            updateAvailableCommands();
            listenerSet.flushEvents();
        }
    }

    public final void setShuffleOrder(ShuffleOrder$DefaultShuffleOrder shuffleOrder$DefaultShuffleOrder) {
        verifyApplicationThread();
        UtilsKt.checkArgument(shuffleOrder$DefaultShuffleOrder.shuffled.length == this.mediaSourceHolderSnapshots.size());
        this.shuffleOrder = shuffleOrder$DefaultShuffleOrder;
        PlaylistTimeline playlistTimelineCreateMaskingTimeline = createMaskingTimeline();
        PlaybackInfo playbackInfoMaskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo, playlistTimelineCreateMaskingTimeline, maskWindowPositionMsOrGetPeriodPositionUs(playlistTimelineCreateMaskingTimeline, getCurrentMediaItemIndex(), getCurrentPosition()));
        this.pendingOperationAcks++;
        this.internalPlayer.handler.obtainMessage(21, shuffleOrder$DefaultShuffleOrder).sendToTarget();
        updatePlaybackInfo(playbackInfoMaskTimelineAndPosition, 0, false, 5, -9223372036854775807L, -1, false);
    }

    public final void setSkipSilenceEnabled(boolean z) {
        verifyApplicationThread();
        if (this.skipSilenceEnabled == z) {
            return;
        }
        this.skipSilenceEnabled = z;
        sendRendererMessage(1, 9, Boolean.valueOf(z));
        this.listeners.sendEvent(23, new ExoPlayerImpl$$ExternalSyntheticLambda14((byte) 0, z));
    }

    @Override // androidx.media3.common.Player
    public final void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        verifyApplicationThread();
        DefaultTrackSelector defaultTrackSelector = this.trackSelector;
        defaultTrackSelector.getClass();
        TrackSelectionParameters trackSelectionParameters2 = getTrackSelectionParameters();
        if (!trackSelectionParameters.equals(defaultTrackSelector.getParameters())) {
            if (trackSelectionParameters instanceof DefaultTrackSelector.Parameters) {
                defaultTrackSelector.setParametersInternal((DefaultTrackSelector.Parameters) trackSelectionParameters);
            }
            DefaultTrackSelector.Parameters.Builder builder = new DefaultTrackSelector.Parameters.Builder(defaultTrackSelector.getParameters());
            builder.init(trackSelectionParameters);
            defaultTrackSelector.setParametersInternal(new DefaultTrackSelector.Parameters(builder));
        }
        if (trackSelectionParameters2.equals(trackSelectionParameters)) {
            return;
        }
        this.listeners.sendEvent(19, new ExoPlayerImpl$$ExternalSyntheticLambda23(trackSelectionParameters, (byte) 0));
    }

    public final void setVideoOutputInternal(Surface surface) {
        Object obj = this.videoOutput;
        boolean zBlockUninterruptible = true;
        boolean z = (obj == null || obj == surface) ? false : true;
        long j = z ? this.detachSurfaceTimeoutMs : -9223372036854775807L;
        ExoPlayerImplInternal exoPlayerImplInternal = this.internalPlayer;
        if (!exoPlayerImplInternal.releasedOnApplicationThread && exoPlayerImplInternal.playbackLooper.getThread().isAlive()) {
            ConditionVariable conditionVariable = new ConditionVariable(0);
            exoPlayerImplInternal.handler.obtainMessage(30, new Pair(surface, conditionVariable)).sendToTarget();
            if (j != -9223372036854775807L) {
                zBlockUninterruptible = conditionVariable.blockUninterruptible(j);
            }
        }
        if (z) {
            Object obj2 = this.videoOutput;
            Surface surface2 = this.ownedSurface;
            if (obj2 == surface2) {
                surface2.release();
                this.ownedSurface = null;
            }
        }
        this.videoOutput = surface;
        if (zBlockUninterruptible) {
            return;
        }
        stopInternal(new ExoPlaybackException(2, new HttpException("Detaching surface timed out."), 1003));
    }

    @Override // androidx.media3.common.Player
    public final void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        verifyApplicationThread();
        if (surfaceHolder == null) {
            verifyApplicationThread();
            removeSurfaceCallbacks();
            setVideoOutputInternal(null);
            maybeNotifySurfaceSizeChanged(0, 0);
            return;
        }
        removeSurfaceCallbacks();
        this.surfaceHolderSurfaceIsVideoOutput = true;
        this.surfaceHolder = surfaceHolder;
        surfaceHolder.addCallback(this.componentListener);
        Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            setVideoOutputInternal(null);
            maybeNotifySurfaceSizeChanged(0, 0);
        } else {
            setVideoOutputInternal(surface);
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            maybeNotifySurfaceSizeChanged(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // androidx.media3.common.Player
    public final void setVolume(float f) {
        verifyApplicationThread();
        float fConstrainValue = Util.constrainValue(f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
        float f2 = this.volume;
        if (f2 == fConstrainValue) {
            return;
        }
        if (fConstrainValue != CropImageView.DEFAULT_ASPECT_RATIO) {
            f2 = fConstrainValue;
        }
        this.unmuteVolume = f2;
        this.volume = fConstrainValue;
        this.internalPlayer.handler.obtainMessage(32, Float.valueOf(fConstrainValue)).sendToTarget();
        this.listeners.sendEvent(22, new ExoPlayerImpl$$ExternalSyntheticLambda15(fConstrainValue, (byte) 0));
    }

    @Override // androidx.media3.common.Player
    public final void stop() {
        verifyApplicationThread();
        stopInternal(null);
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        this.currentCueGroup = new CueGroup(RegularImmutableList.EMPTY, this.playbackInfo.positionUs);
    }

    public final void stopInternal(ExoPlaybackException exoPlaybackException) {
        PlaybackInfo playbackInfo = this.playbackInfo;
        PlaybackInfo playbackInfoCopyWithLoadingMediaPeriodId = playbackInfo.copyWithLoadingMediaPeriodId(playbackInfo.periodId);
        playbackInfoCopyWithLoadingMediaPeriodId.bufferedPositionUs = playbackInfoCopyWithLoadingMediaPeriodId.positionUs;
        playbackInfoCopyWithLoadingMediaPeriodId.totalBufferedDurationUs = 0L;
        PlaybackInfo playbackInfoMaskPlaybackState = maskPlaybackState(playbackInfoCopyWithLoadingMediaPeriodId, 1);
        if (exoPlaybackException != null) {
            playbackInfoMaskPlaybackState = playbackInfoMaskPlaybackState.copyWithPlaybackError(exoPlaybackException);
        }
        this.pendingOperationAcks++;
        this.internalPlayer.handler.obtainMessage(6).sendToTarget();
        updatePlaybackInfo(playbackInfoMaskPlaybackState, 0, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // androidx.media3.common.Player
    public final void unmute() {
        verifyApplicationThread();
        if (this.volume == CropImageView.DEFAULT_ASPECT_RATIO) {
            float f = this.unmuteVolume;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                setVolume(f);
            }
        }
    }

    public final void updateAvailableCommands() {
        Player.Commands commands = this.availableCommands;
        String str = Util.DEVICE_DEBUG_INFO;
        ExoPlayerImpl exoPlayerImpl = this.wrappingPlayer;
        boolean zIsPlayingAd = exoPlayerImpl.isPlayingAd();
        boolean zIsCurrentMediaItemSeekable = exoPlayerImpl.isCurrentMediaItemSeekable();
        boolean zHasPreviousMediaItem = exoPlayerImpl.hasPreviousMediaItem();
        boolean zHasNextMediaItem = exoPlayerImpl.hasNextMediaItem();
        boolean zIsCurrentMediaItemLive = exoPlayerImpl.isCurrentMediaItemLive();
        boolean zIsCurrentMediaItemDynamic = exoPlayerImpl.isCurrentMediaItemDynamic();
        boolean zIsEmpty = exoPlayerImpl.getCurrentTimeline().isEmpty();
        boolean z = false;
        FlagSet.Builder builder = new FlagSet.Builder((byte) 0);
        builder.addAll(this.permanentAvailableCommands.flags);
        byte b = 4;
        if (!zIsPlayingAd) {
            builder.add(4);
        }
        if (zIsCurrentMediaItemSeekable && !zIsPlayingAd) {
            builder.add(5);
        }
        if (zHasPreviousMediaItem && !zIsPlayingAd) {
            builder.add(6);
        }
        if (!zIsEmpty && (zHasPreviousMediaItem || !zIsCurrentMediaItemLive || zIsCurrentMediaItemSeekable) && !zIsPlayingAd) {
            builder.add(7);
        }
        if (zHasNextMediaItem && !zIsPlayingAd) {
            builder.add(8);
        }
        if (!zIsEmpty && (zHasNextMediaItem || (zIsCurrentMediaItemLive && zIsCurrentMediaItemDynamic)) && !zIsPlayingAd) {
            builder.add(9);
        }
        if (!zIsPlayingAd) {
            builder.add(10);
        }
        if (zIsCurrentMediaItemSeekable && !zIsPlayingAd) {
            builder.add(11);
        }
        if (zIsCurrentMediaItemSeekable && !zIsPlayingAd) {
            z = true;
        }
        if (z) {
            builder.add(12);
        }
        Player.Commands commands2 = new Player.Commands(builder.build());
        this.availableCommands = commands2;
        if (commands2.equals(commands)) {
            return;
        }
        this.listeners.queueEvent(13, new ExoPlayerImpl$$ExternalSyntheticLambda20(this, b));
    }

    public final void updatePlayWhenReady(int i, boolean z) {
        PlaybackInfo playbackInfoCopyWithEstimatedPosition = this.playbackInfo;
        int i2 = playbackInfoCopyWithEstimatedPosition.playbackSuppressionReason;
        int i3 = (i2 != 1 || z) ? 0 : 1;
        if (playbackInfoCopyWithEstimatedPosition.playWhenReady == z && i2 == i3 && playbackInfoCopyWithEstimatedPosition.playWhenReadyChangeReason == i) {
            return;
        }
        this.pendingOperationAcks++;
        if (playbackInfoCopyWithEstimatedPosition.sleepingForOffload) {
            playbackInfoCopyWithEstimatedPosition = playbackInfoCopyWithEstimatedPosition.copyWithEstimatedPosition();
        }
        PlaybackInfo playbackInfoCopyWithPlayWhenReady = playbackInfoCopyWithEstimatedPosition.copyWithPlayWhenReady(i, z, i3);
        SystemHandlerWrapper systemHandlerWrapper = this.internalPlayer.handler;
        systemHandlerWrapper.getClass();
        SystemHandlerWrapper.SystemMessage systemMessageObtainSystemMessage = SystemHandlerWrapper.obtainSystemMessage();
        systemMessageObtainSystemMessage.message = systemHandlerWrapper.handler.obtainMessage(1, z ? 1 : 0, i | (i3 << 4));
        systemMessageObtainSystemMessage.sendToTarget();
        updatePlaybackInfo(playbackInfoCopyWithPlayWhenReady, 0, false, 5, -9223372036854775807L, -1, false);
    }

    public final void updatePlaybackInfo(final PlaybackInfo playbackInfo, int i, boolean z, int i2, long j, int i3, boolean z2) {
        Pair pair;
        int i4;
        MediaItem mediaItem;
        int i5;
        int i6;
        Object obj;
        MediaItem mediaItem2;
        Object obj2;
        long j2;
        long j3;
        long requestedContentPositionUs;
        long requestedContentPositionUs2;
        Object obj3;
        MediaItem mediaItem3;
        Object obj4;
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        this.playbackInfo = playbackInfo;
        boolean zEquals = playbackInfo2.timeline.equals(playbackInfo.timeline);
        Timeline.Window window = this.window;
        Timeline.Period period = this.period;
        Timeline timeline = playbackInfo2.timeline;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = playbackInfo2.periodId;
        Timeline timeline2 = playbackInfo.timeline;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = playbackInfo.periodId;
        if (timeline2.isEmpty() && timeline.isEmpty()) {
            pair = new Pair(Boolean.FALSE, -1);
        } else if (timeline2.isEmpty() != timeline.isEmpty()) {
            pair = new Pair(Boolean.TRUE, 3);
        } else if (!timeline.getWindow(timeline.getPeriodByUid(mediaSource$MediaPeriodId.periodUid, period).windowIndex, window, 0L).uid.equals(timeline2.getWindow(timeline2.getPeriodByUid(mediaSource$MediaPeriodId2.periodUid, period).windowIndex, window, 0L).uid)) {
            if (z && i2 == 0) {
                i4 = 1;
            } else if (z && i2 == 1) {
                i4 = 2;
            } else {
                if (zEquals) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m();
                    return;
                }
                i4 = 3;
            }
            pair = new Pair(Boolean.TRUE, Integer.valueOf(i4));
        } else if (z && i2 == 0 && mediaSource$MediaPeriodId.windowSequenceNumber < mediaSource$MediaPeriodId2.windowSequenceNumber) {
            pair = new Pair(Boolean.TRUE, 0);
        } else {
            pair = (z && i2 == 1 && z2) ? new Pair(Boolean.TRUE, 2) : new Pair(Boolean.FALSE, -1);
        }
        boolean zBooleanValue = ((Boolean) pair.first).booleanValue();
        int iIntValue = ((Integer) pair.second).intValue();
        if (zBooleanValue) {
            mediaItem = playbackInfo.timeline.isEmpty() ? null : playbackInfo.timeline.getWindow(playbackInfo.timeline.getPeriodByUid(playbackInfo.periodId.periodUid, this.period).windowIndex, this.window, 0L).mediaItem;
            this.staticAndDynamicMediaMetadata = MediaMetadata.EMPTY;
        } else {
            mediaItem = null;
        }
        if (zBooleanValue || !playbackInfo2.staticMetadata.equals(playbackInfo.staticMetadata)) {
            MediaMetadata.Builder builderBuildUpon = this.staticAndDynamicMediaMetadata.buildUpon();
            List list = playbackInfo.staticMetadata;
            for (int i7 = 0; i7 < list.size(); i7++) {
                Metadata metadata = (Metadata) list.get(i7);
                int i8 = 0;
                while (true) {
                    Metadata.Entry[] entryArr = metadata.entries;
                    if (i8 < entryArr.length) {
                        entryArr[i8].populateMediaMetadata(builderBuildUpon);
                        i8++;
                    }
                }
            }
            this.staticAndDynamicMediaMetadata = new MediaMetadata(builderBuildUpon);
        }
        MediaMetadata mediaMetadataBuildUpdatedMediaMetadata = buildUpdatedMediaMetadata();
        boolean zEquals2 = mediaMetadataBuildUpdatedMediaMetadata.equals(this.mediaMetadata);
        this.mediaMetadata = mediaMetadataBuildUpdatedMediaMetadata;
        boolean z3 = playbackInfo2.playWhenReady != playbackInfo.playWhenReady;
        boolean z4 = playbackInfo2.playbackState != playbackInfo.playbackState;
        if (z4 || z3) {
            updateWakeAndWifiLock();
        }
        boolean z5 = playbackInfo2.isLoading != playbackInfo.isLoading;
        if (!zEquals) {
            this.listeners.queueEvent(0, new ExoPlayerImpl$$ExternalSyntheticLambda0(playbackInfo, i));
        }
        if (z) {
            Timeline.Period period2 = new Timeline.Period();
            if (playbackInfo2.timeline.isEmpty()) {
                i5 = i3;
                i6 = i5;
                obj = null;
                mediaItem2 = null;
                obj2 = null;
            } else {
                Object obj5 = playbackInfo2.periodId.periodUid;
                playbackInfo2.timeline.getPeriodByUid(obj5, period2);
                int i9 = period2.windowIndex;
                int indexOfPeriod = playbackInfo2.timeline.getIndexOfPeriod(obj5);
                obj = playbackInfo2.timeline.getWindow(i9, this.window, 0L).uid;
                mediaItem2 = this.window.mediaItem;
                obj2 = obj5;
                i5 = i9;
                i6 = indexOfPeriod;
            }
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId3 = playbackInfo2.periodId;
            if (i2 == 0) {
                boolean zIsAd = mediaSource$MediaPeriodId3.isAd();
                MediaSource$MediaPeriodId mediaSource$MediaPeriodId4 = playbackInfo2.periodId;
                if (zIsAd) {
                    requestedContentPositionUs = period2.getAdDurationUs(mediaSource$MediaPeriodId4.adGroupIndex, mediaSource$MediaPeriodId4.adIndexInAdGroup);
                    requestedContentPositionUs2 = getRequestedContentPositionUs(playbackInfo2);
                } else {
                    if (mediaSource$MediaPeriodId4.nextAdGroupIndex != -1) {
                        requestedContentPositionUs = getRequestedContentPositionUs(this.playbackInfo);
                    } else {
                        j2 = period2.positionInWindowUs;
                        j3 = period2.durationUs;
                        requestedContentPositionUs = j2 + j3;
                    }
                    requestedContentPositionUs2 = requestedContentPositionUs;
                }
            } else if (mediaSource$MediaPeriodId3.isAd()) {
                requestedContentPositionUs = playbackInfo2.positionUs;
                requestedContentPositionUs2 = getRequestedContentPositionUs(playbackInfo2);
            } else {
                j2 = period2.positionInWindowUs;
                j3 = playbackInfo2.positionUs;
                requestedContentPositionUs = j2 + j3;
                requestedContentPositionUs2 = requestedContentPositionUs;
            }
            long jUsToMs = Util.usToMs(requestedContentPositionUs);
            long jUsToMs2 = Util.usToMs(requestedContentPositionUs2);
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId5 = playbackInfo2.periodId;
            Player.PositionInfo positionInfo = new Player.PositionInfo(obj, i5, mediaItem2, obj2, i6, jUsToMs, jUsToMs2, mediaSource$MediaPeriodId5.adGroupIndex, mediaSource$MediaPeriodId5.adIndexInAdGroup);
            Timeline.Window window2 = this.window;
            int currentMediaItemIndex = getCurrentMediaItemIndex();
            int currentPeriodIndex = getCurrentPeriodIndex();
            if (this.playbackInfo.timeline.isEmpty()) {
                obj3 = null;
                mediaItem3 = null;
                obj4 = null;
            } else {
                PlaybackInfo playbackInfo3 = this.playbackInfo;
                Object obj6 = playbackInfo3.periodId.periodUid;
                playbackInfo3.timeline.getPeriodByUid(obj6, this.period);
                currentPeriodIndex = this.playbackInfo.timeline.getIndexOfPeriod(obj6);
                Object obj7 = this.playbackInfo.timeline.getWindow(currentMediaItemIndex, window2, 0L).uid;
                mediaItem3 = window2.mediaItem;
                obj4 = obj6;
                obj3 = obj7;
            }
            int i10 = currentPeriodIndex;
            long jUsToMs3 = Util.usToMs(j);
            long jUsToMs4 = this.playbackInfo.periodId.isAd() ? Util.usToMs(getRequestedContentPositionUs(this.playbackInfo)) : jUsToMs3;
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId6 = this.playbackInfo.periodId;
            this.listeners.queueEvent(11, new ExoPlayerImpl$$ExternalSyntheticLambda5(i2, positionInfo, new Player.PositionInfo(obj3, currentMediaItemIndex, mediaItem3, obj4, i10, jUsToMs3, jUsToMs4, mediaSource$MediaPeriodId6.adGroupIndex, mediaSource$MediaPeriodId6.adIndexInAdGroup)));
        } else {
            zBooleanValue = zBooleanValue;
            zEquals2 = zEquals2;
            z4 = z4;
        }
        if (zBooleanValue) {
            this.listeners.queueEvent(1, new ExoPlayerImpl$$ExternalSyntheticLambda6((Object) mediaItem, iIntValue, (byte) 0));
        }
        final byte b = 7;
        if (playbackInfo2.playbackError != playbackInfo.playbackError) {
            this.listeners.queueEvent(10, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda1
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj8) {
                    byte b2 = b;
                    PlaybackInfo playbackInfo4 = playbackInfo;
                    Player.Listener listener = (Player.Listener) obj8;
                    switch (b2) {
                        case 0:
                            listener.onPlayWhenReadyChanged(playbackInfo4.playWhenReadyChangeReason, playbackInfo4.playWhenReady);
                            break;
                        case 1:
                            listener.onLoadingChanged(playbackInfo4.isLoading);
                            listener.onIsLoadingChanged(playbackInfo4.isLoading);
                            break;
                        case 2:
                            listener.onPlayerStateChanged(playbackInfo4.playbackState, playbackInfo4.playWhenReady);
                            break;
                        case 3:
                            listener.onPlaybackStateChanged(playbackInfo4.playbackState);
                            break;
                        case 4:
                            listener.onPlaybackSuppressionReasonChanged(playbackInfo4.playbackSuppressionReason);
                            break;
                        case 5:
                            listener.onIsPlayingChanged(playbackInfo4.isPlaying());
                            break;
                        case 6:
                            listener.onPlaybackParametersChanged(playbackInfo4.playbackParameters);
                            break;
                        case 7:
                            listener.onPlayerErrorChanged(playbackInfo4.playbackError);
                            break;
                        case 8:
                            listener.onPlayerError(playbackInfo4.playbackError);
                            break;
                        default:
                            listener.onTracksChanged(playbackInfo4.trackSelectorResult.tracks);
                            break;
                    }
                }
            });
            if (playbackInfo.playbackError != null) {
                final byte b2 = 8;
                this.listeners.queueEvent(10, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda1
                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj8) {
                        byte b3 = b2;
                        PlaybackInfo playbackInfo4 = playbackInfo;
                        Player.Listener listener = (Player.Listener) obj8;
                        switch (b3) {
                            case 0:
                                listener.onPlayWhenReadyChanged(playbackInfo4.playWhenReadyChangeReason, playbackInfo4.playWhenReady);
                                break;
                            case 1:
                                listener.onLoadingChanged(playbackInfo4.isLoading);
                                listener.onIsLoadingChanged(playbackInfo4.isLoading);
                                break;
                            case 2:
                                listener.onPlayerStateChanged(playbackInfo4.playbackState, playbackInfo4.playWhenReady);
                                break;
                            case 3:
                                listener.onPlaybackStateChanged(playbackInfo4.playbackState);
                                break;
                            case 4:
                                listener.onPlaybackSuppressionReasonChanged(playbackInfo4.playbackSuppressionReason);
                                break;
                            case 5:
                                listener.onIsPlayingChanged(playbackInfo4.isPlaying());
                                break;
                            case 6:
                                listener.onPlaybackParametersChanged(playbackInfo4.playbackParameters);
                                break;
                            case 7:
                                listener.onPlayerErrorChanged(playbackInfo4.playbackError);
                                break;
                            case 8:
                                listener.onPlayerError(playbackInfo4.playbackError);
                                break;
                            default:
                                listener.onTracksChanged(playbackInfo4.trackSelectorResult.tracks);
                                break;
                        }
                    }
                });
            }
        }
        TrackSelectorResult trackSelectorResult = playbackInfo2.trackSelectorResult;
        TrackSelectorResult trackSelectorResult2 = playbackInfo.trackSelectorResult;
        if (trackSelectorResult != trackSelectorResult2) {
            DefaultTrackSelector defaultTrackSelector = this.trackSelector;
            Object obj8 = trackSelectorResult2.info;
            defaultTrackSelector.getClass();
            final byte b3 = 9;
            this.listeners.queueEvent(2, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda1
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj9) {
                    byte b4 = b3;
                    PlaybackInfo playbackInfo4 = playbackInfo;
                    Player.Listener listener = (Player.Listener) obj9;
                    switch (b4) {
                        case 0:
                            listener.onPlayWhenReadyChanged(playbackInfo4.playWhenReadyChangeReason, playbackInfo4.playWhenReady);
                            break;
                        case 1:
                            listener.onLoadingChanged(playbackInfo4.isLoading);
                            listener.onIsLoadingChanged(playbackInfo4.isLoading);
                            break;
                        case 2:
                            listener.onPlayerStateChanged(playbackInfo4.playbackState, playbackInfo4.playWhenReady);
                            break;
                        case 3:
                            listener.onPlaybackStateChanged(playbackInfo4.playbackState);
                            break;
                        case 4:
                            listener.onPlaybackSuppressionReasonChanged(playbackInfo4.playbackSuppressionReason);
                            break;
                        case 5:
                            listener.onIsPlayingChanged(playbackInfo4.isPlaying());
                            break;
                        case 6:
                            listener.onPlaybackParametersChanged(playbackInfo4.playbackParameters);
                            break;
                        case 7:
                            listener.onPlayerErrorChanged(playbackInfo4.playbackError);
                            break;
                        case 8:
                            listener.onPlayerError(playbackInfo4.playbackError);
                            break;
                        default:
                            listener.onTracksChanged(playbackInfo4.trackSelectorResult.tracks);
                            break;
                    }
                }
            });
        }
        if (!zEquals2) {
            this.listeners.queueEvent(14, new ExoPlayerImpl$$ExternalSyntheticLambda10(this.mediaMetadata, (byte) 0));
        }
        if (z5) {
            final byte b4 = 1;
            this.listeners.queueEvent(3, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda1
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj9) {
                    byte b5 = b4;
                    PlaybackInfo playbackInfo4 = playbackInfo;
                    Player.Listener listener = (Player.Listener) obj9;
                    switch (b5) {
                        case 0:
                            listener.onPlayWhenReadyChanged(playbackInfo4.playWhenReadyChangeReason, playbackInfo4.playWhenReady);
                            break;
                        case 1:
                            listener.onLoadingChanged(playbackInfo4.isLoading);
                            listener.onIsLoadingChanged(playbackInfo4.isLoading);
                            break;
                        case 2:
                            listener.onPlayerStateChanged(playbackInfo4.playbackState, playbackInfo4.playWhenReady);
                            break;
                        case 3:
                            listener.onPlaybackStateChanged(playbackInfo4.playbackState);
                            break;
                        case 4:
                            listener.onPlaybackSuppressionReasonChanged(playbackInfo4.playbackSuppressionReason);
                            break;
                        case 5:
                            listener.onIsPlayingChanged(playbackInfo4.isPlaying());
                            break;
                        case 6:
                            listener.onPlaybackParametersChanged(playbackInfo4.playbackParameters);
                            break;
                        case 7:
                            listener.onPlayerErrorChanged(playbackInfo4.playbackError);
                            break;
                        case 8:
                            listener.onPlayerError(playbackInfo4.playbackError);
                            break;
                        default:
                            listener.onTracksChanged(playbackInfo4.trackSelectorResult.tracks);
                            break;
                    }
                }
            });
        }
        if (z4 || z3) {
            final byte b5 = 2;
            this.listeners.queueEvent(-1, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda1
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj9) {
                    byte b6 = b5;
                    PlaybackInfo playbackInfo4 = playbackInfo;
                    Player.Listener listener = (Player.Listener) obj9;
                    switch (b6) {
                        case 0:
                            listener.onPlayWhenReadyChanged(playbackInfo4.playWhenReadyChangeReason, playbackInfo4.playWhenReady);
                            break;
                        case 1:
                            listener.onLoadingChanged(playbackInfo4.isLoading);
                            listener.onIsLoadingChanged(playbackInfo4.isLoading);
                            break;
                        case 2:
                            listener.onPlayerStateChanged(playbackInfo4.playbackState, playbackInfo4.playWhenReady);
                            break;
                        case 3:
                            listener.onPlaybackStateChanged(playbackInfo4.playbackState);
                            break;
                        case 4:
                            listener.onPlaybackSuppressionReasonChanged(playbackInfo4.playbackSuppressionReason);
                            break;
                        case 5:
                            listener.onIsPlayingChanged(playbackInfo4.isPlaying());
                            break;
                        case 6:
                            listener.onPlaybackParametersChanged(playbackInfo4.playbackParameters);
                            break;
                        case 7:
                            listener.onPlayerErrorChanged(playbackInfo4.playbackError);
                            break;
                        case 8:
                            listener.onPlayerError(playbackInfo4.playbackError);
                            break;
                        default:
                            listener.onTracksChanged(playbackInfo4.trackSelectorResult.tracks);
                            break;
                    }
                }
            });
        }
        final byte b6 = 4;
        if (z4) {
            final byte b7 = 3;
            this.listeners.queueEvent(4, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda1
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj9) {
                    byte b8 = b7;
                    PlaybackInfo playbackInfo4 = playbackInfo;
                    Player.Listener listener = (Player.Listener) obj9;
                    switch (b8) {
                        case 0:
                            listener.onPlayWhenReadyChanged(playbackInfo4.playWhenReadyChangeReason, playbackInfo4.playWhenReady);
                            break;
                        case 1:
                            listener.onLoadingChanged(playbackInfo4.isLoading);
                            listener.onIsLoadingChanged(playbackInfo4.isLoading);
                            break;
                        case 2:
                            listener.onPlayerStateChanged(playbackInfo4.playbackState, playbackInfo4.playWhenReady);
                            break;
                        case 3:
                            listener.onPlaybackStateChanged(playbackInfo4.playbackState);
                            break;
                        case 4:
                            listener.onPlaybackSuppressionReasonChanged(playbackInfo4.playbackSuppressionReason);
                            break;
                        case 5:
                            listener.onIsPlayingChanged(playbackInfo4.isPlaying());
                            break;
                        case 6:
                            listener.onPlaybackParametersChanged(playbackInfo4.playbackParameters);
                            break;
                        case 7:
                            listener.onPlayerErrorChanged(playbackInfo4.playbackError);
                            break;
                        case 8:
                            listener.onPlayerError(playbackInfo4.playbackError);
                            break;
                        default:
                            listener.onTracksChanged(playbackInfo4.trackSelectorResult.tracks);
                            break;
                    }
                }
            });
        }
        final byte b8 = 5;
        if (z3 || playbackInfo2.playWhenReadyChangeReason != playbackInfo.playWhenReadyChangeReason) {
            final byte b9 = 0;
            this.listeners.queueEvent(5, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda1
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj9) {
                    byte b10 = b9;
                    PlaybackInfo playbackInfo4 = playbackInfo;
                    Player.Listener listener = (Player.Listener) obj9;
                    switch (b10) {
                        case 0:
                            listener.onPlayWhenReadyChanged(playbackInfo4.playWhenReadyChangeReason, playbackInfo4.playWhenReady);
                            break;
                        case 1:
                            listener.onLoadingChanged(playbackInfo4.isLoading);
                            listener.onIsLoadingChanged(playbackInfo4.isLoading);
                            break;
                        case 2:
                            listener.onPlayerStateChanged(playbackInfo4.playbackState, playbackInfo4.playWhenReady);
                            break;
                        case 3:
                            listener.onPlaybackStateChanged(playbackInfo4.playbackState);
                            break;
                        case 4:
                            listener.onPlaybackSuppressionReasonChanged(playbackInfo4.playbackSuppressionReason);
                            break;
                        case 5:
                            listener.onIsPlayingChanged(playbackInfo4.isPlaying());
                            break;
                        case 6:
                            listener.onPlaybackParametersChanged(playbackInfo4.playbackParameters);
                            break;
                        case 7:
                            listener.onPlayerErrorChanged(playbackInfo4.playbackError);
                            break;
                        case 8:
                            listener.onPlayerError(playbackInfo4.playbackError);
                            break;
                        default:
                            listener.onTracksChanged(playbackInfo4.trackSelectorResult.tracks);
                            break;
                    }
                }
            });
        }
        final byte b10 = 6;
        if (playbackInfo2.playbackSuppressionReason != playbackInfo.playbackSuppressionReason) {
            this.listeners.queueEvent(6, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda1
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj9) {
                    byte b11 = b6;
                    PlaybackInfo playbackInfo4 = playbackInfo;
                    Player.Listener listener = (Player.Listener) obj9;
                    switch (b11) {
                        case 0:
                            listener.onPlayWhenReadyChanged(playbackInfo4.playWhenReadyChangeReason, playbackInfo4.playWhenReady);
                            break;
                        case 1:
                            listener.onLoadingChanged(playbackInfo4.isLoading);
                            listener.onIsLoadingChanged(playbackInfo4.isLoading);
                            break;
                        case 2:
                            listener.onPlayerStateChanged(playbackInfo4.playbackState, playbackInfo4.playWhenReady);
                            break;
                        case 3:
                            listener.onPlaybackStateChanged(playbackInfo4.playbackState);
                            break;
                        case 4:
                            listener.onPlaybackSuppressionReasonChanged(playbackInfo4.playbackSuppressionReason);
                            break;
                        case 5:
                            listener.onIsPlayingChanged(playbackInfo4.isPlaying());
                            break;
                        case 6:
                            listener.onPlaybackParametersChanged(playbackInfo4.playbackParameters);
                            break;
                        case 7:
                            listener.onPlayerErrorChanged(playbackInfo4.playbackError);
                            break;
                        case 8:
                            listener.onPlayerError(playbackInfo4.playbackError);
                            break;
                        default:
                            listener.onTracksChanged(playbackInfo4.trackSelectorResult.tracks);
                            break;
                    }
                }
            });
        }
        if (playbackInfo2.isPlaying() != playbackInfo.isPlaying()) {
            this.listeners.queueEvent(7, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda1
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj9) {
                    byte b11 = b8;
                    PlaybackInfo playbackInfo4 = playbackInfo;
                    Player.Listener listener = (Player.Listener) obj9;
                    switch (b11) {
                        case 0:
                            listener.onPlayWhenReadyChanged(playbackInfo4.playWhenReadyChangeReason, playbackInfo4.playWhenReady);
                            break;
                        case 1:
                            listener.onLoadingChanged(playbackInfo4.isLoading);
                            listener.onIsLoadingChanged(playbackInfo4.isLoading);
                            break;
                        case 2:
                            listener.onPlayerStateChanged(playbackInfo4.playbackState, playbackInfo4.playWhenReady);
                            break;
                        case 3:
                            listener.onPlaybackStateChanged(playbackInfo4.playbackState);
                            break;
                        case 4:
                            listener.onPlaybackSuppressionReasonChanged(playbackInfo4.playbackSuppressionReason);
                            break;
                        case 5:
                            listener.onIsPlayingChanged(playbackInfo4.isPlaying());
                            break;
                        case 6:
                            listener.onPlaybackParametersChanged(playbackInfo4.playbackParameters);
                            break;
                        case 7:
                            listener.onPlayerErrorChanged(playbackInfo4.playbackError);
                            break;
                        case 8:
                            listener.onPlayerError(playbackInfo4.playbackError);
                            break;
                        default:
                            listener.onTracksChanged(playbackInfo4.trackSelectorResult.tracks);
                            break;
                    }
                }
            });
        }
        if (!playbackInfo2.playbackParameters.equals(playbackInfo.playbackParameters)) {
            this.listeners.queueEvent(12, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda1
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj9) {
                    byte b11 = b10;
                    PlaybackInfo playbackInfo4 = playbackInfo;
                    Player.Listener listener = (Player.Listener) obj9;
                    switch (b11) {
                        case 0:
                            listener.onPlayWhenReadyChanged(playbackInfo4.playWhenReadyChangeReason, playbackInfo4.playWhenReady);
                            break;
                        case 1:
                            listener.onLoadingChanged(playbackInfo4.isLoading);
                            listener.onIsLoadingChanged(playbackInfo4.isLoading);
                            break;
                        case 2:
                            listener.onPlayerStateChanged(playbackInfo4.playbackState, playbackInfo4.playWhenReady);
                            break;
                        case 3:
                            listener.onPlaybackStateChanged(playbackInfo4.playbackState);
                            break;
                        case 4:
                            listener.onPlaybackSuppressionReasonChanged(playbackInfo4.playbackSuppressionReason);
                            break;
                        case 5:
                            listener.onIsPlayingChanged(playbackInfo4.isPlaying());
                            break;
                        case 6:
                            listener.onPlaybackParametersChanged(playbackInfo4.playbackParameters);
                            break;
                        case 7:
                            listener.onPlayerErrorChanged(playbackInfo4.playbackError);
                            break;
                        case 8:
                            listener.onPlayerError(playbackInfo4.playbackError);
                            break;
                        default:
                            listener.onTracksChanged(playbackInfo4.trackSelectorResult.tracks);
                            break;
                    }
                }
            });
        }
        updateAvailableCommands();
        this.listeners.flushEvents();
        if (playbackInfo2.sleepingForOffload != playbackInfo.sleepingForOffload) {
            Iterator it = this.audioOffloadListeners.iterator();
            while (it.hasNext()) {
                ExoPlayerImpl.this.updateWakeAndWifiLock();
            }
        }
    }

    public final void updateWakeAndWifiLock() {
        int playbackState = getPlaybackState();
        Exchange exchange = this.wifiLockManager;
        Exchange exchange2 = this.wakeLockManager;
        boolean z = false;
        if (playbackState != 1) {
            if (playbackState == 2 || playbackState == 3) {
                verifyApplicationThread();
                boolean z2 = this.playbackInfo.sleepingForOffload;
                if (getPlayWhenReady() && !z2) {
                    z = true;
                }
                exchange2.setStayAwake(z);
                exchange.setStayAwake(getPlayWhenReady());
                return;
            }
            if (playbackState != 4) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                return;
            }
        }
        exchange2.setStayAwake(false);
        exchange.setStayAwake(false);
    }

    public final void verifyApplicationThread() {
        this.constructorFinished.blockUninterruptible();
        Thread threadCurrentThread = Thread.currentThread();
        Looper looper = this.applicationLooper;
        if (threadCurrentThread != looper.getThread()) {
            String name = Thread.currentThread().getName();
            String name2 = looper.getThread().getName();
            String str = Util.DEVICE_DEBUG_INFO;
            Locale locale = Locale.US;
            String strM = Fragment$5$$ExternalSyntheticOutline0.m("Player is accessed on the wrong thread.\nCurrent thread: '", name, "'\nExpected thread: '", name2, "'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread");
            if (this.throwsWhenUsingWrongThread) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2(strM);
            } else {
                Log.w("ExoPlayerImpl", strM, this.hasNotifiedFullWrongThreadWarning ? null : new IllegalStateException());
                this.hasNotifiedFullWrongThreadWarning = true;
            }
        }
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItem(MediaItem mediaItem) {
        setMediaItems(ImmutableList.of((Object) mediaItem));
    }

    @Override // androidx.media3.common.Player
    public final void increaseDeviceVolume(int i) {
        verifyApplicationThread();
        RulerTrackingMap rulerTrackingMap = this.streamVolumeManager;
        if (rulerTrackingMap != null) {
            rulerTrackingMap.increaseVolume(i);
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekToDefaultPosition(int i) {
        seekTo(i, -9223372036854775807L, false);
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItems(List list, int i, long j) {
        verifyApplicationThread();
        ArrayList arrayListCreateMediaSources = createMediaSources(list);
        verifyApplicationThread();
        setMediaSourcesInternal(arrayListCreateMediaSources, i, j, false);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ComponentListener implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
        public ComponentListener() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            Surface surface = new Surface(surfaceTexture);
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            exoPlayerImpl.setVideoOutputInternal(surface);
            exoPlayerImpl.ownedSurface = surface;
            exoPlayerImpl.maybeNotifySurfaceSizeChanged(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            exoPlayerImpl.setVideoOutputInternal(null);
            exoPlayerImpl.maybeNotifySurfaceSizeChanged(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            ExoPlayerImpl.this.maybeNotifySurfaceSizeChanged(i, i2);
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            ExoPlayerImpl.this.maybeNotifySurfaceSizeChanged(i2, i3);
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            if (exoPlayerImpl.surfaceHolderSurfaceIsVideoOutput) {
                exoPlayerImpl.setVideoOutputInternal(surfaceHolder.getSurface());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            if (exoPlayerImpl.surfaceHolderSurfaceIsVideoOutput) {
                exoPlayerImpl.setVideoOutputInternal(null);
            }
            exoPlayerImpl.maybeNotifySurfaceSizeChanged(0, 0);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    @Override // androidx.media3.common.Player
    public final void setDeviceMuted(int i, boolean z) {
        verifyApplicationThread();
        RulerTrackingMap rulerTrackingMap = this.streamVolumeManager;
        if (rulerTrackingMap != null) {
            ((RulerTrackingMap) rulerTrackingMap.accessFlags).updateStateAsync(new StreamVolumeManager$$ExternalSyntheticLambda6(rulerTrackingMap, z), new StreamVolumeManager$$ExternalSyntheticLambda7(rulerTrackingMap, z, i));
        }
    }

    @Override // androidx.media3.common.Player
    public final void setDeviceVolume(int i, int i2) {
        verifyApplicationThread();
        RulerTrackingMap rulerTrackingMap = this.streamVolumeManager;
        if (rulerTrackingMap != null) {
            ((RulerTrackingMap) rulerTrackingMap.accessFlags).updateStateAsync(new Timeline$$ExternalSyntheticLambda0((byte) 3, i), new StreamVolumeManager$$ExternalSyntheticLambda5(rulerTrackingMap, i, i2));
        }
    }

    @Override // androidx.media3.common.Player
    public final void decreaseDeviceVolume(int i) {
        verifyApplicationThread();
        RulerTrackingMap rulerTrackingMap = this.streamVolumeManager;
        if (rulerTrackingMap != null) {
            ((RulerTrackingMap) rulerTrackingMap.accessFlags).updateStateAsync(new Format$$ExternalSyntheticLambda1((byte) 9), new StreamVolumeManager$$ExternalSyntheticLambda3(rulerTrackingMap, i, (byte) 0));
        }
    }

    @Override // androidx.media3.common.Player
    public final void addMediaItems(List list) {
        addMediaItems(Integer.MAX_VALUE, list);
    }

    @Override // androidx.media3.common.Player
    public final void seekTo(int i, long j) {
        seekTo(i, j, false);
    }

    @Override // androidx.media3.common.Player
    public final void seekTo(long j) {
        seekToCurrentItem(j);
    }
}
