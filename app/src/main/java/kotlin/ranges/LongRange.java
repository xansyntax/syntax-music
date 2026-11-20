package kotlin.ranges;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LongRange implements Iterable, KMappedMarker {
    public static final LongRange EMPTY = new LongRange(1, 0);
    public final long first;
    public final long last;

    public LongRange(long j, long j2) {
        this.first = j;
        if (j < j2) {
            long j3 = j2 % 1;
            long j4 = j % 1;
            long j5 = ((j3 < 0 ? j3 + 1 : j3) - (j4 < 0 ? j4 + 1 : j4)) % 1;
            j2 -= j5 < 0 ? j5 + 1 : j5;
        }
        this.last = j2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LongRange)) {
            return false;
        }
        if (isEmpty() && ((LongRange) obj).isEmpty()) {
            return true;
        }
        LongRange longRange = (LongRange) obj;
        return this.first == longRange.first && this.last == longRange.last;
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return Long.hashCode(this.last) + (Long.hashCode(this.first) * 31);
    }

    public final boolean isEmpty() {
        return this.first > this.last;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new LongProgressionIterator(this.first, this.last);
    }

    public final String toString() {
        return this.first + ".." + this.last;
    }
}
