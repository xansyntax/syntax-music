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
public final class DoubleArrayList extends AbstractProtobufList implements Internal.DoubleList, RandomAccess, PrimitiveNonBoxingCollection {
    public static final double[] EMPTY_ARRAY;
    public static final DoubleArrayList EMPTY_LIST;
    public double[] array;
    public int size;

    static {
        double[] dArr = new double[0];
        EMPTY_ARRAY = dArr;
        EMPTY_LIST = new DoubleArrayList(dArr, 0, false);
    }

    public DoubleArrayList(double[] dArr, int i, boolean z) {
        super(z);
        this.array = dArr;
        this.size = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        double dDoubleValue = ((Double) obj).doubleValue();
        ensureIsMutable();
        if (i < 0 || i > (i2 = this.size)) {
            PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(i, "Index:", ", Size:"), this.size);
            return;
        }
        double[] dArr = this.array;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[Format$$ExternalSyntheticOutline0.m(dArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.array, 0, dArr2, 0, i);
            System.arraycopy(this.array, i, dArr2, i + 1, this.size - i);
            this.array = dArr2;
        }
        this.array[i] = dDoubleValue;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        ensureIsMutable();
        byte[] bArr = Internal.EMPTY_BYTE_ARRAY;
        collection.getClass();
        if (!(collection instanceof DoubleArrayList)) {
            return super.addAll(collection);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) collection;
        int i = doubleArrayList.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        double[] dArrCopyOf = this.array;
        if (i3 > dArrCopyOf.length) {
            dArrCopyOf = Arrays.copyOf(dArrCopyOf, i3);
            this.array = dArrCopyOf;
        }
        System.arraycopy(doubleArrayList.array, 0, dArrCopyOf, this.size, doubleArrayList.size);
        this.size = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void addDouble(double d) {
        ensureIsMutable();
        int i = this.size;
        double[] dArr = this.array;
        if (i == dArr.length) {
            dArr = new double[Format$$ExternalSyntheticOutline0.m(dArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.array, 0, dArr, 0, this.size);
            this.array = dArr;
        }
        int i2 = this.size;
        this.size = i2 + 1;
        dArr[i2] = d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void ensureIndexInRange$1(int i) {
        if (i < 0 || i >= this.size) {
            PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(i, "Index:", ", Size:"), this.size);
        }
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DoubleArrayList)) {
            return super.equals(obj);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) obj;
        if (this.size != doubleArrayList.size) {
            return false;
        }
        double[] dArr = doubleArrayList.array;
        for (int i = 0; i < this.size; i++) {
            if (Double.doubleToLongBits(this.array[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        ensureIndexInRange$1(i);
        return Double.valueOf(this.array[i]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iHashLong = 1;
        for (int i = 0; i < this.size; i++) {
            iHashLong = (iHashLong * 31) + Internal.hashLong(Double.doubleToLongBits(this.array[i]));
        }
        return iHashLong;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.array[i2] == dDoubleValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.protobuf.Internal.ProtobufList
    public final DoubleArrayList mutableCopyWithCapacity(int i) {
        if (i >= this.size) {
            return new DoubleArrayList(i == 0 ? EMPTY_ARRAY : Arrays.copyOf(this.array, i), this.size, true);
        }
        Path$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        ensureIsMutable();
        ensureIndexInRange$1(i);
        double[] dArr = this.array;
        double d = dArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        ensureIsMutable();
        if (i2 < i) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m("toIndex < fromIndex");
            return;
        }
        double[] dArr = this.array;
        System.arraycopy(dArr, i2, dArr, i, this.size - i2);
        this.size -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        ensureIsMutable();
        ensureIndexInRange$1(i);
        double[] dArr = this.array;
        double d = dArr[i];
        dArr[i] = dDoubleValue;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addDouble(((Double) obj).doubleValue());
        return true;
    }
}
