package com.google.common.collect;

import coil3.util.UtilsKt;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RegularImmutableMap extends ImmutableMap {
    public static final RegularImmutableMap EMPTY = new RegularImmutableMap(0, null, new Object[0]);
    public final transient Object[] alternatingKeysAndValues;
    public final transient Object hashTable;
    public final transient int size;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class EntrySet extends ImmutableSet {
        public final transient Object[] alternatingKeysAndValues;
        public final transient boolean keyOffset;
        public final transient ImmutableMap map;
        public final transient int size;

        /* JADX WARN: Multi-variable type inference failed */
        public EntrySet(ImmutableMap immutableMap, Object[] objArr, int i, int i2) {
            this.map = immutableMap;
            this.alternatingKeysAndValues = objArr;
            this.keyOffset = i;
            this.size = i2;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.map.get(key));
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final int copyIntoArray(int i, Object[] objArr) {
            return asList().copyIntoArray(i, objArr);
        }

        @Override // com.google.common.collect.ImmutableSet
        public final ImmutableList createAsList() {
            return new ImmutableList() { // from class: com.google.common.collect.RegularImmutableMap.EntrySet.1
                @Override // java.util.List
                public final Object get(int i) {
                    EntrySet entrySet = EntrySet.this;
                    UtilsKt.checkElementIndex(i, entrySet.size);
                    Object[] objArr = entrySet.alternatingKeysAndValues;
                    int i2 = i * 2;
                    boolean z = entrySet.keyOffset;
                    Object obj = objArr[i2 + (z ? 1 : 0)];
                    Objects.requireNonNull(obj);
                    Object obj2 = objArr[i2 + (!z ? 1 : 0)];
                    Objects.requireNonNull(obj2);
                    return new AbstractMap.SimpleImmutableEntry(obj, obj2);
                }

                @Override // com.google.common.collect.ImmutableCollection
                public final boolean isPartialView() {
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public final int size() {
                    return EntrySet.this.size;
                }
            };
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final UnmodifiableIterator iterator() {
            return asList().listIterator(0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.size;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class KeySet extends ImmutableSet {
        public final transient KeysOrValuesAsList list;
        public final transient ImmutableMap map;

        public KeySet(ImmutableMap immutableMap, KeysOrValuesAsList keysOrValuesAsList) {
            this.map = immutableMap;
            this.list = keysOrValuesAsList;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public final ImmutableList asList() {
            return this.list;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
            return this.map.get(obj) != null;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final int copyIntoArray(int i, Object[] objArr) {
            return this.list.copyIntoArray(i, objArr);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final UnmodifiableIterator iterator() {
            return this.list.listIterator(0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.map.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class KeysOrValuesAsList extends ImmutableList {
        public final transient Object[] alternatingKeysAndValues;
        public final transient boolean offset;
        public final transient int size;

        /* JADX WARN: Multi-variable type inference failed */
        public KeysOrValuesAsList(Object[] objArr, int i, int i2) {
            this.alternatingKeysAndValues = objArr;
            this.offset = i;
            this.size = i2;
        }

        @Override // java.util.List
        public final Object get(int i) {
            UtilsKt.checkElementIndex(i, this.size);
            Object obj = this.alternatingKeysAndValues[(i * 2) + (this.offset ? 1 : 0)];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return this.size;
        }
    }

    public RegularImmutableMap(int i, Object obj, Object[] objArr) {
        this.hashTable = obj;
        this.alternatingKeysAndValues = objArr;
        this.size = i;
    }

    public static RegularImmutableMap create(int i, Object[] objArr, StatusLine statusLine) {
        if (i == 0) {
            return EMPTY;
        }
        if (i == 1) {
            Objects.requireNonNull(objArr[0]);
            Objects.requireNonNull(objArr[1]);
            return new RegularImmutableMap(1, null, objArr);
        }
        UtilsKt.checkPositionIndex(i, objArr.length >> 1);
        Object objCreateHashTable = createHashTable(objArr, i, ImmutableSet.chooseTableSize(i), 0);
        if (objCreateHashTable instanceof Object[]) {
            Object[] objArr2 = (Object[]) objCreateHashTable;
            ImmutableMap$Builder$DuplicateKey immutableMap$Builder$DuplicateKey = (ImmutableMap$Builder$DuplicateKey) objArr2[2];
            if (statusLine == null) {
                throw immutableMap$Builder$DuplicateKey.exception();
            }
            statusLine.message = immutableMap$Builder$DuplicateKey;
            Object obj = objArr2[0];
            int iIntValue = ((Integer) objArr2[1]).intValue();
            objArr = Arrays.copyOf(objArr, iIntValue * 2);
            objCreateHashTable = obj;
            i = iIntValue;
        }
        return new RegularImmutableMap(i, objCreateHashTable, objArr);
    }

    public static Object createHashTable(Object[] objArr, int i, int i2, int i3) {
        ImmutableMap$Builder$DuplicateKey immutableMap$Builder$DuplicateKey = null;
        if (i == 1) {
            Objects.requireNonNull(objArr[i3]);
            Objects.requireNonNull(objArr[i3 ^ 1]);
            return null;
        }
        int i4 = i2 - 1;
        int i5 = 0;
        if (i2 <= 128) {
            byte[] bArr = new byte[i2];
            Arrays.fill(bArr, (byte) -1);
            int i6 = 0;
            while (i5 < i) {
                int i7 = (i5 * 2) + i3;
                int i8 = (i6 * 2) + i3;
                Object obj = objArr[i7];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i7 ^ 1];
                Objects.requireNonNull(obj2);
                int iSmear = Maps.smear(obj.hashCode());
                while (true) {
                    int i9 = iSmear & i4;
                    int i10 = bArr[i9] & 255;
                    if (i10 == 255) {
                        bArr[i9] = (byte) i8;
                        if (i6 < i5) {
                            objArr[i8] = obj;
                            objArr[i8 ^ 1] = obj2;
                        }
                        i6++;
                        break;
                    }
                    if (obj.equals(objArr[i10])) {
                        int i11 = i10 ^ 1;
                        Object obj3 = objArr[i11];
                        Objects.requireNonNull(obj3);
                        immutableMap$Builder$DuplicateKey = new ImmutableMap$Builder$DuplicateKey(obj, obj2, obj3);
                        objArr[i11] = obj2;
                        break;
                    }
                    iSmear = i9 + 1;
                }
                i5++;
            }
            return i6 == i ? bArr : new Object[]{bArr, Integer.valueOf(i6), immutableMap$Builder$DuplicateKey};
        }
        if (i2 <= 32768) {
            short[] sArr = new short[i2];
            Arrays.fill(sArr, (short) -1);
            int i12 = 0;
            while (i5 < i) {
                int i13 = (i5 * 2) + i3;
                int i14 = (i12 * 2) + i3;
                Object obj4 = objArr[i13];
                Objects.requireNonNull(obj4);
                Object obj5 = objArr[i13 ^ 1];
                Objects.requireNonNull(obj5);
                int iSmear2 = Maps.smear(obj4.hashCode());
                while (true) {
                    int i15 = iSmear2 & i4;
                    int i16 = sArr[i15] & 65535;
                    if (i16 == 65535) {
                        sArr[i15] = (short) i14;
                        if (i12 < i5) {
                            objArr[i14] = obj4;
                            objArr[i14 ^ 1] = obj5;
                        }
                        i12++;
                        break;
                    }
                    if (obj4.equals(objArr[i16])) {
                        int i17 = i16 ^ 1;
                        Object obj6 = objArr[i17];
                        Objects.requireNonNull(obj6);
                        immutableMap$Builder$DuplicateKey = new ImmutableMap$Builder$DuplicateKey(obj4, obj5, obj6);
                        objArr[i17] = obj5;
                        break;
                    }
                    iSmear2 = i15 + 1;
                }
                i5++;
            }
            return i12 == i ? sArr : new Object[]{sArr, Integer.valueOf(i12), immutableMap$Builder$DuplicateKey};
        }
        int[] iArr = new int[i2];
        Arrays.fill(iArr, -1);
        int i18 = 0;
        while (i5 < i) {
            int i19 = (i5 * 2) + i3;
            int i20 = (i18 * 2) + i3;
            Object obj7 = objArr[i19];
            Objects.requireNonNull(obj7);
            Object obj8 = objArr[i19 ^ 1];
            Objects.requireNonNull(obj8);
            int iSmear3 = Maps.smear(obj7.hashCode());
            while (true) {
                int i21 = iSmear3 & i4;
                int i22 = iArr[i21];
                if (i22 == -1) {
                    iArr[i21] = i20;
                    if (i18 < i5) {
                        objArr[i20] = obj7;
                        objArr[i20 ^ 1] = obj8;
                    }
                    i18++;
                    break;
                }
                if (obj7.equals(objArr[i22])) {
                    int i23 = i22 ^ 1;
                    Object obj9 = objArr[i23];
                    Objects.requireNonNull(obj9);
                    immutableMap$Builder$DuplicateKey = new ImmutableMap$Builder$DuplicateKey(obj7, obj8, obj9);
                    objArr[i23] = obj8;
                    break;
                }
                iSmear3 = i21 + 1;
            }
            i5++;
        }
        return i18 == i ? iArr : new Object[]{iArr, Integer.valueOf(i18), immutableMap$Builder$DuplicateKey};
    }

    public static Object get(Object obj, Object[] objArr, int i, int i2, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i == 1) {
            Object obj3 = objArr[i2];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i2 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length - 1;
            int iSmear = Maps.smear(obj2.hashCode());
            while (true) {
                int i3 = iSmear & length;
                int i4 = bArr[i3] & 255;
                if (i4 == 255) {
                    return null;
                }
                if (obj2.equals(objArr[i4])) {
                    return objArr[i4 ^ 1];
                }
                iSmear = i3 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int iSmear2 = Maps.smear(obj2.hashCode());
            while (true) {
                int i5 = iSmear2 & length2;
                int i6 = sArr[i5] & 65535;
                if (i6 == 65535) {
                    return null;
                }
                if (obj2.equals(objArr[i6])) {
                    return objArr[i6 ^ 1];
                }
                iSmear2 = i5 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int iSmear3 = Maps.smear(obj2.hashCode());
            while (true) {
                int i7 = iSmear3 & length3;
                int i8 = iArr[i7];
                if (i8 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i8])) {
                    return objArr[i8 ^ 1];
                }
                iSmear3 = i7 + 1;
            }
        }
    }

    @Override // java.util.Map
    public final EntrySet entrySet() {
        return new EntrySet(this, this.alternatingKeysAndValues, 0, this.size);
    }

    @Override // java.util.Map
    public final KeySet keySet() {
        return new KeySet(this, new KeysOrValuesAsList(this.alternatingKeysAndValues, 0, this.size));
    }

    @Override // java.util.Map
    public final int size() {
        return this.size;
    }

    @Override // java.util.Map
    public final ImmutableCollection values() {
        return new KeysOrValuesAsList(this.alternatingKeysAndValues, 1, this.size);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public final Object get(Object obj) {
        Object obj2 = get(this.hashTable, this.alternatingKeysAndValues, this.size, 0, obj);
        if (obj2 == null) {
            return null;
        }
        return obj2;
    }
}
