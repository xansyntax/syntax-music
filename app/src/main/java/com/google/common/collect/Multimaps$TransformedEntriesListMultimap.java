package com.google.common.collect;

import com.google.common.base.Splitter$$ExternalSyntheticLambda0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Multimaps$TransformedEntriesListMultimap extends AbstractMultimap {
    public final Multimap fromMultimap;
    public final Splitter$$ExternalSyntheticLambda0 transformer;

    public Multimaps$TransformedEntriesListMultimap(Multimap multimap, Splitter$$ExternalSyntheticLambda0 splitter$$ExternalSyntheticLambda0) {
        multimap.getClass();
        this.fromMultimap = multimap;
        this.transformer = splitter$$ExternalSyntheticLambda0;
    }

    @Override // com.google.common.collect.Multimap
    public final void clear() {
        this.fromMultimap.clear();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public final Map createAsMap() {
        return new Maps.TransformedEntriesMap(this.fromMultimap.asMap(), new Splitter$$ExternalSyntheticLambda0((byte) 7, this));
    }

    @Override // com.google.common.collect.AbstractMultimap
    public final Collection createEntries() {
        return new Maps.Values((byte) 1, this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public final Set createKeySet() {
        return this.fromMultimap.keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public final Iterator entryIterator() {
        return new Iterators$6(this.fromMultimap.entries().iterator(), new Maps$$ExternalSyntheticLambda1((byte) 0, this.transformer));
    }

    @Override // com.google.common.collect.Multimap
    public final Collection get(Object obj) {
        return Maps.transform(new Multimaps$TransformedEntriesListMultimap$$ExternalSyntheticLambda0(this, obj), (List) this.fromMultimap.get(obj));
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final boolean remove(Object obj, Object obj2) {
        return get(obj).remove(obj2);
    }

    @Override // com.google.common.collect.Multimap
    public final int size() {
        return this.fromMultimap.size();
    }
}
