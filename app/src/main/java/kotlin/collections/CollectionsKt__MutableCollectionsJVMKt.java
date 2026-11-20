package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CollectionsKt__MutableCollectionsJVMKt extends CollectionsKt__IteratorsKt {
    public static void sort(List list) {
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static void sortWith(List list, Comparator comparator) {
        list.getClass();
        comparator.getClass();
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
