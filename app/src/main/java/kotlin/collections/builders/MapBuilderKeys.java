package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class MapBuilderKeys extends AbstractMutableSet {
    public final /* synthetic */ byte $r8$classId;
    public final MapBuilder backing;

    public /* synthetic */ MapBuilderKeys(MapBuilder mapBuilder, byte b) {
        this.$r8$classId = b;
        this.backing = mapBuilder;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                ((Map.Entry) obj).getClass();
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        byte b = this.$r8$classId;
        collection.getClass();
        switch (b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        byte b = this.$r8$classId;
        MapBuilder mapBuilder = this.backing;
        switch (b) {
            case 0:
                mapBuilder.clear();
                break;
            default:
                mapBuilder.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        byte b = this.$r8$classId;
        MapBuilder mapBuilder = this.backing;
        switch (b) {
            case 0:
                return mapBuilder.containsKey(obj);
            default:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                int iFindKey = mapBuilder.findKey(entry.getKey());
                if (iFindKey < 0) {
                    return false;
                }
                Object[] objArr = mapBuilder.valuesArray;
                objArr.getClass();
                return Intrinsics.areEqual(objArr[iFindKey], entry.getValue());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        switch (this.$r8$classId) {
            case 1:
                collection.getClass();
                return this.backing.containsAllEntries$kotlin_stdlib(collection);
            default:
                return super.containsAll(collection);
        }
    }

    @Override // kotlin.collections.AbstractMutableSet
    public final int getSize() {
        byte b = this.$r8$classId;
        MapBuilder mapBuilder = this.backing;
        switch (b) {
            case 0:
                break;
        }
        return mapBuilder.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        byte b = this.$r8$classId;
        MapBuilder mapBuilder = this.backing;
        switch (b) {
            case 0:
                break;
        }
        return mapBuilder.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        byte b = this.$r8$classId;
        MapBuilder mapBuilder = this.backing;
        switch (b) {
            case 0:
                return new MapBuilder.KeysItr(mapBuilder, (byte) 0);
            default:
                return new MapBuilder.KeysItr(mapBuilder, (byte) 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        byte b = this.$r8$classId;
        MapBuilder mapBuilder = this.backing;
        switch (b) {
            case 0:
                mapBuilder.checkIsMutable$kotlin_stdlib();
                int iFindKey = mapBuilder.findKey(obj);
                if (iFindKey < 0) {
                    return false;
                }
                mapBuilder.removeEntryAt(iFindKey);
                return true;
            default:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    mapBuilder.checkIsMutable$kotlin_stdlib();
                    int iFindKey2 = mapBuilder.findKey(entry.getKey());
                    if (iFindKey2 >= 0) {
                        Object[] objArr = mapBuilder.valuesArray;
                        objArr.getClass();
                        if (Intrinsics.areEqual(objArr[iFindKey2], entry.getValue())) {
                            mapBuilder.removeEntryAt(iFindKey2);
                            return true;
                        }
                    }
                }
                return false;
        }
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        byte b = this.$r8$classId;
        MapBuilder mapBuilder = this.backing;
        collection.getClass();
        switch (b) {
            case 0:
                mapBuilder.checkIsMutable$kotlin_stdlib();
                break;
            default:
                mapBuilder.checkIsMutable$kotlin_stdlib();
                break;
        }
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        byte b = this.$r8$classId;
        MapBuilder mapBuilder = this.backing;
        collection.getClass();
        switch (b) {
            case 0:
                mapBuilder.checkIsMutable$kotlin_stdlib();
                break;
            default:
                mapBuilder.checkIsMutable$kotlin_stdlib();
                break;
        }
        return super.retainAll(collection);
    }
}
