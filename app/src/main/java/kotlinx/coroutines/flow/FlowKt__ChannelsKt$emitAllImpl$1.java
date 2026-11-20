package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class FlowKt__ChannelsKt$emitAllImpl$1 extends ContinuationImpl {
    public FlowCollector L$0;
    public ReceiveChannel L$1;
    public ChannelIterator L$2;
    public boolean Z$0;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return StateFlowKt.emitAllImpl$FlowKt__ChannelsKt(null, null, false, this);
    }
}
