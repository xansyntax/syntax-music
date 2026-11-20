package androidx.navigationevent;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavigationEventHistory {
    public final int currentIndex;
    public final List mergedHistory;

    public NavigationEventHistory(int i, List list) {
        this.mergedHistory = list;
        this.currentIndex = i;
        if (list.isEmpty() && i == -1) {
            return;
        }
        if (!list.isEmpty()) {
            int size = list.size();
            if (i >= 0 && i < size) {
                return;
            }
        }
        PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(i, "Invalid 'NavigationEventHistory' state:  'currentIndex' must be within the bounds of 'mergedHistory' (or -1 if empty). Received: currentIndex = '", "', bounds = '"), CollectionsKt__IterablesKt.getIndices(list), "'.");
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NavigationEventHistory.class != obj.getClass()) {
            return false;
        }
        NavigationEventHistory navigationEventHistory = (NavigationEventHistory) obj;
        return this.currentIndex == navigationEventHistory.currentIndex && Intrinsics.areEqual(this.mergedHistory, navigationEventHistory.mergedHistory);
    }

    public final int hashCode() {
        return this.mergedHistory.hashCode() + (this.currentIndex * 31);
    }

    public final String toString() {
        return "NavigationEventHistory(currentIndex=" + this.currentIndex + ", mergedHistory=" + this.mergedHistory + ')';
    }

    public NavigationEventHistory() {
        this(-1, EmptyList.INSTANCE);
    }
}
