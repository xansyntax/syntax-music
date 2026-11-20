package androidx.compose.runtime.snapshots;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NestedReadonlySnapshot extends Snapshot {
    public final Snapshot parent;
    public final Function1 readObserver;

    public NestedReadonlySnapshot(long j, SnapshotIdSet snapshotIdSet, Function1 function1, Snapshot snapshot) {
        super(j, snapshotIdSet);
        this.readObserver = function1;
        this.parent = snapshot;
        snapshot.nestedActivated$runtime();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void dispose() {
        Snapshot snapshot = this.parent;
        if (this.disposed) {
            return;
        }
        if (this.snapshotId != snapshot.getSnapshotId()) {
            closeAndReleasePinning$runtime();
        }
        snapshot.nestedDeactivated$runtime();
        this.disposed = true;
        synchronized (SnapshotKt.lock) {
            releasePinnedSnapshotLocked$runtime();
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final Function1 getReadObserver() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final boolean getReadOnly() {
        return true;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final Snapshot takeNestedSnapshot(Function1 function1) {
        return new NestedReadonlySnapshot(this.snapshotId, this.invalid, SnapshotKt.mergedReadObserver(function1, this.readObserver, true), this.parent);
    }
}
