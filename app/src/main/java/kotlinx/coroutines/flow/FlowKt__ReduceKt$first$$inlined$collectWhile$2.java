package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class FlowKt__ReduceKt$first$$inlined$collectWhile$2 implements FlowCollector {
    public final /* synthetic */ Function2 $predicate$inlined;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Ref$ObjectRef $result$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2$1, reason: invalid class name */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Object L$2;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__ReduceKt$first$$inlined$collectWhile$2.this.emit(null, this);
        }
    }

    public /* synthetic */ FlowKt__ReduceKt$first$$inlined$collectWhile$2(Function2 function2, Ref$ObjectRef ref$ObjectRef, byte b) {
        this.$r8$classId = b;
        this.$predicate$inlined = function2;
        this.$result$inlined = ref$ObjectRef;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x006d  */
    /* JADX WARN: Code duplicated, block: B:9:0x0024  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1 flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1;
        byte b = this.$r8$classId;
        Ref$ObjectRef ref$ObjectRef = this.$result$inlined;
        Unit unit = Unit.INSTANCE;
        Function2 function2 = this.$predicate$inlined;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                if (continuation instanceof AnonymousClass1) {
                    anonymousClass1 = (AnonymousClass1) continuation;
                    int i = anonymousClass1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        anonymousClass1.label = i - Integer.MIN_VALUE;
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                } else {
                    anonymousClass1 = new AnonymousClass1(continuation);
                }
                Object objInvoke = anonymousClass1.result;
                int i2 = anonymousClass1.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objInvoke);
                    anonymousClass1.L$2 = obj;
                    anonymousClass1.label = 1;
                    objInvoke = function2.invoke(obj, anonymousClass1);
                    if (objInvoke == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i2 != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    obj = anonymousClass1.L$2;
                    ResultKt.throwOnFailure(objInvoke);
                }
                if (!((Boolean) objInvoke).booleanValue()) {
                    return unit;
                }
                ref$ObjectRef.element = obj;
                throw new AbortFlowException(this);
            default:
                if (continuation instanceof FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1) {
                    flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1 = (FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1) continuation;
                    int i3 = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1.label;
                    if ((i3 & Integer.MIN_VALUE) != 0) {
                        flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1.label = i3 - Integer.MIN_VALUE;
                    } else {
                        flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1 = new FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1(this, continuation);
                    }
                } else {
                    flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1 = new FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1(this, continuation);
                }
                Object objInvoke2 = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1.result;
                int i4 = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1.label;
                if (i4 == 0) {
                    ResultKt.throwOnFailure(objInvoke2);
                    flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1.L$2 = obj;
                    flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1.label = 1;
                    objInvoke2 = function2.invoke(obj, flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1);
                    if (objInvoke2 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i4 != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    obj = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1.L$2;
                    ResultKt.throwOnFailure(objInvoke2);
                }
                if (!((Boolean) objInvoke2).booleanValue()) {
                    return unit;
                }
                ref$ObjectRef.element = obj;
                throw new AbortFlowException(this);
        }
    }
}
