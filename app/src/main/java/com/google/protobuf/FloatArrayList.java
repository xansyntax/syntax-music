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
public final class FloatArrayList extends AbstractProtobufList implements Internal.FloatList, RandomAccess, PrimitiveNonBoxingCollection {
    public static final float[] EMPTY_ARRAY;
    public static final FloatArrayList EMPTY_LIST;
    public float[] array;
    public int size;

    static {
        float[] fArr = new float[0];
        EMPTY_ARRAY = fArr;
        EMPTY_LIST = new FloatArrayList(fArr, 0, false);
    }

    public FloatArrayList(float[] fArr, int i, boolean z) {
        super(z);
        this.array = fArr;
        this.size = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        float fFloatValue = ((Float) obj).floatValue();
        ensureIsMutable();
        if (i < 0 || i > (i2 = this.size)) {
            PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(i, "Index:", ", Size:"), this.size);
            return;
        }
        float[] fArr = this.array;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[Format$$ExternalSyntheticOutline0.m(fArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.array, 0, fArr2, 0, i);
            System.arraycopy(this.array, i, fArr2, i + 1, this.size - i);
            this.array = fArr2;
        }
        this.array[i] = fFloatValue;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        ensureIsMutable();
        byte[] bArr = Internal.EMPTY_BYTE_ARRAY;
        collection.getClass();
        if (!(collection instanceof FloatArrayList)) {
            return super.addAll(collection);
        }
        FloatArrayList floatArrayList = (FloatArrayList) collection;
        int i = floatArrayList.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        float[] fArrCopyOf = this.array;
        if (i3 > fArrCopyOf.length) {
            fArrCopyOf = Arrays.copyOf(fArrCopyOf, i3);
            this.array = fArrCopyOf;
        }
        System.arraycopy(floatArrayList.array, 0, fArrCopyOf, this.size, floatArrayList.size);
        this.size = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void addFloat(float f) {
        ensureIsMutable();
        int i = this.size;
        float[] fArr = this.array;
        if (i == fArr.length) {
            fArr = new float[Format$$ExternalSyntheticOutline0.m(fArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.array, 0, fArr, 0, this.size);
            this.array = fArr;
        }
        int i2 = this.size;
        this.size = i2 + 1;
        fArr[i2] = f;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void ensureIndexInRange$2(int i) {
        if (i < 0 || i >= this.size) {
            PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(i, "Index:", ", Size:"), this.size);
        }
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FloatArrayList)) {
            return super.equals(obj);
        }
        FloatArrayList floatArrayList = (FloatArrayList) obj;
        if (this.size != floatArrayList.size) {
            return false;
        }
        float[] fArr = floatArrayList.array;
        for (int i = 0; i < this.size; i++) {
            if (Float.floatToIntBits(this.array[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        ensureIndexInRange$2(i);
        return Float.valueOf(this.array[i]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i = 0; i < this.size; i++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.array[i]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.array[i2] == fFloatValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.protobuf.Internal.ProtobufList
    public final FloatArrayList mutableCopyWithCapacity(int i) {
        if (i >= this.size) {
            return new FloatArrayList(i == 0 ? EMPTY_ARRAY : Arrays.copyOf(this.array, i), this.size, true);
        }
        Path$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        ensureIsMutable();
        ensureIndexInRange$2(i);
        float[] fArr = this.array;
        float f = fArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        ensureIsMutable();
        if (i2 < i) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m("toIndex < fromIndex");
            return;
        }
        float[] fArr = this.array;
        System.arraycopy(fArr, i2, fArr, i, this.size - i2);
        this.size -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        ensureIsMutable();
        ensureIndexInRange$2(i);
        float[] fArr = this.array;
        float f = fArr[i];
        fArr[i] = fFloatValue;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addFloat(((Float) obj).floatValue());
        return true;
    }
}
