package androidx.collection;

import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.datastore.preferences.protobuf.SmallSortedMap$1;
import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ArrayMap extends SimpleArrayMap implements Map {
    public EntrySet mEntrySet;
    public KeySet mKeySet;
    public ValueCollection mValues;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public class EntrySet extends AbstractSet {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Map this$0;

        public /* synthetic */ EntrySet(Map map, byte b) {
            this.$r8$classId = b;
            this.this$0 = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Object obj) {
            switch (this.$r8$classId) {
                case 1:
                    Map.Entry entry = (Map.Entry) obj;
                    if (contains(entry)) {
                        return false;
                    }
                    ((SmallSortedMap$1) this.this$0).put((Comparable) entry.getKey(), entry.getValue());
                    return true;
                default:
                    return super.add(obj);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            switch (this.$r8$classId) {
                case 1:
                    ((SmallSortedMap$1) this.this$0).clear();
                    break;
                default:
                    super.clear();
                    break;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            switch (this.$r8$classId) {
                case 1:
                    Map.Entry entry = (Map.Entry) obj;
                    Object obj2 = ((SmallSortedMap$1) this.this$0).get(entry.getKey());
                    Object value = entry.getValue();
                    return obj2 == value || (obj2 != null && obj2.equals(value));
                default:
                    return super.contains(obj);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            byte b = this.$r8$classId;
            Map map = this.this$0;
            switch (b) {
                case 0:
                    return ((ArrayMap) map).new MapIterator();
                default:
                    final SmallSortedMap$1 smallSortedMap$1 = (SmallSortedMap$1) map;
                    return new Iterator() { // from class: androidx.datastore.preferences.protobuf.SmallSortedMap$EntryIterator
                        public Iterator lazyOverflowIterator;
                        public boolean nextCalledBeforeRemove;
                        public int pos = -1;

                        public final Iterator getOverflowIterator() {
                            Iterator it = this.lazyOverflowIterator;
                            if (it != null) {
                                return it;
                            }
                            Iterator it2 = smallSortedMap$1.overflowEntries.entrySet().iterator();
                            this.lazyOverflowIterator = it2;
                            return it2;
                        }

                        @Override // java.util.Iterator
                        public final boolean hasNext() {
                            int i = this.pos + 1;
                            SmallSortedMap$1 smallSortedMap$2 = smallSortedMap$1;
                            return i < smallSortedMap$2.entryList.size() || (!smallSortedMap$2.overflowEntries.isEmpty() && getOverflowIterator().hasNext());
                        }

                        @Override // java.util.Iterator
                        public final Object next() {
                            this.nextCalledBeforeRemove = true;
                            int i = this.pos + 1;
                            this.pos = i;
                            SmallSortedMap$1 smallSortedMap$2 = smallSortedMap$1;
                            return i < smallSortedMap$2.entryList.size() ? (Map.Entry) smallSortedMap$2.entryList.get(this.pos) : (Map.Entry) getOverflowIterator().next();
                        }

                        @Override // java.util.Iterator
                        public final void remove() {
                            if (!this.nextCalledBeforeRemove) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("remove() was called before next()");
                                return;
                            }
                            this.nextCalledBeforeRemove = false;
                            int i = SmallSortedMap$1.$r8$clinit;
                            SmallSortedMap$1 smallSortedMap$2 = smallSortedMap$1;
                            smallSortedMap$2.checkMutable();
                            if (this.pos >= smallSortedMap$2.entryList.size()) {
                                getOverflowIterator().remove();
                                return;
                            }
                            int i2 = this.pos;
                            this.pos = i2 - 1;
                            smallSortedMap$2.removeArrayEntryAt(i2);
                        }
                    };
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            switch (this.$r8$classId) {
                case 1:
                    Map.Entry entry = (Map.Entry) obj;
                    if (!contains(entry)) {
                        return false;
                    }
                    ((SmallSortedMap$1) this.this$0).remove(entry.getKey());
                    return true;
                default:
                    return super.remove(obj);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            byte b = this.$r8$classId;
            Map map = this.this$0;
            switch (b) {
                case 0:
                    return ((ArrayMap) map).size;
                default:
                    return ((SmallSortedMap$1) map).size();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MapIterator implements Iterator, Map.Entry {
        public int mEnd;
        public boolean mEntryValid;
        public int mIndex = -1;

        public MapIterator() {
            this.mEnd = ArrayMap.this.size - 1;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!this.mEntryValid) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This container does not support retaining Map.Entry objects");
                return false;
            }
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                int i = this.mIndex;
                ArrayMap arrayMap = ArrayMap.this;
                if (Intrinsics.areEqual(key, arrayMap.keyAt(i)) && Intrinsics.areEqual(entry.getValue(), arrayMap.valueAt(this.mIndex))) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            if (this.mEntryValid) {
                return ArrayMap.this.keyAt(this.mIndex);
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This container does not support retaining Map.Entry objects");
            return null;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            if (this.mEntryValid) {
                return ArrayMap.this.valueAt(this.mIndex);
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This container does not support retaining Map.Entry objects");
            return null;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.mIndex < this.mEnd;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            if (!this.mEntryValid) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This container does not support retaining Map.Entry objects");
                return 0;
            }
            int i = this.mIndex;
            ArrayMap arrayMap = ArrayMap.this;
            Object objKeyAt = arrayMap.keyAt(i);
            Object objValueAt = arrayMap.valueAt(this.mIndex);
            return (objKeyAt == null ? 0 : objKeyAt.hashCode()) ^ (objValueAt != null ? objValueAt.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (!hasNext()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                return null;
            }
            this.mIndex++;
            this.mEntryValid = true;
            return this;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (!this.mEntryValid) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                return;
            }
            ArrayMap.this.removeAt(this.mIndex);
            this.mIndex--;
            this.mEnd--;
            this.mEntryValid = false;
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            if (this.mEntryValid) {
                return ArrayMap.this.setValueAt(this.mIndex, obj);
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This container does not support retaining Map.Entry objects");
            return null;
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!super.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        EntrySet entrySet = this.mEntrySet;
        if (entrySet != null) {
            return entrySet;
        }
        EntrySet entrySet2 = new EntrySet(this, (byte) 0);
        this.mEntrySet = entrySet2;
        return entrySet2;
    }

    @Override // java.util.Map
    public final Set keySet() {
        KeySet keySet = this.mKeySet;
        if (keySet != null) {
            return keySet;
        }
        KeySet keySet2 = new KeySet();
        this.mKeySet = keySet2;
        return keySet2;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        int size = map.size() + this.size;
        int i = this.size;
        int[] iArr = this.hashes;
        if (iArr.length < size) {
            this.hashes = Arrays.copyOf(iArr, size);
            this.array = Arrays.copyOf(this.array, size * 2);
        }
        if (this.size != i) {
            MarqueeSpacing$Companion$$ExternalSyntheticLambda0.m52m();
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public final boolean removeAll(Collection collection) {
        int i = this.size;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            super.remove(it.next());
        }
        return i != this.size;
    }

    public final boolean retainAll(Collection collection) {
        int i = this.size;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (!collection.contains(keyAt(i2))) {
                removeAt(i2);
            }
        }
        return i != this.size;
    }

    @Override // java.util.Map
    public final Collection values() {
        ValueCollection valueCollection = this.mValues;
        if (valueCollection != null) {
            return valueCollection;
        }
        ValueCollection valueCollection2 = new ValueCollection();
        this.mValues = valueCollection2;
        return valueCollection2;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class KeyIterator implements Iterator, KMappedMarker {
        public final /* synthetic */ byte $r8$classId;
        public boolean canRemove;
        public int index;
        public int size;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public KeyIterator(ArrayMap arrayMap, byte b) {
            this(arrayMap.size);
            this.$r8$classId = b;
            switch (b) {
                case 1:
                    this.this$0 = arrayMap;
                    this(arrayMap.size);
                    break;
                default:
                    this.this$0 = arrayMap;
                    break;
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.index < this.size;
        }

        @Override // java.util.Iterator
        public final Object next() {
            Object objKeyAt;
            if (!hasNext()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                return null;
            }
            int i = this.index;
            byte b = this.$r8$classId;
            Object obj = this.this$0;
            switch (b) {
                case 0:
                    objKeyAt = ((ArrayMap) obj).keyAt(i);
                    break;
                case 1:
                    objKeyAt = ((ArrayMap) obj).valueAt(i);
                    break;
                default:
                    objKeyAt = ((ArraySet) obj).array[i];
                    break;
            }
            this.index++;
            this.canRemove = true;
            return objKeyAt;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (!this.canRemove) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Call next() before removing an element.");
                return;
            }
            int i = this.index - 1;
            this.index = i;
            byte b = this.$r8$classId;
            Object obj = this.this$0;
            switch (b) {
                case 0:
                    ((ArrayMap) obj).removeAt(i);
                    break;
                case 1:
                    ((ArrayMap) obj).removeAt(i);
                    break;
                default:
                    ((ArraySet) obj).removeAt(i);
                    break;
            }
            this.size--;
            this.canRemove = false;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public KeyIterator(ArraySet arraySet) {
            this(arraySet._size);
            this.$r8$classId = (byte) 2;
            this.this$0 = arraySet;
        }

        public KeyIterator(int i) {
            this.size = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class KeySet implements Set {
        public KeySet() {
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final void clear() {
            ArrayMap.this.clear();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean contains(Object obj) {
            return ArrayMap.this.containsKey(obj);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean containsAll(Collection collection) {
            return ArrayMap.this.containsAll(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean equals(Object obj) {
            ArrayMap arrayMap = ArrayMap.this;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Set)) {
                return false;
            }
            Set set = (Set) obj;
            try {
                return arrayMap.size == set.size() && arrayMap.containsAll(set);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // java.util.Set, java.util.Collection
        public final int hashCode() {
            ArrayMap arrayMap = ArrayMap.this;
            int iHashCode = 0;
            for (int i = arrayMap.size - 1; i >= 0; i--) {
                Object objKeyAt = arrayMap.keyAt(i);
                iHashCode += objKeyAt == null ? 0 : objKeyAt.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean isEmpty() {
            return ArrayMap.this.isEmpty();
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            return new KeyIterator(ArrayMap.this, (byte) 0);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean remove(Object obj) {
            ArrayMap arrayMap = ArrayMap.this;
            int iIndexOfKey = arrayMap.indexOfKey(obj);
            if (iIndexOfKey < 0) {
                return false;
            }
            arrayMap.removeAt(iIndexOfKey);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean removeAll(Collection collection) {
            return ArrayMap.this.removeAll(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean retainAll(Collection collection) {
            return ArrayMap.this.retainAll(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public final int size() {
            return ArrayMap.this.size;
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray(Object[] objArr) {
            ArrayMap arrayMap = ArrayMap.this;
            int i = arrayMap.size;
            if (objArr.length < i) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
            }
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = arrayMap.keyAt(i2);
            }
            if (objArr.length > i) {
                objArr[i] = null;
            }
            return objArr;
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray() {
            ArrayMap arrayMap = ArrayMap.this;
            int i = arrayMap.size;
            Object[] objArr = new Object[i];
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = arrayMap.keyAt(i2);
            }
            return objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ValueCollection implements Collection {
        public ValueCollection() {
        }

        @Override // java.util.Collection
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final void clear() {
            ArrayMap.this.clear();
        }

        @Override // java.util.Collection
        public final boolean contains(Object obj) {
            return ArrayMap.this.__restricted$indexOfValue(obj) >= 0;
        }

        @Override // java.util.Collection
        public final boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            return ArrayMap.this.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            return new KeyIterator(ArrayMap.this, (byte) 1);
        }

        @Override // java.util.Collection
        public final boolean remove(Object obj) {
            ArrayMap arrayMap = ArrayMap.this;
            int i__restricted$indexOfValue = arrayMap.__restricted$indexOfValue(obj);
            if (i__restricted$indexOfValue < 0) {
                return false;
            }
            arrayMap.removeAt(i__restricted$indexOfValue);
            return true;
        }

        @Override // java.util.Collection
        public final boolean removeAll(Collection collection) {
            ArrayMap arrayMap = ArrayMap.this;
            int i = arrayMap.size;
            int i2 = 0;
            boolean z = false;
            while (i2 < i) {
                if (collection.contains(arrayMap.valueAt(i2))) {
                    arrayMap.removeAt(i2);
                    i2--;
                    i--;
                    z = true;
                }
                i2++;
            }
            return z;
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection collection) {
            ArrayMap arrayMap = ArrayMap.this;
            int i = arrayMap.size;
            int i2 = 0;
            boolean z = false;
            while (i2 < i) {
                if (!collection.contains(arrayMap.valueAt(i2))) {
                    arrayMap.removeAt(i2);
                    i2--;
                    i--;
                    z = true;
                }
                i2++;
            }
            return z;
        }

        @Override // java.util.Collection
        public final int size() {
            return ArrayMap.this.size;
        }

        @Override // java.util.Collection
        public final Object[] toArray(Object[] objArr) {
            ArrayMap arrayMap = ArrayMap.this;
            int i = arrayMap.size;
            if (objArr.length < i) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
            }
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = arrayMap.valueAt(i2);
            }
            if (objArr.length > i) {
                objArr[i] = null;
            }
            return objArr;
        }

        @Override // java.util.Collection
        public final Object[] toArray() {
            ArrayMap arrayMap = ArrayMap.this;
            int i = arrayMap.size;
            Object[] objArr = new Object[i];
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = arrayMap.valueAt(i2);
            }
            return objArr;
        }
    }
}
