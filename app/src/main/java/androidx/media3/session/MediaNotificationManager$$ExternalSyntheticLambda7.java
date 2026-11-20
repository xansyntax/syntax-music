package androidx.media3.session;

import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture;
import androidx.media3.common.util.Log;
import androidx.media3.session.legacy.MediaSessionManager$RemoteUserInfo;
import androidx.sqlite.SQLite;
import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaNotificationManager$$ExternalSyntheticLambda7 implements Runnable {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ Object f$4;

    public /* synthetic */ MediaNotificationManager$$ExternalSyntheticLambda7(MediaNotificationManager mediaNotificationManager, MediaLibraryService.MediaLibrarySession mediaLibrarySession, PriorityQueue priorityQueue, boolean z, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.f$0 = mediaNotificationManager;
        this.f$1 = mediaLibrarySession;
        this.f$2 = priorityQueue;
        this.f$3 = z;
        this.f$4 = callbackToFutureAdapter$Completer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        Object obj = this.f$4;
        Object obj2 = this.f$2;
        Object obj3 = this.f$1;
        Object obj4 = this.f$0;
        switch (b) {
            case 0:
                CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = (CallbackToFutureAdapter$Completer) obj;
                try {
                    ((MediaNotificationManager) obj4).updateNotificationInternal((MediaLibraryService.MediaLibrarySession) obj3, (PriorityQueue) obj2, this.f$3);
                    callbackToFutureAdapter$Completer.set(null);
                    return;
                } catch (IllegalStateException e) {
                    callbackToFutureAdapter$Completer.attemptedSetting = true;
                    CallbackToFutureAdapter$SafeFuture callbackToFutureAdapter$SafeFuture = callbackToFutureAdapter$Completer.future;
                    if (callbackToFutureAdapter$SafeFuture == null || !callbackToFutureAdapter$SafeFuture.delegate.setException(e)) {
                        return;
                    }
                    callbackToFutureAdapter$Completer.tag = null;
                    callbackToFutureAdapter$Completer.future = null;
                    callbackToFutureAdapter$Completer.cancellationFuture = null;
                    return;
                }
            default:
                MediaSessionService.MediaSessionServiceStub mediaSessionServiceStub = (MediaSessionService.MediaSessionServiceStub) obj4;
                IMediaController iMediaController = (IMediaController) obj3;
                MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo = (MediaSessionManager$RemoteUserInfo) obj2;
                ConnectionRequest connectionRequest = (ConnectionRequest) obj;
                boolean z = this.f$3;
                mediaSessionServiceStub.pendingControllers.remove(iMediaController);
                try {
                    try {
                        MediaSessionService mediaSessionService = (MediaSessionService) mediaSessionServiceStub.serviceReference.get();
                        if (mediaSessionService != null) {
                            int i = connectionRequest.libraryVersion;
                            int i2 = connectionRequest.controllerInterfaceVersion;
                            MediaSession$ControllerInfo mediaSession$ControllerInfo = new MediaSession$ControllerInfo(mediaSessionManager$RemoteUserInfo, i, i2, z, new MediaSessionStub.Controller2Cb(iMediaController, i2), connectionRequest.connectionHints);
                            MediaLibraryService.MediaLibrarySession mediaLibrarySessionOnGetSession = mediaSessionService.onGetSession(mediaSession$ControllerInfo);
                            if (mediaLibrarySessionOnGetSession != null) {
                                mediaSessionService.addSession(mediaLibrarySessionOnGetSession);
                                mediaLibrarySessionOnGetSession.impl.sessionStub.connect(iMediaController, mediaSession$ControllerInfo);
                                return;
                            }
                        }
                    } catch (Exception e2) {
                        Log.w("MSessionService", "Failed to add a session to session service", e2);
                        break;
                    }
                    SQLite.disconnectIMediaController(iMediaController);
                    return;
                } catch (Throwable th) {
                    SQLite.disconnectIMediaController(iMediaController);
                    throw th;
                }
        }
    }

    public /* synthetic */ MediaNotificationManager$$ExternalSyntheticLambda7(MediaSessionService.MediaSessionServiceStub mediaSessionServiceStub, IMediaController iMediaController, MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo, ConnectionRequest connectionRequest, boolean z) {
        this.f$0 = mediaSessionServiceStub;
        this.f$1 = iMediaController;
        this.f$2 = mediaSessionManager$RemoteUserInfo;
        this.f$4 = connectionRequest;
        this.f$3 = z;
    }
}
