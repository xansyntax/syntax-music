package androidx.navigation.compose;

import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphNavigator;
import androidx.navigation.Navigator;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Navigator.Name("navigation")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Landroidx/navigation/compose/ComposeNavGraphNavigator;", "Landroidx/navigation/NavGraphNavigator;", "ComposeNavGraph", "navigation-compose_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ComposeNavGraphNavigator extends NavGraphNavigator {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ComposeNavGraph extends NavGraph {
    }

    @Override // androidx.navigation.NavGraphNavigator, androidx.navigation.Navigator
    public final NavDestination createDestination() {
        return new ComposeNavGraph(this);
    }

    @Override // androidx.navigation.NavGraphNavigator, androidx.navigation.Navigator
    public final NavGraph createDestination() {
        return new ComposeNavGraph(this);
    }
}
