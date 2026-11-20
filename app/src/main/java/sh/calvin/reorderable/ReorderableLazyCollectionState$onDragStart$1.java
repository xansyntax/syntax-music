package sh.calvin.reorderable;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ReorderableLazyCollectionState$onDragStart$1 extends ContinuationImpl {
    public long J$0;
    public ReorderableLazyListState L$0;
    public Object L$1;
    public ReorderableLazyListKt$toLazyCollectionItemInfo$1 L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ReorderableLazyListState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReorderableLazyCollectionState$onDragStart$1(ReorderableLazyListState reorderableLazyListState, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = reorderableLazyListState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m1923onDragStartd4ec7I$reorderable_release(null, 0L, this);
    }
}
