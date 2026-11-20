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
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CompactHashSet extends AbstractSet implements Serializable {
    public transient Object[] elements;
    public transient int[] entries;
    public transient int metadata;
    public transient int size;
    public transient Object table;

    public static CompactHashSet createWithExpectedSize(int i) {
        CompactHashSet compactHashSet = new CompactHashSet();
        UtilsKt.checkArgument("Expected size must be >= 0", i >= 0);
        compactHashSet.metadata = StringsKt__IndentKt.constrainToRange(i, 1);
        return compactHashSet;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = objectInputStream.readInt();
        if (i < 0) {
            throw new InvalidObjectException(IntIntPair$$ExternalSyntheticOutline0.m(i, "Invalid size: "));
        }
        UtilsKt.checkArgument("Expected size must be >= 0", i >= 0);
        this.metadata = StringsKt__IndentKt.constrainToRange(i, 1);
        for (int i2 = 0; i2 < i; i2++) {
            add(objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int iMin;
        char c = 31;
        if (needsAllocArrays()) {
            UtilsKt.checkState("Arrays already allocated", needsAllocArrays());
            int i = this.metadata;
            int iMax = Math.max(i + 1, 2);
            int iHighestOneBit = Integer.highestOneBit(iMax);
            if (iMax > ((int) (1.0d * ((double) iHighestOneBit))) && (iHighestOneBit = iHighestOneBit << 1) <= 0) {
                iHighestOneBit = 1073741824;
            }
            int iMax2 = Math.max(4, iHighestOneBit);
            this.table = Maps.createTable(iMax2);
            this.metadata = Maps.maskCombine(this.metadata, 32 - Integer.numberOfLeadingZeros(iMax2 - 1), 31);
            this.entries = new int[i];
            this.elements = new Object[i];
        }
        Set setDelegateOrNull = delegateOrNull();
        if (setDelegateOrNull != null) {
            return setDelegateOrNull.add(obj);
        }
        int[] iArrRequireEntries = requireEntries();
        Object[] objArrRequireElements = requireElements();
        int i2 = this.size;
        int i3 = i2 + 1;
        int iSmearedHash = Maps.smearedHash(obj);
        int iResizeTable = (1 << (this.metadata & 31)) - 1;
        int i4 = iSmearedHash & iResizeTable;
        Object obj2 = this.table;
        Objects.requireNonNull(obj2);
        int iTableGet = Maps.tableGet(i4, obj2);
        if (iTableGet != 0) {
            int i5 = ~iResizeTable;
            int i6 = iSmearedHash & i5;
            int i7 = 0;
            while (true) {
                int i8 = iTableGet - 1;
                int i9 = iArrRequireEntries[i8];
                char c2 = c;
                if ((i9 & i5) == i6 && Objects.equals(obj, objArrRequireElements[i8])) {
                    return false;
                }
                int i10 = i9 & iResizeTable;
                i7++;
                if (i10 == 0) {
                    if (i7 < 9) {
                        if (i3 <= iResizeTable) {
                            iArrRequireEntries[i8] = Maps.maskCombine(i9, i3, iResizeTable);
                            break;
                        }
                        iResizeTable = resizeTable(iResizeTable, Maps.newCapacity(iResizeTable), iSmearedHash, i2);
                        break;
                    }
                    LinkedHashSet linkedHashSet = new LinkedHashSet(1 << (this.metadata & 31), 1.0f);
                    int i11 = isEmpty() ? -1 : 0;
                    while (i11 >= 0) {
                        linkedHashSet.add(requireElements()[i11]);
                        i11++;
                        if (i11 >= this.size) {
                            i11 = -1;
                        }
                    }
                    this.table = linkedHashSet;
                    this.entries = null;
                    this.elements = null;
                    this.metadata += 32;
                    return linkedHashSet.add(obj);
                }
                iTableGet = i10;
                c = c2;
            }
        } else if (i3 > iResizeTable) {
            iResizeTable = resizeTable(iResizeTable, Maps.newCapacity(iResizeTable), iSmearedHash, i2);
        } else {
            Object obj3 = this.table;
            Objects.requireNonNull(obj3);
            Maps.tableSet(i4, i3, obj3);
        }
        int length = requireEntries().length;
        if (i3 > length && (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            this.entries = Arrays.copyOf(requireEntries(), iMin);
            this.elements = Arrays.copyOf(requireElements(), iMin);
        }
        requireEntries()[i2] = Maps.maskCombine(iSmearedHash, 0, iResizeTable);
        requireElements()[i2] = obj;
        this.size = i3;
        this.metadata += 32;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        if (needsAllocArrays()) {
            return;
        }
        this.metadata += 32;
        Set setDelegateOrNull = delegateOrNull();
        if (setDelegateOrNull != null) {
            this.metadata = StringsKt__IndentKt.constrainToRange(size(), 3);
            setDelegateOrNull.clear();
            this.table = null;
            this.size = 0;
            return;
        }
        Arrays.fill(requireElements(), 0, this.size, (Object) null);
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

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        Set setDelegateOrNull = delegateOrNull();
        if (setDelegateOrNull != null) {
            return setDelegateOrNull.contains(obj);
        }
        int iSmearedHash = Maps.smearedHash(obj);
        int i = (1 << (this.metadata & 31)) - 1;
        Object obj2 = this.table;
        Objects.requireNonNull(obj2);
        int iTableGet = Maps.tableGet(iSmearedHash & i, obj2);
        if (iTableGet == 0) {
            return false;
        }
        int i2 = ~i;
        int i3 = iSmearedHash & i2;
        do {
            int i4 = iTableGet - 1;
            int i5 = requireEntries()[i4];
            if ((i5 & i2) == i3 && Objects.equals(obj, requireElements()[i4])) {
                return true;
            }
            iTableGet = i5 & i;
        } while (iTableGet != 0);
        return false;
    }

    public final Set delegateOrNull() {
        Object obj = this.table;
        if (obj instanceof Set) {
            return (Set) obj;
        }
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        Set setDelegateOrNull = delegateOrNull();
        return setDelegateOrNull != null ? setDelegateOrNull.iterator() : new Iterator() { // from class: com.google.common.collect.CompactHashSet.1
            public int currentIndex;
            public int expectedMetadata;
            public int indexToRemove;

            {
                this.expectedMetadata = CompactHashSet.this.metadata;
                this.currentIndex = CompactHashSet.this.isEmpty() ? -1 : 0;
                this.indexToRemove = -1;
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.currentIndex >= 0;
            }

            @Override // java.util.Iterator
            public final Object next() {
                CompactHashSet compactHashSet = CompactHashSet.this;
                if (compactHashSet.metadata != this.expectedMetadata) {
                    MarqueeSpacing$Companion$$ExternalSyntheticLambda0.m52m();
                    return null;
                }
                if (!hasNext()) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                    return null;
                }
                int i = this.currentIndex;
                this.indexToRemove = i;
                Object obj = compactHashSet.requireElements()[i];
                int i2 = this.currentIndex + 1;
                if (i2 >= compactHashSet.size) {
                    i2 = -1;
                }
                this.currentIndex = i2;
                return obj;
            }

            @Override // java.util.Iterator
            public final void remove() {
                CompactHashSet compactHashSet = CompactHashSet.this;
                if (compactHashSet.metadata != this.expectedMetadata) {
                    MarqueeSpacing$Companion$$ExternalSyntheticLambda0.m52m();
                    return;
                }
                UtilsKt.checkState("no calls to next() since the last call to remove()", this.indexToRemove >= 0);
                this.expectedMetadata += 32;
                compactHashSet.remove(compactHashSet.requireElements()[this.indexToRemove]);
                this.currentIndex--;
                this.indexToRemove = -1;
            }
        };
    }

    public final boolean needsAllocArrays() {
        return this.table == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int i;
        int i2;
        if (!needsAllocArrays()) {
            Set setDelegateOrNull = delegateOrNull();
            if (setDelegateOrNull != null) {
                return setDelegateOrNull.remove(obj);
            }
            int i3 = (1 << (this.metadata & 31)) - 1;
            Object obj2 = this.table;
            Objects.requireNonNull(obj2);
            int iRemove = Maps.remove(obj, null, i3, obj2, requireEntries(), requireElements(), null);
            if (iRemove != -1) {
                Object obj3 = this.table;
                Objects.requireNonNull(obj3);
                int[] iArrRequireEntries = requireEntries();
                Object[] objArrRequireElements = requireElements();
                int size = size();
                int i4 = size - 1;
                if (iRemove < i4) {
                    Object obj4 = objArrRequireElements[i4];
                    objArrRequireElements[iRemove] = obj4;
                    objArrRequireElements[i4] = null;
                    iArrRequireEntries[iRemove] = iArrRequireEntries[i4];
                    iArrRequireEntries[i4] = 0;
                    int iSmearedHash = Maps.smearedHash(obj4) & i3;
                    int iTableGet = Maps.tableGet(iSmearedHash, obj3);
                    if (iTableGet == size) {
                        Maps.tableSet(iSmearedHash, iRemove + 1, obj3);
                    } else {
                        while (true) {
                            i = iTableGet - 1;
                            i2 = iArrRequireEntries[i];
                            int i5 = i2 & i3;
                            if (i5 == size) {
                                break;
                            }
                            iTableGet = i5;
                        }
                        iArrRequireEntries[i] = Maps.maskCombine(i2, iRemove + 1, i3);
                    }
                } else {
                    objArrRequireElements[iRemove] = null;
                    iArrRequireEntries[iRemove] = 0;
                }
                this.size--;
                this.metadata += 32;
                return true;
            }
        }
        return false;
    }

    public final Object[] requireElements() {
        Object[] objArr = this.elements;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final int[] requireEntries() {
        int[] iArr = this.entries;
        Objects.requireNonNull(iArr);
        return iArr;
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

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        Set setDelegateOrNull = delegateOrNull();
        return setDelegateOrNull != null ? setDelegateOrNull.size() : this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        if (needsAllocArrays()) {
            if (objArr.length > 0) {
                objArr[0] = null;
            }
            return objArr;
        }
        Set setDelegateOrNull = delegateOrNull();
        if (setDelegateOrNull != null) {
            return setDelegateOrNull.toArray(objArr);
        }
        Object[] objArrRequireElements = requireElements();
        int i = this.size;
        UtilsKt.checkPositionIndexes(0, i, objArrRequireElements.length);
        if (objArr.length < i) {
            if (objArr.length != 0) {
                objArr = Arrays.copyOf(objArr, 0);
            }
            objArr = Arrays.copyOf(objArr, i);
        } else if (objArr.length > i) {
            objArr[i] = null;
        }
        System.arraycopy(objArrRequireElements, 0, objArr, 0, i);
        return objArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        if (needsAllocArrays()) {
            return new Object[0];
        }
        Set setDelegateOrNull = delegateOrNull();
        return setDelegateOrNull != null ? setDelegateOrNull.toArray() : Arrays.copyOf(requireElements(), this.size);
    }
}
