package androidx.navigation;

import android.os.Bundle;
import android.util.Log;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.material3.MenuKt$$ExternalSyntheticLambda2;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import androidx.media3.extractor.text.CueDecoder;
import androidx.navigation.internal.NavControllerImpl;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavController$NavControllerNavigatorState {
    public final StateFlowImpl _backStack;
    public final StateFlowImpl _transitionsInProgress;
    public final ReadonlyStateFlow backStack;
    public final CueDecoder backStackLock;
    public boolean isNavigating;
    public final Navigator navigator;
    public final /* synthetic */ NavHostController this$0;
    public final ReadonlyStateFlow transitionsInProgress;

    public NavController$NavControllerNavigatorState(NavHostController navHostController, Navigator navigator) {
        navigator.getClass();
        this.this$0 = navHostController;
        this.backStackLock = new CueDecoder((byte) 19);
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(EmptyList.INSTANCE);
        this._backStack = stateFlowImplMutableStateFlow;
        StateFlowImpl stateFlowImplMutableStateFlow2 = StateFlowKt.MutableStateFlow(EmptySet.INSTANCE);
        this._transitionsInProgress = stateFlowImplMutableStateFlow2;
        this.backStack = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        this.transitionsInProgress = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow2);
        this.navigator = navigator;
    }

    public final void addInternal(NavBackStackEntry navBackStackEntry) {
        navBackStackEntry.getClass();
        synchronized (this.backStackLock) {
            StateFlowImpl stateFlowImpl = this._backStack;
            stateFlowImpl.updateState(null, CollectionsKt.plus(navBackStackEntry, (Collection) stateFlowImpl.getValue()));
        }
    }

    public final NavBackStackEntry createBackStackEntry(NavDestination navDestination, Bundle bundle) {
        NavControllerImpl navControllerImpl = this.this$0.impl;
        navControllerImpl.getClass();
        return CueDecoder.create$default(navControllerImpl.navController.navContext, navDestination, bundle, navControllerImpl.getHostLifecycleState$navigation_runtime_release(), navControllerImpl.viewModel);
    }

    public final void markTransitionComplete(NavBackStackEntry navBackStackEntry) {
        NavControllerViewModel navControllerViewModel;
        ViewModelStore viewModelStore;
        navBackStackEntry.getClass();
        NavControllerImpl navControllerImpl = this.this$0.impl;
        StateFlowImpl stateFlowImpl = navControllerImpl._visibleEntries;
        String str = navBackStackEntry.id;
        LinkedHashMap linkedHashMap = navControllerImpl.entrySavedState;
        boolean zAreEqual = Intrinsics.areEqual(linkedHashMap.get(navBackStackEntry), Boolean.TRUE);
        StateFlowImpl stateFlowImpl2 = this._transitionsInProgress;
        Set set = (Set) stateFlowImpl2.getValue();
        set.getClass();
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(set.size()));
        boolean z = false;
        for (Object obj : set) {
            boolean z2 = true;
            if (!z && Intrinsics.areEqual(obj, navBackStackEntry)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(obj);
            }
        }
        stateFlowImpl2.updateState(null, linkedHashSet);
        linkedHashMap.remove(navBackStackEntry);
        ArrayDeque arrayDeque = navControllerImpl.backQueue;
        if (arrayDeque.contains(navBackStackEntry)) {
            if (this.isNavigating) {
                return;
            }
            navControllerImpl.updateBackStackLifecycle$navigation_runtime_release();
            StateFlowImpl stateFlowImpl3 = navControllerImpl._currentBackStack;
            ArrayList arrayList = new ArrayList(arrayDeque);
            stateFlowImpl3.getClass();
            stateFlowImpl3.updateState(null, arrayList);
            ArrayList arrayListPopulateVisibleEntries$navigation_runtime_release = navControllerImpl.populateVisibleEntries$navigation_runtime_release();
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, arrayListPopulateVisibleEntries$navigation_runtime_release);
            return;
        }
        navControllerImpl.unlinkChildFromParent$navigation_runtime_release(navBackStackEntry);
        if (navBackStackEntry.impl.lifecycle.state.compareTo(Lifecycle.State.CREATED) >= 0) {
            navBackStackEntry.setMaxLifecycle(Lifecycle.State.DESTROYED);
        }
        if (!arrayDeque.isEmpty()) {
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                if (((NavBackStackEntry) it.next()).id.equals(str)) {
                }
            }
            if (!zAreEqual) {
                viewModelStore.clear();
            }
        } else if (!zAreEqual && (navControllerViewModel = navControllerImpl.viewModel) != null && (viewModelStore = (ViewModelStore) navControllerViewModel.viewModelStores.remove(str)) != null) {
            viewModelStore.clear();
        }
        navControllerImpl.updateBackStackLifecycle$navigation_runtime_release();
        ArrayList arrayListPopulateVisibleEntries$navigation_runtime_release2 = navControllerImpl.populateVisibleEntries$navigation_runtime_release();
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, arrayListPopulateVisibleEntries$navigation_runtime_release2);
    }

    public final void pop(NavBackStackEntry navBackStackEntry, boolean z) {
        NavControllerImpl navControllerImpl = this.this$0.impl;
        ComponentRegistry$Builder$$ExternalSyntheticLambda2 componentRegistry$Builder$$ExternalSyntheticLambda2 = new ComponentRegistry$Builder$$ExternalSyntheticLambda2(this, navBackStackEntry, z);
        navControllerImpl.getClass();
        Navigator navigator = navControllerImpl._navigatorProvider.getNavigator(navBackStackEntry.destination.navigatorName);
        navControllerImpl.entrySavedState.put(navBackStackEntry, Boolean.valueOf(z));
        if (!navigator.equals(this.navigator)) {
            Object obj = navControllerImpl.navigatorState.get(navigator);
            obj.getClass();
            ((NavController$NavControllerNavigatorState) obj).pop(navBackStackEntry, z);
            return;
        }
        MenuKt$$ExternalSyntheticLambda2 menuKt$$ExternalSyntheticLambda2 = navControllerImpl.popFromBackStackHandler;
        if (menuKt$$ExternalSyntheticLambda2 != null) {
            menuKt$$ExternalSyntheticLambda2.invoke(navBackStackEntry);
            componentRegistry$Builder$$ExternalSyntheticLambda2.invoke();
            return;
        }
        ArrayDeque arrayDeque = navControllerImpl.backQueue;
        int iIndexOf = arrayDeque.indexOf(navBackStackEntry);
        if (iIndexOf < 0) {
            Log.i("NavController", "Ignoring pop of " + navBackStackEntry + " as it was not found on the current back stack");
            return;
        }
        int i = iIndexOf + 1;
        if (i != arrayDeque.size) {
            navControllerImpl.popBackStackInternal$navigation_runtime_release(((NavBackStackEntry) arrayDeque.get(i)).destination.impl.size, true, false);
        }
        NavControllerImpl.popEntryFromBackStack$navigation_runtime_release$default(navControllerImpl, navBackStackEntry);
        componentRegistry$Builder$$ExternalSyntheticLambda2.invoke();
        navControllerImpl.updateOnBackPressedCallbackEnabledCallback.invoke();
        navControllerImpl.dispatchOnDestinationChanged$navigation_runtime_release();
    }

    public final void popWithTransition(NavBackStackEntry navBackStackEntry, boolean z) {
        Object objPrevious;
        StateFlow stateFlow = this.backStack.$$delegate_0;
        StateFlowImpl stateFlowImpl = this._transitionsInProgress;
        Iterable iterable = (Iterable) stateFlowImpl.getValue();
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                if (((NavBackStackEntry) it.next()) == navBackStackEntry) {
                    Iterable iterable2 = (Iterable) stateFlow.getValue();
                    if ((iterable2 instanceof Collection) && ((Collection) iterable2).isEmpty()) {
                        return;
                    }
                    Iterator it2 = iterable2.iterator();
                    while (it2.hasNext()) {
                        if (((NavBackStackEntry) it2.next()) == navBackStackEntry) {
                            break;
                        }
                    }
                    return;
                }
            }
        }
        stateFlowImpl.updateState(null, SetsKt.plus((Set) stateFlowImpl.getValue(), navBackStackEntry));
        List list = (List) stateFlow.getValue();
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) objPrevious;
            if (!Intrinsics.areEqual(navBackStackEntry2, navBackStackEntry) && ((List) stateFlow.getValue()).lastIndexOf(navBackStackEntry2) < ((List) stateFlow.getValue()).lastIndexOf(navBackStackEntry)) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) objPrevious;
        if (navBackStackEntry3 != null) {
            stateFlowImpl.updateState(null, SetsKt.plus((Set) stateFlowImpl.getValue(), navBackStackEntry3));
        }
        pop(navBackStackEntry, z);
    }

    public final void push(NavBackStackEntry navBackStackEntry) {
        navBackStackEntry.getClass();
        NavControllerImpl navControllerImpl = this.this$0.impl;
        navControllerImpl.getClass();
        Navigator navigator = navControllerImpl._navigatorProvider.getNavigator(navBackStackEntry.destination.navigatorName);
        if (!navigator.equals(this.navigator)) {
            Object obj = navControllerImpl.navigatorState.get(navigator);
            if (obj != null) {
                ((NavController$NavControllerNavigatorState) obj).push(navBackStackEntry);
                return;
            } else {
                _UtilJvmKt$$ExternalSyntheticLambda0.m((Object) IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder("NavigatorBackStack for "), navBackStackEntry.destination.navigatorName, " should already be created"));
                return;
            }
        }
        Function1 function1 = navControllerImpl.addToBackStackHandler;
        if (function1 != null) {
            function1.invoke(navBackStackEntry);
            addInternal(navBackStackEntry);
        } else {
            Log.i("NavController", "Ignoring add of destination " + navBackStackEntry.destination + " outside of the call to navigate(). ");
        }
    }
}
