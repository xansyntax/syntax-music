package androidx.media3.common.util;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LongArray {
    public final /* synthetic */ byte $r8$classId = 1;
    public int size;
    public long[] values;

    public LongArray(int i) {
        this.values = new long[i];
    }

    public final void add(long j) {
        switch (this.$r8$classId) {
            case 0:
                int i = this.size;
                long[] jArrCopyOf = this.values;
                if (i == jArrCopyOf.length) {
                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i * 2);
                    this.values = jArrCopyOf;
                }
                int i2 = this.size;
                this.size = i2 + 1;
                jArrCopyOf[i2] = j;
                break;
            default:
                if (!contains(j)) {
                    int i3 = this.size;
                    long[] jArrCopyOf2 = this.values;
                    if (i3 >= jArrCopyOf2.length) {
                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, Math.max(i3 + 1, jArrCopyOf2.length * 2));
                        this.values = jArrCopyOf2;
                    }
                    jArrCopyOf2[i3] = j;
                    if (i3 >= this.size) {
                        this.size = i3 + 1;
                    }
                }
                break;
        }
    }

    public void addAll(long[] jArr) {
        int length = this.size + jArr.length;
        long[] jArrCopyOf = this.values;
        if (length > jArrCopyOf.length) {
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, Math.max(jArrCopyOf.length * 2, length));
            this.values = jArrCopyOf;
        }
        System.arraycopy(jArr, 0, jArrCopyOf, this.size, jArr.length);
        this.size = length;
    }

    public boolean contains(long j) {
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.values[i2] == j) {
                return true;
            }
        }
        return false;
    }

    public long get(int i) {
        if (i >= 0 && i < this.size) {
            return this.values[i];
        }
        PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(i, "Invalid index ", ", size is "), this.size);
        return 0L;
    }

    public void remove(long j) {
        int i = this.size;
        int i2 = 0;
        while (i2 < i) {
            if (j == this.values[i2]) {
                int i3 = this.size - 1;
                while (i2 < i3) {
                    long[] jArr = this.values;
                    int i4 = i2 + 1;
                    jArr[i2] = jArr[i4];
                    i2 = i4;
                }
                this.size--;
                return;
            }
            i2++;
        }
    }

    public /* synthetic */ LongArray() {
    }
}
