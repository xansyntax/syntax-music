package sh.calvin.reorderable;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ReorderableLazyCollectionState$onDrag$targetItem$1 extends Lambda implements Function1 {
    public final /* synthetic */ Object $draggingItem;
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReorderableLazyCollectionState$onDrag$targetItem$1(byte b, Object obj) {
        super(1);
        this.$r8$classId = b;
        this.$draggingItem = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Object obj2 = this.$draggingItem;
        switch (b) {
            case 0:
                ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$1 = (ReorderableLazyListKt$toLazyCollectionItemInfo$1) obj;
                reorderableLazyListKt$toLazyCollectionItemInfo$1.getClass();
                return Boolean.valueOf(reorderableLazyListKt$toLazyCollectionItemInfo$1.$this_toLazyCollectionItemInfo.index != ((ReorderableLazyListKt$toLazyCollectionItemInfo$1) obj2).$this_toLazyCollectionItemInfo.index);
            default:
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) obj;
                layoutCoordinates.getClass();
                ((MutableState) obj2).setValue(new Offset(layoutCoordinates.mo606localToRootMKHz9U(0L)));
                return Unit.INSTANCE;
        }
    }
}
