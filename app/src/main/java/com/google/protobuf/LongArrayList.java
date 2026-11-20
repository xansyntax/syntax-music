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
public final class LongArrayList extends AbstractProtobufList implements Internal.LongList, RandomAccess, PrimitiveNonBoxingCollection {
    public static final long[] EMPTY_ARRAY;
    public static final LongArrayList EMPTY_LIST;
    public long[] array;
    public int size;

    static {
        long[] jArr = new long[0];
        EMPTY_ARRAY = jArr;
        EMPTY_LIST = new LongArrayList(jArr, 0, false);
    }

    public LongArrayList(long[] jArr, int i, boolean z) {
        super(z);
        this.array = jArr;
        this.size = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        long jLongValue = ((Long) obj).longValue();
        ensureIsMutable();
        if (i < 0 || i > (i2 = this.size)) {
            PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(i, "Index:", ", Size:"), this.size);
            return;
        }
        long[] jArr = this.array;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[Format$$ExternalSyntheticOutline0.m(jArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.array, 0, jArr2, 0, i);
            System.arraycopy(this.array, i, jArr2, i + 1, this.size - i);
            this.array = jArr2;
        }
        this.array[i] = jLongValue;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        ensureIsMutable();
        byte[] bArr = Internal.EMPTY_BYTE_ARRAY;
        collection.getClass();
        if (!(collection instanceof LongArrayList)) {
            return super.addAll(collection);
        }
        LongArrayList longArrayList = (LongArrayList) collection;
        int i = longArrayList.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        long[] jArrCopyOf = this.array;
        if (i3 > jArrCopyOf.length) {
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, i3);
            this.array = jArrCopyOf;
        }
        System.arraycopy(longArrayList.array, 0, jArrCopyOf, this.size, longArrayList.size);
        this.size = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void addLong(long j) {
        ensureIsMutable();
        int i = this.size;
        long[] jArr = this.array;
        if (i == jArr.length) {
            jArr = new long[Format$$ExternalSyntheticOutline0.m(jArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.array, 0, jArr, 0, this.size);
            this.array = jArr;
        }
        int i2 = this.size;
        this.size = i2 + 1;
        jArr[i2] = j;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void ensureIndexInRange$4(int i) {
        if (i < 0 || i >= this.size) {
            PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(i, "Index:", ", Size:"), this.size);
        }
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LongArrayList)) {
            return super.equals(obj);
        }
        LongArrayList longArrayList = (LongArrayList) obj;
        if (this.size != longArrayList.size) {
            return false;
        }
        long[] jArr = longArrayList.array;
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    public final long getLong(int i) {
        ensureIndexInRange$4(i);
        return this.array[i];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iHashLong = 1;
        for (int i = 0; i < this.size; i++) {
            iHashLong = (iHashLong * 31) + Internal.hashLong(this.array[i]);
        }
        return iHashLong;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.array[i2] == jLongValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.protobuf.Internal.ProtobufList
    public final LongArrayList mutableCopyWithCapacity(int i) {
        if (i >= this.size) {
            return new LongArrayList(i == 0 ? EMPTY_ARRAY : Arrays.copyOf(this.array, i), this.size, true);
        }
        Path$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        ensureIsMutable();
        ensureIndexInRange$4(i);
        long[] jArr = this.array;
        long j = jArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        ensureIsMutable();
        if (i2 < i) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m("toIndex < fromIndex");
            return;
        }
        long[] jArr = this.array;
        System.arraycopy(jArr, i2, jArr, i, this.size - i2);
        this.size -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        ensureIsMutable();
        ensureIndexInRange$4(i);
        long[] jArr = this.array;
        long j = jArr[i];
        jArr[i] = jLongValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLong(((Long) obj).longValue());
        return true;
    }
}
