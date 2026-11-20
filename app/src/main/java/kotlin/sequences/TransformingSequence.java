package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class TransformingSequence implements Sequence {
    public final Sequence sequence;
    public final Function1 transformer;

    /* JADX INFO: renamed from: kotlin.sequences.TransformingSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements Iterator, KMappedMarker {
        public final Iterator iterator;

        public AnonymousClass1() {
            this.iterator = TransformingSequence.this.sequence.iterator();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            return TransformingSequence.this.transformer.invoke(this.iterator.next());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public TransformingSequence(Sequence sequence, Function1 function1) {
        sequence.getClass();
        this.sequence = sequence;
        this.transformer = function1;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new AnonymousClass1();
    }
}
