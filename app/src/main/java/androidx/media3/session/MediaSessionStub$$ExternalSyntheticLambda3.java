package androidx.media3.session;

import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.compose.ui.node.NodeChain;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.ConnectionState.InProcessBinder;
import androidx.media3.session.legacy.MediaBrowserServiceCompat$Result;
import androidx.media3.session.legacy.MediaSessionCompat$MediaSessionImplApi23;
import androidx.media3.session.legacy.MediaSessionCompat$QueueItem;
import androidx.sqlite.SQLite;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.DirectExecutor;
import com.google.common.util.concurrent.ImmediateFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.uuid.UuidKt;
import okhttp3.Dispatcher;
import okhttp3.internal.connection.FastFallbackExchangeFinder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionStub$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ MediaSessionStub$$ExternalSyntheticLambda3(MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub, AtomicReference atomicReference, MediaSession$ControllerInfo mediaSession$ControllerInfo, ConditionVariable conditionVariable) {
        this.$r8$classId = (byte) 8;
        this.f$0 = mediaLibraryServiceLegacyStub;
        this.f$2 = atomicReference;
        this.f$1 = mediaSession$ControllerInfo;
        this.f$3 = conditionVariable;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        IMediaController iMediaController;
        int i;
        Bundle bundleForRemoteProcess;
        Bitmap bitmap;
        Bitmap bitmap2;
        byte b = 1;
        int i2 = 0;
        switch (this.$r8$classId) {
            case 0:
                MediaSessionStub mediaSessionStub = (MediaSessionStub) this.f$0;
                MediaSession$ControllerInfo mediaSession$ControllerInfo = (MediaSession$ControllerInfo) this.f$1;
                MediaLibrarySessionImpl mediaLibrarySessionImpl = (MediaLibrarySessionImpl) this.f$2;
                IMediaController iMediaController2 = (IMediaController) this.f$3;
                Dispatcher dispatcher = mediaSessionStub.connectedControllersManager;
                try {
                    mediaSessionStub.pendingControllers.remove(mediaSession$ControllerInfo);
                    if (!mediaLibrarySessionImpl.isReleased()) {
                        MediaSessionStub.Controller2Cb controller2Cb = (MediaSessionStub.Controller2Cb) mediaSession$ControllerInfo.controllerCb;
                        controller2Cb.getClass();
                        IBinder iBinderAsBinder = controller2Cb.iController.asBinder();
                        MediaSession$ConnectionResult mediaSession$ConnectionResultOnConnectOnHandler = mediaLibrarySessionImpl.onConnectOnHandler(mediaSession$ControllerInfo);
                        if (dispatcher.isConnected(mediaSession$ControllerInfo)) {
                            Log.w("MediaSessionStub", "Controller " + mediaSession$ControllerInfo + " has sent connection request multiple times");
                        }
                        dispatcher.addController(iBinderAsBinder, mediaSession$ControllerInfo, mediaSession$ConnectionResultOnConnectOnHandler.availableSessionCommands, mediaSession$ConnectionResultOnConnectOnHandler.availablePlayerCommands);
                        NodeChain.Differ sequencedFutureManager = dispatcher.getSequencedFutureManager(mediaSession$ControllerInfo);
                        if (sequencedFutureManager == null) {
                            Log.w("MediaSessionStub", "Ignoring connection request from unknown controller info");
                        } else {
                            PlayerWrapper playerWrapper = mediaLibrarySessionImpl.playerWrapper;
                            PlayerInfo playerInfo = mediaLibrarySessionImpl.playerInfo;
                            Player.Commands commands = mediaSession$ConnectionResultOnConnectOnHandler.availablePlayerCommands;
                            PlayerInfo playerInfoUpdatePlayerInfoWithUniqueTrackGroupIds = mediaSessionStub.updatePlayerInfoWithUniqueTrackGroupIds(playerInfo);
                            MediaSession.Token token = ((MediaSessionCompat$MediaSessionImplApi23) mediaLibrarySessionImpl.sessionLegacyStub.sessionCompat.mCallback).token.inner;
                            PendingIntent pendingIntent = mediaLibrarySessionImpl.sessionActivity;
                            ImmutableList immutableList = mediaSession$ConnectionResultOnConnectOnHandler.customLayout;
                            if (immutableList == null) {
                                immutableList = mediaLibrarySessionImpl.customLayout;
                            }
                            ImmutableList immutableList2 = mediaSession$ConnectionResultOnConnectOnHandler.mediaButtonPreferences;
                            if (immutableList2 == null) {
                                immutableList2 = mediaLibrarySessionImpl.mediaButtonPreferences;
                            }
                            iMediaController = iMediaController2;
                            try {
                                ConnectionState connectionState = new ConnectionState(1010001300, 9, mediaSessionStub, pendingIntent, immutableList, immutableList2, mediaLibrarySessionImpl.commandButtonsForMediaItems, mediaSession$ConnectionResultOnConnectOnHandler.availableSessionCommands, commands, playerWrapper.getAvailableCommands(), mediaLibrarySessionImpl.sessionToken.impl.getExtras(), mediaLibrarySessionImpl.sessionExtras, playerInfoUpdatePlayerInfoWithUniqueTrackGroupIds, token);
                                if (!mediaLibrarySessionImpl.isReleased()) {
                                    try {
                                        int iObtainNextSequenceNumber = sequencedFutureManager.obtainNextSequenceNumber();
                                        if (iMediaController instanceof MediaControllerStub) {
                                            bundleForRemoteProcess = new Bundle();
                                            bundleForRemoteProcess.putBinder(ConnectionState.FIELD_IN_PROCESS_BINDER, connectionState.new InProcessBinder());
                                        } else {
                                            bundleForRemoteProcess = connectionState.toBundleForRemoteProcess(mediaSession$ControllerInfo.interfaceVersion);
                                        }
                                        iMediaController.onConnected(iObtainNextSequenceNumber, bundleForRemoteProcess);
                                        i = 1;
                                    } catch (RemoteException unused) {
                                        i = 0;
                                    }
                                    if (i != 0) {
                                        try {
                                            if (!mediaLibrarySessionImpl.isMediaNotificationControllerConnected || !MediaLibrarySessionImpl.isSystemUiController(mediaSession$ControllerInfo)) {
                                                mediaLibrarySessionImpl.callback$1.getClass();
                                                break;
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            i2 = i;
                                            if (i2 == 0) {
                                                SQLite.disconnectIMediaController(iMediaController);
                                            }
                                            throw th;
                                        }
                                    }
                                    if (i != 0) {
                                        return;
                                    }
                                }
                                SQLite.disconnectIMediaController(iMediaController);
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    }
                    SQLite.disconnectIMediaController(iMediaController2);
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    iMediaController = iMediaController2;
                }
                break;
            case 1:
                Dispatcher dispatcher2 = (Dispatcher) this.f$0;
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.f$1;
                ConnectedControllersManager$ConnectedControllerRecord connectedControllersManager$ConnectedControllerRecord = (ConnectedControllersManager$ConnectedControllerRecord) this.f$2;
                AtomicBoolean atomicBoolean2 = (AtomicBoolean) this.f$3;
                synchronized (dispatcher2.executorServiceOrNull) {
                    try {
                        if (atomicBoolean.get()) {
                            atomicBoolean2.set(true);
                        } else {
                            dispatcher2.flushCommandQueue(connectedControllersManager$ConnectedControllerRecord);
                        }
                    } catch (Throwable th4) {
                        throw th4;
                    }
                    break;
                }
                return;
            case 2:
                AtomicInteger atomicInteger = (AtomicInteger) this.f$0;
                ImmutableList immutableList3 = (ImmutableList) this.f$1;
                ArrayList arrayList = (ArrayList) this.f$2;
                SettableFuture settableFuture = (SettableFuture) this.f$3;
                if (atomicInteger.incrementAndGet() == immutableList3.size()) {
                    ArrayList arrayList2 = new ArrayList();
                    while (i2 < arrayList.size()) {
                        ListenableFuture listenableFuture = (ListenableFuture) arrayList.get(i2);
                        if (listenableFuture != null) {
                            try {
                                bitmap = (Bitmap) UuidKt.getDone(listenableFuture);
                            } catch (CancellationException | ExecutionException e) {
                                Log.d("Failed to get bitmap", e);
                                bitmap = null;
                            }
                        } else {
                            bitmap = null;
                        }
                        arrayList2.add(LegacyConversions.convertToBrowserItem((MediaItem) immutableList3.get(i2), bitmap));
                        i2++;
                    }
                    settableFuture.set(arrayList2);
                    return;
                }
                return;
            case 3:
                MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub = (MediaLibraryServiceLegacyStub) this.f$0;
                MediaSession$ControllerInfo mediaSession$ControllerInfo2 = (MediaSession$ControllerInfo) this.f$1;
                Bundle bundle = (Bundle) this.f$2;
                String str = (String) this.f$3;
                MediaLibrarySessionImpl mediaLibrarySessionImpl2 = mediaLibraryServiceLegacyStub.librarySessionImpl;
                if (mediaLibraryServiceLegacyStub.connectedControllersManager.isSessionCommandAvailable(mediaSession$ControllerInfo2, 50001)) {
                    mediaLibrarySessionImpl2.onSubscribeOnHandler(mediaSession$ControllerInfo2, str, LegacyConversions.convertToLibraryParams(mediaLibrarySessionImpl2.context, bundle));
                    return;
                }
                return;
            case 4:
                MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub2 = (MediaLibraryServiceLegacyStub) this.f$0;
                MediaSession$ControllerInfo mediaSession$ControllerInfo3 = (MediaSession$ControllerInfo) this.f$1;
                MediaBrowserServiceCompat$Result mediaBrowserServiceCompat$Result = (MediaBrowserServiceCompat$Result) this.f$2;
                String str2 = (String) this.f$3;
                if (!mediaLibraryServiceLegacyStub2.connectedControllersManager.isSessionCommandAvailable(mediaSession$ControllerInfo3, 50004)) {
                    mediaBrowserServiceCompat$Result.sendResult(null);
                    return;
                } else {
                    SettableFuture settableFutureTransformFutureAsync = Util.transformFutureAsync(mediaLibraryServiceLegacyStub2.librarySessionImpl.onGetItemOnHandler(mediaSession$ControllerInfo3, str2), new MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda8(mediaLibraryServiceLegacyStub2, b));
                    settableFutureTransformFutureAsync.addListener(new MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda7(settableFutureTransformFutureAsync, mediaBrowserServiceCompat$Result, (byte) 0), DirectExecutor.INSTANCE);
                    return;
                }
            case 5:
                MediaLibrarySessionImpl mediaLibrarySessionImpl3 = (MediaLibrarySessionImpl) this.f$2;
                ImmediateFuture immediateFuture = (ImmediateFuture) this.f$0;
                MediaSession$ControllerInfo mediaSession$ControllerInfo4 = (MediaSession$ControllerInfo) this.f$1;
                String str3 = (String) this.f$3;
                LibraryResult libraryResult = (LibraryResult) MediaLibrarySessionImpl.tryGetFutureResult(immediateFuture);
                if (libraryResult == null || libraryResult.resultCode != 0) {
                    mediaLibrarySessionImpl3.removeSubscription(mediaSession$ControllerInfo4, str3);
                    return;
                }
                return;
            case 6:
                MediaNotificationManager mediaNotificationManager = (MediaNotificationManager) this.f$0;
                MediaControllerHolder mediaControllerHolder = (MediaControllerHolder) this.f$1;
                MediaNotificationManager.MediaControllerListener mediaControllerListener = (MediaNotificationManager.MediaControllerListener) this.f$2;
                MediaLibraryService.MediaLibrarySession mediaLibrarySession = (MediaLibraryService.MediaLibrarySession) this.f$3;
                try {
                    MediaController mediaController = (MediaController) mediaControllerHolder.get(0L, TimeUnit.MILLISECONDS);
                    if (mediaNotificationManager.shouldShowNotification(mediaLibrarySession)) {
                        mediaControllerListener.mediaSessionService.onUpdateNotificationInternal(mediaControllerListener.session, false);
                    }
                    mediaController.addListener(mediaControllerListener);
                    return;
                } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException unused2) {
                    mediaNotificationManager.mediaSessionService.removeSession(mediaLibrarySession);
                    return;
                }
            case 7:
                FastFallbackExchangeFinder fastFallbackExchangeFinder = (FastFallbackExchangeFinder) this.f$0;
                AtomicInteger atomicInteger2 = (AtomicInteger) this.f$1;
                ArrayList arrayList3 = (ArrayList) this.f$2;
                ArrayList arrayList4 = (ArrayList) this.f$3;
                if (atomicInteger2.incrementAndGet() == arrayList3.size()) {
                    ArrayList arrayList5 = new ArrayList();
                    while (i2 < arrayList4.size()) {
                        ListenableFuture listenableFuture2 = (ListenableFuture) arrayList4.get(i2);
                        if (listenableFuture2 != null) {
                            try {
                                bitmap2 = (Bitmap) UuidKt.getDone(listenableFuture2);
                            } catch (CancellationException | ExecutionException e2) {
                                Log.d("Failed to get bitmap", e2);
                                bitmap2 = null;
                            }
                        } else {
                            bitmap2 = null;
                        }
                        arrayList5.add(new MediaSessionCompat$QueueItem(null, LegacyConversions.convertToMediaDescriptionCompat((MediaItem) arrayList3.get(i2), bitmap2), i2 == -1 ? -1L : i2));
                        i2++;
                        break;
                    }
                    ((MediaSessionLegacyStub) fastFallbackExchangeFinder.connectResults).sessionCompat.setQueue(arrayList5);
                    return;
                }
                return;
            case 8:
                MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub3 = (MediaLibraryServiceLegacyStub) this.f$0;
                AtomicReference atomicReference = (AtomicReference) this.f$2;
                MediaSession$ControllerInfo mediaSession$ControllerInfo5 = (MediaSession$ControllerInfo) this.f$1;
                ConditionVariable conditionVariable = (ConditionVariable) this.f$3;
                atomicReference.set(mediaLibraryServiceLegacyStub3.sessionImpl.onConnectOnHandler(mediaSession$ControllerInfo5));
                conditionVariable.open();
                return;
            case 9:
                MediaLibrarySessionImpl mediaLibrarySessionImpl4 = (MediaLibrarySessionImpl) this.f$2;
                SettableFuture settableFuture2 = (SettableFuture) this.f$0;
                Consumer consumer = (Consumer) this.f$1;
                ListenableFuture listenableFuture3 = (ListenableFuture) this.f$3;
                if (mediaLibrarySessionImpl4.isReleased()) {
                    settableFuture2.set(null);
                    return;
                }
                try {
                    consumer.accept(listenableFuture3);
                    settableFuture2.set(null);
                    return;
                } catch (Throwable th5) {
                    settableFuture2.setException(th5);
                    return;
                }
            default:
                MediaLibrarySessionImpl mediaLibrarySessionImpl5 = (MediaLibrarySessionImpl) this.f$2;
                MediaSessionStub.MediaItemPlayerTask mediaItemPlayerTask = (MediaSessionStub.MediaItemPlayerTask) this.f$0;
                MediaSession$ControllerInfo mediaSession$ControllerInfo6 = (MediaSession$ControllerInfo) this.f$1;
                List list = (List) this.f$3;
                if (mediaLibrarySessionImpl5.isReleased()) {
                    return;
                }
                mediaItemPlayerTask.run(mediaLibrarySessionImpl5.playerWrapper, mediaSession$ControllerInfo6, list);
                return;
        }
    }

    public /* synthetic */ MediaSessionStub$$ExternalSyntheticLambda3(MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub, AtomicInteger atomicInteger, ImmutableList immutableList, ArrayList arrayList, SettableFuture settableFuture) {
        this.$r8$classId = (byte) 2;
        this.f$0 = atomicInteger;
        this.f$1 = immutableList;
        this.f$2 = arrayList;
        this.f$3 = settableFuture;
    }

    public /* synthetic */ MediaSessionStub$$ExternalSyntheticLambda3(MediaLibrarySessionImpl mediaLibrarySessionImpl, Object obj, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.f$2 = mediaLibrarySessionImpl;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$3 = obj3;
    }

    public /* synthetic */ MediaSessionStub$$ExternalSyntheticLambda3(Object obj, Object obj2, Object obj3, Object obj4, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
    }
}
