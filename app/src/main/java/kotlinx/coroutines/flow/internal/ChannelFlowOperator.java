package kotlinx.coroutines.flow.internal;

import com.valentinilk.shimmer.ShimmerModifierKt$shimmer$1$1;
import kotlin.Unit;
import kotlin.coroutines.CombinedContext$$ExternalSyntheticLambda0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1;
import kotlinx.coroutines.internal.InlineList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ChannelFlowOperator extends ChannelFlow {
    public final Flow flow;

    public ChannelFlowOperator(Flow flow, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.flow = flow;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006f  */
    /* JADX WARN: Code duplicated, block: B:26:0x0075 A[RETURN] */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) throws Throwable {
        Object objCollect;
        int i = this.capacity;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i == -3) {
            CoroutineContext context = continuation.getContext();
            Boolean bool = Boolean.FALSE;
            CombinedContext$$ExternalSyntheticLambda0 combinedContext$$ExternalSyntheticLambda0 = new CombinedContext$$ExternalSyntheticLambda0((byte) 9);
            CoroutineContext coroutineContext = this.context;
            CoroutineContext coroutineContextPlus = !((Boolean) coroutineContext.fold(bool, combinedContext$$ExternalSyntheticLambda0)).booleanValue() ? context.plus(coroutineContext) : AwaitKt.foldCopies(context, coroutineContext, false);
            if (Intrinsics.areEqual(coroutineContextPlus, context)) {
                Object objFlowCollect = flowCollect(flowCollector, continuation);
                if (objFlowCollect == coroutineSingletons) {
                    return objFlowCollect;
                }
            } else {
                ContinuationInterceptor$Key continuationInterceptor$Key = ContinuationInterceptor$Key.$$INSTANCE;
                if (Intrinsics.areEqual(coroutineContextPlus.get(continuationInterceptor$Key), context.get(continuationInterceptor$Key))) {
                    CoroutineContext context2 = continuation.getContext();
                    if (!(flowCollector instanceof SendingCollector) && !(flowCollector instanceof NopCollector)) {
                        flowCollector = new FlowKt__LimitKt$take$2$1(flowCollector, context2);
                    }
                    Object objWithContextUndispatched = CombineKt.withContextUndispatched(coroutineContextPlus, flowCollector, InlineList.threadContextElements(coroutineContextPlus), new ShimmerModifierKt$shimmer$1$1(this, null, (byte) 8), continuation);
                    if (objWithContextUndispatched == coroutineSingletons) {
                        return objWithContextUndispatched;
                    }
                } else {
                    objCollect = super.collect(flowCollector, continuation);
                    if (objCollect == coroutineSingletons) {
                        return objCollect;
                    }
                }
            }
        } else {
            objCollect = super.collect(flowCollector, continuation);
            if (objCollect == coroutineSingletons) {
                return objCollect;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final Object collectTo(ProducerScope producerScope, Continuation continuation) {
        Object objFlowCollect = flowCollect(new SendingCollector(producerScope), continuation);
        return objFlowCollect == CoroutineSingletons.COROUTINE_SUSPENDED ? objFlowCollect : Unit.INSTANCE;
    }

    public Object flowCollect(FlowCollector flowCollector, Continuation continuation) {
        Object objCollect = this.flow.collect(flowCollector, continuation);
        return objCollect == CoroutineSingletons.COROUTINE_SUSPENDED ? objCollect : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final String toString() {
        return this.flow + " -> " + super.toString();
    }
}
