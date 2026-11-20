package androidx.compose.ui.platform;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.HostDefaultProviderKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.composer.gapbuffer.SlotTable;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.res.ImageVectorCache;
import androidx.compose.ui.res.ResourceIdCache;
import androidx.compose.ui.text.font.Font$ResourceLoader;
import androidx.core.provider.CallbackWrapper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.compose.LocalSavedStateRegistryOwnerKt;
import coil3.size.SizeKt;
import coil3.util.UtilsKt;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda1;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda9;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.R;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableSet;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ComposeViewContext {
    public CompositionContext _compositionContext;
    public List _enabledServices;
    public boolean _isAccessibilityEnabled;
    public boolean _isTouchExplorationEnabled;
    public LifecycleOwner _lifecycleOwner;
    public SavedStateRegistryOwner _savedStateRegistryOwner;
    public AndroidSoundEffect _soundEffect;
    public AndroidUriHandler _uriHandler;
    public ViewModelStoreOwner _viewModelStoreOwner;
    public final AndroidAccessibilityManager accessibilityManager;
    public boolean areValuesResolved;
    public final RoomDatabase$$ExternalSyntheticLambda0 calculateWindowSizeLambda;
    public final ComposeViewContextCallback callback;
    public final CanvasHolder canvasHolder;
    public final Clipboard clipboard;
    public final CallbackWrapper clipboardManager;
    public final MutableState configuration;
    public final Configuration currentConfiguration;
    public final MutableState fontFamilyResolver;
    public final Font$ResourceLoader fontLoader;
    public Handler handler;
    public final HapticFeedback hapticFeedback;
    public boolean hasAccessibilityListener;
    public final ImageVectorCache imageVectorCache;
    public boolean pendingWindowInfoUpdate;
    public final ResourceIdCache resourceIdCache;
    public final LayoutNodeDrawScope sharedDrawScope;
    public final View view;
    public final AndroidViewConfiguration viewConfiguration;
    public int viewCount;
    public final LazyWindowInfo windowInfo;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ComposeViewContextCallback implements Runnable, ComponentCallbacks2, ViewTreeObserver.OnWindowFocusChangeListener, ViewTreeObserver.OnGlobalLayoutListener, android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener, android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener {
        public ComposeViewContextCallback() {
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public final void onAccessibilityStateChanged(boolean z) {
            ComposeViewContext composeViewContext = ComposeViewContext.this;
            composeViewContext._isAccessibilityEnabled = z;
            if (z) {
                composeViewContext._enabledServices = null;
            }
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration configuration) {
            ComposeViewContext.this.onConfigurationChanged$ui(configuration);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            ComposeViewContext composeViewContext = ComposeViewContext.this;
            if (composeViewContext.pendingWindowInfoUpdate) {
                composeViewContext.pendingWindowInfoUpdate = false;
                LazyWindowInfo lazyWindowInfo = composeViewContext.windowInfo;
                RoomDatabase$$ExternalSyntheticLambda0 roomDatabase$$ExternalSyntheticLambda0 = composeViewContext.calculateWindowSizeLambda;
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = lazyWindowInfo._containerSize;
                if (parcelableSnapshotMutableState != null) {
                    parcelableSnapshotMutableState.setValue(roomDatabase$$ExternalSyntheticLambda0.invoke());
                }
            }
        }

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
            ComposeViewContext composeViewContext = ComposeViewContext.this;
            composeViewContext.imageVectorCache.map.clear();
            ResourceIdCache resourceIdCache = composeViewContext.resourceIdCache;
            synchronized (resourceIdCache) {
                resourceIdCache.resIdPathMap.clear();
            }
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public final void onTouchExplorationStateChanged(boolean z) {
            ComposeViewContext composeViewContext = ComposeViewContext.this;
            composeViewContext._isTouchExplorationEnabled = z;
            if (z && composeViewContext._isAccessibilityEnabled) {
                composeViewContext._enabledServices = null;
            }
        }

        @Override // android.content.ComponentCallbacks2
        public final void onTrimMemory(int i) {
            ComposeViewContext composeViewContext = ComposeViewContext.this;
            composeViewContext.imageVectorCache.map.clear();
            ResourceIdCache resourceIdCache = composeViewContext.resourceIdCache;
            synchronized (resourceIdCache) {
                resourceIdCache.resIdPathMap.clear();
            }
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public final void onWindowFocusChanged(boolean z) {
            ComposeViewContext.this.windowInfo.isWindowFocused$delegate.setValue(Boolean.valueOf(z));
        }

        @Override // java.lang.Runnable
        public final void run() {
            ComposeViewContext composeViewContext = ComposeViewContext.this;
            android.view.accessibility.AccessibilityManager accessibilityManager = composeViewContext.accessibilityManager.accessibilityManager;
            boolean z = false;
            if (composeViewContext.viewCount <= 0) {
                composeViewContext.hasAccessibilityListener = false;
                accessibilityManager.removeAccessibilityStateChangeListener(this);
                accessibilityManager.removeTouchExplorationStateChangeListener(this);
                return;
            }
            composeViewContext.hasAccessibilityListener = true;
            boolean zIsEnabled = accessibilityManager.isEnabled();
            composeViewContext._isAccessibilityEnabled = zIsEnabled;
            if (zIsEnabled && accessibilityManager.isTouchExplorationEnabled()) {
                z = true;
            }
            composeViewContext._isTouchExplorationEnabled = z;
            if (composeViewContext._isAccessibilityEnabled) {
                composeViewContext._enabledServices = null;
            }
            accessibilityManager.addAccessibilityStateChangeListener(this);
            accessibilityManager.addTouchExplorationStateChangeListener(this);
        }
    }

    public ComposeViewContext(ComposeViewContext composeViewContext, View view, CompositionContext compositionContext, LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner, ViewModelStoreOwner viewModelStoreOwner) {
        ImageVectorCache imageVectorCache;
        Configuration configuration;
        MutableState mutableStateMutableStateOf$default;
        AndroidAccessibilityManager androidAccessibilityManager;
        AndroidUriHandler androidUriHandler;
        CallbackWrapper callbackWrapper;
        Clipboard androidClipboardImpl;
        Font$ResourceLoader androidFontResourceLoader;
        MutableState parcelableSnapshotMutableState;
        AndroidViewConfiguration androidViewConfiguration;
        boolean zAreEqual = Intrinsics.areEqual(composeViewContext != null ? composeViewContext.view.getContext() : null, view.getContext());
        this.view = view;
        this._compositionContext = compositionContext;
        this._lifecycleOwner = lifecycleOwner;
        this._savedStateRegistryOwner = savedStateRegistryOwner;
        this._viewModelStoreOwner = viewModelStoreOwner;
        if (zAreEqual) {
            composeViewContext.getClass();
            imageVectorCache = composeViewContext.imageVectorCache;
        } else {
            imageVectorCache = new ImageVectorCache();
        }
        this.imageVectorCache = imageVectorCache;
        this.resourceIdCache = composeViewContext != null ? composeViewContext.resourceIdCache : new ResourceIdCache();
        if (zAreEqual) {
            composeViewContext.getClass();
            configuration = composeViewContext.currentConfiguration;
        } else {
            configuration = new Configuration(view.getContext().getResources().getConfiguration());
        }
        this.currentConfiguration = configuration;
        if (zAreEqual) {
            composeViewContext.getClass();
            mutableStateMutableStateOf$default = composeViewContext.configuration;
        } else {
            mutableStateMutableStateOf$default = Stack.mutableStateOf$default(new Configuration(configuration));
        }
        this.configuration = mutableStateMutableStateOf$default;
        if (zAreEqual) {
            composeViewContext.getClass();
            androidAccessibilityManager = composeViewContext.accessibilityManager;
        } else {
            androidAccessibilityManager = new AndroidAccessibilityManager(view.getContext());
        }
        this.accessibilityManager = androidAccessibilityManager;
        if (zAreEqual) {
            composeViewContext.getClass();
            androidUriHandler = composeViewContext._uriHandler;
            if (androidUriHandler == null) {
                androidUriHandler = new AndroidUriHandler(composeViewContext.view.getContext());
                composeViewContext._uriHandler = androidUriHandler;
            }
        } else {
            androidUriHandler = null;
        }
        this._uriHandler = androidUriHandler;
        if (zAreEqual) {
            composeViewContext.getClass();
            callbackWrapper = composeViewContext.clipboardManager;
        } else {
            callbackWrapper = new CallbackWrapper((byte) 11, (Object) view.getContext());
        }
        this.clipboardManager = callbackWrapper;
        if (zAreEqual) {
            composeViewContext.getClass();
            androidClipboardImpl = composeViewContext.clipboard;
        } else {
            androidClipboardImpl = new AndroidClipboardImpl(callbackWrapper);
        }
        this.clipboard = androidClipboardImpl;
        if (zAreEqual) {
            composeViewContext.getClass();
            androidFontResourceLoader = composeViewContext.fontLoader;
        } else {
            view.getContext();
            androidFontResourceLoader = new AndroidFontResourceLoader();
        }
        this.fontLoader = androidFontResourceLoader;
        if (zAreEqual) {
            composeViewContext.getClass();
            parcelableSnapshotMutableState = composeViewContext.fontFamilyResolver;
        } else {
            parcelableSnapshotMutableState = new ParcelableSnapshotMutableState(SizeKt.createFontFamilyResolver(view.getContext()), NeverEqualPolicy.INSTANCE$1);
        }
        this.fontFamilyResolver = parcelableSnapshotMutableState;
        this.hapticFeedback = view == (composeViewContext != null ? composeViewContext.view : null) ? composeViewContext.hapticFeedback : new PlatformHapticFeedback(view);
        if (zAreEqual) {
            composeViewContext.getClass();
            androidViewConfiguration = composeViewContext.viewConfiguration;
        } else {
            androidViewConfiguration = new AndroidViewConfiguration(android.view.ViewConfiguration.get(view.getContext()));
        }
        this.viewConfiguration = androidViewConfiguration;
        this.sharedDrawScope = composeViewContext != null ? composeViewContext.sharedDrawScope : new LayoutNodeDrawScope();
        this.windowInfo = new LazyWindowInfo();
        this.canvasHolder = composeViewContext != null ? composeViewContext.canvasHolder : new CanvasHolder();
        this.calculateWindowSizeLambda = new RoomDatabase$$ExternalSyntheticLambda0((byte) 15, this);
        this.callback = new ComposeViewContextCallback();
    }

    public final void ProvideCompositionLocals$ui(AndroidComposeView androidComposeView, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(123858079);
        int i2 = i | (gapComposer.changedInstance(androidComposeView) ? 4 : 2) | (gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16) | (gapComposer.changedInstance(this) ? 256 : 128);
        byte b = 1;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            Object tag = androidComposeView.getTag(R.id.inspection_slot_table_set);
            Set set = null;
            Set set2 = (!(tag instanceof Set) || ((tag instanceof KMappedMarker) && !(tag instanceof KMutableSet))) ? null : (Set) tag;
            if (set2 == null) {
                Object parent = androidComposeView.getParent();
                View view = parent instanceof View ? (View) parent : null;
                Object tag2 = view != null ? view.getTag(R.id.inspection_slot_table_set) : null;
                if ((tag2 instanceof Set) && (!(tag2 instanceof KMappedMarker) || (tag2 instanceof KMutableSet))) {
                    set = (Set) tag2;
                }
            } else {
                set = set2;
            }
            if (set != null) {
                set.add(gapComposer.getCompositionData());
                gapComposer.forceRecomposeScopes = true;
                gapComposer.sourceMarkersEnabled = true;
                gapComposer.slotTable.collectSourceInformation();
                gapComposer.insertTable.collectSourceInformation();
                SlotWriter slotWriter = gapComposer.writer;
                SlotTable slotTable = slotWriter.table;
                slotWriter.sourceInformationMap = slotTable.sourceInformationMap;
                slotWriter.calledByMap = slotTable.calledByMap;
            }
            gapComposer.startReplaceGroup(480629184);
            ProvidedValue providedValueDefaultProvidedValue$runtime = LocalLifecycleOwnerKt.LocalLifecycleOwner.defaultProvidedValue$runtime(getLifecycleOwner$ui());
            ProvidableCompositionLocal providableCompositionLocal = LocalSavedStateRegistryOwnerKt.LocalSavedStateRegistryOwner;
            resolveValuesIfNeeded();
            SavedStateRegistryOwner savedStateRegistryOwner = this._savedStateRegistryOwner;
            savedStateRegistryOwner.getClass();
            ProvidedValue providedValueDefaultProvidedValue$runtime2 = providableCompositionLocal.defaultProvidedValue$runtime(savedStateRegistryOwner);
            ProvidedValue providedValueDefaultProvidedValue$runtime3 = AndroidCompositionLocals_androidKt.LocalImageVectorCache.defaultProvidedValue$runtime(this.imageVectorCache);
            ProvidedValue providedValueDefaultProvidedValue$runtime4 = AndroidCompositionLocals_androidKt.LocalResourceIdCache.defaultProvidedValue$runtime(this.resourceIdCache);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = CompositionLocalsKt.LocalSoundEffect;
            boolean zChangedInstance = gapComposer.changedInstance(this);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new TextKt$$ExternalSyntheticLambda2((byte) 29, this);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            ProvidedValue providedValueProvidesComputed = staticProvidableCompositionLocal.providesComputed((Function1) objRememberedValue);
            ProvidedValue providedValueDefaultProvidedValue$runtime5 = AndroidCompositionLocals_androidKt.LocalContext.defaultProvidedValue$runtime(androidComposeView.getContext());
            ProvidedValue providedValueDefaultProvidedValue$runtime6 = InspectionTablesKt.LocalInspectionTables.defaultProvidedValue$runtime(set);
            ProvidedValue providedValueDefaultProvidedValue$runtime7 = AndroidCompositionLocals_androidKt.LocalConfiguration.defaultProvidedValue$runtime(androidComposeView.getConfiguration());
            StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = SaveableStateRegistryKt.LocalSaveableStateRegistry;
            boolean zChangedInstance2 = gapComposer.changedInstance(androidComposeView);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new AndroidComposeView$$ExternalSyntheticLambda0(androidComposeView, (byte) 3);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            ProvidedValue providedValueProvidesComputed2 = staticProvidableCompositionLocal2.providesComputed((Function1) objRememberedValue2);
            ProvidedValue providedValueDefaultProvidedValue$runtime8 = AndroidCompositionLocals_androidKt.LocalView.defaultProvidedValue$runtime(androidComposeView.getView());
            StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = CompositionLocalsKt.LocalProvidableScrollCaptureInProgress;
            boolean zChangedInstance3 = gapComposer.changedInstance(androidComposeView);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new AndroidComposeView$$ExternalSyntheticLambda0(androidComposeView, (byte) 4);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            Stack.CompositionLocalProvider(new ProvidedValue[]{providedValueDefaultProvidedValue$runtime, providedValueDefaultProvidedValue$runtime2, providedValueDefaultProvidedValue$runtime3, providedValueDefaultProvidedValue$runtime4, providedValueProvidesComputed, providedValueDefaultProvidedValue$runtime5, providedValueDefaultProvidedValue$runtime6, providedValueDefaultProvidedValue$runtime7, providedValueProvidesComputed2, providedValueDefaultProvidedValue$runtime8, staticProvidableCompositionLocal3.providesComputed((Function1) objRememberedValue3), CompositionLocalsKt.LocalViewConfiguration.defaultProvidedValue$runtime(androidComposeView.getViewConfiguration()), HostDefaultProviderKt.LocalHostDefaultProvider.defaultProvidedValue$runtime(androidComposeView.getHostDefaultProvider())}, Expect_jvmKt.rememberComposableLambda(1509086010, new MainActivity$$ExternalSyntheticLambda1(androidComposeView, composableLambdaImpl, b), gapComposer), gapComposer, 56);
            gapComposer.end(false);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda9((byte) 11, i, this, androidComposeView, composableLambdaImpl);
        }
    }

    public final void decrementViewCount$ui() {
        int i = this.viewCount - 1;
        this.viewCount = i;
        if (i < 0) {
            Log.e("ComposeViewContext", "View count has dropped below 0");
            this.viewCount = 0;
            i = 0;
        }
        if (i == 0) {
            View view = this.view;
            Context context = view.getContext();
            ComposeViewContextCallback composeViewContextCallback = this.callback;
            context.unregisterComponentCallbacks(composeViewContextCallback);
            LazyWindowInfo lazyWindowInfo = this.windowInfo;
            if (lazyWindowInfo._containerSize == null) {
                lazyWindowInfo.onInitializeContainerSize = null;
            }
            view.getViewTreeObserver().removeOnWindowFocusChangeListener(composeViewContextCallback);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(composeViewContextCallback);
            this.pendingWindowInfoUpdate = false;
            boolean z = this.hasAccessibilityListener;
            Handler handler = this.handler;
            if (z) {
                if (handler != null) {
                    handler.post(composeViewContextCallback);
                }
            } else if (handler != null) {
                handler.removeCallbacks(composeViewContextCallback);
            }
            this.handler = null;
        }
    }

    public final CompositionContext getCompositionContext$ui() {
        resolveValuesIfNeeded();
        CompositionContext compositionContext = this._compositionContext;
        compositionContext.getClass();
        return compositionContext;
    }

    public final LifecycleOwner getLifecycleOwner$ui() {
        resolveValuesIfNeeded();
        LifecycleOwner lifecycleOwner = this._lifecycleOwner;
        lifecycleOwner.getClass();
        return lifecycleOwner;
    }

    public final void incrementViewCount$ui() {
        int i = this.viewCount + 1;
        this.viewCount = i;
        if (i == 1) {
            View view = this.view;
            Context context = view.getContext();
            ComposeViewContextCallback composeViewContextCallback = this.callback;
            context.registerComponentCallbacks(composeViewContextCallback);
            onConfigurationChanged$ui(view.getResources().getConfiguration());
            boolean zHasWindowFocus = view.hasWindowFocus();
            LazyWindowInfo lazyWindowInfo = this.windowInfo;
            lazyWindowInfo.isWindowFocused$delegate.setValue(Boolean.valueOf(zHasWindowFocus));
            ParcelableSnapshotMutableState parcelableSnapshotMutableState = lazyWindowInfo._containerSize;
            RoomDatabase$$ExternalSyntheticLambda0 roomDatabase$$ExternalSyntheticLambda0 = this.calculateWindowSizeLambda;
            if (parcelableSnapshotMutableState == null) {
                lazyWindowInfo.onInitializeContainerSize = roomDatabase$$ExternalSyntheticLambda0;
            }
            if (parcelableSnapshotMutableState != null) {
                parcelableSnapshotMutableState.setValue(roomDatabase$$ExternalSyntheticLambda0.invoke());
            }
            view.getViewTreeObserver().addOnWindowFocusChangeListener(composeViewContextCallback);
            view.getViewTreeObserver().addOnGlobalLayoutListener(composeViewContextCallback);
            this.pendingWindowInfoUpdate = false;
            android.view.accessibility.AccessibilityManager accessibilityManager = this.accessibilityManager.accessibilityManager;
            boolean zIsEnabled = accessibilityManager.isEnabled();
            this._isAccessibilityEnabled = zIsEnabled;
            this._isTouchExplorationEnabled = zIsEnabled && accessibilityManager.isTouchExplorationEnabled();
            Handler handler = view.getHandler();
            this.handler = handler;
            if (handler != null) {
                handler.post(composeViewContextCallback);
            }
        }
    }

    public final void onConfigurationChanged$ui(Configuration configuration) {
        int iUpdateFrom = this.currentConfiguration.updateFrom(configuration);
        if (iUpdateFrom != 0) {
            Iterator it = this.imageVectorCache.map.entrySet().iterator();
            while (it.hasNext()) {
                ImageVectorCache.ImageVectorEntry imageVectorEntry = (ImageVectorCache.ImageVectorEntry) ((WeakReference) ((Map.Entry) it.next()).getValue()).get();
                if (imageVectorEntry == null || Configuration.needNewResources(iUpdateFrom, imageVectorEntry.configFlags)) {
                    it.remove();
                }
            }
            this.configuration.setValue(new Configuration(configuration));
            ResourceIdCache resourceIdCache = this.resourceIdCache;
            synchronized (resourceIdCache) {
                resourceIdCache.resIdPathMap.clear();
            }
            if ((268435456 & iUpdateFrom) != 0) {
                this.fontFamilyResolver.setValue(SizeKt.createFontFamilyResolver(this.view.getContext()));
            }
            if ((805248384 & iUpdateFrom) != 0) {
                if (Build.VERSION.SDK_INT < 33) {
                    this.pendingWindowInfoUpdate = true;
                    return;
                }
                LazyWindowInfo lazyWindowInfo = this.windowInfo;
                RoomDatabase$$ExternalSyntheticLambda0 roomDatabase$$ExternalSyntheticLambda0 = this.calculateWindowSizeLambda;
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = lazyWindowInfo._containerSize;
                if (parcelableSnapshotMutableState != null) {
                    parcelableSnapshotMutableState.setValue(roomDatabase$$ExternalSyntheticLambda0.invoke());
                }
            }
        }
    }

    public final void resolveValuesIfNeeded() {
        if (this.areValuesResolved) {
            return;
        }
        this.areValuesResolved = true;
        CompositionContext compositionContext = this._compositionContext;
        View view = this.view;
        if (compositionContext == null) {
            CompositionContext compositionContext2 = WindowRecomposer_androidKt.getCompositionContext(view);
            if (compositionContext2 == null) {
                Object parent = view.getParent();
                while (compositionContext2 == null && (parent instanceof View)) {
                    View view2 = (View) parent;
                    compositionContext2 = WindowRecomposer_androidKt.getCompositionContext(view2);
                    parent = DatabaseDao_Impl.AnonymousClass17.getParentOrViewTreeDisjointParent(view2);
                }
            }
            if (compositionContext2 == null) {
                compositionContext2 = WindowRecomposer_androidKt.getWindowRecomposer(view);
            }
            this._compositionContext = compositionContext2;
        }
        if (this._lifecycleOwner == null) {
            LifecycleOwner lifecycleOwner = ViewModelKt.get(view);
            if (lifecycleOwner == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Composed into a View which doesn't propagate ViewTreeLifecycleOwner!");
                return;
            }
            this._lifecycleOwner = lifecycleOwner;
        }
        if (this._savedStateRegistryOwner == null) {
            SavedStateRegistryOwner savedStateRegistryOwner = UtilsKt.get(view);
            if (savedStateRegistryOwner == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Composed into a View which doesn't propagate ViewTreeSavedStateRegistryOwner!");
                return;
            }
            this._savedStateRegistryOwner = savedStateRegistryOwner;
        }
        if (this._viewModelStoreOwner == null) {
            this._viewModelStoreOwner = ViewModelKt.m835get(view);
        }
    }
}
