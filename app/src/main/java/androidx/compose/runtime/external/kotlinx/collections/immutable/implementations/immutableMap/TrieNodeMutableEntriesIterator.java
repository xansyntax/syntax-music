package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import com.google.protobuf.kotlin.UnmodifiableIterator;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TrieNodeMutableEntriesIterator extends TrieNodeBaseIterator {
    public final UnmodifiableIterator parentIterator;

    public TrieNodeMutableEntriesIterator(UnmodifiableIterator unmodifiableIterator) {
        this.parentIterator = unmodifiableIterator;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.index;
        this.index = i + 2;
        Object[] objArr = this.buffer;
        return new MutableMapEntry(this.parentIterator, objArr[i], objArr[i + 1]);
    }
}
