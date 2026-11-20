package com.metrolist.music.extensions;

import coil3.RealImageLoaderKt$CoroutineScope$$inlined$CoroutineExceptionHandler$1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.ContextScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CoroutineExtKt {
    public static final RealImageLoaderKt$CoroutineScope$$inlined$CoroutineExceptionHandler$1 SilentHandler = new RealImageLoaderKt$CoroutineScope$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key.$$INSTANCE, 2);

    /* JADX INFO: renamed from: com.metrolist.music.extensions.CoroutineExtKt$collect$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Function2 $action;
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Flow $this_collect;
        public boolean label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(Flow flow, Function2 function2, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$this_collect = flow;
            this.$action = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            Function2 function2 = this.$action;
            Flow flow = this.$this_collect;
            switch (b) {
                case 0:
                    return new AnonymousClass1(flow, function2, continuation, (byte) 0);
                default:
                    return new AnonymousClass1(flow, function2, continuation, (byte) 1);
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            Function2 function2 = this.$action;
            Flow flow = this.$this_collect;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            switch (b) {
                case 0:
                    boolean z = this.label;
                    if (!z) {
                        ResultKt.throwOnFailure(obj);
                        CoroutineExtKt$sam$kotlinx_coroutines_flow_FlowCollector$0 coroutineExtKt$sam$kotlinx_coroutines_flow_FlowCollector$0 = new CoroutineExtKt$sam$kotlinx_coroutines_flow_FlowCollector$0(function2);
                        this.label = true;
                        return flow.collect(coroutineExtKt$sam$kotlinx_coroutines_flow_FlowCollector$0, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                default:
                    boolean z2 = this.label;
                    if (!z2) {
                        ResultKt.throwOnFailure(obj);
                        this.label = true;
                        return StateFlowKt.collectLatest(flow, function2, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        }
    }

    public static final void collect(Flow flow, ContextScope contextScope, Function2 function2) {
        flow.getClass();
        contextScope.getClass();
        AwaitKt.launch$default(contextScope, null, null, new AnonymousClass1(flow, function2, null, (byte) 0), 3);
    }

    public static final void collectLatest(Flow flow, ContextScope contextScope, Function2 function2) {
        flow.getClass();
        contextScope.getClass();
        AwaitKt.launch$default(contextScope, null, null, new AnonymousClass1(flow, function2, null, (byte) 1), 3);
    }
}
