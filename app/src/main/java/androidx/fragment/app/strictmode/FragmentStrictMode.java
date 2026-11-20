package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentStrictMode {
    public static final Policy defaultPolicy = Policy.LAX;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Policy {
        public static final Policy LAX;

        static {
            Policy policy = new Policy();
            new LinkedHashMap();
            LAX = policy;
        }
    }

    public static Policy getNearestPolicy(Fragment fragment) {
        while (fragment != null) {
            if (fragment.isAdded()) {
                fragment.getParentFragmentManager().getClass();
            }
            fragment = fragment.getParentFragment();
        }
        return defaultPolicy;
    }

    public static void logIfDebuggingEnabled(Violation violation) {
        if (FragmentManager.isLoggingEnabled(3)) {
            violation.fragment.getClass();
        }
    }

    public static final void onFragmentReuse(Fragment fragment, String str) {
        str.getClass();
        logIfDebuggingEnabled(new FragmentReuseViolation(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + str));
        getNearestPolicy(fragment).getClass();
    }
}
