package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class AbstractFlow$collect$1 extends ContinuationImpl {
    public SafeCollector L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SafeFlow this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractFlow$collect$1(SafeFlow safeFlow, Continuation continuation) {
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
