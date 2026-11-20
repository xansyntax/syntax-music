package androidx.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Log;
import android.view.inputmethod.EditorInfo;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda3;
import androidx.activity.compose.ComposePredictiveBackHandler;
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner;
import androidx.activity.compose.PredictiveBackHandlerInfo;
import androidx.activity.compose.internal.BackHandlerDispatcherCompat;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.DecayAnimationSpecImpl;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda0;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2;
import androidx.compose.foundation.gestures.snapping.AnimationResult;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateWithTarget$1;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.lazy.grid.LazyGridMeasureResult;
import androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.LongPressTextDragObserverKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.selection.DownResolution;
import androidx.compose.foundation.text.selection.SelectionAdjustment$Companion;
import androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$1;
import androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionFirstPress$1;
import androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$1;
import androidx.compose.foundation.text.selection.SelectionGestures_androidKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.SliderKt$$ExternalSyntheticLambda8;
import androidx.compose.material3.carousel.KeylineList;
import androidx.compose.material3.carousel.Strategy;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.StateListIterator;
import androidx.compose.runtime.tooling.ComposeStackTrace;
import androidx.compose.runtime.tooling.ComposeStackTraceFrame;
import androidx.compose.runtime.tooling.DiagnosticComposeException;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.android.TextLayout_androidKt;
import androidx.compose.ui.text.android.style.IndentationFixSpan_androidKt$WhenMappings;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.core.os.BuildCompat;
import androidx.core.os.HandlerCompat$Api28Impl;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.graphics.shapes.Cubic;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModel;
import androidx.media3.common.Metadata;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.media3.session.IMediaController;
import androidx.media3.session.MediaSessionImpl$1;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.compose.DialogNavigator;
import androidx.navigationevent.NavigationEventDispatcher;
import androidx.navigationevent.NavigationEventDispatcherOwner;
import androidx.navigationevent.compose.LocalNavigationEventDispatcherOwner;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import coil3.network.NetworkHeaders;
import coil3.network.NetworkRequest;
import coil3.network.NetworkResponse;
import coil3.network.SourceResponseBody;
import coil3.network.okhttp.internal.CallFactoryNetworkClientKt$toRequest$1;
import coil3.util.LifecyclesKt;
import coil3.util.UtilsKt;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda0;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda1;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.lyrics.LyricsUtils$$ExternalSyntheticLambda0;
import com.metrolist.music.ui.component.AppNavigationKt$$ExternalSyntheticLambda27;
import com.metrolist.music.utils.SyncUtils$createPlaylist$1;
import com.yalantis.ucrop.view.CropImageView;
import dagger.hilt.EntryPoints;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.UIntArray;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.internal.PlatformImplementations$ReflectThrowable;
import kotlin.internal.jdk7.JDK7PlatformImplementations$ReflectSdkVersion;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.encoding.Encoder;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.RequestBody$Companion$toRequestBody$1;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.http.StatusLine;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SQLite {
    public static final Cubic Cubic(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return new Cubic(new float[]{f, f2, f3, f4, f5, f6, f7, f8});
    }

    public static final void DialogHost(final DialogNavigator dialogNavigator, Composer composer, int i) {
        SnapshotStateList snapshotStateList;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(294589392);
        byte b = 2;
        if ((((gapComposer.changedInstance(dialogNavigator) ? 4 : 2) | i) & 3) == 2 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            final SaveableStateHolderImpl saveableStateHolderImplRememberSaveableStateHolder = SaverKt.rememberSaveableStateHolder(gapComposer);
            MutableState mutableStateCollectAsState = Stack.collectAsState(dialogNavigator.getState().backStack, gapComposer, 0);
            List list = (List) mutableStateCollectAsState.getValue();
            boolean zBooleanValue = ((Boolean) gapComposer.consume(InspectionModeKt.LocalInspectionMode)).booleanValue();
            boolean zChanged = gapComposer.changed(list);
            Object objRememberedValue = gapComposer.rememberedValue();
            Object obj = Composer.Companion.Empty;
            Object obj2 = objRememberedValue;
            if (zChanged || objRememberedValue == obj) {
                SnapshotStateList snapshotStateList2 = new SnapshotStateList();
                ArrayList arrayList = new ArrayList();
                for (Object obj3 : list) {
                    NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj3;
                    if (zBooleanValue || navBackStackEntry.impl.lifecycle.state.compareTo(Lifecycle.State.STARTED) >= 0) {
                        arrayList.add(obj3);
                    }
                }
                snapshotStateList2.addAll(arrayList);
                gapComposer.updateRememberedValue(snapshotStateList2);
                obj2 = snapshotStateList2;
            }
            SnapshotStateList snapshotStateList3 = (SnapshotStateList) obj2;
            PopulateVisibleList(snapshotStateList3, (List) mutableStateCollectAsState.getValue(), gapComposer, 0);
            MutableState mutableStateCollectAsState2 = Stack.collectAsState(dialogNavigator.getState().transitionsInProgress, gapComposer, 0);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == obj) {
                objRememberedValue2 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer);
            }
            final SnapshotStateList snapshotStateList4 = (SnapshotStateList) objRememberedValue2;
            gapComposer.startReplaceGroup(-367418626);
            ListIterator listIterator = snapshotStateList3.listIterator();
            while (true) {
                StateListIterator stateListIterator = (StateListIterator) listIterator;
                if (!stateListIterator.hasNext()) {
                    break;
                }
                final NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) stateListIterator.next();
                NavDestination navDestination = navBackStackEntry2.destination;
                navDestination.getClass();
                final DialogNavigator.Destination destination = (DialogNavigator.Destination) navDestination;
                boolean zChangedInstance = gapComposer.changedInstance(dialogNavigator) | gapComposer.changedInstance(navBackStackEntry2);
                Object objRememberedValue3 = gapComposer.rememberedValue();
                if (zChangedInstance || objRememberedValue3 == obj) {
                    objRememberedValue3 = new ComponentRegistry$Builder$$ExternalSyntheticLambda2((Object) dialogNavigator, (Object) navBackStackEntry2, (byte) 5);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                AndroidDialog_androidKt.Dialog((Function0) objRememberedValue3, destination.dialogProperties, Expect_jvmKt.rememberComposableLambda(1129586364, new Function2() { // from class: androidx.navigation.compose.DialogHostKt$DialogHost$1$2
                    /* JADX WARN: Code duplicated, block: B:12:0x0034  */
                    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj4, Object obj5) {
                        GapComposer gapComposer2;
                        NavBackStackEntry navBackStackEntry3;
                        DialogNavigator dialogNavigator2;
                        boolean zChangedInstance2;
                        Object objRememberedValue4;
                        Composer composer2 = (Composer) obj4;
                        if ((((Number) obj5).intValue() & 3) == 2) {
                            GapComposer gapComposer3 = (GapComposer) composer2;
                            if (gapComposer3.getSkipping()) {
                                gapComposer3.skipToGroupEnd();
                            } else {
                                gapComposer2 = (GapComposer) composer2;
                                navBackStackEntry3 = navBackStackEntry2;
                                boolean zChangedInstance3 = gapComposer2.changedInstance(navBackStackEntry3);
                                dialogNavigator2 = dialogNavigator;
                                zChangedInstance2 = zChangedInstance3 | gapComposer2.changedInstance(dialogNavigator2);
                                objRememberedValue4 = gapComposer2.rememberedValue();
                                if (zChangedInstance2 || objRememberedValue4 == Composer.Companion.Empty) {
                                    objRememberedValue4 = new UtilsKt$$ExternalSyntheticLambda0((Object) snapshotStateList4, (Object) navBackStackEntry3, (Object) dialogNavigator2, (byte) 27);
                                    gapComposer2.updateRememberedValue(objRememberedValue4);
                                }
                                Stack.DisposableEffect(navBackStackEntry3, (Function1) objRememberedValue4, gapComposer2);
                                DatabaseDao_Impl.AnonymousClass17.LocalOwnersProvider(navBackStackEntry3, saveableStateHolderImplRememberSaveableStateHolder, Expect_jvmKt.rememberComposableLambda(-497631156, new NavHostKt$NavHost$32.AnonymousClass1(destination, navBackStackEntry3), gapComposer2), gapComposer2, 384);
                            }
                        } else {
                            gapComposer2 = (GapComposer) composer2;
                            navBackStackEntry3 = navBackStackEntry2;
                            boolean zChangedInstance4 = gapComposer2.changedInstance(navBackStackEntry3);
                            dialogNavigator2 = dialogNavigator;
                            zChangedInstance2 = zChangedInstance4 | gapComposer2.changedInstance(dialogNavigator2);
                            objRememberedValue4 = gapComposer2.rememberedValue();
                            if (zChangedInstance2) {
                                objRememberedValue4 = new UtilsKt$$ExternalSyntheticLambda0((Object) snapshotStateList4, (Object) navBackStackEntry3, (Object) dialogNavigator2, (byte) 27);
                                gapComposer2.updateRememberedValue(objRememberedValue4);
                            } else {
                                objRememberedValue4 = new UtilsKt$$ExternalSyntheticLambda0((Object) snapshotStateList4, (Object) navBackStackEntry3, (Object) dialogNavigator2, (byte) 27);
                                gapComposer2.updateRememberedValue(objRememberedValue4);
                            }
                            Stack.DisposableEffect(navBackStackEntry3, (Function1) objRememberedValue4, gapComposer2);
                            DatabaseDao_Impl.AnonymousClass17.LocalOwnersProvider(navBackStackEntry3, saveableStateHolderImplRememberSaveableStateHolder, Expect_jvmKt.rememberComposableLambda(-497631156, new NavHostKt$NavHost$32.AnonymousClass1(destination, navBackStackEntry3), gapComposer2), gapComposer2, 384);
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer), gapComposer, 384);
            }
            gapComposer.end(false);
            Set set = (Set) mutableStateCollectAsState2.getValue();
            boolean zChanged2 = gapComposer.changed(mutableStateCollectAsState2) | gapComposer.changedInstance(dialogNavigator);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue4 == obj) {
                snapshotStateList = snapshotStateList4;
                Object anonymousClass1 = new SyncUtils$createPlaylist$1.AnonymousClass1((Object) mutableStateCollectAsState2, (Object) dialogNavigator, (Object) snapshotStateList, (Continuation) null, (byte) 3);
                gapComposer.updateRememberedValue(anonymousClass1);
                objRememberedValue4 = anonymousClass1;
            } else {
                snapshotStateList = snapshotStateList4;
            }
            Stack.LaunchedEffect(set, snapshotStateList, (Function2) objRememberedValue4, gapComposer);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda0(dialogNavigator, i, b);
        }
    }

    public static final long IntOffset(int i, int i2) {
        return (((long) i2) & 4294967295L) | (((long) i) << 32);
    }

    public static final void PopulateVisibleList(List list, Collection collection, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1537894851);
        byte b = 4;
        if ((((gapComposer.changedInstance(list) ? 4 : 2) | i | (gapComposer.changedInstance(collection) ? 32 : 16)) & 19) == 18 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            boolean zBooleanValue = ((Boolean) gapComposer.consume(InspectionModeKt.LocalInspectionMode)).booleanValue();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) it.next();
                LifecycleRegistry lifecycleRegistry = navBackStackEntry.impl.lifecycle;
                boolean zChanged = gapComposer.changed(zBooleanValue) | gapComposer.changedInstance(list) | gapComposer.changedInstance(navBackStackEntry);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = new LyricsUtils$$ExternalSyntheticLambda0((Object) navBackStackEntry, zBooleanValue, (Object) list, (byte) 6);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                Stack.DisposableEffect(lifecycleRegistry, (Function1) objRememberedValue, gapComposer);
            }
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda1(list, collection, i, b);
        }
    }

    public static final void PredictiveBackHandler(boolean z, Function2 function2, Composer composer, int i, int i2) {
        boolean z2;
        int i3;
        boolean z3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-642000585);
        int i4 = i2 & 1;
        byte b = 2;
        if (i4 != 0) {
            i3 = i | 6;
            z2 = z;
        } else if ((i & 6) == 0) {
            z2 = z;
            i3 = i | (gapComposer.changed(z2) ? 4 : 2);
        } else {
            z2 = z;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer.changedInstance(function2) ? 32 : 16;
        }
        byte b2 = 1;
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 19) != 18)) {
            boolean z4 = i4 != 0 ? true : z2;
            Object current = LocalNavigationEventDispatcherOwner.getCurrent(gapComposer);
            if (current == null) {
                gapComposer.startReplaceGroup(1512740606);
                current = LocalOnBackPressedDispatcherOwner.getCurrent(gapComposer);
            } else {
                gapComposer.startReplaceGroup(1512737723);
            }
            gapComposer.end(false);
            if (current == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("No NavigationEventDispatcherOwner was provided via LocalNavigationEventDispatcherOwner and no OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner. Please provide one of the two.");
                return;
            }
            boolean zChanged = gapComposer.changed(current);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zChanged || objRememberedValue == neverEqualPolicy) {
                NavigationEventDispatcherOwner navigationEventDispatcherOwner = current instanceof NavigationEventDispatcherOwner ? (NavigationEventDispatcherOwner) current : null;
                NavigationEventDispatcher navigationEventDispatcher = navigationEventDispatcherOwner != null ? navigationEventDispatcherOwner.getNavigationEventDispatcher() : null;
                OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = current instanceof OnBackPressedDispatcherOwner ? (OnBackPressedDispatcherOwner) current : null;
                objRememberedValue = new BackHandlerDispatcherCompat(navigationEventDispatcher, onBackPressedDispatcherOwner != null ? onBackPressedDispatcherOwner.getOnBackPressedDispatcher() : null);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            BackHandlerDispatcherCompat backHandlerDispatcherCompat = (BackHandlerDispatcherCompat) objRememberedValue;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
            long j = gapComposer.compositeKeyHashCode;
            boolean zChanged2 = gapComposer.changed(backHandlerDispatcherCompat) | gapComposer.changed(j);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new ComposePredictiveBackHandler(coroutineScope, new PredictiveBackHandlerInfo(j, current));
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            ComposePredictiveBackHandler composePredictiveBackHandler = (ComposePredictiveBackHandler) objRememberedValue3;
            gapComposer.startReplaceGroup(-348514256);
            boolean zChangedInstance = gapComposer.changedInstance(composePredictiveBackHandler) | gapComposer.changedInstance(function2);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new Recomposer$$ExternalSyntheticLambda6(composePredictiveBackHandler, function2, b);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            Stack.SideEffect((Function0) objRememberedValue4, gapComposer);
            Boolean boolValueOf = Boolean.valueOf(z4);
            int i5 = i3 & 14;
            boolean zChangedInstance2 = (i5 == 4) | gapComposer.changedInstance(composePredictiveBackHandler);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = new SliderKt$$ExternalSyntheticLambda8(composePredictiveBackHandler, z4, b);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            LifecyclesKt.LifecycleStartEffect(boolValueOf, composePredictiveBackHandler, null, (Function1) objRememberedValue5, gapComposer, i5);
            boolean zChangedInstance3 = gapComposer.changedInstance(backHandlerDispatcherCompat) | gapComposer.changedInstance(composePredictiveBackHandler);
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue6 == neverEqualPolicy) {
                objRememberedValue6 = new BackHandlerKt$$ExternalSyntheticLambda2(backHandlerDispatcherCompat, composePredictiveBackHandler, b2);
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            Stack.DisposableEffect(backHandlerDispatcherCompat, composePredictiveBackHandler, (Function1) objRememberedValue6, gapComposer);
            gapComposer.end(false);
            z3 = z4;
        } else {
            gapComposer.skipToGroupEnd();
            z3 = z2;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new BackHandlerKt$$ExternalSyntheticLambda3(z3, function2, i, i2, (byte) 1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object animateDecay(ScrollScope scrollScope, float f, AnimationState animationState, DecayAnimationSpecImpl decayAnimationSpecImpl, Function1 function1, ContinuationImpl continuationImpl) {
        SnapFlingBehaviorKt$animateDecay$1 snapFlingBehaviorKt$animateDecay$1;
        float f2;
        Ref$FloatRef ref$FloatRef;
        if (continuationImpl instanceof SnapFlingBehaviorKt$animateDecay$1) {
            snapFlingBehaviorKt$animateDecay$1 = (SnapFlingBehaviorKt$animateDecay$1) continuationImpl;
            int i = snapFlingBehaviorKt$animateDecay$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                snapFlingBehaviorKt$animateDecay$1.label = i - Integer.MIN_VALUE;
            } else {
                snapFlingBehaviorKt$animateDecay$1 = new SnapFlingBehaviorKt$animateDecay$1(continuationImpl);
            }
        } else {
            snapFlingBehaviorKt$animateDecay$1 = new SnapFlingBehaviorKt$animateDecay$1(continuationImpl);
        }
        Object obj = snapFlingBehaviorKt$animateDecay$1.result;
        int i2 = snapFlingBehaviorKt$animateDecay$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
            boolean z = ((Number) animationState.getVelocity()).floatValue() == CropImageView.DEFAULT_ASPECT_RATIO;
            AppNavigationKt$$ExternalSyntheticLambda27 appNavigationKt$$ExternalSyntheticLambda27 = new AppNavigationKt$$ExternalSyntheticLambda27(f, ref$FloatRef2, scrollScope, function1, (byte) 1);
            snapFlingBehaviorKt$animateDecay$1.L$0 = animationState;
            snapFlingBehaviorKt$animateDecay$1.L$1 = ref$FloatRef2;
            snapFlingBehaviorKt$animateDecay$1.F$0 = f;
            snapFlingBehaviorKt$animateDecay$1.label = 1;
            Object objAnimateDecay = ArcSplineKt.animateDecay(animationState, decayAnimationSpecImpl, !z, appNavigationKt$$ExternalSyntheticLambda27, snapFlingBehaviorKt$animateDecay$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAnimateDecay == coroutineSingletons) {
                return coroutineSingletons;
            }
            f2 = f;
            ref$FloatRef = ref$FloatRef2;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            f2 = snapFlingBehaviorKt$animateDecay$1.F$0;
            ref$FloatRef = snapFlingBehaviorKt$animateDecay$1.L$1;
            animationState = snapFlingBehaviorKt$animateDecay$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return new AnimationResult(new Float(f2 - ref$FloatRef.element), animationState);
    }

    public static final void animateDecay$consumeDelta(AnimationScope animationScope, ScrollScope scrollScope, Function1 function1, float f) {
        float fScrollBy;
        try {
            fScrollBy = scrollScope.scrollBy(f);
        } catch (CancellationException unused) {
            animationScope.cancelAnimation();
            fScrollBy = CropImageView.DEFAULT_ASPECT_RATIO;
        }
        function1.invoke(Float.valueOf(fScrollBy));
        if (Math.abs(f - fScrollBy) > 0.5f) {
            animationScope.cancelAnimation();
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public static final Object animateWithTarget(ScrollScope scrollScope, float f, float f2, AnimationState animationState, AnimationSpec animationSpec, Function1 function1, ContinuationImpl continuationImpl) {
        SnapFlingBehaviorKt$animateWithTarget$1 snapFlingBehaviorKt$animateWithTarget$1;
        float fFloatValue;
        AnimationState animationState2;
        Ref$FloatRef ref$FloatRef;
        float f3 = f;
        if (continuationImpl instanceof SnapFlingBehaviorKt$animateWithTarget$1) {
            snapFlingBehaviorKt$animateWithTarget$1 = (SnapFlingBehaviorKt$animateWithTarget$1) continuationImpl;
            int i = snapFlingBehaviorKt$animateWithTarget$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                snapFlingBehaviorKt$animateWithTarget$1.label = i - Integer.MIN_VALUE;
            } else {
                snapFlingBehaviorKt$animateWithTarget$1 = new SnapFlingBehaviorKt$animateWithTarget$1(continuationImpl);
            }
        } else {
            snapFlingBehaviorKt$animateWithTarget$1 = new SnapFlingBehaviorKt$animateWithTarget$1(continuationImpl);
        }
        SnapFlingBehaviorKt$animateWithTarget$1 snapFlingBehaviorKt$animateWithTarget$2 = snapFlingBehaviorKt$animateWithTarget$1;
        Object obj = snapFlingBehaviorKt$animateWithTarget$2.result;
        int i2 = snapFlingBehaviorKt$animateWithTarget$2.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
            fFloatValue = ((Number) animationState.getVelocity()).floatValue();
            Float f4 = new Float(f3);
            boolean z = ((Number) animationState.getVelocity()).floatValue() == CropImageView.DEFAULT_ASPECT_RATIO;
            AppNavigationKt$$ExternalSyntheticLambda27 appNavigationKt$$ExternalSyntheticLambda27 = new AppNavigationKt$$ExternalSyntheticLambda27(f2, ref$FloatRef2, scrollScope, function1, (byte) 2);
            snapFlingBehaviorKt$animateWithTarget$2.L$0 = animationState;
            snapFlingBehaviorKt$animateWithTarget$2.L$1 = ref$FloatRef2;
            snapFlingBehaviorKt$animateWithTarget$2.F$0 = f3;
            snapFlingBehaviorKt$animateWithTarget$2.F$1 = fFloatValue;
            snapFlingBehaviorKt$animateWithTarget$2.label = 1;
            Object objAnimateTo = ArcSplineKt.animateTo(animationState, f4, animationSpec, !z, appNavigationKt$$ExternalSyntheticLambda27, snapFlingBehaviorKt$animateWithTarget$2);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAnimateTo == coroutineSingletons) {
                return coroutineSingletons;
            }
            animationState2 = animationState;
            ref$FloatRef = ref$FloatRef2;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            float f5 = snapFlingBehaviorKt$animateWithTarget$2.F$1;
            float f6 = snapFlingBehaviorKt$animateWithTarget$2.F$0;
            ref$FloatRef = snapFlingBehaviorKt$animateWithTarget$2.L$1;
            animationState2 = snapFlingBehaviorKt$animateWithTarget$2.L$0;
            ResultKt.throwOnFailure(obj);
            fFloatValue = f5;
            f3 = f6;
        }
        return new AnimationResult(new Float(f3 - ref$FloatRef.element), ArcSplineKt.copy$default(animationState2, CropImageView.DEFAULT_ASPECT_RATIO, coerceToTarget(((Number) animationState2.getVelocity()).floatValue(), fFloatValue), 29));
    }

    public static final void appendPlaceholders(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("?");
            if (i2 < i - 1) {
                sb.append(",");
            }
        }
    }

    public static final void asYamlOutput(Encoder encoder) {
        throw new IllegalStateException(("This serializer can be used only with Yaml format. Expected Encoder to be YamlOutput, got " + Reflection.getOrCreateKotlinClass(encoder.getClass())).toString());
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x004b  */
    /* JADX WARN: Code duplicated, block: B:23:0x0058 A[LOOP:0: B:19:0x0049->B:23:0x0058, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:26:0x0031 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x003d -> B:18:0x0040). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public static final java.lang.Object awaitDown(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine r6, kotlin.coroutines.jvm.internal.BaseContinuationImpl r7) {
        /*
            boolean r0 = r7 instanceof androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1 r0 = (androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1 r0 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L2e
            if (r1 != r2) goto L27
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r6 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L40
        L27:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r6)
            r6 = 0
            return r6
        L2e:
            kotlin.ResultKt.throwOnFailure(r7)
        L31:
            r0.L$0 = r6
            r0.label = r2
            androidx.compose.ui.input.pointer.PointerEventPass r7 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            java.lang.Object r7 = r6.awaitPointerEvent(r7, r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r7 != r1) goto L40
            return r1
        L40:
            androidx.compose.ui.input.pointer.PointerEvent r7 = (androidx.compose.ui.input.pointer.PointerEvent) r7
            java.util.List r1 = r7.changes
            int r3 = r1.size()
            r4 = 0
        L49:
            if (r4 >= r3) goto L5b
            java.lang.Object r5 = r1.get(r4)
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            boolean r5 = androidx.compose.ui.input.pointer.PointerIconKt.changedToDown(r5)
            if (r5 != 0) goto L58
            goto L31
        L58:
            int r4 = r4 + 1
            goto L49
        L5b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.SQLite.awaitDown(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine, kotlin.coroutines.jvm.internal.BaseContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0052  */
    /* JADX WARN: Code duplicated, block: B:25:0x005f A[LOOP:0: B:21:0x0050->B:25:0x005f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:29:0x0031 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x003d -> B:18:0x0040). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public static final java.lang.Object awaitFirstRightClickDown(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine r6, kotlin.coroutines.jvm.internal.BaseContinuationImpl r7) {
        /*
            boolean r0 = r7 instanceof androidx.compose.foundation.text.contextmenu.gestures.RightClickGesturesKt$awaitFirstRightClickDown$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.foundation.text.contextmenu.gestures.RightClickGesturesKt$awaitFirstRightClickDown$1 r0 = (androidx.compose.foundation.text.contextmenu.gestures.RightClickGesturesKt$awaitFirstRightClickDown$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.text.contextmenu.gestures.RightClickGesturesKt$awaitFirstRightClickDown$1 r0 = new androidx.compose.foundation.text.contextmenu.gestures.RightClickGesturesKt$awaitFirstRightClickDown$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L2e
            if (r1 != r2) goto L27
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r6 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L40
        L27:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r6)
            r6 = 0
            return r6
        L2e:
            kotlin.ResultKt.throwOnFailure(r7)
        L31:
            r0.L$0 = r6
            r0.label = r2
            androidx.compose.ui.input.pointer.PointerEventPass r7 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            java.lang.Object r7 = r6.awaitPointerEvent(r7, r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r7 != r1) goto L40
            return r1
        L40:
            androidx.compose.ui.input.pointer.PointerEvent r7 = (androidx.compose.ui.input.pointer.PointerEvent) r7
            int r1 = r7.buttons
            java.util.List r7 = r7.changes
            r1 = r1 & 66
            if (r1 == 0) goto L31
            int r1 = r7.size()
            r3 = 0
            r4 = r3
        L50:
            if (r4 >= r1) goto L62
            java.lang.Object r5 = r7.get(r4)
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            boolean r5 = androidx.compose.ui.input.pointer.PointerIconKt.changedToDown(r5)
            if (r5 != 0) goto L5f
            goto L31
        L5f:
            int r4 = r4 + 1
            goto L50
        L62:
            java.lang.Object r6 = r7.get(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.SQLite.awaitFirstRightClickDown(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine, kotlin.coroutines.jvm.internal.BaseContinuationImpl):java.lang.Object");
    }

    public static int checkPackageValidity(Context context, String str, int i) {
        if (str == null) {
            return 1;
        }
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(i);
        if (packagesForUid == null || packagesForUid.length == 0) {
            return 2;
        }
        for (String str2 : packagesForUid) {
            if (str2.equals(str)) {
                return 0;
            }
        }
        return 1;
    }

    public static final float coerceToTarget(float f, float f2) {
        if (f2 == CropImageView.DEFAULT_ASPECT_RATIO) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        return (f2 <= CropImageView.DEFAULT_ASPECT_RATIO ? f >= f2 : f <= f2) ? f : f2;
    }

    public static final ContentValues contentValuesOf(Pair... pairArr) {
        ContentValues contentValues = new ContentValues(pairArr.length);
        for (Pair pair : pairArr) {
            String str = (String) pair.first;
            Object obj = pair.second;
            if (obj == null) {
                contentValues.putNull(str);
            } else if (obj instanceof String) {
                contentValues.put(str, (String) obj);
            } else if (obj instanceof Integer) {
                contentValues.put(str, (Integer) obj);
            } else if (obj instanceof Long) {
                contentValues.put(str, (Long) obj);
            } else if (obj instanceof Boolean) {
                contentValues.put(str, (Boolean) obj);
            } else if (obj instanceof Float) {
                contentValues.put(str, (Float) obj);
            } else if (obj instanceof Double) {
                contentValues.put(str, (Double) obj);
            } else if (obj instanceof byte[]) {
                contentValues.put(str, (byte[]) obj);
            } else if (obj instanceof Byte) {
                contentValues.put(str, (Byte) obj);
            } else {
                if (!(obj instanceof Short)) {
                    DifferentialMotionFlingController$$ExternalSyntheticLambda0.m("Illegal value type ", obj.getClass().getCanonicalName(), " for key \"", str, 34);
                    return null;
                }
                contentValues.put(str, (Short) obj);
            }
        }
        return contentValues;
    }

    public static Handler createAsync(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return HandlerCompat$Api28Impl.createAsync(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException e) {
            e = e;
            Log.w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
            return new Handler(looper);
        } catch (InstantiationException e2) {
            e = e2;
            Log.w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
            return new Handler(looper);
        } catch (NoSuchMethodException e3) {
            e = e3;
            Log.w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
            return new Handler(looper);
        } catch (InvocationTargetException e4) {
            Throwable cause = e4.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    public static ViewModel createViewModel(Class cls) throws InvocationTargetException {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(null);
            if (!Modifier.isPublic(declaredConstructor.getModifiers())) {
                throw new RuntimeException("Cannot create an instance of " + cls);
            }
            try {
                Object objNewInstance = declaredConstructor.newInstance(null);
                objNewInstance.getClass();
                return (ViewModel) objNewInstance;
            } catch (IllegalAccessException e) {
                DifferentialMotionFlingController$$ExternalSyntheticLambda0.m("Cannot create an instance of ", (Object) cls, (Throwable) e);
                return null;
            } catch (InstantiationException e2) {
                DifferentialMotionFlingController$$ExternalSyntheticLambda0.m("Cannot create an instance of ", (Object) cls, (Throwable) e2);
                return null;
            }
        } catch (NoSuchMethodException e3) {
            DifferentialMotionFlingController$$ExternalSyntheticLambda0.m("Cannot create an instance of ", (Object) cls, (Throwable) e3);
            return null;
        }
    }

    public static void disconnectIMediaController(IMediaController iMediaController) {
        if (iMediaController != null) {
            try {
                iMediaController.onDisconnected();
            } catch (RemoteException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m845equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static final void execSQL(SQLiteConnection sQLiteConnection, String str) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.step();
            StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, th);
                throw th2;
            }
        }
    }

    public static final float getEllipsizedLeftPadding(Layout layout, int i, Paint paint) {
        float fAbs;
        float width;
        float lineLeft = layout.getLineLeft(i);
        ThreadLocal threadLocal = TextLayout_androidKt.SharedTextAndroidCanvas;
        if (layout.getEllipsisCount(i) <= 0 || layout.getParagraphDirection(i) != 1 || lineLeft >= CropImageView.DEFAULT_ASPECT_RATIO) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        float fMeasureText = paint.measureText("…") + (layout.getPrimaryHorizontal(layout.getEllipsisStart(i) + layout.getLineStart(i)) - lineLeft);
        Layout.Alignment paragraphAlignment = layout.getParagraphAlignment(i);
        if ((paragraphAlignment == null ? -1 : IndentationFixSpan_androidKt$WhenMappings.$EnumSwitchMapping$0[paragraphAlignment.ordinal()]) == 1) {
            fAbs = Math.abs(lineLeft);
            width = (layout.getWidth() - fMeasureText) / 2.0f;
        } else {
            fAbs = Math.abs(lineLeft);
            width = layout.getWidth() - fMeasureText;
        }
        return width + fAbs;
    }

    public static final float getEllipsizedRightPadding(Layout layout, int i, Paint paint) {
        float width;
        float width2;
        ThreadLocal threadLocal = TextLayout_androidKt.SharedTextAndroidCanvas;
        if (layout.getEllipsisCount(i) <= 0) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        if (layout.getParagraphDirection(i) != -1 || layout.getWidth() >= layout.getLineRight(i)) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        float fMeasureText = paint.measureText("…") + (layout.getLineRight(i) - layout.getPrimaryHorizontal(layout.getEllipsisStart(i) + layout.getLineStart(i)));
        Layout.Alignment paragraphAlignment = layout.getParagraphAlignment(i);
        if ((paragraphAlignment != null ? IndentationFixSpan_androidKt$WhenMappings.$EnumSwitchMapping$0[paragraphAlignment.ordinal()] : -1) == 1) {
            width = layout.getWidth() - layout.getLineRight(i);
            width2 = (layout.getWidth() - fMeasureText) / 2.0f;
        } else {
            width = layout.getWidth() - layout.getLineRight(i);
            width2 = layout.getWidth() - fMeasureText;
        }
        return width - width2;
    }

    public static final int getSnapPositionOffset(Strategy strategy, int i, int i2) {
        boolean z = strategy.isValid;
        KeylineList keylineList = strategy.defaultKeylines;
        List list = strategy.endKeylineSteps;
        List list2 = strategy.startKeylineSteps;
        if (!z) {
            return 0;
        }
        int iRoundToInt = MathKt.roundToInt(keylineList.getFirstFocal().unadjustedOffset - (strategy.getItemMainAxisSize() / 2.0f));
        if (i <= list2.size() - 1) {
            iRoundToInt = MathKt.roundToInt(((KeylineList) list2.get(UuidKt.coerceIn((list2.size() - 1) - i, 0, list2.size() - 1))).getFirstFocal().unadjustedOffset - (strategy.getItemMainAxisSize() / 2.0f));
        }
        int i3 = i2 - 1;
        return (i < i3 - (list.size() + (-1)) || i2 <= keylineList.focalCount) ? iRoundToInt : MathKt.roundToInt(((KeylineList) list.get(UuidKt.coerceIn((list.size() - 1) - (i3 - i), 0, list.size() - 1))).getLastFocal().unadjustedOffset - (strategy.getItemMainAxisSize() / 2.0f));
    }

    public static String lenientFormat(String str, Object... objArr) {
        int iIndexOf;
        String strValueOf = String.valueOf(str);
        StringBuilder sb = new StringBuilder((objArr.length * 16) + strValueOf.length());
        int i = 0;
        int i2 = 0;
        while (i < objArr.length && (iIndexOf = strValueOf.indexOf("%s", i2)) != -1) {
            sb.append((CharSequence) strValueOf, i2, iIndexOf);
            sb.append(lenientToString(objArr[i]));
            i2 = iIndexOf + 2;
            i++;
        }
        sb.append((CharSequence) strValueOf, i2, strValueOf.length());
        if (i < objArr.length) {
            String str2 = " [";
            while (i < objArr.length) {
                sb.append(str2);
                sb.append(lenientToString(objArr[i]));
                i++;
                str2 = ", ";
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static String lenientToString(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            return obj.toString();
        } catch (Exception e) {
            String str = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
            Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for ".concat(str), (Throwable) e);
            StringBuilder sbM4m = IntIntPair$$ExternalSyntheticOutline0.m4m("<", str, " threw ");
            sbM4m.append(e.getClass().getName());
            sbM4m.append(">");
            return sbM4m.toString();
        }
    }

    /* JADX WARN: Code duplicated, block: B:107:0x00d8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x00bd A[Catch: all -> 0x0053, TryCatch #1 {all -> 0x0053, blocks: (B:21:0x004f, B:44:0x00b5, B:46:0x00bd, B:48:0x00c9, B:50:0x00d5, B:41:0x009b), top: B:99:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00c9 A[Catch: all -> 0x0053, TryCatch #1 {all -> 0x0053, blocks: (B:21:0x004f, B:44:0x00b5, B:46:0x00bd, B:48:0x00c9, B:50:0x00d5, B:41:0x009b), top: B:99:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00d5 A[Catch: all -> 0x0053, TRY_LEAVE, TryCatch #1 {all -> 0x0053, blocks: (B:21:0x004f, B:44:0x00b5, B:46:0x00bd, B:48:0x00c9, B:50:0x00d5, B:41:0x009b), top: B:99:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0166, code lost:
    
        if (r3 == r13) goto L83;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object mouseSelection(SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine, MediaSessionImpl$1 mediaSessionImpl$1, StatusLine statusLine, PointerEvent pointerEvent, BaseContinuationImpl baseContinuationImpl) {
        SelectionGesturesKt$mouseSelection$1 selectionGesturesKt$mouseSelection$1;
        MarqueeSpacing$Companion$$ExternalSyntheticLambda0 marqueeSpacing$Companion$$ExternalSyntheticLambda0;
        boolean z;
        Ref$BooleanRef ref$BooleanRef;
        LegacyTextFieldState legacyTextFieldState;
        boolean z2;
        List list;
        int size;
        PointerInputChange pointerInputChange;
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine2 = pointerEventHandlerCoroutine;
        MediaSessionImpl$1 mediaSessionImpl$2 = mediaSessionImpl$1;
        MarqueeSpacing$Companion$$ExternalSyntheticLambda0 marqueeSpacing$Companion$$ExternalSyntheticLambda1 = SelectionAdjustment$Companion.None;
        if (baseContinuationImpl instanceof SelectionGesturesKt$mouseSelection$1) {
            selectionGesturesKt$mouseSelection$1 = (SelectionGesturesKt$mouseSelection$1) baseContinuationImpl;
            int i = selectionGesturesKt$mouseSelection$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                selectionGesturesKt$mouseSelection$1.label = i - Integer.MIN_VALUE;
            } else {
                selectionGesturesKt$mouseSelection$1 = new SelectionGesturesKt$mouseSelection$1(baseContinuationImpl);
            }
        } else {
            selectionGesturesKt$mouseSelection$1 = new SelectionGesturesKt$mouseSelection$1(baseContinuationImpl);
        }
        SelectionGesturesKt$mouseSelection$1 selectionGesturesKt$mouseSelection$2 = selectionGesturesKt$mouseSelection$1;
        Object objM91dragjO51t88 = selectionGesturesKt$mouseSelection$2.result;
        int i2 = selectionGesturesKt$mouseSelection$2.label;
        int i3 = 0;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objM91dragjO51t88);
                    PointerInputChange pointerInputChange2 = (PointerInputChange) pointerEvent.changes.get(0);
                    int i4 = pointerEvent.keyboardModifiers & 1;
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (i4 != 0) {
                        long j = pointerInputChange2.position;
                        TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) mediaSessionImpl$2.this$0;
                        LegacyTextFieldState legacyTextFieldState2 = textFieldSelectionManager.state;
                        if (legacyTextFieldState2 == null || legacyTextFieldState2.getLayoutResult() == null || !textFieldSelectionManager.getEnabled()) {
                            z2 = false;
                        } else {
                            textFieldSelectionManager.previousRawDragOffset = -1;
                            FocusRequester focusRequester = textFieldSelectionManager.focusRequester;
                            if (focusRequester != null) {
                                FocusRequester.m415requestFocus3ESFkO8$default(focusRequester);
                            }
                            mediaSessionImpl$2.updateMouseSelection(textFieldSelectionManager.getValue$foundation(), j, false, SelectionAdjustment$Companion.None);
                            z2 = true;
                        }
                        if (z2) {
                            pointerInputChange2.consume();
                            long j2 = pointerInputChange2.id;
                            ScrollState$$ExternalSyntheticLambda0 scrollState$$ExternalSyntheticLambda0 = new ScrollState$$ExternalSyntheticLambda0((byte) 29, mediaSessionImpl$2);
                            selectionGesturesKt$mouseSelection$2.L$0 = pointerEventHandlerCoroutine2;
                            selectionGesturesKt$mouseSelection$2.L$1 = mediaSessionImpl$2;
                            selectionGesturesKt$mouseSelection$2.label = 1;
                            objM91dragjO51t88 = ScrollableKt.m91dragjO51t88(pointerEventHandlerCoroutine2, j2, scrollState$$ExternalSyntheticLambda0, selectionGesturesKt$mouseSelection$2);
                            if (objM91dragjO51t88 == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            if (((Boolean) objM91dragjO51t88).booleanValue()) {
                                list = SuspendingPointerInputModifierNodeImpl.this.currentEvent.changes;
                                size = list.size();
                                while (i3 < size) {
                                    pointerInputChange = (PointerInputChange) list.get(i3);
                                    if (PointerIconKt.changedToUp(pointerInputChange)) {
                                        pointerInputChange.consume();
                                    }
                                    i3++;
                                }
                            }
                            mediaSessionImpl$2.onDragDone();
                        }
                    } else {
                        int i5 = statusLine.code;
                        if (i5 != 1) {
                            marqueeSpacing$Companion$$ExternalSyntheticLambda0 = i5 != 2 ? SelectionAdjustment$Companion.Paragraph : SelectionAdjustment$Companion.Word;
                        } else {
                            marqueeSpacing$Companion$$ExternalSyntheticLambda0 = marqueeSpacing$Companion$$ExternalSyntheticLambda1;
                        }
                        long j3 = pointerInputChange2.position;
                        TextFieldSelectionManager textFieldSelectionManager2 = (TextFieldSelectionManager) mediaSessionImpl$2.this$0;
                        if (!textFieldSelectionManager2.getEnabled() || textFieldSelectionManager2.getValue$foundation().annotatedString.text.length() == 0 || (legacyTextFieldState = textFieldSelectionManager2.state) == null || legacyTextFieldState.getLayoutResult() == null) {
                            z = false;
                        } else {
                            FocusRequester focusRequester2 = textFieldSelectionManager2.focusRequester;
                            if (focusRequester2 != null) {
                                FocusRequester.m415requestFocus3ESFkO8$default(focusRequester2);
                            }
                            textFieldSelectionManager2.dragBeginPosition = j3;
                            textFieldSelectionManager2.previousRawDragOffset = -1;
                            textFieldSelectionManager2.enterSelectionMode$foundation(true);
                            long jUpdateMouseSelection = mediaSessionImpl$2.updateMouseSelection(textFieldSelectionManager2.getValue$foundation(), textFieldSelectionManager2.dragBeginPosition, true, marqueeSpacing$Companion$$ExternalSyntheticLambda0);
                            if (i5 >= 2) {
                                mediaSessionImpl$2.val$callOnPlayerInteractionFinished = true;
                                mediaSessionImpl$2.val$controllerForRequest = new TextRange(jUpdateMouseSelection);
                            }
                            z = true;
                        }
                        if (z) {
                            ref$BooleanRef = new Ref$BooleanRef();
                            ref$BooleanRef.element = !marqueeSpacing$Companion$$ExternalSyntheticLambda0.equals(marqueeSpacing$Companion$$ExternalSyntheticLambda1);
                            long j4 = pointerInputChange2.id;
                            UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0 = new UtilsKt$$ExternalSyntheticLambda0((Object) mediaSessionImpl$2, (Object) marqueeSpacing$Companion$$ExternalSyntheticLambda0, (Object) ref$BooleanRef, (byte) 12);
                            selectionGesturesKt$mouseSelection$2.L$0 = pointerEventHandlerCoroutine2;
                            selectionGesturesKt$mouseSelection$2.L$1 = mediaSessionImpl$2;
                            selectionGesturesKt$mouseSelection$2.L$2 = ref$BooleanRef;
                            selectionGesturesKt$mouseSelection$2.label = 2;
                            objM91dragjO51t88 = ScrollableKt.m91dragjO51t88(pointerEventHandlerCoroutine2, j4, utilsKt$$ExternalSyntheticLambda0, selectionGesturesKt$mouseSelection$2);
                        }
                    }
                } else if (i2 == 1) {
                    mediaSessionImpl$2 = selectionGesturesKt$mouseSelection$2.L$1;
                    pointerEventHandlerCoroutine2 = selectionGesturesKt$mouseSelection$2.L$0;
                    ResultKt.throwOnFailure(objM91dragjO51t88);
                    if (((Boolean) objM91dragjO51t88).booleanValue()) {
                        list = SuspendingPointerInputModifierNodeImpl.this.currentEvent.changes;
                        size = list.size();
                        while (i3 < size) {
                            pointerInputChange = (PointerInputChange) list.get(i3);
                            if (PointerIconKt.changedToUp(pointerInputChange)) {
                                pointerInputChange.consume();
                            }
                            i3++;
                        }
                    }
                    mediaSessionImpl$2.onDragDone();
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    Ref$BooleanRef ref$BooleanRef2 = selectionGesturesKt$mouseSelection$2.L$2;
                    mediaSessionImpl$2 = selectionGesturesKt$mouseSelection$2.L$1;
                    SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine3 = selectionGesturesKt$mouseSelection$2.L$0;
                    ResultKt.throwOnFailure(objM91dragjO51t88);
                    ref$BooleanRef = ref$BooleanRef2;
                    pointerEventHandlerCoroutine2 = pointerEventHandlerCoroutine3;
                    if (((Boolean) objM91dragjO51t88).booleanValue() && ref$BooleanRef.element) {
                        List list2 = SuspendingPointerInputModifierNodeImpl.this.currentEvent.changes;
                        int size2 = list2.size();
                        while (i3 < size2) {
                            PointerInputChange pointerInputChange3 = (PointerInputChange) list2.get(i3);
                            if (PointerIconKt.changedToUp(pointerInputChange3)) {
                                pointerInputChange3.consume();
                            }
                            i3++;
                        }
                    }
                    mediaSessionImpl$2.onDragDone();
                }
                return Unit.INSTANCE;
            } catch (Throwable th) {
                mediaSessionImpl$2.onDragDone();
                throw th;
            }
        } catch (Throwable th2) {
            mediaSessionImpl$2.onDragDone();
            throw th2;
        }
    }

    /* JADX INFO: renamed from: plus-Nv-tHpc, reason: not valid java name */
    public static final long m846plusNvtHpc(long j, long j2) {
        return (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32)) + ((int) (j2 >> 32)))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) + ((int) (j2 & 4294967295L)))) & 4294967295L);
    }

    public static final String processForeignKeyCheckFailure$DBUtil__DBUtilKt(SQLiteStatement sQLiteStatement) {
        StringBuilder sb = new StringBuilder();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        do {
            if (i == 0) {
                sb.append("Foreign key violation(s) detected in '");
                sb.append(sQLiteStatement.getText(0));
                sb.append("'.\n");
            }
            String text = sQLiteStatement.getText(3);
            if (!linkedHashMap.containsKey(text)) {
                linkedHashMap.put(text, sQLiteStatement.getText(2));
            }
            i++;
        } while (sQLiteStatement.step());
        sb.append("Number of different violations discovered: ");
        sb.append(linkedHashMap.keySet().size());
        sb.append("\nNumber of rows in violation: ");
        sb.append(i);
        sb.append("\nViolation(s) detected in the following constraint(s):\n");
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            IntIntPair$$ExternalSyntheticOutline0.m6m(sb, "\tParent Table = ", (String) entry.getValue(), ", Foreign Key Constraint Index = ", (String) entry.getKey());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static final SnapFlingBehavior rememberSnapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider, GapComposer gapComposer) {
        Object obj = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
        DecayAnimationSpecImpl decayAnimationSpecImplRememberSplineBasedDecay = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(gapComposer);
        boolean zChanged = gapComposer.changed(obj) | gapComposer.changed(snapLayoutInfoProvider) | gapComposer.changed(decayAnimationSpecImplRememberSplineBasedDecay);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new SnapFlingBehavior(snapLayoutInfoProvider, decayAnimationSpecImplRememberSplineBasedDecay, ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, null, 5));
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (SnapFlingBehavior) objRememberedValue;
    }

    /* JADX INFO: renamed from: round-k-4lQ0M, reason: not valid java name */
    public static final long m847roundk4lQ0M(long j) {
        int iRound = Math.round(Float.intBitsToFloat((int) (j >> 32)));
        return (((long) Math.round(Float.intBitsToFloat((int) (j & 4294967295L)))) & 4294967295L) | (((long) iRound) << 32);
    }

    public static void setInitialSurroundingText(EditorInfo editorInfo, CharSequence charSequence) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            BuildCompat.Api30Impl.setInitialSurroundingSubText(editorInfo, charSequence);
            return;
        }
        charSequence.getClass();
        if (i >= 30) {
            BuildCompat.Api30Impl.setInitialSurroundingSubText(editorInfo, charSequence);
            return;
        }
        int i2 = editorInfo.initialSelStart;
        int i3 = editorInfo.initialSelEnd;
        int i4 = i2 > i3 ? i3 : i2;
        if (i2 <= i3) {
            i2 = i3;
        }
        int length = charSequence.length();
        if (i4 < 0 || i2 > length) {
            setSurroundingText(editorInfo, null, 0, 0);
            return;
        }
        int i5 = editorInfo.inputType & 4095;
        if (i5 == 129 || i5 == 225 || i5 == 18) {
            setSurroundingText(editorInfo, null, 0, 0);
            return;
        }
        if (length <= 2048) {
            setSurroundingText(editorInfo, charSequence, i4, i2);
            return;
        }
        int i6 = i2 - i4;
        int i7 = i6 > 1024 ? 0 : i6;
        int i8 = 2048 - i7;
        int iMin = Math.min(charSequence.length() - i2, i8 - Math.min(i4, (int) (((double) i8) * 0.8d)));
        int iMin2 = Math.min(i4, i8 - iMin);
        int i9 = i4 - iMin2;
        if (Character.isLowSurrogate(charSequence.charAt(i9))) {
            i9++;
            iMin2--;
        }
        if (Character.isHighSurrogate(charSequence.charAt((i2 + iMin) - 1))) {
            iMin--;
        }
        int i10 = iMin2 + i7;
        setSurroundingText(editorInfo, i7 != i6 ? TextUtils.concat(charSequence.subSequence(i9, i9 + iMin2), charSequence.subSequence(i2, iMin + i2)) : charSequence.subSequence(i9, i10 + iMin + i9), iMin2, i10);
    }

    public static void setSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int i, int i2) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i2);
    }

    public static final void throwSQLiteException(int i, String str) {
        throw new SQLException(IntIntPair$$ExternalSyntheticOutline0.m(i, "Error code: ").concat(", message: ".concat(str)));
    }

    public static final NetworkResponse toNetworkResponse(Response response) {
        BufferedSource bufferedSourceSource;
        int i = response.code;
        long j = response.sentRequestAtMillis;
        long j2 = response.receivedResponseAtMillis;
        Headers headers = response.headers;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = headers.iterator();
        while (true) {
            UIntArray.Iterator iterator = (UIntArray.Iterator) it;
            if (!iterator.hasNext()) {
                break;
            }
            Pair pair = (Pair) iterator.next();
            String str = (String) pair.first;
            String str2 = (String) pair.second;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            Object arrayList = linkedHashMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(lowerCase, arrayList);
            }
            ((List) arrayList).add(str2);
        }
        NetworkHeaders networkHeaders = new NetworkHeaders(MapsKt__MapsKt.toMap(linkedHashMap));
        ResponseBody responseBody = response.body;
        return new NetworkResponse(i, j, j2, networkHeaders, (responseBody == null || (bufferedSourceSource = responseBody.source()) == null) ? null : new SourceResponseBody(bufferedSourceSource), response);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0073  */
    /* JADX WARN: Code duplicated, block: B:26:0x008f A[LOOP:1: B:24:0x0089->B:26:0x008f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Request toRequest(NetworkRequest networkRequest, ContinuationImpl continuationImpl) {
        CallFactoryNetworkClientKt$toRequest$1 callFactoryNetworkClientKt$toRequest$1;
        Request.Builder builder;
        String str;
        Request.Builder builder2;
        NetworkRequest networkRequest2;
        RequestBody$Companion$toRequestBody$1 requestBody$Companion$toRequestBody$1;
        ArrayList arrayList;
        String str2;
        if (continuationImpl instanceof CallFactoryNetworkClientKt$toRequest$1) {
            callFactoryNetworkClientKt$toRequest$1 = (CallFactoryNetworkClientKt$toRequest$1) continuationImpl;
            int i = callFactoryNetworkClientKt$toRequest$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                callFactoryNetworkClientKt$toRequest$1.label = i - Integer.MIN_VALUE;
            } else {
                callFactoryNetworkClientKt$toRequest$1 = new CallFactoryNetworkClientKt$toRequest$1(continuationImpl);
            }
        } else {
            callFactoryNetworkClientKt$toRequest$1 = new CallFactoryNetworkClientKt$toRequest$1(continuationImpl);
        }
        Object obj = callFactoryNetworkClientKt$toRequest$1.result;
        int i2 = callFactoryNetworkClientKt$toRequest$1.label;
        Request.Builder builder3 = null;
        if (i2 != 0) {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            ByteString byteString = (ByteString) obj;
            if (byteString != null) {
                RequestBody.Companion.getClass();
                requestBody$Companion$toRequestBody$1 = new RequestBody$Companion$toRequestBody$1(null, byteString);
                networkRequest2 = null;
                builder2 = null;
                str = null;
            } else {
                networkRequest = null;
                builder = null;
                builder2 = null;
                str = null;
            }
            builder3.method(str, requestBody$Companion$toRequestBody$1);
            NetworkHeaders networkHeaders = networkRequest2.headers;
            arrayList = new ArrayList(20);
            for (Map.Entry entry : networkHeaders.data.entrySet()) {
                str2 = (String) entry.getKey();
                for (String str3 : (List) entry.getValue()) {
                    str2.getClass();
                    str3.getClass();
                    EntryPoints.headersCheckName(str2);
                    arrayList.add(str2);
                    arrayList.add(StringsKt.trim(str3).toString());
                }
            }
            Headers headers = new Headers((String[]) arrayList.toArray(new String[0]));
            builder2.getClass();
            builder2.headers = EntryPoints.commonNewBuilder(headers);
            return new Request(builder2);
        }
        ResultKt.throwOnFailure(obj);
        builder = new Request.Builder();
        builder.url(networkRequest.url);
        str = networkRequest.method;
        builder2 = builder;
        Request.Builder builder4 = builder;
        networkRequest2 = networkRequest;
        requestBody$Companion$toRequestBody$1 = null;
        builder3 = builder4;
        builder3.method(str, requestBody$Companion$toRequestBody$1);
        NetworkHeaders networkHeaders2 = networkRequest2.headers;
        arrayList = new ArrayList(20);
        while (r5.hasNext()) {
            str2 = (String) entry.getKey();
            while (r1.hasNext()) {
                str2.getClass();
                str3.getClass();
                EntryPoints.headersCheckName(str2);
                arrayList.add(str2);
                arrayList.add(StringsKt.trim(str3).toString());
            }
        }
        Headers headers2 = new Headers((String[]) arrayList.toArray(new String[0]));
        builder2.getClass();
        builder2.headers = EntryPoints.commonNewBuilder(headers2);
        return new Request(builder2);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m848toStringimpl(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        return Float.intBitsToFloat(i) == Float.intBitsToFloat(i2) ? IntIntPair$$ExternalSyntheticOutline0.m("CornerRadius.circular(", DatabaseDao_Impl.AnonymousClass17.toStringAsFixed(Float.intBitsToFloat(i)), ")") : Fragment$5$$ExternalSyntheticOutline0.m("CornerRadius.elliptical(", DatabaseDao_Impl.AnonymousClass17.toStringAsFixed(Float.intBitsToFloat(i)), ", ", DatabaseDao_Impl.AnonymousClass17.toStringAsFixed(Float.intBitsToFloat(i2)), ")");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009e, code lost:
    
        if (r15 == r6) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object touchSelectionFirstPress(SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine, TextDragObserver textDragObserver, PointerEvent pointerEvent, BaseContinuationImpl baseContinuationImpl) {
        SelectionGesturesKt$touchSelectionFirstPress$1 selectionGesturesKt$touchSelectionFirstPress$1;
        PointerInputChange pointerInputChange;
        if (baseContinuationImpl instanceof SelectionGesturesKt$touchSelectionFirstPress$1) {
            selectionGesturesKt$touchSelectionFirstPress$1 = (SelectionGesturesKt$touchSelectionFirstPress$1) baseContinuationImpl;
            int i = selectionGesturesKt$touchSelectionFirstPress$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                selectionGesturesKt$touchSelectionFirstPress$1.label = i - Integer.MIN_VALUE;
            } else {
                selectionGesturesKt$touchSelectionFirstPress$1 = new SelectionGesturesKt$touchSelectionFirstPress$1(baseContinuationImpl);
            }
        } else {
            selectionGesturesKt$touchSelectionFirstPress$1 = new SelectionGesturesKt$touchSelectionFirstPress$1(baseContinuationImpl);
        }
        Object objM87awaitLongPressOrCancellationrnUCldI = selectionGesturesKt$touchSelectionFirstPress$1.result;
        int i2 = selectionGesturesKt$touchSelectionFirstPress$1.label;
        byte b = 1;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objM87awaitLongPressOrCancellationrnUCldI);
                pointerInputChange = (PointerInputChange) CollectionsKt.first(pointerEvent.changes);
                long j = pointerInputChange.id;
                selectionGesturesKt$touchSelectionFirstPress$1.L$0 = pointerEventHandlerCoroutine;
                selectionGesturesKt$touchSelectionFirstPress$1.L$1 = textDragObserver;
                selectionGesturesKt$touchSelectionFirstPress$1.L$2 = pointerInputChange;
                selectionGesturesKt$touchSelectionFirstPress$1.label = 1;
                objM87awaitLongPressOrCancellationrnUCldI = ScrollableKt.m87awaitLongPressOrCancellationrnUCldI(pointerEventHandlerCoroutine, j, selectionGesturesKt$touchSelectionFirstPress$1);
                if (objM87awaitLongPressOrCancellationrnUCldI == coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (i2 == 1) {
                PointerInputChange pointerInputChange2 = selectionGesturesKt$touchSelectionFirstPress$1.L$2;
                textDragObserver = selectionGesturesKt$touchSelectionFirstPress$1.L$1;
                SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine2 = selectionGesturesKt$touchSelectionFirstPress$1.L$0;
                ResultKt.throwOnFailure(objM87awaitLongPressOrCancellationrnUCldI);
                pointerInputChange = pointerInputChange2;
                pointerEventHandlerCoroutine = pointerEventHandlerCoroutine2;
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                textDragObserver = selectionGesturesKt$touchSelectionFirstPress$1.L$1;
                pointerEventHandlerCoroutine = selectionGesturesKt$touchSelectionFirstPress$1.L$0;
                ResultKt.throwOnFailure(objM87awaitLongPressOrCancellationrnUCldI);
            }
            if (((Boolean) objM87awaitLongPressOrCancellationrnUCldI).booleanValue()) {
                List list = SuspendingPointerInputModifierNodeImpl.this.currentEvent.changes;
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    PointerInputChange pointerInputChange3 = (PointerInputChange) list.get(i3);
                    if (PointerIconKt.changedToUp(pointerInputChange3)) {
                        pointerInputChange3.consume();
                    }
                }
                textDragObserver.onStop();
            } else {
                textDragObserver.onCancel();
            }
            return Unit.INSTANCE;
            PointerInputChange pointerInputChange4 = (PointerInputChange) objM87awaitLongPressOrCancellationrnUCldI;
            if (pointerInputChange4 != null) {
                long j2 = pointerInputChange4.position;
                if (Offset.m435getDistanceimpl(Offset.m438minusMKHz9U(pointerInputChange.position, j2)) < ScrollableKt.m94pointerSlopE8SPZFQ(pointerEventHandlerCoroutine.getViewConfiguration(), pointerInputChange.type)) {
                    textDragObserver.mo202onStart3MmeM6k(j2, SelectionGestures_androidKt.FirstLongPressSelectionAdjustment);
                    long j3 = pointerInputChange4.id;
                    LongPressTextDragObserverKt$$ExternalSyntheticLambda0 longPressTextDragObserverKt$$ExternalSyntheticLambda0 = new LongPressTextDragObserverKt$$ExternalSyntheticLambda0(textDragObserver, b);
                    selectionGesturesKt$touchSelectionFirstPress$1.L$0 = pointerEventHandlerCoroutine;
                    selectionGesturesKt$touchSelectionFirstPress$1.L$1 = textDragObserver;
                    selectionGesturesKt$touchSelectionFirstPress$1.L$2 = null;
                    selectionGesturesKt$touchSelectionFirstPress$1.label = 2;
                    objM87awaitLongPressOrCancellationrnUCldI = ScrollableKt.m91dragjO51t88(pointerEventHandlerCoroutine, j3, longPressTextDragObserverKt$$ExternalSyntheticLambda0, selectionGesturesKt$touchSelectionFirstPress$1);
                }
            }
            return Unit.INSTANCE;
        } catch (CancellationException e) {
            textDragObserver.onCancel();
            throw e;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c1, code lost:
    
        if (r15 == r6) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object touchSelectionSubsequentPress(SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine, TextDragObserver textDragObserver, PointerEvent pointerEvent, int i, BaseContinuationImpl baseContinuationImpl) {
        SelectionGesturesKt$touchSelectionSubsequentPress$1 selectionGesturesKt$touchSelectionSubsequentPress$1;
        long j;
        Ref$LongRef ref$LongRef;
        if (baseContinuationImpl instanceof SelectionGesturesKt$touchSelectionSubsequentPress$1) {
            selectionGesturesKt$touchSelectionSubsequentPress$1 = (SelectionGesturesKt$touchSelectionSubsequentPress$1) baseContinuationImpl;
            int i2 = selectionGesturesKt$touchSelectionSubsequentPress$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                selectionGesturesKt$touchSelectionSubsequentPress$1.label = i2 - Integer.MIN_VALUE;
            } else {
                selectionGesturesKt$touchSelectionSubsequentPress$1 = new SelectionGesturesKt$touchSelectionSubsequentPress$1(baseContinuationImpl);
            }
        } else {
            selectionGesturesKt$touchSelectionSubsequentPress$1 = new SelectionGesturesKt$touchSelectionSubsequentPress$1(baseContinuationImpl);
        }
        Object objWithTimeoutOrNull = selectionGesturesKt$touchSelectionSubsequentPress$1.result;
        int i3 = selectionGesturesKt$touchSelectionSubsequentPress$1.label;
        Unit unit = Unit.INSTANCE;
        byte b = 2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(objWithTimeoutOrNull);
                PointerInputChange pointerInputChange = (PointerInputChange) CollectionsKt.first(pointerEvent.changes);
                j = pointerInputChange.id;
                textDragObserver.mo202onStart3MmeM6k(pointerInputChange.position, i > 2 ? SelectionAdjustment$Companion.Paragraph : SelectionAdjustment$Companion.Word);
                ref$LongRef = new Ref$LongRef();
                ref$LongRef.element = 9205357640488583168L;
                long longPressTimeoutMillis = pointerEventHandlerCoroutine.getViewConfiguration().getLongPressTimeoutMillis();
                TapGestureDetectorKt$awaitSecondDown$2 tapGestureDetectorKt$awaitSecondDown$2 = new TapGestureDetectorKt$awaitSecondDown$2(j, ref$LongRef, null);
                selectionGesturesKt$touchSelectionSubsequentPress$1.L$0 = pointerEventHandlerCoroutine;
                selectionGesturesKt$touchSelectionSubsequentPress$1.L$1 = textDragObserver;
                selectionGesturesKt$touchSelectionSubsequentPress$1.L$2 = ref$LongRef;
                selectionGesturesKt$touchSelectionSubsequentPress$1.J$0 = j;
                selectionGesturesKt$touchSelectionSubsequentPress$1.label = 1;
                objWithTimeoutOrNull = pointerEventHandlerCoroutine.withTimeoutOrNull(longPressTimeoutMillis, tapGestureDetectorKt$awaitSecondDown$2, selectionGesturesKt$touchSelectionSubsequentPress$1);
                if (objWithTimeoutOrNull == coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (i3 == 1) {
                long j2 = selectionGesturesKt$touchSelectionSubsequentPress$1.J$0;
                ref$LongRef = selectionGesturesKt$touchSelectionSubsequentPress$1.L$2;
                TextDragObserver textDragObserver2 = selectionGesturesKt$touchSelectionSubsequentPress$1.L$1;
                SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine2 = selectionGesturesKt$touchSelectionSubsequentPress$1.L$0;
                try {
                    ResultKt.throwOnFailure(objWithTimeoutOrNull);
                    j = j2;
                    textDragObserver = textDragObserver2;
                    pointerEventHandlerCoroutine = pointerEventHandlerCoroutine2;
                } catch (CancellationException e) {
                    e = e;
                    textDragObserver = textDragObserver2;
                    textDragObserver.onCancel();
                    throw e;
                }
            } else {
                if (i3 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                textDragObserver = selectionGesturesKt$touchSelectionSubsequentPress$1.L$1;
                pointerEventHandlerCoroutine = selectionGesturesKt$touchSelectionSubsequentPress$1.L$0;
                ResultKt.throwOnFailure(objWithTimeoutOrNull);
            }
            if (!((Boolean) objWithTimeoutOrNull).booleanValue()) {
                textDragObserver.onCancel();
                return unit;
            }
            List list = SuspendingPointerInputModifierNodeImpl.this.currentEvent.changes;
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                PointerInputChange pointerInputChange2 = (PointerInputChange) list.get(i4);
                if (PointerIconKt.changedToUp(pointerInputChange2)) {
                    pointerInputChange2.consume();
                }
            }
            textDragObserver.onStop();
            return unit;
            DownResolution downResolution = (DownResolution) objWithTimeoutOrNull;
            if (downResolution == null) {
                downResolution = DownResolution.Timeout;
            }
            if (downResolution == DownResolution.Cancel) {
                textDragObserver.onCancel();
                return unit;
            }
            if (downResolution == DownResolution.Up) {
                textDragObserver.onStop();
                return unit;
            }
            if (downResolution == DownResolution.Drag) {
                textDragObserver.mo201onDragk4lQ0M(ref$LongRef.element);
            }
            LongPressTextDragObserverKt$$ExternalSyntheticLambda0 longPressTextDragObserverKt$$ExternalSyntheticLambda0 = new LongPressTextDragObserverKt$$ExternalSyntheticLambda0(textDragObserver, b);
            selectionGesturesKt$touchSelectionSubsequentPress$1.L$0 = pointerEventHandlerCoroutine;
            selectionGesturesKt$touchSelectionSubsequentPress$1.L$1 = textDragObserver;
            selectionGesturesKt$touchSelectionSubsequentPress$1.L$2 = null;
            selectionGesturesKt$touchSelectionSubsequentPress$1.label = 2;
            objWithTimeoutOrNull = ScrollableKt.m91dragjO51t88(pointerEventHandlerCoroutine, j, longPressTextDragObserverKt$$ExternalSyntheticLambda0, selectionGesturesKt$touchSelectionSubsequentPress$1);
        } catch (CancellationException e2) {
            e = e2;
        }
    }

    public static final boolean tryAttachComposeStackTrace(Function0 function0, Throwable th) {
        List listAsList;
        Object objInvoke;
        th.getClass();
        Integer num = JDK7PlatformImplementations$ReflectSdkVersion.sdkVersion;
        DiagnosticComposeException diagnosticComposeException = null;
        if (num == null || num.intValue() >= 19) {
            Throwable[] suppressed = th.getSuppressed();
            suppressed.getClass();
            listAsList = Arrays.asList(suppressed);
            listAsList.getClass();
        } else {
            Method method = PlatformImplementations$ReflectThrowable.getSuppressed;
            if (method == null || (objInvoke = method.invoke(th, null)) == null) {
                listAsList = EmptyList.INSTANCE;
            } else {
                listAsList = Arrays.asList((Throwable[]) objInvoke);
                listAsList.getClass();
            }
        }
        int size = listAsList.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            if (((Throwable) listAsList.get(i)) instanceof DiagnosticComposeException) {
                return false;
            }
        }
        try {
            ComposeStackTrace composeStackTrace = (ComposeStackTrace) function0.invoke();
            if (composeStackTrace != null) {
                boolean z2 = composeStackTrace.hasSourceInformation;
                List list = composeStackTrace.frames;
                if (z2) {
                    int size2 = list.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        if (((ComposeStackTraceFrame) list.get(i2)).sourceInfo != null) {
                            z = true;
                            break;
                        }
                    }
                } else if (!list.isEmpty()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                composeStackTrace.getClass();
                diagnosticComposeException = new DiagnosticComposeException(composeStackTrace);
            }
        } catch (Throwable th2) {
            diagnosticComposeException = th2;
        }
        if (diagnosticComposeException != null) {
            ResultKt.addSuppressed(th, diagnosticComposeException);
        }
        return z;
    }

    public static final int visibleLinesAverageMainAxisSize(LazyGridMeasureResult lazyGridMeasureResult) {
        Orientation orientation = lazyGridMeasureResult.orientation;
        List list = lazyGridMeasureResult.visibleItemsInfo;
        boolean z = orientation == Orientation.Vertical;
        if (list.isEmpty()) {
            return 0;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < list.size()) {
            LazyGridMeasuredItem lazyGridMeasuredItem = (LazyGridMeasuredItem) list.get(i);
            int i4 = z ? lazyGridMeasuredItem.row : lazyGridMeasuredItem.column;
            if (i4 == -1) {
                i++;
            } else {
                int iMax = 0;
                while (i < list.size()) {
                    LazyGridMeasuredItem lazyGridMeasuredItem2 = (LazyGridMeasuredItem) list.get(i);
                    if ((z ? lazyGridMeasuredItem2.row : lazyGridMeasuredItem2.column) != i4) {
                        break;
                    }
                    iMax = Math.max(iMax, (int) (z ? ((LazyGridMeasuredItem) list.get(i)).size & 4294967295L : ((LazyGridMeasuredItem) list.get(i)).size >> 32));
                    i++;
                }
                i2 += iMax;
                i3++;
            }
        }
        return (i2 / i3) + lazyGridMeasureResult.mainAxisItemSpacing;
    }

    public boolean contains$ui(ProvidableModifierLocal providableModifierLocal) {
        return false;
    }

    public Metadata decode(MetadataInputBuffer metadataInputBuffer) {
        ByteBuffer byteBuffer = metadataInputBuffer.data;
        byteBuffer.getClass();
        UtilsKt.checkArgument(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        return decode(metadataInputBuffer, byteBuffer);
    }

    public abstract Metadata decode(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer);

    public abstract String decodeUtf8(byte[] bArr, int i, int i2);

    public abstract int encodeUtf8(String str, byte[] bArr, int i, int i2);

    public Object get$ui() {
        throw new IllegalStateException("");
    }
}
