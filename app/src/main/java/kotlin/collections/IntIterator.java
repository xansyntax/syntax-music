package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class IntIterator implements Iterator, KMappedMarker {
    public final /* synthetic */ byte $r8$classId;

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        switch (this.$r8$classId) {
            case 0:
                return Integer.valueOf(nextInt());
            default:
                return Character.valueOf(nextChar());
        }
    }

    public abstract char nextChar();

    public abstract int nextInt();

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }
}
