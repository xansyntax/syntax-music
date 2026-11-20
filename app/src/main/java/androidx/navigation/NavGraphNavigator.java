package androidx.navigation;

import android.os.Bundle;
import androidx.collection.ArraySetKt;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.node.RulerTrackingMap;
import androidx.navigation.internal.NavGraphImpl;
import coil3.util.UtilsKt;
import com.google.common.math.IntMath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Navigator.Name("navigation")
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/navigation/NavGraphNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavGraph;", "navigation-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class NavGraphNavigator extends Navigator {
    public final NavigatorProvider navigatorProvider;

    public NavGraphNavigator(NavigatorProvider navigatorProvider) {
        navigatorProvider.getClass();
        this.navigatorProvider = navigatorProvider;
    }

    @Override // androidx.navigation.Navigator
    public NavGraph createDestination() {
        return new NavGraph(this);
    }

    @Override // androidx.navigation.Navigator
    public final void navigate(List list, NavOptions navOptions) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) it.next();
            NavDestination navDestination = navBackStackEntry.destination;
            navDestination.getClass();
            NavGraph navGraph = (NavGraph) navDestination;
            RulerTrackingMap rulerTrackingMap = ((NavDestination) navGraph).impl;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = navBackStackEntry.impl.getArguments$navigation_common_release();
            NavGraphImpl navGraphImpl = navGraph.impl;
            int i = navGraphImpl.startDestId;
            String str = (String) navGraphImpl.startDestinationRoute;
            if (i == 0 && str == null) {
                rulerTrackingMap.getClass();
                String strValueOf = String.valueOf(rulerTrackingMap.size);
                strValueOf.getClass();
                if (((NavDestination) ((NavGraph) navGraphImpl.graph)).impl.size == 0) {
                    strValueOf = "the root navigation";
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m((Object) "no start destination defined via app:startDestination for ".concat(strValueOf));
                return;
            }
            byte b = 0;
            NavDestination navDestinationFindNode$navigation_common_release = str != null ? navGraphImpl.findNode$navigation_common_release(str, false) : (NavDestination) ArraySetKt.commonGet((SparseArrayCompat) navGraphImpl.nodes, i);
            if (navDestinationFindNode$navigation_common_release == null) {
                String strValueOf2 = (String) navGraphImpl.startDestIdName;
                if (strValueOf2 == null) {
                    strValueOf2 = (String) navGraphImpl.startDestinationRoute;
                    if (strValueOf2 == null) {
                        strValueOf2 = String.valueOf(navGraphImpl.startDestId);
                    }
                    navGraphImpl.startDestIdName = strValueOf2;
                }
                strValueOf2.getClass();
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m("navigation destination ", strValueOf2, " is not a direct child of this NavGraph"));
                return;
            }
            RulerTrackingMap rulerTrackingMap2 = navDestinationFindNode$navigation_common_release.impl;
            if (str != null) {
                if (!str.equals((String) rulerTrackingMap2.layoutNodes)) {
                    NavDestination.DeepLinkMatch deepLinkMatchMatchRoute$navigation_common_release = rulerTrackingMap2.matchRoute$navigation_common_release(str);
                    Bundle bundle = deepLinkMatchMatchRoute$navigation_common_release != null ? deepLinkMatchMatchRoute$navigation_common_release.matchingArgs : null;
                    if (bundle != null && !bundle.isEmpty()) {
                        Bundle bundleBundleOf = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                        bundleBundleOf.putAll(bundle);
                        Bundle bundle2 = (Bundle) ref$ObjectRef.element;
                        if (bundle2 != null) {
                            bundleBundleOf.putAll(bundle2);
                        }
                        ref$ObjectRef.element = bundleBundleOf;
                    }
                }
                if (navDestinationFindNode$navigation_common_release.getArguments().isEmpty()) {
                    continue;
                } else {
                    ArrayList arrayListMissingRequiredArguments = IntMath.missingRequiredArguments(navDestinationFindNode$navigation_common_release.getArguments(), new NavGraphNavigator$$ExternalSyntheticLambda0(ref$ObjectRef, b));
                    if (!arrayListMissingRequiredArguments.isEmpty()) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m("Cannot navigate to startDestination ", navDestinationFindNode$navigation_common_release, ". Missing required arguments [", arrayListMissingRequiredArguments, 93);
                        return;
                    }
                }
            }
            this.navigatorProvider.getNavigator(navDestinationFindNode$navigation_common_release.navigatorName).navigate(CollectionsKt__IterablesKt.listOf(getState().createBackStackEntry(navDestinationFindNode$navigation_common_release, navDestinationFindNode$navigation_common_release.addInDefaultArgs((Bundle) ref$ObjectRef.element))), navOptions);
        }
    }
}
