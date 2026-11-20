package androidx.lifecycle;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl implements LifecycleEventObserver, CoroutineScope {
    public final CoroutineContext coroutineContext;
    public final Lifecycle lifecycle;

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle, CoroutineContext coroutineContext) {
        lifecycle.getClass();
        coroutineContext.getClass();
        this.lifecycle = lifecycle;
        this.coroutineContext = coroutineContext;
        if (((LifecycleRegistry) lifecycle).state == Lifecycle.State.DESTROYED) {
            AwaitKt.cancel(coroutineContext, (CancellationException) null);
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Lifecycle lifecycle = this.lifecycle;
        if (((LifecycleRegistry) lifecycle).state.compareTo(Lifecycle.State.DESTROYED) <= 0) {
            lifecycle.removeObserver(this);
            AwaitKt.cancel(this.coroutineContext, (CancellationException) null);
        }
    }
}
