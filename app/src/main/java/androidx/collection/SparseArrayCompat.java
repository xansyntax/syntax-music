package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import kotlin.collections.ArraysKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SparseArrayCompat implements Cloneable {
    public /* synthetic */ boolean garbage;
    public /* synthetic */ int[] keys;
    public /* synthetic */ int size;
    public /* synthetic */ Object[] values;

    public SparseArrayCompat(int i) {
        int i2;
        int i3 = 4;
        while (true) {
            i2 = 40;
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (40 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        int i5 = i2 / 4;
        this.keys = new int[i5];
        this.values = new Object[i5];
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final SparseArrayCompat m7clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        objClone.getClass();
        SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) objClone;
        sparseArrayCompat.keys = (int[]) this.keys.clone();
        sparseArrayCompat.values = (Object[]) this.values.clone();
        return sparseArrayCompat;
    }

    public final int keyAt(int i) {
        if (this.garbage) {
            ArraySetKt.gc(this);
        }
        return this.keys[i];
    }

    public final void put(int i, Object obj) {
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.size, i, this.keys);
        if (iBinarySearch >= 0) {
            this.values[iBinarySearch] = obj;
            return;
        }
        int i2 = ~iBinarySearch;
        int i3 = this.size;
        if (i2 < i3) {
            Object[] objArr = this.values;
            if (objArr[i2] == ArraySetKt.DELETED$1) {
                this.keys[i2] = i;
                objArr[i2] = obj;
                return;
            }
        }
        if (this.garbage && i3 >= this.keys.length) {
            ArraySetKt.gc(this);
            i2 = ~ContainerHelpersKt.binarySearch(this.size, i, this.keys);
        }
        int i4 = this.size;
        if (i4 >= this.keys.length) {
            int i5 = (i4 + 1) * 4;
            for (int i6 = 4; i6 < 32; i6++) {
                int i7 = (1 << i6) - 12;
                if (i5 <= i7) {
                    i5 = i7;
                    break;
                }
            }
            int i8 = i5 / 4;
            this.keys = Arrays.copyOf(this.keys, i8);
            this.values = Arrays.copyOf(this.values, i8);
        }
        int i9 = this.size;
        if (i9 - i2 != 0) {
            int[] iArr = this.keys;
            int i10 = i2 + 1;
            ArraysKt.copyInto(i10, i2, i9, iArr, iArr);
            Object[] objArr2 = this.values;
            ArraysKt.copyInto(i10, i2, this.size, objArr2, objArr2);
        }
        this.keys[i2] = i;
        this.values[i2] = obj;
        this.size++;
    }

    public final int size() {
        if (this.garbage) {
            ArraySetKt.gc(this);
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
            if (objValueAt != this) {
                sb.append(objValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final Object valueAt(int i) {
        if (this.garbage) {
            ArraySetKt.gc(this);
        }
        Object[] objArr = this.values;
        if (i < objArr.length) {
            return objArr[i];
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
