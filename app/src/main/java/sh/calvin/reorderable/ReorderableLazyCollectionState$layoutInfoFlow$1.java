package sh.calvin.reorderable;

import androidx.compose.foundation.lazy.LazyListMeasureResult;
import coil3.size.SizeKt;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ReorderableLazyCollectionState$layoutInfoFlow$1 extends Lambda implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ReorderableLazyListState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReorderableLazyCollectionState$layoutInfoFlow$1(ReorderableLazyListState reorderableLazyListState, byte b) {
        super(0);
        this.$r8$classId = b;
        this.this$0 = reorderableLazyListState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        long jM162getViewportSizeYbymL2g;
        long j;
        byte b = this.$r8$classId;
        float fM1881getAxis3MmeM6k = CropImageView.DEFAULT_ASPECT_RATIO;
        ReorderableLazyListState reorderableLazyListState = this.this$0;
        switch (b) {
            case 0:
                return reorderableLazyListState.state.getLayoutInfo();
            case 1:
                return Boolean.valueOf(reorderableLazyListState.draggingItemKey$delegate.getValue() != null);
            case 2:
                ReorderableLazyListKt$toLazyCollectionItemInfo$1 draggingItemLayoutInfo = reorderableLazyListState.getDraggingItemLayoutInfo();
                if (draggingItemLayoutInfo != null) {
                    LazyListMeasureResult lazyListMeasureResult = (LazyListMeasureResult) reorderableLazyListState.state.getLayoutInfo().delegate;
                    int iOrdinal = lazyListMeasureResult.orientation.ordinal();
                    if (iOrdinal == 0) {
                        jM162getViewportSizeYbymL2g = lazyListMeasureResult.m162getViewportSizeYbymL2g() & 4294967295L;
                    } else {
                        if (iOrdinal != 1) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        jM162getViewportSizeYbymL2g = lazyListMeasureResult.m162getViewportSizeYbymL2g() >> 32;
                    }
                    long jM1920getOffsetnOccac = draggingItemLayoutInfo.m1920getOffsetnOccac();
                    fM1881getAxis3MmeM6k = (((int) jM162getViewportSizeYbymL2g) - HexFormatKt.m1881getAxis3MmeM6k(SizeKt.Offset((int) (jM1920getOffsetnOccac >> 32), (int) (jM1920getOffsetnOccac & 4294967295L)), reorderableLazyListState.getOrientation$reorderable_release())) - 1.0f;
                }
                return Float.valueOf(fM1881getAxis3MmeM6k);
            case 3:
                ReorderableLazyListKt$toLazyCollectionItemInfo$1 draggingItemLayoutInfo2 = reorderableLazyListState.getDraggingItemLayoutInfo();
                if (draggingItemLayoutInfo2 != null) {
                    long jM1920getOffsetnOccac2 = draggingItemLayoutInfo2.m1920getOffsetnOccac();
                    float fM1881getAxis3MmeM6k2 = HexFormatKt.m1881getAxis3MmeM6k(SizeKt.Offset((int) (jM1920getOffsetnOccac2 >> 32), (int) (jM1920getOffsetnOccac2 & 4294967295L)), reorderableLazyListState.getOrientation$reorderable_release());
                    long jM1921getSizeYbymL2g = draggingItemLayoutInfo2.m1921getSizeYbymL2g();
                    int iOrdinal2 = reorderableLazyListState.getOrientation$reorderable_release().ordinal();
                    if (iOrdinal2 == 0) {
                        j = jM1921getSizeYbymL2g & 4294967295L;
                    } else {
                        if (iOrdinal2 != 1) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        j = jM1921getSizeYbymL2g >> 32;
                    }
                    fM1881getAxis3MmeM6k = (fM1881getAxis3MmeM6k2 + ((int) j)) - 1.0f;
                }
                return Float.valueOf(fM1881getAxis3MmeM6k);
            default:
                return reorderableLazyListState.getOrientation$reorderable_release();
        }
    }
}
