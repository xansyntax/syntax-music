package dagger.hilt.android.internal.managers;

import androidx.navigation.internal.NavContext;
import com.metrolist.music.DaggerApp_HiltComponents_SingletonC$SingletonCImpl;
import com.metrolist.music.Hilt_App;
import dagger.hilt.internal.GeneratedComponentManager;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ApplicationComponentManager implements GeneratedComponentManager {
    public volatile DaggerApp_HiltComponents_SingletonC$SingletonCImpl component;
    public final ConnectionPool componentCreator;
    public final Object componentLock = new Object();

    public ApplicationComponentManager(ConnectionPool connectionPool) {
        this.componentCreator = connectionPool;
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        if (this.component == null) {
            synchronized (this.componentLock) {
                try {
                    if (this.component == null) {
                        this.component = new DaggerApp_HiltComponents_SingletonC$SingletonCImpl(new NavContext((Hilt_App) this.componentCreator.delegate, 0));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.component;
    }
}
