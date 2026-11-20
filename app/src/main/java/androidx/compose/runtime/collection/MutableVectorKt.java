package androidx.compose.runtime.collection;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MutableVectorKt {
    public static final void checkIndex(int i, List list) {
        int size = list.size();
        if (i < 0 || i >= size) {
            throwListIndexOutOfBoundsException(i, size);
        }
    }

    public static final void checkSubIndex(int i, int i2, List list) {
        if (i > i2) {
            throwReversedIndicesException(i, i2);
        }
        if (i < 0) {
            throwNegativeIndexException(i);
        }
        if (i2 > list.size()) {
            throwOutOfRangeException(i2, list.size());
        }
    }

    private static final void throwListIndexOutOfBoundsException(int i, int i2) {
        throw new IndexOutOfBoundsException(IntIntPair$$ExternalSyntheticOutline0.m(i, "Index ", " is out of bounds. The list has ", i2, " elements."));
    }

    private static final void throwNegativeIndexException(int i) {
        throw new IndexOutOfBoundsException(IntIntPair$$ExternalSyntheticOutline0.m(i, "fromIndex (", ") is less than 0."));
    }

    private static final void throwOutOfRangeException(int i, int i2) {
        throw new IndexOutOfBoundsException(IntIntPair$$ExternalSyntheticOutline0.m(i, "toIndex (", ") is more than than the list size (", i2, ")"));
    }

    private static final void throwReversedIndicesException(int i, int i2) {
        throw new IllegalArgumentException(IntIntPair$$ExternalSyntheticOutline0.m(i, "Indices are out of order. fromIndex (", ") is greater than toIndex (", i2, ")."));
    }
}
