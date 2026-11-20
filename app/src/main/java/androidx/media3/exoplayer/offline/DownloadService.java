package androidx.media3.exoplayer.offline;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PersistableBundle;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda10;
import androidx.compose.ui.platform.WeakCache;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.NetworkTypeObserver;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.scheduler.Requirements;
import androidx.media3.exoplayer.scheduler.RequirementsWatcher;
import coil3.util.UtilsKt;
import com.metrolist.music.playback.ExoDownloadService;
import com.yalantis.ucrop.R;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import okhttp3.ConnectionSpec;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DownloadService extends Service {
    public static final HashMap downloadManagerHelpers = new HashMap();
    public final String channelId;
    public final int channelNameResourceId;
    public DownloadManagerHelper downloadManagerHelper;
    public final ConnectionSpec.Builder foregroundNotificationUpdater;
    public boolean isStopped;
    public int lastStartId;
    public boolean startedInForeground;
    public boolean taskRemoved;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DownloadManagerHelper implements DownloadManager.Listener {
        public final Context context;
        public final DownloadManager downloadManager;
        public DownloadService downloadService;
        public final boolean foregroundAllowed;
        public Requirements scheduledRequirements;
        public final WeakCache scheduler;
        public final Class serviceClass;

        public DownloadManagerHelper(Context context, DownloadManager downloadManager, boolean z, WeakCache weakCache, Class cls) {
            this.context = context;
            this.downloadManager = downloadManager;
            this.foregroundAllowed = z;
            this.scheduler = weakCache;
            this.serviceClass = cls;
            downloadManager.getClass();
            downloadManager.listeners.add(this);
            updateScheduler();
        }

        public final void cancelScheduler() {
            Requirements requirements = new Requirements(0);
            if (Objects.equals(this.scheduledRequirements, requirements)) {
                return;
            }
            ((JobScheduler) this.scheduler.referenceQueue).cancel(1);
            this.scheduledRequirements = requirements;
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.Listener
        public final void onDownloadChanged(DownloadManager downloadManager, Download download, Exception exc) {
            ConnectionSpec.Builder builder;
            DownloadService downloadService = this.downloadService;
            if (downloadService != null && (builder = downloadService.foregroundNotificationUpdater) != null) {
                int i = download.state;
                if (i == 2 || i == 5 || i == 7) {
                    builder.tls = true;
                    builder.update();
                } else if (builder.supportsTlsExtensions) {
                    builder.update();
                }
            }
            DownloadService downloadService2 = this.downloadService;
            if (downloadService2 == null || downloadService2.isStopped) {
                int i2 = download.state;
                if (i2 == 2 || i2 == 5 || i2 == 7) {
                    Log.w("DownloadService", "DownloadService wasn't running. Restarting.");
                    restartService();
                }
            }
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.Listener
        public final void onDownloadRemoved(DownloadManager downloadManager, Download download) {
            ConnectionSpec.Builder builder;
            DownloadService downloadService = this.downloadService;
            if (downloadService == null || (builder = downloadService.foregroundNotificationUpdater) == null || !builder.supportsTlsExtensions) {
                return;
            }
            builder.update();
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.Listener
        public final void onIdle() {
            DownloadService downloadService = this.downloadService;
            if (downloadService != null) {
                downloadService.onIdle();
            }
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.Listener
        public final void onInitialized(DownloadManager downloadManager) {
            DownloadService downloadService = this.downloadService;
            if (downloadService != null) {
                downloadService.notifyDownloads(downloadManager.downloads);
            }
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.Listener
        public final void onRequirementsStateChanged() {
            updateScheduler();
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.Listener
        public final void onWaitingForRequirementsChanged(DownloadManager downloadManager, boolean z) {
            if (z || downloadManager.downloadsPaused) {
                return;
            }
            DownloadService downloadService = this.downloadService;
            if (downloadService == null || downloadService.isStopped) {
                List list = downloadManager.downloads;
                for (int i = 0; i < list.size(); i++) {
                    if (((Download) list.get(i)).state == 0) {
                        restartService();
                        return;
                    }
                }
            }
        }

        public final void restartService() {
            Class cls = this.serviceClass;
            boolean z = this.foregroundAllowed;
            Context context = this.context;
            if (!z) {
                try {
                    context.startService(new Intent(context, (Class<?>) cls).setAction("androidx.media3.exoplayer.downloadService.action.INIT"));
                } catch (IllegalStateException unused) {
                    Log.w("DownloadService", "Failed to restart (process is idle)");
                }
            } else {
                try {
                    Intent action = new Intent(context, (Class<?>) cls).setAction("androidx.media3.exoplayer.downloadService.action.RESTART");
                    String str = Util.DEVICE_DEBUG_INFO;
                    context.startForegroundService(action);
                } catch (IllegalStateException unused2) {
                    Log.w("DownloadService", "Failed to restart (foreground launch restriction)");
                }
            }
        }

        public final boolean updateScheduler() {
            DownloadManager downloadManager = this.downloadManager;
            boolean z = downloadManager.waitingForRequirements;
            WeakCache weakCache = this.scheduler;
            if (weakCache == null) {
                return !z;
            }
            if (!z) {
                cancelScheduler();
                return true;
            }
            Requirements requirements = downloadManager.requirementsWatcher.requirements;
            int i = requirements.requirements;
            int i2 = i & 31;
            if (!(i2 == i ? requirements : new Requirements(i2)).equals(requirements)) {
                cancelScheduler();
                return false;
            }
            if (Objects.equals(this.scheduledRequirements, requirements)) {
                return true;
            }
            String packageName = this.context.getPackageName();
            ComponentName componentName = (ComponentName) weakCache.values;
            int i3 = i & 31;
            Requirements requirements2 = i3 == i ? requirements : new Requirements(i3);
            if (!requirements2.equals(requirements)) {
                Log.w("PlatformScheduler", "Ignoring unsupported requirements: " + (requirements2.requirements ^ i));
            }
            JobInfo.Builder builder = new JobInfo.Builder(1, componentName);
            if ((i & 2) != 0) {
                builder.setRequiredNetworkType(2);
            } else if ((i & 1) != 0) {
                builder.setRequiredNetworkType(1);
            }
            builder.setRequiresDeviceIdle((i & 4) != 0);
            builder.setRequiresCharging((i & 8) != 0);
            if ((i & 16) != 0) {
                builder.setRequiresStorageNotLow(true);
            }
            builder.setPersisted(true);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("service_action", "androidx.media3.exoplayer.downloadService.action.RESTART");
            persistableBundle.putString("service_package", packageName);
            persistableBundle.putInt("requirements", i);
            builder.setExtras(persistableBundle);
            if (((JobScheduler) weakCache.referenceQueue).schedule(builder.build()) == 1) {
                this.scheduledRequirements = requirements;
                return true;
            }
            Log.w("DownloadService", "Failed to schedule restart");
            cancelScheduler();
            return false;
        }
    }

    public DownloadService() {
        ConnectionSpec.Builder builder = new ConnectionSpec.Builder();
        builder.tlsVersions = this;
        builder.cipherSuites = new Handler(Looper.getMainLooper());
        this.foregroundNotificationUpdater = builder;
        this.channelId = "download";
        this.channelNameResourceId = R.string.downloading;
    }

    public static void sendRemoveDownload(Context context, String str) {
        context.startService(new Intent(context, (Class<?>) ExoDownloadService.class).setAction("androidx.media3.exoplayer.downloadService.action.REMOVE_DOWNLOAD").putExtra("foreground", false).putExtra("content_id", str));
    }

    public final void notifyDownloads(List list) {
        ConnectionSpec.Builder builder = this.foregroundNotificationUpdater;
        if (builder != null) {
            for (int i = 0; i < list.size(); i++) {
                int i2 = ((Download) list.get(i)).state;
                if (i2 == 2 || i2 == 5 || i2 == 7) {
                    builder.tls = true;
                    builder.update();
                    return;
                }
            }
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public void onCreate() {
        String str = this.channelId;
        if (str != null) {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            notificationManager.getClass();
            notificationManager.createNotificationChannel(new NotificationChannel(str, getString(this.channelNameResourceId), 2));
        }
        Class<?> cls = getClass();
        HashMap map = downloadManagerHelpers;
        DownloadManagerHelper downloadManagerHelper = (DownloadManagerHelper) map.get(cls);
        if (downloadManagerHelper == null) {
            boolean z = this.foregroundNotificationUpdater != null;
            WeakCache weakCache = (z && (Build.VERSION.SDK_INT < 31)) ? new WeakCache((ExoDownloadService) this) : null;
            DownloadManager downloadManager = ((ExoDownloadService) this).getDownloadUtil().downloadManager;
            downloadManager.setDownloadsPaused(false);
            DownloadManagerHelper downloadManagerHelper2 = new DownloadManagerHelper(getApplicationContext(), downloadManager, z, weakCache, cls);
            map.put(cls, downloadManagerHelper2);
            downloadManagerHelper = downloadManagerHelper2;
        }
        this.downloadManagerHelper = downloadManagerHelper;
        UtilsKt.checkState(downloadManagerHelper.downloadService == null);
        downloadManagerHelper.downloadService = this;
        if (downloadManagerHelper.downloadManager.initialized) {
            Util.createHandlerForCurrentOrMainLooper(null).postAtFrontOfQueue(new ComponentActivity$$ExternalSyntheticLambda10(downloadManagerHelper, this, (byte) 26));
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        DownloadManagerHelper downloadManagerHelper = this.downloadManagerHelper;
        downloadManagerHelper.getClass();
        UtilsKt.checkState(downloadManagerHelper.downloadService == this);
        downloadManagerHelper.downloadService = null;
        ConnectionSpec.Builder builder = this.foregroundNotificationUpdater;
        if (builder != null) {
            builder.tls = false;
            ((Handler) builder.cipherSuites).removeCallbacksAndMessages(null);
        }
    }

    public final void onIdle() {
        ConnectionSpec.Builder builder = this.foregroundNotificationUpdater;
        if (builder != null) {
            builder.tls = false;
            ((Handler) builder.cipherSuites).removeCallbacksAndMessages(null);
        }
        DownloadManagerHelper downloadManagerHelper = this.downloadManagerHelper;
        downloadManagerHelper.getClass();
        if (downloadManagerHelper.updateScheduler()) {
            if (Build.VERSION.SDK_INT >= 28 || !this.taskRemoved) {
                this.isStopped |= stopSelfResult(this.lastStartId);
            } else {
                stopSelf();
                this.isStopped = true;
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String action;
        String stringExtra;
        ConnectionSpec.Builder builder;
        this.lastStartId = i2;
        this.taskRemoved = false;
        if (intent != null) {
            action = intent.getAction();
            stringExtra = intent.getStringExtra("content_id");
            this.startedInForeground |= intent.getBooleanExtra("foreground", false) || "androidx.media3.exoplayer.downloadService.action.RESTART".equals(action);
        } else {
            action = null;
            stringExtra = null;
        }
        if (action == null) {
            action = "androidx.media3.exoplayer.downloadService.action.INIT";
        }
        DownloadManagerHelper downloadManagerHelper = this.downloadManagerHelper;
        downloadManagerHelper.getClass();
        DownloadManager downloadManager = downloadManagerHelper.downloadManager;
        switch (action) {
            case "androidx.media3.exoplayer.downloadService.action.SET_STOP_REASON":
                intent.getClass();
                if (intent.hasExtra("stop_reason")) {
                    int intExtra = intent.getIntExtra("stop_reason", 0);
                    downloadManager.pendingMessages++;
                    downloadManager.internalHandler.obtainMessage(4, intExtra, 0, stringExtra).sendToTarget();
                    break;
                } else {
                    Log.e("DownloadService", "Ignored SET_STOP_REASON: Missing stop_reason extra");
                    break;
                }
                break;
            case "androidx.media3.exoplayer.downloadService.action.REMOVE_DOWNLOAD":
                if (stringExtra == null) {
                    Log.e("DownloadService", "Ignored REMOVE_DOWNLOAD: Missing content_id extra");
                    break;
                } else {
                    downloadManager.pendingMessages++;
                    downloadManager.internalHandler.obtainMessage(8, stringExtra).sendToTarget();
                    break;
                }
                break;
            case "androidx.media3.exoplayer.downloadService.action.RESTART":
            case "androidx.media3.exoplayer.downloadService.action.INIT":
                break;
            case "androidx.media3.exoplayer.downloadService.action.RESUME_DOWNLOADS":
                downloadManager.setDownloadsPaused(false);
                break;
            case "androidx.media3.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS":
                downloadManager.pendingMessages++;
                downloadManager.internalHandler.obtainMessage(9).sendToTarget();
                break;
            case "androidx.media3.exoplayer.downloadService.action.ADD_DOWNLOAD":
                intent.getClass();
                DownloadRequest downloadRequest = (DownloadRequest) intent.getParcelableExtra("download_request");
                if (downloadRequest == null) {
                    Log.e("DownloadService", "Ignored ADD_DOWNLOAD: Missing download_request extra");
                    break;
                } else {
                    int intExtra2 = intent.getIntExtra("stop_reason", 0);
                    downloadManager.pendingMessages++;
                    downloadManager.internalHandler.obtainMessage(7, intExtra2, 0, downloadRequest).sendToTarget();
                    break;
                }
                break;
            case "androidx.media3.exoplayer.downloadService.action.SET_REQUIREMENTS":
                intent.getClass();
                Requirements requirements = (Requirements) intent.getParcelableExtra("requirements");
                if (requirements == null) {
                    Log.e("DownloadService", "Ignored SET_REQUIREMENTS: Missing requirements extra");
                    break;
                } else {
                    if (!requirements.equals(downloadManager.requirementsWatcher.requirements)) {
                        RequirementsWatcher requirementsWatcher = downloadManager.requirementsWatcher;
                        Context context = requirementsWatcher.context;
                        NetworkTypeObserver.Receiver receiver = requirementsWatcher.receiver;
                        receiver.getClass();
                        context.unregisterReceiver(receiver);
                        requirementsWatcher.receiver = null;
                        if (requirementsWatcher.networkCallback != null) {
                            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                            connectivityManager.getClass();
                            RequirementsWatcher.NetworkCallback networkCallback = requirementsWatcher.networkCallback;
                            networkCallback.getClass();
                            connectivityManager.unregisterNetworkCallback(networkCallback);
                            requirementsWatcher.networkCallback = null;
                        }
                        RequirementsWatcher requirementsWatcher2 = new RequirementsWatcher(downloadManager.context, downloadManager.requirementsListener, requirements);
                        downloadManager.requirementsWatcher = requirementsWatcher2;
                        downloadManager.onRequirementsStateChanged(downloadManager.requirementsWatcher, requirementsWatcher2.start());
                    }
                    break;
                }
                break;
            case "androidx.media3.exoplayer.downloadService.action.PAUSE_DOWNLOADS":
                downloadManager.setDownloadsPaused(true);
                break;
            default:
                Log.e("DownloadService", "Ignored unrecognized action: ".concat(action));
                break;
        }
        if (this.startedInForeground && (builder = this.foregroundNotificationUpdater) != null && !builder.supportsTlsExtensions) {
            builder.update();
        }
        this.isStopped = false;
        if (downloadManager.activeTaskCount == 0 && downloadManager.pendingMessages == 0) {
            onIdle();
        }
        return 1;
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
        this.taskRemoved = true;
    }

    public final void onTimeout(int i, int i2) {
        Log.w("DownloadService", "onTimeout() called by system. Calling stopSelf() to terminate gracefully.");
        stopSelf();
    }
}
