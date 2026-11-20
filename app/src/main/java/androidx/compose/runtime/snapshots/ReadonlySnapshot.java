package androidx.compose.runtime.snapshots;

import androidx.compose.ui.ComposedModifierKt$$ExternalSyntheticLambda0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ReadonlySnapshot extends Snapshot {
    public final Function1 readObserver;
    public int snapshots;

    public ReadonlySnapshot(long j, SnapshotIdSet snapshotIdSet, Function1 function1) {
        super(j, snapshotIdSet);
        this.readObserver = function1;
        this.snapshots = 1;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void dispose() {
        if (this.disposed) {
            return;
        }
        nestedDeactivated$runtime();
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
    public final Function1 getWriteObserver$runtime() {
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void nestedActivated$runtime() {
        this.snapshots++;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void nestedDeactivated$runtime() {
        int i = this.snapshots - 1;
        this.snapshots = i;
        if (i == 0) {
            closeAndReleasePinning$runtime();
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void recordModified$runtime(StateObject stateObject) {
        ComposedModifierKt$$ExternalSyntheticLambda0 composedModifierKt$$ExternalSyntheticLambda0 = SnapshotKt.emptyLambda;
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot");
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final Snapshot takeNestedSnapshot(Function1 function1) {
        SnapshotKt.validateOpen(this);
        return new NestedReadonlySnapshot(this.snapshotId, this.invalid, SnapshotKt.mergedReadObserver(function1, this.readObserver, true), this);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void notifyObjectsInitialized$runtime() {
    }
}
