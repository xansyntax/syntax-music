package androidx.collection;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FloatSetKt {
    public static final float[] EmptyFloatArray;

    static {
        long[] jArr = ScatterMapKt.EmptyGroup;
        int iUnloadedCapacity = ScatterMapKt.unloadedCapacity(0);
        int iMax = iUnloadedCapacity > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(iUnloadedCapacity)) : 0;
        if (iMax != 0) {
            int i = ((iMax + 15) & (-8)) >> 3;
            long[] jArr2 = new long[i];
            Arrays.fill(jArr2, 0, i, -9187201950435737472L);
            jArr = jArr2;
        }
        int i2 = iMax >> 3;
        long j = 255 << ((iMax & 7) << 3);
        jArr[i2] = (jArr[i2] & (~j)) | j;
        float[] fArr = new float[iMax];
        EmptyFloatArray = new float[0];
    }
}
