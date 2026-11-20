package androidx.collection;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.ranges.IntRange;
import kotlin.uuid.UuidKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableIntList {
    public int _size;
    public int[] content;

    public MutableIntList(int i) {
        this.content = i == 0 ? IntSetKt.EmptyIntArray : new int[i];
    }

    public final void add(int i) {
        ensureCapacity(this._size + 1);
        int[] iArr = this.content;
        int i2 = this._size;
        iArr[i2] = i;
        this._size = i2 + 1;
    }

    public final void ensureCapacity(int i) {
        int[] iArr = this.content;
        if (iArr.length < i) {
            this.content = Arrays.copyOf(iArr, Math.max(i, (iArr.length * 3) / 2));
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof MutableIntList) {
            MutableIntList mutableIntList = (MutableIntList) obj;
            int i = mutableIntList._size;
            int i2 = this._size;
            if (i == i2) {
                int[] iArr = this.content;
                int[] iArr2 = mutableIntList.content;
                IntRange intRangeUntil = UuidKt.until(0, i2);
                int i3 = intRangeUntil.first;
                int i4 = intRangeUntil.last;
                if (i3 > i4) {
                    return true;
                }
                while (iArr[i3] == iArr2[i3]) {
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

    public final int get(int i) {
        if (i >= 0 && i < this._size) {
            return this.content[i];
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m("Index must be between 0 and size");
        return 0;
    }

    public final int hashCode() {
        int[] iArr = this.content;
        int i = this._size;
        int iHashCode = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iHashCode += Integer.hashCode(iArr[i2]) * 31;
        }
        return iHashCode;
    }

    public final int last() {
        int i = this._size;
        if (i != 0) {
            return this.content[i - 1];
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1("IntList is empty.");
        return 0;
    }

    public final void removeAt(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this._size)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m("Index must be between 0 and size");
            return;
        }
        int[] iArr = this.content;
        int i3 = iArr[i];
        if (i != i2 - 1) {
            ArraysKt.copyInto(i, i + 1, i2, iArr, iArr);
        }
        this._size--;
    }

    public final void set(int i, int i2) {
        if (i < 0 || i >= this._size) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m("Index must be between 0 and size");
            return;
        }
        int[] iArr = this.content;
        int i3 = iArr[i];
        iArr[i] = i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        int[] iArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            if (i2 == -1) {
                sb.append((CharSequence) "...");
                return sb.toString();
            }
            if (i2 != 0) {
                sb.append((CharSequence) ", ");
            }
            sb.append(i3);
        }
        sb.append((CharSequence) "]");
        return sb.toString();
    }

    public /* synthetic */ MutableIntList() {
        this(16);
    }
}
