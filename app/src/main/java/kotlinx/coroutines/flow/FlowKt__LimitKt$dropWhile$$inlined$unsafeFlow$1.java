package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.flow.internal.SafeCollector;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1 implements Flow {
    public final /* synthetic */ Function2 $predicate$inlined;
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Flow $this_dropWhile$inlined;

    public FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1(Function2 function2, Flow flow) {
        this.$predicate$inlined = function2;
        this.$this_dropWhile$inlined = flow;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0020  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [int] */
    /* JADX WARN: Type inference failed for: r10v2, types: [kotlin.coroutines.jvm.internal.ContinuationImpl] */
    /* JADX WARN: Type inference failed for: r10v4, types: [kotlin.coroutines.jvm.internal.ContinuationImpl] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1;
        int i;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Flow flow = this.$this_dropWhile$inlined;
        Function2 function2 = this.$predicate$inlined;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                Object objCollect = flow.collect(new FlowKt__LimitKt$take$2$1((Object) new Ref$BooleanRef(), (Object) flowCollector, (Object) function2, (byte) 9), continuation);
                return objCollect == coroutineSingletons ? objCollect : unit;
            default:
                if (continuation instanceof FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1) {
                    flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 = (FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1) continuation;
                    int i2 = flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1.label;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1.label = i2 - Integer.MIN_VALUE;
                    } else {
                        flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 = new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1(this, continuation);
                    }
                } else {
                    flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 = new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1(this, continuation);
                }
                Object obj = flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1.result;
                ?? r10 = flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1.label;
                try {
                    if (r10 == 0) {
                        ResultKt.throwOnFailure(obj);
                        SafeCollector safeCollector = new SafeCollector(flowCollector, flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1.getContext());
                        flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1.L$2 = flowCollector;
                        flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1.L$3 = safeCollector;
                        i = 0;
                        flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1.I$0 = 0;
                        flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1.label = 1;
                        Object objInvoke = function2.invoke(safeCollector, flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1);
                        r10 = safeCollector;
                        if (objInvoke != coroutineSingletons) {
                        }
                        return coroutineSingletons;
                    }
                    if (r10 != 1) {
                        if (r10 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    int i3 = flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1.I$0;
                    SafeCollector safeCollector2 = flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1.L$3;
                    FlowCollector flowCollector2 = flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1.L$2;
                    ResultKt.throwOnFailure(obj);
                    i = i3;
                    flowCollector = flowCollector2;
                    r10 = safeCollector2;
                    r10.releaseIntercepted();
                    flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1.L$2 = null;
                    flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1.L$3 = null;
                    flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1.I$0 = i;
                    flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1.label = 2;
                    if (flow.collect(flowCollector, flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1) != coroutineSingletons) {
                        return unit;
                    }
                    return coroutineSingletons;
                } catch (Throwable th) {
                    r10.releaseIntercepted();
                    throw th;
                }
        }
    }

    public FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1(Flow flow, Function2 function2) {
        this.$this_dropWhile$inlined = flow;
        this.$predicate$inlined = function2;
    }
}
