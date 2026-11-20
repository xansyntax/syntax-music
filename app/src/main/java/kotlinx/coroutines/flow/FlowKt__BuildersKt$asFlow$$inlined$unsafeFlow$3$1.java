package kotlinx.coroutines.flow;

import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1 extends ContinuationImpl {
    public int I$0;
    public int I$1;
    public FlowCollector L$2;
    public Iterator L$4;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SafeFlow this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1(SafeFlow safeFlow, Continuation continuation) {
        super(continuation);
        this.this$0 = safeFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collect(null, this);
    }
}
