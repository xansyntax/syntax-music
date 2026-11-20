package coil3.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import androidx.collection.ArraySetKt;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.MutableObjectFloatMap;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectFloatMapKt;
import androidx.collection.SparseArrayCompat;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterTransitionImpl;
import androidx.compose.animation.ExitTransitionImpl;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyListMeasureResult;
import androidx.compose.foundation.lazy.LazyListMeasuredItem;
import androidx.compose.foundation.pager.PagerMeasureResult;
import androidx.compose.foundation.text.selection.HandlePositionProvider;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.carousel.Arrangement;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$1$1;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAbsoluteAlignment;
import androidx.compose.ui.ComposedModifier;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.autofill.AndroidContentDataType;
import androidx.compose.ui.autofill.AndroidFillableData;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InvertMatrixKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.scrollcapture.ScrollCapture;
import androidx.compose.ui.scrollcapture.ScrollCaptureCandidate;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import androidx.core.app.TaskStackBuilder;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.os.BuildCompat;
import androidx.core.os.HandlerCompat$Api28Impl;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavBackStackEntryState;
import androidx.navigation.NavController$NavControllerNavigatorState;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.compose.ComposeNavigator;
import androidx.navigation.compose.DialogNavigator;
import androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda12;
import androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda13;
import androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda3;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import androidx.navigation.compose.NavHostKt$NavHost$32;
import androidx.navigation.compose.NavHostKt$NavHost$33$1;
import androidx.navigation.internal.NavContext;
import androidx.navigation.internal.NavControllerImpl;
import androidx.navigation.internal.NavGraphImpl;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda2;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteStatement;
import coil3.BitmapImage;
import coil3.EventListener$Companion$NONE$1;
import coil3.Image;
import coil3.RealImageLoader;
import coil3.RealImageLoader$execute$result$1;
import coil3.UriKt;
import coil3.intercept.EngineInterceptor;
import coil3.intercept.EngineInterceptorKt$transform$1;
import coil3.request.ImageRequest;
import coil3.request.ImageRequestsKt;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import coil3.size.Precision;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.util.FileSystemsKt;
import com.dokar.quickjs.QuickJs$$ExternalSyntheticLambda1;
import com.github.ajalt.colormath.Illuminant;
import com.github.ajalt.colormath.WhitePoint;
import com.github.ajalt.colormath.model.XYZColorSpaceImpl;
import com.github.ajalt.colormath.model.XYZColorSpaces;
import com.google.common.math.IntMath;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda22;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda50;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda33;
import com.metrolist.music.ui.screens.ListenTogetherScreenKt$$ExternalSyntheticLambda72;
import com.yalantis.ucrop.util.ImageHeaderParser;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.utils.io.ByteChannelKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.ReversedList;
import kotlin.collections.ReversedListReadOnly;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.http.StatusLine;
import okio.FileSystem;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FileSystemsKt {
    public static Boolean shouldIgnorePerformancePoints;

    public static final void HandlePopup(OffsetProvider offsetProvider, Alignment alignment, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1090171650);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? gapComposer.changed(offsetProvider) : gapComposer.changedInstance(offsetProvider) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(alignment) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 256 : 128;
        }
        boolean z = true;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            boolean z2 = (i2 & 112) == 32;
            if ((i2 & 14) != 4 && ((i2 & 8) == 0 || !gapComposer.changed(offsetProvider))) {
                z = false;
            }
            boolean z3 = z2 | z;
            Object objRememberedValue = gapComposer.rememberedValue();
            if (z3 || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new HandlePositionProvider(alignment, offsetProvider);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            AndroidPopup_androidKt.Popup((HandlePositionProvider) objRememberedValue, null, new PopupProperties(false, SecureFlagPolicy.Inherit, false, 1920), composableLambdaImpl, gapComposer, ((i2 << 3) & 7168) | 384, 2);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda0((byte) 7, i, (Object) offsetProvider, (Object) alignment, (Object) composableLambdaImpl);
        }
    }

    /* JADX WARN: Code duplicated, block: B:301:0x05fb  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void NavHost(NavHostController navHostController, NavGraph navGraph, Modifier modifier, Alignment alignment, final Function1 function1, final Function1 function2, final Function1 function3, final Function1 function4, Composer composer, int i) {
        NavigatorProvider navigatorProvider;
        GapComposer gapComposer;
        LifecycleOwner lifecycleOwner;
        ComposeNavigator composeNavigator;
        MutableState mutableState;
        ComposeNavigator composeNavigator2;
        GapComposer gapComposer2;
        DialogNavigator dialogNavigator;
        DialogNavigator dialogNavigator2;
        final ComposeNavigator composeNavigator3;
        boolean z;
        Transition transition;
        SeekableTransitionState seekableTransitionState;
        State state;
        MutableObjectFloatMap mutableObjectFloatMap;
        ComposeNavigator composeNavigator4;
        int[] intArray;
        int[] iArr;
        ArrayList arrayList;
        String displayName;
        NavDestination navDestinationFindNode$navigation_common_release;
        NavGraph navGraph2;
        int i2;
        Bundle bundle;
        int i3;
        NavDestination navDestinationFindNode$navigation_common_release2;
        NavGraph navGraph3;
        GapComposer gapComposer3 = (GapComposer) composer;
        gapComposer3.startRestartGroup(-1964664536);
        int i4 = (i & 6) == 0 ? (gapComposer3.changedInstance(navHostController) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i4 |= gapComposer3.changedInstance(navGraph) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= gapComposer3.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= gapComposer3.changed(alignment) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= gapComposer3.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i4 |= gapComposer3.changedInstance(function2) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i4 |= gapComposer3.changedInstance(function3) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if ((i & 12582912) == 0) {
            i4 |= gapComposer3.changedInstance(function4) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i4 |= gapComposer3.changedInstance(null) ? 67108864 : 33554432;
        }
        int i5 = i4;
        if ((38347923 & i5) == 38347922 && gapComposer3.getSkipping()) {
            gapComposer3.skipToGroupEnd();
            gapComposer2 = gapComposer3;
        } else {
            gapComposer3.startDefaults();
            if ((i & 1) != 0 && !gapComposer3.getDefaultsInvalid()) {
                gapComposer3.skipToGroupEnd();
            }
            gapComposer3.endDefaults();
            LifecycleOwner lifecycleOwner2 = (LifecycleOwner) gapComposer3.consume(LocalLifecycleOwnerKt.LocalLifecycleOwner);
            ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) gapComposer3.consume(LocalViewModelStoreOwner.LocalViewModelStoreOwner);
            if (viewModelStoreOwner == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("NavHost requires a ViewModelStoreOwner to be provided via LocalViewModelStoreOwner");
                return;
            }
            ViewModelStore viewModelStore = viewModelStoreOwner.getViewModelStore();
            navHostController.getClass();
            NavControllerImpl navControllerImpl = navHostController.impl;
            viewModelStore.getClass();
            navControllerImpl.getClass();
            ArrayDeque<NavBackStackEntry> arrayDeque = navControllerImpl.backQueue;
            NavigatorProvider navigatorProvider2 = navControllerImpl._navigatorProvider;
            if (!Intrinsics.areEqual(navControllerImpl.viewModel, MathKt.getInstance(viewModelStore))) {
                if (!arrayDeque.isEmpty()) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("ViewModelStore should be set before setGraph call");
                    return;
                }
                navControllerImpl.viewModel = MathKt.getInstance(viewModelStore);
            }
            navGraph.getClass();
            LinkedHashMap linkedHashMap = navControllerImpl.navigatorState;
            NavGraphImpl navGraphImpl = navGraph.impl;
            if (!arrayDeque.isEmpty() && navControllerImpl.getHostLifecycleState$navigation_runtime_release() == Lifecycle.State.DESTROYED) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("You cannot set a new graph on a NavController with entries on the back stack after the NavController has been destroyed. Please ensure that your NavHost has the same lifetime as your NavController.");
                return;
            }
            boolean z2 = false;
            if (Intrinsics.areEqual(navControllerImpl._graph, navGraph)) {
                navigatorProvider = navigatorProvider2;
                gapComposer = gapComposer3;
                i5 = i5;
                lifecycleOwner = lifecycleOwner2;
                composeNavigator = null;
                int size = ((SparseArrayCompat) navGraphImpl.nodes).size();
                for (int i6 = 0; i6 < size; i6++) {
                    NavDestination navDestination = (NavDestination) ((SparseArrayCompat) navGraphImpl.nodes).valueAt(i6);
                    NavGraph navGraph4 = navControllerImpl._graph;
                    navGraph4.getClass();
                    int iKeyAt = ((SparseArrayCompat) navGraph4.impl.nodes).keyAt(i6);
                    NavGraph navGraph5 = navControllerImpl._graph;
                    navGraph5.getClass();
                    SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) navGraph5.impl.nodes;
                    if (sparseArrayCompat.garbage) {
                        ArraySetKt.gc(sparseArrayCompat);
                    }
                    int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.size, iKeyAt, sparseArrayCompat.keys);
                    if (iBinarySearch >= 0) {
                        Object[] objArr = sparseArrayCompat.values;
                        Object obj = objArr[iBinarySearch];
                        objArr[iBinarySearch] = navDestination;
                    }
                }
                for (NavBackStackEntry navBackStackEntry : arrayDeque) {
                    int i7 = NavDestination.$r8$clinit;
                    ReversedListReadOnly reversedListReadOnly = new ReversedListReadOnly(SequencesKt.toList(getHierarchy(navBackStackEntry.destination)));
                    NavDestination navDestinationFindNode$navigation_common_release3 = navControllerImpl._graph;
                    navDestinationFindNode$navigation_common_release3.getClass();
                    Iterator it = reversedListReadOnly.iterator();
                    while (true) {
                        ListIterator listIterator = (ListIterator) ((ReversedList.AnonymousClass1) it).delegateIterator;
                        if (listIterator.hasPrevious()) {
                            NavDestination navDestination2 = (NavDestination) listIterator.previous();
                            if (!Intrinsics.areEqual(navDestination2, navControllerImpl._graph) || !navDestinationFindNode$navigation_common_release3.equals(navGraph)) {
                                if (navDestinationFindNode$navigation_common_release3 instanceof NavGraph) {
                                    navDestinationFindNode$navigation_common_release3 = ((NavGraph) navDestinationFindNode$navigation_common_release3).impl.findNode$navigation_common_release(navDestination2.impl.size);
                                    navDestinationFindNode$navigation_common_release3.getClass();
                                }
                            }
                        }
                    }
                    navBackStackEntry.destination = navDestinationFindNode$navigation_common_release3;
                }
            } else {
                NavGraph navGraph6 = navControllerImpl._graph;
                if (navGraph6 != null) {
                    ArrayList arrayList2 = new ArrayList(navControllerImpl.backStackMap.keySet());
                    int size2 = arrayList2.size();
                    int i8 = 0;
                    while (i8 < size2) {
                        Object obj2 = arrayList2.get(i8);
                        int i9 = i8 + 1;
                        Integer num = (Integer) obj2;
                        num.getClass();
                        ArrayList arrayList3 = arrayList2;
                        int iIntValue = num.intValue();
                        Iterator it2 = linkedHashMap.values().iterator();
                        while (it2.hasNext()) {
                            ((NavController$NavControllerNavigatorState) it2.next()).isNavigating = true;
                            i9 = i9;
                        }
                        int i10 = i9;
                        boolean zRestoreStateInternal = navControllerImpl.restoreStateInternal(iIntValue, null, new NavOptions(z2, true, -1, z2, z2, -1, -1));
                        for (Iterator it3 = linkedHashMap.values().iterator(); it3.hasNext(); it3 = it3) {
                            ((NavController$NavControllerNavigatorState) it3.next()).isNavigating = false;
                            zRestoreStateInternal = zRestoreStateInternal;
                        }
                        if (zRestoreStateInternal) {
                            navControllerImpl.popBackStackInternal$navigation_runtime_release(iIntValue, true, false);
                        }
                        arrayList2 = arrayList3;
                        i8 = i10;
                        z2 = false;
                    }
                    navControllerImpl.popBackStackInternal$navigation_runtime_release(((NavDestination) navGraph6).impl.size, true, false);
                }
                navControllerImpl._graph = navGraph;
                NavHostController navHostController2 = navControllerImpl.navController;
                NavContext navContext = navHostController2.navContext;
                Bundle bundle2 = navControllerImpl.navigatorStateToRestore;
                if (bundle2 != null && bundle2.containsKey("android-support-nav:controller:navigatorState:names")) {
                    ArrayList<String> stringArrayList = bundle2.getStringArrayList("android-support-nav:controller:navigatorState:names");
                    if (stringArrayList == null) {
                        keyOrValueNotFoundError("android-support-nav:controller:navigatorState:names");
                        throw null;
                    }
                    int size3 = stringArrayList.size();
                    int i11 = 0;
                    while (i11 < size3) {
                        String str = stringArrayList.get(i11);
                        i11++;
                        int i12 = size3;
                        String str2 = str;
                        navigatorProvider2.getNavigator(str2);
                        if (bundle2.containsKey(str2) && bundle2.getBundle(str2) == null) {
                            keyOrValueNotFoundError(str2);
                            throw null;
                        }
                        size3 = i12;
                    }
                }
                Bundle[] bundleArr = navControllerImpl.backStackToRestore;
                if (bundleArr != null) {
                    int length = bundleArr.length;
                    int i13 = 0;
                    while (i13 < length) {
                        Bundle[] bundleArr2 = bundleArr;
                        Bundle bundle3 = bundleArr2[i13];
                        bundle3.getClass();
                        int i14 = length;
                        bundle3.setClassLoader(NavBackStackEntryState.class.getClassLoader());
                        String string = bundle3.getString("nav-entry-state:id");
                        if (string == null) {
                            keyOrValueNotFoundError("nav-entry-state:id");
                            throw null;
                        }
                        int iM1876getIntimpl = MathKt.m1876getIntimpl("nav-entry-state:destination-id", bundle3);
                        Bundle bundle4 = bundle3.getBundle("nav-entry-state:args");
                        if (bundle4 == null) {
                            keyOrValueNotFoundError("nav-entry-state:args");
                            throw null;
                        }
                        Bundle bundle5 = bundle3.getBundle("nav-entry-state:saved-state");
                        if (bundle5 == null) {
                            keyOrValueNotFoundError("nav-entry-state:saved-state");
                            throw null;
                        }
                        NavDestination navDestinationFindDestination$navigation_runtime_release = navControllerImpl.findDestination$navigation_runtime_release(iM1876getIntimpl, null);
                        if (navDestinationFindDestination$navigation_runtime_release == null) {
                            int i15 = NavDestination.$r8$clinit;
                            StringBuilder sbM4m = IntIntPair$$ExternalSyntheticOutline0.m4m("Restoring the Navigation back stack failed: destination ", getDisplayName(navContext, iM1876getIntimpl), " cannot be found from the current destination ");
                            sbM4m.append(navControllerImpl.getCurrentDestination$navigation_runtime_release());
                            throw new IllegalStateException(sbM4m.toString());
                        }
                        Lifecycle.State hostLifecycleState$navigation_runtime_release = navControllerImpl.getHostLifecycleState$navigation_runtime_release();
                        NavControllerViewModel navControllerViewModel = navControllerImpl.viewModel;
                        navContext.getClass();
                        hostLifecycleState$navigation_runtime_release.getClass();
                        Context context = navContext.context;
                        bundle4.setClassLoader(context != null ? context.getClassLoader() : null);
                        NavBackStackEntry navBackStackEntry2 = new NavBackStackEntry(navContext, navDestinationFindDestination$navigation_runtime_release, bundle4, hostLifecycleState$navigation_runtime_release, navControllerViewModel, string, bundle5);
                        Navigator navigator = navigatorProvider2.getNavigator(navDestinationFindDestination$navigation_runtime_release.navigatorName);
                        Object obj3 = linkedHashMap.get(navigator);
                        Object obj4 = obj3;
                        if (obj3 == null) {
                            NavController$NavControllerNavigatorState navController$NavControllerNavigatorState = new NavController$NavControllerNavigatorState(navHostController2, navigator);
                            linkedHashMap.put(navigator, navController$NavControllerNavigatorState);
                            obj4 = navController$NavControllerNavigatorState;
                        }
                        arrayDeque.addLast(navBackStackEntry2);
                        ((NavController$NavControllerNavigatorState) obj4).addInternal(navBackStackEntry2);
                        NavGraph navGraph7 = navBackStackEntry2.destination.parent;
                        if (navGraph7 != null) {
                            navControllerImpl.linkChildToParent$navigation_runtime_release(navBackStackEntry2, navControllerImpl.getBackStackEntry$navigation_runtime_release(((NavDestination) navGraph7).impl.size));
                        }
                        i13++;
                        bundleArr = bundleArr2;
                        length = i14;
                    }
                    navControllerImpl.updateOnBackPressedCallbackEnabledCallback.invoke();
                    navControllerImpl.backStackToRestore = null;
                }
                Collection collectionValues = MapsKt__MapsKt.toMap(navigatorProvider2._navigators).values();
                ArrayList arrayList4 = new ArrayList();
                for (Object obj5 : collectionValues) {
                    if (!((Navigator) obj5).isAttached) {
                        arrayList4.add(obj5);
                    }
                }
                int size4 = arrayList4.size();
                int i16 = 0;
                while (i16 < size4) {
                    Object obj6 = arrayList4.get(i16);
                    i16++;
                    Navigator navigator2 = (Navigator) obj6;
                    Object navController$NavControllerNavigatorState2 = linkedHashMap.get(navigator2);
                    if (navController$NavControllerNavigatorState2 == null) {
                        navigator2.getClass();
                        navController$NavControllerNavigatorState2 = new NavController$NavControllerNavigatorState(navHostController2, navigator2);
                        linkedHashMap.put(navigator2, navController$NavControllerNavigatorState2);
                    }
                    navigator2.getClass();
                    navigator2._state = (NavController$NavControllerNavigatorState) navController$NavControllerNavigatorState2;
                    navigator2.isAttached = true;
                }
                if (navControllerImpl._graph == null || !arrayDeque.isEmpty()) {
                    navigatorProvider = navigatorProvider2;
                    gapComposer = gapComposer3;
                    i5 = i5;
                    lifecycleOwner = lifecycleOwner2;
                    composeNavigator = null;
                    navControllerImpl.dispatchOnDestinationChanged$navigation_runtime_release();
                } else {
                    Activity activity = navHostController2.activity;
                    if (navHostController2.deepLinkHandled || activity == null) {
                        navigatorProvider = navigatorProvider2;
                        gapComposer = gapComposer3;
                        i5 = i5;
                        lifecycleOwner = lifecycleOwner2;
                        NavGraph navGraph8 = navControllerImpl._graph;
                        navGraph8.getClass();
                        composeNavigator = null;
                        navControllerImpl.navigate$navigation_runtime_release(navGraph8, null, null);
                    } else {
                        Intent intent = activity.getIntent();
                        NavControllerImpl navControllerImpl2 = navHostController2.impl;
                        if (intent == null) {
                            navigatorProvider = navigatorProvider2;
                            gapComposer = gapComposer3;
                            i5 = i5;
                            lifecycleOwner = lifecycleOwner2;
                        } else {
                            Bundle extras = intent.getExtras();
                            if (extras != null) {
                                try {
                                    intArray = extras.getIntArray("android-support-nav:controller:deepLinkIds");
                                } catch (Exception e) {
                                    Log.e("NavController", "handleDeepLink() could not extract deepLink from " + intent, e);
                                    intArray = null;
                                }
                            } else {
                                intArray = null;
                            }
                            ArrayList parcelableArrayList = extras != null ? extras.getParcelableArrayList("android-support-nav:controller:deepLinkArgs") : null;
                            Bundle bundleBundleOf = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                            Bundle bundle6 = extras != null ? extras.getBundle("android-support-nav:controller:deepLinkExtras") : null;
                            if (bundle6 != null) {
                                bundleBundleOf.putAll(bundle6);
                            }
                            if (intArray == null || intArray.length == 0) {
                                NavGraph topGraph$navigation_runtime_release = navControllerImpl2.getTopGraph$navigation_runtime_release();
                                lifecycleOwner = lifecycleOwner2;
                                gapComposer = gapComposer3;
                                navigatorProvider = navigatorProvider2;
                                NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLinkComprehensive = topGraph$navigation_runtime_release.matchDeepLinkComprehensive(new NavDeepLinkRequest((Object) intent.getData(), (Object) intent.getAction(), (Object) intent.getType(), (byte) 0), topGraph$navigation_runtime_release);
                                if (deepLinkMatchMatchDeepLinkComprehensive != null) {
                                    NavDestination navDestination3 = deepLinkMatchMatchDeepLinkComprehensive.destination;
                                    int[] iArrBuildDeepLinkIds = navDestination3.buildDeepLinkIds(null);
                                    Bundle bundleAddInDefaultArgs = navDestination3.addInDefaultArgs(deepLinkMatchMatchDeepLinkComprehensive.matchingArgs);
                                    if (bundleAddInDefaultArgs != null) {
                                        bundleBundleOf.putAll(bundleAddInDefaultArgs);
                                    }
                                    iArr = iArrBuildDeepLinkIds;
                                    arrayList = null;
                                }
                                if (iArr == null && iArr.length != 0) {
                                    navControllerImpl2.getClass();
                                    NavGraph navGraph9 = navControllerImpl2._graph;
                                    int length2 = iArr.length;
                                    int i17 = 0;
                                    while (true) {
                                        if (i17 >= length2) {
                                            displayName = null;
                                            break;
                                        }
                                        int i18 = iArr[i17];
                                        if (i17 == 0) {
                                            i3 = length2;
                                            NavGraph navGraph10 = navControllerImpl2._graph;
                                            navGraph10.getClass();
                                            navDestinationFindNode$navigation_common_release2 = ((NavDestination) navGraph10).impl.size == i18 ? navControllerImpl2._graph : null;
                                        } else {
                                            i3 = length2;
                                            navGraph9.getClass();
                                            navDestinationFindNode$navigation_common_release2 = navGraph9.impl.findNode$navigation_common_release(i18);
                                        }
                                        if (navDestinationFindNode$navigation_common_release2 == null) {
                                            int i19 = NavDestination.$r8$clinit;
                                            displayName = getDisplayName(navControllerImpl2.navController.navContext, i18);
                                            break;
                                        }
                                        if (i17 != iArr.length - 1 && (navDestinationFindNode$navigation_common_release2 instanceof NavGraph)) {
                                            while (true) {
                                                navGraph3 = (NavGraph) navDestinationFindNode$navigation_common_release2;
                                                navGraph3.getClass();
                                                NavGraphImpl navGraphImpl2 = navGraph3.impl;
                                                if (!(navGraphImpl2.findNode$navigation_common_release(navGraphImpl2.startDestId) instanceof NavGraph)) {
                                                    break;
                                                } else {
                                                    navDestinationFindNode$navigation_common_release2 = navGraphImpl2.findNode$navigation_common_release(navGraphImpl2.startDestId);
                                                }
                                            }
                                            navGraph9 = navGraph3;
                                        }
                                        i17++;
                                        length2 = i3;
                                    }
                                    if (displayName != null) {
                                        Log.i("NavController", "Could not find destination " + displayName + " in the navigation graph, ignoring the deep link from " + intent);
                                    } else {
                                        bundleBundleOf.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
                                        int length3 = iArr.length;
                                        Bundle[] bundleArr3 = new Bundle[length3];
                                        for (int i20 = 0; i20 < length3; i20++) {
                                            Bundle bundleBundleOf2 = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                                            bundleBundleOf2.putAll(bundleBundleOf);
                                            if (arrayList != null && (bundle = (Bundle) arrayList.get(i20)) != null) {
                                                bundleBundleOf2.putAll(bundle);
                                            }
                                            bundleArr3[i20] = bundleBundleOf2;
                                        }
                                        int flags = intent.getFlags();
                                        int i21 = 268435456 & flags;
                                        if (i21 != 0 && (flags & 32768) == 0) {
                                            intent.addFlags(32768);
                                            TaskStackBuilder taskStackBuilder = new TaskStackBuilder(navHostController2.context);
                                            ComponentName component = intent.getComponent();
                                            if (component == null) {
                                                component = intent.resolveActivity(taskStackBuilder.mSourceContext.getPackageManager());
                                            }
                                            if (component != null) {
                                                taskStackBuilder.addParentStack(component);
                                            }
                                            taskStackBuilder.mIntents.add(intent);
                                            taskStackBuilder.startActivities();
                                            activity.finish();
                                            activity.overridePendingTransition(0, 0);
                                        } else if (i21 != 0) {
                                            if (navControllerImpl2.backQueue.isEmpty()) {
                                                i2 = 0;
                                            } else {
                                                NavGraph navGraph11 = navControllerImpl2._graph;
                                                navGraph11.getClass();
                                                i2 = 0;
                                                navControllerImpl2.popBackStackInternal$navigation_runtime_release(((NavDestination) navGraph11).impl.size, true, false);
                                            }
                                            while (i2 < iArr.length) {
                                                int i22 = iArr[i2];
                                                int i23 = i2 + 1;
                                                Bundle bundle7 = bundleArr3[i2];
                                                NavDestination navDestinationFindDestination$navigation_runtime_release2 = navControllerImpl2.findDestination$navigation_runtime_release(i22, null);
                                                if (navDestinationFindDestination$navigation_runtime_release2 == null) {
                                                    int i24 = NavDestination.$r8$clinit;
                                                    StringBuilder sbM4m2 = IntIntPair$$ExternalSyntheticOutline0.m4m("Deep Linking failed: destination ", getDisplayName(navContext, i22), " cannot be found from the current destination ");
                                                    sbM4m2.append(navControllerImpl2.getCurrentDestination$navigation_runtime_release());
                                                    throw new IllegalStateException(sbM4m2.toString());
                                                }
                                                navControllerImpl2.navigate$navigation_runtime_release(navDestinationFindDestination$navigation_runtime_release2, bundle7, LifecyclesKt.navOptions(new QuickJs$$ExternalSyntheticLambda1(navDestinationFindDestination$navigation_runtime_release2, navHostController2, (byte) 5)));
                                                i2 = i23;
                                            }
                                            navHostController2.deepLinkHandled = true;
                                        } else {
                                            NavGraph navGraph12 = navControllerImpl2._graph;
                                            int length4 = iArr.length;
                                            for (int i25 = 0; i25 < length4; i25++) {
                                                int i26 = iArr[i25];
                                                Bundle bundle8 = bundleArr3[i25];
                                                if (i25 == 0) {
                                                    navDestinationFindNode$navigation_common_release = navControllerImpl2._graph;
                                                } else {
                                                    navGraph12.getClass();
                                                    navDestinationFindNode$navigation_common_release = navGraph12.impl.findNode$navigation_common_release(i26);
                                                }
                                                if (navDestinationFindNode$navigation_common_release == null) {
                                                    int i27 = NavDestination.$r8$clinit;
                                                    PathKt$$ExternalSyntheticBUOutline0.m$1("Deep Linking failed: destination ", getDisplayName(navContext, i26), " cannot be found in graph ", navGraph12);
                                                    return;
                                                }
                                                if (i25 == iArr.length - 1) {
                                                    NavGraph navGraph13 = navControllerImpl2._graph;
                                                    navGraph13.getClass();
                                                    navControllerImpl2.navigate$navigation_runtime_release(navDestinationFindNode$navigation_common_release, bundle8, new NavOptions(false, false, ((NavDestination) navGraph13).impl.size, true, false, 0, 0));
                                                } else if (navDestinationFindNode$navigation_common_release instanceof NavGraph) {
                                                    while (true) {
                                                        navGraph2 = (NavGraph) navDestinationFindNode$navigation_common_release;
                                                        navGraph2.getClass();
                                                        NavGraphImpl navGraphImpl3 = navGraph2.impl;
                                                        if (!(navGraphImpl3.findNode$navigation_common_release(navGraphImpl3.startDestId) instanceof NavGraph)) {
                                                            break;
                                                        } else {
                                                            navDestinationFindNode$navigation_common_release = navGraphImpl3.findNode$navigation_common_release(navGraphImpl3.startDestId);
                                                        }
                                                    }
                                                    navGraph12 = navGraph2;
                                                }
                                            }
                                            navHostController2.deepLinkHandled = true;
                                        }
                                        composeNavigator = null;
                                    }
                                }
                            } else {
                                navigatorProvider = navigatorProvider2;
                                gapComposer = gapComposer3;
                                lifecycleOwner = lifecycleOwner2;
                            }
                            arrayList = parcelableArrayList;
                            iArr = intArray;
                            if (iArr == null) {
                            }
                        }
                        NavGraph navGraph14 = navControllerImpl._graph;
                        navGraph14.getClass();
                        composeNavigator = null;
                        navControllerImpl.navigate$navigation_runtime_release(navGraph14, null, null);
                    }
                }
            }
            NavigatorProvider navigatorProvider3 = navigatorProvider;
            Navigator navigator3 = navigatorProvider3.getNavigator("composable");
            ComposeNavigator composeNavigator5 = navigator3 instanceof ComposeNavigator ? (ComposeNavigator) navigator3 : composeNavigator;
            if (composeNavigator5 == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new NavHostKt$$ExternalSyntheticLambda3(navHostController, navGraph, modifier, alignment, function1, function2, function3, function4, i, (byte) 2);
                    return;
                }
                return;
            }
            GapComposer gapComposer4 = gapComposer;
            MutableState mutableStateCollectAsState = Stack.collectAsState(composeNavigator5.getState().backStack, gapComposer4, 0);
            Object objRememberedValue = gapComposer4.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Format$$ExternalSyntheticOutline0.m(CropImageView.DEFAULT_ASPECT_RATIO, gapComposer4);
            }
            ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) objRememberedValue;
            Object objRememberedValue2 = gapComposer4.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer4.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            boolean z3 = ((List) mutableStateCollectAsState.getValue()).size() > 1;
            boolean zChanged = gapComposer4.changed(mutableStateCollectAsState) | gapComposer4.changedInstance(composeNavigator5);
            Object objRememberedValue3 = gapComposer4.rememberedValue();
            if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new RealImageLoader$execute$result$1(composeNavigator5, mutableStateCollectAsState, parcelableSnapshotMutableFloatState, mutableState2, null, (byte) 8);
                mutableState = mutableStateCollectAsState;
                gapComposer4.updateRememberedValue(objRememberedValue3);
            } else {
                mutableState = mutableStateCollectAsState;
            }
            LifecyclesKt.PredictiveBackHandler(z3, (Function2) objRememberedValue3, gapComposer4, 0);
            LifecycleOwner lifecycleOwner3 = lifecycleOwner;
            boolean zChangedInstance = gapComposer4.changedInstance(navHostController) | gapComposer4.changedInstance(lifecycleOwner3);
            Object objRememberedValue4 = gapComposer4.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new QuickJs$$ExternalSyntheticLambda1(navHostController, lifecycleOwner3, (byte) 7);
                gapComposer4.updateRememberedValue(objRememberedValue4);
            }
            Stack.DisposableEffect(lifecycleOwner3, (Function1) objRememberedValue4, gapComposer4);
            SaveableStateHolderImpl saveableStateHolderImplRememberSaveableStateHolder = SaverKt.rememberSaveableStateHolder(gapComposer4);
            MutableState mutableStateCollectAsState2 = Stack.collectAsState(navControllerImpl.visibleEntries, gapComposer4, 0);
            Object objRememberedValue5 = gapComposer4.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new MainActivity$$ExternalSyntheticLambda22(mutableStateCollectAsState2, (byte) 11));
                gapComposer4.updateRememberedValue(objRememberedValue5);
            }
            State state2 = (State) objRememberedValue5;
            NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) CollectionsKt.lastOrNull((List) state2.getValue());
            Object objRememberedValue6 = gapComposer4.rememberedValue();
            if (objRememberedValue6 == neverEqualPolicy) {
                int i28 = ObjectFloatMapKt.$r8$clinit;
                objRememberedValue6 = new MutableObjectFloatMap(6);
                gapComposer4.updateRememberedValue(objRememberedValue6);
            }
            MutableObjectFloatMap mutableObjectFloatMap2 = (MutableObjectFloatMap) objRememberedValue6;
            if (navBackStackEntry3 != null) {
                gapComposer4.startReplaceGroup(-1797897130);
                boolean zChangedInstance2 = gapComposer4.changedInstance(composeNavigator5) | ((((i5 & 3670016) ^ 1572864) > 1048576 && gapComposer4.changed(function3)) || (i5 & 1572864) == 1048576) | ((i5 & 57344) == 16384);
                Object objRememberedValue7 = gapComposer4.rememberedValue();
                if (zChangedInstance2 || objRememberedValue7 == neverEqualPolicy) {
                    ComposeNavigator composeNavigator6 = composeNavigator5;
                    final byte b = 0;
                    composeNavigator3 = composeNavigator6;
                    z = true;
                    Function1 function5 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda8
                        /* JADX WARN: Code duplicated, block: B:21:0x0065  */
                        /* JADX WARN: Code duplicated, block: B:34:0x009a  */
                        /* JADX WARN: Code duplicated, block: B:53:0x00f7  */
                        /* JADX WARN: Code duplicated, block: B:66:0x012c  */
                        /* JADX WARN: Code duplicated, block: B:88:? A[RETURN, SYNTHETIC] */
                        /* JADX WARN: Code duplicated, block: B:90:? A[RETURN, SYNTHETIC] */
                        /* JADX WARN: Code duplicated, block: B:91:? A[RETURN, SYNTHETIC] */
                        /* JADX WARN: Code duplicated, block: B:93:? A[RETURN, SYNTHETIC] */
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj7) {
                            Function1 function6;
                            Function1 function7;
                            Function1 function8;
                            Function1 function9;
                            byte b2 = b;
                            Object obj8 = null;
                            MutableState mutableState3 = mutableState2;
                            Function1 function10 = function1;
                            Function1 function11 = function3;
                            ComposeNavigator composeNavigator7 = composeNavigator3;
                            AnimatedContentTransitionScope animatedContentTransitionScope = (AnimatedContentTransitionScope) obj7;
                            switch (b2) {
                                case 0:
                                    NavDestination navDestination4 = ((NavBackStackEntry) animatedContentTransitionScope.getTargetState()).destination;
                                    navDestination4.getClass();
                                    ComposeNavigator.Destination destination = (ComposeNavigator.Destination) navDestination4;
                                    if (((Boolean) composeNavigator7.isPop.getValue()).booleanValue() || ((Boolean) mutableState3.getValue()).booleanValue()) {
                                        int i29 = NavDestination.$r8$clinit;
                                        for (NavDestination navDestination5 : FileSystemsKt.getHierarchy(destination)) {
                                            EnterTransitionImpl enterTransitionImpl = (!(navDestination5 instanceof ComposeNavigator.Destination) || (function6 = ((ComposeNavigator.Destination) navDestination5).popEnterTransition) == null) ? null : (EnterTransitionImpl) function6.invoke(animatedContentTransitionScope);
                                            if (enterTransitionImpl != null) {
                                                obj8 = enterTransitionImpl;
                                                if (obj8 == null) {
                                                    return (EnterTransitionImpl) function11.invoke(animatedContentTransitionScope);
                                                }
                                                return obj8;
                                            }
                                        }
                                        if (obj8 == null) {
                                            return (EnterTransitionImpl) function11.invoke(animatedContentTransitionScope);
                                        }
                                        return obj8;
                                    }
                                    int i30 = NavDestination.$r8$clinit;
                                    for (NavDestination navDestination6 : FileSystemsKt.getHierarchy(destination)) {
                                        EnterTransitionImpl enterTransitionImpl2 = (!(navDestination6 instanceof ComposeNavigator.Destination) || (function7 = ((ComposeNavigator.Destination) navDestination6).enterTransition) == null) ? null : (EnterTransitionImpl) function7.invoke(animatedContentTransitionScope);
                                        if (enterTransitionImpl2 != null) {
                                            obj8 = enterTransitionImpl2;
                                            if (obj8 == null) {
                                                return (EnterTransitionImpl) function10.invoke(animatedContentTransitionScope);
                                            }
                                            return obj8;
                                        }
                                    }
                                    if (obj8 == null) {
                                        return (EnterTransitionImpl) function10.invoke(animatedContentTransitionScope);
                                    }
                                    return obj8;
                                default:
                                    NavDestination navDestination7 = ((NavBackStackEntry) animatedContentTransitionScope.getInitialState()).destination;
                                    navDestination7.getClass();
                                    ComposeNavigator.Destination destination2 = (ComposeNavigator.Destination) navDestination7;
                                    if (((Boolean) composeNavigator7.isPop.getValue()).booleanValue() || ((Boolean) mutableState3.getValue()).booleanValue()) {
                                        int i31 = NavDestination.$r8$clinit;
                                        for (NavDestination navDestination8 : FileSystemsKt.getHierarchy(destination2)) {
                                            ExitTransitionImpl exitTransitionImpl = (!(navDestination8 instanceof ComposeNavigator.Destination) || (function8 = ((ComposeNavigator.Destination) navDestination8).popExitTransition) == null) ? null : (ExitTransitionImpl) function8.invoke(animatedContentTransitionScope);
                                            if (exitTransitionImpl != null) {
                                                obj8 = exitTransitionImpl;
                                                if (obj8 == null) {
                                                    return (ExitTransitionImpl) function11.invoke(animatedContentTransitionScope);
                                                }
                                                return obj8;
                                            }
                                        }
                                        if (obj8 == null) {
                                            return (ExitTransitionImpl) function11.invoke(animatedContentTransitionScope);
                                        }
                                        return obj8;
                                    }
                                    int i32 = NavDestination.$r8$clinit;
                                    for (NavDestination navDestination9 : FileSystemsKt.getHierarchy(destination2)) {
                                        ExitTransitionImpl exitTransitionImpl2 = (!(navDestination9 instanceof ComposeNavigator.Destination) || (function9 = ((ComposeNavigator.Destination) navDestination9).exitTransition) == null) ? null : (ExitTransitionImpl) function9.invoke(animatedContentTransitionScope);
                                        if (exitTransitionImpl2 != null) {
                                            obj8 = exitTransitionImpl2;
                                            if (obj8 == null) {
                                                return (ExitTransitionImpl) function10.invoke(animatedContentTransitionScope);
                                            }
                                            return obj8;
                                        }
                                    }
                                    if (obj8 == null) {
                                        return (ExitTransitionImpl) function10.invoke(animatedContentTransitionScope);
                                    }
                                    return obj8;
                            }
                        }
                    };
                    gapComposer4.updateRememberedValue(function5);
                    objRememberedValue7 = function5;
                } else {
                    composeNavigator3 = composeNavigator5;
                    z = true;
                }
                Function1 function6 = (Function1) objRememberedValue7;
                boolean zChangedInstance3 = gapComposer4.changedInstance(composeNavigator3) | (((((i5 & 29360128) ^ 12582912) <= 8388608 || !gapComposer4.changed(function4)) && (i5 & 12582912) != 8388608) ? false : z) | ((i5 & 458752) == 131072 ? z : false);
                Object objRememberedValue8 = gapComposer4.rememberedValue();
                if (zChangedInstance3 || objRememberedValue8 == neverEqualPolicy) {
                    final byte b2 = 1;
                    Function1 function7 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda8
                        /* JADX WARN: Code duplicated, block: B:21:0x0065  */
                        /* JADX WARN: Code duplicated, block: B:34:0x009a  */
                        /* JADX WARN: Code duplicated, block: B:53:0x00f7  */
                        /* JADX WARN: Code duplicated, block: B:66:0x012c  */
                        /* JADX WARN: Code duplicated, block: B:88:? A[RETURN, SYNTHETIC] */
                        /* JADX WARN: Code duplicated, block: B:90:? A[RETURN, SYNTHETIC] */
                        /* JADX WARN: Code duplicated, block: B:91:? A[RETURN, SYNTHETIC] */
                        /* JADX WARN: Code duplicated, block: B:93:? A[RETURN, SYNTHETIC] */
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj7) {
                            Function1 function8;
                            Function1 function9;
                            Function1 function10;
                            Function1 function11;
                            byte b3 = b2;
                            Object obj8 = null;
                            MutableState mutableState3 = mutableState2;
                            Function1 function12 = function2;
                            Function1 function13 = function4;
                            ComposeNavigator composeNavigator7 = composeNavigator3;
                            AnimatedContentTransitionScope animatedContentTransitionScope = (AnimatedContentTransitionScope) obj7;
                            switch (b3) {
                                case 0:
                                    NavDestination navDestination4 = ((NavBackStackEntry) animatedContentTransitionScope.getTargetState()).destination;
                                    navDestination4.getClass();
                                    ComposeNavigator.Destination destination = (ComposeNavigator.Destination) navDestination4;
                                    if (((Boolean) composeNavigator7.isPop.getValue()).booleanValue() || ((Boolean) mutableState3.getValue()).booleanValue()) {
                                        int i29 = NavDestination.$r8$clinit;
                                        for (NavDestination navDestination5 : FileSystemsKt.getHierarchy(destination)) {
                                            EnterTransitionImpl enterTransitionImpl = (!(navDestination5 instanceof ComposeNavigator.Destination) || (function8 = ((ComposeNavigator.Destination) navDestination5).popEnterTransition) == null) ? null : (EnterTransitionImpl) function8.invoke(animatedContentTransitionScope);
                                            if (enterTransitionImpl != null) {
                                                obj8 = enterTransitionImpl;
                                                if (obj8 == null) {
                                                    return (EnterTransitionImpl) function13.invoke(animatedContentTransitionScope);
                                                }
                                                return obj8;
                                            }
                                        }
                                        if (obj8 == null) {
                                            return (EnterTransitionImpl) function13.invoke(animatedContentTransitionScope);
                                        }
                                        return obj8;
                                    }
                                    int i30 = NavDestination.$r8$clinit;
                                    for (NavDestination navDestination6 : FileSystemsKt.getHierarchy(destination)) {
                                        EnterTransitionImpl enterTransitionImpl2 = (!(navDestination6 instanceof ComposeNavigator.Destination) || (function9 = ((ComposeNavigator.Destination) navDestination6).enterTransition) == null) ? null : (EnterTransitionImpl) function9.invoke(animatedContentTransitionScope);
                                        if (enterTransitionImpl2 != null) {
                                            obj8 = enterTransitionImpl2;
                                            if (obj8 == null) {
                                                return (EnterTransitionImpl) function12.invoke(animatedContentTransitionScope);
                                            }
                                            return obj8;
                                        }
                                    }
                                    if (obj8 == null) {
                                        return (EnterTransitionImpl) function12.invoke(animatedContentTransitionScope);
                                    }
                                    return obj8;
                                default:
                                    NavDestination navDestination7 = ((NavBackStackEntry) animatedContentTransitionScope.getInitialState()).destination;
                                    navDestination7.getClass();
                                    ComposeNavigator.Destination destination2 = (ComposeNavigator.Destination) navDestination7;
                                    if (((Boolean) composeNavigator7.isPop.getValue()).booleanValue() || ((Boolean) mutableState3.getValue()).booleanValue()) {
                                        int i31 = NavDestination.$r8$clinit;
                                        for (NavDestination navDestination8 : FileSystemsKt.getHierarchy(destination2)) {
                                            ExitTransitionImpl exitTransitionImpl = (!(navDestination8 instanceof ComposeNavigator.Destination) || (function10 = ((ComposeNavigator.Destination) navDestination8).popExitTransition) == null) ? null : (ExitTransitionImpl) function10.invoke(animatedContentTransitionScope);
                                            if (exitTransitionImpl != null) {
                                                obj8 = exitTransitionImpl;
                                                if (obj8 == null) {
                                                    return (ExitTransitionImpl) function13.invoke(animatedContentTransitionScope);
                                                }
                                                return obj8;
                                            }
                                        }
                                        if (obj8 == null) {
                                            return (ExitTransitionImpl) function13.invoke(animatedContentTransitionScope);
                                        }
                                        return obj8;
                                    }
                                    int i32 = NavDestination.$r8$clinit;
                                    for (NavDestination navDestination9 : FileSystemsKt.getHierarchy(destination2)) {
                                        ExitTransitionImpl exitTransitionImpl2 = (!(navDestination9 instanceof ComposeNavigator.Destination) || (function11 = ((ComposeNavigator.Destination) navDestination9).exitTransition) == null) ? null : (ExitTransitionImpl) function11.invoke(animatedContentTransitionScope);
                                        if (exitTransitionImpl2 != null) {
                                            obj8 = exitTransitionImpl2;
                                            if (obj8 == null) {
                                                return (ExitTransitionImpl) function12.invoke(animatedContentTransitionScope);
                                            }
                                            return obj8;
                                        }
                                    }
                                    if (obj8 == null) {
                                        return (ExitTransitionImpl) function12.invoke(animatedContentTransitionScope);
                                    }
                                    return obj8;
                            }
                        }
                    };
                    gapComposer4.updateRememberedValue(function7);
                    objRememberedValue8 = function7;
                }
                Function1 function8 = (Function1) objRememberedValue8;
                if ((i5 & 234881024) != 67108864) {
                    z = false;
                }
                Object objRememberedValue9 = gapComposer4.rememberedValue();
                if (z || objRememberedValue9 == neverEqualPolicy) {
                    objRememberedValue9 = new RoomDatabase$$ExternalSyntheticLambda2((byte) 12);
                    gapComposer4.updateRememberedValue(objRememberedValue9);
                }
                Function1 function9 = (Function1) objRememberedValue9;
                Boolean bool = Boolean.TRUE;
                boolean zChangedInstance4 = gapComposer4.changedInstance(composeNavigator3);
                Object objRememberedValue10 = gapComposer4.rememberedValue();
                if (zChangedInstance4 || objRememberedValue10 == neverEqualPolicy) {
                    objRememberedValue10 = new QuickJs$$ExternalSyntheticLambda1(state2, composeNavigator3, (byte) 6);
                    gapComposer4.updateRememberedValue(objRememberedValue10);
                }
                Stack.DisposableEffect(bool, (Function1) objRememberedValue10, gapComposer4);
                Object objRememberedValue11 = gapComposer4.rememberedValue();
                if (objRememberedValue11 == neverEqualPolicy) {
                    objRememberedValue11 = new SeekableTransitionState(navBackStackEntry3);
                    gapComposer4.updateRememberedValue(objRememberedValue11);
                }
                SeekableTransitionState seekableTransitionState2 = (SeekableTransitionState) objRememberedValue11;
                Transition transitionRememberTransition = ArcSplineKt.rememberTransition(seekableTransitionState2, "entry", gapComposer4, 56);
                if (((Boolean) mutableState2.getValue()).booleanValue()) {
                    gapComposer4.startReplaceGroup(-1795663766);
                    Float fValueOf = Float.valueOf(parcelableSnapshotMutableFloatState.getFloatValue());
                    boolean zChanged2 = gapComposer4.changed(mutableState) | gapComposer4.changedInstance(seekableTransitionState2);
                    Object objRememberedValue12 = gapComposer4.rememberedValue();
                    if (zChanged2 || objRememberedValue12 == neverEqualPolicy) {
                        composeNavigator2 = null;
                        objRememberedValue12 = new RealImageLoader.AnonymousClass2(seekableTransitionState2, mutableState, parcelableSnapshotMutableFloatState, false ? 1 : 0, (byte) 26, false);
                        gapComposer4.updateRememberedValue(objRememberedValue12);
                    } else {
                        composeNavigator2 = null;
                    }
                    Stack.LaunchedEffect(gapComposer4, fValueOf, (Function2) objRememberedValue12);
                    gapComposer4.end(false);
                    transition = transitionRememberTransition;
                    seekableTransitionState = seekableTransitionState2;
                } else {
                    composeNavigator2 = null;
                    boolean z4 = false;
                    gapComposer4.startReplaceGroup(-1795408729);
                    boolean zChangedInstance5 = gapComposer4.changedInstance(seekableTransitionState2) | gapComposer4.changedInstance(navBackStackEntry3) | gapComposer4.changed(transitionRememberTransition);
                    Object objRememberedValue13 = gapComposer4.rememberedValue();
                    if (zChangedInstance5 || objRememberedValue13 == neverEqualPolicy) {
                        transition = transitionRememberTransition;
                        seekableTransitionState = seekableTransitionState2;
                        objRememberedValue13 = new NavHostKt$NavHost$29$1((Object) seekableTransitionState, (Object) navBackStackEntry3, (Object) transition, (Continuation) (z4 ? 1 : 0), (byte) 0);
                        gapComposer4.updateRememberedValue(objRememberedValue13);
                    } else {
                        transition = transitionRememberTransition;
                        seekableTransitionState = seekableTransitionState2;
                    }
                    Stack.LaunchedEffect(gapComposer4, navBackStackEntry3, (Function2) objRememberedValue13);
                    gapComposer4.end(false);
                }
                boolean zChangedInstance6 = gapComposer4.changedInstance(mutableObjectFloatMap2) | gapComposer4.changedInstance(composeNavigator3) | gapComposer4.changed(function6) | gapComposer4.changed(function8) | gapComposer4.changed(function9);
                Object objRememberedValue14 = gapComposer4.rememberedValue();
                if (zChangedInstance6 || objRememberedValue14 == neverEqualPolicy) {
                    ComposeNavigator composeNavigator7 = composeNavigator3;
                    state = state2;
                    objRememberedValue14 = new NavHostKt$$ExternalSyntheticLambda12((Object) mutableObjectFloatMap2, (Object) composeNavigator7, (Object) function6, (Object) function8, (Object) function9, state, (State) mutableState2, (byte) 0);
                    mutableObjectFloatMap = mutableObjectFloatMap2;
                    composeNavigator4 = composeNavigator7;
                    gapComposer4.updateRememberedValue(objRememberedValue14);
                } else {
                    state = state2;
                    mutableObjectFloatMap = mutableObjectFloatMap2;
                    composeNavigator4 = composeNavigator3;
                }
                Function1 function10 = (Function1) objRememberedValue14;
                Object objRememberedValue15 = gapComposer4.rememberedValue();
                if (objRememberedValue15 == neverEqualPolicy) {
                    objRememberedValue15 = new RoomDatabase$$ExternalSyntheticLambda2((byte) 13);
                    gapComposer4.updateRememberedValue(objRememberedValue15);
                }
                State state3 = state;
                Transition transition2 = transition;
                CrossfadeKt.AnimatedContent(transition2, modifier, function10, alignment, (Function1) objRememberedValue15, Expect_jvmKt.rememberComposableLambda(820763100, new NavHostKt$NavHost$32((Object) seekableTransitionState, (Object) navBackStackEntry3, (Object) saveableStateHolderImplRememberSaveableStateHolder, (Object) mutableState2, (Object) state3, (byte) 0), gapComposer4), gapComposer4, ((i5 >> 3) & 112) | 221184 | (i5 & 7168));
                gapComposer2 = gapComposer4;
                Object currentState = transition2.transitionState.getCurrentState();
                Object value = transition2.targetState$delegate.getValue();
                boolean zChanged3 = gapComposer2.changed(transition2) | gapComposer2.changedInstance(navHostController) | gapComposer2.changedInstance(composeNavigator4) | gapComposer2.changedInstance(mutableObjectFloatMap);
                Object objRememberedValue16 = gapComposer2.rememberedValue();
                if (zChanged3 || objRememberedValue16 == neverEqualPolicy) {
                    NavHostKt$NavHost$33$1 navHostKt$NavHost$33$1 = new NavHostKt$NavHost$33$1(transition2, navHostController, mutableObjectFloatMap, state3, composeNavigator4, null, (byte) 0);
                    gapComposer2.updateRememberedValue(navHostKt$NavHost$33$1);
                    objRememberedValue16 = navHostKt$NavHost$33$1;
                }
                Stack.LaunchedEffect(currentState, value, (Function2) objRememberedValue16, gapComposer2);
                gapComposer2.end(false);
            } else {
                composeNavigator2 = composeNavigator;
                gapComposer2 = gapComposer4;
                gapComposer2.startReplaceGroup(-1790236038);
                gapComposer2.end(false);
            }
            Navigator navigator4 = navigatorProvider3.getNavigator("dialog");
            if (navigator4 instanceof DialogNavigator) {
                dialogNavigator2 = (DialogNavigator) navigator4;
            } else {
                dialogNavigator = composeNavigator2;
            }
            if (dialogNavigator == 0) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer2.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup2 == null) {
                    dialogNavigator = dialogNavigator2;
                    return;
                } else {
                    dialogNavigator = dialogNavigator2;
                    recomposeScopeImplEndRestartGroup2.block = new NavHostKt$$ExternalSyntheticLambda3(navHostController, navGraph, modifier, alignment, function1, function2, function3, function4, i, (byte) 0);
                    return;
                }
            }
            dialogNavigator = dialogNavigator2;
            SQLite.DialogHost(dialogNavigator, gapComposer2, 0);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup3 = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup3 != null) {
            recomposeScopeImplEndRestartGroup3.block = new NavHostKt$$ExternalSyntheticLambda3(navHostController, navGraph, modifier, alignment, function1, function2, function3, function4, i, (byte) 1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:70:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d0  */
    /* JADX INFO: renamed from: SelectionHandle-wLIcFTc, reason: not valid java name */
    public static final void m878SelectionHandlewLIcFTc(final OffsetProvider offsetProvider, final boolean z, final ResolvedTextDirection resolvedTextDirection, final boolean z2, long j, final float f, final Modifier modifier, Composer composer, final int i) {
        int i2;
        final long j2;
        int i3;
        long j3;
        boolean z3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-466280168);
        byte b = 2;
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? gapComposer.changed(offsetProvider) : gapComposer.changedInstance(offsetProvider) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(resolvedTextDirection.ordinal()) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= 8192;
        }
        if ((1572864 & i) == 0) {
            i2 |= gapComposer.changed(modifier) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if (gapComposer.shouldExecute(i2 & 1, (533651 & i2) != 533650)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                i3 = i2 & (-57345);
                j3 = 9205357640488583168L;
            } else {
                gapComposer.skipToGroupEnd();
                i3 = i2 & (-57345);
                j3 = j;
            }
            gapComposer.endDefaults();
            ResolvedTextDirection resolvedTextDirection2 = ResolvedTextDirection.Rtl;
            ResolvedTextDirection resolvedTextDirection3 = ResolvedTextDirection.Ltr;
            if (z) {
                SemanticsPropertyKey semanticsPropertyKey = SelectionHandlesKt.SelectionHandleInfoKey;
                if ((resolvedTextDirection != resolvedTextDirection3 || z2) && !(resolvedTextDirection == resolvedTextDirection2 && z2)) {
                    z3 = false;
                } else {
                    z3 = true;
                }
            } else {
                SemanticsPropertyKey semanticsPropertyKey2 = SelectionHandlesKt.SelectionHandleInfoKey;
                if ((resolvedTextDirection != resolvedTextDirection3 || z2) && !(resolvedTextDirection == resolvedTextDirection2 && z2)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
            }
            BiasAbsoluteAlignment biasAbsoluteAlignment = z3 ? ZIndexModifierKt.TopRight : ZIndexModifierKt.TopLeft;
            int i4 = i3 & 14;
            boolean zChanged = ((i3 & 112) == 32) | (i4 == 4 || ((i3 & 8) != 0 && gapComposer.changedInstance(offsetProvider))) | gapComposer.changed(z3);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new MainActivity$$ExternalSyntheticLambda50(offsetProvider, z, z3, b);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            final Modifier modifierSemantics = SemanticsModifierKt.semantics(modifier, false, (Function1) objRememberedValue);
            final ViewConfiguration viewConfiguration = (ViewConfiguration) gapComposer.consume(CompositionLocalsKt.LocalViewConfiguration);
            final boolean z4 = z3;
            j2 = j3;
            HandlePopup(offsetProvider, biasAbsoluteAlignment, Expect_jvmKt.rememberComposableLambda(1365123137, new Function2() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Composer composer2 = (Composer) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    GapComposer gapComposer2 = (GapComposer) composer2;
                    if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        Stack.CompositionLocalProvider(CompositionLocalsKt.LocalViewConfiguration.defaultProvidedValue$runtime(viewConfiguration), Expect_jvmKt.rememberComposableLambda(1260045569, new PlayerKt$$ExternalSyntheticLambda33(j2, z4, modifierSemantics, offsetProvider), gapComposer2), gapComposer2, 56);
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, i4 | 384);
        } else {
            gapComposer.skipToGroupEnd();
            j2 = j;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final long j4 = j2;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    FileSystemsKt.m878SelectionHandlewLIcFTc(offsetProvider, z, resolvedTextDirection, z2, j4, f, modifier, (Composer) obj, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void SelectionHandleIcon(final int i, Composer composer, final Modifier modifier, final Function0 function0, final boolean z) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(2111672474);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        int i3 = i2 | (gapComposer.changedInstance(function0) ? 32 : 16) | (gapComposer.changed(z) ? 256 : 128);
        byte b = 1;
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
            SemanticsPropertyKey semanticsPropertyKey = SelectionHandlesKt.SelectionHandleInfoKey;
            OffsetKt.Spacer(gapComposer, SizeKt.m152sizeVpY3zN4(modifier, 25.0f, 25.0f).then(new ComposedModifier(new ListenTogetherScreenKt$$ExternalSyntheticLambda72(b, function0, z))));
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    FileSystemsKt.SelectionHandleIcon(Stack.updateChangedFlags(i | 1), (Composer) obj, modifier, function0, z);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final XYZColorSpaceImpl XYZColorSpace(WhitePoint whitePoint) {
        whitePoint.getClass();
        if (whitePoint.equals(Illuminant.D65)) {
            return XYZColorSpaces.XYZ65;
        }
        return whitePoint.equals(Illuminant.D50) ? XYZColorSpaces.XYZ50 : new XYZColorSpaceImpl(whitePoint);
    }

    public static final GapAnchor asGapAnchor(GapAnchor gapAnchor) {
        if (!(gapAnchor instanceof GapAnchor)) {
            gapAnchor = null;
        }
        if (gapAnchor != null) {
            return gapAnchor;
        }
        ComposerKt.composeRuntimeError("Inconsistent composition");
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
        return null;
    }

    public static final Preferences$Key booleanKey(String str) {
        return new Preferences$Key(str);
    }

    public static void checkNonNegative(long j, String str) {
        if (j >= 0) {
            return;
        }
        throw new IllegalArgumentException(str + " (" + j + ") must be >= 0");
    }

    public static void checkRoundingUnnecessary(boolean z) {
        if (!z) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }

    public static final MutableState collectAsStateWithLifecycle(Flow flow, Object obj, Lifecycle lifecycle, Composer composer, int i) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        Object[] objArr = {flow, lifecycle, state, emptyCoroutineContext};
        GapComposer gapComposer = (GapComposer) composer;
        boolean zChangedInstance = ((((i & 7168) ^ 3072) > 2048 && gapComposer.changed(state.ordinal())) || (i & 3072) == 2048) | gapComposer.changedInstance(lifecycle) | gapComposer.changedInstance(emptyCoroutineContext) | gapComposer.changedInstance(flow);
        Object objRememberedValue = gapComposer.rememberedValue();
        Continuation continuation = null;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
            objRememberedValue = new RealImageLoader.AnonymousClass2(lifecycle, flow, continuation, (byte) 25);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        Function2 function2 = (Function2) objRememberedValue;
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = Stack.mutableStateOf$default(obj);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        MutableState mutableState = (MutableState) objRememberedValue2;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 4);
        boolean zChangedInstance2 = gapComposer.changedInstance(function2);
        Object objRememberedValue3 = gapComposer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
            objRememberedValue3 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(function2, mutableState, continuation, (byte) 3);
            gapComposer.updateRememberedValue(objRememberedValue3);
        }
        Stack.LaunchedEffect(objArrCopyOf, (Function2) objRememberedValue3, gapComposer);
        return mutableState;
    }

    public static final boolean containsInclusive(Rect rect, float f, float f2) {
        float f3 = rect.left;
        if (f > rect.right || f3 > f) {
            return false;
        }
        return f2 <= rect.bottom && rect.top <= f2;
    }

    public static void createFile$default(FileSystem fileSystem, Path path) {
        if (fileSystem.exists(path)) {
            return;
        }
        try {
            fileSystem.sink(path, false).close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0029  */
    public static final ImageBitmap createHandleImage(CacheDrawScope cacheDrawScope, float f) {
        int iCeil = ((int) Math.ceil(f)) * 2;
        AndroidImageBitmap androidImageBitmapM488ImageBitmapx__hDU$default = LifecyclesKt.imageBitmap;
        AndroidCanvas androidCanvasActualCanvas = LifecyclesKt.canvas;
        CanvasDrawScope canvasDrawScope = LifecyclesKt.canvasDrawScope;
        if (androidImageBitmapM488ImageBitmapx__hDU$default == null || androidCanvasActualCanvas == null) {
            androidImageBitmapM488ImageBitmapx__hDU$default = ColorKt.m488ImageBitmapx__hDU$default(iCeil, iCeil, 1, 24);
            LifecyclesKt.imageBitmap = androidImageBitmapM488ImageBitmapx__hDU$default;
            androidCanvasActualCanvas = AndroidCanvas_androidKt.ActualCanvas(androidImageBitmapM488ImageBitmapx__hDU$default);
            LifecyclesKt.canvas = androidCanvasActualCanvas;
        } else {
            Bitmap bitmap = androidImageBitmapM488ImageBitmapx__hDU$default.bitmap;
            if (iCeil > bitmap.getWidth() || iCeil > bitmap.getHeight()) {
                androidImageBitmapM488ImageBitmapx__hDU$default = ColorKt.m488ImageBitmapx__hDU$default(iCeil, iCeil, 1, 24);
                LifecyclesKt.imageBitmap = androidImageBitmapM488ImageBitmapx__hDU$default;
                androidCanvasActualCanvas = AndroidCanvas_androidKt.ActualCanvas(androidImageBitmapM488ImageBitmapx__hDU$default);
                LifecyclesKt.canvas = androidCanvasActualCanvas;
            }
        }
        AndroidImageBitmap androidImageBitmap = androidImageBitmapM488ImageBitmapx__hDU$default;
        AndroidCanvas androidCanvas = androidCanvasActualCanvas;
        if (canvasDrawScope == null) {
            canvasDrawScope = new CanvasDrawScope();
            LifecyclesKt.canvasDrawScope = canvasDrawScope;
        }
        CanvasDrawScope canvasDrawScope2 = canvasDrawScope;
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope2.drawParams;
        LayoutDirection layoutDirection = cacheDrawScope.cacheParams.getLayoutDirection();
        Bitmap bitmap2 = androidImageBitmap.bitmap;
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(bitmap2.getWidth())) << 32) | (((long) Float.floatToRawIntBits(bitmap2.getHeight())) & 4294967295L);
        Density density = drawParams.density;
        LayoutDirection layoutDirection2 = drawParams.layoutDirection;
        Canvas canvas = drawParams.canvas;
        long j = drawParams.size;
        drawParams.density = cacheDrawScope;
        drawParams.layoutDirection = layoutDirection;
        drawParams.canvas = androidCanvas;
        drawParams.size = jFloatToRawIntBits;
        androidCanvas.save();
        DrawScope.m550drawRectnJ9OG0$default(canvasDrawScope2, -72057594037927936L, 0L, canvasDrawScope2.mo556getSizeNHjbRc(), CropImageView.DEFAULT_ASPECT_RATIO, 0, 58);
        DrawScope.m550drawRectnJ9OG0$default(canvasDrawScope2, -72057594037927936L, 0L, (((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L), CropImageView.DEFAULT_ASPECT_RATIO, 0, 120);
        DrawScope.m543drawCircleVaOC9Bg$default(canvasDrawScope2, -72057594037927936L, f, (((long) Float.floatToRawIntBits(f)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32), null, 0, 120);
        androidCanvas.restore();
        drawParams.density = density;
        drawParams.layoutDirection = layoutDirection2;
        drawParams.canvas = canvas;
        drawParams.size = j;
        return androidImageBitmap;
    }

    public static final long currentThreadId() {
        return Thread.currentThread().getId();
    }

    public static final void deleteContents(FileSystem fileSystem, Path path) throws IOException {
        try {
            IOException iOException = null;
            for (Path path2 : fileSystem.list(path)) {
                try {
                    if (fileSystem.metadata(path2).isDirectory) {
                        deleteContents(fileSystem, path2);
                    }
                    fileSystem.delete(path2);
                } catch (IOException e) {
                    if (iOException == null) {
                        iOException = e;
                    }
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } catch (FileNotFoundException unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0069  */
    /* JADX WARN: Code duplicated, block: B:26:0x0080  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:41:0x00db  */
    /* JADX WARN: Code duplicated, block: B:47:0x00da A[SYNTHETIC] */
    public static Arrangement findLowestCostArrangement(float f, float f2, float f3, float f4, float f5, int[] iArr, float f6, int[] iArr2, float f7, int[] iArr3) {
        float f8;
        float fMax;
        float f9;
        float f10;
        Arrangement arrangement;
        Arrangement arrangement2 = null;
        int i = 1;
        for (int i2 : iArr3) {
            int length = iArr2.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = iArr2[i3];
                int length2 = iArr.length;
                int i5 = 0;
                while (i5 < length2) {
                    int i6 = length2;
                    int i7 = iArr[i5];
                    float f11 = f - ((((i2 + i4) + i7) - 1) * f2);
                    float fCoerceIn = UuidKt.coerceIn(f3, f4, f5);
                    float f12 = i2;
                    float f13 = i4;
                    float f14 = f6 * f13;
                    float f15 = i7;
                    float f16 = f11 - ((fCoerceIn * f15) + (f14 + (f7 * f12)));
                    if (i7 <= 0 || f16 <= CropImageView.DEFAULT_ASPECT_RATIO) {
                        f8 = f15;
                        if (i7 > 0 && f16 < CropImageView.DEFAULT_ASPECT_RATIO) {
                            fMax = Math.max(f16 / f8, f4 - fCoerceIn);
                        }
                        if (i7 <= 0) {
                            fCoerceIn = 0.0f;
                        }
                        float f17 = f13 / 2.0f;
                        float f18 = (f11 - ((f8 + f17) * fCoerceIn)) / (f17 + f12);
                        f9 = (f18 + fCoerceIn) / 2.0f;
                        if (i4 <= 0 && f18 != f7) {
                            float f19 = (f7 - f18) * f12;
                            float fMin = Math.min(Math.abs(f19), 0.1f * f9 * f13);
                            if (f19 > CropImageView.DEFAULT_ASPECT_RATIO) {
                                f10 = f9 - (fMin / f13);
                                f18 += fMin / f12;
                            } else {
                                f10 = (fMin / f13) + f9;
                                f18 -= fMin / f12;
                            }
                        }
                        int i8 = i2;
                        int i9 = i5;
                        int i10 = length;
                        int i11 = i;
                        arrangement = new Arrangement(i11, fCoerceIn, i7, f10, i4, f18, i8);
                        if (arrangement2 != null || arrangement.cost(f7) < arrangement2.cost(f7)) {
                            if (arrangement.cost(f7) == CropImageView.DEFAULT_ASPECT_RATIO) {
                                return arrangement;
                            }
                            arrangement2 = arrangement;
                        }
                        i = i11 + 1;
                        i5 = i9 + 1;
                        length = i10;
                        length2 = i6;
                        i3 = i3;
                        i2 = i8;
                        iArr = iArr;
                    } else {
                        f8 = f15;
                        fMax = Math.min(f16 / f8, f5 - fCoerceIn);
                    }
                    fCoerceIn = fMax + fCoerceIn;
                    if (i7 <= 0) {
                        fCoerceIn = 0.0f;
                    }
                    float f110 = f13 / 2.0f;
                    float f111 = (f11 - ((f8 + f110) * fCoerceIn)) / (f110 + f12);
                    f9 = (f111 + fCoerceIn) / 2.0f;
                    f10 = i4 <= 0 ? f9 : f9;
                    int i12 = i2;
                    int i13 = i5;
                    int i14 = length;
                    int i15 = i;
                    arrangement = new Arrangement(i15, fCoerceIn, i7, f10, i4, f111, i12);
                    if (arrangement2 != null) {
                        if (arrangement.cost(f7) == CropImageView.DEFAULT_ASPECT_RATIO) {
                            return arrangement;
                        }
                        arrangement2 = arrangement;
                    } else {
                        if (arrangement.cost(f7) == CropImageView.DEFAULT_ASPECT_RATIO) {
                            return arrangement;
                        }
                        arrangement2 = arrangement;
                    }
                    i = i15 + 1;
                    i5 = i13 + 1;
                    length = i14;
                    length2 = i6;
                    i3 = i3;
                    i2 = i12;
                    iArr = iArr;
                }
                i3++;
                iArr2 = iArr2;
                length = length;
                iArr = iArr;
            }
        }
        return arrangement2;
    }

    /* JADX INFO: renamed from: fitPrioritizingHeight-Zbe2FdA, reason: not valid java name */
    public static long m879fitPrioritizingHeightZbe2FdA(int i, int i2, int i3, int i4) {
        int i5 = 262142;
        int iMin = Math.min(i3, 262142);
        int iMin2 = i4 == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(i4, 262142);
        int i6 = iMin2 == Integer.MAX_VALUE ? iMin : iMin2;
        if (i6 >= 8191) {
            if (i6 < 32767) {
                i5 = 65534;
            } else if (i6 < 65535) {
                i5 = 32766;
            } else {
                if (i6 >= 262143) {
                    ConstraintsKt.throwInvalidConstraintsSizeException(i6);
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                    return 0L;
                }
                i5 = 8190;
            }
        }
        return ConstraintsKt.Constraints(Math.min(i5, i), i2 != Integer.MAX_VALUE ? Math.min(i5, i2) : Integer.MAX_VALUE, iMin, iMin2);
    }

    /* JADX INFO: renamed from: fitPrioritizingWidth-Zbe2FdA, reason: not valid java name */
    public static long m880fitPrioritizingWidthZbe2FdA(int i, int i2, int i3, int i4) {
        int i5 = 262142;
        int iMin = Math.min(i, 262142);
        int iMin2 = i2 == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(i2, 262142);
        int i6 = iMin2 == Integer.MAX_VALUE ? iMin : iMin2;
        if (i6 >= 8191) {
            if (i6 < 32767) {
                i5 = 65534;
            } else if (i6 < 65535) {
                i5 = 32766;
            } else {
                if (i6 >= 262143) {
                    ConstraintsKt.throwInvalidConstraintsSizeException(i6);
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                    return 0L;
                }
                i5 = 8190;
            }
        }
        return ConstraintsKt.Constraints(iMin, iMin2, Math.min(i5, i3), i4 != Integer.MAX_VALUE ? Math.min(i5, i4) : Integer.MAX_VALUE);
    }

    public static final Preferences$Key floatKey(String str) {
        return new Preferences$Key(str);
    }

    /* JADX INFO: renamed from: getCenter-uvyYCjk, reason: not valid java name */
    public static final long m881getCenteruvyYCjk(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) / 2.0f;
        return (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) / 2.0f)) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
    }

    public static final int getColumnIndexOrThrow(SQLiteStatement sQLiteStatement, String str) {
        sQLiteStatement.getClass();
        int iColumnIndexOf = LifecyclesKt.columnIndexOf(sQLiteStatement, str);
        if (iColumnIndexOf >= 0) {
            return iColumnIndexOf;
        }
        int columnCount = sQLiteStatement.getColumnCount();
        ArrayList arrayList = new ArrayList(columnCount);
        for (int i = 0; i < columnCount; i++) {
            arrayList.add(sQLiteStatement.getColumnName(i));
        }
        DifferentialMotionFlingController$$ExternalSyntheticLambda0.m("Column '", str, "' does not exist. Available columns: [", CollectionsKt.joinToString$default(arrayList, null, null, null, null, 63), 93);
        return 0;
    }

    public static String getDisplayName(NavContext navContext, int i) {
        navContext.getClass();
        if (i <= 16777215) {
            return String.valueOf(i);
        }
        try {
            Context context = navContext.context;
            context.getClass();
            String resourceName = context.getResources().getResourceName(i);
            resourceName.getClass();
            return resourceName;
        } catch (Resources.NotFoundException unused) {
            return String.valueOf(i);
        }
    }

    public static Sequence getHierarchy(NavDestination navDestination) {
        navDestination.getClass();
        return SequencesKt.generateSequence(navDestination, new RoomDatabase$$ExternalSyntheticLambda2((byte) 9));
    }

    public static final int getMainAxisViewportSize(PagerMeasureResult pagerMeasureResult) {
        return (int) (pagerMeasureResult.orientation == Orientation.Vertical ? pagerMeasureResult.m179getViewportSizeYbymL2g() & 4294967295L : pagerMeasureResult.m179getViewportSizeYbymL2g() >> 32);
    }

    public static int indexOf(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 32) {
            return 5;
        }
        if (i == 64) {
            return 6;
        }
        if (i == 128) {
            return 7;
        }
        if (i == 256) {
            return 8;
        }
        if (i == 512) {
            return 9;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i, "type needs to be >= FIRST and <= LAST, type="));
        return 0;
    }

    public static final int indexSegment(int i, int i2) {
        return (i >> i2) & 31;
    }

    public static final Object[] insertEntryAtIndex(Object[] objArr, int i, Object obj, Object obj2) {
        Object[] objArr2 = new Object[objArr.length + 2];
        ArraysKt.copyInto$default(0, i, 6, objArr, objArr2);
        ArraysKt.copyInto(i + 2, i, objArr.length, objArr, objArr2);
        objArr2[i] = obj;
        objArr2[i + 1] = obj2;
        return objArr2;
    }

    public static final Preferences$Key intKey(String str) {
        return new Preferences$Key(str);
    }

    public static final void keyOrValueNotFoundError(String str) {
        str.getClass();
        throw new IllegalArgumentException(IntIntPair$$ExternalSyntheticOutline0.m("No valid saved state was found for the key '", str, "'. It may be missing, null, or not of the expected type. This can occur if the value was saved with a different type or if the saved state was modified unexpectedly."));
    }

    public static final Preferences$Key longKey(String str) {
        return new Preferences$Key(str);
    }

    public static float lookupAndInterpolate(float f, float[] fArr, float[] fArr2) {
        float f2;
        float f3;
        float f4;
        float f5;
        float fAbs = Math.abs(f);
        float fSignum = Math.signum(f);
        int iBinarySearch = Arrays.binarySearch(fArr, fAbs);
        if (iBinarySearch >= 0) {
            return fSignum * fArr2[iBinarySearch];
        }
        int i = -(iBinarySearch + 1);
        int i2 = i - 1;
        if (i2 >= fArr.length - 1) {
            float f6 = fArr[fArr.length - 1];
            return f6 == CropImageView.DEFAULT_ASPECT_RATIO ? CropImageView.DEFAULT_ASPECT_RATIO : (fArr2[fArr.length - 1] / f6) * f;
        }
        if (i2 == -1) {
            float f7 = fArr[0];
            f4 = fArr2[0];
            f5 = f7;
            f3 = 0.0f;
            f2 = 0.0f;
        } else {
            float f8 = fArr[i2];
            float f9 = fArr[i];
            f2 = fArr2[i2];
            f3 = f8;
            f4 = fArr2[i];
            f5 = f9;
        }
        return (((f4 - f2) * Math.max(CropImageView.DEFAULT_ASPECT_RATIO, Math.min(1.0f, f3 == f5 ? 0.0f : (fAbs - f3) / (f5 - f3)))) + f2) * fSignum;
    }

    /* JADX WARN: Code duplicated, block: B:117:0x02c1 A[PHI: r14 r15
      0x02c1: PHI (r14v4 java.util.List) = (r14v3 java.util.List), (r14v5 java.util.List) binds: [B:103:0x0275, B:116:0x02bf] A[DONT_GENERATE, DONT_INLINE]
      0x02c1: PHI (r15v6 int) = (r15v5 int), (r15v7 int) binds: [B:103:0x0275, B:116:0x02bf] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:119:0x02c5 A[LOOP:3: B:102:0x0267->B:119:0x02c5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:120:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:182:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:187:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:191:0x03e7  */
    /* JADX WARN: Code duplicated, block: B:194:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:196:0x03f8 A[LOOP:5: B:195:0x03f6->B:196:0x03f8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:205:0x043a  */
    /* JADX WARN: Code duplicated, block: B:210:0x0450  */
    /* JADX WARN: Code duplicated, block: B:236:0x02cd A[EDGE_INSN: B:236:0x02cd->B:121:0x02cd BREAK  A[LOOP:3: B:102:0x0267->B:119:0x02c5], SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:196:0x03f8, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v17, types: [boolean] */
    /* JADX WARN: Type inference failed for: r38v0 */
    /* JADX WARN: Type inference failed for: r38v1, types: [int] */
    /* JADX WARN: Type inference failed for: r38v12 */
    /* JADX WARN: Type inference failed for: r42v0, types: [android.view.ViewStructure] */
    public static final void populate(ViewStructure viewStructure, LayoutNode layoutNode, AutofillId autofillId, String str, RectManager rectManager) {
        ?? r38;
        long j;
        long j2;
        char c;
        long j3;
        boolean zBooleanValue;
        AndroidContentDataType androidContentDataType;
        AnnotatedString annotatedString;
        AndroidFillableData androidFillableData;
        ToggleableState toggleableState;
        Role role;
        boolean z;
        ContentType contentType;
        Boolean bool;
        boolean z2;
        Integer num;
        Object obj;
        List list;
        Integer numValueOf;
        boolean z3;
        boolean z4;
        boolean z5;
        String strM713toLegacyClassNameV4PA4sw;
        int size;
        String str2;
        int i;
        String[] contentHints;
        String[] contentHints2;
        int i2;
        int i3;
        int i4;
        boolean z6;
        AndroidContentDataType androidContentDataType2;
        ToggleableState toggleableState2;
        AnnotatedString annotatedString2;
        AndroidFillableData androidFillableData2;
        Role role2;
        boolean z7;
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.ContentDescription;
        SemanticsPropertyKey semanticsPropertyKey2 = SemanticsActions.GetTextLayoutResult;
        SemanticsConfiguration semanticsConfiguration = layoutNode.getSemanticsConfiguration();
        boolean z8 = true;
        if (semanticsConfiguration != null) {
            MutableScatterMap mutableScatterMap = semanticsConfiguration.props;
            j = 128;
            Object[] objArr = mutableScatterMap.keys;
            Object[] objArr2 = mutableScatterMap.values;
            long[] jArr = mutableScatterMap.metadata;
            j2 = 255;
            int length = jArr.length - 2;
            if (length >= 0) {
                zBooleanValue = true;
                int i5 = 0;
                androidContentDataType2 = null;
                z = false;
                toggleableState2 = null;
                annotatedString2 = null;
                androidFillableData2 = null;
                contentType = null;
                bool = null;
                role2 = null;
                z2 = false;
                num = null;
                obj = null;
                c = 7;
                while (true) {
                    long j4 = jArr[i5];
                    j3 = -9187201950435737472L;
                    if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i6 = 8 - ((~(i5 - length)) >>> 31);
                        int i7 = 0;
                        while (i7 < i6) {
                            if ((j4 & 255) < 128) {
                                int i8 = (i5 << 3) + i7;
                                Object obj2 = objArr[i8];
                                Object obj3 = objArr2[i8];
                                SemanticsPropertyKey semanticsPropertyKey3 = (SemanticsPropertyKey) obj2;
                                if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsProperties.ContentDataType)) {
                                    obj3.getClass();
                                    androidContentDataType2 = (AndroidContentDataType) obj3;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsProperties.ContentDescription)) {
                                    obj3.getClass();
                                    String str3 = (String) CollectionsKt.firstOrNull((List) obj3);
                                    if (str3 != null) {
                                        viewStructure.setContentDescription(str3);
                                    }
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsProperties.ContentType)) {
                                    obj3.getClass();
                                    contentType = (ContentType) obj3;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsProperties.FillableData)) {
                                    obj3.getClass();
                                    androidFillableData2 = (AndroidFillableData) obj3;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsProperties.EditableText)) {
                                    obj3.getClass();
                                    annotatedString2 = (AnnotatedString) obj3;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsProperties.Focused)) {
                                    obj3.getClass();
                                    viewStructure.setFocused(((Boolean) obj3).booleanValue());
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsProperties.MaxTextLength)) {
                                    obj3.getClass();
                                    num = (Integer) obj3;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsProperties.Password)) {
                                    z2 = z8;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsProperties.IsSensitiveData)) {
                                    obj3.getClass();
                                    zBooleanValue = ((Boolean) obj3).booleanValue();
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsProperties.Role)) {
                                    obj3.getClass();
                                    role2 = (Role) obj3;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsProperties.Selected)) {
                                    obj3.getClass();
                                    bool = (Boolean) obj3;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsProperties.ToggleableState)) {
                                    obj3.getClass();
                                    toggleableState2 = (ToggleableState) obj3;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsActions.OnClick)) {
                                    viewStructure.setClickable(z8);
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsActions.OnLongClick)) {
                                    viewStructure.setLongClickable(z8);
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsActions.RequestFocus)) {
                                    viewStructure.setFocusable(z8);
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsActions.SetText)) {
                                    z = z8;
                                }
                                z7 = z8;
                                if (Build.VERSION.SDK_INT >= 34 && Intrinsics.areEqual(semanticsPropertyKey3, SemanticsNodeKt.CredentialRequest)) {
                                    obj = obj3;
                                }
                            } else {
                                z7 = z8;
                            }
                            j4 >>= 8;
                            i7++;
                            z8 = z7;
                        }
                        z6 = z8;
                        z6 = z6;
                        if (i6 != 8) {
                            break;
                        }
                    } else {
                        z6 = z8 ? 1 : 0;
                    }
                    if (i5 == length) {
                        break;
                    }
                    i5++;
                    z8 = z6 ? 1 : 0;
                }
            } else {
                z6 = true;
                c = 7;
                j3 = -9187201950435737472L;
                zBooleanValue = true;
                androidContentDataType2 = null;
                z = false;
                toggleableState2 = null;
                annotatedString2 = null;
                androidFillableData2 = null;
                contentType = null;
                bool = null;
                role2 = null;
                z2 = false;
                num = null;
                obj = null;
            }
            androidContentDataType = androidContentDataType2;
            toggleableState = toggleableState2;
            annotatedString = annotatedString2;
            androidFillableData = androidFillableData2;
            role = role2;
            r38 = z6;
        } else {
            r38 = 1;
            j = 128;
            j2 = 255;
            c = 7;
            j3 = -9187201950435737472L;
            zBooleanValue = true;
            androidContentDataType = null;
            annotatedString = null;
            androidFillableData = null;
            toggleableState = null;
            role = null;
            z = false;
            contentType = null;
            bool = null;
            z2 = false;
            num = null;
            obj = null;
        }
        SemanticsConfiguration semanticsConfiguration2 = layoutNode.getSemanticsConfiguration();
        if (semanticsConfiguration2 != null && semanticsConfiguration2.isMergingSemanticsOfDescendants && !semanticsConfiguration2.isClearingSemantics) {
            SemanticsConfiguration semanticsConfiguration3 = new SemanticsConfiguration();
            semanticsConfiguration3.isMergingSemanticsOfDescendants = semanticsConfiguration2.isMergingSemanticsOfDescendants;
            semanticsConfiguration3.isClearingSemantics = semanticsConfiguration2.isClearingSemantics;
            semanticsConfiguration3.props.putAll(semanticsConfiguration2.props);
            MutableObjectList mutableObjectList = new MutableObjectList(((MutableVector) ((MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui()).objectList).size);
            mutableObjectList.addAll(layoutNode.getChildren$ui());
            while (mutableObjectList.isNotEmpty()) {
                LayoutNode layoutNode2 = (LayoutNode) mutableObjectList.removeAt(mutableObjectList._size - 1);
                SemanticsConfiguration semanticsConfiguration4 = layoutNode2.getSemanticsConfiguration();
                if (semanticsConfiguration4 != null && !semanticsConfiguration4.isMergingSemanticsOfDescendants) {
                    semanticsConfiguration3.mergeChild$ui(semanticsConfiguration4);
                    if (!semanticsConfiguration4.isClearingSemantics) {
                        mutableObjectList.addAll(layoutNode2.getChildren$ui());
                    }
                }
            }
            semanticsConfiguration2 = semanticsConfiguration3;
        }
        if (semanticsConfiguration2 != null) {
            MutableScatterMap mutableScatterMap2 = semanticsConfiguration2.props;
            Object[] objArr3 = mutableScatterMap2.keys;
            Object[] objArr4 = mutableScatterMap2.values;
            long[] jArr2 = mutableScatterMap2.metadata;
            int length2 = jArr2.length - 2;
            if (length2 >= 0) {
                int i9 = 8;
                list = null;
                int i10 = 0;
                while (true) {
                    long j5 = jArr2[i10];
                    long[] jArr3 = jArr2;
                    Object[] objArr5 = objArr3;
                    if ((((~j5) << c) & j5 & j3) == j3) {
                        i2 = i10;
                        if (i2 != length2) {
                            break;
                            break;
                        } else {
                            i10 = i2 + 1;
                            objArr3 = objArr5;
                            jArr2 = jArr3;
                        }
                    } else {
                        int i11 = 8 - ((~(i10 - length2)) >>> 31);
                        int i12 = 0;
                        while (i12 < i11) {
                            if ((j5 & j2) < j) {
                                int i13 = (i10 << 3) + i12;
                                Object obj4 = objArr5[i13];
                                Object obj5 = objArr4[i13];
                                i4 = i9;
                                SemanticsPropertyKey semanticsPropertyKey4 = (SemanticsPropertyKey) obj4;
                                i3 = i12;
                                if (Intrinsics.areEqual(semanticsPropertyKey4, SemanticsProperties.Disabled)) {
                                    viewStructure.setEnabled(false);
                                } else if (Intrinsics.areEqual(semanticsPropertyKey4, SemanticsProperties.Text)) {
                                    obj5.getClass();
                                    list = (List) obj5;
                                }
                            } else {
                                i3 = i12;
                                i4 = i9;
                            }
                            j5 >>= i4;
                            i12 = i3 + 1;
                            i9 = i4;
                        }
                        if (i11 != i9) {
                            break;
                        }
                        i2 = i10;
                        if (i2 != length2) {
                            break;
                        }
                        i10 = i2 + 1;
                        objArr3 = objArr5;
                        jArr2 = jArr3;
                    }
                }
            } else {
                list = null;
            }
        } else {
            list = null;
        }
        Integer numValueOf2 = Integer.valueOf(layoutNode.semanticsId);
        if (layoutNode.getParent$ui() == null) {
            numValueOf2 = null;
        }
        int iIntValue = numValueOf2 != null ? numValueOf2.intValue() : -1;
        viewStructure.setAutofillId(autofillId, iIntValue);
        viewStructure.setId(iIntValue, str, null, null);
        if (androidContentDataType != null) {
            numValueOf = Integer.valueOf(androidContentDataType.androidAutofillType);
        } else if (z) {
            numValueOf = Integer.valueOf((int) r38);
        } else {
            numValueOf = toggleableState != null ? 2 : null;
        }
        if (numValueOf != null) {
            viewStructure.setAutofillType(numValueOf.intValue());
        }
        if (annotatedString != null) {
            viewStructure.setAutofillValue(AutofillValue.forText(IntMath.trimToSafeLength(annotatedString.text)));
        }
        if (androidFillableData != null) {
            viewStructure.setAutofillValue(androidFillableData.autofillValue);
        }
        if (contentType != null && (contentHints2 = MathKt.getContentHints(contentType)) != null) {
            viewStructure.setAutofillHints(contentHints2);
        }
        LayoutNode layoutNode3 = (LayoutNode) rectManager.layoutNodes.get(layoutNode.semanticsId);
        if (layoutNode3 != null && layoutNode3.rectListIndex != -4) {
            StatusLine statusLine = rectManager.rects;
            int iIndexInRectList = rectManager.indexInRectList(layoutNode3);
            long[] jArr4 = (long[]) statusLine.protocol;
            long j6 = jArr4[iIndexInRectList];
            long j7 = jArr4[iIndexInRectList + 1];
            int i14 = (int) (j6 >> 32);
            int i15 = (int) j6;
            viewStructure.setDimens(i14, i15, 0, 0, ((int) (j7 >> 32)) - i14, ((int) j7) - i15);
        }
        if (bool != null) {
            viewStructure.setSelected(bool.booleanValue());
        }
        if (toggleableState != null) {
            viewStructure.setCheckable(r38);
            viewStructure.setChecked(toggleableState == ToggleableState.On);
        } else if (bool != null && (role == null || role.value != 4)) {
            viewStructure.setCheckable(true);
            viewStructure.setChecked(bool.booleanValue());
        }
        ContentType.Companion.getClass();
        String[] contentHints3 = MathKt.getContentHints(ContentType.Companion.Password);
        contentHints3.getClass();
        if (contentHints3.length == 0) {
            PathKt$$ExternalSyntheticBUOutline0.m$1("Array is empty.");
            return;
        }
        String str4 = contentHints3[0];
        if (contentType != null && (contentHints = MathKt.getContentHints(contentType)) != null) {
            boolean zContains = ArraysKt.contains(contentHints, str4);
            z3 = true;
            boolean z9 = zContains;
            if (!z2 || z9) {
                z4 = z3;
            } else {
                z4 = false;
            }
            if (!z4 || zBooleanValue) {
                z5 = z3;
            } else {
                z5 = false;
            }
            viewStructure.setDataIsSensitive(z5);
            viewStructure.setVisibility(((NodeCoordinator) layoutNode.nodes.outerCoordinator).isTransparent() ? 4 : 0);
            if (list != null) {
                size = list.size();
                str2 = "";
                for (i = 0; i < size; i++) {
                    str2 = ((Object) str2) + ((AnnotatedString) list.get(i)).text + "\n";
                }
                viewStructure.setText(str2);
                viewStructure.setClassName("android.widget.TextView");
            }
            if (((MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui()).isEmpty() && role != null && (strM713toLegacyClassNameV4PA4sw = InvertMatrixKt.m713toLegacyClassNameV4PA4sw(role.value)) != null) {
                viewStructure.setClassName(strM713toLegacyClassNameV4PA4sw);
            }
            if (z) {
                viewStructure.setClassName("android.widget.EditText");
                if (Build.VERSION.SDK_INT >= 28 && num != null) {
                    HandlerCompat$Api28Impl.setMaxTextLength(viewStructure, num.intValue());
                }
                if (z4) {
                    viewStructure.setInputType(129);
                }
            }
            if (Build.VERSION.SDK_INT >= 35 || obj == null) {
            }
            PathKt$$ExternalSyntheticBUOutline0.m();
            return;
        }
        z3 = true;
        if (z2) {
            z4 = z3;
        } else {
            z4 = z3;
        }
        if (z4) {
            z5 = z3;
        } else {
            z5 = z3;
        }
        viewStructure.setDataIsSensitive(z5);
        viewStructure.setVisibility(((NodeCoordinator) layoutNode.nodes.outerCoordinator).isTransparent() ? 4 : 0);
        if (list != null) {
            size = list.size();
            str2 = "";
            while (i < size) {
                str2 = ((Object) str2) + ((AnnotatedString) list.get(i)).text + "\n";
            }
            viewStructure.setText(str2);
            viewStructure.setClassName("android.widget.TextView");
        }
        if (((MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui()).isEmpty()) {
            viewStructure.setClassName(strM713toLegacyClassNameV4PA4sw);
        }
        if (z) {
            viewStructure.setClassName("android.widget.EditText");
            if (Build.VERSION.SDK_INT >= 28) {
                HandlerCompat$Api28Impl.setMaxTextLength(viewStructure, num.intValue());
            }
            if (z4) {
                viewStructure.setInputType(129);
            }
        }
        if (Build.VERSION.SDK_INT >= 35) {
        }
    }

    public static Object readTypedObject(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static final Object[] removeEntryAtIndex(int i, Object[] objArr) {
        Object[] objArr2 = new Object[objArr.length - 2];
        ArraysKt.copyInto$default(0, i, 6, objArr, objArr2);
        ArraysKt.copyInto(i, i + 2, objArr.length, objArr, objArr2);
        return objArr2;
    }

    public static final Object[] removeNodeAtIndex(int i, Object[] objArr) {
        Object[] objArr2 = new Object[objArr.length - 1];
        ArraysKt.copyInto$default(0, i, 6, objArr, objArr2);
        ArraysKt.copyInto(i, i + 1, objArr.length, objArr, objArr2);
        return objArr2;
    }

    public static final Preferences$Key stringKey(String str) {
        return new Preferences$Key(str);
    }

    public static Icon toIcon(IconCompat iconCompat, Context context) {
        Icon iconCreateWithBitmap;
        InputStream inputStreamOpenInputStream;
        int i = iconCompat.mType;
        String resPackage = null;
        switch (i) {
            case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                return (Icon) iconCompat.mObj1;
            case 0:
            default:
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Unknown type");
                return null;
            case 1:
                iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.mObj1);
                break;
            case 2:
                if (i == -1) {
                    Object obj = iconCompat.mObj1;
                    if (Build.VERSION.SDK_INT >= 28) {
                        resPackage = HandlerCompat$Api28Impl.getResPackage(obj);
                    } else {
                        try {
                            resPackage = (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
                        } catch (IllegalAccessException e) {
                            Log.e("IconCompat", "Unable to get icon package", e);
                        } catch (NoSuchMethodException e2) {
                            Log.e("IconCompat", "Unable to get icon package", e2);
                        } catch (InvocationTargetException e3) {
                            Log.e("IconCompat", "Unable to get icon package", e3);
                        }
                    }
                } else {
                    if (i != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1(iconCompat, "called getResPackage() on ");
                        return null;
                    }
                    String str = iconCompat.mString1;
                    resPackage = (str == null || TextUtils.isEmpty(str)) ? ((String) iconCompat.mObj1).split(ServerSentEventKt.COLON, -1)[0] : iconCompat.mString1;
                }
                iconCreateWithBitmap = Icon.createWithResource(resPackage, iconCompat.mInt1);
                break;
            case 3:
                iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.mObj1, iconCompat.mInt1, iconCompat.mInt2);
                break;
            case 4:
                iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.mObj1);
                break;
            case 5:
                iconCreateWithBitmap = Icon.createWithAdaptiveBitmap((Bitmap) iconCompat.mObj1);
                break;
            case 6:
                if (Build.VERSION.SDK_INT >= 30) {
                    iconCreateWithBitmap = BuildCompat.Api30Impl.createWithAdaptiveBitmapContentUri(iconCompat.getUri());
                } else {
                    if (context == null) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2(iconCompat.getUri(), "Context is required to resolve the file uri of the icon: ");
                        return null;
                    }
                    Uri uri = iconCompat.getUri();
                    String scheme = uri.getScheme();
                    if ("content".equals(scheme) || "file".equals(scheme)) {
                        try {
                            inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                        } catch (Exception e4) {
                            Log.w("IconCompat", "Unable to load image from URI: " + uri, e4);
                            inputStreamOpenInputStream = null;
                        }
                    } else {
                        try {
                            inputStreamOpenInputStream = new FileInputStream(new File((String) iconCompat.mObj1));
                        } catch (FileNotFoundException e5) {
                            Log.w("IconCompat", "Unable to load image from path: " + uri, e5);
                            inputStreamOpenInputStream = null;
                        }
                    }
                    if (inputStreamOpenInputStream == null) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(iconCompat.getUri(), "Cannot load adaptive icon from uri: ");
                        return null;
                    }
                    iconCreateWithBitmap = Icon.createWithAdaptiveBitmap(BitmapFactory.decodeStream(inputStreamOpenInputStream));
                }
                break;
        }
        ColorStateList colorStateList = iconCompat.mTintList;
        if (colorStateList != null) {
            iconCreateWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = iconCompat.mTintMode;
        if (mode != IconCompat.DEFAULT_TINT_MODE) {
            iconCreateWithBitmap.setTintMode(mode);
        }
        return iconCreateWithBitmap;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x009b  */
    /* JADX WARN: Code duplicated, block: B:32:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public static final EngineInterceptor.ExecuteResult transform(EngineInterceptor.ExecuteResult executeResult, ImageRequest imageRequest, Options options, EventListener$Companion$NONE$1 eventListener$Companion$NONE$1, ContinuationImpl continuationImpl) {
        EngineInterceptorKt$transform$1 engineInterceptorKt$transform$1;
        List list;
        int i;
        boolean z;
        Bitmap bitmapConvertToBitmap;
        int size;
        Bitmap bitmap;
        EventListener$Companion$NONE$1 eventListener$Companion$NONE$2;
        EngineInterceptor.ExecuteResult executeResult2 = executeResult;
        ImageRequest imageRequest2 = imageRequest;
        Options options2 = options;
        if (continuationImpl instanceof EngineInterceptorKt$transform$1) {
            engineInterceptorKt$transform$1 = (EngineInterceptorKt$transform$1) continuationImpl;
            int i2 = engineInterceptorKt$transform$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                engineInterceptorKt$transform$1.label = i2 - Integer.MIN_VALUE;
            } else {
                engineInterceptorKt$transform$1 = new EngineInterceptorKt$transform$1(continuationImpl);
            }
        } else {
            engineInterceptorKt$transform$1 = new EngineInterceptorKt$transform$1(continuationImpl);
        }
        Object obj = engineInterceptorKt$transform$1.result;
        int i3 = engineInterceptorKt$transform$1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            list = (List) UriKt.getExtra(imageRequest2, ImageRequestsKt.transformationsKey);
            if (list.isEmpty()) {
                return executeResult2;
            }
            Image image = executeResult2.image;
            boolean z2 = image instanceof BitmapImage;
            if (!z2 && !((Boolean) UriKt.getExtra(imageRequest2, ImageRequestsKt.allowConversionToBitmapKey)).booleanValue()) {
                return executeResult2;
            }
            i = 0;
            if (z2) {
                Bitmap bitmap2 = ((BitmapImage) image).bitmap;
                Bitmap.Config config = bitmap2.getConfig();
                if (config == null) {
                    config = Bitmap.Config.ARGB_8888;
                }
                if (ArraysKt.contains(Utils_androidKt.VALID_TRANSFORMATION_CONFIGS, config)) {
                    bitmapConvertToBitmap = bitmap2;
                } else {
                    Drawable drawableAsDrawable = UriKt.asDrawable(image, options2.context.getResources());
                    Bitmap.Config config2 = (Bitmap.Config) UriKt.getExtra(options2, ImageRequests_androidKt.bitmapConfigKey);
                    Size size2 = options2.size;
                    Scale scale = options2.scale;
                    Size size3 = (Size) UriKt.getExtra(options2, ImageRequestsKt.maxBitmapSizeKey);
                    if (options2.precision == Precision.INEXACT) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bitmapConvertToBitmap = MathKt.convertToBitmap(drawableAsDrawable, config2, size2, scale, size3, z);
                }
            } else {
                Drawable drawableAsDrawable2 = UriKt.asDrawable(image, options2.context.getResources());
                Bitmap.Config config3 = (Bitmap.Config) UriKt.getExtra(options2, ImageRequests_androidKt.bitmapConfigKey);
                Size size4 = options2.size;
                Scale scale2 = options2.scale;
                Size size5 = (Size) UriKt.getExtra(options2, ImageRequestsKt.maxBitmapSizeKey);
                if (options2.precision == Precision.INEXACT) {
                    z = true;
                } else {
                    z = false;
                }
                bitmapConvertToBitmap = MathKt.convertToBitmap(drawableAsDrawable2, config3, size4, scale2, size5, z);
            }
            eventListener$Companion$NONE$1.getClass();
            size = list.size();
            bitmap = bitmapConvertToBitmap;
            eventListener$Companion$NONE$2 = eventListener$Companion$NONE$1;
        } else {
            if (i3 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            int i4 = engineInterceptorKt$transform$1.I$1;
            int i5 = engineInterceptorKt$transform$1.I$0;
            List list2 = engineInterceptorKt$transform$1.L$8;
            eventListener$Companion$NONE$2 = engineInterceptorKt$transform$1.L$3;
            Options options3 = engineInterceptorKt$transform$1.L$2;
            ImageRequest imageRequest3 = engineInterceptorKt$transform$1.L$1;
            EngineInterceptor.ExecuteResult executeResult3 = engineInterceptorKt$transform$1.L$0;
            ResultKt.throwOnFailure(obj);
            AwaitKt.ensureActive(engineInterceptorKt$transform$1.getContext());
            size = i4;
            executeResult2 = executeResult3;
            bitmap = (Bitmap) obj;
            list = list2;
            options2 = options3;
            i = i5 + 1;
            imageRequest2 = imageRequest3;
        }
        if (i >= size) {
            eventListener$Companion$NONE$2.getClass();
            return new EngineInterceptor.ExecuteResult(new BitmapImage(bitmap), executeResult2.isSampled, executeResult2.dataSource, executeResult2.diskCacheKey);
        }
        if (list.get(i) != null) {
            PathKt$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        Size size6 = options2.size;
        engineInterceptorKt$transform$1.L$0 = executeResult2;
        engineInterceptorKt$transform$1.L$1 = imageRequest2;
        engineInterceptorKt$transform$1.L$2 = options2;
        engineInterceptorKt$transform$1.L$3 = eventListener$Companion$NONE$2;
        engineInterceptorKt$transform$1.L$8 = list;
        engineInterceptorKt$transform$1.I$0 = i;
        engineInterceptorKt$transform$1.I$1 = size;
        engineInterceptorKt$transform$1.label = 1;
        throw null;
    }

    public static final int visibleItemsAverageSize(LazyListMeasureResult lazyListMeasureResult) {
        List list = lazyListMeasureResult.visibleItemsInfo;
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += ((LazyListMeasuredItem) list.get(i2)).size;
        }
        return (i / list.size()) + lazyListMeasureResult.mainAxisItemSpacing;
    }

    public static final void visitScrollCaptureCandidates(SemanticsNode semanticsNode, int i, ScrollCapture.AnonymousClass1 anonymousClass1) {
        MutableVector mutableVector = new MutableVector(new SemanticsNode[16]);
        List children$ui = semanticsNode.getChildren$ui(false, false);
        while (true) {
            mutableVector.addAll(mutableVector.size, children$ui);
            while (true) {
                int i2 = mutableVector.size;
                if (i2 == 0) {
                    return;
                }
                SemanticsNode semanticsNode2 = (SemanticsNode) mutableVector.removeAt(i2 - 1);
                boolean zIsHidden = SemanticsNodeKt.isHidden(semanticsNode2);
                SemanticsConfiguration semanticsConfiguration = semanticsNode2.unmergedConfig;
                MutableScatterMap mutableScatterMap = semanticsConfiguration.props;
                if (!zIsHidden && !mutableScatterMap.containsKey(SemanticsProperties.Disabled)) {
                    NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui = semanticsNode2.findCoordinatorToGetBounds$ui();
                    if (nodeCoordinatorFindCoordinatorToGetBounds$ui == null) {
                        throw Fragment$5$$ExternalSyntheticOutline0.m$2("Expected semantics node to have a coordinator.");
                    }
                    IntRect intRectRoundToIntRect = DatabaseDao_Impl.AnonymousClass17.roundToIntRect(RulerKt.boundsInWindow(nodeCoordinatorFindCoordinatorToGetBounds$ui, true));
                    if (intRectRoundToIntRect.left < intRectRoundToIntRect.right && intRectRoundToIntRect.top < intRectRoundToIntRect.bottom) {
                        Object obj = semanticsConfiguration.props.get(SemanticsActions.ScrollByOffset);
                        if (obj == null) {
                            obj = null;
                        }
                        Function2 function2 = (Function2) obj;
                        Object obj2 = mutableScatterMap.get(SemanticsProperties.VerticalScrollAxisRange);
                        ScrollAxisRange scrollAxisRange = (ScrollAxisRange) (obj2 != null ? obj2 : null);
                        if (function2 == null || scrollAxisRange == null || ((Number) scrollAxisRange.maxValue.invoke()).floatValue() <= CropImageView.DEFAULT_ASPECT_RATIO) {
                            children$ui = semanticsNode2.getChildren$ui(false, false);
                        } else {
                            int i3 = 1 + i;
                            anonymousClass1.invoke(new ScrollCaptureCandidate(semanticsNode2, i3, intRectRoundToIntRect, nodeCoordinatorFindCoordinatorToGetBounds$ui));
                            visitScrollCaptureCandidates(semanticsNode2, i3, anonymousClass1);
                        }
                    }
                }
            }
        }
    }

    public static void writeTypedObject(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }
    }

    public abstract InputFilter[] getFilters(InputFilter[] inputFilterArr);

    public abstract boolean isEnabled();

    public abstract void setAllCaps(boolean z);

    public abstract void setEnabled(boolean z);

    public static final MutableState collectAsStateWithLifecycle(StateFlow stateFlow, Composer composer) {
        return collectAsStateWithLifecycle(stateFlow, stateFlow.getValue(), ((LifecycleOwner) ((GapComposer) composer).consume(LocalLifecycleOwnerKt.LocalLifecycleOwner)).getLifecycle(), composer, 0);
    }

    public static final MutableState collectAsStateWithLifecycle(Flow flow, Object obj, Composer composer, int i) {
        return collectAsStateWithLifecycle(flow, obj, ((LifecycleOwner) ((GapComposer) composer).consume(LocalLifecycleOwnerKt.LocalLifecycleOwner)).getLifecycle(), composer, (i & 57344) | (i & 14) | (((i >> 3) & 8) << 3) | (i & 112) | (i & 7168));
    }

    public static final void NavHost(NavHostController navHostController, String str, Modifier modifier, Alignment alignment, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function1 function5, Composer composer, int i) {
        Alignment alignment2;
        Alignment alignment3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1840250294);
        int i2 = i | (gapComposer.changedInstance(navHostController) ? 4 : 2) | (gapComposer.changed(str) ? 32 : 16) | (gapComposer.changed(modifier) ? 256 : 128) | 805334016;
        char c = gapComposer.changedInstance(function5) ? (char) 4 : (char) 2;
        if ((306783379 & i2) == 306783378 && (c & 3) == 2 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            alignment3 = alignment;
        } else {
            gapComposer.startDefaults();
            if ((i & 1) != 0 && !gapComposer.getDefaultsInvalid()) {
                gapComposer.skipToGroupEnd();
                alignment2 = alignment;
            } else {
                alignment2 = Alignment.Companion.TopStart;
            }
            gapComposer.endDefaults();
            boolean z = ((i2 & 112) == 32) | ((c & 14) == 4);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (z || objRememberedValue == Composer.Companion.Empty) {
                NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHostController.impl._navigatorProvider, str);
                function5.invoke(navGraphBuilder);
                objRememberedValue = navGraphBuilder.build();
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Alignment alignment4 = alignment2;
            NavHost(navHostController, (NavGraph) objRememberedValue, modifier, alignment4, function1, function2, function3, function4, gapComposer, (i2 & 8078) | 115040256);
            alignment3 = alignment4;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new NavHostKt$$ExternalSyntheticLambda13(navHostController, str, modifier, alignment3, function1, function2, function3, function4, function5, i);
        }
    }
}
