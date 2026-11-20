package androidx.navigation.compose;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController$NavControllerNavigatorState;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.internal.NavControllerImpl;
import io.ktor.http.HttpHeaders;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Navigator.Name("composable")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Landroidx/navigation/compose/ComposeNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/compose/ComposeNavigator$Destination;", HttpHeaders.Destination, "navigation-compose_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ComposeNavigator extends Navigator {
    public final ParcelableSnapshotMutableState isPop = Stack.mutableStateOf$default(Boolean.FALSE);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Destination extends NavDestination {
        public final ComposableLambdaImpl content;
        public Function1 enterTransition;
        public Function1 exitTransition;
        public Function1 popEnterTransition;
        public Function1 popExitTransition;

        public Destination(ComposeNavigator composeNavigator, ComposableLambdaImpl composableLambdaImpl) {
            super(composeNavigator);
            this.content = composableLambdaImpl;
        }
    }

    @Override // androidx.navigation.Navigator
    public final NavDestination createDestination() {
        return new Destination(this, ComposableSingletons$ComposeNavigatorKt.lambda$127448943);
    }

    @Override // androidx.navigation.Navigator
    public final void navigate(List list, NavOptions navOptions) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) it.next();
            NavController$NavControllerNavigatorState state = getState();
            StateFlow stateFlow = state.backStack.$$delegate_0;
            navBackStackEntry.getClass();
            StateFlowImpl stateFlowImpl = state._transitionsInProgress;
            Iterable iterable = (Iterable) stateFlowImpl.getValue();
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it2 = iterable.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((NavBackStackEntry) it2.next()) == navBackStackEntry) {
                            Iterable iterable2 = (Iterable) stateFlow.getValue();
                            if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
                                Iterator it3 = iterable2.iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        if (((NavBackStackEntry) it3.next()) == navBackStackEntry) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) CollectionsKt.lastOrNull((List) stateFlow.getValue());
            if (navBackStackEntry2 != null) {
                stateFlowImpl.updateState(null, SetsKt.plus((Set) stateFlowImpl.getValue(), navBackStackEntry2));
            }
            stateFlowImpl.updateState(null, SetsKt.plus((Set) stateFlowImpl.getValue(), navBackStackEntry));
            state.push(navBackStackEntry);
        }
        this.isPop.setValue(Boolean.FALSE);
    }

    @Override // androidx.navigation.Navigator
    public final void popBackStack(NavBackStackEntry navBackStackEntry, boolean z) {
        getState().popWithTransition(navBackStackEntry, z);
        this.isPop.setValue(Boolean.TRUE);
    }

    public final void prepareForTransition(NavBackStackEntry navBackStackEntry) {
        NavController$NavControllerNavigatorState state = getState();
        navBackStackEntry.getClass();
        StateFlowImpl stateFlowImpl = state._transitionsInProgress;
        stateFlowImpl.updateState(null, SetsKt.plus((Set) stateFlowImpl.getValue(), navBackStackEntry));
        NavControllerImpl navControllerImpl = state.this$0.impl;
        navControllerImpl.getClass();
        if (navControllerImpl.backQueue.contains(navBackStackEntry)) {
            navBackStackEntry.setMaxLifecycle(Lifecycle.State.STARTED);
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Cannot transition entry that is not in the back stack");
        }
    }
}
