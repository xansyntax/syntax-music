package kotlinx.coroutines;

import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor$Key;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class UndispatchedCoroutine extends ScopeCoroutine {
    private volatile boolean threadLocalIsSet;
    public final ThreadLocal threadStateToRecover;

    /* JADX WARN: Illegal instructions before constructor call */
    public UndispatchedCoroutine(Continuation continuation, CoroutineContext coroutineContext) {
        UndispatchedMarker undispatchedMarker = UndispatchedMarker.INSTANCE;
        super(continuation, coroutineContext.get(undispatchedMarker) == null ? coroutineContext.plus(undispatchedMarker) : coroutineContext);
        this.threadStateToRecover = new ThreadLocal();
        if (continuation.getContext().get(ContinuationInterceptor$Key.$$INSTANCE) instanceof CoroutineDispatcher) {
            return;
        }
        Object objUpdateThreadContext = InlineList.updateThreadContext(coroutineContext, null);
        InlineList.restoreThreadContext(coroutineContext, objUpdateThreadContext);
        saveThreadContext(coroutineContext, objUpdateThreadContext);
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine
    public final void afterCompletionUndispatched() {
        clearThreadLocal();
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.JobSupport
    public final void afterResume(Object obj) {
        clearThreadLocal();
        Object objRecoverResult = AwaitKt.recoverResult(obj);
        Continuation continuation = this.uCont;
        CoroutineContext context = continuation.getContext();
        Object objUpdateThreadContext = InlineList.updateThreadContext(context, null);
        UndispatchedCoroutine undispatchedCoroutineUpdateUndispatchedCompletion = objUpdateThreadContext != InlineList.NO_THREAD_ELEMENTS ? AwaitKt.updateUndispatchedCompletion(continuation, context, objUpdateThreadContext) : null;
        try {
            continuation.resumeWith(objRecoverResult);
        } finally {
            if (undispatchedCoroutineUpdateUndispatchedCompletion == null || undispatchedCoroutineUpdateUndispatchedCompletion.clearThreadContext()) {
                InlineList.restoreThreadContext(context, objUpdateThreadContext);
            }
        }
    }

    public final boolean clearThreadContext() {
        boolean z = this.threadLocalIsSet && this.threadStateToRecover.get() == null;
        this.threadStateToRecover.remove();
        return !z;
    }

    public final void clearThreadLocal() {
        if (this.threadLocalIsSet) {
            Pair pair = (Pair) this.threadStateToRecover.get();
            if (pair != null) {
                InlineList.restoreThreadContext((CoroutineContext) pair.first, pair.second);
            }
            this.threadStateToRecover.remove();
        }
    }

    public final void saveThreadContext(CoroutineContext coroutineContext, Object obj) {
        this.threadLocalIsSet = true;
        this.threadStateToRecover.set(new Pair(coroutineContext, obj));
    }
}
