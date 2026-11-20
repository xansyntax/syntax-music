package kotlin.collections;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableCollection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CollectionsKt__MutableCollectionsKt extends CollectionsKt__MutableCollectionsJVMKt {
    public static void addAll(Iterable iterable, Collection collection) {
        collection.getClass();
        iterable.getClass();
        if (iterable instanceof Collection) {
            collection.addAll((Collection) iterable);
            return;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
    }

    public static void removeAll(List list, Function1 function1) {
        int size;
        list.getClass();
        function1.getClass();
        if (!(list instanceof RandomAccess)) {
            if ((list instanceof KMappedMarker) && !(list instanceof KMutableCollection)) {
                TypeIntrinsics.throwCce(list, "kotlin.collections.MutableIterable");
                throw null;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((Boolean) function1.invoke(it.next())).booleanValue()) {
                    it.remove();
                }
            }
            return;
        }
        int size2 = list.size() - 1;
        int i = 0;
        if (size2 >= 0) {
            int i2 = 0;
            while (true) {
                Object obj = list.get(i);
                if (!((Boolean) function1.invoke(obj)).booleanValue()) {
                    if (i2 != i) {
                        list.set(i2, obj);
                    }
                    i2++;
                }
                if (i == size2) {
                    break;
                } else {
                    i++;
                }
            }
            i = i2;
        }
        if (i >= list.size() || i > (size = list.size() - 1)) {
            return;
        }
        while (true) {
            list.remove(size);
            if (size == i) {
                return;
            } else {
                size--;
            }
        }
    }

    public static Object removeFirst(ArrayList arrayList) {
        if (!arrayList.isEmpty()) {
            return arrayList.remove(0);
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1("List is empty.");
        return null;
    }

    public static Object removeLast(List list) {
        list.getClass();
        if (!list.isEmpty()) {
            return list.remove(list.size() - 1);
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1("List is empty.");
        return null;
    }

    public static Object removeLastOrNull(java.util.AbstractList abstractList) {
        abstractList.getClass();
        if (abstractList.isEmpty()) {
            return null;
        }
        return abstractList.remove(abstractList.size() - 1);
    }
}
