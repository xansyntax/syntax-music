package kotlinx.coroutines;

import _COROUTINE.ArtificialStackFramesUnsafe;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class InvokeOnCancelling extends JobNode {
    public static final /* synthetic */ long _invoked$volatile$FU$offset = ArtificialStackFramesUnsafe.unsafe.objectFieldOffset(InvokeOnCancelling.class.getDeclaredField("_invoked$volatile"));
    private volatile /* synthetic */ int _invoked$volatile;
    public final Function1 handler;

    public InvokeOnCancelling(Function1 function1) {
        this.handler = function1;
    }

    @Override // kotlinx.coroutines.JobNode
    public final boolean getOnCancelling() {
        return true;
    }

    @Override // kotlinx.coroutines.JobNode
    public final void invoke(Throwable th) {
        if (ArtificialStackFramesUnsafe.unsafe.compareAndSwapInt(this, _invoked$volatile$FU$offset, 0, 1)) {
            this.handler.invoke(th);
        }
    }
}
