package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelAsFlow extends ChannelFlow {
    public static final /* synthetic */ AtomicIntegerFieldUpdater consumed$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(ChannelAsFlow.class, "consumed$volatile");
    public final ReceiveChannel channel;
    public final boolean consume;
    private volatile /* synthetic */ int consumed$volatile;

    public /* synthetic */ ChannelAsFlow(ReceiveChannel receiveChannel, boolean z) {
        this(receiveChannel, z, EmptyCoroutineContext.INSTANCE, -3, BufferOverflow.SUSPEND);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final String additionalToStringProps() {
        return "channel=" + this.channel;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) throws Throwable {
        int i = this.capacity;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i == -3) {
            boolean z = this.consume;
            if (z && consumed$volatile$FU.getAndSet(this, 1) == 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("ReceiveChannel.consumeAsFlow can be collected just once");
                return null;
            }
            Object objEmitAllImpl$FlowKt__ChannelsKt = StateFlowKt.emitAllImpl$FlowKt__ChannelsKt(flowCollector, this.channel, z, continuation);
            if (objEmitAllImpl$FlowKt__ChannelsKt == coroutineSingletons) {
                return objEmitAllImpl$FlowKt__ChannelsKt;
            }
        } else {
            Object objCollect = super.collect(flowCollector, continuation);
            if (objCollect == coroutineSingletons) {
                return objCollect;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final Object collectTo(ProducerScope producerScope, Continuation continuation) throws Throwable {
        Object objEmitAllImpl$FlowKt__ChannelsKt = StateFlowKt.emitAllImpl$FlowKt__ChannelsKt(new SendingCollector(producerScope), this.channel, this.consume, continuation);
        return objEmitAllImpl$FlowKt__ChannelsKt == CoroutineSingletons.COROUTINE_SUSPENDED ? objEmitAllImpl$FlowKt__ChannelsKt : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final ChannelFlow create(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return new ChannelAsFlow(this.channel, this.consume, coroutineContext, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final Flow dropChannelOperators() {
        return new ChannelAsFlow(this.channel, this.consume);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final ReceiveChannel produceImpl(CoroutineScope coroutineScope) {
        if (!this.consume || consumed$volatile$FU.getAndSet(this, 1) != 1) {
            return this.capacity == -3 ? this.channel : super.produceImpl(coroutineScope);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("ReceiveChannel.consumeAsFlow can be collected just once");
        return null;
    }

    public ChannelAsFlow(ReceiveChannel receiveChannel, boolean z, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.channel = receiveChannel;
        this.consume = z;
    }
}
