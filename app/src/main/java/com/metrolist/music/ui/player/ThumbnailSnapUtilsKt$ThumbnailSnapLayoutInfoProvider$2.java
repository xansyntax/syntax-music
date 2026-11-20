package com.metrolist.music.ui.player;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.lazy.grid.LazyGridMeasureResult;
import androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ThumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$2 implements SnapLayoutInfoProvider {
    public final /* synthetic */ LazyGridState $lazyGridState;
    public final /* synthetic */ Function2 $positionInLayout;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ThumbnailSnapUtilsKt$ThumbnailSnapLayoutInfoProvider$2(LazyGridState lazyGridState, Function2 function2, byte b) {
        this.$r8$classId = b;
        this.$lazyGridState = lazyGridState;
        this.$positionInLayout = function2;
    }

    @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
    public final float calculateApproachOffset(float f, float f2) {
        switch (this.$r8$classId) {
        }
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x010c, code lost:
    
        if (java.lang.Math.abs(r8) < java.lang.Math.abs(r7)) goto L51;
     */
    @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float calculateSnapOffset(float f) {
        byte b = this.$r8$classId;
        Orientation orientation = Orientation.Vertical;
        Function2 function2 = this.$positionInLayout;
        LazyGridState lazyGridState = this.$lazyGridState;
        float f2 = Float.POSITIVE_INFINITY;
        float f3 = Float.NEGATIVE_INFINITY;
        switch (b) {
            case 0:
                List list = lazyGridState.getLayoutInfo().visibleItemsInfo;
                QueueKt$$ExternalSyntheticLambda3 queueKt$$ExternalSyntheticLambda3 = (QueueKt$$ExternalSyntheticLambda3) function2;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    LazyGridMeasuredItem lazyGridMeasuredItem = (LazyGridMeasuredItem) list.get(i);
                    LazyGridMeasureResult layoutInfo = lazyGridState.getLayoutInfo();
                    layoutInfo.getClass();
                    lazyGridMeasuredItem.getClass();
                    float fFloatValue = ((int) (lazyGridMeasuredItem.offset >> 32)) - ((Number) queueKt$$ExternalSyntheticLambda3.invoke(Float.valueOf((((int) (layoutInfo.orientation == orientation ? layoutInfo.m168getViewportSizeYbymL2g() & 4294967295L : layoutInfo.m168getViewportSizeYbymL2g() >> 32)) - (-layoutInfo.viewportStartOffset)) - layoutInfo.afterContentPadding), Float.valueOf((int) (lazyGridMeasuredItem.size >> 32)))).floatValue();
                    if (fFloatValue <= CropImageView.DEFAULT_ASPECT_RATIO && fFloatValue > f3) {
                        f3 = fFloatValue;
                    }
                    if (fFloatValue >= CropImageView.DEFAULT_ASPECT_RATIO && fFloatValue < f2) {
                        f2 = fFloatValue;
                    }
                }
                if (Math.abs(f) >= 500.0f) {
                    if (f >= CropImageView.DEFAULT_ASPECT_RATIO) {
                        if (f <= CropImageView.DEFAULT_ASPECT_RATIO) {
                            return CropImageView.DEFAULT_ASPECT_RATIO;
                        }
                        return f2;
                    }
                    return f3;
                }
                break;
                break;
            default:
                for (LazyGridMeasuredItem lazyGridMeasuredItem2 : lazyGridState.getLayoutInfo().visibleItemsInfo) {
                    LazyGridMeasureResult layoutInfo2 = lazyGridState.getLayoutInfo();
                    layoutInfo2.getClass();
                    lazyGridMeasuredItem2.getClass();
                    float fFloatValue2 = ((int) (lazyGridMeasuredItem2.offset >> 32)) - ((Number) function2.invoke(Float.valueOf((((int) (layoutInfo2.orientation == orientation ? layoutInfo2.m168getViewportSizeYbymL2g() & 4294967295L : layoutInfo2.m168getViewportSizeYbymL2g() >> 32)) - (-layoutInfo2.viewportStartOffset)) - layoutInfo2.afterContentPadding), Float.valueOf((int) (lazyGridMeasuredItem2.size >> 32)))).floatValue();
                    if (fFloatValue2 <= CropImageView.DEFAULT_ASPECT_RATIO && fFloatValue2 > f3) {
                        f3 = fFloatValue2;
                    }
                    if (fFloatValue2 >= CropImageView.DEFAULT_ASPECT_RATIO && fFloatValue2 < f2) {
                        f2 = fFloatValue2;
                    }
                }
                if (f < CropImageView.DEFAULT_ASPECT_RATIO) {
                    return f3;
                }
                return f > CropImageView.DEFAULT_ASPECT_RATIO ? f2 : CropImageView.DEFAULT_ASPECT_RATIO;
        }
    }
}
