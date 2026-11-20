package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import androidx.collection.ArraySetKt;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.node.RulerTrackingMap;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import coil3.util.UtilsKt;
import com.google.common.math.IntMath;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatcherMatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavDestination {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final SparseArrayCompat actions;
    public final RulerTrackingMap impl;
    public final String navigatorName;
    public NavGraph parent;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DeepLinkMatch implements Comparable {
        public final NavDestination destination;
        public final boolean hasMatchingAction;
        public final boolean isExactDeepLink;
        public final Bundle matchingArgs;
        public final int matchingPathSegments;

        public DeepLinkMatch(NavDestination navDestination, Bundle bundle, boolean z, int i, boolean z2) {
            this.destination = navDestination;
            this.matchingArgs = bundle;
            this.isExactDeepLink = z;
            this.matchingPathSegments = i;
            this.hasMatchingAction = z2;
        }

        @Override // java.lang.Comparable
        public final int compareTo(DeepLinkMatch deepLinkMatch) {
            deepLinkMatch.getClass();
            boolean z = deepLinkMatch.hasMatchingAction;
            boolean z2 = deepLinkMatch.isExactDeepLink;
            Bundle bundle = deepLinkMatch.matchingArgs;
            boolean z3 = this.isExactDeepLink;
            if (z3 && !z2) {
                return 1;
            }
            if (!z3 && z2) {
                return -1;
            }
            int i = this.matchingPathSegments - deepLinkMatch.matchingPathSegments;
            if (i > 0) {
                return 1;
            }
            if (i < 0) {
                return -1;
            }
            Bundle bundle2 = this.matchingArgs;
            if (bundle2 != null && bundle == null) {
                return 1;
            }
            if (bundle2 == null && bundle != null) {
                return -1;
            }
            if (bundle2 != null) {
                int size = bundle2.size();
                bundle.getClass();
                int size2 = size - bundle.size();
                if (size2 > 0) {
                    return 1;
                }
                if (size2 < 0) {
                    return -1;
                }
            }
            boolean z4 = this.hasMatchingAction;
            if (!z4 || z) {
                return (z4 || !z) ? 0 : -1;
            }
            return 1;
        }
    }

    static {
        new LinkedHashMap();
    }

    public NavDestination(Navigator navigator) {
        LinkedHashMap linkedHashMap = NavigatorProvider.annotationNames;
        this.navigatorName = UtilsKt.getNameForNavigator$navigation_common_release(navigator.getClass());
        RulerTrackingMap rulerTrackingMap = new RulerTrackingMap();
        rulerTrackingMap.rulers = this;
        rulerTrackingMap.values = new ArrayList();
        rulerTrackingMap.accessFlags = new LinkedHashMap();
        this.impl = rulerTrackingMap;
        this.actions = new SparseArrayCompat(0);
    }

    public final Bundle addInDefaultArgs(Bundle bundle) {
        Object obj;
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.impl.accessFlags;
        if (bundle == null && linkedHashMap.isEmpty()) {
            return null;
        }
        Bundle bundleBundleOf = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            NavArgument navArgument = (NavArgument) entry.getValue();
            navArgument.getClass();
            str.getClass();
            if (navArgument.isDefaultValuePresent && (obj = navArgument.defaultValue) != null) {
                navArgument.type.put(bundleBundleOf, str, obj);
            }
        }
        if (bundle != null) {
            bundleBundleOf.putAll(bundle);
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                String str2 = (String) entry2.getKey();
                NavArgument navArgument2 = (NavArgument) entry2.getValue();
                navArgument2.getClass();
                NavType navType = navArgument2.type;
                str2.getClass();
                if (navArgument2.isNullable || !bundleBundleOf.containsKey(str2) || !MathKt.m1879isNullimpl(str2, bundleBundleOf)) {
                    try {
                        navType.get(str2, bundleBundleOf);
                    } catch (IllegalStateException unused) {
                    }
                }
                PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m4m("Wrong argument type for '", str2, "' in argument savedState. "), navType.getName(), " expected.");
                return null;
            }
        }
        return bundleBundleOf;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0024  */
    /* JADX WARN: Code duplicated, block: B:14:0x002e  */
    public final int[] buildDeepLinkIds(NavDestination navDestination) {
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            RulerTrackingMap rulerTrackingMap = this.impl;
            NavGraph navGraph = this.parent;
            if ((navDestination != null ? navDestination.parent : null) != null) {
                NavGraph navGraph2 = navDestination.parent;
                navGraph2.getClass();
                if (navGraph2.impl.findNode$navigation_common_release(rulerTrackingMap.size) != this) {
                    if (navGraph != null || navGraph.impl.startDestId != rulerTrackingMap.size) {
                        arrayDeque.addFirst(this);
                    }
                    if (!Intrinsics.areEqual(navGraph, navDestination) || navGraph == null) {
                        break;
                    }
                    this = navGraph;
                } else {
                    arrayDeque.addFirst(this);
                    break;
                }
            } else {
                if (navGraph != null) {
                    arrayDeque.addFirst(this);
                } else {
                    arrayDeque.addFirst(this);
                }
                if (!Intrinsics.areEqual(navGraph, navDestination)) {
                    break;
                }
                this = navGraph;
            }
        }
        List list = CollectionsKt.toList(arrayDeque);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((NavDestination) it.next()).impl.size));
        }
        return CollectionsKt.toIntArray(arrayList);
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this != obj) {
            if (obj != null && (obj instanceof NavDestination)) {
                RulerTrackingMap rulerTrackingMap = this.impl;
                ArrayList arrayList = (ArrayList) rulerTrackingMap.values;
                NavDestination navDestination = (NavDestination) obj;
                SparseArrayCompat sparseArrayCompat = navDestination.actions;
                RulerTrackingMap rulerTrackingMap2 = navDestination.impl;
                boolean zEquals = arrayList.equals((ArrayList) rulerTrackingMap2.values);
                final SparseArrayCompat sparseArrayCompat2 = this.actions;
                if (sparseArrayCompat2.size() != sparseArrayCompat.size()) {
                    z = false;
                    break;
                }
                Iterator it = ((ConstrainedOnceSequence) SequencesKt.asSequence(new IntIterator() { // from class: androidx.collection.SparseArrayKt$keyIterator$1
                    public int index;

                    {
                        super((byte) 0);
                    }

                    @Override // java.util.Iterator
                    public final boolean hasNext() {
                        return this.index < sparseArrayCompat2.size();
                    }

                    @Override // kotlin.collections.IntIterator
                    public final int nextInt() {
                        int i = this.index;
                        this.index = i + 1;
                        return sparseArrayCompat2.keyAt(i);
                    }
                })).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    int iIntValue = ((Number) it.next()).intValue();
                    if (!Intrinsics.areEqual(ArraySetKt.commonGet(sparseArrayCompat2, iIntValue), ArraySetKt.commonGet(sparseArrayCompat, iIntValue))) {
                        z = false;
                        break;
                    }
                }
                if (getArguments().size() != navDestination.getArguments().size()) {
                    z2 = false;
                    break;
                }
                Iterator it2 = ((Iterable) CollectionsKt.asSequence(getArguments().entrySet()).reader).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z2 = true;
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it2.next();
                    if (!navDestination.getArguments().containsKey(entry.getKey()) || !Intrinsics.areEqual(navDestination.getArguments().get(entry.getKey()), entry.getValue())) {
                        z2 = false;
                        break;
                    }
                }
                if (rulerTrackingMap.size != rulerTrackingMap2.size || !Intrinsics.areEqual((String) rulerTrackingMap.layoutNodes, (String) rulerTrackingMap2.layoutNodes) || !zEquals || !z || !z2) {
                }
            }
            return false;
        }
        return true;
    }

    public final Map getArguments() {
        return MapsKt__MapsKt.toMap((LinkedHashMap) this.impl.accessFlags);
    }

    public final boolean hasRoute(String str, Bundle bundle) {
        str.getClass();
        RulerTrackingMap rulerTrackingMap = this.impl;
        rulerTrackingMap.getClass();
        if (Intrinsics.areEqual((String) rulerTrackingMap.layoutNodes, str)) {
            return true;
        }
        DeepLinkMatch deepLinkMatchMatchRoute$navigation_common_release = rulerTrackingMap.matchRoute$navigation_common_release(str);
        if (!((NavDestination) rulerTrackingMap.rulers).equals(deepLinkMatchMatchRoute$navigation_common_release != null ? deepLinkMatchMatchRoute$navigation_common_release.destination : null)) {
            return false;
        }
        Bundle bundle2 = deepLinkMatchMatchRoute$navigation_common_release.matchingArgs;
        if (bundle == null || bundle2 == null) {
            return false;
        }
        Set<String> setKeySet = bundle2.keySet();
        setKeySet.getClass();
        for (String str2 : setKeySet) {
            str2.getClass();
            if (!bundle.containsKey(str2)) {
                return false;
            }
            NavArgument navArgument = (NavArgument) deepLinkMatchMatchRoute$navigation_common_release.destination.getArguments().get(str2);
            NavType navType = navArgument != null ? navArgument.type : null;
            Object obj = navType != null ? navType.get(str2, bundle2) : null;
            Object obj2 = navType != null ? navType.get(str2, bundle) : null;
            if (navType != null && !navType.valueEquals(obj, obj2)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        RulerTrackingMap rulerTrackingMap = this.impl;
        int i = rulerTrackingMap.size * 31;
        String str = (String) rulerTrackingMap.layoutNodes;
        int iHashCode = i + (str != null ? str.hashCode() : 0);
        ArrayList arrayList = (ArrayList) rulerTrackingMap.values;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            iHashCode = (((NavDeepLink) obj).uriPattern.hashCode() + (iHashCode * 31)) * 961;
        }
        SparseArrayCompat sparseArrayCompat = this.actions;
        sparseArrayCompat.getClass();
        if (sparseArrayCompat.size() > 0) {
            sparseArrayCompat.valueAt(0).getClass();
            PathKt$$ExternalSyntheticBUOutline0.m();
            return 0;
        }
        for (String str2 : getArguments().keySet()) {
            int iM = Fragment$5$$ExternalSyntheticOutline0.m(iHashCode * 31, 31, str2);
            Object obj2 = getArguments().get(str2);
            iHashCode = iM + (obj2 != null ? obj2.hashCode() : 0);
        }
        return iHashCode;
    }

    public DeepLinkMatch matchDeepLink(NavDeepLinkRequest navDeepLinkRequest) {
        boolean zMatches;
        Regex regex;
        MatcherMatchResult matcherMatchResultMatchEntire;
        RulerTrackingMap rulerTrackingMap = this.impl;
        LinkedHashMap linkedHashMap = (LinkedHashMap) rulerTrackingMap.accessFlags;
        Uri uri = (Uri) navDeepLinkRequest.uri;
        ArrayList arrayList = (ArrayList) rulerTrackingMap.values;
        if (arrayList.isEmpty()) {
            return null;
        }
        int size = arrayList.size();
        DeepLinkMatch deepLinkMatch = null;
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            NavDeepLink navDeepLink = (NavDeepLink) obj;
            navDeepLink.getClass();
            SynchronizedLazyImpl synchronizedLazyImpl = navDeepLink.pathPattern$delegate;
            if (((Regex) synchronizedLazyImpl.getValue()) == null) {
                zMatches = true;
            } else if (uri == null) {
                zMatches = false;
            } else {
                Regex regex2 = (Regex) synchronizedLazyImpl.getValue();
                regex2.getClass();
                zMatches = regex2.matches(uri.toString());
            }
            if (zMatches) {
                Bundle matchingArguments = uri != null ? navDeepLink.getMatchingArguments(uri, linkedHashMap) : null;
                int iCalculateMatchingPathSegments$navigation_common_release = navDeepLink.calculateMatchingPathSegments$navigation_common_release(uri);
                String str = (String) navDeepLinkRequest.action;
                boolean z = str != null && str.equals(null);
                if (matchingArguments == null) {
                    if (z) {
                        Bundle bundleBundleOf = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                        if (uri != null && (regex = (Regex) synchronizedLazyImpl.getValue()) != null && (matcherMatchResultMatchEntire = regex.matchEntire(uri.toString())) != null) {
                            navDeepLink.getMatchingPathArguments(matcherMatchResultMatchEntire, bundleBundleOf, linkedHashMap);
                            if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                                navDeepLink.getMatchingQueryArguments(uri, bundleBundleOf, linkedHashMap);
                            }
                        }
                        if (IntMath.missingRequiredArguments(linkedHashMap, new NavDeepLink$$ExternalSyntheticLambda8(bundleBundleOf, (byte) 1)).isEmpty()) {
                        }
                    }
                }
                DeepLinkMatch deepLinkMatch2 = new DeepLinkMatch((NavDestination) rulerTrackingMap.rulers, matchingArguments, navDeepLink.isExactDeepLink, iCalculateMatchingPathSegments$navigation_common_release, z);
                if (deepLinkMatch == null || deepLinkMatch2.compareTo(deepLinkMatch) > 0) {
                    deepLinkMatch = deepLinkMatch2;
                }
            }
        }
        return deepLinkMatch;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append("(0x");
        RulerTrackingMap rulerTrackingMap = this.impl;
        rulerTrackingMap.getClass();
        sb.append(Integer.toHexString(rulerTrackingMap.size));
        sb.append(")");
        String str = (String) rulerTrackingMap.layoutNodes;
        if (str != null && !StringsKt.isBlank(str)) {
            sb.append(" route=");
            sb.append((String) rulerTrackingMap.layoutNodes);
        }
        return sb.toString();
    }
}
