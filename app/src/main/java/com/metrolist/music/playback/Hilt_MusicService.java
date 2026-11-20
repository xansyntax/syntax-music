package com.metrolist.music.playback;

import androidx.media3.datasource.cache.SimpleCache;
import androidx.media3.session.MediaLibraryService;
import com.metrolist.music.DaggerApp_HiltComponents_SingletonC$ServiceCImpl;
import com.metrolist.music.DaggerApp_HiltComponents_SingletonC$SingletonCImpl;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.eq.EqualizerService;
import com.metrolist.music.eq.data.EQProfileRepository;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.widget.MetrolistWidgetManager;
import dagger.hilt.android.internal.managers.ServiceComponentManager;
import dagger.hilt.internal.GeneratedComponentManager;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Hilt_MusicService extends MediaLibraryService implements GeneratedComponentManager {
    public volatile ServiceComponentManager componentManager;
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

    @Override // androidx.media3.session.MediaSessionService, androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        if (!this.injected) {
            this.injected = true;
            MusicService musicService = (MusicService) this;
            DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl = ((DaggerApp_HiltComponents_SingletonC$ServiceCImpl) ((MusicService_GeneratedInjector) generatedComponent())).singletonCImpl;
            musicService.database = (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get();
            musicService.lyricsHelper = daggerApp_HiltComponents_SingletonC$SingletonCImpl.lyricsHelper();
            musicService.syncUtils = (SyncUtils) daggerApp_HiltComponents_SingletonC$SingletonCImpl.syncUtilsProvider.get();
            musicService.downloadUtil = (DownloadUtil) daggerApp_HiltComponents_SingletonC$SingletonCImpl.downloadUtilProvider.get();
            musicService.mediaLibrarySessionCallback = new MediaLibrarySessionCallback(daggerApp_HiltComponents_SingletonC$SingletonCImpl.applicationContextModule.context, (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get(), (DownloadUtil) daggerApp_HiltComponents_SingletonC$SingletonCImpl.downloadUtilProvider.get());
            musicService.equalizerService = (EqualizerService) daggerApp_HiltComponents_SingletonC$SingletonCImpl.equalizerServiceProvider.get();
            musicService.eqProfileRepository = (EQProfileRepository) daggerApp_HiltComponents_SingletonC$SingletonCImpl.eQProfileRepositoryProvider.get();
            musicService.widgetManager = (MetrolistWidgetManager) daggerApp_HiltComponents_SingletonC$SingletonCImpl.metrolistWidgetManagerProvider.get();
            musicService.listenTogetherManager = (ListenTogetherManager) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideListenTogetherManagerProvider.get();
            musicService.playerCache = (SimpleCache) daggerApp_HiltComponents_SingletonC$SingletonCImpl.providePlayerCacheProvider.get();
            musicService.downloadCache = (SimpleCache) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDownloadCacheProvider.get();
        }
        super.onCreate();
    }
}
