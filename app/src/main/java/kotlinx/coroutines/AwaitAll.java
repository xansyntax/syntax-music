package kotlinx.coroutines;

import _COROUTINE.ArtificialStackFramesUnsafe;
import com.google.common.base.Joiner;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class AwaitAll {
    public static final /* synthetic */ AtomicIntegerFieldUpdater notCompletedCount$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(AwaitAll.class, "notCompletedCount$volatile");
    public final Deferred[] deferreds;
    private volatile /* synthetic */ int notCompletedCount$volatile;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AwaitAllNode extends JobNode {
        public static final /* synthetic */ long _disposer$volatile$FU$offset = ArtificialStackFramesUnsafe.unsafe.objectFieldOffset(AwaitAllNode.class.getDeclaredField("_disposer$volatile"));
        private volatile /* synthetic */ Object _disposer$volatile;
        public final CancellableContinuationImpl continuation;
        public DisposableHandle handle;

        public AwaitAllNode(CancellableContinuationImpl cancellableContinuationImpl) {
            this.continuation = cancellableContinuationImpl;
        }

        @Override // kotlinx.coroutines.JobNode
        public final boolean getOnCancelling() {
            return false;
        }

        @Override // kotlinx.coroutines.JobNode
        public final void invoke(Throwable th) throws DispatchException {
            CancellableContinuationImpl cancellableContinuationImpl = this.continuation;
            if (th != null) {
                Joiner joinerTryResumeImpl = cancellableContinuationImpl.tryResumeImpl(new CompletedExceptionally(th, false), null);
                if (joinerTryResumeImpl != null) {
                    cancellableContinuationImpl.completeResume(joinerTryResumeImpl);
                    DisposeHandlersOnCancel disposeHandlersOnCancel = (DisposeHandlersOnCancel) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(this, _disposer$volatile$FU$offset);
                    if (disposeHandlersOnCancel != null) {
                        disposeHandlersOnCancel.disposeAll();
                        return;
                    }
                    return;
                }
                return;
            }
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = AwaitAll.notCompletedCount$volatile$FU;
            AwaitAll awaitAll = AwaitAll.this;
            if (atomicIntegerFieldUpdater.decrementAndGet(awaitAll) == 0) {
                Deferred[] deferredArr = awaitAll.deferreds;
                ArrayList arrayList = new ArrayList(deferredArr.length);
                for (Deferred deferred : deferredArr) {
                    arrayList.add(deferred.getCompleted());
                }
                cancellableContinuationImpl.resumeWith(arrayList);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DisposeHandlersOnCancel implements CancelHandler {
        public final AwaitAllNode[] nodes;

        public DisposeHandlersOnCancel(AwaitAllNode[] awaitAllNodeArr) {
            this.nodes = awaitAllNodeArr;
        }

        public final void disposeAll() {
            for (AwaitAllNode awaitAllNode : this.nodes) {
                DisposableHandle disposableHandle = awaitAllNode.handle;
                if (disposableHandle == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("handle");
                    throw null;
                }
                disposableHandle.dispose();
            }
        }

        @Override // kotlinx.coroutines.CancelHandler
        public final void invoke(Throwable th) {
            disposeAll();
        }

        public final String toString() {
            return "DisposeHandlersOnCancel[" + this.nodes + ']';
        }
    }

    public AwaitAll(Deferred[] deferredArr) {
        this.deferreds = deferredArr;
        this.notCompletedCount$volatile = deferredArr.length;
    }
}
