package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.DropSequence;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class IndexingIterator implements Iterator, KMappedMarker {
    public final /* synthetic */ byte $r8$classId = 0;
    public int index;
    public final Iterator iterator;

    public IndexingIterator(DropSequence dropSequence, byte b) {
        this.index = dropSequence.count;
        this.iterator = dropSequence.sequence.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        byte b = this.$r8$classId;
        Iterator it = this.iterator;
        switch (b) {
            case 0:
                return it.hasNext();
            case 1:
                break;
            default:
                return this.index > 0 && it.hasNext();
        }
        while (this.index > 0 && it.hasNext()) {
            it.next();
            this.index--;
        }
        return it.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        byte b = this.$r8$classId;
        Iterator it = this.iterator;
        switch (b) {
            case 0:
                int i = this.index;
                this.index = i + 1;
                if (i >= 0) {
                    return new IndexedValue(i, it.next());
                }
                CollectionsKt__IterablesKt.throwIndexOverflow();
                throw null;
            case 1:
                break;
            default:
                int i2 = this.index;
                if (i2 != 0) {
                    this.index = i2 - 1;
                    return it.next();
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                return null;
        }
        while (this.index > 0 && it.hasNext()) {
            it.next();
            this.index--;
        }
        return it.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public IndexingIterator(Iterator it) {
        it.getClass();
        this.iterator = it;
    }

    public IndexingIterator(DropSequence dropSequence) {
        this.iterator = dropSequence.sequence.iterator();
        this.index = dropSequence.count;
    }
}
