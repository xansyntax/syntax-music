package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.snapshots.GlobalSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.snapshots.StateRecord;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda1;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ParcelableSnapshotMutableFloatState extends StateObjectImpl implements Parcelable, SnapshotMutableState, State, MutableState {
    public static final Parcelable.Creator<ParcelableSnapshotMutableFloatState> CREATOR = new ParcelableSnapshotMutableIntState$Companion$CREATOR$1((byte) 1);
    public SnapshotMutableFloatStateImpl$FloatStateStateRecord next;

    public ParcelableSnapshotMutableFloatState(float f) {
        Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
        SnapshotMutableFloatStateImpl$FloatStateStateRecord snapshotMutableFloatStateImpl$FloatStateStateRecord = new SnapshotMutableFloatStateImpl$FloatStateStateRecord(snapshotCurrentSnapshot.getSnapshotId(), f);
        if (!(snapshotCurrentSnapshot instanceof GlobalSnapshot)) {
            snapshotMutableFloatStateImpl$FloatStateStateRecord.next = new SnapshotMutableFloatStateImpl$FloatStateStateRecord(1L, f);
        }
        this.next = snapshotMutableFloatStateImpl$FloatStateStateRecord;
    }

    @Override // androidx.compose.runtime.MutableState
    public final Object component1() {
        return Float.valueOf(getFloatValue());
    }

    @Override // androidx.compose.runtime.MutableState
    public final Function1 component2() {
        return new PlayerKt$$ExternalSyntheticLambda1(this, (byte) 1);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord getFirstStateRecord() {
        return this.next;
    }

    public final float getFloatValue() {
        return ((SnapshotMutableFloatStateImpl$FloatStateStateRecord) SnapshotKt.readable(this.next, this)).value;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMutableState
    public final NeverEqualPolicy getPolicy() {
        return NeverEqualPolicy.INSTANCE$3;
    }

    @Override // androidx.compose.runtime.State
    public final Object getValue() {
        return Float.valueOf(getFloatValue());
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        if (((SnapshotMutableFloatStateImpl$FloatStateStateRecord) stateRecord2).value == ((SnapshotMutableFloatStateImpl$FloatStateStateRecord) stateRecord3).value) {
            return stateRecord2;
        }
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final void prependStateRecord(StateRecord stateRecord) {
        this.next = (SnapshotMutableFloatStateImpl$FloatStateStateRecord) stateRecord;
    }

    public final void setFloatValue(float f) {
        Snapshot snapshotCurrentSnapshot;
        SnapshotMutableFloatStateImpl$FloatStateStateRecord snapshotMutableFloatStateImpl$FloatStateStateRecord = (SnapshotMutableFloatStateImpl$FloatStateStateRecord) SnapshotKt.current(this.next, this);
        if (snapshotMutableFloatStateImpl$FloatStateStateRecord.value == f) {
            return;
        }
        SnapshotMutableFloatStateImpl$FloatStateStateRecord snapshotMutableFloatStateImpl$FloatStateStateRecord2 = this.next;
        synchronized (SnapshotKt.lock) {
            snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
            ((SnapshotMutableFloatStateImpl$FloatStateStateRecord) SnapshotKt.overwritableRecord(snapshotMutableFloatStateImpl$FloatStateStateRecord2, this, snapshotCurrentSnapshot, snapshotMutableFloatStateImpl$FloatStateStateRecord)).value = f;
        }
        SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
    }

    @Override // androidx.compose.runtime.MutableState
    public final void setValue(Object obj) {
        setFloatValue(((Number) obj).floatValue());
    }

    public final String toString() {
        return "MutableFloatState(value=" + ((SnapshotMutableFloatStateImpl$FloatStateStateRecord) SnapshotKt.current(this.next, this)).value + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(getFloatValue());
    }
}
