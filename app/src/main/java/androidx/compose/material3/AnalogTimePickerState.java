package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.Dp;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AnalogTimePickerState implements TimePickerState, RememberObserver {
    public Animatable anim;
    public float hourAngle;
    public float minuteAngle;
    public final TimePickerState state;
    public final Ref userOverride;
    public final ParcelableSnapshotMutableState currentDiameter$delegate = Stack.mutableStateOf$default(new Dp(CropImageView.DEFAULT_ASPECT_RATIO));
    public final ParcelableSnapshotMutableState isDialFocusable$delegate = Stack.mutableStateOf$default(Boolean.FALSE);
    public final FocusRequester dialFocusRequester = new FocusRequester();
    public final FocusRequester hourNodeFocusRequester = new FocusRequester();
    public final FocusRequester minuteNodeFocusRequester = new FocusRequester();
    public final FocusRequester amPmNodeFocusRequester = new FocusRequester();
    public final MutatorMutex mutex = new MutatorMutex();

    public AnalogTimePickerState(TimePickerState timePickerState, Ref ref) {
        this.state = timePickerState;
        this.userOverride = ref;
        this.hourAngle = ((timePickerState.getHour() % 12) * 0.5235988f) - 1.5707964f;
        this.minuteAngle = (timePickerState.getMinute() * 0.10471976f) - 1.5707964f;
        this.anim = ArcSplineKt.Animatable$default(this.hourAngle);
    }

    public static float normalize(float f) {
        double d = ((double) f) % 6.283185307179586d;
        if (d < 0.0d) {
            d += 6.283185307179586d;
        }
        return (float) d;
    }

    public final float endValueForAnimation(float f) {
        float fFloatValue = ((Number) this.anim.getValue()).floatValue() - f;
        while (fFloatValue > 3.1415927f) {
            fFloatValue -= 6.2831855f;
        }
        while (fFloatValue <= -3.1415927f) {
            fFloatValue += 6.2831855f;
        }
        return ((Number) this.anim.getValue()).floatValue() - fFloatValue;
    }

    /* JADX INFO: renamed from: getCurrentDiameter-D9Ej5fM, reason: not valid java name */
    public final float m240getCurrentDiameterD9Ej5fM() {
        return ((Dp) this.currentDiameter$delegate.getValue()).value;
    }

    @Override // androidx.compose.material3.TimePickerState
    public final int getHour() {
        return this.state.getHour();
    }

    @Override // androidx.compose.material3.TimePickerState
    public final int getHourInput() {
        return this.state.getHour();
    }

    @Override // androidx.compose.material3.TimePickerState
    public final int getMinute() {
        return this.state.getMinute();
    }

    @Override // androidx.compose.material3.TimePickerState
    /* JADX INFO: renamed from: getSelection-yecRtBI, reason: not valid java name */
    public final int mo241getSelectionyecRtBI() {
        return this.state.mo241getSelectionyecRtBI();
    }

    @Override // androidx.compose.material3.TimePickerState
    public final boolean is24hour() {
        return this.state.is24hour();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onRemembered() {
        TimePickerState timePickerState = this.state;
        this.hourAngle = ((timePickerState.getHour() % 12) * 0.5235988f) - 1.5707964f;
        this.minuteAngle = (timePickerState.getMinute() * 0.10471976f) - 1.5707964f;
        this.anim = ArcSplineKt.Animatable$default(timePickerState.mo241getSelectionyecRtBI() == 0 ? this.hourAngle : this.minuteAngle);
    }

    public final void setDialFocusable(boolean z) {
        this.isDialFocusable$delegate.setValue(Boolean.valueOf(z));
    }

    @Override // androidx.compose.material3.TimePickerState
    public final void setHour(int i) {
        this.state.setHour(i);
    }

    @Override // androidx.compose.material3.TimePickerState
    public final void setHourInput(int i) {
        this.hourAngle = ((i % 12) * 0.5235988f) - 1.5707964f;
        TimePickerState timePickerState = this.state;
        timePickerState.setHour(i);
        if (timePickerState.mo241getSelectionyecRtBI() == 0) {
            this.anim = ArcSplineKt.Animatable$default(this.hourAngle);
        }
    }

    @Override // androidx.compose.material3.TimePickerState
    public final void setMinute(int i) {
        this.state.setMinute(i);
    }

    @Override // androidx.compose.material3.TimePickerState
    public final void setMinuteInput(int i) {
        this.minuteAngle = (i * 0.10471976f) - 1.5707964f;
        TimePickerState timePickerState = this.state;
        timePickerState.setMinute(i);
        if (timePickerState.mo241getSelectionyecRtBI() == 1) {
            this.anim = ArcSplineKt.Animatable$default(this.minuteAngle);
        }
    }

    @Override // androidx.compose.material3.TimePickerState
    /* JADX INFO: renamed from: setSelection-6_8s6DQ, reason: not valid java name */
    public final void mo242setSelection6_8s6DQ(int i) {
        this.state.mo242setSelection6_8s6DQ(i);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onAbandoned() {
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onForgotten() {
    }
}
