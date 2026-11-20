package androidx.compose.runtime.external.kotlinx.collections.immutable;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList;
import coil3.util.LifecyclesKt;
import java.util.List;
import kotlin.collections.AbstractList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ImmutableList$SubList extends AbstractList {
    public final int _size;
    public final int fromIndex;
    public final AbstractPersistentList source;

    public ImmutableList$SubList(AbstractPersistentList abstractPersistentList, int i, int i2) {
        this.source = abstractPersistentList;
        this.fromIndex = i;
        LifecyclesKt.checkRangeIndexes$runtime(i, i2, abstractPersistentList.getSize());
        this._size = i2 - i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        LifecyclesKt.checkElementIndex$runtime(i, this._size);
        return this.source.get(this.fromIndex + i);
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return this._size;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        LifecyclesKt.checkRangeIndexes$runtime(i, i2, this._size);
        int i3 = this.fromIndex;
        return new ImmutableList$SubList(this.source, i + i3, i3 + i2);
    }
}
