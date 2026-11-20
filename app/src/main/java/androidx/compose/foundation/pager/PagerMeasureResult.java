package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Density;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PagerMeasureResult implements MeasureResult {
    public final int afterContentPadding;
    public final int beyondViewportPageCount;
    public final boolean canScrollForward;
    public final long childConstraints;
    public final CoroutineScope coroutineScope;
    public final MeasuredPage currentPage;
    public final float currentPageOffsetFraction;
    public final Density density;
    public final List extraPagesAfter;
    public final List extraPagesBefore;
    public final MeasuredPage firstVisiblePage;
    public final int firstVisiblePageScrollOffset;
    public final MeasureResult measureResult;
    public final Orientation orientation;
    public final int pageSize;
    public final int pageSpacing;
    public final boolean remeasureNeeded;
    public final SnapPosition snapPosition;
    public final int viewportEndOffset;
    public final int viewportStartOffset;
    public final List visiblePagesInfo;

    public PagerMeasureResult(List list, int i, int i2, int i3, Orientation orientation, int i4, int i5, int i6, MeasuredPage measuredPage, MeasuredPage measuredPage2, float f, int i7, boolean z, SnapPosition snapPosition, MeasureResult measureResult, boolean z2, List list2, List list3, CoroutineScope coroutineScope, Density density, long j) {
        this.visiblePagesInfo = list;
        this.pageSize = i;
        this.pageSpacing = i2;
        this.afterContentPadding = i3;
        this.orientation = orientation;
        this.viewportStartOffset = i4;
        this.viewportEndOffset = i5;
        this.beyondViewportPageCount = i6;
        this.firstVisiblePage = measuredPage;
        this.currentPage = measuredPage2;
        this.currentPageOffsetFraction = f;
        this.firstVisiblePageScrollOffset = i7;
        this.canScrollForward = z;
        this.snapPosition = snapPosition;
        this.measureResult = measureResult;
        this.remeasureNeeded = z2;
        this.extraPagesBefore = list2;
        this.extraPagesAfter = list3;
        this.coroutineScope = coroutineScope;
        this.density = density;
        this.childConstraints = j;
    }

    public final PagerMeasureResult copyWithScrollDeltaWithoutRemeasure(int i) {
        int i2;
        int i3 = this.pageSize + this.pageSpacing;
        if (this.remeasureNeeded) {
            return null;
        }
        List list = this.visiblePagesInfo;
        if (list.isEmpty() || this.firstVisiblePage == null || (i2 = this.firstVisiblePageScrollOffset - i) < 0 || i2 >= i3) {
            return null;
        }
        float f = this.currentPageOffsetFraction - (i3 != 0 ? i / i3 : CropImageView.DEFAULT_ASPECT_RATIO);
        if (this.currentPage == null || f >= 0.5f || f <= -0.5f) {
            return null;
        }
        MeasuredPage measuredPage = (MeasuredPage) CollectionsKt.first(list);
        MeasuredPage measuredPage2 = (MeasuredPage) CollectionsKt.last(list);
        int i4 = this.viewportEndOffset;
        int i5 = this.viewportStartOffset;
        if (i < 0) {
            if (Math.min((measuredPage.offset + i3) - i5, (measuredPage2.offset + i3) - i4) <= (-i)) {
                return null;
            }
        } else if (Math.min(i5 - measuredPage.offset, i4 - measuredPage2.offset) <= i) {
            return null;
        }
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((MeasuredPage) list.get(i6)).applyScrollDelta(i);
        }
        List list2 = this.extraPagesBefore;
        int size2 = list2.size();
        for (int i7 = 0; i7 < size2; i7++) {
            ((MeasuredPage) list2.get(i7)).applyScrollDelta(i);
        }
        List list3 = this.extraPagesAfter;
        int size3 = list3.size();
        for (int i8 = 0; i8 < size3; i8++) {
            ((MeasuredPage) list3.get(i8)).applyScrollDelta(i);
        }
        return new PagerMeasureResult(this.visiblePagesInfo, this.pageSize, this.pageSpacing, this.afterContentPadding, this.orientation, this.viewportStartOffset, this.viewportEndOffset, this.beyondViewportPageCount, this.firstVisiblePage, this.currentPage, f, i2, this.canScrollForward || i > 0, this.snapPosition, this.measureResult, this.remeasureNeeded, this.extraPagesBefore, this.extraPagesAfter, this.coroutineScope, this.density, this.childConstraints);
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
    public final long m179getViewportSizeYbymL2g() {
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

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PagerMeasureResult(int i, int i2, int i3, Orientation orientation, int i4, int i5, int i6, SnapPosition snapPosition, MeasureResult measureResult, CoroutineScope coroutineScope, Density density, long j) {
        EmptyList emptyList = EmptyList.INSTANCE;
        this(emptyList, i, i2, i3, orientation, i4, i5, i6, null, null, CropImageView.DEFAULT_ASPECT_RATIO, 0, false, snapPosition, measureResult, false, emptyList, emptyList, coroutineScope, density, j);
    }
}
