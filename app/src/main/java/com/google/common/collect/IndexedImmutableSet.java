package com.google.common.collect;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class IndexedImmutableSet extends ImmutableSet {
    @Override // com.google.common.collect.ImmutableCollection
    public final int copyIntoArray(int i, Object[] objArr) {
        return asList().copyIntoArray(i, objArr);
    }

    @Override // com.google.common.collect.ImmutableSet
    public final ImmutableList createAsList() {
        return new ImmutableList() { // from class: com.google.common.collect.IndexedImmutableSet.1
            @Override // java.util.List
            public final Object get(int i) {
                return IndexedImmutableSet.this.get(i);
            }

            @Override // com.google.common.collect.ImmutableCollection
            public final boolean isPartialView() {
                return IndexedImmutableSet.this.isPartialView();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public final int size() {
                return IndexedImmutableSet.this.size();
            }
        };
    }

    public abstract Object get(int i);

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final UnmodifiableIterator iterator() {
        return asList().listIterator(0);
    }
}
