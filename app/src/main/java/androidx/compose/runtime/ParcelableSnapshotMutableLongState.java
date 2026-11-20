package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.snapshots.GlobalSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ParcelableSnapshotMutableLongState extends StateObjectImpl implements Parcelable, SnapshotMutableState, State, MutableState {
    public static final Parcelable.Creator<ParcelableSnapshotMutableLongState> CREATOR = new ParcelableSnapshotMutableIntState$Companion$CREATOR$1((byte) 2);
    public SnapshotMutableLongStateImpl$LongStateStateRecord next;

    public ParcelableSnapshotMutableLongState(long j) {
        Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
        SnapshotMutableLongStateImpl$LongStateStateRecord snapshotMutableLongStateImpl$LongStateStateRecord = new SnapshotMutableLongStateImpl$LongStateStateRecord(snapshotCurrentSnapshot.getSnapshotId(), j);
        if (!(snapshotCurrentSnapshot instanceof GlobalSnapshot)) {
            snapshotMutableLongStateImpl$LongStateStateRecord.next = new SnapshotMutableLongStateImpl$LongStateStateRecord(1L, j);
        }
        this.next = snapshotMutableLongStateImpl$LongStateStateRecord;
    }

    @Override // androidx.compose.runtime.MutableState
    public final Object component1() {
        return Long.valueOf(getLongValue());
    }

    @Override // androidx.compose.runtime.MutableState
    public final Function1 component2() {
        return new TextKt$$ExternalSyntheticLambda2((byte) 13, this);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord getFirstStateRecord() {
        return this.next;
    }

    public final long getLongValue() {
        return ((SnapshotMutableLongStateImpl$LongStateStateRecord) SnapshotKt.readable(this.next, this)).value;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMutableState
    public final NeverEqualPolicy getPolicy() {
        return NeverEqualPolicy.INSTANCE$3;
    }

    @Override // androidx.compose.runtime.State
    public final Object getValue() {
        return Long.valueOf(getLongValue());
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        if (((SnapshotMutableLongStateImpl$LongStateStateRecord) stateRecord2).value == ((SnapshotMutableLongStateImpl$LongStateStateRecord) stateRecord3).value) {
            return stateRecord2;
        }
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final void prependStateRecord(StateRecord stateRecord) {
        this.next = (SnapshotMutableLongStateImpl$LongStateStateRecord) stateRecord;
    }

    public final void setLongValue(long j) {
        Snapshot snapshotCurrentSnapshot;
        SnapshotMutableLongStateImpl$LongStateStateRecord snapshotMutableLongStateImpl$LongStateStateRecord = (SnapshotMutableLongStateImpl$LongStateStateRecord) SnapshotKt.current(this.next, this);
        if (snapshotMutableLongStateImpl$LongStateStateRecord.value != j) {
            SnapshotMutableLongStateImpl$LongStateStateRecord snapshotMutableLongStateImpl$LongStateStateRecord2 = this.next;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                ((SnapshotMutableLongStateImpl$LongStateStateRecord) SnapshotKt.overwritableRecord(snapshotMutableLongStateImpl$LongStateStateRecord2, this, snapshotCurrentSnapshot, snapshotMutableLongStateImpl$LongStateStateRecord)).value = j;
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        }
    }

    @Override // androidx.compose.runtime.MutableState
    public final void setValue(Object obj) {
        setLongValue(((Number) obj).longValue());
    }

    public final String toString() {
        return "MutableLongState(value=" + ((SnapshotMutableLongStateImpl$LongStateStateRecord) SnapshotKt.current(this.next, this)).value + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(getLongValue());
    }
}
