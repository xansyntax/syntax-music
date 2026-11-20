package com.google.common.collect;

import coil3.util.UtilsKt;
import com.google.common.base.Predicate;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class Sets$FilteredSet extends AbstractCollection implements Set {
    public final Predicate predicate;
    public final Collection unfiltered;

    public Sets$FilteredSet(Collection collection, Predicate predicate) {
        this.unfiltered = collection;
        this.predicate = predicate;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        UtilsKt.checkArgument(this.predicate.apply(obj));
        return this.unfiltered.add(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            UtilsKt.checkArgument(this.predicate.apply(it.next()));
        }
        return this.unfiltered.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        Collection collection = this.unfiltered;
        boolean z = collection instanceof RandomAccess;
        Predicate predicate = this.predicate;
        if (!z || !(collection instanceof List)) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (predicate.apply(it.next())) {
                    it.remove();
                }
            }
            return;
        }
        List list = (List) collection;
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Object obj = list.get(i2);
            if (!predicate.apply(obj)) {
                if (i2 > i) {
                    try {
                        list.set(i, obj);
                    } catch (IllegalArgumentException unused) {
                        Maps.slowRemoveIfForRemainingElements(list, predicate, i, i2);
                        return;
                    } catch (UnsupportedOperationException unused2) {
                        Maps.slowRemoveIfForRemainingElements(list, predicate, i, i2);
                        return;
                    }
                }
                i++;
            }
        }
        list.subList(i, list.size()).clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        boolean zContains;
        Collection collection = this.unfiltered;
        collection.getClass();
        try {
            zContains = collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            zContains = false;
        }
        if (zContains) {
            return this.predicate.apply(obj);
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        return Maps.equalsImpl(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return Maps.hashCodeImpl(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        Iterator it = this.unfiltered.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (this.predicate.apply(it.next())) {
                break;
            }
            i++;
        }
        return true ^ (i != -1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        Iterator it = this.unfiltered.iterator();
        it.getClass();
        return new Sets$2.AnonymousClass1(it, this.predicate);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        return contains(obj) && this.unfiltered.remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        Iterator it = this.unfiltered.iterator();
        boolean z = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (this.predicate.apply(next) && collection.contains(next)) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        Iterator it = this.unfiltered.iterator();
        boolean z = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (this.predicate.apply(next) && !collection.contains(next)) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        Iterator it = this.unfiltered.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (this.predicate.apply(it.next())) {
                i++;
            }
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return Maps.newArrayList(iterator()).toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        return Maps.newArrayList(iterator()).toArray(objArr);
    }
}
