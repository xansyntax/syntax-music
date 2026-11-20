package sh.calvin.reorderable;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Scroller$stop$1 extends ContinuationImpl {
    public Scroller L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ Scroller this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Scroller$stop$1(Scroller scroller, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = scroller;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.stop$reorderable_release(this);
    }
}
