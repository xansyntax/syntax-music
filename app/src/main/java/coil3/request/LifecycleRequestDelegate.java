package coil3.request;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import coil3.RealImageLoader;
import coil3.util.LifecyclesKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LifecycleRequestDelegate implements RequestDelegate, DefaultLifecycleObserver {
    public final Job job;
    public final Lifecycle lifecycle;

    public LifecycleRequestDelegate(Lifecycle lifecycle, Job job) {
        this.lifecycle = lifecycle;
        this.job = job;
    }

    @Override // coil3.request.RequestDelegate
    public final Object awaitStarted(RealImageLoader.AnonymousClass3 anonymousClass3) {
        return LifecyclesKt.awaitStarted(this.lifecycle, anonymousClass3);
    }

    @Override // coil3.request.RequestDelegate
    public final void complete() {
        this.lifecycle.removeObserver(this);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onDestroy(LifecycleOwner lifecycleOwner) {
        this.job.cancel(null);
    }

    @Override // coil3.request.RequestDelegate
    public final void start() {
        this.lifecycle.addObserver(this);
    }
}
