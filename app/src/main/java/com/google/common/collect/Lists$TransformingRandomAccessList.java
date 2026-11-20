package com.google.common.collect;

import com.google.common.base.Function;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Lists$TransformingRandomAccessList extends AbstractList implements RandomAccess, Serializable {
    public final List fromList;
    public final Function function;

    public Lists$TransformingRandomAccessList(Function function, List list) {
        list.getClass();
        this.fromList = list;
        this.function = function;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.function.apply(this.fromList.get(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.fromList.isEmpty();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new Lists$TransformingSequentialList.AnonymousClass1(this, this.fromList.listIterator(i), (byte) 1);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        return this.function.apply(this.fromList.remove(i));
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
