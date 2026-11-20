package com.google.protobuf.kotlin;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilderBaseIterator;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeMutableEntriesIterator;
import androidx.compose.ui.graphics.vector.VectorGroup;
import androidx.compose.ui.graphics.vector.VectorNode;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class UnmodifiableIterator implements Iterator, KMappedMarker {
    public final Iterator $$delegate_0;
    public final /* synthetic */ byte $r8$classId = 2;

    public UnmodifiableIterator(PersistentHashMapBuilder persistentHashMapBuilder) {
        TrieNodeBaseIterator[] trieNodeBaseIteratorArr = new TrieNodeBaseIterator[8];
        for (int i = 0; i < 8; i++) {
            trieNodeBaseIteratorArr[i] = new TrieNodeMutableEntriesIterator(this);
        }
        this.$$delegate_0 = new PersistentHashMapBuilderBaseIterator(persistentHashMapBuilder, trieNodeBaseIteratorArr);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.$r8$classId) {
            case 0:
                return this.$$delegate_0.hasNext();
            case 1:
                return this.$$delegate_0.hasNext();
            default:
                return ((PersistentHashMapBuilderBaseIterator) this.$$delegate_0).hasNext;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.$r8$classId) {
            case 0:
                return this.$$delegate_0.next();
            case 1:
                return (VectorNode) this.$$delegate_0.next();
            default:
                return (Map.Entry) ((PersistentHashMapBuilderBaseIterator) this.$$delegate_0).next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                ((PersistentHashMapBuilderBaseIterator) this.$$delegate_0).remove();
                return;
        }
    }

    public UnmodifiableIterator(Iterator it) {
        it.getClass();
        this.$$delegate_0 = it;
    }

    public UnmodifiableIterator(VectorGroup vectorGroup) {
        this.$$delegate_0 = vectorGroup.children.iterator();
    }
}
