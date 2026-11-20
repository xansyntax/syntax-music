package kotlin.coroutines.jvm.internal;

import _COROUTINE.ArtificialStackFramesUnsafe;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor$Key;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.InlineList;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final CoroutineContext _context;
    private transient Continuation intercepted;

    public ContinuationImpl(Continuation continuation) {
        this(continuation, continuation != null ? continuation.getContext() : null);
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this._context;
        coroutineContext.getClass();
        return coroutineContext;
    }

    public final Continuation intercepted() {
        Continuation continuation = this.intercepted;
        if (continuation != null) {
            return continuation;
        }
        CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) getContext().get(ContinuationInterceptor$Key.$$INSTANCE);
        Continuation dispatchedContinuation = coroutineDispatcher != null ? new DispatchedContinuation(coroutineDispatcher, this) : this;
        this.intercepted = dispatchedContinuation;
        return dispatchedContinuation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        Unsafe unsafe;
        long j;
        Continuation continuation = this.intercepted;
        if (continuation != null && continuation != this) {
            CoroutineContext.Element element = getContext().get(ContinuationInterceptor$Key.$$INSTANCE);
            element.getClass();
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            do {
                unsafe = ArtificialStackFramesUnsafe.unsafe;
                j = DispatchedContinuation._reusableCancellableContinuation$volatile$FU$offset;
            } while (unsafe.getObjectVolatile(dispatchedContinuation, j) == InlineList.REUSABLE_CLAIMED);
            Object objectVolatile = unsafe.getObjectVolatile(dispatchedContinuation, j);
            CancellableContinuationImpl cancellableContinuationImpl = objectVolatile instanceof CancellableContinuationImpl ? (CancellableContinuationImpl) objectVolatile : null;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.detachChild$kotlinx_coroutines_core();
            }
        }
        this.intercepted = CompletedContinuation.INSTANCE;
    }

    public ContinuationImpl(Continuation continuation, CoroutineContext coroutineContext) {
        super(continuation);
        this._context = coroutineContext;
    }
}
