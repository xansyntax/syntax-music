package com.google.common.collect;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import coil3.util.UtilsKt;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates$AndPredicate;
import com.google.common.base.Splitter$$ExternalSyntheticLambda0;
import com.google.common.collect.RegularImmutableMultiset.ElementSet;
import io.ktor.http.ContentDisposition;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Maps {
    public final /* synthetic */ byte $r8$classId = 3;

    /* JADX INFO: renamed from: com.google.common.collect.Maps$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends TransformedIterator {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TransformedEntriesMap extends AbstractMap {
        public final Map fromMap;
        public final Splitter$$ExternalSyntheticLambda0 transformer;

        public TransformedEntriesMap(Map map, Splitter$$ExternalSyntheticLambda0 splitter$$ExternalSyntheticLambda0) {
            map.getClass();
            this.fromMap = map;
            this.transformer = splitter$$ExternalSyntheticLambda0;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final void clear() {
            this.fromMap.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object obj) {
            return this.fromMap.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Set entrySet() {
            return new Maps$IteratorBasedAbstractMap$1(this, (byte) 0);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object get(Object obj) {
            Map map = this.fromMap;
            Object obj2 = map.get(obj);
            if (obj2 != null || map.containsKey(obj)) {
                return this.transformer.transformEntry(obj, obj2);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Set keySet() {
            return this.fromMap.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object remove(Object obj) {
            Map map = this.fromMap;
            if (map.containsKey(obj)) {
                return this.transformer.transformEntry(obj, map.remove(obj));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final int size() {
            return this.fromMap.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Collection values() {
            return new Values(this);
        }
    }

    public static void checkElementsNotNull(int i, Object[] objArr) {
        for (int i2 = 0; i2 < i; i2++) {
            if (objArr[i2] == null) {
                PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(i2, "at index "));
                return;
            }
        }
    }

    public static void checkEntryNotNull(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj + "=null");
    }

    public static void checkNonnegative(int i, String str) {
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    public static Object createTable(int i) {
        if (i < 2 || i > 1073741824 || Integer.highestOneBit(i) != i) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i, "must be power of 2 between 2^1 and 2^30: "));
            return null;
        }
        if (i <= 256) {
            return new byte[i];
        }
        return i <= 65536 ? new short[i] : new int[i];
    }

    public static boolean equalsImpl(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            return set.size() == set2.size() && set.containsAll(set2);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static Sets$FilteredSet filter(Set set, Predicate predicate) {
        if (set instanceof SortedSet) {
            Collection collection = (SortedSet) set;
            if (!(collection instanceof Sets$FilteredSet)) {
                return new Sets$FilteredSortedSet(collection, predicate);
            }
            Sets$FilteredSet sets$FilteredSet = (Sets$FilteredSet) collection;
            return new Sets$FilteredSortedSet((SortedSet) sets$FilteredSet.unfiltered, new Predicates$AndPredicate(Arrays.asList(sets$FilteredSet.predicate, predicate)));
        }
        if (set instanceof Sets$FilteredSet) {
            Sets$FilteredSet sets$FilteredSet2 = (Sets$FilteredSet) set;
            return new Sets$FilteredSet((Set) sets$FilteredSet2.unfiltered, new Predicates$AndPredicate(Arrays.asList(sets$FilteredSet2.predicate, predicate)));
        }
        set.getClass();
        return new Sets$FilteredSet(set, predicate);
    }

    public static Object getLast(Iterable iterable) {
        Object next;
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (!list.isEmpty()) {
                return list.get(list.size() - 1);
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
            return null;
        }
        if (iterable instanceof SortedSet) {
            return ((SortedSet) iterable).last();
        }
        Iterator it = iterable.iterator();
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static int hashCodeImpl(Set set) {
        Iterator it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    public static Sets$2 intersection(Set set, ImmutableSet immutableSet) {
        UtilsKt.checkNotNull(set, "set1");
        UtilsKt.checkNotNull(immutableSet, "set2");
        return new Sets$2(set, immutableSet);
    }

    public static int maskCombine(int i, int i2, int i3) {
        return (i & (~i3)) | (i2 & i3);
    }

    public static ArrayList newArrayList(Iterator it) {
        ArrayList arrayList = new ArrayList();
        it.getClass();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static int newCapacity(int i) {
        return (i + 1) * (i < 32 ? 4 : 2);
    }

    public static int remove(Object obj, Object obj2, int i, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int iSmearedHash = smearedHash(obj);
        int i2 = iSmearedHash & i;
        int iTableGet = tableGet(i2, obj3);
        if (iTableGet != 0) {
            int i3 = ~i;
            int i4 = iSmearedHash & i3;
            int i5 = -1;
            while (true) {
                int i6 = iTableGet - 1;
                int i7 = iArr[i6];
                if ((i7 & i3) == i4 && Objects.equals(obj, objArr[i6]) && (objArr2 == null || Objects.equals(obj2, objArr2[i6]))) {
                    int i8 = i7 & i;
                    if (i5 == -1) {
                        tableSet(i2, i8, obj3);
                        return i6;
                    }
                    iArr[i5] = maskCombine(iArr[i5], i8, i);
                    return i6;
                }
                int i9 = i7 & i;
                if (i9 == 0) {
                    break;
                }
                i5 = i6;
                iTableGet = i9;
            }
        }
        return -1;
    }

    public static boolean removeAllImpl(Set set, Collection collection) {
        collection.getClass();
        if (collection instanceof ImmutableMultiset) {
            RegularImmutableMultiset regularImmutableMultiset = (RegularImmutableMultiset) ((ImmutableMultiset) collection);
            RegularImmutableMultiset.ElementSet elementSet = regularImmutableMultiset.elementSet;
            if (elementSet == null) {
                elementSet = regularImmutableMultiset.new ElementSet();
                regularImmutableMultiset.elementSet = elementSet;
            }
            collection = elementSet;
        }
        boolean zRemove = false;
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                zRemove |= set.remove(it.next());
            }
            return zRemove;
        }
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            if (collection.contains(it2.next())) {
                it2.remove();
                zRemove = true;
            }
        }
        return zRemove;
    }

    public static void slowRemoveIfForRemainingElements(List list, Predicate predicate, int i, int i2) {
        for (int size = list.size() - 1; size > i2; size--) {
            if (predicate.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            list.remove(i3);
        }
    }

    public static int smear(int i) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i) * (-862048943)), 15)) * 461845907);
    }

    public static int smearedHash(Object obj) {
        return smear(obj == null ? 0 : obj.hashCode());
    }

    public static int tableGet(int i, Object obj) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i] & 255;
        }
        return obj instanceof short[] ? ((short[]) obj)[i] & 65535 : ((int[]) obj)[i];
    }

    public static void tableSet(int i, int i2, Object obj) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = (byte) i2;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i] = (short) i2;
        } else {
            ((int[]) obj)[i] = i2;
        }
    }

    public static String toStringImpl(Map map) {
        int size = map.size();
        checkNonnegative(size, ContentDisposition.Parameters.Size);
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824L));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : map.entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }

    public static AbstractList transform(Function function, List list) {
        return list instanceof RandomAccess ? new Lists$TransformingRandomAccessList(function, list) : new Lists$TransformingSequentialList(function, list);
    }

    public static void writeMultimap(AbstractMultimap abstractMultimap, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(abstractMultimap.asMap().size());
        for (Map.Entry entry : abstractMultimap.asMap().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(((Collection) entry.getValue()).size());
            Iterator it = ((Collection) entry.getValue()).iterator();
            while (it.hasNext()) {
                objectOutputStream.writeObject(it.next());
            }
        }
    }

    public abstract Object delegate();

    public String toString() {
        switch (this.$r8$classId) {
            case 3:
                return delegate().toString();
            default:
                return super.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public class Values extends AbstractCollection {
        public final /* synthetic */ byte $r8$classId;
        public final Object map;

        public Values(AbstractMap abstractMap) {
            this.$r8$classId = (byte) 0;
            this.map = abstractMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            byte b = this.$r8$classId;
            Object obj = this.map;
            switch (b) {
                case 0:
                    ((AbstractMap) obj).clear();
                    break;
                case 1:
                    ((AbstractMultimap) obj).clear();
                    break;
                case 2:
                    ((AbstractMapBasedMultimap) obj).clear();
                    break;
                default:
                    ((CompactHashMap) obj).clear();
                    break;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            byte b = this.$r8$classId;
            Object obj2 = this.map;
            switch (b) {
                case 0:
                    return ((AbstractMap) obj2).containsValue(obj);
                case 1:
                    if (!(obj instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    Collection collection = (Collection) ((AbstractMultimap) obj2).asMap().get(key);
                    return collection != null && collection.contains(value);
                case 2:
                    return ((AbstractMapBasedMultimap) obj2).containsValue(obj);
                default:
                    return super.contains(obj);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            switch (this.$r8$classId) {
                case 0:
                    return ((AbstractMap) this.map).isEmpty();
                default:
                    return super.isEmpty();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            byte b = this.$r8$classId;
            Object obj = this.map;
            switch (b) {
                case 0:
                    return new AnonymousClass2(((AbstractMap) obj).entrySet().iterator());
                case 1:
                    return ((AbstractMultimap) obj).entryIterator();
                case 2:
                    return new AbstractMapBasedMultimap.AnonymousClass1((AbstractMapBasedMultimap) obj, (byte) 0);
                default:
                    CompactHashMap compactHashMap = (CompactHashMap) obj;
                    Map mapDelegateOrNull = compactHashMap.delegateOrNull();
                    return mapDelegateOrNull != null ? mapDelegateOrNull.values().iterator() : new CompactHashMap.AnonymousClass1(compactHashMap, (byte) 2);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            byte b = this.$r8$classId;
            Object obj2 = this.map;
            switch (b) {
                case 0:
                    AbstractMap abstractMap = (AbstractMap) obj2;
                    try {
                        return super.remove(obj);
                    } catch (UnsupportedOperationException unused) {
                        for (Map.Entry entry : abstractMap.entrySet()) {
                            if (Objects.equals(obj, entry.getValue())) {
                                abstractMap.remove(entry.getKey());
                                return true;
                            }
                        }
                        return false;
                    }
                case 1:
                    if (!(obj instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry entry2 = (Map.Entry) obj;
                    return ((AbstractMultimap) obj2).remove(entry2.getKey(), entry2.getValue());
                default:
                    return super.remove(obj);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            switch (this.$r8$classId) {
                case 0:
                    AbstractMap abstractMap = (AbstractMap) this.map;
                    try {
                        collection.getClass();
                        return super.removeAll(collection);
                    } catch (UnsupportedOperationException unused) {
                        HashSet hashSet = new HashSet();
                        for (Map.Entry entry : abstractMap.entrySet()) {
                            if (collection.contains(entry.getValue())) {
                                hashSet.add(entry.getKey());
                            }
                        }
                        return abstractMap.keySet().removeAll(hashSet);
                    }
                default:
                    return super.removeAll(collection);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            switch (this.$r8$classId) {
                case 0:
                    AbstractMap abstractMap = (AbstractMap) this.map;
                    try {
                        collection.getClass();
                        return super.retainAll(collection);
                    } catch (UnsupportedOperationException unused) {
                        HashSet hashSet = new HashSet();
                        for (Map.Entry entry : abstractMap.entrySet()) {
                            if (collection.contains(entry.getValue())) {
                                hashSet.add(entry.getKey());
                            }
                        }
                        return abstractMap.keySet().retainAll(hashSet);
                    }
                default:
                    return super.retainAll(collection);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            byte b = this.$r8$classId;
            Object obj = this.map;
            switch (b) {
                case 0:
                    return ((AbstractMap) obj).size();
                case 1:
                    return ((AbstractMultimap) obj).size();
                case 2:
                    return ((AbstractMapBasedMultimap) obj).totalSize;
                default:
                    return ((CompactHashMap) obj).size();
            }
        }

        public /* synthetic */ Values(byte b, Object obj) {
            this.$r8$classId = b;
            this.map = obj;
        }
    }

    public static boolean equalsImpl(Map map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }
}
