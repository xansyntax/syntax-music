package androidx.activity;

import android.content.res.Resources;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Util;
import androidx.media3.common.util.Util$$ExternalSyntheticLambda1;
import androidx.media3.session.ConnectedControllersManager$AsyncCommand;
import androidx.media3.session.LegacyConversions;
import androidx.media3.session.MediaController;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaLibraryServiceLegacyStub;
import androidx.media3.session.MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda7;
import androidx.media3.session.MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda8;
import androidx.media3.session.MediaLibrarySessionImpl;
import androidx.media3.session.MediaNotificationManager;
import androidx.media3.session.MediaSession$ControllerCb;
import androidx.media3.session.MediaSession$ControllerInfo;
import androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda3;
import androidx.media3.session.SessionCommand;
import androidx.media3.session.legacy.MediaBrowserServiceCompat$2;
import androidx.media3.session.legacy.MediaBrowserServiceCompat$Result;
import androidx.room.TransactionExecutor$$ExternalSyntheticLambda0;
import com.google.common.util.concurrent.DirectExecutor;
import com.google.common.util.concurrent.ImmediateFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function1;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class EdgeToEdge$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;

    public /* synthetic */ EdgeToEdge$$ExternalSyntheticLambda0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
        this.f$4 = obj5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaLibraryService.LibraryParams libraryParamsConvertToLibraryParams;
        MediaLibraryService.LibraryParams libraryParams = null;
        switch (this.$r8$classId) {
            case 0:
                EdgeToEdgeApi26 edgeToEdgeApi26 = (EdgeToEdgeApi26) this.f$0;
                SystemBarStyle systemBarStyle = (SystemBarStyle) this.f$1;
                SystemBarStyle systemBarStyle2 = (SystemBarStyle) this.f$2;
                ComponentActivity componentActivity = (ComponentActivity) this.f$3;
                View view = (View) this.f$4;
                Window window = componentActivity.getWindow();
                window.getClass();
                Function1 function1 = systemBarStyle.detectDarkMode;
                Resources resources = view.getResources();
                resources.getClass();
                boolean zBooleanValue = ((Boolean) function1.invoke(resources)).booleanValue();
                Function1 function2 = systemBarStyle2.detectDarkMode;
                Resources resources2 = view.getResources();
                resources2.getClass();
                edgeToEdgeApi26.setUp(systemBarStyle, systemBarStyle2, window, view, zBooleanValue, ((Boolean) function2.invoke(resources2)).booleanValue());
                return;
            case 1:
                ((ConnectedControllersManager$AsyncCommand) this.f$1).run().addListener(new MediaSessionStub$$ExternalSyntheticLambda3((Object) ((Dispatcher) this.f$0), this.f$2, this.f$3, this.f$4, (byte) 1), DirectExecutor.INSTANCE);
                return;
            case 2:
                MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub = (MediaLibraryServiceLegacyStub) this.f$0;
                AtomicReference atomicReference = (AtomicReference) this.f$1;
                MediaSession$ControllerInfo mediaSession$ControllerInfo = (MediaSession$ControllerInfo) this.f$2;
                MediaLibraryService.LibraryParams libraryParams2 = (MediaLibraryService.LibraryParams) this.f$3;
                ConditionVariable conditionVariable = (ConditionVariable) this.f$4;
                atomicReference.set(mediaLibraryServiceLegacyStub.librarySessionImpl.onGetLibraryRootOnHandler(mediaSession$ControllerInfo, libraryParams2));
                conditionVariable.open();
                return;
            case 3:
                MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub2 = (MediaLibraryServiceLegacyStub) this.f$0;
                String str = (String) this.f$1;
                MediaSession$ControllerInfo mediaSession$ControllerInfo2 = (MediaSession$ControllerInfo) this.f$2;
                MediaBrowserServiceCompat$2 mediaBrowserServiceCompat$2 = (MediaBrowserServiceCompat$2) this.f$3;
                Bundle bundle = (Bundle) this.f$4;
                SessionCommand sessionCommand = new SessionCommand(str, Bundle.EMPTY);
                if (!mediaLibraryServiceLegacyStub2.connectedControllersManager.isSessionCommandAvailable(mediaSession$ControllerInfo2, sessionCommand)) {
                    mediaBrowserServiceCompat$2.sendError();
                    return;
                } else {
                    ImmediateFuture immediateFutureOnCustomCommandOnHandler = mediaLibraryServiceLegacyStub2.librarySessionImpl.onCustomCommandOnHandler(mediaSession$ControllerInfo2, sessionCommand, bundle);
                    immediateFutureOnCustomCommandOnHandler.addListener(new TransactionExecutor$$ExternalSyntheticLambda0((Object) immediateFutureOnCustomCommandOnHandler, (Object) mediaBrowserServiceCompat$2, (byte) 6), DirectExecutor.INSTANCE);
                    return;
                }
            case 4:
                DirectExecutor directExecutor = DirectExecutor.INSTANCE;
                MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub3 = (MediaLibraryServiceLegacyStub) this.f$0;
                MediaSession$ControllerInfo mediaSession$ControllerInfo3 = (MediaSession$ControllerInfo) this.f$1;
                MediaBrowserServiceCompat$Result mediaBrowserServiceCompat$Result = (MediaBrowserServiceCompat$Result) this.f$2;
                Bundle bundle2 = (Bundle) this.f$3;
                String str2 = (String) this.f$4;
                MediaLibrarySessionImpl mediaLibrarySessionImpl = mediaLibraryServiceLegacyStub3.librarySessionImpl;
                if (!mediaLibraryServiceLegacyStub3.connectedControllersManager.isSessionCommandAvailable(mediaSession$ControllerInfo3, 50003)) {
                    mediaBrowserServiceCompat$Result.sendResult(null);
                    return;
                }
                byte b = 0;
                if (bundle2 != null) {
                    bundle2.setClassLoader(mediaLibrarySessionImpl.context.getClassLoader());
                    try {
                        int i = bundle2.getInt("android.media.browse.extra.PAGE");
                        int i2 = bundle2.getInt("android.media.browse.extra.PAGE_SIZE");
                        libraryParamsConvertToLibraryParams = LegacyConversions.convertToLibraryParams(mediaLibrarySessionImpl.context, bundle2);
                        if (i >= 0 && i2 > 0) {
                            try {
                                SettableFuture settableFutureTransformFutureAsync = Util.transformFutureAsync(mediaLibraryServiceLegacyStub3.librarySessionImpl.onGetChildrenOnHandler(mediaSession$ControllerInfo3, str2, i, i2, libraryParamsConvertToLibraryParams), new MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda8(mediaLibraryServiceLegacyStub3, b));
                                settableFutureTransformFutureAsync.addListener(new MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda7(settableFutureTransformFutureAsync, mediaBrowserServiceCompat$Result, (byte) 1), directExecutor);
                                return;
                            } catch (BadParcelableException unused) {
                                libraryParams = libraryParamsConvertToLibraryParams;
                            }
                        }
                    } catch (BadParcelableException unused2) {
                    }
                } else {
                    libraryParamsConvertToLibraryParams = libraryParams;
                }
                SettableFuture settableFutureTransformFutureAsync2 = Util.transformFutureAsync(mediaLibraryServiceLegacyStub3.librarySessionImpl.onGetChildrenOnHandler(mediaSession$ControllerInfo3, str2, 0, Integer.MAX_VALUE, libraryParamsConvertToLibraryParams), new MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda8(mediaLibraryServiceLegacyStub3, b));
                settableFutureTransformFutureAsync2.addListener(new MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda7(settableFutureTransformFutureAsync2, mediaBrowserServiceCompat$Result, (byte) 1), directExecutor);
                return;
            case 5:
                MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub4 = (MediaLibraryServiceLegacyStub) this.f$0;
                MediaSession$ControllerInfo mediaSession$ControllerInfo4 = (MediaSession$ControllerInfo) this.f$1;
                MediaBrowserServiceCompat$2 mediaBrowserServiceCompat$3 = (MediaBrowserServiceCompat$2) this.f$2;
                String str3 = (String) this.f$3;
                Bundle bundle3 = (Bundle) this.f$4;
                if (!mediaLibraryServiceLegacyStub4.connectedControllersManager.isSessionCommandAvailable(mediaSession$ControllerInfo4, 50005)) {
                    mediaBrowserServiceCompat$3.sendResult(null);
                    return;
                }
                MediaSession$ControllerCb mediaSession$ControllerCb = mediaSession$ControllerInfo4.controllerCb;
                mediaSession$ControllerCb.getClass();
                MediaLibraryServiceLegacyStub.BrowserLegacyCb browserLegacyCb = (MediaLibraryServiceLegacyStub.BrowserLegacyCb) mediaSession$ControllerCb;
                synchronized (browserLegacyCb.lock) {
                    browserLegacyCb.searchRequests.add(new MediaLibraryServiceLegacyStub.SearchRequest(mediaSession$ControllerInfo4, mediaSession$ControllerInfo4.remoteUserInfo, str3, bundle3, mediaBrowserServiceCompat$3));
                    break;
                }
                mediaLibraryServiceLegacyStub4.librarySessionImpl.onSearchOnHandler(mediaSession$ControllerInfo4, str3, LegacyConversions.convertToLibraryParams(mediaLibraryServiceLegacyStub4.librarySessionImpl.context, bundle3));
                return;
            default:
                MediaNotificationManager mediaNotificationManager = (MediaNotificationManager) this.f$0;
                MediaLibraryService.MediaLibrarySession mediaLibrarySession = (MediaLibraryService.MediaLibrarySession) this.f$1;
                String str4 = (String) this.f$2;
                Bundle bundle4 = (Bundle) this.f$3;
                MediaController mediaController = (MediaController) this.f$4;
                mediaNotificationManager.mediaNotificationProvider.handleCustomCommand(mediaLibrarySession, str4, bundle4);
                mediaNotificationManager.mainExecutor.execute(new Util$$ExternalSyntheticLambda1(mediaNotificationManager, mediaController, str4, bundle4));
                return;
        }
    }
}
