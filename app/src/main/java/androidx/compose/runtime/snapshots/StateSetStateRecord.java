package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StateSetStateRecord extends StateRecord {
    public int modification;
    public PersistentOrderedSet set;

    public StateSetStateRecord(long j, PersistentOrderedSet persistentOrderedSet) {
        super(j);
        this.set = persistentOrderedSet;
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public final void assign(StateRecord stateRecord) {
        synchronized (SnapshotId_jvmKt.sync$2) {
            stateRecord.getClass();
            this.set = ((StateSetStateRecord) stateRecord).set;
            this.modification = ((StateSetStateRecord) stateRecord).modification;
        }
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public final StateRecord create(long j) {
        return new StateSetStateRecord(j, this.set);
    }
}
