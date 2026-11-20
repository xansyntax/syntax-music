package kotlin.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SafeContinuation implements Continuation, CoroutineStackFrame {
    public static final AtomicReferenceFieldUpdater RESULT = AtomicReferenceFieldUpdater.newUpdater(SafeContinuation.class, Object.class, "result");
    public final Continuation delegate;
    private volatile Object result;

    public SafeContinuation(Continuation continuation) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        this.delegate = continuation;
        this.result = coroutineSingletons;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.delegate;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.delegate.getContext();
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = RESULT;
        while (true) {
            Object obj2 = this.result;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
            if (obj2 == coroutineSingletons) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, coroutineSingletons, obj)) {
                    if (atomicReferenceFieldUpdater.get(this) != coroutineSingletons) {
                    }
                }
                return;
            }
            CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (obj2 != coroutineSingletons2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Already resumed");
                return;
            }
            CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.RESUMED;
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, coroutineSingletons2, coroutineSingletons3)) {
                    this.delegate.resumeWith(obj);
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == coroutineSingletons2);
        }
    }

    public final String toString() {
        return "SafeContinuation for " + this.delegate;
    }
}
