package androidx.navigation;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.node.RulerTrackingMap;
import androidx.navigation.NavDeepLink;
import androidx.navigation.internal.NavDestinationImpl$$ExternalSyntheticLambda2;
import com.google.common.math.IntMath;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.SynchronizedLazyImpl;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavDestinationBuilder {
    public final Navigator navigator;
    public final String route;
    public final LinkedHashMap arguments = new LinkedHashMap();
    public final ArrayList deepLinks = new ArrayList();
    public final LinkedHashMap actions = new LinkedHashMap();

    public NavDestinationBuilder(Navigator navigator, String str) {
        this.navigator = navigator;
        this.route = str;
    }

    public NavDestination build() {
        NavDestination navDestinationInstantiateDestination = instantiateDestination();
        navDestinationInstantiateDestination.getClass();
        RulerTrackingMap rulerTrackingMap = navDestinationInstantiateDestination.impl;
        for (Map.Entry entry : this.arguments.entrySet()) {
            String str = (String) entry.getKey();
            NavArgument navArgument = (NavArgument) entry.getValue();
            str.getClass();
            navArgument.getClass();
            rulerTrackingMap.getClass();
            ((LinkedHashMap) rulerTrackingMap.accessFlags).put(str, navArgument);
        }
        ArrayList arrayList = this.deepLinks;
        int size = arrayList.size();
        final byte b = 0;
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            final NavDeepLink navDeepLink = (NavDeepLink) obj;
            navDeepLink.getClass();
            rulerTrackingMap.getClass();
            ArrayList arrayListMissingRequiredArguments = IntMath.missingRequiredArguments((LinkedHashMap) rulerTrackingMap.accessFlags, new Function1() { // from class: androidx.navigation.internal.NavDestinationImpl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    boolean zContains;
                    byte b2 = b;
                    NavDeepLink navDeepLink2 = navDeepLink;
                    String str2 = (String) obj2;
                    switch (b2) {
                        case 0:
                            str2.getClass();
                            zContains = navDeepLink2.getArgumentsNames$navigation_common_release().contains(str2);
                            break;
                        default:
                            str2.getClass();
                            zContains = navDeepLink2.getArgumentsNames$navigation_common_release().contains(str2);
                            break;
                    }
                    return Boolean.valueOf(!zContains);
                }
            });
            if (!arrayListMissingRequiredArguments.isEmpty()) {
                throw new IllegalArgumentException(("Deep link " + navDeepLink.uriPattern + " can't be used to open destination " + ((NavDestination) rulerTrackingMap.rulers) + ".\nFollowing required arguments are missing: " + arrayListMissingRequiredArguments).toString());
            }
            ((ArrayList) rulerTrackingMap.values).add(navDeepLink);
        }
        Iterator it = this.actions.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            ((Number) entry2.getKey()).intValue();
            entry2.getValue().getClass();
            PathKt$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        String str2 = this.route;
        if (str2 != null) {
            rulerTrackingMap.getClass();
            if (StringsKt.isBlank(str2)) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Cannot have an empty route");
                return null;
            }
            String strConcat = "android-app://androidx.navigation/".concat(str2);
            final NavDeepLink navDeepLink2 = new NavDeepLink(strConcat);
            final byte b2 = 1;
            ArrayList arrayListMissingRequiredArguments2 = IntMath.missingRequiredArguments((LinkedHashMap) rulerTrackingMap.accessFlags, new Function1() { // from class: androidx.navigation.internal.NavDestinationImpl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    boolean zContains;
                    byte b3 = b2;
                    NavDeepLink navDeepLink3 = navDeepLink2;
                    String str3 = (String) obj2;
                    switch (b3) {
                        case 0:
                            str3.getClass();
                            zContains = navDeepLink3.getArgumentsNames$navigation_common_release().contains(str3);
                            break;
                        default:
                            str3.getClass();
                            zContains = navDeepLink3.getArgumentsNames$navigation_common_release().contains(str3);
                            break;
                    }
                    return Boolean.valueOf(!zContains);
                }
            });
            if (!arrayListMissingRequiredArguments2.isEmpty()) {
                StringBuilder sbM4m = IntIntPair$$ExternalSyntheticOutline0.m4m("Cannot set route \"", str2, "\" for destination ");
                sbM4m.append((NavDestination) rulerTrackingMap.rulers);
                sbM4m.append(". Following required arguments are missing: ");
                sbM4m.append(arrayListMissingRequiredArguments2);
                throw new IllegalArgumentException(sbM4m.toString().toString());
            }
            rulerTrackingMap.newRulers = new SynchronizedLazyImpl(new NavDestinationImpl$$ExternalSyntheticLambda2(strConcat, b));
            rulerTrackingMap.size = strConcat.hashCode();
            rulerTrackingMap.layoutNodes = str2;
        }
        return navDestinationInstantiateDestination;
    }

    public NavDestination instantiateDestination() {
        return this.navigator.createDestination();
    }
}
