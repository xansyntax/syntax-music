package sh.calvin.reorderable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ReorderableCollectionItemScopeImpl {
    public final ReorderableLazyListKt$rememberReorderableLazyListState$1$1 itemPositionProvider;
    public final Object key;
    public final ReorderableLazyListState reorderableLazyCollectionState;

    public ReorderableCollectionItemScopeImpl(ReorderableLazyListState reorderableLazyListState, Object obj, ReorderableLazyListKt$rememberReorderableLazyListState$1$1 reorderableLazyListKt$rememberReorderableLazyListState$1$1) {
        this.reorderableLazyCollectionState = reorderableLazyListState;
        this.key = obj;
        this.itemPositionProvider = reorderableLazyListKt$rememberReorderableLazyListState$1$1;
    }
}
