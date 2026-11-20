package androidx.datastore.preferences.protobuf;

import androidx.collection.ArrayMap;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SmallSortedMap$1 extends AbstractMap {
    public static final /* synthetic */ int $r8$clinit = 0;
    public List entryList;
    public boolean isImmutable;
    public volatile ArrayMap.EntrySet lazyEntrySet;
    public Map overflowEntries;
    public Map overflowEntriesDescending;

    public static SmallSortedMap$1 newFieldMap() {
        SmallSortedMap$1 smallSortedMap$1 = new SmallSortedMap$1();
        smallSortedMap$1.entryList = Collections.EMPTY_LIST;
        Map map = Collections.EMPTY_MAP;
        smallSortedMap$1.overflowEntries = map;
        smallSortedMap$1.overflowEntriesDescending = map;
        return smallSortedMap$1;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0024  */
    /* JADX WARN: Code duplicated, block: B:17:0x003e  */
    /* JADX WARN: Code duplicated, block: B:21:0x003c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0038 A[SYNTHETIC] */
    public final int binarySearchInArray(Comparable comparable) {
        int i;
        int i2;
        int i3;
        int iCompareTo;
        int size = this.entryList.size();
        int i4 = size - 1;
        if (i4 < 0) {
            i = 0;
            while (i <= i4) {
                i3 = (i + i4) / 2;
                iCompareTo = comparable.compareTo(((SmallSortedMap$Entry) this.entryList.get(i3)).key);
                if (iCompareTo < 0) {
                    i4 = i3 - 1;
                } else {
                    if (iCompareTo > 0) {
                        return i3;
                    }
                    i = i3 + 1;
                }
            }
            i2 = i + 1;
        } else {
            int iCompareTo2 = comparable.compareTo(((SmallSortedMap$Entry) this.entryList.get(i4)).key);
            if (iCompareTo2 > 0) {
                i2 = size + 1;
            } else {
                if (iCompareTo2 == 0) {
                    return i4;
                }
                i = 0;
                while (i <= i4) {
                    i3 = (i + i4) / 2;
                    iCompareTo = comparable.compareTo(((SmallSortedMap$Entry) this.entryList.get(i3)).key);
                    if (iCompareTo < 0) {
                        i4 = i3 - 1;
                    } else {
                        if (iCompareTo > 0) {
                            return i3;
                        }
                        i = i3 + 1;
                    }
                }
                i2 = i + 1;
            }
        }
        return -i2;
    }

    public final void checkMutable() {
        if (this.isImmutable) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        checkMutable();
        if (!this.entryList.isEmpty()) {
            this.entryList.clear();
        }
        if (this.overflowEntries.isEmpty()) {
            return;
        }
        this.overflowEntries.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return binarySearchInArray(comparable) >= 0 || this.overflowEntries.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.lazyEntrySet == null) {
            this.lazyEntrySet = new ArrayMap.EntrySet(this, (byte) 1);
        }
        return this.lazyEntrySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SmallSortedMap$1)) {
            return super.equals(obj);
        }
        SmallSortedMap$1 smallSortedMap$1 = (SmallSortedMap$1) obj;
        int size = size();
        if (size == smallSortedMap$1.size()) {
            int size2 = this.entryList.size();
            if (size2 != smallSortedMap$1.entryList.size()) {
                return ((AbstractSet) entrySet()).equals(smallSortedMap$1.entrySet());
            }
            for (int i = 0; i < size2; i++) {
                if (getArrayEntryAt(i).equals(smallSortedMap$1.getArrayEntryAt(i))) {
                }
            }
            if (size2 != size) {
                return this.overflowEntries.equals(smallSortedMap$1.overflowEntries);
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iBinarySearchInArray = binarySearchInArray(comparable);
        return iBinarySearchInArray >= 0 ? ((SmallSortedMap$Entry) this.entryList.get(iBinarySearchInArray)).value : this.overflowEntries.get(comparable);
    }

    public final Map.Entry getArrayEntryAt(int i) {
        return (Map.Entry) this.entryList.get(i);
    }

    public final Set getOverflowEntries() {
        return this.overflowEntries.isEmpty() ? Collections.EMPTY_SET : this.overflowEntries.entrySet();
    }

    public final SortedMap getOverflowEntriesMutable() {
        checkMutable();
        if (this.overflowEntries.isEmpty() && !(this.overflowEntries instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.overflowEntries = treeMap;
            this.overflowEntriesDescending = treeMap.descendingMap();
        }
        return (SortedMap) this.overflowEntries;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.entryList.size();
        int iHashCode = 0;
        for (int i = 0; i < size; i++) {
            iHashCode += ((SmallSortedMap$Entry) this.entryList.get(i)).hashCode();
        }
        return this.overflowEntries.size() > 0 ? this.overflowEntries.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: put$androidx$datastore$preferences$protobuf$SmallSortedMap, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        checkMutable();
        int iBinarySearchInArray = binarySearchInArray(comparable);
        if (iBinarySearchInArray >= 0) {
            return ((SmallSortedMap$Entry) this.entryList.get(iBinarySearchInArray)).setValue(obj);
        }
        checkMutable();
        if (this.entryList.isEmpty() && !(this.entryList instanceof ArrayList)) {
            this.entryList = new ArrayList(16);
        }
        int i = -(iBinarySearchInArray + 1);
        if (i >= 16) {
            return getOverflowEntriesMutable().put(comparable, obj);
        }
        if (this.entryList.size() == 16) {
            SmallSortedMap$Entry smallSortedMap$Entry = (SmallSortedMap$Entry) this.entryList.remove(15);
            getOverflowEntriesMutable().put(smallSortedMap$Entry.key, smallSortedMap$Entry.value);
        }
        this.entryList.add(i, new SmallSortedMap$Entry(this, comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        checkMutable();
        Comparable comparable = (Comparable) obj;
        int iBinarySearchInArray = binarySearchInArray(comparable);
        if (iBinarySearchInArray >= 0) {
            return removeArrayEntryAt(iBinarySearchInArray);
        }
        if (this.overflowEntries.isEmpty()) {
            return null;
        }
        return this.overflowEntries.remove(comparable);
    }

    public final Object removeArrayEntryAt(int i) {
        checkMutable();
        Object obj = ((SmallSortedMap$Entry) this.entryList.remove(i)).value;
        if (!this.overflowEntries.isEmpty()) {
            Iterator it = getOverflowEntriesMutable().entrySet().iterator();
            List list = this.entryList;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new SmallSortedMap$Entry(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.overflowEntries.size() + this.entryList.size();
    }
}
