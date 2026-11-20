package androidx.collection;

import java.util.List;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ObjectListKt {
    public static final Object[] EmptyArray = new Object[0];
    public static final MutableObjectList EmptyObjectList = new MutableObjectList(0);

    public static final void checkIndex(int i, List list) {
        int size = list.size();
        if (i < 0 || i >= size) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(IntIntPair$$ExternalSyntheticOutline0.m(i, "Index ", " is out of bounds. The list has ", size, " elements."));
        }
    }

    public static final void checkSubIndex(int i, int i2, List list) {
        int size = list.size();
        if (i > i2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i, "Indices are out of order. fromIndex (", ") is greater than toIndex (", i2, ")."));
            return;
        }
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(IntIntPair$$ExternalSyntheticOutline0.m(i, "fromIndex (", ") is less than 0."));
            return;
        }
        if (i2 <= size) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is more than than the list size (" + size + ')');
    }
}
