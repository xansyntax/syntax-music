package sh.calvin.reorderable;

import androidx.compose.foundation.lazy.LazyListMeasureResult;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ReorderableLazyListKt$rememberReorderableLazyListState$1$1 extends Lambda implements Function0 {
    public final /* synthetic */ Object $lazyListState;
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReorderableLazyListKt$rememberReorderableLazyListState$1$1(byte b, Object obj) {
        super(0);
        this.$r8$classId = b;
        this.$lazyListState = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        long jM162getViewportSizeYbymL2g;
        byte b = this.$r8$classId;
        Object obj = this.$lazyListState;
        switch (b) {
            case 0:
                LazyListMeasureResult layoutInfo = ((LazyListState) obj).getLayoutInfo();
                int iOrdinal = layoutInfo.orientation.ordinal();
                if (iOrdinal == 0) {
                    jM162getViewportSizeYbymL2g = layoutInfo.m162getViewportSizeYbymL2g() & 4294967295L;
                } else {
                    if (iOrdinal != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    jM162getViewportSizeYbymL2g = layoutInfo.m162getViewportSizeYbymL2g() >> 32;
                }
                return Float.valueOf(((int) jM162getViewportSizeYbymL2g) * 0.05f);
            case 1:
                return ((LazyListState) obj).getLayoutInfo().orientation;
            default:
                Offset offset = (Offset) ((MutableState) obj).getValue();
                long j = offset.packedValue;
                return offset;
        }
    }
}
