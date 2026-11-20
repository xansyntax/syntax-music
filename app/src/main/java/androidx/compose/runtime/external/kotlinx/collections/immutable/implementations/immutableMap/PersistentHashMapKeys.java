package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.AbstractSet;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentHashMapKeys extends AbstractSet implements ImmutableSet {
    public final /* synthetic */ byte $r8$classId;
    public final PersistentHashMap map;

    public /* synthetic */ PersistentHashMapKeys(PersistentHashMap persistentHashMap, byte b) {
        this.$r8$classId = b;
        this.map = persistentHashMap;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        byte b = this.$r8$classId;
        PersistentHashMap persistentHashMap = this.map;
        switch (b) {
            case 0:
                return persistentHashMap.containsKey(obj);
            default:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object obj2 = persistentHashMap.get(entry.getKey());
                    if (obj2 != null) {
                        return obj2.equals(entry.getValue());
                    }
                    if (entry.getValue() == null && persistentHashMap.containsKey(entry.getKey())) {
                        return true;
                    }
                }
                return false;
        }
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        byte b = this.$r8$classId;
        PersistentHashMap persistentHashMap = this.map;
        switch (b) {
            case 0:
                break;
        }
        return persistentHashMap.size;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        byte b = this.$r8$classId;
        PersistentHashMap persistentHashMap = this.map;
        switch (b) {
            case 0:
                TrieNode trieNode = persistentHashMap.node;
                TrieNodeBaseIterator[] trieNodeBaseIteratorArr = new TrieNodeBaseIterator[8];
                for (int i = 0; i < 8; i++) {
                    trieNodeBaseIteratorArr[i] = new TrieNodeKeysIterator((byte) 0);
                }
                return new PersistentHashMapKeysIterator(trieNode, trieNodeBaseIteratorArr);
            default:
                TrieNode trieNode2 = persistentHashMap.node;
                TrieNodeBaseIterator[] trieNodeBaseIteratorArr2 = new TrieNodeBaseIterator[8];
                for (int i2 = 0; i2 < 8; i2++) {
                    trieNodeBaseIteratorArr2[i2] = new TrieNodeKeysIterator((byte) 1);
                }
                return new PersistentHashMapKeysIterator(trieNode2, trieNodeBaseIteratorArr2);
        }
    }
}
