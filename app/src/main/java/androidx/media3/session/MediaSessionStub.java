package androidx.media3.session;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.collection.ArrayMap;
import androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda10;
import androidx.compose.ui.node.NodeChain;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.BundleListRetriever;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Rating;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda0;
import androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda10;
import androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda14;
import androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda15;
import androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda24;
import androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda5;
import androidx.media3.session.PlayerInfo.InProcessBinder;
import androidx.media3.session.legacy.MediaBrowserCompat;
import androidx.media3.session.legacy.MediaSessionManager$RemoteUserInfo;
import androidx.room.TransactionExecutor$$ExternalSyntheticLambda0;
import androidx.sqlite.SQLite;
import coil3.util.LifecyclesKt;
import coil3.util.UtilsKt;
import com.google.common.base.Splitter$$ExternalSyntheticLambda0;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.DirectExecutor;
import com.google.common.util.concurrent.ImmediateFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.metrolist.innertube.InnerTube$$ExternalSyntheticLambda8;
import com.metrolist.music.playback.MediaLibrarySessionCallback;
import com.yalantis.ucrop.UCropActivity$$ExternalSyntheticLambda1;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSessionStub extends Binder implements IMediaSession {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final Dispatcher connectedControllersManager;
    public int nextUniqueTrackGroupIdPrefix;
    public final Set pendingControllers;
    public final WeakReference sessionImpl;
    public SurfaceHolderWithSize surfaceHolderWithSize;
    public RegularImmutableBiMap trackGroupIdMap;
    public RegularImmutableMap trackGroupOriginalToUniqueIdMap;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Controller2Cb implements MediaSession$ControllerCb {
        public final int controllerInterfaceVersion;
        public final IMediaController iController;

        public Controller2Cb(IMediaController iMediaController, int i) {
            this.iController = iMediaController;
            this.controllerInterfaceVersion = i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != Controller2Cb.class) {
                return false;
            }
            return Objects.equals(this.iController.asBinder(), ((Controller2Cb) obj).iController.asBinder());
        }

        public final int hashCode() {
            return Objects.hash(this.iController.asBinder());
        }

        @Override // androidx.media3.session.MediaSession$ControllerCb
        public final void onAvailableCommandsChangedFromPlayer(int i, Player.Commands commands) {
            this.iController.onAvailableCommandsChangedFromPlayer(i, commands.toBundle());
        }

        @Override // androidx.media3.session.MediaSession$ControllerCb
        public final void onDisconnected() {
            SQLite.disconnectIMediaController(this.iController);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
        
            if (r2 != 4) goto L26;
         */
        @Override // androidx.media3.session.MediaSession$ControllerCb
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onLibraryResult(int i, LibraryResult libraryResult) {
            String str = LibraryResult.FIELD_VALUE;
            Object obj = libraryResult.value;
            int i2 = libraryResult.valueType;
            Bundle bundle = new Bundle();
            bundle.putInt(LibraryResult.FIELD_RESULT_CODE, libraryResult.resultCode);
            bundle.putLong(LibraryResult.FIELD_COMPLETION_TIME_MS, libraryResult.completionTimeMs);
            MediaLibraryService.LibraryParams libraryParams = libraryResult.params;
            if (libraryParams != null) {
                bundle.putBundle(LibraryResult.FIELD_PARAMS, libraryParams.toBundle());
            }
            SessionError sessionError = libraryResult.sessionError;
            if (sessionError != null) {
                bundle.putBundle(LibraryResult.FIELD_SESSION_ERROR, sessionError.toBundle());
            }
            bundle.putInt(LibraryResult.FIELD_VALUE_TYPE, i2);
            if (obj != null) {
                if (i2 != 1) {
                    int i3 = this.controllerInterfaceVersion;
                    if (i2 == 2) {
                        bundle.putBundle(str, ((MediaItem) obj).toBundle(i3, false));
                    } else if (i2 == 3) {
                        ImmutableList immutableList = (ImmutableList) obj;
                        ImmutableList.Builder builder = ImmutableList.builder();
                        for (int i4 = 0; i4 < immutableList.size(); i4++) {
                            builder.add((Object) ((MediaItem) immutableList.get(i4)).toBundle(i3, false));
                        }
                        bundle.putBinder(str, new BundleListRetriever(builder.build()));
                    }
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                return;
            }
            this.iController.onLibraryResult(i, bundle);
        }

        @Override // androidx.media3.session.MediaSession$ControllerCb
        public final void onPeriodicSessionPositionInfoChanged(int i, SessionPositionInfo sessionPositionInfo, boolean z, boolean z2, int i2) {
            this.iController.onPeriodicSessionPositionInfoChanged(i, sessionPositionInfo.filterByAvailableCommands(z, z2).toBundle(i2));
        }

        @Override // androidx.media3.session.MediaSession$ControllerCb
        public final void onPlayerInfoChanged(int i, PlayerInfo playerInfo, Player.Commands commands, boolean z, boolean z2) {
            Bundle bundleForRemoteProcess;
            int i2 = this.controllerInterfaceVersion;
            UtilsKt.checkState(i2 != 0);
            boolean z3 = z || !commands.contains(17);
            boolean z4 = z2 || !commands.contains(30);
            IMediaController iMediaController = this.iController;
            if (i2 < 2) {
                iMediaController.onPlayerInfoChanged(i, playerInfo.filterByAvailableCommands(commands, z, true).toBundleForRemoteProcess(i2), z3);
                return;
            }
            PlayerInfo playerInfoFilterByAvailableCommands = playerInfo.filterByAvailableCommands(commands, z, z2);
            if (iMediaController instanceof MediaControllerStub) {
                bundleForRemoteProcess = new Bundle();
                bundleForRemoteProcess.putBinder(PlayerInfo.FIELD_IN_PROCESS_BINDER, playerInfoFilterByAvailableCommands.new InProcessBinder());
            } else {
                bundleForRemoteProcess = playerInfoFilterByAvailableCommands.toBundleForRemoteProcess(i2);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(PlayerInfo.BundlingExclusions.FIELD_IS_TIMELINE_EXCLUDED, z3);
            bundle.putBoolean(PlayerInfo.BundlingExclusions.FIELD_ARE_CURRENT_TRACKS_EXCLUDED, z4);
            iMediaController.onPlayerInfoChangedWithExclusions(i, bundleForRemoteProcess, bundle);
        }

        @Override // androidx.media3.session.MediaSession$ControllerCb
        public final void onRenderedFirstFrame(int i) {
            this.iController.onRenderedFirstFrame(i);
        }

        @Override // androidx.media3.session.MediaSession$ControllerCb
        public final void onSearchResultChanged(int i, String str, MediaLibraryService.LibraryParams libraryParams) {
            this.iController.onSearchResultChanged(i, 1, libraryParams == null ? null : libraryParams.toBundle(), str);
        }

        @Override // androidx.media3.session.MediaSession$ControllerCb
        public final void onSessionResult(int i, SessionResult sessionResult) {
            this.iController.onSessionResult(i, sessionResult.toBundle());
        }

        @Override // androidx.media3.session.MediaSession$ControllerCb
        public final void onSurfaceSizeChanged(int i, int i2, int i3) {
            this.iController.onSurfaceSizeChanged(i, i2, i3);
        }

        @Override // androidx.media3.session.MediaSession$ControllerCb
        public final void sendCustomCommand(int i, SessionCommand sessionCommand) {
            this.iController.onCustomCommand(i, sessionCommand.toBundle(), Bundle.EMPTY);
        }

        @Override // androidx.media3.session.MediaSession$ControllerCb
        public final void setCustomLayout(int i, List list) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (int i2 = 0; i2 < list.size(); i2++) {
                builder.add((Object) ((CommandButton) list.get(i2)).toBundle(this.controllerInterfaceVersion));
            }
            this.iController.onSetCustomLayout(i, builder.build());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface ControllerPlayerTask {
        void run(PlayerWrapper playerWrapper, MediaSession$ControllerInfo mediaSession$ControllerInfo);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface MediaItemPlayerTask {
        void run(PlayerWrapper playerWrapper, MediaSession$ControllerInfo mediaSession$ControllerInfo, List list);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface SessionTask {
        Object run(MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession$ControllerInfo mediaSession$ControllerInfo, int i);
    }

    public MediaSessionStub(MediaLibrarySessionImpl mediaLibrarySessionImpl) {
        attachInterface(this, "androidx.media3.session.IMediaSession");
        this.sessionImpl = new WeakReference(mediaLibrarySessionImpl);
        this.connectedControllersManager = new Dispatcher(mediaLibrarySessionImpl);
        this.pendingControllers = Collections.synchronizedSet(new HashSet());
        this.trackGroupIdMap = RegularImmutableBiMap.EMPTY;
        this.trackGroupOriginalToUniqueIdMap = RegularImmutableMap.EMPTY;
    }

    public static ListenableFuture handleSessionTaskWhenReady(MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession$ControllerInfo mediaSession$ControllerInfo, int i, SessionTask sessionTask, Consumer consumer) {
        if (mediaLibrarySessionImpl.isReleased()) {
            return ImmediateFuture.NULL;
        }
        ListenableFuture listenableFuture = (ListenableFuture) sessionTask.run(mediaLibrarySessionImpl, mediaSession$ControllerInfo, i);
        SettableFuture settableFuture = new SettableFuture();
        listenableFuture.addListener(new MediaSessionStub$$ExternalSyntheticLambda3(mediaLibrarySessionImpl, (Object) settableFuture, (Object) consumer, (Object) listenableFuture, (byte) 9), DirectExecutor.INSTANCE);
        return settableFuture;
    }

    public static void sendSessionResult(MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession$ControllerInfo mediaSession$ControllerInfo, int i, SessionResult sessionResult) {
        try {
            MediaSession$ControllerCb mediaSession$ControllerCb = mediaSession$ControllerInfo.controllerCb;
            mediaSession$ControllerCb.getClass();
            mediaSession$ControllerCb.onSessionResult(i, sessionResult);
            mediaLibrarySessionImpl.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
        } catch (RemoteException e) {
            Log.w("MediaSessionStub", "Failed to send result to controller " + mediaSession$ControllerInfo, e);
        }
    }

    public static Splitter$$ExternalSyntheticLambda0 sendSessionResultSuccess(Consumer consumer) {
        return new Splitter$$ExternalSyntheticLambda0((byte) 3, new Splitter$$ExternalSyntheticLambda0((byte) 4, consumer));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void addMediaItemWithIndex(IMediaController iMediaController, int i, int i2, Bundle bundle) {
        MediaSession$ControllerInfo controller;
        if (iMediaController == null || bundle == null || i2 < 0 || (controller = this.connectedControllersManager.getController(iMediaController.asBinder())) == null) {
            return;
        }
        try {
            queueSessionTaskWithPlayerCommandForControllerInfo(controller, i, 20, new MediaSessionStub$$ExternalSyntheticLambda76(new TextLinkScope$$ExternalSyntheticLambda10(new MediaSessionStub$$ExternalSyntheticLambda23(MediaItem.fromBundle(controller.interfaceVersion, bundle), (byte) 0), new MediaSessionStub$$ExternalSyntheticLambda6(this, i2, (byte) 2), (byte) 23), (byte) 1));
        } catch (RuntimeException e) {
            Log.w("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void addMediaItems(IMediaController iMediaController, int i, IBinder iBinder) {
        MediaSession$ControllerInfo controller;
        if (iMediaController == null || iBinder == null || (controller = this.connectedControllersManager.getController(iMediaController.asBinder())) == null) {
            return;
        }
        try {
            ImmutableList list = BundleListRetriever.getList(iBinder);
            ImmutableList.Builder builder = ImmutableList.builder();
            for (int i2 = 0; i2 < list.size(); i2++) {
                Bundle bundle = (Bundle) list.get(i2);
                bundle.getClass();
                builder.add((Object) MediaItem.fromBundle(controller.interfaceVersion, bundle));
            }
            queueSessionTaskWithPlayerCommandForControllerInfo(controller, i, 20, new MediaSessionStub$$ExternalSyntheticLambda76(new TextLinkScope$$ExternalSyntheticLambda10(new MediaSessionStub$$ExternalSyntheticLambda35(builder.build(), (byte) 2), new MediaSessionStub$$ExternalSyntheticLambda8((byte) 22), (byte) 23), (byte) 1));
        } catch (RuntimeException e) {
            Log.w("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void addMediaItemsWithIndex(IMediaController iMediaController, int i, int i2, IBinder iBinder) {
        MediaSession$ControllerInfo controller;
        if (iMediaController == null || iBinder == null || i2 < 0 || (controller = this.connectedControllersManager.getController(iMediaController.asBinder())) == null) {
            return;
        }
        try {
            ImmutableList list = BundleListRetriever.getList(iBinder);
            ImmutableList.Builder builder = ImmutableList.builder();
            byte b = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                Bundle bundle = (Bundle) list.get(i3);
                bundle.getClass();
                builder.add((Object) MediaItem.fromBundle(controller.interfaceVersion, bundle));
            }
            queueSessionTaskWithPlayerCommandForControllerInfo(controller, i, 20, new MediaSessionStub$$ExternalSyntheticLambda76(new TextLinkScope$$ExternalSyntheticLambda10(new MediaSessionStub$$ExternalSyntheticLambda35(builder.build(), b), new MediaSessionStub$$ExternalSyntheticLambda6(this, i2, (byte) 4), (byte) 23), (byte) 1));
        } catch (RuntimeException e) {
            Log.w("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void clearMediaItems(IMediaController iMediaController, int i) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 20, sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 28)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void connect(IMediaController iMediaController, int i, Bundle bundle) {
        MediaLibrarySessionImpl mediaLibrarySessionImpl = (MediaLibrarySessionImpl) this.sessionImpl.get();
        if (iMediaController == null || bundle == null || mediaLibrarySessionImpl == null) {
            SQLite.disconnectIMediaController(iMediaController);
            return;
        }
        try {
            Context context = mediaLibrarySessionImpl.context;
            ConnectionRequest connectionRequestFromBundle = ConnectionRequest.fromBundle(bundle);
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            String str = connectionRequestFromBundle.packageName;
            if (SQLite.checkPackageValidity(context, str, callingUid) == 1) {
                Log.w("MediaSessionStub", "Ignoring connection from invalid package name " + str + " (uid=" + callingUid + ")");
                SQLite.disconnectIMediaController(iMediaController);
                return;
            }
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            if (callingPid == 0) {
                callingPid = connectionRequestFromBundle.pid;
            }
            try {
                MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo = new MediaSessionManager$RemoteUserInfo(str, callingPid, callingUid);
                boolean zIsTrustedForMediaControl = MediaBrowserCompat.getSessionManager(context).isTrustedForMediaControl(mediaSessionManager$RemoteUserInfo);
                int i2 = connectionRequestFromBundle.libraryVersion;
                int i3 = connectionRequestFromBundle.controllerInterfaceVersion;
                connect(iMediaController, new MediaSession$ControllerInfo(mediaSessionManager$RemoteUserInfo, i2, i3, zIsTrustedForMediaControl, new Controller2Cb(iMediaController, i3), connectionRequestFromBundle.connectionHints));
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        } catch (RuntimeException e) {
            Log.w("MediaSessionStub", "Ignoring malformed Bundle for ConnectionRequest", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void decreaseDeviceVolume(IMediaController iMediaController, int i) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 26, sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 21)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void decreaseDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 34, sendSessionResultSuccess(new UCropActivity$$ExternalSyntheticLambda1((byte) 6, i2)));
    }

    public final void dispatchSessionTaskWithSessionCommand(IMediaController iMediaController, final int i, final SessionCommand sessionCommand, final int i2, final SessionTask sessionTask) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            final MediaLibrarySessionImpl mediaLibrarySessionImpl = (MediaLibrarySessionImpl) this.sessionImpl.get();
            if (mediaLibrarySessionImpl != null && !mediaLibrarySessionImpl.isReleased()) {
                final MediaSession$ControllerInfo controller = this.connectedControllersManager.getController(iMediaController.asBinder());
                if (controller == null) {
                    return;
                }
                Util.postOrRun(mediaLibrarySessionImpl.applicationHandler, new Runnable() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda72
                    @Override // java.lang.Runnable
                    public final void run() {
                        Dispatcher dispatcher = this.f$0.connectedControllersManager;
                        MediaSession$ControllerInfo mediaSession$ControllerInfo = controller;
                        if (dispatcher.isConnected(mediaSession$ControllerInfo)) {
                            SessionCommand sessionCommand2 = sessionCommand;
                            MediaLibrarySessionImpl mediaLibrarySessionImpl2 = mediaLibrarySessionImpl;
                            int i3 = i;
                            if (sessionCommand2 != null) {
                                if (!dispatcher.isSessionCommandAvailable(mediaSession$ControllerInfo, sessionCommand2)) {
                                    MediaSessionStub.sendSessionResult(mediaLibrarySessionImpl2, mediaSession$ControllerInfo, i3, new SessionResult(-4));
                                    return;
                                }
                            } else if (!dispatcher.isSessionCommandAvailable(mediaSession$ControllerInfo, i2)) {
                                MediaSessionStub.sendSessionResult(mediaLibrarySessionImpl2, mediaSession$ControllerInfo, i3, new SessionResult(-4));
                                return;
                            }
                            sessionTask.run(mediaLibrarySessionImpl2, mediaSession$ControllerInfo, i3);
                        }
                    }
                });
            }
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void flushCommandQueue(IMediaController iMediaController) {
        if (iMediaController == null) {
            return;
        }
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaLibrarySessionImpl mediaLibrarySessionImpl = (MediaLibrarySessionImpl) this.sessionImpl.get();
            if (mediaLibrarySessionImpl != null && !mediaLibrarySessionImpl.isReleased()) {
                MediaSession$ControllerInfo controller = this.connectedControllersManager.getController(iMediaController.asBinder());
                if (controller != null) {
                    Util.postOrRun(mediaLibrarySessionImpl.applicationHandler, new TransactionExecutor$$ExternalSyntheticLambda0((Object) this, (Object) controller, (byte) 16));
                }
            }
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void increaseDeviceVolume(IMediaController iMediaController, int i) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 26, sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 14)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void increaseDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 34, sendSessionResultSuccess(new UCropActivity$$ExternalSyntheticLambda1((byte) 7, i2)));
    }

    public final int maybeCorrectMediaItemIndex(MediaSession$ControllerInfo mediaSession$ControllerInfo, PlayerWrapper playerWrapper, int i) {
        if (playerWrapper.isCommandAvailable(17)) {
            Dispatcher dispatcher = this.connectedControllersManager;
            if (!dispatcher.isPlayerCommandAvailable(mediaSession$ControllerInfo, 17) && dispatcher.isPlayerCommandAvailable(mediaSession$ControllerInfo, 16)) {
                return playerWrapper.getCurrentMediaItemIndex() + i;
            }
        }
        return i;
    }

    @Override // androidx.media3.session.IMediaSession
    public final void moveMediaItem(IMediaController iMediaController, int i, int i2, int i3) {
        if (iMediaController == null || i2 < 0 || i3 < 0) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 20, sendSessionResultSuccess(new ExoPlayerImpl$$ExternalSyntheticLambda24(i2, i3, (byte) 5)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void moveMediaItems(IMediaController iMediaController, int i, final int i2, final int i3, final int i4) {
        if (iMediaController == null || i2 < 0 || i3 < i2 || i4 < 0) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 20, sendSessionResultSuccess(new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda41
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).moveMediaItems(i2, i3, i4);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void mute(IMediaController iMediaController, int i) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 24, sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 11)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void onControllerResult(IMediaController iMediaController, int i, Bundle bundle) {
        ConnectedControllersManager$ConnectedControllerRecord connectedControllersManager$ConnectedControllerRecord;
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            SessionResult sessionResultFromBundle = SessionResult.fromBundle(bundle);
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                Dispatcher dispatcher = this.connectedControllersManager;
                IBinder iBinderAsBinder = iMediaController.asBinder();
                synchronized (dispatcher.executorServiceOrNull) {
                    try {
                        MediaSession$ControllerInfo controller = dispatcher.getController(iBinderAsBinder);
                        connectedControllersManager$ConnectedControllerRecord = controller != null ? (ConnectedControllersManager$ConnectedControllerRecord) ((ArrayMap) dispatcher.runningAsyncCalls).get(controller) : null;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                NodeChain.Differ differ = connectedControllersManager$ConnectedControllerRecord != null ? connectedControllersManager$ConnectedControllerRecord.sequencedFutureManager : null;
                if (differ == null) {
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                } else {
                    differ.setFutureResult(i, sessionResultFromBundle);
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                }
            } catch (Throwable th2) {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                throw th2;
            }
        } catch (RuntimeException e) {
            Log.w("MediaSessionStub", "Ignoring malformed Bundle for SessionResult", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void onCustomCommand(IMediaController iMediaController, int i, Bundle bundle, Bundle bundle2) {
        onCustomCommandWithProgressUpdate(iMediaController, i, bundle, bundle2, false);
    }

    @Override // androidx.media3.session.IMediaSession
    public final void onCustomCommandWithProgressUpdate(final IMediaController iMediaController, final int i, Bundle bundle, Bundle bundle2, boolean z) {
        Bundle bundleConvertToNullIfInvalid = Util.convertToNullIfInvalid(bundle2);
        if (iMediaController == null || bundle == null || bundleConvertToNullIfInvalid == null) {
            return;
        }
        try {
            final SessionCommand sessionCommandFromBundle = SessionCommand.fromBundle(bundle);
            if (!CommandButton.isPredefinedCustomCommandButtonCode(sessionCommandFromBundle.customAction)) {
                dispatchSessionTaskWithSessionCommand(iMediaController, i, sessionCommandFromBundle, 0, new MediaSessionStub$$ExternalSyntheticLambda76(new TextLinkScope$$ExternalSyntheticLambda10(z, sessionCommandFromBundle, bundleConvertToNullIfInvalid), (byte) 1));
                return;
            }
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                final MediaLibrarySessionImpl mediaLibrarySessionImpl = (MediaLibrarySessionImpl) this.sessionImpl.get();
                if (mediaLibrarySessionImpl != null && !mediaLibrarySessionImpl.isReleased()) {
                    final MediaSession$ControllerInfo controller = this.connectedControllersManager.getController(iMediaController.asBinder());
                    if (controller == null) {
                        return;
                    }
                    Util.postOrRun(mediaLibrarySessionImpl.applicationHandler, new Runnable() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda78
                        /* JADX WARN: Code duplicated, block: B:19:0x006a  */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public final void run() {
                            boolean zBooleanValue;
                            SessionCommand sessionCommand = sessionCommandFromBundle;
                            String str = sessionCommand.customAction;
                            MediaLibrarySessionImpl mediaLibrarySessionImpl2 = mediaLibrarySessionImpl;
                            int i2 = i;
                            MediaSessionStub mediaSessionStub = this.f$0;
                            Dispatcher dispatcher = mediaSessionStub.connectedControllersManager;
                            MediaSession$ControllerInfo mediaSession$ControllerInfo = controller;
                            if (dispatcher.isConnected(mediaSession$ControllerInfo)) {
                                try {
                                    CommandButton commandButtonConvertFromPredefinedCustomCommand = CommandButton.convertFromPredefinedCustomCommand(sessionCommand);
                                    Object obj = commandButtonConvertFromPredefinedCustomCommand.parameter;
                                    int i3 = commandButtonConvertFromPredefinedCustomCommand.playerCommand;
                                    if (!commandButtonConvertFromPredefinedCustomCommand.canExecuteAction()) {
                                        Log.w("MediaSessionStub", "Can't execute predefined custom command: " + str);
                                        MediaSessionStub.sendSessionResult(mediaLibrarySessionImpl2, mediaSession$ControllerInfo, i2, new SessionResult(-6));
                                        return;
                                    }
                                    SessionCommand sessionCommand2 = commandButtonConvertFromPredefinedCustomCommand.sessionCommand;
                                    Object[] objArr = 0;
                                    if (sessionCommand2 != null) {
                                        UtilsKt.checkState(sessionCommand2.commandCode == 40010);
                                        mediaSessionStub.dispatchSessionTaskWithSessionCommand(iMediaController, i2, null, 40010, new MediaSessionStub$$ExternalSyntheticLambda76(new MediaSessionStub$$ExternalSyntheticLambda85(commandButtonConvertFromPredefinedCustomCommand), (byte) 1));
                                        return;
                                    }
                                    PlayerWrapper playerWrapper = mediaLibrarySessionImpl2.playerWrapper;
                                    if (i3 != 1) {
                                        zBooleanValue = false;
                                    } else if (obj != null) {
                                        zBooleanValue = ((Boolean) obj).booleanValue();
                                    } else if (playerWrapper.getPlayWhenReady()) {
                                        zBooleanValue = false;
                                    } else {
                                        zBooleanValue = true;
                                    }
                                    if (zBooleanValue) {
                                        mediaSessionStub.playForControllerInfo(mediaSession$ControllerInfo, i2);
                                    } else if (i3 == 31) {
                                        obj.getClass();
                                        mediaSessionStub.queueSessionTaskWithPlayerCommandForControllerInfo(mediaSession$ControllerInfo, i2, 31, new MediaSessionStub$$ExternalSyntheticLambda76(new TextLinkScope$$ExternalSyntheticLambda10(new ExoPlayerImpl$$ExternalSyntheticLambda0((MediaItem) obj, true, (byte) 1), new MediaSessionStub$$ExternalSyntheticLambda8((byte) (objArr == true ? 1 : 0)), (byte) 22), (byte) 1));
                                    } else {
                                        mediaSessionStub.queueSessionTaskWithPlayerCommandForControllerInfo(mediaSession$ControllerInfo, i2, i3, MediaSessionStub.sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda85(commandButtonConvertFromPredefinedCustomCommand)));
                                    }
                                    dispatcher.flushCommandQueue(mediaSession$ControllerInfo);
                                } catch (RuntimeException e) {
                                    Log.w("MediaSessionStub", "Failed to convert predefined custom command: " + str, e);
                                    MediaSessionStub.sendSessionResult(mediaLibrarySessionImpl2, mediaSession$ControllerInfo, i2, new SessionResult(-3));
                                }
                            }
                        }
                    });
                }
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        } catch (RuntimeException e) {
            Log.w("MediaSessionStub", "Ignoring malformed Bundle for SessionCommand", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void onSurfaceSizeChanged(IMediaController iMediaController, int i, int i2, int i3) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 27, sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda0(this, i2, i3)));
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        MediaSession$ControllerInfo controller;
        byte b = 1;
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface("androidx.media3.session.IMediaSession");
        }
        if (i == 1598968902) {
            parcel2.writeString("androidx.media3.session.IMediaSession");
            return true;
        }
        byte b2 = 2;
        boolean z = false;
        switch (i) {
            case 3002:
                setVolume(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readFloat());
                return true;
            case 3003:
                setDeviceVolume(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                return true;
            case 3004:
                increaseDeviceVolume(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                return true;
            case 3005:
                decreaseDeviceVolume(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                return true;
            case 3006:
                setDeviceMuted(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                return true;
            case 3007:
                setMediaItemWithResetPosition(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Bundle) LifecyclesKt.readTypedObject(parcel, Bundle.CREATOR), true);
                return true;
            case 3008:
                setMediaItemWithStartPosition(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Bundle) LifecyclesKt.readTypedObject(parcel, Bundle.CREATOR), parcel.readLong());
                return true;
            case 3009:
                setMediaItemWithResetPosition(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Bundle) LifecyclesKt.readTypedObject(parcel, Bundle.CREATOR), parcel.readInt() != 0);
                return true;
            case 3010:
                setMediaItemsWithResetPosition(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readStrongBinder(), true);
                return true;
            case 3011:
                setMediaItemsWithResetPosition(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readStrongBinder(), parcel.readInt() != 0);
                return true;
            case 3012:
                setMediaItemsWithStartIndex(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readStrongBinder(), parcel.readInt(), parcel.readLong());
                return true;
            case 3013:
                setPlayWhenReady(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                return true;
            case 3014:
                onControllerResult(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Bundle) LifecyclesKt.readTypedObject(parcel, Bundle.CREATOR));
                return true;
            case 3015:
                connect(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Bundle) LifecyclesKt.readTypedObject(parcel, Bundle.CREATOR));
                return true;
            case 3016:
                IMediaController iMediaControllerAsInterface = MediaControllerStub.asInterface(parcel.readStrongBinder());
                int i3 = parcel.readInt();
                Parcelable.Creator creator = Bundle.CREATOR;
                onCustomCommandWithProgressUpdate(iMediaControllerAsInterface, i3, (Bundle) LifecyclesKt.readTypedObject(parcel, creator), (Bundle) LifecyclesKt.readTypedObject(parcel, creator), false);
                return true;
            case 3017:
                setRepeatMode(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                return true;
            case 3018:
                setShuffleModeEnabled(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                return true;
            case 3019:
                removeMediaItem(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                return true;
            case 3020:
                removeMediaItems(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt());
                return true;
            case 3021:
                clearMediaItems(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                return true;
            case 3022:
                moveMediaItem(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt());
                return true;
            case 3023:
                moveMediaItems(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                return true;
            case 3024:
                play(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                return true;
            case 3025:
                pause(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                return true;
            case 3026:
                prepare(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                return true;
            case 3027:
                setPlaybackParameters(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Bundle) LifecyclesKt.readTypedObject(parcel, Bundle.CREATOR));
                return true;
            case 3028:
                setPlaybackSpeed(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readFloat());
                return true;
            case 3029:
                IMediaController iMediaControllerAsInterface2 = MediaControllerStub.asInterface(parcel.readStrongBinder());
                int i4 = parcel.readInt();
                Bundle bundle = (Bundle) LifecyclesKt.readTypedObject(parcel, Bundle.CREATOR);
                if (iMediaControllerAsInterface2 != null && bundle != null && (controller = this.connectedControllersManager.getController(iMediaControllerAsInterface2.asBinder())) != null) {
                    try {
                        queueSessionTaskWithPlayerCommandForControllerInfo(controller, i4, 20, new MediaSessionStub$$ExternalSyntheticLambda76(new TextLinkScope$$ExternalSyntheticLambda10(new MediaSessionStub$$ExternalSyntheticLambda23(MediaItem.fromBundle(controller.interfaceVersion, bundle), b2), new MediaSessionStub$$ExternalSyntheticLambda8((byte) 23), (byte) 23), b));
                    } catch (RuntimeException e) {
                        Log.w("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e);
                    }
                }
                return true;
            case 3030:
                addMediaItemWithIndex(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), (Bundle) LifecyclesKt.readTypedObject(parcel, Bundle.CREATOR));
                return true;
            case 3031:
                addMediaItems(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readStrongBinder());
                return true;
            case 3032:
                addMediaItemsWithIndex(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readStrongBinder());
                return true;
            case 3033:
                setPlaylistMetadata(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Bundle) LifecyclesKt.readTypedObject(parcel, Bundle.CREATOR));
                return true;
            case 3034:
                stop(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                return true;
            case 3035:
                release(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                return true;
            case 3036:
                seekToDefaultPosition(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                return true;
            case 3037:
                seekToDefaultPositionWithMediaItemIndex(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                return true;
            case 3038:
                seekTo(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readLong());
                return true;
            case 3039:
                seekToWithMediaItemIndex(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readLong());
                return true;
            case 3040:
                seekBack(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                return true;
            case 3041:
                seekForward(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                return true;
            case 3042:
                seekToPreviousMediaItem(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                return true;
            case 3043:
                seekToNextMediaItem(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                return true;
            case 3044:
                setVideoSurface(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Surface) LifecyclesKt.readTypedObject(parcel, Surface.CREATOR));
                return true;
            case 3045:
                flushCommandQueue(MediaControllerStub.asInterface(parcel.readStrongBinder()));
                return true;
            case 3046:
                seekToPrevious(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                return true;
            case 3047:
                seekToNext(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                return true;
            case 3048:
                setTrackSelectionParameters(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Bundle) LifecyclesKt.readTypedObject(parcel, Bundle.CREATOR));
                return true;
            case 3049:
                IMediaController iMediaControllerAsInterface3 = MediaControllerStub.asInterface(parcel.readStrongBinder());
                int i5 = parcel.readInt();
                String string = parcel.readString();
                Bundle bundle2 = (Bundle) LifecyclesKt.readTypedObject(parcel, Bundle.CREATOR);
                if (iMediaControllerAsInterface3 != null && string != null && bundle2 != null) {
                    if (TextUtils.isEmpty(string)) {
                        Log.w("MediaSessionStub", "setRatingWithMediaId(): Ignoring empty mediaId");
                    } else {
                        try {
                            dispatchSessionTaskWithSessionCommand(iMediaControllerAsInterface3, i5, null, 40010, new MediaSessionStub$$ExternalSyntheticLambda76(new MediaSessionStub$$ExternalSyntheticLambda8(string, Rating.fromBundle(bundle2)), b));
                        } catch (RuntimeException e2) {
                            Log.w("MediaSessionStub", "Ignoring malformed Bundle for Rating", e2);
                        }
                    }
                }
                return true;
            case 3050:
                IMediaController iMediaControllerAsInterface4 = MediaControllerStub.asInterface(parcel.readStrongBinder());
                int i6 = parcel.readInt();
                Bundle bundle3 = (Bundle) LifecyclesKt.readTypedObject(parcel, Bundle.CREATOR);
                if (iMediaControllerAsInterface4 != null && bundle3 != null) {
                    try {
                        dispatchSessionTaskWithSessionCommand(iMediaControllerAsInterface4, i6, null, 40010, new MediaSessionStub$$ExternalSyntheticLambda76(new MediaSessionStub$$ExternalSyntheticLambda8(Rating.fromBundle(bundle3)), b));
                    } catch (RuntimeException e3) {
                        Log.w("MediaSessionStub", "Ignoring malformed Bundle for Rating", e3);
                    }
                }
                return true;
            case 3051:
                setDeviceVolumeWithFlags(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt());
                return true;
            case 3052:
                increaseDeviceVolumeWithFlags(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                return true;
            case 3053:
                decreaseDeviceVolumeWithFlags(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                return true;
            case 3054:
                setDeviceMutedWithFlags(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt());
                return true;
            case 3055:
                replaceMediaItem(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), (Bundle) LifecyclesKt.readTypedObject(parcel, Bundle.CREATOR));
                return true;
            case 3056:
                replaceMediaItems(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readStrongBinder());
                return true;
            case 3057:
                setAudioAttributes(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Bundle) LifecyclesKt.readTypedObject(parcel, Bundle.CREATOR), parcel.readInt() != 0);
                return true;
            case 3058:
                mute(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                return true;
            case 3059:
                unmute(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                return true;
            case 3060:
                IMediaController iMediaControllerAsInterface5 = MediaControllerStub.asInterface(parcel.readStrongBinder());
                int i7 = parcel.readInt();
                Parcelable.Creator creator2 = Bundle.CREATOR;
                onCustomCommandWithProgressUpdate(iMediaControllerAsInterface5, i7, (Bundle) LifecyclesKt.readTypedObject(parcel, creator2), (Bundle) LifecyclesKt.readTypedObject(parcel, creator2), parcel.readInt() != 0);
                return true;
            case 3061:
                setVideoSurfaceWithSize(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Surface) LifecyclesKt.readTypedObject(parcel, Surface.CREATOR), parcel.readInt(), parcel.readInt());
                return true;
            case 3062:
                onSurfaceSizeChanged(MediaControllerStub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt());
                return true;
            default:
                MediaLibraryService.LibraryParams libraryParamsFromBundle = null;
                switch (i) {
                    case 4001:
                        IMediaController iMediaControllerAsInterface6 = MediaControllerStub.asInterface(parcel.readStrongBinder());
                        int i8 = parcel.readInt();
                        Bundle bundle4 = (Bundle) LifecyclesKt.readTypedObject(parcel, Bundle.CREATOR);
                        if (iMediaControllerAsInterface6 != null) {
                            if (bundle4 != null) {
                                try {
                                    libraryParamsFromBundle = MediaLibraryService.LibraryParams.fromBundle(bundle4);
                                } catch (RuntimeException e4) {
                                    Log.w("MediaSessionStub", "Ignoring malformed Bundle for LibraryParams", e4);
                                }
                            }
                            dispatchSessionTaskWithSessionCommand(iMediaControllerAsInterface6, i8, null, 50000, new MediaSessionStub$$ExternalSyntheticLambda76(new Splitter$$ExternalSyntheticLambda0((byte) 2, libraryParamsFromBundle), z ? (byte) 1 : (byte) 0));
                            break;
                        }
                        return true;
                    case 4002:
                        IMediaController iMediaControllerAsInterface7 = MediaControllerStub.asInterface(parcel.readStrongBinder());
                        int i9 = parcel.readInt();
                        String string2 = parcel.readString();
                        if (iMediaControllerAsInterface7 != null) {
                            if (TextUtils.isEmpty(string2)) {
                                Log.w("MediaSessionStub", "getItem(): Ignoring empty mediaId");
                                return true;
                            }
                            dispatchSessionTaskWithSessionCommand(iMediaControllerAsInterface7, i9, null, 50004, new MediaSessionStub$$ExternalSyntheticLambda76(new InnerTube$$ExternalSyntheticLambda8(string2, b2), z ? (byte) 1 : (byte) 0));
                            return true;
                        }
                        return true;
                    case 4003:
                        IMediaController iMediaControllerAsInterface8 = MediaControllerStub.asInterface(parcel.readStrongBinder());
                        int i10 = parcel.readInt();
                        String string3 = parcel.readString();
                        int i11 = parcel.readInt();
                        int i12 = parcel.readInt();
                        Bundle bundle5 = (Bundle) LifecyclesKt.readTypedObject(parcel, Bundle.CREATOR);
                        if (iMediaControllerAsInterface8 != null) {
                            if (TextUtils.isEmpty(string3)) {
                                Log.w("MediaSessionStub", "getChildren(): Ignoring empty parentId");
                            } else if (i11 < 0) {
                                Log.w("MediaSessionStub", "getChildren(): Ignoring negative page");
                            } else if (i12 < 1) {
                                Log.w("MediaSessionStub", "getChildren(): Ignoring pageSize less than 1");
                            } else {
                                if (bundle5 != null) {
                                    try {
                                        libraryParamsFromBundle = MediaLibraryService.LibraryParams.fromBundle(bundle5);
                                    } catch (RuntimeException e5) {
                                        Log.w("MediaSessionStub", "Ignoring malformed Bundle for LibraryParams", e5);
                                    }
                                }
                                dispatchSessionTaskWithSessionCommand(iMediaControllerAsInterface8, i10, null, 50003, new MediaSessionStub$$ExternalSyntheticLambda76(new MediaSessionStub$$ExternalSyntheticLambda11(string3, i11, i12, libraryParamsFromBundle), z ? (byte) 1 : (byte) 0));
                            }
                            break;
                        }
                        return true;
                    case 4004:
                        IMediaController iMediaControllerAsInterface9 = MediaControllerStub.asInterface(parcel.readStrongBinder());
                        int i13 = parcel.readInt();
                        String string4 = parcel.readString();
                        Bundle bundle6 = (Bundle) LifecyclesKt.readTypedObject(parcel, Bundle.CREATOR);
                        if (iMediaControllerAsInterface9 != null) {
                            if (TextUtils.isEmpty(string4)) {
                                Log.w("MediaSessionStub", "search(): Ignoring empty query");
                            } else {
                                if (bundle6 != null) {
                                    try {
                                        libraryParamsFromBundle = MediaLibraryService.LibraryParams.fromBundle(bundle6);
                                    } catch (RuntimeException e6) {
                                        Log.w("MediaSessionStub", "Ignoring malformed Bundle for LibraryParams", e6);
                                    }
                                }
                                dispatchSessionTaskWithSessionCommand(iMediaControllerAsInterface9, i13, null, 50005, new MediaSessionStub$$ExternalSyntheticLambda76(new MediaSessionStub$$ExternalSyntheticLambda65(string4, libraryParamsFromBundle, (byte) 2), z ? (byte) 1 : (byte) 0));
                            }
                            break;
                        }
                        return true;
                    case 4005:
                        IMediaController iMediaControllerAsInterface10 = MediaControllerStub.asInterface(parcel.readStrongBinder());
                        int i14 = parcel.readInt();
                        String string5 = parcel.readString();
                        int i15 = parcel.readInt();
                        int i16 = parcel.readInt();
                        Bundle bundle7 = (Bundle) LifecyclesKt.readTypedObject(parcel, Bundle.CREATOR);
                        if (iMediaControllerAsInterface10 != null) {
                            if (TextUtils.isEmpty(string5)) {
                                Log.w("MediaSessionStub", "getSearchResult(): Ignoring empty query");
                            } else if (i15 < 0) {
                                Log.w("MediaSessionStub", "getSearchResult(): Ignoring negative page");
                            } else if (i16 < 1) {
                                Log.w("MediaSessionStub", "getSearchResult(): Ignoring pageSize less than 1");
                            } else {
                                if (bundle7 != null) {
                                    try {
                                        libraryParamsFromBundle = MediaLibraryService.LibraryParams.fromBundle(bundle7);
                                    } catch (RuntimeException e7) {
                                        Log.w("MediaSessionStub", "Ignoring malformed Bundle for LibraryParams", e7);
                                    }
                                }
                                dispatchSessionTaskWithSessionCommand(iMediaControllerAsInterface10, i14, null, 50006, new MediaSessionStub$$ExternalSyntheticLambda76(new ExoPlayerImpl$$ExternalSyntheticLambda5(string5, i15, i16, libraryParamsFromBundle), z ? (byte) 1 : (byte) 0));
                            }
                            break;
                        }
                        return true;
                    case 4006:
                        IMediaController iMediaControllerAsInterface11 = MediaControllerStub.asInterface(parcel.readStrongBinder());
                        int i17 = parcel.readInt();
                        String string6 = parcel.readString();
                        Bundle bundle8 = (Bundle) LifecyclesKt.readTypedObject(parcel, Bundle.CREATOR);
                        if (iMediaControllerAsInterface11 != null) {
                            if (TextUtils.isEmpty(string6)) {
                                Log.w("MediaSessionStub", "subscribe(): Ignoring empty parentId");
                            } else {
                                if (bundle8 != null) {
                                    try {
                                        libraryParamsFromBundle = MediaLibraryService.LibraryParams.fromBundle(bundle8);
                                    } catch (RuntimeException e8) {
                                        Log.w("MediaSessionStub", "Ignoring malformed Bundle for LibraryParams", e8);
                                    }
                                }
                                dispatchSessionTaskWithSessionCommand(iMediaControllerAsInterface11, i17, null, 50001, new MediaSessionStub$$ExternalSyntheticLambda76(new MediaSessionStub$$ExternalSyntheticLambda65(string6, libraryParamsFromBundle, (byte) 0), z ? (byte) 1 : (byte) 0));
                            }
                            break;
                        }
                        return true;
                    case 4007:
                        IMediaController iMediaControllerAsInterface12 = MediaControllerStub.asInterface(parcel.readStrongBinder());
                        int i18 = parcel.readInt();
                        String string7 = parcel.readString();
                        if (iMediaControllerAsInterface12 != null) {
                            if (TextUtils.isEmpty(string7)) {
                                Log.w("MediaSessionStub", "unsubscribe(): Ignoring empty parentId");
                                return true;
                            }
                            dispatchSessionTaskWithSessionCommand(iMediaControllerAsInterface12, i18, null, 50002, new MediaSessionStub$$ExternalSyntheticLambda76(new InnerTube$$ExternalSyntheticLambda8(string7, b), z ? (byte) 1 : (byte) 0));
                            return true;
                        }
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void pause(IMediaController iMediaController, int i) {
        MediaSession$ControllerInfo controller;
        if (iMediaController == null || (controller = this.connectedControllersManager.getController(iMediaController.asBinder())) == null) {
            return;
        }
        queueSessionTaskWithPlayerCommandForControllerInfo(controller, i, 1, sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 12)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void play(IMediaController iMediaController, int i) {
        MediaSession$ControllerInfo controller;
        if (iMediaController == null || (controller = this.connectedControllersManager.getController(iMediaController.asBinder())) == null) {
            return;
        }
        playForControllerInfo(controller, i);
    }

    public final void playForControllerInfo(MediaSession$ControllerInfo mediaSession$ControllerInfo, int i) {
        queueSessionTaskWithPlayerCommandForControllerInfo(mediaSession$ControllerInfo, i, 1, sendSessionResultSuccess(new TextLinkScope$$ExternalSyntheticLambda10(this, mediaSession$ControllerInfo, (byte) 20)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void prepare(IMediaController iMediaController, int i) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 2, sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 27)));
    }

    public final void queueSessionTaskWithPlayerCommand(IMediaController iMediaController, int i, int i2, Splitter$$ExternalSyntheticLambda0 splitter$$ExternalSyntheticLambda0) {
        MediaSession$ControllerInfo controller = this.connectedControllersManager.getController(iMediaController.asBinder());
        if (controller != null) {
            queueSessionTaskWithPlayerCommandForControllerInfo(controller, i, i2, splitter$$ExternalSyntheticLambda0);
        }
    }

    public final void queueSessionTaskWithPlayerCommandForControllerInfo(final MediaSession$ControllerInfo mediaSession$ControllerInfo, final int i, final int i2, final SessionTask sessionTask) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            final MediaLibrarySessionImpl mediaLibrarySessionImpl = (MediaLibrarySessionImpl) this.sessionImpl.get();
            if (mediaLibrarySessionImpl != null && !mediaLibrarySessionImpl.isReleased()) {
                Util.postOrRun(mediaLibrarySessionImpl.applicationHandler, new Runnable() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda73
                    @Override // java.lang.Runnable
                    public final void run() {
                        Dispatcher dispatcher = this.f$0.connectedControllersManager;
                        final MediaSession$ControllerInfo mediaSession$ControllerInfo2 = mediaSession$ControllerInfo;
                        int i3 = i2;
                        boolean zIsPlayerCommandAvailable = dispatcher.isPlayerCommandAvailable(mediaSession$ControllerInfo2, i3);
                        final MediaLibrarySessionImpl mediaLibrarySessionImpl2 = mediaLibrarySessionImpl;
                        final int i4 = i;
                        if (!zIsPlayerCommandAvailable) {
                            MediaSessionStub.sendSessionResult(mediaLibrarySessionImpl2, mediaSession$ControllerInfo2, i4, new SessionResult(-4));
                            return;
                        }
                        MediaLibrarySessionCallback mediaLibrarySessionCallback = mediaLibrarySessionImpl2.callback$1;
                        mediaLibrarySessionImpl2.resolveControllerInfoForCallback(mediaSession$ControllerInfo2);
                        mediaLibrarySessionCallback.getClass();
                        final MediaSessionStub.SessionTask sessionTask2 = sessionTask;
                        if (i3 != 27) {
                            dispatcher.addToCommandQueue(mediaSession$ControllerInfo2, i3, new ConnectedControllersManager$AsyncCommand() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda83
                                @Override // androidx.media3.session.ConnectedControllersManager$AsyncCommand
                                public final ListenableFuture run() {
                                    return (ListenableFuture) sessionTask2.run(mediaLibrarySessionImpl2, mediaSession$ControllerInfo2, i4);
                                }
                            });
                        } else {
                            sessionTask2.run(mediaLibrarySessionImpl2, mediaSession$ControllerInfo2, i4);
                            dispatcher.addToCommandQueue(mediaSession$ControllerInfo2, i3, new MediaSessionStub$$ExternalSyntheticLambda82());
                        }
                    }
                });
            }
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void release(IMediaController iMediaController, int i) {
        if (iMediaController == null) {
            return;
        }
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaLibrarySessionImpl mediaLibrarySessionImpl = (MediaLibrarySessionImpl) this.sessionImpl.get();
            if (mediaLibrarySessionImpl != null && !mediaLibrarySessionImpl.isReleased()) {
                Util.postOrRun(mediaLibrarySessionImpl.applicationHandler, new TransactionExecutor$$ExternalSyntheticLambda0((Object) this, (Object) iMediaController, (byte) 15));
            }
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void removeMediaItem(IMediaController iMediaController, int i, int i2) {
        if (iMediaController == null || i2 < 0) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 20, new Splitter$$ExternalSyntheticLambda0((byte) 3, new MediaSessionStub$$ExternalSyntheticLambda6(this, i2, (byte) 0)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void removeMediaItems(IMediaController iMediaController, int i, int i2, int i3) {
        if (iMediaController == null || i2 < 0 || i3 < i2) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 20, new Splitter$$ExternalSyntheticLambda0((byte) 3, new MediaSessionStub$$ExternalSyntheticLambda0(this, i2, i3)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void replaceMediaItem(IMediaController iMediaController, int i, int i2, Bundle bundle) {
        MediaSession$ControllerInfo controller;
        if (iMediaController == null || bundle == null || i2 < 0 || (controller = this.connectedControllersManager.getController(iMediaController.asBinder())) == null) {
            return;
        }
        try {
            byte b = 1;
            queueSessionTaskWithPlayerCommandForControllerInfo(controller, i, 20, new MediaSessionStub$$ExternalSyntheticLambda76(new TextLinkScope$$ExternalSyntheticLambda10(new MediaSessionStub$$ExternalSyntheticLambda23(MediaItem.fromBundle(controller.interfaceVersion, bundle), b), new MediaSessionStub$$ExternalSyntheticLambda6(this, i2, (byte) 3), (byte) 23), b));
        } catch (RuntimeException e) {
            Log.w("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void replaceMediaItems(IMediaController iMediaController, int i, int i2, int i3, IBinder iBinder) {
        MediaSession$ControllerInfo controller;
        if (iMediaController == null || iBinder == null || i2 < 0 || i3 < i2 || (controller = this.connectedControllersManager.getController(iMediaController.asBinder())) == null) {
            return;
        }
        try {
            ImmutableList list = BundleListRetriever.getList(iBinder);
            ImmutableList.Builder builder = ImmutableList.builder();
            for (int i4 = 0; i4 < list.size(); i4++) {
                Bundle bundle = (Bundle) list.get(i4);
                bundle.getClass();
                builder.add((Object) MediaItem.fromBundle(controller.interfaceVersion, bundle));
            }
            queueSessionTaskWithPlayerCommandForControllerInfo(controller, i, 20, new MediaSessionStub$$ExternalSyntheticLambda76(new TextLinkScope$$ExternalSyntheticLambda10(new MediaSessionImpl$$ExternalSyntheticLambda1(builder.build()), new MediaSessionStub$$ExternalSyntheticLambda0(this, i2, i3), (byte) 23), (byte) 1));
        } catch (RuntimeException e) {
            Log.w("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void seekBack(IMediaController iMediaController, int i) {
        MediaSession$ControllerInfo controller;
        if (iMediaController == null || (controller = this.connectedControllersManager.getController(iMediaController.asBinder())) == null) {
            return;
        }
        queueSessionTaskWithPlayerCommandForControllerInfo(controller, i, 11, sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 15)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void seekForward(IMediaController iMediaController, int i) {
        MediaSession$ControllerInfo controller;
        if (iMediaController == null || (controller = this.connectedControllersManager.getController(iMediaController.asBinder())) == null) {
            return;
        }
        queueSessionTaskWithPlayerCommandForControllerInfo(controller, i, 12, sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 18)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void seekTo(IMediaController iMediaController, int i, long j) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 5, sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda68(j)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void seekToDefaultPosition(IMediaController iMediaController, int i) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 4, sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 26)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void seekToDefaultPositionWithMediaItemIndex(IMediaController iMediaController, int i, int i2) {
        if (iMediaController == null || i2 < 0) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 10, new Splitter$$ExternalSyntheticLambda0((byte) 3, new MediaSessionStub$$ExternalSyntheticLambda6(this, i2, (byte) 1)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void seekToNext(IMediaController iMediaController, int i) {
        MediaSession$ControllerInfo controller;
        if (iMediaController == null || (controller = this.connectedControllersManager.getController(iMediaController.asBinder())) == null) {
            return;
        }
        queueSessionTaskWithPlayerCommandForControllerInfo(controller, i, 9, sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 19)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void seekToNextMediaItem(IMediaController iMediaController, int i) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 8, sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 13)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void seekToPrevious(IMediaController iMediaController, int i) {
        MediaSession$ControllerInfo controller;
        if (iMediaController == null || (controller = this.connectedControllersManager.getController(iMediaController.asBinder())) == null) {
            return;
        }
        queueSessionTaskWithPlayerCommandForControllerInfo(controller, i, 7, sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 16)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void seekToPreviousMediaItem(IMediaController iMediaController, int i) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 6, sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 17)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void seekToWithMediaItemIndex(IMediaController iMediaController, int i, int i2, long j) {
        if (iMediaController == null || i2 < 0) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 10, new Splitter$$ExternalSyntheticLambda0((byte) 3, new MediaSessionStub$$ExternalSyntheticLambda20(i2, j, this)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setAudioAttributes(IMediaController iMediaController, int i, Bundle bundle, boolean z) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            queueSessionTaskWithPlayerCommand(iMediaController, i, 35, sendSessionResultSuccess(new ExoPlayerImpl$$ExternalSyntheticLambda0(AudioAttributes.fromBundle(bundle), z, (byte) 2)));
        } catch (RuntimeException e) {
            Log.w("MediaSessionStub", "Ignoring malformed Bundle for AudioAttributes", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setDeviceMuted(IMediaController iMediaController, int i, boolean z) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 26, sendSessionResultSuccess(new ExoPlayerImpl$$ExternalSyntheticLambda14((byte) 5, z)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setDeviceMutedWithFlags(IMediaController iMediaController, int i, boolean z, int i2) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 34, sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda62(z, i2)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setDeviceVolume(IMediaController iMediaController, int i, int i2) {
        if (iMediaController == null || i2 < 0) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 25, sendSessionResultSuccess(new UCropActivity$$ExternalSyntheticLambda1((byte) 9, i2)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2, int i3) {
        if (iMediaController == null || i2 < 0) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 33, sendSessionResultSuccess(new ExoPlayerImpl$$ExternalSyntheticLambda24(i2, i3, (byte) 4)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setMediaItem(IMediaController iMediaController, int i, Bundle bundle) {
        setMediaItemWithResetPosition(iMediaController, i, bundle, true);
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setMediaItemWithResetPosition(IMediaController iMediaController, int i, Bundle bundle, boolean z) {
        MediaSession$ControllerInfo controller;
        if (iMediaController == null || bundle == null || (controller = this.connectedControllersManager.getController(iMediaController.asBinder())) == null) {
            return;
        }
        try {
            byte b = 1;
            queueSessionTaskWithPlayerCommandForControllerInfo(controller, i, 31, new MediaSessionStub$$ExternalSyntheticLambda76(new TextLinkScope$$ExternalSyntheticLambda10(new ExoPlayerImpl$$ExternalSyntheticLambda0(MediaItem.fromBundle(controller.interfaceVersion, bundle), z, b), new MediaSessionStub$$ExternalSyntheticLambda8((byte) 0), (byte) 22), b));
        } catch (RuntimeException e) {
            Log.w("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setMediaItemWithStartPosition(IMediaController iMediaController, int i, Bundle bundle, long j) {
        MediaSession$ControllerInfo controller;
        if (iMediaController == null || bundle == null || (controller = this.connectedControllersManager.getController(iMediaController.asBinder())) == null) {
            return;
        }
        try {
            queueSessionTaskWithPlayerCommandForControllerInfo(controller, i, 31, new MediaSessionStub$$ExternalSyntheticLambda76(new TextLinkScope$$ExternalSyntheticLambda10(new MediaSessionStub$$ExternalSyntheticLambda64(j, MediaItem.fromBundle(controller.interfaceVersion, bundle)), new MediaSessionStub$$ExternalSyntheticLambda8((byte) 0), (byte) 22), (byte) 1));
        } catch (RuntimeException e) {
            Log.w("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setMediaItemsWithResetPosition(IMediaController iMediaController, int i, IBinder iBinder, boolean z) {
        MediaSession$ControllerInfo controller;
        if (iMediaController == null || iBinder == null || (controller = this.connectedControllersManager.getController(iMediaController.asBinder())) == null) {
            return;
        }
        try {
            ImmutableList list = BundleListRetriever.getList(iBinder);
            ImmutableList.Builder builder = ImmutableList.builder();
            byte b = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                Bundle bundle = (Bundle) list.get(i2);
                bundle.getClass();
                builder.add((Object) MediaItem.fromBundle(controller.interfaceVersion, bundle));
            }
            queueSessionTaskWithPlayerCommandForControllerInfo(controller, i, 20, new MediaSessionStub$$ExternalSyntheticLambda76(new TextLinkScope$$ExternalSyntheticLambda10(new ExoPlayerImpl$$ExternalSyntheticLambda0(builder.build(), z, (byte) 3), new MediaSessionStub$$ExternalSyntheticLambda8(b), (byte) 22), (byte) 1));
        } catch (RuntimeException e) {
            Log.w("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setMediaItemsWithStartIndex(IMediaController iMediaController, int i, IBinder iBinder, int i2, long j) {
        MediaSession$ControllerInfo controller;
        if (iMediaController == null || iBinder == null) {
            return;
        }
        if ((i2 == -1 || i2 >= 0) && (controller = this.connectedControllersManager.getController(iMediaController.asBinder())) != null) {
            try {
                ImmutableList list = BundleListRetriever.getList(iBinder);
                ImmutableList.Builder builder = ImmutableList.builder();
                byte b = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    Bundle bundle = (Bundle) list.get(i3);
                    bundle.getClass();
                    builder.add((Object) MediaItem.fromBundle(controller.interfaceVersion, bundle));
                }
                queueSessionTaskWithPlayerCommandForControllerInfo(controller, i, 20, new MediaSessionStub$$ExternalSyntheticLambda76(new TextLinkScope$$ExternalSyntheticLambda10(new MediaSessionStub$$ExternalSyntheticLambda20(i2, j, builder.build()), new MediaSessionStub$$ExternalSyntheticLambda8(b), (byte) 22), (byte) 1));
            } catch (RuntimeException e) {
                Log.w("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e);
            }
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setPlayWhenReady(IMediaController iMediaController, int i, boolean z) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 1, sendSessionResultSuccess(new ExoPlayerImpl$$ExternalSyntheticLambda14((byte) 4, z)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setPlaybackParameters(IMediaController iMediaController, int i, Bundle bundle) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            queueSessionTaskWithPlayerCommand(iMediaController, i, 13, sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda33(new PlaybackParameters(bundle.getFloat(PlaybackParameters.FIELD_SPEED, 1.0f), bundle.getFloat(PlaybackParameters.FIELD_PITCH, 1.0f)), (byte) 0)));
        } catch (RuntimeException e) {
            Log.w("MediaSessionStub", "Ignoring malformed Bundle for PlaybackParameters", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setPlaybackSpeed(IMediaController iMediaController, int i, float f) {
        if (iMediaController == null || f <= CropImageView.DEFAULT_ASPECT_RATIO) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 13, sendSessionResultSuccess(new ExoPlayerImpl$$ExternalSyntheticLambda15(f, (byte) 3)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setPlaylistMetadata(IMediaController iMediaController, int i, Bundle bundle) {
        MediaSession$ControllerInfo controller;
        if (iMediaController == null || bundle == null || (controller = this.connectedControllersManager.getController(iMediaController.asBinder())) == null) {
            return;
        }
        try {
            queueSessionTaskWithPlayerCommandForControllerInfo(controller, i, 19, sendSessionResultSuccess(new ExoPlayerImpl$$ExternalSyntheticLambda10(MediaMetadata.fromBundle(controller.interfaceVersion, bundle), (byte) 2)));
        } catch (RuntimeException e) {
            Log.w("MediaSessionStub", "Ignoring malformed Bundle for MediaMetadata", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setRepeatMode(IMediaController iMediaController, int i, int i2) {
        if (iMediaController == null) {
            return;
        }
        if (i2 == 2 || i2 == 0 || i2 == 1) {
            queueSessionTaskWithPlayerCommand(iMediaController, i, 15, sendSessionResultSuccess(new UCropActivity$$ExternalSyntheticLambda1((byte) 8, i2)));
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setShuffleModeEnabled(IMediaController iMediaController, int i, boolean z) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 14, sendSessionResultSuccess(new ExoPlayerImpl$$ExternalSyntheticLambda14((byte) 6, z)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setTrackSelectionParameters(IMediaController iMediaController, int i, Bundle bundle) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            queueSessionTaskWithPlayerCommand(iMediaController, i, 29, sendSessionResultSuccess(new TextLinkScope$$ExternalSyntheticLambda10(this, TrackSelectionParameters.fromBundle(bundle), (byte) 18)));
        } catch (RuntimeException e) {
            Log.w("MediaSessionStub", "Ignoring malformed Bundle for TrackSelectionParameters", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setVideoSurface(IMediaController iMediaController, int i, Surface surface) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 27, sendSessionResultSuccess(new TextLinkScope$$ExternalSyntheticLambda10(this, surface, (byte) 21)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setVideoSurfaceWithSize(IMediaController iMediaController, int i, Surface surface, int i2, int i3) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 27, sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda11(this, surface, i2, i3, (byte) 3)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void setVolume(IMediaController iMediaController, int i, float f) {
        if (iMediaController == null || f < CropImageView.DEFAULT_ASPECT_RATIO || f > 1.0f) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 24, sendSessionResultSuccess(new ExoPlayerImpl$$ExternalSyntheticLambda15(f, (byte) 4)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void stop(IMediaController iMediaController, int i) {
        MediaSession$ControllerInfo controller;
        if (iMediaController == null || (controller = this.connectedControllersManager.getController(iMediaController.asBinder())) == null) {
            return;
        }
        queueSessionTaskWithPlayerCommandForControllerInfo(controller, i, 3, sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 24)));
    }

    @Override // androidx.media3.session.IMediaSession
    public final void unmute(IMediaController iMediaController, int i) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 24, sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 25)));
    }

    public final PlayerInfo updatePlayerInfoWithUniqueTrackGroupIds(PlayerInfo playerInfo) {
        ImmutableList immutableList = playerInfo.currentTracks.groups;
        ImmutableBiMap.Builder builder = new ImmutableBiMap.Builder(4);
        StatusLine statusLine = new StatusLine(4);
        for (int i = 0; i < immutableList.size(); i++) {
            TrackGroup trackGroup = ((Tracks.Group) immutableList.get(i)).mediaTrackGroup;
            String str = trackGroup.id;
            String string = (String) this.trackGroupIdMap.get(trackGroup);
            if (string == null) {
                StringBuilder sb = new StringBuilder();
                int i2 = this.nextUniqueTrackGroupIdPrefix;
                this.nextUniqueTrackGroupIdPrefix = i2 + 1;
                String str2 = Util.DEVICE_DEBUG_INFO;
                sb.append(Integer.toString(i2, 36));
                sb.append("-");
                sb.append(str);
                string = sb.toString();
            }
            builder.put(trackGroup, string);
            statusLine.put(str, string);
        }
        this.trackGroupIdMap = builder.code == 0 ? RegularImmutableBiMap.EMPTY : new RegularImmutableBiMap(builder.code, (Object[]) builder.protocol);
        this.trackGroupOriginalToUniqueIdMap = statusLine.build(false);
        ImmutableList.Builder builder2 = ImmutableList.builder();
        for (int i3 = 0; i3 < immutableList.size(); i3++) {
            Tracks.Group group = (Tracks.Group) immutableList.get(i3);
            builder2.add((Object) new Tracks.Group(updateTrackGroupWithUniqueIds(group.mediaTrackGroup), group.adaptiveSupported, group.trackSupport, group.trackSelected));
        }
        PlayerInfo playerInfoCopyWithCurrentTracks = playerInfo.copyWithCurrentTracks(new Tracks(builder2.build()));
        TrackSelectionParameters trackSelectionParameters = playerInfoCopyWithCurrentTracks.trackSelectionParameters;
        if (trackSelectionParameters.overrides.isEmpty()) {
            return playerInfoCopyWithCurrentTracks;
        }
        TrackSelectionParameters.Builder builderClearOverrides = trackSelectionParameters.buildUpon().clearOverrides();
        UnmodifiableIterator it = trackSelectionParameters.overrides.values().iterator();
        while (it.hasNext()) {
            TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) it.next();
            builderClearOverrides.addOverride(new TrackSelectionOverride(updateTrackGroupWithUniqueIds(trackSelectionOverride.mediaTrackGroup), trackSelectionOverride.trackIndices));
        }
        return playerInfoCopyWithCurrentTracks.copyWithTrackSelectionParameters(builderClearOverrides.build());
    }

    public final TrackGroup updateTrackGroupWithUniqueIds(TrackGroup trackGroup) {
        int i = trackGroup.length;
        String str = (String) this.trackGroupIdMap.get(trackGroup);
        if (str == null) {
            str = trackGroup.id;
        }
        int i2 = 0;
        while (true) {
            Format[] formatArr = trackGroup.formats;
            if (i2 >= i) {
                return new TrackGroup(str, formatArr);
            }
            if (formatArr[i2].primaryTrackGroupId != null) {
                Format[] formatArr2 = new Format[i];
                for (int i3 = 0; i3 < i; i3++) {
                    Format format = formatArr[i3];
                    String str2 = format.primaryTrackGroupId;
                    String str3 = str2 != null ? (String) this.trackGroupOriginalToUniqueIdMap.get(str2) : null;
                    if (str3 != null) {
                        Format.Builder builderBuildUpon = format.buildUpon();
                        builderBuildUpon.primaryTrackGroupId = str3;
                        formatArr2[i3] = new Format(builderBuildUpon);
                    } else {
                        formatArr2[i3] = format;
                    }
                }
                return new TrackGroup(str, formatArr2);
            }
            i2++;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SurfaceHolderWithSize implements SurfaceHolder {
        public SurfaceHolder.Callback callback;
        public final Surface surface;
        public final Rect surfaceFrame;

        public SurfaceHolderWithSize(Surface surface, int i, int i2) {
            Rect rect = new Rect();
            this.surfaceFrame = rect;
            this.surface = surface;
            rect.set(0, 0, i, i2);
        }

        @Override // android.view.SurfaceHolder
        public final void addCallback(SurfaceHolder.Callback callback) {
            this.callback = callback;
        }

        @Override // android.view.SurfaceHolder
        public final Surface getSurface() {
            return this.surface;
        }

        @Override // android.view.SurfaceHolder
        public final Rect getSurfaceFrame() {
            return this.surfaceFrame;
        }

        @Override // android.view.SurfaceHolder
        public final boolean isCreating() {
            return false;
        }

        @Override // android.view.SurfaceHolder
        public final Canvas lockCanvas() {
            throw new UnsupportedOperationException();
        }

        @Override // android.view.SurfaceHolder
        public final void removeCallback(SurfaceHolder.Callback callback) {
            if (this.callback == callback) {
                this.callback = null;
            }
        }

        @Override // android.view.SurfaceHolder
        public final void setFixedSize(int i, int i2) {
            this.surfaceFrame.set(0, 0, i, i2);
            SurfaceHolder.Callback callback = this.callback;
            if (callback != null) {
                callback.surfaceChanged(this, 1, i, i2);
            }
        }

        @Override // android.view.SurfaceHolder
        public final Canvas lockCanvas(Rect rect) {
            throw new UnsupportedOperationException();
        }

        public SurfaceHolderWithSize(Surface surface) {
            this.surfaceFrame = new Rect();
            this.surface = surface;
        }

        @Override // android.view.SurfaceHolder
        public final void setSizeFromLayout() {
        }

        @Override // android.view.SurfaceHolder
        public final void setFormat(int i) {
        }

        @Override // android.view.SurfaceHolder
        public final void setKeepScreenOn(boolean z) {
        }

        @Override // android.view.SurfaceHolder
        public final void setType(int i) {
        }

        @Override // android.view.SurfaceHolder
        public final void unlockCanvasAndPost(Canvas canvas) {
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    public final void connect(IMediaController iMediaController, MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        if (iMediaController != null) {
            MediaLibrarySessionImpl mediaLibrarySessionImpl = (MediaLibrarySessionImpl) this.sessionImpl.get();
            if (mediaLibrarySessionImpl != null && !mediaLibrarySessionImpl.isReleased()) {
                this.pendingControllers.add(mediaSession$ControllerInfo);
                Util.postOrRun(mediaLibrarySessionImpl.applicationHandler, new MediaSessionStub$$ExternalSyntheticLambda3((Object) this, (Object) mediaSession$ControllerInfo, (Object) mediaLibrarySessionImpl, (Object) iMediaController, (byte) 0));
                return;
            } else {
                SQLite.disconnectIMediaController(iMediaController);
                return;
            }
        }
        SQLite.disconnectIMediaController(iMediaController);
    }
}
