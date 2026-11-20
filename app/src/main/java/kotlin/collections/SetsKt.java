package kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class SetsKt extends CharsKt {
    public static LinkedHashSet plus(Set set, Iterable iterable) {
        int size;
        set.getClass();
        iterable.getClass();
        Integer numValueOf = iterable instanceof Collection ? Integer.valueOf(((Collection) iterable).size()) : null;
        if (numValueOf != null) {
            size = set.size() + numValueOf.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(size));
        linkedHashSet.addAll(set);
        CollectionsKt__MutableCollectionsKt.addAll(iterable, linkedHashSet);
        return linkedHashSet;
    }

    public static Set setOf(Object... objArr) {
        return ArraysKt.toSet(objArr);
    }

    public static LinkedHashSet plus(Set set, Object obj) {
        set.getClass();
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(obj);
        return linkedHashSet;
    }
}
