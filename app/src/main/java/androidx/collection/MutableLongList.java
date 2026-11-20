package androidx.collection;

import java.util.Arrays;
import kotlin.ranges.IntRange;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableLongList {
    public int _size;
    public long[] content;

    public MutableLongList(int i) {
        this.content = i == 0 ? LongSetKt.EmptyLongArray : new long[i];
    }

    public final void add(long j) {
        int i = this._size + 1;
        long[] jArrCopyOf = this.content;
        if (jArrCopyOf.length < i) {
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, Math.max(i, (jArrCopyOf.length * 3) / 2));
            this.content = jArrCopyOf;
        }
        int i2 = this._size;
        jArrCopyOf[i2] = j;
        this._size = i2 + 1;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof MutableLongList) {
            MutableLongList mutableLongList = (MutableLongList) obj;
            int i = mutableLongList._size;
            int i2 = this._size;
            if (i == i2) {
                long[] jArr = this.content;
                long[] jArr2 = mutableLongList.content;
                IntRange intRangeUntil = UuidKt.until(0, i2);
                int i3 = intRangeUntil.first;
                int i4 = intRangeUntil.last;
                if (i3 > i4) {
                    return true;
                }
                while (jArr[i3] == jArr2[i3]) {
                    if (i3 == i4) {
                        return true;
                    }
                    i3++;
                }
                return false;
            }
        }
        return false;
    }

    public final int hashCode() {
        long[] jArr = this.content;
        int i = this._size;
        int iHashCode = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iHashCode += Long.hashCode(jArr[i2]) * 31;
        }
        return iHashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        long[] jArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            long j = jArr[i2];
            if (i2 == -1) {
                sb.append((CharSequence) "...");
                return sb.toString();
            }
            if (i2 != 0) {
                sb.append((CharSequence) ", ");
            }
            sb.append(j);
        }
        sb.append((CharSequence) "]");
        return sb.toString();
    }
}
