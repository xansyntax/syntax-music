package androidx.compose.runtime.snapshots;

import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList;
import java.util.ListIterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StateListIterator implements ListIterator, KMappedMarker {
    public int index;
    public int lastRequested = -1;
    public AbstractPersistentList list;
    public final SnapshotStateList stateList;
    public int structure;

    public StateListIterator(SnapshotStateList snapshotStateList, int i) {
        this.stateList = snapshotStateList;
        this.index = i - 1;
        this.list = SnapshotId_jvmKt.getReadable(snapshotStateList).list;
        this.structure = SnapshotId_jvmKt.getStructure(snapshotStateList);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        validateModification();
        int i = this.index + 1;
        SnapshotStateList snapshotStateList = this.stateList;
        snapshotStateList.add(i, obj);
        this.lastRequested = -1;
        this.index++;
        this.list = SnapshotId_jvmKt.getReadable(snapshotStateList).list;
        this.structure = SnapshotId_jvmKt.getStructure(snapshotStateList);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.index < this.list.getSize() - 1;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.index >= 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        validateModification();
        int i = this.index + 1;
        this.lastRequested = i;
        SnapshotId_jvmKt.validateRange(i, this.list.getSize());
        Object obj = this.list.get(i);
        this.index = i;
        return obj;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.index + 1;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        validateModification();
        SnapshotId_jvmKt.validateRange(this.index, this.list.getSize());
        int i = this.index;
        this.lastRequested = i;
        Object obj = this.list.get(i);
        this.index--;
        return obj;
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.index;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        validateModification();
        int i = this.lastRequested;
        SnapshotStateList snapshotStateList = this.stateList;
        snapshotStateList.remove(i);
        this.index--;
        this.lastRequested = -1;
        this.list = SnapshotId_jvmKt.getReadable(snapshotStateList).list;
        this.structure = SnapshotId_jvmKt.getStructure(snapshotStateList);
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        validateModification();
        int i = this.lastRequested;
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Cannot call set before the first call to next() or previous() or immediately after a call to add() or remove()");
            return;
        }
        SnapshotStateList snapshotStateList = this.stateList;
        snapshotStateList.set(i, obj);
        this.list = SnapshotId_jvmKt.getReadable(snapshotStateList).list;
        this.structure = SnapshotId_jvmKt.getStructure(snapshotStateList);
    }

    public final void validateModification() {
        if (SnapshotId_jvmKt.getStructure(this.stateList) == this.structure) {
            return;
        }
        MarqueeSpacing$Companion$$ExternalSyntheticLambda0.m52m();
    }
}
