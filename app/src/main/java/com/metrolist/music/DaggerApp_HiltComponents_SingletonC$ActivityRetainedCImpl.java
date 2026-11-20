package com.metrolist.music;

import dagger.hilt.android.internal.lifecycle.RetainedLifecycleImpl;
import dagger.hilt.android.internal.managers.ActivityComponentManager;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager;
import dagger.hilt.internal.GeneratedComponent;
import dagger.internal.DoubleCheck;
import dagger.internal.Provider;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl implements ActivityComponentManager.ActivityComponentBuilderEntryPoint, ActivityRetainedComponentManager.ActivityRetainedLifecycleEntryPoint, GeneratedComponent {
    public final DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl activityRetainedCImpl = this;
    public final Provider provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider());
    public final DaggerApp_HiltComponents_SingletonC$SingletonCImpl singletonCImpl;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SwitchingProvider implements Provider {
        @Override // dagger.internal.Provider
        public final Object get() {
            return new RetainedLifecycleImpl();
        }
    }

    public DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl(DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl) {
        this.singletonCImpl = daggerApp_HiltComponents_SingletonC$SingletonCImpl;
    }
}
