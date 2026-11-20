package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import com.google.protobuf.kotlin.UnmodifiableIterator;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.AbstractMutableSet;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentHashMapBuilderKeys extends AbstractMutableSet {
    public final /* synthetic */ byte $r8$classId;
    public final PersistentHashMapBuilder builder;

    public /* synthetic */ PersistentHashMapBuilderKeys(PersistentHashMapBuilder persistentHashMapBuilder, byte b) {
        this.$r8$classId = b;
        this.builder = persistentHashMapBuilder;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        byte b = this.$r8$classId;
        PersistentHashMapBuilder persistentHashMapBuilder = this.builder;
        switch (b) {
            case 0:
                persistentHashMapBuilder.clear();
                break;
            default:
                persistentHashMapBuilder.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return this.builder.containsKey(obj);
            default:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    PersistentHashMapBuilder persistentHashMapBuilder = this.builder;
                    Object obj2 = persistentHashMapBuilder.get(key);
                    if (obj2 != null) {
                        return obj2.equals(entry.getValue());
                    }
                    if (entry.getValue() == null && persistentHashMapBuilder.containsKey(entry.getKey())) {
                        return true;
                    }
                }
                return false;
        }
    }

    @Override // kotlin.collections.AbstractMutableSet
    public final int getSize() {
        byte b = this.$r8$classId;
        PersistentHashMapBuilder persistentHashMapBuilder = this.builder;
        switch (b) {
            case 0:
                break;
        }
        return persistentHashMapBuilder.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        byte b = this.$r8$classId;
        PersistentHashMapBuilder persistentHashMapBuilder = this.builder;
        switch (b) {
            case 0:
                TrieNodeBaseIterator[] trieNodeBaseIteratorArr = new TrieNodeBaseIterator[8];
                for (int i = 0; i < 8; i++) {
                    trieNodeBaseIteratorArr[i] = new TrieNodeKeysIterator((byte) 0);
                }
                return new PersistentHashMapBuilderKeysIterator(persistentHashMapBuilder, trieNodeBaseIteratorArr);
            default:
                return new UnmodifiableIterator(persistentHashMapBuilder);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                PersistentHashMapBuilder persistentHashMapBuilder = this.builder;
                if (!persistentHashMapBuilder.containsKey(obj)) {
                    return false;
                }
                persistentHashMapBuilder.remove(obj);
                return true;
            default:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return this.builder.remove(entry.getKey(), entry.getValue());
        }
    }
}
