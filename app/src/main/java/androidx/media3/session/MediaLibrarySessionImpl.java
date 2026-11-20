package androidx.media3.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.node.NodeChain;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.app.ActivityRecreator;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.FlagSet;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.BitmapLoader;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.NetworkTypeObserver;
import androidx.media3.common.util.Util;
import androidx.media3.common.util.Util$$ExternalSyntheticLambda1;
import androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda24;
import androidx.media3.extractor.mp4.BoxParser;
import androidx.media3.session.legacy.MediaControllerCompat$MediaControllerImplApi23;
import androidx.media3.session.legacy.MediaSessionCompat$MediaSessionImplApi23;
import androidx.room.TransactionExecutor$$ExternalSyntheticLambda0;
import coil3.util.UtilsKt;
import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.math.IntMath;
import com.google.common.util.concurrent.AbstractCatchingFuture$CatchingFuture;
import com.google.common.util.concurrent.AbstractTransformFuture$TransformFuture;
import com.google.common.util.concurrent.DirectExecutor;
import com.google.common.util.concurrent.ImmediateFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.metrolist.music.App;
import com.metrolist.music.constants.MediaSessionConstants;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.playback.MediaLibrarySessionCallback;
import com.metrolist.music.playback.MediaLibrarySessionCallback$onGetChildren$1;
import com.metrolist.music.playback.MediaLibrarySessionCallback$onGetSearchResult$1;
import com.metrolist.music.playback.MediaLibrarySessionCallback$onSetMediaItems$1;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import kotlin.collections.EmptyList;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.guava.JobListenableFuture;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.connection.FastFallbackExchangeFinder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaLibrarySessionImpl {
    public static final SessionResult RESULT_WHEN_CLOSED = new SessionResult(1);
    public static final Supplier mediaMetadataBitmapMaxSize = DatabaseDao_Impl.AnonymousClass17.memoize(new MediaSessionImpl$$ExternalSyntheticLambda15(0));
    public final Handler applicationHandler;
    public final BitmapLoader bitmapLoader;
    public MediaLibraryServiceLegacyStub browserServiceLegacyStub;
    public final MediaLibrarySessionCallback callback;
    public final MediaLibrarySessionCallback callback$1;
    public boolean closed;
    public final ImmutableList commandButtonsForMediaItems;
    public final Context context;
    public final HashMultimap controllerToSubscribedParentIds;
    public ImmutableList customLayout;
    public final MediaLibraryService.MediaLibrarySession instance;
    public final MediaLibraryService.MediaLibrarySession instance$1;
    public boolean isMediaNotificationControllerConnected;
    public final boolean isPeriodicPositionUpdateEnabled;
    public final byte libraryErrorReplicationMode;
    public final Object lock = new Object();
    public final Handler mainHandler;
    public final ImmutableList mediaButtonPreferences;
    public final MediaSessionImpl$MediaPlayPauseKeyHandler mediaPlayPauseKeyHandler;
    public DefaultActionFactory mediaSessionListener;
    public final MediaSessionImpl$PlayerInfoChangedHandler onPlayerInfoChangedHandler;
    public final HashMultimap parentIdToSubscribedControllers;
    public final MediaSessionImpl$$ExternalSyntheticLambda0 periodicSessionPositionInfoUpdateRunnable;
    public final boolean playIfSuppressed;
    public PlayerInfo playerInfo;
    public MediaSessionImpl$PlayerListener playerListener;
    public PlayerWrapper playerWrapper;
    public final PendingIntent sessionActivity;
    public final Bundle sessionExtras;
    public final String sessionId;
    public final MediaSessionLegacyStub sessionLegacyStub;
    public final short sessionPositionUpdateDelayMs;
    public final MediaSessionStub sessionStub;
    public final SessionToken sessionToken;
    public final Uri sessionUri;

    /* JADX WARN: Multi-variable type inference failed */
    public MediaLibrarySessionImpl(MediaLibraryService.MediaLibrarySession mediaLibrarySession, Context context, String str, Player player, PendingIntent pendingIntent, ImmutableList immutableList, ImmutableList immutableList2, ImmutableList immutableList3, MediaLibrarySessionCallback mediaLibrarySessionCallback, Bundle bundle, Bundle bundle2, BitmapLoader bitmapLoader, boolean z, boolean z2, int i) {
        Log.i("MediaSessionImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.10.1] [" + Util.DEVICE_DEBUG_INFO + "]");
        this.instance$1 = mediaLibrarySession;
        this.context = context;
        this.sessionId = str;
        this.sessionActivity = pendingIntent;
        this.customLayout = immutableList;
        this.mediaButtonPreferences = immutableList2;
        this.commandButtonsForMediaItems = immutableList3;
        this.callback$1 = mediaLibrarySessionCallback;
        this.sessionExtras = bundle2;
        this.bitmapLoader = bitmapLoader;
        this.playIfSuppressed = z;
        this.isPeriodicPositionUpdateEnabled = z2;
        MediaSessionStub mediaSessionStub = new MediaSessionStub(this);
        this.sessionStub = mediaSessionStub;
        this.mainHandler = new Handler(Looper.getMainLooper());
        Looper applicationLooper = player.getApplicationLooper();
        Handler handler = new Handler(applicationLooper);
        this.applicationHandler = handler;
        this.playerInfo = PlayerInfo.DEFAULT;
        this.onPlayerInfoChangedHandler = new MediaSessionImpl$PlayerInfoChangedHandler(this, applicationLooper);
        this.mediaPlayPauseKeyHandler = new MediaSessionImpl$MediaPlayPauseKeyHandler(this, applicationLooper);
        Uri uriCreateSessionUri = createSessionUri(str);
        this.sessionUri = uriCreateSessionUri;
        MediaSessionLegacyStub mediaSessionLegacyStub = new MediaSessionLegacyStub(this, uriCreateSessionUri, handler, bundle, z, immutableList, immutableList2, MediaSession$ConnectionResult.DEFAULT_SESSION_AND_LIBRARY_COMMANDS, MediaSession$ConnectionResult.DEFAULT_PLAYER_COMMANDS, bundle2);
        this.sessionLegacyStub = mediaSessionLegacyStub;
        this.sessionToken = new SessionToken(Process.myUid(), 1010001300, 9, context.getPackageName(), mediaSessionStub, bundle, ((MediaSessionCompat$MediaSessionImplApi23) mediaSessionLegacyStub.sessionCompat.mCallback).token.inner);
        PlayerWrapper playerWrapper = new PlayerWrapper(player);
        this.playerWrapper = playerWrapper;
        Util.postOrRun(handler, new TransactionExecutor$$ExternalSyntheticLambda0((Object) this, (Object) playerWrapper, (byte) 11));
        this.sessionPositionUpdateDelayMs = (short) 3000;
        this.periodicSessionPositionInfoUpdateRunnable = new MediaSessionImpl$$ExternalSyntheticLambda0(this, (byte) 2);
        Util.postOrRun(handler, new MediaSessionImpl$$ExternalSyntheticLambda0(this, (byte) 3));
        this.instance = mediaLibrarySession;
        this.callback = mediaLibrarySessionCallback;
        this.libraryErrorReplicationMode = i;
        this.parentIdToSubscribedControllers = new HashMultimap();
        this.controllerToSubscribedParentIds = new HashMultimap();
    }

    public static Uri createSessionUri(String str) {
        Uri.Builder builderAuthority = new Uri.Builder().scheme("androidx").authority("media3.session");
        if (str == null) {
            str = "";
        }
        return builderAuthority.appendPath(str).build();
    }

    public static boolean isSystemUiController(MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        return mediaSession$ControllerInfo != null && Objects.equals(mediaSession$ControllerInfo.remoteUserInfo.impl.packageName, "com.android.systemui");
    }

    public static /* synthetic */ LibraryResult lambda$getRecentMediaItemAtDeviceBootTime$8(MediaLibraryService.LibraryParams libraryParams, MediaSession$MediaItemsWithStartPosition mediaSession$MediaItemsWithStartPosition) {
        ImmutableList immutableList = mediaSession$MediaItemsWithStartPosition.mediaItems;
        return immutableList.isEmpty() ? LibraryResult.ofError(-2, libraryParams) : LibraryResult.ofItemList(ImmutableList.of(immutableList.get(Math.max(0, Math.min(mediaSession$MediaItemsWithStartPosition.startIndex, immutableList.size() - 1)))), libraryParams);
    }

    public static Object tryGetFutureResult(Future future) {
        UtilsKt.checkState(future.isDone());
        try {
            return future.get();
        } catch (InterruptedException | CancellationException | ExecutionException e) {
            Log.w("MediaSessionImpl", "Library operation failed", e);
            return null;
        }
    }

    public static void verifyResultItems(int i, LibraryResult libraryResult) {
        if (libraryResult.resultCode == 0) {
            ImmutableList immutableList = (ImmutableList) libraryResult.value;
            immutableList.getClass();
            if (immutableList.size() <= i) {
                return;
            }
            throw new IllegalStateException("Invalid size=" + immutableList.size() + ", pageSize=" + i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:25:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0065  */
    /* JADX WARN: Code duplicated, block: B:30:0x006d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0073  */
    public final boolean applyMediaButtonKeyEvent(KeyEvent keyEvent, boolean z, final boolean z2) {
        final MediaSessionImpl$$ExternalSyntheticLambda5 mediaSessionImpl$$ExternalSyntheticLambda5;
        final MediaSession$ControllerInfo mediaNotificationControllerInfo = this.instance$1.impl.getMediaNotificationControllerInfo();
        byte b = 0;
        if (mediaNotificationControllerInfo != null) {
            int keyCode = keyEvent.getKeyCode();
            if ((keyCode == 85 || keyCode == 79) && z) {
                keyCode = 87;
            }
            if (keyCode == 79) {
                if (!this.playerWrapper.getPlayWhenReady()) {
                    mediaSessionImpl$$ExternalSyntheticLambda5 = new MediaSessionImpl$$ExternalSyntheticLambda5(this, mediaNotificationControllerInfo, b);
                } else {
                    mediaSessionImpl$$ExternalSyntheticLambda5 = new MediaSessionImpl$$ExternalSyntheticLambda5(this, mediaNotificationControllerInfo, (byte) 6);
                }
            } else if (keyCode == 126) {
                mediaSessionImpl$$ExternalSyntheticLambda5 = new MediaSessionImpl$$ExternalSyntheticLambda5(this, mediaNotificationControllerInfo, (byte) 7);
            } else if (keyCode == 127) {
                mediaSessionImpl$$ExternalSyntheticLambda5 = new MediaSessionImpl$$ExternalSyntheticLambda5(this, mediaNotificationControllerInfo, (byte) 8);
            } else if (keyCode == 272) {
                mediaSessionImpl$$ExternalSyntheticLambda5 = new MediaSessionImpl$$ExternalSyntheticLambda5(this, mediaNotificationControllerInfo, (byte) 9);
            } else if (keyCode != 273) {
                switch (keyCode) {
                    case 85:
                        if (!this.playerWrapper.getPlayWhenReady()) {
                            mediaSessionImpl$$ExternalSyntheticLambda5 = new MediaSessionImpl$$ExternalSyntheticLambda5(this, mediaNotificationControllerInfo, (byte) 6);
                        } else {
                            mediaSessionImpl$$ExternalSyntheticLambda5 = new MediaSessionImpl$$ExternalSyntheticLambda5(this, mediaNotificationControllerInfo, b);
                        }
                        break;
                    case 86:
                        mediaSessionImpl$$ExternalSyntheticLambda5 = new MediaSessionImpl$$ExternalSyntheticLambda5(this, mediaNotificationControllerInfo, (byte) 5);
                        break;
                    case 87:
                        mediaSessionImpl$$ExternalSyntheticLambda5 = new MediaSessionImpl$$ExternalSyntheticLambda5(this, mediaNotificationControllerInfo, (byte) 9);
                        break;
                    case 88:
                        mediaSessionImpl$$ExternalSyntheticLambda5 = new MediaSessionImpl$$ExternalSyntheticLambda5(this, mediaNotificationControllerInfo, (byte) 2);
                        break;
                    case 89:
                        mediaSessionImpl$$ExternalSyntheticLambda5 = new MediaSessionImpl$$ExternalSyntheticLambda5(this, mediaNotificationControllerInfo, (byte) 4);
                        break;
                    case 90:
                        mediaSessionImpl$$ExternalSyntheticLambda5 = new MediaSessionImpl$$ExternalSyntheticLambda5(this, mediaNotificationControllerInfo, (byte) 3);
                        break;
                }
            } else {
                mediaSessionImpl$$ExternalSyntheticLambda5 = new MediaSessionImpl$$ExternalSyntheticLambda5(this, mediaNotificationControllerInfo, (byte) 2);
            }
            Util.postOrRun(this.applicationHandler, new Runnable() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    int i;
                    MediaLibrarySessionImpl mediaLibrarySessionImpl = this.f$0;
                    MediaSessionStub mediaSessionStub = mediaLibrarySessionImpl.sessionStub;
                    boolean z3 = z2;
                    MediaSession$ControllerInfo mediaSession$ControllerInfo = mediaNotificationControllerInfo;
                    if (z3) {
                        SessionCommand sessionCommand = new SessionCommand("androidx.media3.session.NOTIFICATION_DISMISSED_EVENT_KEY", Bundle.EMPTY);
                        try {
                            NodeChain.Differ sequencedFutureManager = mediaSessionStub.connectedControllersManager.getSequencedFutureManager(mediaSession$ControllerInfo);
                            if (sequencedFutureManager != null) {
                                i = sequencedFutureManager.createSequencedFuture(MediaLibrarySessionImpl.RESULT_WHEN_CLOSED).sequenceNumber;
                            } else if (mediaLibrarySessionImpl.isConnected(mediaSession$ControllerInfo)) {
                                UuidKt.immediateFuture(new SessionResult(0));
                                i = 0;
                            } else {
                                UuidKt.immediateFuture(new SessionResult(-100));
                            }
                            MediaSession$ControllerCb mediaSession$ControllerCb = mediaSession$ControllerInfo.controllerCb;
                            if (mediaSession$ControllerCb != null) {
                                mediaSession$ControllerCb.sendCustomCommand(i, sessionCommand);
                            }
                        } catch (DeadObjectException unused) {
                            mediaSessionStub.connectedControllersManager.removeController(mediaSession$ControllerInfo);
                            UuidKt.immediateFuture(new SessionResult(-100));
                        } catch (RemoteException e) {
                            Log.w("MediaSessionImpl", "Exception in " + mediaSession$ControllerInfo, e);
                            UuidKt.immediateFuture(new SessionResult(-1));
                        }
                    }
                    mediaSessionImpl$$ExternalSyntheticLambda5.run();
                    mediaSessionStub.connectedControllersManager.flushCommandQueue(mediaSession$ControllerInfo);
                }
            });
            return true;
        }
        return false;
    }

    public final void dispatchRemoteControllerTaskWithoutReturn(MediaSession$ControllerInfo mediaSession$ControllerInfo, MediaSessionImpl$RemoteControllerTask mediaSessionImpl$RemoteControllerTask) {
        int iObtainNextSequenceNumber;
        MediaSessionStub mediaSessionStub = this.sessionStub;
        try {
            NodeChain.Differ sequencedFutureManager = mediaSessionStub.connectedControllersManager.getSequencedFutureManager(mediaSession$ControllerInfo);
            if (sequencedFutureManager != null) {
                iObtainNextSequenceNumber = sequencedFutureManager.obtainNextSequenceNumber();
            } else if (!isConnected(mediaSession$ControllerInfo)) {
                return;
            } else {
                iObtainNextSequenceNumber = 0;
            }
            MediaSession$ControllerCb mediaSession$ControllerCb = mediaSession$ControllerInfo.controllerCb;
            if (mediaSession$ControllerCb != null) {
                mediaSessionImpl$RemoteControllerTask.run(mediaSession$ControllerCb, iObtainNextSequenceNumber);
            }
        } catch (DeadObjectException unused) {
            mediaSessionStub.connectedControllersManager.removeController(mediaSession$ControllerInfo);
        } catch (RemoteException e) {
            Log.w("MediaSessionImpl", "Exception in " + mediaSession$ControllerInfo, e);
        }
    }

    public final MediaSession$ControllerInfo getMediaNotificationControllerInfo() {
        ImmutableList connectedControllers = this.sessionStub.connectedControllersManager.getConnectedControllers();
        for (int i = 0; i < connectedControllers.size(); i++) {
            MediaSession$ControllerInfo mediaSession$ControllerInfo = (MediaSession$ControllerInfo) connectedControllers.get(i);
            if (isMediaNotificationController(mediaSession$ControllerInfo)) {
                return mediaSession$ControllerInfo;
            }
        }
        return null;
    }

    public final void handleAvailablePlayerCommandsChanged(Player.Commands commands) {
        this.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(false, false);
        dispatchRemoteControllerTaskWithoutReturn(new MediaSessionImpl$$ExternalSyntheticLambda17(commands));
        try {
            FastFallbackExchangeFinder fastFallbackExchangeFinder = this.sessionLegacyStub.controllerLegacyCbForBroadcast;
            DeviceInfo deviceInfo = this.playerInfo.deviceInfo;
            fastFallbackExchangeFinder.onDeviceInfoChanged();
        } catch (RemoteException e) {
            Log.e("MediaSessionImpl", "Exception in using media1 API", e);
        }
    }

    public final void handleMediaControllerPlayRequest(MediaSession$ControllerInfo mediaSession$ControllerInfo, boolean z) {
        if (onPlayRequested()) {
            byte b = 1;
            boolean z2 = this.playerWrapper.isCommandAvailable(16) && this.playerWrapper.getCurrentMediaItem() != null;
            boolean z3 = this.playerWrapper.isCommandAvailable(31) || this.playerWrapper.isCommandAvailable(20);
            MediaSession$ControllerInfo mediaSession$ControllerInfoResolveControllerInfoForCallback = resolveControllerInfoForCallback(mediaSession$ControllerInfo);
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
            UtilsKt.checkState(!false);
            sparseBooleanArray.append(1, true);
            UtilsKt.checkState(!false);
            Player.Commands commands = new Player.Commands(new FlagSet(sparseBooleanArray));
            if (z2 || !z3) {
                if (!z2) {
                    Log.w("MediaSessionImpl", "Play requested without current MediaItem, but playback resumption prevented by missing available commands");
                }
                Util.handlePlayButtonAction(this.playerWrapper);
                if (z) {
                    onPlayerInteractionFinishedOnHandler(mediaSession$ControllerInfoResolveControllerInfoForCallback);
                    return;
                }
                return;
            }
            this.callback$1.getClass();
            this.instance$1.getClass();
            mediaSession$ControllerInfoResolveControllerInfoForCallback.getClass();
            ImmediateFuture immediateFuture = new ImmediateFuture(new MediaSession$MediaItemsWithStartPosition(EmptyList.INSTANCE, 0, -9223372036854775807L));
            immediateFuture.addListener(new ActivityRecreator.AnonymousClass1(immediateFuture, new MediaSessionImpl$1(this, mediaSession$ControllerInfoResolveControllerInfoForCallback, z, commands), b), new MediaSessionImpl$$ExternalSyntheticLambda18(this, (byte) 0));
        }
    }

    public final boolean isConnected(MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub;
        if (this.sessionStub.connectedControllersManager.isConnected(mediaSession$ControllerInfo) || this.sessionLegacyStub.connectedControllersManager.isConnected(mediaSession$ControllerInfo)) {
            return true;
        }
        synchronized (this.lock) {
            mediaLibraryServiceLegacyStub = this.browserServiceLegacyStub;
        }
        return mediaLibraryServiceLegacyStub != null && mediaLibraryServiceLegacyStub.connectedControllersManager.isConnected(mediaSession$ControllerInfo);
    }

    public final boolean isMediaNotificationController(MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        return Objects.equals(mediaSession$ControllerInfo.remoteUserInfo.impl.packageName, this.context.getPackageName()) && mediaSession$ControllerInfo.libraryVersion != 0 && new Bundle(mediaSession$ControllerInfo.connectionHints).getBoolean("androidx.media3.session.MediaNotificationManager", false);
    }

    public final boolean isReleased() {
        boolean z;
        synchronized (this.lock) {
            z = this.closed;
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0045 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:29:0x0047  */
    public final void maybeUpdateLegacyErrorState(MediaSession$ControllerInfo mediaSession$ControllerInfo, LibraryResult libraryResult) {
        byte b = this.libraryErrorReplicationMode;
        if (b == 0 || mediaSession$ControllerInfo.libraryVersion != 0) {
            return;
        }
        int i = libraryResult.resultCode;
        MediaSessionLegacyStub mediaSessionLegacyStub = this.sessionLegacyStub;
        if (i == -102 || i == -105) {
            boolean z = b == 1;
            mediaSessionLegacyStub.getClass();
            MediaLibraryService.LibraryParams libraryParams = libraryResult.params;
            SessionError sessionError = libraryResult.sessionError;
            int iConvertToLegacyErrorCode = LegacyConversions.convertToLegacyErrorCode(i);
            BoxParser.StsdData stsdData = mediaSessionLegacyStub.legacyError;
            if (stsdData == null || stsdData.nalUnitLengthFieldLength != iConvertToLegacyErrorCode) {
                String str = sessionError != null ? sessionError.message : "no error message provided";
                Bundle bundle = Bundle.EMPTY;
                if (libraryParams != null) {
                    Bundle bundle2 = libraryParams.extras;
                    if (bundle2.containsKey("android.media.extras.ERROR_RESOLUTION_ACTION_INTENT")) {
                        bundle = bundle2;
                    } else if (sessionError != null) {
                        bundle = sessionError.extras;
                    }
                } else if (sessionError != null) {
                    bundle = sessionError.extras;
                }
                mediaSessionLegacyStub.legacyError = new BoxParser.StsdData(z, iConvertToLegacyErrorCode, str, bundle);
                mediaSessionLegacyStub.updateLegacySessionPlaybackState(mediaSessionLegacyStub.sessionImpl.playerWrapper);
            }
        }
        if (i != 0 || mediaSessionLegacyStub.legacyError == null) {
            return;
        }
        mediaSessionLegacyStub.legacyError = null;
        mediaSessionLegacyStub.updateLegacySessionPlaybackState(mediaSessionLegacyStub.sessionImpl.playerWrapper);
    }

    public final ListenableFuture onAddMediaItemsOnHandler(MediaSession$ControllerInfo mediaSession$ControllerInfo, List list) {
        resolveControllerInfoForCallback(mediaSession$ControllerInfo);
        this.callback$1.getClass();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((MediaItem) it.next()).localConfiguration == null) {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                ImmediateFuture.ImmediateFailedFuture immediateFailedFuture = new ImmediateFuture.ImmediateFailedFuture();
                immediateFailedFuture.setException(unsupportedOperationException);
                return immediateFailedFuture;
            }
        }
        return new ImmediateFuture(list);
    }

    public final MediaSession$ConnectionResult onConnectOnHandler(MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        ImmutableList immutableListCopyOf;
        boolean z = this.isMediaNotificationControllerConnected;
        ImmutableList immutableListCopyOf2 = null;
        MediaSessionLegacyStub mediaSessionLegacyStub = this.sessionLegacyStub;
        if (z && isSystemUiController(mediaSession$ControllerInfo)) {
            mediaSessionLegacyStub.getClass();
            SessionCommands sessionCommands = MediaSession$ConnectionResult.DEFAULT_SESSION_AND_LIBRARY_COMMANDS;
            SessionCommands sessionCommands2 = mediaSessionLegacyStub.availableSessionCommands;
            sessionCommands2.getClass();
            Player.Commands commands = mediaSessionLegacyStub.availablePlayerCommands;
            commands.getClass();
            if (mediaSessionLegacyStub.mediaButtonPreferences.isEmpty()) {
                ImmutableList immutableList = mediaSessionLegacyStub.customLayout;
                immutableListCopyOf2 = immutableList == null ? null : ImmutableList.copyOf((Collection) immutableList);
                immutableListCopyOf = null;
            } else {
                ImmutableList immutableList2 = mediaSessionLegacyStub.mediaButtonPreferences;
                immutableListCopyOf = immutableList2 == null ? null : ImmutableList.copyOf((Collection) immutableList2);
            }
            return new MediaSession$ConnectionResult(sessionCommands2, commands, immutableListCopyOf2, immutableListCopyOf);
        }
        this.callback$1.getClass();
        MediaLibraryService.MediaLibrarySession mediaLibrarySession = this.instance$1;
        mediaLibrarySession.getClass();
        MediaLibrarySessionImpl mediaLibrarySessionImpl = mediaLibrarySession.impl;
        Player.Commands commands2 = MediaSession$ConnectionResult.DEFAULT_PLAYER_COMMANDS;
        SessionCommands sessionCommands3 = MediaSession$ConnectionResult.DEFAULT_SESSION_AND_LIBRARY_COMMANDS;
        sessionCommands3.getClass();
        HashSet hashSet = new HashSet(sessionCommands3.commands);
        SessionCommand sessionCommand = MediaSessionConstants.CommandToggleLike;
        sessionCommand.getClass();
        hashSet.add(sessionCommand);
        SessionCommand sessionCommand2 = MediaSessionConstants.CommandToggleStartRadio;
        sessionCommand2.getClass();
        hashSet.add(sessionCommand2);
        SessionCommand sessionCommand3 = MediaSessionConstants.CommandToggleLibrary;
        sessionCommand3.getClass();
        hashSet.add(sessionCommand3);
        SessionCommand sessionCommand4 = MediaSessionConstants.CommandToggleShuffle;
        sessionCommand4.getClass();
        hashSet.add(sessionCommand4);
        SessionCommand sessionCommand5 = MediaSessionConstants.CommandToggleRepeatMode;
        sessionCommand5.getClass();
        hashSet.add(sessionCommand5);
        SessionCommand sessionCommand6 = MediaSessionConstants.CommandAddToTargetPlaylist;
        sessionCommand6.getClass();
        hashSet.add(sessionCommand6);
        SessionCommands sessionCommands4 = new SessionCommands(hashSet);
        MediaSession$ConnectionResult mediaSession$ConnectionResult = new MediaSession$ConnectionResult(sessionCommands4, commands2, null, null);
        if (isMediaNotificationController(mediaSession$ControllerInfo)) {
            byte b = 1;
            this.isMediaNotificationControllerConnected = true;
            ImmutableList immutableList3 = mediaLibrarySessionImpl.mediaButtonPreferences;
            if (immutableList3.isEmpty()) {
                mediaSessionLegacyStub.customLayout = mediaLibrarySessionImpl.customLayout;
            } else {
                mediaSessionLegacyStub.mediaButtonPreferences = immutableList3;
                mediaSessionLegacyStub.updateCustomLayoutAndLegacyExtrasForMediaButtonPreferencesAndInformExtrasChanged();
            }
            boolean z2 = mediaSessionLegacyStub.availablePlayerCommands.contains(17) != commands2.contains(17);
            mediaSessionLegacyStub.availableSessionCommands = sessionCommands4;
            mediaSessionLegacyStub.availablePlayerCommands = commands2;
            if (!mediaSessionLegacyStub.mediaButtonPreferences.isEmpty()) {
                mediaSessionLegacyStub.updateCustomLayoutAndLegacyExtrasForMediaButtonPreferencesAndInformExtrasChanged();
            }
            MediaLibrarySessionImpl mediaLibrarySessionImpl2 = mediaSessionLegacyStub.sessionImpl;
            if (z2) {
                Util.postOrRun(mediaLibrarySessionImpl2.applicationHandler, new MediaSessionLegacyStub$$ExternalSyntheticLambda5(mediaSessionLegacyStub, mediaLibrarySessionImpl2.playerWrapper, b));
                return mediaSession$ConnectionResult;
            }
            mediaSessionLegacyStub.updateLegacySessionPlaybackState(mediaLibrarySessionImpl2.playerWrapper);
        }
        return mediaSession$ConnectionResult;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final ImmediateFuture onCustomCommandOnHandler(MediaSession$ControllerInfo mediaSession$ControllerInfo, SessionCommand sessionCommand, Bundle bundle) {
        MediaSession$ControllerInfo mediaSession$ControllerInfoResolveControllerInfoForCallback = resolveControllerInfoForCallback(mediaSession$ControllerInfo);
        MediaLibrarySessionCallback mediaLibrarySessionCallback = this.callback$1;
        mediaLibrarySessionCallback.getClass();
        MediaLibraryService.MediaLibrarySession mediaLibrarySession = this.instance$1;
        mediaLibrarySession.getClass();
        mediaSession$ControllerInfoResolveControllerInfoForCallback.getClass();
        bundle.getClass();
        String str = sessionCommand.customAction;
        switch (str.hashCode()) {
            case -1097675910:
                if (str.equals("ADD_TO_TARGET_PLAYLIST")) {
                    mediaLibrarySessionCallback.addToTargetPlaylist.invoke();
                }
                break;
            case -737700626:
                if (str.equals("TOGGLE_SHUFFLE")) {
                    mediaLibrarySession.getPlayer().setShuffleModeEnabled(!mediaLibrarySession.getPlayer().getShuffleModeEnabled());
                }
                break;
            case -218545828:
                if (str.equals("TOGGLE_REPEAT_MODE")) {
                    IntMath.toggleRepeatMode(mediaLibrarySession.getPlayer());
                }
                break;
            case 1536763298:
                if (str.equals("TOGGLE_LIKE")) {
                    mediaLibrarySessionCallback.toggleLike.invoke();
                }
                break;
            case 1651143344:
                if (str.equals("TOGGLE_LIBRARY")) {
                    mediaLibrarySessionCallback.toggleLibrary.invoke();
                }
                break;
            case 1840726323:
                if (str.equals("TOGGLE_START_RADIO")) {
                    mediaLibrarySessionCallback.toggleStartRadio.invoke();
                }
                break;
        }
        return new ImmediateFuture(new SessionResult(0));
    }

    public final ListenableFuture onGetChildrenOnHandler(MediaSession$ControllerInfo mediaSession$ControllerInfo, String str, int i, int i2, final MediaLibraryService.LibraryParams libraryParams) {
        boolean zEquals = Objects.equals(str, "androidx.media3.session.recent.root");
        final byte b = 1;
        MediaLibraryService.MediaLibrarySession mediaLibrarySession = this.instance;
        MediaLibrarySessionCallback mediaLibrarySessionCallback = this.callback;
        if (!zEquals) {
            MediaSession$ControllerInfo mediaSession$ControllerInfoResolveControllerInfoForCallback = resolveControllerInfoForCallback(mediaSession$ControllerInfo);
            mediaLibrarySessionCallback.getClass();
            mediaLibrarySession.getClass();
            mediaSession$ControllerInfoResolveControllerInfoForCallback.getClass();
            str.getClass();
            ContextScope contextScope = mediaLibrarySessionCallback.scope;
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            JobListenableFuture jobListenableFutureFuture$default = RegexKt.future$default(contextScope, DefaultIoScheduler.INSTANCE, new MediaLibrarySessionCallback$onGetChildren$1(mediaLibrarySessionCallback, str, i, i2, libraryParams, null));
            jobListenableFutureFuture$default.addListener(new MediaLibrarySessionImpl$$ExternalSyntheticLambda0(this, jobListenableFutureFuture$default, mediaSession$ControllerInfo, i2, (byte) 0), new MediaSessionImpl$$ExternalSyntheticLambda18(this, (byte) 1));
            return jobListenableFutureFuture$default;
        }
        if (this.sessionLegacyStub.broadcastReceiverComponentName == null) {
            return new ImmediateFuture(LibraryResult.ofError(-6));
        }
        if (this.playerWrapper.getPlaybackState() != 1) {
            MediaItem.Builder builder = new MediaItem.Builder();
            builder.mediaId = "androidx.media3.session.recent.item";
            MediaMetadata.Builder builder2 = new MediaMetadata.Builder();
            builder2.isBrowsable = Boolean.FALSE;
            builder2.isPlayable = Boolean.TRUE;
            builder.mediaMetadata = new MediaMetadata(builder2);
            return new ImmediateFuture(LibraryResult.ofItemList(ImmutableList.of((Object) builder.build()), libraryParams));
        }
        if (this.isMediaNotificationControllerConnected) {
            getMediaNotificationControllerInfo();
        }
        mediaLibrarySessionCallback.getClass();
        mediaLibrarySession.getClass();
        final byte b2 = 0;
        AbstractTransformFuture$TransformFuture abstractTransformFuture$TransformFutureCreate = AbstractTransformFuture$TransformFuture.create(new ImmediateFuture(new MediaSession$MediaItemsWithStartPosition(EmptyList.INSTANCE, 0, -9223372036854775807L)), new Function() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda8
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                byte b3 = b2;
                MediaLibraryService.LibraryParams libraryParams2 = libraryParams;
                switch (b3) {
                    case 0:
                        return MediaLibrarySessionImpl.lambda$getRecentMediaItemAtDeviceBootTime$8(libraryParams2, (MediaSession$MediaItemsWithStartPosition) obj);
                    default:
                        Log.e("MediaSessionImpl", "Failed fetching recent media item at boot time.", (Throwable) obj);
                        return LibraryResult.ofError(-1, libraryParams2);
                }
            }
        });
        Function function = new Function() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda8
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                byte b3 = b;
                MediaLibraryService.LibraryParams libraryParams2 = libraryParams;
                switch (b3) {
                    case 0:
                        return MediaLibrarySessionImpl.lambda$getRecentMediaItemAtDeviceBootTime$8(libraryParams2, (MediaSession$MediaItemsWithStartPosition) obj);
                    default:
                        Log.e("MediaSessionImpl", "Failed fetching recent media item at boot time.", (Throwable) obj);
                        return LibraryResult.ofError(-1, libraryParams2);
                }
            }
        };
        AbstractCatchingFuture$CatchingFuture abstractCatchingFuture$CatchingFuture = new AbstractCatchingFuture$CatchingFuture();
        abstractCatchingFuture$CatchingFuture.inputFuture = abstractTransformFuture$TransformFutureCreate;
        abstractCatchingFuture$CatchingFuture.exceptionType = Throwable.class;
        abstractCatchingFuture$CatchingFuture.fallback = function;
        abstractTransformFuture$TransformFutureCreate.addListener(abstractCatchingFuture$CatchingFuture, DirectExecutor.INSTANCE);
        return abstractCatchingFuture$CatchingFuture;
    }

    public final JobListenableFuture onGetItemOnHandler(MediaSession$ControllerInfo mediaSession$ControllerInfo, String str) {
        MediaSession$ControllerInfo mediaSession$ControllerInfoResolveControllerInfoForCallback = resolveControllerInfoForCallback(mediaSession$ControllerInfo);
        MediaLibrarySessionCallback mediaLibrarySessionCallback = this.callback;
        mediaLibrarySessionCallback.getClass();
        this.instance.getClass();
        mediaSession$ControllerInfoResolveControllerInfoForCallback.getClass();
        str.getClass();
        ContextScope contextScope = mediaLibrarySessionCallback.scope;
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        JobListenableFuture jobListenableFutureFuture$default = RegexKt.future$default(contextScope, DefaultIoScheduler.INSTANCE, new App.C01391(mediaLibrarySessionCallback, str, null, (byte) 18));
        jobListenableFutureFuture$default.addListener(new Util$$ExternalSyntheticLambda1((byte) 14, this, jobListenableFutureFuture$default, mediaSession$ControllerInfo, false), new MediaSessionImpl$$ExternalSyntheticLambda18(this, (byte) 1));
        return jobListenableFutureFuture$default;
    }

    public final ImmediateFuture onGetLibraryRootOnHandler(MediaSession$ControllerInfo mediaSession$ControllerInfo, MediaLibraryService.LibraryParams libraryParams) {
        if (libraryParams != null && libraryParams.isRecent && isSystemUiController(mediaSession$ControllerInfo)) {
            if (this.sessionLegacyStub.broadcastReceiverComponentName == null) {
                return new ImmediateFuture(LibraryResult.ofError(-6));
            }
            MediaItem.Builder builder = new MediaItem.Builder();
            builder.mediaId = "androidx.media3.session.recent.root";
            MediaMetadata.Builder builder2 = new MediaMetadata.Builder();
            builder2.isBrowsable = Boolean.TRUE;
            builder2.isPlayable = Boolean.FALSE;
            builder.mediaMetadata = new MediaMetadata(builder2);
            MediaItem mediaItemBuild = builder.build();
            LibraryResult.verifyMediaItem(mediaItemBuild);
            return new ImmediateFuture(new LibraryResult(0, SystemClock.elapsedRealtime(), libraryParams, null, mediaItemBuild, 2));
        }
        MediaSession$ControllerInfo mediaSession$ControllerInfoResolveControllerInfoForCallback = resolveControllerInfoForCallback(mediaSession$ControllerInfo);
        this.callback.getClass();
        this.instance.getClass();
        mediaSession$ControllerInfoResolveControllerInfoForCallback.getClass();
        MediaItem.Builder builder3 = new MediaItem.Builder();
        builder3.mediaId = "root";
        MediaMetadata.Builder builder4 = new MediaMetadata.Builder();
        builder4.isPlayable = Boolean.FALSE;
        builder4.isBrowsable = Boolean.TRUE;
        builder4.mediaType = 20;
        builder3.mediaMetadata = new MediaMetadata(builder4);
        MediaItem mediaItemBuild2 = builder3.build();
        LibraryResult.verifyMediaItem(mediaItemBuild2);
        return new ImmediateFuture(new LibraryResult(0, SystemClock.elapsedRealtime(), libraryParams, null, mediaItemBuild2, 2));
    }

    public final JobListenableFuture onGetSearchResultOnHandler(MediaSession$ControllerInfo mediaSession$ControllerInfo, String str, int i, MediaLibraryService.LibraryParams libraryParams) {
        MediaSession$ControllerInfo mediaSession$ControllerInfoResolveControllerInfoForCallback = resolveControllerInfoForCallback(mediaSession$ControllerInfo);
        MediaLibrarySessionCallback mediaLibrarySessionCallback = this.callback;
        mediaLibrarySessionCallback.getClass();
        this.instance.getClass();
        mediaSession$ControllerInfoResolveControllerInfoForCallback.getClass();
        str.getClass();
        ContextScope contextScope = mediaLibrarySessionCallback.scope;
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        JobListenableFuture jobListenableFutureFuture$default = RegexKt.future$default(contextScope, DefaultIoScheduler.INSTANCE, new MediaLibrarySessionCallback$onGetSearchResult$1(str, libraryParams, mediaLibrarySessionCallback, null));
        jobListenableFutureFuture$default.addListener(new MediaLibrarySessionImpl$$ExternalSyntheticLambda0(this, jobListenableFutureFuture$default, mediaSession$ControllerInfo, i, (byte) 1), new MediaSessionImpl$$ExternalSyntheticLambda18(this, (byte) 1));
        return jobListenableFutureFuture$default;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00de  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:67:0x00fc  */
    public final boolean onMediaButtonEvent(MediaSession$ControllerInfo mediaSession$ControllerInfo, Intent intent) {
        boolean z;
        MediaSessionLegacyStub mediaSessionLegacyStub;
        int i = mediaSession$ControllerInfo.libraryVersion;
        Bundle extras = intent.getExtras();
        Util$$ExternalSyntheticLambda1 util$$ExternalSyntheticLambda1 = null;
        KeyEvent keyEvent = (extras == null || !extras.containsKey("android.intent.extra.KEY_EVENT")) ? null : (KeyEvent) extras.getParcelable("android.intent.extra.KEY_EVENT");
        ComponentName component = intent.getComponent();
        if (Objects.equals(intent.getAction(), "android.intent.action.MEDIA_BUTTON")) {
            Context context = this.context;
            if ((component == null || Objects.equals(component.getPackageName(), context.getPackageName())) && keyEvent != null) {
                verifyApplicationThread();
                this.callback$1.getClass();
                if (keyEvent.getAction() != 0) {
                    int keyCode = keyEvent.getKeyCode();
                    if (keyCode != 79 && keyCode != 126 && keyCode != 127 && keyCode != 272 && keyCode != 273) {
                        switch (keyCode) {
                        }
                    }
                    return true;
                }
                int keyCode2 = keyEvent.getKeyCode();
                boolean zHasSystemFeature = context.getPackageManager().hasSystemFeature("android.software.leanback");
                MediaSessionImpl$MediaPlayPauseKeyHandler mediaSessionImpl$MediaPlayPauseKeyHandler = this.mediaPlayPauseKeyHandler;
                if (keyCode2 == 79 || keyCode2 == 85) {
                    if (!zHasSystemFeature && i == 0 && keyEvent.getRepeatCount() == 0) {
                        Util$$ExternalSyntheticLambda1 util$$ExternalSyntheticLambda2 = (Util$$ExternalSyntheticLambda1) mediaSessionImpl$MediaPlayPauseKeyHandler.playPauseTask;
                        if (util$$ExternalSyntheticLambda2 == null) {
                            Util$$ExternalSyntheticLambda1 util$$ExternalSyntheticLambda3 = new Util$$ExternalSyntheticLambda1((Object) mediaSessionImpl$MediaPlayPauseKeyHandler, (Object) mediaSession$ControllerInfo, (Object) keyEvent, (byte) 18);
                            mediaSessionImpl$MediaPlayPauseKeyHandler.playPauseTask = util$$ExternalSyntheticLambda3;
                            mediaSessionImpl$MediaPlayPauseKeyHandler.postDelayed(util$$ExternalSyntheticLambda3, ViewConfiguration.getDoubleTapTimeout());
                            return true;
                        }
                        if (util$$ExternalSyntheticLambda2 != null) {
                            mediaSessionImpl$MediaPlayPauseKeyHandler.removeCallbacks(util$$ExternalSyntheticLambda2);
                            mediaSessionImpl$MediaPlayPauseKeyHandler.playPauseTask = null;
                        }
                        z = true;
                    } else {
                        Util$$ExternalSyntheticLambda1 util$$ExternalSyntheticLambda4 = (Util$$ExternalSyntheticLambda1) mediaSessionImpl$MediaPlayPauseKeyHandler.playPauseTask;
                        if (util$$ExternalSyntheticLambda4 != null) {
                            mediaSessionImpl$MediaPlayPauseKeyHandler.removeCallbacks(util$$ExternalSyntheticLambda4);
                            Util$$ExternalSyntheticLambda1 util$$ExternalSyntheticLambda5 = (Util$$ExternalSyntheticLambda1) mediaSessionImpl$MediaPlayPauseKeyHandler.playPauseTask;
                            mediaSessionImpl$MediaPlayPauseKeyHandler.playPauseTask = null;
                            util$$ExternalSyntheticLambda1 = util$$ExternalSyntheticLambda5;
                        }
                        if (util$$ExternalSyntheticLambda1 != null) {
                            Util.postOrRun(mediaSessionImpl$MediaPlayPauseKeyHandler, util$$ExternalSyntheticLambda1);
                        }
                    }
                    if (!this.isMediaNotificationControllerConnected) {
                        boolean booleanExtra = intent.getBooleanExtra("androidx.media3.session.NOTIFICATION_DISMISSED_EVENT_KEY", false);
                        if (keyEvent.getRepeatCount() <= 0 || applyMediaButtonKeyEvent(keyEvent, z, booleanExtra)) {
                            return true;
                        }
                    } else {
                        mediaSessionLegacyStub = this.sessionLegacyStub;
                        if ((keyCode2 != 85 || keyCode2 == 79) && z) {
                            mediaSessionLegacyStub.onSkipToNext();
                            return true;
                        }
                        if (i != 0) {
                            ((MediaControllerCompat$MediaControllerImplApi23) ((CallbackWrapper) mediaSessionLegacyStub.sessionCompat.mExecutor).mCallback).controllerFwk.dispatchMediaButtonEvent(keyEvent);
                            return true;
                        }
                    }
                } else {
                    Util$$ExternalSyntheticLambda1 util$$ExternalSyntheticLambda6 = (Util$$ExternalSyntheticLambda1) mediaSessionImpl$MediaPlayPauseKeyHandler.playPauseTask;
                    if (util$$ExternalSyntheticLambda6 != null) {
                        mediaSessionImpl$MediaPlayPauseKeyHandler.removeCallbacks(util$$ExternalSyntheticLambda6);
                        Util$$ExternalSyntheticLambda1 util$$ExternalSyntheticLambda7 = (Util$$ExternalSyntheticLambda1) mediaSessionImpl$MediaPlayPauseKeyHandler.playPauseTask;
                        mediaSessionImpl$MediaPlayPauseKeyHandler.playPauseTask = null;
                        util$$ExternalSyntheticLambda1 = util$$ExternalSyntheticLambda7;
                    }
                    if (util$$ExternalSyntheticLambda1 != null) {
                        Util.postOrRun(mediaSessionImpl$MediaPlayPauseKeyHandler, util$$ExternalSyntheticLambda1);
                    }
                }
                z = false;
                if (!this.isMediaNotificationControllerConnected) {
                    boolean booleanExtra2 = intent.getBooleanExtra("androidx.media3.session.NOTIFICATION_DISMISSED_EVENT_KEY", false);
                    if (keyEvent.getRepeatCount() <= 0) {
                    }
                    return true;
                }
                mediaSessionLegacyStub = this.sessionLegacyStub;
                if (keyCode2 != 85) {
                    mediaSessionLegacyStub.onSkipToNext();
                    return true;
                }
                mediaSessionLegacyStub.onSkipToNext();
                return true;
                if (i != 0) {
                    ((MediaControllerCompat$MediaControllerImplApi23) ((CallbackWrapper) mediaSessionLegacyStub.sessionCompat.mExecutor).mCallback).controllerFwk.dispatchMediaButtonEvent(keyEvent);
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean onPlayRequested() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            DefaultActionFactory defaultActionFactory = this.mediaSessionListener;
            if (defaultActionFactory != null) {
                MediaSessionService mediaSessionService = defaultActionFactory.service;
                int i = Build.VERSION.SDK_INT;
                if (i >= 31 && i < 33) {
                    int i2 = MediaSessionService.$r8$clinit;
                    if (!mediaSessionService.getMediaNotificationManager(null).startedInForeground) {
                        mediaSessionService.onUpdateNotificationInternal(this.instance$1, true);
                    }
                }
            }
            return true;
        }
        try {
            try {
                CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = new CallbackToFutureAdapter$Completer();
                callbackToFutureAdapter$Completer.cancellationFuture = new ResolvableFuture();
                CallbackToFutureAdapter$SafeFuture callbackToFutureAdapter$SafeFuture = new CallbackToFutureAdapter$SafeFuture(callbackToFutureAdapter$Completer);
                CallbackToFutureAdapter$SafeFuture.AnonymousClass1 anonymousClass1 = callbackToFutureAdapter$SafeFuture.delegate;
                callbackToFutureAdapter$Completer.future = callbackToFutureAdapter$SafeFuture;
                callbackToFutureAdapter$Completer.tag = IntIntPair$$ExternalSyntheticOutline0.class;
                try {
                    this.mainHandler.post(new TransactionExecutor$$ExternalSyntheticLambda0((Object) this, (Object) callbackToFutureAdapter$Completer, (byte) 10));
                    callbackToFutureAdapter$Completer.tag = "onPlayRequested";
                } catch (Exception e) {
                    anonymousClass1.setException(e);
                }
                return ((Boolean) anonymousClass1.get()).booleanValue();
            } catch (ExecutionException e2) {
                e = e2;
                throw new IllegalStateException(e);
            }
        } catch (InterruptedException | ExecutionException e3) {
            e = e3;
            throw new IllegalStateException(e);
        }
    }

    public final void onPlayerInteractionFinishedOnHandler(MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        resolveControllerInfoForCallback(mediaSession$ControllerInfo);
        this.callback$1.getClass();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x006d A[PHI: r0
      0x006d: PHI (r0v1 androidx.media3.session.MediaSession$ControllerInfo) = 
      (r0v0 androidx.media3.session.MediaSession$ControllerInfo)
      (r0v0 androidx.media3.session.MediaSession$ControllerInfo)
      (r0v11 androidx.media3.session.MediaSession$ControllerInfo)
     binds: [B:3:0x0021, B:5:0x0027, B:21:0x006a] A[DONT_GENERATE, DONT_INLINE]] */
    public final ImmediateFuture onSearchOnHandler(MediaSession$ControllerInfo mediaSession$ControllerInfo, String str, MediaLibraryService.LibraryParams libraryParams) {
        MediaSession$ControllerInfo mediaSession$ControllerInfoResolveControllerInfoForCallback = resolveControllerInfoForCallback(mediaSession$ControllerInfo);
        this.callback.getClass();
        MediaLibraryService.MediaLibrarySession mediaLibrarySession = this.instance;
        mediaLibrarySession.getClass();
        mediaSession$ControllerInfoResolveControllerInfoForCallback.getClass();
        str.getClass();
        byte b = 1;
        UtilsKt.checkArgument(!TextUtils.isEmpty(str));
        MediaLibrarySessionImpl mediaLibrarySessionImpl = mediaLibrarySession.impl;
        if (mediaLibrarySessionImpl.isMediaNotificationControllerConnected && mediaLibrarySessionImpl.isMediaNotificationController(mediaSession$ControllerInfoResolveControllerInfoForCallback)) {
            ImmutableList connectedControllers = mediaLibrarySessionImpl.sessionLegacyStub.connectedControllersManager.getConnectedControllers();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= connectedControllers.size()) {
                    ImmutableList connectedControllers2 = mediaLibrarySessionImpl.sessionStub.connectedControllersManager.getConnectedControllers();
                    while (true) {
                        if (i >= connectedControllers2.size()) {
                            mediaSession$ControllerInfoResolveControllerInfoForCallback = null;
                            break;
                        }
                        MediaSession$ControllerInfo mediaSession$ControllerInfo2 = (MediaSession$ControllerInfo) connectedControllers2.get(i);
                        if (isSystemUiController(mediaSession$ControllerInfo2)) {
                            mediaSession$ControllerInfoResolveControllerInfoForCallback = mediaSession$ControllerInfo2;
                            break;
                        }
                        i++;
                    }
                } else {
                    MediaSession$ControllerInfo mediaSession$ControllerInfo3 = (MediaSession$ControllerInfo) connectedControllers.get(i2);
                    if (isSystemUiController(mediaSession$ControllerInfo3)) {
                        mediaSession$ControllerInfoResolveControllerInfoForCallback = mediaSession$ControllerInfo3;
                        break;
                    }
                    i2++;
                }
            }
            if (mediaSession$ControllerInfoResolveControllerInfoForCallback != null) {
                mediaLibrarySessionImpl.dispatchRemoteControllerTaskWithoutReturn(mediaSession$ControllerInfoResolveControllerInfoForCallback, new MediaSessionStub$$ExternalSyntheticLambda65(str, libraryParams, b));
            }
        } else {
            mediaLibrarySessionImpl.dispatchRemoteControllerTaskWithoutReturn(mediaSession$ControllerInfoResolveControllerInfoForCallback, new MediaSessionStub$$ExternalSyntheticLambda65(str, libraryParams, b));
        }
        ImmediateFuture immediateFuture = new ImmediateFuture(new LibraryResult(0, SystemClock.elapsedRealtime(), null, null, null, 1));
        immediateFuture.addListener(new Util$$ExternalSyntheticLambda1((Object) this, (Object) immediateFuture, (Object) mediaSession$ControllerInfo, (byte) 15), new MediaSessionImpl$$ExternalSyntheticLambda18(this, (byte) 1));
        return immediateFuture;
    }

    public final ListenableFuture onSetMediaItemsOnHandler(MediaSession$ControllerInfo mediaSession$ControllerInfo, List list, int i, long j) {
        MediaSession$ControllerInfo mediaSession$ControllerInfoResolveControllerInfoForCallback = resolveControllerInfoForCallback(mediaSession$ControllerInfo);
        MediaLibrarySessionCallback mediaLibrarySessionCallback = this.callback$1;
        mediaLibrarySessionCallback.getClass();
        this.instance$1.getClass();
        mediaSession$ControllerInfoResolveControllerInfoForCallback.getClass();
        list.getClass();
        ContextScope contextScope = mediaLibrarySessionCallback.scope;
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        JobListenableFuture jobListenableFutureFuture$default = RegexKt.future$default(contextScope, DefaultIoScheduler.INSTANCE, new MediaLibrarySessionCallback$onSetMediaItems$1(i, j, list, mediaLibrarySessionCallback, null));
        UtilsKt.checkNotNull(jobListenableFutureFuture$default, "Callback.onSetMediaItems must return a non-null future");
        return jobListenableFutureFuture$default;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x00ac */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ImmediateFuture onSubscribeOnHandler(MediaSession$ControllerInfo mediaSession$ControllerInfo, String str, MediaLibraryService.LibraryParams libraryParams) throws Throwable {
        MediaSession$ControllerCb mediaSession$ControllerCb = mediaSession$ControllerInfo.controllerCb;
        mediaSession$ControllerCb.getClass();
        synchronized (this) {
            try {
                this.controllerToSubscribedParentIds.put(mediaSession$ControllerCb, str);
                this.parentIdToSubscribedControllers.put(str, mediaSession$ControllerInfo);
            } catch (Throwable th) {
                th = th;
                while (true) {
                    throw th;
                }
            }
        }
        MediaLibrarySessionCallback mediaLibrarySessionCallback = this.callback;
        MediaLibraryService.MediaLibrarySession mediaLibrarySession = this.instance;
        MediaSession$ControllerInfo mediaSession$ControllerInfoResolveControllerInfoForCallback = resolveControllerInfoForCallback(mediaSession$ControllerInfo);
        mediaLibrarySessionCallback.getClass();
        mediaLibrarySession.getClass();
        mediaSession$ControllerInfoResolveControllerInfoForCallback.getClass();
        str.getClass();
        ImmediateFuture immediateFuture = new ImmediateFuture((str.equals("root") || str.equals("song") || str.equals("artist") || str.equals("album") || str.equals("playlist") || str.equals("youtube_playlist") || StringsKt__StringsJVMKt.startsWith(str, "artist/", false) || StringsKt__StringsJVMKt.startsWith(str, "album/", false) || StringsKt__StringsJVMKt.startsWith(str, "playlist/", false) || StringsKt__StringsJVMKt.startsWith(str, "youtube_playlist/", false)) ? new LibraryResult(0, SystemClock.elapsedRealtime(), libraryParams, null, null, 1) : LibraryResult.ofError(-3, libraryParams));
        immediateFuture.addListener(new MediaSessionStub$$ExternalSyntheticLambda3(this, (Object) immediateFuture, (Object) mediaSession$ControllerInfo, (Object) str, (byte) 5), new MediaSessionImpl$$ExternalSyntheticLambda18(this, (byte) 2));
        return immediateFuture;
    }

    public final ImmediateFuture onUnsubscribeOnHandler(MediaSession$ControllerInfo mediaSession$ControllerInfo, String str) {
        resolveControllerInfoForCallback(mediaSession$ControllerInfo);
        this.callback.getClass();
        ImmediateFuture immediateFuture = new ImmediateFuture(new LibraryResult(0, SystemClock.elapsedRealtime(), null, null, null, 1));
        immediateFuture.addListener(new Util$$ExternalSyntheticLambda1((Object) this, (Object) mediaSession$ControllerInfo, (Object) str, (byte) 16), new MediaSessionImpl$$ExternalSyntheticLambda18(this, (byte) 1));
        return immediateFuture;
    }

    public final void postOrRunOnApplicationHandler(Runnable runnable) {
        Util.postOrRun(this.applicationHandler, runnable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void release() {
        String str;
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
        Log.i("MediaSessionImpl", sb.toString());
        synchronized (this.lock) {
            try {
                if (this.closed) {
                    return;
                }
                this.closed = true;
                MediaSessionImpl$MediaPlayPauseKeyHandler mediaSessionImpl$MediaPlayPauseKeyHandler = this.mediaPlayPauseKeyHandler;
                Util$$ExternalSyntheticLambda1 util$$ExternalSyntheticLambda1 = (Util$$ExternalSyntheticLambda1) mediaSessionImpl$MediaPlayPauseKeyHandler.playPauseTask;
                if (util$$ExternalSyntheticLambda1 != null) {
                    mediaSessionImpl$MediaPlayPauseKeyHandler.removeCallbacks(util$$ExternalSyntheticLambda1);
                    mediaSessionImpl$MediaPlayPauseKeyHandler.playPauseTask = null;
                }
                this.applicationHandler.removeCallbacksAndMessages(null);
                int i = 0;
                try {
                    Util.postOrRun(this.applicationHandler, new MediaSessionImpl$$ExternalSyntheticLambda0(this, 0 == true ? 1 : 0));
                } catch (Exception e) {
                    Log.w("MediaSessionImpl", "Exception thrown while closing", e);
                }
                MediaSessionLegacyStub mediaSessionLegacyStub = this.sessionLegacyStub;
                ComponentName componentName = mediaSessionLegacyStub.broadcastReceiverComponentName;
                MediaLibrarySessionImpl mediaLibrarySessionImpl = mediaSessionLegacyStub.sessionImpl;
                CallbackWrapper callbackWrapper = mediaSessionLegacyStub.sessionCompat;
                int i2 = Build.VERSION.SDK_INT;
                if (i2 < 31) {
                    if (componentName == null) {
                        ((MediaSessionCompat$MediaSessionImplApi23) callbackWrapper.mCallback).sessionFwk.setMediaButtonReceiver(null);
                    } else {
                        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON", mediaLibrarySessionImpl.sessionUri);
                        intent.setComponent(componentName);
                        ((MediaSessionCompat$MediaSessionImplApi23) callbackWrapper.mCallback).sessionFwk.setMediaButtonReceiver(PendingIntent.getBroadcast(mediaLibrarySessionImpl.context, 0, intent, MediaSessionLegacyStub.PENDING_INTENT_FLAG_MUTABLE));
                    }
                }
                NetworkTypeObserver.Receiver receiver = mediaSessionLegacyStub.runtimeBroadcastReceiver;
                if (receiver != null) {
                    mediaLibrarySessionImpl.context.unregisterReceiver(receiver);
                }
                AndroidAutoConnectionStateObserver androidAutoConnectionStateObserver = mediaSessionLegacyStub.androidAutoObserver;
                if (androidAutoConnectionStateObserver != null && !androidAutoConnectionStateObserver.isReleased.getAndSet(true)) {
                    androidAutoConnectionStateObserver.backgroundExecutor.execute(new AndroidAutoConnectionStateObserver$$ExternalSyntheticLambda0(androidAutoConnectionStateObserver, (byte) 0));
                }
                MediaSessionCompat$MediaSessionImplApi23 mediaSessionCompat$MediaSessionImplApi23 = (MediaSessionCompat$MediaSessionImplApi23) callbackWrapper.mCallback;
                MediaSession mediaSession = mediaSessionCompat$MediaSessionImplApi23.sessionFwk;
                mediaSessionCompat$MediaSessionImplApi23.extraControllerCallbacks.kill();
                if (i2 == 27) {
                    try {
                        Field declaredField = mediaSession.getClass().getDeclaredField("mCallback");
                        declaredField.setAccessible(true);
                        Handler handler = (Handler) declaredField.get(mediaSession);
                        if (handler != null) {
                            handler.removeCallbacksAndMessages(null);
                        }
                    } catch (Exception e2) {
                        Log.w("MediaSessionCompat", "Exception happened while accessing MediaSession.mCallback.", e2);
                    }
                }
                mediaSession.setCallback(null);
                mediaSessionCompat$MediaSessionImplApi23.extraSession.mediaSessionImplRef.clear();
                mediaSession.release();
                MediaSessionStub mediaSessionStub = this.sessionStub;
                Set set = mediaSessionStub.pendingControllers;
                Dispatcher dispatcher = mediaSessionStub.connectedControllersManager;
                ImmutableList connectedControllers = dispatcher.getConnectedControllers();
                int size = connectedControllers.size();
                while (i < size) {
                    Object obj = connectedControllers.get(i);
                    i++;
                    MediaSession$ControllerInfo mediaSession$ControllerInfo = (MediaSession$ControllerInfo) obj;
                    dispatcher.removeController(mediaSession$ControllerInfo);
                    MediaSession$ControllerCb mediaSession$ControllerCb = mediaSession$ControllerInfo.controllerCb;
                    if (mediaSession$ControllerCb != null) {
                        mediaSession$ControllerCb.onDisconnected();
                    }
                }
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    MediaSession$ControllerCb mediaSession$ControllerCb2 = ((MediaSession$ControllerInfo) it.next()).controllerCb;
                    if (mediaSession$ControllerCb2 != null) {
                        mediaSession$ControllerCb2.onDisconnected();
                    }
                }
                set.clear();
                mediaSessionStub.sessionImpl.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void removeSubscription(MediaSession$ControllerInfo mediaSession$ControllerInfo, String str) {
        MediaSession$ControllerCb mediaSession$ControllerCb = mediaSession$ControllerInfo.controllerCb;
        mediaSession$ControllerCb.getClass();
        this.parentIdToSubscribedControllers.remove(str, mediaSession$ControllerInfo);
        this.controllerToSubscribedParentIds.remove(mediaSession$ControllerCb, str);
    }

    public final MediaSession$ControllerInfo resolveControllerInfoForCallback(MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        MediaSession$ControllerInfo mediaNotificationControllerInfo;
        return (this.isMediaNotificationControllerConnected && isSystemUiController(mediaSession$ControllerInfo) && (mediaNotificationControllerInfo = getMediaNotificationControllerInfo()) != null) ? mediaNotificationControllerInfo : mediaSession$ControllerInfo;
    }

    public final void schedulePeriodicSessionPositionInfoChanges() {
        long j = this.sessionPositionUpdateDelayMs;
        Handler handler = this.applicationHandler;
        MediaSessionImpl$$ExternalSyntheticLambda0 mediaSessionImpl$$ExternalSyntheticLambda0 = this.periodicSessionPositionInfoUpdateRunnable;
        handler.removeCallbacks(mediaSessionImpl$$ExternalSyntheticLambda0);
        if (!this.isPeriodicPositionUpdateEnabled || j <= 0) {
            return;
        }
        if (this.playerWrapper.isPlaying() || this.playerWrapper.isLoading()) {
            handler.postDelayed(mediaSessionImpl$$ExternalSyntheticLambda0, j);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.media3.common.Player$Listener, androidx.media3.session.MediaSessionImpl$PlayerListener] */
    public final void setPlayerInternal(PlayerWrapper playerWrapper, final PlayerWrapper playerWrapper2) {
        MediaSessionLegacyStub mediaSessionLegacyStub = this.sessionLegacyStub;
        this.playerWrapper = playerWrapper2;
        if (playerWrapper != null) {
            MediaSessionImpl$PlayerListener mediaSessionImpl$PlayerListener = this.playerListener;
            mediaSessionImpl$PlayerListener.getClass();
            playerWrapper.removeListener(mediaSessionImpl$PlayerListener);
        }
        ?? r0 = new Player.Listener(this, playerWrapper2) { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener
            public final WeakReference player;
            public final WeakReference session;

            {
                this.session = new WeakReference(this);
                this.player = new WeakReference(playerWrapper2);
            }

            public final MediaLibrarySessionImpl getSession() {
                return (MediaLibrarySessionImpl) this.session.get();
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onAudioAttributesChanged(AudioAttributes audioAttributes) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                if (((PlayerWrapper) this.player.get()) == null) {
                    return;
                }
                session.playerInfo = session.playerInfo.copyWithAudioAttributes(audioAttributes);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
                try {
                    MediaSessionLegacyStub mediaSessionLegacyStub2 = (MediaSessionLegacyStub) session.sessionLegacyStub.controllerLegacyCbForBroadcast.connectResults;
                    if (mediaSessionLegacyStub2.sessionImpl.playerWrapper.getDeviceInfo().playbackType == 0) {
                        ((MediaSessionCompat$MediaSessionImplApi23) mediaSessionLegacyStub2.sessionCompat.mCallback).sessionFwk.setPlaybackToLocal(audioAttributes.getPlatformAudioAttributes());
                    }
                } catch (RemoteException e) {
                    Log.e("MediaSessionImpl", "Exception in using media1 API", e);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onAudioSessionIdChanged(int i) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                if (((PlayerWrapper) this.player.get()) == null) {
                    return;
                }
                PlayerInfo playerInfo = session.playerInfo;
                PlaybackException playbackException = playerInfo.playerError;
                int i2 = playerInfo.mediaItemTransitionReason;
                SessionPositionInfo sessionPositionInfo = playerInfo.sessionPositionInfo;
                Player.PositionInfo positionInfo = playerInfo.oldPositionInfo;
                Player.PositionInfo positionInfo2 = playerInfo.newPositionInfo;
                int i3 = playerInfo.discontinuityReason;
                PlaybackParameters playbackParameters = playerInfo.playbackParameters;
                int i4 = playerInfo.repeatMode;
                boolean z = playerInfo.shuffleModeEnabled;
                Timeline timeline = playerInfo.timeline;
                int i5 = playerInfo.timelineChangeReason;
                VideoSize videoSize = playerInfo.videoSize;
                MediaMetadata mediaMetadata = playerInfo.playlistMetadata;
                float f = playerInfo.volume;
                float f2 = playerInfo.unmuteVolume;
                AudioAttributes audioAttributes = playerInfo.audioAttributes;
                CueGroup cueGroup = playerInfo.cueGroup;
                DeviceInfo deviceInfo = playerInfo.deviceInfo;
                int i6 = playerInfo.deviceVolume;
                boolean z2 = playerInfo.deviceMuted;
                boolean z3 = playerInfo.playWhenReady;
                int i7 = playerInfo.playWhenReadyChangeReason;
                boolean z4 = playerInfo.isPlaying;
                boolean z5 = playerInfo.isLoading;
                int i8 = playerInfo.playbackSuppressionReason;
                int i9 = playerInfo.playbackState;
                MediaMetadata mediaMetadata2 = playerInfo.mediaMetadata;
                long j = playerInfo.seekBackIncrementMs;
                long j2 = playerInfo.seekForwardIncrementMs;
                long j3 = playerInfo.maxSeekToPreviousPositionMs;
                Tracks tracks = playerInfo.currentTracks;
                TrackSelectionParameters trackSelectionParameters = playerInfo.trackSelectionParameters;
                UtilsKt.checkState(timeline.isEmpty() || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
                session.playerInfo = new PlayerInfo(playbackException, i2, sessionPositionInfo, positionInfo, positionInfo2, i3, playbackParameters, i4, z, videoSize, timeline, i5, mediaMetadata, f, f2, audioAttributes, i, cueGroup, deviceInfo, i6, z2, z3, i7, i8, i9, z4, z5, mediaMetadata2, j, j2, j3, tracks, trackSelectionParameters);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
                try {
                    session.sessionLegacyStub.controllerLegacyCbForBroadcast.getClass();
                } catch (RemoteException e) {
                    Log.e("MediaSessionImpl", "Exception in using media1 API", e);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onAvailableCommandsChanged(Player.Commands commands) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                if (((PlayerWrapper) this.player.get()) == null) {
                    return;
                }
                session.handleAvailablePlayerCommandsChanged(commands);
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onCues(CueGroup cueGroup) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                if (((PlayerWrapper) this.player.get()) == null) {
                    return;
                }
                PlayerInfo playerInfo = session.playerInfo;
                PlaybackException playbackException = playerInfo.playerError;
                int i = playerInfo.mediaItemTransitionReason;
                SessionPositionInfo sessionPositionInfo = playerInfo.sessionPositionInfo;
                Player.PositionInfo positionInfo = playerInfo.oldPositionInfo;
                Player.PositionInfo positionInfo2 = playerInfo.newPositionInfo;
                int i2 = playerInfo.discontinuityReason;
                PlaybackParameters playbackParameters = playerInfo.playbackParameters;
                int i3 = playerInfo.repeatMode;
                boolean z = playerInfo.shuffleModeEnabled;
                Timeline timeline = playerInfo.timeline;
                int i4 = playerInfo.timelineChangeReason;
                VideoSize videoSize = playerInfo.videoSize;
                MediaMetadata mediaMetadata = playerInfo.playlistMetadata;
                float f = playerInfo.volume;
                float f2 = playerInfo.unmuteVolume;
                int i5 = playerInfo.audioSessionId;
                AudioAttributes audioAttributes = playerInfo.audioAttributes;
                DeviceInfo deviceInfo = playerInfo.deviceInfo;
                int i6 = playerInfo.deviceVolume;
                boolean z2 = playerInfo.deviceMuted;
                boolean z3 = playerInfo.playWhenReady;
                int i7 = playerInfo.playWhenReadyChangeReason;
                boolean z4 = playerInfo.isPlaying;
                boolean z5 = playerInfo.isLoading;
                int i8 = playerInfo.playbackSuppressionReason;
                int i9 = playerInfo.playbackState;
                MediaMetadata mediaMetadata2 = playerInfo.mediaMetadata;
                long j = playerInfo.seekBackIncrementMs;
                long j2 = playerInfo.seekForwardIncrementMs;
                long j3 = playerInfo.maxSeekToPreviousPositionMs;
                Tracks tracks = playerInfo.currentTracks;
                TrackSelectionParameters trackSelectionParameters = playerInfo.trackSelectionParameters;
                UtilsKt.checkState(timeline.isEmpty() || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
                session.playerInfo = new PlayerInfo(playbackException, i, sessionPositionInfo, positionInfo, positionInfo2, i2, playbackParameters, i3, z, videoSize, timeline, i4, mediaMetadata, f, f2, audioAttributes, i5, cueGroup, deviceInfo, i6, z2, z3, i7, i8, i9, z4, z5, mediaMetadata2, j, j2, j3, tracks, trackSelectionParameters);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onDeviceInfoChanged(DeviceInfo deviceInfo) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                if (((PlayerWrapper) this.player.get()) == null) {
                    return;
                }
                PlayerInfo playerInfo = session.playerInfo;
                PlaybackException playbackException = playerInfo.playerError;
                int i = playerInfo.mediaItemTransitionReason;
                SessionPositionInfo sessionPositionInfo = playerInfo.sessionPositionInfo;
                Player.PositionInfo positionInfo = playerInfo.oldPositionInfo;
                Player.PositionInfo positionInfo2 = playerInfo.newPositionInfo;
                int i2 = playerInfo.discontinuityReason;
                PlaybackParameters playbackParameters = playerInfo.playbackParameters;
                int i3 = playerInfo.repeatMode;
                boolean z = playerInfo.shuffleModeEnabled;
                Timeline timeline = playerInfo.timeline;
                int i4 = playerInfo.timelineChangeReason;
                VideoSize videoSize = playerInfo.videoSize;
                MediaMetadata mediaMetadata = playerInfo.playlistMetadata;
                float f = playerInfo.volume;
                float f2 = playerInfo.unmuteVolume;
                int i5 = playerInfo.audioSessionId;
                AudioAttributes audioAttributes = playerInfo.audioAttributes;
                CueGroup cueGroup = playerInfo.cueGroup;
                int i6 = playerInfo.deviceVolume;
                boolean z2 = playerInfo.deviceMuted;
                boolean z3 = playerInfo.playWhenReady;
                int i7 = playerInfo.playWhenReadyChangeReason;
                boolean z4 = playerInfo.isPlaying;
                boolean z5 = playerInfo.isLoading;
                int i8 = playerInfo.playbackSuppressionReason;
                int i9 = playerInfo.playbackState;
                MediaMetadata mediaMetadata2 = playerInfo.mediaMetadata;
                long j = playerInfo.seekBackIncrementMs;
                long j2 = playerInfo.seekForwardIncrementMs;
                long j3 = playerInfo.maxSeekToPreviousPositionMs;
                Tracks tracks = playerInfo.currentTracks;
                TrackSelectionParameters trackSelectionParameters = playerInfo.trackSelectionParameters;
                UtilsKt.checkState(timeline.isEmpty() || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
                session.playerInfo = new PlayerInfo(playbackException, i, sessionPositionInfo, positionInfo, positionInfo2, i2, playbackParameters, i3, z, videoSize, timeline, i4, mediaMetadata, f, f2, audioAttributes, i5, cueGroup, deviceInfo, i6, z2, z3, i7, i8, i9, z4, z5, mediaMetadata2, j, j2, j3, tracks, trackSelectionParameters);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
                try {
                    session.sessionLegacyStub.controllerLegacyCbForBroadcast.onDeviceInfoChanged();
                } catch (RemoteException e) {
                    Log.e("MediaSessionImpl", "Exception in using media1 API", e);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onDeviceVolumeChanged(int i, boolean z) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                if (((PlayerWrapper) this.player.get()) == null) {
                    return;
                }
                session.playerInfo = session.playerInfo.copyWithDeviceVolume(i, z);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
                try {
                    MediaSessionLegacyStub.AnonymousClass3 anonymousClass3 = ((MediaSessionLegacyStub) session.sessionLegacyStub.controllerLegacyCbForBroadcast.connectResults).volumeProviderCompat;
                    if (anonymousClass3 != null) {
                        if (z) {
                            i = 0;
                        }
                        anonymousClass3.currentVolume = i;
                        anonymousClass3.getVolumeProvider().setCurrentVolume(i);
                    }
                } catch (RemoteException e) {
                    Log.e("MediaSessionImpl", "Exception in using media1 API", e);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onIsLoadingChanged(boolean z) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                if (((PlayerWrapper) this.player.get()) == null) {
                    return;
                }
                PlayerInfo playerInfo = session.playerInfo;
                PlaybackException playbackException = playerInfo.playerError;
                int i = playerInfo.mediaItemTransitionReason;
                SessionPositionInfo sessionPositionInfo = playerInfo.sessionPositionInfo;
                Player.PositionInfo positionInfo = playerInfo.oldPositionInfo;
                Player.PositionInfo positionInfo2 = playerInfo.newPositionInfo;
                int i2 = playerInfo.discontinuityReason;
                PlaybackParameters playbackParameters = playerInfo.playbackParameters;
                int i3 = playerInfo.repeatMode;
                boolean z2 = playerInfo.shuffleModeEnabled;
                Timeline timeline = playerInfo.timeline;
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
                int i8 = playerInfo.playbackSuppressionReason;
                int i9 = playerInfo.playbackState;
                MediaMetadata mediaMetadata2 = playerInfo.mediaMetadata;
                long j = playerInfo.seekBackIncrementMs;
                long j2 = playerInfo.seekForwardIncrementMs;
                long j3 = playerInfo.maxSeekToPreviousPositionMs;
                Tracks tracks = playerInfo.currentTracks;
                TrackSelectionParameters trackSelectionParameters = playerInfo.trackSelectionParameters;
                UtilsKt.checkState(timeline.isEmpty() || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
                session.playerInfo = new PlayerInfo(playbackException, i, sessionPositionInfo, positionInfo, positionInfo2, i2, playbackParameters, i3, z2, videoSize, timeline, i4, mediaMetadata, f, f2, audioAttributes, i5, cueGroup, deviceInfo, i6, z3, z4, i7, i8, i9, z5, z, mediaMetadata2, j, j2, j3, tracks, trackSelectionParameters);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
                try {
                    session.sessionLegacyStub.controllerLegacyCbForBroadcast.getClass();
                } catch (RemoteException e) {
                    Log.e("MediaSessionImpl", "Exception in using media1 API", e);
                }
                session.schedulePeriodicSessionPositionInfoChanges();
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onIsPlayingChanged(boolean z) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                if (((PlayerWrapper) this.player.get()) == null) {
                    return;
                }
                PlayerInfo playerInfo = session.playerInfo;
                PlaybackException playbackException = playerInfo.playerError;
                int i = playerInfo.mediaItemTransitionReason;
                SessionPositionInfo sessionPositionInfo = playerInfo.sessionPositionInfo;
                Player.PositionInfo positionInfo = playerInfo.oldPositionInfo;
                Player.PositionInfo positionInfo2 = playerInfo.newPositionInfo;
                int i2 = playerInfo.discontinuityReason;
                PlaybackParameters playbackParameters = playerInfo.playbackParameters;
                int i3 = playerInfo.repeatMode;
                boolean z2 = playerInfo.shuffleModeEnabled;
                Timeline timeline = playerInfo.timeline;
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
                boolean z5 = playerInfo.isLoading;
                int i8 = playerInfo.playbackSuppressionReason;
                int i9 = playerInfo.playbackState;
                MediaMetadata mediaMetadata2 = playerInfo.mediaMetadata;
                long j = playerInfo.seekBackIncrementMs;
                long j2 = playerInfo.seekForwardIncrementMs;
                long j3 = playerInfo.maxSeekToPreviousPositionMs;
                Tracks tracks = playerInfo.currentTracks;
                TrackSelectionParameters trackSelectionParameters = playerInfo.trackSelectionParameters;
                UtilsKt.checkState(timeline.isEmpty() || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
                session.playerInfo = new PlayerInfo(playbackException, i, sessionPositionInfo, positionInfo, positionInfo2, i2, playbackParameters, i3, z2, videoSize, timeline, i4, mediaMetadata, f, f2, audioAttributes, i5, cueGroup, deviceInfo, i6, z3, z4, i7, i8, i9, z, z5, mediaMetadata2, j, j2, j3, tracks, trackSelectionParameters);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
                try {
                    MediaSessionLegacyStub mediaSessionLegacyStub2 = (MediaSessionLegacyStub) session.sessionLegacyStub.controllerLegacyCbForBroadcast.connectResults;
                    mediaSessionLegacyStub2.updateLegacySessionPlaybackState(mediaSessionLegacyStub2.sessionImpl.playerWrapper);
                } catch (RemoteException e) {
                    Log.e("MediaSessionImpl", "Exception in using media1 API", e);
                }
                session.schedulePeriodicSessionPositionInfoChanges();
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onMaxSeekToPreviousPositionChanged(long j) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                if (((PlayerWrapper) this.player.get()) == null) {
                    return;
                }
                PlayerInfo playerInfo = session.playerInfo;
                PlaybackException playbackException = playerInfo.playerError;
                int i = playerInfo.mediaItemTransitionReason;
                SessionPositionInfo sessionPositionInfo = playerInfo.sessionPositionInfo;
                Player.PositionInfo positionInfo = playerInfo.oldPositionInfo;
                Player.PositionInfo positionInfo2 = playerInfo.newPositionInfo;
                int i2 = playerInfo.discontinuityReason;
                PlaybackParameters playbackParameters = playerInfo.playbackParameters;
                int i3 = playerInfo.repeatMode;
                boolean z = playerInfo.shuffleModeEnabled;
                Timeline timeline = playerInfo.timeline;
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
                boolean z2 = playerInfo.deviceMuted;
                boolean z3 = playerInfo.playWhenReady;
                int i7 = playerInfo.playWhenReadyChangeReason;
                boolean z4 = playerInfo.isPlaying;
                boolean z5 = playerInfo.isLoading;
                int i8 = playerInfo.playbackSuppressionReason;
                int i9 = playerInfo.playbackState;
                MediaMetadata mediaMetadata2 = playerInfo.mediaMetadata;
                long j2 = playerInfo.seekBackIncrementMs;
                long j3 = playerInfo.seekForwardIncrementMs;
                Tracks tracks = playerInfo.currentTracks;
                TrackSelectionParameters trackSelectionParameters = playerInfo.trackSelectionParameters;
                UtilsKt.checkState(timeline.isEmpty() || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
                session.playerInfo = new PlayerInfo(playbackException, i, sessionPositionInfo, positionInfo, positionInfo2, i2, playbackParameters, i3, z, videoSize, timeline, i4, mediaMetadata, f, f2, audioAttributes, i5, cueGroup, deviceInfo, i6, z2, z3, i7, i8, i9, z4, z5, mediaMetadata2, j2, j3, j, tracks, trackSelectionParameters);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onMediaItemTransition(int i, MediaItem mediaItem) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                if (((PlayerWrapper) this.player.get()) == null) {
                    return;
                }
                PlayerInfo playerInfo = session.playerInfo;
                PlaybackException playbackException = playerInfo.playerError;
                SessionPositionInfo sessionPositionInfo = playerInfo.sessionPositionInfo;
                Player.PositionInfo positionInfo = playerInfo.oldPositionInfo;
                Player.PositionInfo positionInfo2 = playerInfo.newPositionInfo;
                int i2 = playerInfo.discontinuityReason;
                PlaybackParameters playbackParameters = playerInfo.playbackParameters;
                int i3 = playerInfo.repeatMode;
                boolean z = playerInfo.shuffleModeEnabled;
                Timeline timeline = playerInfo.timeline;
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
                boolean z2 = playerInfo.deviceMuted;
                boolean z3 = playerInfo.playWhenReady;
                int i7 = playerInfo.playWhenReadyChangeReason;
                boolean z4 = playerInfo.isPlaying;
                boolean z5 = playerInfo.isLoading;
                int i8 = playerInfo.playbackSuppressionReason;
                int i9 = playerInfo.playbackState;
                MediaMetadata mediaMetadata2 = playerInfo.mediaMetadata;
                long j = playerInfo.seekBackIncrementMs;
                long j2 = playerInfo.seekForwardIncrementMs;
                long j3 = playerInfo.maxSeekToPreviousPositionMs;
                Tracks tracks = playerInfo.currentTracks;
                TrackSelectionParameters trackSelectionParameters = playerInfo.trackSelectionParameters;
                UtilsKt.checkState(timeline.isEmpty() || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
                session.playerInfo = new PlayerInfo(playbackException, i, sessionPositionInfo, positionInfo, positionInfo2, i2, playbackParameters, i3, z, videoSize, timeline, i4, mediaMetadata, f, f2, audioAttributes, i5, cueGroup, deviceInfo, i6, z2, z3, i7, i8, i9, z4, z5, mediaMetadata2, j, j2, j3, tracks, trackSelectionParameters);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
                try {
                    session.sessionLegacyStub.controllerLegacyCbForBroadcast.onMediaItemTransition(mediaItem);
                } catch (RemoteException e) {
                    Log.e("MediaSessionImpl", "Exception in using media1 API", e);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                if (((PlayerWrapper) this.player.get()) == null) {
                    return;
                }
                PlayerInfo playerInfo = session.playerInfo;
                PlaybackException playbackException = playerInfo.playerError;
                int i = playerInfo.mediaItemTransitionReason;
                SessionPositionInfo sessionPositionInfo = playerInfo.sessionPositionInfo;
                Player.PositionInfo positionInfo = playerInfo.oldPositionInfo;
                Player.PositionInfo positionInfo2 = playerInfo.newPositionInfo;
                int i2 = playerInfo.discontinuityReason;
                PlaybackParameters playbackParameters = playerInfo.playbackParameters;
                int i3 = playerInfo.repeatMode;
                boolean z = playerInfo.shuffleModeEnabled;
                Timeline timeline = playerInfo.timeline;
                int i4 = playerInfo.timelineChangeReason;
                VideoSize videoSize = playerInfo.videoSize;
                MediaMetadata mediaMetadata2 = playerInfo.playlistMetadata;
                float f = playerInfo.volume;
                float f2 = playerInfo.unmuteVolume;
                int i5 = playerInfo.audioSessionId;
                AudioAttributes audioAttributes = playerInfo.audioAttributes;
                CueGroup cueGroup = playerInfo.cueGroup;
                DeviceInfo deviceInfo = playerInfo.deviceInfo;
                int i6 = playerInfo.deviceVolume;
                boolean z2 = playerInfo.deviceMuted;
                boolean z3 = playerInfo.playWhenReady;
                int i7 = playerInfo.playWhenReadyChangeReason;
                boolean z4 = playerInfo.isPlaying;
                boolean z5 = playerInfo.isLoading;
                int i8 = playerInfo.playbackSuppressionReason;
                int i9 = playerInfo.playbackState;
                long j = playerInfo.seekBackIncrementMs;
                long j2 = playerInfo.seekForwardIncrementMs;
                long j3 = playerInfo.maxSeekToPreviousPositionMs;
                Tracks tracks = playerInfo.currentTracks;
                TrackSelectionParameters trackSelectionParameters = playerInfo.trackSelectionParameters;
                UtilsKt.checkState(timeline.isEmpty() || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
                session.playerInfo = new PlayerInfo(playbackException, i, sessionPositionInfo, positionInfo, positionInfo2, i2, playbackParameters, i3, z, videoSize, timeline, i4, mediaMetadata2, f, f2, audioAttributes, i5, cueGroup, deviceInfo, i6, z2, z3, i7, i8, i9, z4, z5, mediaMetadata, j, j2, j3, tracks, trackSelectionParameters);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
                try {
                    session.sessionLegacyStub.controllerLegacyCbForBroadcast.updateMetadataIfChanged();
                } catch (RemoteException e) {
                    Log.e("MediaSessionImpl", "Exception in using media1 API", e);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onPlayWhenReadyChanged(int i, boolean z) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                if (((PlayerWrapper) this.player.get()) == null) {
                    return;
                }
                PlayerInfo playerInfo = session.playerInfo;
                session.playerInfo = playerInfo.copyWithPlayWhenReady(i, z, playerInfo.playbackSuppressionReason);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
                try {
                    MediaSessionLegacyStub mediaSessionLegacyStub2 = (MediaSessionLegacyStub) session.sessionLegacyStub.controllerLegacyCbForBroadcast.connectResults;
                    mediaSessionLegacyStub2.updateLegacySessionPlaybackState(mediaSessionLegacyStub2.sessionImpl.playerWrapper);
                } catch (RemoteException e) {
                    Log.e("MediaSessionImpl", "Exception in using media1 API", e);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                if (((PlayerWrapper) this.player.get()) == null) {
                    return;
                }
                session.playerInfo = session.playerInfo.copyWithPlaybackParameters(playbackParameters);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
                try {
                    MediaSessionLegacyStub mediaSessionLegacyStub2 = (MediaSessionLegacyStub) session.sessionLegacyStub.controllerLegacyCbForBroadcast.connectResults;
                    mediaSessionLegacyStub2.updateLegacySessionPlaybackState(mediaSessionLegacyStub2.sessionImpl.playerWrapper);
                } catch (RemoteException e) {
                    Log.e("MediaSessionImpl", "Exception in using media1 API", e);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onPlaybackStateChanged(int i) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                PlayerWrapper playerWrapper3 = (PlayerWrapper) this.player.get();
                if (playerWrapper3 == null) {
                    return;
                }
                session.playerInfo = session.playerInfo.copyWithPlaybackState(i, playerWrapper3.getPlayerError());
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
                try {
                    FastFallbackExchangeFinder fastFallbackExchangeFinder = session.sessionLegacyStub.controllerLegacyCbForBroadcast;
                    playerWrapper3.getPlayerError();
                    MediaSessionLegacyStub mediaSessionLegacyStub2 = (MediaSessionLegacyStub) fastFallbackExchangeFinder.connectResults;
                    mediaSessionLegacyStub2.updateLegacySessionPlaybackState(mediaSessionLegacyStub2.sessionImpl.playerWrapper);
                } catch (RemoteException e) {
                    Log.e("MediaSessionImpl", "Exception in using media1 API", e);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onPlaybackSuppressionReasonChanged(int i) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                if (((PlayerWrapper) this.player.get()) == null) {
                    return;
                }
                PlayerInfo playerInfo = session.playerInfo;
                session.playerInfo = playerInfo.copyWithPlayWhenReady(playerInfo.playWhenReadyChangeReason, playerInfo.playWhenReady, i);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
                try {
                    MediaSessionLegacyStub mediaSessionLegacyStub2 = (MediaSessionLegacyStub) session.sessionLegacyStub.controllerLegacyCbForBroadcast.connectResults;
                    mediaSessionLegacyStub2.updateLegacySessionPlaybackState(mediaSessionLegacyStub2.sessionImpl.playerWrapper);
                } catch (RemoteException e) {
                    Log.e("MediaSessionImpl", "Exception in using media1 API", e);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onPlayerError(PlaybackException playbackException) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                if (((PlayerWrapper) this.player.get()) == null) {
                    return;
                }
                PlayerInfo playerInfo = session.playerInfo;
                int i = playerInfo.mediaItemTransitionReason;
                SessionPositionInfo sessionPositionInfo = playerInfo.sessionPositionInfo;
                Player.PositionInfo positionInfo = playerInfo.oldPositionInfo;
                Player.PositionInfo positionInfo2 = playerInfo.newPositionInfo;
                int i2 = playerInfo.discontinuityReason;
                PlaybackParameters playbackParameters = playerInfo.playbackParameters;
                int i3 = playerInfo.repeatMode;
                boolean z = playerInfo.shuffleModeEnabled;
                Timeline timeline = playerInfo.timeline;
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
                boolean z2 = playerInfo.deviceMuted;
                boolean z3 = playerInfo.playWhenReady;
                int i7 = playerInfo.playWhenReadyChangeReason;
                boolean z4 = playerInfo.isPlaying;
                boolean z5 = playerInfo.isLoading;
                int i8 = playerInfo.playbackSuppressionReason;
                int i9 = playerInfo.playbackState;
                MediaMetadata mediaMetadata2 = playerInfo.mediaMetadata;
                long j = playerInfo.seekBackIncrementMs;
                long j2 = playerInfo.seekForwardIncrementMs;
                long j3 = playerInfo.maxSeekToPreviousPositionMs;
                Tracks tracks = playerInfo.currentTracks;
                TrackSelectionParameters trackSelectionParameters = playerInfo.trackSelectionParameters;
                UtilsKt.checkState(timeline.isEmpty() || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
                session.playerInfo = new PlayerInfo(playbackException, i, sessionPositionInfo, positionInfo, positionInfo2, i2, playbackParameters, i3, z, videoSize, timeline, i4, mediaMetadata, f, f2, audioAttributes, i5, cueGroup, deviceInfo, i6, z2, z3, i7, i8, i9, z4, z5, mediaMetadata2, j, j2, j3, tracks, trackSelectionParameters);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
                try {
                    MediaSessionLegacyStub mediaSessionLegacyStub2 = (MediaSessionLegacyStub) session.sessionLegacyStub.controllerLegacyCbForBroadcast.connectResults;
                    mediaSessionLegacyStub2.updateLegacySessionPlaybackState(mediaSessionLegacyStub2.sessionImpl.playerWrapper);
                } catch (RemoteException e) {
                    Log.e("MediaSessionImpl", "Exception in using media1 API", e);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                session.playerInfo = session.playerInfo.copyWithPlaylistMetadata(mediaMetadata);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
                try {
                    session.sessionLegacyStub.controllerLegacyCbForBroadcast.onPlaylistMetadataChanged(mediaMetadata);
                } catch (RemoteException e) {
                    Log.e("MediaSessionImpl", "Exception in using media1 API", e);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onPositionDiscontinuity(int i, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                if (((PlayerWrapper) this.player.get()) == null) {
                    return;
                }
                session.playerInfo = session.playerInfo.copyWithPositionInfos(i, positionInfo, positionInfo2);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
                try {
                    MediaSessionLegacyStub mediaSessionLegacyStub2 = (MediaSessionLegacyStub) session.sessionLegacyStub.controllerLegacyCbForBroadcast.connectResults;
                    mediaSessionLegacyStub2.updateLegacySessionPlaybackState(mediaSessionLegacyStub2.sessionImpl.playerWrapper);
                } catch (RemoteException e) {
                    Log.e("MediaSessionImpl", "Exception in using media1 API", e);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onRenderedFirstFrame() {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                Dispatcher dispatcher = session.sessionStub.connectedControllersManager;
                ImmutableList connectedControllers = dispatcher.getConnectedControllers();
                for (int i = 0; i < connectedControllers.size(); i++) {
                    MediaSession$ControllerInfo mediaSession$ControllerInfo = (MediaSession$ControllerInfo) connectedControllers.get(i);
                    dispatcher.getPlaybackException(mediaSession$ControllerInfo);
                    session.dispatchRemoteControllerTaskWithoutReturn(mediaSession$ControllerInfo, new MediaSessionStub$$ExternalSyntheticLambda8((byte) 10));
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onRepeatModeChanged(int i) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                if (((PlayerWrapper) this.player.get()) == null) {
                    return;
                }
                session.playerInfo = session.playerInfo.copyWithRepeatMode(i);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
                try {
                    session.sessionLegacyStub.controllerLegacyCbForBroadcast.onRepeatModeChanged(i);
                } catch (RemoteException e) {
                    Log.e("MediaSessionImpl", "Exception in using media1 API", e);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onSeekBackIncrementChanged(long j) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                if (((PlayerWrapper) this.player.get()) == null) {
                    return;
                }
                PlayerInfo playerInfo = session.playerInfo;
                PlaybackException playbackException = playerInfo.playerError;
                int i = playerInfo.mediaItemTransitionReason;
                SessionPositionInfo sessionPositionInfo = playerInfo.sessionPositionInfo;
                Player.PositionInfo positionInfo = playerInfo.oldPositionInfo;
                Player.PositionInfo positionInfo2 = playerInfo.newPositionInfo;
                int i2 = playerInfo.discontinuityReason;
                PlaybackParameters playbackParameters = playerInfo.playbackParameters;
                int i3 = playerInfo.repeatMode;
                boolean z = playerInfo.shuffleModeEnabled;
                Timeline timeline = playerInfo.timeline;
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
                boolean z2 = playerInfo.deviceMuted;
                boolean z3 = playerInfo.playWhenReady;
                int i7 = playerInfo.playWhenReadyChangeReason;
                boolean z4 = playerInfo.isPlaying;
                boolean z5 = playerInfo.isLoading;
                int i8 = playerInfo.playbackSuppressionReason;
                int i9 = playerInfo.playbackState;
                MediaMetadata mediaMetadata2 = playerInfo.mediaMetadata;
                long j2 = playerInfo.seekForwardIncrementMs;
                long j3 = playerInfo.maxSeekToPreviousPositionMs;
                Tracks tracks = playerInfo.currentTracks;
                TrackSelectionParameters trackSelectionParameters = playerInfo.trackSelectionParameters;
                UtilsKt.checkState(timeline.isEmpty() || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
                session.playerInfo = new PlayerInfo(playbackException, i, sessionPositionInfo, positionInfo, positionInfo2, i2, playbackParameters, i3, z, videoSize, timeline, i4, mediaMetadata, f, f2, audioAttributes, i5, cueGroup, deviceInfo, i6, z2, z3, i7, i8, i9, z4, z5, mediaMetadata2, j, j2, j3, tracks, trackSelectionParameters);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
                try {
                    session.sessionLegacyStub.controllerLegacyCbForBroadcast.getClass();
                } catch (RemoteException e) {
                    Log.e("MediaSessionImpl", "Exception in using media1 API", e);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onSeekForwardIncrementChanged(long j) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                if (((PlayerWrapper) this.player.get()) == null) {
                    return;
                }
                PlayerInfo playerInfo = session.playerInfo;
                PlaybackException playbackException = playerInfo.playerError;
                int i = playerInfo.mediaItemTransitionReason;
                SessionPositionInfo sessionPositionInfo = playerInfo.sessionPositionInfo;
                Player.PositionInfo positionInfo = playerInfo.oldPositionInfo;
                Player.PositionInfo positionInfo2 = playerInfo.newPositionInfo;
                int i2 = playerInfo.discontinuityReason;
                PlaybackParameters playbackParameters = playerInfo.playbackParameters;
                int i3 = playerInfo.repeatMode;
                boolean z = playerInfo.shuffleModeEnabled;
                Timeline timeline = playerInfo.timeline;
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
                boolean z2 = playerInfo.deviceMuted;
                boolean z3 = playerInfo.playWhenReady;
                int i7 = playerInfo.playWhenReadyChangeReason;
                boolean z4 = playerInfo.isPlaying;
                boolean z5 = playerInfo.isLoading;
                int i8 = playerInfo.playbackSuppressionReason;
                int i9 = playerInfo.playbackState;
                MediaMetadata mediaMetadata2 = playerInfo.mediaMetadata;
                long j2 = playerInfo.seekBackIncrementMs;
                long j3 = playerInfo.maxSeekToPreviousPositionMs;
                Tracks tracks = playerInfo.currentTracks;
                TrackSelectionParameters trackSelectionParameters = playerInfo.trackSelectionParameters;
                UtilsKt.checkState(timeline.isEmpty() || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
                session.playerInfo = new PlayerInfo(playbackException, i, sessionPositionInfo, positionInfo, positionInfo2, i2, playbackParameters, i3, z, videoSize, timeline, i4, mediaMetadata, f, f2, audioAttributes, i5, cueGroup, deviceInfo, i6, z2, z3, i7, i8, i9, z4, z5, mediaMetadata2, j2, j, j3, tracks, trackSelectionParameters);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
                try {
                    session.sessionLegacyStub.controllerLegacyCbForBroadcast.getClass();
                } catch (RemoteException e) {
                    Log.e("MediaSessionImpl", "Exception in using media1 API", e);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onShuffleModeEnabledChanged(boolean z) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                if (((PlayerWrapper) this.player.get()) == null) {
                    return;
                }
                session.playerInfo = session.playerInfo.copyWithShuffleModeEnabled(z);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
                try {
                    session.sessionLegacyStub.controllerLegacyCbForBroadcast.onShuffleModeEnabledChanged(z);
                } catch (RemoteException e) {
                    Log.e("MediaSessionImpl", "Exception in using media1 API", e);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onSurfaceSizeChanged(int i, int i2) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                if (((PlayerWrapper) this.player.get()) == null) {
                    return;
                }
                session.dispatchRemoteControllerTaskWithoutReturn(new ExoPlayerImpl$$ExternalSyntheticLambda24(i, i2, (byte) 3));
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onTimelineChanged(Timeline timeline, int i) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                PlayerWrapper playerWrapper3 = (PlayerWrapper) this.player.get();
                if (playerWrapper3 == null) {
                    return;
                }
                session.playerInfo = session.playerInfo.copyWithTimelineAndSessionPositionInfo(timeline, playerWrapper3.createSessionPositionInfo(), i);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(false, true);
                try {
                    session.sessionLegacyStub.controllerLegacyCbForBroadcast.onTimelineChanged(timeline);
                } catch (RemoteException e) {
                    Log.e("MediaSessionImpl", "Exception in using media1 API", e);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                if (((PlayerWrapper) this.player.get()) == null) {
                    return;
                }
                session.playerInfo = session.playerInfo.copyWithTrackSelectionParameters(trackSelectionParameters);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
                session.dispatchRemoteControllerTaskWithoutReturn(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 8));
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onTracksChanged(Tracks tracks) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                if (((PlayerWrapper) this.player.get()) == null) {
                    return;
                }
                session.playerInfo = session.playerInfo.copyWithCurrentTracks(tracks);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, false);
                session.dispatchRemoteControllerTaskWithoutReturn(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 9));
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onVideoSizeChanged(VideoSize videoSize) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                PlayerInfo playerInfo = session.playerInfo;
                PlaybackException playbackException = playerInfo.playerError;
                int i = playerInfo.mediaItemTransitionReason;
                SessionPositionInfo sessionPositionInfo = playerInfo.sessionPositionInfo;
                Player.PositionInfo positionInfo = playerInfo.oldPositionInfo;
                Player.PositionInfo positionInfo2 = playerInfo.newPositionInfo;
                int i2 = playerInfo.discontinuityReason;
                PlaybackParameters playbackParameters = playerInfo.playbackParameters;
                int i3 = playerInfo.repeatMode;
                boolean z = playerInfo.shuffleModeEnabled;
                Timeline timeline = playerInfo.timeline;
                int i4 = playerInfo.timelineChangeReason;
                MediaMetadata mediaMetadata = playerInfo.playlistMetadata;
                float f = playerInfo.volume;
                float f2 = playerInfo.unmuteVolume;
                int i5 = playerInfo.audioSessionId;
                AudioAttributes audioAttributes = playerInfo.audioAttributes;
                CueGroup cueGroup = playerInfo.cueGroup;
                DeviceInfo deviceInfo = playerInfo.deviceInfo;
                int i6 = playerInfo.deviceVolume;
                boolean z2 = playerInfo.deviceMuted;
                boolean z3 = playerInfo.playWhenReady;
                int i7 = playerInfo.playWhenReadyChangeReason;
                boolean z4 = playerInfo.isPlaying;
                boolean z5 = playerInfo.isLoading;
                int i8 = playerInfo.playbackSuppressionReason;
                int i9 = playerInfo.playbackState;
                MediaMetadata mediaMetadata2 = playerInfo.mediaMetadata;
                long j = playerInfo.seekBackIncrementMs;
                long j2 = playerInfo.seekForwardIncrementMs;
                long j3 = playerInfo.maxSeekToPreviousPositionMs;
                Tracks tracks = playerInfo.currentTracks;
                TrackSelectionParameters trackSelectionParameters = playerInfo.trackSelectionParameters;
                UtilsKt.checkState(timeline.isEmpty() || sessionPositionInfo.positionInfo.mediaItemIndex < timeline.getWindowCount());
                session.playerInfo = new PlayerInfo(playbackException, i, sessionPositionInfo, positionInfo, positionInfo2, i2, playbackParameters, i3, z, videoSize, timeline, i4, mediaMetadata, f, f2, audioAttributes, i5, cueGroup, deviceInfo, i6, z2, z3, i7, i8, i9, z4, z5, mediaMetadata2, j, j2, j3, tracks, trackSelectionParameters);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
                try {
                    session.sessionLegacyStub.controllerLegacyCbForBroadcast.getClass();
                } catch (RemoteException e) {
                    Log.e("MediaSessionImpl", "Exception in using media1 API", e);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public final void onVolumeChanged(float f) {
                MediaLibrarySessionImpl session = getSession();
                if (session == null) {
                    return;
                }
                session.verifyApplicationThread();
                session.playerInfo = session.playerInfo.copyWithVolume(f);
                session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
                try {
                    session.sessionLegacyStub.controllerLegacyCbForBroadcast.getClass();
                } catch (RemoteException e) {
                    Log.e("MediaSessionImpl", "Exception in using media1 API", e);
                }
            }
        };
        playerWrapper2.addListener(r0);
        this.playerListener = r0;
        try {
            mediaSessionLegacyStub.controllerLegacyCbForBroadcast.onPlayerChanged(0, playerWrapper, playerWrapper2);
        } catch (RemoteException e) {
            Log.e("MediaSessionImpl", "Exception in using media1 API", e);
        }
        if (playerWrapper == null) {
            ((MediaSessionCompat$MediaSessionImplApi23) mediaSessionLegacyStub.sessionCompat.mCallback).sessionFwk.setActive(true);
        }
        this.playerInfo = new PlayerInfo(playerWrapper2.getPlayerError(), 0, playerWrapper2.createSessionPositionInfo(), playerWrapper2.createPositionInfo(), playerWrapper2.createPositionInfo(), 0, playerWrapper2.getPlaybackParameters(), playerWrapper2.getRepeatMode(), playerWrapper2.getShuffleModeEnabled(), playerWrapper2.getVideoSize(), playerWrapper2.getCurrentTimelineWithCommandCheck(), 0, playerWrapper2.isCommandAvailable(18) ? playerWrapper2.getPlaylistMetadata() : MediaMetadata.EMPTY, playerWrapper2.isCommandAvailable(22) ? playerWrapper2.getVolume() : 1.0f, 1.0f, playerWrapper2.isCommandAvailable(21) ? playerWrapper2.getAudioAttributes() : AudioAttributes.DEFAULT, 0, playerWrapper2.isCommandAvailable(28) ? playerWrapper2.getCurrentCues() : CueGroup.EMPTY_TIME_ZERO, playerWrapper2.getDeviceInfo(), playerWrapper2.isCommandAvailable(23) ? playerWrapper2.getDeviceVolume() : 0, playerWrapper2.isDeviceMutedWithCommandCheck(), playerWrapper2.getPlayWhenReady(), 1, playerWrapper2.getPlaybackSuppressionReason(), playerWrapper2.getPlaybackState(), playerWrapper2.isPlaying(), playerWrapper2.isLoading(), playerWrapper2.getMediaMetadataWithCommandCheck(), playerWrapper2.getSeekBackIncrement(), playerWrapper2.getSeekForwardIncrement(), playerWrapper2.getMaxSeekToPreviousPosition(), playerWrapper2.isCommandAvailable(30) ? playerWrapper2.getCurrentTracks() : Tracks.EMPTY, playerWrapper2.getTrackSelectionParameters());
        handleAvailablePlayerCommandsChanged(playerWrapper2.getAvailableCommands());
    }

    public final void verifyApplicationThread() {
        if (Looper.myLooper() == this.applicationHandler.getLooper()) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Player callback method is called from a wrong thread. See javadoc of MediaSession for details.");
    }

    public final void dispatchRemoteControllerTaskWithoutReturn(MediaSessionImpl$RemoteControllerTask mediaSessionImpl$RemoteControllerTask) {
        ImmutableList connectedControllers = this.sessionStub.connectedControllersManager.getConnectedControllers();
        for (int i = 0; i < connectedControllers.size(); i++) {
            dispatchRemoteControllerTaskWithoutReturn((MediaSession$ControllerInfo) connectedControllers.get(i), mediaSessionImpl$RemoteControllerTask);
        }
        try {
            mediaSessionImpl$RemoteControllerTask.run(this.sessionLegacyStub.controllerLegacyCbForBroadcast, 0);
        } catch (RemoteException e) {
            Log.e("MediaSessionImpl", "Exception in using media1 API", e);
        }
    }
}
