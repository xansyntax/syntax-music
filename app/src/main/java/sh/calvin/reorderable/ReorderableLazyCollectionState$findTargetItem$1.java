package sh.calvin.reorderable;

import androidx.compose.ui.geometry.Offset;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ReorderableLazyCollectionState$findTargetItem$1 extends Lambda implements Function1 {
    public static final ReorderableLazyCollectionState$findTargetItem$1 INSTANCE;
    public static final ReorderableLazyCollectionState$findTargetItem$1 INSTANCE$1;
    public final /* synthetic */ byte $r8$classId;

    static {
        int i = 1;
        INSTANCE$1 = new ReorderableLazyCollectionState$findTargetItem$1((byte) 1, i);
        INSTANCE = new ReorderableLazyCollectionState$findTargetItem$1((byte) 0, i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReorderableLazyCollectionState$findTargetItem$1(byte b, int i) {
        super(i);
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ((ReorderableLazyListKt$toLazyCollectionItemInfo$1) obj).getClass();
                return Boolean.TRUE;
            default:
                long j = ((Offset) obj).packedValue;
                return Unit.INSTANCE;
        }
    }
}
