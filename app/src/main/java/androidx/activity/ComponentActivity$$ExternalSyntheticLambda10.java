package androidx.activity;

import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioRouting;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.util.LongSparseArray;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.node.RulerTrackingMap;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.platform.WrappedComposition;
import androidx.core.os.HandlerCompat$Api28Impl;
import androidx.core.provider.CallbackWrapper;
import androidx.core.view.DisplayCompat;
import androidx.core.view.MenuHostHelper$$ExternalSyntheticLambda1;
import androidx.datastore.core.AtomicInt;
import androidx.lifecycle.Lifecycle;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.BackgroundThreadStateHandler$$ExternalSyntheticLambda0;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.NetworkTypeObserver;
import androidx.media3.common.util.SystemHandlerWrapper;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.CodecParameters;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.exoplayer.ExoPlayerImplInternal;
import androidx.media3.exoplayer.PlaybackInfo;
import androidx.media3.exoplayer.PlaylistTimeline;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector$$ExternalSyntheticLambda4;
import androidx.media3.exoplayer.analytics.MediaMetricsListener;
import androidx.media3.exoplayer.audio.AudioCapabilities;
import androidx.media3.exoplayer.audio.AudioCapabilitiesReceiver;
import androidx.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher;
import androidx.media3.exoplayer.audio.AudioTrackAudioOutput$OnRoutingChangedListenerApi24$$ExternalSyntheticLambda0;
import androidx.media3.exoplayer.audio.AudioTrackAudioOutputProvider;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecCallback;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.offline.DownloadService;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.ProgressiveMediaPeriod;
import androidx.media3.exoplayer.video.DefaultVideoSink;
import androidx.media3.extractor.SeekMap;
import androidx.room.TransactionExecutor;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.base.Function;
import com.google.common.collect.RegularImmutableList;
import io.ktor.http.ContentType;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Dispatcher;
import okhttp3.internal.connection.Exchange;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComponentActivity$$ExternalSyntheticLambda10 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda10(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    /* JADX WARN: Code duplicated, block: B:147:0x030a  */
    /* JADX WARN: Code duplicated, block: B:162:0x0331  */
    /* JADX WARN: Code duplicated, block: B:163:0x0333  */
    /* JADX WARN: Code duplicated, block: B:164:0x0335  */
    /* JADX WARN: Code duplicated, block: B:166:0x033c  */
    /* JADX WARN: Code duplicated, block: B:167:0x033e  */
    /* JADX WARN: Code duplicated, block: B:170:0x0345  */
    /* JADX WARN: Code duplicated, block: B:171:0x0347  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        PowerManager.WakeLock wakeLock;
        WifiManager.WifiLock wifiLock;
        int i;
        long j;
        boolean z;
        AudioCapabilitiesReceiver audioCapabilitiesReceiver;
        byte b = 9;
        byte b2 = 1;
        byte b3 = 0;
        switch (this.$r8$classId) {
            case 0:
                ComponentActivity componentActivity = (ComponentActivity) this.f$0;
                componentActivity.getLifecycle().addObserver(new MenuHostHelper$$ExternalSyntheticLambda1((OnBackPressedDispatcher) this.f$1, componentActivity, b2));
                return;
            case 1:
                TransactionExecutor transactionExecutor = (TransactionExecutor) this.f$0;
                try {
                    ((Runnable) this.f$1).run();
                    return;
                } finally {
                    transactionExecutor.scheduleNext();
                }
            case 2:
                DisplayCompat.doTranslation((AndroidContentCaptureManager) this.f$0, (LongSparseArray) this.f$1);
                return;
            case 3:
                WrappedComposition wrappedComposition = (WrappedComposition) this.f$0;
                Lifecycle lifecycle = (Lifecycle) this.f$1;
                if (wrappedComposition.disposed) {
                    return;
                }
                wrappedComposition.addedToLifecycle = lifecycle;
                lifecycle.addObserver(wrappedComposition);
                return;
            case 4:
                ((TimedValueQueue) this.f$0).onFontRetrieved((Typeface) this.f$1);
                return;
            case 5:
                Context context = (Context) this.f$0;
                ConditionVariable conditionVariable = (ConditionVariable) this.f$1;
                HandlerCompat$Api28Impl.audioManager = (AudioManager) context.getSystemService(ContentType.Audio.TYPE);
                conditionVariable.open();
                return;
            case 6:
                RulerTrackingMap rulerTrackingMap = (RulerTrackingMap) this.f$0;
                Object objApply = ((Function) this.f$1).apply(rulerTrackingMap.newRulers);
                rulerTrackingMap.newRulers = objApply;
                BackgroundThreadStateHandler$$ExternalSyntheticLambda0 backgroundThreadStateHandler$$ExternalSyntheticLambda0 = new BackgroundThreadStateHandler$$ExternalSyntheticLambda0(rulerTrackingMap, objApply, (byte) 1);
                SystemHandlerWrapper systemHandlerWrapper = (SystemHandlerWrapper) rulerTrackingMap.values;
                if (systemHandlerWrapper.handler.getLooper().getThread().isAlive()) {
                    systemHandlerWrapper.post(backgroundThreadStateHandler$$ExternalSyntheticLambda0);
                    return;
                }
                return;
            case 7:
                NetworkTypeObserver networkTypeObserver = (NetworkTypeObserver) this.f$0;
                Context context2 = (Context) this.f$1;
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context2.registerReceiver(new NetworkTypeObserver.Receiver(b3, networkTypeObserver), intentFilter);
                return;
            case 8:
                NetworkTypeObserver.Receiver receiver = (NetworkTypeObserver.Receiver) this.f$0;
                Context context3 = (Context) this.f$1;
                NetworkTypeObserver networkTypeObserver2 = (NetworkTypeObserver) receiver.this$0;
                ConnectivityManager connectivityManager = (ConnectivityManager) context3.getSystemService("connectivity");
                if (connectivityManager == null) {
                    b = 0;
                } else {
                    try {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                            b = 1;
                        } else {
                            int type = activeNetworkInfo.getType();
                            if (type == 0) {
                                switch (activeNetworkInfo.getSubtype()) {
                                    case 1:
                                    case 2:
                                        b = 3;
                                        break;
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                                    case 14:
                                    case 15:
                                    case 17:
                                        b = 4;
                                        break;
                                    case 13:
                                        b = 5;
                                        break;
                                    case 16:
                                    case 19:
                                    default:
                                        b = 6;
                                        break;
                                    case 18:
                                        b = 2;
                                        break;
                                    case 20:
                                        if (Build.VERSION.SDK_INT < 29) {
                                            b = 0;
                                        }
                                        break;
                                }
                            } else if (type == 1) {
                                b = 2;
                            } else if (type == 4 || type == 5) {
                                switch (activeNetworkInfo.getSubtype()) {
                                    case 1:
                                    case 2:
                                        b = 3;
                                        break;
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                                    case 14:
                                    case 15:
                                    case 17:
                                        b = 4;
                                        break;
                                    case 13:
                                        b = 5;
                                        break;
                                    case 16:
                                    case 19:
                                    default:
                                        b = 6;
                                        break;
                                    case 18:
                                        b = 2;
                                        break;
                                    case 20:
                                        if (Build.VERSION.SDK_INT < 29) {
                                            b = 0;
                                        }
                                        break;
                                }
                            } else if (type != 6) {
                                b = type != 9 ? (byte) 8 : (byte) 7;
                            } else {
                                b = 5;
                            }
                        }
                    } catch (SecurityException unused) {
                    }
                }
                if (Build.VERSION.SDK_INT < 31 || b != 5) {
                    networkTypeObserver2.updateNetworkType(b);
                    return;
                } else {
                    NetworkTypeObserver.Api31.disambiguate4gAnd5gNsa(context3, networkTypeObserver2);
                    return;
                }
            case 9:
                Exchange exchange = (Exchange) this.f$0;
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.f$1;
                CallbackWrapper callbackWrapper = (CallbackWrapper) exchange.call;
                if (atomicBoolean.get()) {
                    new Thread(new ComponentActivity$$ExternalSyntheticLambda10(callbackWrapper, atomicBoolean, (byte) 10), "ExoPlayer:WakeLockManager").start();
                    return;
                }
                return;
            case 10:
                CallbackWrapper callbackWrapper2 = (CallbackWrapper) this.f$0;
                AtomicBoolean atomicBoolean2 = (AtomicBoolean) this.f$1;
                synchronized (callbackWrapper2) {
                    if (atomicBoolean2.get() && (wakeLock = (PowerManager.WakeLock) callbackWrapper2.mExecutor) != null) {
                        wakeLock.release();
                    }
                    break;
                }
                return;
            case 11:
                Exchange exchange2 = (Exchange) this.f$0;
                AtomicBoolean atomicBoolean3 = (AtomicBoolean) this.f$1;
                WeakCache weakCache = (WeakCache) exchange2.call;
                if (atomicBoolean3.get()) {
                    new Thread(new ComponentActivity$$ExternalSyntheticLambda10(weakCache, atomicBoolean3, (byte) 12), "ExoPlayer:WifiLockManager").start();
                    return;
                }
                return;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                WeakCache weakCache2 = (WeakCache) this.f$0;
                AtomicBoolean atomicBoolean4 = (AtomicBoolean) this.f$1;
                synchronized (weakCache2) {
                    if (atomicBoolean4.get() && (wifiLock = (WifiManager.WifiLock) weakCache2.referenceQueue) != null) {
                        wifiLock.release();
                    }
                    break;
                }
                return;
            case 13:
                ExoPlayerImpl exoPlayerImpl = (ExoPlayerImpl) this.f$0;
                ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate = (ExoPlayerImplInternal.PlaybackInfoUpdate) this.f$1;
                int i2 = exoPlayerImpl.pendingOperationAcks - playbackInfoUpdate.operationAcks;
                exoPlayerImpl.pendingOperationAcks = i2;
                if (playbackInfoUpdate.positionDiscontinuity) {
                    exoPlayerImpl.pendingDiscontinuityReason = playbackInfoUpdate.discontinuityReason;
                    exoPlayerImpl.pendingDiscontinuity = true;
                }
                if (i2 == 0) {
                    Timeline timeline = playbackInfoUpdate.playbackInfo.timeline;
                    int currentMediaItemIndex = -1;
                    if (!exoPlayerImpl.playbackInfo.timeline.isEmpty() && timeline.isEmpty()) {
                        exoPlayerImpl.maskingWindowIndex = -1;
                        exoPlayerImpl.maskingWindowPositionMs = 0L;
                    }
                    if (!timeline.isEmpty()) {
                        List listAsList = Arrays.asList(((PlaylistTimeline) timeline).timelines);
                        UtilsKt.checkState(listAsList.size() == exoPlayerImpl.mediaSourceHolderSnapshots.size());
                        for (int i3 = 0; i3 < listAsList.size(); i3++) {
                            ((ExoPlayerImpl.MediaSourceHolderSnapshot) exoPlayerImpl.mediaSourceHolderSnapshots.get(i3)).timeline = (Timeline) listAsList.get(i3);
                        }
                    }
                    long j2 = -9223372036854775807L;
                    if (exoPlayerImpl.pendingDiscontinuity) {
                        boolean z2 = playbackInfoUpdate.playbackInfo.timeline.isEmpty() && exoPlayerImpl.playbackInfo.timeline.isEmpty();
                        boolean zEquals = playbackInfoUpdate.playbackInfo.periodId.equals(exoPlayerImpl.playbackInfo.periodId);
                        boolean z3 = playbackInfoUpdate.playbackInfo.discontinuityStartPositionUs == exoPlayerImpl.playbackInfo.positionUs;
                        if (z2 || (zEquals && z3)) {
                            b2 = 0;
                        }
                        if (b2 != 0) {
                            currentMediaItemIndex = exoPlayerImpl.getCurrentMediaItemIndex();
                            if (timeline.isEmpty() || playbackInfoUpdate.playbackInfo.periodId.isAd()) {
                                j2 = playbackInfoUpdate.playbackInfo.discontinuityStartPositionUs;
                            } else {
                                PlaybackInfo playbackInfo = playbackInfoUpdate.playbackInfo;
                                MediaSource$MediaPeriodId mediaSource$MediaPeriodId = playbackInfo.periodId;
                                long j3 = playbackInfo.discontinuityStartPositionUs;
                                Object obj = mediaSource$MediaPeriodId.periodUid;
                                Timeline.Period period = exoPlayerImpl.period;
                                timeline.getPeriodByUid(obj, period);
                                j2 = j3 + period.positionInWindowUs;
                            }
                        }
                        i = currentMediaItemIndex;
                        j = j2;
                        z = b2;
                    } else {
                        i = -1;
                        j = -9223372036854775807L;
                        z = 0;
                    }
                    exoPlayerImpl.pendingDiscontinuity = false;
                    exoPlayerImpl.updatePlaybackInfo(playbackInfoUpdate.playbackInfo, 1, z, exoPlayerImpl.pendingDiscontinuityReason, j, i, false);
                    return;
                }
                return;
            case 14:
                ((MediaMetricsListener) this.f$0).lambda$reportTrackChangeEvent$3((TrackChangeEvent) this.f$1);
                return;
            case 15:
                ((MediaMetricsListener) this.f$0).lambda$maybeReportNetworkChange$1((NetworkEvent) this.f$1);
                return;
            case 16:
                ((MediaMetricsListener) this.f$0).lambda$maybeReportPlaybackError$0((PlaybackErrorEvent) this.f$1);
                return;
            case 17:
                ((MediaMetricsListener) this.f$0).lambda$finishCurrentSession$4((PlaybackMetrics) this.f$1);
                return;
            case 18:
                ((MediaMetricsListener) this.f$0).lambda$maybeReportPlaybackStateChange$2((PlaybackStateEvent) this.f$1);
                return;
            case 19:
                AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = (AudioRendererEventListener$EventDispatcher) this.f$0;
                synchronized (((DecoderCounters) this.f$1)) {
                }
                ExoPlayerImpl.ComponentListener componentListener = audioRendererEventListener$EventDispatcher.listener;
                String str = Util.DEVICE_DEBUG_INFO;
                DefaultAnalyticsCollector defaultAnalyticsCollector = ExoPlayerImpl.this.analyticsCollector;
                defaultAnalyticsCollector.sendEvent(defaultAnalyticsCollector.generateEventTime((MediaSource$MediaPeriodId) defaultAnalyticsCollector.mediaPeriodQueueTracker.moments), 1013, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4(b));
                return;
            case 20:
                AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher2 = (AudioRendererEventListener$EventDispatcher) this.f$0;
                CodecParameters codecParameters = (CodecParameters) this.f$1;
                ExoPlayerImpl.ComponentListener componentListener2 = audioRendererEventListener$EventDispatcher2.listener;
                String str2 = Util.DEVICE_DEBUG_INFO;
                ExoPlayerImpl.this.audioListenerManager.onParametersChanged(codecParameters);
                return;
            case 21:
                Dispatcher dispatcher = (Dispatcher) this.f$0;
                AudioDeviceInfo routedDevice = ((AudioRouting) this.f$1).getRoutedDevice();
                if (routedDevice != null) {
                    ((Handler) dispatcher.runningAsyncCalls).post(new ComponentActivity$$ExternalSyntheticLambda10(dispatcher, routedDevice, (byte) 22));
                    return;
                }
                return;
            case 22:
                Dispatcher dispatcher2 = (Dispatcher) this.f$0;
                AudioDeviceInfo audioDeviceInfo = (AudioDeviceInfo) this.f$1;
                if (((AudioTrackAudioOutput$OnRoutingChangedListenerApi24$$ExternalSyntheticLambda0) dispatcher2.runningSyncCalls) == null || (audioCapabilitiesReceiver = ((AudioTrackAudioOutputProvider) ((AtomicInt) dispatcher2.readyAsyncCalls).delegate).audioCapabilitiesReceiver) == null || audioDeviceInfo.equals(audioCapabilitiesReceiver.routedDevice)) {
                    return;
                }
                audioCapabilitiesReceiver.routedDevice = audioDeviceInfo;
                Context context4 = audioCapabilitiesReceiver.context;
                AudioAttributes audioAttributes = audioCapabilitiesReceiver.audioAttributes;
                List spatializerChannelMasks = audioCapabilitiesReceiver.getSpatializerChannelMasks();
                RegularImmutableList regularImmutableList = AudioCapabilities.DEFAULT_SPEAKER_LAYOUT_CHANNEL_MASKS;
                audioCapabilitiesReceiver.onNewAudioCapabilities(AudioCapabilities.getCapabilitiesInternal(context4, context4.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), audioAttributes, audioDeviceInfo, spatializerChannelMasks));
                return;
            case 23:
                DefaultDrmSessionManager.PreacquiredSessionReference preacquiredSessionReference = (DefaultDrmSessionManager.PreacquiredSessionReference) this.f$0;
                Format format = (Format) this.f$1;
                DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
                if (defaultDrmSessionManager.prepareCallsCount == 0 || preacquiredSessionReference.isReleased) {
                    return;
                }
                Looper looper = defaultDrmSessionManager.playbackLooper;
                looper.getClass();
                preacquiredSessionReference.session = defaultDrmSessionManager.acquireSession(looper, preacquiredSessionReference.eventDispatcher, format, false);
                defaultDrmSessionManager.preacquiredSessionReferences.add(preacquiredSessionReference);
                return;
            case 24:
                AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter = (AsynchronousMediaCodecAdapter) this.f$0;
                ComponentActivity$$ExternalSyntheticLambda10 componentActivity$$ExternalSyntheticLambda10 = (ComponentActivity$$ExternalSyntheticLambda10) this.f$1;
                asynchronousMediaCodecAdapter.bufferEnqueuer.maybeThrowException();
                AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = asynchronousMediaCodecAdapter.asynchronousMediaCodecCallback;
                synchronized (asynchronousMediaCodecCallback.lock) {
                    asynchronousMediaCodecCallback.maybeThrowException();
                    componentActivity$$ExternalSyntheticLambda10.run();
                    break;
                }
                return;
            case 25:
                MediaCodecRenderer mediaCodecRenderer = (MediaCodecRenderer) this.f$0;
                mediaCodecRenderer.readDataResultHolder.set(mediaCodecRenderer.readSource((WeakCache) this.f$1, mediaCodecRenderer.buffer, 0));
                return;
            case 26:
                ((DownloadService) this.f$1).notifyDownloads(((DownloadService.DownloadManagerHelper) this.f$0).downloadManager.downloads);
                return;
            case 27:
                ((Consumer) this.f$0).accept((MediaSourceEventListener) this.f$1);
                return;
            case 28:
                ((ProgressiveMediaPeriod) this.f$0).setSeekMap((SeekMap) this.f$1);
                return;
            default:
                ((DefaultVideoSink) ((WeakCache) this.f$0).referenceQueue).listener.onVideoSizeChanged((VideoSize) this.f$1);
                return;
        }
    }
}
