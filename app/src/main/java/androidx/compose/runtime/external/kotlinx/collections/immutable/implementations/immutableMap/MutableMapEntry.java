package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.collection.MapEntry;
import com.google.protobuf.kotlin.UnmodifiableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableMapEntry extends MapEntry implements KMutableMap.Entry {
    public final UnmodifiableIterator parentIterator;
    public Object value;

    public MutableMapEntry(UnmodifiableIterator unmodifiableIterator, Object obj, Object obj2) {
        super(obj, obj2, (byte) 1);
        this.parentIterator = unmodifiableIterator;
        this.value = obj2;
    }

    @Override // androidx.collection.MapEntry, java.util.Map.Entry
    public final Object getValue() {
        return this.value;
    }

    @Override // androidx.collection.MapEntry, java.util.Map.Entry
    public final Object setValue(Object obj) {
        Object obj2 = this.value;
        this.value = obj;
        PersistentHashMapBuilderBaseIterator persistentHashMapBuilderBaseIterator = (PersistentHashMapBuilderBaseIterator) this.parentIterator.$$delegate_0;
        PersistentHashMapBuilder persistentHashMapBuilder = persistentHashMapBuilderBaseIterator.builder;
        Object obj3 = this.key;
        if (!persistentHashMapBuilder.containsKey(obj3)) {
            return obj2;
        }
        boolean z = persistentHashMapBuilderBaseIterator.hasNext;
        if (!z) {
            persistentHashMapBuilder.put(obj3, obj);
        } else {
            if (!z) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                return null;
            }
            TrieNodeBaseIterator trieNodeBaseIterator = persistentHashMapBuilderBaseIterator.path[persistentHashMapBuilderBaseIterator.pathLastIndex];
            Object obj4 = trieNodeBaseIterator.buffer[trieNodeBaseIterator.index];
            persistentHashMapBuilder.put(obj3, obj);
            persistentHashMapBuilderBaseIterator.resetPath(obj4 != null ? obj4.hashCode() : 0, persistentHashMapBuilder.node, obj4, 0);
        }
        persistentHashMapBuilderBaseIterator.expectedModCount = persistentHashMapBuilder.modCount;
        return obj2;
    }
}
