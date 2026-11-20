package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.DerivedSnapshotState;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class StateRecord {
    public StateRecord next;
    public long snapshotId;

    public StateRecord(long j) {
        this.snapshotId = j;
    }

    public abstract void assign(StateRecord stateRecord);

    public StateRecord create(long j) {
        return new DerivedSnapshotState.ResultRecord(j);
    }
}
