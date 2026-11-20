package androidx.compose.foundation.lazy;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LazyListKt$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ LazyListState f$0;

    public /* synthetic */ LazyListKt$$ExternalSyntheticLambda0(LazyListState lazyListState, byte b) {
        this.$r8$classId = b;
        this.f$0 = lazyListState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        boolean z = true;
        LazyListState lazyListState = this.f$0;
        switch (b) {
            case 0:
                return Integer.valueOf(((LazyListMeasureResult) lazyListState.layoutInfoState.getValue()).stickingItemsCombinedSize);
            case 1:
                return Integer.valueOf(lazyListState.getLayoutInfo().totalItemsCount);
            case 2:
                return Boolean.valueOf(lazyListState.scrollableState.isScrollInProgress());
            case 3:
                LazyListMeasuredItem lazyListMeasuredItem = (LazyListMeasuredItem) CollectionsKt.lastOrNull(lazyListState.getLayoutInfo().visibleItemsInfo);
                if (lazyListMeasuredItem != null) {
                    return Integer.valueOf(lazyListMeasuredItem.index);
                }
                return null;
            case 4:
                List list = lazyListState.getLayoutInfo().visibleItemsInfo;
                if (list.isEmpty()) {
                    z = false;
                } else {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        if (((LazyListMeasuredItem) it.next()).key.equals("loading")) {
                        }
                    }
                    z = false;
                }
                return Boolean.valueOf(z);
            case 5:
                return Boolean.valueOf(lazyListState.getFirstVisibleItemIndex() == 0 && lazyListState.getFirstVisibleItemScrollOffset() < 100);
            case 6:
                return Boolean.valueOf(lazyListState.getFirstVisibleItemIndex() > 0);
            case 7:
                return Integer.valueOf(lazyListState.getFirstVisibleItemScrollOffset());
            case 8:
                List list2 = lazyListState.getLayoutInfo().visibleItemsInfo;
                if (list2.isEmpty()) {
                    z = false;
                } else {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (((LazyListMeasuredItem) it2.next()).key.equals("loading")) {
                        }
                    }
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                return Integer.valueOf(lazyListState.getFirstVisibleItemScrollOffset());
        }
    }
}
