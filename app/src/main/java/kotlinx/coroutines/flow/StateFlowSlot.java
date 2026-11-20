package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class StateFlowSlot extends AbstractSharedFlowSlot {
    public final AtomicReference _state = new AtomicReference(null);

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public final boolean allocateLocked(AbstractSharedFlow abstractSharedFlow) {
        AtomicReference atomicReference = this._state;
        if (atomicReference.get() != null) {
            return false;
        }
        atomicReference.set(StateFlowKt.NONE);
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public final Continuation[] freeLocked(AbstractSharedFlow abstractSharedFlow) {
        this._state.set(null);
        return CombineKt.EMPTY_RESUMES;
    }
}
