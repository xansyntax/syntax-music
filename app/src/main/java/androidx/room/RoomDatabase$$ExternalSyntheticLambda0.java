package androidx.room;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.inputmethodservice.InputMethodService;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.ripple.AndroidRippleNode;
import androidx.compose.runtime.CompositionImpl;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.retain.ManagedRetainedValuesStore;
import androidx.compose.runtime.retain.impl.PreconditionsKt;
import androidx.compose.runtime.saveable.SaveableHolder;
import androidx.compose.runtime.saveable.SaveableStateRegistryWrapper;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollNode;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.LookaheadPassDelegate;
import androidx.compose.ui.platform.AndroidPlatformTextInputSession;
import androidx.compose.ui.platform.ComposeViewContext;
import androidx.compose.ui.platform.DerivedSize;
import androidx.compose.ui.platform.LifecycleRetainedValuesStoreOwner;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.unit.DensityWithConverter;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.window.PopupLayout;
import androidx.emoji2.text.EmojiProcessor;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.internal.NavBackStackEntryImpl;
import androidx.room.concurrent.FileLock;
import androidx.room.coroutines.PassthroughConnectionPool;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import androidx.window.layout.WindowMetrics;
import androidx.window.layout.WindowMetricsCalculator;
import androidx.window.layout.WindowMetricsCalculatorCompat;
import androidx.window.layout.util.BoundsHelperApi24Impl;
import androidx.window.layout.util.BoundsHelperApi30Impl;
import androidx.window.layout.util.DensityCompatHelperApi34Impl;
import androidx.window.layout.util.WindowMetricsCompatHelper;
import coil3.size.SizeKt;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.db.InternalDatabase_Impl;
import com.metrolist.music.db.MusicDatabase$$ExternalSyntheticLambda0;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlinx.coroutines.AwaitKt;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RoomDatabase$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ RoomDatabase$$ExternalSyntheticLambda0(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    /* JADX WARN: Code duplicated, block: B:171:0x038c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:172:0x038e A[Catch: all -> 0x03a4, LOOP:5: B:162:0x035d->B:172:0x038e, LOOP_END, TryCatch #0 {all -> 0x03a4, blocks: (B:159:0x0349, B:162:0x035d, B:164:0x036b, B:166:0x0375, B:168:0x037b, B:169:0x0384, B:172:0x038e, B:173:0x0396), top: B:217:0x0349 }] */
    /* JADX WARN: Code duplicated, block: B:238:0x0396 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:86:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:87:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:89:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:90:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:92:0x0209  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        char c;
        boolean z;
        CompositionImpl compositionImpl;
        long j;
        DerivedSize derivedSize;
        int i;
        WindowMetricsCompatHelper windowMetricsCompatHelper;
        long j2 = -9187201950435737472L;
        char c2 = 7;
        boolean z2 = true;
        byte b = 0;
        Context context = null;
        switch (this.$r8$classId) {
            case 0:
                ((MusicDatabase$$ExternalSyntheticLambda0) this.f$0).run();
                return Unit.INSTANCE;
            case 1:
                return Float.valueOf(((FloatProducer) this.f$0).invoke() < 1.0f ? 0.3f : 1.0f);
            case 2:
                HitTestResultKt.invalidateDraw((AndroidRippleNode) this.f$0);
                return Unit.INSTANCE;
            case 3:
                SaveableHolder saveableHolder = (SaveableHolder) this.f$0;
                Saver saver = saveableHolder.saver;
                Object obj = saveableHolder.value;
                if (obj != null) {
                    return saver.save(saveableHolder, obj);
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Value should be initialized");
                return null;
            case 4:
                SavedStateRegistryController savedStateRegistryController = ((SaveableStateRegistryWrapper) this.f$0)._controller;
                if (savedStateRegistryController == null) {
                    return null;
                }
                Bundle bundleBundleOf = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                savedStateRegistryController.performSave(bundleBundleOf);
                if (bundleBundleOf.isEmpty()) {
                    return null;
                }
                return bundleBundleOf;
            case 5:
                long j3 = 128;
                SnapshotStateObserver snapshotStateObserver = (SnapshotStateObserver) this.f$0;
                while (true) {
                    synchronized (snapshotStateObserver.observedScopeMapsLock) {
                        try {
                            if (snapshotStateObserver.sendingNotifications) {
                                c = c2;
                            } else {
                                snapshotStateObserver.sendingNotifications = z2;
                                try {
                                    MutableVector mutableVector = snapshotStateObserver.observedScopeMaps;
                                    Object[] objArr = mutableVector.content;
                                    int i2 = mutableVector.size;
                                    int i3 = b;
                                    while (i3 < i2) {
                                        try {
                                            SnapshotStateObserver.ObservedScopeMap observedScopeMap = (SnapshotStateObserver.ObservedScopeMap) objArr[i3];
                                            MutableScatterSet mutableScatterSet = observedScopeMap.invalidated;
                                            Function1 function1 = observedScopeMap.onChanged;
                                            Object[] objArr2 = mutableScatterSet.elements;
                                            long[] jArr = mutableScatterSet.metadata;
                                            int length = jArr.length - 2;
                                            char c3 = c2;
                                            if (length >= 0) {
                                                int i4 = b;
                                                while (true) {
                                                    long j4 = jArr[i4];
                                                    long[] jArr2 = jArr;
                                                    if ((((~j4) << c3) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                        int i5 = 8 - ((~(i4 - length)) >>> 31);
                                                        int i6 = 0;
                                                        while (i6 < i5) {
                                                            if ((j4 & 255) < j3) {
                                                                function1.invoke(objArr2[(i4 << 3) + i6]);
                                                            }
                                                            j4 >>= 8;
                                                            i6++;
                                                            j3 = 128;
                                                        }
                                                        if (i5 == 8) {
                                                            if (i4 != length) {
                                                                i4++;
                                                                jArr = jArr2;
                                                                j3 = 128;
                                                            }
                                                        }
                                                    } else if (i4 != length) {
                                                        i4++;
                                                        jArr = jArr2;
                                                        j3 = 128;
                                                    }
                                                }
                                            }
                                            mutableScatterSet.clear();
                                            i3++;
                                            c2 = c3;
                                            b = 0;
                                            j3 = 128;
                                        } catch (Throwable th) {
                                            th = th;
                                            z = 0;
                                            snapshotStateObserver.sendingNotifications = z;
                                            throw th;
                                        }
                                    }
                                    c = c2;
                                    snapshotStateObserver.sendingNotifications = b;
                                } catch (Throwable th2) {
                                    th = th2;
                                    z = b;
                                }
                            }
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                    if (!snapshotStateObserver.drainChanges()) {
                        return Unit.INSTANCE;
                    }
                    c2 = c;
                    z2 = true;
                    b = 0;
                    j3 = 128;
                }
                break;
            case 6:
                ((FocusTargetNode) this.f$0).fetchFocusProperties$ui();
                return Unit.INSTANCE;
            case 7:
                VectorPainter vectorPainter = (VectorPainter) this.f$0;
                Unit unit = Unit.INSTANCE;
                vectorPainter.drawInvalidation$delegate.setValue(unit);
                return unit;
            case 8:
                return ((NestedScrollDispatcher) this.f$0).scope;
            case 9:
                return ((NestedScrollNode) this.f$0).getNestedCoroutineScope();
            case 10:
                LayoutNodeSubcompositionsState.NodeState nodeState = (LayoutNodeSubcompositionsState.NodeState) this.f$0;
                if (!((Boolean) nodeState.activeState.getValue()).booleanValue() && (compositionImpl = nodeState.composition) != null) {
                    compositionImpl.deactivate();
                }
                return Unit.INSTANCE;
            case 11:
                LayoutNodeSubcompositionsState state = ((SubcomposeLayoutState) this.f$0).getState();
                LayoutNode layoutNode = state.root;
                if (state.reusableCount != ((MutableVector) ((MutableObjectList.ObjectListMutableList) layoutNode.getFoldedChildren$ui()).objectList).size) {
                    MutableScatterMap mutableScatterMap = state.nodeToNodeState;
                    Object[] objArr3 = mutableScatterMap.values;
                    long[] jArr3 = mutableScatterMap.metadata;
                    int length2 = jArr3.length - 2;
                    if (length2 >= 0) {
                        int i7 = 0;
                        while (true) {
                            long j5 = jArr3[i7];
                            if ((((~j5) << 7) & j5 & j2) != j2) {
                                int i8 = 8 - ((~(i7 - length2)) >>> 31);
                                int i9 = 0;
                                while (i9 < i8) {
                                    if ((j5 & 255) < 128) {
                                        ((LayoutNodeSubcompositionsState.NodeState) objArr3[(i7 << 3) + i9]).forceRecompose = true;
                                    }
                                    j5 >>= 8;
                                    i9++;
                                    j2 = j2;
                                }
                                j = j2;
                                if (i8 == 8) {
                                }
                            } else {
                                j = j2;
                            }
                            if (i7 != length2) {
                                i7++;
                                j2 = j;
                            }
                        }
                    }
                    if (layoutNode.lookaheadRoot != null) {
                        if (!layoutNode.layoutDelegate.lookaheadMeasurePending) {
                            LayoutNode.requestLookaheadRemeasure$ui$default(layoutNode, false, 7);
                        }
                    } else if (!layoutNode.getMeasurePending$ui()) {
                        LayoutNode.requestRemeasure$ui$default(layoutNode, false, 7);
                    }
                }
                return Unit.INSTANCE;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = ((LayoutNode) this.f$0).layoutDelegate;
                layoutNodeLayoutDelegate.measurePassDelegate.childDelegatesDirty = true;
                LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
                if (lookaheadPassDelegate != null) {
                    lookaheadPassDelegate.childDelegatesDirty = true;
                }
                return Unit.INSTANCE;
            case 13:
                AwaitKt.cancel(((AndroidPlatformTextInputSession) this.f$0).coroutineScope, (CancellationException) null);
                return Unit.INSTANCE;
            case 14:
                return Unit.INSTANCE;
            case 15:
                ComposeViewContext composeViewContext = (ComposeViewContext) this.f$0;
                boolean zM810equalsimpl0 = IntSize.m810equalsimpl0(0L, 0L);
                View view = composeViewContext.view;
                if (zM810equalsimpl0) {
                    Context context2 = view.getContext();
                    Context baseContext = context2;
                    while (baseContext instanceof ContextWrapper) {
                        if ((baseContext instanceof Activity) || (baseContext instanceof InputMethodService) || (baseContext instanceof Application)) {
                            context = baseContext;
                        } else {
                            ContextWrapper contextWrapper = (ContextWrapper) baseContext;
                            if (contextWrapper.getBaseContext() != null) {
                                baseContext = contextWrapper.getBaseContext();
                            }
                        }
                        if (context != null) {
                            WindowMetricsCalculator.Companion.getClass();
                            WindowMetricsCalculator.Companion companion = WindowMetricsCalculator.Companion.$$INSTANCE;
                            WindowMetricsCalculatorCompat windowMetricsCalculatorCompat = WindowMetricsCalculator.Companion.windowMetricsCalculatorCompat;
                            windowMetricsCalculatorCompat.getClass();
                            i = Build.VERSION.SDK_INT;
                            if (i >= 34) {
                                windowMetricsCompatHelper = DensityCompatHelperApi34Impl.INSTANCE$1;
                            } else if (i >= 30) {
                                windowMetricsCompatHelper = BoundsHelperApi30Impl.INSTANCE$1;
                            } else {
                                windowMetricsCompatHelper = BoundsHelperApi24Impl.INSTANCE$4;
                            }
                            WindowMetrics windowMetricsCurrentWindowMetrics = windowMetricsCompatHelper.currentWindowMetrics(context, windowMetricsCalculatorCompat.densityCompatHelper);
                            long jWidth = (((long) windowMetricsCurrentWindowMetrics.getBounds().width()) << 32) | (((long) windowMetricsCurrentWindowMetrics.getBounds().height()) & 4294967295L);
                            return new DerivedSize(jWidth, MathKt.Density(context).mo79toDpSizekrfVVM(SizeKt.m876toSizeozmzZPI(jWidth)));
                        }
                        Configuration configuration = context2.getResources().getConfiguration();
                        DensityWithConverter densityWithConverterDensity = MathKt.Density(context2);
                        long jM890DpSizeYgX7TsA = UtilsKt.m890DpSizeYgX7TsA(configuration.screenWidthDp, configuration.screenHeightDp);
                        derivedSize = new DerivedSize(SizeKt.m875toIntSizeuvyYCjk(densityWithConverterDensity.mo82toSizeXkaWNTQ(jM890DpSizeYgX7TsA)), jM890DpSizeYgX7TsA);
                    }
                    if (context != null) {
                        WindowMetricsCalculator.Companion.getClass();
                        WindowMetricsCalculator.Companion companion2 = WindowMetricsCalculator.Companion.$$INSTANCE;
                        WindowMetricsCalculatorCompat windowMetricsCalculatorCompat2 = WindowMetricsCalculator.Companion.windowMetricsCalculatorCompat;
                        windowMetricsCalculatorCompat2.getClass();
                        i = Build.VERSION.SDK_INT;
                        if (i >= 34) {
                            windowMetricsCompatHelper = DensityCompatHelperApi34Impl.INSTANCE$1;
                        } else if (i >= 30) {
                            windowMetricsCompatHelper = BoundsHelperApi30Impl.INSTANCE$1;
                        } else {
                            windowMetricsCompatHelper = BoundsHelperApi24Impl.INSTANCE$4;
                        }
                        WindowMetrics windowMetricsCurrentWindowMetrics2 = windowMetricsCompatHelper.currentWindowMetrics(context, windowMetricsCalculatorCompat2.densityCompatHelper);
                        long jWidth2 = (((long) windowMetricsCurrentWindowMetrics2.getBounds().width()) << 32) | (((long) windowMetricsCurrentWindowMetrics2.getBounds().height()) & 4294967295L);
                        return new DerivedSize(jWidth2, MathKt.Density(context).mo79toDpSizekrfVVM(SizeKt.m876toSizeozmzZPI(jWidth2)));
                    }
                    Configuration configuration2 = context2.getResources().getConfiguration();
                    DensityWithConverter densityWithConverterDensity2 = MathKt.Density(context2);
                    long jM890DpSizeYgX7TsA2 = UtilsKt.m890DpSizeYgX7TsA(configuration2.screenWidthDp, configuration2.screenHeightDp);
                    derivedSize = new DerivedSize(SizeKt.m875toIntSizeuvyYCjk(densityWithConverterDensity2.mo82toSizeXkaWNTQ(jM890DpSizeYgX7TsA2)), jM890DpSizeYgX7TsA2);
                } else {
                    derivedSize = new DerivedSize(0L, MathKt.Density(view.getContext()).mo79toDpSizekrfVVM(SizeKt.m876toSizeozmzZPI(0L)));
                }
                return derivedSize;
            case 16:
                ManagedRetainedValuesStore managedRetainedValuesStore = (ManagedRetainedValuesStore) ((LifecycleRetainedValuesStoreOwner.RetainedValuesStoreEntry) this.f$0)._retainedValuesStore.block;
                if (!managedRetainedValuesStore.isDisposed) {
                    if (managedRetainedValuesStore.isContentComposed) {
                        PreconditionsKt.throwIllegalStateException("ManagedValuesStore tried to enter composition twice. Did you attempt to install the same store multiple times or into two compositions?");
                    }
                    managedRetainedValuesStore.purgeUnusedExitedValues();
                    managedRetainedValuesStore.isContentComposed = true;
                }
                return Unit.INSTANCE;
            case 17:
                RectManager rectManager = (RectManager) this.f$0;
                rectManager.dispatchToken = null;
                Trace.beginSection("OnPositionedDispatch");
                try {
                    rectManager.dispatchCallbacks();
                    return Unit.INSTANCE;
                } finally {
                    Trace.endSection();
                }
            case 18:
                Object systemService = ((View) ((EmojiProcessor) this.f$0).mSpanFactory).getContext().getSystemService("input_method");
                systemService.getClass();
                return (InputMethodManager) systemService;
            case 19:
                return new BaseInputConnection(((TextInputServiceAndroid) this.f$0).view, false);
            case 20:
                ShaderBrushSpan shaderBrushSpan = (ShaderBrushSpan) this.f$0;
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = shaderBrushSpan.size$delegate;
                if (((Size) parcelableSnapshotMutableState.getValue()).packedValue == 9205357640488583168L || Size.m449isEmptyimpl(((Size) parcelableSnapshotMutableState.getValue()).packedValue)) {
                    return null;
                }
                return shaderBrushSpan.shaderBrush.mo474createShaderuvyYCjk(((Size) parcelableSnapshotMutableState.getValue()).packedValue);
            case 21:
                return Boolean.valueOf(PopupLayout.canCalculatePosition_delegate$lambda$0((PopupLayout) this.f$0));
            case 22:
                return ViewModelKt.getSavedStateHandlesVM((ViewModelStoreOwner) this.f$0);
            case 23:
                NavBackStackEntryImpl navBackStackEntryImpl = ((NavBackStackEntry) this.f$0).impl;
                if (!navBackStackEntryImpl.savedStateRegistryAttached) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("You cannot access the NavBackStackEntry's SavedStateHandle until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).");
                    return null;
                }
                if (navBackStackEntryImpl.lifecycle.state == Lifecycle.State.DESTROYED) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("You cannot access the NavBackStackEntry's SavedStateHandle after the NavBackStackEntry is destroyed.");
                    return null;
                }
                NavBackStackEntry navBackStackEntry = navBackStackEntryImpl.entry;
                ViewModelProvider$Factory viewModelProvider$Factory = (ViewModelProvider$Factory) navBackStackEntryImpl.navResultSavedStateFactory$delegate.getValue();
                CreationExtras viewModelCreationExtras = ViewModelKt.getViewModelCreationExtras(navBackStackEntry);
                viewModelProvider$Factory.getClass();
                viewModelCreationExtras.getClass();
                Dispatcher dispatcher = new Dispatcher(navBackStackEntry.getViewModelStore(), viewModelProvider$Factory, viewModelCreationExtras);
                ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(NavBackStackEntryImpl.SavedStateViewModel.class);
                String qualifiedName = orCreateKotlinClass.getQualifiedName();
                if (qualifiedName != null) {
                    return ((NavBackStackEntryImpl.SavedStateViewModel) dispatcher.getViewModel$lifecycle_viewmodel(orCreateKotlinClass, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(qualifiedName))).handle;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Local and anonymous classes can not be ViewModels");
                return null;
            case 24:
                InternalDatabase_Impl internalDatabase_Impl = ((InvalidationTracker) this.f$0).database;
                if (internalDatabase_Impl.inCompatibilityMode() && !internalDatabase_Impl.isOpenInternal$room_runtime()) {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            case 25:
                return ((FileLock) this.f$0).open(":memory:");
            case 26:
                PassthroughConnectionPool passthroughConnectionPool = (PassthroughConnectionPool) this.f$0;
                return passthroughConnectionPool.driver.open(passthroughConnectionPool.fileName);
            case 27:
                SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) this.f$0;
                savedStateRegistryOwner.getLifecycle().addObserver(new Recreator(b, savedStateRegistryOwner));
                return Unit.INSTANCE;
            case 28:
                FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper = (FrameworkSQLiteOpenHelper) this.f$0;
                FrameworkSQLiteOpenHelper.OpenHelper openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(frameworkSQLiteOpenHelper.context, frameworkSQLiteOpenHelper.name, new ConnectionPool((byte) 6), frameworkSQLiteOpenHelper.callback);
                openHelper.setWriteAheadLoggingEnabled(frameworkSQLiteOpenHelper.writeAheadLoggingEnabled);
                return openHelper;
            default:
                return CollectionsKt__IterablesKt.listOf((Pair) this.f$0);
        }
    }
}
