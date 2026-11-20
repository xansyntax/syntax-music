package com.google.common.collect;

import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SingletonImmutableSet extends ImmutableSet {
    public final transient Object element;

    public SingletonImmutableSet(Object obj) {
        obj.getClass();
        this.element = obj;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public final ImmutableList asList() {
        return ImmutableList.of(this.element);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.element.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int copyIntoArray(int i, Object[] objArr) {
        objArr[i] = this.element;
        return i + 1;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.element.hashCode();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final UnmodifiableIterator iterator() {
        final Object obj = this.element;
        return new UnmodifiableIterator(obj) { // from class: com.google.common.collect.Iterators$SingletonIterator
            public boolean done;
            public final Object value;

            {
                this.value = obj;
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return !this.done;
            }

            @Override // java.util.Iterator
            public final Object next() {
                if (this.done) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                    return null;
                }
                this.done = true;
                return this.value;
            }
        };
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return "[" + this.element.toString() + ']';
    }
}
