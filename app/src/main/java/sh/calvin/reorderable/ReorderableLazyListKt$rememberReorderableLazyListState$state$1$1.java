package sh.calvin.reorderable;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ReorderableLazyListKt$rememberReorderableLazyListState$state$1$1 extends Lambda implements Function2 {
    public static final ReorderableLazyListKt$rememberReorderableLazyListState$state$1$1 INSTANCE;
    public static final ReorderableLazyListKt$rememberReorderableLazyListState$state$1$1 INSTANCE$1;
    public final /* synthetic */ byte $r8$classId;

    static {
        int i = 2;
        INSTANCE = new ReorderableLazyListKt$rememberReorderableLazyListState$state$1$1((byte) 0, i);
        INSTANCE$1 = new ReorderableLazyListKt$rememberReorderableLazyListState$state$1$1((byte) 1, i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReorderableLazyListKt$rememberReorderableLazyListState$state$1$1(byte b, int i) {
        super(i);
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        boolean z = false;
        switch (this.$r8$classId) {
            case 0:
                Rect rect = (Rect) obj;
                Rect rect2 = (Rect) obj2;
                rect.getClass();
                rect2.getClass();
                float f = rect.top;
                float f2 = rect.bottom;
                float fM437getYimpl = Offset.m437getYimpl(rect2.m443getCenterF1C5BW0());
                if (fM437getYimpl >= f && fM437getYimpl < f2) {
                    z = true;
                }
                return Boolean.valueOf(z);
            default:
                Rect rect3 = (Rect) obj;
                Rect rect4 = (Rect) obj2;
                rect3.getClass();
                rect4.getClass();
                float f3 = rect3.left;
                float f4 = rect3.right;
                float fM436getXimpl = Offset.m436getXimpl(rect4.m443getCenterF1C5BW0());
                if (fM436getXimpl >= f3 && fM436getXimpl < f4) {
                    z = true;
                }
                return Boolean.valueOf(z);
        }
    }
}
