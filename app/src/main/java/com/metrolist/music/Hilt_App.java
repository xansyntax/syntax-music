package com.metrolist.music;

import android.app.Application;
import dagger.hilt.android.internal.managers.ApplicationComponentManager;
import dagger.hilt.internal.GeneratedComponentManager;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Hilt_App extends Application implements GeneratedComponentManager {
    public boolean injected = false;
    public final ApplicationComponentManager componentManager = new ApplicationComponentManager(new ConnectionPool(this));

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        return this.componentManager.generatedComponent();
    }

    @Override // android.app.Application
    public void onCreate() {
        if (!this.injected) {
            this.injected = true;
            ((App) this).applicationScope = (CoroutineScope) ((DaggerApp_HiltComponents_SingletonC$SingletonCImpl) ((App_GeneratedInjector) this.componentManager.generatedComponent())).provideApplicationScopeProvider.get();
        }
        super.onCreate();
    }
}
