package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class FlowKt__ReduceKt$first$$inlined$collectWhile$1 implements FlowCollector {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Ref$ObjectRef $result$inlined;

    public /* synthetic */ FlowKt__ReduceKt$first$$inlined$collectWhile$1(Ref$ObjectRef ref$ObjectRef, byte b) {
        this.$r8$classId = b;
        this.$result$inlined = ref$ObjectRef;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Ref$ObjectRef ref$ObjectRef = this.$result$inlined;
        switch (b) {
            case 0:
                ref$ObjectRef.element = obj;
                throw new AbortFlowException(this);
            default:
                ref$ObjectRef.element = obj;
                throw new AbortFlowException(this);
        }
    }
}
