package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.LazyListMeasureResult;
import androidx.compose.foundation.lazy.LazyListMeasuredItem;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.grid.LazyGridMeasureResult;
import androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.sqlite.SQLite;
import coil3.util.FileSystemsKt;
import coil3.util.UtilsKt;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.math.MathKt;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PagerScrollScopeKt$LazyLayoutScrollScope$1 implements ScrollScope {
    public final /* synthetic */ ScrollScope $$delegate_0;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ScrollableState $state;

    public /* synthetic */ PagerScrollScopeKt$LazyLayoutScrollScope$1(ScrollScope scrollScope, ScrollableState scrollableState, byte b) {
        this.$r8$classId = b;
        this.$state = scrollableState;
        this.$$delegate_0 = scrollScope;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:59:? A[RETURN, SYNTHETIC] */
    public final int calculateDistanceTo(int i) {
        LazyListMeasuredItem lazyListMeasuredItem;
        Object obj;
        byte b = this.$r8$classId;
        Object obj2 = null;
        numValueOf = null;
        Integer numValueOf = null;
        ScrollableState scrollableState = this.$state;
        switch (b) {
            case 0:
                PagerState pagerState = (PagerState) scrollableState;
                return (int) (UuidKt.coerceIn(UtilsKt.currentAbsoluteScrollOffset(pagerState) + ((long) MathKt.roundToInt(((pagerState.getPageSizeWithSpacing$foundation() * (i - pagerState.getCurrentPage())) - (pagerState.getCurrentPageOffsetFraction() * pagerState.getPageSizeWithSpacing$foundation())) + CropImageView.DEFAULT_ASPECT_RATIO)), pagerState.minScrollOffset, pagerState.maxScrollOffset) - UtilsKt.currentAbsoluteScrollOffset(pagerState));
            case 1:
                LazyListState lazyListState = (LazyListState) scrollableState;
                LazyListMeasureResult layoutInfo = lazyListState.getLayoutInfo();
                if (layoutInfo.visibleItemsInfo.isEmpty()) {
                    return 0;
                }
                int firstVisibleItemIndex = lazyListState.getFirstVisibleItemIndex();
                if (i > getLastVisibleItemIndex() || firstVisibleItemIndex > i) {
                    return ((i - lazyListState.getFirstVisibleItemIndex()) * FileSystemsKt.visibleItemsAverageSize(layoutInfo)) - lazyListState.getFirstVisibleItemScrollOffset();
                }
                List list = layoutInfo.visibleItemsInfo;
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Object obj3 = list.get(i2);
                    if (((LazyListMeasuredItem) obj3).index == i) {
                        obj2 = obj3;
                        lazyListMeasuredItem = (LazyListMeasuredItem) obj2;
                        if (lazyListMeasuredItem != null) {
                            return lazyListMeasuredItem.offset;
                        }
                        return 0;
                    }
                }
                lazyListMeasuredItem = (LazyListMeasuredItem) obj2;
                if (lazyListMeasuredItem != null) {
                    return lazyListMeasuredItem.offset;
                }
                return 0;
            default:
                LazyGridState lazyGridState = (LazyGridState) scrollableState;
                LazyGridMeasureResult layoutInfo2 = lazyGridState.getLayoutInfo();
                if (layoutInfo2.visibleItemsInfo.isEmpty()) {
                    return 0;
                }
                int firstVisibleItemIndex2 = lazyGridState.getFirstVisibleItemIndex();
                if (i > getLastVisibleItemIndex() || firstVisibleItemIndex2 > i) {
                    int i3 = ((LazyGridMeasureResult) lazyGridState.layoutInfoState.getValue()).slotsPerLine;
                    return (((((i3 - 1) * (i < lazyGridState.getFirstVisibleItemIndex() ? -1 : 1)) + (i - lazyGridState.getFirstVisibleItemIndex())) / i3) * SQLite.visibleLinesAverageMainAxisSize(layoutInfo2)) - lazyGridState.getFirstVisibleItemScrollOffset();
                }
                List list2 = layoutInfo2.visibleItemsInfo;
                int size2 = list2.size();
                int i4 = 0;
                while (true) {
                    if (i4 < size2) {
                        obj = list2.get(i4);
                        if (((LazyGridMeasuredItem) obj).index != i) {
                            i4++;
                        }
                    } else {
                        obj = null;
                    }
                }
                LazyGridMeasuredItem lazyGridMeasuredItem = (LazyGridMeasuredItem) obj;
                if (layoutInfo2.orientation == Orientation.Vertical) {
                    if (lazyGridMeasuredItem != null) {
                        numValueOf = Integer.valueOf((int) (lazyGridMeasuredItem.offset & 4294967295L));
                    }
                } else if (lazyGridMeasuredItem != null) {
                    numValueOf = Integer.valueOf((int) (lazyGridMeasuredItem.offset >> 32));
                }
                if (numValueOf != null) {
                    return numValueOf.intValue();
                }
                return 0;
        }
    }

    public final int getFirstVisibleItemIndex() {
        byte b = this.$r8$classId;
        ScrollableState scrollableState = this.$state;
        switch (b) {
            case 0:
                return ((PagerState) scrollableState).firstVisiblePage;
            case 1:
                return ((LazyListState) scrollableState).getFirstVisibleItemIndex();
            default:
                return ((LazyGridState) scrollableState).getFirstVisibleItemIndex();
        }
    }

    public final int getFirstVisibleItemScrollOffset() {
        byte b = this.$r8$classId;
        ScrollableState scrollableState = this.$state;
        switch (b) {
            case 0:
                return ((PagerState) scrollableState).firstVisiblePageOffset;
            case 1:
                return ((LazyListState) scrollableState).getFirstVisibleItemScrollOffset();
            default:
                return ((LazyGridState) scrollableState).getFirstVisibleItemScrollOffset();
        }
    }

    public final int getLastVisibleItemIndex() {
        byte b = this.$r8$classId;
        ScrollableState scrollableState = this.$state;
        switch (b) {
            case 0:
                return ((MeasuredPage) CollectionsKt.last(((PagerState) scrollableState).getLayoutInfo().visiblePagesInfo)).index;
            case 1:
                LazyListMeasuredItem lazyListMeasuredItem = (LazyListMeasuredItem) CollectionsKt.lastOrNull(((LazyListState) scrollableState).getLayoutInfo().visibleItemsInfo);
                if (lazyListMeasuredItem != null) {
                    return lazyListMeasuredItem.index;
                }
                return 0;
            default:
                LazyGridMeasuredItem lazyGridMeasuredItem = (LazyGridMeasuredItem) CollectionsKt.lastOrNull(((LazyGridState) scrollableState).getLayoutInfo().visibleItemsInfo);
                if (lazyGridMeasuredItem != null) {
                    return lazyGridMeasuredItem.index;
                }
                return 0;
        }
    }

    @Override // androidx.compose.foundation.gestures.ScrollScope
    public final float scrollBy(float f) {
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.$$delegate_0.scrollBy(f);
    }

    public final void snapToItem(int i) {
        byte b = this.$r8$classId;
        ScrollableState scrollableState = this.$state;
        switch (b) {
            case 0:
                PagerState pagerState = (PagerState) scrollableState;
                float pageSizeWithSpacing$foundation = pagerState.getPageSizeWithSpacing$foundation();
                float f = CropImageView.DEFAULT_ASPECT_RATIO;
                if (pageSizeWithSpacing$foundation != CropImageView.DEFAULT_ASPECT_RATIO) {
                    f = CropImageView.DEFAULT_ASPECT_RATIO / pageSizeWithSpacing$foundation;
                }
                pagerState.snapToItem$foundation(i, f, true);
                break;
            case 1:
                ((LazyListState) scrollableState).snapToItemIndexInternal$foundation(i, true, 0);
                break;
            default:
                ((LazyGridState) scrollableState).snapToItemIndexInternal$foundation(i, true, 0);
                break;
        }
    }
}
