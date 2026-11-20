package com.google.protobuf;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BooleanArrayList extends AbstractProtobufList implements Internal.BooleanList, RandomAccess, PrimitiveNonBoxingCollection {
    public static final boolean[] EMPTY_ARRAY;
    public static final BooleanArrayList EMPTY_LIST;
    public boolean[] array;
    public int size;

    static {
        boolean[] zArr = new boolean[0];
        EMPTY_ARRAY = zArr;
        EMPTY_LIST = new BooleanArrayList(zArr, 0, false);
    }

    public BooleanArrayList(boolean[] zArr, int i, boolean z) {
        super(z);
        this.array = zArr;
        this.size = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        ensureIsMutable();
        if (i < 0 || i > (i2 = this.size)) {
            PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(i, "Index:", ", Size:"), this.size);
            return;
        }
        boolean[] zArr = this.array;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[Format$$ExternalSyntheticOutline0.m(zArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.array, 0, zArr2, 0, i);
            System.arraycopy(this.array, i, zArr2, i + 1, this.size - i);
            this.array = zArr2;
        }
        this.array[i] = zBooleanValue;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        ensureIsMutable();
        byte[] bArr = Internal.EMPTY_BYTE_ARRAY;
        collection.getClass();
        if (!(collection instanceof BooleanArrayList)) {
            return super.addAll(collection);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) collection;
        int i = booleanArrayList.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        boolean[] zArrCopyOf = this.array;
        if (i3 > zArrCopyOf.length) {
            zArrCopyOf = Arrays.copyOf(zArrCopyOf, i3);
            this.array = zArrCopyOf;
        }
        System.arraycopy(booleanArrayList.array, 0, zArrCopyOf, this.size, booleanArrayList.size);
        this.size = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void addBoolean(boolean z) {
        ensureIsMutable();
        int i = this.size;
        boolean[] zArr = this.array;
        if (i == zArr.length) {
            zArr = new boolean[Format$$ExternalSyntheticOutline0.m(zArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.array, 0, zArr, 0, this.size);
            this.array = zArr;
        }
        int i2 = this.size;
        this.size = i2 + 1;
        zArr[i2] = z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void ensureIndexInRange(int i) {
        if (i < 0 || i >= this.size) {
            PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(i, "Index:", ", Size:"), this.size);
        }
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BooleanArrayList)) {
            return super.equals(obj);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) obj;
        if (this.size != booleanArrayList.size) {
            return false;
        }
        boolean[] zArr = booleanArrayList.array;
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        ensureIndexInRange(i);
        return Boolean.valueOf(this.array[i]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            int i3 = i * 31;
            boolean z = this.array[i2];
            byte[] bArr = Internal.EMPTY_BYTE_ARRAY;
            i = i3 + (z ? 1231 : 1237);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.array[i2] == zBooleanValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.protobuf.Internal.ProtobufList
    public final BooleanArrayList mutableCopyWithCapacity(int i) {
        if (i >= this.size) {
            return new BooleanArrayList(i == 0 ? EMPTY_ARRAY : Arrays.copyOf(this.array, i), this.size, true);
        }
        Path$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        ensureIsMutable();
        ensureIndexInRange(i);
        boolean[] zArr = this.array;
        boolean z = zArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        ensureIsMutable();
        if (i2 < i) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m("toIndex < fromIndex");
            return;
        }
        boolean[] zArr = this.array;
        System.arraycopy(zArr, i2, zArr, i, this.size - i2);
        this.size -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        ensureIsMutable();
        ensureIndexInRange(i);
        boolean[] zArr = this.array;
        boolean z = zArr[i];
        zArr[i] = zBooleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addBoolean(((Boolean) obj).booleanValue());
        return true;
    }
}
