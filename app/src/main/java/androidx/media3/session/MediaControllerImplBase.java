package androidx.media3.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda10;
import androidx.compose.ui.node.NodeChain;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.BundleListRetriever;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.IllegalSeekPositionException;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.ListenerSet$$ExternalSyntheticLambda1;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda10;
import androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda14;
import androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda15;
import androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda23;
import androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda24;
import androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda27;
import androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda5;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.DirectExecutor;
import com.google.common.util.concurrent.ImmediateFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.yalantis.ucrop.UCropActivity$$ExternalSyntheticLambda1;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import kotlin.time.InstantParseResult;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class MediaControllerImplBase implements MediaController.MediaControllerImpl {
    public SessionToken connectedToken;
    public final Bundle connectionHints;
    public final Context context;
    public final MediaControllerStub controllerStub;
    public long currentPositionMs;
    public ImmutableList customLayoutOriginal;
    public final MediaControllerImplBase$$ExternalSyntheticLambda4 deathRecipient;
    public final Handler fallbackPlaybackInfoUpdateHandler;
    public final Splitter flushCommandQueueHandler;
    public IMediaSession iSession;
    public final MediaController instance;
    public Player.Commands intersectedPlayerCommands;
    public long lastSetPlayWhenReadyCalledTimeMs;
    public final ListenerSet listeners;
    public ImmutableList mediaButtonPreferencesOriginal;
    public final SparseArray pendingCustomActionProgressListeners;
    public final ArraySet pendingMaskingSequencedFutureNumbers;
    public PlayerInfo pendingPlayerInfo;
    public android.media.session.MediaController platformController;
    public Player.Commands playerCommandsFromPlayer;
    public Player.Commands playerCommandsFromSession;
    public boolean released;
    public RegularImmutableList resolvedCustomLayout;
    public RegularImmutableList resolvedMediaButtonPreferences;
    public final NodeChain.Differ sequencedFutureManager;
    public SessionServiceConnection serviceConnection;
    public PendingIntent sessionActivity;
    public Bundle sessionExtras;
    public final SurfaceCallback surfaceCallback;
    public final SessionToken token;
    public Surface videoSurface;
    public SurfaceHolder videoSurfaceHolder;
    public PlayerInfo playerInfo = PlayerInfo.DEFAULT;
    public Size surfaceSize = Size.UNKNOWN;
    public SessionCommands sessionCommands = SessionCommands.EMPTY;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface RemoteSessionTask {
        void run(IMediaSession iMediaSession, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SessionServiceConnection implements ServiceConnection {
        public final Bundle connectionHints;

        public SessionServiceConnection(Bundle bundle) {
            this.connectionHints = bundle;
        }

        @Override // android.content.ServiceConnection
        public final void onBindingDied(ComponentName componentName) {
            MediaController mediaController = MediaControllerImplBase.this.instance;
            Objects.requireNonNull(mediaController);
            mediaController.runOnApplicationLooper(new MediaSessionService$$ExternalSyntheticLambda3((byte) 2, mediaController));
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MediaSessionService$$ExternalSyntheticLambda3 mediaSessionService$$ExternalSyntheticLambda3;
            MediaControllerImplBase mediaControllerImplBase = MediaControllerImplBase.this;
            SessionToken sessionToken = mediaControllerImplBase.token;
            MediaController mediaController = mediaControllerImplBase.instance;
            byte b = 2;
            try {
                try {
                    if (sessionToken.impl.getPackageName().equals(componentName.getPackageName())) {
                        IMediaSessionService iMediaSessionServiceAsInterface = MediaSessionService.MediaSessionServiceStub.asInterface(iBinder);
                        if (iMediaSessionServiceAsInterface != null) {
                            String packageName = mediaControllerImplBase.context.getPackageName();
                            int iMyPid = Process.myPid();
                            Bundle bundle = this.connectionHints;
                            mediaController.getClass();
                            iMediaSessionServiceAsInterface.connect(mediaControllerImplBase.controllerStub, new ConnectionRequest(packageName, iMyPid, bundle).toBundle());
                            return;
                        }
                        Log.e("MCImplBase", "Service interface is missing.");
                        Objects.requireNonNull(mediaController);
                        mediaSessionService$$ExternalSyntheticLambda3 = new MediaSessionService$$ExternalSyntheticLambda3(b, mediaController);
                    } else {
                        Log.e("MCImplBase", "Expected connection to " + sessionToken.impl.getPackageName() + " but is connected to " + componentName);
                        Objects.requireNonNull(mediaController);
                        mediaSessionService$$ExternalSyntheticLambda3 = new MediaSessionService$$ExternalSyntheticLambda3(b, mediaController);
                    }
                } catch (RemoteException unused) {
                    Log.w("MCImplBase", "Service " + componentName + " has died prematurely");
                    Objects.requireNonNull(mediaController);
                    mediaSessionService$$ExternalSyntheticLambda3 = new MediaSessionService$$ExternalSyntheticLambda3(b, mediaController);
                }
                mediaController.runOnApplicationLooper(mediaSessionService$$ExternalSyntheticLambda3);
            } catch (Throwable th) {
                Objects.requireNonNull(mediaController);
                mediaController.runOnApplicationLooper(new MediaSessionService$$ExternalSyntheticLambda3(b, mediaController));
                throw th;
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            MediaController mediaController = MediaControllerImplBase.this.instance;
            Objects.requireNonNull(mediaController);
            mediaController.runOnApplicationLooper(new MediaSessionService$$ExternalSyntheticLambda3((byte) 2, mediaController));
        }
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda4] */
    public MediaControllerImplBase(Context context, MediaController mediaController, SessionToken sessionToken, Bundle bundle, Looper looper) {
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        RegularImmutableList regularImmutableList = RegularImmutableList.EMPTY;
        this.customLayoutOriginal = regularImmutableList;
        this.mediaButtonPreferencesOriginal = regularImmutableList;
        this.resolvedMediaButtonPreferences = regularImmutableList;
        this.resolvedCustomLayout = regularImmutableList;
        Player.Commands commands = Player.Commands.EMPTY;
        this.playerCommandsFromSession = commands;
        this.playerCommandsFromPlayer = commands;
        this.intersectedPlayerCommands = createIntersectedCommandsWithControllerOverrides(commands, commands);
        this.listeners = new ListenerSet(looper, new MediaControllerImplBase$$ExternalSyntheticLambda3(this, (byte) 0));
        this.fallbackPlaybackInfoUpdateHandler = new Handler(looper);
        this.instance = mediaController;
        UtilsKt.checkNotNull(sessionToken, "token must not be null");
        this.context = context;
        this.sequencedFutureManager = new NodeChain.Differ();
        this.controllerStub = new MediaControllerStub(this);
        this.pendingMaskingSequencedFutureNumbers = new ArraySet(0);
        this.token = sessionToken;
        this.connectionHints = bundle;
        this.deathRecipient = new IBinder.DeathRecipient() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda4
            @Override // android.os.IBinder.DeathRecipient
            public final void binderDied() {
                MediaController mediaController2 = this.f$0.instance;
                Objects.requireNonNull(mediaController2);
                mediaController2.runOnApplicationLooper(new MediaSessionService$$ExternalSyntheticLambda3((byte) 2, mediaController2));
            }
        };
        this.surfaceCallback = new SurfaceCallback();
        this.sessionExtras = Bundle.EMPTY;
        this.serviceConnection = sessionToken.impl.getType() == 0 ? null : new SessionServiceConnection(bundle);
        this.flushCommandQueueHandler = new Splitter(this, looper);
        this.currentPositionMs = -9223372036854775807L;
        this.lastSetPlayWhenReadyCalledTimeMs = -9223372036854775807L;
        this.pendingCustomActionProgressListeners = new SparseArray();
    }

    public static Timeline.RemotableTimeline createMaskingTimeline(ArrayList arrayList, ArrayList arrayList2) {
        ImmutableList.Builder builder = new ImmutableList.Builder(4);
        builder.addAll(arrayList);
        RegularImmutableList regularImmutableListBuild = builder.build();
        ImmutableList.Builder builder2 = new ImmutableList.Builder(4);
        builder2.addAll(arrayList2);
        RegularImmutableList regularImmutableListBuild2 = builder2.build();
        int size = arrayList.size();
        Splitter splitter = MediaUtils.defaultBrowserRoot;
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = i;
        }
        return new Timeline.RemotableTimeline(regularImmutableListBuild, regularImmutableListBuild2, iArr);
    }

    public static int getCurrentMediaItemIndexInternal(PlayerInfo playerInfo) {
        return playerInfo.sessionPositionInfo.positionInfo.mediaItemIndex;
    }

    public static PlayerInfo maskPlayerInfoForAddedItems(PlayerInfo playerInfo, int i, List list, long j, long j2) {
        int size;
        Timeline timeline = playerInfo.timeline;
        SessionPositionInfo sessionPositionInfo = playerInfo.sessionPositionInfo;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size2 = 0;
        for (int i2 = 0; i2 < timeline.getWindowCount(); i2++) {
            arrayList.add(timeline.getWindow(i2, new Timeline.Window(), 0L));
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            MediaItem mediaItem = (MediaItem) list.get(i3);
            Timeline.Window window = new Timeline.Window();
            window.set(0, mediaItem, 0L, 0L, 0L, true, false, null, 0L, -9223372036854775807L, -1, -1, 0L);
            arrayList.add(i3 + i, window);
        }
        rebuildPeriods(timeline, arrayList, arrayList2);
        Timeline.RemotableTimeline remotableTimelineCreateMaskingTimeline = createMaskingTimeline(arrayList, arrayList2);
        if (playerInfo.timeline.isEmpty()) {
            size = 0;
        } else {
            int i4 = sessionPositionInfo.positionInfo.mediaItemIndex;
            size2 = i4 >= i ? list.size() + i4 : i4;
            int i5 = sessionPositionInfo.positionInfo.periodIndex;
            size = i5 >= i ? list.size() + i5 : i5;
        }
        return maskTimelineAndPositionInfo(playerInfo, remotableTimelineCreateMaskingTimeline, size2, size, j, j2, 5);
    }

    public static PlayerInfo maskPlayerInfoForRemovedItems(PlayerInfo playerInfo, int i, int i2, boolean z, long j, long j2) {
        int i3;
        int firstWindowIndex;
        int i4;
        PlayerInfo playerInfoMaskTimelineAndPositionInfo;
        Timeline timeline = playerInfo.timeline;
        boolean z2 = playerInfo.shuffleModeEnabled;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i5 = 0;
        for (int i6 = 0; i6 < timeline.getWindowCount(); i6++) {
            if (i6 < i || i6 >= i2) {
                arrayList.add(timeline.getWindow(i6, new Timeline.Window(), 0L));
            }
        }
        rebuildPeriods(timeline, arrayList, arrayList2);
        Timeline.RemotableTimeline remotableTimelineCreateMaskingTimeline = createMaskingTimeline(arrayList, arrayList2);
        Player.PositionInfo positionInfo = playerInfo.sessionPositionInfo.positionInfo;
        int i7 = positionInfo.mediaItemIndex;
        int i8 = positionInfo.periodIndex;
        Timeline.Window window = new Timeline.Window();
        boolean z3 = i7 >= i && i7 < i2;
        if (remotableTimelineCreateMaskingTimeline.isEmpty()) {
            i8 = 0;
            firstWindowIndex = -1;
            i3 = 1;
        } else {
            if (z3) {
                int i9 = playerInfo.repeatMode;
                int windowCount = timeline.getWindowCount();
                firstWindowIndex = i7;
                i3 = 1;
                while (true) {
                    if (i5 < windowCount) {
                        firstWindowIndex = timeline.getNextWindowIndex(firstWindowIndex, z2, i9);
                        if (firstWindowIndex != -1) {
                            if (firstWindowIndex < i || firstWindowIndex >= i2) {
                                break;
                            }
                            i5++;
                        }
                    }
                    firstWindowIndex = -1;
                    break;
                }
                if (firstWindowIndex == -1) {
                    firstWindowIndex = remotableTimelineCreateMaskingTimeline.getFirstWindowIndex(z2);
                } else if (firstWindowIndex >= i2) {
                    firstWindowIndex -= i2 - i;
                }
                remotableTimelineCreateMaskingTimeline.getWindow(firstWindowIndex, window, 0L);
                i4 = window.firstPeriodIndex;
            } else {
                i3 = 1;
                if (i7 >= i2) {
                    firstWindowIndex = i7 - (i2 - i);
                    if (i8 != -1) {
                        for (int i10 = i; i10 < i2; i10++) {
                            Timeline.Window window2 = new Timeline.Window();
                            timeline.getWindow(i10, window2);
                            i8 -= (window2.lastPeriodIndex - window2.firstPeriodIndex) + 1;
                        }
                    }
                    i4 = i8;
                } else {
                    firstWindowIndex = i7;
                }
            }
            i8 = i4;
        }
        if (!z3) {
            playerInfoMaskTimelineAndPositionInfo = maskTimelineAndPositionInfo(playerInfo, remotableTimelineCreateMaskingTimeline, firstWindowIndex, i8, j, j2, 4);
        } else if (firstWindowIndex == -1) {
            playerInfoMaskTimelineAndPositionInfo = maskTimelineAndPositionInfo(playerInfo, remotableTimelineCreateMaskingTimeline, SessionPositionInfo.DEFAULT_POSITION_INFO, SessionPositionInfo.DEFAULT, 4);
        } else if (z) {
            playerInfoMaskTimelineAndPositionInfo = maskTimelineAndPositionInfo(playerInfo, remotableTimelineCreateMaskingTimeline, firstWindowIndex, i8, j, j2, 4);
        } else {
            int i11 = firstWindowIndex;
            Timeline.Window window3 = new Timeline.Window();
            remotableTimelineCreateMaskingTimeline.getWindow(i11, window3, 0L);
            long jUsToMs = Util.usToMs(window3.defaultPositionUs);
            long jUsToMs2 = Util.usToMs(window3.durationUs);
            Player.PositionInfo positionInfo2 = new Player.PositionInfo(null, i11, window3.mediaItem, null, i8, jUsToMs, jUsToMs, -1, -1);
            playerInfoMaskTimelineAndPositionInfo = maskTimelineAndPositionInfo(playerInfo, remotableTimelineCreateMaskingTimeline, positionInfo2, new SessionPositionInfo(positionInfo2, false, SystemClock.elapsedRealtime(), jUsToMs2, jUsToMs, MediaUtils.calculateBufferedPercentage(jUsToMs, jUsToMs2), 0L, -9223372036854775807L, jUsToMs2, jUsToMs), 4);
        }
        int i12 = playerInfoMaskTimelineAndPositionInfo.playbackState;
        return (i12 == i3 || i12 == 4 || i >= i2 || i2 != timeline.getWindowCount() || i7 < i) ? playerInfoMaskTimelineAndPositionInfo : playerInfoMaskTimelineAndPositionInfo.copyWithPlaybackState(4, null);
    }

    public static PlayerInfo maskTimelineAndPositionInfo(PlayerInfo playerInfo, Timeline timeline, Player.PositionInfo positionInfo, SessionPositionInfo sessionPositionInfo, int i) {
        SessionPositionInfo sessionPositionInfo2;
        TrackSelectionParameters trackSelectionParameters;
        Tracks tracks;
        boolean z;
        PlaybackException playbackException = playerInfo.playerError;
        int i2 = playerInfo.mediaItemTransitionReason;
        SessionPositionInfo sessionPositionInfo3 = playerInfo.sessionPositionInfo;
        PlaybackParameters playbackParameters = playerInfo.playbackParameters;
        int i3 = playerInfo.repeatMode;
        boolean z2 = playerInfo.shuffleModeEnabled;
        int i4 = playerInfo.timelineChangeReason;
        VideoSize videoSize = playerInfo.videoSize;
        MediaMetadata mediaMetadata = playerInfo.playlistMetadata;
        float f = playerInfo.volume;
        float f2 = playerInfo.unmuteVolume;
        int i5 = playerInfo.audioSessionId;
        AudioAttributes audioAttributes = playerInfo.audioAttributes;
        CueGroup cueGroup = playerInfo.cueGroup;
        DeviceInfo deviceInfo = playerInfo.deviceInfo;
        int i6 = playerInfo.deviceVolume;
        boolean z3 = playerInfo.deviceMuted;
        boolean z4 = playerInfo.playWhenReady;
        int i7 = playerInfo.playWhenReadyChangeReason;
        boolean z5 = playerInfo.isPlaying;
        boolean z6 = playerInfo.isLoading;
        int i8 = playerInfo.playbackSuppressionReason;
        int i9 = playerInfo.playbackState;
        MediaMetadata mediaMetadata2 = playerInfo.mediaMetadata;
        long j = playerInfo.seekBackIncrementMs;
        long j2 = playerInfo.seekForwardIncrementMs;
        long j3 = playerInfo.maxSeekToPreviousPositionMs;
        Tracks tracks2 = playerInfo.currentTracks;
        TrackSelectionParameters trackSelectionParameters2 = playerInfo.trackSelectionParameters;
        Player.PositionInfo positionInfo2 = sessionPositionInfo3.positionInfo;
        if (!timeline.isEmpty()) {
            sessionPositionInfo2 = sessionPositionInfo;
            trackSelectionParameters = trackSelectionParameters2;
            tracks = tracks2;
            if (sessionPositionInfo2.positionInfo.mediaItemIndex >= timeline.getWindowCount()) {
                z = false;
            }
            UtilsKt.checkState(z);
            return new PlayerInfo(playbackException, i2, sessionPositionInfo2, positionInfo2, positionInfo, i, playbackParameters, i3, z2, videoSize, timeline, i4, mediaMetadata, f, f2, audioAttributes, i5, cueGroup, deviceInfo, i6, z3, z4, i7, i8, i9, z5, z6, mediaMetadata2, j, j2, j3, tracks, trackSelectionParameters);
        }
        sessionPositionInfo2 = sessionPositionInfo;
        trackSelectionParameters = trackSelectionParameters2;
        tracks = tracks2;
        z = true;
        UtilsKt.checkState(z);
        return new PlayerInfo(playbackException, i2, sessionPositionInfo2, positionInfo2, positionInfo, i, playbackParameters, i3, z2, videoSize, timeline, i4, mediaMetadata, f, f2, audioAttributes, i5, cueGroup, deviceInfo, i6, z3, z4, i7, i8, i9, z5, z6, mediaMetadata2, j, j2, j3, tracks, trackSelectionParameters);
    }

    public static void rebuildPeriods(Timeline timeline, ArrayList arrayList, ArrayList arrayList2) {
        for (int i = 0; i < arrayList.size(); i++) {
            Timeline.Window window = (Timeline.Window) arrayList.get(i);
            int i2 = window.firstPeriodIndex;
            int i3 = window.lastPeriodIndex;
            if (i2 == -1 || i3 == -1) {
                window.firstPeriodIndex = arrayList2.size();
                window.lastPeriodIndex = arrayList2.size();
                Timeline.Period period = new Timeline.Period();
                period.set(null, null, i, -9223372036854775807L, 0L, AdPlaybackState.NONE, true);
                arrayList2.add(period);
            } else {
                window.firstPeriodIndex = arrayList2.size();
                window.lastPeriodIndex = (i3 - i2) + arrayList2.size();
                while (i2 <= i3) {
                    Timeline.Period period2 = new Timeline.Period();
                    timeline.getPeriod(i2, period2, false);
                    period2.windowIndex = i;
                    arrayList2.add(period2);
                    i2++;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0025  */
    public static RegularImmutableList resolveCustomLayout(List list, List list2, Bundle bundle, SessionCommands sessionCommands, Player.Commands commands, int i) {
        boolean z;
        if (!list2.isEmpty()) {
            return CommandButton.copyWithUnavailableButtonsDisabled(list2, sessionCommands, commands);
        }
        boolean z2 = false;
        if (bundle.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS")) {
            z = false;
        } else {
            if (commands.flags.containsAny(6, 7)) {
                z = false;
            } else {
                z = true;
            }
        }
        if (!bundle.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT")) {
            if (!commands.flags.containsAny(8, 9)) {
                z2 = true;
            }
        }
        return CommandButton.getCustomLayoutFromMediaButtonPreferences(list, z, z2, i);
    }

    public static RegularImmutableList resolveMediaButtonPreferences(List list, List list2, SessionCommands sessionCommands, Player.Commands commands, Bundle bundle) {
        if (list.isEmpty()) {
            list = CommandButton.getMediaButtonPreferencesFromCustomLayout(list2, commands, bundle);
        }
        return CommandButton.copyWithUnavailableButtonsDisabled(list, sessionCommands, commands);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void addListener(Player.Listener listener) {
        this.listeners.add(listener);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void addMediaItems(List list) {
        if (isPlayerCommandAvailable(20)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda99(this, list, (byte) 1));
            addMediaItemsInternal(this.playerInfo.timeline.getWindowCount(), list);
        }
    }

    public final void addMediaItemsInternal(int i, List list) {
        if (list.isEmpty()) {
            return;
        }
        if (this.playerInfo.timeline.isEmpty()) {
            setMediaItemsInternal(list, -1, -9223372036854775807L, false);
        } else {
            updatePlayerInfo(maskPlayerInfoForAddedItems(this.playerInfo, Math.min(i, this.playerInfo.timeline.getWindowCount()), list, getCurrentPosition(), getContentPosition()), 0, null, null, this.playerInfo.timeline.isEmpty() ? 3 : null);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void clearMediaItems() {
        if (isPlayerCommandAvailable(20)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda3(this, (byte) 6));
            removeMediaItemsInternal(0, Integer.MAX_VALUE);
        }
    }

    public final void clearSurfacesAndCallbacks() {
        SurfaceHolder surfaceHolder = this.videoSurfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.surfaceCallback);
            this.videoSurfaceHolder = null;
        }
        if (this.videoSurface != null) {
            this.videoSurface = null;
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void connect() {
        IMediaSession iMediaSession;
        SessionToken sessionToken = this.token;
        SessionToken.SessionTokenImpl sessionTokenImpl = sessionToken.impl;
        SessionToken.SessionTokenImpl sessionTokenImpl2 = sessionToken.impl;
        int type = sessionTokenImpl.getType();
        MediaController mediaController = this.instance;
        Context context = this.context;
        Bundle bundle = this.connectionHints;
        if (type == 0) {
            this.serviceConnection = null;
            Object binder = sessionTokenImpl2.getBinder();
            binder.getClass();
            IBinder iBinder = (IBinder) binder;
            int i = MediaSessionStub.$r8$clinit;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.media3.session.IMediaSession");
            if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMediaSession)) {
                IMediaSession$Stub$Proxy iMediaSession$Stub$Proxy = new IMediaSession$Stub$Proxy();
                iMediaSession$Stub$Proxy.mRemote = iBinder;
                iMediaSession = iMediaSession$Stub$Proxy;
            } else {
                iMediaSession = (IMediaSession) iInterfaceQueryLocalInterface;
            }
            int iObtainNextSequenceNumber = this.sequencedFutureManager.obtainNextSequenceNumber();
            String packageName = context.getPackageName();
            int iMyPid = Process.myPid();
            mediaController.getClass();
            try {
                iMediaSession.connect(this.controllerStub, iObtainNextSequenceNumber, new ConnectionRequest(packageName, iMyPid, bundle).toBundle());
                return;
            } catch (RemoteException e) {
                Log.w("MCImplBase", "Failed to call connection request.", e);
            }
        } else {
            this.serviceConnection = new SessionServiceConnection(bundle);
            int i2 = Build.VERSION.SDK_INT >= 29 ? 4097 : 1;
            Intent intent = new Intent("androidx.media3.session.MediaSessionService");
            intent.setClassName(sessionTokenImpl2.getPackageName(), sessionTokenImpl2.getServiceName());
            try {
                if (context.bindService(intent, this.serviceConnection, i2)) {
                    return;
                }
                Log.w("MCImplBase", "bind to " + sessionToken + " failed");
            } catch (SecurityException e2) {
                Log.w("MCImplBase", "bind to " + sessionToken + " not allowed", e2);
            }
        }
        Objects.requireNonNull(mediaController);
        mediaController.runOnApplicationLooper(new MediaSessionService$$ExternalSyntheticLambda3((byte) 2, mediaController));
    }

    public final Player.Commands createIntersectedCommandsWithControllerOverrides(Player.Commands commands, Player.Commands commands2) {
        Player.Commands commandsIntersect = MediaUtils.intersect(commands, commands2);
        boolean z = this.playerInfo.deviceInfo.playbackType == 0;
        boolean zContains = commandsIntersect.contains(32);
        FlagSet flagSet = commandsIntersect.flags;
        if (zContains && (!z || !flagSet.containsAny(25, 33, 26, 34))) {
            return commandsIntersect;
        }
        FlagSet.Builder builder = new FlagSet.Builder((byte) 0);
        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) builder.flags;
        builder.addAll(flagSet);
        builder.add(32);
        if (z) {
            UtilsKt.checkState(!builder.buildCalled);
            sparseBooleanArray.delete(25);
        }
        if (z) {
            UtilsKt.checkState(!builder.buildCalled);
            sparseBooleanArray.delete(33);
        }
        if (z) {
            UtilsKt.checkState(!builder.buildCalled);
            sparseBooleanArray.delete(26);
        }
        if (z) {
            UtilsKt.checkState(!builder.buildCalled);
            sparseBooleanArray.delete(34);
        }
        return new Player.Commands(builder.build());
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void decreaseDeviceVolume() {
        if (isPlayerCommandAvailable(26)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda3(this, (byte) 14));
            PlayerInfo playerInfo = this.playerInfo;
            int i = playerInfo.deviceVolume - 1;
            if (i >= playerInfo.deviceInfo.minVolume) {
                this.playerInfo = playerInfo.copyWithDeviceVolume(i, playerInfo.deviceMuted);
                MediaControllerImplBase$$ExternalSyntheticLambda10 mediaControllerImplBase$$ExternalSyntheticLambda10 = new MediaControllerImplBase$$ExternalSyntheticLambda10(this, i, (byte) 9);
                ListenerSet listenerSet = this.listeners;
                listenerSet.queueEvent(30, mediaControllerImplBase$$ExternalSyntheticLambda10);
                listenerSet.flushEvents();
            }
        }
    }

    public final ListenableFuture dispatchRemoteSessionTask(IMediaSession iMediaSession, RemoteSessionTask remoteSessionTask, boolean z) {
        android.media.session.MediaController mediaController;
        if (iMediaSession == null) {
            return new ImmediateFuture(new SessionResult(-4));
        }
        if (Build.VERSION.SDK_INT >= 31 && (mediaController = this.platformController) != null) {
            mediaController.getTransportControls().sendCustomAction("androidx.media3.session.SESSION_COMMAND_MEDIA3_PLAY_REQUEST", (Bundle) null);
        }
        SessionResult sessionResult = new SessionResult(1);
        NodeChain.Differ differ = this.sequencedFutureManager;
        SequencedFutureManager$SequencedFuture sequencedFutureManager$SequencedFutureCreateSequencedFuture = differ.createSequencedFuture(sessionResult);
        int i = sequencedFutureManager$SequencedFutureCreateSequencedFuture.sequenceNumber;
        ArraySet arraySet = this.pendingMaskingSequencedFutureNumbers;
        if (z) {
            if (arraySet.isEmpty()) {
                this.pendingPlayerInfo = this.playerInfo;
            }
            arraySet.add(Integer.valueOf(i));
        }
        try {
            remoteSessionTask.run(iMediaSession, i);
            return sequencedFutureManager$SequencedFutureCreateSequencedFuture;
        } catch (RemoteException e) {
            Log.w("MCImplBase", "Cannot connect to the service or the session is gone", e);
            arraySet.remove(Integer.valueOf(i));
            differ.setFutureResult(i, new SessionResult(-100));
            return sequencedFutureManager$SequencedFutureCreateSequencedFuture;
        }
    }

    public final void dispatchRemoteSessionTaskWithPlayerCommand(RemoteSessionTask remoteSessionTask) {
        Splitter splitter = this.flushCommandQueueHandler;
        Handler handler = (Handler) splitter.trimmer;
        if (((MediaControllerImplBase) splitter.strategy).iSession != null && !handler.hasMessages(1)) {
            handler.sendEmptyMessage(1);
        }
        dispatchRemoteSessionTask(this.iSession, remoteSessionTask, true);
    }

    public final void dispatchRemoteSessionTaskWithPlayerCommandAndWaitForFuture(RemoteSessionTask remoteSessionTask) {
        Splitter splitter = this.flushCommandQueueHandler;
        Handler handler = (Handler) splitter.trimmer;
        if (((MediaControllerImplBase) splitter.strategy).iSession != null && !handler.hasMessages(1)) {
            handler.sendEmptyMessage(1);
        }
        ListenableFuture listenableFutureDispatchRemoteSessionTask = dispatchRemoteSessionTask(this.iSession, remoteSessionTask, true);
        try {
            LegacyConversions.getFutureResult(listenableFutureDispatchRemoteSessionTask);
        } catch (ExecutionException e) {
            throw new IllegalStateException(e);
        } catch (TimeoutException e2) {
            if (listenableFutureDispatchRemoteSessionTask instanceof SequencedFutureManager$SequencedFuture) {
                int i = ((SequencedFutureManager$SequencedFuture) listenableFutureDispatchRemoteSessionTask).sequenceNumber;
                this.pendingMaskingSequencedFutureNumbers.remove(Integer.valueOf(i));
                this.sequencedFutureManager.setFutureResult(i, new SessionResult(-1));
            }
            Log.w("MCImplBase", "Synchronous command takes too long on the session side.", e2);
        }
    }

    public final ListenableFuture dispatchRemoteSessionTaskWithSessionCommand(SessionCommand sessionCommand, RemoteSessionTask remoteSessionTask) {
        IMediaSession iMediaSession;
        int i = sessionCommand.commandCode;
        String str = sessionCommand.customAction;
        UtilsKt.checkArgument(i == 0);
        if (this.sessionCommands.commands.contains(sessionCommand) || CommandButton.isPredefinedCustomCommandButtonCode(str)) {
            iMediaSession = this.iSession;
        } else {
            Log.w("MCImplBase", "Controller isn't allowed to call custom session command:".concat(str));
            iMediaSession = null;
        }
        return dispatchRemoteSessionTask(iMediaSession, remoteSessionTask, false);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final AudioAttributes getAudioAttributes() {
        return this.playerInfo.audioAttributes;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final Player.Commands getAvailableCommands() {
        return this.intersectedPlayerCommands;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final SessionCommands getAvailableSessionCommands() {
        return this.sessionCommands;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int getBufferedPercentage() {
        return this.playerInfo.sessionPositionInfo.bufferedPercentage;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long getBufferedPosition() {
        return this.playerInfo.sessionPositionInfo.bufferedPositionMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final Bundle getConnectionHints() {
        return this.connectionHints;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long getContentBufferedPosition() {
        return this.playerInfo.sessionPositionInfo.contentBufferedPositionMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long getContentDuration() {
        return this.playerInfo.sessionPositionInfo.contentDurationMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long getContentPosition() {
        SessionPositionInfo sessionPositionInfo = this.playerInfo.sessionPositionInfo;
        return !sessionPositionInfo.isPlayingAd ? getCurrentPosition() : sessionPositionInfo.positionInfo.contentPositionMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int getCurrentAdGroupIndex() {
        return this.playerInfo.sessionPositionInfo.positionInfo.adGroupIndex;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int getCurrentAdIndexInAdGroup() {
        return this.playerInfo.sessionPositionInfo.positionInfo.adIndexInAdGroup;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final CueGroup getCurrentCues() {
        return this.playerInfo.cueGroup;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long getCurrentLiveOffset() {
        return this.playerInfo.sessionPositionInfo.currentLiveOffsetMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int getCurrentMediaItemIndex() {
        return getCurrentMediaItemIndexInternal(this.playerInfo);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int getCurrentPeriodIndex() {
        return this.playerInfo.sessionPositionInfo.positionInfo.periodIndex;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long getCurrentPosition() {
        long updatedCurrentPositionMs = MediaUtils.getUpdatedCurrentPositionMs(this.playerInfo, this.currentPositionMs, this.lastSetPlayWhenReadyCalledTimeMs, this.instance.timeDiffMs);
        this.currentPositionMs = updatedCurrentPositionMs;
        return updatedCurrentPositionMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final Timeline getCurrentTimeline() {
        return this.playerInfo.timeline;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final Tracks getCurrentTracks() {
        return this.playerInfo.currentTracks;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final DeviceInfo getDeviceInfo() {
        return this.playerInfo.deviceInfo;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int getDeviceVolume() {
        return this.playerInfo.deviceVolume;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long getDuration() {
        return this.playerInfo.sessionPositionInfo.durationMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long getMaxSeekToPreviousPosition() {
        return this.playerInfo.maxSeekToPreviousPositionMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final ImmutableList getMediaButtonPreferences() {
        return this.resolvedMediaButtonPreferences;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final MediaMetadata getMediaMetadata() {
        return this.playerInfo.mediaMetadata;
    }

    public final int getNextMediaItemIndex() {
        if (this.playerInfo.timeline.isEmpty()) {
            return -1;
        }
        PlayerInfo playerInfo = this.playerInfo;
        Timeline timeline = playerInfo.timeline;
        int currentMediaItemIndexInternal = getCurrentMediaItemIndexInternal(playerInfo);
        PlayerInfo playerInfo2 = this.playerInfo;
        int i = playerInfo2.repeatMode;
        if (i == 1) {
            i = 0;
        }
        return timeline.getNextWindowIndex(currentMediaItemIndexInternal, playerInfo2.shuffleModeEnabled, i);
    }

    public final InstantParseResult.Success getPeriodInfo(Timeline timeline, int i, long j) {
        if (timeline.isEmpty()) {
            return null;
        }
        Timeline.Window window = new Timeline.Window();
        Timeline.Period period = new Timeline.Period();
        if (i == -1 || i >= timeline.getWindowCount()) {
            i = timeline.getFirstWindowIndex(this.playerInfo.shuffleModeEnabled);
            j = Util.usToMs(timeline.getWindow(i, window, 0L).defaultPositionUs);
        }
        long jMsToUs = Util.msToUs(j);
        UtilsKt.checkElementIndex(i, timeline.getWindowCount());
        timeline.getWindow(i, window);
        if (jMsToUs == -9223372036854775807L) {
            jMsToUs = window.defaultPositionUs;
            if (jMsToUs == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = window.firstPeriodIndex;
        timeline.getPeriod(i2, period, false);
        while (i2 < window.lastPeriodIndex && period.positionInWindowUs != jMsToUs) {
            int i3 = i2 + 1;
            if (timeline.getPeriod(i3, period, false).positionInWindowUs > jMsToUs) {
                break;
            }
            i2 = i3;
        }
        timeline.getPeriod(i2, period, false);
        return new InstantParseResult.Success(i2, jMsToUs - period.positionInWindowUs);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean getPlayWhenReady() {
        return this.playerInfo.playWhenReady;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final PlaybackParameters getPlaybackParameters() {
        return this.playerInfo.playbackParameters;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int getPlaybackState() {
        return this.playerInfo.playbackState;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int getPlaybackSuppressionReason() {
        return this.playerInfo.playbackSuppressionReason;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final PlaybackException getPlayerError() {
        return this.playerInfo.playerError;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final MediaMetadata getPlaylistMetadata() {
        return this.playerInfo.playlistMetadata;
    }

    public final int getPreviousMediaItemIndex() {
        if (this.playerInfo.timeline.isEmpty()) {
            return -1;
        }
        PlayerInfo playerInfo = this.playerInfo;
        Timeline timeline = playerInfo.timeline;
        int currentMediaItemIndexInternal = getCurrentMediaItemIndexInternal(playerInfo);
        PlayerInfo playerInfo2 = this.playerInfo;
        int i = playerInfo2.repeatMode;
        if (i == 1) {
            i = 0;
        }
        return timeline.getPreviousWindowIndex(currentMediaItemIndexInternal, playerInfo2.shuffleModeEnabled, i);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final int getRepeatMode() {
        return this.playerInfo.repeatMode;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long getSeekBackIncrement() {
        return this.playerInfo.seekBackIncrementMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long getSeekForwardIncrement() {
        return this.playerInfo.seekForwardIncrementMs;
    }

    public final int getSessionInterfaceVersion() {
        SessionToken sessionToken = this.connectedToken;
        sessionToken.getClass();
        return sessionToken.impl.getInterfaceVersion();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean getShuffleModeEnabled() {
        return this.playerInfo.shuffleModeEnabled;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final long getTotalBufferedDuration() {
        return this.playerInfo.sessionPositionInfo.totalBufferedDurationMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final TrackSelectionParameters getTrackSelectionParameters() {
        return this.playerInfo.trackSelectionParameters;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final VideoSize getVideoSize() {
        return this.playerInfo.videoSize;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final float getVolume() {
        return this.playerInfo.volume;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void increaseDeviceVolume() {
        if (isPlayerCommandAvailable(26)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda3(this, (byte) 9));
            PlayerInfo playerInfo = this.playerInfo;
            int i = playerInfo.deviceVolume + 1;
            int i2 = playerInfo.deviceInfo.maxVolume;
            if (i2 == 0 || i <= i2) {
                this.playerInfo = playerInfo.copyWithDeviceVolume(i, playerInfo.deviceMuted);
                MediaControllerImplBase$$ExternalSyntheticLambda10 mediaControllerImplBase$$ExternalSyntheticLambda10 = new MediaControllerImplBase$$ExternalSyntheticLambda10(this, i, (byte) 3);
                ListenerSet listenerSet = this.listeners;
                listenerSet.queueEvent(30, mediaControllerImplBase$$ExternalSyntheticLambda10);
                listenerSet.flushEvents();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean isConnected() {
        return this.iSession != null;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean isDeviceMuted() {
        return this.playerInfo.deviceMuted;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean isLoading() {
        return this.playerInfo.isLoading;
    }

    public final boolean isPlayerCommandAvailable(int i) {
        if (this.intersectedPlayerCommands.contains(i)) {
            return true;
        }
        Format$$ExternalSyntheticOutline0.m(i, "Controller isn't allowed to call command= ", "MCImplBase");
        return false;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean isPlaying() {
        return this.playerInfo.isPlaying;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final boolean isPlayingAd() {
        return this.playerInfo.sessionPositionInfo.isPlayingAd;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void moveMediaItem(int i, int i2) {
        if (isPlayerCommandAvailable(20)) {
            UtilsKt.checkArgument(i >= 0 && i2 >= 0);
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda48(this, i, i2, (byte) 1));
            moveMediaItemsInternal(i, i + 1, i2);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void moveMediaItems(final int i, final int i2, final int i3) {
        if (isPlayerCommandAvailable(20)) {
            UtilsKt.checkArgument(i >= 0 && i <= i2 && i3 >= 0);
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda55
                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i4) {
                    iMediaSession.moveMediaItems(this.f$0.controllerStub, i4, i, i2, i3);
                }
            });
            moveMediaItemsInternal(i, i2, i3);
        }
    }

    public final void moveMediaItemsInternal(int i, int i2, int i3) {
        int i4;
        int i5;
        Timeline timeline = this.playerInfo.timeline;
        int windowCount = timeline.getWindowCount();
        int iMin = Math.min(i2, windowCount);
        int i6 = iMin - i;
        int iMin2 = Math.min(i3, windowCount - i6);
        if (i >= windowCount || i == iMin || i == iMin2) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i7 = 0; i7 < windowCount; i7++) {
            arrayList.add(timeline.getWindow(i7, new Timeline.Window(), 0L));
        }
        Util.moveItems(arrayList, i, iMin, iMin2);
        rebuildPeriods(timeline, arrayList, arrayList2);
        Timeline.RemotableTimeline remotableTimelineCreateMaskingTimeline = createMaskingTimeline(arrayList, arrayList2);
        if (remotableTimelineCreateMaskingTimeline.isEmpty()) {
            return;
        }
        int currentMediaItemIndexInternal = getCurrentMediaItemIndexInternal(this.playerInfo);
        if (currentMediaItemIndexInternal >= i && currentMediaItemIndexInternal < iMin) {
            i5 = (currentMediaItemIndexInternal - i) + iMin2;
        } else {
            if (iMin > currentMediaItemIndexInternal || iMin2 <= currentMediaItemIndexInternal) {
                if (iMin <= currentMediaItemIndexInternal || iMin2 > currentMediaItemIndexInternal) {
                    i4 = currentMediaItemIndexInternal;
                } else {
                    i5 = currentMediaItemIndexInternal + i6;
                }
                Timeline.Window window = new Timeline.Window();
                int i8 = this.playerInfo.sessionPositionInfo.positionInfo.periodIndex - timeline.getWindow(currentMediaItemIndexInternal, window, 0L).firstPeriodIndex;
                remotableTimelineCreateMaskingTimeline.getWindow(i4, window, 0L);
                updatePlayerInfo(maskTimelineAndPositionInfo(this.playerInfo, remotableTimelineCreateMaskingTimeline, i4, window.firstPeriodIndex + i8, getCurrentPosition(), getContentPosition(), 5), 0, null, null, null);
            }
            i5 = currentMediaItemIndexInternal - i6;
        }
        i4 = i5;
        Timeline.Window window2 = new Timeline.Window();
        int i9 = this.playerInfo.sessionPositionInfo.positionInfo.periodIndex - timeline.getWindow(currentMediaItemIndexInternal, window2, 0L).firstPeriodIndex;
        remotableTimelineCreateMaskingTimeline.getWindow(i4, window2, 0L);
        updatePlayerInfo(maskTimelineAndPositionInfo(this.playerInfo, remotableTimelineCreateMaskingTimeline, i4, window2.firstPeriodIndex + i9, getCurrentPosition(), getContentPosition(), 5), 0, null, null, null);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void mute() {
        if (isPlayerCommandAvailable(24)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda3(this, (byte) 12));
            PlayerInfo playerInfo = this.playerInfo;
            if (playerInfo.volume != CropImageView.DEFAULT_ASPECT_RATIO) {
                this.playerInfo = playerInfo.copyWithVolume(CropImageView.DEFAULT_ASPECT_RATIO);
                MediaSessionStub$$ExternalSyntheticLambda8 mediaSessionStub$$ExternalSyntheticLambda8 = new MediaSessionStub$$ExternalSyntheticLambda8((byte) 3);
                ListenerSet listenerSet = this.listeners;
                listenerSet.queueEvent(22, mediaSessionStub$$ExternalSyntheticLambda8);
                listenerSet.flushEvents();
            }
        }
    }

    public final void notifyPlayerInfoListenersWithReasons(PlayerInfo playerInfo, final PlayerInfo playerInfo2, final Integer num, final Integer num2, final Integer num3, Integer num4) {
        final byte b = 0;
        ListenerSet listenerSet = this.listeners;
        if (num != null) {
            listenerSet.queueEvent(0, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda20
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b2 = b;
                    Integer num5 = num;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b2) {
                        case 0:
                            listener.onTimelineChanged(playerInfo3.timeline, num5.intValue());
                            break;
                        case 1:
                            listener.onPositionDiscontinuity(num5.intValue(), playerInfo3.oldPositionInfo, playerInfo3.newPositionInfo);
                            break;
                        default:
                            listener.onPlayWhenReadyChanged(num5.intValue(), playerInfo3.playWhenReady);
                            break;
                    }
                }
            });
        }
        final byte b2 = 1;
        final byte b3 = 11;
        if (num3 != null) {
            listenerSet.queueEvent(11, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda20
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b4 = b2;
                    Integer num5 = num3;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b4) {
                        case 0:
                            listener.onTimelineChanged(playerInfo3.timeline, num5.intValue());
                            break;
                        case 1:
                            listener.onPositionDiscontinuity(num5.intValue(), playerInfo3.oldPositionInfo, playerInfo3.newPositionInfo);
                            break;
                        default:
                            listener.onPlayWhenReadyChanged(num5.intValue(), playerInfo3.playWhenReady);
                            break;
                    }
                }
            });
        }
        MediaItem currentMediaItem = playerInfo2.getCurrentMediaItem();
        if (num4 != null) {
            listenerSet.queueEvent(1, new TextLinkScope$$ExternalSyntheticLambda10(currentMediaItem, num4, b3));
        }
        PlaybackException playbackException = playerInfo.playerError;
        PlaybackException playbackException2 = playerInfo2.playerError;
        final byte b4 = 2;
        final byte b5 = 10;
        if (playbackException != playbackException2 && (playbackException == null || !playbackException.errorInfoEquals(playbackException2))) {
            listenerSet.queueEvent(10, new MediaControllerImplBase$$ExternalSyntheticLambda41(playbackException2, (byte) 0));
            if (playbackException2 != null) {
                listenerSet.queueEvent(10, new MediaControllerImplBase$$ExternalSyntheticLambda41(playbackException2, (byte) 2));
            }
        }
        final byte b6 = 18;
        if (!playerInfo.currentTracks.equals(playerInfo2.currentTracks)) {
            listenerSet.queueEvent(2, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda21
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b7 = b6;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b7) {
                        case 0:
                            listener.onPlaybackSuppressionReasonChanged(playerInfo3.playbackSuppressionReason);
                            break;
                        case 1:
                            listener.onIsPlayingChanged(playerInfo3.isPlaying);
                            break;
                        case 2:
                            listener.onPlaybackParametersChanged(playerInfo3.playbackParameters);
                            break;
                        case 3:
                            listener.onRepeatModeChanged(playerInfo3.repeatMode);
                            break;
                        case 4:
                            listener.onShuffleModeEnabledChanged(playerInfo3.shuffleModeEnabled);
                            break;
                        case 5:
                            listener.onPlaylistMetadataChanged(playerInfo3.playlistMetadata);
                            break;
                        case 6:
                            listener.onVolumeChanged(playerInfo3.volume);
                            break;
                        case 7:
                            listener.onAudioAttributesChanged(playerInfo3.audioAttributes);
                            break;
                        case 8:
                            listener.onAudioSessionIdChanged(playerInfo3.audioSessionId);
                            break;
                        case 9:
                            listener.onCues(playerInfo3.cueGroup.cues);
                            break;
                        case 10:
                            listener.onCues(playerInfo3.cueGroup);
                            break;
                        case 11:
                            listener.onDeviceInfoChanged(playerInfo3.deviceInfo);
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 13:
                            listener.onVideoSizeChanged(playerInfo3.videoSize);
                            break;
                        case 14:
                            listener.onSeekBackIncrementChanged(playerInfo3.seekBackIncrementMs);
                            break;
                        case 15:
                            listener.onSeekForwardIncrementChanged(playerInfo3.seekForwardIncrementMs);
                            break;
                        case 16:
                            listener.onMaxSeekToPreviousPositionChanged(playerInfo3.maxSeekToPreviousPositionMs);
                            break;
                        case 17:
                            listener.onTrackSelectionParametersChanged(playerInfo3.trackSelectionParameters);
                            break;
                        case 18:
                            listener.onTracksChanged(playerInfo3.currentTracks);
                            break;
                        case 19:
                            listener.onMediaMetadataChanged(playerInfo3.mediaMetadata);
                            break;
                        case 20:
                            listener.onIsLoadingChanged(playerInfo3.isLoading);
                            break;
                        default:
                            listener.onPlaybackStateChanged(playerInfo3.playbackState);
                            break;
                    }
                }
            });
        }
        final byte b7 = 19;
        if (!playerInfo.mediaMetadata.equals(playerInfo2.mediaMetadata)) {
            listenerSet.queueEvent(14, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda21
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b8 = b7;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b8) {
                        case 0:
                            listener.onPlaybackSuppressionReasonChanged(playerInfo3.playbackSuppressionReason);
                            break;
                        case 1:
                            listener.onIsPlayingChanged(playerInfo3.isPlaying);
                            break;
                        case 2:
                            listener.onPlaybackParametersChanged(playerInfo3.playbackParameters);
                            break;
                        case 3:
                            listener.onRepeatModeChanged(playerInfo3.repeatMode);
                            break;
                        case 4:
                            listener.onShuffleModeEnabledChanged(playerInfo3.shuffleModeEnabled);
                            break;
                        case 5:
                            listener.onPlaylistMetadataChanged(playerInfo3.playlistMetadata);
                            break;
                        case 6:
                            listener.onVolumeChanged(playerInfo3.volume);
                            break;
                        case 7:
                            listener.onAudioAttributesChanged(playerInfo3.audioAttributes);
                            break;
                        case 8:
                            listener.onAudioSessionIdChanged(playerInfo3.audioSessionId);
                            break;
                        case 9:
                            listener.onCues(playerInfo3.cueGroup.cues);
                            break;
                        case 10:
                            listener.onCues(playerInfo3.cueGroup);
                            break;
                        case 11:
                            listener.onDeviceInfoChanged(playerInfo3.deviceInfo);
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 13:
                            listener.onVideoSizeChanged(playerInfo3.videoSize);
                            break;
                        case 14:
                            listener.onSeekBackIncrementChanged(playerInfo3.seekBackIncrementMs);
                            break;
                        case 15:
                            listener.onSeekForwardIncrementChanged(playerInfo3.seekForwardIncrementMs);
                            break;
                        case 16:
                            listener.onMaxSeekToPreviousPositionChanged(playerInfo3.maxSeekToPreviousPositionMs);
                            break;
                        case 17:
                            listener.onTrackSelectionParametersChanged(playerInfo3.trackSelectionParameters);
                            break;
                        case 18:
                            listener.onTracksChanged(playerInfo3.currentTracks);
                            break;
                        case 19:
                            listener.onMediaMetadataChanged(playerInfo3.mediaMetadata);
                            break;
                        case 20:
                            listener.onIsLoadingChanged(playerInfo3.isLoading);
                            break;
                        default:
                            listener.onPlaybackStateChanged(playerInfo3.playbackState);
                            break;
                    }
                }
            });
        }
        final byte b8 = 20;
        final byte b9 = 3;
        if (playerInfo.isLoading != playerInfo2.isLoading) {
            listenerSet.queueEvent(3, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda21
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b10 = b8;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b10) {
                        case 0:
                            listener.onPlaybackSuppressionReasonChanged(playerInfo3.playbackSuppressionReason);
                            break;
                        case 1:
                            listener.onIsPlayingChanged(playerInfo3.isPlaying);
                            break;
                        case 2:
                            listener.onPlaybackParametersChanged(playerInfo3.playbackParameters);
                            break;
                        case 3:
                            listener.onRepeatModeChanged(playerInfo3.repeatMode);
                            break;
                        case 4:
                            listener.onShuffleModeEnabledChanged(playerInfo3.shuffleModeEnabled);
                            break;
                        case 5:
                            listener.onPlaylistMetadataChanged(playerInfo3.playlistMetadata);
                            break;
                        case 6:
                            listener.onVolumeChanged(playerInfo3.volume);
                            break;
                        case 7:
                            listener.onAudioAttributesChanged(playerInfo3.audioAttributes);
                            break;
                        case 8:
                            listener.onAudioSessionIdChanged(playerInfo3.audioSessionId);
                            break;
                        case 9:
                            listener.onCues(playerInfo3.cueGroup.cues);
                            break;
                        case 10:
                            listener.onCues(playerInfo3.cueGroup);
                            break;
                        case 11:
                            listener.onDeviceInfoChanged(playerInfo3.deviceInfo);
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 13:
                            listener.onVideoSizeChanged(playerInfo3.videoSize);
                            break;
                        case 14:
                            listener.onSeekBackIncrementChanged(playerInfo3.seekBackIncrementMs);
                            break;
                        case 15:
                            listener.onSeekForwardIncrementChanged(playerInfo3.seekForwardIncrementMs);
                            break;
                        case 16:
                            listener.onMaxSeekToPreviousPositionChanged(playerInfo3.maxSeekToPreviousPositionMs);
                            break;
                        case 17:
                            listener.onTrackSelectionParametersChanged(playerInfo3.trackSelectionParameters);
                            break;
                        case 18:
                            listener.onTracksChanged(playerInfo3.currentTracks);
                            break;
                        case 19:
                            listener.onMediaMetadataChanged(playerInfo3.mediaMetadata);
                            break;
                        case 20:
                            listener.onIsLoadingChanged(playerInfo3.isLoading);
                            break;
                        default:
                            listener.onPlaybackStateChanged(playerInfo3.playbackState);
                            break;
                    }
                }
            });
        }
        final byte b10 = 21;
        final byte b11 = 4;
        if (playerInfo.playbackState != playerInfo2.playbackState) {
            listenerSet.queueEvent(4, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda21
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b12 = b10;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b12) {
                        case 0:
                            listener.onPlaybackSuppressionReasonChanged(playerInfo3.playbackSuppressionReason);
                            break;
                        case 1:
                            listener.onIsPlayingChanged(playerInfo3.isPlaying);
                            break;
                        case 2:
                            listener.onPlaybackParametersChanged(playerInfo3.playbackParameters);
                            break;
                        case 3:
                            listener.onRepeatModeChanged(playerInfo3.repeatMode);
                            break;
                        case 4:
                            listener.onShuffleModeEnabledChanged(playerInfo3.shuffleModeEnabled);
                            break;
                        case 5:
                            listener.onPlaylistMetadataChanged(playerInfo3.playlistMetadata);
                            break;
                        case 6:
                            listener.onVolumeChanged(playerInfo3.volume);
                            break;
                        case 7:
                            listener.onAudioAttributesChanged(playerInfo3.audioAttributes);
                            break;
                        case 8:
                            listener.onAudioSessionIdChanged(playerInfo3.audioSessionId);
                            break;
                        case 9:
                            listener.onCues(playerInfo3.cueGroup.cues);
                            break;
                        case 10:
                            listener.onCues(playerInfo3.cueGroup);
                            break;
                        case 11:
                            listener.onDeviceInfoChanged(playerInfo3.deviceInfo);
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 13:
                            listener.onVideoSizeChanged(playerInfo3.videoSize);
                            break;
                        case 14:
                            listener.onSeekBackIncrementChanged(playerInfo3.seekBackIncrementMs);
                            break;
                        case 15:
                            listener.onSeekForwardIncrementChanged(playerInfo3.seekForwardIncrementMs);
                            break;
                        case 16:
                            listener.onMaxSeekToPreviousPositionChanged(playerInfo3.maxSeekToPreviousPositionMs);
                            break;
                        case 17:
                            listener.onTrackSelectionParametersChanged(playerInfo3.trackSelectionParameters);
                            break;
                        case 18:
                            listener.onTracksChanged(playerInfo3.currentTracks);
                            break;
                        case 19:
                            listener.onMediaMetadataChanged(playerInfo3.mediaMetadata);
                            break;
                        case 20:
                            listener.onIsLoadingChanged(playerInfo3.isLoading);
                            break;
                        default:
                            listener.onPlaybackStateChanged(playerInfo3.playbackState);
                            break;
                    }
                }
            });
        }
        final byte b12 = 5;
        if (num2 != null) {
            listenerSet.queueEvent(5, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda20
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b13 = b4;
                    Integer num5 = num2;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b13) {
                        case 0:
                            listener.onTimelineChanged(playerInfo3.timeline, num5.intValue());
                            break;
                        case 1:
                            listener.onPositionDiscontinuity(num5.intValue(), playerInfo3.oldPositionInfo, playerInfo3.newPositionInfo);
                            break;
                        default:
                            listener.onPlayWhenReadyChanged(num5.intValue(), playerInfo3.playWhenReady);
                            break;
                    }
                }
            });
        }
        final byte b13 = 6;
        if (playerInfo.playbackSuppressionReason != playerInfo2.playbackSuppressionReason) {
            listenerSet.queueEvent(6, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda21
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b14 = b;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b14) {
                        case 0:
                            listener.onPlaybackSuppressionReasonChanged(playerInfo3.playbackSuppressionReason);
                            break;
                        case 1:
                            listener.onIsPlayingChanged(playerInfo3.isPlaying);
                            break;
                        case 2:
                            listener.onPlaybackParametersChanged(playerInfo3.playbackParameters);
                            break;
                        case 3:
                            listener.onRepeatModeChanged(playerInfo3.repeatMode);
                            break;
                        case 4:
                            listener.onShuffleModeEnabledChanged(playerInfo3.shuffleModeEnabled);
                            break;
                        case 5:
                            listener.onPlaylistMetadataChanged(playerInfo3.playlistMetadata);
                            break;
                        case 6:
                            listener.onVolumeChanged(playerInfo3.volume);
                            break;
                        case 7:
                            listener.onAudioAttributesChanged(playerInfo3.audioAttributes);
                            break;
                        case 8:
                            listener.onAudioSessionIdChanged(playerInfo3.audioSessionId);
                            break;
                        case 9:
                            listener.onCues(playerInfo3.cueGroup.cues);
                            break;
                        case 10:
                            listener.onCues(playerInfo3.cueGroup);
                            break;
                        case 11:
                            listener.onDeviceInfoChanged(playerInfo3.deviceInfo);
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 13:
                            listener.onVideoSizeChanged(playerInfo3.videoSize);
                            break;
                        case 14:
                            listener.onSeekBackIncrementChanged(playerInfo3.seekBackIncrementMs);
                            break;
                        case 15:
                            listener.onSeekForwardIncrementChanged(playerInfo3.seekForwardIncrementMs);
                            break;
                        case 16:
                            listener.onMaxSeekToPreviousPositionChanged(playerInfo3.maxSeekToPreviousPositionMs);
                            break;
                        case 17:
                            listener.onTrackSelectionParametersChanged(playerInfo3.trackSelectionParameters);
                            break;
                        case 18:
                            listener.onTracksChanged(playerInfo3.currentTracks);
                            break;
                        case 19:
                            listener.onMediaMetadataChanged(playerInfo3.mediaMetadata);
                            break;
                        case 20:
                            listener.onIsLoadingChanged(playerInfo3.isLoading);
                            break;
                        default:
                            listener.onPlaybackStateChanged(playerInfo3.playbackState);
                            break;
                    }
                }
            });
        }
        final byte b14 = 7;
        if (playerInfo.isPlaying != playerInfo2.isPlaying) {
            listenerSet.queueEvent(7, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda21
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b15 = b2;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b15) {
                        case 0:
                            listener.onPlaybackSuppressionReasonChanged(playerInfo3.playbackSuppressionReason);
                            break;
                        case 1:
                            listener.onIsPlayingChanged(playerInfo3.isPlaying);
                            break;
                        case 2:
                            listener.onPlaybackParametersChanged(playerInfo3.playbackParameters);
                            break;
                        case 3:
                            listener.onRepeatModeChanged(playerInfo3.repeatMode);
                            break;
                        case 4:
                            listener.onShuffleModeEnabledChanged(playerInfo3.shuffleModeEnabled);
                            break;
                        case 5:
                            listener.onPlaylistMetadataChanged(playerInfo3.playlistMetadata);
                            break;
                        case 6:
                            listener.onVolumeChanged(playerInfo3.volume);
                            break;
                        case 7:
                            listener.onAudioAttributesChanged(playerInfo3.audioAttributes);
                            break;
                        case 8:
                            listener.onAudioSessionIdChanged(playerInfo3.audioSessionId);
                            break;
                        case 9:
                            listener.onCues(playerInfo3.cueGroup.cues);
                            break;
                        case 10:
                            listener.onCues(playerInfo3.cueGroup);
                            break;
                        case 11:
                            listener.onDeviceInfoChanged(playerInfo3.deviceInfo);
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 13:
                            listener.onVideoSizeChanged(playerInfo3.videoSize);
                            break;
                        case 14:
                            listener.onSeekBackIncrementChanged(playerInfo3.seekBackIncrementMs);
                            break;
                        case 15:
                            listener.onSeekForwardIncrementChanged(playerInfo3.seekForwardIncrementMs);
                            break;
                        case 16:
                            listener.onMaxSeekToPreviousPositionChanged(playerInfo3.maxSeekToPreviousPositionMs);
                            break;
                        case 17:
                            listener.onTrackSelectionParametersChanged(playerInfo3.trackSelectionParameters);
                            break;
                        case 18:
                            listener.onTracksChanged(playerInfo3.currentTracks);
                            break;
                        case 19:
                            listener.onMediaMetadataChanged(playerInfo3.mediaMetadata);
                            break;
                        case 20:
                            listener.onIsLoadingChanged(playerInfo3.isLoading);
                            break;
                        default:
                            listener.onPlaybackStateChanged(playerInfo3.playbackState);
                            break;
                    }
                }
            });
        }
        final byte b15 = 12;
        if (!playerInfo.playbackParameters.equals(playerInfo2.playbackParameters)) {
            listenerSet.queueEvent(12, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda21
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b16 = b4;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b16) {
                        case 0:
                            listener.onPlaybackSuppressionReasonChanged(playerInfo3.playbackSuppressionReason);
                            break;
                        case 1:
                            listener.onIsPlayingChanged(playerInfo3.isPlaying);
                            break;
                        case 2:
                            listener.onPlaybackParametersChanged(playerInfo3.playbackParameters);
                            break;
                        case 3:
                            listener.onRepeatModeChanged(playerInfo3.repeatMode);
                            break;
                        case 4:
                            listener.onShuffleModeEnabledChanged(playerInfo3.shuffleModeEnabled);
                            break;
                        case 5:
                            listener.onPlaylistMetadataChanged(playerInfo3.playlistMetadata);
                            break;
                        case 6:
                            listener.onVolumeChanged(playerInfo3.volume);
                            break;
                        case 7:
                            listener.onAudioAttributesChanged(playerInfo3.audioAttributes);
                            break;
                        case 8:
                            listener.onAudioSessionIdChanged(playerInfo3.audioSessionId);
                            break;
                        case 9:
                            listener.onCues(playerInfo3.cueGroup.cues);
                            break;
                        case 10:
                            listener.onCues(playerInfo3.cueGroup);
                            break;
                        case 11:
                            listener.onDeviceInfoChanged(playerInfo3.deviceInfo);
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 13:
                            listener.onVideoSizeChanged(playerInfo3.videoSize);
                            break;
                        case 14:
                            listener.onSeekBackIncrementChanged(playerInfo3.seekBackIncrementMs);
                            break;
                        case 15:
                            listener.onSeekForwardIncrementChanged(playerInfo3.seekForwardIncrementMs);
                            break;
                        case 16:
                            listener.onMaxSeekToPreviousPositionChanged(playerInfo3.maxSeekToPreviousPositionMs);
                            break;
                        case 17:
                            listener.onTrackSelectionParametersChanged(playerInfo3.trackSelectionParameters);
                            break;
                        case 18:
                            listener.onTracksChanged(playerInfo3.currentTracks);
                            break;
                        case 19:
                            listener.onMediaMetadataChanged(playerInfo3.mediaMetadata);
                            break;
                        case 20:
                            listener.onIsLoadingChanged(playerInfo3.isLoading);
                            break;
                        default:
                            listener.onPlaybackStateChanged(playerInfo3.playbackState);
                            break;
                    }
                }
            });
        }
        final byte b16 = 8;
        if (playerInfo.repeatMode != playerInfo2.repeatMode) {
            listenerSet.queueEvent(8, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda21
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b17 = b9;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b17) {
                        case 0:
                            listener.onPlaybackSuppressionReasonChanged(playerInfo3.playbackSuppressionReason);
                            break;
                        case 1:
                            listener.onIsPlayingChanged(playerInfo3.isPlaying);
                            break;
                        case 2:
                            listener.onPlaybackParametersChanged(playerInfo3.playbackParameters);
                            break;
                        case 3:
                            listener.onRepeatModeChanged(playerInfo3.repeatMode);
                            break;
                        case 4:
                            listener.onShuffleModeEnabledChanged(playerInfo3.shuffleModeEnabled);
                            break;
                        case 5:
                            listener.onPlaylistMetadataChanged(playerInfo3.playlistMetadata);
                            break;
                        case 6:
                            listener.onVolumeChanged(playerInfo3.volume);
                            break;
                        case 7:
                            listener.onAudioAttributesChanged(playerInfo3.audioAttributes);
                            break;
                        case 8:
                            listener.onAudioSessionIdChanged(playerInfo3.audioSessionId);
                            break;
                        case 9:
                            listener.onCues(playerInfo3.cueGroup.cues);
                            break;
                        case 10:
                            listener.onCues(playerInfo3.cueGroup);
                            break;
                        case 11:
                            listener.onDeviceInfoChanged(playerInfo3.deviceInfo);
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 13:
                            listener.onVideoSizeChanged(playerInfo3.videoSize);
                            break;
                        case 14:
                            listener.onSeekBackIncrementChanged(playerInfo3.seekBackIncrementMs);
                            break;
                        case 15:
                            listener.onSeekForwardIncrementChanged(playerInfo3.seekForwardIncrementMs);
                            break;
                        case 16:
                            listener.onMaxSeekToPreviousPositionChanged(playerInfo3.maxSeekToPreviousPositionMs);
                            break;
                        case 17:
                            listener.onTrackSelectionParametersChanged(playerInfo3.trackSelectionParameters);
                            break;
                        case 18:
                            listener.onTracksChanged(playerInfo3.currentTracks);
                            break;
                        case 19:
                            listener.onMediaMetadataChanged(playerInfo3.mediaMetadata);
                            break;
                        case 20:
                            listener.onIsLoadingChanged(playerInfo3.isLoading);
                            break;
                        default:
                            listener.onPlaybackStateChanged(playerInfo3.playbackState);
                            break;
                    }
                }
            });
        }
        final byte b17 = 9;
        if (playerInfo.shuffleModeEnabled != playerInfo2.shuffleModeEnabled) {
            listenerSet.queueEvent(9, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda21
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b18 = b11;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b18) {
                        case 0:
                            listener.onPlaybackSuppressionReasonChanged(playerInfo3.playbackSuppressionReason);
                            break;
                        case 1:
                            listener.onIsPlayingChanged(playerInfo3.isPlaying);
                            break;
                        case 2:
                            listener.onPlaybackParametersChanged(playerInfo3.playbackParameters);
                            break;
                        case 3:
                            listener.onRepeatModeChanged(playerInfo3.repeatMode);
                            break;
                        case 4:
                            listener.onShuffleModeEnabledChanged(playerInfo3.shuffleModeEnabled);
                            break;
                        case 5:
                            listener.onPlaylistMetadataChanged(playerInfo3.playlistMetadata);
                            break;
                        case 6:
                            listener.onVolumeChanged(playerInfo3.volume);
                            break;
                        case 7:
                            listener.onAudioAttributesChanged(playerInfo3.audioAttributes);
                            break;
                        case 8:
                            listener.onAudioSessionIdChanged(playerInfo3.audioSessionId);
                            break;
                        case 9:
                            listener.onCues(playerInfo3.cueGroup.cues);
                            break;
                        case 10:
                            listener.onCues(playerInfo3.cueGroup);
                            break;
                        case 11:
                            listener.onDeviceInfoChanged(playerInfo3.deviceInfo);
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 13:
                            listener.onVideoSizeChanged(playerInfo3.videoSize);
                            break;
                        case 14:
                            listener.onSeekBackIncrementChanged(playerInfo3.seekBackIncrementMs);
                            break;
                        case 15:
                            listener.onSeekForwardIncrementChanged(playerInfo3.seekForwardIncrementMs);
                            break;
                        case 16:
                            listener.onMaxSeekToPreviousPositionChanged(playerInfo3.maxSeekToPreviousPositionMs);
                            break;
                        case 17:
                            listener.onTrackSelectionParametersChanged(playerInfo3.trackSelectionParameters);
                            break;
                        case 18:
                            listener.onTracksChanged(playerInfo3.currentTracks);
                            break;
                        case 19:
                            listener.onMediaMetadataChanged(playerInfo3.mediaMetadata);
                            break;
                        case 20:
                            listener.onIsLoadingChanged(playerInfo3.isLoading);
                            break;
                        default:
                            listener.onPlaybackStateChanged(playerInfo3.playbackState);
                            break;
                    }
                }
            });
        }
        final byte b18 = 15;
        if (!playerInfo.playlistMetadata.equals(playerInfo2.playlistMetadata)) {
            listenerSet.queueEvent(15, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda21
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b19 = b12;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b19) {
                        case 0:
                            listener.onPlaybackSuppressionReasonChanged(playerInfo3.playbackSuppressionReason);
                            break;
                        case 1:
                            listener.onIsPlayingChanged(playerInfo3.isPlaying);
                            break;
                        case 2:
                            listener.onPlaybackParametersChanged(playerInfo3.playbackParameters);
                            break;
                        case 3:
                            listener.onRepeatModeChanged(playerInfo3.repeatMode);
                            break;
                        case 4:
                            listener.onShuffleModeEnabledChanged(playerInfo3.shuffleModeEnabled);
                            break;
                        case 5:
                            listener.onPlaylistMetadataChanged(playerInfo3.playlistMetadata);
                            break;
                        case 6:
                            listener.onVolumeChanged(playerInfo3.volume);
                            break;
                        case 7:
                            listener.onAudioAttributesChanged(playerInfo3.audioAttributes);
                            break;
                        case 8:
                            listener.onAudioSessionIdChanged(playerInfo3.audioSessionId);
                            break;
                        case 9:
                            listener.onCues(playerInfo3.cueGroup.cues);
                            break;
                        case 10:
                            listener.onCues(playerInfo3.cueGroup);
                            break;
                        case 11:
                            listener.onDeviceInfoChanged(playerInfo3.deviceInfo);
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 13:
                            listener.onVideoSizeChanged(playerInfo3.videoSize);
                            break;
                        case 14:
                            listener.onSeekBackIncrementChanged(playerInfo3.seekBackIncrementMs);
                            break;
                        case 15:
                            listener.onSeekForwardIncrementChanged(playerInfo3.seekForwardIncrementMs);
                            break;
                        case 16:
                            listener.onMaxSeekToPreviousPositionChanged(playerInfo3.maxSeekToPreviousPositionMs);
                            break;
                        case 17:
                            listener.onTrackSelectionParametersChanged(playerInfo3.trackSelectionParameters);
                            break;
                        case 18:
                            listener.onTracksChanged(playerInfo3.currentTracks);
                            break;
                        case 19:
                            listener.onMediaMetadataChanged(playerInfo3.mediaMetadata);
                            break;
                        case 20:
                            listener.onIsLoadingChanged(playerInfo3.isLoading);
                            break;
                        default:
                            listener.onPlaybackStateChanged(playerInfo3.playbackState);
                            break;
                    }
                }
            });
        }
        if (playerInfo.volume != playerInfo2.volume) {
            listenerSet.queueEvent(22, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda21
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b19 = b13;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b19) {
                        case 0:
                            listener.onPlaybackSuppressionReasonChanged(playerInfo3.playbackSuppressionReason);
                            break;
                        case 1:
                            listener.onIsPlayingChanged(playerInfo3.isPlaying);
                            break;
                        case 2:
                            listener.onPlaybackParametersChanged(playerInfo3.playbackParameters);
                            break;
                        case 3:
                            listener.onRepeatModeChanged(playerInfo3.repeatMode);
                            break;
                        case 4:
                            listener.onShuffleModeEnabledChanged(playerInfo3.shuffleModeEnabled);
                            break;
                        case 5:
                            listener.onPlaylistMetadataChanged(playerInfo3.playlistMetadata);
                            break;
                        case 6:
                            listener.onVolumeChanged(playerInfo3.volume);
                            break;
                        case 7:
                            listener.onAudioAttributesChanged(playerInfo3.audioAttributes);
                            break;
                        case 8:
                            listener.onAudioSessionIdChanged(playerInfo3.audioSessionId);
                            break;
                        case 9:
                            listener.onCues(playerInfo3.cueGroup.cues);
                            break;
                        case 10:
                            listener.onCues(playerInfo3.cueGroup);
                            break;
                        case 11:
                            listener.onDeviceInfoChanged(playerInfo3.deviceInfo);
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 13:
                            listener.onVideoSizeChanged(playerInfo3.videoSize);
                            break;
                        case 14:
                            listener.onSeekBackIncrementChanged(playerInfo3.seekBackIncrementMs);
                            break;
                        case 15:
                            listener.onSeekForwardIncrementChanged(playerInfo3.seekForwardIncrementMs);
                            break;
                        case 16:
                            listener.onMaxSeekToPreviousPositionChanged(playerInfo3.maxSeekToPreviousPositionMs);
                            break;
                        case 17:
                            listener.onTrackSelectionParametersChanged(playerInfo3.trackSelectionParameters);
                            break;
                        case 18:
                            listener.onTracksChanged(playerInfo3.currentTracks);
                            break;
                        case 19:
                            listener.onMediaMetadataChanged(playerInfo3.mediaMetadata);
                            break;
                        case 20:
                            listener.onIsLoadingChanged(playerInfo3.isLoading);
                            break;
                        default:
                            listener.onPlaybackStateChanged(playerInfo3.playbackState);
                            break;
                    }
                }
            });
        }
        if (!playerInfo.audioAttributes.equals(playerInfo2.audioAttributes)) {
            listenerSet.queueEvent(20, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda21
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b19 = b14;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b19) {
                        case 0:
                            listener.onPlaybackSuppressionReasonChanged(playerInfo3.playbackSuppressionReason);
                            break;
                        case 1:
                            listener.onIsPlayingChanged(playerInfo3.isPlaying);
                            break;
                        case 2:
                            listener.onPlaybackParametersChanged(playerInfo3.playbackParameters);
                            break;
                        case 3:
                            listener.onRepeatModeChanged(playerInfo3.repeatMode);
                            break;
                        case 4:
                            listener.onShuffleModeEnabledChanged(playerInfo3.shuffleModeEnabled);
                            break;
                        case 5:
                            listener.onPlaylistMetadataChanged(playerInfo3.playlistMetadata);
                            break;
                        case 6:
                            listener.onVolumeChanged(playerInfo3.volume);
                            break;
                        case 7:
                            listener.onAudioAttributesChanged(playerInfo3.audioAttributes);
                            break;
                        case 8:
                            listener.onAudioSessionIdChanged(playerInfo3.audioSessionId);
                            break;
                        case 9:
                            listener.onCues(playerInfo3.cueGroup.cues);
                            break;
                        case 10:
                            listener.onCues(playerInfo3.cueGroup);
                            break;
                        case 11:
                            listener.onDeviceInfoChanged(playerInfo3.deviceInfo);
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 13:
                            listener.onVideoSizeChanged(playerInfo3.videoSize);
                            break;
                        case 14:
                            listener.onSeekBackIncrementChanged(playerInfo3.seekBackIncrementMs);
                            break;
                        case 15:
                            listener.onSeekForwardIncrementChanged(playerInfo3.seekForwardIncrementMs);
                            break;
                        case 16:
                            listener.onMaxSeekToPreviousPositionChanged(playerInfo3.maxSeekToPreviousPositionMs);
                            break;
                        case 17:
                            listener.onTrackSelectionParametersChanged(playerInfo3.trackSelectionParameters);
                            break;
                        case 18:
                            listener.onTracksChanged(playerInfo3.currentTracks);
                            break;
                        case 19:
                            listener.onMediaMetadataChanged(playerInfo3.mediaMetadata);
                            break;
                        case 20:
                            listener.onIsLoadingChanged(playerInfo3.isLoading);
                            break;
                        default:
                            listener.onPlaybackStateChanged(playerInfo3.playbackState);
                            break;
                    }
                }
            });
        }
        if (playerInfo.audioSessionId != playerInfo2.audioSessionId) {
            listenerSet.queueEvent(21, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda21
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b19 = b16;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b19) {
                        case 0:
                            listener.onPlaybackSuppressionReasonChanged(playerInfo3.playbackSuppressionReason);
                            break;
                        case 1:
                            listener.onIsPlayingChanged(playerInfo3.isPlaying);
                            break;
                        case 2:
                            listener.onPlaybackParametersChanged(playerInfo3.playbackParameters);
                            break;
                        case 3:
                            listener.onRepeatModeChanged(playerInfo3.repeatMode);
                            break;
                        case 4:
                            listener.onShuffleModeEnabledChanged(playerInfo3.shuffleModeEnabled);
                            break;
                        case 5:
                            listener.onPlaylistMetadataChanged(playerInfo3.playlistMetadata);
                            break;
                        case 6:
                            listener.onVolumeChanged(playerInfo3.volume);
                            break;
                        case 7:
                            listener.onAudioAttributesChanged(playerInfo3.audioAttributes);
                            break;
                        case 8:
                            listener.onAudioSessionIdChanged(playerInfo3.audioSessionId);
                            break;
                        case 9:
                            listener.onCues(playerInfo3.cueGroup.cues);
                            break;
                        case 10:
                            listener.onCues(playerInfo3.cueGroup);
                            break;
                        case 11:
                            listener.onDeviceInfoChanged(playerInfo3.deviceInfo);
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 13:
                            listener.onVideoSizeChanged(playerInfo3.videoSize);
                            break;
                        case 14:
                            listener.onSeekBackIncrementChanged(playerInfo3.seekBackIncrementMs);
                            break;
                        case 15:
                            listener.onSeekForwardIncrementChanged(playerInfo3.seekForwardIncrementMs);
                            break;
                        case 16:
                            listener.onMaxSeekToPreviousPositionChanged(playerInfo3.maxSeekToPreviousPositionMs);
                            break;
                        case 17:
                            listener.onTrackSelectionParametersChanged(playerInfo3.trackSelectionParameters);
                            break;
                        case 18:
                            listener.onTracksChanged(playerInfo3.currentTracks);
                            break;
                        case 19:
                            listener.onMediaMetadataChanged(playerInfo3.mediaMetadata);
                            break;
                        case 20:
                            listener.onIsLoadingChanged(playerInfo3.isLoading);
                            break;
                        default:
                            listener.onPlaybackStateChanged(playerInfo3.playbackState);
                            break;
                    }
                }
            });
        }
        if (!playerInfo.cueGroup.cues.equals(playerInfo2.cueGroup.cues)) {
            listenerSet.queueEvent(27, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda21
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b19 = b17;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b19) {
                        case 0:
                            listener.onPlaybackSuppressionReasonChanged(playerInfo3.playbackSuppressionReason);
                            break;
                        case 1:
                            listener.onIsPlayingChanged(playerInfo3.isPlaying);
                            break;
                        case 2:
                            listener.onPlaybackParametersChanged(playerInfo3.playbackParameters);
                            break;
                        case 3:
                            listener.onRepeatModeChanged(playerInfo3.repeatMode);
                            break;
                        case 4:
                            listener.onShuffleModeEnabledChanged(playerInfo3.shuffleModeEnabled);
                            break;
                        case 5:
                            listener.onPlaylistMetadataChanged(playerInfo3.playlistMetadata);
                            break;
                        case 6:
                            listener.onVolumeChanged(playerInfo3.volume);
                            break;
                        case 7:
                            listener.onAudioAttributesChanged(playerInfo3.audioAttributes);
                            break;
                        case 8:
                            listener.onAudioSessionIdChanged(playerInfo3.audioSessionId);
                            break;
                        case 9:
                            listener.onCues(playerInfo3.cueGroup.cues);
                            break;
                        case 10:
                            listener.onCues(playerInfo3.cueGroup);
                            break;
                        case 11:
                            listener.onDeviceInfoChanged(playerInfo3.deviceInfo);
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 13:
                            listener.onVideoSizeChanged(playerInfo3.videoSize);
                            break;
                        case 14:
                            listener.onSeekBackIncrementChanged(playerInfo3.seekBackIncrementMs);
                            break;
                        case 15:
                            listener.onSeekForwardIncrementChanged(playerInfo3.seekForwardIncrementMs);
                            break;
                        case 16:
                            listener.onMaxSeekToPreviousPositionChanged(playerInfo3.maxSeekToPreviousPositionMs);
                            break;
                        case 17:
                            listener.onTrackSelectionParametersChanged(playerInfo3.trackSelectionParameters);
                            break;
                        case 18:
                            listener.onTracksChanged(playerInfo3.currentTracks);
                            break;
                        case 19:
                            listener.onMediaMetadataChanged(playerInfo3.mediaMetadata);
                            break;
                        case 20:
                            listener.onIsLoadingChanged(playerInfo3.isLoading);
                            break;
                        default:
                            listener.onPlaybackStateChanged(playerInfo3.playbackState);
                            break;
                    }
                }
            });
            listenerSet.queueEvent(27, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda21
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b19 = b5;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b19) {
                        case 0:
                            listener.onPlaybackSuppressionReasonChanged(playerInfo3.playbackSuppressionReason);
                            break;
                        case 1:
                            listener.onIsPlayingChanged(playerInfo3.isPlaying);
                            break;
                        case 2:
                            listener.onPlaybackParametersChanged(playerInfo3.playbackParameters);
                            break;
                        case 3:
                            listener.onRepeatModeChanged(playerInfo3.repeatMode);
                            break;
                        case 4:
                            listener.onShuffleModeEnabledChanged(playerInfo3.shuffleModeEnabled);
                            break;
                        case 5:
                            listener.onPlaylistMetadataChanged(playerInfo3.playlistMetadata);
                            break;
                        case 6:
                            listener.onVolumeChanged(playerInfo3.volume);
                            break;
                        case 7:
                            listener.onAudioAttributesChanged(playerInfo3.audioAttributes);
                            break;
                        case 8:
                            listener.onAudioSessionIdChanged(playerInfo3.audioSessionId);
                            break;
                        case 9:
                            listener.onCues(playerInfo3.cueGroup.cues);
                            break;
                        case 10:
                            listener.onCues(playerInfo3.cueGroup);
                            break;
                        case 11:
                            listener.onDeviceInfoChanged(playerInfo3.deviceInfo);
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 13:
                            listener.onVideoSizeChanged(playerInfo3.videoSize);
                            break;
                        case 14:
                            listener.onSeekBackIncrementChanged(playerInfo3.seekBackIncrementMs);
                            break;
                        case 15:
                            listener.onSeekForwardIncrementChanged(playerInfo3.seekForwardIncrementMs);
                            break;
                        case 16:
                            listener.onMaxSeekToPreviousPositionChanged(playerInfo3.maxSeekToPreviousPositionMs);
                            break;
                        case 17:
                            listener.onTrackSelectionParametersChanged(playerInfo3.trackSelectionParameters);
                            break;
                        case 18:
                            listener.onTracksChanged(playerInfo3.currentTracks);
                            break;
                        case 19:
                            listener.onMediaMetadataChanged(playerInfo3.mediaMetadata);
                            break;
                        case 20:
                            listener.onIsLoadingChanged(playerInfo3.isLoading);
                            break;
                        default:
                            listener.onPlaybackStateChanged(playerInfo3.playbackState);
                            break;
                    }
                }
            });
        }
        if (!playerInfo.deviceInfo.equals(playerInfo2.deviceInfo)) {
            listenerSet.queueEvent(29, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda21
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b19 = b3;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b19) {
                        case 0:
                            listener.onPlaybackSuppressionReasonChanged(playerInfo3.playbackSuppressionReason);
                            break;
                        case 1:
                            listener.onIsPlayingChanged(playerInfo3.isPlaying);
                            break;
                        case 2:
                            listener.onPlaybackParametersChanged(playerInfo3.playbackParameters);
                            break;
                        case 3:
                            listener.onRepeatModeChanged(playerInfo3.repeatMode);
                            break;
                        case 4:
                            listener.onShuffleModeEnabledChanged(playerInfo3.shuffleModeEnabled);
                            break;
                        case 5:
                            listener.onPlaylistMetadataChanged(playerInfo3.playlistMetadata);
                            break;
                        case 6:
                            listener.onVolumeChanged(playerInfo3.volume);
                            break;
                        case 7:
                            listener.onAudioAttributesChanged(playerInfo3.audioAttributes);
                            break;
                        case 8:
                            listener.onAudioSessionIdChanged(playerInfo3.audioSessionId);
                            break;
                        case 9:
                            listener.onCues(playerInfo3.cueGroup.cues);
                            break;
                        case 10:
                            listener.onCues(playerInfo3.cueGroup);
                            break;
                        case 11:
                            listener.onDeviceInfoChanged(playerInfo3.deviceInfo);
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 13:
                            listener.onVideoSizeChanged(playerInfo3.videoSize);
                            break;
                        case 14:
                            listener.onSeekBackIncrementChanged(playerInfo3.seekBackIncrementMs);
                            break;
                        case 15:
                            listener.onSeekForwardIncrementChanged(playerInfo3.seekForwardIncrementMs);
                            break;
                        case 16:
                            listener.onMaxSeekToPreviousPositionChanged(playerInfo3.maxSeekToPreviousPositionMs);
                            break;
                        case 17:
                            listener.onTrackSelectionParametersChanged(playerInfo3.trackSelectionParameters);
                            break;
                        case 18:
                            listener.onTracksChanged(playerInfo3.currentTracks);
                            break;
                        case 19:
                            listener.onMediaMetadataChanged(playerInfo3.mediaMetadata);
                            break;
                        case 20:
                            listener.onIsLoadingChanged(playerInfo3.isLoading);
                            break;
                        default:
                            listener.onPlaybackStateChanged(playerInfo3.playbackState);
                            break;
                    }
                }
            });
        }
        if (playerInfo.deviceVolume != playerInfo2.deviceVolume || playerInfo.deviceMuted != playerInfo2.deviceMuted) {
            listenerSet.queueEvent(30, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda21
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b19 = b15;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b19) {
                        case 0:
                            listener.onPlaybackSuppressionReasonChanged(playerInfo3.playbackSuppressionReason);
                            break;
                        case 1:
                            listener.onIsPlayingChanged(playerInfo3.isPlaying);
                            break;
                        case 2:
                            listener.onPlaybackParametersChanged(playerInfo3.playbackParameters);
                            break;
                        case 3:
                            listener.onRepeatModeChanged(playerInfo3.repeatMode);
                            break;
                        case 4:
                            listener.onShuffleModeEnabledChanged(playerInfo3.shuffleModeEnabled);
                            break;
                        case 5:
                            listener.onPlaylistMetadataChanged(playerInfo3.playlistMetadata);
                            break;
                        case 6:
                            listener.onVolumeChanged(playerInfo3.volume);
                            break;
                        case 7:
                            listener.onAudioAttributesChanged(playerInfo3.audioAttributes);
                            break;
                        case 8:
                            listener.onAudioSessionIdChanged(playerInfo3.audioSessionId);
                            break;
                        case 9:
                            listener.onCues(playerInfo3.cueGroup.cues);
                            break;
                        case 10:
                            listener.onCues(playerInfo3.cueGroup);
                            break;
                        case 11:
                            listener.onDeviceInfoChanged(playerInfo3.deviceInfo);
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 13:
                            listener.onVideoSizeChanged(playerInfo3.videoSize);
                            break;
                        case 14:
                            listener.onSeekBackIncrementChanged(playerInfo3.seekBackIncrementMs);
                            break;
                        case 15:
                            listener.onSeekForwardIncrementChanged(playerInfo3.seekForwardIncrementMs);
                            break;
                        case 16:
                            listener.onMaxSeekToPreviousPositionChanged(playerInfo3.maxSeekToPreviousPositionMs);
                            break;
                        case 17:
                            listener.onTrackSelectionParametersChanged(playerInfo3.trackSelectionParameters);
                            break;
                        case 18:
                            listener.onTracksChanged(playerInfo3.currentTracks);
                            break;
                        case 19:
                            listener.onMediaMetadataChanged(playerInfo3.mediaMetadata);
                            break;
                        case 20:
                            listener.onIsLoadingChanged(playerInfo3.isLoading);
                            break;
                        default:
                            listener.onPlaybackStateChanged(playerInfo3.playbackState);
                            break;
                    }
                }
            });
        }
        if (!playerInfo.videoSize.equals(playerInfo2.videoSize)) {
            final byte b19 = 13;
            listenerSet.queueEvent(25, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda21
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b110 = b19;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b110) {
                        case 0:
                            listener.onPlaybackSuppressionReasonChanged(playerInfo3.playbackSuppressionReason);
                            break;
                        case 1:
                            listener.onIsPlayingChanged(playerInfo3.isPlaying);
                            break;
                        case 2:
                            listener.onPlaybackParametersChanged(playerInfo3.playbackParameters);
                            break;
                        case 3:
                            listener.onRepeatModeChanged(playerInfo3.repeatMode);
                            break;
                        case 4:
                            listener.onShuffleModeEnabledChanged(playerInfo3.shuffleModeEnabled);
                            break;
                        case 5:
                            listener.onPlaylistMetadataChanged(playerInfo3.playlistMetadata);
                            break;
                        case 6:
                            listener.onVolumeChanged(playerInfo3.volume);
                            break;
                        case 7:
                            listener.onAudioAttributesChanged(playerInfo3.audioAttributes);
                            break;
                        case 8:
                            listener.onAudioSessionIdChanged(playerInfo3.audioSessionId);
                            break;
                        case 9:
                            listener.onCues(playerInfo3.cueGroup.cues);
                            break;
                        case 10:
                            listener.onCues(playerInfo3.cueGroup);
                            break;
                        case 11:
                            listener.onDeviceInfoChanged(playerInfo3.deviceInfo);
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 13:
                            listener.onVideoSizeChanged(playerInfo3.videoSize);
                            break;
                        case 14:
                            listener.onSeekBackIncrementChanged(playerInfo3.seekBackIncrementMs);
                            break;
                        case 15:
                            listener.onSeekForwardIncrementChanged(playerInfo3.seekForwardIncrementMs);
                            break;
                        case 16:
                            listener.onMaxSeekToPreviousPositionChanged(playerInfo3.maxSeekToPreviousPositionMs);
                            break;
                        case 17:
                            listener.onTrackSelectionParametersChanged(playerInfo3.trackSelectionParameters);
                            break;
                        case 18:
                            listener.onTracksChanged(playerInfo3.currentTracks);
                            break;
                        case 19:
                            listener.onMediaMetadataChanged(playerInfo3.mediaMetadata);
                            break;
                        case 20:
                            listener.onIsLoadingChanged(playerInfo3.isLoading);
                            break;
                        default:
                            listener.onPlaybackStateChanged(playerInfo3.playbackState);
                            break;
                    }
                }
            });
        }
        final byte b20 = 16;
        if (playerInfo.seekBackIncrementMs != playerInfo2.seekBackIncrementMs) {
            final byte b21 = 14;
            listenerSet.queueEvent(16, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda21
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b110 = b21;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b110) {
                        case 0:
                            listener.onPlaybackSuppressionReasonChanged(playerInfo3.playbackSuppressionReason);
                            break;
                        case 1:
                            listener.onIsPlayingChanged(playerInfo3.isPlaying);
                            break;
                        case 2:
                            listener.onPlaybackParametersChanged(playerInfo3.playbackParameters);
                            break;
                        case 3:
                            listener.onRepeatModeChanged(playerInfo3.repeatMode);
                            break;
                        case 4:
                            listener.onShuffleModeEnabledChanged(playerInfo3.shuffleModeEnabled);
                            break;
                        case 5:
                            listener.onPlaylistMetadataChanged(playerInfo3.playlistMetadata);
                            break;
                        case 6:
                            listener.onVolumeChanged(playerInfo3.volume);
                            break;
                        case 7:
                            listener.onAudioAttributesChanged(playerInfo3.audioAttributes);
                            break;
                        case 8:
                            listener.onAudioSessionIdChanged(playerInfo3.audioSessionId);
                            break;
                        case 9:
                            listener.onCues(playerInfo3.cueGroup.cues);
                            break;
                        case 10:
                            listener.onCues(playerInfo3.cueGroup);
                            break;
                        case 11:
                            listener.onDeviceInfoChanged(playerInfo3.deviceInfo);
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 13:
                            listener.onVideoSizeChanged(playerInfo3.videoSize);
                            break;
                        case 14:
                            listener.onSeekBackIncrementChanged(playerInfo3.seekBackIncrementMs);
                            break;
                        case 15:
                            listener.onSeekForwardIncrementChanged(playerInfo3.seekForwardIncrementMs);
                            break;
                        case 16:
                            listener.onMaxSeekToPreviousPositionChanged(playerInfo3.maxSeekToPreviousPositionMs);
                            break;
                        case 17:
                            listener.onTrackSelectionParametersChanged(playerInfo3.trackSelectionParameters);
                            break;
                        case 18:
                            listener.onTracksChanged(playerInfo3.currentTracks);
                            break;
                        case 19:
                            listener.onMediaMetadataChanged(playerInfo3.mediaMetadata);
                            break;
                        case 20:
                            listener.onIsLoadingChanged(playerInfo3.isLoading);
                            break;
                        default:
                            listener.onPlaybackStateChanged(playerInfo3.playbackState);
                            break;
                    }
                }
            });
        }
        final byte b22 = 17;
        if (playerInfo.seekForwardIncrementMs != playerInfo2.seekForwardIncrementMs) {
            listenerSet.queueEvent(17, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda21
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b110 = b18;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b110) {
                        case 0:
                            listener.onPlaybackSuppressionReasonChanged(playerInfo3.playbackSuppressionReason);
                            break;
                        case 1:
                            listener.onIsPlayingChanged(playerInfo3.isPlaying);
                            break;
                        case 2:
                            listener.onPlaybackParametersChanged(playerInfo3.playbackParameters);
                            break;
                        case 3:
                            listener.onRepeatModeChanged(playerInfo3.repeatMode);
                            break;
                        case 4:
                            listener.onShuffleModeEnabledChanged(playerInfo3.shuffleModeEnabled);
                            break;
                        case 5:
                            listener.onPlaylistMetadataChanged(playerInfo3.playlistMetadata);
                            break;
                        case 6:
                            listener.onVolumeChanged(playerInfo3.volume);
                            break;
                        case 7:
                            listener.onAudioAttributesChanged(playerInfo3.audioAttributes);
                            break;
                        case 8:
                            listener.onAudioSessionIdChanged(playerInfo3.audioSessionId);
                            break;
                        case 9:
                            listener.onCues(playerInfo3.cueGroup.cues);
                            break;
                        case 10:
                            listener.onCues(playerInfo3.cueGroup);
                            break;
                        case 11:
                            listener.onDeviceInfoChanged(playerInfo3.deviceInfo);
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 13:
                            listener.onVideoSizeChanged(playerInfo3.videoSize);
                            break;
                        case 14:
                            listener.onSeekBackIncrementChanged(playerInfo3.seekBackIncrementMs);
                            break;
                        case 15:
                            listener.onSeekForwardIncrementChanged(playerInfo3.seekForwardIncrementMs);
                            break;
                        case 16:
                            listener.onMaxSeekToPreviousPositionChanged(playerInfo3.maxSeekToPreviousPositionMs);
                            break;
                        case 17:
                            listener.onTrackSelectionParametersChanged(playerInfo3.trackSelectionParameters);
                            break;
                        case 18:
                            listener.onTracksChanged(playerInfo3.currentTracks);
                            break;
                        case 19:
                            listener.onMediaMetadataChanged(playerInfo3.mediaMetadata);
                            break;
                        case 20:
                            listener.onIsLoadingChanged(playerInfo3.isLoading);
                            break;
                        default:
                            listener.onPlaybackStateChanged(playerInfo3.playbackState);
                            break;
                    }
                }
            });
        }
        if (playerInfo.maxSeekToPreviousPositionMs != playerInfo2.maxSeekToPreviousPositionMs) {
            listenerSet.queueEvent(18, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda21
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b110 = b20;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b110) {
                        case 0:
                            listener.onPlaybackSuppressionReasonChanged(playerInfo3.playbackSuppressionReason);
                            break;
                        case 1:
                            listener.onIsPlayingChanged(playerInfo3.isPlaying);
                            break;
                        case 2:
                            listener.onPlaybackParametersChanged(playerInfo3.playbackParameters);
                            break;
                        case 3:
                            listener.onRepeatModeChanged(playerInfo3.repeatMode);
                            break;
                        case 4:
                            listener.onShuffleModeEnabledChanged(playerInfo3.shuffleModeEnabled);
                            break;
                        case 5:
                            listener.onPlaylistMetadataChanged(playerInfo3.playlistMetadata);
                            break;
                        case 6:
                            listener.onVolumeChanged(playerInfo3.volume);
                            break;
                        case 7:
                            listener.onAudioAttributesChanged(playerInfo3.audioAttributes);
                            break;
                        case 8:
                            listener.onAudioSessionIdChanged(playerInfo3.audioSessionId);
                            break;
                        case 9:
                            listener.onCues(playerInfo3.cueGroup.cues);
                            break;
                        case 10:
                            listener.onCues(playerInfo3.cueGroup);
                            break;
                        case 11:
                            listener.onDeviceInfoChanged(playerInfo3.deviceInfo);
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 13:
                            listener.onVideoSizeChanged(playerInfo3.videoSize);
                            break;
                        case 14:
                            listener.onSeekBackIncrementChanged(playerInfo3.seekBackIncrementMs);
                            break;
                        case 15:
                            listener.onSeekForwardIncrementChanged(playerInfo3.seekForwardIncrementMs);
                            break;
                        case 16:
                            listener.onMaxSeekToPreviousPositionChanged(playerInfo3.maxSeekToPreviousPositionMs);
                            break;
                        case 17:
                            listener.onTrackSelectionParametersChanged(playerInfo3.trackSelectionParameters);
                            break;
                        case 18:
                            listener.onTracksChanged(playerInfo3.currentTracks);
                            break;
                        case 19:
                            listener.onMediaMetadataChanged(playerInfo3.mediaMetadata);
                            break;
                        case 20:
                            listener.onIsLoadingChanged(playerInfo3.isLoading);
                            break;
                        default:
                            listener.onPlaybackStateChanged(playerInfo3.playbackState);
                            break;
                    }
                }
            });
        }
        if (!playerInfo.trackSelectionParameters.equals(playerInfo2.trackSelectionParameters)) {
            listenerSet.queueEvent(19, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda21
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    byte b110 = b22;
                    PlayerInfo playerInfo3 = playerInfo2;
                    Player.Listener listener = (Player.Listener) obj;
                    switch (b110) {
                        case 0:
                            listener.onPlaybackSuppressionReasonChanged(playerInfo3.playbackSuppressionReason);
                            break;
                        case 1:
                            listener.onIsPlayingChanged(playerInfo3.isPlaying);
                            break;
                        case 2:
                            listener.onPlaybackParametersChanged(playerInfo3.playbackParameters);
                            break;
                        case 3:
                            listener.onRepeatModeChanged(playerInfo3.repeatMode);
                            break;
                        case 4:
                            listener.onShuffleModeEnabledChanged(playerInfo3.shuffleModeEnabled);
                            break;
                        case 5:
                            listener.onPlaylistMetadataChanged(playerInfo3.playlistMetadata);
                            break;
                        case 6:
                            listener.onVolumeChanged(playerInfo3.volume);
                            break;
                        case 7:
                            listener.onAudioAttributesChanged(playerInfo3.audioAttributes);
                            break;
                        case 8:
                            listener.onAudioSessionIdChanged(playerInfo3.audioSessionId);
                            break;
                        case 9:
                            listener.onCues(playerInfo3.cueGroup.cues);
                            break;
                        case 10:
                            listener.onCues(playerInfo3.cueGroup);
                            break;
                        case 11:
                            listener.onDeviceInfoChanged(playerInfo3.deviceInfo);
                            break;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            listener.onDeviceVolumeChanged(playerInfo3.deviceVolume, playerInfo3.deviceMuted);
                            break;
                        case 13:
                            listener.onVideoSizeChanged(playerInfo3.videoSize);
                            break;
                        case 14:
                            listener.onSeekBackIncrementChanged(playerInfo3.seekBackIncrementMs);
                            break;
                        case 15:
                            listener.onSeekForwardIncrementChanged(playerInfo3.seekForwardIncrementMs);
                            break;
                        case 16:
                            listener.onMaxSeekToPreviousPositionChanged(playerInfo3.maxSeekToPreviousPositionMs);
                            break;
                        case 17:
                            listener.onTrackSelectionParametersChanged(playerInfo3.trackSelectionParameters);
                            break;
                        case 18:
                            listener.onTracksChanged(playerInfo3.currentTracks);
                            break;
                        case 19:
                            listener.onMediaMetadataChanged(playerInfo3.mediaMetadata);
                            break;
                        case 20:
                            listener.onIsLoadingChanged(playerInfo3.isLoading);
                            break;
                        default:
                            listener.onPlaybackStateChanged(playerInfo3.playbackState);
                            break;
                    }
                }
            });
        }
        listenerSet.flushEvents();
    }

    public final void onPlayerInfoChanged(PlayerInfo playerInfo, PlayerInfo.BundlingExclusions bundlingExclusions) {
        PlayerInfo playerInfo2;
        PlayerInfo.BundlingExclusions bundlingExclusions2;
        if (isConnected()) {
            boolean z = getSessionInterfaceVersion() < 6;
            PlayerInfo playerInfo3 = this.pendingPlayerInfo;
            if (playerInfo3 != null) {
                Player.Commands commands = this.intersectedPlayerCommands;
                SessionToken sessionToken = this.connectedToken;
                sessionToken.getClass();
                this.pendingPlayerInfo = MediaUtils.mergePlayerInfo(playerInfo3, playerInfo, bundlingExclusions, commands, z, sessionToken);
                if (!this.pendingMaskingSequencedFutureNumbers.isEmpty()) {
                    return;
                }
                PlayerInfo playerInfo4 = this.pendingPlayerInfo;
                PlayerInfo.BundlingExclusions bundlingExclusions3 = PlayerInfo.BundlingExclusions.NONE;
                this.pendingPlayerInfo = null;
                playerInfo2 = playerInfo4;
                bundlingExclusions2 = bundlingExclusions3;
            } else {
                playerInfo2 = playerInfo;
                bundlingExclusions2 = bundlingExclusions;
            }
            PlayerInfo playerInfo5 = this.playerInfo;
            Player.Commands commands2 = this.intersectedPlayerCommands;
            SessionToken sessionToken2 = this.connectedToken;
            sessionToken2.getClass();
            PlayerInfo playerInfoMergePlayerInfo = MediaUtils.mergePlayerInfo(playerInfo5, playerInfo2, bundlingExclusions2, commands2, z, sessionToken2);
            this.playerInfo = playerInfoMergePlayerInfo;
            Player.PositionInfo positionInfo = playerInfo5.oldPositionInfo;
            Player.PositionInfo positionInfo2 = playerInfo5.newPositionInfo;
            Integer numValueOf = (positionInfo.equals(playerInfo2.oldPositionInfo) && positionInfo2.equals(playerInfo2.newPositionInfo)) ? null : Integer.valueOf(playerInfoMergePlayerInfo.discontinuityReason);
            MediaItem currentMediaItem = playerInfo5.getCurrentMediaItem();
            MediaItem currentMediaItem2 = playerInfoMergePlayerInfo.getCurrentMediaItem();
            Player.PositionInfo positionInfo3 = playerInfoMergePlayerInfo.newPositionInfo;
            boolean zEquals = Objects.equals(currentMediaItem, currentMediaItem2);
            Integer numValueOf2 = !zEquals ? Integer.valueOf(playerInfoMergePlayerInfo.mediaItemTransitionReason) : null;
            if (zEquals && numValueOf != null && (numValueOf.intValue() == 0 || numValueOf.intValue() == 1)) {
                if (positionInfo2.mediaItemIndex != positionInfo3.mediaItemIndex) {
                    numValueOf2 = Integer.valueOf(numValueOf.intValue() != 0 ? 2 : 1);
                } else if (playerInfo5.repeatMode != 0 && numValueOf.intValue() == 0 && playerInfo5.oldPositionInfo.adGroupIndex == -1 && positionInfo3.adGroupIndex == -1) {
                    numValueOf2 = 0;
                }
            }
            Integer numValueOf3 = !playerInfo5.timeline.equals(playerInfoMergePlayerInfo.timeline) ? Integer.valueOf(playerInfoMergePlayerInfo.timelineChangeReason) : null;
            int i = playerInfo5.playWhenReadyChangeReason;
            int i2 = playerInfoMergePlayerInfo.playWhenReadyChangeReason;
            notifyPlayerInfoListenersWithReasons(playerInfo5, playerInfoMergePlayerInfo, numValueOf3, (i == i2 && playerInfo5.playWhenReady == playerInfoMergePlayerInfo.playWhenReady) ? null : Integer.valueOf(i2), numValueOf, numValueOf2);
        }
    }

    public final void onSurfaceSizeChanged(int i, int i2) {
        Size size = this.surfaceSize;
        if (size.width == i && size.height == i2) {
            return;
        }
        this.surfaceSize = new Size(i, i2);
        this.listeners.sendEvent(24, new ExoPlayerImpl$$ExternalSyntheticLambda24(i, i2, (byte) 1));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void pause() {
        if (isPlayerCommandAvailable(1)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda3(this, (byte) 8));
            setPlayWhenReady$1(false);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void play() {
        if (!isPlayerCommandAvailable(1)) {
            Log.w("MCImplBase", "Calling play() omitted due to COMMAND_PLAY_PAUSE not being available. If this play command has started the service for instance for playback resumption, this may prevent the service from being started into the foreground.");
        } else {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda3(this, (byte) 16));
            setPlayWhenReady$1(true);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void prepare() {
        if (isPlayerCommandAvailable(2)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda3(this, (byte) 11));
            PlayerInfo playerInfo = this.playerInfo;
            if (playerInfo.playbackState == 1) {
                updatePlayerInfo(playerInfo.copyWithPlaybackState(playerInfo.timeline.isEmpty() ? 4 : 2, null), null, null, null, null);
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void release() {
        IMediaSession iMediaSession = this.iSession;
        if (this.released) {
            return;
        }
        this.released = true;
        this.connectedToken = null;
        this.fallbackPlaybackInfoUpdateHandler.removeCallbacksAndMessages(null);
        clearSurfacesAndCallbacks();
        Splitter splitter = this.flushCommandQueueHandler;
        Handler handler = (Handler) splitter.trimmer;
        if (handler.hasMessages(1)) {
            splitter.flushCommandQueue();
        }
        handler.removeCallbacksAndMessages(null);
        this.iSession = null;
        byte b = 0;
        if (iMediaSession != null && iMediaSession.asBinder().isBinderAlive()) {
            int iObtainNextSequenceNumber = this.sequencedFutureManager.obtainNextSequenceNumber();
            try {
                iMediaSession.asBinder().unlinkToDeath(this.deathRecipient, 0);
                iMediaSession.release(this.controllerStub, iObtainNextSequenceNumber);
            } catch (RemoteException unused) {
            }
        }
        this.listeners.release();
        NodeChain.Differ differ = this.sequencedFutureManager;
        MediaControllerImplBase$$ExternalSyntheticLambda52 mediaControllerImplBase$$ExternalSyntheticLambda52 = new MediaControllerImplBase$$ExternalSyntheticLambda52(this, b);
        synchronized (differ.node) {
            try {
                Handler handlerCreateHandlerForCurrentLooper = Util.createHandlerForCurrentLooper(null);
                differ.this$0 = handlerCreateHandlerForCurrentLooper;
                differ.after = mediaControllerImplBase$$ExternalSyntheticLambda52;
                if (((ArrayMap) differ.before).isEmpty()) {
                    differ.release();
                } else {
                    handlerCreateHandlerForCurrentLooper.postDelayed(new MediaSessionService$$ExternalSyntheticLambda3((byte) 3, differ), 30000L);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void removeListener(Player.Listener listener) {
        this.listeners.remove(listener);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void removeMediaItem(int i) {
        if (isPlayerCommandAvailable(20)) {
            UtilsKt.checkArgument(i >= 0);
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda10(this, i, (byte) 11));
            removeMediaItemsInternal(i, i + 1);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void removeMediaItems(int i, int i2) {
        if (isPlayerCommandAvailable(20)) {
            UtilsKt.checkArgument(i >= 0 && i2 >= i);
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda48(this, i, i2, (byte) 2));
            removeMediaItemsInternal(i, i2);
        }
    }

    public final void removeMediaItemsInternal(int i, int i2) {
        int windowCount = this.playerInfo.timeline.getWindowCount();
        int iMin = Math.min(i2, windowCount);
        if (i >= windowCount || i == iMin || windowCount == 0) {
            return;
        }
        boolean z = getCurrentMediaItemIndexInternal(this.playerInfo) >= i && getCurrentMediaItemIndexInternal(this.playerInfo) < iMin;
        PlayerInfo playerInfoMaskPlayerInfoForRemovedItems = maskPlayerInfoForRemovedItems(this.playerInfo, i, iMin, false, getCurrentPosition(), getContentPosition());
        int i3 = this.playerInfo.sessionPositionInfo.positionInfo.mediaItemIndex;
        updatePlayerInfo(playerInfoMaskPlayerInfoForRemovedItems, 0, null, z ? 4 : null, i3 >= i && i3 < iMin ? 3 : null);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void replaceMediaItem(int i, MediaItem mediaItem) {
        if (isPlayerCommandAvailable(20)) {
            UtilsKt.checkArgument(i >= 0);
            dispatchRemoteSessionTaskWithPlayerCommand(new ExoPlayerImpl$$ExternalSyntheticLambda5((Object) this, i, (Object) mediaItem, (byte) 2));
            replaceMediaItemsInternal(i, i + 1, ImmutableList.of((Object) mediaItem));
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void replaceMediaItems(int i, int i2, List list) {
        if (isPlayerCommandAvailable(20)) {
            UtilsKt.checkArgument(i >= 0 && i <= i2);
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaSessionStub$$ExternalSyntheticLambda11(this, list, i, i2, (byte) 1));
            replaceMediaItemsInternal(i, i2, list);
        }
    }

    public final void replaceMediaItemsInternal(int i, int i2, List list) {
        int windowCount = this.playerInfo.timeline.getWindowCount();
        if (i > windowCount) {
            return;
        }
        if (this.playerInfo.timeline.isEmpty()) {
            setMediaItemsInternal(list, -1, -9223372036854775807L, false);
            return;
        }
        int iMin = Math.min(i2, windowCount);
        PlayerInfo playerInfoMaskPlayerInfoForRemovedItems = maskPlayerInfoForRemovedItems(maskPlayerInfoForAddedItems(this.playerInfo, iMin, list, getCurrentPosition(), getContentPosition()), i, iMin, true, getCurrentPosition(), getContentPosition());
        int i3 = this.playerInfo.sessionPositionInfo.positionInfo.mediaItemIndex;
        boolean z = i3 >= i && i3 < iMin;
        updatePlayerInfo(playerInfoMaskPlayerInfoForRemovedItems, 0, null, z ? 4 : null, z ? 3 : null);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void seekBack() {
        if (isPlayerCommandAvailable(11)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda3(this, (byte) 7));
            seekToInternalByOffset(-this.playerInfo.seekBackIncrementMs);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void seekForward() {
        if (isPlayerCommandAvailable(12)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda3(this, (byte) 3));
            seekToInternalByOffset(this.playerInfo.seekForwardIncrementMs);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void seekTo(int i, long j) {
        if (isPlayerCommandAvailable(10)) {
            UtilsKt.checkArgument(i >= 0);
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaSessionStub$$ExternalSyntheticLambda20(i, j, this));
            seekToInternal(i, j);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void seekToDefaultPosition(int i) {
        if (isPlayerCommandAvailable(10)) {
            UtilsKt.checkArgument(i >= 0);
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda10(this, i, (byte) 10));
            seekToInternal(i, -9223372036854775807L);
        }
    }

    public final void seekToInternal(int i, long j) {
        int i2;
        int i3;
        PlayerInfo playerInfoMaskTimelineAndPositionInfo;
        Timeline timeline = this.playerInfo.timeline;
        if ((timeline.isEmpty() || i < timeline.getWindowCount()) && !isPlayingAd()) {
            PlayerInfo playerInfo = this.playerInfo;
            PlayerInfo playerInfoCopyWithPlaybackState = playerInfo.copyWithPlaybackState(playerInfo.playbackState == 1 ? 1 : 2, playerInfo.playerError);
            InstantParseResult.Success periodInfo = getPeriodInfo(timeline, i, j);
            if (periodInfo == null) {
                long j2 = 0;
                long j3 = j != -9223372036854775807L ? j : 0L;
                if (j != -9223372036854775807L) {
                    j2 = j;
                }
                i2 = 1;
                i3 = 2;
                Player.PositionInfo positionInfo = new Player.PositionInfo(null, i, null, null, i, j3, j2, -1, -1);
                PlayerInfo playerInfo2 = this.playerInfo;
                Timeline timeline2 = playerInfo2.timeline;
                boolean z = this.playerInfo.sessionPositionInfo.isPlayingAd;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                SessionPositionInfo sessionPositionInfo = this.playerInfo.sessionPositionInfo;
                playerInfoMaskTimelineAndPositionInfo = maskTimelineAndPositionInfo(playerInfo2, timeline2, positionInfo, new SessionPositionInfo(positionInfo, z, jElapsedRealtime, sessionPositionInfo.durationMs, j == -9223372036854775807L ? 0L : j, 0, 0L, sessionPositionInfo.currentLiveOffsetMs, sessionPositionInfo.contentDurationMs, j == -9223372036854775807L ? 0L : j), 1);
            } else {
                i2 = 1;
                i3 = 2;
                SessionPositionInfo sessionPositionInfo2 = playerInfoCopyWithPlaybackState.sessionPositionInfo;
                Player.PositionInfo positionInfo2 = sessionPositionInfo2.positionInfo;
                Player.PositionInfo positionInfo3 = sessionPositionInfo2.positionInfo;
                int i4 = positionInfo2.periodIndex;
                int i5 = periodInfo.nanosecondsOfSecond;
                Timeline.Period period = new Timeline.Period();
                timeline.getPeriod(i4, period, false);
                Timeline.Period period2 = new Timeline.Period();
                timeline.getPeriod(i5, period2, false);
                boolean z2 = i4 != i5;
                long j4 = periodInfo.epochSeconds;
                long jMsToUs = Util.msToUs(getCurrentPosition()) - period.positionInWindowUs;
                if (z2 || j4 != jMsToUs) {
                    UtilsKt.checkState(positionInfo3.adGroupIndex == -1);
                    Player.PositionInfo positionInfo4 = new Player.PositionInfo(null, period.windowIndex, positionInfo3.mediaItem, null, i4, Util.usToMs(period.positionInWindowUs + jMsToUs), Util.usToMs(period.positionInWindowUs + jMsToUs), -1, -1);
                    timeline.getPeriod(i5, period2, false);
                    Timeline.Window window = new Timeline.Window();
                    timeline.getWindow(period2.windowIndex, window);
                    long jUsToMs = Util.usToMs(period2.positionInWindowUs + j4);
                    Player.PositionInfo positionInfo5 = new Player.PositionInfo(null, period2.windowIndex, window.mediaItem, null, i5, jUsToMs, jUsToMs, -1, -1);
                    PlayerInfo playerInfoCopyWithPositionInfos = playerInfoCopyWithPlaybackState.copyWithPositionInfos(1, positionInfo4, positionInfo5);
                    if (z2 || j4 < jMsToUs) {
                        playerInfoCopyWithPlaybackState = playerInfoCopyWithPositionInfos.copyWithSessionPositionInfo(new SessionPositionInfo(positionInfo5, false, SystemClock.elapsedRealtime(), Util.usToMs(window.durationUs), jUsToMs, MediaUtils.calculateBufferedPercentage(jUsToMs, Util.usToMs(window.durationUs)), 0L, -9223372036854775807L, -9223372036854775807L, jUsToMs));
                    } else {
                        long jMax = Math.max(0L, Util.msToUs(playerInfoCopyWithPositionInfos.sessionPositionInfo.totalBufferedDurationMs) - (j4 - jMsToUs));
                        long jUsToMs2 = Util.usToMs(period2.positionInWindowUs + j4 + jMax);
                        playerInfoCopyWithPlaybackState = playerInfoCopyWithPositionInfos.copyWithSessionPositionInfo(new SessionPositionInfo(positionInfo5, false, SystemClock.elapsedRealtime(), Util.usToMs(window.durationUs), jUsToMs2, MediaUtils.calculateBufferedPercentage(jUsToMs2, Util.usToMs(window.durationUs)), Util.usToMs(jMax), -9223372036854775807L, -9223372036854775807L, jUsToMs2));
                    }
                }
                playerInfoMaskTimelineAndPositionInfo = playerInfoCopyWithPlaybackState;
            }
            SessionPositionInfo sessionPositionInfo3 = playerInfoMaskTimelineAndPositionInfo.sessionPositionInfo;
            int i6 = (this.playerInfo.timeline.isEmpty() || sessionPositionInfo3.positionInfo.mediaItemIndex == this.playerInfo.sessionPositionInfo.positionInfo.mediaItemIndex) ? 0 : i2;
            if (i6 == 0 && sessionPositionInfo3.positionInfo.positionMs == this.playerInfo.sessionPositionInfo.positionInfo.positionMs) {
                return;
            }
            updatePlayerInfo(playerInfoMaskTimelineAndPositionInfo, null, null, Integer.valueOf(i2), i6 != 0 ? Integer.valueOf(i3) : null);
        }
    }

    public final void seekToInternalByOffset(long j) {
        long currentPosition = getCurrentPosition() + j;
        long duration = getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        seekToInternal(getCurrentMediaItemIndexInternal(this.playerInfo), Math.max(currentPosition, 0L));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void seekToNext() {
        if (isPlayerCommandAvailable(9)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda3(this, (byte) 17));
            Timeline timeline = this.playerInfo.timeline;
            if (timeline.isEmpty() || isPlayingAd()) {
                return;
            }
            if (getNextMediaItemIndex() != -1) {
                seekToInternal(getNextMediaItemIndex(), -9223372036854775807L);
                return;
            }
            Timeline.Window window = timeline.getWindow(getCurrentMediaItemIndexInternal(this.playerInfo), new Timeline.Window(), 0L);
            if (window.isDynamic && window.isLive()) {
                seekToInternal(getCurrentMediaItemIndexInternal(this.playerInfo), -9223372036854775807L);
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void seekToNextMediaItem() {
        if (isPlayerCommandAvailable(8)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda3(this, (byte) 13));
            if (getNextMediaItemIndex() != -1) {
                seekToInternal(getNextMediaItemIndex(), -9223372036854775807L);
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void seekToPrevious() {
        if (isPlayerCommandAvailable(7)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda3(this, (byte) 5));
            Timeline timeline = this.playerInfo.timeline;
            if (timeline.isEmpty() || isPlayingAd()) {
                return;
            }
            boolean z = getPreviousMediaItemIndex() != -1;
            Timeline.Window window = timeline.getWindow(getCurrentMediaItemIndexInternal(this.playerInfo), new Timeline.Window(), 0L);
            if (window.isDynamic && window.isLive()) {
                if (z) {
                    seekToInternal(getPreviousMediaItemIndex(), -9223372036854775807L);
                }
            } else if (!z || getCurrentPosition() > this.playerInfo.maxSeekToPreviousPositionMs) {
                seekToInternal(getCurrentMediaItemIndexInternal(this.playerInfo), 0L);
            } else {
                seekToInternal(getPreviousMediaItemIndex(), -9223372036854775807L);
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void seekToPreviousMediaItem() {
        if (isPlayerCommandAvailable(6)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda3(this, (byte) 15));
            if (getPreviousMediaItemIndex() != -1) {
                seekToInternal(getPreviousMediaItemIndex(), -9223372036854775807L);
            }
        }
    }

    public final void sendControllerResultWhenReady(int i, ListenableFuture listenableFuture) {
        listenableFuture.addListener(new ListenerSet$$ExternalSyntheticLambda1(this, listenableFuture, i), DirectExecutor.INSTANCE);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final ListenableFuture sendCustomCommand(final SessionCommand sessionCommand, final Bundle bundle) {
        if (getSessionInterfaceVersion() < 7) {
            final byte b = 0;
            return dispatchRemoteSessionTaskWithSessionCommand(sessionCommand, new RemoteSessionTask(this) { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda18
                public final /* synthetic */ MediaControllerImplBase f$0;

                {
                    this.f$0 = this;
                }

                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i) {
                    byte b2 = b;
                    SessionCommand sessionCommand2 = sessionCommand;
                    MediaControllerImplBase mediaControllerImplBase = this.f$0;
                    switch (b2) {
                        case 0:
                            iMediaSession.onCustomCommand(mediaControllerImplBase.controllerStub, i, sessionCommand2.toBundle(), bundle);
                            break;
                        default:
                            iMediaSession.onCustomCommandWithProgressUpdate(mediaControllerImplBase.controllerStub, i, sessionCommand2.toBundle(), bundle, false);
                            break;
                    }
                }
            });
        }
        if (getSessionInterfaceVersion() < 7) {
            return sendCustomCommand(sessionCommand, bundle);
        }
        final byte b2 = 1;
        return dispatchRemoteSessionTaskWithSessionCommand(sessionCommand, new RemoteSessionTask(this) { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda18
            public final /* synthetic */ MediaControllerImplBase f$0;

            {
                this.f$0 = this;
            }

            @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
            public final void run(IMediaSession iMediaSession, int i) {
                byte b3 = b2;
                SessionCommand sessionCommand2 = sessionCommand;
                MediaControllerImplBase mediaControllerImplBase = this.f$0;
                switch (b3) {
                    case 0:
                        iMediaSession.onCustomCommand(mediaControllerImplBase.controllerStub, i, sessionCommand2.toBundle(), bundle);
                        break;
                    default:
                        iMediaSession.onCustomCommandWithProgressUpdate(mediaControllerImplBase.controllerStub, i, sessionCommand2.toBundle(), bundle, false);
                        break;
                }
            }
        });
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setAudioAttributes(AudioAttributes audioAttributes, boolean z) {
        if (isPlayerCommandAvailable(35)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaNotificationManager$$ExternalSyntheticLambda2(this, audioAttributes, z));
            if (this.playerInfo.audioAttributes.equals(audioAttributes)) {
                return;
            }
            this.playerInfo = this.playerInfo.copyWithAudioAttributes(audioAttributes);
            ExoPlayerImpl$$ExternalSyntheticLambda27 exoPlayerImpl$$ExternalSyntheticLambda27 = new ExoPlayerImpl$$ExternalSyntheticLambda27(audioAttributes, (byte) 1);
            ListenerSet listenerSet = this.listeners;
            listenerSet.queueEvent(20, exoPlayerImpl$$ExternalSyntheticLambda27);
            listenerSet.flushEvents();
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setDeviceMuted(boolean z) {
        if (isPlayerCommandAvailable(26)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda5(this, z, (byte) 3));
            PlayerInfo playerInfo = this.playerInfo;
            if (playerInfo.deviceMuted != z) {
                this.playerInfo = playerInfo.copyWithDeviceVolume(playerInfo.deviceVolume, z);
                MediaControllerImplBase$$ExternalSyntheticLambda5 mediaControllerImplBase$$ExternalSyntheticLambda5 = new MediaControllerImplBase$$ExternalSyntheticLambda5(this, z, (byte) 4);
                ListenerSet listenerSet = this.listeners;
                listenerSet.queueEvent(30, mediaControllerImplBase$$ExternalSyntheticLambda5);
                listenerSet.flushEvents();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setDeviceVolume(int i) {
        if (isPlayerCommandAvailable(25)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda10(this, i, (byte) 7));
            PlayerInfo playerInfo = this.playerInfo;
            DeviceInfo deviceInfo = playerInfo.deviceInfo;
            if (playerInfo.deviceVolume == i || deviceInfo.minVolume > i) {
                return;
            }
            int i2 = deviceInfo.maxVolume;
            if (i2 == 0 || i <= i2) {
                this.playerInfo = playerInfo.copyWithDeviceVolume(i, playerInfo.deviceMuted);
                MediaControllerImplBase$$ExternalSyntheticLambda10 mediaControllerImplBase$$ExternalSyntheticLambda10 = new MediaControllerImplBase$$ExternalSyntheticLambda10(this, i, (byte) 8);
                ListenerSet listenerSet = this.listeners;
                listenerSet.queueEvent(30, mediaControllerImplBase$$ExternalSyntheticLambda10);
                listenerSet.flushEvents();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setMediaItem(MediaItem mediaItem) {
        if (isPlayerCommandAvailable(31)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda98(this, mediaItem, (byte) 0));
            setMediaItemsInternal(Collections.singletonList(mediaItem), -1, -9223372036854775807L, true);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setMediaItem$1(MediaItem mediaItem) {
        if (isPlayerCommandAvailable(31)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda98(this, mediaItem, (byte) 1));
            setMediaItemsInternal(Collections.singletonList(mediaItem), -1, -9223372036854775807L, true);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setMediaItems(List list) {
        if (isPlayerCommandAvailable(20)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda99(this, list, (byte) 0));
            setMediaItemsInternal(list, -1, -9223372036854775807L, true);
        }
    }

    public final void setMediaItemsInternal(List list, int i, long j, boolean z) {
        int firstWindowIndex;
        boolean z2;
        long j2;
        Player.PositionInfo positionInfo;
        SessionPositionInfo sessionPositionInfo;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        while (i2 < list.size()) {
            MediaItem mediaItem = (MediaItem) list.get(i2);
            ImmutableSet immutableSet = LegacyConversions.KNOWN_METADATA_COMPAT_KEYS;
            Timeline.Window window = new Timeline.Window();
            int i3 = i2;
            window.set(0, mediaItem, 0L, 0L, 0L, true, false, null, 0L, -9223372036854775807L, i3, i3, 0L);
            arrayList.add(window);
            Timeline.Period period = new Timeline.Period();
            period.set(null, null, i3, -9223372036854775807L, 0L, AdPlaybackState.NONE, true);
            arrayList2.add(period);
            i2 = i3 + 1;
        }
        Timeline.RemotableTimeline remotableTimelineCreateMaskingTimeline = createMaskingTimeline(arrayList, arrayList2);
        ImmutableList immutableList = remotableTimelineCreateMaskingTimeline.windows;
        if (!remotableTimelineCreateMaskingTimeline.isEmpty() && i >= immutableList.size()) {
            throw new IllegalSeekPositionException();
        }
        if (z) {
            firstWindowIndex = remotableTimelineCreateMaskingTimeline.isEmpty() ? 0 : remotableTimelineCreateMaskingTimeline.getFirstWindowIndex(this.playerInfo.shuffleModeEnabled);
            z2 = false;
            j2 = -9223372036854775807L;
        } else if (i == -1) {
            Player.PositionInfo positionInfo2 = this.playerInfo.sessionPositionInfo.positionInfo;
            int i4 = positionInfo2.mediaItemIndex;
            long j3 = positionInfo2.positionMs;
            if (remotableTimelineCreateMaskingTimeline.isEmpty() || i4 < immutableList.size()) {
                z2 = false;
                j2 = j3;
                firstWindowIndex = i4;
            } else {
                firstWindowIndex = remotableTimelineCreateMaskingTimeline.getFirstWindowIndex(this.playerInfo.shuffleModeEnabled);
                j2 = -9223372036854775807L;
                z2 = true;
            }
        } else {
            firstWindowIndex = i;
            z2 = false;
            j2 = j;
        }
        InstantParseResult.Success periodInfo = getPeriodInfo(remotableTimelineCreateMaskingTimeline, firstWindowIndex, j2);
        if (periodInfo == null) {
            positionInfo = new Player.PositionInfo(null, firstWindowIndex, null, null, firstWindowIndex, j2 == -9223372036854775807L ? 0L : j2, j2 == -9223372036854775807L ? 0L : j2, -1, -1);
            sessionPositionInfo = new SessionPositionInfo(positionInfo, false, SystemClock.elapsedRealtime(), -9223372036854775807L, j2 == -9223372036854775807L ? 0L : j2, 0, 0L, -9223372036854775807L, -9223372036854775807L, j2 == -9223372036854775807L ? 0L : j2);
        } else {
            long j4 = periodInfo.epochSeconds;
            positionInfo = new Player.PositionInfo(null, firstWindowIndex, (MediaItem) list.get(firstWindowIndex), null, periodInfo.nanosecondsOfSecond, Util.usToMs(j4), Util.usToMs(j4), -1, -1);
            sessionPositionInfo = new SessionPositionInfo(positionInfo, false, SystemClock.elapsedRealtime(), -9223372036854775807L, Util.usToMs(j4), 0, 0L, -9223372036854775807L, -9223372036854775807L, Util.usToMs(j4));
        }
        PlayerInfo playerInfoMaskTimelineAndPositionInfo = maskTimelineAndPositionInfo(this.playerInfo, remotableTimelineCreateMaskingTimeline, positionInfo, sessionPositionInfo, 4);
        int i5 = playerInfoMaskTimelineAndPositionInfo.playbackState;
        if (firstWindowIndex != -1 && i5 != 1) {
            i5 = (remotableTimelineCreateMaskingTimeline.isEmpty() || z2) ? 4 : 2;
        }
        PlayerInfo playerInfoCopyWithPlaybackState = playerInfoMaskTimelineAndPositionInfo.copyWithPlaybackState(i5, this.playerInfo.playerError);
        updatePlayerInfo(playerInfoCopyWithPlaybackState, 0, null, !this.playerInfo.timeline.isEmpty() ? 4 : null, (this.playerInfo.timeline.isEmpty() && playerInfoCopyWithPlaybackState.timeline.isEmpty()) ? null : 3);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setPlayWhenReady(boolean z) {
        if (isPlayerCommandAvailable(1)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda5(this, z, (byte) 0));
            setPlayWhenReady$1(z);
        } else if (z) {
            Log.w("MCImplBase", "Calling play() omitted due to COMMAND_PLAY_PAUSE not being available. If this play command has started the service for instance for playback resumption, this may prevent the service from being started into the foreground.");
        }
    }

    public final void setPlayWhenReady$1(boolean z) {
        PlayerInfo playerInfo = this.playerInfo;
        int i = playerInfo.playbackSuppressionReason;
        int i2 = i == 1 ? 0 : i;
        if (playerInfo.playWhenReady == z && i == i2) {
            return;
        }
        this.currentPositionMs = MediaUtils.getUpdatedCurrentPositionMs(playerInfo, this.currentPositionMs, this.lastSetPlayWhenReadyCalledTimeMs, this.instance.timeDiffMs);
        this.lastSetPlayWhenReadyCalledTimeMs = SystemClock.elapsedRealtime();
        updatePlayerInfo(this.playerInfo.copyWithPlayWhenReady(1, z, i2), null, 1, null, null);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setPlaybackParameters(PlaybackParameters playbackParameters) {
        if (isPlayerCommandAvailable(13)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new TextLinkScope$$ExternalSyntheticLambda10((Object) this, (Object) playbackParameters, (byte) 10));
            if (this.playerInfo.playbackParameters.equals(playbackParameters)) {
                return;
            }
            this.playerInfo = this.playerInfo.copyWithPlaybackParameters(playbackParameters);
            MediaSessionStub$$ExternalSyntheticLambda33 mediaSessionStub$$ExternalSyntheticLambda33 = new MediaSessionStub$$ExternalSyntheticLambda33(playbackParameters, (byte) 1);
            ListenerSet listenerSet = this.listeners;
            listenerSet.queueEvent(12, mediaSessionStub$$ExternalSyntheticLambda33);
            listenerSet.flushEvents();
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setPlaybackSpeed(float f) {
        if (isPlayerCommandAvailable(13)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaSessionLegacyStub$$ExternalSyntheticLambda10(this, f, (byte) 1));
            PlaybackParameters playbackParameters = this.playerInfo.playbackParameters;
            if (playbackParameters.speed != f) {
                PlaybackParameters playbackParameters2 = new PlaybackParameters(f, playbackParameters.pitch);
                this.playerInfo = this.playerInfo.copyWithPlaybackParameters(playbackParameters2);
                MediaSessionStub$$ExternalSyntheticLambda33 mediaSessionStub$$ExternalSyntheticLambda33 = new MediaSessionStub$$ExternalSyntheticLambda33(playbackParameters2, (byte) 2);
                ListenerSet listenerSet = this.listeners;
                listenerSet.queueEvent(12, mediaSessionStub$$ExternalSyntheticLambda33);
                listenerSet.flushEvents();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setPlaylistMetadata(MediaMetadata mediaMetadata) {
        if (isPlayerCommandAvailable(19)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new TextLinkScope$$ExternalSyntheticLambda10((Object) this, (Object) mediaMetadata, (byte) 9));
            if (this.playerInfo.playlistMetadata.equals(mediaMetadata)) {
                return;
            }
            this.playerInfo = this.playerInfo.copyWithPlaylistMetadata(mediaMetadata);
            ExoPlayerImpl$$ExternalSyntheticLambda10 exoPlayerImpl$$ExternalSyntheticLambda10 = new ExoPlayerImpl$$ExternalSyntheticLambda10(mediaMetadata, (byte) 1);
            ListenerSet listenerSet = this.listeners;
            listenerSet.queueEvent(15, exoPlayerImpl$$ExternalSyntheticLambda10);
            listenerSet.flushEvents();
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setRepeatMode(int i) {
        if (isPlayerCommandAvailable(15)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda10(this, i, (byte) 6));
            PlayerInfo playerInfo = this.playerInfo;
            if (playerInfo.repeatMode != i) {
                this.playerInfo = playerInfo.copyWithRepeatMode(i);
                UCropActivity$$ExternalSyntheticLambda1 uCropActivity$$ExternalSyntheticLambda1 = new UCropActivity$$ExternalSyntheticLambda1((byte) 4, i);
                ListenerSet listenerSet = this.listeners;
                listenerSet.queueEvent(8, uCropActivity$$ExternalSyntheticLambda1);
                listenerSet.flushEvents();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setShuffleModeEnabled(boolean z) {
        if (isPlayerCommandAvailable(14)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda5(this, z, (byte) 2));
            PlayerInfo playerInfo = this.playerInfo;
            if (playerInfo.shuffleModeEnabled != z) {
                this.playerInfo = playerInfo.copyWithShuffleModeEnabled(z);
                ExoPlayerImpl$$ExternalSyntheticLambda14 exoPlayerImpl$$ExternalSyntheticLambda14 = new ExoPlayerImpl$$ExternalSyntheticLambda14((byte) 3, z);
                ListenerSet listenerSet = this.listeners;
                listenerSet.queueEvent(9, exoPlayerImpl$$ExternalSyntheticLambda14);
                listenerSet.flushEvents();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        if (isPlayerCommandAvailable(29)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new TextLinkScope$$ExternalSyntheticLambda10((Object) this, (Object) trackSelectionParameters, (byte) 12));
            PlayerInfo playerInfo = this.playerInfo;
            if (trackSelectionParameters != playerInfo.trackSelectionParameters) {
                this.playerInfo = playerInfo.copyWithTrackSelectionParameters(trackSelectionParameters);
                ExoPlayerImpl$$ExternalSyntheticLambda23 exoPlayerImpl$$ExternalSyntheticLambda23 = new ExoPlayerImpl$$ExternalSyntheticLambda23(trackSelectionParameters, (byte) 1);
                ListenerSet listenerSet = this.listeners;
                listenerSet.queueEvent(19, exoPlayerImpl$$ExternalSyntheticLambda23);
                listenerSet.flushEvents();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        if (isPlayerCommandAvailable(27)) {
            if (surfaceHolder == null) {
                if (isPlayerCommandAvailable(27)) {
                    clearSurfacesAndCallbacks();
                    setVideoSurfaceWithSize(null, 0, 0);
                    onSurfaceSizeChanged(0, 0);
                    return;
                }
                return;
            }
            if (this.videoSurfaceHolder == surfaceHolder) {
                return;
            }
            clearSurfacesAndCallbacks();
            this.videoSurfaceHolder = surfaceHolder;
            surfaceHolder.addCallback(this.surfaceCallback);
            Surface surface = surfaceHolder.getSurface();
            if (surface == null || !surface.isValid()) {
                this.videoSurface = null;
                setVideoSurfaceWithSize(null, 0, 0);
                onSurfaceSizeChanged(0, 0);
            } else {
                this.videoSurface = surface;
                Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
                setVideoSurfaceWithSize(surface, surfaceFrame.width(), surfaceFrame.height());
                onSurfaceSizeChanged(surfaceFrame.width(), surfaceFrame.height());
            }
        }
    }

    public final void setVideoSurfaceWithSize(Surface surface, int i, int i2) {
        if (isConnected()) {
            if (getSessionInterfaceVersion() >= 8) {
                dispatchRemoteSessionTaskWithPlayerCommandAndWaitForFuture(new MediaSessionStub$$ExternalSyntheticLambda11(this, surface, i, i2, (byte) 2));
            } else {
                dispatchRemoteSessionTaskWithPlayerCommandAndWaitForFuture(new TextLinkScope$$ExternalSyntheticLambda10((Object) this, (Object) surface, (byte) 8));
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setVolume(float f) {
        if (isPlayerCommandAvailable(24)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaSessionLegacyStub$$ExternalSyntheticLambda10(this, f, (byte) 2));
            PlayerInfo playerInfo = this.playerInfo;
            if (playerInfo.volume != f) {
                this.playerInfo = playerInfo.copyWithVolume(f);
                ExoPlayerImpl$$ExternalSyntheticLambda15 exoPlayerImpl$$ExternalSyntheticLambda15 = new ExoPlayerImpl$$ExternalSyntheticLambda15(f, (byte) 1);
                ListenerSet listenerSet = this.listeners;
                listenerSet.queueEvent(22, exoPlayerImpl$$ExternalSyntheticLambda15);
                listenerSet.flushEvents();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void stop() {
        if (isPlayerCommandAvailable(3)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda3(this, (byte) 10));
            PlayerInfo playerInfo = this.playerInfo;
            SessionPositionInfo sessionPositionInfo = this.playerInfo.sessionPositionInfo;
            Player.PositionInfo positionInfo = sessionPositionInfo.positionInfo;
            boolean z = sessionPositionInfo.isPlayingAd;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            SessionPositionInfo sessionPositionInfo2 = this.playerInfo.sessionPositionInfo;
            long j = sessionPositionInfo2.durationMs;
            long j2 = sessionPositionInfo2.positionInfo.positionMs;
            int iCalculateBufferedPercentage = MediaUtils.calculateBufferedPercentage(j2, j);
            SessionPositionInfo sessionPositionInfo3 = this.playerInfo.sessionPositionInfo;
            PlayerInfo playerInfoCopyWithSessionPositionInfo = playerInfo.copyWithSessionPositionInfo(new SessionPositionInfo(positionInfo, z, jElapsedRealtime, j, j2, iCalculateBufferedPercentage, 0L, sessionPositionInfo3.currentLiveOffsetMs, sessionPositionInfo3.contentDurationMs, sessionPositionInfo3.positionInfo.positionMs));
            this.playerInfo = playerInfoCopyWithSessionPositionInfo;
            if (playerInfoCopyWithSessionPositionInfo.playbackState != 1) {
                this.playerInfo = playerInfoCopyWithSessionPositionInfo.copyWithPlaybackState(1, playerInfoCopyWithSessionPositionInfo.playerError);
                MediaSessionStub$$ExternalSyntheticLambda8 mediaSessionStub$$ExternalSyntheticLambda8 = new MediaSessionStub$$ExternalSyntheticLambda8((byte) 2);
                ListenerSet listenerSet = this.listeners;
                listenerSet.queueEvent(4, mediaSessionStub$$ExternalSyntheticLambda8);
                listenerSet.flushEvents();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void unmute() {
        if (isPlayerCommandAvailable(24)) {
            float f = this.playerInfo.unmuteVolume;
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaSessionLegacyStub$$ExternalSyntheticLambda10(this, f, (byte) 3));
            PlayerInfo playerInfo = this.playerInfo;
            float f2 = playerInfo.volume;
            if (f2 == playerInfo.unmuteVolume || f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                return;
            }
            this.playerInfo = playerInfo.copyWithVolume(f);
            ExoPlayerImpl$$ExternalSyntheticLambda15 exoPlayerImpl$$ExternalSyntheticLambda15 = new ExoPlayerImpl$$ExternalSyntheticLambda15(f, (byte) 2);
            ListenerSet listenerSet = this.listeners;
            listenerSet.queueEvent(22, exoPlayerImpl$$ExternalSyntheticLambda15);
            listenerSet.flushEvents();
        }
    }

    public final void updatePlayerInfo(PlayerInfo playerInfo, Integer num, Integer num2, Integer num3, Integer num4) {
        PlayerInfo playerInfo2 = this.playerInfo;
        this.playerInfo = playerInfo;
        notifyPlayerInfoListenersWithReasons(playerInfo2, playerInfo, num, num2, num3, num4);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SurfaceCallback implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
        public SurfaceCallback() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return true;
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            MediaControllerImplBase mediaControllerImplBase = MediaControllerImplBase.this;
            if (mediaControllerImplBase.videoSurfaceHolder == surfaceHolder && mediaControllerImplBase.isConnected()) {
                if (mediaControllerImplBase.getSessionInterfaceVersion() >= 8) {
                    mediaControllerImplBase.dispatchRemoteSessionTaskWithPlayerCommandAndWaitForFuture(new MediaControllerImplBase$$ExternalSyntheticLambda48(this, i2, i3, (byte) 3));
                }
                mediaControllerImplBase.onSurfaceSizeChanged(i2, i3);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            MediaControllerImplBase mediaControllerImplBase = MediaControllerImplBase.this;
            if (mediaControllerImplBase.videoSurfaceHolder != surfaceHolder) {
                return;
            }
            mediaControllerImplBase.videoSurface = surfaceHolder.getSurface();
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            mediaControllerImplBase.setVideoSurfaceWithSize(mediaControllerImplBase.videoSurface, surfaceFrame.width(), surfaceFrame.height());
            mediaControllerImplBase.onSurfaceSizeChanged(surfaceFrame.width(), surfaceFrame.height());
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            MediaControllerImplBase mediaControllerImplBase = MediaControllerImplBase.this;
            if (mediaControllerImplBase.videoSurfaceHolder != surfaceHolder) {
                return;
            }
            mediaControllerImplBase.videoSurface = null;
            mediaControllerImplBase.setVideoSurfaceWithSize(null, 0, 0);
            mediaControllerImplBase.onSurfaceSizeChanged(0, 0);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void seekTo(long j) {
        if (isPlayerCommandAvailable(5)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaSessionStub$$ExternalSyntheticLambda64(j, this));
            seekToInternal(getCurrentMediaItemIndexInternal(this.playerInfo), j);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void addMediaItems(int i, List list) {
        if (isPlayerCommandAvailable(20)) {
            UtilsKt.checkArgument(i >= 0);
            dispatchRemoteSessionTaskWithPlayerCommand(new ExoPlayerImpl$$ExternalSyntheticLambda5((Object) this, i, (Object) list, (byte) 1));
            addMediaItemsInternal(i, list);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setMediaItems(final List list, final int i, final long j) {
        if (isPlayerCommandAvailable(20)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda97
                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i2) {
                    MediaControllerImplBase mediaControllerImplBase = this.f$0;
                    MediaControllerStub mediaControllerStub = mediaControllerImplBase.controllerStub;
                    ImmutableList.Builder builder = ImmutableList.builder();
                    int i3 = 0;
                    while (true) {
                        List list2 = list;
                        if (i3 >= list2.size()) {
                            iMediaSession.setMediaItemsWithStartIndex(mediaControllerStub, i2, new BundleListRetriever(builder.build()), i, j);
                            return;
                        } else {
                            builder.add((Object) ((MediaItem) list2.get(i3)).toBundle(mediaControllerImplBase.getSessionInterfaceVersion(), true));
                            i3++;
                        }
                    }
                }
            });
            setMediaItemsInternal(list, i, j, false);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setMediaItem(final MediaItem mediaItem, final long j) {
        if (isPlayerCommandAvailable(31)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda96
                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i) {
                    MediaControllerImplBase mediaControllerImplBase = this.f$0;
                    iMediaSession.setMediaItemWithStartPosition(mediaControllerImplBase.controllerStub, i, mediaItem.toBundle(mediaControllerImplBase.getSessionInterfaceVersion(), true), j);
                }
            });
            setMediaItemsInternal(Collections.singletonList(mediaItem), -1, j, false);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void seekToDefaultPosition() {
        if (isPlayerCommandAvailable(4)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda3(this, (byte) 4));
            seekToInternal(getCurrentMediaItemIndexInternal(this.playerInfo), -9223372036854775807L);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setDeviceMuted(final int i, final boolean z) {
        if (isPlayerCommandAvailable(34)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new RemoteSessionTask() { // from class: androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda53
                @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
                public final void run(IMediaSession iMediaSession, int i2) {
                    iMediaSession.setDeviceMutedWithFlags(this.f$0.controllerStub, i2, z, i);
                }
            });
            PlayerInfo playerInfo = this.playerInfo;
            if (playerInfo.deviceMuted != z) {
                this.playerInfo = playerInfo.copyWithDeviceVolume(playerInfo.deviceVolume, z);
                MediaControllerImplBase$$ExternalSyntheticLambda5 mediaControllerImplBase$$ExternalSyntheticLambda5 = new MediaControllerImplBase$$ExternalSyntheticLambda5(this, z, (byte) 1);
                ListenerSet listenerSet = this.listeners;
                listenerSet.queueEvent(30, mediaControllerImplBase$$ExternalSyntheticLambda5);
                listenerSet.flushEvents();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void decreaseDeviceVolume(int i) {
        if (isPlayerCommandAvailable(34)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda10(this, i, (byte) 0));
            PlayerInfo playerInfo = this.playerInfo;
            byte b = 1;
            int i2 = playerInfo.deviceVolume - 1;
            if (i2 >= playerInfo.deviceInfo.minVolume) {
                this.playerInfo = playerInfo.copyWithDeviceVolume(i2, playerInfo.deviceMuted);
                MediaControllerImplBase$$ExternalSyntheticLambda10 mediaControllerImplBase$$ExternalSyntheticLambda10 = new MediaControllerImplBase$$ExternalSyntheticLambda10(this, i2, b);
                ListenerSet listenerSet = this.listeners;
                listenerSet.queueEvent(30, mediaControllerImplBase$$ExternalSyntheticLambda10);
                listenerSet.flushEvents();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void increaseDeviceVolume(int i) {
        if (isPlayerCommandAvailable(34)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda10(this, i, (byte) 4));
            PlayerInfo playerInfo = this.playerInfo;
            int i2 = playerInfo.deviceVolume + 1;
            int i3 = playerInfo.deviceInfo.maxVolume;
            if (i3 == 0 || i2 <= i3) {
                this.playerInfo = playerInfo.copyWithDeviceVolume(i2, playerInfo.deviceMuted);
                MediaControllerImplBase$$ExternalSyntheticLambda10 mediaControllerImplBase$$ExternalSyntheticLambda10 = new MediaControllerImplBase$$ExternalSyntheticLambda10(this, i2, (byte) 5);
                ListenerSet listenerSet = this.listeners;
                listenerSet.queueEvent(30, mediaControllerImplBase$$ExternalSyntheticLambda10);
                listenerSet.flushEvents();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public final void setDeviceVolume(int i, int i2) {
        if (isPlayerCommandAvailable(33)) {
            dispatchRemoteSessionTaskWithPlayerCommand(new MediaControllerImplBase$$ExternalSyntheticLambda48(this, i, i2, (byte) 0));
            PlayerInfo playerInfo = this.playerInfo;
            DeviceInfo deviceInfo = playerInfo.deviceInfo;
            if (playerInfo.deviceVolume == i || deviceInfo.minVolume > i) {
                return;
            }
            int i3 = deviceInfo.maxVolume;
            if (i3 == 0 || i <= i3) {
                this.playerInfo = playerInfo.copyWithDeviceVolume(i, playerInfo.deviceMuted);
                MediaControllerImplBase$$ExternalSyntheticLambda10 mediaControllerImplBase$$ExternalSyntheticLambda10 = new MediaControllerImplBase$$ExternalSyntheticLambda10(this, i, (byte) 2);
                ListenerSet listenerSet = this.listeners;
                listenerSet.queueEvent(30, mediaControllerImplBase$$ExternalSyntheticLambda10);
                listenerSet.flushEvents();
            }
        }
    }

    public static PlayerInfo maskTimelineAndPositionInfo(PlayerInfo playerInfo, Timeline.RemotableTimeline remotableTimeline, int i, int i2, long j, long j2, int i3) {
        Timeline.Window window = new Timeline.Window();
        remotableTimeline.getWindow(i, window, 0L);
        MediaItem mediaItem = window.mediaItem;
        Player.PositionInfo positionInfo = playerInfo.sessionPositionInfo.positionInfo;
        Player.PositionInfo positionInfo2 = new Player.PositionInfo(null, i, mediaItem, null, i2, j, j2, positionInfo.adGroupIndex, positionInfo.adIndexInAdGroup);
        SessionPositionInfo sessionPositionInfo = playerInfo.sessionPositionInfo;
        return maskTimelineAndPositionInfo(playerInfo, remotableTimeline, positionInfo2, new SessionPositionInfo(positionInfo2, sessionPositionInfo.isPlayingAd, SystemClock.elapsedRealtime(), sessionPositionInfo.durationMs, sessionPositionInfo.bufferedPositionMs, sessionPositionInfo.bufferedPercentage, sessionPositionInfo.totalBufferedDurationMs, sessionPositionInfo.currentLiveOffsetMs, sessionPositionInfo.contentDurationMs, sessionPositionInfo.contentBufferedPositionMs), i3);
    }
}
