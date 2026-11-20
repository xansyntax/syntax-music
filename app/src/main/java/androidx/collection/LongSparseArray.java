package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LongSparseArray implements Cloneable {
    public /* synthetic */ boolean garbage;
    public /* synthetic */ long[] keys;
    public /* synthetic */ int size;
    public /* synthetic */ Object[] values;

    public LongSparseArray(int i) {
        if (i == 0) {
            this.keys = ContainerHelpersKt.EMPTY_LONGS;
            this.values = ContainerHelpersKt.EMPTY_OBJECTS;
            return;
        }
        int i2 = i * 8;
        for (int i3 = 4; i3 < 32; i3++) {
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                i2 = i4;
                break;
            }
        }
        int i5 = i2 / 8;
        this.keys = new long[i5];
        this.values = new Object[i5];
    }

    public final void clear() {
        int i = this.size;
        Object[] objArr = this.values;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.size = 0;
        this.garbage = false;
    }

    public final Object clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        objClone.getClass();
        LongSparseArray longSparseArray = (LongSparseArray) objClone;
        longSparseArray.keys = (long[]) this.keys.clone();
        longSparseArray.values = (Object[]) this.values.clone();
        return longSparseArray;
    }

    public final Object get(long j) {
        Object obj;
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j);
        if (iBinarySearch < 0 || (obj = this.values[iBinarySearch]) == ArraySetKt.DELETED) {
            return null;
        }
        return obj;
    }

    public final long keyAt(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.size)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i, "Expected index to be within 0..size()-1, but was "));
            return 0L;
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != ArraySetKt.DELETED) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.garbage = false;
            this.size = i3;
        }
        return this.keys[i];
    }

    public final void put(long j, Object obj) {
        Object obj2 = ArraySetKt.DELETED;
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j);
        if (iBinarySearch >= 0) {
            this.values[iBinarySearch] = obj;
            return;
        }
        int i = ~iBinarySearch;
        int i2 = this.size;
        if (i < i2) {
            Object[] objArr = this.values;
            if (objArr[i] == obj2) {
                this.keys[i] = j;
                objArr[i] = obj;
                return;
            }
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            if (i2 >= jArr.length) {
                Object[] objArr2 = this.values;
                int i3 = 0;
                for (int i4 = 0; i4 < i2; i4++) {
                    Object obj3 = objArr2[i4];
                    if (obj3 != obj2) {
                        if (i4 != i3) {
                            jArr[i3] = jArr[i4];
                            objArr2[i3] = obj3;
                            objArr2[i4] = null;
                        }
                        i3++;
                    }
                }
                this.garbage = false;
                this.size = i3;
                i = ~ContainerHelpersKt.binarySearch(this.keys, i3, j);
            }
        }
        int i5 = this.size;
        if (i5 >= this.keys.length) {
            int i6 = (i5 + 1) * 8;
            for (int i7 = 4; i7 < 32; i7++) {
                int i8 = (1 << i7) - 12;
                if (i6 <= i8) {
                    i6 = i8;
                    break;
                }
            }
            int i9 = i6 / 8;
            this.keys = Arrays.copyOf(this.keys, i9);
            this.values = Arrays.copyOf(this.values, i9);
        }
        int i10 = this.size;
        if (i10 - i != 0) {
            long[] jArr2 = this.keys;
            int i11 = i + 1;
            ArraysKt.copyInto(jArr2, jArr2, i11, i, i10);
            Object[] objArr3 = this.values;
            ArraysKt.copyInto(i11, i, this.size, objArr3, objArr3);
        }
        this.keys[i] = j;
        this.values[i] = obj;
        this.size++;
    }

    public final void remove(long j) {
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j);
        if (iBinarySearch >= 0) {
            Object[] objArr = this.values;
            Object obj = objArr[iBinarySearch];
            Object obj2 = ArraySetKt.DELETED;
            if (obj != obj2) {
                objArr[iBinarySearch] = obj2;
                this.garbage = true;
            }
        }
    }

    public final int size() {
        if (this.garbage) {
            int i = this.size;
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (obj != ArraySetKt.DELETED) {
                    if (i3 != i2) {
                        jArr[i2] = jArr[i3];
                        objArr[i2] = obj;
                        objArr[i3] = null;
                    }
                    i2++;
                }
            }
            this.garbage = false;
            this.size = i2;
        }
        return this.size;
    }

    public final String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 28);
        sb.append('{');
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(i2));
            sb.append('=');
            Object objValueAt = valueAt(i2);
            if (objValueAt != sb) {
                sb.append(objValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final Object valueAt(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.size)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i, "Expected index to be within 0..size()-1, but was "));
            return null;
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != ArraySetKt.DELETED) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.garbage = false;
            this.size = i3;
        }
        return this.values[i];
    }

    public /* synthetic */ LongSparseArray() {
        this(10);
    }
}
