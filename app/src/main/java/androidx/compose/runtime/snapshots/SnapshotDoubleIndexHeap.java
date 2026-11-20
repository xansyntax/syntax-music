package androidx.compose.runtime.snapshots;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.content.res.CamUtils;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okio.PriorityQueue;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotDoubleIndexHeap {
    public int firstFreeHandle;
    public Object handles;
    public int[] index;
    public int size;
    public Object values;

    public int add(long j) {
        int i = this.size + 1;
        long[] jArr = (long[]) this.values;
        int length = jArr.length;
        if (i > length) {
            int i2 = length * 2;
            long[] jArr2 = new long[i2];
            int[] iArr = new int[i2];
            ArraysKt.copyInto(jArr, jArr2, 0, 0, jArr.length);
            ArraysKt.copyInto$default(0, 0, 14, this.index, iArr);
            this.values = jArr2;
            this.index = iArr;
        }
        int i3 = this.size;
        this.size = i3 + 1;
        int[] iArr2 = (int[]) this.handles;
        int length2 = iArr2.length;
        if (this.firstFreeHandle >= length2) {
            int i4 = length2 * 2;
            iArr2 = new int[i4];
            int i5 = 0;
            while (i5 < i4) {
                int i6 = i5 + 1;
                iArr2[i5] = i6;
                i5 = i6;
            }
            ArraysKt.copyInto$default(0, 0, 14, (int[]) this.handles, iArr2);
            this.handles = iArr2;
        }
        int[] iArr3 = iArr2;
        int i7 = this.firstFreeHandle;
        this.firstFreeHandle = iArr2[i7];
        long[] jArr3 = (long[]) this.values;
        jArr3[i3] = j;
        this.index[i3] = i7;
        iArr3[i7] = i3;
        while (i3 > 0) {
            int i8 = ((i3 + 1) >> 1) - 1;
            if (Intrinsics.compare(jArr3[i8], j) <= 0) {
                break;
            }
            swap(i8, i3);
            i3 = i8;
        }
        return i7;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0041  */
    public PriorityQueue getNamedComplexColor(TypedArray typedArray, Resources.Theme theme, String str, int i) {
        PriorityQueue priorityQueue;
        byte b = 4;
        Object obj = null;
        int i2 = 0;
        if (CamUtils.hasAttribute((XmlPullParser) this.values, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            int i3 = typedValue.type;
            if (i3 < 28 || i3 > 31) {
                try {
                    priorityQueue = PriorityQueue.createFromXml(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
                } catch (Exception e) {
                    Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
                    priorityQueue = null;
                }
                if (priorityQueue == null) {
                    priorityQueue = new PriorityQueue(obj, i2, b);
                }
            } else {
                priorityQueue = new PriorityQueue(obj, typedValue.data, b);
            }
        } else {
            priorityQueue = new PriorityQueue(obj, i2, b);
        }
        updateConfig(typedArray.getChangingConfigurations());
        return priorityQueue;
    }

    public float getNamedFloat(TypedArray typedArray, String str, int i, float f) {
        if (CamUtils.hasAttribute((XmlPullParser) this.values, str)) {
            f = typedArray.getFloat(i, f);
        }
        updateConfig(typedArray.getChangingConfigurations());
        return f;
    }

    public void swap(int i, int i2) {
        long[] jArr = (long[]) this.values;
        int[] iArr = this.index;
        int[] iArr2 = (int[]) this.handles;
        long j = jArr[i];
        jArr[i] = jArr[i2];
        jArr[i2] = j;
        int i3 = iArr[i];
        int i4 = iArr[i2];
        iArr[i] = i4;
        iArr[i2] = i3;
        iArr2[i4] = i;
        iArr2[i3] = i2;
    }

    public void updateConfig(int i) {
        this.size = i | this.size;
    }
}
