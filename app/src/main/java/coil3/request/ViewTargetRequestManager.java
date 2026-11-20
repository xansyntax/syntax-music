package coil3.request;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import coil3.RealImageLoader;
import coil3.RealImageLoader$enqueue$job$1;
import coil3.UriKt;
import coil3.target.GenericViewTarget;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.StandaloneCoroutine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewTargetRequestManager implements View.OnAttachStateChangeListener {
    public ViewTargetDisposable currentDisposable;
    public ViewTargetRequestDelegate currentRequest;
    public boolean isRestart;
    public StandaloneCoroutine pendingClear;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        ViewTargetRequestDelegate viewTargetRequestDelegate = this.currentRequest;
        if (viewTargetRequestDelegate == null) {
            return;
        }
        this.isRestart = true;
        RealImageLoader realImageLoader = viewTargetRequestDelegate.imageLoader;
        ImageRequest imageRequest = viewTargetRequestDelegate.initialRequest;
        UriKt.getDisposable(imageRequest, AwaitKt.async$default(realImageLoader.scope, (CoroutineContext) realImageLoader.options.mainCoroutineContextLazy.getValue(), new RealImageLoader$enqueue$job$1(realImageLoader, imageRequest, null, (byte) 0), 2));
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        ViewTargetRequestDelegate viewTargetRequestDelegate = this.currentRequest;
        if (viewTargetRequestDelegate != null) {
            Lifecycle lifecycle = viewTargetRequestDelegate.lifecycle;
            viewTargetRequestDelegate.job.cancel(null);
            GenericViewTarget genericViewTarget = viewTargetRequestDelegate.target;
            if (genericViewTarget != null && lifecycle != null) {
                lifecycle.removeObserver(genericViewTarget);
            }
            if (lifecycle != null) {
                lifecycle.removeObserver(viewTargetRequestDelegate);
            }
        }
    }
}
