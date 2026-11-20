package kotlinx.coroutines.sync;

import _COROUTINE.ArtificialStackFramesUnsafe;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda17;
import com.google.common.base.Joiner;
import io.ktor.websocket.PingPongKt$$ExternalSyntheticLambda0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancelledContinuation;
import kotlinx.coroutines.DispatchException;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class MutexImpl extends SemaphoreAndMutexImpl implements Mutex {
    public static final /* synthetic */ AtomicReferenceFieldUpdater owner$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner$volatile");
    public static final /* synthetic */ long owner$volatile$FU$offset = ArtificialStackFramesUnsafe.unsafe.objectFieldOffset(MutexImpl.class.getDeclaredField("owner$volatile"));
    private volatile /* synthetic */ Object owner$volatile;

    public MutexImpl() {
        super(1);
        this.owner$volatile = MutexKt.NO_OWNER;
    }

    public final boolean isLocked() {
        return Math.max(ArtificialStackFramesUnsafe.unsafe.getIntVolatile(this, SemaphoreAndMutexImpl._availablePermits$volatile$FU$offset), 0) == 0;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public final Object lock(Continuation continuation) {
        boolean zTryLock = tryLock();
        Unit unit = Unit.INSTANCE;
        if (!zTryLock) {
            CancellableContinuationImpl orCreateCancellableContinuation = AwaitKt.getOrCreateCancellableContinuation(Okio__OkioKt.intercepted(continuation));
            try {
                CancellableContinuationWithOwner cancellableContinuationWithOwner = new CancellableContinuationWithOwner(orCreateCancellableContinuation);
                while (true) {
                    int andDecrement = SemaphoreAndMutexImpl._availablePermits$volatile$FU.getAndDecrement(this);
                    if (andDecrement <= this.permits) {
                        if (andDecrement > 0) {
                            cancellableContinuationWithOwner.resume(unit, (Function3) this.onCancellationRelease);
                            break;
                        }
                        if (addAcquireToQueue(cancellableContinuationWithOwner)) {
                            break;
                        }
                    }
                }
                Object result = orCreateCancellableContinuation.getResult();
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (result != coroutineSingletons) {
                    result = unit;
                }
                if (result == coroutineSingletons) {
                    return result;
                }
            } catch (Throwable th) {
                orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                throw th;
            }
        }
        return unit;
    }

    public final String toString() {
        return "Mutex@" + AwaitKt.getHexAddress(this) + "[isLocked=" + isLocked() + ",owner=" + ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(this, owner$volatile$FU$offset) + ']';
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public final boolean tryLock() {
        MutexImpl mutexImpl;
        while (true) {
            Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
            long j = SemaphoreAndMutexImpl._availablePermits$volatile$FU$offset;
            int intVolatile = unsafe.getIntVolatile(this, j);
            if (intVolatile > this.permits) {
                while (true) {
                    Unsafe unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                    long j2 = SemaphoreAndMutexImpl._availablePermits$volatile$FU$offset;
                    int intVolatile2 = unsafe2.getIntVolatile(this, j2);
                    int i = this.permits;
                    if (intVolatile2 <= i) {
                        mutexImpl = this;
                        break;
                    }
                    MutexImpl mutexImpl2 = this;
                    mutexImpl = mutexImpl2;
                    if (unsafe2.compareAndSwapInt(mutexImpl2, j2, intVolatile2, i)) {
                        break;
                    }
                    this = mutexImpl;
                }
            } else {
                mutexImpl = this;
                if (intVolatile <= 0) {
                    return false;
                }
                if (unsafe.compareAndSwapInt(mutexImpl, j, intVolatile, intVolatile - 1)) {
                    unsafe.putObjectVolatile(mutexImpl, owner$volatile$FU$offset, (Object) null);
                    return true;
                }
            }
            this = mutexImpl;
        }
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public final void unlock(Object obj) {
        while (this.isLocked()) {
            Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
            long j = owner$volatile$FU$offset;
            Object objectVolatile = unsafe.getObjectVolatile(this, j);
            Joiner joiner = MutexKt.NO_OWNER;
            if (objectVolatile != joiner) {
                if (objectVolatile != obj && obj != null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m("This mutex is locked by ", objectVolatile, ", but ", obj, " is expected");
                    return;
                }
                while (true) {
                    MutexImpl mutexImpl = this;
                    if (ArtificialStackFramesUnsafe.unsafe.compareAndSwapObject(mutexImpl, owner$volatile$FU$offset, objectVolatile, joiner)) {
                        mutexImpl.release();
                        return;
                    } else {
                        if (ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(mutexImpl, j) != objectVolatile) {
                            this = mutexImpl;
                            break;
                        }
                        this = mutexImpl;
                    }
                }
            }
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This mutex is not locked");
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CancellableContinuationWithOwner implements CancellableContinuation, Waiter {
        public final CancellableContinuationImpl cont;

        public CancellableContinuationWithOwner(CancellableContinuationImpl cancellableContinuationImpl) {
            this.cont = cancellableContinuationImpl;
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public final boolean cancel(Throwable th) {
            return this.cont.cancel(th);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public final void completeResume(Object obj) throws DispatchException {
            this.cont.completeResume(obj);
        }

        @Override // kotlin.coroutines.Continuation
        public final CoroutineContext getContext() {
            return this.cont.context;
        }

        @Override // kotlinx.coroutines.Waiter
        public final void invokeOnCancellation(Segment segment, int i) {
            this.cont.invokeOnCancellation(segment, i);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public final boolean isCancelled() {
            return this.cont.getState$kotlinx_coroutines_core() instanceof CancelledContinuation;
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public <R extends Unit> void resume(R r, Function3 function3) throws DispatchException {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = MutexImpl.owner$volatile$FU;
            MutexImpl mutexImpl = MutexImpl.this;
            atomicReferenceFieldUpdater.set(mutexImpl, null);
            this.cont.resume(r, new PingPongKt$$ExternalSyntheticLambda0(mutexImpl, this));
        }

        @Override // kotlin.coroutines.Continuation
        public final void resumeWith(Object obj) {
            this.cont.resumeWith(obj);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public final Joiner tryResume(Object obj, Function3 function3) {
            MutexImpl mutexImpl = MutexImpl.this;
            ListItemKt$$ExternalSyntheticLambda17 listItemKt$$ExternalSyntheticLambda17 = new ListItemKt$$ExternalSyntheticLambda17(mutexImpl, this);
            Joiner joinerTryResumeImpl = this.cont.tryResumeImpl((Unit) obj, listItemKt$$ExternalSyntheticLambda17);
            if (joinerTryResumeImpl != null) {
                MutexImpl.owner$volatile$FU.set(mutexImpl, null);
            }
            return joinerTryResumeImpl;
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        @Deprecated
        public void resume(Unit unit, Function1 function1) throws DispatchException {
            this.cont.resume(unit, function1);
        }
    }
}
