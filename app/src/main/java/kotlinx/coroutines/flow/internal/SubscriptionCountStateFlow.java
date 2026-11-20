package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class SubscriptionCountStateFlow extends SharedFlowImpl implements StateFlow {
    @Override // kotlinx.coroutines.flow.StateFlow
    public final Object getValue() {
        Integer numValueOf;
        synchronized (this) {
            Object[] objArr = this.buffer;
            objArr.getClass();
            numValueOf = Integer.valueOf(((Number) objArr[((int) ((this.replayIndex + ((long) ((int) ((getHead() + ((long) this.bufferSize)) - this.replayIndex)))) - 1)) & (objArr.length - 1)]).intValue());
        }
        return numValueOf;
    }

    public final void increment(int i) {
        synchronized (this) {
            Object[] objArr = this.buffer;
            objArr.getClass();
            tryEmit(Integer.valueOf(((Number) objArr[((int) ((this.replayIndex + ((long) ((int) ((getHead() + ((long) this.bufferSize)) - this.replayIndex)))) - 1)) & (objArr.length - 1)]).intValue() + i));
        }
    }
}
