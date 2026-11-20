package kotlinx.coroutines;

import _COROUTINE.ArtificialStackFramesUnsafe;
import kotlin.Unit;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public class JobImpl extends JobSupport implements CompletableJob {
    public final boolean handlesException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JobImpl(Job job) {
        super(true);
        boolean z = true;
        initParentJob(job);
        Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
        long j = JobSupport._parentHandle$volatile$FU$offset;
        ChildHandle childHandle = (ChildHandle) unsafe.getObjectVolatile(this, j);
        ChildHandleNode childHandleNode = childHandle instanceof ChildHandleNode ? (ChildHandleNode) childHandle : null;
        if (childHandleNode == null) {
            z = false;
            break;
        }
        JobSupport job2 = childHandleNode.getJob();
        while (!job2.getHandlesException$kotlinx_coroutines_core()) {
            ChildHandle childHandle2 = (ChildHandle) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(job2, j);
            ChildHandleNode childHandleNode2 = childHandle2 instanceof ChildHandleNode ? (ChildHandleNode) childHandle2 : null;
            if (childHandleNode2 == null) {
                z = false;
                break;
            }
            job2 = childHandleNode2.getJob();
        }
        this.handlesException = z;
    }

    public final boolean complete$1() {
        return makeCompleting$kotlinx_coroutines_core(Unit.INSTANCE);
    }

    public final boolean completeExceptionally(Throwable th) {
        return makeCompleting$kotlinx_coroutines_core(new CompletedExceptionally(th, false));
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean getHandlesException$kotlinx_coroutines_core() {
        return this.handlesException;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }
}
