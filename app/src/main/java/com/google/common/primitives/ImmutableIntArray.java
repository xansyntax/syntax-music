package com.google.common.primitives;

import coil3.util.UtilsKt;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ImmutableIntArray implements Serializable {
    public static final ImmutableIntArray EMPTY = new ImmutableIntArray(new int[0]);
    public final int[] array;
    public final int end;

    public ImmutableIntArray(int[] iArr) {
        int length = iArr.length;
        this.array = iArr;
        this.end = length;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0013 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:13:0x0015 A[RETURN] */
    public final boolean contains(int i) {
        int i2 = 0;
        while (i2 < this.end) {
            if (this.array[i2] == i) {
                if (i2 >= 0) {
                    return true;
                }
                return false;
            }
            i2++;
        }
        i2 = -1;
        if (i2 >= 0) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableIntArray) {
            ImmutableIntArray immutableIntArray = (ImmutableIntArray) obj;
            int i = immutableIntArray.end;
            int i2 = this.end;
            if (i2 == i) {
                for (int i3 = 0; i3 < i2; i3++) {
                    if (get(i3) == immutableIntArray.get(i3)) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int get(int i) {
        UtilsKt.checkElementIndex(i, this.end);
        return this.array[i];
    }

    public final int hashCode() {
        int iHashCode = 1;
        for (int i = 0; i < this.end; i++) {
            iHashCode = (iHashCode * 31) + Integer.hashCode(this.array[i]);
        }
        return iHashCode;
    }

    public final String toString() {
        int i = this.end;
        if (i == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(i * 5);
        sb.append('[');
        int[] iArr = this.array;
        sb.append(iArr[0]);
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(", ");
            sb.append(iArr[i2]);
        }
        sb.append(']');
        return sb.toString();
    }
}
