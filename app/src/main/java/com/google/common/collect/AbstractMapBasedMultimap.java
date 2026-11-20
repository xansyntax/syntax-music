package com.google.common.collect;

import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import coil3.util.UtilsKt;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractMapBasedMultimap extends AbstractMultimap implements Serializable {
    public transient Map map;
    public transient int totalSize;

    /* JADX INFO: renamed from: com.google.common.collect.AbstractMapBasedMultimap$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements Iterator {
        public final /* synthetic */ byte $r8$classId;
        public final Iterator keyIterator;
        public final /* synthetic */ AbstractMapBasedMultimap this$0;
        public Object key = null;
        public Collection collection = null;
        public Iterator valueIterator = Iterators$EmptyModifiableIterator.INSTANCE;

        public AnonymousClass1(AbstractMapBasedMultimap abstractMapBasedMultimap, byte b) {
            this.$r8$classId = b;
            this.this$0 = abstractMapBasedMultimap;
            this.keyIterator = abstractMapBasedMultimap.map.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.keyIterator.hasNext() || this.valueIterator.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (!this.valueIterator.hasNext()) {
                Map.Entry entry = (Map.Entry) this.keyIterator.next();
                this.key = entry.getKey();
                Collection collection = (Collection) entry.getValue();
                this.collection = collection;
                this.valueIterator = collection.iterator();
            }
            Object obj = this.key;
            Object next = this.valueIterator.next();
            switch (this.$r8$classId) {
                case 0:
                    return next;
                default:
                    return new AbstractMap.SimpleImmutableEntry(obj, next);
            }
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.valueIterator.remove();
            Collection collection = this.collection;
            Objects.requireNonNull(collection);
            if (collection.isEmpty()) {
                this.keyIterator.remove();
            }
            this.this$0.totalSize--;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public class AsMap extends AbstractMap {
        public transient Maps$IteratorBasedAbstractMap$1 entrySet;
        public final transient Map submap;
        public transient Maps.Values values;

        public AsMap(Map map) {
            this.submap = map;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final void clear() {
            AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
            if (this.submap == abstractMapBasedMultimap.map) {
                abstractMapBasedMultimap.clear();
                return;
            }
            KeySet.AnonymousClass1 anonymousClass1 = new KeySet.AnonymousClass1(this);
            while (anonymousClass1.hasNext()) {
                anonymousClass1.next();
                anonymousClass1.remove();
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object obj) {
            Map map = this.submap;
            map.getClass();
            try {
                return map.containsKey(obj);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Set entrySet() {
            Maps$IteratorBasedAbstractMap$1 maps$IteratorBasedAbstractMap$1 = this.entrySet;
            if (maps$IteratorBasedAbstractMap$1 != null) {
                return maps$IteratorBasedAbstractMap$1;
            }
            Maps$IteratorBasedAbstractMap$1 maps$IteratorBasedAbstractMap$2 = new Maps$IteratorBasedAbstractMap$1(this, (byte) 1);
            this.entrySet = maps$IteratorBasedAbstractMap$2;
            return maps$IteratorBasedAbstractMap$2;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean equals(Object obj) {
            return this == obj || this.submap.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object get(Object obj) {
            Object obj2;
            Map map = this.submap;
            map.getClass();
            try {
                obj2 = map.get(obj);
            } catch (ClassCastException | NullPointerException unused) {
                obj2 = null;
            }
            Collection collection = (Collection) obj2;
            if (collection == null) {
                return null;
            }
            return AbstractMapBasedMultimap.this.wrapCollection(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final int hashCode() {
            return this.submap.hashCode();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set keySet() {
            return AbstractMapBasedMultimap.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object remove(Object obj) {
            Collection collection = (Collection) this.submap.remove(obj);
            if (collection == null) {
                return null;
            }
            AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
            Collection collectionCreateCollection = abstractMapBasedMultimap.createCollection();
            collectionCreateCollection.addAll(collection);
            abstractMapBasedMultimap.totalSize -= collection.size();
            collection.clear();
            return collectionCreateCollection;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final int size() {
            return this.submap.size();
        }

        @Override // java.util.AbstractMap
        public final String toString() {
            return this.submap.toString();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Collection values() {
            Maps.Values values = this.values;
            if (values != null) {
                return values;
            }
            Maps.Values values2 = new Maps.Values(this);
            this.values = values2;
            return values2;
        }

        public final AbstractMap.SimpleImmutableEntry wrapEntry(Map.Entry entry) {
            Object key = entry.getKey();
            return new AbstractMap.SimpleImmutableEntry(key, AbstractMapBasedMultimap.this.wrapCollection(key, (Collection) entry.getValue()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RandomAccessWrappedList extends WrappedList implements RandomAccess {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public class SortedAsMap extends AsMap implements SortedMap {
        public SortedSet sortedKeySet;
        public final /* synthetic */ Multimaps$CustomListMultimap this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SortedAsMap(Multimaps$CustomListMultimap multimaps$CustomListMultimap, SortedMap sortedMap) {
            super(sortedMap);
            this.this$0 = multimaps$CustomListMultimap;
        }

        @Override // java.util.SortedMap
        public final Comparator comparator() {
            return sortedMap().comparator();
        }

        public SortedSet createKeySet() {
            return new SortedKeySet(this.this$0, sortedMap());
        }

        @Override // java.util.SortedMap
        public final Object firstKey() {
            return sortedMap().firstKey();
        }

        public SortedMap headMap(Object obj) {
            return new SortedAsMap(this.this$0, sortedMap().headMap(obj));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.AsMap, java.util.AbstractMap, java.util.Map
        public SortedSet keySet() {
            SortedSet sortedSet = this.sortedKeySet;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet sortedSetCreateKeySet = createKeySet();
            this.sortedKeySet = sortedSetCreateKeySet;
            return sortedSetCreateKeySet;
        }

        @Override // java.util.SortedMap
        public final Object lastKey() {
            return sortedMap().lastKey();
        }

        public SortedMap sortedMap() {
            return (SortedMap) this.submap;
        }

        public SortedMap subMap(Object obj, Object obj2) {
            return new SortedAsMap(this.this$0, sortedMap().subMap(obj, obj2));
        }

        public SortedMap tailMap(Object obj) {
            return new SortedAsMap(this.this$0, sortedMap().tailMap(obj));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public class SortedKeySet extends KeySet implements SortedSet {
        public final /* synthetic */ Multimaps$CustomListMultimap this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SortedKeySet(Multimaps$CustomListMultimap multimaps$CustomListMultimap, SortedMap sortedMap) {
            super(sortedMap);
            this.this$0 = multimaps$CustomListMultimap;
        }

        @Override // java.util.SortedSet
        public final Comparator comparator() {
            return sortedMap().comparator();
        }

        @Override // java.util.SortedSet
        public final Object first() {
            return sortedMap().firstKey();
        }

        public SortedSet headSet(Object obj) {
            return new SortedKeySet(this.this$0, sortedMap().headMap(obj));
        }

        @Override // java.util.SortedSet
        public final Object last() {
            return sortedMap().lastKey();
        }

        public SortedMap sortedMap() {
            return (SortedMap) this.map;
        }

        public SortedSet subSet(Object obj, Object obj2) {
            return new SortedKeySet(this.this$0, sortedMap().subMap(obj, obj2));
        }

        public SortedSet tailSet(Object obj) {
            return new SortedKeySet(this.this$0, sortedMap().tailMap(obj));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class WrappedCollection extends AbstractCollection {
        public final WrappedCollection ancestor;
        public final Collection ancestorDelegate;
        public Collection delegate;
        public final Object key;

        public WrappedCollection(Object obj, Collection collection, WrappedCollection wrappedCollection) {
            this.key = obj;
            this.delegate = collection;
            this.ancestor = wrappedCollection;
            this.ancestorDelegate = wrappedCollection == null ? null : wrappedCollection.delegate;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean add(Object obj) {
            refreshIfEmpty();
            boolean zIsEmpty = this.delegate.isEmpty();
            boolean zAdd = this.delegate.add(obj);
            if (zAdd) {
                AbstractMapBasedMultimap.this.totalSize++;
                if (zIsEmpty) {
                    addToMap();
                }
            }
            return zAdd;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean addAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = this.delegate.addAll(collection);
            if (zAddAll) {
                AbstractMapBasedMultimap.this.totalSize += this.delegate.size() - size;
                if (size == 0) {
                    addToMap();
                }
            }
            return zAddAll;
        }

        public final void addToMap() {
            WrappedCollection wrappedCollection = this.ancestor;
            if (wrappedCollection != null) {
                wrappedCollection.addToMap();
            } else {
                AbstractMapBasedMultimap.this.map.put(this.key, this.delegate);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.delegate.clear();
            AbstractMapBasedMultimap.this.totalSize -= size;
            removeIfEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
            refreshIfEmpty();
            return this.delegate.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean containsAll(Collection collection) {
            refreshIfEmpty();
            return this.delegate.containsAll(collection);
        }

        @Override // java.util.Collection
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            refreshIfEmpty();
            return this.delegate.equals(obj);
        }

        @Override // java.util.Collection
        public final int hashCode() {
            refreshIfEmpty();
            return this.delegate.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            refreshIfEmpty();
            return new KeySet.AnonymousClass1(this);
        }

        public final void refreshIfEmpty() {
            Collection collection;
            WrappedCollection wrappedCollection = this.ancestor;
            if (wrappedCollection != null) {
                wrappedCollection.refreshIfEmpty();
                if (wrappedCollection.delegate == this.ancestorDelegate) {
                    return;
                }
                MarqueeSpacing$Companion$$ExternalSyntheticLambda0.m52m();
                return;
            }
            if (!this.delegate.isEmpty() || (collection = (Collection) AbstractMapBasedMultimap.this.map.get(this.key)) == null) {
                return;
            }
            this.delegate = collection;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean remove(Object obj) {
            refreshIfEmpty();
            boolean zRemove = this.delegate.remove(obj);
            if (zRemove) {
                AbstractMapBasedMultimap.this.totalSize--;
                removeIfEmpty();
            }
            return zRemove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zRemoveAll = this.delegate.removeAll(collection);
            if (zRemoveAll) {
                AbstractMapBasedMultimap.this.totalSize += this.delegate.size() - size;
                removeIfEmpty();
            }
            return zRemoveAll;
        }

        public final void removeIfEmpty() {
            WrappedCollection wrappedCollection = this.ancestor;
            if (wrappedCollection != null) {
                wrappedCollection.removeIfEmpty();
            } else if (this.delegate.isEmpty()) {
                AbstractMapBasedMultimap.this.map.remove(this.key);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean retainAll(Collection collection) {
            collection.getClass();
            int size = size();
            boolean zRetainAll = this.delegate.retainAll(collection);
            if (zRetainAll) {
                AbstractMapBasedMultimap.this.totalSize += this.delegate.size() - size;
                removeIfEmpty();
            }
            return zRetainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            refreshIfEmpty();
            return this.delegate.size();
        }

        @Override // java.util.AbstractCollection
        public final String toString() {
            refreshIfEmpty();
            return this.delegate.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class WrappedSet extends WrappedCollection implements Set {
        public final /* synthetic */ HashMultimap this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WrappedSet(HashMultimap hashMultimap, Object obj, Set set) {
            super(obj, set, null);
            this.this$0 = hashMultimap;
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.WrappedCollection, java.util.AbstractCollection, java.util.Collection
        public final boolean removeAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zRemoveAllImpl = Maps.removeAllImpl((Set) this.delegate, collection);
            if (zRemoveAllImpl) {
                this.this$0.totalSize += this.delegate.size() - size;
                removeIfEmpty();
            }
            return zRemoveAllImpl;
        }
    }

    public AbstractMapBasedMultimap(Map map) {
        UtilsKt.checkArgument(map.isEmpty());
        this.map = map;
    }

    @Override // com.google.common.collect.Multimap
    public final void clear() {
        Iterator it = this.map.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        this.map.clear();
        this.totalSize = 0;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Map createAsMap() {
        return new AsMap(this.map);
    }

    public abstract Collection createCollection();

    @Override // com.google.common.collect.AbstractMultimap
    public Set createKeySet() {
        return new KeySet(this.map);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Collection entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public final Iterator entryIterator() {
        return new AnonymousClass1(this, (byte) 1);
    }

    public boolean put(Object obj, Object obj2) {
        Collection collection = (Collection) this.map.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.totalSize++;
            return true;
        }
        Collection collectionCreateCollection = createCollection();
        if (!collectionCreateCollection.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.totalSize++;
        this.map.put(obj, collectionCreateCollection);
        return true;
    }

    public final void setMap(Map map) {
        this.map = map;
        this.totalSize = 0;
        for (Collection collection : map.values()) {
            UtilsKt.checkArgument(!collection.isEmpty());
            this.totalSize = collection.size() + this.totalSize;
        }
    }

    @Override // com.google.common.collect.Multimap
    public final int size() {
        return this.totalSize;
    }

    public Collection wrapCollection(Object obj, Collection collection) {
        List list = (List) collection;
        return list instanceof RandomAccess ? new RandomAccessWrappedList(obj, list, null) : new WrappedList(obj, list, null);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class NavigableAsMap extends SortedAsMap implements NavigableMap {
        public final /* synthetic */ Multimaps$CustomListMultimap this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigableAsMap(Multimaps$CustomListMultimap multimaps$CustomListMultimap, NavigableMap navigableMap) {
            super(multimaps$CustomListMultimap, navigableMap);
            this.this$0 = multimaps$CustomListMultimap;
        }

        @Override // java.util.NavigableMap
        public final Map.Entry ceilingEntry(Object obj) {
            Map.Entry entryCeilingEntry = sortedMap().ceilingEntry(obj);
            if (entryCeilingEntry == null) {
                return null;
            }
            return wrapEntry(entryCeilingEntry);
        }

        @Override // java.util.NavigableMap
        public final Object ceilingKey(Object obj) {
            return sortedMap().ceilingKey(obj);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap
        public final SortedSet createKeySet() {
            return new NavigableKeySet(this.this$0, sortedMap());
        }

        @Override // java.util.NavigableMap
        public final NavigableSet descendingKeySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // java.util.NavigableMap
        public final NavigableMap descendingMap() {
            return new NavigableAsMap(this.this$0, sortedMap().descendingMap());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry firstEntry() {
            Map.Entry entryFirstEntry = sortedMap().firstEntry();
            if (entryFirstEntry == null) {
                return null;
            }
            return wrapEntry(entryFirstEntry);
        }

        @Override // java.util.NavigableMap
        public final Map.Entry floorEntry(Object obj) {
            Map.Entry entryFloorEntry = sortedMap().floorEntry(obj);
            if (entryFloorEntry == null) {
                return null;
            }
            return wrapEntry(entryFloorEntry);
        }

        @Override // java.util.NavigableMap
        public final Object floorKey(Object obj) {
            return sortedMap().floorKey(obj);
        }

        @Override // java.util.NavigableMap
        public final NavigableMap headMap(Object obj, boolean z) {
            return new NavigableAsMap(this.this$0, sortedMap().headMap(obj, z));
        }

        @Override // java.util.NavigableMap
        public final Map.Entry higherEntry(Object obj) {
            Map.Entry entryHigherEntry = sortedMap().higherEntry(obj);
            if (entryHigherEntry == null) {
                return null;
            }
            return wrapEntry(entryHigherEntry);
        }

        @Override // java.util.NavigableMap
        public final Object higherKey(Object obj) {
            return sortedMap().higherKey(obj);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, com.google.common.collect.AbstractMapBasedMultimap.AsMap, java.util.AbstractMap, java.util.Map
        public final Set keySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry lastEntry() {
            Map.Entry entryLastEntry = sortedMap().lastEntry();
            if (entryLastEntry == null) {
                return null;
            }
            return wrapEntry(entryLastEntry);
        }

        @Override // java.util.NavigableMap
        public final Map.Entry lowerEntry(Object obj) {
            Map.Entry entryLowerEntry = sortedMap().lowerEntry(obj);
            if (entryLowerEntry == null) {
                return null;
            }
            return wrapEntry(entryLowerEntry);
        }

        @Override // java.util.NavigableMap
        public final Object lowerKey(Object obj) {
            return sortedMap().lowerKey(obj);
        }

        @Override // java.util.NavigableMap
        public final NavigableSet navigableKeySet() {
            return (NavigableSet) super.keySet();
        }

        public final AbstractMap.SimpleImmutableEntry pollAsMapEntry(Iterator it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry entry = (Map.Entry) it.next();
            Collection collectionCreateCollection = this.this$0.createCollection();
            collectionCreateCollection.addAll((Collection) entry.getValue());
            it.remove();
            return new AbstractMap.SimpleImmutableEntry(entry.getKey(), Collections.unmodifiableList((List) collectionCreateCollection));
        }

        @Override // java.util.NavigableMap
        public final Map.Entry pollFirstEntry() {
            return pollAsMapEntry(((Maps$IteratorBasedAbstractMap$1) entrySet()).iterator());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry pollLastEntry() {
            return pollAsMapEntry(((Maps$IteratorBasedAbstractMap$1) ((AsMap) descendingMap()).entrySet()).iterator());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap
        public final NavigableMap sortedMap() {
            return (NavigableMap) ((SortedMap) this.submap);
        }

        @Override // java.util.NavigableMap
        public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return new NavigableAsMap(this.this$0, sortedMap().subMap(obj, z, obj2, z2));
        }

        @Override // java.util.NavigableMap
        public final NavigableMap tailMap(Object obj, boolean z) {
            return new NavigableAsMap(this.this$0, sortedMap().tailMap(obj, z));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, com.google.common.collect.AbstractMapBasedMultimap.AsMap, java.util.AbstractMap, java.util.Map
        public final SortedSet keySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        public final SortedMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        public final SortedMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        public final SortedMap tailMap(Object obj) {
            return tailMap(obj, true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public class WrappedList extends WrappedCollection implements List {
        public WrappedList(Object obj, List list, WrappedCollection wrappedCollection) {
            super(obj, list, wrappedCollection);
        }

        @Override // java.util.List
        public final void add(int i, Object obj) {
            refreshIfEmpty();
            boolean zIsEmpty = this.delegate.isEmpty();
            ((List) this.delegate).add(i, obj);
            AbstractMapBasedMultimap.this.totalSize++;
            if (zIsEmpty) {
                addToMap();
            }
        }

        @Override // java.util.List
        public final boolean addAll(int i, Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = ((List) this.delegate).addAll(i, collection);
            if (zAddAll) {
                AbstractMapBasedMultimap.this.totalSize += this.delegate.size() - size;
                if (size == 0) {
                    addToMap();
                }
            }
            return zAddAll;
        }

        @Override // java.util.List
        public final Object get(int i) {
            refreshIfEmpty();
            return ((List) this.delegate).get(i);
        }

        @Override // java.util.List
        public final int indexOf(Object obj) {
            refreshIfEmpty();
            return ((List) this.delegate).indexOf(obj);
        }

        @Override // java.util.List
        public final int lastIndexOf(Object obj) {
            refreshIfEmpty();
            return ((List) this.delegate).lastIndexOf(obj);
        }

        @Override // java.util.List
        public final ListIterator listIterator() {
            refreshIfEmpty();
            return new WrappedListIterator();
        }

        @Override // java.util.List
        public final Object remove(int i) {
            refreshIfEmpty();
            Object objRemove = ((List) this.delegate).remove(i);
            AbstractMapBasedMultimap.this.totalSize--;
            removeIfEmpty();
            return objRemove;
        }

        @Override // java.util.List
        public final Object set(int i, Object obj) {
            refreshIfEmpty();
            return ((List) this.delegate).set(i, obj);
        }

        @Override // java.util.List
        public final List subList(int i, int i2) {
            refreshIfEmpty();
            List listSubList = ((List) this.delegate).subList(i, i2);
            WrappedCollection wrappedCollection = this.ancestor;
            if (wrappedCollection == null) {
                wrappedCollection = this;
            }
            boolean z = listSubList instanceof RandomAccess;
            AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
            Object obj = this.key;
            return z ? abstractMapBasedMultimap.new RandomAccessWrappedList(obj, listSubList, wrappedCollection) : abstractMapBasedMultimap.new WrappedList(obj, listSubList, wrappedCollection);
        }

        @Override // java.util.List
        public final ListIterator listIterator(int i) {
            refreshIfEmpty();
            return new WrappedListIterator(i);
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class WrappedListIterator extends KeySet.AnonymousClass1 implements ListIterator {
            public WrappedListIterator(int i) {
                super(WrappedList.this, ((List) WrappedList.this.delegate).listIterator(i));
            }

            @Override // java.util.ListIterator
            public final void add(Object obj) {
                WrappedList wrappedList = WrappedList.this;
                boolean zIsEmpty = wrappedList.isEmpty();
                getDelegateListIterator().add(obj);
                AbstractMapBasedMultimap.this.totalSize++;
                if (zIsEmpty) {
                    wrappedList.addToMap();
                }
            }

            public final ListIterator getDelegateListIterator() {
                validateIterator();
                return (ListIterator) this.val$entryIterator;
            }

            @Override // java.util.ListIterator
            public final boolean hasPrevious() {
                return getDelegateListIterator().hasPrevious();
            }

            @Override // java.util.ListIterator
            public final int nextIndex() {
                return getDelegateListIterator().nextIndex();
            }

            @Override // java.util.ListIterator
            public final Object previous() {
                return getDelegateListIterator().previous();
            }

            @Override // java.util.ListIterator
            public final int previousIndex() {
                return getDelegateListIterator().previousIndex();
            }

            @Override // java.util.ListIterator
            public final void set(Object obj) {
                getDelegateListIterator().set(obj);
            }

            public WrappedListIterator() {
                super(WrappedList.this);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class NavigableKeySet extends SortedKeySet implements NavigableSet {
        public final /* synthetic */ Multimaps$CustomListMultimap this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigableKeySet(Multimaps$CustomListMultimap multimaps$CustomListMultimap, NavigableMap navigableMap) {
            super(multimaps$CustomListMultimap, navigableMap);
            this.this$0 = multimaps$CustomListMultimap;
        }

        @Override // java.util.NavigableSet
        public final Object ceiling(Object obj) {
            return sortedMap().ceilingKey(obj);
        }

        @Override // java.util.NavigableSet
        public final Iterator descendingIterator() {
            return ((KeySet) descendingSet()).iterator();
        }

        @Override // java.util.NavigableSet
        public final NavigableSet descendingSet() {
            return new NavigableKeySet(this.this$0, sortedMap().descendingMap());
        }

        @Override // java.util.NavigableSet
        public final Object floor(Object obj) {
            return sortedMap().floorKey(obj);
        }

        @Override // java.util.NavigableSet
        public final NavigableSet headSet(Object obj, boolean z) {
            return new NavigableKeySet(this.this$0, sortedMap().headMap(obj, z));
        }

        @Override // java.util.NavigableSet
        public final Object higher(Object obj) {
            return sortedMap().higherKey(obj);
        }

        @Override // java.util.NavigableSet
        public final Object lower(Object obj) {
            return sortedMap().lowerKey(obj);
        }

        @Override // java.util.NavigableSet
        public final Object pollFirst() {
            KeySet.AnonymousClass1 anonymousClass1 = (KeySet.AnonymousClass1) iterator();
            if (!anonymousClass1.hasNext()) {
                return null;
            }
            Object next = anonymousClass1.next();
            anonymousClass1.remove();
            return next;
        }

        @Override // java.util.NavigableSet
        public final Object pollLast() {
            Iterator itDescendingIterator = descendingIterator();
            if (!itDescendingIterator.hasNext()) {
                return null;
            }
            Object next = itDescendingIterator.next();
            itDescendingIterator.remove();
            return next;
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet
        public final NavigableMap sortedMap() {
            return (NavigableMap) ((SortedMap) this.map);
        }

        @Override // java.util.NavigableSet
        public final NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
            return new NavigableKeySet(this.this$0, sortedMap().subMap(obj, z, obj2, z2));
        }

        @Override // java.util.NavigableSet
        public final NavigableSet tailSet(Object obj, boolean z) {
            return new NavigableKeySet(this.this$0, sortedMap().tailMap(obj, z));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public final SortedSet headSet(Object obj) {
            return headSet(obj, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public final SortedSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public final SortedSet tailSet(Object obj) {
            return tailSet(obj, true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public class KeySet extends Sets$ImprovedAbstractSet {
        public final Map map;

        public KeySet(Map map) {
            map.getClass();
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            Iterator it = iterator();
            while (true) {
                AnonymousClass1 anonymousClass1 = (AnonymousClass1) it;
                if (!anonymousClass1.hasNext()) {
                    return;
                }
                anonymousClass1.next();
                anonymousClass1.remove();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return this.map.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean containsAll(Collection collection) {
            return this.map.keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public final boolean equals(Object obj) {
            return this == obj || this.map.keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public final int hashCode() {
            return this.map.keySet().hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            return new AnonymousClass1(this, this.map.entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            int size;
            Collection collection = (Collection) this.map.remove(obj);
            if (collection != null) {
                size = collection.size();
                collection.clear();
                AbstractMapBasedMultimap.this.totalSize -= size;
            } else {
                size = 0;
            }
            return size > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.map.size();
        }

        /* JADX INFO: renamed from: com.google.common.collect.AbstractMapBasedMultimap$KeySet$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public class AnonymousClass1 implements Iterator {
            public final /* synthetic */ byte $r8$classId = 1;
            public Object entry;
            public final /* synthetic */ Object this$1;
            public final Iterator val$entryIterator;

            public AnonymousClass1(WrappedCollection wrappedCollection) {
                this.this$1 = wrappedCollection;
                Collection collection = wrappedCollection.delegate;
                this.entry = collection;
                this.val$entryIterator = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                switch (this.$r8$classId) {
                    case 0:
                        break;
                    case 1:
                        break;
                    default:
                        validateIterator();
                        break;
                }
                return this.val$entryIterator.hasNext();
            }

            @Override // java.util.Iterator
            public final Object next() {
                byte b = this.$r8$classId;
                Iterator it = this.val$entryIterator;
                switch (b) {
                    case 0:
                        Map.Entry entry = (Map.Entry) it.next();
                        this.entry = entry;
                        return entry.getKey();
                    case 1:
                        Map.Entry entry2 = (Map.Entry) it.next();
                        this.entry = (Collection) entry2.getValue();
                        return ((AsMap) this.this$1).wrapEntry(entry2);
                    default:
                        validateIterator();
                        return it.next();
                }
            }

            @Override // java.util.Iterator
            public final void remove() {
                byte b = this.$r8$classId;
                Object obj = this.this$1;
                Iterator it = this.val$entryIterator;
                switch (b) {
                    case 0:
                        UtilsKt.checkState("no calls to next() since the last call to remove()", ((Map.Entry) this.entry) != null);
                        Collection collection = (Collection) ((Map.Entry) this.entry).getValue();
                        it.remove();
                        AbstractMapBasedMultimap.this.totalSize -= collection.size();
                        collection.clear();
                        this.entry = null;
                        break;
                    case 1:
                        UtilsKt.checkState("no calls to next() since the last call to remove()", ((Collection) this.entry) != null);
                        it.remove();
                        AbstractMapBasedMultimap.this.totalSize -= ((Collection) this.entry).size();
                        ((Collection) this.entry).clear();
                        this.entry = null;
                        break;
                    default:
                        it.remove();
                        WrappedCollection wrappedCollection = (WrappedCollection) obj;
                        AbstractMapBasedMultimap.this.totalSize--;
                        wrappedCollection.removeIfEmpty();
                        break;
                }
            }

            public void validateIterator() {
                WrappedCollection wrappedCollection = (WrappedCollection) this.this$1;
                wrappedCollection.refreshIfEmpty();
                if (wrappedCollection.delegate == ((Collection) this.entry)) {
                    return;
                }
                MarqueeSpacing$Companion$$ExternalSyntheticLambda0.m52m();
            }

            public AnonymousClass1(WrappedCollection wrappedCollection, ListIterator listIterator) {
                this.this$1 = wrappedCollection;
                this.entry = wrappedCollection.delegate;
                this.val$entryIterator = listIterator;
            }

            public AnonymousClass1(KeySet keySet, Iterator it) {
                this.val$entryIterator = it;
                this.this$1 = keySet;
            }

            public AnonymousClass1(AsMap asMap) {
                this.this$1 = asMap;
                this.val$entryIterator = asMap.submap.entrySet().iterator();
            }
        }
    }
}
