package sh.calvin.reorderable;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.AwaitKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ScrollerKt$rememberScroller$3$1 extends Lambda implements Function0 {
    public final /* synthetic */ Object $durationUpdated;
    public final /* synthetic */ Object $pixelAmountProviderUpdated;
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScrollerKt$rememberScroller$3$1(Object obj, Object obj2, byte b) {
        super(0);
        this.$r8$classId = b;
        this.$pixelAmountProviderUpdated = obj;
        this.$durationUpdated = obj2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Object obj = this.$durationUpdated;
        Object obj2 = this.$pixelAmountProviderUpdated;
        switch (b) {
            case 0:
                return Float.valueOf(((Number) ((Function0) ((MutableState) obj2).getValue()).invoke()).floatValue() / (((Number) ((MutableState) obj).getValue()).floatValue() / 1000.0f));
            case 1:
                ReorderableLazyListState reorderableLazyListState = ((ReorderableCollectionItemScopeImpl) obj2).reorderableLazyCollectionState;
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = reorderableLazyListState.draggingItemKey$delegate;
                ReorderableLazyListKt$toLazyCollectionItemInfo$1 draggingItemLayoutInfo = reorderableLazyListState.getDraggingItemLayoutInfo();
                IntOffset intOffset = draggingItemLayoutInfo != null ? new IntOffset(draggingItemLayoutInfo.m1920getOffsetnOccac()) : null;
                ReorderableLazyListKt$toLazyCollectionItemInfo$1 draggingItemLayoutInfo2 = reorderableLazyListState.getDraggingItemLayoutInfo();
                if ((draggingItemLayoutInfo2 != null ? Integer.valueOf(draggingItemLayoutInfo2.$this_toLazyCollectionItemInfo.index) : null) != null) {
                    reorderableLazyListState.previousDraggingItemKey$delegate.setValue(parcelableSnapshotMutableState.getValue());
                    AwaitKt.launch$default(reorderableLazyListState.scope, null, null, new ReorderableLazyCollectionState$onDragStop$1(reorderableLazyListState, reorderableLazyListState.m1922getDraggingItemOffsetF1C5BW0$reorderable_release(), (Continuation) null), 3);
                }
                reorderableLazyListState.draggingItemDraggedDelta$delegate.setValue(new Offset(0L));
                parcelableSnapshotMutableState.setValue(null);
                reorderableLazyListState.draggingItemInitialOffset$delegate.setValue(new IntOffset(intOffset != null ? intOffset.packedValue : 0L));
                Scroller scroller = reorderableLazyListState.scroller;
                AwaitKt.launch$default(scroller.scope, null, null, new Scroller$start$3(scroller, null, (byte) 1), 3);
                reorderableLazyListState.oldDraggingItemIndex$delegate.setValue(null);
                reorderableLazyListState.predictedDraggingItemOffset$delegate.setValue(null);
                ((Function0) obj).invoke();
                return Unit.INSTANCE;
            default:
                return Boolean.valueOf(obj2.equals(((ReorderableLazyListState) obj).draggingItemKey$delegate.getValue()));
        }
    }
}
