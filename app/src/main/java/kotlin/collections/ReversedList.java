package kotlin.collections;

import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.runtime.snapshots.SubList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ReversedList extends AbstractMutableList {
    public final List delegate;

    public ReversedList(List list) {
        list.getClass();
        this.delegate = list;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        this.delegate.add(CollectionsKt.reversePositionIndex$CollectionsKt__ReversedViewsKt(i, this), obj);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.delegate.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.delegate.get(CollectionsKt.reverseElementIndex$CollectionsKt__ReversedViewsKt(i, this));
    }

    @Override // kotlin.collections.AbstractMutableList
    public final int getSize() {
        return this.delegate.size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new AnonymousClass1(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return new AnonymousClass1(this, 0);
    }

    @Override // kotlin.collections.AbstractMutableList
    public final Object removeAt(int i) {
        return this.delegate.remove(CollectionsKt.reverseElementIndex$CollectionsKt__ReversedViewsKt(i, this));
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        return this.delegate.set(CollectionsKt.reverseElementIndex$CollectionsKt__ReversedViewsKt(i, this), obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new AnonymousClass1(this, i);
    }

    /* JADX INFO: renamed from: kotlin.collections.ReversedList$listIterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass1 implements ListIterator, KMappedMarker {
        public final /* synthetic */ byte $r8$classId = 0;
        public final Object delegateIterator;
        public final /* synthetic */ Object this$0;

        public AnonymousClass1(ReversedListReadOnly reversedListReadOnly, int i) {
            this.this$0 = reversedListReadOnly;
            this.delegateIterator = ((List) reversedListReadOnly.delegate).listIterator(CollectionsKt.reversePositionIndex$CollectionsKt__ReversedViewsKt(i, reversedListReadOnly));
        }

        @Override // java.util.ListIterator
        public final void add(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    ListIterator listIterator = (ListIterator) this.delegateIterator;
                    listIterator.add(obj);
                    listIterator.previous();
                    return;
                case 1:
                    throw new IllegalStateException("Cannot modify a state list through an iterator");
                default:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            byte b = this.$r8$classId;
            Object obj = this.delegateIterator;
            switch (b) {
                case 0:
                    return ((ListIterator) obj).hasPrevious();
                case 1:
                    return ((Ref$IntRef) obj).element < ((SubList) this.this$0).size - 1;
                default:
                    return ((ListIterator) obj).hasPrevious();
            }
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            byte b = this.$r8$classId;
            Object obj = this.delegateIterator;
            switch (b) {
                case 0:
                    return ((ListIterator) obj).hasNext();
                case 1:
                    return ((Ref$IntRef) obj).element >= 0;
                default:
                    return ((ListIterator) obj).hasNext();
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final Object next() {
            byte b = this.$r8$classId;
            Object obj = this.delegateIterator;
            switch (b) {
                case 0:
                    return ((ListIterator) obj).previous();
                case 1:
                    Ref$IntRef ref$IntRef = (Ref$IntRef) obj;
                    int i = ref$IntRef.element + 1;
                    SubList subList = (SubList) this.this$0;
                    SnapshotId_jvmKt.validateRange(i, subList.size);
                    ref$IntRef.element = i;
                    return subList.get(i);
                default:
                    return ((ListIterator) obj).previous();
            }
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            int iPreviousIndex;
            int size;
            byte b = this.$r8$classId;
            Object obj = this.this$0;
            Object obj2 = this.delegateIterator;
            switch (b) {
                case 0:
                    iPreviousIndex = ((ListIterator) obj2).previousIndex();
                    size = ((ReversedList) obj).size();
                    break;
                case 1:
                    return ((Ref$IntRef) obj2).element + 1;
                default:
                    iPreviousIndex = ((ListIterator) obj2).previousIndex();
                    size = ((ReversedListReadOnly) obj).size();
                    break;
            }
            return (size - 1) - iPreviousIndex;
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            byte b = this.$r8$classId;
            Object obj = this.delegateIterator;
            switch (b) {
                case 0:
                    return ((ListIterator) obj).next();
                case 1:
                    Ref$IntRef ref$IntRef = (Ref$IntRef) obj;
                    int i = ref$IntRef.element;
                    SubList subList = (SubList) this.this$0;
                    SnapshotId_jvmKt.validateRange(i, subList.size);
                    ref$IntRef.element = i - 1;
                    return subList.get(i);
                default:
                    return ((ListIterator) obj).next();
            }
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            int iNextIndex;
            int size;
            byte b = this.$r8$classId;
            Object obj = this.this$0;
            Object obj2 = this.delegateIterator;
            switch (b) {
                case 0:
                    iNextIndex = ((ListIterator) obj2).nextIndex();
                    size = ((ReversedList) obj).size();
                    break;
                case 1:
                    return ((Ref$IntRef) obj2).element;
                default:
                    iNextIndex = ((ListIterator) obj2).nextIndex();
                    size = ((ReversedListReadOnly) obj).size();
                    break;
            }
            return (size - 1) - iNextIndex;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            switch (this.$r8$classId) {
                case 0:
                    ((ListIterator) this.delegateIterator).remove();
                    return;
                case 1:
                    throw new IllegalStateException("Cannot modify a state list through an iterator");
                default:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        @Override // java.util.ListIterator
        public final void set(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    ((ListIterator) this.delegateIterator).set(obj);
                    return;
                case 1:
                    throw new IllegalStateException("Cannot modify a state list through an iterator");
                default:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        public AnonymousClass1(ReversedList reversedList, int i) {
            this.this$0 = reversedList;
            this.delegateIterator = reversedList.delegate.listIterator(CollectionsKt.reversePositionIndex$CollectionsKt__ReversedViewsKt(i, reversedList));
        }

        public AnonymousClass1(Ref$IntRef ref$IntRef, SubList subList) {
            this.delegateIterator = ref$IntRef;
            this.this$0 = subList;
        }
    }
}
