package com.google.common.collect;

import com.google.common.base.Function;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Lists$TransformingSequentialList extends AbstractSequentialList implements Serializable {
    public final List fromList;
    public final Function function;

    /* JADX INFO: renamed from: com.google.common.collect.Lists$TransformingSequentialList$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends TransformedIterator implements ListIterator {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ AbstractList this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(AbstractList abstractList, ListIterator listIterator, byte b) {
            super(listIterator);
            this.$r8$classId = b;
            this.this$0 = abstractList;
        }

        @Override // java.util.ListIterator
        public final void add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return ((ListIterator) this.backingIterator).hasPrevious();
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return ((ListIterator) this.backingIterator).nextIndex();
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            return transform(((ListIterator) this.backingIterator).previous());
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return ((ListIterator) this.backingIterator).previousIndex();
        }

        @Override // java.util.ListIterator
        public final void set(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.TransformedIterator
        public final Object transform(Object obj) {
            byte b = this.$r8$classId;
            AbstractList abstractList = this.this$0;
            switch (b) {
                case 0:
                    return ((Lists$TransformingSequentialList) abstractList).function.apply(obj);
                default:
                    return ((Lists$TransformingRandomAccessList) abstractList).function.apply(obj);
            }
        }
    }

    public Lists$TransformingSequentialList(Function function, List list) {
        list.getClass();
        this.fromList = list;
        this.function = function;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.fromList.isEmpty();
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new AnonymousClass1(this, this.fromList.listIterator(i), (byte) 0);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        this.fromList.subList(i, i2).clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.fromList.size();
    }
}
