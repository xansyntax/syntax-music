package androidx.navigation.internal;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDestination;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import coil3.disk.UtilsKt$$ExternalSyntheticLambda0;
import coil3.util.UtilsKt;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.SynchronizedLazyImpl;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavBackStackEntryImpl {
    public final SavedStateViewModelFactory defaultViewModelProviderFactory;
    public final NavDestination destination;
    public final NavBackStackEntry entry;
    public Lifecycle.State hostLifecycleState;
    public final String id;
    public final Bundle immutableArgs;
    public final LifecycleRegistry lifecycle;
    public Lifecycle.State maxLifecycle;
    public final SynchronizedLazyImpl navResultSavedStateFactory$delegate;
    public final Bundle savedState;
    public boolean savedStateRegistryAttached;
    public final SavedStateRegistryController savedStateRegistryController;
    public final NavControllerViewModel viewModelStoreProvider;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SavedStateViewModel extends ViewModel {
        public final SavedStateHandle handle;

        public SavedStateViewModel(SavedStateHandle savedStateHandle) {
            savedStateHandle.getClass();
            this.handle = savedStateHandle;
        }
    }

    public NavBackStackEntryImpl(NavBackStackEntry navBackStackEntry) {
        this.entry = navBackStackEntry;
        this.destination = navBackStackEntry.destination;
        this.immutableArgs = navBackStackEntry.immutableArgs;
        this.hostLifecycleState = navBackStackEntry.hostLifecycleState;
        this.viewModelStoreProvider = navBackStackEntry.viewModelStoreProvider;
        this.id = navBackStackEntry.id;
        this.savedState = navBackStackEntry.savedState;
        this.savedStateRegistryController = new SavedStateRegistryController(new SavedStateRegistryImpl(navBackStackEntry, new RoomDatabase$$ExternalSyntheticLambda0((byte) 27, navBackStackEntry)));
        SynchronizedLazyImpl synchronizedLazyImpl = new SynchronizedLazyImpl(new UtilsKt$$ExternalSyntheticLambda0((byte) 9));
        this.lifecycle = new LifecycleRegistry(navBackStackEntry, true);
        this.maxLifecycle = Lifecycle.State.INITIALIZED;
        this.defaultViewModelProviderFactory = (SavedStateViewModelFactory) synchronizedLazyImpl.getValue();
        this.navResultSavedStateFactory$delegate = new SynchronizedLazyImpl(new UtilsKt$$ExternalSyntheticLambda0((byte) 10));
    }

    public final Bundle getArguments$navigation_common_release() {
        Bundle bundle = this.immutableArgs;
        if (bundle == null) {
            return null;
        }
        Bundle bundleBundleOf = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
        bundleBundleOf.putAll(bundle);
        return bundleBundleOf;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Reflection.getOrCreateKotlinClass(NavBackStackEntry.class).getSimpleName());
        sb.append("(" + this.id + ')');
        sb.append(" destination=");
        sb.append(this.destination);
        return sb.toString();
    }

    public final void updateState$navigation_common_release() {
        if (!this.savedStateRegistryAttached) {
            SavedStateRegistryController savedStateRegistryController = this.savedStateRegistryController;
            savedStateRegistryController.impl.performAttach();
            this.savedStateRegistryAttached = true;
            if (this.viewModelStoreProvider != null) {
                ViewModelKt.enableSavedStateHandles(this.entry);
            }
            savedStateRegistryController.performRestore(this.savedState);
        }
        int iOrdinal = this.hostLifecycleState.ordinal();
        int iOrdinal2 = this.maxLifecycle.ordinal();
        LifecycleRegistry lifecycleRegistry = this.lifecycle;
        if (iOrdinal < iOrdinal2) {
            lifecycleRegistry.setCurrentState(this.hostLifecycleState);
        } else {
            lifecycleRegistry.setCurrentState(this.maxLifecycle);
        }
    }
}
