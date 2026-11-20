package kotlinx.coroutines;

import _COROUTINE.ArtificialStackFramesUnsafe;
import com.google.common.base.Joiner;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.InlineList;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ChildContinuation extends JobNode {
    public final CancellableContinuationImpl child;

    public ChildContinuation(CancellableContinuationImpl cancellableContinuationImpl) {
        this.child = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.JobNode
    public final boolean getOnCancelling() {
        return true;
    }

    @Override // kotlinx.coroutines.JobNode
    public final void invoke(Throwable th) {
        Unsafe unsafe;
        Unsafe unsafe2;
        JobSupport job = getJob();
        CancellableContinuationImpl cancellableContinuationImpl = this.child;
        Throwable continuationCancellationCause = cancellableContinuationImpl.getContinuationCancellationCause(job);
        if (cancellableContinuationImpl.isReusable()) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) cancellableContinuationImpl.delegate;
            long j = DispatchedContinuation._reusableCancellableContinuation$volatile$FU$offset;
            loop0: while (true) {
                Object objectVolatile = ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(dispatchedContinuation, j);
                Joiner joiner = InlineList.REUSABLE_CLAIMED;
                if (Intrinsics.areEqual(objectVolatile, joiner)) {
                    do {
                        unsafe = ArtificialStackFramesUnsafe.unsafe;
                        if (unsafe.compareAndSwapObject(dispatchedContinuation, DispatchedContinuation._reusableCancellableContinuation$volatile$FU$offset, joiner, continuationCancellationCause)) {
                            return;
                        }
                    } while (unsafe.getObjectVolatile(dispatchedContinuation, j) == joiner);
                } else {
                    if (objectVolatile instanceof Throwable) {
                        return;
                    }
                    do {
                        unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                        if (unsafe2.compareAndSwapObject(dispatchedContinuation, DispatchedContinuation._reusableCancellableContinuation$volatile$FU$offset, objectVolatile, (Object) null)) {
                            break loop0;
                        }
                    } while (unsafe2.getObjectVolatile(dispatchedContinuation, j) == objectVolatile);
                }
            }
        }
        cancellableContinuationImpl.cancel(continuationCancellationCause);
        if (cancellableContinuationImpl.isReusable()) {
            return;
        }
        cancellableContinuationImpl.detachChild$kotlinx_coroutines_core();
    }
}
