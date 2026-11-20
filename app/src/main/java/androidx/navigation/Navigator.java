package androidx.navigation;

import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.ListIterator;
import kotlin.io.LinesSequence;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.FilteringSequence;
import kotlin.sequences.TransformingSequence;
import kotlin.time.InstantKt$$ExternalSyntheticLambda0;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Navigator {
    public NavController$NavControllerNavigatorState _state;
    public boolean isAttached;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Name {
        String value();
    }

    public NavDestination createDestination() {
        return new ActivityNavigator.Destination(this);
    }

    public final NavController$NavControllerNavigatorState getState() {
        NavController$NavControllerNavigatorState navController$NavControllerNavigatorState = this._state;
        if (navController$NavControllerNavigatorState != null) {
            return navController$NavControllerNavigatorState;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("You cannot access the Navigator's state until the Navigator is attached");
        return null;
    }

    public void navigate(List list, NavOptions navOptions) {
        FilteringSequence.AnonymousClass1 anonymousClass1 = new FilteringSequence.AnonymousClass1(new FilteringSequence(new TransformingSequence(new LinesSequence((byte) 2, list), new DiskLruCache$$ExternalSyntheticLambda0(this, navOptions, (byte) 12)), false, new InstantKt$$ExternalSyntheticLambda0((byte) 19)));
        while (anonymousClass1.hasNext()) {
            getState().push((NavBackStackEntry) anonymousClass1.next());
        }
    }

    public void popBackStack(NavBackStackEntry navBackStackEntry, boolean z) {
        List list = (List) getState().backStack.$$delegate_0.getValue();
        if (!list.contains(navBackStackEntry)) {
            PathKt$$ExternalSyntheticBUOutline0.m("popBackStack was called with ", navBackStackEntry, " which does not exist in back stack ", list);
            return;
        }
        ListIterator listIterator = list.listIterator(list.size());
        NavBackStackEntry navBackStackEntry2 = null;
        while (popBackStack()) {
            navBackStackEntry2 = (NavBackStackEntry) listIterator.previous();
            if (Intrinsics.areEqual(navBackStackEntry2, navBackStackEntry)) {
                break;
            }
        }
        if (navBackStackEntry2 != null) {
            getState().pop(navBackStackEntry2, z);
        }
    }

    public NavDestination navigate(NavDestination navDestination) {
        return navDestination;
    }

    public boolean popBackStack() {
        return true;
    }
}
