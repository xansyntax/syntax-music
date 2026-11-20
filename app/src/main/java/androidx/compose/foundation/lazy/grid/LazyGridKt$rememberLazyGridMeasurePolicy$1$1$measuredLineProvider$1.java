package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.InlineClassHelperKt;
import java.util.List;
import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 {
    public final /* synthetic */ boolean $isVertical;
    public final /* synthetic */ LazyGridSlots $resolvedSlots;
    public final int gridItemsCount;
    public final boolean isVertical;
    public final LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 measuredItemProvider;
    public final LazyGridSlots slots;
    public final int spaceBetweenLines;
    public final LazyGridSpanLayoutProvider spanLayoutProvider;

    public LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1(boolean z, LazyGridSlots lazyGridSlots, int i, int i2, LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1, LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider) {
        this.$isVertical = z;
        this.$resolvedSlots = lazyGridSlots;
        this.isVertical = z;
        this.slots = lazyGridSlots;
        this.gridItemsCount = i;
        this.spaceBetweenLines = i2;
        this.measuredItemProvider = lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1;
        this.spanLayoutProvider = lazyGridSpanLayoutProvider;
    }

    /* JADX INFO: renamed from: childConstraints-JhjzzOo$foundation, reason: not valid java name */
    public final long m167childConstraintsJhjzzOo$foundation(int i, int i2) {
        int i3;
        LazyGridSlots lazyGridSlots = this.slots;
        int[] iArr = lazyGridSlots.sizes;
        if (i2 == 1) {
            i3 = iArr[i];
        } else {
            int i4 = (i2 + i) - 1;
            int[] iArr2 = lazyGridSlots.positions;
            i3 = (iArr2[i4] + iArr[i4]) - iArr2[i];
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (this.isVertical) {
            if (i3 < 0) {
                InlineClassHelperKt.throwIllegalArgumentException("width must be >= 0");
            }
            return ConstraintsKt.createConstraints(i3, i3, 0, Integer.MAX_VALUE);
        }
        if (i3 < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("height must be >= 0");
        }
        return ConstraintsKt.createConstraints(0, Integer.MAX_VALUE, i3, i3);
    }

    public final LazyGridMeasuredLine getAndMeasure(int i) {
        PriorityQueue lineConfiguration = this.spanLayoutProvider.getLineConfiguration(i);
        int i2 = lineConfiguration.size;
        int size = ((List) lineConfiguration.array).size();
        int i3 = 0;
        int i4 = (size == 0 || i2 + size == this.gridItemsCount) ? 0 : this.spaceBetweenLines;
        LazyGridMeasuredItem[] lazyGridMeasuredItemArr = new LazyGridMeasuredItem[size];
        int i5 = 0;
        while (true) {
            List list = (List) lineConfiguration.array;
            if (i3 >= size) {
                return new LazyGridMeasuredLine(i, lazyGridMeasuredItemArr, this.$resolvedSlots, list, this.$isVertical, i4);
            }
            int i6 = (int) ((GridItemSpan) list.get(i3)).packedValue;
            LazyGridMeasuredItem lazyGridMeasuredItemM166getAndMeasurem8Kt_7k = this.measuredItemProvider.m166getAndMeasurem8Kt_7k(i2 + i3, m167childConstraintsJhjzzOo$foundation(i5, i6), i5, i6, i4);
            i5 += i6;
            lazyGridMeasuredItemArr[i3] = lazyGridMeasuredItemM166getAndMeasurem8Kt_7k;
            i3++;
        }
    }
}
