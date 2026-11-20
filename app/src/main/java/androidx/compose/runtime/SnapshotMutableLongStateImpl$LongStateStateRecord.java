package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.StateRecord;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotMutableLongStateImpl$LongStateStateRecord extends StateRecord {
    public long value;

    public SnapshotMutableLongStateImpl$LongStateStateRecord(long j, long j2) {
        super(j);
        this.value = j2;
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public final void assign(StateRecord stateRecord) {
        stateRecord.getClass();
        this.value = ((SnapshotMutableLongStateImpl$LongStateStateRecord) stateRecord).value;
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public final StateRecord create(long j) {
        return new SnapshotMutableLongStateImpl$LongStateStateRecord(j, this.value);
    }
}
