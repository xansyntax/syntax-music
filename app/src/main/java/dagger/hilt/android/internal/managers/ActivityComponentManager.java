package dagger.hilt.android.internal.managers;

import android.app.Application;
import androidx.media3.common.FlagSet;
import com.metrolist.music.DaggerApp_HiltComponents_SingletonC$ActivityCImpl;
import com.metrolist.music.DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl;
import com.metrolist.music.MainActivity;
import dagger.hilt.EntryPoints;
import dagger.hilt.internal.GeneratedComponentManager;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityComponentManager implements GeneratedComponentManager {
    public final MainActivity activity;
    public final ActivityRetainedComponentManager activityRetainedComponentManager;
    public FlagSet.Builder activitySavedStateHandleHolder;
    public volatile DaggerApp_HiltComponents_SingletonC$ActivityCImpl component;
    public final Object componentLock = new Object();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface ActivityComponentBuilderEntryPoint {
    }

    public ActivityComponentManager(MainActivity mainActivity) {
        this.activity = mainActivity;
        this.activityRetainedComponentManager = new ActivityRetainedComponentManager(mainActivity);
    }

    public final DaggerApp_HiltComponents_SingletonC$ActivityCImpl createComponent() {
        String str;
        MainActivity mainActivity = this.activity;
        if (mainActivity.getApplication() instanceof GeneratedComponentManager) {
            DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl = (DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl) ((ActivityComponentBuilderEntryPoint) EntryPoints.get(this.activityRetainedComponentManager, ActivityComponentBuilderEntryPoint.class));
            return new DaggerApp_HiltComponents_SingletonC$ActivityCImpl(daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl.singletonCImpl, daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl.activityRetainedCImpl);
        }
        if (Application.class.equals(mainActivity.getApplication().getClass())) {
            str = "Did you forget to specify your Application's class name in your manifest's <application />'s android:name attribute?";
        } else {
            str = "Found: " + mainActivity.getApplication().getClass();
        }
        throw new IllegalStateException("Hilt Activity must be attached to an @HiltAndroidApp Application. ".concat(str));
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        if (this.component == null) {
            synchronized (this.componentLock) {
                try {
                    if (this.component == null) {
                        this.component = createComponent();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.component;
    }
}
