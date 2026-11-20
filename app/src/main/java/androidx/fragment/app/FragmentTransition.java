package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentTransition {
    public static final FragmentTransitionCompat21 PLATFORM_IMPL = new FragmentTransitionCompat21();
    public static final FragmentTransitionCompat21 SUPPORT_IMPL;

    static {
        FragmentTransitionCompat21 fragmentTransitionCompat21 = null;
        try {
            fragmentTransitionCompat21 = (FragmentTransitionCompat21) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        SUPPORT_IMPL = fragmentTransitionCompat21;
    }

    public static void setViewVisibility(int i, ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((View) arrayList.get(size)).setVisibility(i);
        }
    }
}
