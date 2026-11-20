package kotlin.ranges;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.uuid.UuidKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public class IntProgression implements Iterable, KMappedMarker {
    public final int first;
    public final int last;
    public final int step;

    public IntProgression(int i, int i2, int i3) {
        if (i3 == 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Step must be non-zero.");
            throw null;
        }
        if (i3 == Integer.MIN_VALUE) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            throw null;
        }
        this.first = i;
        this.last = UuidKt.getProgressionLastElement(i, i2, i3);
        this.step = i3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IntProgression)) {
            return false;
        }
        if (isEmpty() && ((IntProgression) obj).isEmpty()) {
            return true;
        }
        IntProgression intProgression = (IntProgression) obj;
        return this.first == intProgression.first && this.last == intProgression.last && this.step == intProgression.step;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.first * 31) + this.last) * 31) + this.step;
    }

    public boolean isEmpty() {
        int i = this.last;
        int i2 = this.step;
        int i3 = this.first;
        if (i2 > 0) {
            return i3 > i;
        }
        return i3 < i;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new IntProgressionIterator(this.first, this.last, this.step);
    }

    public String toString() {
        StringBuilder sb;
        int i = this.last;
        int i2 = this.step;
        int i3 = this.first;
        if (i2 > 0) {
            sb = new StringBuilder();
            sb.append(i3);
            sb.append("..");
            sb.append(i);
            sb.append(" step ");
            sb.append(i2);
        } else {
            sb = new StringBuilder();
            sb.append(i3);
            sb.append(" downTo ");
            sb.append(i);
            sb.append(" step ");
            sb.append(-i2);
        }
        return sb.toString();
    }
}
