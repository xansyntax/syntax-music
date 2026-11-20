package kotlinx.coroutines.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.DispatchException;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public class ScopeCoroutine extends AbstractCoroutine implements CoroutineStackFrame {
    public final Continuation uCont;

    public ScopeCoroutine(Continuation continuation, CoroutineContext coroutineContext) {
        super(coroutineContext, true);
        this.uCont = continuation;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void afterCompletion(Object obj) throws DispatchException {
        InlineList.resumeCancellableWithInternal(AwaitKt.recoverResult(obj), Okio__OkioKt.intercepted(this.uCont));
    }

    @Override // kotlinx.coroutines.JobSupport
    public void afterResume(Object obj) {
        this.uCont.resumeWith(AwaitKt.recoverResult(obj));
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.uCont;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean isScopedCoroutine() {
        return true;
    }

    public void afterCompletionUndispatched() {
    }
}
