package androidx.media3.session;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.media3.common.Player;
import androidx.media3.common.util.Util;
import androidx.media3.session.legacy.MediaSessionCompat$MediaSessionImplApi23;
import com.google.common.util.concurrent.ImmediateFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import kotlin.uuid.UuidKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaNotificationManager implements Handler.Callback {
    public final DefaultActionFactory actionFactory;
    public final HashMap controllerMap;
    public boolean isUserEngaged;
    public boolean isUserEngagedTimeoutEnabled;
    public final MediaControllerHolder$$ExternalSyntheticLambda1 mainExecutor;
    public final Handler mainHandler;
    public PriorityQueue mediaNotification;
    public MediaNotification$Provider mediaNotificationProvider;
    public final MediaSessionService mediaSessionService;
    public final NotificationManager notificationManager;
    public final byte showNotificationForIdlePlayerMode;
    public final Intent startSelfIntent;
    public final String startSelfIntentUid;
    public boolean startedInForeground;
    public int totalNotificationCount;
    public final int userEngagedTimeoutMs;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ControllerInfo {
        public final MediaControllerHolder controllerFuture;
        public boolean hasBeenPrepared;
        public boolean wasNotificationDismissed;

        public ControllerInfo(MediaControllerHolder mediaControllerHolder) {
            this.controllerFuture = mediaControllerHolder;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MediaControllerListener implements MediaController.Listener, Player.Listener {
        public final MediaSessionService mediaSessionService;
        public final MediaLibraryService.MediaLibrarySession session;

        public MediaControllerListener(MediaSessionService mediaSessionService, MediaLibraryService.MediaLibrarySession mediaLibrarySession) {
            this.mediaSessionService = mediaSessionService;
            this.session = mediaLibrarySession;
        }

        @Override // androidx.media3.session.MediaController.Listener
        public final void onAvailableSessionCommandsChanged() {
            this.mediaSessionService.onUpdateNotificationInternal(this.session, false);
        }

        @Override // androidx.media3.session.MediaController.Listener
        public final ImmediateFuture onCustomCommand(SessionCommand sessionCommand) {
            int i;
            if (sessionCommand.customAction.equals("androidx.media3.session.NOTIFICATION_DISMISSED_EVENT_KEY")) {
                ControllerInfo controllerInfo = (ControllerInfo) MediaNotificationManager.this.controllerMap.get(this.session);
                if (controllerInfo != null) {
                    controllerInfo.wasNotificationDismissed = true;
                }
                i = 0;
            } else {
                i = -6;
            }
            return new ImmediateFuture(new SessionResult(i));
        }

        @Override // androidx.media3.session.MediaController.Listener
        public final void onDisconnected() {
            MediaSessionService mediaSessionService = this.mediaSessionService;
            MediaLibraryService.MediaLibrarySession mediaLibrarySession = this.session;
            if (mediaSessionService.isSessionAdded(mediaLibrarySession)) {
                mediaSessionService.removeSession(mediaLibrarySession);
            }
            mediaSessionService.onUpdateNotificationInternal(mediaLibrarySession, false);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void onEvents(Player player, Player.Events events) {
            if (events.flags.containsAny(4, 5, 14, 0)) {
                this.mediaSessionService.onUpdateNotificationInternal(this.session, false);
            }
        }

        @Override // androidx.media3.session.MediaController.Listener
        public final void onMediaButtonPreferencesChanged() {
            this.mediaSessionService.onUpdateNotificationInternal(this.session, false);
        }
    }

    public MediaNotificationManager(MediaSessionService mediaSessionService, MediaNotification$Provider mediaNotification$Provider, DefaultActionFactory defaultActionFactory) {
        this.mediaSessionService = mediaSessionService;
        this.mediaNotificationProvider = mediaNotification$Provider;
        this.actionFactory = defaultActionFactory;
        NotificationManager notificationManager = (NotificationManager) mediaSessionService.getSystemService("notification");
        notificationManager.getClass();
        this.notificationManager = notificationManager;
        Looper mainLooper = Looper.getMainLooper();
        String str = Util.DEVICE_DEBUG_INFO;
        this.mainHandler = new Handler(mainLooper, this);
        this.mainExecutor = new MediaControllerHolder$$ExternalSyntheticLambda1((byte) 3, this);
        Intent intent = new Intent(mediaSessionService, mediaSessionService.getClass());
        this.startSelfIntent = intent;
        String string = UUID.randomUUID().toString();
        this.startSelfIntentUid = string;
        intent.putExtra("androidx.media3.session.intent.uid", string);
        this.controllerMap = new HashMap();
        this.startedInForeground = false;
        this.isUserEngagedTimeoutEnabled = true;
        this.userEngagedTimeoutMs = 600000;
        this.showNotificationForIdlePlayerMode = (byte) 3;
    }

    public final void disableUserEngagedTimeout() {
        this.isUserEngagedTimeoutEnabled = false;
        Handler handler = this.mainHandler;
        if (handler.hasMessages(1)) {
            handler.removeMessages(1);
            MediaSessionService mediaSessionService = this.mediaSessionService;
            ArrayList sessions = mediaSessionService.getSessions();
            for (int i = 0; i < sessions.size(); i++) {
                mediaSessionService.onUpdateNotificationInternal((MediaLibraryService.MediaLibrarySession) sessions.get(i), false);
            }
        }
    }

    public final MediaController getConnectedControllerForSession(MediaLibraryService.MediaLibrarySession mediaLibrarySession) {
        ControllerInfo controllerInfo = (ControllerInfo) this.controllerMap.get(mediaLibrarySession);
        if (controllerInfo == null) {
            return null;
        }
        MediaControllerHolder mediaControllerHolder = controllerInfo.controllerFuture;
        if (!mediaControllerHolder.isDone()) {
            return null;
        }
        try {
            return (MediaController) UuidKt.getDone(mediaControllerHolder);
        } catch (ExecutionException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        MediaSessionService mediaSessionService = this.mediaSessionService;
        ArrayList sessions = mediaSessionService.getSessions();
        for (int i = 0; i < sessions.size(); i++) {
            mediaSessionService.onUpdateNotificationInternal((MediaLibraryService.MediaLibrarySession) sessions.get(i), false);
        }
        return true;
    }

    public final boolean shouldRunInForeground(boolean z) {
        boolean z2;
        long j = this.userEngagedTimeoutMs;
        ArrayList sessions = this.mediaSessionService.getSessions();
        int i = 0;
        while (true) {
            if (i >= sessions.size()) {
                z2 = false;
                break;
            }
            MediaController connectedControllerForSession = getConnectedControllerForSession((MediaLibraryService.MediaLibrarySession) sessions.get(i));
            if (connectedControllerForSession != null && ((connectedControllerForSession.getPlayWhenReady() || z) && (connectedControllerForSession.getPlaybackState() == 3 || connectedControllerForSession.getPlaybackState() == 2))) {
                z2 = true;
                break;
            }
            i++;
        }
        boolean z3 = this.isUserEngagedTimeoutEnabled && j > 0;
        boolean z4 = this.isUserEngaged;
        Handler handler = this.mainHandler;
        if (z4 && !z2 && z3) {
            handler.sendEmptyMessageDelayed(1, j);
        } else if (z2) {
            handler.removeMessages(1);
        }
        this.isUserEngaged = z2;
        return z2 || handler.hasMessages(1);
    }

    public final boolean shouldShowNotification(MediaLibraryService.MediaLibrarySession mediaLibrarySession) {
        MediaController connectedControllerForSession = getConnectedControllerForSession(mediaLibrarySession);
        if (connectedControllerForSession != null && !connectedControllerForSession.getCurrentTimeline().isEmpty()) {
            ControllerInfo controllerInfo = (ControllerInfo) this.controllerMap.get(mediaLibrarySession);
            controllerInfo.getClass();
            if (connectedControllerForSession.getPlaybackState() != 1) {
                controllerInfo.wasNotificationDismissed = false;
                controllerInfo.hasBeenPrepared = true;
                return true;
            }
            byte b = this.showNotificationForIdlePlayerMode;
            if (b == 1) {
                return !controllerInfo.wasNotificationDismissed;
            }
            if (b != 2) {
                if (b != 3) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m();
                    return false;
                }
                if (!controllerInfo.wasNotificationDismissed && controllerInfo.hasBeenPrepared) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void updateNotificationInternal(MediaLibraryService.MediaLibrarySession mediaLibrarySession, PriorityQueue priorityQueue, boolean z) {
        MediaSession.Token token = ((MediaSessionCompat$MediaSessionImplApi23) mediaLibrarySession.impl.sessionLegacyStub.sessionCompat.mCallback).token.inner;
        Notification notification = (Notification) priorityQueue.array;
        int i = priorityQueue.size;
        notification.extras.putParcelable("android.mediaSession", token);
        this.mediaNotification = priorityQueue;
        MediaSessionService mediaSessionService = this.mediaSessionService;
        if (!z) {
            this.notificationManager.notify(i, notification);
            String str = Util.DEVICE_DEBUG_INFO;
            mediaSessionService.stopForeground(2);
        } else {
            mediaSessionService.startForegroundService(this.startSelfIntent);
            String str2 = Util.DEVICE_DEBUG_INFO;
            if (Build.VERSION.SDK_INT >= 29) {
                Util.Api29.startForeground(mediaSessionService, i, notification, 2, "mediaPlayback");
            } else {
                mediaSessionService.startForeground(i, notification);
            }
            this.startedInForeground = true;
        }
    }
}
