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
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ParcelableSnapshotMutableState extends StateObjectImpl implements Parcelable, SnapshotMutableState {
    public static final Parcelable.Creator<ParcelableSnapshotMutableState> CREATOR = new ParcelableSnapshotMutableState$Companion$CREATOR$1();
    public SnapshotMutableStateImpl$StateStateRecord next;
    public final NeverEqualPolicy policy;

    public ParcelableSnapshotMutableState(Object obj, NeverEqualPolicy neverEqualPolicy) {
        this.policy = neverEqualPolicy;
        Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
        SnapshotMutableStateImpl$StateStateRecord snapshotMutableStateImpl$StateStateRecord = new SnapshotMutableStateImpl$StateStateRecord(snapshotCurrentSnapshot.getSnapshotId(), obj);
        if (!(snapshotCurrentSnapshot instanceof GlobalSnapshot)) {
            snapshotMutableStateImpl$StateStateRecord.next = new SnapshotMutableStateImpl$StateStateRecord(1L, obj);
        }
        this.next = snapshotMutableStateImpl$StateStateRecord;
    }

    @Override // androidx.compose.runtime.MutableState
    public final Object component1() {
        return getValue();
    }

    @Override // androidx.compose.runtime.MutableState
    public final Function1 component2() {
        return new TextKt$$ExternalSyntheticLambda2((byte) 14, this);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord getFirstStateRecord() {
        return this.next;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMutableState
    public final NeverEqualPolicy getPolicy() {
        return this.policy;
    }

    @Override // androidx.compose.runtime.State
    public final Object getValue() {
        return ((SnapshotMutableStateImpl$StateStateRecord) SnapshotKt.readable(this.next, this)).value;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        if (this.policy.equivalent(((SnapshotMutableStateImpl$StateStateRecord) stateRecord2).value, ((SnapshotMutableStateImpl$StateStateRecord) stateRecord3).value)) {
            return stateRecord2;
        }
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final void prependStateRecord(StateRecord stateRecord) {
        this.next = (SnapshotMutableStateImpl$StateStateRecord) stateRecord;
    }

    @Override // androidx.compose.runtime.MutableState
    public final void setValue(Object obj) {
        Snapshot snapshotCurrentSnapshot;
        SnapshotMutableStateImpl$StateStateRecord snapshotMutableStateImpl$StateStateRecord = (SnapshotMutableStateImpl$StateStateRecord) SnapshotKt.current(this.next, this);
        if (this.policy.equivalent(snapshotMutableStateImpl$StateStateRecord.value, obj)) {
            return;
        }
        SnapshotMutableStateImpl$StateStateRecord snapshotMutableStateImpl$StateStateRecord2 = this.next;
        synchronized (SnapshotKt.lock) {
            snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
            ((SnapshotMutableStateImpl$StateStateRecord) SnapshotKt.overwritableRecord(snapshotMutableStateImpl$StateStateRecord2, this, snapshotCurrentSnapshot, snapshotMutableStateImpl$StateStateRecord)).value = obj;
        }
        SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
    }

    public final String toString() {
        return "MutableState(value=" + ((SnapshotMutableStateImpl$StateStateRecord) SnapshotKt.current(this.next, this)).value + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        parcel.writeValue(getValue());
        NeverEqualPolicy neverEqualPolicy = NeverEqualPolicy.INSTANCE;
        NeverEqualPolicy neverEqualPolicy2 = this.policy;
        if (Intrinsics.areEqual(neverEqualPolicy2, neverEqualPolicy)) {
            i2 = 0;
        } else if (Intrinsics.areEqual(neverEqualPolicy2, NeverEqualPolicy.INSTANCE$3)) {
            i2 = 1;
        } else {
            if (!Intrinsics.areEqual(neverEqualPolicy2, NeverEqualPolicy.INSTANCE$1)) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Only known types of MutableState's SnapshotMutationPolicy are supported");
                return;
            }
            i2 = 2;
        }
        parcel.writeInt(i2);
    }
}
