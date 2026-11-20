package androidx.navigation.compose;

import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.window.DialogProperties;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import io.ktor.http.HttpHeaders;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Navigator.Name("dialog")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Landroidx/navigation/compose/DialogNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/compose/DialogNavigator$Destination;", HttpHeaders.Destination, "navigation-compose_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DialogNavigator extends Navigator {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Destination extends NavDestination {
        public final ComposableLambdaImpl content;
        public final DialogProperties dialogProperties;

        public Destination(DialogNavigator dialogNavigator) {
            ComposableLambdaImpl composableLambdaImpl = ComposableSingletons$DialogNavigatorKt.f8lambda$1092249270;
            DialogProperties dialogProperties = new DialogProperties(7);
            super(dialogNavigator);
            this.dialogProperties = dialogProperties;
            this.content = composableLambdaImpl;
        }
    }

    @Override // androidx.navigation.Navigator
    public final NavDestination createDestination() {
        ComposableLambdaImpl composableLambdaImpl = ComposableSingletons$DialogNavigatorKt.f8lambda$1092249270;
        return new Destination(this);
    }

    @Override // androidx.navigation.Navigator
    public final void navigate(List list, NavOptions navOptions) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            getState().push((NavBackStackEntry) it.next());
        }
    }

    @Override // androidx.navigation.Navigator
    public final void popBackStack(NavBackStackEntry navBackStackEntry, boolean z) {
        getState().popWithTransition(navBackStackEntry, z);
        int iIndexOf = CollectionsKt.indexOf((Iterable) getState().transitionsInProgress.$$delegate_0.getValue(), navBackStackEntry);
        int i = 0;
        for (Object obj : (Iterable) getState().transitionsInProgress.$$delegate_0.getValue()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__IterablesKt.throwIndexOverflow();
                throw null;
            }
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) obj;
            if (i > iIndexOf) {
                getState().markTransitionComplete(navBackStackEntry2);
            }
            i = i2;
        }
    }
}
