package androidx.media3.session;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.util.Pair;
import androidx.activity.EdgeToEdge$$ExternalSyntheticLambda0;
import androidx.collection.ArrayMap;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.provider.CallbackWrapper;
import androidx.lifecycle.LifecycleService;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm$$ExternalSyntheticLambda0;
import androidx.media3.session.legacy.MediaBrowserCompat;
import androidx.media3.session.legacy.MediaSessionCompat$MediaSessionImplApi23;
import androidx.media3.session.legacy.MediaSessionCompat$Token;
import androidx.media3.session.legacy.MediaSessionManager$RemoteUserInfo;
import androidx.room.TransactionExecutor$$ExternalSyntheticLambda0;
import androidx.room.concurrent.FileLock;
import androidx.sqlite.SQLite;
import coil3.util.UtilsKt;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps$$ExternalSyntheticLambda1;
import com.google.common.util.concurrent.AbstractCatchingFuture$CatchingFuture;
import com.google.common.util.concurrent.DirectExecutor;
import com.yalantis.ucrop.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MediaSessionService extends LifecycleService {
    public static final /* synthetic */ int $r8$clinit = 0;
    public DefaultActionFactory actionFactory;
    public boolean initialStartIntentProcessed;
    public ConnectionPool listener;
    public MediaNotificationManager mediaNotificationManager;
    public MediaSessionServiceStub stub;
    public final Object lock = new Object();
    public final Handler mainHandler = new Handler(Looper.getMainLooper());
    public final ArrayMap sessions = new ArrayMap(0);

    public static MediaSession$ControllerInfo createFallbackMediaButtonCaller(Intent intent) {
        ComponentName component = intent.getComponent();
        String packageName = component != null ? component.getPackageName() : "androidx.media3.session.MediaSessionService";
        Bundle bundle = new Bundle();
        bundle.putString("androidx.media3.session.hint.controller_info_type", "android.intent.action.MEDIA_BUTTON");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            bundle.putBundle("androidx.media3.session.hint.intent_extras", extras);
        }
        Uri data = intent.getData();
        if (data != null) {
            SessionResult sessionResult = MediaLibrarySessionImpl.RESULT_WHEN_CLOSED;
            List<String> pathSegments = data.getPathSegments();
            bundle.putString("androidx.media3.session.hint.session_id", (Objects.equals(data.getScheme(), "androidx") && Objects.equals(data.getAuthority(), "media3.session") && !pathSegments.isEmpty()) ? pathSegments.get(0) : "");
        }
        return new MediaSession$ControllerInfo(new MediaSessionManager$RemoteUserInfo(packageName, -1, -1), 1010001300, 9, false, null, bundle);
    }

    public final void addSession(MediaLibraryService.MediaLibrarySession mediaLibrarySession) {
        MediaLibraryService.MediaLibrarySession mediaLibrarySession2;
        byte b;
        boolean z = true;
        UtilsKt.checkArgument("session is already released", !mediaLibrarySession.impl.isReleased());
        synchronized (this.lock) {
            mediaLibrarySession2 = (MediaLibraryService.MediaLibrarySession) this.sessions.get(mediaLibrarySession.impl.sessionId);
            b = 0;
            if (mediaLibrarySession2 != null && mediaLibrarySession2 != mediaLibrarySession) {
                z = false;
            }
            UtilsKt.checkArgument("Session ID should be unique", z);
            this.sessions.put(mediaLibrarySession.impl.sessionId, mediaLibrarySession);
        }
        if (mediaLibrarySession2 == null) {
            Util.postOrRun(this.mainHandler, new MediaSessionService$$ExternalSyntheticLambda1(this, mediaLibrarySession, b));
        }
    }

    public final MediaNotificationManager getMediaNotificationManager(FileLock fileLock) {
        MediaNotificationManager mediaNotificationManager = this.mediaNotificationManager;
        MediaNotification$Provider defaultMediaNotificationProvider = fileLock;
        if (mediaNotificationManager == null) {
            if (fileLock == null) {
                UtilsKt.checkNotNull(getBaseContext(), "Accessing service context before onCreate()");
                Context applicationContext = getApplicationContext();
                FrameworkMediaDrm$$ExternalSyntheticLambda0 frameworkMediaDrm$$ExternalSyntheticLambda0 = new FrameworkMediaDrm$$ExternalSyntheticLambda0((byte) 28);
                Supplier supplier = DefaultMediaNotificationProvider.maxNotificationIconSize;
                UtilsKt.checkState(!false);
                defaultMediaNotificationProvider = new DefaultMediaNotificationProvider(applicationContext, frameworkMediaDrm$$ExternalSyntheticLambda0, "default_channel_id", R.string.default_notification_channel_name);
            }
            DefaultActionFactory defaultActionFactory = this.actionFactory;
            if (defaultActionFactory == null) {
                defaultActionFactory = new DefaultActionFactory(this);
                this.actionFactory = defaultActionFactory;
            }
            mediaNotificationManager = new MediaNotificationManager(this, defaultMediaNotificationProvider, defaultActionFactory);
            this.mediaNotificationManager = mediaNotificationManager;
        }
        return mediaNotificationManager;
    }

    public final ArrayList getSessions() {
        ArrayList arrayList;
        synchronized (this.lock) {
            arrayList = new ArrayList(this.sessions.values());
        }
        return arrayList;
    }

    public final boolean isSessionAdded(MediaLibraryService.MediaLibrarySession mediaLibrarySession) {
        boolean zContainsKey;
        synchronized (this.lock) {
            zContainsKey = this.sessions.containsKey(mediaLibrarySession.impl.sessionId);
        }
        return zContainsKey;
    }

    public final void lambda$onUpdateNotification$3(RuntimeException runtimeException) {
        if (Build.VERSION.SDK_INT < 31 || !(runtimeException instanceof ForegroundServiceStartNotAllowedException)) {
            Log.e("MSessionService", "Calling updateNotification() failed with a runtime exception", runtimeException);
            return;
        }
        Log.e("MSessionService", "Failed to start service into the foreground", runtimeException);
        this.mainHandler.post(new MediaSessionService$$ExternalSyntheticLambda3((byte) 0, this));
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public IBinder onBind(Intent intent) {
        MediaLibraryService.MediaLibrarySession mediaLibrarySessionOnGetSession;
        MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub;
        String str = Util.DEVICE_DEBUG_INFO;
        super.onBind(intent);
        String action = intent.getAction();
        if (action == null) {
            return null;
        }
        if (action.equals("androidx.media3.session.MediaSessionService")) {
            MediaSessionServiceStub mediaSessionServiceStub = this.stub;
            mediaSessionServiceStub.getClass();
            return mediaSessionServiceStub;
        }
        if (!action.equals("android.media.browse.MediaBrowserService") || (mediaLibrarySessionOnGetSession = onGetSession(new MediaSession$ControllerInfo(new MediaSessionManager$RemoteUserInfo("android.media.session.MediaController", -1, -1), 0, 0, false, null, Bundle.EMPTY))) == null) {
            return null;
        }
        addSession(mediaLibrarySessionOnGetSession);
        MediaLibrarySessionImpl mediaLibrarySessionImpl = mediaLibrarySessionOnGetSession.impl;
        synchronized (mediaLibrarySessionImpl.lock) {
            try {
                mediaLibraryServiceLegacyStub = mediaLibrarySessionImpl.browserServiceLegacyStub;
                if (mediaLibraryServiceLegacyStub == null) {
                    MediaSessionCompat$Token mediaSessionCompat$Token = ((MediaSessionCompat$MediaSessionImplApi23) mediaLibrarySessionImpl.sessionLegacyStub.sessionCompat.mCallback).token;
                    MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub2 = new MediaLibraryServiceLegacyStub(mediaLibrarySessionImpl);
                    mediaLibraryServiceLegacyStub2.initialize(mediaSessionCompat$Token);
                    mediaLibrarySessionImpl.browserServiceLegacyStub = mediaLibraryServiceLegacyStub2;
                    mediaLibraryServiceLegacyStub = mediaLibraryServiceLegacyStub2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaLibraryServiceLegacyStub.onBind(new Intent("android.media.browse.MediaBrowserService"));
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.stub = new MediaSessionServiceStub(this);
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        MediaNotificationManager mediaNotificationManager = this.mediaNotificationManager;
        if (mediaNotificationManager != null) {
            mediaNotificationManager.disableUserEngagedTimeout();
        }
        MediaSessionServiceStub mediaSessionServiceStub = this.stub;
        if (mediaSessionServiceStub != null) {
            mediaSessionServiceStub.serviceReference.clear();
            mediaSessionServiceStub.handler.removeCallbacksAndMessages(null);
            Set set = mediaSessionServiceStub.pendingControllers;
            Iterator it = set.iterator();
            while (it.hasNext()) {
                SQLite.disconnectIMediaController((IMediaController) it.next());
            }
            set.clear();
            this.stub = null;
        }
    }

    public abstract MediaLibraryService.MediaLibrarySession onGetSession(MediaSession$ControllerInfo mediaSession$ControllerInfo);

    /* JADX WARN: Code duplicated, block: B:39:0x0088  */
    /* JADX WARN: Code duplicated, block: B:40:0x0097  */
    /* JADX WARN: Code duplicated, block: B:42:0x009d  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:55:0x00be  */
    /* JADX WARN: Code duplicated, block: B:56:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:65:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:68:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:72:0x0112  */
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        MediaLibraryService.MediaLibrarySession mediaLibrarySessionOnGetSession;
        MediaLibraryService.MediaLibrarySession mediaLibrarySession;
        Bundle extras;
        Object obj;
        String str;
        Bundle extras2;
        Object obj2;
        Bundle bundle;
        Bundle bundle2;
        MediaNotificationManager mediaNotificationManager;
        MediaController connectedControllerForSession;
        boolean zEquals;
        super.onStartCommand(intent, i, i2);
        if (intent != null) {
            if (this.actionFactory == null) {
                this.actionFactory = new DefaultActionFactory(this);
            }
            Uri data = intent.getData();
            if ("android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || "androidx.media3.session.CUSTOM_NOTIFICATION_ACTION".equals(intent.getAction())) {
                if (data == null) {
                    mediaLibrarySessionOnGetSession = null;
                    break;
                }
                synchronized (this.lock) {
                    try {
                        Iterator it = ((ArrayMap.ValueCollection) this.sessions.values()).iterator();
                        while (true) {
                            ArrayMap.KeyIterator keyIterator = (ArrayMap.KeyIterator) it;
                            if (!keyIterator.hasNext()) {
                                mediaLibrarySessionOnGetSession = null;
                                break;
                            }
                            mediaLibrarySessionOnGetSession = (MediaLibraryService.MediaLibrarySession) keyIterator.next();
                            if (Objects.equals(mediaLibrarySessionOnGetSession.impl.sessionUri, data)) {
                                break;
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (mediaLibrarySessionOnGetSession != null) {
                    mediaLibrarySession = mediaLibrarySessionOnGetSession;
                    if ("android.intent.action.MEDIA_BUTTON".equals(intent.getAction())) {
                        MediaLibrarySessionImpl mediaLibrarySessionImpl = mediaLibrarySession.impl;
                        mediaLibrarySessionImpl.applicationHandler.post(new TransactionExecutor$$ExternalSyntheticLambda0((Object) mediaLibrarySessionImpl, (Object) intent, (byte) 13));
                    } else {
                        extras = intent.getExtras();
                        if (extras != null) {
                            obj = extras.get("androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION");
                        } else {
                            obj = null;
                        }
                        if (obj instanceof String) {
                            str = (String) obj;
                        } else {
                            str = null;
                        }
                        if (str == null) {
                            extras2 = intent.getExtras();
                            if (extras2 != null) {
                                obj2 = extras2.get("androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION_EXTRAS");
                            } else {
                                obj2 = null;
                            }
                            if (obj2 instanceof Bundle) {
                                bundle = (Bundle) obj2;
                            } else {
                                bundle = Bundle.EMPTY;
                            }
                            bundle2 = bundle;
                            mediaNotificationManager = getMediaNotificationManager(null);
                            connectedControllerForSession = mediaNotificationManager.getConnectedControllerForSession(mediaLibrarySession);
                            if (connectedControllerForSession != null) {
                                Util.postOrRun(new Handler(mediaLibrarySession.getPlayer().getApplicationLooper()), new EdgeToEdge$$ExternalSyntheticLambda0(mediaNotificationManager, mediaLibrarySession, str, bundle2, connectedControllerForSession, (byte) 6));
                            }
                        } else if (!this.initialStartIntentProcessed) {
                            stopSelfSafely();
                            return 1;
                        }
                    }
                    if (!this.initialStartIntentProcessed && intent.hasExtra("androidx.media3.session.intent.uid")) {
                        zEquals = Objects.equals(getMediaNotificationManager(null).startSelfIntentUid, intent.getStringExtra("androidx.media3.session.intent.uid"));
                        this.initialStartIntentProcessed = zEquals;
                        if (!zEquals) {
                            Log.w("MSessionService", "Terminating service that was started by a stale start intent");
                            stopSelfSafely();
                        }
                    }
                } else {
                    mediaLibrarySessionOnGetSession = onGetSession(createFallbackMediaButtonCaller(intent));
                    if (mediaLibrarySessionOnGetSession != null) {
                        addSession(mediaLibrarySessionOnGetSession);
                        mediaLibrarySession = mediaLibrarySessionOnGetSession;
                        if ("android.intent.action.MEDIA_BUTTON".equals(intent.getAction())) {
                            MediaLibrarySessionImpl mediaLibrarySessionImpl2 = mediaLibrarySession.impl;
                            mediaLibrarySessionImpl2.applicationHandler.post(new TransactionExecutor$$ExternalSyntheticLambda0((Object) mediaLibrarySessionImpl2, (Object) intent, (byte) 13));
                        } else {
                            extras = intent.getExtras();
                            if (extras != null) {
                                obj = extras.get("androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION");
                            } else {
                                obj = null;
                            }
                            if (obj instanceof String) {
                                str = (String) obj;
                            } else {
                                str = null;
                            }
                            if (str == null) {
                                extras2 = intent.getExtras();
                                if (extras2 != null) {
                                    obj2 = extras2.get("androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION_EXTRAS");
                                } else {
                                    obj2 = null;
                                }
                                if (obj2 instanceof Bundle) {
                                    bundle = (Bundle) obj2;
                                } else {
                                    bundle = Bundle.EMPTY;
                                }
                                bundle2 = bundle;
                                mediaNotificationManager = getMediaNotificationManager(null);
                                connectedControllerForSession = mediaNotificationManager.getConnectedControllerForSession(mediaLibrarySession);
                                if (connectedControllerForSession != null) {
                                    Util.postOrRun(new Handler(mediaLibrarySession.getPlayer().getApplicationLooper()), new EdgeToEdge$$ExternalSyntheticLambda0(mediaNotificationManager, mediaLibrarySession, str, bundle2, connectedControllerForSession, (byte) 6));
                                }
                            } else if (!this.initialStartIntentProcessed) {
                                stopSelfSafely();
                                return 1;
                            }
                        }
                        if (!this.initialStartIntentProcessed) {
                            zEquals = Objects.equals(getMediaNotificationManager(null).startSelfIntentUid, intent.getStringExtra("androidx.media3.session.intent.uid"));
                            this.initialStartIntentProcessed = zEquals;
                            if (!zEquals) {
                                Log.w("MSessionService", "Terminating service that was started by a stale start intent");
                                stopSelfSafely();
                            }
                        }
                    } else if (!this.initialStartIntentProcessed) {
                        stopSelfSafely();
                        return 1;
                    }
                }
            } else if (!this.initialStartIntentProcessed) {
                zEquals = Objects.equals(getMediaNotificationManager(null).startSelfIntentUid, intent.getStringExtra("androidx.media3.session.intent.uid"));
                this.initialStartIntentProcessed = zEquals;
                if (!zEquals) {
                    Log.w("MSessionService", "Terminating service that was started by a stale start intent");
                    stopSelfSafely();
                }
            }
        }
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        if (getMediaNotificationManager(null).startedInForeground) {
            ArrayList sessions = getSessions();
            for (int i = 0; i < sessions.size(); i++) {
                if (((MediaLibraryService.MediaLibrarySession) sessions.get(i)).getPlayer().isPlaying()) {
                    return;
                }
            }
        }
        pauseAllPlayersAndStopSelf();
    }

    public void onUpdateNotification(MediaLibraryService.MediaLibrarySession mediaLibrarySession, boolean z) {
        MediaNotificationManager$$ExternalSyntheticLambda2 mediaNotificationManager$$ExternalSyntheticLambda2 = new MediaNotificationManager$$ExternalSyntheticLambda2(getMediaNotificationManager(null), mediaLibrarySession, z);
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = new CallbackToFutureAdapter$Completer();
        callbackToFutureAdapter$Completer.cancellationFuture = new ResolvableFuture();
        CallbackToFutureAdapter$SafeFuture callbackToFutureAdapter$SafeFuture = new CallbackToFutureAdapter$SafeFuture(callbackToFutureAdapter$Completer);
        callbackToFutureAdapter$Completer.future = callbackToFutureAdapter$SafeFuture;
        callbackToFutureAdapter$Completer.tag = MediaNotificationManager$$ExternalSyntheticLambda2.class;
        try {
            callbackToFutureAdapter$Completer.tag = mediaNotificationManager$$ExternalSyntheticLambda2.attachCompleter(callbackToFutureAdapter$Completer);
        } catch (Exception e) {
            callbackToFutureAdapter$SafeFuture.delegate.setException(e);
        }
        Maps$$ExternalSyntheticLambda1 maps$$ExternalSyntheticLambda1 = new Maps$$ExternalSyntheticLambda1((byte) 2, this);
        AbstractCatchingFuture$CatchingFuture abstractCatchingFuture$CatchingFuture = new AbstractCatchingFuture$CatchingFuture();
        abstractCatchingFuture$CatchingFuture.inputFuture = callbackToFutureAdapter$SafeFuture;
        abstractCatchingFuture$CatchingFuture.exceptionType = RuntimeException.class;
        abstractCatchingFuture$CatchingFuture.fallback = maps$$ExternalSyntheticLambda1;
        callbackToFutureAdapter$SafeFuture.addListener(abstractCatchingFuture$CatchingFuture, DirectExecutor.INSTANCE);
    }

    public final void onUpdateNotificationInternal(MediaLibraryService.MediaLibrarySession mediaLibrarySession, boolean z) {
        onUpdateNotification(mediaLibrarySession, getMediaNotificationManager(null).shouldRunInForeground(z));
    }

    public final void pauseAllPlayersAndStopSelf() {
        getMediaNotificationManager(null).disableUserEngagedTimeout();
        ArrayList sessions = getSessions();
        for (int i = 0; i < sessions.size(); i++) {
            ((MediaLibraryService.MediaLibrarySession) sessions.get(i)).getPlayer().setPlayWhenReady(false);
        }
        stopSelf();
    }

    public final void removeSession(MediaLibraryService.MediaLibrarySession mediaLibrarySession) {
        synchronized (this.lock) {
            UtilsKt.checkArgument("session not found", this.sessions.containsKey(mediaLibrarySession.impl.sessionId));
            this.sessions.remove(mediaLibrarySession.impl.sessionId);
        }
        Util.postOrRun(this.mainHandler, new MediaSessionService$$ExternalSyntheticLambda1(this, mediaLibrarySession, (byte) 1));
    }

    public final void stopSelfSafely() {
        MediaNotificationManager mediaNotificationManager = getMediaNotificationManager(null);
        CallbackWrapper notificationChannelInfo = mediaNotificationManager.mediaNotificationProvider.getNotificationChannelInfo();
        NotificationManager notificationManager = mediaNotificationManager.notificationManager;
        String str = (String) notificationChannelInfo.mCallback;
        String str2 = (String) notificationChannelInfo.mExecutor;
        String str3 = Util.DEVICE_DEBUG_INFO;
        if (notificationManager.getNotificationChannel(str) == null) {
            NotificationChannel notificationChannel = new NotificationChannel(str, str2, 2);
            if (Build.VERSION.SDK_INT <= 27) {
                notificationChannel.setShowBadge(false);
            }
            notificationManager.createNotificationChannel(notificationChannel);
        }
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(this, str);
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            notificationCompat$Builder.mFgsDeferBehavior = (byte) 2;
        }
        notificationCompat$Builder.setFlag(8, true);
        notificationCompat$Builder.mNotification.icon = R.drawable.media3_notification_small_icon;
        notificationCompat$Builder.mVisibility = -1;
        notificationCompat$Builder.setFlag(2, false);
        Pair pair = new Pair(20938, notificationCompat$Builder.build());
        int iIntValue = ((Integer) pair.first).intValue();
        Notification notification = (Notification) pair.second;
        if (i >= 29) {
            Util.Api29.startForeground(this, iIntValue, notification, 2, "mediaPlayback");
        } else {
            startForeground(iIntValue, notification);
        }
        getMediaNotificationManager(null).disableUserEngagedTimeout();
        stopForeground(1);
        stopSelf();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MediaSessionServiceStub extends Binder implements IMediaSessionService {
        public final Handler handler;
        public final Set pendingControllers;
        public final WeakReference serviceReference;

        public MediaSessionServiceStub(MediaSessionService mediaSessionService) {
            attachInterface(this, "androidx.media3.session.IMediaSessionService");
            this.serviceReference = new WeakReference(mediaSessionService);
            this.handler = new Handler(mediaSessionService.getApplicationContext().getMainLooper());
            this.pendingControllers = Collections.synchronizedSet(new HashSet());
        }

        public static IMediaSessionService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.media3.session.IMediaSessionService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IMediaSessionService)) {
                return (IMediaSessionService) iInterfaceQueryLocalInterface;
            }
            IMediaSessionService$Stub$Proxy iMediaSessionService$Stub$Proxy = new IMediaSessionService$Stub$Proxy();
            iMediaSessionService$Stub$Proxy.mRemote = iBinder;
            return iMediaSessionService$Stub$Proxy;
        }

        @Override // androidx.media3.session.IMediaSessionService
        public final void connect(IMediaController iMediaController, Bundle bundle) {
            if (iMediaController == null || bundle == null) {
                SQLite.disconnectIMediaController(iMediaController);
                return;
            }
            try {
                ConnectionRequest connectionRequestFromBundle = ConnectionRequest.fromBundle(bundle);
                String str = connectionRequestFromBundle.packageName;
                MediaSessionService mediaSessionService = (MediaSessionService) this.serviceReference.get();
                if (mediaSessionService == null) {
                    SQLite.disconnectIMediaController(iMediaController);
                    return;
                }
                int callingPid = Binder.getCallingPid();
                int callingUid = Binder.getCallingUid();
                long jClearCallingIdentity = Binder.clearCallingIdentity();
                if (callingPid == 0) {
                    callingPid = connectionRequestFromBundle.pid;
                }
                if (SQLite.checkPackageValidity(mediaSessionService, str, callingUid) == 0) {
                    MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo = new MediaSessionManager$RemoteUserInfo(str, callingPid, callingUid);
                    boolean zIsTrustedForMediaControl = MediaBrowserCompat.getSessionManager(mediaSessionService.getApplicationContext()).isTrustedForMediaControl(mediaSessionManager$RemoteUserInfo);
                    this.pendingControllers.add(iMediaController);
                    try {
                        this.handler.post(new MediaNotificationManager$$ExternalSyntheticLambda7(this, iMediaController, mediaSessionManager$RemoteUserInfo, connectionRequestFromBundle, zIsTrustedForMediaControl));
                        return;
                    } finally {
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                    }
                }
                Log.w("MSessionService", "Ignoring connection from invalid package name " + str + " (uid=" + callingUid + ")");
                SQLite.disconnectIMediaController(iMediaController);
            } catch (RuntimeException e) {
                Log.w("MSessionService", "Ignoring malformed Bundle for ConnectionRequest", e);
                SQLite.disconnectIMediaController(iMediaController);
            }
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface("androidx.media3.session.IMediaSessionService");
            }
            if (i == 1598968902) {
                parcel2.writeString("androidx.media3.session.IMediaSessionService");
                return true;
            }
            if (i != 3001) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            connect(MediaControllerStub.asInterface(parcel.readStrongBinder()), (Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null));
            return true;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }
    }
}
