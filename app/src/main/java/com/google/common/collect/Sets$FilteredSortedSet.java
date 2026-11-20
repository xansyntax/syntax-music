package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Sets$FilteredSortedSet extends Sets$FilteredSet implements SortedSet {
    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return ((SortedSet) this.unfiltered).comparator();
    }

    @Override // java.util.SortedSet
    public final Object first() {
        Iterator it = this.unfiltered.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            if (this.predicate.apply(next)) {
                return next;
            }
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
        return null;
    }

    @Override // java.util.SortedSet
    public final SortedSet headSet(Object obj) {
        return new Sets$FilteredSortedSet(((SortedSet) this.unfiltered).headSet(obj), this.predicate);
    }

    @Override // java.util.SortedSet
    public final Object last() {
        SortedSet sortedSetHeadSet = (SortedSet) this.unfiltered;
        while (true) {
            Object objLast = sortedSetHeadSet.last();
            if (this.predicate.apply(objLast)) {
                return objLast;
            }
            sortedSetHeadSet = sortedSetHeadSet.headSet(objLast);
        }
    }

    @Override // java.util.SortedSet
    public final SortedSet subSet(Object obj, Object obj2) {
        return new Sets$FilteredSortedSet(((SortedSet) this.unfiltered).subSet(obj, obj2), this.predicate);
    }

    @Override // java.util.SortedSet
    public final SortedSet tailSet(Object obj) {
        return new Sets$FilteredSortedSet(((SortedSet) this.unfiltered).tailSet(obj), this.predicate);
    }
}
