package kotlin.collections.builders;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilderKeysIterator;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeKeysIterator;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.AbstractMutableCollection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class MapBuilderValues extends AbstractMutableCollection {
    public final /* synthetic */ byte $r8$classId;
    public final Object backing;

    public /* synthetic */ MapBuilderValues(byte b, Object obj) {
        this.$r8$classId = b;
        this.backing = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection collection) {
        switch (this.$r8$classId) {
            case 0:
                collection.getClass();
                throw new UnsupportedOperationException();
            default:
                return super.addAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        byte b = this.$r8$classId;
        Object obj = this.backing;
        switch (b) {
            case 0:
                ((MapBuilder) obj).clear();
                break;
            default:
                ((PersistentHashMapBuilder) obj).clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        byte b = this.$r8$classId;
        Object obj2 = this.backing;
        switch (b) {
            case 0:
                return ((MapBuilder) obj2).containsValue(obj);
            default:
                return ((PersistentHashMapBuilder) obj2).containsValue(obj);
        }
    }

    @Override // kotlin.collections.AbstractMutableCollection
    public final int getSize() {
        byte b = this.$r8$classId;
        Object obj = this.backing;
        switch (b) {
            case 0:
                return ((MapBuilder) obj).size;
            default:
                return ((PersistentHashMapBuilder) obj).size;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        switch (this.$r8$classId) {
            case 0:
                return ((MapBuilder) this.backing).isEmpty();
            default:
                return super.isEmpty();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        byte b = this.$r8$classId;
        Object obj = this.backing;
        switch (b) {
            case 0:
                return new MapBuilder.KeysItr((MapBuilder) obj, (byte) 2);
            default:
                PersistentHashMapBuilder persistentHashMapBuilder = (PersistentHashMapBuilder) obj;
                TrieNodeBaseIterator[] trieNodeBaseIteratorArr = new TrieNodeBaseIterator[8];
                for (int i = 0; i < 8; i++) {
                    trieNodeBaseIteratorArr[i] = new TrieNodeKeysIterator((byte) 2);
                }
                return new PersistentHashMapBuilderKeysIterator(persistentHashMapBuilder, trieNodeBaseIteratorArr);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                MapBuilder mapBuilder = (MapBuilder) this.backing;
                mapBuilder.checkIsMutable$kotlin_stdlib();
                int iFindValue = mapBuilder.findValue(obj);
                if (iFindValue < 0) {
                    return false;
                }
                mapBuilder.removeEntryAt(iFindValue);
                return true;
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        switch (this.$r8$classId) {
            case 0:
                collection.getClass();
                ((MapBuilder) this.backing).checkIsMutable$kotlin_stdlib();
                break;
        }
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection collection) {
        switch (this.$r8$classId) {
            case 0:
                collection.getClass();
                ((MapBuilder) this.backing).checkIsMutable$kotlin_stdlib();
                break;
        }
        return super.retainAll(collection);
    }
}
