package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.datastore.core.AtomicInt;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Landroidx/lifecycle/ReportFragment;", "Landroid/app/Fragment;", "<init>", "()V", "androidx/datastore/core/AtomicInt", "LifecycleCallbacks", "Companion", "lifecycle-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ReportFragment extends Fragment {
    public static final /* synthetic */ int $r8$clinit = 0;
    public AtomicInt processListener;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Companion {
        /* JADX WARN: Multi-variable type inference failed */
        public static void dispatch$lifecycle_runtime(Activity activity, Lifecycle.Event event) {
            event.getClass();
            if (activity instanceof LifecycleOwner) {
                Lifecycle lifecycle = ((LifecycleOwner) activity).getLifecycle();
                if (lifecycle instanceof LifecycleRegistry) {
                    ((LifecycleRegistry) lifecycle).handleLifecycleEvent(event);
                }
            }
        }

        public static void injectIfNeededIn(Activity activity) {
            if (Build.VERSION.SDK_INT >= 29) {
                LifecycleCallbacks.Companion.getClass();
                LifecycleCallbacks.Companion.registerIn(activity);
            }
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
                fragmentManager.beginTransaction().add(new ReportFragment(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
                fragmentManager.executePendingTransactions();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        public static final Companion Companion = new Companion();

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Companion {
            public static void registerIn(Activity activity) {
                activity.getClass();
                activity.registerActivityLifecycleCallbacks(new LifecycleCallbacks());
            }
        }

        public static final void registerIn(Activity activity) {
            Companion.getClass();
            Companion.registerIn(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            activity.getClass();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            activity.getClass();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            activity.getClass();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            activity.getClass();
            int i = ReportFragment.$r8$clinit;
            Companion.dispatch$lifecycle_runtime(activity, Lifecycle.Event.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            activity.getClass();
            int i = ReportFragment.$r8$clinit;
            Companion.dispatch$lifecycle_runtime(activity, Lifecycle.Event.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            activity.getClass();
            int i = ReportFragment.$r8$clinit;
            Companion.dispatch$lifecycle_runtime(activity, Lifecycle.Event.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            activity.getClass();
            int i = ReportFragment.$r8$clinit;
            Companion.dispatch$lifecycle_runtime(activity, Lifecycle.Event.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            activity.getClass();
            int i = ReportFragment.$r8$clinit;
            Companion.dispatch$lifecycle_runtime(activity, Lifecycle.Event.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            activity.getClass();
            int i = ReportFragment.$r8$clinit;
            Companion.dispatch$lifecycle_runtime(activity, Lifecycle.Event.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            activity.getClass();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            activity.getClass();
            bundle.getClass();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            activity.getClass();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            activity.getClass();
        }
    }

    public final void dispatch(Lifecycle.Event event) {
        if (Build.VERSION.SDK_INT < 29) {
            Activity activity = getActivity();
            activity.getClass();
            Companion.dispatch$lifecycle_runtime(activity, event);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        dispatch(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        dispatch(Lifecycle.Event.ON_DESTROY);
        this.processListener = null;
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        dispatch(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        AtomicInt atomicInt = this.processListener;
        if (atomicInt != null) {
            ((ProcessLifecycleOwner) atomicInt.delegate).activityResumed$lifecycle_process();
        }
        dispatch(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        AtomicInt atomicInt = this.processListener;
        if (atomicInt != null) {
            ProcessLifecycleOwner processLifecycleOwner = (ProcessLifecycleOwner) atomicInt.delegate;
            int i = processLifecycleOwner.startedCounter + 1;
            processLifecycleOwner.startedCounter = i;
            if (i == 1 && processLifecycleOwner.stopSent) {
                processLifecycleOwner.registry.handleLifecycleEvent(Lifecycle.Event.ON_START);
                processLifecycleOwner.stopSent = false;
            }
        }
        dispatch(Lifecycle.Event.ON_START);
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        dispatch(Lifecycle.Event.ON_STOP);
    }
}
