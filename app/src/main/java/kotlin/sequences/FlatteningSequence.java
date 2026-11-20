package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class FlatteningSequence implements Sequence {
    public final Function1 iterator;
    public final Sequence sequence;
    public final Function1 transformer;

    /* JADX INFO: renamed from: kotlin.sequences.FlatteningSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements Iterator, KMappedMarker {
        public Iterator itemIterator;
        public final Iterator iterator;
        public byte state;

        public AnonymousClass1() {
            this.iterator = FlatteningSequence.this.sequence.iterator();
        }

        public final boolean ensureItemIterator() {
            Iterator it;
            Iterator it2 = this.itemIterator;
            if (it2 != null && it2.hasNext()) {
                this.state = (byte) 1;
                return true;
            }
            do {
                Iterator it3 = this.iterator;
                if (!it3.hasNext()) {
                    this.state = (byte) 2;
                    this.itemIterator = null;
                    return false;
                }
                Object next = it3.next();
                FlatteningSequence flatteningSequence = FlatteningSequence.this;
                it = (Iterator) flatteningSequence.iterator.invoke(flatteningSequence.transformer.invoke(next));
            } while (!it.hasNext());
            this.itemIterator = it;
            this.state = (byte) 1;
            return true;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            byte b = this.state;
            if (b == 1) {
                return true;
            }
            if (b == 2) {
                return false;
            }
            return ensureItemIterator();
        }

        @Override // java.util.Iterator
        public final Object next() {
            byte b = this.state;
            if (b == 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                return null;
            }
            if (b == 0 && !ensureItemIterator()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                return null;
            }
            this.state = (byte) 0;
            Iterator it = this.itemIterator;
            it.getClass();
            return it.next();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public FlatteningSequence(Sequence sequence, Function1 function1, Function1 function2) {
        sequence.getClass();
        this.sequence = sequence;
        this.transformer = function1;
        this.iterator = function2;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new AnonymousClass1();
    }
}
