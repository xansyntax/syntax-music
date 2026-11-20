package kotlin.collections;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda36;
import dagger.hilt.EntryPoints;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Pair;
import kotlin.io.LinesSequence;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.AbstractPlatformRandom;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
public abstract class CollectionsKt extends CollectionsKt__MutableCollectionsKt {
    public static LinesSequence asSequence(Iterable iterable) {
        iterable.getClass();
        return new LinesSequence((byte) 2, iterable);
    }

    public static ArrayList chunked(int i, Collection collection) {
        collection.getClass();
        if (i <= 0 || i <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "size ", " must be greater than zero."));
            return null;
        }
        if (!(collection instanceof RandomAccess) || !(collection instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = collection.iterator();
            it.getClass();
            Iterator it2 = !it.hasNext() ? EmptyIterator.INSTANCE : EntryPoints.iterator(new SlidingWindowKt$windowedIterator$1(i, i, it, null));
            while (it2.hasNext()) {
                arrayList.add((List) it2.next());
            }
            return arrayList;
        }
        List list = (List) collection;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i) + (size % i == 0 ? 0 : 1));
        int i2 = 0;
        while (i2 >= 0 && i2 < size) {
            int i3 = size - i2;
            if (i <= i3) {
                i3 = i;
            }
            ArrayList arrayList3 = new ArrayList(i3);
            for (int i4 = 0; i4 < i3; i4++) {
                arrayList3.add(list.get(i4 + i2));
            }
            arrayList2.add(arrayList3);
            i2 += i;
        }
        return arrayList2;
    }

    public static boolean contains(Iterable iterable, Object obj) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        return indexOf(iterable, obj) >= 0;
    }

    public static List distinct(Iterable iterable) {
        iterable.getClass();
        return toList(toMutableSet(iterable));
    }

    public static List drop(Iterable iterable, int i) {
        ArrayList arrayList;
        Object objLast;
        iterable.getClass();
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "Requested element count ", " is less than zero."));
            return null;
        }
        if (i == 0) {
            return toList(iterable);
        }
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size() - i;
            if (size <= 0) {
                return EmptyList.INSTANCE;
            }
            if (size == 1) {
                if (iterable instanceof List) {
                    objLast = last((List) iterable);
                } else {
                    Iterator it = iterable.iterator();
                    if (!it.hasNext()) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1("Collection is empty.");
                        return null;
                    }
                    Object next = it.next();
                    while (it.hasNext()) {
                        next = it.next();
                    }
                    objLast = next;
                }
                return CollectionsKt__IterablesKt.listOf(objLast);
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    List list = (List) iterable;
                    int size2 = list.size();
                    while (i < size2) {
                        arrayList.add(list.get(i));
                        i++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i2 = 0;
        for (Object obj : iterable) {
            if (i2 >= i) {
                arrayList.add(obj);
            } else {
                i2++;
            }
        }
        return CollectionsKt__IterablesKt.optimizeReadOnlyList(arrayList);
    }

    public static List dropLast(int i, List list) {
        list.getClass();
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "Requested element count ", " is less than zero."));
            return null;
        }
        int size = list.size() - i;
        if (size < 0) {
            size = 0;
        }
        return take(list, size);
    }

    public static ArrayList filterNotNull(Iterable iterable) {
        iterable.getClass();
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Object first(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof List) {
            return first((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1("Collection is empty.");
        return null;
    }

    public static Object firstOrNull(Iterable iterable) {
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static Object getOrNull(int i, List list) {
        list.getClass();
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public static int indexOf(Iterable iterable, Object obj) {
        iterable.getClass();
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(obj);
        }
        int i = 0;
        for (Object obj2 : iterable) {
            if (i < 0) {
                CollectionsKt__IterablesKt.throwIndexOverflow();
                throw null;
            }
            if (Intrinsics.areEqual(obj, obj2)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final void joinTo(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, Function1 function1) throws IOException {
        iterable.getClass();
        charSequence.getClass();
        appendable.append(charSequence2);
        int i = 0;
        for (Object obj : iterable) {
            i++;
            if (i > 1) {
                appendable.append(charSequence);
            }
            StringsKt__IndentKt.appendElement(appendable, obj, function1);
        }
        appendable.append(charSequence3);
    }

    public static /* synthetic */ void joinTo$default(List list, Appendable appendable, String str, Function1 function1, int i) throws IOException {
        if ((i & 2) != 0) {
            str = ", ";
        }
        String str2 = str;
        if ((i & 64) != 0) {
            function1 = null;
        }
        joinTo(list, appendable, str2, "", "", "...", function1);
    }

    public static String joinToString$default(Iterable iterable, CharSequence charSequence, String str, String str2, Function1 function1, int i) throws IOException {
        if ((i & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence2 = charSequence;
        String str3 = (i & 2) != 0 ? "" : str;
        String str4 = (i & 4) != 0 ? "" : str2;
        if ((i & 32) != 0) {
            function1 = null;
        }
        iterable.getClass();
        charSequence2.getClass();
        str3.getClass();
        StringBuilder sb = new StringBuilder();
        joinTo(iterable, sb, charSequence2, str3, str4, "...", function1);
        return sb.toString();
    }

    public static Object last(List list) {
        list.getClass();
        if (!list.isEmpty()) {
            return list.get(list.size() - 1);
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1("List is empty.");
        return null;
    }

    public static Object lastOrNull(List list) {
        list.getClass();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static Comparable maxOrNull(Iterable iterable) {
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) < 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static Object maxWithOrNull(List list, Comparator comparator) {
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object next = it.next();
        while (it.hasNext()) {
            Object next2 = it.next();
            if (comparator.compare(next, next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    public static ArrayList minus(List list, Object obj) {
        list.getClass();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        boolean z = false;
        for (Object obj2 : list) {
            boolean z2 = true;
            if (!z && Intrinsics.areEqual(obj2, obj)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }

    public static ArrayList plus(Iterable iterable, Collection collection) {
        collection.getClass();
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            CollectionsKt__MutableCollectionsKt.addAll(iterable, arrayList);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection2.size() + collection.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static Object random(Collection collection) {
        AbstractPlatformRandom abstractPlatformRandom = Random.defaultRandom;
        collection.getClass();
        if (collection.isEmpty()) {
            PathKt$$ExternalSyntheticBUOutline0.m$1("Collection is empty.");
            return null;
        }
        Collection collection2 = collection;
        int iNextInt = Random.defaultRandom.nextInt(collection.size());
        boolean z = collection2 instanceof List;
        if (z) {
            return ((List) collection2).get(iNextInt);
        }
        TimePickerKt$$ExternalSyntheticLambda36 timePickerKt$$ExternalSyntheticLambda36 = new TimePickerKt$$ExternalSyntheticLambda36((byte) 9, iNextInt);
        if (z) {
            List list = (List) collection2;
            if (iNextInt >= 0 && iNextInt < list.size()) {
                return list.get(iNextInt);
            }
            timePickerKt$$ExternalSyntheticLambda36.invoke(Integer.valueOf(iNextInt));
            throw null;
        }
        if (iNextInt < 0) {
            timePickerKt$$ExternalSyntheticLambda36.invoke(Integer.valueOf(iNextInt));
            throw null;
        }
        int i = 0;
        for (Object obj : collection2) {
            int i2 = i + 1;
            if (iNextInt == i) {
                return obj;
            }
            i = i2;
        }
        timePickerKt$$ExternalSyntheticLambda36.invoke(Integer.valueOf(iNextInt));
        throw null;
    }

    public static final int reverseElementIndex$CollectionsKt__ReversedViewsKt(int i, List list) {
        if (i >= 0 && i <= list.size() - 1) {
            return (list.size() - 1) - i;
        }
        StringBuilder sbM2m = IntIntPair$$ExternalSyntheticOutline0.m2m(i, "Element index ", " must be in range [");
        sbM2m.append(new IntRange(0, list.size() - 1, 1));
        sbM2m.append("].");
        throw new IndexOutOfBoundsException(sbM2m.toString());
    }

    public static final int reversePositionIndex$CollectionsKt__ReversedViewsKt(int i, List list) {
        if (i >= 0 && i <= list.size()) {
            return list.size() - i;
        }
        StringBuilder sbM2m = IntIntPair$$ExternalSyntheticOutline0.m2m(i, "Position index ", " must be in range [");
        sbM2m.append(new IntRange(0, list.size(), 1));
        sbM2m.append("].");
        throw new IndexOutOfBoundsException(sbM2m.toString());
    }

    public static List reversed(Iterable iterable) {
        iterable.getClass();
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return toList(iterable);
        }
        List mutableList = toMutableList(iterable);
        Collections.reverse(mutableList);
        return mutableList;
    }

    public static Object single(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof List) {
            return single((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            PathKt$$ExternalSyntheticBUOutline0.m$1("Collection is empty.");
            return null;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Collection has more than one element.");
        return null;
    }

    public static Object singleOrNull(List list) {
        list.getClass();
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static List sorted(Iterable iterable) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            List mutableList = toMutableList(iterable);
            CollectionsKt__MutableCollectionsJVMKt.sort(mutableList);
            return mutableList;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return toList(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        Comparable[] comparableArr = (Comparable[]) array;
        comparableArr.getClass();
        if (comparableArr.length > 1) {
            Arrays.sort(comparableArr);
        }
        return ArraysKt.asList(array);
    }

    public static List sortedWith(Iterable iterable, Comparator comparator) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            List mutableList = toMutableList(iterable);
            CollectionsKt__MutableCollectionsJVMKt.sortWith(mutableList, comparator);
            return mutableList;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return toList(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        array.getClass();
        if (array.length > 1) {
            Arrays.sort(array, comparator);
        }
        List listAsList = Arrays.asList(array);
        listAsList.getClass();
        return listAsList;
    }

    public static List take(Iterable iterable, int i) {
        iterable.getClass();
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "Requested element count ", " is less than zero."));
            return null;
        }
        if (i == 0) {
            return EmptyList.INSTANCE;
        }
        if (iterable instanceof Collection) {
            if (i >= ((Collection) iterable).size()) {
                return toList(iterable);
            }
            if (i == 1) {
                return CollectionsKt__IterablesKt.listOf(first(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i);
        Iterator it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return CollectionsKt__IterablesKt.optimizeReadOnlyList(arrayList);
    }

    public static List takeLast(int i, List list) {
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "Requested element count ", " is less than zero."));
            return null;
        }
        if (i == 0) {
            return EmptyList.INSTANCE;
        }
        int size = list.size();
        if (i >= size) {
            return toList(list);
        }
        if (i == 1) {
            return CollectionsKt__IterablesKt.listOf(last(list));
        }
        ArrayList arrayList = new ArrayList(i);
        if (list instanceof RandomAccess) {
            for (int i2 = size - i; i2 < size; i2++) {
                arrayList.add(list.get(i2));
            }
        } else {
            ListIterator listIterator = list.listIterator(size - i);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    public static byte[] toByteArray(ArrayList arrayList) {
        byte[] bArr = new byte[arrayList.size()];
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            bArr[i] = ((Number) obj).byteValue();
            i++;
        }
        return bArr;
    }

    public static final void toCollection(Iterable iterable, java.util.AbstractCollection abstractCollection) {
        iterable.getClass();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static float[] toFloatArray(Collection collection) {
        collection.getClass();
        float[] fArr = new float[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            fArr[i] = ((Number) it.next()).floatValue();
            i++;
        }
        return fArr;
    }

    public static int[] toIntArray(List list) {
        list.getClass();
        int[] iArr = new int[list.size()];
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((Number) it.next()).intValue();
            i++;
        }
        return iArr;
    }

    public static List toList(Iterable iterable) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            return CollectionsKt__IterablesKt.optimizeReadOnlyList(toMutableList(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return EmptyList.INSTANCE;
        }
        if (size != 1) {
            return new ArrayList(collection);
        }
        return CollectionsKt__IterablesKt.listOf(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static final List toMutableList(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return new ArrayList((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        toCollection(iterable, arrayList);
        return arrayList;
    }

    public static Set toMutableSet(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        toCollection(iterable, linkedHashSet);
        return linkedHashSet;
    }

    public static Set toSet(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size == 1) {
                    return CharsKt.setOf(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(collection.size()));
                toCollection(iterable, linkedHashSet);
                return linkedHashSet;
            }
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            toCollection(iterable, linkedHashSet2);
            int size2 = linkedHashSet2.size();
            if (size2 != 0) {
                return size2 != 1 ? linkedHashSet2 : CharsKt.setOf(linkedHashSet2.iterator().next());
            }
        }
        return EmptySet.INSTANCE;
    }

    public static ArrayList zip(List list, List list2) {
        Iterator it = list.iterator();
        Iterator it2 = list2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10), CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(new Pair(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static ArrayList toMutableList(Collection collection) {
        collection.getClass();
        return new ArrayList(collection);
    }

    public static Object first(List list) {
        list.getClass();
        if (!list.isEmpty()) {
            return list.get(0);
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1("List is empty.");
        return null;
    }

    public static Object firstOrNull(List list) {
        list.getClass();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static ArrayList plus(Object obj, Collection collection) {
        collection.getClass();
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static Object single(List list) {
        int size = list.size();
        if (size == 0) {
            PathKt$$ExternalSyntheticBUOutline0.m$1("List is empty.");
            return null;
        }
        if (size == 1) {
            return list.get(0);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("List has more than one element.");
        return null;
    }
}
