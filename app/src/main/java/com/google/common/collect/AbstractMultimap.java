package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractMultimap implements Multimap {
    public transient Map asMap;
    public transient Collection entries;
    public transient Set keySet;
    public transient Collection values;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class EntrySet extends Maps.Values implements Set {
        @Override // java.util.Collection, java.util.Set
        public final boolean equals(Object obj) {
            return Maps.equalsImpl(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public final int hashCode() {
            return Maps.hashCodeImpl(this);
        }
    }

    @Override // com.google.common.collect.Multimap
    public Map asMap() {
        Map map = this.asMap;
        if (map != null) {
            return map;
        }
        Map mapCreateAsMap = createAsMap();
        this.asMap = mapCreateAsMap;
        return mapCreateAsMap;
    }

    public boolean containsValue(Object obj) {
        Iterator it = asMap().values().iterator();
        while (it.hasNext()) {
            if (((Collection) it.next()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public Map createAsMap() {
        throw new AssertionError("should never be called");
    }

    public Collection createEntries() {
        return this instanceof HashMultimap ? new EntrySet((byte) 1, this) : new Maps.Values((byte) 1, this);
    }

    public Set createKeySet() {
        throw new AssertionError("unreachable");
    }

    @Override // com.google.common.collect.Multimap
    public Collection entries() {
        Collection collection = this.entries;
        if (collection != null) {
            return collection;
        }
        Collection collectionCreateEntries = createEntries();
        this.entries = collectionCreateEntries;
        return collectionCreateEntries;
    }

    public abstract Iterator entryIterator();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Multimap) {
            return asMap().equals(((Multimap) obj).asMap());
        }
        return false;
    }

    public final int hashCode() {
        return asMap().hashCode();
    }

    @Override // com.google.common.collect.Multimap
    public Set keySet() {
        Set set = this.keySet;
        if (set != null) {
            return set;
        }
        Set setCreateKeySet = createKeySet();
        this.keySet = setCreateKeySet;
        return setCreateKeySet;
    }

    @Override // com.google.common.collect.Multimap
    public boolean remove(Object obj, Object obj2) {
        Collection collection = (Collection) asMap().get(obj);
        return collection != null && collection.remove(obj2);
    }

    public final String toString() {
        return asMap().toString();
    }
}
