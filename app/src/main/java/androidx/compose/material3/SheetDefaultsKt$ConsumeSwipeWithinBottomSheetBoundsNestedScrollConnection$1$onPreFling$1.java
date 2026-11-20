package androidx.compose.material3;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 extends ContinuationImpl {
    public long J$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1(SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1 sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo326onPreFlingQWom1Mo(0L, this);
    }
}
