package com.metrolist.music.playback;

import android.content.Intent;
import androidx.media3.exoplayer.offline.Download;
import androidx.media3.exoplayer.offline.DownloadManager;
import androidx.media3.exoplayer.offline.DownloadService;
import com.metrolist.music.DaggerApp_HiltComponents_SingletonC$ServiceCImpl;
import dagger.hilt.android.internal.managers.ServiceComponentManager;
import dagger.hilt.internal.GeneratedComponentManager;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ExoDownloadService extends DownloadService implements GeneratedComponentManager {
    public volatile ServiceComponentManager componentManager;
    public DownloadUtil downloadUtil;
    public final Object componentManagerLock = new Object();
    public boolean injected = false;

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        if (this.componentManager == null) {
            synchronized (this.componentManagerLock) {
                try {
                    if (this.componentManager == null) {
                        this.componentManager = new ServiceComponentManager(this);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.componentManager.generatedComponent();
    }

    public final DownloadUtil getDownloadUtil() {
        DownloadUtil downloadUtil = this.downloadUtil;
        if (downloadUtil != null) {
            return downloadUtil;
        }
        Intrinsics.throwUninitializedPropertyAccessException("downloadUtil");
        throw null;
    }

    @Override // androidx.media3.exoplayer.offline.DownloadService, android.app.Service
    public final void onCreate() {
        if (!this.injected) {
            this.injected = true;
            this.downloadUtil = (DownloadUtil) ((DaggerApp_HiltComponents_SingletonC$ServiceCImpl) ((ExoDownloadService_GeneratedInjector) generatedComponent())).singletonCImpl.downloadUtilProvider.get();
        }
        super.onCreate();
    }

    @Override // androidx.media3.exoplayer.offline.DownloadService, android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, "REMOVE_ALL_PENDING_DOWNLOADS")) {
            List<Download> list = getDownloadUtil().downloadManager.downloads;
            list.getClass();
            for (Download download : list) {
                DownloadManager downloadManager = getDownloadUtil().downloadManager;
                String str = download.request.id;
                downloadManager.pendingMessages++;
                downloadManager.internalHandler.obtainMessage(8, str).sendToTarget();
            }
        }
        super.onStartCommand(intent, i, i2);
        return 1;
    }
}
