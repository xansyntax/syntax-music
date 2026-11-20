package androidx.media3.session;

import android.os.RemoteException;
import androidx.media3.common.util.Log;
import com.google.common.collect.ImmutableList;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionImpl$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaLibrarySessionImpl f$0;

    public /* synthetic */ MediaSessionImpl$$ExternalSyntheticLambda0(MediaLibrarySessionImpl mediaLibrarySessionImpl, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaLibrarySessionImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        MediaLibrarySessionImpl mediaLibrarySessionImpl = this.f$0;
        switch (b) {
            case 0:
                MediaSessionImpl$PlayerListener mediaSessionImpl$PlayerListener = mediaLibrarySessionImpl.playerListener;
                if (mediaSessionImpl$PlayerListener != null) {
                    mediaLibrarySessionImpl.playerWrapper.removeListener(mediaSessionImpl$PlayerListener);
                    return;
                }
                return;
            case 1:
                DefaultActionFactory defaultActionFactory = mediaLibrarySessionImpl.mediaSessionListener;
                if (defaultActionFactory != null) {
                    defaultActionFactory.service.onUpdateNotificationInternal(mediaLibrarySessionImpl.instance$1, false);
                    return;
                }
                return;
            case 2:
                synchronized (mediaLibrarySessionImpl.lock) {
                    try {
                        if (mediaLibrarySessionImpl.closed) {
                            return;
                        }
                        SessionPositionInfo sessionPositionInfoCreateSessionPositionInfo = mediaLibrarySessionImpl.playerWrapper.createSessionPositionInfo();
                        if (!mediaLibrarySessionImpl.onPlayerInfoChangedHandler.hasMessages(1) && MediaUtils.areSessionPositionInfosInSamePeriodOrAd(sessionPositionInfoCreateSessionPositionInfo, mediaLibrarySessionImpl.playerInfo.sessionPositionInfo)) {
                            Dispatcher dispatcher = mediaLibrarySessionImpl.sessionStub.connectedControllersManager;
                            ImmutableList connectedControllers = dispatcher.getConnectedControllers();
                            for (int i = 0; i < connectedControllers.size(); i++) {
                                MediaSession$ControllerInfo mediaSession$ControllerInfo = (MediaSession$ControllerInfo) connectedControllers.get(i);
                                dispatcher.getPlaybackException(mediaSession$ControllerInfo);
                                mediaLibrarySessionImpl.dispatchRemoteControllerTaskWithoutReturn(mediaSession$ControllerInfo, new MediaSessionImpl$$ExternalSyntheticLambda16(sessionPositionInfoCreateSessionPositionInfo, dispatcher.isPlayerCommandAvailable(mediaSession$ControllerInfo, 16), dispatcher.isPlayerCommandAvailable(mediaSession$ControllerInfo, 17), mediaSession$ControllerInfo));
                            }
                            try {
                                mediaLibrarySessionImpl.sessionLegacyStub.controllerLegacyCbForBroadcast.onPeriodicSessionPositionInfoChanged(0, sessionPositionInfoCreateSessionPositionInfo, true, true, 0);
                            } catch (RemoteException e) {
                                Log.e("MediaSessionImpl", "Exception in using media1 API", e);
                            }
                            break;
                        }
                        mediaLibrarySessionImpl.schedulePeriodicSessionPositionInfoChanges();
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            default:
                mediaLibrarySessionImpl.schedulePeriodicSessionPositionInfoChanges();
                return;
        }
    }
}
