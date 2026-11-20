package kotlinx.coroutines;

import _COROUTINE.ArtificialStackFramesUnsafe;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Removed;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class JobNode extends LockFreeLinkedListNode implements DisposableHandle, Incomplete {
    public JobSupport job;

    @Override // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
        JobNode jobNode;
        Unsafe unsafe;
        long j;
        JobSupport job = getJob();
        while (true) {
            Object state$kotlinx_coroutines_core = job.getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof JobNode) {
                if (state$kotlinx_coroutines_core != this) {
                    return;
                }
                Empty empty = AwaitKt.EMPTY_ACTIVE;
                do {
                    unsafe = ArtificialStackFramesUnsafe.unsafe;
                    j = JobSupport._state$volatile$FU$offset;
                    if (unsafe.compareAndSwapObject(job, j, state$kotlinx_coroutines_core, empty)) {
                        return;
                    }
                } while (unsafe.getObjectVolatile(job, j) == state$kotlinx_coroutines_core);
            } else {
                if (!(state$kotlinx_coroutines_core instanceof Incomplete) || ((Incomplete) state$kotlinx_coroutines_core).getList() == null) {
                    return;
                }
                while (true) {
                    Object next = this.getNext();
                    if (next instanceof Removed) {
                        return;
                    }
                    if (next == this) {
                        return;
                    }
                    next.getClass();
                    LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
                    Unsafe unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                    long j2 = LockFreeLinkedListNode._removedRef$volatile$FU$offset;
                    Removed removed = (Removed) unsafe2.getObjectVolatile(lockFreeLinkedListNode, j2);
                    if (removed == null) {
                        removed = new Removed(lockFreeLinkedListNode);
                        unsafe2.putObjectVolatile(lockFreeLinkedListNode, j2, removed);
                    }
                    Removed removed2 = removed;
                    while (true) {
                        Unsafe unsafe3 = ArtificialStackFramesUnsafe.unsafe;
                        long j3 = LockFreeLinkedListNode._next$volatile$FU$offset;
                        jobNode = this;
                        if (unsafe3.compareAndSwapObject(jobNode, j3, next, removed2)) {
                            lockFreeLinkedListNode.correctPrev();
                            return;
                        } else if (unsafe3.getObjectVolatile(jobNode, j3) != next) {
                            break;
                        } else {
                            this = jobNode;
                        }
                    }
                    this = jobNode;
                }
            }
        }
    }

    public final JobSupport getJob() {
        JobSupport jobSupport = this.job;
        if (jobSupport != null) {
            return jobSupport;
        }
        Intrinsics.throwUninitializedPropertyAccessException("job");
        throw null;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final NodeList getList() {
        return null;
    }

    public boolean getOnCancelling() {
        return true;
    }

    public abstract void invoke(Throwable th);

    @Override // kotlinx.coroutines.Incomplete
    public final boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final String toString() {
        return getClass().getSimpleName() + '@' + AwaitKt.getHexAddress(this) + "[job@" + AwaitKt.getHexAddress(getJob()) + ']';
    }
}
