package dagger.hilt.android.internal.managers;

import android.app.Application;
import android.app.Service;
import com.metrolist.music.DaggerApp_HiltComponents_SingletonC$ServiceCImpl;
import com.metrolist.music.DaggerApp_HiltComponents_SingletonC$SingletonCImpl;
import dagger.hilt.EntryPoints;
import dagger.hilt.internal.GeneratedComponentManager;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceComponentManager implements GeneratedComponentManager {
    public DaggerApp_HiltComponents_SingletonC$ServiceCImpl component;
    public final Service service;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface ServiceComponentBuilderEntryPoint {
    }

    public ServiceComponentManager(Service service) {
        this.service = service;
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        DaggerApp_HiltComponents_SingletonC$ServiceCImpl daggerApp_HiltComponents_SingletonC$ServiceCImpl = this.component;
        if (daggerApp_HiltComponents_SingletonC$ServiceCImpl != null) {
            return daggerApp_HiltComponents_SingletonC$ServiceCImpl;
        }
        Application application = this.service.getApplication();
        boolean z = application instanceof GeneratedComponentManager;
        Class<?> cls = application.getClass();
        if (!z) {
            PathKt$$ExternalSyntheticBUOutline0.m$1(cls, "Hilt service must be attached to an @HiltAndroidApp Application. Found: ");
            return null;
        }
        DaggerApp_HiltComponents_SingletonC$ServiceCImpl daggerApp_HiltComponents_SingletonC$ServiceCImpl2 = new DaggerApp_HiltComponents_SingletonC$ServiceCImpl(((DaggerApp_HiltComponents_SingletonC$SingletonCImpl) ((ServiceComponentBuilderEntryPoint) EntryPoints.get(application, ServiceComponentBuilderEntryPoint.class))).singletonCImpl);
        this.component = daggerApp_HiltComponents_SingletonC$ServiceCImpl2;
        return daggerApp_HiltComponents_SingletonC$ServiceCImpl2;
    }
}
