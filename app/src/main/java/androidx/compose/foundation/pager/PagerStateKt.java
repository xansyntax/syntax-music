package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PagerStateKt {
    public static final PagerMeasureResult EmptyLayoutInfo;
    public static final PagerStateKt$UnitDensity$1 UnitDensity;

    static {
        PagerStateKt$UnitDensity$1 pagerStateKt$UnitDensity$1 = new PagerStateKt$UnitDensity$1();
        UnitDensity = pagerStateKt$UnitDensity$1;
        EmptyLayoutInfo = new PagerMeasureResult(0, 0, 0, Orientation.Horizontal, 0, 0, 0, SnapPosition.Start.INSTANCE, new PagerStateKt$EmptyLayoutInfo$1(), AwaitKt.CoroutineScope(EmptyCoroutineContext.INSTANCE), pagerStateKt$UnitDensity$1, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15));
    }

    public static final long calculateNewMaxScrollOffset(PagerMeasureResult pagerMeasureResult, int i) {
        int i2 = pagerMeasureResult.pageSpacing;
        long j = (((((long) i) * ((long) (pagerMeasureResult.pageSize + i2))) + ((long) (-pagerMeasureResult.viewportStartOffset))) + ((long) pagerMeasureResult.afterContentPadding)) - ((long) i2);
        int iM179getViewportSizeYbymL2g = (int) (pagerMeasureResult.orientation == Orientation.Horizontal ? pagerMeasureResult.m179getViewportSizeYbymL2g() >> 32 : pagerMeasureResult.m179getViewportSizeYbymL2g() & 4294967295L);
        long jCoerceIn = j - ((long) (iM179getViewportSizeYbymL2g - UuidKt.coerceIn(pagerMeasureResult.snapPosition.position(i - 1, i), 0, iM179getViewportSizeYbymL2g)));
        if (jCoerceIn < 0) {
            return 0L;
        }
        return jCoerceIn;
    }
}
