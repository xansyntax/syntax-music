package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LifecycleDispatcher {
    public static final AtomicBoolean initialized = new AtomicBoolean(false);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DispatcherActivityCallback extends EmptyActivityLifecycleCallbacks {
        @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            activity.getClass();
            int i = ReportFragment.$r8$clinit;
            ReportFragment.Companion.injectIfNeededIn(activity);
        }
    }
}
