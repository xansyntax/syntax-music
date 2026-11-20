package com.google.common.collect;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import coil3.util.UtilsKt;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CompactHashMap implements Map, Serializable {
    public static final Object NOT_FOUND = new Object();
    public transient int[] entries;
    public transient Object[] keys;
    public transient int metadata;
    public transient int size;
    public transient Object table;
    public transient Object[] values;

    /* JADX INFO: renamed from: com.google.common.collect.CompactHashMap$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements Iterator {
        public final /* synthetic */ byte $r8$classId;
        public int currentIndex;
        public int expectedMetadata;
        public int indexToRemove;
        public final /* synthetic */ CompactHashMap this$0;
        public final /* synthetic */ CompactHashMap this$0$1;

        public AnonymousClass1(CompactHashMap compactHashMap, byte b) {
            this.$r8$classId = b;
            this.this$0 = compactHashMap;
            this.this$0$1 = compactHashMap;
            this.expectedMetadata = compactHashMap.metadata;
            this.currentIndex = compactHashMap.isEmpty() ? -1 : 0;
            this.indexToRemove = -1;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.currentIndex >= 0;
        }

        @Override // java.util.Iterator
        public final Object next() {
            Object mapEntry;
            CompactHashMap compactHashMap = this.this$0$1;
            if (compactHashMap.metadata != this.expectedMetadata) {
                MarqueeSpacing$Companion$$ExternalSyntheticLambda0.m52m();
                return null;
            }
            if (!hasNext()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                return null;
            }
            int i = this.currentIndex;
            this.indexToRemove = i;
            byte b = this.$r8$classId;
            CompactHashMap compactHashMap2 = this.this$0;
            switch (b) {
                case 0:
                    mapEntry = compactHashMap2.requireKeys()[i];
                    break;
                case 1:
                    mapEntry = compactHashMap2.new MapEntry(i);
                    break;
                default:
                    mapEntry = compactHashMap2.requireValues()[i];
                    break;
            }
            int i2 = this.currentIndex + 1;
            if (i2 >= compactHashMap.size) {
                i2 = -1;
            }
            this.currentIndex = i2;
            return mapEntry;
        }

        @Override // java.util.Iterator
        public final void remove() {
            CompactHashMap compactHashMap = this.this$0$1;
            if (compactHashMap.metadata != this.expectedMetadata) {
                MarqueeSpacing$Companion$$ExternalSyntheticLambda0.m52m();
                return;
            }
            UtilsKt.checkState("no calls to next() since the last call to remove()", this.indexToRemove >= 0);
            this.expectedMetadata += 32;
            compactHashMap.remove(compactHashMap.requireKeys()[this.indexToRemove]);
            this.currentIndex--;
            this.indexToRemove = -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class KeySetView extends AbstractSet {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ CompactHashMap this$0;

        public /* synthetic */ KeySetView(CompactHashMap compactHashMap, byte b) {
            this.$r8$classId = b;
            this.this$0 = compactHashMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            byte b = this.$r8$classId;
            CompactHashMap compactHashMap = this.this$0;
            switch (b) {
                case 0:
                    compactHashMap.clear();
                    break;
                default:
                    compactHashMap.clear();
                    break;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            byte b = this.$r8$classId;
            CompactHashMap compactHashMap = this.this$0;
            switch (b) {
                case 0:
                    return compactHashMap.containsKey(obj);
                default:
                    Map mapDelegateOrNull = compactHashMap.delegateOrNull();
                    if (mapDelegateOrNull != null) {
                        return mapDelegateOrNull.entrySet().contains(obj);
                    }
                    if (obj instanceof Map.Entry) {
                        Map.Entry entry = (Map.Entry) obj;
                        int iIndexOf = compactHashMap.indexOf(entry.getKey());
                        if (iIndexOf != -1 && Objects.equals(compactHashMap.requireValues()[iIndexOf], entry.getValue())) {
                            return true;
                        }
                    }
                    return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            byte b = this.$r8$classId;
            CompactHashMap compactHashMap = this.this$0;
            switch (b) {
                case 0:
                    Map mapDelegateOrNull = compactHashMap.delegateOrNull();
                    return mapDelegateOrNull != null ? mapDelegateOrNull.keySet().iterator() : new AnonymousClass1(compactHashMap, (byte) 0);
                default:
                    Map mapDelegateOrNull2 = compactHashMap.delegateOrNull();
                    return mapDelegateOrNull2 != null ? mapDelegateOrNull2.entrySet().iterator() : new AnonymousClass1(compactHashMap, (byte) 1);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            byte b = this.$r8$classId;
            CompactHashMap compactHashMap = this.this$0;
            switch (b) {
                case 0:
                    Map mapDelegateOrNull = compactHashMap.delegateOrNull();
                    if (mapDelegateOrNull != null) {
                        return mapDelegateOrNull.keySet().remove(obj);
                    }
                    return compactHashMap.removeHelper(obj) != CompactHashMap.NOT_FOUND;
                default:
                    Map mapDelegateOrNull2 = compactHashMap.delegateOrNull();
                    if (mapDelegateOrNull2 != null) {
                        return mapDelegateOrNull2.entrySet().remove(obj);
                    }
                    if (!(obj instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    if (compactHashMap.needsAllocArrays()) {
                        return false;
                    }
                    int iHashTableMask = compactHashMap.hashTableMask();
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    Object obj2 = compactHashMap.table;
                    Objects.requireNonNull(obj2);
                    int iRemove = Maps.remove(key, value, iHashTableMask, obj2, compactHashMap.requireEntries(), compactHashMap.requireKeys(), compactHashMap.requireValues());
                    if (iRemove == -1) {
                        return false;
                    }
                    compactHashMap.moveLastEntry(iRemove, iHashTableMask);
                    compactHashMap.size--;
                    compactHashMap.metadata += 32;
                    return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            byte b = this.$r8$classId;
            CompactHashMap compactHashMap = this.this$0;
            switch (b) {
                case 0:
                    break;
            }
            return compactHashMap.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MapEntry extends AbstractMapEntry {
        public final Object key;
        public int lastKnownIndex;

        public MapEntry(int i) {
            this.key = CompactHashMap.this.requireKeys()[i];
            this.lastKnownIndex = i;
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            CompactHashMap compactHashMap = CompactHashMap.this;
            Map mapDelegateOrNull = compactHashMap.delegateOrNull();
            if (mapDelegateOrNull != null) {
                return mapDelegateOrNull.get(this.key);
            }
            updateLastKnownIndex();
            int i = this.lastKnownIndex;
            if (i == -1) {
                return null;
            }
            return compactHashMap.requireValues()[i];
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public final Object setValue(Object obj) {
            CompactHashMap compactHashMap = CompactHashMap.this;
            Map mapDelegateOrNull = compactHashMap.delegateOrNull();
            Object obj2 = this.key;
            if (mapDelegateOrNull != null) {
                return mapDelegateOrNull.put(obj2, obj);
            }
            updateLastKnownIndex();
            int i = this.lastKnownIndex;
            if (i == -1) {
                compactHashMap.put(obj2, obj);
                return null;
            }
            Object obj3 = compactHashMap.requireValues()[i];
            compactHashMap.requireValues()[this.lastKnownIndex] = obj;
            return obj3;
        }

        public final void updateLastKnownIndex() {
            int i = this.lastKnownIndex;
            Object obj = this.key;
            CompactHashMap compactHashMap = CompactHashMap.this;
            if (i != -1 && i < compactHashMap.size()) {
                if (Objects.equals(obj, compactHashMap.requireKeys()[this.lastKnownIndex])) {
                    return;
                }
            }
            this.lastKnownIndex = compactHashMap.indexOf(obj);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = objectInputStream.readInt();
        if (i < 0) {
            throw new InvalidObjectException(IntIntPair$$ExternalSyntheticOutline0.m(i, "Invalid size: "));
        }
        init(i);
        for (int i2 = 0; i2 < i; i2++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Map mapDelegateOrNull = delegateOrNull();
        Iterator it = mapDelegateOrNull != null ? mapDelegateOrNull.entrySet().iterator() : new AnonymousClass1(this, (byte) 1);
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // java.util.Map
    public final void clear() {
        if (needsAllocArrays()) {
            return;
        }
        this.metadata += 32;
        Map mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            this.metadata = StringsKt__IndentKt.constrainToRange(size(), 3);
            mapDelegateOrNull.clear();
            this.table = null;
            this.size = 0;
            return;
        }
        Arrays.fill(requireKeys(), 0, this.size, (Object) null);
        Arrays.fill(requireValues(), 0, this.size, (Object) null);
        Object obj = this.table;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(requireEntries(), 0, this.size, 0);
        this.size = 0;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        Map mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.containsKey(obj);
        }
        return indexOf(obj) != -1;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        Map mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.containsValue(obj);
        }
        for (int i = 0; i < this.size; i++) {
            if (Objects.equals(obj, requireValues()[i])) {
                return true;
            }
        }
        return false;
    }

    public final Map delegateOrNull() {
        Object obj = this.table;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        return new KeySetView(this, (byte) 1);
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return Maps.equalsImpl(this, obj);
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        Map mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.get(obj);
        }
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return null;
        }
        return requireValues()[iIndexOf];
    }

    @Override // java.util.Map
    public final int hashCode() {
        return new KeySetView(this, (byte) 1).hashCode();
    }

    public final int hashTableMask() {
        return (1 << (this.metadata & 31)) - 1;
    }

    public final int indexOf(Object obj) {
        if (needsAllocArrays()) {
            return -1;
        }
        int iSmearedHash = Maps.smearedHash(obj);
        int iHashTableMask = hashTableMask();
        Object obj2 = this.table;
        Objects.requireNonNull(obj2);
        int iTableGet = Maps.tableGet(iSmearedHash & iHashTableMask, obj2);
        if (iTableGet == 0) {
            return -1;
        }
        int i = ~iHashTableMask;
        int i2 = iSmearedHash & i;
        do {
            int i3 = iTableGet - 1;
            int i4 = requireEntries()[i3];
            if ((i4 & i) == i2 && Objects.equals(obj, requireKeys()[i3])) {
                return i3;
            }
            iTableGet = i4 & iHashTableMask;
        } while (iTableGet != 0);
        return -1;
    }

    public final void init(int i) {
        UtilsKt.checkArgument("Expected size must be >= 0", i >= 0);
        this.metadata = StringsKt__IndentKt.constrainToRange(i, 1);
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final Set keySet() {
        return new KeySetView(this, (byte) 0);
    }

    public final void moveLastEntry(int i, int i2) {
        Object obj = this.table;
        Objects.requireNonNull(obj);
        int[] iArrRequireEntries = requireEntries();
        Object[] objArrRequireKeys = requireKeys();
        Object[] objArrRequireValues = requireValues();
        int size = size();
        int i3 = size - 1;
        if (i >= i3) {
            objArrRequireKeys[i] = null;
            objArrRequireValues[i] = null;
            iArrRequireEntries[i] = 0;
            return;
        }
        Object obj2 = objArrRequireKeys[i3];
        objArrRequireKeys[i] = obj2;
        objArrRequireValues[i] = objArrRequireValues[i3];
        objArrRequireKeys[i3] = null;
        objArrRequireValues[i3] = null;
        iArrRequireEntries[i] = iArrRequireEntries[i3];
        iArrRequireEntries[i3] = 0;
        int iSmearedHash = Maps.smearedHash(obj2) & i2;
        int iTableGet = Maps.tableGet(iSmearedHash, obj);
        if (iTableGet == size) {
            Maps.tableSet(iSmearedHash, i + 1, obj);
            return;
        }
        while (true) {
            int i4 = iTableGet - 1;
            int i5 = iArrRequireEntries[i4];
            int i6 = i5 & i2;
            if (i6 == size) {
                iArrRequireEntries[i4] = Maps.maskCombine(i5, i + 1, i2);
                return;
            }
            iTableGet = i6;
        }
    }

    public final boolean needsAllocArrays() {
        return this.table == null;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00de  */
    /* JADX WARN: Code duplicated, block: B:55:0x00f4 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00f1 -> B:34:0x00d9). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:55:0x00f4
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // java.util.Map
    public final java.lang.Object put(java.lang.Object r20, java.lang.Object r21) {
        /*
            Method dump skipped, instruction units count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.CompactHashMap.put(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        Map mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.remove(obj);
        }
        Object objRemoveHelper = removeHelper(obj);
        if (objRemoveHelper == NOT_FOUND) {
            return null;
        }
        return objRemoveHelper;
    }

    public final Object removeHelper(Object obj) {
        if (!needsAllocArrays()) {
            int iHashTableMask = hashTableMask();
            Object obj2 = this.table;
            Objects.requireNonNull(obj2);
            int iRemove = Maps.remove(obj, null, iHashTableMask, obj2, requireEntries(), requireKeys(), null);
            if (iRemove != -1) {
                Object obj3 = requireValues()[iRemove];
                moveLastEntry(iRemove, iHashTableMask);
                this.size--;
                this.metadata += 32;
                return obj3;
            }
        }
        return NOT_FOUND;
    }

    public final int[] requireEntries() {
        int[] iArr = this.entries;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final Object[] requireKeys() {
        Object[] objArr = this.keys;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final Object[] requireValues() {
        Object[] objArr = this.values;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final int resizeTable(int i, int i2, int i3, int i4) {
        Object objCreateTable = Maps.createTable(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            Maps.tableSet(i3 & i5, i4 + 1, objCreateTable);
        }
        Object obj = this.table;
        Objects.requireNonNull(obj);
        int[] iArrRequireEntries = requireEntries();
        for (int i6 = 0; i6 <= i; i6++) {
            int iTableGet = Maps.tableGet(i6, obj);
            while (iTableGet != 0) {
                int i7 = iTableGet - 1;
                int i8 = iArrRequireEntries[i7];
                int i9 = ((~i) & i8) | i6;
                int i10 = i9 & i5;
                int iTableGet2 = Maps.tableGet(i10, objCreateTable);
                Maps.tableSet(i10, iTableGet, objCreateTable);
                iArrRequireEntries[i7] = Maps.maskCombine(i9, iTableGet2, i5);
                iTableGet = i8 & i;
            }
        }
        this.table = objCreateTable;
        this.metadata = Maps.maskCombine(this.metadata, 32 - Integer.numberOfLeadingZeros(i5), 31);
        return i5;
    }

    @Override // java.util.Map
    public final int size() {
        Map mapDelegateOrNull = delegateOrNull();
        return mapDelegateOrNull != null ? mapDelegateOrNull.size() : this.size;
    }

    public final String toString() {
        return Maps.toStringImpl(this);
    }

    @Override // java.util.Map
    public final Collection values() {
        return new Maps.Values((byte) 3, this);
    }
}
