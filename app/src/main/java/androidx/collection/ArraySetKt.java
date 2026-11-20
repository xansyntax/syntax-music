package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ArraySetKt {
    public static final Object DELETED = new Object();
    public static final long[] EmptyNodes = new long[0];
    public static final Object DELETED$1 = new Object();

    public static final Object commonGet(SparseArrayCompat sparseArrayCompat, int i) {
        Object obj;
        sparseArrayCompat.getClass();
        int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.size, i, sparseArrayCompat.keys);
        if (iBinarySearch < 0 || (obj = sparseArrayCompat.values[iBinarySearch]) == DELETED$1) {
            return null;
        }
        return obj;
    }

    public static final void gc(SparseArrayCompat sparseArrayCompat) {
        int i = sparseArrayCompat.size;
        int[] iArr = sparseArrayCompat.keys;
        Object[] objArr = sparseArrayCompat.values;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != DELETED$1) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        sparseArrayCompat.garbage = false;
        sparseArrayCompat.size = i2;
    }

    public static final int indexOf(ArraySet arraySet, Object obj, int i) {
        int i2 = arraySet._size;
        if (i2 == 0) {
            return -1;
        }
        try {
            int iBinarySearch = ContainerHelpersKt.binarySearch(i2, i, arraySet.hashes);
            if (iBinarySearch < 0 || Intrinsics.areEqual(obj, arraySet.array[iBinarySearch])) {
                return iBinarySearch;
            }
            int i3 = iBinarySearch + 1;
            while (i3 < i2 && arraySet.hashes[i3] == i) {
                if (Intrinsics.areEqual(obj, arraySet.array[i3])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = iBinarySearch - 1; i4 >= 0 && arraySet.hashes[i4] == i; i4--) {
                if (Intrinsics.areEqual(obj, arraySet.array[i4])) {
                    return i4;
                }
            }
            return ~i3;
        } catch (IndexOutOfBoundsException unused) {
            MarqueeSpacing$Companion$$ExternalSyntheticLambda0.m52m();
            return 0;
        }
    }
}
