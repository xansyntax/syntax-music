package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.SubSequence;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentOrderedSetMutableIterator extends SubSequence.AnonymousClass1 {
    public final PersistentOrderedSetBuilder builder;
    public int expectedModCount;
    public Object lastIteratedElement;
    public boolean nextWasInvoked;

    /* JADX WARN: Illegal instructions before constructor call */
    public PersistentOrderedSetMutableIterator(PersistentOrderedSetBuilder persistentOrderedSetBuilder) {
        Object obj = persistentOrderedSetBuilder.firstElement;
        PersistentHashMapBuilder persistentHashMapBuilder = persistentOrderedSetBuilder.hashMapBuilder;
        super(persistentHashMapBuilder, obj);
        this.builder = persistentOrderedSetBuilder;
        this.expectedModCount = persistentHashMapBuilder.modCount;
    }

    @Override // kotlin.sequences.SubSequence.AnonymousClass1, java.util.Iterator
    public final Object next() {
        if (this.builder.hashMapBuilder.modCount != this.expectedModCount) {
            MarqueeSpacing$Companion$$ExternalSyntheticLambda0.m52m();
            return null;
        }
        Object next = super.next();
        this.lastIteratedElement = next;
        this.nextWasInvoked = true;
        return next;
    }

    @Override // kotlin.sequences.SubSequence.AnonymousClass1, java.util.Iterator
    public final void remove() {
        if (!this.nextWasInvoked) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m();
            return;
        }
        Object obj = this.lastIteratedElement;
        PersistentOrderedSetBuilder persistentOrderedSetBuilder = this.builder;
        TypeIntrinsics.asMutableCollection(persistentOrderedSetBuilder).remove(obj);
        this.lastIteratedElement = null;
        this.nextWasInvoked = false;
        this.expectedModCount = persistentOrderedSetBuilder.hashMapBuilder.modCount;
        this.position--;
    }
}
