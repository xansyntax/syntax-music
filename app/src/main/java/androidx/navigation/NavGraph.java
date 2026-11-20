package androidx.navigation;

import androidx.collection.ArraySetKt;
import androidx.collection.SparseArrayCompat;
import androidx.navigation.internal.NavGraphImpl;
import androidx.navigation.internal.NavGraphImpl$iterator$1;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.UIntArray;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class NavGraph extends NavDestination implements Iterable, KMappedMarker {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final NavGraphImpl impl;

    public NavGraph(NavGraphNavigator navGraphNavigator) {
        super(navGraphNavigator);
        this.impl = new NavGraphImpl(this);
    }

    @Override // androidx.navigation.NavDestination
    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || !(obj instanceof NavGraph) || !super.equals(obj)) {
                return false;
            }
            NavGraphImpl navGraphImpl = this.impl;
            int size = ((SparseArrayCompat) navGraphImpl.nodes).size();
            NavGraphImpl navGraphImpl2 = ((NavGraph) obj).impl;
            if (size != ((SparseArrayCompat) navGraphImpl2.nodes).size() || navGraphImpl.startDestId != navGraphImpl2.startDestId) {
                return false;
            }
            for (NavDestination navDestination : (ConstrainedOnceSequence) SequencesKt.asSequence(new UIntArray.Iterator((byte) 1, (SparseArrayCompat) navGraphImpl.nodes))) {
                if (!navDestination.equals(ArraySetKt.commonGet((SparseArrayCompat) navGraphImpl2.nodes, navDestination.impl.size))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // androidx.navigation.NavDestination
    public final int hashCode() {
        NavGraphImpl navGraphImpl = this.impl;
        int iKeyAt = navGraphImpl.startDestId;
        SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) navGraphImpl.nodes;
        int size = sparseArrayCompat.size();
        for (int i = 0; i < size; i++) {
            iKeyAt = (((iKeyAt * 31) + sparseArrayCompat.keyAt(i)) * 31) + ((NavDestination) sparseArrayCompat.valueAt(i)).hashCode();
        }
        return iKeyAt;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        NavGraphImpl navGraphImpl = this.impl;
        navGraphImpl.getClass();
        return new NavGraphImpl$iterator$1(navGraphImpl);
    }

    @Override // androidx.navigation.NavDestination
    public final NavDestination.DeepLinkMatch matchDeepLink(NavDeepLinkRequest navDeepLinkRequest) {
        NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLink = super.matchDeepLink(navDeepLinkRequest);
        NavGraphImpl navGraphImpl = this.impl;
        navGraphImpl.getClass();
        return navGraphImpl.matchDeepLinkComprehensive$navigation_common_release(deepLinkMatchMatchDeepLink, navDeepLinkRequest, false, (NavGraph) navGraphImpl.graph);
    }

    public final NavDestination.DeepLinkMatch matchDeepLinkComprehensive(NavDeepLinkRequest navDeepLinkRequest, NavDestination navDestination) {
        return this.impl.matchDeepLinkComprehensive$navigation_common_release(super.matchDeepLink(navDeepLinkRequest), navDeepLinkRequest, true, navDestination);
    }

    public final NavDestination.DeepLinkMatch matchRouteComprehensive(String str, boolean z, NavDestination navDestination) {
        NavDestination.DeepLinkMatch deepLinkMatchMatchRouteComprehensive;
        str.getClass();
        NavGraphImpl navGraphImpl = this.impl;
        navGraphImpl.getClass();
        NavGraph navGraph = (NavGraph) navGraphImpl.graph;
        NavDestination.DeepLinkMatch deepLinkMatchMatchRoute$navigation_common_release = ((NavDestination) navGraph).impl.matchRoute$navigation_common_release(str);
        ArrayList arrayList = new ArrayList();
        Iterator it = navGraph.iterator();
        while (true) {
            NavGraphImpl$iterator$1 navGraphImpl$iterator$1 = (NavGraphImpl$iterator$1) it;
            deepLinkMatchMatchRouteComprehensive = null;
            if (!navGraphImpl$iterator$1.hasNext()) {
                break;
            }
            NavDestination navDestination2 = (NavDestination) navGraphImpl$iterator$1.next();
            if (!Intrinsics.areEqual(navDestination2, navDestination)) {
                if (navDestination2 instanceof NavGraph) {
                    deepLinkMatchMatchRouteComprehensive = ((NavGraph) navDestination2).matchRouteComprehensive(str, false, navGraph);
                } else {
                    navDestination2.getClass();
                    deepLinkMatchMatchRouteComprehensive = navDestination2.impl.matchRoute$navigation_common_release(str);
                }
            }
            if (deepLinkMatchMatchRouteComprehensive != null) {
                arrayList.add(deepLinkMatchMatchRouteComprehensive);
            }
        }
        NavDestination.DeepLinkMatch deepLinkMatch = (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull(arrayList);
        NavGraph navGraph2 = navGraph.parent;
        if (navGraph2 != null && z && !navGraph2.equals(navDestination)) {
            deepLinkMatchMatchRouteComprehensive = navGraph2.matchRouteComprehensive(str, true, navGraph);
        }
        return (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull(ArraysKt.filterNotNull(new NavDestination.DeepLinkMatch[]{deepLinkMatchMatchRoute$navigation_common_release, deepLinkMatch, deepLinkMatchMatchRouteComprehensive}));
    }

    @Override // androidx.navigation.NavDestination
    public final String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        NavGraphImpl navGraphImpl = this.impl;
        String str = (String) navGraphImpl.startDestinationRoute;
        navGraphImpl.getClass();
        NavDestination navDestinationFindNode$navigation_common_release = (str == null || StringsKt.isBlank(str)) ? null : navGraphImpl.findNode$navigation_common_release(str, true);
        if (navDestinationFindNode$navigation_common_release == null) {
            navDestinationFindNode$navigation_common_release = navGraphImpl.findNode$navigation_common_release(navGraphImpl.startDestId);
        }
        sb.append(" startDestination=");
        if (navDestinationFindNode$navigation_common_release == null) {
            String str2 = (String) navGraphImpl.startDestinationRoute;
            if (str2 != null) {
                sb.append(str2);
            } else {
                String str3 = (String) navGraphImpl.startDestIdName;
                if (str3 != null) {
                    sb.append(str3);
                } else {
                    sb.append("0x" + Integer.toHexString(navGraphImpl.startDestId));
                }
            }
        } else {
            sb.append("{");
            sb.append(navDestinationFindNode$navigation_common_release.toString());
            sb.append("}");
        }
        return sb.toString();
    }
}
