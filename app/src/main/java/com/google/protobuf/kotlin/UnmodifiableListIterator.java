package com.google.protobuf.kotlin;

import java.util.ListIterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class UnmodifiableListIterator implements ListIterator, KMappedMarker {
    public final /* synthetic */ ListIterator $$delegate_0;

    public UnmodifiableListIterator(ListIterator listIterator) {
        listIterator.getClass();
        this.$$delegate_0 = listIterator;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.$$delegate_0.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.$$delegate_0.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        return this.$$delegate_0.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.$$delegate_0.nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return this.$$delegate_0.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.$$delegate_0.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
