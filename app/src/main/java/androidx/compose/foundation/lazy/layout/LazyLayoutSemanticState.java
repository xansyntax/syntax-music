package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.pager.PagerState$scrollToPage$2;
import androidx.compose.ui.semantics.CollectionInfo;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface LazyLayoutSemanticState {
    CollectionInfo collectionInfo();

    int getContentPadding();

    float getMaxScrollOffset();

    float getScrollOffset();

    int getViewport();

    Object scrollToItem(int i, PagerState$scrollToPage$2 pagerState$scrollToPage$2);
}
