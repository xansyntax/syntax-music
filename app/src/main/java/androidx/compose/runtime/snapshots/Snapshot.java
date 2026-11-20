package androidx.compose.runtime.snapshots;

import androidx.compose.ui.ComposedModifierKt$$ExternalSyntheticLambda0;
import androidx.emoji2.text.EmojiProcessor;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Snapshot {
    public boolean disposed;
    public SnapshotIdSet invalid;
    public int pinningTrackingHandle;
    public long snapshotId;

    public Snapshot(long j, SnapshotIdSet snapshotIdSet) {
        int iAdd;
        int iNumberOfTrailingZeros;
        this.invalid = snapshotIdSet;
        this.snapshotId = j;
        ComposedModifierKt$$ExternalSyntheticLambda0 composedModifierKt$$ExternalSyntheticLambda0 = SnapshotKt.emptyLambda;
        if (j != 0) {
            SnapshotIdSet invalid$runtime = getInvalid$runtime();
            long j2 = invalid$runtime.lowerBound;
            long[] jArr = invalid$runtime.belowBound;
            if (jArr != null) {
                j = jArr[0];
            } else {
                long j3 = invalid$runtime.lowerSet;
                if (j3 != 0) {
                    iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j3);
                } else {
                    long j4 = invalid$runtime.upperSet;
                    if (j4 != 0) {
                        j2 += 64;
                        iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j4);
                    }
                }
                j = ((long) iNumberOfTrailingZeros) + j2;
            }
            synchronized (SnapshotKt.lock) {
                iAdd = SnapshotKt.pinningTable.add(j);
            }
        } else {
            iAdd = -1;
        }
        this.pinningTrackingHandle = iAdd;
    }

    public static void restoreCurrent(Snapshot snapshot) {
        SnapshotKt.threadSnapshot.set(snapshot);
    }

    public final void closeAndReleasePinning$runtime() {
        synchronized (SnapshotKt.lock) {
            closeLocked$runtime();
            releasePinnedSnapshotsForCloseLocked$runtime();
        }
    }

    public void closeLocked$runtime() {
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.clear(getSnapshotId());
    }

    public abstract void dispose();

    public SnapshotIdSet getInvalid$runtime() {
        return this.invalid;
    }

    public abstract Function1 getReadObserver();

    public boolean getReadOnly() {
        return false;
    }

    public long getSnapshotId() {
        return this.snapshotId;
    }

    public int getWriteCount$runtime() {
        return 0;
    }

    public Function1 getWriteObserver$runtime() {
        return null;
    }

    public final Snapshot makeCurrent() {
        EmojiProcessor emojiProcessor = SnapshotKt.threadSnapshot;
        Snapshot snapshot = (Snapshot) emojiProcessor.get();
        emojiProcessor.set(this);
        return snapshot;
    }

    public void nestedActivated$runtime() {
        SnapshotId_jvmKt.unsupported();
        throw null;
    }

    public void nestedDeactivated$runtime() {
        SnapshotId_jvmKt.unsupported();
        throw null;
    }

    public void recordModified$runtime(StateObject stateObject) {
        ComposedModifierKt$$ExternalSyntheticLambda0 composedModifierKt$$ExternalSyntheticLambda0 = SnapshotKt.emptyLambda;
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot");
    }

    public final void releasePinnedSnapshotLocked$runtime() {
        int i = this.pinningTrackingHandle;
        if (i >= 0) {
            SnapshotKt.releasePinningLocked(i);
            this.pinningTrackingHandle = -1;
        }
    }

    public void releasePinnedSnapshotsForCloseLocked$runtime() {
        releasePinnedSnapshotLocked$runtime();
    }

    public void setInvalid$runtime(SnapshotIdSet snapshotIdSet) {
        this.invalid = snapshotIdSet;
    }

    public void setSnapshotId$runtime(long j) {
        this.snapshotId = j;
    }

    public void setWriteCount$runtime(int i) {
        throw new IllegalStateException("Updating write count is not supported for this snapshot");
    }

    public abstract Snapshot takeNestedSnapshot(Function1 function1);

    public void notifyObjectsInitialized$runtime() {
    }
}
