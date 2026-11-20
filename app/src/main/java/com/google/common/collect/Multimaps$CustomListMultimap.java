package com.google.common.collect;

import com.google.common.base.Supplier;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Multimaps$CustomListMultimap extends AbstractMapBasedMultimap {
    public transient Supplier factory;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Object object = objectInputStream.readObject();
        Objects.requireNonNull(object);
        this.factory = (Supplier) object;
        Object object2 = objectInputStream.readObject();
        Objects.requireNonNull(object2);
        setMap((Map) object2);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.factory);
        objectOutputStream.writeObject(this.map);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
    public final Map createAsMap() {
        Map map = this.map;
        if (map instanceof NavigableMap) {
            return new AbstractMapBasedMultimap.NavigableAsMap(this, (NavigableMap) this.map);
        }
        return map instanceof SortedMap ? new AbstractMapBasedMultimap.SortedAsMap(this, (SortedMap) this.map) : new AbstractMapBasedMultimap.AsMap(this.map);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public final Collection createCollection() {
        return (List) this.factory.get();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
    public final Set createKeySet() {
        Map map = this.map;
        if (map instanceof NavigableMap) {
            return new AbstractMapBasedMultimap.NavigableKeySet(this, (NavigableMap) this.map);
        }
        return map instanceof SortedMap ? new AbstractMapBasedMultimap.SortedKeySet(this, (SortedMap) this.map) : new AbstractMapBasedMultimap.KeySet(this.map);
    }

    @Override // com.google.common.collect.Multimap
    public final Collection get(Object obj) {
        Collection collectionCreateCollection = (Collection) this.map.get(obj);
        if (collectionCreateCollection == null) {
            collectionCreateCollection = createCollection();
        }
        return (List) wrapCollection(obj, collectionCreateCollection);
    }
}
