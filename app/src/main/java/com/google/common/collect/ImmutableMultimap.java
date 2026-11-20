package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ImmutableMultimap extends BaseImmutableMultimap implements Serializable {
    final transient ImmutableMap map;
    final transient int size;

    /* JADX INFO: renamed from: com.google.common.collect.ImmutableMultimap$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends UnmodifiableIterator {
        public final UnmodifiableIterator asMapItr;
        public Object currentKey = null;
        public UnmodifiableIterator valueItr = new AbstractIndexedListIterator(new Object[0]) { // from class: com.google.common.collect.Iterators$ArrayItr
            public final Object[] array;

            {
                super(objArr.length, 0);
                this.array = objArr;
            }

            @Override // com.google.common.collect.AbstractIndexedListIterator
            public final Object get(int i) {
                return this.array[i];
            }
        };

        public AnonymousClass1(ImmutableMultimap immutableMultimap) {
            this.asMapItr = immutableMultimap.map.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.valueItr.hasNext() || this.asMapItr.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (!this.valueItr.hasNext()) {
                Map.Entry entry = (Map.Entry) this.asMapItr.next();
                this.currentKey = entry.getKey();
                this.valueItr = ((ImmutableCollection) entry.getValue()).iterator();
            }
            Object obj = this.currentKey;
            Objects.requireNonNull(obj);
            return new AbstractMap.SimpleImmutableEntry(obj, this.valueItr.next());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class EntryCollection extends ImmutableCollection {
        public final ImmutableMultimap multimap;

        public EntryCollection(ImmutableMultimap immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                Collection collection = (Collection) this.multimap.asMap().get(key);
                if (collection != null && collection.contains(value)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final UnmodifiableIterator iterator() {
            return new AnonymousClass1(this.multimap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return this.multimap.size;
        }
    }

    public ImmutableMultimap(RegularImmutableMap regularImmutableMap, int i) {
        this.map = regularImmutableMap;
        this.size = i;
    }

    @Override // com.google.common.collect.Multimap
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public final boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public final Collection createEntries() {
        return new EntryCollection(this);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final Collection entries() {
        return (ImmutableCollection) super.entries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public final Iterator entryIterator() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final Set keySet() {
        return this.map.keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimap
    public final int size() {
        return this.size;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableMap asMap() {
        return this.map;
    }
}
