package dagger.hilt.android.internal.managers;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.media3.common.FlagSet;
import com.metrolist.music.DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl;
import com.metrolist.music.MainActivity;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.internal.lifecycle.RetainedLifecycleImpl;
import dagger.hilt.internal.GeneratedComponentManager;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityRetainedComponentManager implements GeneratedComponentManager {
    public volatile DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl component;
    public final Object componentLock = new Object();
    public final MainActivity context;
    public final MainActivity viewModelStoreOwner;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface ActivityRetainedComponentBuilderEntryPoint {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ActivityRetainedComponentViewModel extends ViewModel {
        public final DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl component;
        public final FlagSet.Builder savedStateHandleHolder;

        public ActivityRetainedComponentViewModel(DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl, FlagSet.Builder builder) {
            this.component = daggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl;
            this.savedStateHandleHolder = builder;
        }

        @Override // androidx.lifecycle.ViewModel
        public final void onCleared() {
            ((RetainedLifecycleImpl) ((DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl) ((ActivityRetainedLifecycleEntryPoint) EntryPoints.get(this.component, ActivityRetainedLifecycleEntryPoint.class))).provideActivityRetainedLifecycleProvider.get()).dispatchOnCleared();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface ActivityRetainedLifecycleEntryPoint {
    }

    public ActivityRetainedComponentManager(MainActivity mainActivity) {
        this.viewModelStoreOwner = mainActivity;
        this.context = mainActivity;
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        if (this.component == null) {
            synchronized (this.componentLock) {
                try {
                    if (this.component == null) {
                        MainActivity mainActivity = this.viewModelStoreOwner;
                        InitializerViewModelFactory initializerViewModelFactory = new InitializerViewModelFactory((byte) 2, this.context);
                        ViewModelStore viewModelStore = mainActivity.getViewModelStore();
                        CreationExtras viewModelCreationExtras = ViewModelKt.getViewModelCreationExtras(mainActivity);
                        viewModelStore.getClass();
                        viewModelCreationExtras.getClass();
                        Dispatcher dispatcher = new Dispatcher(viewModelStore, initializerViewModelFactory, viewModelCreationExtras);
                        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ActivityRetainedComponentViewModel.class);
                        String qualifiedName = orCreateKotlinClass.getQualifiedName();
                        if (qualifiedName == null) {
                            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                        }
                        this.component = ((ActivityRetainedComponentViewModel) dispatcher.getViewModel$lifecycle_viewmodel(orCreateKotlinClass, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(qualifiedName))).component;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.component;
    }
}
