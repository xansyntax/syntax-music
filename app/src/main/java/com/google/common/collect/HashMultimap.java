package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HashMultimap extends AbstractMapBasedMultimap implements Multimap {
    public transient byte expectedValuesPerKey;

    public HashMultimap() {
        CompactHashMap compactHashMap = new CompactHashMap();
        compactHashMap.init(12);
        super(compactHashMap);
        this.expectedValuesPerKey = (byte) 2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.expectedValuesPerKey = (byte) 2;
        int i = objectInputStream.readInt();
        CompactHashMap compactHashMap = new CompactHashMap();
        compactHashMap.init(12);
        setMap(compactHashMap);
        for (int i2 = 0; i2 < i; i2++) {
            Collection collection = get(objectInputStream.readObject());
            int i3 = objectInputStream.readInt();
            for (int i4 = 0; i4 < i3; i4++) {
                collection.add(objectInputStream.readObject());
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Maps.writeMultimap(this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public final Collection createCollection() {
        return CompactHashSet.createWithExpectedSize(this.expectedValuesPerKey);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final Collection entries() {
        return (Set) super.entries();
    }

    @Override // com.google.common.collect.Multimap
    public final Collection get(Object obj) {
        Collection collectionCreateCollection = (Collection) this.map.get(obj);
        if (collectionCreateCollection == null) {
            collectionCreateCollection = createCollection();
        }
        return (Set) wrapCollection(obj, collectionCreateCollection);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public final Collection wrapCollection(Object obj, Collection collection) {
        return new AbstractMapBasedMultimap.WrappedSet(this, obj, (Set) collection);
    }
}
