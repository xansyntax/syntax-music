package androidx.navigation.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.collection.ArraySetKt;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.SparseArrayCompat;
import androidx.compose.material3.MenuKt$$ExternalSyntheticLambda2;
import androidx.compose.ui.node.RulerTrackingMap;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.media3.extractor.text.CueDecoder;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavBackStackEntryState;
import androidx.navigation.NavController$NavControllerNavigatorState;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.compose.DialogNavigator;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda2;
import coil3.util.FileSystemsKt;
import coil3.util.UtilsKt;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda2;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda59;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda40;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.FilteringSequence;
import kotlin.sequences.GeneratorSequence;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.TransformingSequence;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.json.internal.JsonPath;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavControllerImpl {
    public final StateFlowImpl _currentBackStack;
    public final SharedFlowImpl _currentBackStackEntryFlow;
    public NavGraph _graph;
    public final NavigatorProvider _navigatorProvider;
    public final StateFlowImpl _visibleEntries;
    public Function1 addToBackStackHandler;
    public final ArrayDeque backQueue = new ArrayDeque();
    public final ArrayList backStackEntriesToDispatch;
    public final LinkedHashMap backStackMap;
    public final LinkedHashMap backStackStates;
    public Bundle[] backStackToRestore;
    public final LinkedHashMap childToParentEntries;
    public int dispatchReentrantCount;
    public final LinkedHashMap entrySavedState;
    public Lifecycle.State hostLifecycleState;
    public final NavControllerImpl$$ExternalSyntheticLambda3 lifecycleObserver;
    public LifecycleOwner lifecycleOwner;
    public final NavHostController navController;
    public final LinkedHashMap navigatorState;
    public Bundle navigatorStateToRestore;
    public final ArrayList onDestinationChangedListeners;
    public final LinkedHashMap parentToChildCount;
    public MenuKt$$ExternalSyntheticLambda2 popFromBackStackHandler;
    public final MainActivity$$ExternalSyntheticLambda2 updateOnBackPressedCallbackEnabledCallback;
    public NavControllerViewModel viewModel;
    public final ReadonlyStateFlow visibleEntries;

    public NavControllerImpl(NavHostController navHostController, MainActivity$$ExternalSyntheticLambda2 mainActivity$$ExternalSyntheticLambda2) {
        this.navController = navHostController;
        this.updateOnBackPressedCallbackEnabledCallback = mainActivity$$ExternalSyntheticLambda2;
        EmptyList emptyList = EmptyList.INSTANCE;
        this._currentBackStack = StateFlowKt.MutableStateFlow(emptyList);
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(emptyList);
        this._visibleEntries = stateFlowImplMutableStateFlow;
        this.visibleEntries = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        this.childToParentEntries = new LinkedHashMap();
        this.parentToChildCount = new LinkedHashMap();
        this.backStackMap = new LinkedHashMap();
        this.backStackStates = new LinkedHashMap();
        this.onDestinationChangedListeners = new ArrayList();
        this.hostLifecycleState = Lifecycle.State.INITIALIZED;
        this.lifecycleObserver = new NavControllerImpl$$ExternalSyntheticLambda3((byte) 0, this);
        this._navigatorProvider = new NavigatorProvider();
        this.navigatorState = new LinkedHashMap();
        this.entrySavedState = new LinkedHashMap();
        this.backStackEntriesToDispatch = new ArrayList();
        this._currentBackStackEntryFlow = StateFlowKt.MutableSharedFlow$default(0, 2, BufferOverflow.DROP_OLDEST);
    }

    public static NavDestination findDestinationComprehensive$navigation_runtime_release(int i, NavDestination navDestination, NavDestination navDestination2, boolean z) {
        if (navDestination.impl.size == i && (navDestination2 == null || (navDestination.equals(navDestination2) && Intrinsics.areEqual(navDestination.parent, navDestination2.parent)))) {
            return navDestination;
        }
        NavGraph navGraph = navDestination instanceof NavGraph ? (NavGraph) navDestination : null;
        if (navGraph == null) {
            navGraph = navDestination.parent;
            navGraph.getClass();
        }
        return navGraph.impl.findNodeComprehensive$navigation_common_release(i, navGraph, navDestination2, z);
    }

    public static /* synthetic */ void popEntryFromBackStack$navigation_runtime_release$default(NavControllerImpl navControllerImpl, NavBackStackEntry navBackStackEntry) {
        navControllerImpl.popEntryFromBackStack$navigation_runtime_release(navBackStackEntry, false, new ArrayDeque());
    }

    public final void addEntryToBackStack(NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List list) {
        Object objPrevious;
        Object objPrevious2;
        NavContext navContext = this.navController.navContext;
        NavDestination navDestination2 = navBackStackEntry.destination;
        boolean z = navDestination2 instanceof DialogNavigator.Destination;
        ArrayDeque arrayDeque = this.backQueue;
        if (!z) {
            while (!arrayDeque.isEmpty() && (((NavBackStackEntry) arrayDeque.last()).destination instanceof DialogNavigator.Destination) && popBackStackInternal$navigation_runtime_release(((NavBackStackEntry) arrayDeque.last()).destination.impl.size, true, false)) {
            }
        }
        ArrayDeque<NavBackStackEntry> arrayDeque2 = new ArrayDeque();
        Object obj = null;
        if (navDestination instanceof NavGraph) {
            NavDestination navDestination3 = navDestination2;
            do {
                navDestination3.getClass();
                navDestination3 = navDestination3.parent;
                if (navDestination3 != null) {
                    ListIterator listIterator = list.listIterator(list.size());
                    do {
                        if (!listIterator.hasPrevious()) {
                            objPrevious2 = null;
                            break;
                        }
                        objPrevious2 = listIterator.previous();
                    } while (!Intrinsics.areEqual(((NavBackStackEntry) objPrevious2).destination, navDestination3));
                    NavBackStackEntry navBackStackEntryCreate$default = (NavBackStackEntry) objPrevious2;
                    if (navBackStackEntryCreate$default == null) {
                        navBackStackEntryCreate$default = CueDecoder.create$default(navContext, navDestination3, bundle, getHostLifecycleState$navigation_runtime_release(), this.viewModel);
                    }
                    arrayDeque2.addFirst(navBackStackEntryCreate$default);
                    if (!arrayDeque.isEmpty() && ((NavBackStackEntry) arrayDeque.last()).destination == navDestination3) {
                        popEntryFromBackStack$navigation_runtime_release$default(this, (NavBackStackEntry) arrayDeque.last());
                    }
                }
                if (navDestination3 == null) {
                    break;
                }
            } while (navDestination3 != navDestination);
        }
        NavDestination navDestination4 = arrayDeque2.isEmpty() ? navDestination2 : ((NavBackStackEntry) arrayDeque2.first()).destination;
        while (navDestination4 != null && findDestination$navigation_runtime_release(navDestination4.impl.size, navDestination4) != navDestination4) {
            navDestination4 = navDestination4.parent;
            if (navDestination4 != null) {
                Bundle bundle2 = (bundle == null || !bundle.isEmpty()) ? bundle : null;
                ListIterator listIterator2 = list.listIterator(list.size());
                do {
                    if (!listIterator2.hasPrevious()) {
                        objPrevious = null;
                        break;
                    }
                    objPrevious = listIterator2.previous();
                } while (!Intrinsics.areEqual(((NavBackStackEntry) objPrevious).destination, navDestination4));
                NavBackStackEntry navBackStackEntryCreate$default2 = (NavBackStackEntry) objPrevious;
                if (navBackStackEntryCreate$default2 == null) {
                    navBackStackEntryCreate$default2 = CueDecoder.create$default(navContext, navDestination4, navDestination4.addInDefaultArgs(bundle2), getHostLifecycleState$navigation_runtime_release(), this.viewModel);
                }
                arrayDeque2.addFirst(navBackStackEntryCreate$default2);
            }
        }
        if (!arrayDeque2.isEmpty()) {
            navDestination2 = ((NavBackStackEntry) arrayDeque2.first()).destination;
        }
        while (!arrayDeque.isEmpty() && (((NavBackStackEntry) arrayDeque.last()).destination instanceof NavGraph)) {
            NavDestination navDestination5 = ((NavBackStackEntry) arrayDeque.last()).destination;
            navDestination5.getClass();
            if (ArraySetKt.commonGet((SparseArrayCompat) ((NavGraph) navDestination5).impl.nodes, navDestination2.impl.size) != null) {
                break;
            } else {
                popEntryFromBackStack$navigation_runtime_release$default(this, (NavBackStackEntry) arrayDeque.last());
            }
        }
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) arrayDeque.firstOrNull();
        if (navBackStackEntry2 == null) {
            navBackStackEntry2 = (NavBackStackEntry) arrayDeque2.firstOrNull();
        }
        if (!Intrinsics.areEqual(navBackStackEntry2 != null ? navBackStackEntry2.destination : null, this._graph)) {
            ListIterator listIterator3 = list.listIterator(list.size());
            while (listIterator3.hasPrevious()) {
                Object objPrevious3 = listIterator3.previous();
                NavDestination navDestination6 = ((NavBackStackEntry) objPrevious3).destination;
                NavGraph navGraph = this._graph;
                navGraph.getClass();
                if (Intrinsics.areEqual(navDestination6, navGraph)) {
                    obj = objPrevious3;
                    break;
                }
            }
            NavBackStackEntry navBackStackEntryCreate$default3 = (NavBackStackEntry) obj;
            if (navBackStackEntryCreate$default3 == null) {
                NavGraph navGraph2 = this._graph;
                navGraph2.getClass();
                NavGraph navGraph3 = this._graph;
                navGraph3.getClass();
                navBackStackEntryCreate$default3 = CueDecoder.create$default(navContext, navGraph2, navGraph3.addInDefaultArgs(bundle), getHostLifecycleState$navigation_runtime_release(), this.viewModel);
            }
            arrayDeque2.addFirst(navBackStackEntryCreate$default3);
        }
        for (NavBackStackEntry navBackStackEntry3 : arrayDeque2) {
            Object obj2 = this.navigatorState.get(this._navigatorProvider.getNavigator(navBackStackEntry3.destination.navigatorName));
            if (obj2 == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m((Object) IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder("NavigatorBackStack for "), navDestination.navigatorName, " should already be created"));
                return;
            }
            ((NavController$NavControllerNavigatorState) obj2).addInternal(navBackStackEntry3);
        }
        arrayDeque.addAll(arrayDeque2);
        arrayDeque.addLast(navBackStackEntry);
        ArrayList arrayListPlus = CollectionsKt.plus(navBackStackEntry, arrayDeque2);
        int size = arrayListPlus.size();
        int i = 0;
        while (i < size) {
            Object obj3 = arrayListPlus.get(i);
            i++;
            NavBackStackEntry navBackStackEntry4 = (NavBackStackEntry) obj3;
            NavGraph navGraph4 = navBackStackEntry4.destination.parent;
            if (navGraph4 != null) {
                linkChildToParent$navigation_runtime_release(navBackStackEntry4, getBackStackEntry$navigation_runtime_release(((NavDestination) navGraph4).impl.size));
            }
        }
    }

    public final boolean dispatchOnDestinationChanged$navigation_runtime_release() {
        ArrayDeque arrayDeque;
        while (true) {
            arrayDeque = this.backQueue;
            if (arrayDeque.isEmpty() || !(((NavBackStackEntry) arrayDeque.last()).destination instanceof NavGraph)) {
                break;
            }
            popEntryFromBackStack$navigation_runtime_release$default(this, (NavBackStackEntry) arrayDeque.last());
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) arrayDeque.lastOrNull();
        ArrayList arrayList = this.backStackEntriesToDispatch;
        if (navBackStackEntry != null) {
            arrayList.add(navBackStackEntry);
        }
        this.dispatchReentrantCount++;
        updateBackStackLifecycle$navigation_runtime_release();
        int i = this.dispatchReentrantCount - 1;
        this.dispatchReentrantCount = i;
        if (i == 0) {
            ArrayList mutableList = CollectionsKt.toMutableList((Collection) arrayList);
            arrayList.clear();
            int size = mutableList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = mutableList.get(i2);
                i2++;
                NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) obj;
                Iterator it = this.onDestinationChangedListeners.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        PathKt$$ExternalSyntheticBUOutline0.m();
                        return false;
                    }
                    NavDestination navDestination = navBackStackEntry2.destination;
                    navBackStackEntry2.impl.getArguments$navigation_common_release();
                    throw null;
                }
                this._currentBackStackEntryFlow.tryEmit(navBackStackEntry2);
            }
            ArrayList arrayList2 = new ArrayList(arrayDeque);
            StateFlowImpl stateFlowImpl = this._currentBackStack;
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, arrayList2);
            ArrayList arrayListPopulateVisibleEntries$navigation_runtime_release = populateVisibleEntries$navigation_runtime_release();
            StateFlowImpl stateFlowImpl2 = this._visibleEntries;
            stateFlowImpl2.getClass();
            stateFlowImpl2.updateState(null, arrayListPopulateVisibleEntries$navigation_runtime_release);
        }
        return navBackStackEntry != null;
    }

    public final boolean executePopOperations$navigation_runtime_release(ArrayList arrayList, NavDestination navDestination, boolean z, boolean z2) {
        boolean z3;
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ArrayDeque arrayDeque = new ArrayDeque();
        int size = arrayList.size();
        final byte b = 0;
        int i = 0;
        while (true) {
            if (i >= size) {
                z3 = z2;
                break;
            }
            int i2 = i + 1;
            Navigator navigator = (Navigator) arrayList.get(i);
            Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.backQueue.last();
            z3 = z2;
            MenuKt$$ExternalSyntheticLambda2 menuKt$$ExternalSyntheticLambda2 = new MenuKt$$ExternalSyntheticLambda2(ref$BooleanRef2, ref$BooleanRef, this, z3, arrayDeque);
            navigator.getClass();
            navBackStackEntry.getClass();
            this.popFromBackStackHandler = menuKt$$ExternalSyntheticLambda2;
            navigator.popBackStack(navBackStackEntry, z3);
            this.popFromBackStackHandler = null;
            if (!ref$BooleanRef2.element) {
                break;
            }
            i = i2;
        }
        if (z3) {
            LinkedHashMap linkedHashMap = this.backStackMap;
            if (!z) {
                FilteringSequence.AnonymousClass1 anonymousClass1 = new FilteringSequence.AnonymousClass1(new GeneratorSequence(SequencesKt.generateSequence(navDestination, new RoomDatabase$$ExternalSyntheticLambda2((byte) 16)), new Function1(this) { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda6
                    public final /* synthetic */ NavControllerImpl f$0;

                    {
                        this.f$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        boolean zContainsKey;
                        byte b2 = b;
                        NavControllerImpl navControllerImpl = this.f$0;
                        NavDestination navDestination2 = (NavDestination) obj;
                        switch (b2) {
                            case 0:
                                navDestination2.getClass();
                                zContainsKey = navControllerImpl.backStackMap.containsKey(Integer.valueOf(navDestination2.impl.size));
                                break;
                            default:
                                navDestination2.getClass();
                                zContainsKey = navControllerImpl.backStackMap.containsKey(Integer.valueOf(navDestination2.impl.size));
                                break;
                        }
                        return Boolean.valueOf(!zContainsKey);
                    }
                }));
                while (anonymousClass1.hasNext()) {
                    Integer numValueOf = Integer.valueOf(((NavDestination) anonymousClass1.next()).impl.size);
                    NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) arrayDeque.firstOrNull();
                    linkedHashMap.put(numValueOf, navBackStackEntryState != null ? (String) navBackStackEntryState.impl.configuration : null);
                }
            }
            if (!arrayDeque.isEmpty()) {
                JsonPath jsonPath = ((NavBackStackEntryState) arrayDeque.first()).impl;
                String str = (String) jsonPath.configuration;
                final byte b2 = 1;
                FilteringSequence.AnonymousClass1 anonymousClass2 = new FilteringSequence.AnonymousClass1(new GeneratorSequence(SequencesKt.generateSequence(findDestination$navigation_runtime_release(jsonPath.currentDepth, null), new RoomDatabase$$ExternalSyntheticLambda2((byte) 17)), new Function1(this) { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda6
                    public final /* synthetic */ NavControllerImpl f$0;

                    {
                        this.f$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        boolean zContainsKey;
                        byte b3 = b2;
                        NavControllerImpl navControllerImpl = this.f$0;
                        NavDestination navDestination2 = (NavDestination) obj;
                        switch (b3) {
                            case 0:
                                navDestination2.getClass();
                                zContainsKey = navControllerImpl.backStackMap.containsKey(Integer.valueOf(navDestination2.impl.size));
                                break;
                            default:
                                navDestination2.getClass();
                                zContainsKey = navControllerImpl.backStackMap.containsKey(Integer.valueOf(navDestination2.impl.size));
                                break;
                        }
                        return Boolean.valueOf(!zContainsKey);
                    }
                }));
                while (anonymousClass2.hasNext()) {
                    linkedHashMap.put(Integer.valueOf(((NavDestination) anonymousClass2.next()).impl.size), str);
                }
                if (linkedHashMap.values().contains(str)) {
                    this.backStackStates.put(str, arrayDeque);
                }
            }
        }
        this.updateOnBackPressedCallbackEnabledCallback.invoke();
        return ref$BooleanRef.element;
    }

    public final NavDestination findDestination$navigation_runtime_release(int i, NavDestination navDestination) {
        NavDestination navDestination2;
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            return null;
        }
        if (((NavDestination) navGraph).impl.size == i) {
            if (navDestination == null) {
                return navGraph;
            }
            if (Intrinsics.areEqual(navGraph, navDestination) && navDestination.parent == null) {
                return this._graph;
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.backQueue.lastOrNull();
        if (navBackStackEntry == null || (navDestination2 = navBackStackEntry.destination) == null) {
            navDestination2 = this._graph;
            navDestination2.getClass();
        }
        return findDestinationComprehensive$navigation_runtime_release(i, navDestination2, navDestination, false);
    }

    public final NavBackStackEntry getBackStackEntry$navigation_runtime_release(int i) {
        Object objPrevious;
        ArrayDeque arrayDeque = this.backQueue;
        ListIterator<E> listIterator = arrayDeque.listIterator(arrayDeque.size());
        do {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
        } while (((NavBackStackEntry) objPrevious).destination.impl.size != i);
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) objPrevious;
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        StringBuilder sbM2m = IntIntPair$$ExternalSyntheticOutline0.m2m(i, "No destination with ID ", " is on the NavController's back stack. The current destination is ");
        sbM2m.append(getCurrentDestination$navigation_runtime_release());
        throw new IllegalArgumentException(sbM2m.toString().toString());
    }

    public final NavBackStackEntry getCurrentBackStackEntry$navigation_runtime_release() {
        return (NavBackStackEntry) this.backQueue.lastOrNull();
    }

    public final NavDestination getCurrentDestination$navigation_runtime_release() {
        NavBackStackEntry currentBackStackEntry$navigation_runtime_release = getCurrentBackStackEntry$navigation_runtime_release();
        if (currentBackStackEntry$navigation_runtime_release != null) {
            return currentBackStackEntry$navigation_runtime_release.destination;
        }
        return null;
    }

    public final NavGraph getGraph$navigation_runtime_release() {
        NavGraph navGraph = this._graph;
        if (navGraph != null) {
            navGraph.getClass();
            return navGraph;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("You must call setGraph() before calling getGraph()");
        return null;
    }

    public final Lifecycle.State getHostLifecycleState$navigation_runtime_release() {
        return this.lifecycleOwner == null ? Lifecycle.State.CREATED : this.hostLifecycleState;
    }

    public final NavGraph getTopGraph$navigation_runtime_release() {
        NavDestination navDestination;
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.backQueue.lastOrNull();
        if (navBackStackEntry == null || (navDestination = navBackStackEntry.destination) == null) {
            navDestination = this._graph;
            navDestination.getClass();
        }
        NavGraph navGraph = navDestination instanceof NavGraph ? (NavGraph) navDestination : null;
        if (navGraph != null) {
            return navGraph;
        }
        NavGraph navGraph2 = navDestination.parent;
        navGraph2.getClass();
        return navGraph2;
    }

    public final void linkChildToParent$navigation_runtime_release(NavBackStackEntry navBackStackEntry, NavBackStackEntry navBackStackEntry2) {
        this.childToParentEntries.put(navBackStackEntry, navBackStackEntry2);
        LinkedHashMap linkedHashMap = this.parentToChildCount;
        if (linkedHashMap.get(navBackStackEntry2) == null) {
            linkedHashMap.put(navBackStackEntry2, new AtomicInt());
        }
        Object obj = linkedHashMap.get(navBackStackEntry2);
        obj.getClass();
        ((AtomicInt) obj).atomicInt.incrementAndGet();
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0276  */
    /* JADX WARN: Code duplicated, block: B:124:0x0232 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:135:0x01ff A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x0228 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x0209 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:141:0x025e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:142:0x0265 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:143:? A[LOOP:7: B:94:0x0248->B:143:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:71:0x0182  */
    /* JADX WARN: Code duplicated, block: B:74:0x018f A[LOOP:4: B:72:0x0187->B:74:0x018f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:78:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:80:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:85:0x020f  */
    /* JADX WARN: Code duplicated, block: B:88:0x0224  */
    /* JADX WARN: Code duplicated, block: B:96:0x024e A[Catch: all -> 0x0263, TryCatch #0 {all -> 0x0263, blocks: (B:93:0x0232, B:94:0x0248, B:96:0x024e, B:98:0x025e, B:102:0x0266), top: B:124:0x0232 }] */
    public final void navigate$navigation_runtime_release(NavDestination navDestination, Bundle bundle, NavOptions navOptions) {
        boolean z;
        boolean z2;
        int iNextIndex;
        NavDestination navDestination2;
        ArrayDeque<NavBackStackEntry> arrayDeque;
        Navigator navigator;
        NavDestination navDestination3;
        NavController$NavControllerNavigatorState state;
        ListIterator listIterator;
        int iNextIndex2;
        NavGraph navGraph;
        boolean zPopBackStackInternal$navigation_runtime_release;
        Object objPrevious;
        boolean zHasRoute;
        navDestination.getClass();
        Iterator it = this.navigatorState.values().iterator();
        while (it.hasNext()) {
            ((NavController$NavControllerNavigatorState) it.next()).isNavigating = true;
        }
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        if (navOptions == null) {
            z = false;
        } else {
            String str = navOptions.popUpToRoute;
            if (str != null) {
                boolean z3 = navOptions.popUpToInclusive;
                boolean z4 = navOptions.popUpToSaveState;
                str.getClass();
                ArrayDeque arrayDeque2 = this.backQueue;
                if (arrayDeque2.isEmpty()) {
                    zPopBackStackInternal$navigation_runtime_release = false;
                } else {
                    ArrayList arrayList = new ArrayList();
                    ListIterator listIterator2 = arrayDeque2.listIterator(arrayDeque2.getSize());
                    do {
                        if (!listIterator2.hasPrevious()) {
                            objPrevious = null;
                            break;
                        }
                        objPrevious = listIterator2.previous();
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) objPrevious;
                        zHasRoute = navBackStackEntry.destination.hasRoute(str, navBackStackEntry.impl.getArguments$navigation_common_release());
                        if (z3 || !zHasRoute) {
                            arrayList.add(this._navigatorProvider.getNavigator(navBackStackEntry.destination.navigatorName));
                        }
                    } while (!zHasRoute);
                    NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) objPrevious;
                    NavDestination navDestination4 = navBackStackEntry2 != null ? navBackStackEntry2.destination : null;
                    if (navDestination4 == null) {
                        Log.i("NavController", "Ignoring popBackStack to route " + str + " as it was not found on the current back stack");
                        zPopBackStackInternal$navigation_runtime_release = false;
                    } else {
                        zPopBackStackInternal$navigation_runtime_release = executePopOperations$navigation_runtime_release(arrayList, navDestination4, z3, z4);
                    }
                }
            } else {
                int i = navOptions.popUpToId;
                if (i != -1) {
                    zPopBackStackInternal$navigation_runtime_release = popBackStackInternal$navigation_runtime_release(i, navOptions.popUpToInclusive, navOptions.popUpToSaveState);
                } else {
                    z = false;
                }
            }
            z = zPopBackStackInternal$navigation_runtime_release;
        }
        Bundle bundleAddInDefaultArgs = navDestination.addInDefaultArgs(bundle);
        if (navOptions != null && navOptions.restoreState && this.backStackMap.containsKey(Integer.valueOf(navDestination.impl.size))) {
            ref$BooleanRef.element = restoreStateInternal(navDestination.impl.size, bundleAddInDefaultArgs, navOptions);
            z2 = false;
        } else {
            if (navOptions == null || !navOptions.singleTop) {
                z2 = false;
            } else {
                NavBackStackEntry currentBackStackEntry$navigation_runtime_release = getCurrentBackStackEntry$navigation_runtime_release();
                ArrayDeque arrayDeque3 = this.backQueue;
                ListIterator listIterator3 = arrayDeque3.listIterator(arrayDeque3.getSize());
                while (true) {
                    if (listIterator3.hasPrevious()) {
                        if (((NavBackStackEntry) listIterator3.previous()).destination == navDestination) {
                            iNextIndex = listIterator3.nextIndex();
                            break;
                        }
                    } else {
                        iNextIndex = -1;
                        break;
                    }
                }
                if (iNextIndex == -1) {
                    z2 = false;
                } else if (navDestination instanceof NavGraph) {
                    int i2 = NavGraph.$r8$clinit;
                    List list = SequencesKt.toList(new TransformingSequence(SequencesKt.generateSequence((NavGraph) navDestination, new RoomDatabase$$ExternalSyntheticLambda2((byte) 10)), new RoomDatabase$$ExternalSyntheticLambda2((byte) 15)));
                    if (this.backQueue.size - iNextIndex == list.size()) {
                        ArrayDeque arrayDeque4 = this.backQueue;
                        List listSubList = arrayDeque4.subList(iNextIndex, arrayDeque4.size);
                        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSubList, 10));
                        Iterator it2 = listSubList.iterator();
                        while (it2.hasNext()) {
                            arrayList2.add(Integer.valueOf(((NavBackStackEntry) it2.next()).destination.impl.size));
                        }
                        if (arrayList2.equals(list)) {
                            arrayDeque = new ArrayDeque();
                            while (CollectionsKt__IterablesKt.getLastIndex(this.backQueue) >= iNextIndex) {
                                NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) CollectionsKt__MutableCollectionsKt.removeLast(this.backQueue);
                                unlinkChildFromParent$navigation_runtime_release(navBackStackEntry3);
                                NavBackStackEntry navBackStackEntry4 = new NavBackStackEntry(navBackStackEntry3.context, navBackStackEntry3.destination, navBackStackEntry3.destination.addInDefaultArgs(bundle), navBackStackEntry3.hostLifecycleState, navBackStackEntry3.viewModelStoreProvider, navBackStackEntry3.id, navBackStackEntry3.savedState);
                                NavBackStackEntryImpl navBackStackEntryImpl = navBackStackEntry4.impl;
                                Lifecycle.State state2 = navBackStackEntry3.hostLifecycleState;
                                navBackStackEntryImpl.getClass();
                                state2.getClass();
                                navBackStackEntryImpl.hostLifecycleState = state2;
                                NavBackStackEntryImpl navBackStackEntryImpl2 = navBackStackEntry4.impl;
                                navBackStackEntryImpl2.maxLifecycle = navBackStackEntry3.impl.maxLifecycle;
                                navBackStackEntryImpl2.updateState$navigation_common_release();
                                arrayDeque.addFirst(navBackStackEntry4);
                            }
                            for (NavBackStackEntry navBackStackEntry5 : arrayDeque) {
                                navGraph = navBackStackEntry5.destination.parent;
                                if (navGraph != null) {
                                    linkChildToParent$navigation_runtime_release(navBackStackEntry5, getBackStackEntry$navigation_runtime_release(((NavDestination) navGraph).impl.size));
                                }
                                this.backQueue.addLast(navBackStackEntry5);
                            }
                            for (NavBackStackEntry navBackStackEntry6 : arrayDeque) {
                                navigator = this._navigatorProvider.getNavigator(navBackStackEntry6.destination.navigatorName);
                                navDestination3 = navBackStackEntry6.destination;
                                if (navDestination3 == null) {
                                    navDestination3 = null;
                                }
                                if (navDestination3 == null) {
                                    navigator.navigate(navDestination3);
                                    state = navigator.getState();
                                    synchronized (state.backStackLock) {
                                        try {
                                            ArrayList mutableList = CollectionsKt.toMutableList((Collection) state.backStack.$$delegate_0.getValue());
                                            listIterator = mutableList.listIterator(mutableList.size());
                                            while (true) {
                                                if (listIterator.hasPrevious()) {
                                                    if (((NavBackStackEntry) listIterator.previous()).id.equals(navBackStackEntry6.id)) {
                                                        iNextIndex2 = listIterator.nextIndex();
                                                        break;
                                                    }
                                                } else {
                                                    iNextIndex2 = -1;
                                                    break;
                                                }
                                            }
                                            mutableList.set(iNextIndex2, navBackStackEntry6);
                                            state._backStack.updateState(null, mutableList);
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                    }
                                }
                            }
                            z2 = true;
                        }
                    }
                    z2 = false;
                } else if (currentBackStackEntry$navigation_runtime_release == null || (navDestination2 = currentBackStackEntry$navigation_runtime_release.destination) == null || navDestination.impl.size != navDestination2.impl.size) {
                    z2 = false;
                } else {
                    arrayDeque = new ArrayDeque();
                    while (CollectionsKt__IterablesKt.getLastIndex(this.backQueue) >= iNextIndex) {
                        NavBackStackEntry navBackStackEntry7 = (NavBackStackEntry) CollectionsKt__MutableCollectionsKt.removeLast(this.backQueue);
                        unlinkChildFromParent$navigation_runtime_release(navBackStackEntry7);
                        NavBackStackEntry navBackStackEntry8 = new NavBackStackEntry(navBackStackEntry7.context, navBackStackEntry7.destination, navBackStackEntry7.destination.addInDefaultArgs(bundle), navBackStackEntry7.hostLifecycleState, navBackStackEntry7.viewModelStoreProvider, navBackStackEntry7.id, navBackStackEntry7.savedState);
                        NavBackStackEntryImpl navBackStackEntryImpl3 = navBackStackEntry8.impl;
                        Lifecycle.State state3 = navBackStackEntry7.hostLifecycleState;
                        navBackStackEntryImpl3.getClass();
                        state3.getClass();
                        navBackStackEntryImpl3.hostLifecycleState = state3;
                        NavBackStackEntryImpl navBackStackEntryImpl4 = navBackStackEntry8.impl;
                        navBackStackEntryImpl4.maxLifecycle = navBackStackEntry7.impl.maxLifecycle;
                        navBackStackEntryImpl4.updateState$navigation_common_release();
                        arrayDeque.addFirst(navBackStackEntry8);
                    }
                    while (r0.hasNext()) {
                        navGraph = navBackStackEntry5.destination.parent;
                        if (navGraph != null) {
                            linkChildToParent$navigation_runtime_release(navBackStackEntry5, getBackStackEntry$navigation_runtime_release(((NavDestination) navGraph).impl.size));
                        }
                        this.backQueue.addLast(navBackStackEntry5);
                    }
                    while (r0.hasNext()) {
                        navigator = this._navigatorProvider.getNavigator(navBackStackEntry6.destination.navigatorName);
                        navDestination3 = navBackStackEntry6.destination;
                        if (navDestination3 == null) {
                            navDestination3 = null;
                        }
                        if (navDestination3 == null) {
                            navigator.navigate(navDestination3);
                            state = navigator.getState();
                            synchronized (state.backStackLock) {
                                ArrayList mutableList2 = CollectionsKt.toMutableList((Collection) state.backStack.$$delegate_0.getValue());
                                listIterator = mutableList2.listIterator(mutableList2.size());
                                while (true) {
                                    if (listIterator.hasPrevious()) {
                                        if (((NavBackStackEntry) listIterator.previous()).id.equals(navBackStackEntry6.id)) {
                                            iNextIndex2 = listIterator.nextIndex();
                                            break;
                                        }
                                    } else {
                                        iNextIndex2 = -1;
                                        break;
                                    }
                                }
                                mutableList2.set(iNextIndex2, navBackStackEntry6);
                                state._backStack.updateState(null, mutableList2);
                            }
                        }
                    }
                    z2 = true;
                }
            }
            if (!z2) {
                NavBackStackEntry navBackStackEntryCreate$default = CueDecoder.create$default(this.navController.navContext, navDestination, bundleAddInDefaultArgs, getHostLifecycleState$navigation_runtime_release(), this.viewModel);
                Navigator navigator2 = this._navigatorProvider.getNavigator(navDestination.navigatorName);
                List listListOf = CollectionsKt__IterablesKt.listOf(navBackStackEntryCreate$default);
                this.addToBackStackHandler = new MainActivity$$ExternalSyntheticLambda59((Object) ref$BooleanRef, (Object) this, (Object) navDestination, (Object) bundleAddInDefaultArgs, (byte) 8);
                navigator2.navigate(listListOf, navOptions);
                this.addToBackStackHandler = null;
            }
        }
        this.updateOnBackPressedCallbackEnabledCallback.invoke();
        Iterator it3 = this.navigatorState.values().iterator();
        while (it3.hasNext()) {
            ((NavController$NavControllerNavigatorState) it3.next()).isNavigating = false;
        }
        if (z || ref$BooleanRef.element || z2) {
            dispatchOnDestinationChanged$navigation_runtime_release();
        } else {
            updateBackStackLifecycle$navigation_runtime_release();
        }
    }

    public final boolean popBackStackInternal$navigation_runtime_release(int i, boolean z, boolean z2) {
        NavDestination navDestination;
        RulerTrackingMap rulerTrackingMap;
        ArrayDeque arrayDeque = this.backQueue;
        if (arrayDeque.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = CollectionsKt.reversed(arrayDeque).iterator();
        do {
            if (!it.hasNext()) {
                navDestination = null;
                break;
            }
            navDestination = ((NavBackStackEntry) it.next()).destination;
            String str = navDestination.navigatorName;
            rulerTrackingMap = navDestination.impl;
            Navigator navigator = this._navigatorProvider.getNavigator(str);
            if (z || rulerTrackingMap.size != i) {
                arrayList.add(navigator);
            }
        } while (rulerTrackingMap.size != i);
        if (navDestination != null) {
            return executePopOperations$navigation_runtime_release(arrayList, navDestination, z, z2);
        }
        int i2 = NavDestination.$r8$clinit;
        Log.i("NavController", "Ignoring popBackStack to destination " + FileSystemsKt.getDisplayName(this.navController.navContext, i) + " as it was not found on the current back stack");
        return false;
    }

    public final void popEntryFromBackStack$navigation_runtime_release(NavBackStackEntry navBackStackEntry, boolean z, ArrayDeque arrayDeque) {
        NavControllerViewModel navControllerViewModel;
        Set set;
        navBackStackEntry.getClass();
        ArrayDeque arrayDeque2 = this.backQueue;
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) arrayDeque2.last();
        if (!Intrinsics.areEqual(navBackStackEntry2, navBackStackEntry)) {
            StringBuilder sb = new StringBuilder("Attempted to pop ");
            sb.append(navBackStackEntry.destination);
            NavDestination navDestination = navBackStackEntry2.destination;
            sb.append(", which is not the top of the back stack (");
            sb.append(navDestination);
            sb.append(')');
            throw new IllegalStateException(sb.toString().toString());
        }
        CollectionsKt__MutableCollectionsKt.removeLast(arrayDeque2);
        NavController$NavControllerNavigatorState navController$NavControllerNavigatorState = (NavController$NavControllerNavigatorState) this.navigatorState.get(this._navigatorProvider.getNavigator(navBackStackEntry2.destination.navigatorName));
        boolean z2 = true;
        if ((navController$NavControllerNavigatorState == null || (set = (Set) navController$NavControllerNavigatorState.transitionsInProgress.$$delegate_0.getValue()) == null || !set.contains(navBackStackEntry2)) && !this.parentToChildCount.containsKey(navBackStackEntry2)) {
            z2 = false;
        }
        Lifecycle.State state = navBackStackEntry2.impl.lifecycle.state;
        Lifecycle.State state2 = Lifecycle.State.CREATED;
        if (state.compareTo(state2) >= 0) {
            if (z) {
                navBackStackEntry2.setMaxLifecycle(state2);
                arrayDeque.addFirst(new NavBackStackEntryState(navBackStackEntry2));
            }
            if (z2) {
                navBackStackEntry2.setMaxLifecycle(state2);
            } else {
                navBackStackEntry2.setMaxLifecycle(Lifecycle.State.DESTROYED);
                unlinkChildFromParent$navigation_runtime_release(navBackStackEntry2);
            }
        }
        if (z || z2 || (navControllerViewModel = this.viewModel) == null) {
            return;
        }
        ViewModelStore viewModelStore = (ViewModelStore) navControllerViewModel.viewModelStores.remove(navBackStackEntry2.id);
        if (viewModelStore != null) {
            viewModelStore.clear();
        }
    }

    public final ArrayList populateVisibleEntries$navigation_runtime_release() {
        Lifecycle.State state;
        ArrayList arrayList = new ArrayList();
        Iterator it = this.navigatorState.values().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            state = Lifecycle.State.STARTED;
            if (!zHasNext) {
                break;
            }
            Iterable iterable = (Iterable) ((NavController$NavControllerNavigatorState) it.next()).transitionsInProgress.$$delegate_0.getValue();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : iterable) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                if (!arrayList.contains(navBackStackEntry) && navBackStackEntry.impl.maxLifecycle.compareTo(state) < 0) {
                    arrayList2.add(obj);
                }
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList2, arrayList);
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : this.backQueue) {
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) obj2;
            if (!arrayList.contains(navBackStackEntry2) && navBackStackEntry2.impl.maxLifecycle.compareTo(state) >= 0) {
                arrayList3.add(obj2);
            }
        }
        CollectionsKt__MutableCollectionsKt.addAll(arrayList3, arrayList);
        ArrayList arrayList4 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj3 = arrayList.get(i);
            i++;
            if (!(((NavBackStackEntry) obj3).destination instanceof NavGraph)) {
                arrayList4.add(obj3);
            }
        }
        return arrayList4;
    }

    public final boolean restoreStateInternal(int i, Bundle bundle, NavOptions navOptions) {
        NavDestination graph$navigation_runtime_release;
        NavBackStackEntry navBackStackEntry;
        NavDestination navDestination;
        Bundle bundle2;
        Integer numValueOf = Integer.valueOf(i);
        LinkedHashMap linkedHashMap = this.backStackMap;
        int i2 = 0;
        if (!linkedHashMap.containsKey(numValueOf)) {
            return false;
        }
        String str = (String) linkedHashMap.get(Integer.valueOf(i));
        Collection collectionValues = linkedHashMap.values();
        collectionValues.getClass();
        Iterator it = collectionValues.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual((String) it.next(), str)) {
                it.remove();
            }
        }
        ArrayDeque<NavBackStackEntryState> arrayDeque = (ArrayDeque) TypeIntrinsics.asMutableMap(this.backStackStates).remove(str);
        NavContext navContext = this.navController.navContext;
        ArrayList arrayList = new ArrayList();
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) this.backQueue.lastOrNull();
        if (navBackStackEntry2 == null || (graph$navigation_runtime_release = navBackStackEntry2.destination) == null) {
            graph$navigation_runtime_release = getGraph$navigation_runtime_release();
        }
        if (arrayDeque != null) {
            for (NavBackStackEntryState navBackStackEntryState : arrayDeque) {
                JsonPath jsonPath = navBackStackEntryState.impl;
                JsonPath jsonPath2 = navBackStackEntryState.impl;
                NavDestination navDestinationFindDestinationComprehensive$navigation_runtime_release = findDestinationComprehensive$navigation_runtime_release(jsonPath.currentDepth, graph$navigation_runtime_release, null, true);
                if (navDestinationFindDestinationComprehensive$navigation_runtime_release == null) {
                    int i3 = NavDestination.$r8$clinit;
                    PathKt$$ExternalSyntheticBUOutline0.m("Restore State failed: destination ", FileSystemsKt.getDisplayName(navContext, jsonPath2.currentDepth), " cannot be found from the current destination ", graph$navigation_runtime_release);
                    return false;
                }
                Lifecycle.State hostLifecycleState$navigation_runtime_release = getHostLifecycleState$navigation_runtime_release();
                NavControllerViewModel navControllerViewModel = this.viewModel;
                navContext.getClass();
                hostLifecycleState$navigation_runtime_release.getClass();
                Bundle bundle3 = (Bundle) jsonPath2.currentObjectPath;
                if (bundle3 != null) {
                    Context context = navContext.context;
                    bundle3.setClassLoader(context != null ? context.getClassLoader() : null);
                    bundle2 = bundle3;
                } else {
                    bundle2 = null;
                }
                arrayList.add(new NavBackStackEntry(navContext, navDestinationFindDestinationComprehensive$navigation_runtime_release, bundle2, hostLifecycleState$navigation_runtime_release, navControllerViewModel, (String) jsonPath2.configuration, (Bundle) jsonPath2.indicies));
                graph$navigation_runtime_release = navDestinationFindDestinationComprehensive$navigation_runtime_release;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            if (!(((NavBackStackEntry) obj).destination instanceof NavGraph)) {
                arrayList3.add(obj);
            }
        }
        int size2 = arrayList3.size();
        int i5 = 0;
        while (i5 < size2) {
            Object obj2 = arrayList3.get(i5);
            i5++;
            NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) obj2;
            List list = (List) CollectionsKt.lastOrNull(arrayList2);
            if (Intrinsics.areEqual((list == null || (navBackStackEntry = (NavBackStackEntry) CollectionsKt.last(list)) == null || (navDestination = navBackStackEntry.destination) == null) ? null : navDestination.navigatorName, navBackStackEntry3.destination.navigatorName)) {
                list.add(navBackStackEntry3);
            } else {
                arrayList2.add(CollectionsKt__IterablesKt.mutableListOf(navBackStackEntry3));
            }
        }
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        int size3 = arrayList2.size();
        while (i2 < size3) {
            Object obj3 = arrayList2.get(i2);
            i2++;
            List list2 = (List) obj3;
            Navigator navigator = this._navigatorProvider.getNavigator(((NavBackStackEntry) CollectionsKt.first(list2)).destination.navigatorName);
            ArrayList arrayList4 = arrayList;
            this.addToBackStackHandler = new AlbumMenuKt$$ExternalSyntheticLambda40((Object) ref$BooleanRef, (Object) arrayList4, (Object) new Ref$IntRef(), (Object) this, (Object) bundle, (byte) 5);
            navigator.navigate(list2, navOptions);
            this.addToBackStackHandler = null;
            arrayList = arrayList4;
        }
        return ref$BooleanRef.element;
    }

    public final void unlinkChildFromParent$navigation_runtime_release(NavBackStackEntry navBackStackEntry) {
        navBackStackEntry.getClass();
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) this.childToParentEntries.remove(navBackStackEntry);
        if (navBackStackEntry2 == null) {
            return;
        }
        LinkedHashMap linkedHashMap = this.parentToChildCount;
        AtomicInt atomicInt = (AtomicInt) linkedHashMap.get(navBackStackEntry2);
        Integer numValueOf = atomicInt != null ? Integer.valueOf(atomicInt.atomicInt.decrementAndGet()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            NavController$NavControllerNavigatorState navController$NavControllerNavigatorState = (NavController$NavControllerNavigatorState) this.navigatorState.get(this._navigatorProvider.getNavigator(navBackStackEntry2.destination.navigatorName));
            if (navController$NavControllerNavigatorState != null) {
                navController$NavControllerNavigatorState.markTransitionComplete(navBackStackEntry2);
            }
            linkedHashMap.remove(navBackStackEntry2);
        }
    }

    public final void updateBackStackLifecycle$navigation_runtime_release() {
        AtomicInt atomicInt;
        Set set;
        ArrayList mutableList = CollectionsKt.toMutableList((Collection) this.backQueue);
        if (mutableList.isEmpty()) {
            return;
        }
        ArrayList arrayListMutableListOf = CollectionsKt__IterablesKt.mutableListOf(((NavBackStackEntry) CollectionsKt.last(mutableList)).destination);
        ArrayList arrayList = new ArrayList();
        if (CollectionsKt.last(arrayListMutableListOf) instanceof DialogNavigator.Destination) {
            Iterator it = CollectionsKt.reversed(mutableList).iterator();
            while (it.hasNext()) {
                NavDestination navDestination = ((NavBackStackEntry) it.next()).destination;
                arrayList.add(navDestination);
                if (!(navDestination instanceof DialogNavigator.Destination) && !(navDestination instanceof NavGraph)) {
                    break;
                }
            }
        }
        HashMap map = new HashMap();
        for (NavBackStackEntry navBackStackEntry : CollectionsKt.reversed(mutableList)) {
            Lifecycle.State state = navBackStackEntry.impl.maxLifecycle;
            NavDestination navDestination2 = navBackStackEntry.destination;
            NavDestination navDestination3 = (NavDestination) CollectionsKt.firstOrNull((List) arrayListMutableListOf);
            Lifecycle.State state2 = Lifecycle.State.RESUMED;
            Lifecycle.State state3 = Lifecycle.State.STARTED;
            if (navDestination3 != null && navDestination3.impl.size == navDestination2.impl.size) {
                if (state != state2) {
                    NavController$NavControllerNavigatorState navController$NavControllerNavigatorState = (NavController$NavControllerNavigatorState) this.navigatorState.get(this._navigatorProvider.getNavigator(navBackStackEntry.destination.navigatorName));
                    if (Intrinsics.areEqual((navController$NavControllerNavigatorState == null || (set = (Set) navController$NavControllerNavigatorState.transitionsInProgress.$$delegate_0.getValue()) == null) ? null : Boolean.valueOf(set.contains(navBackStackEntry)), Boolean.TRUE) || ((atomicInt = (AtomicInt) this.parentToChildCount.get(navBackStackEntry)) != null && atomicInt.atomicInt.get() == 0)) {
                        map.put(navBackStackEntry, state3);
                    } else {
                        map.put(navBackStackEntry, state2);
                    }
                }
                NavDestination navDestination4 = (NavDestination) CollectionsKt.firstOrNull((List) arrayList);
                if (navDestination4 != null && navDestination4.impl.size == navDestination2.impl.size) {
                    CollectionsKt__MutableCollectionsKt.removeFirst(arrayList);
                }
                CollectionsKt__MutableCollectionsKt.removeFirst(arrayListMutableListOf);
                NavGraph navGraph = navDestination2.parent;
                if (navGraph != null) {
                    arrayListMutableListOf.add(navGraph);
                }
            } else if (arrayList.isEmpty() || navDestination2.impl.size != ((NavDestination) CollectionsKt.first((List) arrayList)).impl.size) {
                navBackStackEntry.setMaxLifecycle(Lifecycle.State.CREATED);
            } else {
                NavDestination navDestination5 = (NavDestination) CollectionsKt__MutableCollectionsKt.removeFirst(arrayList);
                if (state == state2) {
                    navBackStackEntry.setMaxLifecycle(state3);
                } else if (state != state3) {
                    map.put(navBackStackEntry, state3);
                }
                NavGraph navGraph2 = navDestination5.parent;
                if (navGraph2 != null && !arrayList.contains(navGraph2)) {
                    arrayList.add(navGraph2);
                }
            }
        }
        int size = mutableList.size();
        int i = 0;
        while (i < size) {
            Object obj = mutableList.get(i);
            i++;
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) obj;
            Lifecycle.State state4 = (Lifecycle.State) map.get(navBackStackEntry2);
            if (state4 != null) {
                navBackStackEntry2.setMaxLifecycle(state4);
            } else {
                navBackStackEntry2.impl.updateState$navigation_common_release();
            }
        }
    }

    public final void navigate$navigation_runtime_release(String str, NavOptions navOptions) {
        str.getClass();
        if (this._graph != null) {
            NavGraph topGraph$navigation_runtime_release = getTopGraph$navigation_runtime_release();
            NavDestination.DeepLinkMatch deepLinkMatchMatchRouteComprehensive = topGraph$navigation_runtime_release.matchRouteComprehensive(str, true, topGraph$navigation_runtime_release);
            if (deepLinkMatchMatchRouteComprehensive != null) {
                NavDestination navDestination = deepLinkMatchMatchRouteComprehensive.destination;
                Bundle bundleAddInDefaultArgs = navDestination.addInDefaultArgs(deepLinkMatchMatchRouteComprehensive.matchingArgs);
                if (bundleAddInDefaultArgs == null) {
                    bundleAddInDefaultArgs = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                }
                int i = NavDestination.$r8$clinit;
                String str2 = (String) navDestination.impl.layoutNodes;
                Uri uri = Uri.parse(str2 != null ? "android-app://androidx.navigation/".concat(str2) : "");
                uri.getClass();
                Intent intent = new Intent();
                intent.setDataAndType(uri, null);
                intent.setAction(null);
                bundleAddInDefaultArgs.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
                navigate$navigation_runtime_release(navDestination, bundleAddInDefaultArgs, navOptions);
                return;
            }
            StringBuilder sbM4m = IntIntPair$$ExternalSyntheticOutline0.m4m("Navigation destination that matches route ", str, " cannot be found in the navigation graph ");
            sbM4m.append(this._graph);
            throw new IllegalArgumentException(sbM4m.toString());
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m("Cannot navigate to ", str, ". Navigation graph has not been set for NavController ", this, 46);
    }
}
