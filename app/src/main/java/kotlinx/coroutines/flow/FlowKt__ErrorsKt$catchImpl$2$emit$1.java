package kotlinx.coroutines.flow;

import com.metrolist.music.viewmodels.HomeViewModel$2$1;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FlowKt__ErrorsKt$catchImpl$2$emit$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ HomeViewModel$2$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ErrorsKt$catchImpl$2$emit$1(HomeViewModel$2$1 homeViewModel$2$1, Continuation continuation) {
        super(continuation);
        this.this$0 = homeViewModel$2$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Object) null, this);
    }
}
