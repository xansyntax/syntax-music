package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class NamedDispatcher extends CoroutineDispatcher implements Delay {
    public final /* synthetic */ Delay $$delegate_0;
    public final CoroutineDispatcher dispatcher;
    public final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public NamedDispatcher(CoroutineDispatcher coroutineDispatcher, String str) {
        Delay delay = coroutineDispatcher instanceof Delay ? (Delay) coroutineDispatcher : null;
        this.$$delegate_0 = delay == null ? DefaultExecutorKt.DefaultDelay : delay;
        this.dispatcher = coroutineDispatcher;
        this.name = str;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        this.dispatcher.dispatch(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        this.dispatcher.dispatchYield(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.Delay
    public final DisposableHandle invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return this.$$delegate_0.invokeOnTimeout(j, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return this.dispatcher.isDispatchNeeded(coroutineContext);
    }

    @Override // kotlinx.coroutines.Delay
    public final void scheduleResumeAfterDelay(long j, CancellableContinuationImpl cancellableContinuationImpl) {
        this.$$delegate_0.scheduleResumeAfterDelay(j, cancellableContinuationImpl);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return this.name;
    }
}
