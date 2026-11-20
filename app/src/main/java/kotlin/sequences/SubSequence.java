package kotlin.sequences;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.MutableOrderedSetWrapper;
import androidx.collection.MutableOrderedSetWrapper$iterator$1$iterator$1;
import androidx.collection.MutableSetWrapper;
import androidx.collection.MutableSetWrapper$iterator$1$iterator$1;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.Links;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import dagger.hilt.EntryPoints;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class SubSequence implements Sequence, DropTakeSequence {
    public final int endIndex;
    public final Sequence sequence;
    public final int startIndex;

    public SubSequence(Sequence sequence, int i, int i2) {
        sequence.getClass();
        this.sequence = sequence;
        this.startIndex = i;
        this.endIndex = i2;
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "startIndex should be non-negative, but is "));
            throw null;
        }
        if (i2 < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i2, "endIndex should be non-negative, but is "));
            throw null;
        }
        if (i2 >= i) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Fragment$5$$ExternalSyntheticOutline0.m(i2, i, "endIndex should be not less than startIndex, but was ", " < "));
        throw null;
    }

    @Override // kotlin.sequences.DropTakeSequence
    public final Sequence drop(int i) {
        int i2 = this.endIndex;
        int i3 = this.startIndex;
        return i >= i2 - i3 ? EmptySequence.INSTANCE : new SubSequence(this.sequence, i3 + i, i2);
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new AnonymousClass1(this);
    }

    @Override // kotlin.sequences.DropTakeSequence
    public final Sequence take(int i) {
        int i2 = this.endIndex;
        int i3 = this.startIndex;
        return i >= i2 - i3 ? this : new SubSequence(this.sequence, i3, i + i3);
    }

    /* JADX INFO: renamed from: kotlin.sequences.SubSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public class AnonymousClass1 implements Iterator, KMappedMarker {
        public final /* synthetic */ byte $r8$classId;
        public Object iterator;
        public int position;
        public final Object this$0;

        public AnonymousClass1(MutableSetWrapper mutableSetWrapper) {
            this.$r8$classId = (byte) 2;
            this.this$0 = mutableSetWrapper;
            this.position = -1;
            this.iterator = EntryPoints.iterator(new MutableSetWrapper$iterator$1$iterator$1(mutableSetWrapper, this, null));
        }

        public void calcNext$1() {
            Object objInvoke;
            int i = this.position;
            GeneratorSequence generatorSequence = (GeneratorSequence) this.this$0;
            if (i == -2) {
                objInvoke = ((Function0) generatorSequence.getInitialValue).invoke();
            } else {
                Function1 function1 = (Function1) generatorSequence.getNextValue;
                Object obj = this.iterator;
                obj.getClass();
                objInvoke = function1.invoke(obj);
            }
            this.iterator = objInvoke;
            this.position = objInvoke == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            byte b = this.$r8$classId;
            Object obj = this.this$0;
            switch (b) {
                case 0:
                    SubSequence subSequence = (SubSequence) obj;
                    Iterator it = (Iterator) this.iterator;
                    while (this.position < subSequence.startIndex && it.hasNext()) {
                        it.next();
                        this.position++;
                    }
                    return this.position < subSequence.endIndex && it.hasNext();
                case 1:
                    return ((SequenceBuilderIterator) this.iterator).hasNext();
                case 2:
                    return ((SequenceBuilderIterator) this.iterator).hasNext();
                case 3:
                    return this.position < ((Map) obj).size();
                case 4:
                    if (this.position < 0) {
                        calcNext$1();
                    }
                    return this.position == 1;
                default:
                    return ((Iterator) this.iterator).hasNext();
            }
        }

        @Override // java.util.Iterator
        public Object next() {
            byte b = this.$r8$classId;
            Object obj = this.this$0;
            Object obj2 = null;
            switch (b) {
                case 0:
                    SubSequence subSequence = (SubSequence) obj;
                    Iterator it = (Iterator) this.iterator;
                    while (this.position < subSequence.startIndex && it.hasNext()) {
                        it.next();
                        this.position++;
                    }
                    int i = this.position;
                    if (i < subSequence.endIndex) {
                        this.position = i + 1;
                        return it.next();
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                    return null;
                case 1:
                    return ((SequenceBuilderIterator) this.iterator).next();
                case 2:
                    return ((SequenceBuilderIterator) this.iterator).next();
                case 3:
                    if (hasNext()) {
                        obj2 = this.iterator;
                        this.position++;
                        Object obj3 = ((Map) obj).get(obj2);
                        if (obj3 == null) {
                            throw new ConcurrentModificationException("Hash code of an element (" + obj2 + ") has changed after it was added to the persistent set.");
                        }
                        this.iterator = ((Links) obj3).next;
                    } else {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                    }
                    return obj2;
                case 4:
                    if (this.position < 0) {
                        calcNext$1();
                    }
                    if (this.position == 0) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                        return null;
                    }
                    Object obj4 = this.iterator;
                    obj4.getClass();
                    this.position = -1;
                    return obj4;
                default:
                    Function2 function2 = (Function2) ((GeneratorSequence) obj).getNextValue;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    if (i2 >= 0) {
                        return function2.invoke(Integer.valueOf(i2), ((Iterator) this.iterator).next());
                    }
                    CollectionsKt__IterablesKt.throwIndexOverflow();
                    throw null;
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            byte b = this.$r8$classId;
            Object obj = this.this$0;
            switch (b) {
                case 0:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                case 1:
                    int i = this.position;
                    if (i != -1) {
                        ((MutableOrderedSetWrapper) obj).parent.removeElementAt(i);
                        this.position = -1;
                        return;
                    }
                    return;
                case 2:
                    int i2 = this.position;
                    if (i2 != -1) {
                        ((MutableSetWrapper) obj).parent.removeElementAt(i2);
                        this.position = -1;
                        return;
                    }
                    return;
                case 3:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                case 4:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                default:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        public AnonymousClass1(GeneratorSequence generatorSequence, byte b) {
            this.$r8$classId = (byte) 5;
            this.this$0 = generatorSequence;
            this.iterator = new FilteringSequence.AnonymousClass1((GeneratorSequence) generatorSequence.getInitialValue);
        }

        public AnonymousClass1(SubSequence subSequence) {
            this.$r8$classId = (byte) 0;
            this.this$0 = subSequence;
            this.iterator = subSequence.sequence.iterator();
        }

        public AnonymousClass1(GeneratorSequence generatorSequence) {
            this.$r8$classId = (byte) 4;
            this.this$0 = generatorSequence;
            this.position = -2;
        }

        public AnonymousClass1(Map map, Object obj) {
            this.$r8$classId = (byte) 3;
            this.iterator = obj;
            this.this$0 = map;
        }

        public AnonymousClass1(MutableOrderedSetWrapper mutableOrderedSetWrapper) {
            this.$r8$classId = (byte) 1;
            this.this$0 = mutableOrderedSetWrapper;
            this.position = -1;
            this.iterator = EntryPoints.iterator(new MutableOrderedSetWrapper$iterator$1$iterator$1(mutableOrderedSetWrapper, this, null));
        }
    }
}
