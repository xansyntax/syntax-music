package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.snapshots.GlobalSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.snapshots.StateRecord;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.music.ui.component.BottomSheetKt$$ExternalSyntheticLambda9;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ParcelableSnapshotMutableIntState extends StateObjectImpl implements Parcelable, SnapshotMutableState, State, MutableState {
    public static final Parcelable.Creator<ParcelableSnapshotMutableIntState> CREATOR = new ParcelableSnapshotMutableIntState$Companion$CREATOR$1((byte) 0);
    public SnapshotMutableIntStateImpl$IntStateStateRecord next;

    public ParcelableSnapshotMutableIntState(int i) {
        Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
        SnapshotMutableIntStateImpl$IntStateStateRecord snapshotMutableIntStateImpl$IntStateStateRecord = new SnapshotMutableIntStateImpl$IntStateStateRecord(snapshotCurrentSnapshot.getSnapshotId(), i);
        if (!(snapshotCurrentSnapshot instanceof GlobalSnapshot)) {
            snapshotMutableIntStateImpl$IntStateStateRecord.next = new SnapshotMutableIntStateImpl$IntStateStateRecord(1L, i);
        }
        this.next = snapshotMutableIntStateImpl$IntStateStateRecord;
    }

    @Override // androidx.compose.runtime.MutableState
    public final Object component1() {
        return Integer.valueOf(getIntValue());
    }

    @Override // androidx.compose.runtime.MutableState
    public final Function1 component2() {
        return new BottomSheetKt$$ExternalSyntheticLambda9(this, (byte) 1);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord getFirstStateRecord() {
        return this.next;
    }

    public final int getIntValue() {
        return ((SnapshotMutableIntStateImpl$IntStateStateRecord) SnapshotKt.readable(this.next, this)).value;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMutableState
    public final NeverEqualPolicy getPolicy() {
        return NeverEqualPolicy.INSTANCE$3;
    }

    @Override // androidx.compose.runtime.State
    public final Object getValue() {
        return Integer.valueOf(getIntValue());
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        if (((SnapshotMutableIntStateImpl$IntStateStateRecord) stateRecord2).value == ((SnapshotMutableIntStateImpl$IntStateStateRecord) stateRecord3).value) {
            return stateRecord2;
        }
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final void prependStateRecord(StateRecord stateRecord) {
        this.next = (SnapshotMutableIntStateImpl$IntStateStateRecord) stateRecord;
    }

    public final void setIntValue(int i) {
        Snapshot snapshotCurrentSnapshot;
        SnapshotMutableIntStateImpl$IntStateStateRecord snapshotMutableIntStateImpl$IntStateStateRecord = (SnapshotMutableIntStateImpl$IntStateStateRecord) SnapshotKt.current(this.next, this);
        if (snapshotMutableIntStateImpl$IntStateStateRecord.value != i) {
            SnapshotMutableIntStateImpl$IntStateStateRecord snapshotMutableIntStateImpl$IntStateStateRecord2 = this.next;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                ((SnapshotMutableIntStateImpl$IntStateStateRecord) SnapshotKt.overwritableRecord(snapshotMutableIntStateImpl$IntStateStateRecord2, this, snapshotCurrentSnapshot, snapshotMutableIntStateImpl$IntStateStateRecord)).value = i;
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        }
    }

    @Override // androidx.compose.runtime.MutableState
    public final void setValue(Object obj) {
        setIntValue(((Number) obj).intValue());
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m(((SnapshotMutableIntStateImpl$IntStateStateRecord) SnapshotKt.current(this.next, this)).value, hashCode(), "MutableIntState(value=", ")@");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getIntValue());
    }
}
