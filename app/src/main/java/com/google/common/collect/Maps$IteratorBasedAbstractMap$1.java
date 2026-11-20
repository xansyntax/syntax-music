package com.google.common.collect;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Maps$IteratorBasedAbstractMap$1 extends Sets$ImprovedAbstractSet {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ AbstractMap this$0;

    public /* synthetic */ Maps$IteratorBasedAbstractMap$1(AbstractMap abstractMap, byte b) {
        this.$r8$classId = b;
        this.this$0 = abstractMap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        map().clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        switch (this.$r8$classId) {
            case 1:
                Set setEntrySet = ((AbstractMapBasedMultimap.AsMap) this.this$0).submap.entrySet();
                setEntrySet.getClass();
                try {
                    return setEntrySet.contains(obj);
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            default:
                return contains$com$google$common$collect$Maps$EntrySet(obj);
        }
    }

    public final boolean contains$com$google$common$collect$Maps$EntrySet(Object obj) {
        Object obj2;
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Map map = map();
        map.getClass();
        try {
            obj2 = map.get(key);
        } catch (ClassCastException | NullPointerException unused) {
            obj2 = null;
        }
        if (Objects.equals(obj2, entry.getValue())) {
            return obj2 != null || map().containsKey(key);
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return map().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        byte b = this.$r8$classId;
        AbstractMap abstractMap = this.this$0;
        switch (b) {
            case 0:
                Maps.TransformedEntriesMap transformedEntriesMap = (Maps.TransformedEntriesMap) abstractMap;
                return new Iterators$6(transformedEntriesMap.fromMap.entrySet().iterator(), new Maps$$ExternalSyntheticLambda1((byte) 0, transformedEntriesMap.transformer));
            default:
                return new AbstractMapBasedMultimap.KeySet.AnonymousClass1((AbstractMapBasedMultimap.AsMap) abstractMap);
        }
    }

    public final Map map() {
        byte b = this.$r8$classId;
        AbstractMap abstractMap = this.this$0;
        switch (b) {
            case 0:
                return (Maps.TransformedEntriesMap) abstractMap;
            default:
                return (AbstractMapBasedMultimap.AsMap) abstractMap;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        Object objRemove;
        switch (this.$r8$classId) {
            case 1:
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
                Object key = entry.getKey();
                Map map = abstractMapBasedMultimap.map;
                map.getClass();
                try {
                    objRemove = map.remove(key);
                    break;
                } catch (ClassCastException | NullPointerException unused) {
                    objRemove = null;
                }
                Collection collection = (Collection) objRemove;
                if (collection != null) {
                    int size = collection.size();
                    collection.clear();
                    abstractMapBasedMultimap.totalSize -= size;
                }
                return true;
            default:
                return remove$com$google$common$collect$Maps$EntrySet(obj);
        }
    }

    public final boolean remove$com$google$common$collect$Maps$EntrySet(Object obj) {
        if (contains(obj) && (obj instanceof Map.Entry)) {
            return map().keySet().remove(((Map.Entry) obj).getKey());
        }
        return false;
    }

    @Override // com.google.common.collect.Sets$ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        try {
            collection.getClass();
            return Maps.removeAllImpl(this, collection);
        } catch (UnsupportedOperationException unused) {
            Iterator it = collection.iterator();
            boolean zRemove = false;
            while (it.hasNext()) {
                zRemove |= remove(it.next());
            }
            return zRemove;
        }
    }

    @Override // com.google.common.collect.Sets$ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        int iCeil;
        try {
            collection.getClass();
            return super.retainAll(collection);
        } catch (UnsupportedOperationException unused) {
            int size = collection.size();
            if (size < 3) {
                Maps.checkNonnegative(size, "expectedSize");
                iCeil = size + 1;
            } else {
                iCeil = size < 1073741824 ? (int) Math.ceil(((double) size) / 0.75d) : Integer.MAX_VALUE;
            }
            HashSet hashSet = new HashSet(iCeil);
            for (Object obj : collection) {
                if (contains(obj) && (obj instanceof Map.Entry)) {
                    hashSet.add(((Map.Entry) obj).getKey());
                }
            }
            return map().keySet().retainAll(hashSet);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return map().size();
    }
}
