package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Density;
import coil3.util.LifecyclesKt;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyGridMeasureResult implements MeasureResult {
    public final int afterContentPadding;
    public final boolean canScrollForward;
    public final float consumedScroll;
    public final CoroutineScope coroutineScope;
    public final Density density;
    public final LazyGridMeasuredLine firstVisibleLine;
    public final int firstVisibleLineScrollOffset;
    public final Function1 lineIndexProvider;
    public final int mainAxisItemSpacing;
    public final MeasureResult measureResult;
    public final Orientation orientation;
    public final Function1 prefetchInfoRetriever;
    public final LazyLayoutPrefetchState prefetchState;
    public final LazyGridCacheWindowPrefetchStrategy prefetchStrategy;
    public final boolean remeasureNeeded;
    public final float scrollBackAmount;
    public final int slotsPerLine;
    public final int stickingItemsCombinedSize;
    public final int totalItemsCount;
    public final int viewportEndOffset;
    public final int viewportStartOffset;
    public final List visibleItemsInfo;

    public LazyGridMeasureResult(LazyGridMeasuredLine lazyGridMeasuredLine, int i, boolean z, float f, MeasureResult measureResult, float f2, boolean z2, CoroutineScope coroutineScope, Density density, int i2, Function1 function1, Function1 function2, int i3, LazyLayoutPrefetchState lazyLayoutPrefetchState, LazyGridCacheWindowPrefetchStrategy lazyGridCacheWindowPrefetchStrategy, List list, int i4, int i5, int i6, Orientation orientation, int i7, int i8) {
        this.firstVisibleLine = lazyGridMeasuredLine;
        this.firstVisibleLineScrollOffset = i;
        this.canScrollForward = z;
        this.consumedScroll = f;
        this.measureResult = measureResult;
        this.scrollBackAmount = f2;
        this.remeasureNeeded = z2;
        this.coroutineScope = coroutineScope;
        this.density = density;
        this.slotsPerLine = i2;
        this.prefetchInfoRetriever = function1;
        this.lineIndexProvider = function2;
        this.stickingItemsCombinedSize = i3;
        this.prefetchState = lazyLayoutPrefetchState;
        this.prefetchStrategy = lazyGridCacheWindowPrefetchStrategy;
        this.visibleItemsInfo = list;
        this.viewportStartOffset = i4;
        this.viewportEndOffset = i5;
        this.totalItemsCount = i6;
        this.orientation = orientation;
        this.afterContentPadding = i7;
        this.mainAxisItemSpacing = i8;
    }

    public final LazyGridMeasureResult copyWithScrollDeltaWithoutRemeasure(int i, boolean z) {
        LazyGridMeasuredLine lazyGridMeasuredLine;
        List list;
        int i2;
        if (this.remeasureNeeded) {
            return null;
        }
        List list2 = this.visibleItemsInfo;
        if (list2.isEmpty() || (lazyGridMeasuredLine = this.firstVisibleLine) == null) {
            return null;
        }
        int i3 = lazyGridMeasuredLine.mainAxisSizeWithSpacings;
        int i4 = this.firstVisibleLineScrollOffset - i;
        if (i4 < 0 || i4 >= i3) {
            return null;
        }
        LazyGridMeasuredItem lazyGridMeasuredItem = (LazyGridMeasuredItem) CollectionsKt.first(list2);
        LazyGridMeasuredItem lazyGridMeasuredItem2 = (LazyGridMeasuredItem) CollectionsKt.last(list2);
        if (lazyGridMeasuredItem.nonScrollableItem || lazyGridMeasuredItem2.nonScrollableItem) {
            return null;
        }
        int i5 = this.viewportEndOffset;
        int i6 = this.viewportStartOffset;
        Orientation orientation = this.orientation;
        if (i < 0) {
            if (Math.min((lazyGridMeasuredItem.getMainAxisSizeWithSpacings() + LifecyclesKt.offsetOnMainAxis(lazyGridMeasuredItem, orientation)) - i6, (lazyGridMeasuredItem2.getMainAxisSizeWithSpacings() + LifecyclesKt.offsetOnMainAxis(lazyGridMeasuredItem2, orientation)) - i5) <= (-i)) {
                return null;
            }
        } else if (Math.min(i6 - LifecyclesKt.offsetOnMainAxis(lazyGridMeasuredItem, orientation), i5 - LifecyclesKt.offsetOnMainAxis(lazyGridMeasuredItem2, orientation)) <= i) {
            return null;
        }
        int size = list2.size();
        int i7 = 0;
        while (i7 < size) {
            LazyGridMeasuredItem lazyGridMeasuredItem3 = (LazyGridMeasuredItem) list2.get(i7);
            boolean z2 = lazyGridMeasuredItem3.isVertical;
            if (lazyGridMeasuredItem3.nonScrollableItem) {
                list = list2;
                i2 = size;
            } else {
                long j = lazyGridMeasuredItem3.offset;
                long j2 = 4294967295L;
                lazyGridMeasuredItem3.offset = (((long) (z2 ? (int) (j >> 32) : ((int) (j >> 32)) + i)) << 32) | (((long) (z2 ? ((int) (j & 4294967295L)) + i : (int) (j & 4294967295L))) & 4294967295L);
                if (z) {
                    int size2 = lazyGridMeasuredItem3.placeables.size();
                    int i8 = 0;
                    while (i8 < size2) {
                        LazyLayoutItemAnimation animation = lazyGridMeasuredItem3.animator.getAnimation(i8, lazyGridMeasuredItem3.key);
                        if (animation != null) {
                            long j3 = animation.targetOffset;
                            animation.targetOffset = (((long) (z2 ? ((int) (j3 & j2)) + i : (int) (j3 & j2))) & j2) | (((long) (z2 ? (int) (j3 >> 32) : ((int) (j3 >> 32)) + i)) << 32);
                        } else {
                            j2 = j2;
                        }
                        i8++;
                        list2 = list2;
                        j2 = j2;
                        size = size;
                    }
                }
                list = list2;
                i2 = size;
            }
            i7++;
            i4 = i4;
            list2 = list;
            size = i2;
        }
        return new LazyGridMeasureResult(this.firstVisibleLine, i4, this.canScrollForward || i > 0, i, this.measureResult, this.scrollBackAmount, this.remeasureNeeded, this.coroutineScope, this.density, this.slotsPerLine, this.prefetchInfoRetriever, this.lineIndexProvider, this.stickingItemsCombinedSize, this.prefetchState, this.prefetchStrategy, list2, this.viewportStartOffset, this.viewportEndOffset, this.totalItemsCount, orientation, this.afterContentPadding, this.mainAxisItemSpacing);
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
    public final long m168getViewportSizeYbymL2g() {
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
