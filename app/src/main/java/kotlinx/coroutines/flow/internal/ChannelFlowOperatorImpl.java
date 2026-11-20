package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelFlowOperatorImpl extends ChannelFlowOperator {
    public ChannelFlowOperatorImpl(Flow flow, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i2) {
        super(flow, (i2 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i2 & 4) != 0 ? -3 : i, (i2 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final ChannelFlow create(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return new ChannelFlowOperatorImpl(this.flow, coroutineContext, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final Flow dropChannelOperators() {
        return this.flow;
    }
}
