package kotlinx.coroutines.flow.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelFlowTransformLatest extends ChannelFlowOperator {
    public final Function3 transform;

    public ChannelFlowTransformLatest(Function3 function3, Flow flow, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        super(flow, coroutineContext, i, bufferOverflow);
        this.transform = function3;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final ChannelFlow create(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return new ChannelFlowTransformLatest(this.transform, this.flow, coroutineContext, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    public final Object flowCollect(FlowCollector flowCollector, Continuation continuation) {
        Object objCoroutineScope = AwaitKt.coroutineScope(new AnonymousClass3(flowCollector, null), continuation);
        return objCoroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED ? objCoroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass3 extends SuspendLambda implements Function2 {
        public final /* synthetic */ FlowCollector $collector;
        public final /* synthetic */ byte $r8$classId = 1;
        public /* synthetic */ Object L$0;
        public boolean label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(FlowCollector flowCollector, Object obj, Continuation continuation) {
            super(2, continuation);
            this.$collector = flowCollector;
            this.L$0 = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            FlowCollector flowCollector = this.$collector;
            ChannelFlowTransformLatest channelFlowTransformLatest = ChannelFlowTransformLatest.this;
            switch (b) {
                case 0:
                    AnonymousClass3 anonymousClass3 = channelFlowTransformLatest.new AnonymousClass3(flowCollector, continuation);
                    anonymousClass3.L$0 = obj;
                    return anonymousClass3;
                default:
                    return channelFlowTransformLatest.new AnonymousClass3(flowCollector, this.L$0, continuation);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    break;
            }
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(unit);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            FlowCollector flowCollector = this.$collector;
            ChannelFlowTransformLatest channelFlowTransformLatest = ChannelFlowTransformLatest.this;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            switch (b) {
                case 0:
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    boolean z = this.label;
                    if (z) {
                        if (z) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    Ref$ObjectRef ref$ObjectRefM5m = IntIntPair$$ExternalSyntheticOutline0.m5m(obj);
                    Flow flow = channelFlowTransformLatest.flow;
                    TriggerBasedInvalidationTracker$createFlow$1$2 triggerBasedInvalidationTracker$createFlow$1$2 = new TriggerBasedInvalidationTracker$createFlow$1$2(ref$ObjectRefM5m, coroutineScope, channelFlowTransformLatest, flowCollector);
                    this.L$0 = null;
                    this.label = true;
                    return flow.collect(triggerBasedInvalidationTracker$createFlow$1$2, this) == coroutineSingletons ? coroutineSingletons : unit;
                default:
                    boolean z2 = this.label;
                    if (z2) {
                        if (z2) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Function3 function3 = channelFlowTransformLatest.transform;
                    Object obj2 = this.L$0;
                    this.label = true;
                    return function3.invoke(flowCollector, obj2, this) == coroutineSingletons ? coroutineSingletons : unit;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(FlowCollector flowCollector, Continuation continuation) {
            super(2, continuation);
            this.$collector = flowCollector;
        }
    }
}
