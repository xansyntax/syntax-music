package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.ui.node.RulerTrackingMap;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.internal.NavContext;
import androidx.navigation.internal.NavControllerImpl;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda2;
import coil3.ImageLoader$Builder;
import coil3.util.LifecyclesKt;
import coil3.util.UtilsKt;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Pair;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.SequencesKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavHostController {
    public final Activity activity;
    public final Context context;
    public boolean deepLinkHandled;
    public final boolean enableOnBackPressedCallback;
    public final NavControllerImpl impl;
    public final NavContext navContext;
    public final FragmentManager.AnonymousClass1 onBackPressedCallback;

    public NavHostController(Context context) {
        context.getClass();
        this.context = context;
        this.impl = new NavControllerImpl(this, new MainActivity$$ExternalSyntheticLambda2(this, (byte) 1));
        this.navContext = new NavContext(context, 0);
        for (Object obj : SequencesKt.generateSequence(context, new RoomDatabase$$ExternalSyntheticLambda2((byte) 5))) {
            if (((Context) obj) instanceof Activity) {
                this.activity = (Activity) obj;
                this.onBackPressedCallback = new FragmentManager.AnonymousClass1((byte) 3, this);
                this.enableOnBackPressedCallback = true;
                NavigatorProvider navigatorProvider = this.impl._navigatorProvider;
                navigatorProvider.addNavigator(new NavGraphNavigator(navigatorProvider));
                this.impl._navigatorProvider.addNavigator(new ActivityNavigator(this.context));
            }
        }
        obj = null;
        this.activity = (Activity) obj;
        this.onBackPressedCallback = new FragmentManager.AnonymousClass1((byte) 3, this);
        this.enableOnBackPressedCallback = true;
        NavigatorProvider navigatorProvider2 = this.impl._navigatorProvider;
        navigatorProvider2.addNavigator(new NavGraphNavigator(navigatorProvider2));
        this.impl._navigatorProvider.addNavigator(new ActivityNavigator(this.context));
    }

    public static void navigate$default(NavHostController navHostController, String str) {
        navHostController.getClass();
        str.getClass();
        navHostController.impl.navigate$navigation_runtime_release(str, null);
    }

    public final NavBackStackEntry getBackStackEntry() {
        Object objPrevious;
        NavBackStackEntry navBackStackEntry;
        NavControllerImpl navControllerImpl = this.impl;
        navControllerImpl.getClass();
        ArrayDeque arrayDeque = navControllerImpl.backQueue;
        ListIterator listIterator = arrayDeque.listIterator(arrayDeque.getSize());
        do {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            navBackStackEntry = (NavBackStackEntry) objPrevious;
        } while (!navBackStackEntry.destination.hasRoute("search_input", navBackStackEntry.impl.getArguments$navigation_common_release()));
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) objPrevious;
        if (navBackStackEntry2 != null) {
            return navBackStackEntry2;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$4(navControllerImpl.getCurrentDestination$navigation_runtime_release(), "No destination with route search_input is on the NavController's back stack. The current destination is ");
        return null;
    }

    public final int getDestinationCountOnBackStack() {
        ArrayDeque arrayDeque = this.impl.backQueue;
        int i = 0;
        if (arrayDeque != null && arrayDeque.isEmpty()) {
            return 0;
        }
        Iterator<E> it = arrayDeque.iterator();
        while (it.hasNext()) {
            if (!(((NavBackStackEntry) it.next()).destination instanceof NavGraph) && (i = i + 1) < 0) {
                CollectionsKt__IterablesKt.throwCountOverflow();
                throw null;
            }
        }
        return i;
    }

    public final void navigate(String str, Function1 function1) {
        NavControllerImpl navControllerImpl = this.impl;
        navControllerImpl.getClass();
        navControllerImpl.navigate$navigation_runtime_release(str, LifecyclesKt.navOptions(function1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void navigateUp() {
        Bundle bundleAddInDefaultArgs;
        Intent intent;
        if (getDestinationCountOnBackStack() != 1) {
            popBackStack();
            return;
        }
        Activity activity = this.activity;
        Bundle extras = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras();
        int[] intArray = extras != null ? extras.getIntArray("android-support-nav:controller:deepLinkIds") : null;
        NavControllerImpl navControllerImpl = this.impl;
        int i = 0;
        Object[] objArr = 0;
        if (intArray == null) {
            NavDestination currentDestination$navigation_runtime_release = navControllerImpl.getCurrentDestination$navigation_runtime_release();
            currentDestination$navigation_runtime_release.getClass();
            int i2 = currentDestination$navigation_runtime_release.impl.size;
            for (NavGraph navGraph = currentDestination$navigation_runtime_release.parent; navGraph != null; navGraph = navGraph.parent) {
                RulerTrackingMap rulerTrackingMap = ((NavDestination) navGraph).impl;
                if (navGraph.impl.startDestId != i2) {
                    Bundle bundleBundleOf = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                    if (activity != null && activity.getIntent() != null && activity.getIntent().getData() != null) {
                        Intent intent2 = activity.getIntent();
                        intent2.getClass();
                        bundleBundleOf.putParcelable("android-support-nav:controller:deepLinkIntent", intent2);
                        NavGraph topGraph$navigation_runtime_release = navControllerImpl.getTopGraph$navigation_runtime_release();
                        Intent intent3 = activity.getIntent();
                        intent3.getClass();
                        NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLinkComprehensive = topGraph$navigation_runtime_release.matchDeepLinkComprehensive(new NavDeepLinkRequest((Object) intent3.getData(), (Object) intent3.getAction(), (Object) intent3.getType(), (byte) (objArr == true ? 1 : 0)), topGraph$navigation_runtime_release);
                        if ((deepLinkMatchMatchDeepLinkComprehensive != null ? deepLinkMatchMatchDeepLinkComprehensive.matchingArgs : null) != null && (bundleAddInDefaultArgs = deepLinkMatchMatchDeepLinkComprehensive.destination.addInDefaultArgs(deepLinkMatchMatchDeepLinkComprehensive.matchingArgs)) != null) {
                            bundleBundleOf.putAll(bundleAddInDefaultArgs);
                        }
                    }
                    ImageLoader$Builder imageLoader$Builder = new ImageLoader$Builder(this);
                    int i3 = rulerTrackingMap.size;
                    ArrayList arrayList = (ArrayList) imageLoader$Builder.extras;
                    arrayList.clear();
                    arrayList.add(new NavDeepLinkBuilder$DeepLinkDestination(i3, null));
                    imageLoader$Builder.verifyAllDestinations();
                    ((Intent) imageLoader$Builder.memoryCacheLazy).putExtra("android-support-nav:controller:deepLinkExtras", bundleBundleOf);
                    imageLoader$Builder.createTaskStackBuilder().startActivities();
                    if (activity != null) {
                        activity.finish();
                        return;
                    }
                    return;
                }
                i2 = rulerTrackingMap.size;
            }
            return;
        }
        if (this.deepLinkHandled) {
            activity.getClass();
            Intent intent4 = activity.getIntent();
            Bundle extras2 = intent4.getExtras();
            extras2.getClass();
            int[] intArray2 = extras2.getIntArray("android-support-nav:controller:deepLinkIds");
            intArray2.getClass();
            ArrayList arrayList2 = new ArrayList(intArray2.length);
            for (int i4 : intArray2) {
                arrayList2.add(Integer.valueOf(i4));
            }
            ArrayList parcelableArrayList = extras2.getParcelableArrayList("android-support-nav:controller:deepLinkArgs");
            if (arrayList2.size() < 2) {
                return;
            }
            int iIntValue = ((Number) CollectionsKt__MutableCollectionsKt.removeLast(arrayList2)).intValue();
            if (parcelableArrayList != null) {
            }
            NavDestination navDestinationFindDestinationComprehensive$navigation_runtime_release = NavControllerImpl.findDestinationComprehensive$navigation_runtime_release(iIntValue, navControllerImpl.getGraph$navigation_runtime_release(), null, false);
            if (navDestinationFindDestinationComprehensive$navigation_runtime_release instanceof NavGraph) {
                int i5 = NavGraph.$r8$clinit;
                iIntValue = ((NavDestination) SequencesKt.last(SequencesKt.generateSequence((NavGraph) navDestinationFindDestinationComprehensive$navigation_runtime_release, new RoomDatabase$$ExternalSyntheticLambda2((byte) 10)))).impl.size;
            }
            NavDestination currentDestination$navigation_runtime_release2 = navControllerImpl.getCurrentDestination$navigation_runtime_release();
            if (currentDestination$navigation_runtime_release2 == null || iIntValue != currentDestination$navigation_runtime_release2.impl.size) {
                return;
            }
            ImageLoader$Builder imageLoader$Builder2 = new ImageLoader$Builder(this);
            Bundle bundleBundleOf2 = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
            bundleBundleOf2.putParcelable("android-support-nav:controller:deepLinkIntent", intent4);
            Bundle bundle = extras2.getBundle("android-support-nav:controller:deepLinkExtras");
            if (bundle != null) {
                bundleBundleOf2.putAll(bundle);
            }
            ((Intent) imageLoader$Builder2.memoryCacheLazy).putExtra("android-support-nav:controller:deepLinkExtras", bundleBundleOf2);
            int size = arrayList2.size();
            int i6 = 0;
            while (i6 < size) {
                Object obj = arrayList2.get(i6);
                i6++;
                int i7 = i + 1;
                if (i < 0) {
                    CollectionsKt__IterablesKt.throwIndexOverflow();
                    throw null;
                }
                ((ArrayList) imageLoader$Builder2.extras).add(new NavDeepLinkBuilder$DeepLinkDestination(((Number) obj).intValue(), parcelableArrayList != null ? (Bundle) parcelableArrayList.get(i) : null));
                imageLoader$Builder2.verifyAllDestinations();
                i = i7;
            }
            imageLoader$Builder2.createTaskStackBuilder().startActivities();
            activity.finish();
        }
    }

    public final boolean popBackStack() {
        NavControllerImpl navControllerImpl = this.impl;
        if (!navControllerImpl.backQueue.isEmpty()) {
            NavDestination currentDestination$navigation_runtime_release = navControllerImpl.getCurrentDestination$navigation_runtime_release();
            currentDestination$navigation_runtime_release.getClass();
            if (navControllerImpl.popBackStackInternal$navigation_runtime_release(currentDestination$navigation_runtime_release.impl.size, true, false) && navControllerImpl.dispatchOnDestinationChanged$navigation_runtime_release()) {
                return true;
            }
        }
        return false;
    }
}
