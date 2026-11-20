package androidx.media3.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSourceBitmapLoader;
import androidx.media3.session.MediaNotificationManager.MediaControllerListener;
import java.util.HashMap;
import kotlinx.serialization.json.internal.JsonTreeReader;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionService$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaSessionService f$0;
    public final /* synthetic */ MediaLibraryService.MediaLibrarySession f$1;

    public /* synthetic */ MediaSessionService$$ExternalSyntheticLambda1(MediaSessionService mediaSessionService, MediaLibraryService.MediaLibrarySession mediaLibrarySession, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaSessionService;
        this.f$1 = mediaLibrarySession;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        MediaSessionService mediaSessionService = this.f$0;
        switch (b) {
            case 0:
                MediaLibraryService.MediaLibrarySession mediaLibrarySession = this.f$1;
                MediaLibrarySessionImpl mediaLibrarySessionImpl = mediaLibrarySession.impl;
                int i = MediaSessionService.$r8$clinit;
                MediaNotificationManager mediaNotificationManager = mediaSessionService.getMediaNotificationManager(null);
                MediaSessionService mediaSessionService2 = mediaNotificationManager.mediaSessionService;
                HashMap map = mediaNotificationManager.controllerMap;
                if (!map.containsKey(mediaLibrarySession)) {
                    MediaNotificationManager.MediaControllerListener mediaControllerListener = mediaNotificationManager.new MediaControllerListener(mediaSessionService2, mediaLibrarySession);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("androidx.media3.session.MediaNotificationManager", true);
                    SessionToken sessionToken = mediaLibrarySessionImpl.sessionToken;
                    sessionToken.getClass();
                    Bundle bundle2 = Bundle.EMPTY;
                    Util.getCurrentOrMainLooper();
                    Bundle bundle3 = new Bundle(bundle);
                    Looper mainLooper = Looper.getMainLooper();
                    mainLooper.getClass();
                    MediaControllerHolder mediaControllerHolder = new MediaControllerHolder(mainLooper);
                    Util.postOrRun(new Handler(mainLooper), new MediaControllerHolder$$ExternalSyntheticLambda0(mediaControllerHolder, new MediaController(mediaSessionService2, sessionToken, bundle3, mediaControllerListener, mainLooper, mediaControllerHolder, sessionToken.impl.isLegacySession() ? new CallbackWrapper((byte) 26, new DataSourceBitmapLoader(new JsonTreeReader(mediaSessionService2))) : null), (byte) 1));
                    map.put(mediaLibrarySession, new MediaNotificationManager.ControllerInfo(mediaControllerHolder));
                    mediaControllerHolder.addListener(new MediaSessionStub$$ExternalSyntheticLambda3(mediaNotificationManager, mediaControllerHolder, mediaControllerListener, mediaLibrarySession, (byte) 6), mediaNotificationManager.mainExecutor);
                }
                mediaLibrarySessionImpl.mediaSessionListener = new DefaultActionFactory(mediaSessionService);
                break;
            default:
                int i2 = MediaSessionService.$r8$clinit;
                HashMap map2 = mediaSessionService.getMediaNotificationManager(null).controllerMap;
                MediaLibraryService.MediaLibrarySession mediaLibrarySession2 = this.f$1;
                MediaNotificationManager.ControllerInfo controllerInfo = (MediaNotificationManager.ControllerInfo) map2.remove(mediaLibrarySession2);
                if (controllerInfo != null) {
                    MediaController.releaseFuture(controllerInfo.controllerFuture);
                }
                mediaLibrarySession2.impl.mediaSessionListener = null;
                break;
        }
    }
}
