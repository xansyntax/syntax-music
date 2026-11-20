package com.metrolist.music.ui.player;

import androidx.compose.foundation.lazy.grid.LazyGridMeasureResult;
import androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridState$prefetchScope$2$1;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ThumbnailKt$$ExternalSyntheticLambda3 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ LazyGridState f$0;

    public /* synthetic */ ThumbnailKt$$ExternalSyntheticLambda3(LazyGridState lazyGridState, byte b) {
        this.$r8$classId = b;
        this.f$0 = lazyGridState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int firstVisibleItemIndex;
        byte b = this.$r8$classId;
        LazyGridState lazyGridState = this.f$0;
        switch (b) {
            case 0:
                firstVisibleItemIndex = lazyGridState.getFirstVisibleItemIndex();
                break;
            case 1:
                firstVisibleItemIndex = ((LazyGridMeasureResult) lazyGridState.layoutInfoState.getValue()).stickingItemsCombinedSize;
                break;
            case 2:
                return new LazyGridState$prefetchScope$2$1(lazyGridState);
            case 3:
                firstVisibleItemIndex = lazyGridState.getFirstVisibleItemScrollOffset();
                break;
            default:
                List list = lazyGridState.getLayoutInfo().visibleItemsInfo;
                boolean z = false;
                if (!list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        if (((LazyGridMeasuredItem) it.next()).key.equals("loading")) {
                            z = true;
                        }
                    }
                }
                return Boolean.valueOf(z);
        }
        return Integer.valueOf(firstVisibleItemIndex);
    }
}
