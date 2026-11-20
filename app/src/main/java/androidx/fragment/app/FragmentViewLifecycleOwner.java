package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider$AndroidViewModelFactory;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentViewLifecycleOwner implements HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, ViewModelStoreOwner {
    public ViewModelProvider$Factory mDefaultFactory;
    public final Fragment mFragment;
    public LifecycleRegistry mLifecycleRegistry = null;
    public SavedStateRegistryController mSavedStateRegistryController = null;
    public final ViewModelStore mViewModelStore;

    public FragmentViewLifecycleOwner(Fragment fragment, ViewModelStore viewModelStore) {
        this.mFragment = fragment;
        this.mViewModelStore = viewModelStore;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public final CreationExtras getDefaultViewModelCreationExtras() {
        Application application;
        Fragment fragment = this.mFragment;
        Context applicationContext = fragment.requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(0);
        LinkedHashMap linkedHashMap = mutableCreationExtras.extras;
        if (application != null) {
            linkedHashMap.put(ViewModelProvider$AndroidViewModelFactory.APPLICATION_KEY, application);
        }
        linkedHashMap.put(ViewModelKt.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        linkedHashMap.put(ViewModelKt.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (fragment.getArguments() != null) {
            linkedHashMap.put(ViewModelKt.DEFAULT_ARGS_KEY, fragment.getArguments());
        }
        return mutableCreationExtras;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public final ViewModelProvider$Factory getDefaultViewModelProviderFactory() {
        Application application;
        Fragment fragment = this.mFragment;
        ViewModelProvider$Factory defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(fragment.mDefaultFactory)) {
            this.mDefaultFactory = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        ViewModelProvider$Factory viewModelProvider$Factory = this.mDefaultFactory;
        if (viewModelProvider$Factory != null) {
            return viewModelProvider$Factory;
        }
        for (Context applicationContext = fragment.requireContext().getApplicationContext(); applicationContext instanceof ContextWrapper; applicationContext = ((ContextWrapper) applicationContext).getBaseContext()) {
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                SavedStateViewModelFactory savedStateViewModelFactory = new SavedStateViewModelFactory(application, this, fragment.getArguments());
                this.mDefaultFactory = savedStateViewModelFactory;
                return savedStateViewModelFactory;
            }
        }
        application = null;
        SavedStateViewModelFactory savedStateViewModelFactory2 = new SavedStateViewModelFactory(application, this, fragment.getArguments());
        this.mDefaultFactory = savedStateViewModelFactory2;
        return savedStateViewModelFactory2;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        initialize();
        return this.mLifecycleRegistry;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        initialize();
        return this.mSavedStateRegistryController.savedStateRegistry;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        initialize();
        return this.mViewModelStore;
    }

    public final void handleLifecycleEvent(Lifecycle.Event event) {
        this.mLifecycleRegistry.handleLifecycleEvent(event);
    }

    public final void initialize() {
        if (this.mLifecycleRegistry == null) {
            this.mLifecycleRegistry = new LifecycleRegistry(this, true);
            SavedStateRegistryImpl savedStateRegistryImpl = new SavedStateRegistryImpl(this, new RoomDatabase$$ExternalSyntheticLambda0((byte) 27, this));
            this.mSavedStateRegistryController = new SavedStateRegistryController(savedStateRegistryImpl);
            savedStateRegistryImpl.performAttach();
            ViewModelKt.enableSavedStateHandles(this);
        }
    }
}
