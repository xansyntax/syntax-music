package androidx.media3.session;

import android.os.Handler;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda5;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaNotificationManager$$ExternalSyntheticLambda2 implements MediaControllerImplBase.RemoteSessionTask {
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ MediaNotificationManager$$ExternalSyntheticLambda2(Object obj, Object obj2, boolean z) {
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = z;
    }

    public String attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        ImmutableList mediaButtonPreferences;
        MediaNotificationManager mediaNotificationManager = (MediaNotificationManager) this.f$0;
        MediaLibraryService.MediaLibrarySession mediaLibrarySession = (MediaLibraryService.MediaLibrarySession) this.f$1;
        MediaSessionService mediaSessionService = mediaNotificationManager.mediaSessionService;
        if (!mediaSessionService.isSessionAdded(mediaLibrarySession) || !mediaNotificationManager.shouldShowNotification(mediaLibrarySession)) {
            String str = Util.DEVICE_DEBUG_INFO;
            mediaSessionService.stopForeground(1);
            PriorityQueue priorityQueue = mediaNotificationManager.mediaNotification;
            if (priorityQueue != null) {
                mediaNotificationManager.notificationManager.cancel(priorityQueue.size);
                mediaNotificationManager.totalNotificationCount++;
                mediaNotificationManager.mediaNotification = null;
            }
            callbackToFutureAdapter$Completer.set(null);
            return "notificationRemoved";
        }
        int i = mediaNotificationManager.totalNotificationCount + 1;
        mediaNotificationManager.totalNotificationCount = i;
        MediaController connectedControllerForSession = mediaNotificationManager.getConnectedControllerForSession(mediaLibrarySession);
        connectedControllerForSession.getClass();
        connectedControllerForSession.verifyApplicationThread$2();
        MediaController.MediaControllerImpl mediaControllerImpl = connectedControllerForSession.impl;
        if (mediaControllerImpl.isConnected()) {
            mediaButtonPreferences = mediaControllerImpl.getMediaButtonPreferences();
        } else {
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            mediaButtonPreferences = RegularImmutableList.EMPTY;
        }
        Util.postOrRun(new Handler(mediaLibrarySession.getPlayer().getApplicationLooper()), new MediaNotificationManager$$ExternalSyntheticLambda6(mediaNotificationManager, mediaLibrarySession, mediaButtonPreferences, new ExoPlayerImpl$$ExternalSyntheticLambda5(mediaNotificationManager, i, mediaLibrarySession, (byte) 3), this.f$2, callbackToFutureAdapter$Completer));
        return "notificationUpdated";
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public void run(IMediaSession iMediaSession, int i) {
        iMediaSession.setAudioAttributes(((MediaControllerImplBase) this.f$0).controllerStub, i, ((AudioAttributes) this.f$1).toBundle(), this.f$2);
    }
}
