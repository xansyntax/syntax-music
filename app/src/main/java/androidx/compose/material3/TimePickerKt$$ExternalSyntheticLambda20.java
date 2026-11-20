package androidx.compose.material3;

import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusStateImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TimePickerKt$$ExternalSyntheticLambda20 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ TimePickerState f$0;

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda20(TimePickerState timePickerState, byte b) {
        this.$r8$classId = b;
        this.f$0 = timePickerState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        TimePickerState timePickerState = this.f$0;
        switch (b) {
            case 0:
                if (((FocusStateImpl) obj).isFocused() && (timePickerState instanceof AnalogTimePickerState)) {
                    ((AnalogTimePickerState) timePickerState).setDialFocusable(false);
                }
                break;
            case 1:
                if (((FocusStateImpl) obj).isFocused() && (timePickerState instanceof AnalogTimePickerState)) {
                    ((AnalogTimePickerState) timePickerState).setDialFocusable(false);
                }
                break;
            case 2:
                FocusProperties focusProperties = (FocusProperties) obj;
                if (timePickerState instanceof AnalogTimePickerState) {
                    AnalogTimePickerState analogTimePickerState = (AnalogTimePickerState) timePickerState;
                    if (((Boolean) analogTimePickerState.isDialFocusable$delegate.getValue()).booleanValue()) {
                        focusProperties.setDown(analogTimePickerState.dialFocusRequester);
                    }
                }
                break;
            default:
                if (((FocusStateImpl) obj).isFocused() && (timePickerState instanceof AnalogTimePickerState)) {
                    ((AnalogTimePickerState) timePickerState).setDialFocusable(false);
                }
                break;
        }
        return unit;
    }
}
