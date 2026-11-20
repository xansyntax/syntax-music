package okhttp3.internal.connection;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.app.ActivityRecreator;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.DefaultMediaNotificationProvider$$ExternalSyntheticLambda1;
import androidx.media3.session.LegacyConversions;
import androidx.media3.session.MediaLibrarySessionImpl;
import androidx.media3.session.MediaSession$ControllerCb;
import androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda0;
import androidx.media3.session.MediaSessionLegacyStub;
import androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda3;
import androidx.media3.session.PlayerWrapper;
import androidx.media3.session.SessionCommand;
import androidx.media3.session.SessionPositionInfo;
import androidx.media3.session.legacy.IMediaControllerCallback;
import androidx.media3.session.legacy.MediaControllerCompat$MediaControllerImplApi23;
import androidx.media3.session.legacy.MediaSessionCompat$MediaSessionImplApi23;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ResultKt;
import kotlin.uuid.UuidKt;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.ech.EchUntrustedException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class FastFallbackExchangeFinder implements FutureCallback, MediaSession$ControllerCb, ExchangeFinder {
    public final Object connectResults;
    public long nextTcpConnectAtNanos;
    public Object routePlanner;
    public Object taskRunner;
    public Object tcpConnectsInFlight;

    public FastFallbackExchangeFinder(RealRoutePlanner realRoutePlanner, TaskRunner taskRunner) {
        taskRunner.getClass();
        this.routePlanner = realRoutePlanner;
        this.taskRunner = taskRunner;
        this.nextTcpConnectAtNanos = Long.MIN_VALUE;
        this.tcpConnectsInFlight = new CopyOnWriteArrayList();
        this.connectResults = new LinkedBlockingDeque();
    }

    public void cancelInFlightConnects() {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.tcpConnectsInFlight;
        Iterator it = copyOnWriteArrayList.iterator();
        it.getClass();
        while (it.hasNext()) {
            RoutePlanner$Plan routePlanner$Plan = (RoutePlanner$Plan) it.next();
            routePlanner$Plan.cancel();
            RoutePlanner$Plan routePlanner$PlanRetry = routePlanner$Plan.retry();
            if (routePlanner$PlanRetry != null) {
                ((RealRoutePlanner) this.routePlanner).deferredPlans.addLast(routePlanner$PlanRetry);
            }
        }
        copyOnWriteArrayList.clear();
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    public RealConnection find() throws IOException {
        RoutePlanner$ConnectResult routePlanner$ConnectResultLaunchTcpConnect;
        long j;
        RoutePlanner$ConnectResult routePlanner$ConnectResult;
        IOException iOException = null;
        while (true) {
            try {
                if (((CopyOnWriteArrayList) this.tcpConnectsInFlight).isEmpty() && !((RealRoutePlanner) this.routePlanner).hasNext(null)) {
                    break;
                }
                if (((RealRoutePlanner) this.routePlanner).call.canceled) {
                    throw new IOException("Canceled");
                }
                ConnectionPool connectionPool = ((TaskRunner) this.taskRunner).backend;
                long jNanoTime = System.nanoTime();
                long j2 = this.nextTcpConnectAtNanos - jNanoTime;
                if (((CopyOnWriteArrayList) this.tcpConnectsInFlight).isEmpty() || j2 <= 0) {
                    routePlanner$ConnectResultLaunchTcpConnect = launchTcpConnect();
                    j = 250000000;
                    this.nextTcpConnectAtNanos = jNanoTime + 250000000;
                } else {
                    j = j2;
                    routePlanner$ConnectResultLaunchTcpConnect = null;
                }
                if (routePlanner$ConnectResultLaunchTcpConnect == null) {
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.tcpConnectsInFlight;
                    if (copyOnWriteArrayList.isEmpty() || (routePlanner$ConnectResult = (RoutePlanner$ConnectResult) ((LinkedBlockingDeque) this.connectResults).poll(j, timeUnit)) == null) {
                        routePlanner$ConnectResultLaunchTcpConnect = null;
                    } else {
                        copyOnWriteArrayList.remove(routePlanner$ConnectResult.plan);
                        routePlanner$ConnectResultLaunchTcpConnect = routePlanner$ConnectResult;
                    }
                    if (routePlanner$ConnectResultLaunchTcpConnect == null) {
                    }
                }
                boolean z = false;
                if (routePlanner$ConnectResultLaunchTcpConnect.nextPlan == null && routePlanner$ConnectResultLaunchTcpConnect.throwable == null) {
                    cancelInFlightConnects();
                    if (!routePlanner$ConnectResultLaunchTcpConnect.plan.isReady()) {
                        routePlanner$ConnectResultLaunchTcpConnect = routePlanner$ConnectResultLaunchTcpConnect.plan.connectTlsEtc();
                    }
                    if (routePlanner$ConnectResultLaunchTcpConnect.nextPlan == null && routePlanner$ConnectResultLaunchTcpConnect.throwable == null) {
                        z = true;
                    }
                    if (z) {
                        RealConnection realConnectionHandleSuccess = routePlanner$ConnectResultLaunchTcpConnect.plan.handleSuccess();
                        cancelInFlightConnects();
                        return realConnectionHandleSuccess;
                    }
                }
                Throwable th = routePlanner$ConnectResultLaunchTcpConnect.throwable;
                if (th != null) {
                    if (!(th instanceof IOException)) {
                        throw th;
                    }
                    if (iOException == null) {
                        iOException = (IOException) th;
                    } else {
                        ResultKt.addSuppressed(iOException, th);
                    }
                    if (((IOException) th) instanceof EchUntrustedException) {
                        break;
                    }
                }
                RoutePlanner$Plan routePlanner$Plan = routePlanner$ConnectResultLaunchTcpConnect.nextPlan;
                if (routePlanner$Plan != null) {
                    ((RealRoutePlanner) this.routePlanner).deferredPlans.addFirst(routePlanner$Plan);
                }
            } catch (Throwable th2) {
                cancelInFlightConnects();
                throw th2;
            }
        }
        cancelInFlightConnects();
        iOException.getClass();
        throw iOException;
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    public RealRoutePlanner getRoutePlanner() {
        return (RealRoutePlanner) this.routePlanner;
    }

    public RoutePlanner$ConnectResult launchTcpConnect() {
        final RoutePlanner$Plan failedPlan;
        RealRoutePlanner realRoutePlanner = (RealRoutePlanner) this.routePlanner;
        if (realRoutePlanner.hasNext(null)) {
            try {
                failedPlan = realRoutePlanner.plan();
            } catch (Throwable th) {
                failedPlan = new FailedPlan(th);
            }
            if (failedPlan.isReady()) {
                return new RoutePlanner$ConnectResult(failedPlan, null, null, 6);
            }
            if (failedPlan instanceof FailedPlan) {
                return ((FailedPlan) failedPlan).result;
            }
            ((CopyOnWriteArrayList) this.tcpConnectsInFlight).add(failedPlan);
            ((TaskRunner) this.taskRunner).newQueue().schedule(new Task(_UtilJvmKt.okHttpName + " connect " + realRoutePlanner.address.url.redact()) { // from class: okhttp3.internal.connection.FastFallbackExchangeFinder.launchTcpConnect.1
                @Override // okhttp3.internal.concurrent.Task
                public final long runOnce() throws InterruptedException {
                    RoutePlanner$ConnectResult routePlanner$ConnectResult;
                    RoutePlanner$Plan routePlanner$Plan = failedPlan;
                    try {
                        routePlanner$ConnectResult = routePlanner$Plan.connectTcp();
                    } catch (Throwable th2) {
                        routePlanner$ConnectResult = new RoutePlanner$ConnectResult(routePlanner$Plan, null, th2, 2);
                    }
                    FastFallbackExchangeFinder fastFallbackExchangeFinder = this;
                    if (!((CopyOnWriteArrayList) fastFallbackExchangeFinder.tcpConnectsInFlight).contains(routePlanner$Plan)) {
                        return -1L;
                    }
                    ((LinkedBlockingDeque) fastFallbackExchangeFinder.connectResults).put(routePlanner$ConnectResult);
                    return -1L;
                }
            }, 0L);
        }
        return null;
    }

    @Override // androidx.media3.session.MediaSession$ControllerCb
    public void onAvailableCommandsChangedFromPlayer(int i, Player.Commands commands) {
        MediaSessionLegacyStub mediaSessionLegacyStub = (MediaSessionLegacyStub) this.connectResults;
        PlayerWrapper playerWrapper = mediaSessionLegacyStub.sessionImpl.playerWrapper;
        int i2 = playerWrapper.isCommandAvailable(20) ? 4 : 0;
        if (mediaSessionLegacyStub.sessionFlags != i2) {
            mediaSessionLegacyStub.sessionFlags = i2;
            ((MediaSessionCompat$MediaSessionImplApi23) mediaSessionLegacyStub.sessionCompat.mCallback).sessionFwk.setFlags(i2 | 3);
        }
        mediaSessionLegacyStub.updateLegacySessionPlaybackState(playerWrapper);
    }

    public void onDeviceInfoChanged() {
        int i;
        MediaSessionLegacyStub.AnonymousClass3 anonymousClass3;
        MediaSessionLegacyStub mediaSessionLegacyStub = (MediaSessionLegacyStub) this.connectResults;
        PlayerWrapper playerWrapper = mediaSessionLegacyStub.sessionImpl.playerWrapper;
        if (playerWrapper.getDeviceInfo().playbackType == 0) {
            anonymousClass3 = null;
        } else {
            Player.Commands availableCommands = playerWrapper.getAvailableCommands();
            if (availableCommands.flags.containsAny(26, 34)) {
                i = availableCommands.flags.containsAny(25, 33) ? 2 : 1;
            } else {
                i = 0;
            }
            Handler handler = new Handler(playerWrapper.player.getApplicationLooper());
            int deviceVolume = playerWrapper.isCommandAvailable(23) ? playerWrapper.getDeviceVolume() : 0;
            DeviceInfo deviceInfo = playerWrapper.getDeviceInfo();
            anonymousClass3 = new MediaSessionLegacyStub.AnonymousClass3(i, deviceInfo.maxVolume, deviceVolume, deviceInfo.routingControllerId, handler, playerWrapper);
        }
        mediaSessionLegacyStub.volumeProviderCompat = anonymousClass3;
        CallbackWrapper callbackWrapper = mediaSessionLegacyStub.sessionCompat;
        if (anonymousClass3 == null) {
            ((MediaSessionCompat$MediaSessionImplApi23) callbackWrapper.mCallback).sessionFwk.setPlaybackToLocal((playerWrapper.isCommandAvailable(21) ? playerWrapper.getAudioAttributes() : AudioAttributes.DEFAULT).getPlatformAudioAttributes());
        } else {
            ((MediaSessionCompat$MediaSessionImplApi23) callbackWrapper.mCallback).sessionFwk.setPlaybackToRemote(anonymousClass3.getVolumeProvider());
        }
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public void onFailure(Throwable th) {
        if (this != ((MediaSessionLegacyStub) ((FastFallbackExchangeFinder) this.connectResults).connectResults).pendingBitmapLoadCallback) {
            return;
        }
        Log.w("MediaSessionLegacyStub", "Failed to load bitmap: " + th.getMessage());
    }

    public void onMediaItemTransition(MediaItem mediaItem) {
        updateMetadataIfChanged();
        MediaSessionLegacyStub mediaSessionLegacyStub = (MediaSessionLegacyStub) this.connectResults;
        CallbackWrapper callbackWrapper = mediaSessionLegacyStub.sessionCompat;
        if (mediaItem == null) {
            ((MediaSessionCompat$MediaSessionImplApi23) callbackWrapper.mCallback).sessionFwk.setRatingType(0);
        } else {
            ((MediaSessionCompat$MediaSessionImplApi23) callbackWrapper.mCallback).sessionFwk.setRatingType(LegacyConversions.getRatingCompatStyle(mediaItem.mediaMetadata.userRating));
        }
        mediaSessionLegacyStub.updateLegacySessionPlaybackState(mediaSessionLegacyStub.sessionImpl.playerWrapper);
    }

    @Override // androidx.media3.session.MediaSession$ControllerCb
    public void onPeriodicSessionPositionInfoChanged(int i, SessionPositionInfo sessionPositionInfo, boolean z, boolean z2, int i2) {
        MediaSessionLegacyStub mediaSessionLegacyStub = (MediaSessionLegacyStub) this.connectResults;
        mediaSessionLegacyStub.updateLegacySessionPlaybackState(mediaSessionLegacyStub.sessionImpl.playerWrapper);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003b  */
    public void onPlayerChanged(int i, PlayerWrapper playerWrapper, PlayerWrapper playerWrapper2) {
        MediaSessionLegacyStub mediaSessionLegacyStub = (MediaSessionLegacyStub) this.connectResults;
        Timeline currentTimelineWithCommandCheck = playerWrapper2.getCurrentTimelineWithCommandCheck();
        if (playerWrapper == null || !Objects.equals(playerWrapper.getCurrentTimelineWithCommandCheck(), currentTimelineWithCommandCheck)) {
            onTimelineChanged(currentTimelineWithCommandCheck);
        }
        MediaMetadata playlistMetadata = playerWrapper2.isCommandAvailable(18) ? playerWrapper2.getPlaylistMetadata() : MediaMetadata.EMPTY;
        if (playerWrapper == null) {
            onPlaylistMetadataChanged(playlistMetadata);
        } else {
            if (!Objects.equals(playerWrapper.isCommandAvailable(18) ? playerWrapper.getPlaylistMetadata() : MediaMetadata.EMPTY, playlistMetadata)) {
                onPlaylistMetadataChanged(playlistMetadata);
            }
        }
        MediaMetadata mediaMetadataWithCommandCheck = playerWrapper2.getMediaMetadataWithCommandCheck();
        if (playerWrapper == null || !Objects.equals(playerWrapper.getMediaMetadataWithCommandCheck(), mediaMetadataWithCommandCheck)) {
            updateMetadataIfChanged();
        }
        if (playerWrapper == null || playerWrapper.getShuffleModeEnabled() != playerWrapper2.getShuffleModeEnabled()) {
            onShuffleModeEnabledChanged(playerWrapper2.getShuffleModeEnabled());
        }
        if (playerWrapper == null || playerWrapper.getRepeatMode() != playerWrapper2.getRepeatMode()) {
            onRepeatModeChanged(playerWrapper2.getRepeatMode());
        }
        playerWrapper2.getDeviceInfo();
        onDeviceInfoChanged();
        int i2 = playerWrapper2.isCommandAvailable(20) ? 4 : 0;
        if (mediaSessionLegacyStub.sessionFlags != i2) {
            mediaSessionLegacyStub.sessionFlags = i2;
            ((MediaSessionCompat$MediaSessionImplApi23) mediaSessionLegacyStub.sessionCompat.mCallback).sessionFwk.setFlags(i2 | 3);
        }
        MediaItem currentMediaItemWithCommandCheck = playerWrapper2.getCurrentMediaItemWithCommandCheck();
        if (playerWrapper == null || !Objects.equals(playerWrapper.getCurrentMediaItemWithCommandCheck(), currentMediaItemWithCommandCheck)) {
            onMediaItemTransition(currentMediaItemWithCommandCheck);
        } else {
            mediaSessionLegacyStub.updateLegacySessionPlaybackState(playerWrapper2);
        }
    }

    public void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
        MediaSessionLegacyStub mediaSessionLegacyStub = (MediaSessionLegacyStub) this.connectResults;
        CallbackWrapper callbackWrapper = mediaSessionLegacyStub.sessionCompat;
        CharSequence queueTitle = ((MediaControllerCompat$MediaControllerImplApi23) ((CallbackWrapper) callbackWrapper.mExecutor).mCallback).controllerFwk.getQueueTitle();
        CharSequence charSequence = mediaMetadata.title;
        if (TextUtils.equals(queueTitle, charSequence)) {
            return;
        }
        PlayerWrapper playerWrapper = mediaSessionLegacyStub.sessionImpl.playerWrapper;
        if (!mediaSessionLegacyStub.availablePlayerCommands.contains(17) || !playerWrapper.getAvailableCommands().contains(17)) {
            charSequence = null;
        }
        ((MediaSessionCompat$MediaSessionImplApi23) callbackWrapper.mCallback).sessionFwk.setQueueTitle(charSequence);
    }

    public void onRepeatModeChanged(int i) {
        CallbackWrapper callbackWrapper = ((MediaSessionLegacyStub) this.connectResults).sessionCompat;
        int iConvertToPlaybackStateCompatRepeatMode = LegacyConversions.convertToPlaybackStateCompatRepeatMode(i);
        MediaSessionCompat$MediaSessionImplApi23 mediaSessionCompat$MediaSessionImplApi23 = (MediaSessionCompat$MediaSessionImplApi23) callbackWrapper.mCallback;
        if (mediaSessionCompat$MediaSessionImplApi23.repeatMode != iConvertToPlaybackStateCompatRepeatMode) {
            mediaSessionCompat$MediaSessionImplApi23.repeatMode = iConvertToPlaybackStateCompatRepeatMode;
            synchronized (mediaSessionCompat$MediaSessionImplApi23.lock) {
                int iBeginBroadcast = mediaSessionCompat$MediaSessionImplApi23.extraControllerCallbacks.beginBroadcast() - 1;
                while (true) {
                    RemoteCallbackList remoteCallbackList = mediaSessionCompat$MediaSessionImplApi23.extraControllerCallbacks;
                    if (iBeginBroadcast >= 0) {
                        try {
                            ((IMediaControllerCallback) remoteCallbackList.getBroadcastItem(iBeginBroadcast)).onRepeatModeChanged(iConvertToPlaybackStateCompatRepeatMode);
                        } catch (RemoteException | SecurityException e) {
                            Log.e("MediaSessionCompat", "Dead object in setRepeatMode.", e);
                        }
                        iBeginBroadcast--;
                    } else {
                        remoteCallbackList.finishBroadcast();
                    }
                }
            }
        }
    }

    public void onShuffleModeEnabledChanged(boolean z) {
        CallbackWrapper callbackWrapper = ((MediaSessionLegacyStub) this.connectResults).sessionCompat;
        ImmutableSet immutableSet = LegacyConversions.KNOWN_METADATA_COMPAT_KEYS;
        MediaSessionCompat$MediaSessionImplApi23 mediaSessionCompat$MediaSessionImplApi23 = (MediaSessionCompat$MediaSessionImplApi23) callbackWrapper.mCallback;
        if (mediaSessionCompat$MediaSessionImplApi23.shuffleMode != z) {
            mediaSessionCompat$MediaSessionImplApi23.shuffleMode = z ? 1 : 0;
            synchronized (mediaSessionCompat$MediaSessionImplApi23.lock) {
                int iBeginBroadcast = mediaSessionCompat$MediaSessionImplApi23.extraControllerCallbacks.beginBroadcast() - 1;
                while (true) {
                    RemoteCallbackList remoteCallbackList = mediaSessionCompat$MediaSessionImplApi23.extraControllerCallbacks;
                    if (iBeginBroadcast >= 0) {
                        try {
                            ((IMediaControllerCallback) remoteCallbackList.getBroadcastItem(iBeginBroadcast)).onShuffleModeChanged(z ? 1 : 0);
                        } catch (RemoteException | SecurityException e) {
                            Log.e("MediaSessionCompat", "Dead object in setShuffleMode.", e);
                        }
                        iBeginBroadcast--;
                    } else {
                        remoteCallbackList.finishBroadcast();
                    }
                }
            }
        }
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public void onSuccess(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        MediaSessionLegacyStub mediaSessionLegacyStub = (MediaSessionLegacyStub) ((FastFallbackExchangeFinder) this.connectResults).connectResults;
        if (this != mediaSessionLegacyStub.pendingBitmapLoadCallback) {
            return;
        }
        mediaSessionLegacyStub.sessionCompat.setMetadata(LegacyConversions.convertToMediaMetadataCompat((MediaMetadata) this.routePlanner, (String) this.taskRunner, (Uri) this.tcpConnectsInFlight, this.nextTcpConnectAtNanos, bitmap));
        MediaLibrarySessionImpl mediaLibrarySessionImpl = mediaSessionLegacyStub.sessionImpl;
        Util.postOrRun(mediaLibrarySessionImpl.mainHandler, new MediaSessionImpl$$ExternalSyntheticLambda0(mediaLibrarySessionImpl, (byte) 1));
    }

    public void onTimelineChanged(Timeline timeline) {
        updateQueue(timeline);
        updateMetadataIfChanged();
    }

    @Override // androidx.media3.session.MediaSession$ControllerCb
    public void sendCustomCommand(int i, SessionCommand sessionCommand) {
        Bundle bundle = Bundle.EMPTY;
        boolean zIsEmpty = bundle.isEmpty();
        Bundle bundle2 = sessionCommand.customExtras;
        if (zIsEmpty) {
            bundle = bundle2;
        } else if (!bundle2.isEmpty()) {
            Bundle bundle3 = new Bundle(bundle2);
            bundle3.putAll(bundle);
            bundle = bundle3;
        }
        CallbackWrapper callbackWrapper = ((MediaSessionLegacyStub) this.connectResults).sessionCompat;
        String str = sessionCommand.customAction;
        callbackWrapper.getClass();
        if (TextUtils.isEmpty(str)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("event cannot be null or empty");
        } else {
            ((MediaSessionCompat$MediaSessionImplApi23) callbackWrapper.mCallback).sessionFwk.sendSessionEvent(str, bundle);
        }
    }

    @Override // androidx.media3.session.MediaSession$ControllerCb
    public void setCustomLayout(int i, List list) {
        MediaSessionLegacyStub mediaSessionLegacyStub = (MediaSessionLegacyStub) this.connectResults;
        mediaSessionLegacyStub.updateLegacySessionPlaybackState(mediaSessionLegacyStub.sessionImpl.playerWrapper);
    }

    public void updateMetadataIfChanged() {
        long j;
        Uri uri;
        MediaMetadata mediaMetadata;
        Uri uri2;
        MediaSessionLegacyStub mediaSessionLegacyStub = (MediaSessionLegacyStub) this.connectResults;
        MediaLibrarySessionImpl mediaLibrarySessionImpl = mediaSessionLegacyStub.sessionImpl;
        PlayerWrapper playerWrapper = mediaLibrarySessionImpl.playerWrapper;
        MediaItem currentMediaItemWithCommandCheck = playerWrapper.getCurrentMediaItemWithCommandCheck();
        MediaMetadata mediaMetadataWithCommandCheck = playerWrapper.getMediaMetadataWithCommandCheck();
        long duration = -9223372036854775807L;
        if ((!playerWrapper.isCommandAvailable(16) || !playerWrapper.isCurrentMediaItemLive()) && playerWrapper.isCommandAvailable(16)) {
            duration = playerWrapper.getDuration();
        }
        String str = currentMediaItemWithCommandCheck != null ? currentMediaItemWithCommandCheck.mediaId : "";
        Bitmap bitmap = null;
        Uri uri3 = (currentMediaItemWithCommandCheck == null || (uri2 = currentMediaItemWithCommandCheck.requestMetadata.mediaUri) == null) ? null : uri2;
        if (Objects.equals((MediaMetadata) this.routePlanner, mediaMetadataWithCommandCheck) && Objects.equals((String) this.taskRunner, str) && Objects.equals((Uri) this.tcpConnectsInFlight, uri3) && this.nextTcpConnectAtNanos == duration) {
            return;
        }
        this.taskRunner = str;
        this.tcpConnectsInFlight = uri3;
        this.routePlanner = mediaMetadataWithCommandCheck;
        this.nextTcpConnectAtNanos = duration;
        ListenableFuture listenableFutureLoadBitmapFromMetadata = mediaLibrarySessionImpl.bitmapLoader.loadBitmapFromMetadata(mediaMetadataWithCommandCheck);
        if (listenableFutureLoadBitmapFromMetadata != null) {
            mediaSessionLegacyStub.pendingBitmapLoadCallback = null;
            if (listenableFutureLoadBitmapFromMetadata.isDone()) {
                try {
                    bitmap = (Bitmap) UuidKt.getDone(listenableFutureLoadBitmapFromMetadata);
                } catch (CancellationException | ExecutionException e) {
                    Log.w("MediaSessionLegacyStub", "Failed to load bitmap: " + e.getMessage());
                }
                j = duration;
                uri = uri3;
                mediaMetadata = mediaMetadataWithCommandCheck;
            } else {
                j = duration;
                uri = uri3;
                mediaMetadata = mediaMetadataWithCommandCheck;
                FastFallbackExchangeFinder fastFallbackExchangeFinder = new FastFallbackExchangeFinder(this, mediaMetadata, str, uri, j);
                str = str;
                mediaSessionLegacyStub.pendingBitmapLoadCallback = fastFallbackExchangeFinder;
                Handler handler = mediaLibrarySessionImpl.applicationHandler;
                Objects.requireNonNull(handler);
                listenableFutureLoadBitmapFromMetadata.addListener(new ActivityRecreator.AnonymousClass1(listenableFutureLoadBitmapFromMetadata, fastFallbackExchangeFinder, (byte) 1), new DefaultMediaNotificationProvider$$ExternalSyntheticLambda1(handler, (byte) 0));
            }
        } else {
            j = duration;
            uri = uri3;
            mediaMetadata = mediaMetadataWithCommandCheck;
        }
        mediaSessionLegacyStub.sessionCompat.setMetadata(LegacyConversions.convertToMediaMetadataCompat(mediaMetadata, str, uri, j, bitmap));
    }

    public void updateQueue(Timeline timeline) {
        MediaSessionLegacyStub mediaSessionLegacyStub = (MediaSessionLegacyStub) this.connectResults;
        MediaLibrarySessionImpl mediaLibrarySessionImpl = mediaSessionLegacyStub.sessionImpl;
        PlayerWrapper playerWrapper = mediaLibrarySessionImpl.playerWrapper;
        if (!mediaSessionLegacyStub.availablePlayerCommands.contains(17) || !playerWrapper.getAvailableCommands().contains(17) || timeline.isEmpty()) {
            mediaSessionLegacyStub.sessionCompat.setQueue(null);
            return;
        }
        ImmutableSet immutableSet = LegacyConversions.KNOWN_METADATA_COMPAT_KEYS;
        ArrayList arrayList = new ArrayList();
        Timeline.Window window = new Timeline.Window();
        for (int i = 0; i < timeline.getWindowCount(); i++) {
            arrayList.add(timeline.getWindow(i, window, 0L).mediaItem);
        }
        ArrayList arrayList2 = new ArrayList();
        MediaSessionStub$$ExternalSyntheticLambda3 mediaSessionStub$$ExternalSyntheticLambda3 = new MediaSessionStub$$ExternalSyntheticLambda3((Object) this, (Object) new AtomicInteger(0), (Object) arrayList, (Object) arrayList2, (byte) 7);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            byte[] bArr = ((MediaItem) arrayList.get(i2)).mediaMetadata.artworkData;
            if (bArr == null) {
                arrayList2.add(null);
                mediaSessionStub$$ExternalSyntheticLambda3.run();
            } else {
                ListenableFuture listenableFutureDecodeBitmap = mediaLibrarySessionImpl.bitmapLoader.decodeBitmap(bArr);
                arrayList2.add(listenableFutureDecodeBitmap);
                Handler handler = mediaLibrarySessionImpl.applicationHandler;
                Objects.requireNonNull(handler);
                listenableFutureDecodeBitmap.addListener(mediaSessionStub$$ExternalSyntheticLambda3, new DefaultMediaNotificationProvider$$ExternalSyntheticLambda1(handler, (byte) 0));
            }
        }
    }

    public FastFallbackExchangeFinder(MediaSessionLegacyStub mediaSessionLegacyStub) {
        this.connectResults = mediaSessionLegacyStub;
        this.routePlanner = MediaMetadata.EMPTY;
        this.taskRunner = "";
        this.nextTcpConnectAtNanos = -9223372036854775807L;
    }

    public FastFallbackExchangeFinder(FastFallbackExchangeFinder fastFallbackExchangeFinder, MediaMetadata mediaMetadata, String str, Uri uri, long j) {
        this.connectResults = fastFallbackExchangeFinder;
        this.routePlanner = mediaMetadata;
        this.taskRunner = str;
        this.tcpConnectsInFlight = uri;
        this.nextTcpConnectAtNanos = j;
    }

    @Override // androidx.media3.session.MediaSession$ControllerCb
    public void onDisconnected() {
    }
}
