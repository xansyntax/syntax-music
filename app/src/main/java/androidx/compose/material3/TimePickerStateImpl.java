package androidx.compose.material3;

import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TimePickerStateImpl implements TimePickerState {
    public final ParcelableSnapshotMutableIntState hourInputState;
    public final ParcelableSnapshotMutableIntState hourState;
    public final boolean is24hour;
    public final ParcelableSnapshotMutableIntState minuteInputState;
    public final ParcelableSnapshotMutableIntState minuteState;
    public final ParcelableSnapshotMutableState selection$delegate;

    public TimePickerStateImpl(int i, int i2, int i3, boolean z) {
        if (i < 0 || i >= 24) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("initialHour should in [0..23] range");
            throw null;
        }
        if (i2 < 0 || i2 >= 60) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("initialMinute should be in [0..59] range");
            throw null;
        }
        this.is24hour = z;
        this.selection$delegate = Stack.mutableStateOf$default(new TimePickerSelectionMode(i3));
        this.hourState = new ParcelableSnapshotMutableIntState(i);
        this.minuteState = new ParcelableSnapshotMutableIntState(i2);
        this.hourInputState = new ParcelableSnapshotMutableIntState(i);
        this.minuteInputState = new ParcelableSnapshotMutableIntState(i2);
    }

    @Override // androidx.compose.material3.TimePickerState
    public final int getHour() {
        return this.hourState.getIntValue();
    }

    @Override // androidx.compose.material3.TimePickerState
    public final int getHourInput() {
        return this.hourInputState.getIntValue();
    }

    @Override // androidx.compose.material3.TimePickerState
    public final int getMinute() {
        return this.minuteState.getIntValue();
    }

    @Override // androidx.compose.material3.TimePickerState
    /* JADX INFO: renamed from: getSelection-yecRtBI */
    public final int mo241getSelectionyecRtBI() {
        return ((TimePickerSelectionMode) this.selection$delegate.getValue()).value;
    }

    @Override // androidx.compose.material3.TimePickerState
    public final boolean is24hour() {
        return this.is24hour;
    }

    @Override // androidx.compose.material3.TimePickerState
    public final void setHour(int i) {
        this.hourState.setIntValue(i);
        this.hourInputState.setIntValue(i);
    }

    @Override // androidx.compose.material3.TimePickerState
    public final void setHourInput(int i) {
        if (TimePickerKt.isValidHour(this, i)) {
            setHour(i);
        }
        this.hourInputState.setIntValue(i);
    }

    @Override // androidx.compose.material3.TimePickerState
    public final void setMinute(int i) {
        this.minuteState.setIntValue(i);
        this.minuteInputState.setIntValue(i);
    }

    @Override // androidx.compose.material3.TimePickerState
    public final void setMinuteInput(int i) {
        if (i >= 0 && i < 60) {
            setMinute(i);
        }
        this.minuteInputState.setIntValue(i);
    }

    @Override // androidx.compose.material3.TimePickerState
    /* JADX INFO: renamed from: setSelection-6_8s6DQ */
    public final void mo242setSelection6_8s6DQ(int i) {
        this.selection$delegate.setValue(new TimePickerSelectionMode(i));
    }
}
