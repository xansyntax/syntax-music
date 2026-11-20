package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Density;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListMeasureResult implements MeasureResult {
    public final int afterContentPadding;
    public final boolean canScrollForward;
    public final long childConstraints;
    public final float consumedScroll;
    public final CoroutineScope coroutineScope;
    public final Density density;
    public final LazyListMeasuredItem firstVisibleItem;
    public final int firstVisibleItemScrollOffset;
    public final int mainAxisItemSpacing;
    public final MeasureResult measureResult;
    public final Orientation orientation;
    public final boolean remeasureNeeded;
    public final float scrollBackAmount;
    public final int stickingItemsCombinedSize;
    public final int totalItemsCount;
    public final int viewportEndOffset;
    public final int viewportStartOffset;
    public final List visibleItemsInfo;

    public LazyListMeasureResult(LazyListMeasuredItem lazyListMeasuredItem, int i, boolean z, float f, MeasureResult measureResult, float f2, boolean z2, CoroutineScope coroutineScope, Density density, long j, int i2, List list, int i3, int i4, int i5, Orientation orientation, int i6, int i7) {
        this.firstVisibleItem = lazyListMeasuredItem;
        this.firstVisibleItemScrollOffset = i;
        this.canScrollForward = z;
        this.consumedScroll = f;
        this.measureResult = measureResult;
        this.scrollBackAmount = f2;
        this.remeasureNeeded = z2;
        this.coroutineScope = coroutineScope;
        this.density = density;
        this.childConstraints = j;
        this.stickingItemsCombinedSize = i2;
        this.visibleItemsInfo = list;
        this.viewportStartOffset = i3;
        this.viewportEndOffset = i4;
        this.totalItemsCount = i5;
        this.orientation = orientation;
        this.afterContentPadding = i6;
        this.mainAxisItemSpacing = i7;
    }

    public final LazyListMeasureResult copyWithScrollDeltaWithoutRemeasure(int i, boolean z) {
        LazyListMeasuredItem lazyListMeasuredItem;
        int i2;
        int i3;
        if (this.remeasureNeeded) {
            return null;
        }
        List list = this.visibleItemsInfo;
        if (list.isEmpty() || (lazyListMeasuredItem = this.firstVisibleItem) == null) {
            return null;
        }
        int mainAxisSizeWithSpacings = lazyListMeasuredItem.getMainAxisSizeWithSpacings();
        int i4 = this.firstVisibleItemScrollOffset - i;
        if (i4 < 0 || i4 >= mainAxisSizeWithSpacings) {
            return null;
        }
        LazyListMeasuredItem lazyListMeasuredItem2 = (LazyListMeasuredItem) CollectionsKt.first(list);
        LazyListMeasuredItem lazyListMeasuredItem3 = (LazyListMeasuredItem) CollectionsKt.last(list);
        if (lazyListMeasuredItem2.nonScrollableItem || lazyListMeasuredItem3.nonScrollableItem) {
            return null;
        }
        int i5 = lazyListMeasuredItem2.offset;
        int i6 = this.viewportEndOffset;
        int i7 = this.viewportStartOffset;
        if (i < 0) {
            if (Math.min((lazyListMeasuredItem2.getMainAxisSizeWithSpacings() + i5) - i7, (lazyListMeasuredItem3.getMainAxisSizeWithSpacings() + lazyListMeasuredItem3.offset) - i6) <= (-i)) {
                return null;
            }
        } else if (Math.min(i7 - i5, i6 - lazyListMeasuredItem3.offset) <= i) {
            return null;
        }
        int size = list.size();
        int i8 = 0;
        while (i8 < size) {
            LazyListMeasuredItem lazyListMeasuredItem4 = (LazyListMeasuredItem) list.get(i8);
            boolean z2 = lazyListMeasuredItem4.isVertical;
            int[] iArr = lazyListMeasuredItem4.placeableOffsets;
            if (!lazyListMeasuredItem4.nonScrollableItem) {
                lazyListMeasuredItem4.offset += i;
                int length = iArr.length;
                for (int i9 = 0; i9 < length; i9++) {
                    int i10 = i9 & 1;
                    if ((z2 && i10 != 0) || (!z2 && i10 == 0)) {
                        iArr[i9] = iArr[i9] + i;
                    }
                }
                if (z) {
                    int size2 = lazyListMeasuredItem4.placeables.size();
                    int i11 = 0;
                    while (i11 < size2) {
                        LazyLayoutItemAnimation animation = lazyListMeasuredItem4.animator.getAnimation(i11, lazyListMeasuredItem4.key);
                        if (animation != null) {
                            long j = animation.targetOffset;
                            if (z2) {
                                i2 = (int) (j >> 32);
                                i3 = ((int) (j & 4294967295L)) + i;
                            } else {
                                i2 = ((int) (j >> 32)) + i;
                                i3 = (int) (j & 4294967295L);
                            }
                            animation.targetOffset = (((long) i3) & 4294967295L) | (((long) i2) << 32);
                        } else {
                            i4 = i4;
                        }
                        i11++;
                        i4 = i4;
                    }
                }
            }
            i8++;
            i4 = i4;
        }
        return new LazyListMeasureResult(this.firstVisibleItem, i4, this.canScrollForward || i > 0, i, this.measureResult, this.scrollBackAmount, this.remeasureNeeded, this.coroutineScope, this.density, this.childConstraints, this.stickingItemsCombinedSize, list, this.viewportStartOffset, this.viewportEndOffset, this.totalItemsCount, this.orientation, this.afterContentPadding, this.mainAxisItemSpacing);
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final Map getAlignmentLines() {
        return this.measureResult.getAlignmentLines();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final int getHeight() {
        return this.measureResult.getHeight();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final Function2 getRulerProvider() {
        return this.measureResult.getRulerProvider();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final Function1 getRulers() {
        return this.measureResult.getRulers();
    }

    /* JADX INFO: renamed from: getViewportSize-YbymL2g, reason: not valid java name */
    public final long m162getViewportSizeYbymL2g() {
        MeasureResult measureResult = this.measureResult;
        return (((long) measureResult.getWidth()) << 32) | (((long) measureResult.getHeight()) & 4294967295L);
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final int getWidth() {
        return this.measureResult.getWidth();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final Function1 isRulerProvided() {
        return this.measureResult.isRulerProvided();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final void placeChildren() {
        this.measureResult.placeChildren();
    }
}
