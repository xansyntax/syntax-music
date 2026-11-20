package androidx.navigation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.collection.internal.Lock;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider$AndroidViewModelFactory;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.navigation.internal.NavBackStackEntryImpl;
import androidx.navigation.internal.NavContext;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.SynchronizedLazyImpl;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavBackStackEntry implements LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner {
    public final NavContext context;
    public NavDestination destination;
    public final Lifecycle.State hostLifecycleState;
    public final String id;
    public final Bundle immutableArgs;
    public final Bundle savedState;
    public final NavControllerViewModel viewModelStoreProvider;
    public final NavBackStackEntryImpl impl = new NavBackStackEntryImpl(this);
    public final SynchronizedLazyImpl savedStateHandle$delegate = new SynchronizedLazyImpl(new RoomDatabase$$ExternalSyntheticLambda0(23, this));

    public NavBackStackEntry(NavContext navContext, NavDestination navDestination, Bundle bundle, Lifecycle.State state, NavControllerViewModel navControllerViewModel, String str, Bundle bundle2) {
        this.context = navContext;
        this.destination = navDestination;
        this.immutableArgs = bundle;
        this.hostLifecycleState = state;
        this.viewModelStoreProvider = navControllerViewModel;
        this.id = str;
        this.savedState = bundle2;
    }

    public final boolean equals(Object obj) {
        Set<String> setKeySet;
        if (obj != null && (obj instanceof NavBackStackEntry)) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
            Bundle bundle = navBackStackEntry.immutableArgs;
            if (!this.id.equals(navBackStackEntry.id) || !Intrinsics.areEqual(this.destination, navBackStackEntry.destination) || this.impl.lifecycle != navBackStackEntry.impl.lifecycle || getSavedStateRegistry() != navBackStackEntry.getSavedStateRegistry()) {
                return false;
            }
            Bundle bundle2 = this.immutableArgs;
            if (Intrinsics.areEqual(bundle2, bundle)) {
                return true;
            }
            if (bundle2 != null && (setKeySet = bundle2.keySet()) != null) {
                Set<String> set = setKeySet;
                if ((set instanceof Collection) && set.isEmpty()) {
                    return true;
                }
                for (String str : set) {
                    if (!Intrinsics.areEqual(bundle2.get(str), bundle != null ? bundle.get(str) : null)) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003a  */
    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public final CreationExtras getDefaultViewModelCreationExtras() {
        Application application;
        NavBackStackEntryImpl navBackStackEntryImpl = this.impl;
        navBackStackEntryImpl.getClass();
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(0);
        Lock lock = ViewModelKt.SAVED_STATE_REGISTRY_OWNER_KEY;
        NavBackStackEntry navBackStackEntry = navBackStackEntryImpl.entry;
        LinkedHashMap linkedHashMap = mutableCreationExtras.extras;
        linkedHashMap.put(lock, navBackStackEntry);
        linkedHashMap.put(ViewModelKt.VIEW_MODEL_STORE_OWNER_KEY, navBackStackEntry);
        Bundle arguments$navigation_common_release = navBackStackEntryImpl.getArguments$navigation_common_release();
        if (arguments$navigation_common_release != null) {
            linkedHashMap.put(ViewModelKt.DEFAULT_ARGS_KEY, arguments$navigation_common_release);
        }
        NavContext navContext = this.context;
        if (navContext == null) {
            application = null;
        } else {
            Context context = navContext.context;
            Context applicationContext = context != null ? context.getApplicationContext() : null;
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
            } else {
                application = null;
            }
        }
        Application application2 = application != null ? application : null;
        if (application2 != null) {
            linkedHashMap.put(ViewModelProvider$AndroidViewModelFactory.APPLICATION_KEY, application2);
        }
        return mutableCreationExtras;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public final ViewModelProvider$Factory getDefaultViewModelProviderFactory() {
        return this.impl.defaultViewModelProviderFactory;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.impl.lifecycle;
    }

    public final SavedStateHandle getSavedStateHandle() {
        return (SavedStateHandle) this.savedStateHandle$delegate.getValue();
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.impl.savedStateRegistryController.savedStateRegistry;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        NavBackStackEntryImpl navBackStackEntryImpl = this.impl;
        if (!navBackStackEntryImpl.savedStateRegistryAttached) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("You cannot access the NavBackStackEntry's ViewModels until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).");
            return null;
        }
        if (navBackStackEntryImpl.lifecycle.state == Lifecycle.State.DESTROYED) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("You cannot access the NavBackStackEntry's ViewModels after the NavBackStackEntry is destroyed.");
            return null;
        }
        NavControllerViewModel navControllerViewModel = navBackStackEntryImpl.viewModelStoreProvider;
        if (navControllerViewModel == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
            return null;
        }
        String str = navBackStackEntryImpl.id;
        LinkedHashMap linkedHashMap = navControllerViewModel.viewModelStores;
        ViewModelStore viewModelStore = (ViewModelStore) linkedHashMap.get(str);
        if (viewModelStore != null) {
            return viewModelStore;
        }
        ViewModelStore viewModelStore2 = new ViewModelStore();
        linkedHashMap.put(str, viewModelStore2);
        return viewModelStore2;
    }

    public final int hashCode() {
        Set<String> setKeySet;
        int iHashCode = this.destination.hashCode() + (this.id.hashCode() * 31);
        Bundle bundle = this.immutableArgs;
        if (bundle != null && (setKeySet = bundle.keySet()) != null) {
            Iterator<T> it = setKeySet.iterator();
            while (it.hasNext()) {
                int i = iHashCode * 31;
                Object obj = bundle.get((String) it.next());
                iHashCode = i + (obj != null ? obj.hashCode() : 0);
            }
        }
        return getSavedStateRegistry().hashCode() + ((this.impl.lifecycle.hashCode() + (iHashCode * 31)) * 31);
    }

    public final void setMaxLifecycle(Lifecycle.State state) {
        NavBackStackEntryImpl navBackStackEntryImpl = this.impl;
        navBackStackEntryImpl.getClass();
        navBackStackEntryImpl.maxLifecycle = state;
        navBackStackEntryImpl.updateState$navigation_common_release();
    }

    public final String toString() {
        return this.impl.toString();
    }
}
