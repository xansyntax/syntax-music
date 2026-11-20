package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.Latch$await$2$2;
import androidx.compose.runtime.MonotonicFrameClockKt$withFrameMillis$2;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GlobalSnapshot extends MutableSnapshot {
    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public final SnapshotId_jvmKt apply() {
        throw new IllegalStateException("Cannot apply the global snapshot directly. Call Snapshot.advanceGlobalSnapshot");
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public final void dispose() {
        synchronized (SnapshotKt.lock) {
            releasePinnedSnapshotLocked$runtime();
        }
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public final void nestedActivated$runtime() {
        SnapshotId_jvmKt.unsupported();
        throw null;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public final void nestedDeactivated$runtime() {
        SnapshotId_jvmKt.unsupported();
        throw null;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public final void notifyObjectsInitialized$runtime() {
        SnapshotKt.advanceGlobalSnapshot();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public final MutableSnapshot takeNestedMutableSnapshot(Function1 function1, Function1 function2) {
        return (MutableSnapshot) ((Snapshot) SnapshotKt.advanceGlobalSnapshot(new CodecsKt$$ExternalSyntheticLambda0(new Latch$await$2$2(function1, function2, (byte) 3), (byte) 10)));
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public final Snapshot takeNestedSnapshot(Function1 function1) {
        return (ReadonlySnapshot) ((Snapshot) SnapshotKt.advanceGlobalSnapshot(new CodecsKt$$ExternalSyntheticLambda0(new MonotonicFrameClockKt$withFrameMillis$2(function1, (byte) 1), (byte) 10)));
    }
}
