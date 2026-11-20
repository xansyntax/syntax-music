package kotlin.ranges;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class LongProgressionIterator implements Iterator, KMappedMarker {
    public final long finalElement;
    public boolean hasNext;
    public long next;

    public LongProgressionIterator(long j, long j2) {
        this.finalElement = j2;
        boolean z = j <= j2;
        this.hasNext = z;
        this.next = z ? j : j2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.hasNext;
    }

    @Override // java.util.Iterator
    public final Object next() {
        long j = this.next;
        if (j != this.finalElement) {
            this.next = 1 + j;
        } else {
            if (!this.hasNext) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                return null;
            }
            this.hasNext = false;
        }
        return Long.valueOf(j);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
