package coil3.request;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import coil3.RealImageLoader;
import coil3.target.GenericViewTarget;
import coil3.util.LifecyclesKt;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.utils.SyncUtils;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewTargetRequestDelegate implements RequestDelegate, DefaultLifecycleObserver {
    public final RealImageLoader imageLoader;
    public final ImageRequest initialRequest;
    public final Job job;
    public final Lifecycle lifecycle;
    public final GenericViewTarget target;

    public ViewTargetRequestDelegate(RealImageLoader realImageLoader, ImageRequest imageRequest, GenericViewTarget genericViewTarget, Lifecycle lifecycle, Job job) {
        this.imageLoader = realImageLoader;
        this.initialRequest = imageRequest;
        this.target = genericViewTarget;
        this.lifecycle = lifecycle;
        this.job = job;
    }

    @Override // coil3.request.RequestDelegate
    public final void assertActive() {
        GenericViewTarget genericViewTarget = this.target;
        if (genericViewTarget.getView().isAttachedToWindow()) {
            return;
        }
        ViewTargetRequestManager requestManager = DatabaseDao_Impl.AnonymousClass17.getRequestManager(genericViewTarget.getView());
        ViewTargetRequestDelegate viewTargetRequestDelegate = requestManager.currentRequest;
        if (viewTargetRequestDelegate != null) {
            Lifecycle lifecycle = viewTargetRequestDelegate.lifecycle;
            viewTargetRequestDelegate.job.cancel(null);
            GenericViewTarget genericViewTarget2 = viewTargetRequestDelegate.target;
            if (genericViewTarget2 != null && lifecycle != null) {
                lifecycle.removeObserver(genericViewTarget2);
            }
            if (lifecycle != null) {
                lifecycle.removeObserver(viewTargetRequestDelegate);
            }
        }
        requestManager.currentRequest = this;
        throw new CancellationException("'ViewTarget.view' must be attached to a window.");
    }

    @Override // coil3.request.RequestDelegate
    public final Object awaitStarted(RealImageLoader.AnonymousClass3 anonymousClass3) {
        Lifecycle lifecycle = this.lifecycle;
        return lifecycle != null ? LifecyclesKt.awaitStarted(lifecycle, anonymousClass3) : Unit.INSTANCE;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onDestroy(LifecycleOwner lifecycleOwner) {
        ViewTargetRequestManager requestManager = DatabaseDao_Impl.AnonymousClass17.getRequestManager(this.target.getView());
        synchronized (requestManager) {
            try {
                StandaloneCoroutine standaloneCoroutine = requestManager.pendingClear;
                Continuation continuation = null;
                if (standaloneCoroutine != null) {
                    standaloneCoroutine.cancel(null);
                }
                GlobalScope globalScope = GlobalScope.INSTANCE;
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                requestManager.pendingClear = AwaitKt.launch$default(globalScope, MainDispatcherLoader.dispatcher.immediate, null, new SyncUtils.AnonymousClass3(requestManager, continuation, (byte) 6), 2);
                requestManager.currentDisposable = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // coil3.request.RequestDelegate
    public final void start() {
        Lifecycle lifecycle = this.lifecycle;
        if (lifecycle != null) {
            lifecycle.addObserver(this);
        }
        GenericViewTarget genericViewTarget = this.target;
        if (genericViewTarget != null && lifecycle != null) {
            lifecycle.removeObserver(genericViewTarget);
            lifecycle.addObserver(genericViewTarget);
        }
        ViewTargetRequestManager requestManager = DatabaseDao_Impl.AnonymousClass17.getRequestManager(genericViewTarget.getView());
        ViewTargetRequestDelegate viewTargetRequestDelegate = requestManager.currentRequest;
        if (viewTargetRequestDelegate != null) {
            Lifecycle lifecycle2 = viewTargetRequestDelegate.lifecycle;
            viewTargetRequestDelegate.job.cancel(null);
            GenericViewTarget genericViewTarget2 = viewTargetRequestDelegate.target;
            if (genericViewTarget2 != null && lifecycle2 != null) {
                lifecycle2.removeObserver(genericViewTarget2);
            }
            if (lifecycle2 != null) {
                lifecycle2.removeObserver(viewTargetRequestDelegate);
            }
        }
        requestManager.currentRequest = this;
    }
}
