package androidx.collection;

import kotlin.collections.ArraysKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class IntListKt {
    public static final MutableIntList EmptyIntList = new MutableIntList(0);

    public static final MutableIntList intListOf(int... iArr) {
        MutableIntList mutableIntList = new MutableIntList(iArr.length);
        int i = mutableIntList._size;
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m("");
            return null;
        }
        if (iArr.length == 0) {
            return mutableIntList;
        }
        mutableIntList.ensureCapacity(iArr.length + i);
        int[] iArr2 = mutableIntList.content;
        int i2 = mutableIntList._size;
        if (i != i2) {
            ArraysKt.copyInto(iArr.length + i, i, i2, iArr2, iArr2);
        }
        ArraysKt.copyInto$default(i, 0, 12, iArr, iArr2);
        mutableIntList._size += iArr.length;
        return mutableIntList;
    }
}
