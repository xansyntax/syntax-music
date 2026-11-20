package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class FilteringSequence implements Sequence {
    public final Function1 predicate;
    public final boolean sendWhen;
    public final Sequence sequence;

    public FilteringSequence(Sequence sequence, boolean z, Function1 function1) {
        this.sequence = sequence;
        this.sendWhen = z;
        this.predicate = function1;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new AnonymousClass1(this);
    }

    /* JADX INFO: renamed from: kotlin.sequences.FilteringSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements Iterator, KMappedMarker {
        public final Iterator iterator;
        public Object nextItem;
        public final /* synthetic */ Sequence this$0;
        public final /* synthetic */ byte $r8$classId = 0;
        public int nextState = -1;

        public AnonymousClass1(GeneratorSequence generatorSequence) {
            this.this$0 = generatorSequence;
            this.iterator = ((Sequence) generatorSequence.getInitialValue).iterator();
        }

        public void calcNext() {
            Object next;
            FilteringSequence filteringSequence = (FilteringSequence) this.this$0;
            do {
                Iterator it = this.iterator;
                if (!it.hasNext()) {
                    this.nextState = 0;
                    return;
                }
                next = it.next();
            } while (((Boolean) filteringSequence.predicate.invoke(next)).booleanValue() != filteringSequence.sendWhen);
            this.nextItem = next;
            this.nextState = 1;
        }

        public void calcNext$2() {
            Iterator it = this.iterator;
            if (it.hasNext()) {
                Object next = it.next();
                if (((Boolean) ((Function1) ((GeneratorSequence) this.this$0).getNextValue).invoke(next)).booleanValue()) {
                    this.nextState = 1;
                    this.nextItem = next;
                    return;
                }
            }
            this.nextState = 0;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            switch (this.$r8$classId) {
                case 0:
                    if (this.nextState == -1) {
                        calcNext();
                    }
                    return this.nextState == 1;
                default:
                    if (this.nextState == -1) {
                        calcNext$2();
                    }
                    return this.nextState == 1;
            }
        }

        @Override // java.util.Iterator
        public final Object next() {
            switch (this.$r8$classId) {
                case 0:
                    if (this.nextState == -1) {
                        calcNext();
                    }
                    if (this.nextState == 0) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                        return null;
                    }
                    Object obj = this.nextItem;
                    this.nextItem = null;
                    this.nextState = -1;
                    return obj;
                default:
                    if (this.nextState == -1) {
                        calcNext$2();
                    }
                    if (this.nextState == 0) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                        return null;
                    }
                    Object obj2 = this.nextItem;
                    this.nextItem = null;
                    this.nextState = -1;
                    return obj2;
            }
        }

        @Override // java.util.Iterator
        public final void remove() {
            switch (this.$r8$classId) {
                case 0:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                default:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        public AnonymousClass1(FilteringSequence filteringSequence) {
            this.this$0 = filteringSequence;
            this.iterator = filteringSequence.sequence.iterator();
        }
    }
}
