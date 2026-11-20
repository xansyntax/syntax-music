package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface CacheWindowScope {
    Density getDensity();

    int getFirstVisibleItemIndex();

    boolean getHasVisibleItems();

    int getLastItemIndex();

    int getLastVisibleItemIndex();

    int getMainAxisViewportSize();

    int getTotalItemsCount();

    int getVisibleItemIndex(int i);

    Object getVisibleItemKey(int i);

    int getVisibleItemSize(int i);

    int getVisibleItemsCount();

    int lastItemIndexInLine(int i);

    List schedulePrefetch(int i, Function1 function1);

    void updatePerLaneFirstVisibleItemIndex(int[] iArr);

    void updatePerLaneLastVisibleItemIndexes(int[] iArr);

    void updatePerLaneMainAxisExtraEndSpace(int[] iArr);

    void updatePerLaneMainAxisExtraStartSpace(int[] iArr);
}
