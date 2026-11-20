package androidx.navigation;

import androidx.collection.ArraySetKt;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.node.RulerTrackingMap;
import androidx.navigation.internal.NavGraphImpl;
import coil3.util.UtilsKt;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavGraphBuilder extends NavDestinationBuilder {
    public final ArrayList destinations;
    public final NavigatorProvider provider;
    public final String startDestinationRoute;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraphBuilder(NavigatorProvider navigatorProvider, String str) {
        super(navigatorProvider.getNavigator(UtilsKt.getNameForNavigator$navigation_common_release(NavGraphNavigator.class)), null);
        navigatorProvider.getClass();
        this.destinations = new ArrayList();
        this.provider = navigatorProvider;
        this.startDestinationRoute = str;
    }

    @Override // androidx.navigation.NavDestinationBuilder
    public final NavGraph build() {
        int iHashCode;
        NavGraph navGraph = (NavGraph) super.build();
        NavGraphImpl navGraphImpl = navGraph.impl;
        navGraphImpl.getClass();
        ArrayList arrayList = this.destinations;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            NavDestination navDestination = (NavDestination) obj;
            if (navDestination != null) {
                SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) navGraphImpl.nodes;
                NavGraph navGraph2 = (NavGraph) navGraphImpl.graph;
                RulerTrackingMap rulerTrackingMap = ((NavDestination) navGraph2).impl;
                RulerTrackingMap rulerTrackingMap2 = navDestination.impl;
                int i2 = rulerTrackingMap2.size;
                String str = (String) rulerTrackingMap2.layoutNodes;
                if (i2 == 0 && str == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.");
                    return null;
                }
                String str2 = (String) rulerTrackingMap.layoutNodes;
                if (str2 != null && Intrinsics.areEqual(str, str2)) {
                    Path$$ExternalSyntheticBUOutline0.m("Destination ", navDestination, " cannot have the same route as graph ", navGraph2);
                    return null;
                }
                if (i2 == rulerTrackingMap.size) {
                    Path$$ExternalSyntheticBUOutline0.m("Destination ", navDestination, " cannot have the same id as graph ", navGraph2);
                    return null;
                }
                NavDestination navDestination2 = (NavDestination) ArraySetKt.commonGet(sparseArrayCompat, i2);
                if (navDestination2 == navDestination) {
                    continue;
                } else {
                    if (navDestination.parent != null) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
                        return null;
                    }
                    if (navDestination2 != null) {
                        navDestination2.parent = null;
                    }
                    navDestination.parent = navGraph2;
                    sparseArrayCompat.put(rulerTrackingMap2.size, navDestination);
                }
            }
        }
        NavGraph navGraph3 = (NavGraph) navGraphImpl.graph;
        String str3 = this.startDestinationRoute;
        if (str3 != null) {
            if (str3.equals((String) ((NavDestination) navGraph3).impl.layoutNodes)) {
                Path$$ExternalSyntheticBUOutline0.m("Start destination ", str3, " cannot use the same route as the graph ", navGraph3);
            } else if (StringsKt.isBlank(str3)) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Cannot have an empty start destination route");
            } else {
                int i3 = NavDestination.$r8$clinit;
                iHashCode = "android-app://androidx.navigation/".concat(str3).hashCode();
            }
            return navGraph;
        }
        iHashCode = 0;
        navGraphImpl.startDestId = iHashCode;
        navGraphImpl.startDestinationRoute = str3;
        return navGraph;
    }
}
