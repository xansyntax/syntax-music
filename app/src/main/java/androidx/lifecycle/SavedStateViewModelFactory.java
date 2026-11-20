package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.collection.internal.Lock;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.ClassReference;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateViewModelFactory implements ViewModelProvider$Factory {
    public final Application application;
    public final Bundle defaultArgs;
    public final ViewModelProvider$AndroidViewModelFactory factory;
    public final Lifecycle lifecycle;
    public final SavedStateRegistry savedStateRegistry;

    public SavedStateViewModelFactory(Application application, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
        ViewModelProvider$AndroidViewModelFactory viewModelProvider$AndroidViewModelFactory;
        this.savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        this.lifecycle = savedStateRegistryOwner.getLifecycle();
        this.defaultArgs = bundle;
        this.application = application;
        if (application != null) {
            viewModelProvider$AndroidViewModelFactory = ViewModelProvider$AndroidViewModelFactory._instance;
            if (viewModelProvider$AndroidViewModelFactory == null) {
                viewModelProvider$AndroidViewModelFactory = new ViewModelProvider$AndroidViewModelFactory(application);
                ViewModelProvider$AndroidViewModelFactory._instance = viewModelProvider$AndroidViewModelFactory;
            }
        } else {
            viewModelProvider$AndroidViewModelFactory = new ViewModelProvider$AndroidViewModelFactory(null);
        }
        this.factory = viewModelProvider$AndroidViewModelFactory;
    }

    public final ViewModel create(Class cls, String str) {
        SavedStateHandle savedStateHandle;
        Lifecycle lifecycle = this.lifecycle;
        if (lifecycle == null) {
            PathKt$$ExternalSyntheticBUOutline0.m$2("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
            return null;
        }
        boolean zIsAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
        Application application = this.application;
        Constructor constructorFindMatchingConstructor = (!zIsAssignableFrom || application == null) ? SavedStateViewModelFactory_androidKt.findMatchingConstructor(cls, SavedStateViewModelFactory_androidKt.VIEWMODEL_SIGNATURE) : SavedStateViewModelFactory_androidKt.findMatchingConstructor(cls, SavedStateViewModelFactory_androidKt.ANDROID_VIEWMODEL_SIGNATURE);
        if (constructorFindMatchingConstructor == null) {
            if (application != null) {
                return this.factory.create(cls);
            }
            ViewModelProvider$NewInstanceFactory viewModelProvider$NewInstanceFactory = ViewModelProvider$NewInstanceFactory._instance;
            if (viewModelProvider$NewInstanceFactory == null) {
                viewModelProvider$NewInstanceFactory = new ViewModelProvider$NewInstanceFactory();
                ViewModelProvider$NewInstanceFactory._instance = viewModelProvider$NewInstanceFactory;
            }
            return viewModelProvider$NewInstanceFactory.create(cls);
        }
        SavedStateRegistry savedStateRegistry = this.savedStateRegistry;
        savedStateRegistry.getClass();
        Bundle bundleConsumeRestoredStateForKey = savedStateRegistry.consumeRestoredStateForKey(str);
        if (bundleConsumeRestoredStateForKey == null) {
            bundleConsumeRestoredStateForKey = this.defaultArgs;
        }
        if (bundleConsumeRestoredStateForKey == null) {
            savedStateHandle = new SavedStateHandle();
        } else {
            ClassLoader classLoader = SavedStateHandle.class.getClassLoader();
            classLoader.getClass();
            bundleConsumeRestoredStateForKey.setClassLoader(classLoader);
            MapBuilder mapBuilder = new MapBuilder(bundleConsumeRestoredStateForKey.size());
            for (String str2 : bundleConsumeRestoredStateForKey.keySet()) {
                str2.getClass();
                mapBuilder.put(str2, bundleConsumeRestoredStateForKey.get(str2));
            }
            savedStateHandle = new SavedStateHandle(mapBuilder.build());
        }
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, savedStateHandle);
        savedStateHandleController.attachToLifecycle(savedStateRegistry, lifecycle);
        Lifecycle.State state = ((LifecycleRegistry) lifecycle).state;
        if (state == Lifecycle.State.INITIALIZED || state.compareTo(Lifecycle.State.STARTED) >= 0) {
            savedStateRegistry.runOnNextRecreation();
        } else {
            lifecycle.addObserver(new DefaultLifecycleObserverAdapter((Object) lifecycle, (Object) savedStateRegistry, (byte) 2));
        }
        ViewModel viewModelNewInstance = (!zIsAssignableFrom || application == null) ? SavedStateViewModelFactory_androidKt.newInstance(cls, constructorFindMatchingConstructor, savedStateHandle) : SavedStateViewModelFactory_androidKt.newInstance(cls, constructorFindMatchingConstructor, application, savedStateHandle);
        viewModelNewInstance.addCloseable("androidx.lifecycle.savedstate.vm.tag", savedStateHandleController);
        return viewModelNewInstance;
    }

    public SavedStateViewModelFactory() {
        this.factory = new ViewModelProvider$AndroidViewModelFactory(null);
    }

    @Override // androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
        Constructor constructorFindMatchingConstructor;
        Lock lock = ViewModelKt.VIEW_MODEL_KEY;
        LinkedHashMap linkedHashMap = mutableCreationExtras.extras;
        String str = (String) linkedHashMap.get(lock);
        if (str != null) {
            if (linkedHashMap.get(ViewModelKt.SAVED_STATE_REGISTRY_OWNER_KEY) != null && linkedHashMap.get(ViewModelKt.VIEW_MODEL_STORE_OWNER_KEY) != null) {
                Application application = (Application) linkedHashMap.get(ViewModelProvider$AndroidViewModelFactory.APPLICATION_KEY);
                boolean zIsAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
                if (zIsAssignableFrom && application != null) {
                    constructorFindMatchingConstructor = SavedStateViewModelFactory_androidKt.findMatchingConstructor(cls, SavedStateViewModelFactory_androidKt.ANDROID_VIEWMODEL_SIGNATURE);
                } else {
                    constructorFindMatchingConstructor = SavedStateViewModelFactory_androidKt.findMatchingConstructor(cls, SavedStateViewModelFactory_androidKt.VIEWMODEL_SIGNATURE);
                }
                if (constructorFindMatchingConstructor == null) {
                    return this.factory.create(cls, mutableCreationExtras);
                }
                if (zIsAssignableFrom && application != null) {
                    return SavedStateViewModelFactory_androidKt.newInstance(cls, constructorFindMatchingConstructor, application, ViewModelKt.createSavedStateHandle(mutableCreationExtras));
                }
                return SavedStateViewModelFactory_androidKt.newInstance(cls, constructorFindMatchingConstructor, ViewModelKt.createSavedStateHandle(mutableCreationExtras));
            }
            if (this.lifecycle != null) {
                return create(cls, str);
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
            return null;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        return null;
    }

    @Override // androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(ClassReference classReference, MutableCreationExtras mutableCreationExtras) {
        return create(Okio__OkioKt.getJavaClass(classReference), mutableCreationExtras);
    }

    @Override // androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return create(cls, canonicalName);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Local and anonymous classes can not be ViewModels");
        return null;
    }
}
