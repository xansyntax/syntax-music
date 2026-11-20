package androidx.activity;

import android.app.Application;
import android.app.PictureInPictureUiState;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.contextaware.ContextAwareHelper;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.collection.internal.Lock;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.NavUtils;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.app.PictureInPictureParamsCompat;
import androidx.core.app.PictureInPictureUiStateCompat$Companion;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuHostHelper$$ExternalSyntheticLambda0;
import androidx.core.view.MenuHostHelper$$ExternalSyntheticLambda1;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider$AndroidViewModelFactory;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.media3.common.util.ListenerSet$$ExternalSyntheticLambda1;
import androidx.navigationevent.DirectNavigationEventInput;
import androidx.navigationevent.NavigationEventDispatcher;
import androidx.navigationevent.NavigationEventDispatcherOwner;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import coil3.Extras;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.SynchronizedLazyImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ComponentActivity extends androidx.core.app.ComponentActivity implements ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, OnBackPressedDispatcherOwner, NavigationEventDispatcherOwner, ActivityResultRegistryOwner, OnConfigurationChangedProvider, OnTrimMemoryProvider, OnMultiWindowModeChangedProvider, OnPictureInPictureModeChangedProvider, MenuHost {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private static final Companion Companion = new Companion();
    private ViewModelStore _viewModelStore;
    private final ActivityResultRegistry activityResultRegistry;
    private int contentLayoutId;
    private final Lazy defaultViewModelProviderFactory$delegate;
    private boolean dispatchingOnMultiWindowModeChanged;
    private boolean dispatchingOnPictureInPictureModeChanged;
    private final Lazy fullyDrawnReporter$delegate;
    private boolean hasPictureInPictureSystemFeature;
    private final AtomicInteger nextLocalRequestCode;
    private final Lazy onBackPressedDispatcher$delegate;
    private final Lazy onBackPressedInput$delegate;
    private final CopyOnWriteArrayList<Consumer> onConfigurationChangedListeners;
    private final CopyOnWriteArrayList<Consumer> onMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer> onNewIntentListeners;
    private final CopyOnWriteArrayList<Consumer> onPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer> onPictureInPictureUiStateChangedListeners;
    private final CopyOnWriteArrayList<Consumer> onTrimMemoryListeners;
    private final CopyOnWriteArrayList<Runnable> onUserLeaveHintListeners;
    private final ReportFullyDrawnExecutor reportFullyDrawnExecutor;
    private final SavedStateRegistryController savedStateRegistryController;
    private final ContextAwareHelper contextAwareHelper = new ContextAwareHelper();
    private final MenuHostHelper menuHostHelper = new MenuHostHelper(new ComponentActivity$$ExternalSyntheticLambda0(this, 0));

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Companion {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class NonConfigurationInstances {
        public Object custom;
        public ViewModelStore viewModelStore;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface ReportFullyDrawnExecutor extends Executor {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ReportFullyDrawnExecutorImpl implements ReportFullyDrawnExecutor, ViewTreeObserver.OnDrawListener, Runnable {
        public Runnable currentRunnable;
        public final long endWatchTimeMillis = SystemClock.uptimeMillis() + 10000;
        public boolean onDrawScheduled;

        public ReportFullyDrawnExecutorImpl() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.getClass();
            this.currentRunnable = runnable;
            View decorView = ComponentActivity.this.getWindow().getDecorView();
            decorView.getClass();
            if (!this.onDrawScheduled) {
                decorView.postOnAnimation(new ActivityCompat$$ExternalSyntheticLambda0((byte) 1, (Object) this));
            } else if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            boolean z;
            Runnable runnable = this.currentRunnable;
            if (runnable == null) {
                if (SystemClock.uptimeMillis() > this.endWatchTimeMillis) {
                    this.onDrawScheduled = false;
                    ComponentActivity.this.getWindow().getDecorView().post(this);
                    return;
                }
                return;
            }
            runnable.run();
            this.currentRunnable = null;
            FullyDrawnReporter fullyDrawnReporter = ComponentActivity.this.getFullyDrawnReporter();
            synchronized (fullyDrawnReporter.lock) {
                z = fullyDrawnReporter.reportedFullyDrawn;
            }
            if (z) {
                this.onDrawScheduled = false;
                ComponentActivity.this.getWindow().getDecorView().post(this);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        public final void viewCreated(View view) {
            if (this.onDrawScheduled) {
                return;
            }
            this.onDrawScheduled = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }
    }

    public ComponentActivity() {
        SavedStateRegistryImpl savedStateRegistryImpl = new SavedStateRegistryImpl(this, new RoomDatabase$$ExternalSyntheticLambda0((byte) 27, this));
        this.savedStateRegistryController = new SavedStateRegistryController(savedStateRegistryImpl);
        this.reportFullyDrawnExecutor = new ReportFullyDrawnExecutorImpl();
        this.fullyDrawnReporter$delegate = new SynchronizedLazyImpl(new ComponentActivity$$ExternalSyntheticLambda1(this, (byte) 0));
        this.nextLocalRequestCode = new AtomicInteger();
        this.activityResultRegistry = new ActivityResultRegistry() { // from class: androidx.activity.ComponentActivity$activityResultRegistry$1
            @Override // androidx.activity.result.ActivityResultRegistry
            public final void onLaunch(int i, ActivityResultContract activityResultContract, Object obj) {
                Bundle bundleExtra;
                int i2;
                activityResultContract.getClass();
                ComponentActivity componentActivity = this.this$0;
                Extras.Key synchronousResult = activityResultContract.getSynchronousResult(componentActivity, obj);
                if (synchronousResult != null) {
                    new Handler(Looper.getMainLooper()).post(new ListenerSet$$ExternalSyntheticLambda1(this, i, synchronousResult, (byte) 1));
                    return;
                }
                Intent intentCreateIntent = activityResultContract.createIntent(componentActivity, obj);
                if (intentCreateIntent.getExtras() != null) {
                    Bundle extras = intentCreateIntent.getExtras();
                    extras.getClass();
                    if (extras.getClassLoader() == null) {
                        intentCreateIntent.setExtrasClassLoader(componentActivity.getClassLoader());
                    }
                }
                if (intentCreateIntent.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                    bundleExtra = intentCreateIntent.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    intentCreateIntent.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                } else {
                    bundleExtra = null;
                }
                Bundle bundle = bundleExtra;
                if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentCreateIntent.getAction())) {
                    String[] stringArrayExtra = intentCreateIntent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    if (stringArrayExtra == null) {
                        stringArrayExtra = new String[0];
                    }
                    NavUtils.requestPermissions(componentActivity, stringArrayExtra, i);
                    return;
                }
                if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentCreateIntent.getAction())) {
                    componentActivity.startActivityForResult(intentCreateIntent, i, bundle);
                    return;
                }
                IntentSenderRequest intentSenderRequest = (IntentSenderRequest) intentCreateIntent.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                try {
                    intentSenderRequest.getClass();
                    i2 = i;
                    try {
                        componentActivity.startIntentSenderForResult(intentSenderRequest.intentSender, i2, intentSenderRequest.fillInIntent, intentSenderRequest.flagsMask, intentSenderRequest.flagsValues, 0, bundle);
                    } catch (IntentSender.SendIntentException e) {
                        e = e;
                        new Handler(Looper.getMainLooper()).post(new ListenerSet$$ExternalSyntheticLambda1(this, i2, e, (byte) 2));
                    }
                } catch (IntentSender.SendIntentException e2) {
                    e = e2;
                    i2 = i;
                }
            }
        };
        this.onConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.onTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.onNewIntentListeners = new CopyOnWriteArrayList<>();
        this.onMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.onPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.onPictureInPictureUiStateChangedListeners = new CopyOnWriteArrayList<>();
        this.onUserLeaveHintListeners = new CopyOnWriteArrayList<>();
        this.onBackPressedInput$delegate = new SynchronizedLazyImpl(new ComponentActivity$$ExternalSyntheticLambda1(this, (byte) 2));
        if (getLifecycle() == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
            throw null;
        }
        final byte b = 0;
        getLifecycle().addObserver(new LifecycleEventObserver(this) { // from class: androidx.activity.ComponentActivity$$ExternalSyntheticLambda3
            public final /* synthetic */ ComponentActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                Window window;
                View viewPeekDecorView;
                byte b2 = b;
                ComponentActivity componentActivity = this.f$0;
                switch (b2) {
                    case 0:
                        if (event == Lifecycle.Event.ON_STOP && (window = componentActivity.getWindow()) != null && (viewPeekDecorView = window.peekDecorView()) != null) {
                            viewPeekDecorView.cancelPendingInputEvents();
                            break;
                        }
                        break;
                    default:
                        ComponentActivity._init_$lambda$2(componentActivity, lifecycleOwner, event);
                        break;
                }
            }
        });
        final byte b2 = 1;
        getLifecycle().addObserver(new LifecycleEventObserver(this) { // from class: androidx.activity.ComponentActivity$$ExternalSyntheticLambda3
            public final /* synthetic */ ComponentActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                Window window;
                View viewPeekDecorView;
                byte b3 = b2;
                ComponentActivity componentActivity = this.f$0;
                switch (b3) {
                    case 0:
                        if (event == Lifecycle.Event.ON_STOP && (window = componentActivity.getWindow()) != null && (viewPeekDecorView = window.peekDecorView()) != null) {
                            viewPeekDecorView.cancelPendingInputEvents();
                            break;
                        }
                        break;
                    default:
                        ComponentActivity._init_$lambda$2(componentActivity, lifecycleOwner, event);
                        break;
                }
            }
        });
        getLifecycle().addObserver(new Recreator(b2, this));
        savedStateRegistryImpl.performAttach();
        ViewModelKt.enableSavedStateHandles(this);
        getSavedStateRegistry().registerSavedStateProvider(ACTIVITY_RESULT_TAG, new ComponentActivity$$ExternalSyntheticLambda5((byte) 0, this));
        addOnContextAvailableListener(new OnContextAvailableListener() { // from class: androidx.activity.ComponentActivity$$ExternalSyntheticLambda6
            @Override // androidx.activity.contextaware.OnContextAvailableListener
            public final void onContextAvailable(ComponentActivity componentActivity) {
                ComponentActivity._init_$lambda$4(this.f$0, componentActivity);
            }
        });
        this.defaultViewModelProviderFactory$delegate = new SynchronizedLazyImpl(new ComponentActivity$$ExternalSyntheticLambda1(this, (byte) 3));
        this.onBackPressedDispatcher$delegate = new SynchronizedLazyImpl(new ComponentActivity$$ExternalSyntheticLambda1(this, (byte) 4));
    }

    public static final void _init_$lambda$2(ComponentActivity componentActivity, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            componentActivity.contextAwareHelper.context = null;
            if (!componentActivity.isChangingConfigurations()) {
                componentActivity.getViewModelStore().clear();
            }
            ReportFullyDrawnExecutorImpl reportFullyDrawnExecutorImpl = (ReportFullyDrawnExecutorImpl) componentActivity.reportFullyDrawnExecutor;
            ComponentActivity componentActivity2 = ComponentActivity.this;
            componentActivity2.getWindow().getDecorView().removeCallbacks(reportFullyDrawnExecutorImpl);
            componentActivity2.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(reportFullyDrawnExecutorImpl);
        }
    }

    public static final Bundle _init_$lambda$3(ComponentActivity componentActivity) {
        Bundle bundle = new Bundle();
        ActivityResultRegistry activityResultRegistry = componentActivity.activityResultRegistry;
        activityResultRegistry.getClass();
        LinkedHashMap linkedHashMap = activityResultRegistry.keyToRc;
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(linkedHashMap.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(linkedHashMap.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(activityResultRegistry.launchedKeys));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(activityResultRegistry.pendingResults));
        return bundle;
    }

    public static final void _init_$lambda$4(ComponentActivity componentActivity, Context context) {
        context.getClass();
        Bundle bundleConsumeRestoredStateForKey = componentActivity.getSavedStateRegistry().consumeRestoredStateForKey(ACTIVITY_RESULT_TAG);
        if (bundleConsumeRestoredStateForKey != null) {
            ActivityResultRegistry activityResultRegistry = componentActivity.activityResultRegistry;
            LinkedHashMap linkedHashMap = activityResultRegistry.keyToRc;
            LinkedHashMap linkedHashMap2 = activityResultRegistry.rcToKey;
            Bundle bundle = activityResultRegistry.pendingResults;
            ArrayList<Integer> integerArrayList = bundleConsumeRestoredStateForKey.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = bundleConsumeRestoredStateForKey.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList == null || integerArrayList == null) {
                return;
            }
            ArrayList<String> stringArrayList2 = bundleConsumeRestoredStateForKey.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
            if (stringArrayList2 != null) {
                activityResultRegistry.launchedKeys.addAll(stringArrayList2);
            }
            Bundle bundle2 = bundleConsumeRestoredStateForKey.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            int size = stringArrayList.size();
            for (int i = 0; i < size; i++) {
                String str = stringArrayList.get(i);
                if (linkedHashMap.containsKey(str)) {
                    Integer num = (Integer) linkedHashMap.remove(str);
                    if (!bundle.containsKey(str)) {
                        TypeIntrinsics.asMutableMap(linkedHashMap2).remove(num);
                    }
                }
                Integer num2 = integerArrayList.get(i);
                num2.getClass();
                int iIntValue = num2.intValue();
                String str2 = stringArrayList.get(i);
                str2.getClass();
                String str3 = str2;
                linkedHashMap2.put(Integer.valueOf(iIntValue), str3);
                activityResultRegistry.keyToRc.put(str3, Integer.valueOf(iIntValue));
            }
        }
    }

    public static final void access$ensureViewModelStore(ComponentActivity componentActivity) {
        if (componentActivity._viewModelStore == null) {
            NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) componentActivity.getLastNonConfigurationInstance();
            if (nonConfigurationInstances != null) {
                componentActivity._viewModelStore = nonConfigurationInstances.viewModelStore;
            }
            if (componentActivity._viewModelStore == null) {
                componentActivity._viewModelStore = new ViewModelStore();
            }
        }
    }

    public static final void addObserverForBackInvoker$lambda$0(OnBackPressedDispatcher onBackPressedDispatcher, ComponentActivity componentActivity, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_CREATE) {
            OnBackInvokedDispatcher onBackInvokedDispatcher = componentActivity.getOnBackInvokedDispatcher();
            onBackInvokedDispatcher.getClass();
            onBackPressedDispatcher.setOnBackInvokedDispatcher(onBackInvokedDispatcher);
        }
    }

    public static final FullyDrawnReporter fullyDrawnReporter_delegate$lambda$0(ComponentActivity componentActivity) {
        return new FullyDrawnReporter(componentActivity.reportFullyDrawnExecutor, new ComponentActivity$$ExternalSyntheticLambda1(componentActivity, (byte) 1));
    }

    public static final void onBackPressedDispatcher_delegate$lambda$0$0(ComponentActivity componentActivity) {
        try {
            super.onBackPressed();
        } catch (IllegalStateException e) {
            if (!Intrinsics.areEqual(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                throw e;
            }
        } catch (NullPointerException e2) {
            if (!Intrinsics.areEqual(e2.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                throw e2;
            }
        }
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        ReportFullyDrawnExecutor reportFullyDrawnExecutor = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        decorView.getClass();
        ((ReportFullyDrawnExecutorImpl) reportFullyDrawnExecutor).viewCreated(decorView);
        super.addContentView(view, layoutParams);
    }

    public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner) {
        menuProvider.getClass();
        lifecycleOwner.getClass();
        MenuHostHelper menuHostHelper = this.menuHostHelper;
        menuHostHelper.mMenuProviders.add(menuProvider);
        menuHostHelper.mOnInvalidateMenuCallback.run();
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        HashMap map = menuHostHelper.mProviderToLifecycleContainers;
        MenuHostHelper.LifecycleContainer lifecycleContainer = (MenuHostHelper.LifecycleContainer) map.remove(menuProvider);
        if (lifecycleContainer != null) {
            lifecycleContainer.mLifecycle.removeObserver(lifecycleContainer.mObserver);
            lifecycleContainer.mObserver = null;
        }
        map.put(menuProvider, new MenuHostHelper.LifecycleContainer(lifecycle, new MenuHostHelper$$ExternalSyntheticLambda1(menuHostHelper, menuProvider, (byte) 0)));
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void addOnConfigurationChangedListener(Consumer consumer) {
        consumer.getClass();
        this.onConfigurationChangedListeners.add(consumer);
    }

    public final void addOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        onContextAvailableListener.getClass();
        ContextAwareHelper contextAwareHelper = this.contextAwareHelper;
        contextAwareHelper.getClass();
        ComponentActivity componentActivity = contextAwareHelper.context;
        if (componentActivity != null) {
            onContextAvailableListener.onContextAvailable(componentActivity);
        }
        contextAwareHelper.listeners.add(onContextAvailableListener);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void addOnMultiWindowModeChangedListener(Consumer consumer) {
        consumer.getClass();
        this.onMultiWindowModeChangedListeners.add(consumer);
    }

    public final void addOnNewIntentListener(Consumer consumer) {
        consumer.getClass();
        this.onNewIntentListeners.add(consumer);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void addOnPictureInPictureModeChangedListener(Consumer consumer) {
        consumer.getClass();
        this.onPictureInPictureModeChangedListeners.add(consumer);
    }

    public final void addOnPictureInPictureUiStateChangedListener(Consumer consumer) {
        consumer.getClass();
        this.onPictureInPictureUiStateChangedListeners.add(consumer);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void addOnTrimMemoryListener(Consumer consumer) {
        consumer.getClass();
        this.onTrimMemoryListeners.add(consumer);
    }

    public final void addOnUserLeaveHintListener(Runnable runnable) {
        runnable.getClass();
        this.onUserLeaveHintListeners.add(runnable);
    }

    public final void enterPictureInPictureMode(PictureInPictureParamsCompat pictureInPictureParamsCompat) {
        throw null;
    }

    @Override // androidx.activity.result.ActivityResultRegistryOwner
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.activityResultRegistry;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(0);
        Application application = getApplication();
        LinkedHashMap linkedHashMap = mutableCreationExtras.extras;
        if (application != null) {
            linkedHashMap.put(ViewModelProvider$AndroidViewModelFactory.APPLICATION_KEY, getApplication());
        }
        linkedHashMap.put(ViewModelKt.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        linkedHashMap.put(ViewModelKt.VIEW_MODEL_STORE_OWNER_KEY, this);
        Intent intent = getIntent();
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras != null) {
            linkedHashMap.put(ViewModelKt.DEFAULT_ARGS_KEY, extras);
        }
        return mutableCreationExtras;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider$Factory getDefaultViewModelProviderFactory() {
        return (ViewModelProvider$Factory) this.defaultViewModelProviderFactory$delegate.getValue();
    }

    public FullyDrawnReporter getFullyDrawnReporter() {
        return (FullyDrawnReporter) this.fullyDrawnReporter$delegate.getValue();
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null) {
            return nonConfigurationInstances.custom;
        }
        return null;
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    @Override // androidx.navigationevent.NavigationEventDispatcherOwner
    public NavigationEventDispatcher getNavigationEventDispatcher() {
        return getOnBackPressedDispatcher().getEventInput().dispatcher;
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return (OnBackPressedDispatcher) this.onBackPressedDispatcher$delegate.getValue();
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistryController.savedStateRegistry;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (getApplication() == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
            return null;
        }
        ViewModelStore viewModelStore = this._viewModelStore;
        if (viewModelStore == null) {
            NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
            if (nonConfigurationInstances != null) {
                this._viewModelStore = nonConfigurationInstances.viewModelStore;
            }
            viewModelStore = this._viewModelStore;
            if (viewModelStore == null) {
                viewModelStore = new ViewModelStore();
                this._viewModelStore = viewModelStore;
            }
        }
        viewModelStore.getClass();
        return viewModelStore;
    }

    public void initializeViewTreeOwners() {
        View decorView = getWindow().getDecorView();
        decorView.getClass();
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        View decorView2 = getWindow().getDecorView();
        decorView2.getClass();
        decorView2.setTag(R.id.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        decorView3.getClass();
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
        View decorView4 = getWindow().getDecorView();
        decorView4.getClass();
        decorView4.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        View decorView5 = getWindow().getDecorView();
        decorView5.getClass();
        decorView5.setTag(R.id.report_drawn, this);
        View decorView6 = getWindow().getDecorView();
        decorView6.getClass();
        decorView6.setTag(R.id.view_tree_navigation_event_dispatcher_owner, this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.activityResultRegistry.dispatchResult(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    @Deprecated
    public void onBackPressed() {
        ((DirectNavigationEventInput) this.onBackPressedInput$delegate.getValue()).dispatchOnBackCompleted();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        configuration.getClass();
        super.onConfigurationChanged(configuration);
        Iterator<Consumer> it = this.onConfigurationChangedListeners.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.savedStateRegistryController.performRestore(bundle);
        ContextAwareHelper contextAwareHelper = this.contextAwareHelper;
        contextAwareHelper.getClass();
        contextAwareHelper.context = this;
        Iterator it = contextAwareHelper.listeners.iterator();
        while (it.hasNext()) {
            ((OnContextAvailableListener) it.next()).onContextAvailable(this);
        }
        super.onCreate(bundle);
        int i = ReportFragment.$r8$clinit;
        ReportFragment.Companion.injectIfNeededIn(this);
        int i2 = this.contentLayoutId;
        if (i2 != 0) {
            setContentView(i2);
        }
        this.hasPictureInPictureSystemFeature = getPackageManager().hasSystemFeature("android.software.picture_in_picture");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        menu.getClass();
        if (i != 0) {
            return true;
        }
        super.onCreatePanelMenu(i, menu);
        MenuHostHelper menuHostHelper = this.menuHostHelper;
        MenuInflater menuInflater = getMenuInflater();
        Iterator it = menuHostHelper.mMenuProviders.iterator();
        while (it.hasNext()) {
            FragmentManager.this.dispatchCreateOptionsMenu(menu, menuInflater);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        menuItem.getClass();
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.menuHostHelper.onMenuItemSelected(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        configuration.getClass();
        this.dispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z, configuration);
            this.dispatchingOnMultiWindowModeChanged = false;
            Iterator<Consumer> it = this.onMultiWindowModeChangedListeners.iterator();
            it.getClass();
            while (it.hasNext()) {
                it.next().accept(new MultiWindowModeChangedInfo(z));
            }
        } catch (Throwable th) {
            this.dispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        intent.getClass();
        super.onNewIntent(intent);
        Iterator<Consumer> it = this.onNewIntentListeners.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        menu.getClass();
        Iterator it = this.menuHostHelper.mMenuProviders.iterator();
        while (it.hasNext()) {
            FragmentManager.this.dispatchOptionsMenuClosed(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        configuration.getClass();
        this.dispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z, configuration);
            this.dispatchingOnPictureInPictureModeChanged = false;
            Iterator<Consumer> it = this.onPictureInPictureModeChangedListeners.iterator();
            it.getClass();
            while (it.hasNext()) {
                it.next().accept(new PictureInPictureModeChangedInfo(z));
            }
        } catch (Throwable th) {
            this.dispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureUiStateChanged(PictureInPictureUiState pictureInPictureUiState) {
        pictureInPictureUiState.getClass();
        super.onPictureInPictureUiStateChanged(pictureInPictureUiState);
        Lock lockFromPictureInPictureUiState = PictureInPictureUiStateCompat$Companion.fromPictureInPictureUiState(pictureInPictureUiState);
        Iterator<Consumer> it = this.onPictureInPictureUiStateChangedListeners.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().accept(lockFromPictureInPictureUiState);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        menu.getClass();
        if (i != 0) {
            return true;
        }
        super.onPreparePanel(i, view, menu);
        Iterator it = this.menuHostHelper.mMenuProviders.iterator();
        while (it.hasNext()) {
            FragmentManager.this.dispatchPrepareOptionsMenu(menu);
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        strArr.getClass();
        iArr.getClass();
        if (this.activityResultRegistry.dispatchResult(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        NonConfigurationInstances nonConfigurationInstances;
        Object objOnRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        ViewModelStore viewModelStore = this._viewModelStore;
        if (viewModelStore == null && (nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance()) != null) {
            viewModelStore = nonConfigurationInstances.viewModelStore;
        }
        if (viewModelStore == null && objOnRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        NonConfigurationInstances nonConfigurationInstances2 = new NonConfigurationInstances();
        nonConfigurationInstances2.custom = objOnRetainCustomNonConfigurationInstance;
        nonConfigurationInstances2.viewModelStore = viewModelStore;
        return nonConfigurationInstances2;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        if (getLifecycle() instanceof LifecycleRegistry) {
            Lifecycle lifecycle = getLifecycle();
            lifecycle.getClass();
            ((LifecycleRegistry) lifecycle).setCurrentState(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.savedStateRegistryController.performSave(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Iterator<Consumer> it = this.onTrimMemoryListeners.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i));
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        Iterator<Runnable> it = this.onUserLeaveHintListeners.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().run();
        }
    }

    public Context peekAvailableContext() {
        return this.contextAwareHelper.context;
    }

    public final <I, O> ActivityResultLauncher registerForActivityResult(ActivityResultContract activityResultContract, ActivityResultRegistry activityResultRegistry, ActivityResultCallback activityResultCallback) {
        activityResultContract.getClass();
        activityResultRegistry.getClass();
        activityResultCallback.getClass();
        return activityResultRegistry.register("activity_rq#" + this.nextLocalRequestCode.getAndIncrement(), this, activityResultContract, activityResultCallback);
    }

    @Override // androidx.core.view.MenuHost
    public void removeMenuProvider(MenuProvider menuProvider) {
        menuProvider.getClass();
        this.menuHostHelper.removeMenuProvider(menuProvider);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void removeOnConfigurationChangedListener(Consumer consumer) {
        consumer.getClass();
        this.onConfigurationChangedListeners.remove(consumer);
    }

    public final void removeOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        onContextAvailableListener.getClass();
        ContextAwareHelper contextAwareHelper = this.contextAwareHelper;
        contextAwareHelper.getClass();
        contextAwareHelper.listeners.remove(onContextAvailableListener);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void removeOnMultiWindowModeChangedListener(Consumer consumer) {
        consumer.getClass();
        this.onMultiWindowModeChangedListeners.remove(consumer);
    }

    public final void removeOnNewIntentListener(Consumer consumer) {
        consumer.getClass();
        this.onNewIntentListeners.remove(consumer);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void removeOnPictureInPictureModeChangedListener(Consumer consumer) {
        consumer.getClass();
        this.onPictureInPictureModeChangedListeners.remove(consumer);
    }

    public final void removeOnPictureInPictureUiStateChangedListener(Consumer consumer) {
        consumer.getClass();
        this.onPictureInPictureUiStateChangedListeners.remove(consumer);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void removeOnTrimMemoryListener(Consumer consumer) {
        consumer.getClass();
        this.onTrimMemoryListeners.remove(consumer);
    }

    public final void removeOnUserLeaveHintListener(Runnable runnable) {
        runnable.getClass();
        this.onUserLeaveHintListeners.remove(runnable);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (DatabaseDao_Impl.AnonymousClass17.isEnabled()) {
                Trace.beginSection(DatabaseDao_Impl.AnonymousClass17.truncatedTraceSectionLabel("reportFullyDrawn() for ComponentActivity"));
            }
            super.reportFullyDrawn();
            FullyDrawnReporter fullyDrawnReporter = getFullyDrawnReporter();
            synchronized (fullyDrawnReporter.lock) {
                try {
                    fullyDrawnReporter.reportedFullyDrawn = true;
                    ArrayList arrayList = fullyDrawnReporter.onReportCallbacks;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((Function0) obj).invoke();
                    }
                    fullyDrawnReporter.onReportCallbacks.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            Trace.endSection();
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        initializeViewTreeOwners();
        ReportFullyDrawnExecutor reportFullyDrawnExecutor = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        decorView.getClass();
        ((ReportFullyDrawnExecutorImpl) reportFullyDrawnExecutor).viewCreated(decorView);
        super.setContentView(i);
    }

    public final void setPictureInPictureParams(PictureInPictureParamsCompat pictureInPictureParamsCompat) {
        throw null;
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i) {
        intent.getClass();
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        intentSender.getClass();
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        intent.getClass();
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        intentSender.getClass();
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        initializeViewTreeOwners();
        ReportFullyDrawnExecutor reportFullyDrawnExecutor = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        decorView.getClass();
        ((ReportFullyDrawnExecutorImpl) reportFullyDrawnExecutor).viewCreated(decorView);
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        ReportFullyDrawnExecutor reportFullyDrawnExecutor = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        decorView.getClass();
        ((ReportFullyDrawnExecutorImpl) reportFullyDrawnExecutor).viewCreated(decorView);
        super.setContentView(view, layoutParams);
    }

    public final <I, O> ActivityResultLauncher registerForActivityResult(ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback) {
        activityResultContract.getClass();
        activityResultCallback.getClass();
        return registerForActivityResult(activityResultContract, this.activityResultRegistry, activityResultCallback);
    }

    @Override // android.app.Activity
    @Deprecated
    public void onMultiWindowModeChanged(boolean z) {
        if (this.dispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator<Consumer> it = this.onMultiWindowModeChangedListeners.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().accept(new MultiWindowModeChangedInfo(z));
        }
    }

    @Override // android.app.Activity
    @Deprecated
    public void onPictureInPictureModeChanged(boolean z) {
        if (this.dispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator<Consumer> it = this.onPictureInPictureModeChangedListeners.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().accept(new PictureInPictureModeChangedInfo(z));
        }
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(MenuProvider menuProvider) {
        menuProvider.getClass();
        MenuHostHelper menuHostHelper = this.menuHostHelper;
        menuHostHelper.mMenuProviders.add(menuProvider);
        menuHostHelper.mOnInvalidateMenuCallback.run();
    }

    public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.State state) {
        menuProvider.getClass();
        lifecycleOwner.getClass();
        state.getClass();
        MenuHostHelper menuHostHelper = this.menuHostHelper;
        menuHostHelper.getClass();
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        HashMap map = menuHostHelper.mProviderToLifecycleContainers;
        MenuHostHelper.LifecycleContainer lifecycleContainer = (MenuHostHelper.LifecycleContainer) map.remove(menuProvider);
        if (lifecycleContainer != null) {
            lifecycleContainer.mLifecycle.removeObserver(lifecycleContainer.mObserver);
            lifecycleContainer.mObserver = null;
        }
        map.put(menuProvider, new MenuHostHelper.LifecycleContainer(lifecycle, new MenuHostHelper$$ExternalSyntheticLambda0(menuHostHelper, state, menuProvider, (byte) 0)));
    }
}
