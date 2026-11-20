package androidx.lifecycle;

import android.os.Bundle;
import android.view.View;
import androidx.collection.internal.Lock;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import androidx.datastore.core.AtomicInt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import androidx.lifecycle.viewmodel.internal.DefaultViewModelProviderFactory;
import androidx.lifecycle.viewmodel.internal.SynchronizedObject;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import coil3.util.UtilsKt;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.playback.DownloadUtil;
import com.yalantis.ucrop.R;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.collections.builders.MapBuilder;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorJobImpl;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ViewModelKt {
    public static final Lock SAVED_STATE_REGISTRY_OWNER_KEY = new Lock((byte) 22);
    public static final Lock VIEW_MODEL_STORE_OWNER_KEY = new Lock((byte) 23);
    public static final Lock DEFAULT_ARGS_KEY = new Lock((byte) 24);
    public static final SynchronizedObject VIEW_MODEL_SCOPE_LOCK = new SynchronizedObject();
    public static final Lock VIEW_MODEL_KEY = new Lock((byte) 26);

    public static final void attachHandleIfNeeded(ViewModel viewModel, SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        savedStateRegistry.getClass();
        lifecycle.getClass();
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) viewModel.getCloseable("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.isAttached) {
            return;
        }
        savedStateHandleController.attachToLifecycle(savedStateRegistry, lifecycle);
        Lifecycle.State state = ((LifecycleRegistry) lifecycle).state;
        if (state == Lifecycle.State.INITIALIZED || state.compareTo(Lifecycle.State.STARTED) >= 0) {
            savedStateRegistry.runOnNextRecreation();
        } else {
            lifecycle.addObserver(new DefaultLifecycleObserverAdapter((Object) lifecycle, (Object) savedStateRegistry, (byte) 2));
        }
    }

    public static final SavedStateHandle createSavedStateHandle(CreationExtras creationExtras) {
        SavedStateHandle savedStateHandle;
        creationExtras.getClass();
        SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) creationExtras.get(SAVED_STATE_REGISTRY_OWNER_KEY);
        Bundle bundle = null;
        if (savedStateRegistryOwner == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
            return null;
        }
        ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) creationExtras.get(VIEW_MODEL_STORE_OWNER_KEY);
        if (viewModelStoreOwner == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
            return null;
        }
        Bundle bundle2 = (Bundle) creationExtras.get(DEFAULT_ARGS_KEY);
        String str = (String) creationExtras.get(VIEW_MODEL_KEY);
        if (str == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("CreationExtras must have a value by `VIEW_MODEL_KEY`");
            return null;
        }
        SavedStateRegistry.SavedStateProvider savedStateProvider = savedStateRegistryOwner.getSavedStateRegistry().getSavedStateProvider("androidx.lifecycle.internal.SavedStateHandlesProvider");
        SavedStateHandlesProvider savedStateHandlesProvider = savedStateProvider instanceof SavedStateHandlesProvider ? (SavedStateHandlesProvider) savedStateProvider : null;
        if (savedStateHandlesProvider == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
            return null;
        }
        LinkedHashMap linkedHashMap = getSavedStateHandlesVM(viewModelStoreOwner).handles;
        SavedStateHandle savedStateHandle2 = (SavedStateHandle) linkedHashMap.get(str);
        if (savedStateHandle2 != null) {
            return savedStateHandle2;
        }
        savedStateHandlesProvider.performRestore();
        Bundle bundle3 = savedStateHandlesProvider.restoredState;
        if (bundle3 != null && bundle3.containsKey(str)) {
            Bundle bundle4 = bundle3.getBundle(str);
            if (bundle4 == null) {
                bundle4 = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
            }
            bundle3.remove(str);
            if (bundle3.isEmpty()) {
                savedStateHandlesProvider.restoredState = null;
            }
            bundle = bundle4;
        }
        if (bundle != null) {
            bundle2 = bundle;
        }
        if (bundle2 == null) {
            savedStateHandle = new SavedStateHandle();
        } else {
            ClassLoader classLoader = SavedStateHandle.class.getClassLoader();
            classLoader.getClass();
            bundle2.setClassLoader(classLoader);
            MapBuilder mapBuilder = new MapBuilder(bundle2.size());
            for (String str2 : bundle2.keySet()) {
                str2.getClass();
                mapBuilder.put(str2, bundle2.get(str2));
            }
            savedStateHandle = new SavedStateHandle(mapBuilder.build());
        }
        linkedHashMap.put(str, savedStateHandle);
        return savedStateHandle;
    }

    public static final void enableSavedStateHandles(SavedStateRegistryOwner savedStateRegistryOwner) {
        Lifecycle.State state = ((LifecycleRegistry) savedStateRegistryOwner.getLifecycle()).state;
        if (state != Lifecycle.State.INITIALIZED && state != Lifecycle.State.CREATED) {
            DifferentialMotionFlingController$$ExternalSyntheticLambda0.m$1("Failed to enable `SavedStateHandle` for `", savedStateRegistryOwner, "`. The `Lifecycle.State` must be `INITIALIZED` or `CREATED`, but was `", state, "`. You must call `enableSavedStateHandles()` before the `Lifecycle.State` moves to `STARTED`.");
        } else if (savedStateRegistryOwner.getSavedStateRegistry().getSavedStateProvider("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(savedStateRegistryOwner.getSavedStateRegistry(), (ViewModelStoreOwner) savedStateRegistryOwner);
            savedStateRegistryOwner.getSavedStateRegistry().registerSavedStateProvider("androidx.lifecycle.internal.SavedStateHandlesProvider", savedStateHandlesProvider);
            savedStateRegistryOwner.getLifecycle().addObserver(new Recreator((byte) 3, savedStateHandlesProvider));
        }
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public static final ViewModelStoreOwner m835get(View view) {
        view.getClass();
        while (view != null) {
            Object tag = view.getTag(R.id.view_tree_view_model_store_owner);
            ViewModelStoreOwner viewModelStoreOwner = tag instanceof ViewModelStoreOwner ? (ViewModelStoreOwner) tag : null;
            if (viewModelStoreOwner != null) {
                return viewModelStoreOwner;
            }
            Object parentOrViewTreeDisjointParent = DatabaseDao_Impl.AnonymousClass17.getParentOrViewTreeDisjointParent(view);
            view = parentOrViewTreeDisjointParent instanceof View ? (View) parentOrViewTreeDisjointParent : null;
        }
        return null;
    }

    public static final LifecycleCoroutineScopeImpl getCoroutineScope(Lifecycle lifecycle) {
        lifecycle.getClass();
        AtomicInt atomicInt = lifecycle.internalScopeRef;
        while (true) {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl = (LifecycleCoroutineScopeImpl) ((AtomicReference) atomicInt.delegate).get();
            if (lifecycleCoroutineScopeImpl != null) {
                return lifecycleCoroutineScopeImpl;
            }
            SupervisorJobImpl supervisorJobImplSupervisorJob$default = AwaitKt.SupervisorJob$default();
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = new LifecycleCoroutineScopeImpl(lifecycle, StringsKt__IndentKt.plus(supervisorJobImplSupervisorJob$default, MainDispatcherLoader.dispatcher.immediate));
            AtomicReference atomicReference = (AtomicReference) atomicInt.delegate;
            do {
                Continuation continuation = null;
                if (atomicReference.compareAndSet(null, lifecycleCoroutineScopeImpl2)) {
                    DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                    AwaitKt.launch$default(lifecycleCoroutineScopeImpl2, MainDispatcherLoader.dispatcher.immediate, null, new DownloadUtil.AnonymousClass2((Object) lifecycleCoroutineScopeImpl2, continuation, (byte) 5), 2);
                    return lifecycleCoroutineScopeImpl2;
                }
            } while (atomicReference.get() == null);
        }
    }

    public static final SavedStateHandlesVM getSavedStateHandlesVM(ViewModelStoreOwner viewModelStoreOwner) {
        SavedStateHandleSupport$savedStateHandlesVM$1 savedStateHandleSupport$savedStateHandlesVM$1 = new SavedStateHandleSupport$savedStateHandlesVM$1();
        CreationExtras viewModelCreationExtras = getViewModelCreationExtras(viewModelStoreOwner);
        viewModelCreationExtras.getClass();
        ViewModelStore viewModelStore = viewModelStoreOwner.getViewModelStore();
        viewModelStore.getClass();
        return (SavedStateHandlesVM) new Dispatcher(viewModelStore, savedStateHandleSupport$savedStateHandlesVM$1, viewModelCreationExtras).getViewModel$lifecycle_viewmodel(Reflection.getOrCreateKotlinClass(SavedStateHandlesVM.class), "androidx.lifecycle.internal.SavedStateHandlesVM");
    }

    public static final CreationExtras getViewModelCreationExtras(ViewModelStoreOwner viewModelStoreOwner) {
        return viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
    }

    public static final ViewModelProvider$Factory getViewModelProviderFactory(ViewModelStoreOwner viewModelStoreOwner) {
        return viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelProviderFactory() : DefaultViewModelProviderFactory.INSTANCE;
    }

    public static final CloseableCoroutineScope getViewModelScope(ViewModel viewModel) {
        CloseableCoroutineScope closeableCoroutineScope;
        viewModel.getClass();
        synchronized (VIEW_MODEL_SCOPE_LOCK) {
            closeableCoroutineScope = (CloseableCoroutineScope) viewModel.getCloseable("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY");
            if (closeableCoroutineScope == null) {
                CoroutineContext coroutineContext = EmptyCoroutineContext.INSTANCE;
                try {
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    coroutineContext = MainDispatcherLoader.dispatcher.immediate;
                } catch (IllegalStateException | NotImplementedError unused) {
                }
                CloseableCoroutineScope closeableCoroutineScope2 = new CloseableCoroutineScope(coroutineContext.plus(AwaitKt.SupervisorJob$default()));
                viewModel.addCloseable("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY", closeableCoroutineScope2);
                closeableCoroutineScope = closeableCoroutineScope2;
            }
        }
        return closeableCoroutineScope;
    }

    public static final LifecycleOwner get(View view) {
        view.getClass();
        while (view != null) {
            Object tag = view.getTag(R.id.view_tree_lifecycle_owner);
            LifecycleOwner lifecycleOwner = tag instanceof LifecycleOwner ? (LifecycleOwner) tag : null;
            if (lifecycleOwner != null) {
                return lifecycleOwner;
            }
            Object parentOrViewTreeDisjointParent = DatabaseDao_Impl.AnonymousClass17.getParentOrViewTreeDisjointParent(view);
            view = parentOrViewTreeDisjointParent instanceof View ? (View) parentOrViewTreeDisjointParent : null;
        }
        return null;
    }
}
